package com.oplus.tblplayer.remote;

/* loaded from: classes2.dex */
public class RemotePlayerStub extends com.oplus.tblplayer.remote.BaseBinderStub implements android.os.IBinder.DeathRecipient, android.os.IInterface {
    private static final java.lang.String TAG = "RemotePlayerStub";
    private android.content.Context mAppContext;
    private android.os.Handler mMainThreadHandler;
    private com.oplus.tblplayer.remote.RemoteObservable mObservable;
    private com.oplus.tblplayer.IMediaPlayer mPlayer;

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return this;
    }

    public RemotePlayerStub(android.content.Context context) {
        attachInterface(this, "RemotePlayer");
        this.mAppContext = context.getApplicationContext();
        this.mMainThreadHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        this.mPlayer = (com.oplus.tblplayer.IMediaPlayer) execOnMainThread(new java.util.concurrent.Callable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$RemotePlayerStub$XnwS30IcKjJqn_c6JAPwvBVCom4
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f_renamed$0.lambda$new$0$RemotePlayerStub();
            }
        });
    }

    public /* synthetic */ com.oplus.tblplayer.IMediaPlayer lambda$new$0$RemotePlayerStub() throws java.lang.Exception {
        return new com.oplus.tblplayer.TBLExoPlayer(this.mAppContext);
    }

    private <T_renamed> T_renamed execOnMainThread(java.util.concurrent.Callable<T_renamed> callable) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            try {
                return callable.call();
            } catch (java.lang.Exception e_renamed) {
                throw new java.lang.RuntimeException(e_renamed);
            }
        }
        java.util.concurrent.FutureTask futureTask = new java.util.concurrent.FutureTask(callable);
        this.mMainThreadHandler.post(futureTask);
        try {
            return (T_renamed) futureTask.get();
        } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    @Override // com.oplus.tblplayer.remote.BaseBinderStub
    protected java.lang.Object onTransactInternal(final int i_renamed, final java.lang.Object... objArr) throws java.io.IOException {
        return execOnMainThread(new java.util.concurrent.Callable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$RemotePlayerStub$FnqDF7GbBhsGjSFXpzU2AjGeW2c
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f_renamed$0.lambda$onTransactInternal$1$RemotePlayerStub(i_renamed, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: execTransact, reason: merged with bridge method [inline-methods] */
    public java.lang.Object lambda$onTransactInternal$1$RemotePlayerStub(int i_renamed, java.lang.Object... objArr) throws java.lang.IllegalStateException, android.os.RemoteException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        switch (i_renamed) {
            case 1:
                this.mPlayer.setDataSource((java.lang.String) objArr[0]);
                return null;
            case 2:
                this.mPlayer.setDataSource((android.net.Uri) objArr[0]);
                return null;
            case 3:
                this.mPlayer.setDataSource((android.net.Uri) objArr[0], (java.util.Map) objArr[1]);
                return null;
            case 4:
                this.mPlayer.setDataSource((com.oplus.tblplayer.misc.IMediaDataSource) objArr[0]);
                return null;
            case 5:
                this.mPlayer.setDataSource(((android.os.ParcelFileDescriptor) objArr[0]).getFileDescriptor());
                return null;
            case 6:
                return this.mPlayer.getDataSource();
            case 7:
                this.mPlayer.prepareAsync();
                return null;
            case 8:
                this.mPlayer.start();
                return null;
            case 9:
                this.mPlayer.stop();
                return null;
            case 10:
                this.mPlayer.pause();
                return null;
            case 11:
                this.mPlayer.seekTo(((java.lang.Long) objArr[0]).longValue());
                return null;
            case 12:
                return java.lang.Boolean.valueOf(this.mPlayer.isPlaying());
            case 13:
                return java.lang.Boolean.valueOf(this.mPlayer.isPlayable());
            case 14:
                return java.lang.Long.valueOf(this.mPlayer.getCurrentPosition());
            case 15:
                return java.lang.Long.valueOf(this.mPlayer.getDuration());
            case 16:
                release();
                return null;
            case 17:
                this.mPlayer.reset();
                return null;
            case 18:
                this.mPlayer.setVolume(((java.lang.Float) objArr[0]).floatValue());
                return null;
            case 19:
                this.mPlayer.setAudioStreamType(((java.lang.Integer) objArr[0]).intValue());
                return null;
            case 20:
                return java.lang.Integer.valueOf(this.mPlayer.getAudioSessionId());
            case 21:
                return this.mPlayer.getMediaInfo();
            case 22:
                return this.mPlayer.getTrackInfo();
            case 23:
                this.mPlayer.setKeepInBackground(((java.lang.Boolean) objArr[0]).booleanValue());
                return null;
            case 24:
                return java.lang.Integer.valueOf(this.mPlayer.getVideoSarNum());
            case 25:
                return java.lang.Integer.valueOf(this.mPlayer.getVideoSarDen());
            case 26:
                this.mPlayer.setWakeMode(((java.lang.Integer) objArr[0]).intValue());
                return null;
            case 27:
                this.mPlayer.setLooping(((java.lang.Boolean) objArr[0]).booleanValue());
                return null;
            case 28:
                return java.lang.Boolean.valueOf(this.mPlayer.isLooping());
            case 29:
                this.mPlayer.setScreenOnWhilePlaying(((java.lang.Boolean) objArr[0]).booleanValue());
                return null;
            case 30:
                return java.lang.Integer.valueOf(this.mPlayer.getVideoWidth());
            case 31:
                return java.lang.Integer.valueOf(this.mPlayer.getVideoHeight());
            case 33:
                bindObservable((android.os.IBinder) objArr[0]);
            case 32:
                return null;
            case 34:
                com.oplus.tblplayer.remote.RemoteObservable remoteObservable = this.mObservable;
                if (remoteObservable != null) {
                    remoteObservable.setNotifyFlag(((java.lang.Integer) objArr[0]).intValue(), ((java.lang.Integer) objArr[1]).intValue());
                }
                return null;
            case 35:
                this.mPlayer.setSurface((android.view.Surface) objArr[0]);
                return null;
            case 36:
                return java.lang.Long.valueOf(this.mPlayer.getContentBufferedPosition());
            case 37:
                return java.lang.Boolean.valueOf(this.mPlayer.isPause());
            case 38:
                return java.lang.Boolean.valueOf(this.mPlayer.isStop());
            case 39:
                return java.lang.Float.valueOf(this.mPlayer.getSpeed());
            case 40:
                this.mPlayer.setNetworkType(((java.lang.Integer) objArr[0]).intValue());
            case 41:
                return java.lang.Long.valueOf(this.mPlayer.getBufferForPlaybackMs());
            case 42:
                return java.lang.Integer.valueOf(this.mPlayer.getPlaybackState());
            default:
                return super.onTransactInternal(i_renamed, objArr);
        }
    }

    private void bindObservable(android.os.IBinder iBinder) throws android.os.RemoteException {
        try {
            this.mObservable = new com.oplus.tblplayer.remote.RemoteObservable(iBinder);
            this.mObservable.asBinder().linkToDeath(this, 0);
            if (this.mPlayer != null) {
                this.mPlayer.setOnPreparedListener(this.mObservable);
                this.mPlayer.setOnCompletionListener(this.mObservable);
                this.mPlayer.setOnBufferingUpdateListener(this.mObservable);
                this.mPlayer.setOnSeekCompleteListener(this.mObservable);
                this.mPlayer.setOnVideoSizeChangedListener(this.mObservable);
                this.mPlayer.setOnErrorListener(this.mObservable);
                this.mPlayer.setOnInfoListener(this.mObservable);
                this.mPlayer.setOnTimedTextListener(this.mObservable);
                this.mPlayer.setOnPlaybackResultListener(this.mObservable);
                this.mPlayer.setOnPlayerEventListener(this.mObservable);
            }
        } catch (android.os.RemoteException e_renamed) {
            e_renamed.printStackTrace();
            release();
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "binderDied");
        release();
    }

    private synchronized void release() {
        handleRelease();
        if (this.mObservable != null) {
            this.mObservable.asBinder().unlinkToDeath(this, 0);
            this.mObservable = null;
        }
    }

    private void handleRelease() {
        execOnMainThread(new java.util.concurrent.Callable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$RemotePlayerStub$HoIjbusA-h_renamed-ZONrKq5KgG59Be8Q
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f_renamed$0.lambda$handleRelease$2$RemotePlayerStub();
            }
        });
    }

    public /* synthetic */ java.lang.Object lambda$handleRelease$2$RemotePlayerStub() throws java.lang.Exception {
        com.oplus.tblplayer.IMediaPlayer iMediaPlayer = this.mPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.release();
            this.mPlayer = null;
        }
        return null;
    }
}
