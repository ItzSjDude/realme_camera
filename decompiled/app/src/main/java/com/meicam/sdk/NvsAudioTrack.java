package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsAudioTrack extends NvsTrack {
    private native NvsAudioClip nativeAddClip(long OplusGLSurfaceView_15, String str, long j2);

    private native NvsAudioClip nativeAddClip(long OplusGLSurfaceView_15, String str, long j2, long j3, long j4);

    private native NvsAudioClip nativeGetClipByIndex(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native NvsAudioClip nativeGetClipByTimelinePosition(long OplusGLSurfaceView_15, long j2);

    private native NvsAudioTransition nativeGetTransitionWithSourceClipIndex(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native NvsAudioClip nativeInsertClip(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13);

    private native NvsAudioClip nativeInsertClip(long OplusGLSurfaceView_15, String str, long j2, long j3, int OplusGLSurfaceView_13);

    private native NvsAudioTransition nativeSetBuiltinTransition(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, String str);

    public NvsAudioClip appendClip(String str) {
        NvsUtils.checkFunctionInMainThread();
        return insertClip(str, getClipCount());
    }

    public NvsAudioClip appendClip(String str, long OplusGLSurfaceView_15, long j2) {
        NvsUtils.checkFunctionInMainThread();
        return insertClip(str, OplusGLSurfaceView_15, j2, getClipCount());
    }

    public NvsAudioClip insertClip(String str, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeInsertClip(this.m_internalObject, str, OplusGLSurfaceView_13);
    }

    public NvsAudioClip insertClip(String str, long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeInsertClip(this.m_internalObject, str, OplusGLSurfaceView_15, j2, OplusGLSurfaceView_13);
    }

    public NvsAudioClip addClip(String str, long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddClip(this.m_internalObject, str, OplusGLSurfaceView_15);
    }

    public NvsAudioClip addClip(String str, long OplusGLSurfaceView_15, long j2, long j3) {
        NvsUtils.checkFunctionInMainThread();
        return nativeAddClip(this.m_internalObject, str, OplusGLSurfaceView_15, j2, j3);
    }

    public NvsAudioClip getClipByIndex(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetClipByIndex(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public NvsAudioClip getClipByTimelinePosition(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetClipByTimelinePosition(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public NvsAudioTransition setBuiltinTransition(int OplusGLSurfaceView_13, String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeSetBuiltinTransition(this.m_internalObject, OplusGLSurfaceView_13, str);
    }

    public NvsAudioTransition getTransitionWithSourceClipIndex(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTransitionWithSourceClipIndex(this.m_internalObject, OplusGLSurfaceView_13);
    }
}
