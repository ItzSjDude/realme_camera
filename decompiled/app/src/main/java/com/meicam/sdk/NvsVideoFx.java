package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsVideoFx extends com.meicam.sdk.NvsFx {
    public static final int VIDEOFX_TYPE_BUILTIN = 0;
    public static final int VIDEOFX_TYPE_CUSTOM = 2;
    public static final int VIDEOFX_TYPE_PACKAGE = 1;

    private native java.lang.String nativeGetBuiltinVideoFxName(long j_renamed);

    private native int nativeGetIndex(long j_renamed);

    private native java.lang.String nativeGetVideoFxPackageId(long j_renamed);

    private native int nativeGetVideoFxType(long j_renamed);

    private native android.graphics.PointF nativeMapPointFromCanonicalToParticleSystem(long j_renamed, android.graphics.PointF pointF);

    public int getVideoFxType() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoFxType(this.m_internalObject);
    }

    public int getIndex() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetIndex(this.m_internalObject);
    }

    public java.lang.String getBuiltinVideoFxName() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetBuiltinVideoFxName(this.m_internalObject);
    }

    public java.lang.String getVideoFxPackageId() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoFxPackageId(this.m_internalObject);
    }

    public android.graphics.PointF mapPointFromCanonicalToParticleSystem(android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeMapPointFromCanonicalToParticleSystem(this.m_internalObject, pointF);
    }
}
