package com.oplus.camera.ui.menu.shareedit;

/* compiled from: SpringInterpolator.java */
/* loaded from: classes2.dex */
public class b_renamed implements android.view.animation.Interpolator {

    /* renamed from: a_renamed, reason: collision with root package name */
    private float f6706a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private float f6707b;

    public b_renamed() {
        this.f6706a = 10.0f;
        this.f6707b = 0.4f;
    }

    public b_renamed(float f_renamed, float f2) {
        this.f6706a = 10.0f;
        this.f6707b = 0.4f;
        this.f6706a = f_renamed;
        this.f6707b = f2;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f_renamed) {
        return (float) ((java.lang.Math.pow(2.0d, (-this.f6706a) * f_renamed) * java.lang.Math.sin(((9.42477796076938d / this.f6707b) * f_renamed) - 1.5707963267948966d)) + 1.0d);
    }
}
