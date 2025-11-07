package com.oplus.camera.ui.modepanel;

/* compiled from: ModePanelUIControl.java */
/* loaded from: classes2.dex */
public class m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f6741a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.view.ViewGroup f6742b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6743c;
    private android.view.animation.PathInterpolator d_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private android.view.animation.PathInterpolator e_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private com.oplus.camera.ui.modepanel.n_renamed f_renamed = null;
    private com.oplus.camera.ui.modepanel.n_renamed.a_renamed g_renamed = null;
    private int h_renamed = 0;
    private int i_renamed = 0;

    public m_renamed(android.app.Activity activity, android.view.ViewGroup viewGroup) {
        this.f6741a = null;
        this.f6742b = null;
        this.f6743c = 0;
        this.f6741a = activity;
        this.f6742b = viewGroup;
        this.f6743c = this.f6741a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.headline_change_move_distance);
    }

    public void a_renamed(com.oplus.camera.ui.modepanel.n_renamed.a_renamed aVar) {
        this.g_renamed = aVar;
    }

    private void f_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.f_renamed == null) {
            this.f_renamed = new com.oplus.camera.ui.modepanel.n_renamed(this.f6741a, this.f6742b);
            this.f_renamed.a_renamed(this.h_renamed, this.i_renamed);
            this.f_renamed.a_renamed(this.g_renamed);
        }
    }

    public void a_renamed(java.lang.String str) throws android.content.res.Resources.NotFoundException {
        f_renamed();
        this.f_renamed.a_renamed(str);
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.ui.modepanel.n_renamed nVar = this.f_renamed;
        if (nVar != null) {
            nVar.a_renamed(z_renamed);
        }
    }

    public void a_renamed(int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        this.h_renamed = i_renamed;
        this.i_renamed = i2;
        com.oplus.camera.ui.modepanel.n_renamed nVar = this.f_renamed;
        if (nVar != null) {
            nVar.a_renamed(i_renamed, this.i_renamed);
        }
    }

    public java.lang.String a_renamed() {
        com.oplus.camera.ui.modepanel.n_renamed nVar = this.f_renamed;
        return nVar != null ? nVar.a_renamed() : "";
    }

    public void a_renamed(boolean z_renamed, int i_renamed) throws android.content.res.Resources.NotFoundException {
        f_renamed();
        this.f_renamed.a_renamed(0, z_renamed, i_renamed);
    }

    public void a_renamed(android.view.animation.Animation animation) throws android.content.res.Resources.NotFoundException {
        a_renamed(animation, false);
    }

    public void a_renamed(android.view.animation.Animation animation, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        f_renamed();
        this.f_renamed.a_renamed(0, animation, z_renamed);
    }

    public void b_renamed() throws android.content.res.Resources.NotFoundException {
        f_renamed();
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(this.d_renamed);
        alphaAnimation.setDuration(250L);
        alphaAnimation.setStartOffset(150L);
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, this.f6743c, 0.0f);
        translateAnimation.setInterpolator(this.e_renamed);
        translateAnimation.setDuration(400L);
        translateAnimation.setStartOffset(150L);
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        this.f_renamed.a_renamed(0, (android.view.animation.Animation) animationSet, true);
    }

    public void b_renamed(boolean z_renamed, int i_renamed) {
        com.oplus.camera.ui.modepanel.n_renamed nVar = this.f_renamed;
        if (nVar != null) {
            nVar.a_renamed(8, z_renamed, i_renamed);
        }
    }

    public void b_renamed(android.view.animation.Animation animation) {
        com.oplus.camera.ui.modepanel.n_renamed nVar = this.f_renamed;
        if (nVar != null) {
            nVar.a_renamed(8, animation, false);
        }
    }

    public void c_renamed() {
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(this.d_renamed);
        alphaAnimation.setDuration(250L);
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, 0.0f, this.f6743c);
        translateAnimation.setInterpolator(this.e_renamed);
        translateAnimation.setDuration(400L);
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        com.oplus.camera.ui.modepanel.n_renamed nVar = this.f_renamed;
        if (nVar != null) {
            nVar.a_renamed(8, (android.view.animation.Animation) animationSet, true);
        }
    }

    public boolean d_renamed() {
        com.oplus.camera.ui.modepanel.n_renamed nVar = this.f_renamed;
        if (nVar != null) {
            return nVar.b_renamed();
        }
        return false;
    }

    public boolean e_renamed() {
        com.oplus.camera.ui.modepanel.n_renamed nVar = this.f_renamed;
        return nVar != null && nVar.c_renamed();
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.ui.modepanel.n_renamed nVar = this.f_renamed;
        if (nVar != null) {
            nVar.b_renamed(z_renamed);
        }
    }
}
