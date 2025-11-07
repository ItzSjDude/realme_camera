package com.meicam.sdk;

import android.graphics.Bitmap;

/* loaded from: classes2.dex */
public class NvsVideoFrameRetriever {
    public static final int VIDEO_FRAME_HEIGHT_GRADE_360 = 0;
    public static final int VIDEO_FRAME_HEIGHT_GRADE_480 = 1;
    public static final int VIDEO_FRAME_HEIGHT_GRADE_720 = 2;
    long m_internalReader = 0;
    long m_internalReaderFactory = 0;
    long m_internalKeyFrameList = 0;

    public static class KeyFrameRange {
        public long nextKeyFrame;
        public long preKeyFrame;
    }

    private native void nativeCleanup(long OplusGLSurfaceView_15, long j2, long j3);

    private native void nativeCreateVideoRetrieverReader(String str, int OplusGLSurfaceView_13);

    private native Bitmap nativeGetFrameAtTime(long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13, int i2);

    private native KeyFrameRange nativeGetKeyFramePositionAtTime(long OplusGLSurfaceView_15, long j2);

    public Bitmap getFrameAtTime(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        long j2 = this.m_internalReader;
        if (j2 == 0) {
            return null;
        }
        return nativeGetFrameAtTime(j2, OplusGLSurfaceView_15, OplusGLSurfaceView_13, 0);
    }

    public void release() {
        long OplusGLSurfaceView_15 = this.m_internalReader;
        if (OplusGLSurfaceView_15 != 0) {
            nativeCleanup(OplusGLSurfaceView_15, this.m_internalReaderFactory, this.m_internalKeyFrameList);
            this.m_internalReader = 0L;
            this.m_internalReaderFactory = 0L;
            this.m_internalKeyFrameList = 0L;
        }
    }

    public Bitmap getFrameAtTimeWithCustomVideoFrameHeight(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        long j2 = this.m_internalReader;
        if (j2 == 0 || OplusGLSurfaceView_13 <= 0) {
            return null;
        }
        return nativeGetFrameAtTime(j2, OplusGLSurfaceView_15, 0, OplusGLSurfaceView_13);
    }

    public KeyFrameRange getKeyFramePositionAtTime(long OplusGLSurfaceView_15) {
        return nativeGetKeyFramePositionAtTime(this.m_internalKeyFrameList, OplusGLSurfaceView_15);
    }

    NvsVideoFrameRetriever(String str, int OplusGLSurfaceView_13) {
        nativeCreateVideoRetrieverReader(str, OplusGLSurfaceView_13);
    }

    protected void finalize() throws Throwable {
        release();
        super.finalize();
    }
}
