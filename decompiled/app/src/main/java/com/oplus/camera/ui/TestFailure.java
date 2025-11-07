package com.oplus.camera.ui;

/* compiled from: CompoundHintView.java */
/* loaded from: classes2.dex */
public class f_renamed {
    private java.lang.CharSequence e_renamed;
    private final com.oplus.camera.ui.menu.OplusTextView h_renamed;
    private final com.oplus.camera.ui.menu.OplusTextView i_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.view.animation.PathInterpolator f6209a = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6210b = -1;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6211c = -1;
    private int d_renamed = -1;
    private int f_renamed = 0;
    private boolean g_renamed = false;

    public f_renamed(android.view.ViewGroup viewGroup) {
        this.h_renamed = (com.oplus.camera.ui.menu.OplusTextView) viewGroup.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_screen_hint_text);
        this.i_renamed = (com.oplus.camera.ui.menu.OplusTextView) viewGroup.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_screen_aux_hint_text);
    }

    public void a_renamed() {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.h_renamed;
        if (oplusTextView != null) {
            this.f_renamed = oplusTextView.getMeasuredHeight();
        }
    }

    public final void a_renamed(java.lang.CharSequence charSequence) {
        com.oplus.camera.e_renamed.f_renamed("CompoundHintView", "setText:" + ((java.lang.Object) charSequence));
        if (this.i_renamed != null) {
            java.lang.CharSequence charSequenceB = b_renamed();
            if (!android.text.TextUtils.equals(this.e_renamed, charSequenceB)) {
                this.i_renamed.setText(charSequenceB);
                this.i_renamed.clearAnimation();
                this.i_renamed.setVisibility(4);
            }
            this.e_renamed = null;
        }
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.h_renamed;
        if (oplusTextView != null) {
            oplusTextView.setText(charSequence);
        }
    }

    public java.lang.CharSequence b_renamed() {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.h_renamed;
        return oplusTextView != null ? oplusTextView.getText() : "";
    }

    public void a_renamed(float f_renamed) {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.h_renamed;
        if (oplusTextView != null) {
            oplusTextView.setAlpha(f_renamed);
        }
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.h_renamed;
        if (oplusTextView != null) {
            oplusTextView.setVisibility(i_renamed);
        }
    }

    public int c_renamed() {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.h_renamed;
        if (oplusTextView != null) {
            return oplusTextView.getVisibility();
        }
        return 8;
    }

    public boolean d_renamed() {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.h_renamed;
        return oplusTextView != null && oplusTextView.getVisibility() == 0;
    }

    public boolean e_renamed() {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.h_renamed;
        if (oplusTextView != null) {
            return oplusTextView.isShown();
        }
        return false;
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.i_renamed;
        if (oplusTextView != null) {
            oplusTextView.a_renamed(i_renamed, z_renamed);
            this.i_renamed.invalidate();
        }
        com.oplus.camera.ui.menu.OplusTextView oplusTextView2 = this.h_renamed;
        if (oplusTextView2 != null) {
            oplusTextView2.a_renamed(i_renamed, z_renamed);
            this.h_renamed.invalidate();
        }
    }

    public com.oplus.camera.ui.menu.OplusTextView f_renamed() {
        return this.h_renamed;
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.h_renamed;
        if (oplusTextView == null || -1 == i_renamed || oplusTextView.getBackground() == null) {
            return;
        }
        this.h_renamed.setBackgroundResource(i_renamed);
    }

    public void a_renamed(int i_renamed, int i2, int i3) {
        if (this.i_renamed != null) {
            int i4 = this.f6211c;
            if (i4 == -1) {
                i4 = i_renamed;
            }
            this.i_renamed.setBackgroundResource(i4);
            int i5 = this.d_renamed;
            if (i5 == -1) {
                i5 = i2;
            }
            com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.i_renamed;
            oplusTextView.setTextColor(oplusTextView.getResources().getColor(i5));
        }
        this.f6211c = i_renamed;
        this.d_renamed = i2;
        com.oplus.camera.ui.menu.OplusTextView oplusTextView2 = this.h_renamed;
        if (oplusTextView2 == null || -1 == i2 || i2 == 0) {
            return;
        }
        if (-1 != i3 && i_renamed != 0) {
            oplusTextView2.setBackgroundResource(i3);
        } else {
            this.h_renamed.setBackgroundResource(i_renamed);
        }
        com.oplus.camera.ui.menu.OplusTextView oplusTextView3 = this.h_renamed;
        oplusTextView3.setTextColor(oplusTextView3.getResources().getColor(i2));
    }

    public void c_renamed(int i_renamed) {
        if (this.i_renamed != null) {
            int i2 = this.f6210b;
            if (i2 == -1) {
                i2 = i_renamed;
            }
            if (i2 == 0) {
                com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.i_renamed;
                oplusTextView.setShadowLayer(4.0f, 0.0f, 0.0f, oplusTextView.getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_70_percent_transparency));
            } else {
                this.i_renamed.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
        this.f6210b = i_renamed;
        com.oplus.camera.ui.menu.OplusTextView oplusTextView2 = this.h_renamed;
        if (oplusTextView2 != null) {
            if (i_renamed == 0) {
                oplusTextView2.setShadowLayer(4.0f, 0.0f, 0.0f, oplusTextView2.getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_70_percent_transparency));
            } else {
                oplusTextView2.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    public void g_renamed() {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.i_renamed;
        if (oplusTextView != null) {
            oplusTextView.clearAnimation();
            this.i_renamed.setVisibility(4);
        }
        com.oplus.camera.ui.menu.OplusTextView oplusTextView2 = this.h_renamed;
        if (oplusTextView2 != null) {
            oplusTextView2.clearAnimation();
        }
    }

    public void h_renamed() {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.i_renamed;
        if (oplusTextView != null) {
            oplusTextView.setText((java.lang.CharSequence) null);
        }
    }

    public void a_renamed(android.view.animation.Animation animation, boolean z_renamed) {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.i_renamed;
        if (oplusTextView != null) {
            if (!z_renamed) {
                this.e_renamed = this.h_renamed.getText();
                this.i_renamed.setText((java.lang.CharSequence) null);
                this.i_renamed.clearAnimation();
                this.i_renamed.setVisibility(4);
            } else if (!android.text.TextUtils.isEmpty(oplusTextView.getText().toString())) {
                animation.setStartOffset(150L);
                this.i_renamed.clearAnimation();
                this.i_renamed.setVisibility(0);
                android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setInterpolator(this.f6209a);
                alphaAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ui.f_renamed.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(android.view.animation.Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(android.view.animation.Animation animation2) {
                        com.oplus.camera.ui.f_renamed.this.g_renamed = true;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(android.view.animation.Animation animation2) {
                        com.oplus.camera.ui.f_renamed.this.g_renamed = false;
                        com.oplus.camera.ui.f_renamed.this.i_renamed.setVisibility(4);
                    }
                });
                this.i_renamed.startAnimation(alphaAnimation);
            }
        }
        com.oplus.camera.ui.menu.OplusTextView oplusTextView2 = this.h_renamed;
        if (oplusTextView2 != null) {
            oplusTextView2.startAnimation(animation);
        }
    }

    public final void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.h_renamed;
        if (oplusTextView != null) {
            oplusTextView.measure(i_renamed, i2);
        }
        com.oplus.camera.ui.menu.OplusTextView oplusTextView2 = this.i_renamed;
        if (oplusTextView2 != null) {
            oplusTextView2.measure(i_renamed, i2);
        }
    }

    public void b_renamed(int i_renamed, int i2, int i3) {
        int measuredWidth = i_renamed - (this.i_renamed.getMeasuredWidth() / 2);
        int measuredHeight = i2 - (this.i_renamed.getMeasuredHeight() / 2);
        int measuredHeight2 = (this.f_renamed - this.i_renamed.getMeasuredHeight()) / 2;
        if (i3 == 90) {
            measuredWidth -= measuredHeight2;
        } else if (i3 != 270) {
            measuredHeight -= measuredHeight2;
        } else {
            measuredWidth += measuredHeight2;
        }
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.i_renamed;
        oplusTextView.layout(measuredWidth, measuredHeight, oplusTextView.getMeasuredWidth() + measuredWidth, this.i_renamed.getMeasuredHeight() + measuredHeight);
        int measuredWidth2 = i_renamed - (this.h_renamed.getMeasuredWidth() / 2);
        int measuredHeight3 = i2 - (this.h_renamed.getMeasuredHeight() / 2);
        com.oplus.camera.ui.menu.OplusTextView oplusTextView2 = this.h_renamed;
        oplusTextView2.layout(measuredWidth2, measuredHeight3, oplusTextView2.getMeasuredWidth() + measuredWidth2, this.h_renamed.getMeasuredHeight() + measuredHeight3);
    }

    public int i_renamed() {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.h_renamed;
        if (oplusTextView != null) {
            return oplusTextView.getViewWidth();
        }
        return 0;
    }

    public int j_renamed() {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.h_renamed;
        if (oplusTextView != null) {
            return oplusTextView.getViewHeight();
        }
        return 0;
    }

    public final int k_renamed() {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.h_renamed;
        if (oplusTextView != null) {
            return oplusTextView.getMeasuredWidth();
        }
        return 0;
    }

    public final int l_renamed() {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.h_renamed;
        if (oplusTextView != null) {
            return oplusTextView.getMeasuredHeight();
        }
        return 0;
    }

    public void d_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.i_renamed;
        if (oplusTextView != null) {
            oplusTextView.setMaxWidth(i_renamed);
        }
        com.oplus.camera.ui.menu.OplusTextView oplusTextView2 = this.h_renamed;
        if (oplusTextView2 != null) {
            oplusTextView2.setMaxWidth(i_renamed);
        }
    }
}
