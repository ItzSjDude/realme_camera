package com.arcsoft.libsinglecamerabokeh.jni;

/* loaded from: classes.dex */
public class SingleCameraBokehJNI {
    public static final int CAMERA_TYPE_BACK = 0;
    public static final int CAMERA_TYPE_FRONT = 1;
    public static final int PLATFORM_QC_7150 = 1;
    public static final int PLATFORM_QC_8150 = 2;
    public static final int PLATFORM_QC_DEFAULT = 0;
    public static final int PREVIEW_MODE = 2;
    public static final int SINGLECAMBOKEH_FOC_0 = 1;
    public static final int SINGLECAMBOKEH_FOC_180 = 4;
    public static final int SINGLECAMBOKEH_FOC_270 = 3;
    public static final int SINGLECAMBOKEH_FOC_90 = 2;
    public static final int SINGLECAMBOKEH_FOC_UNKNOWN = 0;
    private static final String TAG = "ArcSoft_" + SingleCameraBokehJNI.class.getSimpleName();
    private long mGlobalPtr = 0;

    private native int native_forceUpdateFrame(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native String native_getVersion();

    private native int native_init(SinCamVBInitData sinCamVBInitData);

    private native int native_process(long OplusGLSurfaceView_15, SinCamVBProcessData sinCamVBProcessData);

    private native int native_release(long OplusGLSurfaceView_15);

    static {
        System.loadLibrary("mpbase");
        System.loadLibrary("arcsoft_scbokeh_video");
        System.loadLibrary("single_camera_bokeh_native");
    }

    public static class SinCamVBInitData {
        private int m_CameraType;
        private int m_Format;
        private int m_ModelInit;
        private int m_OutHeight;
        private int m_OutWidth;
        private int m_SrcHeight;
        private int m_SrcWidth;

        public SinCamVBInitData(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.m_SrcWidth = 0;
            this.m_SrcHeight = 0;
            this.m_OutWidth = 0;
            this.m_OutHeight = 0;
            this.m_Format = 0;
            this.m_CameraType = 0;
            this.m_ModelInit = 0;
            this.m_SrcWidth = OplusGLSurfaceView_13;
            this.m_SrcHeight = i2;
            this.m_OutWidth = i3;
            this.m_OutHeight = i4;
            this.m_Format = i5;
            this.m_CameraType = i6;
            this.m_ModelInit = i7;
        }
    }

    public static class SinCamVBProcessData {
        private int m_BlurLevel;
        private int m_FaceCount;
        private int[] m_FaceRect;
        private int m_Orientation;
        private int[] m_OutTexture;
        private int[] m_RefocusRect;
        private int m_SrcTexture;

        public SinCamVBProcessData(int OplusGLSurfaceView_13, int[] iArr, int i2, int[] iArr2, int[] iArr3, int i3, int i4) {
            this.m_SrcTexture = 0;
            this.m_OutTexture = null;
            this.m_FaceCount = 0;
            this.m_FaceRect = null;
            this.m_RefocusRect = null;
            this.m_BlurLevel = 0;
            this.m_Orientation = 0;
            this.m_SrcTexture = OplusGLSurfaceView_13;
            this.m_OutTexture = iArr;
            this.m_FaceCount = i2;
            this.m_FaceRect = iArr2;
            this.m_RefocusRect = iArr3;
            this.m_BlurLevel = i3;
            this.m_Orientation = i4;
        }
    }

    public String getVersion() {
        return native_getVersion();
    }

    public int init(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7) {
        return native_init(new SinCamVBInitData(OplusGLSurfaceView_13, i2, i3, i4, i5, i6, i7));
    }

    public int process(int OplusGLSurfaceView_13, int[] iArr, int i2, int[] iArr2, int[] iArr3, int i3, int i4) {
        long OplusGLSurfaceView_15 = this.mGlobalPtr;
        if (0 != OplusGLSurfaceView_15) {
            return native_process(OplusGLSurfaceView_15, new SinCamVBProcessData(OplusGLSurfaceView_13, iArr, i2, iArr2, iArr3, i3, i4));
        }
        return 2;
    }

    public int release() {
        long OplusGLSurfaceView_15 = this.mGlobalPtr;
        if (0 == OplusGLSurfaceView_15) {
            return 2;
        }
        int iNative_release = native_release(OplusGLSurfaceView_15);
        this.mGlobalPtr = 0L;
        return iNative_release;
    }

    public int forceUpdateFrame(int OplusGLSurfaceView_13) {
        long OplusGLSurfaceView_15 = this.mGlobalPtr;
        if (0 != OplusGLSurfaceView_15) {
            return native_forceUpdateFrame(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
        }
        return 2;
    }
}
