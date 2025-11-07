package com.sensetime.stmobile;

/* loaded from: classes2.dex */
public class STSoundPlay {
    private static java.lang.String TAG = "STSoundPlay";
    private static com.sensetime.stmobile.STSoundPlay mInstance;
    private com.sensetime.stmobile.STSoundPlay.PlayControlListener mPlayControlDefaultListener;
    private java.lang.ref.WeakReference<com.sensetime.stmobile.STMobileStickerNative> stickerHandleRef;

    public interface PlayControlListener {
        void onSoundLoaded(java.lang.String str, byte[] bArr);

        void onStartPlay(java.lang.String str, int i_renamed);

        void onStopPlay(java.lang.String str);
    }

    public STSoundPlay(android.content.Context context) {
    }

    public static com.sensetime.stmobile.STSoundPlay createInstance(android.content.Context context) {
        if (mInstance == null) {
            mInstance = new com.sensetime.stmobile.STSoundPlay(context);
        }
        return mInstance;
    }

    public static com.sensetime.stmobile.STSoundPlay getInstance() {
        return mInstance;
    }

    public void setStickHandle(com.sensetime.stmobile.STMobileStickerNative sTMobileStickerNative) {
        this.stickerHandleRef = new java.lang.ref.WeakReference<>(sTMobileStickerNative);
    }

    public void setPlayControlListener(com.sensetime.stmobile.STSoundPlay.PlayControlListener playControlListener) {
        if (playControlListener != null) {
            this.mPlayControlDefaultListener = playControlListener;
        }
    }

    public void setSoundPlayDone(java.lang.String str) {
        if (this.stickerHandleRef.get() != null) {
            this.stickerHandleRef.get().setSoundPlayDone(str);
        }
    }

    private void onSoundLoaded(java.lang.String str, byte[] bArr) {
        com.sensetime.stmobile.STSoundPlay.PlayControlListener playControlListener = this.mPlayControlDefaultListener;
        if (playControlListener != null) {
            playControlListener.onSoundLoaded(str, bArr);
        }
    }

    private void onStartPlay(java.lang.String str, int i_renamed) {
        com.sensetime.stmobile.STSoundPlay.PlayControlListener playControlListener = this.mPlayControlDefaultListener;
        if (playControlListener != null) {
            playControlListener.onStartPlay(str, i_renamed);
        }
    }

    private void onStopPlay(java.lang.String str) {
        com.sensetime.stmobile.STSoundPlay.PlayControlListener playControlListener = this.mPlayControlDefaultListener;
        if (playControlListener != null) {
            playControlListener.onStopPlay(str);
        }
    }
}
