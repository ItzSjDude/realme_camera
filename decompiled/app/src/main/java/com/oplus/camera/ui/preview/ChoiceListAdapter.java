package com.oplus.camera.ui.preview;

/* compiled from: PreviewAnimManager.java */
/* loaded from: classes2.dex */
public class v_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f7154a = true;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f7155b = true;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f7156c = true;
    private android.view.animation.Interpolator d_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private long e_renamed = Long.MAX_VALUE;
    private long f_renamed = 180;
    private long g_renamed = 0;
    private final float h_renamed;
    private final float i_renamed;
    private float j_renamed;

    public v_renamed(float f_renamed, float f2) {
        this.j_renamed = 0.0f;
        this.h_renamed = f_renamed;
        this.i_renamed = f2;
        this.j_renamed = this.h_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.f7154a = z_renamed;
        com.oplus.camera.e_renamed.a_renamed("PreviewAnimManager", "setNeedAnim, needAnim: " + z_renamed);
    }

    public boolean a_renamed() {
        if (!this.f7154a) {
            return false;
        }
        if (this.f7156c) {
            this.e_renamed = android.os.SystemClock.uptimeMillis();
            this.f7156c = false;
        }
        if (!this.f7155b) {
            return false;
        }
        this.g_renamed = android.os.SystemClock.uptimeMillis();
        float f_renamed = (this.g_renamed - this.e_renamed) / this.f_renamed;
        if (f_renamed > 1.0f) {
            this.f7155b = false;
            this.j_renamed = this.i_renamed;
            return true;
        }
        float interpolation = this.d_renamed.getInterpolation(f_renamed);
        float f2 = this.h_renamed;
        this.j_renamed = f2 + ((this.i_renamed - f2) * interpolation);
        return true;
    }

    public float b_renamed() {
        return this.j_renamed;
    }
}
