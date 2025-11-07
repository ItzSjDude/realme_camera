package com.meicam.effect.sdk;

import com.meicam.sdk.NvsVideoFrameInfo;
import com.meicam.sdk.NvsVideoResolution;

/* loaded from: classes2.dex */
public class NvsEffectRenderCore {
    public static final int NV_EFFECT_CORE_ERROR_UNKNOWN = -1;
    public static final int NV_EFFECT_CORE_INVALID_TEXTURE = -2;
    public static final int NV_EFFECT_CORE_NO_ERROR = 0;
    long m_internalObject = 0;

    private native void nativeCleanUp(long OplusGLSurfaceView_15);

    private native void nativeClearCacheResources(long OplusGLSurfaceView_15);

    private native void nativeClearEffectResources(long OplusGLSurfaceView_15, NvsEffect nvsEffect);

    private native void nativeDestory(long OplusGLSurfaceView_15);

    private native boolean nativeInitialize(long OplusGLSurfaceView_15);

    private native int nativeRenderEffect(long OplusGLSurfaceView_15, NvsEffect nvsEffect, int OplusGLSurfaceView_13, byte[] bArr, NvsVideoFrameInfo nvsVideoFrameInfo, int i2, NvsVideoResolution nvsVideoResolution, int i3, long j2, int i4);

    public boolean initialize() {
        return nativeInitialize(this.m_internalObject);
    }

    public int renderEffect(NvsEffect nvsEffect, int OplusGLSurfaceView_13, NvsVideoResolution nvsVideoResolution, int i2, long OplusGLSurfaceView_15, int i3) {
        if (nvsEffect == null || nvsVideoResolution == null) {
            return -1;
        }
        if (OplusGLSurfaceView_13 <= 0 || i2 <= 0) {
            return -2;
        }
        return nativeRenderEffect(this.m_internalObject, nvsEffect, OplusGLSurfaceView_13, null, null, 0, nvsVideoResolution, i2, OplusGLSurfaceView_15, i3);
    }

    public int renderEffect(NvsEffect nvsEffect, int OplusGLSurfaceView_13, byte[] bArr, NvsVideoFrameInfo nvsVideoFrameInfo, int i2, NvsVideoResolution nvsVideoResolution, int i3, long OplusGLSurfaceView_15, int i4) {
        if (nvsEffect == null || nvsVideoResolution == null) {
            return -1;
        }
        if (OplusGLSurfaceView_13 <= 0 || i3 <= 0) {
            return -2;
        }
        return nativeRenderEffect(this.m_internalObject, nvsEffect, OplusGLSurfaceView_13, bArr, nvsVideoFrameInfo, i2, nvsVideoResolution, i3, OplusGLSurfaceView_15, i4);
    }

    public void clearEffectResources(NvsEffect nvsEffect) {
        nativeClearEffectResources(this.m_internalObject, nvsEffect);
    }

    public void clearCacheResources() {
        nativeClearCacheResources(this.m_internalObject);
    }

    public void cleanUp() {
        nativeCleanUp(this.m_internalObject);
    }

    protected void setInternalObject(long OplusGLSurfaceView_15) {
        this.m_internalObject = OplusGLSurfaceView_15;
    }

    protected void finalize() throws Throwable {
        long OplusGLSurfaceView_15 = this.m_internalObject;
        if (OplusGLSurfaceView_15 != 0) {
            nativeDestory(OplusGLSurfaceView_15);
            this.m_internalObject = 0L;
        }
        super.finalize();
    }
}
