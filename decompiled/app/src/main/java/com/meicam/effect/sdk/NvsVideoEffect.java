package com.meicam.effect.sdk;

/* loaded from: classes2.dex */
public class NvsVideoEffect extends com.meicam.effect.sdk.NvsEffect {
    public static final int VIDEOFX_TYPE_BUILTIN = 0;
    public static final int VIDEOFX_TYPE_CUSTOM = 2;
    public static final int VIDEOFX_TYPE_PACKAGE = 1;

    private native java.lang.String nativeGetBuiltinVideoFxName(long j_renamed);

    private native java.lang.String nativeGetVideoFxPackageId(long j_renamed);

    private native int nativeGetVideoFxType(long j_renamed);

    private native android.graphics.PointF nativeMapPointFromCanonicalToParticleSystem(long j_renamed, com.meicam.sdk.NvsVideoResolution nvsVideoResolution, android.graphics.PointF pointF);

    public int getVideoFxType() {
        return nativeGetVideoFxType(this.m_internalObject);
    }

    public java.lang.String getBuiltinVideoFxName() {
        return nativeGetBuiltinVideoFxName(this.m_internalObject);
    }

    public java.lang.String getVideoFxPackageId() {
        return nativeGetVideoFxPackageId(this.m_internalObject);
    }

    public android.graphics.PointF mapPointFromCanonicalToParticleSystem(com.meicam.sdk.NvsVideoResolution nvsVideoResolution, android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeMapPointFromCanonicalToParticleSystem(this.m_internalObject, nvsVideoResolution, pointF);
    }
}
