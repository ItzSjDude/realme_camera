package com.oplus.camera.upscale;

/* loaded from: classes2.dex */
public class OplusUpscale {
    public static final int IMAGE_FORMAT_NV12 = 9;
    public static final int IMAGE_FORMAT_NV21 = 8;

    public static class ScaleRuntimeParameter {
        public int mNoiseReductionStrength = 0;
        public int mColorNoiseReductionStrength = 0;
        public float mSharpen = 0.0f;
        public int mNumberOfProcessingThreads = 0;
        public int mActiveCPUMask = 0;
    }

    public static class YUVImageParameter {
        public int mFormat = 9;
        public int mWidth = 0;
        public int mHeight = 0;
        public int mYPixelStride = 0;
        public int mYRowStride = 0;
        public int mYColumnStride = 0;
        public int mCBPixelStride = 0;
        public int mCBRowStride = 0;
        public int mCRPixelStride = 0;
        public int mCRRowStride = 0;
    }

    public native java.lang.String getVersion();

    public native int scaleImage(com.oplus.camera.upscale.OplusUpscale.YUVImageParameter yUVImageParameter, byte[] bArr, com.oplus.camera.upscale.OplusUpscale.YUVImageParameter yUVImageParameter2, byte[] bArr2, com.oplus.camera.upscale.OplusUpscale.ScaleRuntimeParameter scaleRuntimeParameter);

    public native int scaleImageSplitYUV(com.oplus.camera.upscale.OplusUpscale.YUVImageParameter yUVImageParameter, byte[] bArr, byte[] bArr2, com.oplus.camera.upscale.OplusUpscale.YUVImageParameter yUVImageParameter2, byte[] bArr3, byte[] bArr4, com.oplus.camera.upscale.OplusUpscale.ScaleRuntimeParameter scaleRuntimeParameter);

    static {
        java.lang.System.loadLibrary("OplusUpscaleJni");
    }
}
