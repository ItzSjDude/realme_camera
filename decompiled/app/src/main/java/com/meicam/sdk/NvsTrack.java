package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsTrack extends NvsObject {
    public static final int TRACK_TYPE_AUDIO = 1;
    public static final int TRACK_TYPE_VIDEO = 0;

    private native long nativeChangeInPoint(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, long j2);

    private native long nativeChangeOutPoint(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, long j2);

    private native int nativeGetClipCount(long OplusGLSurfaceView_15);

    private native long nativeGetDuration(long OplusGLSurfaceView_15);

    private native int nativeGetIndex(long OplusGLSurfaceView_15);

    private native int nativeGetType(long OplusGLSurfaceView_15);

    private native NvsVolume nativeGetVolumeGain(long OplusGLSurfaceView_15);

    private native boolean nativeMoveClip(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2);

    private native boolean nativeRemoveAllClips(long OplusGLSurfaceView_15);

    private native boolean nativeRemoveClip(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, boolean z);

    private native boolean nativeRemoveRange(long OplusGLSurfaceView_15, long j2, long j3, boolean z);

    private native void nativeSetVolumeGain(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12, float f2);

    private native boolean nativeSplitClip(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, long j2);

    public int getType() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetType(this.m_internalObject);
    }

    public int getIndex() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetIndex(this.m_internalObject);
    }

    public long getDuration() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetDuration(this.m_internalObject);
    }

    public int getClipCount() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetClipCount(this.m_internalObject);
    }

    public long changeInPoint(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeChangeInPoint(this.m_internalObject, OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    public long changeOutPoint(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeChangeOutPoint(this.m_internalObject, OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    public boolean splitClip(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeSplitClip(this.m_internalObject, OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    public boolean removeClip(int OplusGLSurfaceView_13, boolean z) {
        NvsUtils.checkFunctionInMainThread();
        return nativeRemoveClip(this.m_internalObject, OplusGLSurfaceView_13, z);
    }

    public boolean removeRange(long OplusGLSurfaceView_15, long j2, boolean z) {
        NvsUtils.checkFunctionInMainThread();
        return nativeRemoveRange(this.m_internalObject, OplusGLSurfaceView_15, j2, z);
    }

    public boolean moveClip(int OplusGLSurfaceView_13, int i2) {
        NvsUtils.checkFunctionInMainThread();
        return nativeMoveClip(this.m_internalObject, OplusGLSurfaceView_13, i2);
    }

    public boolean removeAllClips() {
        NvsUtils.checkFunctionInMainThread();
        return nativeRemoveAllClips(this.m_internalObject);
    }

    public void setVolumeGain(float COUIBaseListPopupWindow_12, float f2) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetVolumeGain(this.m_internalObject, COUIBaseListPopupWindow_12, f2);
    }

    public NvsVolume getVolumeGain() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVolumeGain(this.m_internalObject);
    }
}
