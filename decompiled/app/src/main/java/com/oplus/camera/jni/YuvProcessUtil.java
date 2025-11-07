package com.oplus.camera.jni;

/* loaded from: classes2.dex */
public class YuvProcessUtil {
    public static final int FORMAT_NV12 = 274;
    public static final int FORMAT_NV21 = 17;

    public static class ExifInfo {
        public static final int APERTURE_MULTIPLE = 100;
        public static final int AWB_AUTO = 0;
        public static final int AWB_MANUAL = 1;
        public static final int DATE_TIME_MULTIPLE = 1000;
        public static final int EXPOSURE_BIAS_MULTIPLE = 10000000;
        public static final int EXPOSURE_MULTIPLE = 1000000;
        public static final int FLASH_AUTO_CLOSE = 24;
        public static final int FLASH_AUTO_OPEN = 25;
        public static final int FLASH_CLOSE = 16;
        public static final int FLASH_OPEN = 9;
        public static final int FOCAL_LENGTH_MULTIPLE = 100;
        public static final int F_NUMBER_MULTIPLE = 10;
        public static final int LOCATION_MULTIPLE = 1000;
        public static final int LOCATION_TIME_MULTIPLE = 1;
        public java.lang.String mModel = null;
        public int mJpegOrientation = 0;
        public int mISO = 0;
        public int[] mFNumber = null;
        public int mWhiteBalanceMode = 0;
        public int mFlashValue = 0;
        public long[] mLatitude = null;
        public long[] mLongitude = null;
        public long[] mGPSTimeStamp = null;
        public java.lang.String mGPSDateStamp = null;
        public java.lang.String mDateTime = null;
        public java.lang.String mSubDateTime = null;
        public java.lang.String mManufacture = null;
        public long mFrameNum = 0;
        public long[] mExposureTime = null;
        public int[] mFocalLength = null;
        public byte[] mTunningStats = null;
        public int mSupportDCIP3 = 0;
        public java.lang.String mUserComment = null;
        public java.lang.String mLatitudeRef = null;
        public java.lang.String mLongitudeRef = null;
        public byte mAltitudeRef = 0;
        public long[] mAltitude = null;
        public int mImageWidth = 0;
        public int mImageHeight = 0;
        public long[] mApertureValue = null;
        public long[] mExposureBiasValue = null;
    }

    public static native void bindCpuCores(long j_renamed);

    public static native byte[] mirrorYUV(byte[] bArr, int i_renamed, int[] iArr, int[] iArr2, int i2, int i3, int i4);

    public static native void restoreCpuCores();

    public static native byte[] rotateYUV(byte[] bArr, int i_renamed, int[] iArr, int[] iArr2, int i2, int i3, int i4);

    public static native void setExifParam(java.lang.String str, int i_renamed, int i2, int[] iArr, int i3, int i4, long[] jArr, long[] jArr2, java.lang.String str2, java.lang.String str3, long j_renamed, long[] jArr3, int[] iArr2, java.lang.String str4, byte[] bArr, int i5, java.lang.String str5, java.lang.String str6, java.lang.String str7, byte b2, long[] jArr4, int i6, int i7, java.lang.String str8, long[] jArr5, long[] jArr6, long[] jArr7);

    public native byte[] compressYUVtoJpeg(byte[] bArr, int i_renamed, int[] iArr, int[] iArr2, int i2, int i3, int i4, int i5, boolean z_renamed, boolean z2, boolean z3, int i6);

    public native int init(boolean z_renamed);

    public native void unInit(boolean z_renamed);

    public static void setExifInfo(com.oplus.camera.jni.YuvProcessUtil.ExifInfo exifInfo) {
        setExifParam(exifInfo.mModel, exifInfo.mJpegOrientation, exifInfo.mISO, exifInfo.mFNumber, exifInfo.mWhiteBalanceMode, exifInfo.mFlashValue, exifInfo.mLatitude, exifInfo.mLongitude, exifInfo.mDateTime, exifInfo.mSubDateTime, exifInfo.mFrameNum, exifInfo.mExposureTime, exifInfo.mFocalLength, exifInfo.mManufacture, exifInfo.mTunningStats, exifInfo.mSupportDCIP3, exifInfo.mUserComment, exifInfo.mLatitudeRef, exifInfo.mLongitudeRef, exifInfo.mAltitudeRef, exifInfo.mAltitude, exifInfo.mImageWidth, exifInfo.mImageHeight, exifInfo.mGPSDateStamp, exifInfo.mGPSTimeStamp, exifInfo.mApertureValue, exifInfo.mExposureBiasValue);
    }
}
