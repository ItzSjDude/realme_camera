package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsVideoKeyFrameRetriever {
    long m_internalObject = 0;
    int m_videoFrameHeight;

    public static class KeyFrame {
        public android.graphics.Bitmap bitmap;
        public long timestamp;
    }

    private native void nativeCleanup(long j_renamed);

    private native void nativeCreateVideoRetrieverReader(java.lang.String str, boolean z_renamed);

    private native com.meicam.sdk.NvsVideoKeyFrameRetriever.KeyFrame nativeGetNextKeyFrame(long j_renamed, int i_renamed);

    private native void nativeStartGettingKeyFrame(long j_renamed, long j2);

    NvsVideoKeyFrameRetriever(java.lang.String str, int i_renamed, boolean z_renamed) {
        nativeCreateVideoRetrieverReader(str, z_renamed);
        this.m_videoFrameHeight = i_renamed;
    }

    public void release() {
        long j_renamed = this.m_internalObject;
        if (j_renamed != 0) {
            nativeCleanup(j_renamed);
            this.m_internalObject = 0L;
        }
    }

    public void startGettingKeyFrame(long j_renamed) {
        nativeStartGettingKeyFrame(this.m_internalObject, j_renamed);
    }

    public com.meicam.sdk.NvsVideoKeyFrameRetriever.KeyFrame getNextKeyFrame() {
        long j_renamed = this.m_internalObject;
        if (j_renamed == 0) {
            return null;
        }
        return nativeGetNextKeyFrame(j_renamed, this.m_videoFrameHeight);
    }

    protected void finalize() throws java.lang.Throwable {
        long j_renamed = this.m_internalObject;
        if (j_renamed != 0) {
            nativeCleanup(j_renamed);
            this.m_internalObject = 0L;
        }
        super.finalize();
    }
}
