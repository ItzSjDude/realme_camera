package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public abstract class DownloadService extends android.app.Service {
    public static final java.lang.String ACTION_ADD = "com.google.android.exoplayer.downloadService.action.ADD";
    public static final java.lang.String ACTION_INIT = "com.google.android.exoplayer.downloadService.action.INIT";
    public static final java.lang.String ACTION_RELOAD_REQUIREMENTS = "com.google.android.exoplayer.downloadService.action.RELOAD_REQUIREMENTS";
    private static final java.lang.String ACTION_RESTART = "com.google.android.exoplayer.downloadService.action.RESTART";
    private static final boolean DEBUG = false;
    public static final long DEFAULT_FOREGROUND_NOTIFICATION_UPDATE_INTERVAL = 1000;
    public static final int FOREGROUND_NOTIFICATION_ID_NONE = 0;
    public static final java.lang.String KEY_DOWNLOAD_ACTION = "download_action";
    public static final java.lang.String KEY_FOREGROUND = "foreground";
    private static final java.lang.String TAG = "DownloadService";
    private final java.lang.String channelId;
    private final int channelName;
    private com.google.android.exoplayer2.offline.DownloadManager downloadManager;
    private com.google.android.exoplayer2.offline.DownloadService.DownloadManagerListener downloadManagerListener;
    private final com.google.android.exoplayer2.offline.DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater;
    private int lastStartId;
    private boolean startedInForeground;
    private boolean taskRemoved;
    private static final java.util.HashMap<java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService>, com.google.android.exoplayer2.offline.DownloadService.RequirementsHelper> requirementsHelpers = new java.util.HashMap<>();
    private static final com.google.android.exoplayer2.scheduler.Requirements DEFAULT_REQUIREMENTS = new com.google.android.exoplayer2.scheduler.Requirements(1, false, false);

    private void logd(java.lang.String str) {
    }

    protected abstract com.google.android.exoplayer2.offline.DownloadManager getDownloadManager();

    protected abstract com.google.android.exoplayer2.scheduler.Scheduler getScheduler();

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return null;
    }

    protected void onTaskStateChanged(com.google.android.exoplayer2.offline.DownloadManager.TaskState taskState) {
    }

    protected DownloadService(int i_renamed) {
        this(i_renamed, 1000L);
    }

    protected DownloadService(int i_renamed, long j_renamed) {
        this(i_renamed, j_renamed, null, 0);
    }

    protected DownloadService(int i_renamed, long j_renamed, java.lang.String str, int i2) {
        this.foregroundNotificationUpdater = i_renamed == 0 ? null : new com.google.android.exoplayer2.offline.DownloadService.ForegroundNotificationUpdater(i_renamed, j_renamed);
        this.channelId = str;
        this.channelName = i2;
    }

    public static android.content.Intent buildAddActionIntent(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, com.google.android.exoplayer2.offline.DownloadAction downloadAction, boolean z_renamed) {
        return getIntent(context, cls, ACTION_ADD).putExtra(KEY_DOWNLOAD_ACTION, downloadAction.toByteArray()).putExtra(KEY_FOREGROUND, z_renamed);
    }

    public static void startWithAction(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, com.google.android.exoplayer2.offline.DownloadAction downloadAction, boolean z_renamed) {
        android.content.Intent intentBuildAddActionIntent = buildAddActionIntent(context, cls, downloadAction, z_renamed);
        if (z_renamed) {
            com.google.android.exoplayer2.util.Util.startForegroundService(context, intentBuildAddActionIntent);
        } else {
            context.startService(intentBuildAddActionIntent);
        }
    }

    public static void start(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls) {
        context.startService(getIntent(context, cls, ACTION_INIT));
    }

    public static void startForeground(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls) {
        com.google.android.exoplayer2.util.Util.startForegroundService(context, getIntent(context, cls, ACTION_INIT).putExtra(KEY_FOREGROUND, true));
    }

    @Override // android.app.Service
    public void onCreate() {
        logd("onCreate");
        java.lang.String str = this.channelId;
        if (str != null) {
            com.google.android.exoplayer2.util.NotificationUtil.createNotificationChannel(this, str, this.channelName, 2);
        }
        this.downloadManager = getDownloadManager();
        this.downloadManagerListener = new com.google.android.exoplayer2.offline.DownloadService.DownloadManagerListener();
        this.downloadManager.addListener(this.downloadManagerListener);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:31:0x0076  */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int onStartCommand(android.content.Intent r8, int r9, int r10) {
        /*
            r7 = this;
            r7.lastStartId = r10
            r9 = 0
            r7.taskRemoved = r9
            java.lang.String r0 = "com.google.android.exoplayer.downloadService.action.RESTART"
            r1 = 1
            if (r8 == 0) goto L26
            java.lang.String r2 = r8.getAction()
            boolean r3 = r7.startedInForeground
            java.lang.String r4 = "foreground"
            boolean r4 = r8.getBooleanExtra(r4, r9)
            if (r4 != 0) goto L21
            boolean r4 = r0.equals(r2)
            if (r4 == 0) goto L1f
            goto L21
        L1f:
            r4 = r9
            goto L22
        L21:
            r4 = r1
        L22:
            r3 = r3 | r4
            r7.startedInForeground = r3
            goto L27
        L26:
            r2 = 0
        L27:
            java.lang.String r3 = "com.google.android.exoplayer.downloadService.action.INIT"
            if (r2 != 0) goto L2c
            r2 = r3
        L2c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "onStartCommand action: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = " startId: "
            r4.append(r5)
            r4.append(r10)
            java.lang.String r10 = r4.toString()
            r7.logd(r10)
            r10 = -1
            int r4 = r2.hashCode()
            r5 = 3
            r6 = 2
            switch(r4) {
                case -871181424: goto L6e;
                case -608867945: goto L64;
                case -382886238: goto L5a;
                case 1015676687: goto L53;
                default: goto L52;
            }
        L52:
            goto L76
        L53:
            boolean r0 = r2.equals(r3)
            if (r0 == 0) goto L76
            goto L77
        L5a:
            java.lang.String r9 = "com.google.android.exoplayer.downloadService.action.ADD"
            boolean r9 = r2.equals(r9)
            if (r9 == 0) goto L76
            r9 = r6
            goto L77
        L64:
            java.lang.String r9 = "com.google.android.exoplayer.downloadService.action.RELOAD_REQUIREMENTS"
            boolean r9 = r2.equals(r9)
            if (r9 == 0) goto L76
            r9 = r5
            goto L77
        L6e:
            boolean r9 = r2.equals(r0)
            if (r9 == 0) goto L76
            r9 = r1
            goto L77
        L76:
            r9 = r10
        L77:
            if (r9 == 0) goto Lb4
            if (r9 == r1) goto Lb4
            java.lang.String r10 = "DownloadService"
            if (r9 == r6) goto L9a
            if (r9 == r5) goto L96
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Ignoring unrecognized action: "
            r8.append(r9)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            com.google.android.exoplayer2.util.Log.e_renamed(r10, r8)
            goto Lb4
        L96:
            r7.stopWatchingRequirements()
            goto Lb4
        L9a:
            java.lang.String r9 = "download_action"
            byte[] r8 = r8.getByteArrayExtra(r9)
            if (r8 != 0) goto La8
            java.lang.String r8 = "Ignoring ADD action with no action data"
            com.google.android.exoplayer2.util.Log.e_renamed(r10, r8)
            goto Lb4
        La8:
            com.google.android.exoplayer2.offline.DownloadManager r9 = r7.downloadManager     // Catch: java.io.IOException -> Lae
            r9.handleAction(r8)     // Catch: java.io.IOException -> Lae
            goto Lb4
        Lae:
            r8 = move-exception
            java.lang.String r9 = "Failed to handle ADD action"
            com.google.android.exoplayer2.util.Log.e_renamed(r10, r9, r8)
        Lb4:
            com.google.android.exoplayer2.scheduler.Requirements r8 = r7.getRequirements()
            boolean r9 = r8.checkRequirements(r7)
            if (r9 == 0) goto Lc4
            com.google.android.exoplayer2.offline.DownloadManager r9 = r7.downloadManager
            r9.startDownloads()
            goto Lc9
        Lc4:
            com.google.android.exoplayer2.offline.DownloadManager r9 = r7.downloadManager
            r9.stopDownloads()
        Lc9:
            r7.maybeStartWatchingRequirements(r8)
            com.google.android.exoplayer2.offline.DownloadManager r8 = r7.downloadManager
            boolean r8 = r8.isIdle()
            if (r8 == 0) goto Ld7
            r7.stop()
        Ld7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.DownloadService.onStartCommand(android.content.Intent, int, int):int");
    }

    @Override // android.app.Service
    public void onTaskRemoved(android.content.Intent intent) {
        logd("onTaskRemoved rootIntent: " + intent);
        this.taskRemoved = true;
    }

    @Override // android.app.Service
    public void onDestroy() {
        logd("onDestroy");
        com.google.android.exoplayer2.offline.DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater != null) {
            foregroundNotificationUpdater.stopPeriodicUpdates();
        }
        this.downloadManager.removeListener(this.downloadManagerListener);
        maybeStopWatchingRequirements();
    }

    protected com.google.android.exoplayer2.scheduler.Requirements getRequirements() {
        return DEFAULT_REQUIREMENTS;
    }

    protected android.app.Notification getForegroundNotification(com.google.android.exoplayer2.offline.DownloadManager.TaskState[] taskStateArr) {
        throw new java.lang.IllegalStateException(getClass().getName() + " is_renamed started in_renamed the foreground but getForegroundNotification() is_renamed not implemented.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void maybeStartWatchingRequirements(com.google.android.exoplayer2.scheduler.Requirements requirements) {
        if (this.downloadManager.getDownloadCount() == 0) {
            return;
        }
        java.lang.Class<?> cls = getClass();
        if (requirementsHelpers.get(cls) == null) {
            com.google.android.exoplayer2.offline.DownloadService.RequirementsHelper requirementsHelper = new com.google.android.exoplayer2.offline.DownloadService.RequirementsHelper(this, requirements, getScheduler(), cls);
            requirementsHelpers.put(cls, requirementsHelper);
            requirementsHelper.start();
            logd("started watching requirements");
        }
    }

    private void maybeStopWatchingRequirements() {
        if (this.downloadManager.getDownloadCount() > 0) {
            return;
        }
        stopWatchingRequirements();
    }

    private void stopWatchingRequirements() {
        com.google.android.exoplayer2.offline.DownloadService.RequirementsHelper requirementsHelperRemove = requirementsHelpers.remove(getClass());
        if (requirementsHelperRemove != null) {
            requirementsHelperRemove.stop();
            logd("stopped watching requirements");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        com.google.android.exoplayer2.offline.DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater != null) {
            foregroundNotificationUpdater.stopPeriodicUpdates();
            if (this.startedInForeground && com.google.android.exoplayer2.util.Util.SDK_INT >= 26) {
                this.foregroundNotificationUpdater.showNotificationIfNotAlready();
            }
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 28 && this.taskRemoved) {
            stopSelf();
            logd("stopSelf()");
            return;
        }
        logd("stopSelf(" + this.lastStartId + ") result: " + stopSelfResult(this.lastStartId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static android.content.Intent getIntent(android.content.Context context, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls, java.lang.String str) {
        return new android.content.Intent(context, cls).setAction(str);
    }

    private final class DownloadManagerListener implements com.google.android.exoplayer2.offline.DownloadManager.Listener {
        private DownloadManagerListener() {
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void onInitialized(com.google.android.exoplayer2.offline.DownloadManager downloadManager) {
            com.google.android.exoplayer2.offline.DownloadService downloadService = com.google.android.exoplayer2.offline.DownloadService.this;
            downloadService.maybeStartWatchingRequirements(downloadService.getRequirements());
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void onTaskStateChanged(com.google.android.exoplayer2.offline.DownloadManager downloadManager, com.google.android.exoplayer2.offline.DownloadManager.TaskState taskState) {
            com.google.android.exoplayer2.offline.DownloadService.this.onTaskStateChanged(taskState);
            if (com.google.android.exoplayer2.offline.DownloadService.this.foregroundNotificationUpdater != null) {
                if (taskState.state == 1) {
                    com.google.android.exoplayer2.offline.DownloadService.this.foregroundNotificationUpdater.startPeriodicUpdates();
                } else {
                    com.google.android.exoplayer2.offline.DownloadService.this.foregroundNotificationUpdater.update();
                }
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public final void onIdle(com.google.android.exoplayer2.offline.DownloadManager downloadManager) {
            com.google.android.exoplayer2.offline.DownloadService.this.stop();
        }
    }

    private final class ForegroundNotificationUpdater implements java.lang.Runnable {
        private final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
        private boolean notificationDisplayed;
        private final int notificationId;
        private boolean periodicUpdatesStarted;
        private final long updateInterval;

        public ForegroundNotificationUpdater(int i_renamed, long j_renamed) {
            this.notificationId = i_renamed;
            this.updateInterval = j_renamed;
        }

        public void startPeriodicUpdates() {
            this.periodicUpdatesStarted = true;
            update();
        }

        public void stopPeriodicUpdates() {
            this.periodicUpdatesStarted = false;
            this.handler.removeCallbacks(this);
        }

        public void update() {
            com.google.android.exoplayer2.offline.DownloadManager.TaskState[] allTaskStates = com.google.android.exoplayer2.offline.DownloadService.this.downloadManager.getAllTaskStates();
            com.google.android.exoplayer2.offline.DownloadService downloadService = com.google.android.exoplayer2.offline.DownloadService.this;
            downloadService.startForeground(this.notificationId, downloadService.getForegroundNotification(allTaskStates));
            this.notificationDisplayed = true;
            if (this.periodicUpdatesStarted) {
                this.handler.removeCallbacks(this);
                this.handler.postDelayed(this, this.updateInterval);
            }
        }

        public void showNotificationIfNotAlready() {
            if (this.notificationDisplayed) {
                return;
            }
            update();
        }

        @Override // java.lang.Runnable
        public void run() {
            update();
        }
    }

    private static final class RequirementsHelper implements com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener {
        private final android.content.Context context;
        private final com.google.android.exoplayer2.scheduler.Requirements requirements;
        private final com.google.android.exoplayer2.scheduler.RequirementsWatcher requirementsWatcher;
        private final com.google.android.exoplayer2.scheduler.Scheduler scheduler;
        private final java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> serviceClass;

        private RequirementsHelper(android.content.Context context, com.google.android.exoplayer2.scheduler.Requirements requirements, com.google.android.exoplayer2.scheduler.Scheduler scheduler, java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService> cls) {
            this.context = context;
            this.requirements = requirements;
            this.scheduler = scheduler;
            this.serviceClass = cls;
            this.requirementsWatcher = new com.google.android.exoplayer2.scheduler.RequirementsWatcher(context, this, requirements);
        }

        public void start() {
            this.requirementsWatcher.start();
        }

        public void stop() {
            this.requirementsWatcher.stop();
            com.google.android.exoplayer2.scheduler.Scheduler scheduler = this.scheduler;
            if (scheduler != null) {
                scheduler.cancel();
            }
        }

        @Override // com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener
        public void requirementsMet(com.google.android.exoplayer2.scheduler.RequirementsWatcher requirementsWatcher) {
            try {
                notifyService();
                com.google.android.exoplayer2.scheduler.Scheduler scheduler = this.scheduler;
                if (scheduler != null) {
                    scheduler.cancel();
                }
            } catch (java.lang.Exception unused) {
            }
        }

        @Override // com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener
        public void requirementsNotMet(com.google.android.exoplayer2.scheduler.RequirementsWatcher requirementsWatcher) {
            try {
                notifyService();
            } catch (java.lang.Exception unused) {
            }
            if (this.scheduler != null) {
                if (this.scheduler.schedule(this.requirements, this.context.getPackageName(), com.google.android.exoplayer2.offline.DownloadService.ACTION_RESTART)) {
                    return;
                }
                com.google.android.exoplayer2.util.Log.e_renamed(com.google.android.exoplayer2.offline.DownloadService.TAG, "Scheduling downloads failed.");
            }
        }

        private void notifyService() throws java.lang.Exception {
            try {
                this.context.startService(com.google.android.exoplayer2.offline.DownloadService.getIntent(this.context, this.serviceClass, com.google.android.exoplayer2.offline.DownloadService.ACTION_INIT));
            } catch (java.lang.IllegalStateException e_renamed) {
                throw new java.lang.Exception(e_renamed);
            }
        }
    }
}
