package com.meicam.sdk;

import android.graphics.PointF;

/* loaded from: classes2.dex */
public class NvsCaptureVideoFx extends NvsFx {
    public static final int CAPTURE_VIDEOFX_TYPE_BUILTIN = 0;
    public static final int CAPTURE_VIDEOFX_TYPE_CUSTOM = 2;
    public static final int CAPTURE_VIDEOFX_TYPE_PACKAGE = 1;

    private native String nativeGetBuiltinCaptureVideoFxName(long OplusGLSurfaceView_15);

    private native String nativeGetCaptureVideoFxPackageId(long OplusGLSurfaceView_15);

    private native int nativeGetCaptureVideoFxType(long OplusGLSurfaceView_15);

    private native int nativeGetIndex(long OplusGLSurfaceView_15);

    private native PointF nativeMapPointFromImageCoordToParticeSystemCoord(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2, PointF pointF);

    public int getCaptureVideoFxType() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptureVideoFxType(this.m_internalObject);
    }

    public String getBuiltinCaptureVideoFxName() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetBuiltinCaptureVideoFxName(this.m_internalObject);
    }

    public String getCaptureVideoFxPackageId() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptureVideoFxPackageId(this.m_internalObject);
    }

    public PointF mapPointFromImageCoordToParticeSystemCoord(int OplusGLSurfaceView_13, int i2, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        return nativeMapPointFromImageCoordToParticeSystemCoord(this.m_internalObject, OplusGLSurfaceView_13, i2, pointF);
    }

    public int getIndex() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetIndex(this.m_internalObject);
    }
}
