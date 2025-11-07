package com.oplus.camera.sticker.ui;

/* compiled from: StickerMenu.java */
/* loaded from: classes2.dex */
public class h_renamed {
    private android.graphics.drawable.Drawable D_renamed;
    private android.graphics.drawable.Drawable E_renamed;
    private android.graphics.drawable.Drawable F_renamed;
    private com.oplus.camera.sticker.ui.g_renamed H_renamed;
    private com.oplus.camera.sticker.ui.h_renamed.d_renamed R_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int f5530a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f5531b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f5532c;
    private final int d_renamed;
    private final int e_renamed;
    private final int f_renamed;
    private final int g_renamed;
    private boolean q_renamed;
    private int r_renamed;
    private android.app.Activity s_renamed;
    private android.widget.RelativeLayout t_renamed;
    private com.oplus.camera.ui.RotateImageView v_renamed;
    private android.view.animation.Interpolator h_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);
    private android.animation.TimeInterpolator i_renamed = new android.view.animation.PathInterpolator(0.75f, 0.1f, 0.75f, 1.0f);
    private android.animation.AnimatorSet j_renamed = null;
    private android.animation.AnimatorSet k_renamed = null;
    private android.animation.AnimatorSet l_renamed = null;
    private android.animation.AnimatorSet m_renamed = null;
    private android.animation.Animator n_renamed = null;
    private android.animation.Animator o_renamed = null;
    private boolean p_renamed = false;
    private android.widget.RelativeLayout u_renamed = null;
    private com.oplus.camera.ui.control.MainShutterButton w_renamed = null;
    private com.oplus.camera.sticker.ui.StickerPageView x_renamed = null;
    private com.oplus.camera.ui.RotateImageView y_renamed = null;
    private com.oplus.camera.sticker.ui.j_renamed z_renamed = null;
    private com.oplus.camera.sticker.ui.i_renamed A_renamed = null;
    private com.oplus.camera.sticker.ui.c_renamed B_renamed = null;
    private boolean C_renamed = false;
    private com.oplus.camera.sticker.ui.e_renamed G_renamed = null;
    private android.widget.RelativeLayout I_renamed = null;
    private com.oplus.camera.sticker.ui.f_renamed J_renamed = null;
    private com.oplus.camera.sticker.ui.StickerCategoryRecycleView K_renamed = null;
    private com.oplus.camera.ui.RotateImageView L_renamed = null;
    private com.oplus.camera.ui.RotateImageView M_renamed = null;
    private int N_renamed = -1;
    private boolean O_renamed = false;
    private com.oplus.camera.sticker.ui.h_renamed.c_renamed P_renamed = null;
    private androidx.recyclerview.widget.LinearLayoutManager Q_renamed = null;
    private com.oplus.camera.sticker.ui.h_renamed.b_renamed S_renamed = null;
    private com.oplus.camera.sticker.ui.h_renamed.a_renamed T_renamed = null;
    private android.view.View.OnClickListener U_renamed = new android.view.View.OnClickListener() { // from class: com.oplus.camera.sticker.ui.h_renamed.1
        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            if ((com.oplus.camera.sticker.ui.h_renamed.this.k_renamed != null && com.oplus.camera.sticker.ui.h_renamed.this.k_renamed.isRunning()) || !com.oplus.camera.sticker.ui.h_renamed.this.A_renamed.i_renamed() || !com.oplus.camera.sticker.ui.h_renamed.this.v_renamed.isEnabled() || !com.oplus.camera.sticker.ui.h_renamed.this.v_renamed.isClickable()) {
                com.oplus.camera.e_renamed.a_renamed("StickerMenu", "mEnterMenuButtonOnClickListener, onClick, return");
            } else {
                com.oplus.camera.sticker.ui.h_renamed.this.d_renamed(true);
            }
        }
    };
    private android.view.View.OnClickListener V_renamed = new android.view.View.OnClickListener() { // from class: com.oplus.camera.sticker.ui.h_renamed.8
        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            if (com.oplus.camera.sticker.ui.h_renamed.this.N_renamed != 0) {
                com.oplus.camera.sticker.ui.h_renamed.this.H_renamed.a_renamed(0, 0, com.oplus.camera.sticker.ui.h_renamed.this.S_renamed.f5556c, false);
            }
        }
    };
    private android.view.View.OnClickListener W_renamed = new android.view.View.OnClickListener() { // from class: com.oplus.camera.sticker.ui.h_renamed.9
        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            if (com.oplus.camera.sticker.ui.h_renamed.this.A_renamed != null) {
                com.oplus.camera.sticker.ui.h_renamed.this.A_renamed.g_renamed();
            }
        }
    };
    private android.database.ContentObserver X_renamed = new android.database.ContentObserver(null) { // from class: com.oplus.camera.sticker.ui.h_renamed.10
        @Override // android.database.ContentObserver
        public void onChange(boolean z_renamed) {
            com.oplus.camera.e_renamed.a_renamed("StickerMenu", "onChange, slefChange: " + z_renamed);
            com.oplus.camera.sticker.ui.h_renamed.this.s_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.sticker.ui.h_renamed.10.1
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.sticker.ui.h_renamed.this.a_renamed();
                }
            });
        }
    };

    /* compiled from: StickerMenu.java */
    public interface a_renamed {
        void a_renamed();
    }

    public h_renamed(android.app.Activity activity, int i_renamed, boolean z_renamed) {
        this.q_renamed = false;
        this.r_renamed = 0;
        this.s_renamed = null;
        this.t_renamed = null;
        this.v_renamed = null;
        this.D_renamed = null;
        this.E_renamed = null;
        this.F_renamed = null;
        this.H_renamed = null;
        this.R_renamed = null;
        com.oplus.camera.e_renamed.a_renamed("StickerMenu", "StickerMenu");
        this.s_renamed = activity;
        this.q_renamed = this.s_renamed.getResources().getConfiguration().getLayoutDirection() == 0;
        this.t_renamed = (android.widget.RelativeLayout) this.s_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        this.r_renamed = i_renamed;
        this.R_renamed = new com.oplus.camera.sticker.ui.h_renamed.d_renamed();
        this.f5530a = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_type_view_item_size);
        this.f5531b = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_view_padding);
        this.f5532c = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_view_second_padding);
        this.d_renamed = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_recycle_top_margin);
        this.e_renamed = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_recycle_list_padding);
        this.f_renamed = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_recycle_list_margin_left);
        this.g_renamed = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_recycle_list_margin_right);
        if (this.t_renamed == null) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("StickerMenus");
        this.v_renamed = (com.oplus.camera.ui.RotateImageView) activity.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.enter_sticker_button, (android.view.ViewGroup) null);
        this.v_renamed.a_renamed(this.r_renamed, true);
        this.v_renamed.setOnClickListener(this.U_renamed);
        com.oplus.camera.ui.a_renamed.a_renamed(this.s_renamed).a_renamed(this.v_renamed, "StickerButton");
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_enter_button_width), this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_enter_button_height));
        layoutParams.addRule(20);
        layoutParams.addRule(2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout);
        layoutParams.bottomMargin = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_menu_button_top_margin);
        layoutParams.setMarginStart(this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_menu_button_right_margin));
        if (z_renamed) {
            c_renamed(true);
        } else {
            c_renamed(false);
        }
        this.t_renamed.addView(this.v_renamed, layoutParams);
        this.D_renamed = this.s_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.sticker_music_play);
        this.E_renamed = this.s_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.sticker_music_pause);
        this.F_renamed = this.D_renamed;
        this.H_renamed = new com.oplus.camera.sticker.ui.g_renamed() { // from class: com.oplus.camera.sticker.ui.h_renamed.11
            @Override // com.oplus.camera.sticker.ui.g_renamed
            public void a_renamed(int i2, int i3, java.lang.String str, boolean z2) {
                if (com.oplus.camera.sticker.ui.h_renamed.this.A_renamed != null) {
                    com.oplus.camera.sticker.ui.h_renamed.this.A_renamed.b_renamed(str);
                    com.oplus.camera.sticker.ui.h_renamed.this.N_renamed = i2;
                    com.oplus.camera.sticker.ui.h_renamed.this.a_renamed(str, z2);
                    com.oplus.camera.sticker.ui.h_renamed.this.x_renamed.a_renamed(com.oplus.camera.sticker.ui.h_renamed.this.N_renamed, false);
                    com.oplus.camera.sticker.ui.h_renamed.this.a_renamed(i3);
                    com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(com.oplus.camera.sticker.ui.h_renamed.this.s_renamed).b_renamed(str);
                }
                if (com.oplus.camera.sticker.ui.h_renamed.this.G_renamed != null && i2 == 0) {
                    com.oplus.camera.sticker.ui.h_renamed.this.G_renamed.b_renamed(-1);
                }
                com.oplus.camera.sticker.ui.h_renamed.this.j_renamed();
            }

            @Override // com.oplus.camera.sticker.ui.g_renamed
            public boolean a_renamed() {
                return !com.oplus.camera.sticker.ui.h_renamed.this.O_renamed;
            }

            @Override // com.oplus.camera.sticker.ui.g_renamed
            public void b_renamed() {
                if (com.oplus.camera.sticker.ui.h_renamed.this.A_renamed != null) {
                    com.oplus.camera.sticker.ui.h_renamed.this.A_renamed.d_renamed();
                }
            }
        };
        com.oplus.camera.e_renamed.b_renamed("StickerMenus");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j_renamed() {
        com.oplus.camera.sticker.ui.h_renamed.b_renamed bVar = this.S_renamed;
        if (bVar == null) {
            return;
        }
        if (this.N_renamed == 0) {
            this.L_renamed.setImageDrawable(bVar.f5554a);
        } else {
            this.L_renamed.setImageDrawable(bVar.f5555b);
        }
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.RotateImageView rotateImageView;
        com.oplus.camera.e_renamed.a_renamed("StickerMenu", "onResume");
        com.oplus.camera.e_renamed.a_renamed("StickerMenus.onResume");
        a_renamed();
        if (z_renamed && (rotateImageView = this.v_renamed) != null) {
            rotateImageView.setAlpha(0.0f);
        }
        if (!z2) {
            a_renamed(0, false, false);
        }
        e_renamed();
        com.oplus.camera.e_renamed.b_renamed("StickerMenus.onResume");
    }

    public void a_renamed(final java.lang.String str) {
        android.app.Activity activity = this.s_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.sticker.ui.h_renamed.12
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.sticker.ui.h_renamed.this.z_renamed != null) {
                        com.oplus.camera.sticker.ui.h_renamed.this.z_renamed.a_renamed(str);
                    }
                }
            });
        }
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StickerMenu", "updateLayout, mGridViewRelativeLayout: " + this.u_renamed);
        if (this.u_renamed != null) {
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, n_renamed());
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.oplus.camera.util.Util.Z_renamed();
            this.u_renamed.setLayoutParams(layoutParams);
        }
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StickerMenu", "onPause");
        if (g_renamed()) {
            b_renamed(true, false, false);
        }
        a_renamed(false);
        this.N_renamed = -1;
        f_renamed();
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StickerMenu", "onDestroy");
        this.s_renamed = null;
    }

    public void d_renamed() {
        if (this.x_renamed == null) {
            com.oplus.camera.e_renamed.a_renamed("StickerMenus.initEffectMenuPanel");
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, n_renamed());
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.oplus.camera.util.Util.Z_renamed();
            this.u_renamed = (android.widget.RelativeLayout) android.view.LayoutInflater.from(this.s_renamed).inflate(com.oplus.camera.R_renamed.layout.sticker_page_view, (android.view.ViewGroup) null);
            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) this.s_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.control_panel_button_layout);
            android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) this.s_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.control_panel_layout);
            this.w_renamed = (com.oplus.camera.ui.control.MainShutterButton) this.s_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.shutter_button);
            relativeLayout2.addView(this.u_renamed, relativeLayout2.indexOfChild(relativeLayout), layoutParams);
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.w_renamed, "translationY", 0.0f, o_renamed());
            objectAnimatorOfFloat.setInterpolator(this.i_renamed);
            objectAnimatorOfFloat.setDuration(300L);
            this.l_renamed = new android.animation.AnimatorSet();
            this.l_renamed.play(objectAnimatorOfFloat);
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.w_renamed, "translationY", o_renamed(), 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.i_renamed);
            objectAnimatorOfFloat2.setDuration(300L);
            this.m_renamed = new android.animation.AnimatorSet();
            this.m_renamed.play(objectAnimatorOfFloat2);
            com.oplus.camera.sticker.ui.i_renamed iVar = this.A_renamed;
            com.oplus.camera.sticker.data.StickerItem stickerItemF = iVar != null ? iVar.f_renamed() : null;
            this.x_renamed = (com.oplus.camera.sticker.ui.StickerPageView) this.s_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.page_view);
            this.z_renamed = new com.oplus.camera.sticker.ui.j_renamed(this.s_renamed, this.r_renamed, stickerItemF, this.A_renamed, this.B_renamed);
            if (-1 == this.N_renamed && 1 < this.z_renamed.a_renamed()) {
                this.N_renamed = 1;
            }
            this.z_renamed.c_renamed(this.N_renamed);
            this.x_renamed.setAdapter(this.z_renamed);
            this.x_renamed.a_renamed(this.z_renamed.d_renamed(), false);
            this.x_renamed.setStickerCategoryInterface(this.H_renamed);
            this.x_renamed.setOnPageChangeListener(new androidx.viewpager.widget.ViewPager.f_renamed() { // from class: com.oplus.camera.sticker.ui.h_renamed.13
                @Override // androidx.viewpager.widget.ViewPager.f_renamed
                public void onPageScrolled(int i_renamed, float f_renamed, int i2) {
                    if (f_renamed != 0.0f || com.oplus.camera.sticker.ui.h_renamed.this.G_renamed == null || i_renamed >= com.oplus.camera.sticker.ui.h_renamed.this.G_renamed.getItemCount()) {
                        return;
                    }
                    com.oplus.camera.sticker.ui.h_renamed.this.A_renamed.a_renamed(com.oplus.camera.sticker.ui.h_renamed.this.G_renamed.a_renamed(i_renamed).f5556c);
                }

                @Override // androidx.viewpager.widget.ViewPager.f_renamed
                public void onPageSelected(int i_renamed) {
                    int i2;
                    com.oplus.camera.e_renamed.b_renamed("StickerMenu", "onPageSelected, position: " + i_renamed);
                    if (i_renamed == 0) {
                        com.oplus.camera.sticker.ui.h_renamed.this.H_renamed.a_renamed(0, 0, com.oplus.camera.sticker.ui.h_renamed.this.S_renamed.f5556c, false);
                    }
                    if (com.oplus.camera.sticker.ui.h_renamed.this.z_renamed == null || com.oplus.camera.sticker.ui.h_renamed.this.G_renamed == null || com.oplus.camera.sticker.ui.h_renamed.this.H_renamed == null || com.oplus.camera.sticker.ui.h_renamed.this.K_renamed == null || com.oplus.camera.sticker.ui.h_renamed.this.N_renamed == i_renamed) {
                        return;
                    }
                    int iFindFirstCompletelyVisibleItemPosition = com.oplus.camera.sticker.ui.h_renamed.this.Q_renamed.findFirstCompletelyVisibleItemPosition();
                    int iFindLastCompletelyVisibleItemPosition = com.oplus.camera.sticker.ui.h_renamed.this.Q_renamed.findLastCompletelyVisibleItemPosition();
                    int i3 = i_renamed - 1;
                    if (i3 < 0) {
                        com.oplus.camera.sticker.ui.h_renamed.this.K_renamed.scrollTo(0, 0);
                        com.oplus.camera.sticker.ui.h_renamed hVar = com.oplus.camera.sticker.ui.h_renamed.this;
                        hVar.a_renamed(hVar.G_renamed.a_renamed(0).f5556c, false);
                    } else {
                        if (iFindFirstCompletelyVisibleItemPosition > i3 || i3 > iFindLastCompletelyVisibleItemPosition) {
                            int itemCount = com.oplus.camera.sticker.ui.h_renamed.this.G_renamed.getItemCount();
                            if (i3 == 0 || 1 == i3 || (2 == i3 && 2 == com.oplus.camera.sticker.ui.h_renamed.this.N_renamed)) {
                                com.oplus.camera.sticker.ui.h_renamed.this.K_renamed.scrollToPosition(0);
                            } else {
                                int i4 = itemCount - 1;
                                if (i3 == i4 || i3 == itemCount - 2 || (i3 == itemCount - 3 && com.oplus.camera.sticker.ui.h_renamed.this.N_renamed == i2)) {
                                    com.oplus.camera.sticker.ui.h_renamed.this.K_renamed.scrollToPosition(i4);
                                } else {
                                    if (i3 > com.oplus.camera.sticker.ui.h_renamed.this.N_renamed - 1) {
                                        com.oplus.camera.sticker.ui.h_renamed.this.K_renamed.scrollToPosition(i3 - 3);
                                    } else {
                                        com.oplus.camera.sticker.ui.h_renamed.this.K_renamed.scrollToPosition(i3 - 1);
                                    }
                                    com.oplus.camera.sticker.ui.h_renamed.this.O_renamed = true;
                                    com.oplus.camera.sticker.ui.h_renamed.this.R_renamed.a_renamed(i3);
                                }
                            }
                        } else {
                            com.oplus.camera.sticker.ui.h_renamed.this.a_renamed(i3);
                        }
                        com.oplus.camera.sticker.ui.h_renamed hVar2 = com.oplus.camera.sticker.ui.h_renamed.this;
                        hVar2.a_renamed(hVar2.G_renamed.a_renamed(i3).f5556c, false);
                    }
                    com.oplus.camera.sticker.ui.h_renamed.this.N_renamed = i_renamed;
                    com.oplus.camera.sticker.ui.h_renamed.this.z_renamed.c_renamed(com.oplus.camera.sticker.ui.h_renamed.this.N_renamed);
                    com.oplus.camera.sticker.ui.h_renamed.this.G_renamed.b_renamed(i3);
                    com.oplus.camera.sticker.ui.h_renamed.this.j_renamed();
                }

                @Override // androidx.viewpager.widget.ViewPager.f_renamed
                public void onPageScrollStateChanged(int i_renamed) {
                    com.oplus.camera.e_renamed.b_renamed("StickerMenu", "onPageScrollStateChanged, position: " + i_renamed);
                }
            });
            this.y_renamed = new com.oplus.camera.ui.RotateImageView(this.s_renamed);
            this.y_renamed.setImageDrawable(this.F_renamed);
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            if (this.q_renamed) {
                layoutParams2.addRule(11);
                layoutParams2.rightMargin = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_music_margin_right);
            } else {
                layoutParams2.addRule(9);
                layoutParams2.leftMargin = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_music_margin_right);
            }
            layoutParams2.addRule(8);
            layoutParams2.bottomMargin = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_music_margin_bottom);
            layoutParams2.addRule(2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout);
            this.t_renamed.addView(this.y_renamed, layoutParams2);
            this.y_renamed.setVisibility(this.C_renamed ? 0 : 4);
            this.y_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.sticker.ui.h_renamed.14
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    if (com.oplus.camera.sticker.ui.h_renamed.this.A_renamed != null) {
                        com.oplus.camera.sticker.ui.h_renamed.this.A_renamed.h_renamed();
                    }
                }
            });
        } else {
            com.oplus.camera.sticker.ui.i_renamed iVar2 = this.A_renamed;
            this.z_renamed = new com.oplus.camera.sticker.ui.j_renamed(this.s_renamed, this.r_renamed, iVar2 != null ? iVar2.f_renamed() : null, this.A_renamed, this.B_renamed);
            this.z_renamed.c_renamed(this.N_renamed);
            this.x_renamed.setAdapter(this.z_renamed);
            this.x_renamed.a_renamed(this.z_renamed.d_renamed(), false);
        }
        com.oplus.camera.e_renamed.b_renamed("StickerMenus.initEffectMenuPanel");
    }

    /* compiled from: StickerMenu.java */
    public class d_renamed implements android.view.View.OnLayoutChangeListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f5561b = -1;

        public d_renamed() {
        }

        public void a_renamed(int i_renamed) {
            this.f5561b = i_renamed;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(android.view.View view, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (com.oplus.camera.sticker.ui.h_renamed.this.O_renamed) {
                int i9 = this.f5561b;
                if (i9 != -1) {
                    com.oplus.camera.sticker.ui.h_renamed.this.a_renamed(i9);
                }
                com.oplus.camera.sticker.ui.h_renamed.this.O_renamed = false;
                this.f5561b = -1;
            }
        }
    }

    public void a_renamed(int i_renamed) {
        int i2;
        int i3;
        int i4;
        if (this.G_renamed != null) {
            int childCount = this.K_renamed.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                android.view.View childAt = this.K_renamed.getChildAt(i5);
                if (((java.lang.Integer) childAt.getTag()).intValue() == i_renamed) {
                    int left = childAt.getLeft();
                    int itemCount = this.G_renamed.getItemCount();
                    if (i_renamed == 0) {
                        i4 = this.e_renamed;
                    } else {
                        if (i_renamed == 1) {
                            i2 = this.e_renamed + this.f5530a;
                            i3 = this.f5531b;
                        } else if (i_renamed == itemCount - 1) {
                            i2 = this.e_renamed + (this.f5530a * 4);
                            i3 = this.f5531b * 4;
                        } else if (i_renamed == itemCount - 2) {
                            i2 = this.e_renamed + (this.f5530a * 3);
                            i3 = this.f5531b * 3;
                        } else {
                            i2 = this.e_renamed + (this.f5530a * 2);
                            i3 = this.f5531b * 2;
                        }
                        i4 = i2 + i3;
                    }
                    int i6 = left - i4;
                    if (i6 != Integer.MAX_VALUE) {
                        this.K_renamed.smoothScrollBy(i6, 0);
                    }
                }
            }
        }
    }

    public void a_renamed(final com.oplus.camera.sticker.data.StickerItem stickerItem, final boolean z_renamed) {
        android.app.Activity activity = this.s_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.sticker.ui.h_renamed.15
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.sticker.ui.h_renamed.this.z_renamed != null) {
                        com.oplus.camera.sticker.ui.h_renamed.this.z_renamed.a_renamed(stickerItem, z_renamed);
                    }
                }
            });
        }
    }

    public void a_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.sticker.ui.j_renamed jVar = this.z_renamed;
        if (jVar != null) {
            jVar.a_renamed(str, z_renamed);
        }
    }

    public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        if (stickerItem == null) {
            this.C_renamed = false;
        } else {
            b_renamed(stickerItem.getStickerUUID());
            this.C_renamed = stickerItem.hasMusic();
        }
    }

    public void b_renamed(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.F_renamed = com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.s_renamed).a_renamed(str) ? this.E_renamed : this.D_renamed;
        com.oplus.camera.ui.RotateImageView rotateImageView = this.y_renamed;
        if (rotateImageView != null) {
            rotateImageView.setImageDrawable(this.F_renamed);
        }
    }

    public void a_renamed(java.lang.String str, int i_renamed, int i2, java.lang.String str2, boolean z_renamed, com.oplus.camera.sticker.data.StickerItem stickerItem) throws java.lang.Throwable {
        if (this.z_renamed == null || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        this.z_renamed.a_renamed(str, i_renamed, i2, com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.s_renamed).a_renamed(this.s_renamed, android.net.Uri.parse(str2)), z_renamed, stickerItem);
    }

    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StickerMenu", "registerNavigationBarObserver");
        this.s_renamed.getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("manual_hide_navigationbar"), true, this.X_renamed);
    }

    public void f_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StickerMenu", "unregisterNavigationBarObserver");
        this.s_renamed.getContentResolver().unregisterContentObserver(this.X_renamed);
    }

    public void a_renamed(com.oplus.camera.sticker.ui.i_renamed iVar) {
        this.A_renamed = iVar;
    }

    public void a_renamed(com.oplus.camera.sticker.ui.c_renamed cVar) {
        this.B_renamed = cVar;
    }

    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("StickerMenu", "setVisibility, visible: " + i_renamed + ", includePanel: " + z2);
        if (z_renamed) {
            if (g_renamed()) {
                if (z2) {
                    android.widget.RelativeLayout relativeLayout = this.u_renamed;
                    if (relativeLayout != null) {
                        com.oplus.camera.util.Util.a_renamed(relativeLayout, i_renamed, (android.view.animation.Animation.AnimationListener) null, 300L);
                    }
                    com.oplus.camera.sticker.ui.f_renamed fVar = this.J_renamed;
                    if (fVar != null) {
                        com.oplus.camera.util.Util.a_renamed(fVar, i_renamed, (android.view.animation.Animation.AnimationListener) null, 300L);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.v_renamed != null) {
                k_renamed();
                if (i_renamed == 0) {
                    android.animation.Animator animatorM = m_renamed();
                    if (animatorM != null) {
                        animatorM.start();
                        return;
                    }
                    return;
                }
                android.animation.Animator animatorL = l_renamed();
                if (animatorL != null) {
                    animatorL.start();
                    return;
                }
                return;
            }
            return;
        }
        if (!g_renamed()) {
            if (this.v_renamed != null) {
                k_renamed();
                this.v_renamed.setVisibility(i_renamed);
                this.v_renamed.setAlpha(i_renamed == 0 ? 1.0f : 0.0f);
                return;
            }
            return;
        }
        if (z2) {
            android.widget.RelativeLayout relativeLayout2 = this.u_renamed;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(i_renamed);
            }
            com.oplus.camera.sticker.ui.f_renamed fVar2 = this.J_renamed;
            if (fVar2 != null) {
                fVar2.setVisibility(i_renamed);
            }
        }
    }

    private void k_renamed() {
        android.animation.Animator animator = this.n_renamed;
        if (animator != null) {
            animator.cancel();
        }
        android.animation.Animator animator2 = this.o_renamed;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private android.animation.Animator l_renamed() {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.v_renamed;
        if (rotateImageView != null && rotateImageView.getVisibility() != 0) {
            return null;
        }
        this.o_renamed = android.animation.ObjectAnimator.ofFloat(this.v_renamed, "alpha", 1.0f, 0.0f);
        this.o_renamed.setInterpolator(this.h_renamed);
        this.o_renamed.setDuration(180L);
        this.o_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.sticker.ui.h_renamed.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.sticker.ui.h_renamed.this.v_renamed.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.sticker.ui.h_renamed.this.v_renamed.setClickable(false);
                com.oplus.camera.sticker.ui.h_renamed.this.v_renamed.setVisibility(4);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.oplus.camera.sticker.ui.h_renamed.this.v_renamed.setClickable(true);
                com.oplus.camera.sticker.ui.h_renamed.this.v_renamed.setVisibility(0);
                com.oplus.camera.sticker.ui.h_renamed.this.v_renamed.setAlpha(1.0f);
            }
        });
        return this.o_renamed;
    }

    private android.animation.Animator m_renamed() {
        if (this.v_renamed.getVisibility() == 0 && 1.0f == this.v_renamed.getAlpha()) {
            return null;
        }
        this.n_renamed = android.animation.ObjectAnimator.ofFloat(this.v_renamed, "alpha", 0.0f, 1.0f);
        this.n_renamed.setInterpolator(this.h_renamed);
        this.n_renamed.setDuration(180L);
        this.n_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.sticker.ui.h_renamed.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.sticker.ui.h_renamed.this.v_renamed.setVisibility(0);
                com.oplus.camera.sticker.ui.h_renamed.this.v_renamed.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.sticker.ui.h_renamed.this.v_renamed.setClickable(true);
                if (com.oplus.camera.sticker.ui.h_renamed.this.T_renamed != null) {
                    com.oplus.camera.sticker.ui.h_renamed.this.T_renamed.a_renamed();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.oplus.camera.sticker.ui.h_renamed.this.v_renamed.setClickable(false);
                com.oplus.camera.sticker.ui.h_renamed.this.v_renamed.setVisibility(4);
                com.oplus.camera.sticker.ui.h_renamed.this.v_renamed.setAlpha(0.0f);
            }
        });
        return this.n_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.ui.RotateImageView rotateImageView;
        com.oplus.camera.e_renamed.a_renamed("StickerMenu", "setEnable, enable: " + z_renamed + ", isStickerMenuOpen: " + g_renamed());
        if (g_renamed() || (rotateImageView = this.v_renamed) == null) {
            return;
        }
        rotateImageView.setClickable(z_renamed);
    }

    public void c_renamed(java.lang.String str) {
        if ("square".equals(str)) {
            com.oplus.camera.ui.RotateImageView rotateImageView = this.v_renamed;
            rotateImageView.setBackground(rotateImageView.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg));
        } else {
            com.oplus.camera.ui.RotateImageView rotateImageView2 = this.v_renamed;
            rotateImageView2.setBackground(rotateImageView2.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.common_button_bg));
        }
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("StickerMenu", "setStickerPanelEnable, enable: " + z_renamed);
        com.oplus.camera.sticker.ui.j_renamed jVar = this.z_renamed;
        if (jVar != null) {
            jVar.a_renamed(z_renamed);
        }
    }

    public boolean g_renamed() {
        android.animation.AnimatorSet animatorSet;
        return this.p_renamed || ((animatorSet = this.j_renamed) != null && animatorSet.isRunning());
    }

    public void d_renamed(final java.lang.String str) {
        android.app.Activity activity = this.s_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.sticker.ui.h_renamed.4
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.sticker.ui.h_renamed.this.C_renamed = true;
                    com.oplus.camera.sticker.ui.h_renamed.this.b_renamed(str);
                    com.oplus.camera.util.Util.a_renamed(com.oplus.camera.sticker.ui.h_renamed.this.y_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
                    if (com.oplus.camera.sticker.ui.h_renamed.this.J_renamed != null) {
                        com.oplus.camera.sticker.ui.h_renamed.this.J_renamed.a_renamed(com.oplus.camera.sticker.ui.h_renamed.this.C_renamed);
                    }
                }
            });
        }
    }

    public void h_renamed() {
        android.app.Activity activity = this.s_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.sticker.ui.h_renamed.5
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.sticker.ui.h_renamed.this.C_renamed = false;
                    com.oplus.camera.util.Util.a_renamed(com.oplus.camera.sticker.ui.h_renamed.this.y_renamed, 8, (android.view.animation.Animation.AnimationListener) null, 300L);
                    if (com.oplus.camera.sticker.ui.h_renamed.this.J_renamed != null) {
                        com.oplus.camera.sticker.ui.h_renamed.this.J_renamed.a_renamed(com.oplus.camera.sticker.ui.h_renamed.this.C_renamed);
                    }
                }
            });
        }
    }

    public void b_renamed(int i_renamed) {
        this.r_renamed = i_renamed;
        com.oplus.camera.ui.RotateImageView rotateImageView = this.v_renamed;
        if (rotateImageView != null) {
            rotateImageView.a_renamed(this.r_renamed, true);
        }
        com.oplus.camera.sticker.ui.j_renamed jVar = this.z_renamed;
        if (jVar != null) {
            jVar.d_renamed(this.r_renamed);
        }
        com.oplus.camera.sticker.ui.e_renamed eVar = this.G_renamed;
        if (eVar != null) {
            eVar.c_renamed(this.r_renamed);
        }
        com.oplus.camera.ui.RotateImageView rotateImageView2 = this.y_renamed;
        if (rotateImageView2 != null) {
            rotateImageView2.a_renamed(this.r_renamed, true);
        }
        com.oplus.camera.ui.RotateImageView rotateImageView3 = this.L_renamed;
        if (rotateImageView3 != null) {
            rotateImageView3.a_renamed(this.r_renamed, true);
        }
    }

    public void c_renamed(boolean z_renamed) {
        if (z_renamed) {
            this.v_renamed.setImageDrawable(com.oplus.camera.util.Util.b_renamed(this.s_renamed, com.oplus.camera.R_renamed.drawable.sticker_menu_control_button_highlight));
        } else {
            this.v_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.sticker_menu_control_button);
        }
    }

    public boolean i_renamed() {
        android.animation.AnimatorSet animatorSet = this.j_renamed;
        if (animatorSet != null && animatorSet.isRunning()) {
            return true;
        }
        android.animation.AnimatorSet animatorSet2 = this.k_renamed;
        return animatorSet2 != null && animatorSet2.isRunning();
    }

    public void a_renamed(java.util.ArrayList<com.oplus.camera.sticker.ui.h_renamed.b_renamed> arrayList, int i_renamed, boolean z_renamed) {
        boolean z2;
        int i2;
        com.oplus.camera.e_renamed.a_renamed("StickerMenus.updateStickerCategoryMenu");
        if (this.I_renamed == null) {
            this.J_renamed = new com.oplus.camera.sticker.ui.f_renamed(this.s_renamed);
            this.J_renamed.setBackgroundColor(this.s_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.plugin_background_color));
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_recycle_background_height));
            layoutParams.addRule(2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout);
            this.I_renamed = (android.widget.RelativeLayout) android.view.LayoutInflater.from(this.s_renamed).inflate(com.oplus.camera.R_renamed.layout.sticker_category_menu, (android.view.ViewGroup) this.J_renamed, false);
            this.G_renamed = new com.oplus.camera.sticker.ui.e_renamed(this.s_renamed, this.H_renamed, this.r_renamed);
            this.G_renamed.a_renamed(arrayList);
            this.L_renamed = (com.oplus.camera.ui.RotateImageView) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.sticker_download_icon);
            this.S_renamed = arrayList.get(0);
            this.L_renamed.setImageDrawable(this.S_renamed.f5555b);
            this.L_renamed.setOnClickListener(this.V_renamed);
            this.M_renamed = (com.oplus.camera.ui.RotateImageView) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.iv_back);
            this.M_renamed.setOnClickListener(this.W_renamed);
            this.K_renamed = (com.oplus.camera.sticker.ui.StickerCategoryRecycleView) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.RecyclerView);
            this.K_renamed.addOnLayoutChangeListener(this.R_renamed);
            this.K_renamed.setStickerCategoryInterface(this.H_renamed);
            this.Q_renamed = new androidx.recyclerview.widget.LinearLayoutManager(this.s_renamed);
            this.Q_renamed.setOrientation(0);
            this.K_renamed.setItemViewCacheSize(100);
            this.K_renamed.setLayoutManager(this.Q_renamed);
            this.K_renamed.setAdapter(this.G_renamed);
            this.P_renamed = new com.oplus.camera.sticker.ui.h_renamed.c_renamed(this.s_renamed, this.f5531b, this.e_renamed, this.f5532c);
            this.K_renamed.addItemDecoration(this.P_renamed);
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, this.f5530a);
            layoutParams2.addRule(5);
            layoutParams2.leftMargin = this.f_renamed - this.e_renamed;
            layoutParams2.rightMargin = this.g_renamed;
            layoutParams2.topMargin = this.d_renamed;
            if (!g_renamed() || this.G_renamed.getItemCount() <= 1) {
                this.J_renamed.setVisibility(4);
            }
            this.J_renamed.addView(this.I_renamed, layoutParams2);
            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) this.s_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.control_panel_layout);
            android.widget.RelativeLayout relativeLayout2 = this.t_renamed;
            relativeLayout2.addView(this.J_renamed, relativeLayout2.indexOfChild(relativeLayout), layoutParams);
        } else if (arrayList.size() > 1) {
            android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) this.I_renamed.getLayoutParams();
            layoutParams3.width = -1;
            layoutParams3.height = this.f5530a;
            layoutParams3.addRule(5);
            layoutParams3.leftMargin = this.f_renamed - this.e_renamed;
            layoutParams3.rightMargin = this.g_renamed;
            layoutParams3.topMargin = this.d_renamed;
            this.I_renamed.setLayoutParams(layoutParams3);
            this.G_renamed.a_renamed(arrayList);
            this.G_renamed.notifyDataSetChanged();
        }
        if (z_renamed || (i2 = this.N_renamed) == -1 || i2 >= arrayList.size()) {
            if (-1 == this.N_renamed) {
                this.N_renamed = 1;
            } else {
                this.N_renamed = i_renamed;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.N_renamed < arrayList.size()) {
            com.oplus.camera.sticker.ui.j_renamed jVar = this.z_renamed;
            if (jVar != null) {
                jVar.c_renamed(this.N_renamed);
                this.x_renamed.a_renamed(this.z_renamed.d_renamed(), false);
            }
            if (z2) {
                this.O_renamed = true;
                this.R_renamed.a_renamed(this.N_renamed);
            }
            this.P_renamed.a_renamed(arrayList.size());
            a_renamed(arrayList.get(this.N_renamed).f5556c, true);
        }
        int i3 = this.N_renamed - 1;
        com.oplus.camera.sticker.ui.e_renamed eVar = this.G_renamed;
        if (eVar != null && this.K_renamed != null && i3 >= 0 && i3 < eVar.getItemCount()) {
            this.G_renamed.b_renamed(i3);
            this.K_renamed.scrollToPosition(i3);
            j_renamed();
        }
        com.oplus.camera.e_renamed.b_renamed("StickerMenus.updateStickerCategoryMenu");
    }

    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.sticker.ui.f_renamed fVar;
        com.oplus.camera.e_renamed.a_renamed("StickerMenu", "show, isAnim: " + z_renamed);
        android.animation.AnimatorSet animatorSet = this.k_renamed;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.p_renamed = true;
        com.oplus.camera.ui.RotateImageView rotateImageView = this.v_renamed;
        if (rotateImageView != null) {
            rotateImageView.setClickable(false);
        }
        android.widget.RelativeLayout relativeLayout = this.u_renamed;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(false);
        }
        android.widget.RelativeLayout relativeLayout2 = this.I_renamed;
        if (relativeLayout2 != null) {
            relativeLayout2.setEnabled(false);
        }
        com.oplus.camera.sticker.ui.i_renamed iVar = this.A_renamed;
        if (iVar != null) {
            iVar.e_renamed();
            this.A_renamed.a_renamed(z_renamed);
        }
        d_renamed();
        android.animation.AnimatorSet animatorSet2 = this.l_renamed;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
        if (z_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.u_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            if (this.C_renamed) {
                com.oplus.camera.util.Util.a_renamed(this.y_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            }
            com.oplus.camera.sticker.ui.e_renamed eVar = this.G_renamed;
            if (eVar != null && eVar.getItemCount() > 1 && (fVar = this.J_renamed) != null) {
                com.oplus.camera.util.Util.a_renamed(fVar, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
                this.J_renamed.a_renamed(this.C_renamed);
            }
            this.j_renamed = new android.animation.AnimatorSet();
            this.j_renamed.play(l_renamed());
            this.j_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.sticker.ui.h_renamed.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    if (com.oplus.camera.sticker.ui.h_renamed.this.u_renamed != null) {
                        com.oplus.camera.sticker.ui.h_renamed.this.u_renamed.setEnabled(true);
                    }
                    if (com.oplus.camera.sticker.ui.h_renamed.this.A_renamed != null) {
                        com.oplus.camera.sticker.ui.h_renamed.this.A_renamed.a_renamed();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    if (com.oplus.camera.sticker.ui.h_renamed.this.u_renamed != null) {
                        com.oplus.camera.sticker.ui.h_renamed.this.u_renamed.setEnabled(true);
                    }
                    if (com.oplus.camera.sticker.ui.h_renamed.this.A_renamed != null) {
                        com.oplus.camera.sticker.ui.h_renamed.this.A_renamed.a_renamed();
                    }
                }
            });
            this.j_renamed.start();
        } else {
            com.oplus.camera.ui.RotateImageView rotateImageView2 = this.v_renamed;
            if (rotateImageView2 != null) {
                rotateImageView2.setAlpha(0.0f);
            }
            android.widget.RelativeLayout relativeLayout3 = this.u_renamed;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(0);
                this.u_renamed.setEnabled(true);
            }
            com.oplus.camera.sticker.ui.i_renamed iVar2 = this.A_renamed;
            if (iVar2 != null) {
                iVar2.a_renamed();
            }
            com.oplus.camera.sticker.ui.e_renamed eVar2 = this.G_renamed;
            if (eVar2 != null && eVar2.getItemCount() > 1) {
                com.oplus.camera.sticker.ui.f_renamed fVar2 = this.J_renamed;
                if (fVar2 != null) {
                    fVar2.setVisibility(0);
                    this.J_renamed.a_renamed(this.C_renamed);
                }
                a_renamed(this.N_renamed);
            }
        }
        this.s_renamed.getWindow().setNavigationBarColor(this.s_renamed.getColor(com.oplus.camera.R_renamed.color.background_color));
    }

    public void e_renamed(boolean z_renamed) {
        a_renamed(z_renamed, true, true);
    }

    public void a_renamed(boolean z_renamed, final boolean z2, boolean z3) {
        android.animation.AnimatorSet animatorSet = this.j_renamed;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        android.animation.AnimatorSet animatorSet2 = this.l_renamed;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        android.widget.RelativeLayout relativeLayout = this.u_renamed;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(false);
        }
        android.widget.RelativeLayout relativeLayout2 = this.I_renamed;
        if (relativeLayout2 != null) {
            relativeLayout2.setEnabled(false);
        }
        com.oplus.camera.sticker.ui.i_renamed iVar = this.A_renamed;
        if (iVar != null && z2) {
            iVar.b_renamed();
        }
        com.oplus.camera.util.Util.a_renamed(this.u_renamed, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
        this.s_renamed.getWindow().setNavigationBarColor(this.s_renamed.getColor(android.R_renamed.color.transparent));
        com.oplus.camera.sticker.ui.f_renamed fVar = this.J_renamed;
        if (fVar != null) {
            com.oplus.camera.util.Util.a_renamed(fVar, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
            this.J_renamed.a_renamed(this.C_renamed);
        }
        if (this.C_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.y_renamed, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
        }
        this.k_renamed = new android.animation.AnimatorSet();
        if (!z_renamed) {
            this.k_renamed.play(m_renamed());
        }
        this.k_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.sticker.ui.h_renamed.7
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (com.oplus.camera.sticker.ui.h_renamed.this.u_renamed != null) {
                    com.oplus.camera.sticker.ui.h_renamed.this.u_renamed.setEnabled(true);
                }
                if (com.oplus.camera.sticker.ui.h_renamed.this.I_renamed != null) {
                    com.oplus.camera.sticker.ui.h_renamed.this.I_renamed.setEnabled(true);
                }
                if (com.oplus.camera.sticker.ui.h_renamed.this.A_renamed == null || !z2) {
                    return;
                }
                com.oplus.camera.sticker.ui.h_renamed.this.A_renamed.c_renamed();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                if (com.oplus.camera.sticker.ui.h_renamed.this.u_renamed != null) {
                    com.oplus.camera.sticker.ui.h_renamed.this.u_renamed.setEnabled(true);
                }
                if (com.oplus.camera.sticker.ui.h_renamed.this.A_renamed != null && z2) {
                    com.oplus.camera.sticker.ui.h_renamed.this.A_renamed.c_renamed();
                }
                if (com.oplus.camera.sticker.ui.h_renamed.this.I_renamed != null) {
                    com.oplus.camera.sticker.ui.h_renamed.this.I_renamed.setEnabled(true);
                }
            }
        });
        android.animation.AnimatorSet animatorSet3 = this.m_renamed;
        if (animatorSet3 != null && z3) {
            animatorSet3.start();
        }
        this.k_renamed.start();
        this.p_renamed = false;
    }

    public void b_renamed(boolean z_renamed, boolean z2, boolean z3) {
        android.animation.AnimatorSet animatorSet = this.j_renamed;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        android.animation.AnimatorSet animatorSet2 = this.k_renamed;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        android.animation.AnimatorSet animatorSet3 = this.l_renamed;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        android.animation.AnimatorSet animatorSet4 = this.m_renamed;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
        android.widget.RelativeLayout relativeLayout = this.u_renamed;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        com.oplus.camera.sticker.ui.f_renamed fVar = this.J_renamed;
        if (fVar != null) {
            fVar.setVisibility(4);
            this.J_renamed.a_renamed(this.C_renamed);
        }
        com.oplus.camera.ui.RotateImageView rotateImageView = this.y_renamed;
        if (rotateImageView != null && this.C_renamed) {
            rotateImageView.setVisibility(4);
        }
        com.oplus.camera.ui.RotateImageView rotateImageView2 = this.v_renamed;
        if (rotateImageView2 != null) {
            rotateImageView2.setTranslationY(0.0f);
            this.v_renamed.setTranslationX(0.0f);
            this.v_renamed.setAlpha(1.0f);
            if (z_renamed) {
                this.v_renamed.setVisibility(4);
            }
        }
        com.oplus.camera.ui.control.MainShutterButton mainShutterButton = this.w_renamed;
        if (mainShutterButton != null) {
            mainShutterButton.setTranslationY(0.0f);
            this.w_renamed.setScaleX(1.0f);
            this.w_renamed.setScaleY(1.0f);
        }
        com.oplus.camera.ui.RotateImageView rotateImageView3 = this.v_renamed;
        if (rotateImageView3 != null) {
            rotateImageView3.setClickable(true);
        }
        com.oplus.camera.sticker.ui.i_renamed iVar = this.A_renamed;
        if (iVar != null) {
            iVar.b_renamed(z2);
        }
        this.p_renamed = false;
    }

    private int n_renamed() {
        return com.oplus.camera.util.Util.O_renamed() - com.oplus.camera.util.Util.Z_renamed();
    }

    private int o_renamed() {
        return this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_shutter_button_translate_y);
    }

    /* compiled from: StickerMenu.java */
    class c_renamed extends androidx.recyclerview.widget.RecyclerView.h_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f5558b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f5559c;
        private int d_renamed = 0;
        private int e_renamed;
        private int f_renamed;
        private int g_renamed;
        private int h_renamed;
        private int i_renamed;
        private android.app.Activity j_renamed;
        private android.graphics.Paint k_renamed;

        @Override // androidx.recyclerview.widget.RecyclerView.h_renamed
        public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            super.getItemOffsets(rect, view, recyclerView, tVar);
            rect.top = 0;
            rect.bottom = 0;
            if (this.d_renamed > 6) {
                if (com.oplus.camera.sticker.ui.h_renamed.this.q_renamed) {
                    if (((java.lang.Integer) view.getTag()).intValue() == 0) {
                        rect.right = 0;
                        rect.left = this.f5559c;
                        return;
                    } else if (((java.lang.Integer) view.getTag()).intValue() == this.d_renamed - 1) {
                        rect.right = this.f5559c;
                        rect.left = this.f5558b;
                        return;
                    } else {
                        rect.right = 0;
                        rect.left = this.f5558b;
                        return;
                    }
                }
                if (((java.lang.Integer) view.getTag()).intValue() == 0) {
                    rect.left = 0;
                    rect.right = this.f5559c;
                    return;
                } else if (((java.lang.Integer) view.getTag()).intValue() == this.d_renamed - 1) {
                    rect.left = this.f5559c;
                    rect.right = this.f5558b;
                    return;
                } else {
                    rect.left = 0;
                    rect.right = this.f5558b;
                    return;
                }
            }
            if (com.oplus.camera.sticker.ui.h_renamed.this.q_renamed) {
                if (((java.lang.Integer) view.getTag()).intValue() == 0) {
                    rect.right = 0;
                    rect.left = this.f5559c;
                    return;
                } else {
                    if (((java.lang.Integer) view.getTag()).intValue() != 0) {
                        rect.right = 0;
                        rect.left = this.f5558b;
                        return;
                    }
                    return;
                }
            }
            if (((java.lang.Integer) view.getTag()).intValue() == 0) {
                rect.left = 0;
                rect.right = this.f5559c;
            } else if (((java.lang.Integer) view.getTag()).intValue() != 0) {
                rect.left = 0;
                rect.right = this.f5558b;
            }
        }

        public c_renamed(android.app.Activity activity, int i_renamed, int i2, int i3) throws android.content.res.Resources.NotFoundException {
            int screenWidth;
            this.f5558b = 0;
            this.f5559c = 0;
            this.e_renamed = 0;
            this.f_renamed = 0;
            this.g_renamed = 0;
            this.h_renamed = 0;
            this.i_renamed = 0;
            this.j_renamed = null;
            this.k_renamed = null;
            this.j_renamed = activity;
            this.f5558b = i_renamed;
            this.f5559c = i2;
            this.e_renamed = i3;
            if (com.oplus.camera.sticker.ui.h_renamed.this.q_renamed) {
                screenWidth = this.j_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_recycle_line_left_padding);
            } else {
                screenWidth = com.oplus.camera.util.Util.getScreenWidth() - this.j_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_recycle_line_left_padding);
            }
            this.f_renamed = screenWidth;
            this.g_renamed = this.j_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_recycle_line_top_padding);
            this.h_renamed = this.j_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_recycle_line_width);
            this.i_renamed = this.j_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_recycle_line_height);
            this.k_renamed = new android.graphics.Paint();
            this.k_renamed.setColor(this.j_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_30_percent_transparency));
            this.k_renamed.setStrokeWidth(this.h_renamed);
        }

        public void a_renamed(int i_renamed) {
            this.d_renamed = i_renamed;
        }
    }

    /* compiled from: StickerMenu.java */
    public static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public android.graphics.drawable.Drawable f5554a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public android.graphics.drawable.Drawable f5555b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public java.lang.String f5556c;
        public boolean d_renamed;

        public b_renamed(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, java.lang.String str, boolean z_renamed) {
            this.f5554a = null;
            this.f5555b = null;
            this.f5556c = null;
            this.d_renamed = false;
            this.f5554a = drawable;
            this.f5555b = drawable2;
            this.f5556c = str;
            this.d_renamed = z_renamed;
        }
    }
}
