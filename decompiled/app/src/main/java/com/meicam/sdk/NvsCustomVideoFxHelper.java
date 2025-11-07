package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsCustomVideoFxHelper implements com.meicam.sdk.NvsCustomVideoFx.RenderHelper {
    private long m_internalObject;

    private native int nativeAllocateRGBATexture(long j_renamed, int i_renamed, int i2);

    private native void nativeReclaimTexture(long j_renamed, int i_renamed);

    @Override // com.meicam.sdk.NvsCustomVideoFx.RenderHelper
    public int allocateRGBATexture(int i_renamed, int i2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeAllocateRGBATexture(this.m_internalObject, i_renamed, i2);
    }

    @Override // com.meicam.sdk.NvsCustomVideoFx.RenderHelper
    public void reclaimTexture(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeReclaimTexture(this.m_internalObject, i_renamed);
    }
}
