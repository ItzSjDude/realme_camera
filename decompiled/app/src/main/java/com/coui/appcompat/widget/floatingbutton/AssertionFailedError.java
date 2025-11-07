package com.coui.appcompat.widget.floatingbutton;

/* compiled from: COUIFloatingButtonTouchAnimation.java */
/* loaded from: classes.dex */
public class b_renamed extends android.view.animation.ScaleAnimation {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.ref.WeakReference<android.view.View> f2946a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final float f2947b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final float f2948c;
    private float d_renamed;
    private float e_renamed;
    private int f_renamed;

    public b_renamed(float f_renamed, float f2, float f3, float f4) {
        super(f_renamed, f2, f_renamed, f2, f3, f4);
        this.f_renamed = 0;
        this.f2947b = f_renamed;
        this.f2948c = f2;
    }

    @Override // android.view.animation.ScaleAnimation, android.view.animation.Animation
    protected void applyTransformation(float f_renamed, android.view.animation.Transformation transformation) {
        int color;
        super.applyTransformation(f_renamed, transformation);
        float f2 = this.f2947b;
        this.d_renamed = f2 + ((this.f2948c - f2) * f_renamed);
        java.lang.ref.WeakReference<android.view.View> weakReference = this.f2946a;
        if (weakReference != null) {
            android.view.View view = weakReference.get();
            android.content.res.ColorStateList backgroundTintList = view.getBackgroundTintList();
            if (backgroundTintList != null) {
                color = backgroundTintList.getDefaultColor();
            } else {
                color = view.getBackground() instanceof android.graphics.drawable.ColorDrawable ? ((android.graphics.drawable.ColorDrawable) view.getBackground()).getColor() : Integer.MIN_VALUE;
            }
            if (color != Integer.MIN_VALUE) {
                this.e_renamed = a_renamed(f_renamed);
                this.f_renamed = a_renamed(color, this.e_renamed);
                view.getBackground().setTint(this.f_renamed);
            }
        }
    }

    private float a_renamed(float f_renamed) {
        float f2 = this.f2947b;
        float f3 = this.f2948c;
        if (f2 > f3) {
            return 1.0f + (f_renamed * (-0.19999999f));
        }
        if (f2 < f3) {
            return (f_renamed * 0.19999999f) + 0.8f;
        }
        return 1.0f;
    }

    private int a_renamed(int i_renamed, float f_renamed) {
        float[] fArr = new float[3];
        androidx.core.graphics.d_renamed.a_renamed(i_renamed, fArr);
        fArr[2] = fArr[2] * f_renamed;
        int iA = androidx.core.graphics.d_renamed.a_renamed(fArr);
        return android.graphics.Color.argb(android.graphics.Color.alpha(iA), java.lang.Math.min(255, android.graphics.Color.red(iA)), java.lang.Math.min(255, android.graphics.Color.green(iA)), java.lang.Math.min(255, android.graphics.Color.blue(iA)));
    }

    public void a_renamed(android.view.View view) {
        this.f2946a = new java.lang.ref.WeakReference<>(view);
    }

    @Override // android.view.animation.Animation
    public int getBackgroundColor() {
        return this.f_renamed;
    }
}
