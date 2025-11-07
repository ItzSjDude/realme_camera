package com.oplus.tblplayer.remote;

/* loaded from: classes2.dex */
public class RemoteObservable implements com.oplus.tblplayer.IMediaPlayer.OnBufferingUpdateListener, com.oplus.tblplayer.IMediaPlayer.OnCompletionListener, com.oplus.tblplayer.IMediaPlayer.OnErrorListener, com.oplus.tblplayer.IMediaPlayer.OnInfoListener, com.oplus.tblplayer.IMediaPlayer.OnPlaybackResultListener, com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener, com.oplus.tblplayer.IMediaPlayer.OnPreparedListener, com.oplus.tblplayer.IMediaPlayer.OnSeekCompleteListener, com.oplus.tblplayer.IMediaPlayer.OnTimedTextListener, com.oplus.tblplayer.IMediaPlayer.OnVideoSizeChangedListener {
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
    private static final java.lang.String TAG = "RemoteObservable";
    private int mNotifyFlag = 0;
    private com.oplus.tblplayer.IRemoteObservable mRemoteObservable;

    public RemoteObservable(android.os.IBinder iBinder) {
        this.mRemoteObservable = com.oplus.tblplayer.IRemoteObservable.Stub.asInterface(iBinder);
    }

    public void setNotifyFlag(int i_renamed, int i2) {
        this.mNotifyFlag = (i_renamed & i2) | (this.mNotifyFlag & (~i_renamed));
    }

    private boolean shouldNotify(int i_renamed) {
        return (this.mNotifyFlag & i_renamed) != 0;
    }

    public android.os.IBinder asBinder() {
        return this.mRemoteObservable.asBinder();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPreparedListener
    public void onPrepared(com.oplus.tblplayer.IMediaPlayer iMediaPlayer) {
        if (shouldNotify(1)) {
            try {
                this.mRemoteObservable.notifyPrepared();
            } catch (android.os.RemoteException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnCompletionListener
    public void onCompletion(com.oplus.tblplayer.IMediaPlayer iMediaPlayer) {
        if (shouldNotify(2)) {
            try {
                this.mRemoteObservable.notifyCompletion();
            } catch (android.os.RemoteException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, int i_renamed) {
        if (shouldNotify(4)) {
            try {
                this.mRemoteObservable.notifyBufferingUpdate(i_renamed);
            } catch (android.os.RemoteException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(com.oplus.tblplayer.IMediaPlayer iMediaPlayer) {
        if (shouldNotify(8)) {
            try {
                this.mRemoteObservable.notifySeekComplete();
            } catch (android.os.RemoteException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, int i_renamed, int i2, int i3, float f_renamed) {
        if (shouldNotify(16)) {
            try {
                this.mRemoteObservable.notifyVideoSizeChanged(i_renamed, i2, i3, f_renamed);
            } catch (android.os.RemoteException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnErrorListener
    public boolean onError(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, int i_renamed, int i2, java.lang.String str) {
        if (!shouldNotify(32)) {
            return false;
        }
        try {
            return this.mRemoteObservable.notifyError(i_renamed, i2, str);
        } catch (android.os.RemoteException e_renamed) {
            e_renamed.printStackTrace();
            return false;
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnInfoListener
    public boolean onInfo(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, int i_renamed, int i2) {
        if (!shouldNotify(64)) {
            return false;
        }
        try {
            return this.mRemoteObservable.notifyInfo(i_renamed, i2);
        } catch (android.os.RemoteException e_renamed) {
            e_renamed.printStackTrace();
            return false;
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnTimedTextListener
    public void onTimedText(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, com.oplus.tblplayer.misc.TBLTimedText tBLTimedText) {
        if (shouldNotify(128)) {
            try {
                this.mRemoteObservable.notifyTimedText(tBLTimedText);
            } catch (android.os.RemoteException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlaybackResultListener
    public boolean onPlaybackResult(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, com.oplus.tblplayer.monitor.Report report) {
        if (!shouldNotify(256)) {
            return false;
        }
        try {
            this.mRemoteObservable.notifyPlaybackResult(report);
            return false;
        } catch (android.os.RemoteException e_renamed) {
            e_renamed.printStackTrace();
            return false;
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener
    public void onPlayerStateChanged(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, int i_renamed) {
        if (shouldNotify(512)) {
            try {
                this.mRemoteObservable.notifyPlayerStateChanged(i_renamed);
            } catch (android.os.RemoteException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener
    public void onIsPlayingChanged(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, boolean z_renamed) {
        if (shouldNotify(512)) {
            try {
                this.mRemoteObservable.notifyIsPlayingChanged(z_renamed);
            } catch (android.os.RemoteException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener
    public void onDownstreamSizeChanged(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, int i_renamed, int i2, int i3, float f_renamed) {
        if (shouldNotify(512)) {
            try {
                this.mRemoteObservable.notifyDownstreamSizeChanged(i_renamed, i2, i3, f_renamed);
            } catch (android.os.RemoteException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }
}
