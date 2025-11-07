package com.meicam.sdk;

import android.graphics.RectF;
import java.util.List;

/* loaded from: classes2.dex */
public class NvsARSceneManipulate {
    NvsARSceneManipulateCallback m_callback = null;
    private long m_contextInterface;

    public interface NvsARSceneManipulateCallback {
        void notifyFaceBoundingRect(List<NvsFaceBoundingRectInfo> list);
    }

    private native void nativeCleanup(long OplusGLSurfaceView_15);

    private native void nativeSetARSceneManipulateCallback(long OplusGLSurfaceView_15, NvsARSceneManipulateCallback nvsARSceneManipulateCallback);

    public void setARSceneCallback(NvsARSceneManipulateCallback nvsARSceneManipulateCallback) {
        this.m_callback = nvsARSceneManipulateCallback;
        nativeSetARSceneManipulateCallback(this.m_contextInterface, nvsARSceneManipulateCallback);
    }

    protected void setContextInterface(long OplusGLSurfaceView_15) {
        this.m_contextInterface = OplusGLSurfaceView_15;
    }

    public void release() {
        this.m_callback = null;
        long OplusGLSurfaceView_15 = this.m_contextInterface;
        if (OplusGLSurfaceView_15 != 0) {
            nativeCleanup(OplusGLSurfaceView_15);
            this.m_contextInterface = 0L;
        }
    }

    protected void finalize() throws Throwable {
        release();
        super.finalize();
    }

    public static class NvsFaceBoundingRectInfo {
        public RectF faceBoundingRect;
        public int faceId;

        public NvsFaceBoundingRectInfo(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
            this.faceId = OplusGLSurfaceView_13;
            this.faceBoundingRect = new RectF(COUIBaseListPopupWindow_12, f2, f3, f4);
        }
    }
}
