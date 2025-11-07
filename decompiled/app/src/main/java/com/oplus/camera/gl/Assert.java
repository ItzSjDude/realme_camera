package com.oplus.camera.gl_renamed;

/* compiled from: Animation.java */
/* loaded from: classes2.dex */
public abstract class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected long f4571a = -2;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected long f4572b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected android.view.animation.Interpolator f4573c;

    protected abstract void a_renamed(float f_renamed);

    public void a_renamed(long j_renamed) {
        this.f4571a = j_renamed;
    }

    public boolean b_renamed(long j_renamed) {
        long j2 = this.f4571a;
        if (j2 == -2) {
            return false;
        }
        if (j2 == -1) {
            this.f4571a = j_renamed;
        }
        long j3 = j_renamed - this.f4571a;
        float fA_renamed = com.oplus.camera.gl_renamed.y_renamed.a_renamed(j3 / this.f4572b, 0.0f, 1.0f);
        android.view.animation.Interpolator interpolator = this.f4573c;
        if (interpolator != null) {
            fA_renamed = interpolator.getInterpolation(fA_renamed);
        }
        a_renamed(fA_renamed);
        if (j3 >= this.f4572b) {
            this.f4571a = -2L;
        }
        return this.f4571a != -2;
    }
}
