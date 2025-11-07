package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsTimelineVideoFx extends com.meicam.sdk.NvsFx {
    public static final int TIMELINE_VIDEOFX_TYPE_BUILTIN = 0;
    public static final int TIMELINE_VIDEOFX_TYPE_CUSTOM = 2;
    public static final int TIMELINE_VIDEOFX_TYPE_PACKAGE = 1;

    private native long nativeChangeInPoint(long j_renamed, long j2);

    private native long nativeChangeOutPoint(long j_renamed, long j2);

    private native java.lang.String nativeGetBuiltinTimelineVideoFxName(long j_renamed);

    private native long nativeGetInPoint(long j_renamed);

    private native long nativeGetOutPoint(long j_renamed);

    private native java.lang.String nativeGetTimelineVideoFxPackageId(long j_renamed);

    private native int nativeGetTimelineVideoFxType(long j_renamed);

    private native android.graphics.PointF nativeMapPointFromCanonicalToParticleSystem(long j_renamed, android.graphics.PointF pointF);

    private native void nativeMovePosition(long j_renamed, long j2);

    public int getTimelineVideoFxType() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTimelineVideoFxType(this.m_internalObject);
    }

    public java.lang.String getBuiltinTimelineVideoFxName() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetBuiltinTimelineVideoFxName(this.m_internalObject);
    }

    public java.lang.String getTimelineVideoFxPackageId() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTimelineVideoFxPackageId(this.m_internalObject);
    }

    public long getInPoint() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetInPoint(this.m_internalObject);
    }

    public long getOutPoint() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetOutPoint(this.m_internalObject);
    }

    public long changeInPoint(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeChangeInPoint(this.m_internalObject, j_renamed);
    }

    public long changeOutPoint(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeChangeOutPoint(this.m_internalObject, j_renamed);
    }

    public void movePosition(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeMovePosition(this.m_internalObject, j_renamed);
    }

    public android.graphics.PointF mapPointFromCanonicalToParticleSystem(android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeMapPointFromCanonicalToParticleSystem(this.m_internalObject, pointF);
    }
}
