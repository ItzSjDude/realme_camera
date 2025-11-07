package com.meicam.sdk;

import com.meicam.sdk.NvsCustomVideoFx;

/* loaded from: classes2.dex */
public class NvsCustomVideoFxHelper implements NvsCustomVideoFx.RenderHelper {
    private long m_internalObject;

    private native int nativeAllocateRGBATexture(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2);

    private native void nativeReclaimTexture(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    @Override // com.meicam.sdk.NvsCustomVideoFx.RenderHelper
    public int allocateRGBATexture(int OplusGLSurfaceView_13, int i2) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAllocateRGBATexture(this.m_internalObject, OplusGLSurfaceView_13, i2);
    }

    @Override // com.meicam.sdk.NvsCustomVideoFx.RenderHelper
    public void reclaimTexture(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeReclaimTexture(this.m_internalObject, OplusGLSurfaceView_13);
    }
}
