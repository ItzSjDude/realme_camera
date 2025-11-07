package com.oplus.camera.tiltshift;

/* loaded from: classes2.dex */
public class TiltShiftPreview {
    public native int destory();

    public native int getMaskTexture(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, boolean z, int[] iArr);

    public native int init(int OplusGLSurfaceView_13, int i2, int i3, int i4);

    public native int process(int OplusGLSurfaceView_13, int i2, int[] iArr);

    public native int setDebugMask(boolean z);

    public native int setParam(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12);

    static {
        System.loadLibrary("ApsTiltShifPreviewJni");
    }
}
