package com.oplus.camera.tiltshift;

/* loaded from: classes2.dex */
public class TiltShiftPreview {
    public native int destory();

    public native int getMaskTexture(int i_renamed, int i2, float f_renamed, float f2, float f3, float f4, boolean z_renamed, int[] iArr);

    public native int init(int i_renamed, int i2, int i3, int i4);

    public native int process(int i_renamed, int i2, int[] iArr);

    public native int setDebugMask(boolean z_renamed);

    public native int setParam(int i_renamed, float f_renamed);

    static {
        java.lang.System.loadLibrary("ApsTiltShifPreviewJni");
    }
}
