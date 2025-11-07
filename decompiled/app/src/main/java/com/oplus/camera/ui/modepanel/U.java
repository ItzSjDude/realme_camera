package com.oplus.camera.ui.modepanel;

/* compiled from: ModeTitle.java */
/* loaded from: classes2.dex */
public class n_renamed implements android.view.View.OnClickListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static android.graphics.Typeface f6744a;
    private android.app.Activity d_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.view.animation.PathInterpolator f6745b = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.view.animation.PathInterpolator f6746c = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private android.widget.RelativeLayout e_renamed = null;
    private android.widget.TextView f_renamed = null;
    private com.oplus.camera.ui.modepanel.n_renamed.a_renamed g_renamed = null;
    private int h_renamed = 8;
    private int i_renamed = 0;
    private int j_renamed = 0;
    private int k_renamed = 0;
    private boolean l_renamed = true;
    private boolean m_renamed = false;
    private com.oplus.camera.ui.menu.a_renamed.b_renamed n_renamed = null;
    private int o_renamed = 0;
    private int p_renamed = 0;
    private boolean q_renamed = false;

    /* compiled from: ModeTitle.java */
    public interface a_renamed {
        void a_renamed();
    }

    public n_renamed(android.app.Activity activity, android.view.ViewGroup viewGroup) {
        this.d_renamed = null;
        this.d_renamed = activity;
        a_renamed(viewGroup);
    }

    private void a_renamed(android.view.ViewGroup viewGroup) {
        this.d_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.mode_title, viewGroup);
        this.e_renamed = (android.widget.RelativeLayout) this.d_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.mode_title_layout);
        this.f_renamed = (android.widget.TextView) this.e_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.mode_name);
        this.f_renamed.setTypeface(f_renamed(), 1);
        this.e_renamed.setOnClickListener(this);
        this.i_renamed = this.d_renamed.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_menu_translate_y);
        this.n_renamed = (com.oplus.camera.ui.menu.a_renamed.b_renamed) this.d_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.headline_background);
        this.j_renamed = (this.d_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.head_line_background_space) - this.d_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.headline_margin_space)) * 2;
        this.k_renamed = 0;
        com.oplus.camera.ui.menu.a_renamed.b_renamed bVar = this.n_renamed;
        if (bVar != null) {
            bVar.a_renamed(this.e_renamed);
        }
    }

    private void d_renamed() throws android.content.res.Resources.NotFoundException {
        android.widget.RelativeLayout.LayoutParams layoutParams;
        int i_renamed;
        int dimensionPixelSize;
        e_renamed();
        android.content.res.Resources resources = this.d_renamed.getResources();
        int i2 = this.o_renamed;
        if (i2 == 1) {
            layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_title_height));
            layoutParams.addRule(21);
            layoutParams.addRule(12);
            int i3 = this.p_renamed;
            if (270 == i3 || 90 == i3) {
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_rotate_mode_title_margin_bottom);
            } else {
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_mode_title_margin_bottom);
            }
            this.f_renamed.measure(0, 0);
            int measuredWidth = this.f_renamed.getMeasuredWidth();
            if (this.m_renamed) {
                layoutParams.height = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_mode_title_double_line_height);
                layoutParams.bottomMargin += (resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_title_height) - layoutParams.height) / 2;
            }
            if (270 == this.p_renamed) {
                layoutParams.removeRule(21);
                layoutParams.addRule(14);
            } else {
                if (this.m_renamed) {
                    i_renamed = measuredWidth / 2;
                    dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_double_line_mode_name_tv_margin_right);
                } else if (measuredWidth >= resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_mode_title_width_threshold)) {
                    i_renamed = measuredWidth / 2;
                    dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_long_mode_name_tv_margin_right);
                } else {
                    i_renamed = measuredWidth / 2;
                    dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_mode_name_tv_margin_right);
                }
                layoutParams.setMarginEnd((resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_width_full) / 2) - (i_renamed + dimensionPixelSize));
            }
            if (this.m_renamed) {
                this.e_renamed.setBackground(this.d_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.mode_long_title_bg_vertical));
            } else {
                this.e_renamed.setBackground(this.d_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.mode_title_bg_vertical));
            }
            this.l_renamed = false;
            com.oplus.camera.ui.menu.a_renamed.b_renamed bVar = this.n_renamed;
            if (bVar != null) {
                bVar.b_renamed(this.e_renamed);
            }
        } else if (i2 == 4) {
            layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_title_height));
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_title_margin_bottom);
            this.e_renamed.setBackground(this.d_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.mode_title_bg_vertical));
        } else {
            layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            layoutParams.topMargin = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.mode_title_margin_top);
            this.e_renamed.setBackground(null);
            this.l_renamed = true;
            com.oplus.camera.ui.menu.a_renamed.b_renamed bVar2 = this.n_renamed;
            if (bVar2 != null) {
                bVar2.a_renamed(this.e_renamed);
            }
        }
        this.e_renamed.setLayoutParams(layoutParams);
        this.e_renamed.invalidate();
    }

    private void e_renamed() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.inverse.InverseImageView inverseImageView = (com.oplus.camera.ui.inverse.InverseImageView) this.d_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.mode_close);
        android.widget.TextView textView = this.f_renamed;
        if (textView == null || inverseImageView == null) {
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) textView.getLayoutParams();
        android.content.res.Resources resources = this.d_renamed.getResources();
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) inverseImageView.getLayoutParams();
        if (layoutParams == null || inverseImageView == null) {
            return;
        }
        int i_renamed = this.o_renamed;
        if (i_renamed == 1) {
            this.f_renamed.measure(0, 0);
            boolean z_renamed = this.f_renamed.getMeasuredWidth() >= this.d_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_mode_title_width_threshold);
            int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_mode_title_max_width);
            this.m_renamed = this.f_renamed.getMeasuredWidth() >= dimensionPixelOffset;
            if (this.m_renamed) {
                layoutParams.setMarginStart(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_double_line_mode_name_tv_margin_left));
                layoutParams2.setMarginStart(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_double_line_close_img_margin_left));
                layoutParams2.setMarginEnd(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_double_line_close_img_margin_right));
            } else if (z_renamed) {
                layoutParams.setMarginStart(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_long_mode_name_tv_margin_left));
                layoutParams2.setMarginStart(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_mode_close_img_margin_left));
                layoutParams2.setMarginEnd(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_long_mode_close_img_margin_right));
            } else {
                layoutParams.setMarginStart(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.mode_name_tv_margin_left));
                layoutParams2.setMarginStart(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_mode_close_img_margin_left));
                layoutParams2.setMarginEnd(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_mode_close_img_margin_right));
            }
            if (this.m_renamed) {
                java.lang.String string = this.f_renamed.getText().toString();
                if (this.f_renamed.getPaint().measureText(string.split("\\s_renamed")[0]) < dimensionPixelOffset) {
                    this.f_renamed.setText(string.replaceFirst(" ", "\n_renamed"));
                }
            }
            layoutParams2.removeRule(15);
            layoutParams2.addRule(10);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_mode_close_img_margin_top) + resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.headline_bg_fold_offset);
            layoutParams2.width = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_mode_close_img_width);
            layoutParams2.height = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_mode_close_img_width);
            this.f_renamed.setMaxWidth(dimensionPixelOffset);
            this.f_renamed.setSingleLine(false);
            this.f_renamed.setMaxLines(2);
            this.f_renamed.setGravity(1);
        } else if (i_renamed == 2 || i_renamed == 3 || i_renamed == 4) {
            layoutParams.addRule(14, 0);
            layoutParams.setMarginStart(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.mode_name_tv_margin_left));
            layoutParams2.setMarginStart(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.mode_close_img_margin_left));
            layoutParams2.setMarginEnd(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.mode_close_img_margin_right));
            layoutParams2.removeRule(15);
            layoutParams2.addRule(10);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_mode_close_img_margin_top) + resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.headline_bg_fold_offset);
            layoutParams2.width = -2;
            layoutParams2.height = -2;
            this.f_renamed.setMaxWidth(Integer.MAX_VALUE);
            this.f_renamed.setSingleLine(true);
            this.f_renamed.setTextAlignment(0);
        } else {
            layoutParams.addRule(14, 0);
            layoutParams.setMarginStart(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.mode_name_tv_margin_left));
            layoutParams2.setMarginStart(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.mode_close_img_margin_left));
            layoutParams2.setMarginEnd(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.mode_close_img_margin_right));
            layoutParams2.removeRule(10);
            layoutParams2.addRule(15);
            layoutParams2.width = -2;
            layoutParams2.height = -2;
            this.f_renamed.setMaxWidth(Integer.MAX_VALUE);
            this.f_renamed.setSingleLine(true);
            this.f_renamed.setTextAlignment(0);
        }
        inverseImageView.setLayoutParams(layoutParams2);
        this.f_renamed.setLayoutParams(layoutParams);
    }

    public void a_renamed(boolean z_renamed) {
        this.q_renamed = z_renamed;
    }

    public void a_renamed(int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        boolean z_renamed = this.o_renamed != i_renamed;
        this.o_renamed = i_renamed;
        this.p_renamed = i2;
        d_renamed();
        if ((b_renamed() || this.q_renamed) && z_renamed) {
            this.e_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.modepanel.n_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!com.oplus.camera.ui.modepanel.n_renamed.this.l_renamed || com.oplus.camera.ui.modepanel.n_renamed.this.n_renamed == null) {
                        if (com.oplus.camera.ui.modepanel.n_renamed.this.n_renamed != null) {
                            com.oplus.camera.ui.modepanel.n_renamed.this.n_renamed.setVisibility(4);
                        }
                    } else {
                        com.oplus.camera.ui.modepanel.n_renamed.this.n_renamed.a_renamed(com.oplus.camera.ui.modepanel.n_renamed.this.e_renamed.getWidth() + com.oplus.camera.ui.modepanel.n_renamed.this.j_renamed, com.oplus.camera.ui.modepanel.n_renamed.this.e_renamed.getHeight() + com.oplus.camera.ui.modepanel.n_renamed.this.k_renamed);
                        com.oplus.camera.ui.modepanel.n_renamed.this.n_renamed.invalidate();
                        com.oplus.camera.ui.modepanel.n_renamed.this.n_renamed.setAlpha(1.0f);
                        com.oplus.camera.ui.modepanel.n_renamed.this.n_renamed.setVisibility(com.oplus.camera.ui.modepanel.n_renamed.this.h_renamed);
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (this.g_renamed == null || this.e_renamed.getVisibility() != 0) {
            return;
        }
        if (this.e_renamed.getAnimation() == null || !this.e_renamed.getAnimation().hasStarted()) {
            this.g_renamed.a_renamed();
        }
    }

    public void a_renamed(java.lang.String str) throws android.content.res.Resources.NotFoundException {
        this.f_renamed.setText(str);
        this.e_renamed.setContentDescription(str);
        if (1 == this.o_renamed) {
            d_renamed();
        }
        this.e_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.modepanel.n_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                if (!com.oplus.camera.ui.modepanel.n_renamed.this.l_renamed || com.oplus.camera.ui.modepanel.n_renamed.this.n_renamed == null || com.oplus.camera.ui.modepanel.n_renamed.this.e_renamed == null) {
                    return;
                }
                com.oplus.camera.ui.modepanel.n_renamed.this.e_renamed.measure(0, 0);
                com.oplus.camera.ui.modepanel.n_renamed.this.n_renamed.a_renamed(com.oplus.camera.ui.modepanel.n_renamed.this.e_renamed.getMeasuredWidth() + com.oplus.camera.ui.modepanel.n_renamed.this.j_renamed, com.oplus.camera.ui.modepanel.n_renamed.this.e_renamed.getMeasuredHeight() + com.oplus.camera.ui.modepanel.n_renamed.this.k_renamed, 250, 0);
            }
        });
    }

    public java.lang.String a_renamed() {
        android.widget.TextView textView = this.f_renamed;
        if (textView == null || textView.getText() == null) {
            return "";
        }
        if (1 == this.o_renamed) {
            return this.f_renamed.getText().toString().replaceAll("\n_renamed", " ");
        }
        return (java.lang.String) this.f_renamed.getText();
    }

    public boolean b_renamed() {
        return this.h_renamed == 0;
    }

    private boolean a_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.a_renamed.b_renamed bVar;
        if (this.h_renamed == i_renamed) {
            return false;
        }
        this.h_renamed = i_renamed;
        if (!this.l_renamed || (bVar = this.n_renamed) == null) {
            return true;
        }
        bVar.setAlpha(1.0f);
        this.n_renamed.a_renamed(i_renamed, this.e_renamed);
        return true;
    }

    public void a_renamed(int i_renamed, android.view.animation.Animation animation, boolean z_renamed) {
        com.oplus.camera.ui.menu.a_renamed.b_renamed bVar;
        com.oplus.camera.e_renamed.a_renamed("ModeTitle", "setVisibility, visibility: " + i_renamed);
        if (a_renamed(i_renamed)) {
            if (i_renamed == 0) {
                a_renamed(animation);
            } else {
                b_renamed(animation);
            }
            if (z_renamed || !this.l_renamed || (bVar = this.n_renamed) == null) {
                return;
            }
            bVar.clearAnimation();
            if (animation != null) {
                this.n_renamed.startAnimation(animation);
            }
        }
    }

    public void a_renamed(int i_renamed, boolean z_renamed, int i2) {
        android.view.animation.AnimationSet animationSetC;
        com.oplus.camera.ui.menu.a_renamed.b_renamed bVar;
        com.oplus.camera.e_renamed.a_renamed("ModeTitle", "setVisibility, visibility: " + i_renamed);
        if (a_renamed(i_renamed)) {
            if (z_renamed) {
                if (i_renamed == 0) {
                    animationSetC = b_renamed(i2);
                    a_renamed(animationSetC);
                } else {
                    animationSetC = c_renamed(i2);
                    b_renamed(animationSetC);
                }
                if (!this.l_renamed || (bVar = this.n_renamed) == null) {
                    return;
                }
                bVar.clearAnimation();
                this.n_renamed.startAnimation(animationSetC);
                return;
            }
            if (this.e_renamed.getAnimation() != null) {
                this.e_renamed.clearAnimation();
            }
            this.e_renamed.setVisibility(i_renamed);
        }
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ModeTitle", "setEnable, enable: " + z_renamed);
        android.widget.RelativeLayout relativeLayout = this.e_renamed;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(z_renamed);
        }
    }

    public boolean c_renamed() {
        android.widget.RelativeLayout relativeLayout = this.e_renamed;
        return relativeLayout != null && relativeLayout.isEnabled();
    }

    private android.graphics.Typeface f_renamed() {
        android.graphics.Typeface typeface = f6744a;
        if (typeface != null) {
            return typeface;
        }
        f6744a = com.oplus.camera.util.Util.a_renamed((android.content.Context) this.d_renamed, true);
        return f6744a;
    }

    private void a_renamed(android.view.animation.Animation animation) {
        this.e_renamed.setVisibility(0);
        this.e_renamed.clearAnimation();
        if (animation != null) {
            this.e_renamed.startAnimation(animation);
        }
        this.e_renamed.setEnabled(true);
    }

    private void b_renamed(android.view.animation.Animation animation) {
        this.e_renamed.setVisibility(8);
        this.e_renamed.clearAnimation();
        if (animation != null) {
            this.e_renamed.startAnimation(animation);
        }
        this.e_renamed.setEnabled(false);
    }

    private android.view.animation.AnimationSet b_renamed(int i_renamed) {
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(false);
        if (i_renamed == 0) {
            android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setInterpolator(this.f6745b);
            alphaAnimation.setDuration(250L);
            animationSet.addAnimation(alphaAnimation);
        } else if (1 == i_renamed) {
            android.view.animation.AlphaAnimation alphaAnimation2 = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
            alphaAnimation2.setInterpolator(this.f6745b);
            alphaAnimation2.setDuration(250L);
            animationSet.addAnimation(alphaAnimation2);
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, -this.i_renamed, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setInterpolator(this.f6746c);
            animationSet.addAnimation(translateAnimation);
            animationSet.setStartOffset(150L);
        }
        return animationSet;
    }

    private android.view.animation.AnimationSet c_renamed(int i_renamed) {
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(false);
        if (i_renamed == 0) {
            android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setInterpolator(this.f6745b);
            alphaAnimation.setDuration(250L);
            animationSet.addAnimation(alphaAnimation);
        } else if (1 == i_renamed) {
            android.view.animation.AlphaAnimation alphaAnimation2 = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setInterpolator(this.f6745b);
            alphaAnimation2.setDuration(250L);
            animationSet.addAnimation(alphaAnimation2);
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, 0.0f, -this.i_renamed);
            translateAnimation.setDuration(400L);
            translateAnimation.setInterpolator(this.f6746c);
            animationSet.addAnimation(translateAnimation);
        }
        return animationSet;
    }

    public void a_renamed(com.oplus.camera.ui.modepanel.n_renamed.a_renamed aVar) {
        this.g_renamed = aVar;
    }
}
