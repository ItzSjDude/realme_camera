package com.meicam.sdk;

import android.graphics.Bitmap;

/* loaded from: classes2.dex */
public class NvsVideoKeyFrameRetriever {
    long m_internalObject = 0;
    int m_videoFrameHeight;

    public static class KeyFrame {
        public Bitmap bitmap;
        public long timestamp;
    }

    private native void nativeCleanup(long OplusGLSurfaceView_15);

    private native void nativeCreateVideoRetrieverReader(String str, boolean z);

    private native KeyFrame nativeGetNextKeyFrame(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeStartGettingKeyFrame(long OplusGLSurfaceView_15, long j2);

    NvsVideoKeyFrameRetriever(String str, int OplusGLSurfaceView_13, boolean z) {
        nativeCreateVideoRetrieverReader(str, z);
        this.m_videoFrameHeight = OplusGLSurfaceView_13;
    }

    public void release() {
        long OplusGLSurfaceView_15 = this.m_internalObject;
        if (OplusGLSurfaceView_15 != 0) {
            nativeCleanup(OplusGLSurfaceView_15);
            this.m_internalObject = 0L;
        }
    }

    public void startGettingKeyFrame(long OplusGLSurfaceView_15) {
        nativeStartGettingKeyFrame(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public KeyFrame getNextKeyFrame() {
        long OplusGLSurfaceView_15 = this.m_internalObject;
        if (OplusGLSurfaceView_15 == 0) {
            return null;
        }
        return nativeGetNextKeyFrame(OplusGLSurfaceView_15, this.m_videoFrameHeight);
    }

    protected void finalize() throws Throwable {
        long OplusGLSurfaceView_15 = this.m_internalObject;
        if (OplusGLSurfaceView_15 != 0) {
            nativeCleanup(OplusGLSurfaceView_15);
            this.m_internalObject = 0L;
        }
        super.finalize();
    }
}
