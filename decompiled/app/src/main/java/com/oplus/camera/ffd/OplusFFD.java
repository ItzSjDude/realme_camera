package com.oplus.camera.ffd;

/* loaded from: classes2.dex */
public class OplusFFD {
    public static final int FACE_INFO_ATTR = 2;
    public static final int FACE_INFO_FD = 1;
    public static final int FACE_INFO_MASTER = 8;
    public static final int FACE_INFO_SKINSEG = 4;
    public static final int IMAGE_FMT_NV12 = 0;
    public static final int IMAGE_FMT_NV21 = 1;
    public static final int IMAGE_FMT_RGB888 = 3;
    public static final int IMAGE_FMT_RGBA8888 = 2;
    private static final java.lang.String TAG = "OplusFFD";
    private long mHandle = 0;

    public static class ImageInfo {
        public int mWidth = 0;
        public int mHeight = 0;
        public int mStride = 0;
        public int mScanline = 0;
        public int mFormat = 0;
    }

    public static class ProcessParameter {
        public int mDeviceOrientation = 0;
        public boolean mFrontCamera = false;
        public int mFaceNum = 0;
        public int mFFDResultSize = 0;
        public int mAttrResultSize = 0;
        public int mExifSize = 0;
        public java.nio.ByteBuffer mFFDResult = null;
        public java.nio.ByteBuffer mAttrResult = null;
        public java.nio.ByteBuffer mExifResult = null;
    }

    private native int init(int i_renamed, java.lang.String str);

    private native int process(long j_renamed, byte[] bArr, com.oplus.camera.ffd.OplusFFD.ImageInfo imageInfo, com.oplus.camera.ffd.OplusFFD.ProcessParameter processParameter);

    private native int processSplitYUV(long j_renamed, byte[] bArr, byte[] bArr2, com.oplus.camera.ffd.OplusFFD.ImageInfo imageInfo, com.oplus.camera.ffd.OplusFFD.ProcessParameter processParameter);

    private native int release(long j_renamed);

    private native int setDebug(long j_renamed, boolean z_renamed, boolean z2, boolean z3, boolean z4);

    static {
        java.lang.System.loadLibrary("OplusFFDJni");
    }

    public int initialize(int i_renamed, java.lang.String str) {
        long jInit = init(i_renamed, str);
        com.oplus.camera.e_renamed.a_renamed(TAG, "initialize, faceInfoMode: " + i_renamed + ", modelPath: " + str + ", result: " + jInit);
        if (jInit != 0) {
            this.mHandle = jInit;
        }
        return (int) jInit;
    }

    public int processSplitYUV(byte[] bArr, byte[] bArr2, com.oplus.camera.ffd.OplusFFD.ImageInfo imageInfo, com.oplus.camera.ffd.OplusFFD.ProcessParameter processParameter) {
        long j_renamed = this.mHandle;
        int iProcessSplitYUV = j_renamed != 0 ? processSplitYUV(j_renamed, bArr, bArr2, imageInfo, processParameter) : -1;
        com.oplus.camera.e_renamed.a_renamed(TAG, "process, mHandle: " + this.mHandle + ", yBuffer: " + bArr + ", uvBuffer: " + bArr2 + ", imageInfo: " + imageInfo + ", parameter: " + processParameter + ", result: " + iProcessSplitYUV);
        return iProcessSplitYUV;
    }

    public int process(byte[] bArr, com.oplus.camera.ffd.OplusFFD.ImageInfo imageInfo, com.oplus.camera.ffd.OplusFFD.ProcessParameter processParameter) {
        long j_renamed = this.mHandle;
        int iProcess = j_renamed != 0 ? process(j_renamed, bArr, imageInfo, processParameter) : -1;
        com.oplus.camera.e_renamed.a_renamed(TAG, "process, yuvBuffer: " + bArr + ", imageInfo: " + imageInfo + ", parameter: " + processParameter);
        return iProcess;
    }

    public int release() {
        long j_renamed = this.mHandle;
        int iRelease = j_renamed != 0 ? release(j_renamed) : -1;
        com.oplus.camera.e_renamed.a_renamed(TAG, "release, mHandle: " + this.mHandle + ", result: " + iRelease);
        return iRelease;
    }

    public int setDebug(boolean z_renamed, boolean z2, boolean z3, boolean z4) {
        long j_renamed = this.mHandle;
        int debug = j_renamed != 0 ? setDebug(j_renamed, z_renamed, z2, z3, z4) : -1;
        com.oplus.camera.e_renamed.a_renamed(TAG, "setDebug, mHandle: " + this.mHandle + ", fbDump: " + z_renamed + ", drawMarks: " + z2 + ", printAttr: " + z3 + ", printFFD: " + z4 + ", result: " + debug);
        return debug;
    }
}
