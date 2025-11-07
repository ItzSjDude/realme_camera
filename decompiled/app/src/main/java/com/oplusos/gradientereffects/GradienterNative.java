package com.oplusos.gradientereffects;

/* loaded from: classes2.dex */
public class GradienterNative {
    public static native void processGravity(float f_renamed, float f2, float f3, float[] fArr, int[] iArr, int[] iArr2);

    static {
        java.lang.System.loadLibrary("GradienterNativeLib");
    }
}
