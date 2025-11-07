package com.oplus.tblplayer.remote;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.Surface;
import com.oplus.tblplayer.IMediaPlayer;
import com.oplus.tblplayer.TBLExoPlayer;
import com.oplus.tblplayer.misc.IMediaDataSource;
import com.oplus.tblplayer.utils.LogUtil;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* loaded from: classes2.dex */
public class RemotePlayerStub extends BaseBinderStub implements IBinder.DeathRecipient, IInterface {
    private static final String TAG = "RemotePlayerStub";
    private Context mAppContext;
    private Handler mMainThreadHandler;
    private RemoteObservable mObservable;
    private IMediaPlayer mPlayer;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public RemotePlayerStub(Context context) {
        attachInterface(this, "RemotePlayer");
        this.mAppContext = context.getApplicationContext();
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        this.mPlayer = (IMediaPlayer) execOnMainThread(new Callable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$RemotePlayerStub$XnwS30IcKjJqn_c6JAPwvBVCom4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.COUIBaseListPopupWindow_12$0.lambda$new$0$RemotePlayerStub();
            }
        });
    }

    public /* synthetic */ IMediaPlayer lambda$new$0$RemotePlayerStub() throws Exception {
        return new TBLExoPlayer(this.mAppContext);
    }

    private <T> T execOnMainThread(Callable<T> callable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                return callable.call();
            } catch (Exception COUIBaseListPopupWindow_8) {
                throw new RuntimeException(COUIBaseListPopupWindow_8);
            }
        }
        FutureTask futureTask = new FutureTask(callable);
        this.mMainThreadHandler.post(futureTask);
        try {
            return (T) futureTask.get();
        } catch (InterruptedException | ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.oplus.tblplayer.remote.BaseBinderStub
    protected Object onTransactInternal(final int OplusGLSurfaceView_13, final Object... objArr) throws IOException {
        return execOnMainThread(new Callable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$RemotePlayerStub$FnqDF7GbBhsGjSFXpzU2AjGeW2c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.COUIBaseListPopupWindow_12$0.lambda$onTransactInternal$1$RemotePlayerStub(OplusGLSurfaceView_13, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: execTransact, reason: merged with bridge method [inline-methods] */
    public Object lambda$onTransactInternal$1$RemotePlayerStub(int OplusGLSurfaceView_13, Object... objArr) throws IllegalStateException, RemoteException, IOException, SecurityException, IllegalArgumentException {
        switch (OplusGLSurfaceView_13) {
            case 1:
                this.mPlayer.setDataSource((String) objArr[0]);
                return null;
            case 2:
                this.mPlayer.setDataSource((Uri) objArr[0]);
                return null;
            case 3:
                this.mPlayer.setDataSource((Uri) objArr[0], (Map) objArr[1]);
                return null;
            case 4:
                this.mPlayer.setDataSource((IMediaDataSource) objArr[0]);
                return null;
            case 5:
                this.mPlayer.setDataSource(((ParcelFileDescriptor) objArr[0]).getFileDescriptor());
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
                this.mPlayer.seekTo(((Long) objArr[0]).longValue());
                return null;
            case 12:
                return Boolean.valueOf(this.mPlayer.isPlaying());
            case 13:
                return Boolean.valueOf(this.mPlayer.isPlayable());
            case 14:
                return Long.valueOf(this.mPlayer.getCurrentPosition());
            case 15:
                return Long.valueOf(this.mPlayer.getDuration());
            case 16:
                release();
                return null;
            case 17:
                this.mPlayer.reset();
                return null;
            case 18:
                this.mPlayer.setVolume(((Float) objArr[0]).floatValue());
                return null;
            case 19:
                this.mPlayer.setAudioStreamType(((Integer) objArr[0]).intValue());
                return null;
            case 20:
                return Integer.valueOf(this.mPlayer.getAudioSessionId());
            case 21:
                return this.mPlayer.getMediaInfo();
            case 22:
                return this.mPlayer.getTrackInfo();
            case 23:
                this.mPlayer.setKeepInBackground(((Boolean) objArr[0]).booleanValue());
                return null;
            case 24:
                return Integer.valueOf(this.mPlayer.getVideoSarNum());
            case 25:
                return Integer.valueOf(this.mPlayer.getVideoSarDen());
            case 26:
                this.mPlayer.setWakeMode(((Integer) objArr[0]).intValue());
                return null;
            case 27:
                this.mPlayer.setLooping(((Boolean) objArr[0]).booleanValue());
                return null;
            case 28:
                return Boolean.valueOf(this.mPlayer.isLooping());
            case 29:
                this.mPlayer.setScreenOnWhilePlaying(((Boolean) objArr[0]).booleanValue());
                return null;
            case 30:
                return Integer.valueOf(this.mPlayer.getVideoWidth());
            case 31:
                return Integer.valueOf(this.mPlayer.getVideoHeight());
            case 33:
                bindObservable((IBinder) objArr[0]);
            case 32:
                return null;
            case 34:
                RemoteObservable remoteObservable = this.mObservable;
                if (remoteObservable != null) {
                    remoteObservable.setNotifyFlag(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                }
                return null;
            case 35:
                this.mPlayer.setSurface((Surface) objArr[0]);
                return null;
            case 36:
                return Long.valueOf(this.mPlayer.getContentBufferedPosition());
            case 37:
                return Boolean.valueOf(this.mPlayer.isPause());
            case 38:
                return Boolean.valueOf(this.mPlayer.isStop());
            case 39:
                return Float.valueOf(this.mPlayer.getSpeed());
            case 40:
                this.mPlayer.setNetworkType(((Integer) objArr[0]).intValue());
            case 41:
                return Long.valueOf(this.mPlayer.getBufferForPlaybackMs());
            case 42:
                return Integer.valueOf(this.mPlayer.getPlaybackState());
            default:
                return super.onTransactInternal(OplusGLSurfaceView_13, objArr);
        }
    }

    private void bindObservable(IBinder iBinder) throws RemoteException {
        try {
            this.mObservable = new RemoteObservable(iBinder);
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
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            release();
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        LogUtil.m25450d(TAG, "binderDied");
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
        execOnMainThread(new Callable() { // from class: com.oplus.tblplayer.remote.-$$Lambda$RemotePlayerStub$HoIjbusA-COUIBaseListPopupWindow_10-ZONrKq5KgG59Be8Q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.COUIBaseListPopupWindow_12$0.lambda$handleRelease$2$RemotePlayerStub();
            }
        });
    }

    public /* synthetic */ Object lambda$handleRelease$2$RemotePlayerStub() throws Exception {
        IMediaPlayer iMediaPlayer = this.mPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.release();
            this.mPlayer = null;
        }
        return null;
    }
}
