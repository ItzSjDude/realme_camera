package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: FilterEffectMenu.java */
/* loaded from: classes2.dex */
public class g_renamed extends com.oplus.camera.ui.menu.setting.q_renamed {
    private int A_renamed;
    private com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed B_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6520a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.app.Activity f6521b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.RelativeLayout f6522c;
    private android.widget.RelativeLayout d_renamed;
    private com.oplus.camera.ui.inverse.InverseTextView e_renamed;
    private com.oplus.camera.ui.inverse.InverseTextView f_renamed;
    private com.oplus.camera.ui.menu.levelcontrol.b_renamed g_renamed;
    private com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed h_renamed;
    private android.os.Handler i_renamed;
    private android.animation.AnimatorSet j_renamed;
    private java.util.List<java.lang.String> k_renamed;
    private int l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private int r_renamed;
    private int s_renamed;
    private int t_renamed;
    private int u_renamed;
    private android.animation.AnimatorSet v_renamed;
    private android.animation.AnimatorSet w_renamed;
    private android.animation.AnimatorSet x_renamed;
    private android.view.animation.PathInterpolator y_renamed;
    private android.view.animation.PathInterpolator z_renamed;

    /* compiled from: FilterEffectMenu.java */
    public interface a_renamed {
        void a_renamed();

        void a_renamed(int i_renamed, boolean z_renamed);

        void a_renamed(com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar);

        void a_renamed(java.lang.String str);

        void a_renamed(boolean z_renamed);

        boolean a_renamed(int i_renamed);

        void b_renamed(java.lang.String str);

        boolean b_renamed();

        boolean c_renamed();

        boolean d_renamed();

        int e_renamed();

        int f_renamed();

        boolean g_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.q_renamed
    public void showMenuPanel(java.lang.String str, boolean z_renamed, boolean z2) {
        if (this.mbExitAnimationRunning) {
            com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "showMenuPanel, ExitAnimatorSet.isRunning, return");
            return;
        }
        com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed aVar = this.h_renamed;
        if (aVar == null || (!aVar.d_renamed() && !z_renamed)) {
            com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "showMenuPanel, mMenuListener null, return!");
            return;
        }
        if (this.h_renamed.b_renamed() || z_renamed) {
            this.r_renamed = 1;
            this.h_renamed.b_renamed(com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER);
            f_renamed(true);
        }
        super.showMenuPanel(str, z_renamed, false);
    }

    public void a_renamed() {
        b_renamed();
        com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
            if (bVar instanceof com.oplus.camera.ui.menu.levelcontrol.HorizontalScrollBar) {
                ((com.oplus.camera.ui.menu.levelcontrol.HorizontalScrollBar) bVar).setRearMirrorEnable(aVar.g_renamed());
            }
        }
        android.animation.AnimatorSet animatorSet = this.w_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.w_renamed.cancel();
        }
        android.animation.AnimatorSet animatorSet2 = this.x_renamed;
        if (animatorSet2 != null && animatorSet2.isStarted()) {
            this.x_renamed.cancel();
        }
        this.r_renamed = 1;
        com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed aVar2 = this.h_renamed;
        if (aVar2 != null) {
            aVar2.b_renamed(com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER);
        }
        if (this.k_renamed == null) {
            com.oplus.camera.e_renamed.f_renamed("FilterEffectMenu", "showBeautyFilterPanel, mCurrMenuNames is_renamed null.");
            return;
        }
        this.m_renamed = true;
        j_renamed();
        this.g_renamed.setFilterCategory(this.B_renamed);
        this.d_renamed.setVisibility(0);
        this.g_renamed.setAlpha(0.0f);
        this.g_renamed.setVisibility(0);
        if (this.v_renamed == null) {
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.g_renamed, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setInterpolator(this.y_renamed);
            objectAnimatorOfFloat.setDuration(400L);
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.g_renamed, getAnimationTranslateProp(), getAnimationTranslateDistance(), 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.z_renamed);
            objectAnimatorOfFloat2.setDuration(400L);
            this.v_renamed = new android.animation.AnimatorSet();
            this.v_renamed.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
            this.v_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.levelcontrol.g_renamed.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.g_renamed.setAlpha(0.0f);
                    com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.g_renamed.setVisibility(0);
                }
            });
        }
        this.v_renamed.setStartDelay(this.A_renamed);
        this.v_renamed.start();
    }

    public void setBeautyShowDelay(int i_renamed) {
        this.A_renamed = i_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        b_renamed();
        c_renamed(z_renamed);
    }

    public void b_renamed(boolean z_renamed) {
        if (isEffectMenuOpen()) {
            b_renamed();
            d_renamed(z_renamed);
        }
    }

    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar;
        com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "hideFilterEffectMenu, needAni: " + z_renamed);
        android.animation.AnimatorSet animatorSet = this.v_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.v_renamed.cancel();
        }
        android.os.Handler handler = this.i_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.m_renamed = false;
        android.animation.AnimatorSet animatorSet2 = this.w_renamed;
        if ((animatorSet2 == null || !animatorSet2.isStarted()) && (bVar = this.g_renamed) != null && bVar.isShown()) {
            if (z_renamed) {
                if (this.w_renamed == null) {
                    android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.g_renamed, "alpha", 1.0f, 0.0f);
                    objectAnimatorOfFloat.setInterpolator(this.y_renamed);
                    objectAnimatorOfFloat.setDuration(250L);
                    android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.g_renamed, "scaleX", 1.0f, 0.9f);
                    objectAnimatorOfFloat2.setInterpolator(this.z_renamed);
                    objectAnimatorOfFloat2.setDuration(400L);
                    android.animation.ObjectAnimator objectAnimatorOfFloat3 = android.animation.ObjectAnimator.ofFloat(this.g_renamed, "scaleY", 1.0f, 0.9f);
                    objectAnimatorOfFloat3.setInterpolator(this.z_renamed);
                    objectAnimatorOfFloat3.setDuration(400L);
                    this.w_renamed = new android.animation.AnimatorSet();
                    this.w_renamed.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat);
                    this.w_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.levelcontrol.g_renamed.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(android.animation.Animator animator) {
                            com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.g_renamed.setVisibility(0);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(android.animation.Animator animator) {
                            com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.g_renamed.setVisibility(8);
                            com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.g_renamed.setScaleY(1.0f);
                            com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.g_renamed.setScaleX(1.0f);
                        }
                    });
                }
                this.w_renamed.start();
                return;
            }
            this.g_renamed.setVisibility(8);
            this.g_renamed.setScaleY(1.0f);
            this.g_renamed.setScaleX(1.0f);
        }
    }

    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar;
        com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "closeFaceBeautyAnimator, needAni: " + z_renamed);
        android.animation.AnimatorSet animatorSet = this.v_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.v_renamed.cancel();
        }
        android.os.Handler handler = this.i_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.m_renamed = false;
        android.animation.AnimatorSet animatorSet2 = this.x_renamed;
        if ((animatorSet2 == null || !animatorSet2.isStarted()) && (bVar = this.g_renamed) != null && bVar.isShown()) {
            if (z_renamed) {
                if (this.x_renamed == null) {
                    android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.g_renamed, getAnimationTranslateProp(), 0.0f, getAnimationTranslateDistance());
                    objectAnimatorOfFloat.setInterpolator(this.z_renamed);
                    objectAnimatorOfFloat.setDuration(400L);
                    android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.g_renamed, "alpha", 1.0f, 0.0f);
                    objectAnimatorOfFloat2.setInterpolator(this.y_renamed);
                    objectAnimatorOfFloat2.setDuration(250L);
                    this.x_renamed = new android.animation.AnimatorSet();
                    this.x_renamed.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
                    this.x_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.levelcontrol.g_renamed.3
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(android.animation.Animator animator) {
                            com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.g_renamed.setVisibility(0);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(android.animation.Animator animator) {
                            com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.g_renamed.setVisibility(8);
                        }
                    });
                }
                this.x_renamed.start();
                return;
            }
            this.g_renamed.setVisibility(8);
        }
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "cancelAnimation.");
        android.widget.RelativeLayout relativeLayout = this.d_renamed;
        if (relativeLayout != null) {
            relativeLayout.clearAnimation();
        }
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
        if (bVar != null) {
            bVar.clearAnimation();
        }
        this.mbEnterAnimationRunning = false;
        this.mbExitAnimationRunning = false;
    }

    @Override // com.oplus.camera.ui.menu.setting.q_renamed
    public void hideMenuPanel(boolean z_renamed, boolean z2) {
        if (isEffectMenuOpen()) {
            if (isAnimationRunning() || h_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "hideMenuPanel, anim isRunning, return.");
                return;
            }
            b_renamed(true, z2);
        }
        e_renamed();
    }

    /* compiled from: FilterEffectMenu.java */
    private class b_renamed implements com.oplus.camera.ui.menu.levelcontrol.b_renamed.a_renamed {
        private b_renamed() {
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed.a_renamed
        public void a_renamed() {
            if (com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.h_renamed != null) {
                com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.h_renamed.a_renamed();
            }
            if (com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.g_renamed != null) {
                com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.g_renamed.a_renamed(com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.o_renamed, com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.p_renamed);
            }
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed.a_renamed
        public void a_renamed(com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar) {
            if (com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.h_renamed != null) {
                com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.h_renamed.a_renamed(jVar);
            }
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed.a_renamed
        public void a_renamed(int i_renamed, boolean z_renamed) {
            if (com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.h_renamed != null) {
                com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.l_renamed = i_renamed;
                com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.h_renamed.a_renamed(i_renamed, z_renamed);
            }
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed.a_renamed
        public boolean a_renamed(int i_renamed) {
            if (com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.h_renamed != null) {
                return com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.h_renamed.a_renamed(i_renamed);
            }
            return false;
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed.a_renamed
        public boolean b_renamed() {
            return com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.h_renamed != null && com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.h_renamed.b_renamed() && !com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.isAnimationRunning() && (com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.j_renamed == null || !com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.j_renamed.isRunning()) && com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.m_renamed;
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed.a_renamed
        public int c_renamed() {
            return com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.l_renamed;
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed.a_renamed
        public int d_renamed() {
            if (com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.h_renamed != null) {
                return com.oplus.camera.ui.menu.levelcontrol.g_renamed.this.h_renamed.e_renamed();
            }
            return 0;
        }
    }

    public void setFilterEffectMenuListener(com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed aVar) {
        this.h_renamed = aVar;
    }

    public g_renamed(android.app.Activity activity) {
        super(activity);
        this.f6520a = 0;
        this.f6521b = null;
        this.f6522c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = new android.os.Handler();
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = 0;
        this.p_renamed = 0;
        this.q_renamed = 1;
        this.r_renamed = 1;
        this.s_renamed = com.oplus.camera.R_renamed.layout.effects_menu_horizontal_common;
        this.t_renamed = 0;
        this.u_renamed = 0;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.z_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.A_renamed = 0;
        this.B_renamed = com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed.Polarr;
        this.f6521b = activity;
    }

    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "setLayoutMode, layoutMode: " + i_renamed + ", screenRotation: " + i2);
        this.t_renamed = i_renamed;
        this.u_renamed = i2;
        com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(i_renamed, i2);
        if (i_renamed == 0) {
            this.s_renamed = com.oplus.camera.R_renamed.layout.effects_menu_horizontal_common;
        } else if (i_renamed != 1) {
            if (i_renamed == 2) {
                this.s_renamed = com.oplus.camera.R_renamed.layout.effects_menu_horizontal_out_screen;
            } else if (i_renamed == 3) {
                this.s_renamed = com.oplus.camera.R_renamed.layout.effects_menu_horizontal_split_screen;
            } else if (i_renamed == 4) {
                this.s_renamed = 90 == i2 ? com.oplus.camera.R_renamed.layout.effects_menu_horizontal_rack : com.oplus.camera.R_renamed.layout.effects_menu_horizontal_rack_270;
            }
        } else if (i2 == 0) {
            this.s_renamed = com.oplus.camera.R_renamed.layout.effects_menu_vertical;
        } else if (270 == i2) {
            this.s_renamed = com.oplus.camera.R_renamed.layout.effects_menu_vertical_270;
        } else {
            this.s_renamed = com.oplus.camera.R_renamed.layout.effects_menu_vertical_90;
        }
        android.animation.AnimatorSet animatorSet = this.x_renamed;
        if (animatorSet != null) {
            if (animatorSet.isStarted()) {
                this.x_renamed.cancel();
            }
            this.x_renamed = null;
        }
        android.animation.AnimatorSet animatorSet2 = this.v_renamed;
        if (animatorSet2 != null) {
            if (animatorSet2.isStarted()) {
                this.v_renamed.cancel();
            }
            this.v_renamed = null;
        }
        android.widget.RelativeLayout relativeLayout = this.d_renamed;
        if (relativeLayout != null) {
            this.f6522c.removeView(relativeLayout);
            this.d_renamed = null;
        }
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
        if (bVar == null || !bVar.e_renamed()) {
            return;
        }
        this.g_renamed.j_renamed();
    }

    public void setCameraEntryType(int i_renamed) {
        this.q_renamed = i_renamed;
    }

    public void a_renamed(int i_renamed) {
        this.f6520a = i_renamed;
        this.f6522c = (android.widget.RelativeLayout) this.f6521b.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        if (this.f6522c == null) {
        }
    }

    public void c_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
        if (bVar != null) {
            bVar.b_renamed();
        }
    }

    public void d_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
        if (bVar != null) {
            bVar.c_renamed();
        }
        android.os.Handler handler = this.i_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mbEnterAnimationRunning = false;
        this.mbExitAnimationRunning = false;
        hideWithoutAnim(true, false);
        a_renamed(false);
        this.w_renamed = null;
    }

    public void e_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
        if (bVar != null) {
            bVar.d_renamed();
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.q_renamed
    public boolean onBackPressed() {
        if (isEffectMenuOpen()) {
            if (isAnimationRunning() || h_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "onBackPressed, onClick, anim isRunning.");
            } else {
                b_renamed(true, false);
                return true;
            }
        }
        return false;
    }

    @Override // com.oplus.camera.ui.menu.setting.q_renamed
    public boolean onSingleTapUp(int i_renamed, int i2) {
        if (isEffectMenuOpen() && i2 < respondSingleTouchEventY()) {
            if (isAnimationRunning() || h_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "onSingleTapUp, onClick, anim isRunning.");
            } else {
                b_renamed(true, false);
                return true;
            }
        }
        return false;
    }

    @Override // com.oplus.camera.ui.menu.setting.q_renamed
    public boolean isAnimationRunning() {
        android.animation.AnimatorSet animatorSet;
        android.animation.AnimatorSet animatorSet2;
        android.animation.AnimatorSet animatorSet3;
        return this.mbEnterAnimationRunning || this.mbExitAnimationRunning || ((animatorSet = this.w_renamed) != null && animatorSet.isRunning()) || (((animatorSet2 = this.v_renamed) != null && animatorSet2.isRunning()) || ((animatorSet3 = this.x_renamed) != null && animatorSet3.isRunning()));
    }

    public void f_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
        if (bVar != null) {
            bVar.h_renamed();
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.q_renamed
    public void scrollToNext() {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
        if (bVar != null) {
            bVar.f_renamed();
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.q_renamed
    public void scrollToPrevious() {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
        if (bVar != null) {
            bVar.g_renamed();
        }
    }

    public void setMenuOpen(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "setMenuOpen, menuOpen: " + z_renamed);
        this.n_renamed = z_renamed;
    }

    @Override // com.oplus.camera.ui.menu.setting.q_renamed
    public boolean isEffectMenuOpen() {
        android.animation.AnimatorSet animatorSet;
        return this.m_renamed || this.n_renamed || this.mbEnterAnimationRunning || ((animatorSet = this.v_renamed) != null && animatorSet.isRunning());
    }

    @Override // com.oplus.camera.ui.menu.setting.q_renamed
    public boolean isEffectOpen() {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            return aVar.c_renamed();
        }
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a != this.l_renamed;
    }

    private void j_renamed() {
        k_renamed();
    }

    private void k_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed aVar;
        if (this.d_renamed == null) {
            this.d_renamed = (android.widget.RelativeLayout) this.f6521b.getLayoutInflater().inflate(this.s_renamed, (android.view.ViewGroup) null);
            android.view.ViewGroup.LayoutParams layoutParamsL = l_renamed();
            com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed aVar2 = this.h_renamed;
            if (aVar2 != null) {
                this.f6522c.addView(this.d_renamed, aVar2.f_renamed(), layoutParamsL);
            } else {
                this.f6522c.addView(this.d_renamed, layoutParamsL);
            }
            this.w_renamed = null;
            this.g_renamed = (com.oplus.camera.ui.menu.levelcontrol.b_renamed) this.d_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.effect_scrollbar);
            this.g_renamed.setCameraEntryType(this.q_renamed);
            this.g_renamed.setScrollBarTextureViewCallback(new com.oplus.camera.ui.menu.levelcontrol.g_renamed.b_renamed());
            com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed aVar3 = this.h_renamed;
            if (aVar3 != null) {
                com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
                if (bVar instanceof com.oplus.camera.ui.menu.levelcontrol.HorizontalScrollBar) {
                    ((com.oplus.camera.ui.menu.levelcontrol.HorizontalScrollBar) bVar).setRearMirrorEnable(aVar3.g_renamed());
                    return;
                }
                return;
            }
            return;
        }
        if (this.r_renamed != 1 || (aVar = this.h_renamed) == null) {
            return;
        }
        aVar.a_renamed(com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER);
    }

    private android.view.ViewGroup.LayoutParams l_renamed() {
        int i_renamed = this.t_renamed;
        if (i_renamed == 1) {
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(this.f6521b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_effect_menu_width), this.f6521b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_effect_menu_height));
            layoutParams.topMargin = this.f6521b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_effect_menu_margin_top);
            if (270 == this.u_renamed) {
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.f6521b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_effect_menu_margin_left);
                return layoutParams;
            }
            layoutParams.addRule(9);
            layoutParams.leftMargin = this.f6521b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_effect_menu_margin_left);
            return layoutParams;
        }
        if (i_renamed == 3) {
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, this.f6521b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.effects_menu_height));
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = this.f6521b.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_screen_effect_menu_margin_bottom);
            return layoutParams2;
        }
        if (i_renamed == 4) {
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(this.f6521b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_effect_filter_menu_width), this.f6521b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_effect_filter_menu_height));
            layoutParams3.addRule(14);
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = this.f6521b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_effect_filter_menu_margin_bottom);
            return layoutParams3;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-2, this.f6521b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.effects_menu_height));
        layoutParams4.addRule(12);
        layoutParams4.bottomMargin = com.oplus.camera.util.Util.O_renamed();
        return layoutParams4;
    }

    private void m_renamed() {
        android.widget.RelativeLayout relativeLayout = this.d_renamed;
        if (relativeLayout != null) {
            this.f6522c.removeView(relativeLayout);
        }
        this.d_renamed = (android.widget.RelativeLayout) this.f6521b.getLayoutInflater().inflate(this.s_renamed, (android.view.ViewGroup) null);
        android.view.ViewGroup.LayoutParams layoutParamsL = l_renamed();
        com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            this.f6522c.addView(this.d_renamed, aVar.f_renamed(), layoutParamsL);
        } else {
            this.f6522c.addView(this.d_renamed, layoutParamsL);
        }
        this.w_renamed = null;
        this.g_renamed = (com.oplus.camera.ui.menu.levelcontrol.b_renamed) this.d_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.effect_scrollbar);
        this.g_renamed.setCameraEntryType(this.q_renamed);
        this.g_renamed.setScrollBarTextureViewCallback(new com.oplus.camera.ui.menu.levelcontrol.g_renamed.b_renamed());
        com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed aVar2 = this.h_renamed;
        if (aVar2 != null) {
            com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
            if (bVar instanceof com.oplus.camera.ui.menu.levelcontrol.HorizontalScrollBar) {
                ((com.oplus.camera.ui.menu.levelcontrol.HorizontalScrollBar) bVar).setRearMirrorEnable(aVar2.g_renamed());
            }
        }
    }

    public void a_renamed(java.util.List<java.lang.String> list, java.lang.String str, int i_renamed) {
        this.k_renamed = list;
        this.l_renamed = i_renamed;
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
        if (bVar != null) {
            bVar.b_renamed(i_renamed);
        }
    }

    public int getTextureWidth() {
        return this.o_renamed;
    }

    public int getTextureHeight() {
        return this.p_renamed;
    }

    public void b_renamed(int i_renamed, int i2) {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar;
        com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "notifyPreviewSizeChanged, Size: " + i_renamed + "x_renamed" + i2);
        this.o_renamed = i_renamed;
        this.p_renamed = i2;
        if (!isEffectMenuOpen() || (bVar = this.g_renamed) == null) {
            return;
        }
        bVar.a_renamed(i_renamed, i2);
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "setVisibility, visible: " + i_renamed + ", isAnim: " + z_renamed + ", isEffectMenuOpen: " + isEffectMenuOpen());
        if (isEffectMenuOpen()) {
            setExpandMenuAnimation(this.d_renamed, i_renamed, z_renamed);
        }
    }

    public void g_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
        if (bVar != null) {
            bVar.a_renamed();
        }
    }

    public void e_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "reShowFilterEffectMenu, isAnim: " + z_renamed);
        if (this.k_renamed == null) {
            com.oplus.camera.e_renamed.f_renamed("FilterEffectMenu", "reShowFilterEffectMenu failed, mCurrMenuNames: " + this.k_renamed);
            return;
        }
        e_renamed();
        m_renamed();
        this.g_renamed.setFilterCategory(this.B_renamed);
        if (isEffectMenuOpen()) {
            setExpandMenuAnimation(this.d_renamed, 4, z_renamed);
        }
        setExpandMenuAnimation(this.d_renamed, 0, z_renamed);
        setExpandMenuAnimation(this.g_renamed, 0, z_renamed);
        this.m_renamed = true;
    }

    public void f_renamed(boolean z_renamed) {
        a_renamed(z_renamed, true);
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "show, isAnim: " + z_renamed);
        if (this.k_renamed == null) {
            com.oplus.camera.e_renamed.f_renamed("FilterEffectMenu", "show failed, mCurrMenuNames: " + this.k_renamed);
            return;
        }
        this.m_renamed = true;
        j_renamed();
        this.g_renamed.setFilterCategory(this.B_renamed);
        this.g_renamed.setAlpha(1.0f);
        if (z_renamed) {
            setExpandMenuAnimation(this.d_renamed, 0, true);
            setExpandMenuAnimation(this.g_renamed, 0, true);
        } else {
            setExpandMenuAnimation(this.d_renamed, 0, false);
            setExpandMenuAnimation(this.g_renamed, 0, false);
        }
    }

    public void setFilterCategory(com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed aVar) {
        this.B_renamed = aVar;
    }

    public void b_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "hideAnimator");
        android.os.Handler handler = this.i_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        setExpandMenuAnimation(this.g_renamed, 4, true);
        this.m_renamed = false;
        e_renamed();
        com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.a_renamed(z2);
        }
        super.hideMenuPanel(z_renamed, z2);
    }

    @Override // com.oplus.camera.ui.menu.setting.q_renamed
    public void hideWithoutAnim(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("FilterEffectMenu", "hideWithoutAnim");
        android.os.Handler handler = this.i_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (isEffectMenuOpen()) {
            setExpandMenuAnimation(this.g_renamed, 4, false);
            this.m_renamed = false;
            e_renamed();
            super.hideMenuPanel(z_renamed, false);
        }
    }

    public boolean h_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
        if (bVar != null) {
            return bVar.e_renamed();
        }
        return false;
    }

    public void a_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
        if (this.g_renamed == null || iVar == null) {
            return;
        }
        iVar.b_renamed(this.o_renamed);
        iVar.c_renamed(this.p_renamed);
        iVar.g_renamed((this.o_renamed * 1.0f) / this.p_renamed);
        this.l_renamed = iVar.l_renamed();
        this.g_renamed.a_renamed(iVar);
    }

    public void a_renamed(int i_renamed, java.lang.String str) {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
        if (bVar != null) {
            bVar.a_renamed(i_renamed, str);
        }
    }

    public void c_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
        if (bVar != null) {
            bVar.a_renamed(i_renamed);
        }
    }

    public void i_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.b_renamed bVar = this.g_renamed;
        if (bVar != null) {
            bVar.i_renamed();
        }
    }

    protected java.lang.String getAnimationTranslateProp() {
        return 1 == this.t_renamed ? "translationX" : "translationY";
    }

    protected int getAnimationTranslateDistance() {
        if (1 == this.t_renamed && 270 != this.u_renamed) {
            return -this.mMenuTranslateY;
        }
        return this.mMenuTranslateY;
    }
}
