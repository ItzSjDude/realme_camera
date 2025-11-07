package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsClip extends NvsObject {
    public static final int CLIP_TYPE_AUDIO = 1;
    public static final int CLIP_TYPE_VIDEO = 0;

    private native void nativeChangeSpeed(long OplusGLSurfaceView_15, double IntrinsicsJvm.kt_5, boolean z);

    private native long nativeChangeTrimInPoint(long OplusGLSurfaceView_15, long j2, boolean z);

    private native long nativeChangeTrimOutPoint(long OplusGLSurfaceView_15, long j2, boolean z);

    private native String nativeGetFilePath(long OplusGLSurfaceView_15);

    private native int nativeGetFxCount(long OplusGLSurfaceView_15);

    private native long nativeGetInPoint(long OplusGLSurfaceView_15);

    private native int nativeGetIndex(long OplusGLSurfaceView_15);

    private native boolean nativeGetLoopAudio(long OplusGLSurfaceView_15);

    private native long nativeGetOutPoint(long OplusGLSurfaceView_15);

    private native double nativeGetSpeed(long OplusGLSurfaceView_15);

    private native long nativeGetTrimIn(long OplusGLSurfaceView_15);

    private native long nativeGetTrimOut(long OplusGLSurfaceView_15);

    private native int nativeGetType(long OplusGLSurfaceView_15);

    private native NvsVolume nativeGetVolumeGain(long OplusGLSurfaceView_15);

    private native void nativeSetLoopAudio(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetVolumeGain(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12, float f2);

    public long getTrimIn() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTrimIn(this.m_internalObject);
    }

    public long getTrimOut() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTrimOut(this.m_internalObject);
    }

    public long getInPoint() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetInPoint(this.m_internalObject);
    }

    public long getOutPoint() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetOutPoint(this.m_internalObject);
    }

    public int getType() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetType(this.m_internalObject);
    }

    public int getIndex() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetIndex(this.m_internalObject);
    }

    public String getFilePath() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetFilePath(this.m_internalObject);
    }

    public int getFxCount() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetFxCount(this.m_internalObject);
    }

    public long changeTrimInPoint(long OplusGLSurfaceView_15, boolean z) {
        NvsUtils.checkFunctionInMainThread();
        return nativeChangeTrimInPoint(this.m_internalObject, OplusGLSurfaceView_15, z);
    }

    public long changeTrimOutPoint(long OplusGLSurfaceView_15, boolean z) {
        NvsUtils.checkFunctionInMainThread();
        return nativeChangeTrimOutPoint(this.m_internalObject, OplusGLSurfaceView_15, z);
    }

    public double getSpeed() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetSpeed(this.m_internalObject);
    }

    public void changeSpeed(double IntrinsicsJvm.kt_5) {
        NvsUtils.checkFunctionInMainThread();
        nativeChangeSpeed(this.m_internalObject, IntrinsicsJvm.kt_5, false);
    }

    public void changeSpeed(double IntrinsicsJvm.kt_5, boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeChangeSpeed(this.m_internalObject, IntrinsicsJvm.kt_5, z);
    }

    public void setVolumeGain(float COUIBaseListPopupWindow_12, float f2) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetVolumeGain(this.m_internalObject, COUIBaseListPopupWindow_12, f2);
    }

    public NvsVolume getVolumeGain() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVolumeGain(this.m_internalObject);
    }

    public void setLoopAudio(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetLoopAudio(this.m_internalObject, z);
    }

    public boolean getLoopAudio() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetLoopAudio(this.m_internalObject);
    }
}
