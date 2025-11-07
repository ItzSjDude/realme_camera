package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsARSceneManipulate {
    com.meicam.sdk.NvsARSceneManipulate.NvsARSceneManipulateCallback m_callback = null;
    private long m_contextInterface;

    public interface NvsARSceneManipulateCallback {
        void notifyFaceBoundingRect(java.util.List<com.meicam.sdk.NvsARSceneManipulate.NvsFaceBoundingRectInfo> list);
    }

    private native void nativeCleanup(long j_renamed);

    private native void nativeSetARSceneManipulateCallback(long j_renamed, com.meicam.sdk.NvsARSceneManipulate.NvsARSceneManipulateCallback nvsARSceneManipulateCallback);

    public void setARSceneCallback(com.meicam.sdk.NvsARSceneManipulate.NvsARSceneManipulateCallback nvsARSceneManipulateCallback) {
        this.m_callback = nvsARSceneManipulateCallback;
        nativeSetARSceneManipulateCallback(this.m_contextInterface, nvsARSceneManipulateCallback);
    }

    protected void setContextInterface(long j_renamed) {
        this.m_contextInterface = j_renamed;
    }

    public void release() {
        this.m_callback = null;
        long j_renamed = this.m_contextInterface;
        if (j_renamed != 0) {
            nativeCleanup(j_renamed);
            this.m_contextInterface = 0L;
        }
    }

    protected void finalize() throws java.lang.Throwable {
        release();
        super.finalize();
    }

    public static class NvsFaceBoundingRectInfo {
        public android.graphics.RectF faceBoundingRect;
        public int faceId;

        public NvsFaceBoundingRectInfo(int i_renamed, float f_renamed, float f2, float f3, float f4) {
            this.faceId = i_renamed;
            this.faceBoundingRect = new android.graphics.RectF(f_renamed, f2, f3, f4);
        }
    }
}
