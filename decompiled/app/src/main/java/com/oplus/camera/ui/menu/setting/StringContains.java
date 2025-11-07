package com.oplus.camera.ui.menu.setting;

/* compiled from: CameraMenuOptionSecondLevel.java */
/* loaded from: classes2.dex */
public class j_renamed extends com.oplus.camera.ui.menu.setting.CameraMenuOption implements android.view.View.OnClickListener, android.view.View.OnTouchListener, com.oplus.camera.ui.inverse.a_renamed {
    private final android.view.animation.PathInterpolator r_renamed;
    private final android.animation.ArgbEvaluator s_renamed;
    private com.oplus.camera.ui.RotateImageView t_renamed;
    private com.oplus.camera.ui.widget.c_renamed u_renamed;
    private boolean v_renamed;
    private boolean w_renamed;

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void b_renamed(boolean z_renamed) {
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    protected boolean s_renamed() {
        return true;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public int z_renamed() {
        return 1;
    }

    public j_renamed(com.oplus.camera.ComboPreferences comboPreferences, android.content.Context context, com.oplus.camera.ui.CameraUIListener cameraUIListener, int i_renamed) {
        super(comboPreferences, context, null, null, cameraUIListener, i_renamed, null);
        this.r_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.s_renamed = new android.animation.ArgbEvaluator();
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = false;
        this.w_renamed = false;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void b_renamed() {
        this.t_renamed = new com.oplus.camera.ui.RotateImageView(this.k_renamed);
        this.t_renamed.setOnClickListener(this);
        this.t_renamed.setOnTouchListener(this);
        this.t_renamed.setLayoutParams(new android.view.ViewGroup.LayoutParams(this.k_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_width), this.k_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_height)));
        this.t_renamed.setBackground(androidx.core.a_renamed.a_renamed.a_renamed(this.k_renamed, com.oplus.camera.R_renamed.drawable.drawer_item_iv_background).mutate());
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.k_renamed, this);
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(android.view.View view) {
        this.t_renamed = (com.oplus.camera.ui.RotateImageView) view;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public android.view.View J_renamed() {
        return this.t_renamed;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (this.m_renamed != null) {
            this.m_renamed.a_renamed(this);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        super.a_renamed(view, motionEvent);
        return false;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void w_renamed() {
        com.oplus.camera.ui.widget.c_renamed cVar = this.u_renamed;
        if (cVar != null) {
            if (cVar.isShowing()) {
                this.u_renamed.dismiss();
            }
            this.u_renamed = null;
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(final java.lang.String str, java.lang.String str2, final java.lang.String str3, final int i_renamed, final int i2) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        if (this.u_renamed != null) {
            w_renamed();
        }
        if (this.t_renamed != null) {
            this.u_renamed = new com.oplus.camera.ui.widget.c_renamed(this.k_renamed);
            this.u_renamed.a_renamed(true);
            this.u_renamed.a_renamed(str2);
            this.u_renamed.setTouchInterceptor(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$j_renamed$gJqMt1VT08CVyMyJH7kPUoloYbg
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    return this.f_renamed$0.a_renamed(str, str3, view, motionEvent);
                }
            });
            if (this.u_renamed.isShowing()) {
                return;
            }
            this.t_renamed.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.ui.menu.setting.j_renamed.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (com.oplus.camera.ui.menu.setting.j_renamed.this.G_renamed() == 0) {
                        com.oplus.camera.ui.menu.setting.j_renamed.this.t_renamed.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        try {
                            com.oplus.camera.ui.menu.setting.j_renamed.this.u_renamed.a_renamed(i_renamed, i2);
                            com.oplus.camera.ui.menu.setting.j_renamed.this.u_renamed.a_renamed(com.oplus.camera.ui.menu.setting.j_renamed.this.t_renamed, 4);
                        } catch (android.view.WindowManager.BadTokenException e_renamed) {
                            com.oplus.camera.e_renamed.e_renamed("CameraMenuOptionSecondLevel", "showSubMenuOptionTipsBubble, exception: " + e_renamed.getMessage());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a_renamed(java.lang.String str, java.lang.String str2, android.view.View view, android.view.MotionEvent motionEvent) {
        w_renamed();
        if (this.f6559a != null && str != null) {
            android.content.SharedPreferences.Editor editorEdit = this.f6559a.edit();
            editorEdit.putBoolean(str + "_" + str2, false);
            editorEdit.apply();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public int B_renamed() {
        if (this.t_renamed != null) {
            if (1 == this.n_renamed.ca_renamed()) {
                return this.k_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_second_level_item_width);
            }
            return this.k_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_width);
        }
        return super.B_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public int C_renamed() {
        if (this.t_renamed != null) {
            if (1 == this.n_renamed.ca_renamed()) {
                return this.k_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_second_level_item_width);
            }
            return this.k_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_width);
        }
        return super.C_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void h_renamed(java.lang.String str) {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.t_renamed;
        if (rotateImageView != null) {
            rotateImageView.setContentDescription(str);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(android.graphics.drawable.Drawable drawable, boolean z_renamed) {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.t_renamed;
        if (rotateImageView != null) {
            rotateImageView.setImageDrawable(drawable);
        }
    }

    public void b_renamed(android.graphics.drawable.Drawable drawable, boolean z_renamed) {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.t_renamed;
        if (rotateImageView != null) {
            rotateImageView.setImageDrawable(drawable);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.t_renamed;
        if (rotateImageView != null) {
            rotateImageView.a_renamed(i_renamed, z_renamed);
        }
        super.a_renamed(i_renamed, z_renamed);
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    protected void A_renamed() {
        if (this.t_renamed != null) {
            super.A_renamed();
            a_renamed((android.view.View) null);
            com.oplus.camera.ui.inverse.e_renamed.INS.unRegisterInverse(this.k_renamed, this);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void d_renamed(boolean z_renamed) {
        h_renamed(z_renamed);
        com.oplus.camera.ui.RotateImageView rotateImageView = this.t_renamed;
        if (rotateImageView != null) {
            rotateImageView.setSelected(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(boolean z_renamed, boolean z2, long j_renamed) {
        if (this.w_renamed == z_renamed) {
            return;
        }
        this.w_renamed = z_renamed;
        if (!z2) {
            h_renamed(this.t_renamed.isSelected());
            return;
        }
        if (this.t_renamed.isSelected()) {
            return;
        }
        int color = this.k_renamed.getColor(com.oplus.camera.R_renamed.color.color_white_with_15_percent_transparency);
        int color2 = this.k_renamed.getColor(com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency);
        android.animation.ArgbEvaluator argbEvaluator = this.s_renamed;
        java.lang.Object[] objArr = new java.lang.Object[2];
        objArr[0] = java.lang.Integer.valueOf(z_renamed ? color2 : color);
        if (!z_renamed) {
            color = color2;
        }
        objArr[1] = java.lang.Integer.valueOf(color);
        android.animation.ValueAnimator valueAnimatorOfObject = android.animation.ValueAnimator.ofObject(argbEvaluator, objArr);
        valueAnimatorOfObject.setInterpolator(this.r_renamed);
        valueAnimatorOfObject.setDuration(j_renamed);
        valueAnimatorOfObject.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.setting.j_renamed.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                if (com.oplus.camera.ui.menu.setting.j_renamed.this.t_renamed == null || com.oplus.camera.ui.menu.setting.j_renamed.this.t_renamed.isSelected()) {
                    return;
                }
                com.oplus.camera.ui.menu.setting.j_renamed.this.t_renamed.getBackground().setTint(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfObject.start();
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.v_renamed = z_renamed;
        com.oplus.camera.ui.RotateImageView rotateImageView = this.t_renamed;
        if (rotateImageView != null) {
            h_renamed(rotateImageView.isSelected());
        }
    }

    private void h_renamed(boolean z_renamed) {
        int color;
        int color2;
        if (this.t_renamed != null) {
            if (z_renamed) {
                if (this.v_renamed) {
                    color = this.k_renamed.getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency);
                    color2 = com.oplus.camera.util.Util.A_renamed(this.k_renamed);
                } else {
                    color = this.k_renamed.getColor(com.oplus.camera.R_renamed.color.color_black_with_85_percent_transparency);
                    color2 = com.oplus.camera.util.Util.A_renamed(this.k_renamed);
                }
            } else if (this.n_renamed != null && 1 == this.n_renamed.ca_renamed()) {
                color = this.k_renamed.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency);
                color2 = this.k_renamed.getColor(com.oplus.camera.R_renamed.color.color_white_with_0_percent_transparency);
            } else if (this.v_renamed) {
                color = this.k_renamed.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency);
                color2 = this.k_renamed.getColor(com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency);
            } else {
                color = this.k_renamed.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency);
                if (this.w_renamed) {
                    color2 = this.k_renamed.getColor(com.oplus.camera.R_renamed.color.color_white_with_15_percent_transparency);
                } else {
                    color2 = this.k_renamed.getColor(com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency);
                }
            }
            this.t_renamed.a_renamed(color, color2);
            this.t_renamed.invalidate();
        }
    }
}
