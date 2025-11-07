package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public final class DownloadManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_MAX_SIMULTANEOUS_DOWNLOADS = 1;
    public static final int DEFAULT_MIN_RETRY_COUNT = 5;
    private static final java.lang.String TAG = "DownloadManager";
    private final com.google.android.exoplayer2.offline.ActionFile actionFile;
    private final java.util.ArrayList<com.google.android.exoplayer2.offline.DownloadManager.Task> activeDownloadTasks;
    private final com.google.android.exoplayer2.offline.DownloadAction.Deserializer[] deserializers;
    private final com.google.android.exoplayer2.offline.DownloaderConstructorHelper downloaderConstructorHelper;
    private boolean downloadsStopped;
    private final android.os.Handler fileIOHandler;
    private final android.os.HandlerThread fileIOThread;
    private final android.os.Handler handler;
    private boolean initialized;
    private final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.offline.DownloadManager.Listener> listeners;
    private final int maxActiveDownloadTasks;
    private final int minRetryCount;
    private int nextTaskId;
    private boolean released;
    private final java.util.ArrayList<com.google.android.exoplayer2.offline.DownloadManager.Task> tasks;

    public interface Listener {
        void onIdle(com.google.android.exoplayer2.offline.DownloadManager downloadManager);

        void onInitialized(com.google.android.exoplayer2.offline.DownloadManager downloadManager);

        void onTaskStateChanged(com.google.android.exoplayer2.offline.DownloadManager downloadManager, com.google.android.exoplayer2.offline.DownloadManager.TaskState taskState);
    }

    private static void logd(java.lang.String str) {
    }

    public DownloadManager(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.DataSource.Factory factory, java.io.File file, com.google.android.exoplayer2.offline.DownloadAction.Deserializer... deserializerArr) {
        this(new com.google.android.exoplayer2.offline.DownloaderConstructorHelper(cache, factory), file, deserializerArr);
    }

    public DownloadManager(com.google.android.exoplayer2.offline.DownloaderConstructorHelper downloaderConstructorHelper, java.io.File file, com.google.android.exoplayer2.offline.DownloadAction.Deserializer... deserializerArr) {
        this(downloaderConstructorHelper, 1, 5, file, deserializerArr);
    }

    public DownloadManager(com.google.android.exoplayer2.offline.DownloaderConstructorHelper downloaderConstructorHelper, int i_renamed, int i2, java.io.File file, com.google.android.exoplayer2.offline.DownloadAction.Deserializer... deserializerArr) {
        this.downloaderConstructorHelper = downloaderConstructorHelper;
        this.maxActiveDownloadTasks = i_renamed;
        this.minRetryCount = i2;
        this.actionFile = new com.google.android.exoplayer2.offline.ActionFile(file);
        this.deserializers = deserializerArr.length <= 0 ? com.google.android.exoplayer2.offline.DownloadAction.getDefaultDeserializers() : deserializerArr;
        this.downloadsStopped = true;
        this.tasks = new java.util.ArrayList<>();
        this.activeDownloadTasks = new java.util.ArrayList<>();
        android.os.Looper looperMyLooper = android.os.Looper.myLooper();
        this.handler = new android.os.Handler(looperMyLooper == null ? android.os.Looper.getMainLooper() : looperMyLooper);
        this.fileIOThread = new android.os.HandlerThread("DownloadManager file i_renamed/o_renamed");
        this.fileIOThread.start();
        this.fileIOHandler = new android.os.Handler(this.fileIOThread.getLooper());
        this.listeners = new java.util.concurrent.CopyOnWriteArraySet<>();
        loadActions();
        logd("Created");
    }

    public void addListener(com.google.android.exoplayer2.offline.DownloadManager.Listener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(com.google.android.exoplayer2.offline.DownloadManager.Listener listener) {
        this.listeners.remove(listener);
    }

    public void startDownloads() {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        if (this.downloadsStopped) {
            this.downloadsStopped = false;
            maybeStartTasks();
            logd("Downloads are started");
        }
    }

    public void stopDownloads() {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        if (this.downloadsStopped) {
            return;
        }
        this.downloadsStopped = true;
        for (int i_renamed = 0; i_renamed < this.activeDownloadTasks.size(); i_renamed++) {
            this.activeDownloadTasks.get(i_renamed).stop();
        }
        logd("Downloads are stopping");
    }

    public int handleAction(byte[] bArr) throws java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        return handleAction(com.google.android.exoplayer2.offline.DownloadAction.deserializeFromStream(this.deserializers, new java.io.ByteArrayInputStream(bArr)));
    }

    public int handleAction(com.google.android.exoplayer2.offline.DownloadAction downloadAction) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        com.google.android.exoplayer2.offline.DownloadManager.Task taskAddTaskForAction = addTaskForAction(downloadAction);
        if (this.initialized) {
            saveActions();
            maybeStartTasks();
            if (taskAddTaskForAction.currentState == 0) {
                notifyListenersTaskStateChange(taskAddTaskForAction);
            }
        }
        return taskAddTaskForAction.id_renamed;
    }

    public int getTaskCount() {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        return this.tasks.size();
    }

    public int getDownloadCount() {
        int i_renamed = 0;
        for (int i2 = 0; i2 < this.tasks.size(); i2++) {
            if (!this.tasks.get(i2).action.isRemoveAction) {
                i_renamed++;
            }
        }
        return i_renamed;
    }

    public com.google.android.exoplayer2.offline.DownloadManager.TaskState getTaskState(int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        for (int i2 = 0; i2 < this.tasks.size(); i2++) {
            com.google.android.exoplayer2.offline.DownloadManager.Task task = this.tasks.get(i2);
            if (task.id_renamed == i_renamed) {
                return task.getDownloadState();
            }
        }
        return null;
    }

    public com.google.android.exoplayer2.offline.DownloadManager.TaskState[] getAllTaskStates() {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        com.google.android.exoplayer2.offline.DownloadManager.TaskState[] taskStateArr = new com.google.android.exoplayer2.offline.DownloadManager.TaskState[this.tasks.size()];
        for (int i_renamed = 0; i_renamed < taskStateArr.length; i_renamed++) {
            taskStateArr[i_renamed] = this.tasks.get(i_renamed).getDownloadState();
        }
        return taskStateArr;
    }

    public boolean isInitialized() {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        return this.initialized;
    }

    public boolean isIdle() {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        if (!this.initialized) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < this.tasks.size(); i_renamed++) {
            if (this.tasks.get(i_renamed).isActive()) {
                return false;
            }
        }
        return true;
    }

    public void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        for (int i_renamed = 0; i_renamed < this.tasks.size(); i_renamed++) {
            this.tasks.get(i_renamed).stop();
        }
        final android.os.ConditionVariable conditionVariable = new android.os.ConditionVariable();
        android.os.Handler handler = this.fileIOHandler;
        conditionVariable.getClass();
        handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$xEDVsWySjOhZCU-CTVGu6ziJ2xc
            @Override // java.lang.Runnable
            public final void run() {
                conditionVariable.open();
            }
        });
        conditionVariable.block();
        this.fileIOThread.quit();
        logd("Released");
    }

    private com.google.android.exoplayer2.offline.DownloadManager.Task addTaskForAction(com.google.android.exoplayer2.offline.DownloadAction downloadAction) {
        int i_renamed = this.nextTaskId;
        this.nextTaskId = i_renamed + 1;
        com.google.android.exoplayer2.offline.DownloadManager.Task task = new com.google.android.exoplayer2.offline.DownloadManager.Task(i_renamed, this, downloadAction, this.minRetryCount);
        this.tasks.add(task);
        logd("Task is_renamed added", task);
        return task;
    }

    private void maybeStartTasks() {
        com.google.android.exoplayer2.offline.DownloadAction downloadAction;
        boolean z_renamed;
        if (!this.initialized || this.released) {
            return;
        }
        boolean z2 = this.downloadsStopped || this.activeDownloadTasks.size() == this.maxActiveDownloadTasks;
        for (int i_renamed = 0; i_renamed < this.tasks.size(); i_renamed++) {
            com.google.android.exoplayer2.offline.DownloadManager.Task task = this.tasks.get(i_renamed);
            if (task.canStart() && ((z_renamed = (downloadAction = task.action).isRemoveAction) || !z2)) {
                int i2 = 0;
                boolean z3 = true;
                while (true) {
                    if (i2 >= i_renamed) {
                        break;
                    }
                    com.google.android.exoplayer2.offline.DownloadManager.Task task2 = this.tasks.get(i2);
                    if (task2.action.isSameMedia(downloadAction)) {
                        if (z_renamed) {
                            logd(task + " clashes with " + task2);
                            task2.cancel();
                            z3 = false;
                        } else if (task2.action.isRemoveAction) {
                            z3 = false;
                            z2 = true;
                            break;
                        }
                    }
                    i2++;
                }
                if (z3) {
                    task.start();
                    if (!z_renamed) {
                        this.activeDownloadTasks.add(task);
                        z2 = this.activeDownloadTasks.size() == this.maxActiveDownloadTasks;
                    }
                }
            }
        }
    }

    private void maybeNotifyListenersIdle() {
        if (isIdle()) {
            logd("Notify idle state");
            java.util.Iterator<com.google.android.exoplayer2.offline.DownloadManager.Listener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onIdle(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTaskStateChange(com.google.android.exoplayer2.offline.DownloadManager.Task task) {
        if (this.released) {
            return;
        }
        boolean z_renamed = !task.isActive();
        if (z_renamed) {
            this.activeDownloadTasks.remove(task);
        }
        notifyListenersTaskStateChange(task);
        if (task.isFinished()) {
            this.tasks.remove(task);
            saveActions();
        }
        if (z_renamed) {
            maybeStartTasks();
            maybeNotifyListenersIdle();
        }
    }

    private void notifyListenersTaskStateChange(com.google.android.exoplayer2.offline.DownloadManager.Task task) {
        logd("Task state is_renamed changed", task);
        com.google.android.exoplayer2.offline.DownloadManager.TaskState downloadState = task.getDownloadState();
        java.util.Iterator<com.google.android.exoplayer2.offline.DownloadManager.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onTaskStateChanged(this, downloadState);
        }
    }

    private void loadActions() {
        this.fileIOHandler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$DownloadManager$0LJSbWXADhROJkmo8hGQn9eqfcs
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.lambda$loadActions$1$DownloadManager();
            }
        });
    }

    public /* synthetic */ void lambda$loadActions$1$DownloadManager() {
        final com.google.android.exoplayer2.offline.DownloadAction[] downloadActionArrLoad;
        try {
            downloadActionArrLoad = this.actionFile.load(this.deserializers);
            logd("Action file is_renamed loaded.");
        } catch (java.lang.Throwable th) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Action file loading failed.", th);
            downloadActionArrLoad = new com.google.android.exoplayer2.offline.DownloadAction[0];
        }
        this.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$DownloadManager$tqhW7d1-gBwDY6S8i1JfVeIyzSI
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.lambda$null$0$DownloadManager(downloadActionArrLoad);
            }
        });
    }

    public /* synthetic */ void lambda$null$0$DownloadManager(com.google.android.exoplayer2.offline.DownloadAction[] downloadActionArr) {
        if (this.released) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.tasks);
        this.tasks.clear();
        for (com.google.android.exoplayer2.offline.DownloadAction downloadAction : downloadActionArr) {
            addTaskForAction(downloadAction);
        }
        logd("Tasks are created.");
        this.initialized = true;
        java.util.Iterator<com.google.android.exoplayer2.offline.DownloadManager.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onInitialized(this);
        }
        if (!arrayList.isEmpty()) {
            this.tasks.addAll(arrayList);
            saveActions();
        }
        maybeStartTasks();
        for (int i_renamed = 0; i_renamed < this.tasks.size(); i_renamed++) {
            com.google.android.exoplayer2.offline.DownloadManager.Task task = this.tasks.get(i_renamed);
            if (task.currentState == 0) {
                notifyListenersTaskStateChange(task);
            }
        }
    }

    private void saveActions() {
        if (this.released) {
            return;
        }
        final com.google.android.exoplayer2.offline.DownloadAction[] downloadActionArr = new com.google.android.exoplayer2.offline.DownloadAction[this.tasks.size()];
        for (int i_renamed = 0; i_renamed < this.tasks.size(); i_renamed++) {
            downloadActionArr[i_renamed] = this.tasks.get(i_renamed).action;
        }
        this.fileIOHandler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$DownloadManager$SgHHqKrgOJ8vvRnakgUybwmDe2w
            @Override // java.lang.Runnable
            public final void run() throws java.lang.Throwable {
                this.f_renamed$0.lambda$saveActions$2$DownloadManager(downloadActionArr);
            }
        });
    }

    public /* synthetic */ void lambda$saveActions$2$DownloadManager(com.google.android.exoplayer2.offline.DownloadAction[] downloadActionArr) throws java.lang.Throwable {
        try {
            this.actionFile.store(downloadActionArr);
            logd("Actions persisted.");
        } catch (java.io.IOException e_renamed) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Persisting actions failed.", e_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logd(java.lang.String str, com.google.android.exoplayer2.offline.DownloadManager.Task task) {
        logd(str + ": " + task);
    }

    public static final class TaskState {
        public static final int STATE_CANCELED = 3;
        public static final int STATE_COMPLETED = 2;
        public static final int STATE_FAILED = 4;
        public static final int STATE_QUEUED = 0;
        public static final int STATE_STARTED = 1;
        public final com.google.android.exoplayer2.offline.DownloadAction action;
        public final float downloadPercentage;
        public final long downloadedBytes;
        public final java.lang.Throwable error;
        public final int state;
        public final int taskId;

        @java.lang.annotation.Documented
        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface State {
        }

        public static java.lang.String getStateString(int i_renamed) {
            if (i_renamed == 0) {
                return "QUEUED";
            }
            if (i_renamed == 1) {
                return "STARTED";
            }
            if (i_renamed == 2) {
                return "COMPLETED";
            }
            if (i_renamed == 3) {
                return "CANCELED";
            }
            if (i_renamed == 4) {
                return "FAILED";
            }
            throw new java.lang.IllegalStateException();
        }

        private TaskState(int i_renamed, com.google.android.exoplayer2.offline.DownloadAction downloadAction, int i2, float f_renamed, long j_renamed, java.lang.Throwable th) {
            this.taskId = i_renamed;
            this.action = downloadAction;
            this.state = i2;
            this.downloadPercentage = f_renamed;
            this.downloadedBytes = j_renamed;
            this.error = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class Task implements java.lang.Runnable {
        public static final int STATE_QUEUED_CANCELING = 5;
        public static final int STATE_STARTED_CANCELING = 6;
        public static final int STATE_STARTED_STOPPING = 7;
        private final com.google.android.exoplayer2.offline.DownloadAction action;
        private volatile int currentState;
        private final com.google.android.exoplayer2.offline.DownloadManager downloadManager;
        private volatile com.google.android.exoplayer2.offline.Downloader downloader;
        private java.lang.Throwable error;
        private final int id_renamed;
        private final int minRetryCount;
        private java.lang.Thread thread;

        @java.lang.annotation.Documented
        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface InternalState {
        }

        private Task(int i_renamed, com.google.android.exoplayer2.offline.DownloadManager downloadManager, com.google.android.exoplayer2.offline.DownloadAction downloadAction, int i2) {
            this.id_renamed = i_renamed;
            this.downloadManager = downloadManager;
            this.action = downloadAction;
            this.currentState = 0;
            this.minRetryCount = i2;
        }

        public com.google.android.exoplayer2.offline.DownloadManager.TaskState getDownloadState() {
            return new com.google.android.exoplayer2.offline.DownloadManager.TaskState(this.id_renamed, this.action, getExternalState(), getDownloadPercentage(), getDownloadedBytes(), this.error);
        }

        public boolean isFinished() {
            return this.currentState == 4 || this.currentState == 2 || this.currentState == 3;
        }

        public boolean isActive() {
            return this.currentState == 5 || this.currentState == 1 || this.currentState == 7 || this.currentState == 6;
        }

        public float getDownloadPercentage() {
            if (this.downloader != null) {
                return this.downloader.getDownloadPercentage();
            }
            return -1.0f;
        }

        public long getDownloadedBytes() {
            if (this.downloader != null) {
                return this.downloader.getDownloadedBytes();
            }
            return 0L;
        }

        public java.lang.String toString() {
            return super.toString();
        }

        private static java.lang.String toString(byte[] bArr) {
            if (bArr.length > 100) {
                return "<data is_renamed too long>";
            }
            return '\'' + com.google.android.exoplayer2.util.Util.fromUtf8Bytes(bArr) + '\'';
        }

        private java.lang.String getStateString() {
            int i_renamed = this.currentState;
            return (i_renamed == 5 || i_renamed == 6) ? "CANCELING" : i_renamed != 7 ? com.google.android.exoplayer2.offline.DownloadManager.TaskState.getStateString(this.currentState) : "STOPPING";
        }

        private int getExternalState() {
            int i_renamed = this.currentState;
            if (i_renamed == 5) {
                return 0;
            }
            if (i_renamed == 6 || i_renamed == 7) {
                return 1;
            }
            return this.currentState;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void start() {
            if (changeStateAndNotify(0, 1)) {
                this.thread = new java.lang.Thread(this);
                this.thread.start();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean canStart() {
            return this.currentState == 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cancel() {
            if (changeStateAndNotify(0, 5)) {
                this.downloadManager.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$DownloadManager$Task$BscZ_DsnJwLao_N7rZjz7bnzplk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$cancel$0$DownloadManager$Task();
                    }
                });
            } else if (changeStateAndNotify(1, 6)) {
                cancelDownload();
            }
        }

        public /* synthetic */ void lambda$cancel$0$DownloadManager$Task() {
            changeStateAndNotify(5, 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop() {
            if (changeStateAndNotify(1, 7)) {
                com.google.android.exoplayer2.offline.DownloadManager.logd("Stopping", this);
                cancelDownload();
            }
        }

        private boolean changeStateAndNotify(int i_renamed, int i2) {
            return changeStateAndNotify(i_renamed, i2, null);
        }

        private boolean changeStateAndNotify(int i_renamed, int i2, java.lang.Throwable th) {
            if (this.currentState != i_renamed) {
                return false;
            }
            this.currentState = i2;
            this.error = th;
            if (!(this.currentState != getExternalState())) {
                this.downloadManager.onTaskStateChange(this);
            }
            return true;
        }

        private void cancelDownload() {
            if (this.downloader != null) {
                this.downloader.cancel();
            }
            this.thread.interrupt();
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.exoplayer2.offline.DownloadManager.logd("Task is_renamed started", this);
            try {
                this.downloader = this.action.createDownloader(this.downloadManager.downloaderConstructorHelper);
                if (this.action.isRemoveAction) {
                    this.downloader.remove();
                } else {
                    long j_renamed = -1;
                    int i_renamed = 0;
                    while (!java.lang.Thread.interrupted()) {
                        try {
                            this.downloader.download();
                            break;
                        } catch (java.io.IOException e_renamed) {
                            long downloadedBytes = this.downloader.getDownloadedBytes();
                            if (downloadedBytes != j_renamed) {
                                com.google.android.exoplayer2.offline.DownloadManager.logd("Reset error count. downloadedBytes = " + downloadedBytes, this);
                                i_renamed = 0;
                                j_renamed = downloadedBytes;
                            }
                            if (this.currentState != 1 || (i_renamed = i_renamed + 1) > this.minRetryCount) {
                                throw e_renamed;
                            }
                            com.google.android.exoplayer2.offline.DownloadManager.logd("Download error. Retry " + i_renamed, this);
                            java.lang.Thread.sleep((long) getRetryDelayMillis(i_renamed));
                        }
                    }
                }
                th = null;
            } catch (java.lang.Throwable th) {
                th = th;
            }
            this.downloadManager.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$DownloadManager$Task$tMCSa8vI5Qy5JY5aoxlLoYvc2xQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.lambda$run$1$DownloadManager$Task(th);
                }
            });
        }

        public /* synthetic */ void lambda$run$1$DownloadManager$Task(java.lang.Throwable th) {
            if (!changeStateAndNotify(1, th != null ? 4 : 2, th) && !changeStateAndNotify(6, 3) && !changeStateAndNotify(7, 0)) {
                throw new java.lang.IllegalStateException();
            }
        }

        private int getRetryDelayMillis(int i_renamed) {
            return java.lang.Math.min((i_renamed - 1) * 1000, 5000);
        }
    }
}
