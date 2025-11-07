package com.oplus.camera.util;

/* compiled from: BackgroundUtil.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static boolean f7328a = true;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static int f7329b = android.graphics.Color.parseColor("#121212");

    public static int a_renamed(int i_renamed) {
        return f7328a ? android.graphics.Color.argb(android.graphics.Color.alpha(i_renamed), android.graphics.Color.red(f7329b), android.graphics.Color.green(f7329b), android.graphics.Color.blue(f7329b)) : i_renamed;
    }

    public static float a_renamed(float f_renamed) {
        return f7328a ? android.graphics.Color.red(f7329b) / 255.0f : f_renamed;
    }

    public static float b_renamed(float f_renamed) {
        return f7328a ? android.graphics.Color.green(f7329b) / 255.0f : f_renamed;
    }

    public static float c_renamed(float f_renamed) {
        return f7328a ? android.graphics.Color.blue(f7329b) / 255.0f : f_renamed;
    }
}
