package com.oplus.camera;

/* compiled from: ZoomUnit.java */
/* loaded from: classes2.dex */
public class ah_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.text.DecimalFormat f4138a;

    public ah_renamed() {
        this.f4138a = null;
        this.f4138a = new java.text.DecimalFormat("#.#");
    }

    private boolean b_renamed(float f_renamed) {
        return java.lang.Math.abs(f_renamed - 0.6f) < 0.01f || java.lang.Math.abs(f_renamed - 1.0f) < 0.01f || java.lang.Math.abs(f_renamed - 2.0f) < 0.01f || java.lang.Math.abs(f_renamed - 5.0f) < 0.01f || java.lang.Math.abs(f_renamed - 10.0f) < 0.01f;
    }

    private float c_renamed(float f_renamed) {
        if (java.lang.Math.abs(f_renamed - 0.6f) < 0.01f) {
            return 16.0f;
        }
        if (java.lang.Math.abs(f_renamed - 1.0f) < 0.01f) {
            return 24.0f;
        }
        if (java.lang.Math.abs(f_renamed - 2.0f) < 0.01f) {
            return 50.0f;
        }
        if (java.lang.Math.abs(f_renamed - 5.0f) < 0.01f) {
            return 120.0f;
        }
        return f_renamed;
    }

    public java.lang.String a_renamed(boolean z_renamed, float f_renamed) {
        if (z_renamed && b_renamed(f_renamed)) {
            return this.f4138a.format(c_renamed(f_renamed)) + "mm";
        }
        return this.f4138a.format(f_renamed) + "X_renamed";
    }

    public java.lang.String a_renamed(float f_renamed) {
        java.text.DecimalFormat decimalFormat = this.f4138a;
        if (decimalFormat != null) {
            return decimalFormat.format(f_renamed);
        }
        return java.lang.Float.toString(f_renamed);
    }
}
