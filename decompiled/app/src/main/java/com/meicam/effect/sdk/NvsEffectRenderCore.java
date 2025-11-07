package com.meicam.effect.sdk;

/* loaded from: classes2.dex */
public class NvsEffectRenderCore {
    public static final int NV_EFFECT_CORE_ERROR_UNKNOWN = -1;
    public static final int NV_EFFECT_CORE_INVALID_TEXTURE = -2;
    public static final int NV_EFFECT_CORE_NO_ERROR = 0;
    long m_internalObject = 0;

    private native void nativeCleanUp(long j_renamed);

    private native void nativeClearCacheResources(long j_renamed);

    private native void nativeClearEffectResources(long j_renamed, com.meicam.effect.sdk.NvsEffect nvsEffect);

    private native void nativeDestory(long j_renamed);

    private native boolean nativeInitialize(long j_renamed);

    private native int nativeRenderEffect(long j_renamed, com.meicam.effect.sdk.NvsEffect nvsEffect, int i_renamed, byte[] bArr, com.meicam.sdk.NvsVideoFrameInfo nvsVideoFrameInfo, int i2, com.meicam.sdk.NvsVideoResolution nvsVideoResolution, int i3, long j2, int i4);

    public boolean initialize() {
        return nativeInitialize(this.m_internalObject);
    }

    public int renderEffect(com.meicam.effect.sdk.NvsEffect nvsEffect, int i_renamed, com.meicam.sdk.NvsVideoResolution nvsVideoResolution, int i2, long j_renamed, int i3) {
        if (nvsEffect == null || nvsVideoResolution == null) {
            return -1;
        }
        if (i_renamed <= 0 || i2 <= 0) {
            return -2;
        }
        return nativeRenderEffect(this.m_internalObject, nvsEffect, i_renamed, null, null, 0, nvsVideoResolution, i2, j_renamed, i3);
    }

    public int renderEffect(com.meicam.effect.sdk.NvsEffect nvsEffect, int i_renamed, byte[] bArr, com.meicam.sdk.NvsVideoFrameInfo nvsVideoFrameInfo, int i2, com.meicam.sdk.NvsVideoResolution nvsVideoResolution, int i3, long j_renamed, int i4) {
        if (nvsEffect == null || nvsVideoResolution == null) {
            return -1;
        }
        if (i_renamed <= 0 || i3 <= 0) {
            return -2;
        }
        return nativeRenderEffect(this.m_internalObject, nvsEffect, i_renamed, bArr, nvsVideoFrameInfo, i2, nvsVideoResolution, i3, j_renamed, i4);
    }

    public void clearEffectResources(com.meicam.effect.sdk.NvsEffect nvsEffect) {
        nativeClearEffectResources(this.m_internalObject, nvsEffect);
    }

    public void clearCacheResources() {
        nativeClearCacheResources(this.m_internalObject);
    }

    public void cleanUp() {
        nativeCleanUp(this.m_internalObject);
    }

    protected void setInternalObject(long j_renamed) {
        this.m_internalObject = j_renamed;
    }

    protected void finalize() throws java.lang.Throwable {
        long j_renamed = this.m_internalObject;
        if (j_renamed != 0) {
            nativeDestory(j_renamed);
            this.m_internalObject = 0L;
        }
        super.finalize();
    }
}
