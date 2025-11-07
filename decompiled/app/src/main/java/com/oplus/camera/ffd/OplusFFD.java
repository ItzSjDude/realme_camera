package com.oplus.camera.ffd;

import com.oplus.camera.CameraLog;
import java.nio.ByteBuffer;

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
    private static final String TAG = "OplusFFD";
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
        public ByteBuffer mFFDResult = null;
        public ByteBuffer mAttrResult = null;
        public ByteBuffer mExifResult = null;
    }

    private native int init(int OplusGLSurfaceView_13, String str);

    private native int process(long OplusGLSurfaceView_15, byte[] bArr, ImageInfo imageInfo, ProcessParameter processParameter);

    private native int processSplitYUV(long OplusGLSurfaceView_15, byte[] bArr, byte[] bArr2, ImageInfo imageInfo, ProcessParameter processParameter);

    private native int release(long OplusGLSurfaceView_15);

    private native int setDebug(long OplusGLSurfaceView_15, boolean z, boolean z2, boolean z3, boolean z4);

    static {
        System.loadLibrary("OplusFFDJni");
    }

    public int initialize(int OplusGLSurfaceView_13, String str) {
        long jInit = init(OplusGLSurfaceView_13, str);
        CameraLog.m12954a(TAG, "initialize, faceInfoMode: " + OplusGLSurfaceView_13 + ", modelPath: " + str + ", result: " + jInit);
        if (jInit != 0) {
            this.mHandle = jInit;
        }
        return (int) jInit;
    }

    public int processSplitYUV(byte[] bArr, byte[] bArr2, ImageInfo imageInfo, ProcessParameter processParameter) {
        long OplusGLSurfaceView_15 = this.mHandle;
        int iProcessSplitYUV = OplusGLSurfaceView_15 != 0 ? processSplitYUV(OplusGLSurfaceView_15, bArr, bArr2, imageInfo, processParameter) : -1;
        CameraLog.m12954a(TAG, "process, mHandle: " + this.mHandle + ", yBuffer: " + bArr + ", uvBuffer: " + bArr2 + ", imageInfo: " + imageInfo + ", parameter: " + processParameter + ", result: " + iProcessSplitYUV);
        return iProcessSplitYUV;
    }

    public int process(byte[] bArr, ImageInfo imageInfo, ProcessParameter processParameter) {
        long OplusGLSurfaceView_15 = this.mHandle;
        int iProcess = OplusGLSurfaceView_15 != 0 ? process(OplusGLSurfaceView_15, bArr, imageInfo, processParameter) : -1;
        CameraLog.m12954a(TAG, "process, yuvBuffer: " + bArr + ", imageInfo: " + imageInfo + ", parameter: " + processParameter);
        return iProcess;
    }

    public int release() {
        long OplusGLSurfaceView_15 = this.mHandle;
        int iRelease = OplusGLSurfaceView_15 != 0 ? release(OplusGLSurfaceView_15) : -1;
        CameraLog.m12954a(TAG, "release, mHandle: " + this.mHandle + ", result: " + iRelease);
        return iRelease;
    }

    public int setDebug(boolean z, boolean z2, boolean z3, boolean z4) {
        long OplusGLSurfaceView_15 = this.mHandle;
        int debug = OplusGLSurfaceView_15 != 0 ? setDebug(OplusGLSurfaceView_15, z, z2, z3, z4) : -1;
        CameraLog.m12954a(TAG, "setDebug, mHandle: " + this.mHandle + ", fbDump: " + z + ", drawMarks: " + z2 + ", printAttr: " + z3 + ", printFFD: " + z4 + ", result: " + debug);
        return debug;
    }
}
