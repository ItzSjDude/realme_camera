package com.oplus.camera.ui.preview;

/* compiled from: NormalAISceneUI.java */
/* loaded from: classes2.dex */
public class t_renamed extends com.oplus.camera.ui.preview.a_renamed {
    private int n_renamed;
    private int q_renamed;
    private int r_renamed;
    private int x_renamed;
    private android.widget.RelativeLayout d_renamed = null;
    private com.oplus.camera.ui.menu.OplusTextView e_renamed = null;
    private android.widget.ImageView f_renamed = null;
    private com.oplus.camera.ui.menu.OplusTextView g_renamed = null;
    private android.widget.ImageView h_renamed = null;
    private com.oplus.camera.ui.preview.t_renamed.a_renamed i_renamed = null;
    private android.animation.AnimatorSet j_renamed = null;
    private android.animation.ObjectAnimator k_renamed = null;
    private com.oplus.camera.ui.preview.a_renamed.AISceneUI_2 l_renamed = null;
    private android.view.View.OnLayoutChangeListener m_renamed = null;
    private int o_renamed = 0;
    private int p_renamed = 0;
    private int s_renamed = 0;
    private int t_renamed = 0;
    private int u_renamed = 0;
    private int v_renamed = 0;
    private boolean w_renamed = false;

    public t_renamed(android.app.Activity activity, android.view.ViewGroup viewGroup, com.oplus.camera.ComboPreferences comboPreferences) {
        this.n_renamed = 0;
        this.q_renamed = 0;
        this.r_renamed = 0;
        this.x_renamed = 0;
        this.f6818a = activity;
        this.f6819b = viewGroup;
        this.f6820c = comboPreferences;
        this.n_renamed = this.f6818a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_margin);
        this.q_renamed = (int) (com.oplus.camera.util.Util.getScreenWidth() * 1.3333333333333333d);
        this.r_renamed = com.oplus.camera.util.Util.getScreenWidth();
        this.x_renamed = this.f6818a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.toast_margin_top);
    }

    private void l_renamed() {
        if (this.d_renamed != null || this.f6819b == null) {
            return;
        }
        this.f6818a.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.ai_scene_layout, this.f6819b);
        this.d_renamed = (android.widget.RelativeLayout) this.f6818a.findViewById(com.oplus.camera.R_renamed.id_renamed.ai_scene_layout);
        this.e_renamed = (com.oplus.camera.ui.menu.OplusTextView) this.d_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.ai_scene_text);
        this.f_renamed = (android.widget.ImageView) this.d_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.ai_scene_second_divide);
        this.g_renamed = (com.oplus.camera.ui.menu.OplusTextView) this.d_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.ai_scene_right_text);
        this.h_renamed = (android.widget.ImageView) this.d_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.ai_scene_close);
        if (this.j_renamed == null) {
            this.j_renamed = new android.animation.AnimatorSet();
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.d_renamed, (android.util.Property<android.widget.RelativeLayout, java.lang.Float>) android.view.View.SCALE_X, 0.0f, 1.0f);
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.d_renamed, (android.util.Property<android.widget.RelativeLayout, java.lang.Float>) android.view.View.SCALE_Y, 0.0f, 1.0f);
            this.j_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.35f, 2.0f, 0.0f, 1.0f));
            this.j_renamed.setDuration(240L);
            this.j_renamed.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
            this.j_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.t_renamed.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.preview.t_renamed.this.d_renamed != null) {
                        com.oplus.camera.ui.preview.t_renamed.this.d_renamed.setAlpha(1.0f);
                        com.oplus.camera.ui.preview.t_renamed.this.j_renamed(0);
                    }
                }
            });
        }
        if (this.k_renamed == null) {
            this.k_renamed = android.animation.ObjectAnimator.ofFloat(this.d_renamed, (android.util.Property<android.widget.RelativeLayout, java.lang.Float>) android.view.View.ALPHA, 1.0f, 0.0f);
            this.k_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
            this.k_renamed.setDuration(240L);
            this.k_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.t_renamed.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.preview.t_renamed.this.j_renamed(8);
                }
            });
        }
        android.widget.ImageView imageView = this.h_renamed;
        if (imageView != null) {
            imageView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.preview.t_renamed.3
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.oplus.camera.e_renamed.b_renamed("NormalAISceneUI", "mAISceneCloseView, onClick, code: " + view.getTag());
                    if (com.oplus.camera.ui.preview.t_renamed.this.l_renamed != null) {
                        com.oplus.camera.ui.preview.t_renamed.this.l_renamed.a_renamed(((java.lang.Integer) view.getTag()).intValue());
                    }
                }
            });
        }
        q_renamed();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void a_renamed(boolean z_renamed) {
        m_renamed();
        if (this.d_renamed != null && this.f6819b != null) {
            this.f6819b.removeView(this.d_renamed);
            this.d_renamed = null;
            this.e_renamed = null;
        }
        this.j_renamed = null;
        this.k_renamed = null;
        this.w_renamed = z_renamed;
        this.t_renamed = 0;
        this.u_renamed = 0;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void b_renamed(int i_renamed) {
        this.t_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void a_renamed(int i_renamed, int i2, int i3) {
        this.t_renamed = i_renamed;
        this.u_renamed = i3;
        i_renamed(i2);
        if (this.w_renamed) {
            return;
        }
        l_renamed();
        if (this.d_renamed == null) {
            return;
        }
        com.oplus.camera.ui.preview.t_renamed.a_renamed aVarA = a_renamed(i_renamed, i3);
        if (aVarA.a_renamed() == -1) {
            m_renamed();
            p_renamed();
            return;
        }
        this.e_renamed.setText(aVarA.a_renamed());
        if (aVarA.c_renamed()) {
            this.g_renamed.setText(aVarA.b_renamed());
            this.f_renamed.setVisibility(0);
            this.g_renamed.setVisibility(0);
        } else {
            this.g_renamed.setVisibility(8);
            this.f_renamed.setVisibility(8);
        }
        if (aVarA.d_renamed()) {
            this.h_renamed.setTag(java.lang.Integer.valueOf(i_renamed));
            this.h_renamed.setVisibility(0);
        } else {
            this.h_renamed.setVisibility(8);
        }
        f_renamed(i2);
        m_renamed();
        o_renamed();
    }

    private int a_renamed(android.view.View view) {
        if (view == null) {
            return 0;
        }
        view.measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.getScreenWidth());
        return view.getWidth();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.AISceneUI_2 interfaceC0133a) {
        this.l_renamed = interfaceC0133a;
    }

    private void m_renamed() {
        android.animation.ObjectAnimator objectAnimator = this.k_renamed;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.k_renamed.cancel();
        }
        android.animation.AnimatorSet animatorSet = this.j_renamed;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        this.j_renamed.cancel();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void h_renamed() {
        if (this.d_renamed != null) {
            m_renamed();
            p_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    protected void f_renamed(int i_renamed) {
        if (this.d_renamed != null) {
            i_renamed(i_renamed);
            if (this.w_renamed) {
                return;
            }
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
            this.d_renamed.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            int measuredWidth = this.d_renamed.getMeasuredWidth();
            int measuredHeight = this.d_renamed.getMeasuredHeight();
            this.d_renamed.layout(0, 0, measuredWidth, measuredHeight);
            if (this.o_renamed > 0) {
                int i2 = this.x_renamed;
            }
            if (i_renamed == 90) {
                layoutParams.addRule(9);
                layoutParams.addRule(10);
                layoutParams.leftMargin = (this.n_renamed + (measuredHeight / 2)) - (measuredWidth / 2);
                layoutParams.topMargin = (((this.q_renamed - measuredHeight) - this.o_renamed) / 2) + com.oplus.camera.util.Util.N_renamed();
            } else if (i_renamed == 270) {
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = (this.n_renamed + (measuredHeight / 2)) - (measuredWidth / 2);
                layoutParams.topMargin = (((this.q_renamed - measuredHeight) + this.o_renamed) / 2) + com.oplus.camera.util.Util.N_renamed();
            } else {
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.topMargin = com.oplus.camera.util.Util.N_renamed() + this.n_renamed + this.p_renamed + this.x_renamed;
                layoutParams.rightMargin = ((n_renamed() - measuredWidth) - this.o_renamed) / 2;
            }
            this.d_renamed.setZ(999.0f);
            this.d_renamed.setLayoutParams(layoutParams);
            this.d_renamed.setRotation(-this.s_renamed);
        }
    }

    private int n_renamed() {
        if (3 == this.v_renamed) {
            return this.r_renamed / 2;
        }
        return this.r_renamed;
    }

    private com.oplus.camera.ui.preview.t_renamed.a_renamed a_renamed(int i_renamed, int i2) {
        if (this.i_renamed == null) {
            this.i_renamed = new com.oplus.camera.ui.preview.t_renamed.a_renamed();
        }
        this.i_renamed.b_renamed(-1);
        this.i_renamed.a_renamed(false);
        this.i_renamed.b_renamed(false);
        switch (i_renamed) {
            case 1:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_beach);
                break;
            case 2:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_bluesky);
                break;
            case 3:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_cat);
                break;
            case 4:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_text);
                break;
            case 5:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_dog);
                break;
            case 6:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_firework);
                break;
            case 7:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_gourmet);
                break;
            case 8:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_grass);
                break;
            case 9:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_indoor);
                break;
            case 10:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_infant);
                break;
            case 11:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_landscape);
                break;
            case 12:
                com.oplus.camera.e_renamed.b_renamed("NormalAISceneUI", "getDataByAIScene, subCode: " + i2);
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_night);
                if (i2 != 1) {
                    if (i2 == 2) {
                        this.i_renamed.b_renamed(-1);
                        this.i_renamed.a_renamed(false);
                        this.i_renamed.b_renamed(true);
                        break;
                    }
                } else {
                    this.i_renamed.b_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_night_capture_tips);
                    this.i_renamed.a_renamed(true);
                    this.i_renamed.b_renamed(true);
                    break;
                }
                break;
            case 13:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_snow);
                break;
            case 14:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_spotlight);
                break;
            case 15:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_sunset);
                break;
            case 16:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_portrait);
                break;
            case 17:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_multi_portrait);
                break;
            case 18:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_microspur);
                break;
            case 19:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_backlight);
                break;
            case 20:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_purecolor);
                break;
            case 21:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_moire);
                break;
            case 22:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_flower);
                break;
            case 23:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_plant);
                break;
            case 24:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_birds);
                break;
            case 25:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_architecture);
                break;
            case 26:
                this.i_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_video_hdr);
                break;
            default:
                this.i_renamed.a_renamed(-1);
                break;
        }
        return this.i_renamed;
    }

    private void i_renamed(int i_renamed) {
        if (i_renamed == 180) {
            this.s_renamed = 0;
        } else {
            this.s_renamed = i_renamed;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void a_renamed(boolean z_renamed, boolean z2) {
        this.w_renamed = z_renamed;
        l_renamed();
        android.widget.RelativeLayout relativeLayout = this.d_renamed;
        if (relativeLayout != null) {
            if (this.w_renamed) {
                if (relativeLayout.getVisibility() == 0) {
                    j_renamed(8);
                }
            } else {
                if (!z2 || relativeLayout.getVisibility() == 0) {
                    return;
                }
                a_renamed(this.t_renamed, this.s_renamed, this.u_renamed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j_renamed(int i_renamed) {
        android.widget.RelativeLayout relativeLayout = this.d_renamed;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() != i_renamed) {
                this.d_renamed.setVisibility(i_renamed);
            }
            com.oplus.camera.ui.preview.a_renamed.AISceneUI_2 interfaceC0133a = this.l_renamed;
            if (interfaceC0133a != null) {
                if (i_renamed != 0) {
                    interfaceC0133a.b_renamed(0);
                } else {
                    interfaceC0133a.b_renamed(b_renamed());
                }
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public int b_renamed() {
        android.widget.RelativeLayout relativeLayout = this.d_renamed;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return 0;
        }
        return a_renamed(this.d_renamed);
    }

    private void o_renamed() {
        android.animation.AnimatorSet animatorSet = this.j_renamed;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    private void p_renamed() {
        if (this.k_renamed == null || this.d_renamed.getVisibility() != 0) {
            return;
        }
        this.k_renamed.start();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void g_renamed(int i_renamed) {
        f_renamed(i_renamed);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public int f_renamed() {
        return this.t_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void a_renamed(android.view.View.OnLayoutChangeListener onLayoutChangeListener) {
        this.m_renamed = onLayoutChangeListener;
        q_renamed();
    }

    private void q_renamed() {
        android.view.View.OnLayoutChangeListener onLayoutChangeListener;
        android.widget.RelativeLayout relativeLayout = this.d_renamed;
        if (relativeLayout == null || (onLayoutChangeListener = this.m_renamed) == null) {
            return;
        }
        relativeLayout.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public boolean c_renamed() {
        android.widget.RelativeLayout relativeLayout = this.d_renamed;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void a_renamed(int i_renamed) {
        this.p_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public int a_renamed() {
        return this.n_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public boolean i_renamed() {
        android.widget.RelativeLayout relativeLayout = this.d_renamed;
        if (relativeLayout == null) {
            return false;
        }
        return relativeLayout.isShown();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public boolean j_renamed() {
        android.animation.ObjectAnimator objectAnimator = this.k_renamed;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public android.widget.RelativeLayout g_renamed() {
        return this.d_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void h_renamed(int i_renamed) {
        this.v_renamed = i_renamed;
    }

    /* compiled from: NormalAISceneUI.java */
    private class a_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f7147b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f7148c;
        private boolean d_renamed;
        private boolean e_renamed;

        private a_renamed() {
            this.f7147b = -1;
            this.f7148c = -1;
            this.d_renamed = false;
            this.e_renamed = false;
        }

        public void a_renamed(int i_renamed) {
            this.f7147b = i_renamed;
        }

        public void b_renamed(int i_renamed) {
            this.f7148c = i_renamed;
        }

        public void a_renamed(boolean z_renamed) {
            this.d_renamed = z_renamed;
        }

        public void b_renamed(boolean z_renamed) {
            this.e_renamed = z_renamed;
        }

        public int a_renamed() {
            return this.f7147b;
        }

        public int b_renamed() {
            return this.f7148c;
        }

        public boolean c_renamed() {
            return this.d_renamed;
        }

        public boolean d_renamed() {
            return this.e_renamed;
        }
    }
}
