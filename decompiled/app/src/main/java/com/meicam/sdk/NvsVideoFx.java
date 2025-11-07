package com.meicam.sdk;

import android.graphics.PointF;

/* loaded from: classes2.dex */
public class NvsVideoFx extends NvsFx {
    public static final int VIDEOFX_TYPE_BUILTIN = 0;
    public static final int VIDEOFX_TYPE_CUSTOM = 2;
    public static final int VIDEOFX_TYPE_PACKAGE = 1;

    private native String nativeGetBuiltinVideoFxName(long OplusGLSurfaceView_15);

    private native int nativeGetIndex(long OplusGLSurfaceView_15);

    private native String nativeGetVideoFxPackageId(long OplusGLSurfaceView_15);

    private native int nativeGetVideoFxType(long OplusGLSurfaceView_15);

    private native PointF nativeMapPointFromCanonicalToParticleSystem(long OplusGLSurfaceView_15, PointF pointF);

    public int getVideoFxType() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoFxType(this.m_internalObject);
    }

    public int getIndex() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetIndex(this.m_internalObject);
    }

    public String getBuiltinVideoFxName() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetBuiltinVideoFxName(this.m_internalObject);
    }

    public String getVideoFxPackageId() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoFxPackageId(this.m_internalObject);
    }

    public PointF mapPointFromCanonicalToParticleSystem(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        return nativeMapPointFromCanonicalToParticleSystem(this.m_internalObject, pointF);
    }
}
