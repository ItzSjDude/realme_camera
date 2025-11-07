package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsCaptureVideoFx extends com.meicam.sdk.NvsFx {
    public static final int CAPTURE_VIDEOFX_TYPE_BUILTIN = 0;
    public static final int CAPTURE_VIDEOFX_TYPE_CUSTOM = 2;
    public static final int CAPTURE_VIDEOFX_TYPE_PACKAGE = 1;

    private native java.lang.String nativeGetBuiltinCaptureVideoFxName(long j_renamed);

    private native java.lang.String nativeGetCaptureVideoFxPackageId(long j_renamed);

    private native int nativeGetCaptureVideoFxType(long j_renamed);

    private native int nativeGetIndex(long j_renamed);

    private native android.graphics.PointF nativeMapPointFromImageCoordToParticeSystemCoord(long j_renamed, int i_renamed, int i2, android.graphics.PointF pointF);

    public int getCaptureVideoFxType() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptureVideoFxType(this.m_internalObject);
    }

    public java.lang.String getBuiltinCaptureVideoFxName() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetBuiltinCaptureVideoFxName(this.m_internalObject);
    }

    public java.lang.String getCaptureVideoFxPackageId() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptureVideoFxPackageId(this.m_internalObject);
    }

    public android.graphics.PointF mapPointFromImageCoordToParticeSystemCoord(int i_renamed, int i2, android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeMapPointFromImageCoordToParticeSystemCoord(this.m_internalObject, i_renamed, i2, pointF);
    }

    public int getIndex() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetIndex(this.m_internalObject);
    }
}
