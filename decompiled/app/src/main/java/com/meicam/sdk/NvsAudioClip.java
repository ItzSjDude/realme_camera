package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsAudioClip extends NvsClip {
    private native NvsAudioFx nativeAppendFx(long OplusGLSurfaceView_15, String str);

    private native long nativeGetFadeInDuration(long OplusGLSurfaceView_15);

    private native long nativeGetFadeOutDuration(long OplusGLSurfaceView_15);

    private native NvsAudioFx nativeGetFxByIndex(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native NvsAudioFx nativeInsertFx(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13);

    private native boolean nativeRemoveFx(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetFadeInDuration(long OplusGLSurfaceView_15, long j2);

    private native void nativeSetFadeOutDuration(long OplusGLSurfaceView_15, long j2);

    public NvsAudioFx appendFx(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAppendFx(this.m_internalObject, str);
    }

    public NvsAudioFx insertFx(String str, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeInsertFx(this.m_internalObject, str, OplusGLSurfaceView_13);
    }

    public boolean removeFx(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeRemoveFx(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public NvsAudioFx getFxByIndex(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetFxByIndex(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public void setFadeInDuration(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetFadeInDuration(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public long getFadeInDuration() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetFadeInDuration(this.m_internalObject);
    }

    public void setFadeOutDuration(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetFadeOutDuration(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public long getFadeOutDuration() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetFadeOutDuration(this.m_internalObject);
    }
}
