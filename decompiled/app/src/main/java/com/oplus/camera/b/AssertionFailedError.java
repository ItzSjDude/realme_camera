package com.oplus.camera.b_renamed;

/* compiled from: ZoomAnimationListener.java */
/* loaded from: classes2.dex */
public class b_renamed implements android.view.animation.Animation.AnimationListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f4170a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.view.View f4171b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.view.View f4172c;

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(android.view.animation.Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(android.view.animation.Animation animation) {
    }

    public b_renamed(boolean z_renamed, android.view.View view, android.view.View view2) {
        this.f4170a = false;
        this.f4171b = null;
        this.f4172c = null;
        this.f4170a = z_renamed;
        this.f4171b = view;
        this.f4172c = view2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(android.view.animation.Animation animation) {
        a_renamed(180);
    }

    public void a_renamed(int i_renamed) {
        android.view.View view = this.f4171b;
        if (view != null) {
            com.oplus.camera.util.Util.a_renamed(view, this.f4170a ? 0 : 4, (android.view.animation.Animation.AnimationListener) null, i_renamed, 0L, android.view.animation.AnimationUtils.loadInterpolator(this.f4171b.getContext(), com.oplus.camera.R_renamed.anim.face_point_scale_interpolator2));
        }
        android.view.View view2 = this.f4172c;
        if (view2 != null) {
            com.oplus.camera.ui.preview.ai_renamed aiVar = (com.oplus.camera.ui.preview.ai_renamed) view2.findViewById(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar);
            if (aiVar != null) {
                aiVar.n_renamed();
            }
            this.f4172c.setVisibility(4);
        }
    }
}
