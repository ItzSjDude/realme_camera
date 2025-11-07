package com.meicam.sdk;

import android.graphics.PointF;

/* loaded from: classes2.dex */
public class NvsTimelineVideoFx extends NvsFx {
    public static final int TIMELINE_VIDEOFX_TYPE_BUILTIN = 0;
    public static final int TIMELINE_VIDEOFX_TYPE_CUSTOM = 2;
    public static final int TIMELINE_VIDEOFX_TYPE_PACKAGE = 1;

    private native long nativeChangeInPoint(long OplusGLSurfaceView_15, long j2);

    private native long nativeChangeOutPoint(long OplusGLSurfaceView_15, long j2);

    private native String nativeGetBuiltinTimelineVideoFxName(long OplusGLSurfaceView_15);

    private native long nativeGetInPoint(long OplusGLSurfaceView_15);

    private native long nativeGetOutPoint(long OplusGLSurfaceView_15);

    private native String nativeGetTimelineVideoFxPackageId(long OplusGLSurfaceView_15);

    private native int nativeGetTimelineVideoFxType(long OplusGLSurfaceView_15);

    private native PointF nativeMapPointFromCanonicalToParticleSystem(long OplusGLSurfaceView_15, PointF pointF);

    private native void nativeMovePosition(long OplusGLSurfaceView_15, long j2);

    public int getTimelineVideoFxType() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTimelineVideoFxType(this.m_internalObject);
    }

    public String getBuiltinTimelineVideoFxName() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetBuiltinTimelineVideoFxName(this.m_internalObject);
    }

    public String getTimelineVideoFxPackageId() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTimelineVideoFxPackageId(this.m_internalObject);
    }

    public long getInPoint() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetInPoint(this.m_internalObject);
    }

    public long getOutPoint() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetOutPoint(this.m_internalObject);
    }

    public long changeInPoint(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeChangeInPoint(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public long changeOutPoint(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeChangeOutPoint(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public void movePosition(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        nativeMovePosition(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public PointF mapPointFromCanonicalToParticleSystem(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        return nativeMapPointFromCanonicalToParticleSystem(this.m_internalObject, pointF);
    }
}
