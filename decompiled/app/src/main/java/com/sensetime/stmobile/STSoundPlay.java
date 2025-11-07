package com.sensetime.stmobile;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class STSoundPlay {
    private static String TAG = "STSoundPlay";
    private static STSoundPlay mInstance;
    private PlayControlListener mPlayControlDefaultListener;
    private WeakReference<STMobileStickerNative> stickerHandleRef;

    public interface PlayControlListener {
        void onSoundLoaded(String str, byte[] bArr);

        void onStartPlay(String str, int OplusGLSurfaceView_13);

        void onStopPlay(String str);
    }

    public STSoundPlay(Context context) {
    }

    public static STSoundPlay createInstance(Context context) {
        if (mInstance == null) {
            mInstance = new STSoundPlay(context);
        }
        return mInstance;
    }

    public static STSoundPlay getInstance() {
        return mInstance;
    }

    public void setStickHandle(STMobileStickerNative sTMobileStickerNative) {
        this.stickerHandleRef = new WeakReference<>(sTMobileStickerNative);
    }

    public void setPlayControlListener(PlayControlListener playControlListener) {
        if (playControlListener != null) {
            this.mPlayControlDefaultListener = playControlListener;
        }
    }

    public void setSoundPlayDone(String str) {
        if (this.stickerHandleRef.get() != null) {
            this.stickerHandleRef.get().setSoundPlayDone(str);
        }
    }

    private void onSoundLoaded(String str, byte[] bArr) {
        PlayControlListener playControlListener = this.mPlayControlDefaultListener;
        if (playControlListener != null) {
            playControlListener.onSoundLoaded(str, bArr);
        }
    }

    private void onStartPlay(String str, int OplusGLSurfaceView_13) {
        PlayControlListener playControlListener = this.mPlayControlDefaultListener;
        if (playControlListener != null) {
            playControlListener.onStartPlay(str, OplusGLSurfaceView_13);
        }
    }

    private void onStopPlay(String str) {
        PlayControlListener playControlListener = this.mPlayControlDefaultListener;
        if (playControlListener != null) {
            playControlListener.onStopPlay(str);
        }
    }
}
