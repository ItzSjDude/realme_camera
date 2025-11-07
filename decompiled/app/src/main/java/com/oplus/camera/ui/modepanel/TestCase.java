package com.oplus.camera.ui.modepanel;

/* compiled from: FloatViewContainer.java */
/* loaded from: classes2.dex */
public class e_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.app.Activity f6723c;
    private com.oplus.camera.screen.g_renamed f_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.modepanel.d_renamed f6721a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.ref.WeakReference<android.widget.FrameLayout> f6722b = null;
    private float d_renamed = 0.0f;
    private float e_renamed = 0.0f;
    private int g_renamed = 0;

    protected e_renamed(android.app.Activity activity, com.oplus.camera.screen.g_renamed gVar) {
        this.f6723c = null;
        this.f_renamed = null;
        this.f6723c = activity;
        this.f_renamed = gVar;
    }

    protected int a_renamed() {
        com.oplus.camera.ui.modepanel.d_renamed dVar = this.f6721a;
        if (dVar != null) {
            return dVar.getModeId();
        }
        return -1;
    }

    protected void a_renamed(com.oplus.camera.ui.modepanel.k_renamed kVar, int i_renamed, int i2, int i3, int i4) {
        synchronized (this) {
            if (1 != i_renamed && 2 != i_renamed) {
                com.oplus.camera.e_renamed.f_renamed("FloatViewContainer", "add, can't_renamed add float view, invalid type: " + i_renamed);
                return;
            }
            a_renamed(j_renamed());
            if (i_renamed() == null) {
                return;
            }
            if (this.f6721a != null) {
                return;
            }
            this.f6721a = new com.oplus.camera.ui.modepanel.d_renamed(this.f6723c);
            boolean z_renamed = 1 == this.f6723c.getResources().getConfiguration().getLayoutDirection();
            this.f6721a.setRotation(this.f_renamed.a_renamed().k_renamed());
            int[] iArr = {i2, i3};
            int[] iArrA = this.f_renamed.a_renamed().a_renamed(i2, i3);
            this.f6721a.setLayoutParams(a_renamed(i_renamed, iArrA[0], iArrA[1], kVar.a_renamed(), z_renamed, i4));
            this.f6721a.a_renamed(this.g_renamed, this.f_renamed.a_renamed().k_renamed());
            this.f6721a.a_renamed(kVar, i_renamed);
            i_renamed().addView(this.f6721a);
            this.f6721a.a_renamed(i_renamed);
        }
    }

    protected void b_renamed() {
        com.oplus.camera.ui.modepanel.d_renamed dVar = this.f6721a;
        if (dVar == null) {
            return;
        }
        dVar.setVisibility(8);
        android.widget.FrameLayout frameLayoutI = i_renamed();
        if (androidx.core.h_renamed.v_renamed.D_renamed(this.f6721a) && frameLayoutI != null) {
            frameLayoutI.removeView(this.f6721a);
            this.f6722b = null;
        }
        this.f6721a = null;
    }

    private void a_renamed(android.widget.FrameLayout frameLayout) {
        if (frameLayout == null || this.f6721a == null) {
            this.f6722b = new java.lang.ref.WeakReference<>(frameLayout);
            return;
        }
        if (i_renamed() != null && this.f6721a.getParent() == i_renamed()) {
            i_renamed().removeView(this.f6721a);
        }
        this.f6722b = new java.lang.ref.WeakReference<>(frameLayout);
        frameLayout.addView(this.f6721a);
    }

    private android.widget.FrameLayout i_renamed() {
        java.lang.ref.WeakReference<android.widget.FrameLayout> weakReference = this.f6722b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private android.widget.FrameLayout.LayoutParams a_renamed(int i_renamed, int i2, int i3, java.lang.String str, boolean z_renamed, int i4) throws android.content.res.Resources.NotFoundException {
        android.widget.FrameLayout.LayoutParams layoutParams;
        int dimensionPixelSize = this.f6723c.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.float_view_width);
        int dimensionPixelSize2 = this.f6723c.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.float_view_height);
        if (1 == i_renamed) {
            layoutParams = new android.widget.FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
            this.f6721a.setTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_measure_width, java.lang.Integer.valueOf(((int) this.f6721a.a_renamed(str, 1)) + (com.oplus.camera.k_renamed.g_renamed() * 2)));
        } else {
            layoutParams = new android.widget.FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
            this.f6721a.setTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_measure_width, java.lang.Integer.valueOf(i4));
        }
        layoutParams.gravity = com.google.android.material.badge.BadgeDrawable.TOP_START;
        layoutParams.setLayoutDirection(z_renamed ? 1 : 0);
        if (1 != i_renamed) {
            if (2 == i_renamed) {
                i2 = (int) (i2 - ((java.lang.Math.max(i4, com.oplus.camera.k_renamed.d_renamed()) - (this.f6721a.a_renamed(str, 2) + (com.oplus.camera.k_renamed.g_renamed() * 2))) / 2.0f));
                i3 = (int) (i3 - ((com.oplus.camera.k_renamed.e_renamed() - com.oplus.camera.k_renamed.a_renamed()) / 2.0f));
            } else {
                i2 = 0;
                i3 = 0;
            }
        }
        int[] iArrA = this.f_renamed.a_renamed().a_renamed(i2 + this.f6723c.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.float_view_container_left_margin_offset), i3 + this.f6723c.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.float_view_container_top_margin_offset), dimensionPixelSize, dimensionPixelSize2);
        int i5 = iArrA[0];
        int i6 = iArrA[1];
        if (z_renamed) {
            layoutParams.topMargin = i6;
            layoutParams.setMarginStart(i5);
        } else {
            layoutParams.setMargins(i5, i6, 0, 0);
        }
        return layoutParams;
    }

    private android.widget.FrameLayout j_renamed() {
        android.app.Activity activity = this.f6723c;
        if (activity == null) {
            return null;
        }
        try {
            return (android.widget.FrameLayout) activity.getWindow().getDecorView();
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.d_renamed("FloatViewContainer", "getActivityRoot error.", e_renamed);
            return null;
        }
    }

    protected boolean c_renamed() {
        com.oplus.camera.ui.modepanel.d_renamed dVar = this.f6721a;
        if (dVar != null) {
            return dVar.isShown();
        }
        return false;
    }

    protected boolean d_renamed() {
        com.oplus.camera.ui.modepanel.d_renamed dVar = this.f6721a;
        if (dVar != null) {
            return dVar.c_renamed();
        }
        return false;
    }

    protected void e_renamed() {
        com.oplus.camera.ui.modepanel.d_renamed dVar = this.f6721a;
        if (dVar != null) {
            dVar.a_renamed();
        }
    }

    protected void f_renamed() {
        com.oplus.camera.ui.modepanel.d_renamed dVar = this.f6721a;
        if (dVar != null) {
            dVar.b_renamed();
        }
    }

    protected void a_renamed(android.view.MotionEvent motionEvent) {
        float f_renamed;
        if (motionEvent.getAction() == 0) {
            this.d_renamed = motionEvent.getRawX();
            this.e_renamed = motionEvent.getRawY();
            return;
        }
        float f2 = 0.0f;
        if (2 == motionEvent.getAction()) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            f2 = rawX - this.d_renamed;
            f_renamed = rawY - this.e_renamed;
            this.d_renamed = rawX;
            this.e_renamed = rawY;
        } else {
            f_renamed = 0.0f;
        }
        com.oplus.camera.ui.modepanel.d_renamed dVar = this.f6721a;
        if (dVar != null) {
            dVar.a_renamed(f2, f_renamed);
        }
    }

    protected android.graphics.Rect g_renamed() {
        com.oplus.camera.ui.modepanel.d_renamed dVar = this.f6721a;
        if (dVar != null) {
            return dVar.getFloatLocation();
        }
        return null;
    }

    protected float h_renamed() {
        com.oplus.camera.ui.modepanel.d_renamed dVar = this.f6721a;
        if (dVar != null) {
            return dVar.getTextTranslationY();
        }
        return 0.0f;
    }

    protected void a_renamed(android.graphics.Rect rect, int i_renamed) {
        com.oplus.camera.ui.modepanel.d_renamed dVar;
        if (rect == null || (dVar = this.f6721a) == null) {
            com.oplus.camera.e_renamed.f_renamed("FloatViewContainer", "adsorpt, params invalid, targetRect: " + rect + ", mFloatView: " + this.f6721a);
            return;
        }
        dVar.a_renamed(rect, i_renamed);
    }

    public void a_renamed(int i_renamed) {
        this.g_renamed = i_renamed;
        com.oplus.camera.ui.modepanel.d_renamed dVar = this.f6721a;
        if (dVar != null) {
            dVar.a_renamed(this.g_renamed, this.f_renamed.a_renamed().k_renamed());
            if (this.f6721a.getVisibility() == 0) {
                this.f6721a.setVisibility(4);
                this.f6721a = null;
            }
        }
        com.oplus.camera.k_renamed.a_renamed(this.f6723c, i_renamed);
    }
}
