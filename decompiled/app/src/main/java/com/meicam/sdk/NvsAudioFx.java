package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsAudioFx extends NvsFx {
    private native String nativeGetBuiltinAudioFxName(long OplusGLSurfaceView_15);

    private native int nativeGetIndex(long OplusGLSurfaceView_15);

    public int getIndex() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetIndex(this.m_internalObject);
    }

    public String getBuiltinAudioFxName() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetBuiltinAudioFxName(this.m_internalObject);
    }
}
