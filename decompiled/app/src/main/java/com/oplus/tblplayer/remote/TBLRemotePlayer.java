package com.oplus.tblplayer.remote;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.oplus.tblplayer.IRemoteLinker;
import com.oplus.tblplayer.IRemoteObservable;
import com.oplus.tblplayer.misc.TBLTimedText;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.oplus.tblplayer.monitor.Report;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.ParcelUtils;

/* loaded from: classes2.dex */
public class TBLRemotePlayer extends RemotePlayerProxy implements ServiceConnection, IBinder.DeathRecipient {
    private static final int BIND_SERVICE_TIMEOUT = 5000;
    private static final int BIND_STATE_BINDING = 1;
    private static final int BIND_STATE_BOUND = 2;
    private static final int BIND_STATE_IDLE = 0;
    private static final int BIND_STATE_RELEASE = 3;
    private static final String TAG = "TBLRemotePlayer";
    private final Context mAppContext;
    private IRemoteLinker mRemoteLinker;
    private final Intent mServiceIntent;
    private long startBindTime = 0;
    private long onBoundTime = 0;
    private int mBinderState = 0;
    private final Runnable mBindTimeOutRunnable = new Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$qMzPd1pvAIpKrgczbz8m_YoDFoA
        @Override // java.lang.Runnable
        public final void run() {
            this.COUIBaseListPopupWindow_12$0.lambda$new$1$TBLRemotePlayer();
        }
    };
    private IRemoteObservable mRemoteObservable = new BinderC37941();
    protected Handler mEventHandler = new Handler(getLooper());

    public TBLRemotePlayer(Context context) {
        this.mAppContext = context.getApplicationContext();
        this.mServiceIntent = new Intent(this.mAppContext, (Class<?>) TBLRemotePlayerService.class);
        startBindService();
    }

    public static Looper getLooper() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    private synchronized void startBindService() {
        this.startBindTime = System.currentTimeMillis();
        LogUtil.m25450d(TAG, "startBindService: startBindTime is " + this.startBindTime);
        if (this.mBinderState != 0) {
            return;
        }
        try {
            if (!this.mAppContext.bindService(this.mServiceIntent, this, 1)) {
                LogUtil.m25452e(TAG, "startBindService: Fail to bind remote service.");
                handleBinderDied(true, ErrorCode.REASON_BIND_FAILED, "Bind service failed.");
            }
            this.mBinderState = 1;
            this.mEventHandler.postDelayed(this.mBindTimeOutRunnable, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        } catch (SecurityException COUIBaseListPopupWindow_8) {
            LogUtil.m25452e(TAG, "startBindService: SecurityException.");
            handleBinderDied(true, ErrorCode.REASON_BIND_FAILED, "Bind service has exception. " + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    private synchronized void handleServiceBound(IBinder iBinder) {
        this.onBoundTime = System.currentTimeMillis();
        LogUtil.m25450d(TAG, "handleServiceBound: onBoundTime is " + this.onBoundTime + ", bind consuming time is " + (this.onBoundTime - this.startBindTime));
        if (this.mBinderState != 1) {
            return;
        }
        if (this.mEventHandler != null) {
            this.mEventHandler.removeCallbacks(this.mBindTimeOutRunnable);
        }
        try {
            this.mRemoteLinker = IRemoteLinker.Stub.asInterface(iBinder);
            this.mRemoteLinker.asBinder().linkToDeath(this, 0);
            this.mRemotePlayer = this.mRemoteLinker.create();
            this.mBinderState = 2;
            invokeRemoteMethod(33, this.mRemoteObservable);
            this.mSurfaceCache.refreshSurface();
            flushPendingTaskStack();
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            LogUtil.m25453e(TAG, "handleServiceBound: Caught PlatformImplementations.kt_3  RemoteException.", COUIBaseListPopupWindow_8);
            binderDied();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        handleServiceBound(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        LogUtil.m25450d(TAG, "onServiceDisconnected");
        handleBinderDied(true, ErrorCode.REASON_BINDER_DISCONNECTED, "Binder disconnected.");
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        LogUtil.m25450d(TAG, "binderDied");
        handleBinderDied(true, ErrorCode.REASON_BINDER_DISCONNECTED, "Binder disconnected.");
    }

    private synchronized void handleBinderDied(boolean z, int OplusGLSurfaceView_13, String str) {
        LogUtil.m25450d(TAG, "handleBinderDied: notify is " + z + ", binder state is " + this.mBinderState);
        if (this.mBinderState != 3) {
            if (z) {
                notifyBinderError(OplusGLSurfaceView_13, str);
            }
            unbindService();
        }
    }

    private void unbindService() {
        LogUtil.m25450d(TAG, "unbindService");
        try {
            this.mAppContext.unbindService(this);
        } catch (IllegalArgumentException COUIBaseListPopupWindow_8) {
            LogUtil.m25452e(TAG, "unbindService: Service is not exist.");
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    @Override // com.oplus.tblplayer.remote.RemotePlayerProxy
    protected <T> T execRemoteMethod(int OplusGLSurfaceView_13, T t, Object... objArr) {
        try {
            T t2 = (T) ParcelUtils.invokeRemoteMethod(this.mRemotePlayer, "RemotePlayer", OplusGLSurfaceView_13, objArr);
            return t2 == null ? t : t2;
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            LogUtil.m25453e(TAG, "execRemoteMethod fail [IPC]: ", COUIBaseListPopupWindow_8);
            this.binderDied();
            return t;
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
        LogUtil.m25450d(TAG, "onRelease");
        IRemoteLinker iRemoteLinker = this.mRemoteLinker;
        if (iRemoteLinker != null) {
            iRemoteLinker.asBinder().unlinkToDeath(this, 0);
            this.mRemoteLinker = null;
        }
        Handler handler = this.mEventHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mEventHandler = null;
        }
    }

    private void notifyBinderError(final int OplusGLSurfaceView_13, final String str) {
        LogUtil.m25450d(TAG, "notifyBinderError: Notify APP binder error.");
        Handler handler = this.mEventHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$0WBoawbEgAl9Zs8vMe_o-EWFJlA
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.lambda$notifyBinderError$0$TBLRemotePlayer(OplusGLSurfaceView_13, str);
                }
            });
        }
    }

    public /* synthetic */ void lambda$notifyBinderError$0$TBLRemotePlayer(int OplusGLSurfaceView_13, String str) {
        notifyOnError(2, OplusGLSurfaceView_13, str);
        onRelease();
    }

    public /* synthetic */ void lambda$new$1$TBLRemotePlayer() {
        LogUtil.m25452e(TAG, "startBindService: Fail to bind remote service because time out.");
        handleBinderDied(true, ErrorCode.REASON_BIND_TIMEOUT, "Waited for 5000ms, but service was never response.");
    }

    /* renamed from: com.oplus.tblplayer.remote.TBLRemotePlayer$1 */
    class BinderC37941 extends IRemoteObservable.Stub {
        BinderC37941() {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPrepared() throws RemoteException {
            if (TBLRemotePlayer.this.mEventHandler != null) {
                TBLRemotePlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$doNa_P8n2hGxMCUPGz--IRzF9hU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.lambda$notifyPrepared$0$TBLRemotePlayer$1();
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyPrepared$0$TBLRemotePlayer$1() {
            TBLRemotePlayer.this.notifyOnPrepared();
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyCompletion() throws RemoteException {
            if (TBLRemotePlayer.this.mEventHandler != null) {
                TBLRemotePlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$gQrWsEeWAmaDJ0HqNtL8sCPYSI8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.lambda$notifyCompletion$1$TBLRemotePlayer$1();
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyCompletion$1$TBLRemotePlayer$1() {
            TBLRemotePlayer.this.notifyOnCompletion();
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyBufferingUpdate(final int OplusGLSurfaceView_13) throws RemoteException {
            if (TBLRemotePlayer.this.mEventHandler != null) {
                TBLRemotePlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$C2t9nARcgRyOkN4y9IZa6jiLrfw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.lambda$notifyBufferingUpdate$2$TBLRemotePlayer$1(OplusGLSurfaceView_13);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyBufferingUpdate$2$TBLRemotePlayer$1(int OplusGLSurfaceView_13) {
            TBLRemotePlayer.this.notifyOnBufferingUpdate(OplusGLSurfaceView_13);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifySeekComplete() throws RemoteException {
            if (TBLRemotePlayer.this.mEventHandler != null) {
                TBLRemotePlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$CS5cowq5cmVVzUwcxTi6STNu9cg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.lambda$notifySeekComplete$3$TBLRemotePlayer$1();
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifySeekComplete$3$TBLRemotePlayer$1() {
            TBLRemotePlayer.this.notifyOnSeekComplete();
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyVideoSizeChanged(final int OplusGLSurfaceView_13, final int i2, final int i3, final float COUIBaseListPopupWindow_12) throws RemoteException {
            if (TBLRemotePlayer.this.mEventHandler != null) {
                TBLRemotePlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$G6uFcX34O4DTm7n6xfp5fiW9Rgs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.lambda$notifyVideoSizeChanged$4$TBLRemotePlayer$1(OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyVideoSizeChanged$4$TBLRemotePlayer$1(int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) {
            TBLRemotePlayer.this.notifyOnVideoSizeChanged(OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public boolean notifyError(final int OplusGLSurfaceView_13, final int i2, final String str) throws RemoteException {
            if (TBLRemotePlayer.this.mEventHandler == null) {
                return false;
            }
            TBLRemotePlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$yeXWCGDnB3Dgo65UFI-xuZg3k2Y
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.lambda$notifyError$5$TBLRemotePlayer$1(OplusGLSurfaceView_13, i2, str);
                }
            });
            return false;
        }

        public /* synthetic */ void lambda$notifyError$5$TBLRemotePlayer$1(int OplusGLSurfaceView_13, int i2, String str) {
            TBLRemotePlayer.this.notifyOnError(OplusGLSurfaceView_13, i2, str);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public boolean notifyInfo(final int OplusGLSurfaceView_13, final int i2) throws RemoteException {
            if (TBLRemotePlayer.this.mEventHandler == null) {
                return false;
            }
            TBLRemotePlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$rWxKpfFwzsKW9T0FAYXOERWb2Po
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.lambda$notifyInfo$6$TBLRemotePlayer$1(OplusGLSurfaceView_13, i2);
                }
            });
            return false;
        }

        public /* synthetic */ void lambda$notifyInfo$6$TBLRemotePlayer$1(int OplusGLSurfaceView_13, int i2) {
            TBLRemotePlayer.this.notifyOnInfo(OplusGLSurfaceView_13, i2);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyTimedText(final TBLTimedText tBLTimedText) throws RemoteException {
            if (TBLRemotePlayer.this.mEventHandler != null) {
                TBLRemotePlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$xKJjsnuaNXSlEpy9M-FwQbRmh50
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.lambda$notifyTimedText$7$TBLRemotePlayer$1(tBLTimedText);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyTimedText$7$TBLRemotePlayer$1(TBLTimedText tBLTimedText) {
            TBLRemotePlayer.this.notifyOnTimedText(tBLTimedText);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPlaybackResult(final Report report) throws RemoteException {
            if (TBLRemotePlayer.this.mEventHandler != null) {
                TBLRemotePlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$LXyByvGq5CEu0vd6fGte32dU9XI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.lambda$notifyPlaybackResult$8$TBLRemotePlayer$1(report);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyPlaybackResult$8$TBLRemotePlayer$1(Report report) {
            TBLRemotePlayer.this.notifyOnPlaybackResult(report);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPlayerStateChanged(final int OplusGLSurfaceView_13) throws RemoteException {
            if (TBLRemotePlayer.this.mEventHandler != null) {
                TBLRemotePlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$TWJixtiEhGhCY31j5d7eMDUjGxg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m25449x22cc294d(OplusGLSurfaceView_13);
                    }
                });
            }
        }

        /* renamed from: lambda$notifyPlayerStateChanged$9$TBLRemotePlayer$1 */
        public /* synthetic */ void m25449x22cc294d(int OplusGLSurfaceView_13) {
            TBLRemotePlayer.this.notifyOnPlayerStateChanged(OplusGLSurfaceView_13);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyIsPlayingChanged(final boolean z) throws RemoteException {
            if (TBLRemotePlayer.this.mEventHandler != null) {
                TBLRemotePlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$VOg99pvwAo1TdEoXVKQv2fVZb6w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.lambda$notifyIsPlayingChanged$10$TBLRemotePlayer$1(z);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$notifyIsPlayingChanged$10$TBLRemotePlayer$1(boolean z) {
            TBLRemotePlayer.this.notifyOnIsPlayingChanged(z);
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyDownstreamSizeChanged(final int OplusGLSurfaceView_13, final int i2, final int i3, final float COUIBaseListPopupWindow_12) throws RemoteException {
            if (TBLRemotePlayer.this.mEventHandler != null) {
                TBLRemotePlayer.this.mEventHandler.post(new Runnable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$TBLRemotePlayer$1$5zf2oJaJzZsJaGU1QgPMB6NH5IQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m25448x61661207(OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
                    }
                });
            }
        }

        /* renamed from: lambda$notifyDownstreamSizeChanged$11$TBLRemotePlayer$1 */
        public /* synthetic */ void m25448x61661207(int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) {
            TBLRemotePlayer.this.notifyOnDownstreamSizeChanged(OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
        }
    }
}
