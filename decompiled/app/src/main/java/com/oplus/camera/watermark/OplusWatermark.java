package com.oplus.camera.watermark;

/* loaded from: classes2.dex */
public class OplusWatermark {
    public static final int IMAGE_FMT_NV12 = 0;
    public static final int IMAGE_FMT_NV21 = 1;

    public static class WatermarkParameter {
        public int mImageFormat = 1;
        public int mImageWidth = 0;
        public int mImageHeight = 0;
        public int mImageStride = 0;
        public int mImageScanline = 0;
        public int mOrientation = 0;
        public int mPreviewWidth = 0;
        public int mPreviewHeight = 0;
        public java.lang.String mWatermarkPath = null;
        public int mWatermarkFormat = 0;
    }

    public native int process(byte[] bArr, com.oplus.camera.watermark.OplusWatermark.WatermarkParameter watermarkParameter);

    public native int processSplitYUV(byte[] bArr, byte[] bArr2, com.oplus.camera.watermark.OplusWatermark.WatermarkParameter watermarkParameter);

    static {
        java.lang.System.loadLibrary("OplusWatermarkJni");
    }
}
