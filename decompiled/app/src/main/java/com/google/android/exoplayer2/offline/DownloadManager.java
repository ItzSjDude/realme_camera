package com.google.android.exoplayer2.offline;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.exoplayer2.offline.DownloadAction;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class DownloadManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_MAX_SIMULTANEOUS_DOWNLOADS = 1;
    public static final int DEFAULT_MIN_RETRY_COUNT = 5;
    private static final String TAG = "DownloadManager";
    private final ActionFile actionFile;
    private final ArrayList<Task> activeDownloadTasks;
    private final DownloadAction.Deserializer[] deserializers;
    private final DownloaderConstructorHelper downloaderConstructorHelper;
    private boolean downloadsStopped;
    private final Handler fileIOHandler;
    private final HandlerThread fileIOThread;
    private final Handler handler;
    private boolean initialized;
    private final CopyOnWriteArraySet<Listener> listeners;
    private final int maxActiveDownloadTasks;
    private final int minRetryCount;
    private int nextTaskId;
    private boolean released;
    private final ArrayList<Task> tasks;

    public interface Listener {
        void onIdle(DownloadManager downloadManager);

        void onInitialized(DownloadManager downloadManager);

        void onTaskStateChanged(DownloadManager downloadManager, TaskState taskState);
    }

    private static void logd(String str) {
    }

    public DownloadManager(Cache cache, DataSource.Factory factory, File file, DownloadAction.Deserializer... deserializerArr) {
        this(new DownloaderConstructorHelper(cache, factory), file, deserializerArr);
    }

    public DownloadManager(DownloaderConstructorHelper downloaderConstructorHelper, File file, DownloadAction.Deserializer... deserializerArr) {
        this(downloaderConstructorHelper, 1, 5, file, deserializerArr);
    }

    public DownloadManager(DownloaderConstructorHelper downloaderConstructorHelper, int OplusGLSurfaceView_13, int i2, File file, DownloadAction.Deserializer... deserializerArr) {
        this.downloaderConstructorHelper = downloaderConstructorHelper;
        this.maxActiveDownloadTasks = OplusGLSurfaceView_13;
        this.minRetryCount = i2;
        this.actionFile = new ActionFile(file);
        this.deserializers = deserializerArr.length <= 0 ? DownloadAction.getDefaultDeserializers() : deserializerArr;
        this.downloadsStopped = true;
        this.tasks = new ArrayList<>();
        this.activeDownloadTasks = new ArrayList<>();
        Looper looperMyLooper = Looper.myLooper();
        this.handler = new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper);
        this.fileIOThread = new HandlerThread("DownloadManager file OplusGLSurfaceView_13/o");
        this.fileIOThread.start();
        this.fileIOHandler = new Handler(this.fileIOThread.getLooper());
        this.listeners = new CopyOnWriteArraySet<>();
        loadActions();
        logd("Created");
    }

    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    public void startDownloads() {
        Assertions.checkState(!this.released);
        if (this.downloadsStopped) {
            this.downloadsStopped = false;
            maybeStartTasks();
            logd("Downloads are started");
        }
    }

    public void stopDownloads() {
        Assertions.checkState(!this.released);
        if (this.downloadsStopped) {
            return;
        }
        this.downloadsStopped = true;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.activeDownloadTasks.size(); OplusGLSurfaceView_13++) {
            this.activeDownloadTasks.get(OplusGLSurfaceView_13).stop();
        }
        logd("Downloads are stopping");
    }

    public int handleAction(byte[] bArr) throws IOException {
        Assertions.checkState(!this.released);
        return handleAction(DownloadAction.deserializeFromStream(this.deserializers, new ByteArrayInputStream(bArr)));
    }

    public int handleAction(DownloadAction downloadAction) {
        Assertions.checkState(!this.released);
        Task taskAddTaskForAction = addTaskForAction(downloadAction);
        if (this.initialized) {
            saveActions();
            maybeStartTasks();
            if (taskAddTaskForAction.currentState == 0) {
                notifyListenersTaskStateChange(taskAddTaskForAction);
            }
        }
        return taskAddTaskForAction.f9001id;
    }

    public int getTaskCount() {
        Assertions.checkState(!this.released);
        return this.tasks.size();
    }

    public int getDownloadCount() {
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < this.tasks.size(); i2++) {
            if (!this.tasks.get(i2).action.isRemoveAction) {
                OplusGLSurfaceView_13++;
            }
        }
        return OplusGLSurfaceView_13;
    }

    public TaskState getTaskState(int OplusGLSurfaceView_13) {
        Assertions.checkState(!this.released);
        for (int i2 = 0; i2 < this.tasks.size(); i2++) {
            Task task = this.tasks.get(i2);
            if (task.f9001id == OplusGLSurfaceView_13) {
                return task.getDownloadState();
            }
        }
        return null;
    }

    public TaskState[] getAllTaskStates() {
        Assertions.checkState(!this.released);
        TaskState[] taskStateArr = new TaskState[this.tasks.size()];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < taskStateArr.length; OplusGLSurfaceView_13++) {
            taskStateArr[OplusGLSurfaceView_13] = this.tasks.get(OplusGLSurfaceView_13).getDownloadState();
        }
        return taskStateArr;
    }

    public boolean isInitialized() {
        Assertions.checkState(!this.released);
        return this.initialized;
    }

    public boolean isIdle() {
        Assertions.checkState(!this.released);
        if (!this.initialized) {
            return false;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.tasks.size(); OplusGLSurfaceView_13++) {
            if (this.tasks.get(OplusGLSurfaceView_13).isActive()) {
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
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.tasks.size(); OplusGLSurfaceView_13++) {
            this.tasks.get(OplusGLSurfaceView_13).stop();
        }
        final ConditionVariable conditionVariable = new ConditionVariable();
        Handler handler = this.fileIOHandler;
        conditionVariable.getClass();
        handler.post(new Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$xEDVsWySjOhZCU-CTVGu6ziJ2xc
            @Override // java.lang.Runnable
            public final void run() {
                conditionVariable.open();
            }
        });
        conditionVariable.block();
        this.fileIOThread.quit();
        logd("Released");
    }

    private Task addTaskForAction(DownloadAction downloadAction) {
        int OplusGLSurfaceView_13 = this.nextTaskId;
        this.nextTaskId = OplusGLSurfaceView_13 + 1;
        Task task = new Task(OplusGLSurfaceView_13, this, downloadAction, this.minRetryCount);
        this.tasks.add(task);
        logd("Task is added", task);
        return task;
    }

    private void maybeStartTasks() {
        DownloadAction downloadAction;
        boolean z;
        if (!this.initialized || this.released) {
            return;
        }
        boolean z2 = this.downloadsStopped || this.activeDownloadTasks.size() == this.maxActiveDownloadTasks;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.tasks.size(); OplusGLSurfaceView_13++) {
            Task task = this.tasks.get(OplusGLSurfaceView_13);
            if (task.canStart() && ((z = (downloadAction = task.action).isRemoveAction) || !z2)) {
                int i2 = 0;
                boolean z3 = true;
                while (true) {
                    if (i2 >= OplusGLSurfaceView_13) {
                        break;
                    }
                    Task task2 = this.tasks.get(i2);
                    if (task2.action.isSameMedia(downloadAction)) {
                        if (z) {
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
                    if (!z) {
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
            Iterator<Listener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onIdle(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTaskStateChange(Task task) {
        if (this.released) {
            return;
        }
        boolean z = !task.isActive();
        if (z) {
            this.activeDownloadTasks.remove(task);
        }
        notifyListenersTaskStateChange(task);
        if (task.isFinished()) {
            this.tasks.remove(task);
            saveActions();
        }
        if (z) {
            maybeStartTasks();
            maybeNotifyListenersIdle();
        }
    }

    private void notifyListenersTaskStateChange(Task task) {
        logd("Task state is changed", task);
        TaskState downloadState = task.getDownloadState();
        Iterator<Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onTaskStateChanged(this, downloadState);
        }
    }

    private void loadActions() {
        this.fileIOHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$DownloadManager$0LJSbWXADhROJkmo8hGQn9eqfcs
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.lambda$loadActions$1$DownloadManager();
            }
        });
    }

    public /* synthetic */ void lambda$loadActions$1$DownloadManager() {
        final DownloadAction[] downloadActionArrLoad;
        try {
            downloadActionArrLoad = this.actionFile.load(this.deserializers);
            logd("Action file is loaded.");
        } catch (Throwable th) {
            Log.m8321e(TAG, "Action file loading failed.", th);
            downloadActionArrLoad = new DownloadAction[0];
        }
        this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$DownloadManager$tqhW7d1-gBwDY6S8i1JfVeIyzSI
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.lambda$null$0$DownloadManager(downloadActionArrLoad);
            }
        });
    }

    public /* synthetic */ void lambda$null$0$DownloadManager(DownloadAction[] downloadActionArr) {
        if (this.released) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.tasks);
        this.tasks.clear();
        for (DownloadAction downloadAction : downloadActionArr) {
            addTaskForAction(downloadAction);
        }
        logd("Tasks are created.");
        this.initialized = true;
        Iterator<Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onInitialized(this);
        }
        if (!arrayList.isEmpty()) {
            this.tasks.addAll(arrayList);
            saveActions();
        }
        maybeStartTasks();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.tasks.size(); OplusGLSurfaceView_13++) {
            Task task = this.tasks.get(OplusGLSurfaceView_13);
            if (task.currentState == 0) {
                notifyListenersTaskStateChange(task);
            }
        }
    }

    private void saveActions() {
        if (this.released) {
            return;
        }
        final DownloadAction[] downloadActionArr = new DownloadAction[this.tasks.size()];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.tasks.size(); OplusGLSurfaceView_13++) {
            downloadActionArr[OplusGLSurfaceView_13] = this.tasks.get(OplusGLSurfaceView_13).action;
        }
        this.fileIOHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$DownloadManager$SgHHqKrgOJ8vvRnakgUybwmDe2w
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.COUIBaseListPopupWindow_12$0.lambda$saveActions$2$DownloadManager(downloadActionArr);
            }
        });
    }

    public /* synthetic */ void lambda$saveActions$2$DownloadManager(DownloadAction[] downloadActionArr) throws Throwable {
        try {
            this.actionFile.store(downloadActionArr);
            logd("Actions persisted.");
        } catch (IOException COUIBaseListPopupWindow_8) {
            Log.m8321e(TAG, "Persisting actions failed.", COUIBaseListPopupWindow_8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logd(String str, Task task) {
        logd(str + ": " + task);
    }

    public static final class TaskState {
        public static final int STATE_CANCELED = 3;
        public static final int STATE_COMPLETED = 2;
        public static final int STATE_FAILED = 4;
        public static final int STATE_QUEUED = 0;
        public static final int STATE_STARTED = 1;
        public final DownloadAction action;
        public final float downloadPercentage;
        public final long downloadedBytes;
        public final Throwable error;
        public final int state;
        public final int taskId;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface State {
        }

        public static String getStateString(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 0) {
                return "QUEUED";
            }
            if (OplusGLSurfaceView_13 == 1) {
                return "STARTED";
            }
            if (OplusGLSurfaceView_13 == 2) {
                return "COMPLETED";
            }
            if (OplusGLSurfaceView_13 == 3) {
                return "CANCELED";
            }
            if (OplusGLSurfaceView_13 == 4) {
                return "FAILED";
            }
            throw new IllegalStateException();
        }

        private TaskState(int OplusGLSurfaceView_13, DownloadAction downloadAction, int i2, float COUIBaseListPopupWindow_12, long OplusGLSurfaceView_15, Throwable th) {
            this.taskId = OplusGLSurfaceView_13;
            this.action = downloadAction;
            this.state = i2;
            this.downloadPercentage = COUIBaseListPopupWindow_12;
            this.downloadedBytes = OplusGLSurfaceView_15;
            this.error = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class Task implements Runnable {
        public static final int STATE_QUEUED_CANCELING = 5;
        public static final int STATE_STARTED_CANCELING = 6;
        public static final int STATE_STARTED_STOPPING = 7;
        private final DownloadAction action;
        private volatile int currentState;
        private final DownloadManager downloadManager;
        private volatile Downloader downloader;
        private Throwable error;

        /* renamed from: id_renamed */
        private final int f9001id;
        private final int minRetryCount;
        private Thread thread;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface InternalState {
        }

        private Task(int OplusGLSurfaceView_13, DownloadManager downloadManager, DownloadAction downloadAction, int i2) {
            this.f9001id = OplusGLSurfaceView_13;
            this.downloadManager = downloadManager;
            this.action = downloadAction;
            this.currentState = 0;
            this.minRetryCount = i2;
        }

        public TaskState getDownloadState() {
            return new TaskState(this.f9001id, this.action, getExternalState(), getDownloadPercentage(), getDownloadedBytes(), this.error);
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

        public String toString() {
            return super.toString();
        }

        private static String toString(byte[] bArr) {
            if (bArr.length > 100) {
                return "<data is too long>";
            }
            return '\'' + Util.fromUtf8Bytes(bArr) + '\'';
        }

        private String getStateString() {
            int OplusGLSurfaceView_13 = this.currentState;
            return (OplusGLSurfaceView_13 == 5 || OplusGLSurfaceView_13 == 6) ? "CANCELING" : OplusGLSurfaceView_13 != 7 ? TaskState.getStateString(this.currentState) : "STOPPING";
        }

        private int getExternalState() {
            int OplusGLSurfaceView_13 = this.currentState;
            if (OplusGLSurfaceView_13 == 5) {
                return 0;
            }
            if (OplusGLSurfaceView_13 == 6 || OplusGLSurfaceView_13 == 7) {
                return 1;
            }
            return this.currentState;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void start() {
            if (changeStateAndNotify(0, 1)) {
                this.thread = new Thread(this);
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
                this.downloadManager.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$DownloadManager$Task$BscZ_DsnJwLao_N7rZjz7bnzplk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.lambda$cancel$0$DownloadManager$Task();
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
                DownloadManager.logd("Stopping", this);
                cancelDownload();
            }
        }

        private boolean changeStateAndNotify(int OplusGLSurfaceView_13, int i2) {
            return changeStateAndNotify(OplusGLSurfaceView_13, i2, null);
        }

        private boolean changeStateAndNotify(int OplusGLSurfaceView_13, int i2, Throwable th) {
            if (this.currentState != OplusGLSurfaceView_13) {
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
            DownloadManager.logd("Task is started", this);
            try {
                this.downloader = this.action.createDownloader(this.downloadManager.downloaderConstructorHelper);
                if (this.action.isRemoveAction) {
                    this.downloader.remove();
                } else {
                    long OplusGLSurfaceView_15 = -1;
                    int OplusGLSurfaceView_13 = 0;
                    while (!Thread.interrupted()) {
                        try {
                            this.downloader.download();
                            break;
                        } catch (IOException COUIBaseListPopupWindow_8) {
                            long downloadedBytes = this.downloader.getDownloadedBytes();
                            if (downloadedBytes != OplusGLSurfaceView_15) {
                                DownloadManager.logd("Reset error count. downloadedBytes = " + downloadedBytes, this);
                                OplusGLSurfaceView_13 = 0;
                                OplusGLSurfaceView_15 = downloadedBytes;
                            }
                            if (this.currentState != 1 || (OplusGLSurfaceView_13 = OplusGLSurfaceView_13 + 1) > this.minRetryCount) {
                                throw COUIBaseListPopupWindow_8;
                            }
                            DownloadManager.logd("Download error. Retry " + OplusGLSurfaceView_13, this);
                            Thread.sleep((long) getRetryDelayMillis(OplusGLSurfaceView_13));
                        }
                    }
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            this.downloadManager.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$DownloadManager$Task$tMCSa8vI5Qy5JY5aoxlLoYvc2xQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.lambda$run$1$DownloadManager$Task(th);
                }
            });
        }

        public /* synthetic */ void lambda$run$1$DownloadManager$Task(Throwable th) {
            if (!changeStateAndNotify(1, th != null ? 4 : 2, th) && !changeStateAndNotify(6, 3) && !changeStateAndNotify(7, 0)) {
                throw new IllegalStateException();
            }
        }

        private int getRetryDelayMillis(int OplusGLSurfaceView_13) {
            return Math.min((OplusGLSurfaceView_13 - 1) * 1000, 5000);
        }
    }
}
