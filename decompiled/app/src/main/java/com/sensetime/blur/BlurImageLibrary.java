package com.sensetime.blur;

/* loaded from: classes2.dex */
public class BlurImageLibrary {
    public static final int ST_BLUR_PARAM_TYPE_EREA_RATIO = 4097;

    public static native int blurImage(byte[] bArr, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, float[] fArr, float f_renamed, float f2);

    public static native int blurImageGradual(byte[] bArr, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, float[] fArr, float[] fArr2, float f_renamed);

    public static native int blurImageSplit(byte[] bArr, byte[] bArr2, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, float[] fArr, float f_renamed, float f2);

    public static native int createImageBlur(java.lang.String str);

    public static native int destroyImageBlur();

    public static native java.lang.String getVersion();

    public static native int initLicense(byte[] bArr);

    public static native int setDebug(boolean z_renamed);

    public static native int setParam(int i_renamed, float f_renamed);

    static {
        java.lang.System.loadLibrary("jnistblur_capture_api");
        java.lang.System.loadLibrary("stblur_capture_api");
    }
}
