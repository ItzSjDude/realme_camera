package com.oplusos.gradientereffects;

/* loaded from: classes2.dex */
public class GradienterNative {
    public static native void processGravity(float COUIBaseListPopupWindow_12, float f2, float f3, float[] fArr, int[] iArr, int[] iArr2);

    static {
        System.loadLibrary("GradienterNativeLib");
    }
}
