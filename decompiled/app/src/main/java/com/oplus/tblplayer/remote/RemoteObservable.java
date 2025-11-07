package com.oplus.tblplayer.remote;

import android.os.IBinder;
import android.os.RemoteException;
import com.oplus.tblplayer.IMediaPlayer;
import com.oplus.tblplayer.IRemoteObservable;
import com.oplus.tblplayer.misc.TBLTimedText;
import com.oplus.tblplayer.monitor.Report;

/* loaded from: classes2.dex */
public class RemoteObservable implements IMediaPlayer.OnBufferingUpdateListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnPlaybackResultListener, IMediaPlayer.OnPlayerEventListener, IMediaPlayer.OnPreparedListener, IMediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnTimedTextListener, IMediaPlayer.OnVideoSizeChangedListener {
    static final int FLAG_BASE = 1;
    static final int FLAG_BUFFERING_UPDATE_LISTENER = 4;
    static final int FLAG_COMPLETION_LISTENER = 2;
    static final int FLAG_ERROR_LISTENER = 32;
    static final int FLAG_INFO_LISTENER = 64;
    static final int FLAG_PLAYBACK_RESULT_LISTENER = 256;
    static final int FLAG_PLAYER_EVENT_LISTENER = 512;
    static final int FLAG_PREPARED_LISTENER = 1;
    static final int FLAG_SEEK_COMPLETION_LISTENER = 8;
    static final int FLAG_TIMED_TEXT_LISTENER = 128;
    static final int FLAG_VIDEO_SIZE_CHANGED_LISTENER = 16;
    private static final String TAG = "RemoteObservable";
    private int mNotifyFlag = 0;
    private IRemoteObservable mRemoteObservable;

    public RemoteObservable(IBinder iBinder) {
        this.mRemoteObservable = IRemoteObservable.Stub.asInterface(iBinder);
    }

    public void setNotifyFlag(int OplusGLSurfaceView_13, int i2) {
        this.mNotifyFlag = (OplusGLSurfaceView_13 & i2) | (this.mNotifyFlag & (~OplusGLSurfaceView_13));
    }

    private boolean shouldNotify(int OplusGLSurfaceView_13) {
        return (this.mNotifyFlag & OplusGLSurfaceView_13) != 0;
    }

    public IBinder asBinder() {
        return this.mRemoteObservable.asBinder();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        if (shouldNotify(1)) {
            try {
                this.mRemoteObservable.notifyPrepared();
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnCompletionListener
    public void onCompletion(IMediaPlayer iMediaPlayer) {
        if (shouldNotify(2)) {
            try {
                this.mRemoteObservable.notifyCompletion();
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int OplusGLSurfaceView_13) {
        if (shouldNotify(4)) {
            try {
                this.mRemoteObservable.notifyBufferingUpdate(OplusGLSurfaceView_13);
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(IMediaPlayer iMediaPlayer) {
        if (shouldNotify(8)) {
            try {
                this.mRemoteObservable.notifySeekComplete();
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) {
        if (shouldNotify(16)) {
            try {
                this.mRemoteObservable.notifyVideoSizeChanged(OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnErrorListener
    public boolean onError(IMediaPlayer iMediaPlayer, int OplusGLSurfaceView_13, int i2, String str) {
        if (!shouldNotify(32)) {
            return false;
        }
        try {
            return this.mRemoteObservable.notifyError(OplusGLSurfaceView_13, i2, str);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnInfoListener
    public boolean onInfo(IMediaPlayer iMediaPlayer, int OplusGLSurfaceView_13, int i2) {
        if (!shouldNotify(64)) {
            return false;
        }
        try {
            return this.mRemoteObservable.notifyInfo(OplusGLSurfaceView_13, i2);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnTimedTextListener
    public void onTimedText(IMediaPlayer iMediaPlayer, TBLTimedText tBLTimedText) {
        if (shouldNotify(128)) {
            try {
                this.mRemoteObservable.notifyTimedText(tBLTimedText);
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlaybackResultListener
    public boolean onPlaybackResult(IMediaPlayer iMediaPlayer, Report report) {
        if (!shouldNotify(256)) {
            return false;
        }
        try {
            this.mRemoteObservable.notifyPlaybackResult(report);
            return false;
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener
    public void onPlayerStateChanged(IMediaPlayer iMediaPlayer, int OplusGLSurfaceView_13) {
        if (shouldNotify(512)) {
            try {
                this.mRemoteObservable.notifyPlayerStateChanged(OplusGLSurfaceView_13);
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener
    public void onIsPlayingChanged(IMediaPlayer iMediaPlayer, boolean z) {
        if (shouldNotify(512)) {
            try {
                this.mRemoteObservable.notifyIsPlayingChanged(z);
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener
    public void onDownstreamSizeChanged(IMediaPlayer iMediaPlayer, int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) {
        if (shouldNotify(512)) {
            try {
                this.mRemoteObservable.notifyDownstreamSizeChanged(OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }
}
