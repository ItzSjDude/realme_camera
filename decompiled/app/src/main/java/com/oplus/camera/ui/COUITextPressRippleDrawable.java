package com.oplus.camera.ui;

/* compiled from: OrientationAnimation.java */
/* loaded from: classes2.dex */
public class r_renamed extends android.view.animation.Animation implements android.view.animation.Animation.AnimationListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private float f7169a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private float f7170b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f7171c;
    private boolean d_renamed;
    private int e_renamed = 0;
    private com.oplus.camera.ui.r_renamed.a_renamed f_renamed = null;

    /* compiled from: OrientationAnimation.java */
    public interface a_renamed {
        void a_renamed(float f_renamed);

        void a_renamed(int i_renamed);

        boolean a_renamed();
    }

    public r_renamed(float f_renamed, float f2) {
        this.f7169a = 0.0f;
        this.f7170b = 0.0f;
        this.f7171c = false;
        this.d_renamed = false;
        this.f7169a = f_renamed;
        this.f7170b = f2;
        this.f7171c = false;
        this.d_renamed = false;
        setRepeatCount(1);
        setAnimationListener(this);
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        this.e_renamed = i_renamed;
        com.oplus.camera.ui.r_renamed.a_renamed aVar = this.f_renamed;
        if ((aVar == null || aVar.a_renamed()) && z_renamed) {
            return;
        }
        a_renamed(i_renamed);
    }

    public void a_renamed(com.oplus.camera.ui.r_renamed.a_renamed aVar) {
        this.f_renamed = aVar;
    }

    public int a_renamed() {
        return this.e_renamed;
    }

    public boolean b_renamed() {
        return this.f7171c;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f_renamed, android.view.animation.Transformation transformation) {
        float f2;
        float f3;
        if (this.d_renamed) {
            f2 = this.f7170b;
            f3 = this.f7169a;
        } else {
            f2 = this.f7169a;
            f3 = this.f7170b;
        }
        float f4 = f2 + ((f3 - f2) * f_renamed);
        float f5 = f4 <= 1.0f ? f4 : 1.0f;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (!this.f7171c) {
            f5 = this.f7169a;
        }
        a_renamed(f5);
    }

    private void a_renamed(float f_renamed) {
        com.oplus.camera.ui.r_renamed.a_renamed aVar = this.f_renamed;
        if (aVar != null) {
            aVar.a_renamed(f_renamed);
        }
    }

    private void a_renamed(int i_renamed) {
        com.oplus.camera.ui.r_renamed.a_renamed aVar = this.f_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(android.view.animation.Animation animation) {
        a_renamed(this.e_renamed);
        a_renamed(this.f7169a);
        this.f7171c = false;
        this.d_renamed = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(android.view.animation.Animation animation) {
        this.d_renamed = true;
        a_renamed(this.f7170b);
        a_renamed(this.e_renamed);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(android.view.animation.Animation animation) {
        this.f7171c = true;
        this.d_renamed = false;
    }
}
