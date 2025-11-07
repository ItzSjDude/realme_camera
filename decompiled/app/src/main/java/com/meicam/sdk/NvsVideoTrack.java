package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsVideoTrack extends NvsTrack {
    private native NvsVideoClip nativeAddClip(long OplusGLSurfaceView_15, String str, long j2);

    private native NvsVideoClip nativeAddClip(long OplusGLSurfaceView_15, String str, long j2, long j3, long j4);

    private native NvsVideoClip nativeGetClipByIndex(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native NvsVideoClip nativeGetClipByTimelinePosition(long OplusGLSurfaceView_15, long j2);

    private native NvsVideoTransition nativeGetTransitionBySourceClipIndex(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native NvsVideoClip nativeInsertClip(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13);

    private native NvsVideoClip nativeInsertClip(long OplusGLSurfaceView_15, String str, long j2, long j3, int OplusGLSurfaceView_13);

    private native NvsVideoTransition nativeSetBuiltinTransition(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, String str);

    private native NvsVideoTransition nativeSetPackagedTransition(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, String str);

    public NvsVideoClip appendClip(String str) {
        NvsUtils.checkFunctionInMainThread();
        return insertClip(str, getClipCount());
    }

    public NvsVideoClip appendClip(String str, long OplusGLSurfaceView_15, long j2) {
        NvsUtils.checkFunctionInMainThread();
        return insertClip(str, OplusGLSurfaceView_15, j2, getClipCount());
    }

    public NvsVideoClip insertClip(String str, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeInsertClip(this.m_internalObject, str, OplusGLSurfaceView_13);
    }

    public NvsVideoClip insertClip(String str, long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeInsertClip(this.m_internalObject, str, OplusGLSurfaceView_15, j2, OplusGLSurfaceView_13);
    }

    public NvsVideoClip addClip(String str, long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddClip(this.m_internalObject, str, OplusGLSurfaceView_15);
    }

    public NvsVideoClip addClip(String str, long OplusGLSurfaceView_15, long j2, long j3) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddClip(this.m_internalObject, str, OplusGLSurfaceView_15, j2, j3);
    }

    public NvsVideoClip getClipByIndex(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetClipByIndex(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public NvsVideoClip getClipByTimelinePosition(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetClipByTimelinePosition(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public NvsVideoTransition setBuiltinTransition(int OplusGLSurfaceView_13, String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeSetBuiltinTransition(this.m_internalObject, OplusGLSurfaceView_13, str);
    }

    public NvsVideoTransition setPackagedTransition(int OplusGLSurfaceView_13, String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeSetPackagedTransition(this.m_internalObject, OplusGLSurfaceView_13, str);
    }

    public NvsVideoTransition getTransitionBySourceClipIndex(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTransitionBySourceClipIndex(this.m_internalObject, OplusGLSurfaceView_13);
    }
}
