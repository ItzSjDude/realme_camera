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
    private static final java.lang.String TAG = "ArcSoft_" + com.arcsoft.libsinglecamerabokeh.jni.SingleCameraBokehJNI.class.getSimpleName();
    private long mGlobalPtr = 0;

    private native int native_forceUpdateFrame(long j_renamed, int i_renamed);

    private native java.lang.String native_getVersion();

    private native int native_init(com.arcsoft.libsinglecamerabokeh.jni.SingleCameraBokehJNI.SinCamVBInitData sinCamVBInitData);

    private native int native_process(long j_renamed, com.arcsoft.libsinglecamerabokeh.jni.SingleCameraBokehJNI.SinCamVBProcessData sinCamVBProcessData);

    private native int native_release(long j_renamed);

    static {
        java.lang.System.loadLibrary("mpbase");
        java.lang.System.loadLibrary("arcsoft_scbokeh_video");
        java.lang.System.loadLibrary("single_camera_bokeh_native");
    }

    public static class SinCamVBInitData {
        private int m_CameraType;
        private int m_Format;
        private int m_ModelInit;
        private int m_OutHeight;
        private int m_OutWidth;
        private int m_SrcHeight;
        private int m_SrcWidth;

        public SinCamVBInitData(int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.m_SrcWidth = 0;
            this.m_SrcHeight = 0;
            this.m_OutWidth = 0;
            this.m_OutHeight = 0;
            this.m_Format = 0;
            this.m_CameraType = 0;
            this.m_ModelInit = 0;
            this.m_SrcWidth = i_renamed;
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

        public SinCamVBProcessData(int i_renamed, int[] iArr, int i2, int[] iArr2, int[] iArr3, int i3, int i4) {
            this.m_SrcTexture = 0;
            this.m_OutTexture = null;
            this.m_FaceCount = 0;
            this.m_FaceRect = null;
            this.m_RefocusRect = null;
            this.m_BlurLevel = 0;
            this.m_Orientation = 0;
            this.m_SrcTexture = i_renamed;
            this.m_OutTexture = iArr;
            this.m_FaceCount = i2;
            this.m_FaceRect = iArr2;
            this.m_RefocusRect = iArr3;
            this.m_BlurLevel = i3;
            this.m_Orientation = i4;
        }
    }

    public java.lang.String getVersion() {
        return native_getVersion();
    }

    public int init(int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7) {
        return native_init(new com.arcsoft.libsinglecamerabokeh.jni.SingleCameraBokehJNI.SinCamVBInitData(i_renamed, i2, i3, i4, i5, i6, i7));
    }

    public int process(int i_renamed, int[] iArr, int i2, int[] iArr2, int[] iArr3, int i3, int i4) {
        long j_renamed = this.mGlobalPtr;
        if (0 != j_renamed) {
            return native_process(j_renamed, new com.arcsoft.libsinglecamerabokeh.jni.SingleCameraBokehJNI.SinCamVBProcessData(i_renamed, iArr, i2, iArr2, iArr3, i3, i4));
        }
        return 2;
    }

    public int release() {
        long j_renamed = this.mGlobalPtr;
        if (0 == j_renamed) {
            return 2;
        }
        int iNative_release = native_release(j_renamed);
        this.mGlobalPtr = 0L;
        return iNative_release;
    }

    public int forceUpdateFrame(int i_renamed) {
        long j_renamed = this.mGlobalPtr;
        if (0 != j_renamed) {
            return native_forceUpdateFrame(j_renamed, i_renamed);
        }
        return 2;
    }
}
