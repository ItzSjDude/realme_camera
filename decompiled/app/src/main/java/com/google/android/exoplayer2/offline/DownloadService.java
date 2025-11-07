package com.google.android.exoplayer2.offline;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class DownloadService extends Service {
    public static final String ACTION_ADD = "com.google.android.exoplayer.downloadService.action.ADD";
    public static final String ACTION_INIT = "com.google.android.exoplayer.downloadService.action.INIT";
    public static final String ACTION_RELOAD_REQUIREMENTS = "com.google.android.exoplayer.downloadService.action.RELOAD_REQUIREMENTS";
    private static final String ACTION_RESTART = "com.google.android.exoplayer.downloadService.action.RESTART";
    private static final boolean DEBUG = false;
    public static final long DEFAULT_FOREGROUND_NOTIFICATION_UPDATE_INTERVAL = 1000;
    public static final int FOREGROUND_NOTIFICATION_ID_NONE = 0;
    public static final String KEY_DOWNLOAD_ACTION = "download_action";
    public static final String KEY_FOREGROUND = "foreground";
    private static final String TAG = "DownloadService";
    private final String channelId;
    private final int channelName;
    private DownloadManager downloadManager;
    private DownloadManagerListener downloadManagerListener;
    private final ForegroundNotificationUpdater foregroundNotificationUpdater;
    private int lastStartId;
    private boolean startedInForeground;
    private boolean taskRemoved;
    private static final HashMap<Class<? extends DownloadService>, RequirementsHelper> requirementsHelpers = new HashMap<>();
    private static final Requirements DEFAULT_REQUIREMENTS = new Requirements(1, false, false);

    private void logd(String str) {
    }

    protected abstract DownloadManager getDownloadManager();

    protected abstract Scheduler getScheduler();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    protected void onTaskStateChanged(DownloadManager.TaskState taskState) {
    }

    protected DownloadService(int OplusGLSurfaceView_13) {
        this(OplusGLSurfaceView_13, 1000L);
    }

    protected DownloadService(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        this(OplusGLSurfaceView_13, OplusGLSurfaceView_15, null, 0);
    }

    protected DownloadService(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, String str, int i2) {
        this.foregroundNotificationUpdater = OplusGLSurfaceView_13 == 0 ? null : new ForegroundNotificationUpdater(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
        this.channelId = str;
        this.channelName = i2;
    }

    public static Intent buildAddActionIntent(Context context, Class<? extends DownloadService> cls, DownloadAction downloadAction, boolean z) {
        return getIntent(context, cls, ACTION_ADD).putExtra(KEY_DOWNLOAD_ACTION, downloadAction.toByteArray()).putExtra(KEY_FOREGROUND, z);
    }

    public static void startWithAction(Context context, Class<? extends DownloadService> cls, DownloadAction downloadAction, boolean z) {
        Intent intentBuildAddActionIntent = buildAddActionIntent(context, cls, downloadAction, z);
        if (z) {
            Util.startForegroundService(context, intentBuildAddActionIntent);
        } else {
            context.startService(intentBuildAddActionIntent);
        }
    }

    public static void start(Context context, Class<? extends DownloadService> cls) {
        context.startService(getIntent(context, cls, ACTION_INIT));
    }

    public static void startForeground(Context context, Class<? extends DownloadService> cls) {
        Util.startForegroundService(context, getIntent(context, cls, ACTION_INIT).putExtra(KEY_FOREGROUND, true));
    }

    @Override // android.app.Service
    public void onCreate() {
        logd("onCreate");
        String str = this.channelId;
        if (str != null) {
            NotificationUtil.createNotificationChannel(this, str, this.channelName, 2);
        }
        this.downloadManager = getDownloadManager();
        this.downloadManagerListener = new DownloadManagerListener();
        this.downloadManager.addListener(this.downloadManagerListener);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0076  */
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
            com.google.android.exoplayer2.util.Log.m8320e(r10, r8)
            goto Lb4
        L96:
            r7.stopWatchingRequirements()
            goto Lb4
        L9a:
            java.lang.String r9 = "download_action"
            byte[] r8 = r8.getByteArrayExtra(r9)
            if (r8 != 0) goto La8
            java.lang.String r8 = "Ignoring ADD action with no action data"
            com.google.android.exoplayer2.util.Log.m8320e(r10, r8)
            goto Lb4
        La8:
            com.google.android.exoplayer2.offline.DownloadManager r9 = r7.downloadManager     // Catch: java.io.IOException -> Lae
            r9.handleAction(r8)     // Catch: java.io.IOException -> Lae
            goto Lb4
        Lae:
            r8 = move-exception
            java.lang.String r9 = "Failed to handle ADD action"
            com.google.android.exoplayer2.util.Log.m8321e(r10, r9, r8)
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
    public void onTaskRemoved(Intent intent) {
        logd("onTaskRemoved rootIntent: " + intent);
        this.taskRemoved = true;
    }

    @Override // android.app.Service
    public void onDestroy() {
        logd("onDestroy");
        ForegroundNotificationUpdater foregroundNotificationUpdater = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater != null) {
            foregroundNotificationUpdater.stopPeriodicUpdates();
        }
        this.downloadManager.removeListener(this.downloadManagerListener);
        maybeStopWatchingRequirements();
    }

    protected Requirements getRequirements() {
        return DEFAULT_REQUIREMENTS;
    }

    protected Notification getForegroundNotification(DownloadManager.TaskState[] taskStateArr) {
        throw new IllegalStateException(getClass().getName() + " is started in the foreground but getForegroundNotification() is not implemented.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void maybeStartWatchingRequirements(Requirements requirements) {
        if (this.downloadManager.getDownloadCount() == 0) {
            return;
        }
        Class<?> cls = getClass();
        if (requirementsHelpers.get(cls) == null) {
            RequirementsHelper requirementsHelper = new RequirementsHelper(this, requirements, getScheduler(), cls);
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
        RequirementsHelper requirementsHelperRemove = requirementsHelpers.remove(getClass());
        if (requirementsHelperRemove != null) {
            requirementsHelperRemove.stop();
            logd("stopped watching requirements");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        ForegroundNotificationUpdater foregroundNotificationUpdater = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater != null) {
            foregroundNotificationUpdater.stopPeriodicUpdates();
            if (this.startedInForeground && Util.SDK_INT >= 26) {
                this.foregroundNotificationUpdater.showNotificationIfNotAlready();
            }
        }
        if (Util.SDK_INT < 28 && this.taskRemoved) {
            stopSelf();
            logd("stopSelf()");
            return;
        }
        logd("stopSelf(" + this.lastStartId + ") result: " + stopSelfResult(this.lastStartId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent getIntent(Context context, Class<? extends DownloadService> cls, String str) {
        return new Intent(context, cls).setAction(str);
    }

    private final class DownloadManagerListener implements DownloadManager.Listener {
        private DownloadManagerListener() {
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void onInitialized(DownloadManager downloadManager) {
            DownloadService downloadService = DownloadService.this;
            downloadService.maybeStartWatchingRequirements(downloadService.getRequirements());
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void onTaskStateChanged(DownloadManager downloadManager, DownloadManager.TaskState taskState) {
            DownloadService.this.onTaskStateChanged(taskState);
            if (DownloadService.this.foregroundNotificationUpdater != null) {
                if (taskState.state == 1) {
                    DownloadService.this.foregroundNotificationUpdater.startPeriodicUpdates();
                } else {
                    DownloadService.this.foregroundNotificationUpdater.update();
                }
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public final void onIdle(DownloadManager downloadManager) {
            DownloadService.this.stop();
        }
    }

    private final class ForegroundNotificationUpdater implements Runnable {
        private final Handler handler = new Handler(Looper.getMainLooper());
        private boolean notificationDisplayed;
        private final int notificationId;
        private boolean periodicUpdatesStarted;
        private final long updateInterval;

        public ForegroundNotificationUpdater(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            this.notificationId = OplusGLSurfaceView_13;
            this.updateInterval = OplusGLSurfaceView_15;
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
            DownloadManager.TaskState[] allTaskStates = DownloadService.this.downloadManager.getAllTaskStates();
            DownloadService downloadService = DownloadService.this;
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

    private static final class RequirementsHelper implements RequirementsWatcher.Listener {
        private final Context context;
        private final Requirements requirements;
        private final RequirementsWatcher requirementsWatcher;
        private final Scheduler scheduler;
        private final Class<? extends DownloadService> serviceClass;

        private RequirementsHelper(Context context, Requirements requirements, Scheduler scheduler, Class<? extends DownloadService> cls) {
            this.context = context;
            this.requirements = requirements;
            this.scheduler = scheduler;
            this.serviceClass = cls;
            this.requirementsWatcher = new RequirementsWatcher(context, this, requirements);
        }

        public void start() {
            this.requirementsWatcher.start();
        }

        public void stop() {
            this.requirementsWatcher.stop();
            Scheduler scheduler = this.scheduler;
            if (scheduler != null) {
                scheduler.cancel();
            }
        }

        @Override // com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener
        public void requirementsMet(RequirementsWatcher requirementsWatcher) {
            try {
                notifyService();
                Scheduler scheduler = this.scheduler;
                if (scheduler != null) {
                    scheduler.cancel();
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener
        public void requirementsNotMet(RequirementsWatcher requirementsWatcher) {
            try {
                notifyService();
            } catch (Exception unused) {
            }
            if (this.scheduler != null) {
                if (this.scheduler.schedule(this.requirements, this.context.getPackageName(), DownloadService.ACTION_RESTART)) {
                    return;
                }
                Log.m8320e(DownloadService.TAG, "Scheduling downloads failed.");
            }
        }

        private void notifyService() throws Exception {
            try {
                this.context.startService(DownloadService.getIntent(this.context, this.serviceClass, DownloadService.ACTION_INIT));
            } catch (IllegalStateException COUIBaseListPopupWindow_8) {
                throw new Exception(COUIBaseListPopupWindow_8);
            }
        }
    }
}
