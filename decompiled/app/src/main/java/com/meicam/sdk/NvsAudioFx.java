package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsAudioFx extends com.meicam.sdk.NvsFx {
    private native java.lang.String nativeGetBuiltinAudioFxName(long j_renamed);

    private native int nativeGetIndex(long j_renamed);

    public int getIndex() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetIndex(this.m_internalObject);
    }

    public java.lang.String getBuiltinAudioFxName() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetBuiltinAudioFxName(this.m_internalObject);
    }
}
