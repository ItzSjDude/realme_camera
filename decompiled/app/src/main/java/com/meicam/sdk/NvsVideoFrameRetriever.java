package com.meicam.sdk;

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

    private native void nativeCleanup(long j_renamed, long j2, long j3);

    private native void nativeCreateVideoRetrieverReader(java.lang.String str, int i_renamed);

    private native android.graphics.Bitmap nativeGetFrameAtTime(long j_renamed, long j2, int i_renamed, int i2);

    private native com.meicam.sdk.NvsVideoFrameRetriever.KeyFrameRange nativeGetKeyFramePositionAtTime(long j_renamed, long j2);

    public android.graphics.Bitmap getFrameAtTime(long j_renamed, int i_renamed) {
        long j2 = this.m_internalReader;
        if (j2 == 0) {
            return null;
        }
        return nativeGetFrameAtTime(j2, j_renamed, i_renamed, 0);
    }

    public void release() {
        long j_renamed = this.m_internalReader;
        if (j_renamed != 0) {
            nativeCleanup(j_renamed, this.m_internalReaderFactory, this.m_internalKeyFrameList);
            this.m_internalReader = 0L;
            this.m_internalReaderFactory = 0L;
            this.m_internalKeyFrameList = 0L;
        }
    }

    public android.graphics.Bitmap getFrameAtTimeWithCustomVideoFrameHeight(long j_renamed, int i_renamed) {
        long j2 = this.m_internalReader;
        if (j2 == 0 || i_renamed <= 0) {
            return null;
        }
        return nativeGetFrameAtTime(j2, j_renamed, 0, i_renamed);
    }

    public com.meicam.sdk.NvsVideoFrameRetriever.KeyFrameRange getKeyFramePositionAtTime(long j_renamed) {
        return nativeGetKeyFramePositionAtTime(this.m_internalKeyFrameList, j_renamed);
    }

    NvsVideoFrameRetriever(java.lang.String str, int i_renamed) {
        nativeCreateVideoRetrieverReader(str, i_renamed);
    }

    protected void finalize() throws java.lang.Throwable {
        release();
        super.finalize();
    }
}
