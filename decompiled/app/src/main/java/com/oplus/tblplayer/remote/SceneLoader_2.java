package com.oplus.tblplayer.remote;

/* loaded from: classes2.dex */
public class TBLRemotePlayer extends com.oplus.tblplayer.remote.RemotePlayerProxy implements android.content.ServiceConnection, android.os.IBinder.DeathRecipient {
    private static final int BIND_SERVICE_TIMEOUT = 5000;
    private static final int BIND_STATE_BINDING = 1;
    private static final int BIND_STATE_BOUND = 2;
    private static final int BIND_STATE_IDLE = 0;
    private static final int BIND_STATE_RELEASE = 3;
    private static final java.lang.String TAG = "TBLRemotePlayer";
    private final android.content.Context mAppContext;
    private com.oplus.tblplayer.IRemoteLinker mRemoteLinker;
    private final android.content.Intent mServiceIntent;
    private long startBindTime = 0;
    private long onBoundTime = 0;
    private int mBinderState = 0;
    private final java.lang.Runnable mBindTimeOutRunnable = new java.lang.Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$qMzPd1pvAIpKrgczbz8m_YoDFoA
        @Override // java.lang.Runnable
        public final void run() {
            this.f_renamed$0.lambda$new$1$TBLRemotePlayer();
        }
    };
    private com.oplus.tblplayer.IRemoteObservable mRemoteObservable = new com.oplus.tblplayer.remote.TBLRemotePlayer.SceneLoader_2();
    protected android.os.Handler mEventHandler = new android.os.Handler(getLooper());

    public TBLRemotePlayer(android.content.Context context) {
        this.mAppContext = context.getApplicationContext();
        this.mServiceIntent = new android.content.Intent(this.mAppContext, (java.lang.Class<?>) com.oplus.tblplayer.remote.TBLRemotePlayerService.class);
        startBindService();
    }

    public static android.os.Looper getLooper() {
        android.os.Looper looperMyLooper = android.os.Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : android.os.Looper.getMainLooper();
    }

    private synchronized void startBindService() {
        this.startBindTime = java.lang.System.currentTimeMillis();
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "startBindService: startBindTime is_renamed " + this.startBindTime);
        if (this.mBinderState != 0) {
            return;
        }
        try {
            if (!this.mAppContext.bindService(this.mServiceIntent, this, 1)) {
                com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "startBindService: Fail to bind remote service.");
                handleBinderDied(true, com.oplus.tblplayer.monitor.ErrorCode.REASON_BIND_FAILED, "Bind service failed.");
            }
            this.mBinderState = 1;
            this.mEventHandler.postDelayed(this.mBindTimeOutRunnable, com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        } catch (java.lang.SecurityException e_renamed) {
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "startBindService: SecurityException.");
            handleBinderDied(true, com.oplus.tblplayer.monitor.ErrorCode.REASON_BIND_FAILED, "Bind service has exception. " + e_renamed.getMessage());
        }
    }

    private synchronized void handleServiceBound(android.os.IBinder iBinder) {
        this.onBoundTime = java.lang.System.currentTimeMillis();
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "handleServiceBound: onBoundTime is_renamed " + this.onBoundTime + ", bind consuming time is_renamed " + (this.onBoundTime - this.startBindTime));
        if (this.mBinderState != 1) {
            return;
        }
        if (this.mEventHandler != null) {
            this.mEventHandler.removeCallbacks(this.mBindTimeOutRunnable);
        }
        try {
            this.mRemoteLinker = com.oplus.tblplayer.IRemoteLinker.Stub.asInterface(iBinder);
            this.mRemoteLinker.asBinder().linkToDeath(this, 0);
            this.mRemotePlayer = this.mRemoteLinker.create();
            this.mBinderState = 2;
            invokeRemoteMethod(33, this.mRemoteObservable);
            this.mSurfaceCache.refreshSurface();
            flushPendingTaskStack();
        } catch (android.os.RemoteException e_renamed) {
            e_renamed.printStackTrace();
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "handleServiceBound: Caught a_renamed  RemoteException.", e_renamed);
            binderDied();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        handleServiceBound(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onServiceDisconnected");
        handleBinderDied(true, com.oplus.tblplayer.monitor.ErrorCode.REASON_BINDER_DISCONNECTED, "Binder disconnected.");
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "binderDied");
        handleBinderDied(true, com.oplus.tblplayer.monitor.ErrorCode.REASON_BINDER_DISCONNECTED, "Binder disconnected.");
    }

    private synchronized void handleBinderDied(boolean z_renamed, int i_renamed, java.lang.String str) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "handleBinderDied: notify is_renamed " + z_renamed + ", binder state is_renamed " + this.mBinderState);
        if (this.mBinderState != 3) {
            if (z_renamed) {
                notifyBinderError(i_renamed, str);
            }
            unbindService();
        }
    }

    private void unbindService() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "unbindService");
        try {
            this.mAppContext.unbindService(this);
        } catch (java.lang.IllegalArgumentException e_renamed) {
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "unbindService: Service is_renamed not exist.");
            e_renamed.printStackTrace();
        }
    }

    @Override // com.oplus.tblplayer.remote.RemotePlayerProxy
    protected <T_renamed> T_renamed execRemoteMethod(int i_renamed, T_renamed t_renamed, java.lang.Object... objArr) {
        try {
            T_renamed t2 = (T_renamed) com.oplus.tblplayer.utils.ParcelUtils.invokeRemoteMethod(this.mRemotePlayer, "RemotePlayer", i_renamed, objArr);
            return t2 == null ? t_renamed : t2;
        } catch (android.os.RemoteException e_renamed) {
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "execRemoteMethod fail [IPC]: ", e_renamed);
            this.binderDied();
            return t_renamed;
        }
    }

    @Override // com.oplus.tblplayer.remote.RemotePlayerProxy
    protected boolean shouldPending() {
        return this.mRemotePlayer == null && this.mBinderState == 1;
    }

    @Override // com.oplus.tblplayer.remote.RemotePlayerProxy
    protected boolean shouldInvoke() {
        return this.mRemotePlayer != null && this.mBinderState == 2;
    }

    @Override // com.oplus.tblplayer.remote.RemotePlayerProxy
    protected void onRelease() {
        super.onRelease();
        this.mBinderState = 3;
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onRelease");
        com.oplus.tblplayer.IRemoteLinker iRemoteLinker = this.mRemoteLinker;
        if (iRemoteLinker != null) {
            iRemoteLinker.asBinder().unlinkToDeath(this, 0);
            this.mRemoteLinker = null;
        }
        android.os.Handler handler = this.mEventHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mEventHandler = null;
        }
    }

    private void notifyBinderError(final int i_renamed, final java.lang.String str) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "notifyBinderError: Notify APP binder error.");
        android.os.Handler handler = this.mEventHandler;
        if (handler != null) {
            handler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$0WBoawbEgAl9Zs8vMe_o-EWFJlA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.lambda$notifyBinderError$0$TBLRemotePlayer(i_renamed, str);
                }
            });
        }
    }

    public /* synthetic */ void lambda$notifyBinderError$0$TBLRemotePlayer(int i_renamed, java.lang.String str) {
        notifyOnError(2, i_renamed, str);
        onRelease();
    }

    public /* synthetic */ void lambda$new$1$TBLRemotePlayer() {
        com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "startBindService: Fail to bind remote service because time out.");
        handleBinderDied(true, com.oplus.tblplayer.monitor.ErrorCode.REASON_BIND_TIMEOUT, "Waited for 5000ms, but service was never response.");
    }

    /* renamed from: com.oplus.tblplayer.remote.TBLRemotePlayer$1, reason: invalid class name */
    class SceneLoader_2 extends com.oplus.tblplayer.IRemoteObservable.Stub {
        SceneLoader_2() {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPrepared() throws android.os.RemoteException {
            if (com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler != null) {
                com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$doNa_P8n2hGxMCUPGz--IRzF9hU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$notifyPrepared$0$TBLRemotePlayer$1();
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyPrepared$0$TBLRemotePlayer$1() {
            com.oplus.tblplayer.remote.TBLRemotePlayer.this.notifyOnPrepared();
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyCompletion() throws android.os.RemoteException {
            if (com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler != null) {
                com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$gQrWsEeWAmaDJ0HqNtL8sCPYSI8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$notifyCompletion$1$TBLRemotePlayer$1();
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyCompletion$1$TBLRemotePlayer$1() {
            com.oplus.tblplayer.remote.TBLRemotePlayer.this.notifyOnCompletion();
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyBufferingUpdate(final int i_renamed) throws android.os.RemoteException {
            if (com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler != null) {
                com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$C2t9nARcgRyOkN4y9IZa6jiLrfw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$notifyBufferingUpdate$2$TBLRemotePlayer$1(i_renamed);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyBufferingUpdate$2$TBLRemotePlayer$1(int i_renamed) {
            com.oplus.tblplayer.remote.TBLRemotePlayer.this.notifyOnBufferingUpdate(i_renamed);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifySeekComplete() throws android.os.RemoteException {
            if (com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler != null) {
                com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$CS5cowq5cmVVzUwcxTi6STNu9cg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$notifySeekComplete$3$TBLRemotePlayer$1();
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifySeekComplete$3$TBLRemotePlayer$1() {
            com.oplus.tblplayer.remote.TBLRemotePlayer.this.notifyOnSeekComplete();
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyVideoSizeChanged(final int i_renamed, final int i2, final int i3, final float f_renamed) throws android.os.RemoteException {
            if (com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler != null) {
                com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$G6uFcX34O4DTm7n6xfp5fiW9Rgs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$notifyVideoSizeChanged$4$TBLRemotePlayer$1(i_renamed, i2, i3, f_renamed);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyVideoSizeChanged$4$TBLRemotePlayer$1(int i_renamed, int i2, int i3, float f_renamed) {
            com.oplus.tblplayer.remote.TBLRemotePlayer.this.notifyOnVideoSizeChanged(i_renamed, i2, i3, f_renamed);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public boolean notifyError(final int i_renamed, final int i2, final java.lang.String str) throws android.os.RemoteException {
            if (com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler == null) {
                return false;
            }
            com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$yeXWCGDnB3Dgo65UFI-xuZg3k2Y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.lambda$notifyError$5$TBLRemotePlayer$1(i_renamed, i2, str);
                }
            });
            return false;
        }

        public /* synthetic */ void lambda$notifyError$5$TBLRemotePlayer$1(int i_renamed, int i2, java.lang.String str) {
            com.oplus.tblplayer.remote.TBLRemotePlayer.this.notifyOnError(i_renamed, i2, str);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public boolean notifyInfo(final int i_renamed, final int i2) throws android.os.RemoteException {
            if (com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler == null) {
                return false;
            }
            com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$rWxKpfFwzsKW9T0FAYXOERWb2Po
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.lambda$notifyInfo$6$TBLRemotePlayer$1(i_renamed, i2);
                }
            });
            return false;
        }

        public /* synthetic */ void lambda$notifyInfo$6$TBLRemotePlayer$1(int i_renamed, int i2) {
            com.oplus.tblplayer.remote.TBLRemotePlayer.this.notifyOnInfo(i_renamed, i2);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyTimedText(final com.oplus.tblplayer.misc.TBLTimedText tBLTimedText) throws android.os.RemoteException {
            if (com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler != null) {
                com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$xKJjsnuaNXSlEpy9M-FwQbRmh50
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$notifyTimedText$7$TBLRemotePlayer$1(tBLTimedText);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyTimedText$7$TBLRemotePlayer$1(com.oplus.tblplayer.misc.TBLTimedText tBLTimedText) {
            com.oplus.tblplayer.remote.TBLRemotePlayer.this.notifyOnTimedText(tBLTimedText);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPlaybackResult(final com.oplus.tblplayer.monitor.Report report) throws android.os.RemoteException {
            if (com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler != null) {
                com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$LXyByvGq5CEu0vd6fGte32dU9XI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$notifyPlaybackResult$8$TBLRemotePlayer$1(report);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyPlaybackResult$8$TBLRemotePlayer$1(com.oplus.tblplayer.monitor.Report report) {
            com.oplus.tblplayer.remote.TBLRemotePlayer.this.notifyOnPlaybackResult(report);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPlayerStateChanged(final int i_renamed) throws android.os.RemoteException {
            if (com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler != null) {
                com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$TWJixtiEhGhCY31j5d7eMDUjGxg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$notifyPlayerStateChanged$9$TBLRemotePlayer$1(i_renamed);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyPlayerStateChanged$9$TBLRemotePlayer$1(int i_renamed) {
            com.oplus.tblplayer.remote.TBLRemotePlayer.this.notifyOnPlayerStateChanged(i_renamed);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyIsPlayingChanged(final boolean z_renamed) throws android.os.RemoteException {
            if (com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler != null) {
                com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$VOg99pvwAo1TdEoXVKQv2fVZb6w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$notifyIsPlayingChanged$10$TBLRemotePlayer$1(z_renamed);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyIsPlayingChanged$10$TBLRemotePlayer$1(boolean z_renamed) {
            com.oplus.tblplayer.remote.TBLRemotePlayer.this.notifyOnIsPlayingChanged(z_renamed);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyDownstreamSizeChanged(final int i_renamed, final int i2, final int i3, final float f_renamed) throws android.os.RemoteException {
            if (com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler != null) {
                com.oplus.tblplayer.remote.TBLRemotePlayer.this.mEventHandler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$5zf2oJaJzZsJaGU1QgPMB6NH5IQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$notifyDownstreamSizeChanged$11$TBLRemotePlayer$1(i_renamed, i2, i3, f_renamed);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyDownstreamSizeChanged$11$TBLRemotePlayer$1(int i_renamed, int i2, int i3, float f_renamed) {
            com.oplus.tblplayer.remote.TBLRemotePlayer.this.notifyOnDownstreamSizeChanged(i_renamed, i2, i3, f_renamed);
        }
    }
}
