package com.oplus.camera.ui.menu.facebeauty;

/* compiled from: FaceBeautyMenu.java */
/* loaded from: classes2.dex */
public class g_renamed implements android.view.View.OnClickListener, com.oplus.camera.ui.OplusNumSeekBar.a_renamed, com.oplus.camera.ui.menu.facebeauty.d_renamed.a_renamed, com.oplus.camera.ui.menu.facebeauty.f_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6431a;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6433c;
    private com.oplus.camera.ui.CameraUIListener f_renamed;
    private android.app.Activity t_renamed;
    private com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed u_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6432b = 0;
    private int d_renamed = 0;
    private int e_renamed = 0;
    private int g_renamed = 0;
    private int h_renamed = 0;
    private int i_renamed = 0;
    private int j_renamed = 0;
    private int[] k_renamed = {0, 0, 0, 0, 0, 0, 0, 0};
    private boolean l_renamed = false;
    private boolean m_renamed = false;
    private boolean n_renamed = false;
    private boolean o_renamed = false;
    private boolean p_renamed = false;
    private boolean q_renamed = true;
    private android.view.animation.PathInterpolator r_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private android.view.animation.PathInterpolator s_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private com.oplus.camera.ui.menu.facebeauty.f_renamed v_renamed = null;
    private com.oplus.camera.ui.menu.facebeauty.e_renamed w_renamed = null;
    private android.animation.AnimatorSet x_renamed = null;
    private android.animation.AnimatorSet y_renamed = null;
    private android.animation.AnimatorSet z_renamed = null;
    private android.animation.AnimatorSet A_renamed = null;
    private com.oplus.camera.ui.preview.a_renamed.f_renamed B_renamed = null;
    private int C_renamed = 0;
    private int D_renamed = 0;
    private boolean E_renamed = true;
    private boolean F_renamed = true;
    private boolean G_renamed = false;
    private android.animation.AnimatorListenerAdapter H_renamed = new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.g_renamed.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            if (com.oplus.camera.ui.menu.facebeauty.g_renamed.this.l_renamed) {
                if (1 == com.oplus.camera.ui.menu.facebeauty.g_renamed.this.f6432b) {
                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.y_renamed().setVisibility(0);
                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.q_renamed().setVisibility(0);
                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.y_renamed().setAlpha(1.0f);
                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.q_renamed().setAlpha(0.0f);
                    return;
                }
                if (2 == com.oplus.camera.ui.menu.facebeauty.g_renamed.this.f6432b) {
                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.w_renamed.s_renamed().setVisibility(0);
                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.w_renamed.q_renamed().setVisibility(0);
                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.w_renamed.t_renamed().setVisibility(8);
                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.w_renamed.s_renamed().setAlpha(1.0f);
                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.w_renamed.q_renamed().setAlpha(0.0f);
                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.w_renamed.t_renamed().setAlpha(0.0f);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            if (com.oplus.camera.ui.menu.facebeauty.g_renamed.this.l_renamed) {
                return;
            }
            com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = com.oplus.camera.ui.menu.facebeauty.g_renamed.this;
            gVar.a_renamed(gVar.y_renamed());
        }
    };

    /* compiled from: FaceBeautyMenu.java */
    public interface a_renamed {
        int a_renamed(int i_renamed);

        void a_renamed();

        void a_renamed(int i_renamed, int i2, boolean z_renamed);

        void a_renamed(android.view.View view);

        int b_renamed();

        void b_renamed(int i_renamed);

        int c_renamed(int i_renamed);

        boolean c_renamed();

        int d_renamed();

        void d_renamed(int i_renamed);

        int[] e_renamed();

        int[] f_renamed();

        void g_renamed();

        int h_renamed();
    }

    public g_renamed(android.app.Activity activity, com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed aVar, int i_renamed, com.oplus.camera.ui.CameraUIListener cameraUIListener) {
        this.f6431a = 0;
        this.f_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.t_renamed = activity;
        com.oplus.camera.util.Util.q_renamed(this.t_renamed);
        this.u_renamed = aVar;
        this.f6433c = i_renamed;
        this.f_renamed = cameraUIListener;
        this.f6431a = activity.getApplicationContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_menu_translate_y);
    }

    public int e_renamed() {
        return this.f6432b;
    }

    public android.view.View b_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.facebeauty.a_renamed aVarY;
        com.oplus.camera.e_renamed.c_renamed("FaceBeautyMenu", "getLayout, menuType: " + i_renamed + ", mMenuType: " + this.f6432b);
        int i2 = this.f6432b;
        this.f6432b = i_renamed;
        if (i2 != this.f6432b && (aVarY = y_renamed()) != null) {
            aVarY.a_renamed();
        }
        int i3 = this.f6432b;
        if (i3 == 1) {
            if (this.v_renamed == null || this.E_renamed) {
                com.oplus.camera.ui.menu.facebeauty.f_renamed fVar = this.v_renamed;
                if (fVar != null) {
                    fVar.a_renamed();
                }
                this.v_renamed = new com.oplus.camera.ui.menu.facebeauty.f_renamed(this.t_renamed, this, this, this, this, this.B_renamed, this.C_renamed, this.D_renamed);
                this.E_renamed = false;
            }
            return this.v_renamed.y_renamed();
        }
        if (i3 != 2) {
            return null;
        }
        if (this.w_renamed == null || this.F_renamed) {
            com.oplus.camera.ui.menu.facebeauty.e_renamed eVar = this.w_renamed;
            if (eVar != null) {
                eVar.a_renamed();
            }
            this.w_renamed = new com.oplus.camera.ui.menu.facebeauty.e_renamed(this.t_renamed, this, this, this.C_renamed, this.D_renamed);
            this.w_renamed.a_renamed(this.B_renamed);
            this.F_renamed = false;
        }
        return this.w_renamed.s_renamed();
    }

    public void f_renamed() {
        int i_renamed = this.f6432b;
        if (i_renamed == 1) {
            this.v_renamed.f_renamed();
        } else {
            if (i_renamed != 2) {
                return;
            }
            this.w_renamed.f_renamed();
        }
    }

    public void g_renamed() {
        int i_renamed = this.f6432b;
        if (i_renamed == 1) {
            this.v_renamed.g_renamed();
        } else {
            if (i_renamed != 2) {
                return;
            }
            this.w_renamed.g_renamed();
        }
    }

    public boolean h_renamed() {
        return this.q_renamed;
    }

    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.facebeauty.e_renamed eVar;
        this.q_renamed = z_renamed;
        int i_renamed = this.f6432b;
        if (i_renamed != 1) {
            if (i_renamed == 2 && (eVar = this.w_renamed) != null) {
                eVar.b_renamed(this.q_renamed);
                this.w_renamed.d_renamed();
                return;
            }
            return;
        }
        com.oplus.camera.ui.menu.facebeauty.f_renamed fVar = this.v_renamed;
        if (fVar != null) {
            fVar.b_renamed(this.q_renamed);
            this.v_renamed.d_renamed();
        }
    }

    public android.view.ViewGroup.LayoutParams i_renamed() {
        int i_renamed = this.f6432b;
        if (i_renamed == 1) {
            return this.v_renamed.a_renamed(this.C_renamed, this.D_renamed);
        }
        if (i_renamed != 2) {
            return null;
        }
        return this.w_renamed.b_renamed(this.C_renamed, this.D_renamed);
    }

    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyMenu", "setMenuOpen, menuOpen: " + z_renamed);
        this.l_renamed = z_renamed;
    }

    public void c_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyMenu", "setProperCameraId, cameraId: " + i_renamed);
        this.d_renamed = i_renamed;
    }

    public void a_renamed(int i_renamed, int i2) {
        this.C_renamed = i_renamed;
        this.D_renamed = i2;
        this.F_renamed = true;
        this.E_renamed = true;
    }

    public void e_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyMenu", "open, needAnim: " + z_renamed + ", mMenuType: " + this.f6432b);
        int i_renamed = this.f6432b;
        if (i_renamed == 1) {
            i_renamed(z_renamed);
        } else {
            if (i_renamed != 2) {
                return;
            }
            k_renamed(z_renamed);
        }
    }

    public void f_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyMenu", "close, needAnim: " + z_renamed);
        a_renamed(this.x_renamed);
        a_renamed(this.z_renamed);
        int i_renamed = this.f6432b;
        if (i_renamed == 1) {
            j_renamed(z_renamed);
        } else {
            if (i_renamed != 2) {
                return;
            }
            if (this.f_renamed.c_renamed() && this.u_renamed.b_renamed() == 0) {
                this.p_renamed = true;
            }
            l_renamed(z_renamed);
        }
    }

    private void a_renamed(android.animation.Animator animator) {
        if (animator == null || !animator.isStarted()) {
            return;
        }
        animator.cancel();
    }

    public boolean j_renamed() {
        if (1 == this.f6432b) {
            com.oplus.camera.ui.menu.facebeauty.f_renamed fVar = this.v_renamed;
            return fVar != null && fVar.m_renamed();
        }
        com.oplus.camera.ui.menu.facebeauty.e_renamed eVar = this.w_renamed;
        return eVar != null && eVar.m_renamed();
    }

    public void g_renamed(boolean z_renamed) {
        this.p_renamed = z_renamed;
    }

    public void k_renamed() {
        com.oplus.camera.ui.menu.facebeauty.f_renamed fVar;
        if (1 == this.f6432b && (fVar = this.v_renamed) != null && this.m_renamed) {
            fVar.a_renamed(0, true, false);
            this.v_renamed.z_renamed().scrollTo(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.oplus.camera.ui.menu.facebeauty.a_renamed y_renamed() {
        int i_renamed = this.f6432b;
        if (i_renamed == 1) {
            return this.v_renamed;
        }
        if (i_renamed != 2) {
            return null;
        }
        return this.w_renamed;
    }

    public boolean l_renamed() {
        com.oplus.camera.ui.menu.facebeauty.f_renamed fVar = this.v_renamed;
        if (fVar != null) {
            return fVar.t_renamed();
        }
        return true;
    }

    public boolean m_renamed() {
        android.animation.AnimatorSet animatorSet;
        android.animation.AnimatorSet animatorSet2;
        android.animation.AnimatorSet animatorSet3;
        com.oplus.camera.ui.preview.a_renamed.f_renamed fVar;
        com.oplus.camera.ui.menu.facebeauty.e_renamed eVar;
        com.oplus.camera.ui.menu.facebeauty.f_renamed fVar2;
        android.animation.AnimatorSet animatorSet4 = this.x_renamed;
        return (animatorSet4 != null && animatorSet4.isStarted()) || ((animatorSet = this.y_renamed) != null && animatorSet.isStarted()) || (((animatorSet2 = this.z_renamed) != null && animatorSet2.isStarted()) || (((animatorSet3 = this.A_renamed) != null && animatorSet3.isStarted()) || (((fVar = this.B_renamed) != null && fVar.b_renamed()) || (((eVar = this.w_renamed) != null && eVar.b_renamed()) || ((fVar2 = this.v_renamed) != null && fVar2.b_renamed())))));
    }

    public boolean n_renamed() {
        return this.l_renamed;
    }

    public boolean o_renamed() {
        com.oplus.camera.ui.menu.facebeauty.e_renamed eVar;
        return this.f6432b == 2 && (eVar = this.w_renamed) != null && eVar.k_renamed();
    }

    public void p_renamed() {
        F_renamed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final android.view.View view) {
        if (m_renamed()) {
            com.oplus.camera.e_renamed.e_renamed("FaceBeautyMenu", "onClick, isAnimationRunning");
        }
        if (this.v_renamed.A_renamed().c_renamed()) {
            com.oplus.camera.e_renamed.e_renamed("FaceBeautyMenu", "onClick, isThumbOnDragging so return");
            return;
        }
        androidx.recyclerview.widget.RecyclerView.n_renamed nVar = null;
        switch (view.getId()) {
            case com.oplus.camera.R_renamed.id_renamed.face_beauty_none /* 2131296622 */:
                com.oplus.camera.e_renamed.a_renamed("FaceBeautyMenu", "onClick, close face beauty");
                boolean z_renamed = this.m_renamed;
                if (z_renamed) {
                    nVar = new androidx.recyclerview.widget.RecyclerView.n_renamed() { // from class: com.oplus.camera.ui.menu.facebeauty.g_renamed.2
                        @Override // androidx.recyclerview.widget.RecyclerView.n_renamed
                        public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed) {
                            if (i_renamed == 0) {
                                com.oplus.camera.ui.menu.facebeauty.g_renamed.this.u_renamed.a_renamed(view);
                            }
                        }
                    };
                    a_renamed((android.view.View) this.v_renamed.A_renamed(), false);
                    B_renamed();
                    this.v_renamed.o_renamed(false);
                    this.v_renamed.p_renamed(true);
                    this.v_renamed.a_renamed(-3, false, false);
                } else {
                    A_renamed();
                    a_renamed(this.v_renamed.A_renamed());
                    this.v_renamed.v_renamed();
                    this.v_renamed.p_renamed(D_renamed());
                    this.v_renamed.a_renamed(0, false, false);
                    this.v_renamed.a_renamed(this.u_renamed.a_renamed(0), this.u_renamed.e_renamed());
                }
                boolean zA = this.v_renamed.a_renamed(1, nVar);
                if (z_renamed && !zA) {
                    this.u_renamed.a_renamed(view);
                }
                a_renamed(com.oplus.camera.statistics.model.MenuClickMsgData.KEY_NONE_SMOOTH, 0, true);
                break;
            case com.oplus.camera.R_renamed.id_renamed.face_beauty_reset /* 2131296623 */:
                com.oplus.camera.e_renamed.a_renamed("FaceBeautyMenu", "onClick, reset face beauty");
                if (this.m_renamed && !D_renamed()) {
                    z_renamed();
                }
                this.v_renamed.a_renamed(0, (androidx.recyclerview.widget.RecyclerView.n_renamed) null);
                break;
        }
    }

    private void z_renamed() {
        com.oplus.camera.util.o_renamed.a_renamed(this.t_renamed, com.oplus.camera.R_renamed.string.camera_face_beauty_menu_reset_toast);
        this.u_renamed.a_renamed();
        this.v_renamed.a_renamed(true, true);
        this.v_renamed.a_renamed(0, false, false);
        this.v_renamed.a_renamed(this.u_renamed.a_renamed(0), this.u_renamed.e_renamed());
        this.h_renamed++;
        a_renamed(com.oplus.camera.statistics.model.MenuClickMsgData.KEY_RESET_SMOOTH, 0, true);
    }

    public void q_renamed() {
        this.v_renamed.a_renamed(s_renamed(), t_renamed(), r_renamed(), this.f_renamed.ae_renamed(), this.f_renamed.ag_renamed());
    }

    public void b_renamed(final int i_renamed, final boolean z_renamed) {
        this.f_renamed.onMakeupTypeChanged(i_renamed, z_renamed);
        android.app.Activity activity = this.t_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.facebeauty.g_renamed.3
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed != null) {
                        com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.a_renamed(i_renamed, false, true);
                        if (com.oplus.camera.ui.menu.facebeauty.g_renamed.this.n_renamed && com.oplus.camera.ui.menu.facebeauty.g_renamed.this.n_renamed()) {
                            if (i_renamed == 0) {
                                if (com.oplus.camera.ui.menu.facebeauty.g_renamed.this.o_renamed) {
                                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.o_renamed = false;
                                    com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = com.oplus.camera.ui.menu.facebeauty.g_renamed.this;
                                    gVar.a_renamed((android.view.View) gVar.v_renamed.A_renamed(), false);
                                }
                            } else {
                                if (!com.oplus.camera.ui.menu.facebeauty.g_renamed.this.o_renamed) {
                                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.o_renamed = true;
                                    com.oplus.camera.ui.menu.facebeauty.g_renamed gVar2 = com.oplus.camera.ui.menu.facebeauty.g_renamed.this;
                                    gVar2.a_renamed(gVar2.v_renamed.A_renamed());
                                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.v_renamed();
                                } else if (!com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.A_renamed().isShown()) {
                                    com.oplus.camera.ui.menu.facebeauty.g_renamed gVar3 = com.oplus.camera.ui.menu.facebeauty.g_renamed.this;
                                    gVar3.a_renamed(gVar3.v_renamed.A_renamed());
                                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.v_renamed();
                                }
                                com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.b_renamed(com.oplus.camera.ui.menu.facebeauty.g_renamed.this.u_renamed.c_renamed(i_renamed), com.oplus.camera.ui.menu.facebeauty.g_renamed.this.u_renamed.f_renamed());
                            }
                            if (1 == com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.x_renamed().get(i_renamed).d_renamed() && z_renamed) {
                                com.oplus.camera.ui.menu.facebeauty.g_renamed.this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_tips, -1, true, false, false, false);
                            }
                        }
                    }
                    if (z_renamed) {
                        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar4 = com.oplus.camera.ui.menu.facebeauty.g_renamed.this;
                        gVar4.b_renamed(i_renamed, gVar4.u_renamed.c_renamed(i_renamed));
                    }
                    com.oplus.camera.ui.menu.facebeauty.g_renamed.this.u_renamed.g_renamed();
                }
            });
        }
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.f_renamed.a_renamed
    public void a_renamed(android.view.View view, int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyMenu", "onItemClick, position: " + i_renamed + ", mMenuType: " + this.f6432b + ", mbCurrentTapMakeup: " + this.n_renamed);
        if (m_renamed()) {
            com.oplus.camera.e_renamed.e_renamed("FaceBeautyMenu", "onItemClick, isAnimationRunning");
            return;
        }
        if (this.v_renamed.A_renamed().c_renamed()) {
            com.oplus.camera.e_renamed.e_renamed("FaceBeautyMenu", "onItemClick, isThumbOnDragging");
            this.v_renamed.A_renamed().b_renamed();
            return;
        }
        if (1 == this.f6432b) {
            if (this.n_renamed) {
                b_renamed(i_renamed, true);
                this.v_renamed.a_renamed(i_renamed, true, this.n_renamed);
                this.f_renamed.onMakeupTypeChanged(i_renamed, true);
                if (i_renamed == 0) {
                    if (this.o_renamed) {
                        this.o_renamed = false;
                        a_renamed((android.view.View) this.v_renamed.A_renamed(), false);
                    }
                } else {
                    if (!this.o_renamed) {
                        this.o_renamed = true;
                        a_renamed(this.v_renamed.A_renamed());
                        this.v_renamed.v_renamed();
                    }
                    this.v_renamed.b_renamed(this.u_renamed.c_renamed(i_renamed), this.u_renamed.f_renamed());
                }
                b_renamed(i_renamed, this.u_renamed.c_renamed(i_renamed));
                return;
            }
            int i2 = i_renamed - 2;
            int iA = this.u_renamed.a_renamed(i2);
            a_renamed(com.oplus.camera.statistics.model.MenuClickMsgData.KEY_COMMON_CUSTOM_BEAUTY[i2], iA, !this.m_renamed);
            if (!this.m_renamed) {
                A_renamed();
                a_renamed(this.v_renamed.A_renamed());
                this.v_renamed.v_renamed();
                this.v_renamed.p_renamed(D_renamed());
            }
            this.v_renamed.a_renamed(i2, true, this.n_renamed);
            this.v_renamed.a_renamed(iA, this.u_renamed.e_renamed());
            int[] iArr = this.k_renamed;
            if (i2 < iArr.length) {
                iArr[i2] = iArr[i2] + 1;
            }
        }
    }

    @Override // com.oplus.camera.ui.OplusNumSeekBar.a_renamed
    public void a_renamed(com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar, int i_renamed, boolean z_renamed) {
        c_renamed(i_renamed, false);
    }

    @Override // com.oplus.camera.ui.OplusNumSeekBar.a_renamed
    public void a_renamed(com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar, int i_renamed) {
        com.oplus.camera.ui.menu.facebeauty.e_renamed eVar = this.w_renamed;
        if (eVar != null) {
            eVar.n_renamed(false);
            return;
        }
        com.oplus.camera.ui.menu.facebeauty.f_renamed fVar = this.v_renamed;
        if (fVar != null) {
            fVar.n_renamed(false);
        }
    }

    @Override // com.oplus.camera.ui.OplusNumSeekBar.a_renamed
    public void b_renamed(com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar, int i_renamed) {
        c_renamed(i_renamed, true);
        if (1 == this.f6432b) {
            this.v_renamed.p_renamed(D_renamed());
        }
        com.oplus.camera.ui.menu.facebeauty.e_renamed eVar = this.w_renamed;
        if (eVar != null) {
            eVar.n_renamed(true);
            return;
        }
        com.oplus.camera.ui.menu.facebeauty.f_renamed fVar = this.v_renamed;
        if (fVar != null) {
            fVar.n_renamed(true);
        }
    }

    private void c_renamed(int i_renamed, boolean z_renamed) {
        int i2 = this.f6432b;
        if (1 != i2) {
            if (2 == i2) {
                this.u_renamed.a_renamed(0, i_renamed, z_renamed);
                if (!this.m_renamed && i_renamed != 0) {
                    A_renamed();
                    return;
                } else {
                    if (this.m_renamed && i_renamed == 0) {
                        B_renamed();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.n_renamed) {
            this.f_renamed.onMakeupValueChanged(this.v_renamed.w_renamed(), i_renamed, z_renamed);
            if (z_renamed) {
                b_renamed(this.v_renamed.w_renamed(), i_renamed);
                return;
            }
            return;
        }
        if (this.v_renamed.w_renamed() >= 0) {
            this.u_renamed.a_renamed(this.v_renamed.w_renamed(), i_renamed, z_renamed);
            if (z_renamed) {
                a_renamed(com.oplus.camera.statistics.model.MenuClickMsgData.KEY_COMMON_CUSTOM_BEAUTY[this.v_renamed.w_renamed()], i_renamed, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(int i_renamed, int i2) {
        java.lang.String str;
        if (i_renamed <= 0) {
            com.oplus.camera.e_renamed.c_renamed("FaceBeautyMenu", "reportMakeupDCS, index is_renamed " + i_renamed);
            i2 = 0;
            str = com.oplus.camera.statistics.model.MenuClickMsgData.KEY_MAKEUP_CLEAR;
        } else {
            str = com.oplus.camera.statistics.model.MenuClickMsgData.sKeyMakeupList.get(i_renamed);
        }
        a_renamed(str, i2, true);
    }

    @Override // com.oplus.camera.ui.OplusNumSeekBar.a_renamed
    public boolean a_renamed() {
        return this.u_renamed.c_renamed();
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.f_renamed.a_renamed
    public boolean d_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.f_renamed;
        return cameraUIListener != null && cameraUIListener.bL_renamed().q_renamed();
    }

    private void A_renamed() {
        this.u_renamed.b_renamed(102);
        this.m_renamed = true;
    }

    private void B_renamed() {
        this.u_renamed.b_renamed(0);
        this.m_renamed = false;
    }

    public boolean r_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.f_renamed;
        return cameraUIListener != null && cameraUIListener.h_renamed(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_PROCESS);
    }

    public boolean s_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.f_renamed;
        return cameraUIListener != null && cameraUIListener.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_MAKEUP);
    }

    public boolean t_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.f_renamed;
        return cameraUIListener != null && cameraUIListener.z_renamed();
    }

    public boolean u_renamed() {
        return r_renamed() || s_renamed() || t_renamed();
    }

    private void i_renamed(boolean z_renamed) {
        this.m_renamed = this.u_renamed.b_renamed() != 0;
        this.o_renamed = s_renamed() && this.f_renamed.ae_renamed() != 0;
        this.v_renamed.b_renamed(this.q_renamed);
        q_renamed();
        C_renamed();
        if (this.m_renamed) {
            this.v_renamed.v_renamed();
            this.v_renamed.a_renamed(java.lang.Math.max(this.v_renamed.w_renamed(), 0), true, false);
            com.oplus.camera.ui.menu.facebeauty.f_renamed fVar = this.v_renamed;
            fVar.a_renamed(this.u_renamed.a_renamed(fVar.w_renamed()), this.u_renamed.e_renamed());
            this.v_renamed.o_renamed(true);
            this.v_renamed.p_renamed(D_renamed());
        } else {
            this.v_renamed.a_renamed(-3, true, false);
            this.v_renamed.u_renamed();
            this.v_renamed.o_renamed(false);
            this.v_renamed.p_renamed(true);
        }
        a_renamed(this.v_renamed, z_renamed);
        this.v_renamed.c_renamed(z_renamed);
    }

    private void C_renamed() {
        android.widget.LinearLayout linearLayout;
        com.oplus.camera.ui.menu.facebeauty.f_renamed fVar = this.v_renamed;
        if (fVar != null) {
            android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) fVar.q_renamed();
            if (linearLayout2 != null) {
                int childCount = linearLayout2.getChildCount();
                for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                    ((com.oplus.camera.ui.menu.facebeauty.TabContainerTextView) ((android.widget.FrameLayout) linearLayout2.getChildAt(i_renamed)).getChildAt(0)).setLightBgColor(this.G_renamed);
                }
            }
            if (!com.oplus.camera.util.Util.t_renamed()) {
                this.v_renamed.s_renamed();
            }
        }
        com.oplus.camera.ui.menu.facebeauty.e_renamed eVar = this.w_renamed;
        if (eVar == null || (linearLayout = (android.widget.LinearLayout) eVar.q_renamed()) == null) {
            return;
        }
        int childCount2 = linearLayout.getChildCount();
        for (int i2 = 0; i2 < childCount2; i2++) {
            ((com.oplus.camera.ui.menu.facebeauty.TabContainerTextView) ((android.widget.FrameLayout) linearLayout.getChildAt(i2)).getChildAt(0)).setLightBgColor(this.G_renamed);
        }
    }

    private void j_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.facebeauty.f_renamed fVar = this.v_renamed;
        if (fVar == null) {
            return;
        }
        if (fVar.A_renamed().c_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("FaceBeautyMenu", "closeCustomBeautyMenu, isThumbOnDragging");
            this.v_renamed.A_renamed().b_renamed();
        }
        if (z_renamed) {
            b_renamed((com.oplus.camera.ui.menu.facebeauty.d_renamed) this.v_renamed, true);
            this.v_renamed.d_renamed(true);
        } else {
            this.v_renamed.d_renamed(false);
            a_renamed(this.v_renamed);
        }
    }

    private void k_renamed(boolean z_renamed) {
        if (this.w_renamed != null) {
            this.m_renamed = this.u_renamed.b_renamed() != 0;
            boolean zT = t_renamed();
            boolean zR = r_renamed();
            this.w_renamed.b_renamed(this.q_renamed);
            this.w_renamed.a_renamed(zR, zT);
            this.w_renamed.a_renamed(this.u_renamed.a_renamed(0), this.u_renamed.d_renamed());
            C_renamed();
            if (this.w_renamed.t_renamed().c_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("FaceBeautyMenu", "closeCustomBeautyMenu, isThumbOnDragging");
                this.w_renamed.t_renamed().b_renamed();
            }
            a_renamed(this.w_renamed, z_renamed);
            this.w_renamed.c_renamed(z_renamed);
            this.j_renamed++;
        }
    }

    public void d_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.facebeauty.e_renamed eVar;
        if (2 != this.f6432b || (eVar = this.w_renamed) == null) {
            return;
        }
        eVar.a_renamed(i_renamed, this.u_renamed.d_renamed());
    }

    private void l_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.facebeauty.e_renamed eVar = this.w_renamed;
        if (eVar == null) {
            return;
        }
        if (eVar.t_renamed().c_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("FaceBeautyMenu", "closeCommonBeautyMenu, isThumbOnDragging");
            this.w_renamed.t_renamed().b_renamed();
        }
        if (z_renamed) {
            b_renamed((com.oplus.camera.ui.menu.facebeauty.d_renamed) this.w_renamed, true);
            this.w_renamed.d_renamed(true);
        } else {
            this.w_renamed.d_renamed(false);
            a_renamed(this.w_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.camera.ui.menu.facebeauty.a_renamed aVar) {
        if (aVar != null) {
            aVar.a_renamed();
        }
    }

    private boolean D_renamed() {
        int i_renamed = 0;
        for (int i2 : this.u_renamed.e_renamed()) {
            int iA = this.u_renamed.a_renamed(i_renamed);
            if (iA != i2 && iA != -100000) {
                return false;
            }
            i_renamed++;
        }
        return true;
    }

    private void a_renamed(com.oplus.camera.ui.menu.facebeauty.d_renamed dVar, boolean z_renamed) {
        android.animation.AnimatorSet animatorSet;
        android.view.View viewQ = (dVar == null || dVar.q_renamed() == null) ? null : dVar.q_renamed();
        if (viewQ == null || ((animatorSet = this.x_renamed) != null && animatorSet.isStarted())) {
            com.oplus.camera.e_renamed.a_renamed("FaceBeautyMenu", "openFaceBeautyTab, menu: " + dVar + ", tabView is_renamed null, return");
            return;
        }
        android.animation.AnimatorSet animatorSet2 = this.y_renamed;
        if (animatorSet2 != null && animatorSet2.isStarted()) {
            this.y_renamed.cancel();
        }
        if (z_renamed) {
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(viewQ, v_renamed(), w_renamed(), 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.s_renamed);
            objectAnimatorOfFloat.setDuration(400L);
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(viewQ, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat2.setInterpolator(this.r_renamed);
            objectAnimatorOfFloat2.setDuration(400L);
            this.x_renamed = new android.animation.AnimatorSet();
            this.x_renamed.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
            this.x_renamed.setStartDelay(150L);
            this.x_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.g_renamed.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.menu.facebeauty.g_renamed.this.l_renamed) {
                        if (1 == com.oplus.camera.ui.menu.facebeauty.g_renamed.this.f6432b) {
                            com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.y_renamed().setVisibility(0);
                            com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.q_renamed().setVisibility(0);
                            com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.B_renamed();
                            com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.y_renamed().setAlpha(1.0f);
                            com.oplus.camera.ui.menu.facebeauty.g_renamed.this.v_renamed.q_renamed().setAlpha(0.0f);
                            return;
                        }
                        if (2 == com.oplus.camera.ui.menu.facebeauty.g_renamed.this.f6432b) {
                            com.oplus.camera.ui.menu.facebeauty.g_renamed.this.w_renamed.s_renamed().setVisibility(0);
                            com.oplus.camera.ui.menu.facebeauty.g_renamed.this.w_renamed.q_renamed().setVisibility(0);
                            com.oplus.camera.ui.menu.facebeauty.g_renamed.this.w_renamed.t_renamed().setVisibility(8);
                            com.oplus.camera.ui.menu.facebeauty.g_renamed.this.w_renamed.s_renamed().setAlpha(1.0f);
                            com.oplus.camera.ui.menu.facebeauty.g_renamed.this.w_renamed.q_renamed().setAlpha(0.0f);
                            com.oplus.camera.ui.menu.facebeauty.g_renamed.this.w_renamed.t_renamed().setAlpha(0.0f);
                        }
                    }
                }
            });
            this.x_renamed.start();
            return;
        }
        E_renamed();
    }

    private void E_renamed() {
        int i_renamed = this.f6432b;
        if (1 == i_renamed) {
            this.v_renamed.y_renamed().setVisibility(0);
            this.v_renamed.q_renamed().setVisibility(0);
            this.v_renamed.y_renamed().setAlpha(1.0f);
            this.v_renamed.q_renamed().setAlpha(1.0f);
            return;
        }
        if (2 == i_renamed) {
            this.w_renamed.s_renamed().setVisibility(0);
            this.w_renamed.q_renamed().setVisibility(0);
            this.w_renamed.t_renamed().setVisibility(8);
            this.w_renamed.s_renamed().setAlpha(1.0f);
            this.w_renamed.q_renamed().setAlpha(1.0f);
            this.w_renamed.t_renamed().setAlpha(1.0f);
        }
    }

    private void b_renamed(com.oplus.camera.ui.menu.facebeauty.d_renamed dVar, boolean z_renamed) {
        android.animation.AnimatorSet animatorSet;
        android.view.View viewQ = (dVar == null || dVar.q_renamed() == null) ? null : dVar.q_renamed();
        if (viewQ == null || ((animatorSet = this.y_renamed) != null && animatorSet.isStarted())) {
            com.oplus.camera.e_renamed.a_renamed("FaceBeautyMenu", "closeFaceBeautyTab, menu: " + dVar + ", mBeautyTabExitAnimationSet.isStarted(): " + this.y_renamed.isStarted() + ", so return");
            return;
        }
        android.animation.AnimatorSet animatorSet2 = this.x_renamed;
        if (animatorSet2 != null && animatorSet2.isStarted()) {
            this.x_renamed.cancel();
        }
        if (z_renamed) {
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(viewQ, v_renamed(), 0.0f, w_renamed());
            objectAnimatorOfFloat.setInterpolator(this.s_renamed);
            objectAnimatorOfFloat.setDuration(400L);
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(viewQ, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.r_renamed);
            objectAnimatorOfFloat2.setDuration(250L);
            this.y_renamed = new android.animation.AnimatorSet();
            this.y_renamed.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
            this.y_renamed.addListener(this.H_renamed);
            this.y_renamed.start();
            return;
        }
        viewQ.setVisibility(8);
        viewQ.setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.view.View view) {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.r_renamed);
        objectAnimatorOfFloat.setDuration(400L);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(view, v_renamed(), w_renamed(), 0.0f);
        objectAnimatorOfFloat2.setInterpolator(this.s_renamed);
        objectAnimatorOfFloat2.setDuration(400L);
        this.z_renamed = new android.animation.AnimatorSet();
        this.z_renamed.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.z_renamed.setStartDelay(150L);
        this.z_renamed.start();
        view.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.view.View view, boolean z_renamed) {
        android.animation.AnimatorSet animatorSet = this.z_renamed;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.r_renamed);
        objectAnimatorOfFloat.setDuration(250L);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(view, v_renamed(), 0.0f, w_renamed());
        objectAnimatorOfFloat2.setInterpolator(this.s_renamed);
        objectAnimatorOfFloat2.setDuration(400L);
        this.A_renamed = new android.animation.AnimatorSet();
        if (z_renamed) {
            this.A_renamed.addListener(this.H_renamed);
        }
        this.A_renamed.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        this.A_renamed.start();
        view.setEnabled(false);
    }

    private void F_renamed() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i_renamed = 0;
        while (true) {
            int[] iArr = this.k_renamed;
            if (i_renamed >= iArr.length) {
                break;
            }
            if (iArr[i_renamed] > 0) {
                sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.CUSTOM_BEAUTY_CLICK_NUMS[i_renamed], java.lang.String.valueOf(this.k_renamed[i_renamed])));
                this.k_renamed[i_renamed] = 0;
            }
            i_renamed++;
        }
        int i2 = this.g_renamed;
        if (i2 > 0) {
            sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.FACE_BEAUTY_RESET_SHOW, java.lang.String.valueOf(i2)));
            this.g_renamed = 0;
        }
        int i3 = this.h_renamed;
        if (i3 > 0) {
            sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.FACE_BEAUTY_RESET_OK, java.lang.String.valueOf(i3)));
            this.h_renamed = 0;
        }
        int i4 = this.i_renamed;
        if (i4 > 0) {
            sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.FACE_BEAUTY_RESET_CANCEL, java.lang.String.valueOf(i4)));
            this.i_renamed = 0;
        }
        int i5 = this.j_renamed;
        if (i5 > 0) {
            sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.FACE_BEAUTY_COMMON_SHOW, java.lang.String.valueOf(i5)));
            this.j_renamed = 0;
        }
        if (sb.length() > 0) {
            com.oplus.camera.statistics.CameraStatisticsUtil.onCommon(this.t_renamed, com.oplus.camera.statistics.CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString());
        }
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed.a_renamed
    public void a_renamed(java.lang.String str, int i_renamed, boolean z_renamed) {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.t_renamed);
        if (z_renamed) {
            menuClickMsgData.buildEvent(true);
        } else {
            menuClickMsgData.buildMenuSelect();
        }
        menuClickMsgData.mFuncKeyId = 2;
        menuClickMsgData.mItem = str;
        menuClickMsgData.mItemValue = java.lang.String.valueOf(i_renamed);
        menuClickMsgData.mCameraId = this.f_renamed.G_renamed();
        menuClickMsgData.mCameraEnterType = java.lang.String.valueOf(this.f6433c);
        menuClickMsgData.mCaptureType = !this.f_renamed.B_renamed() ? 1 : 0;
        menuClickMsgData.mCaptureMode = this.f_renamed.ao_renamed();
        menuClickMsgData.mRearOrFront = com.oplus.camera.e_renamed.a_renamed.a_renamed(this.d_renamed) ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        menuClickMsgData.report();
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed.a_renamed
    public void a_renamed(int i_renamed) {
        this.u_renamed.d_renamed(i_renamed);
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed.a_renamed
    public int b_renamed() {
        return this.u_renamed.h_renamed();
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed.a_renamed
    public boolean c_renamed() {
        return this.f_renamed.aJ_renamed();
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed.a_renamed
    public int a_renamed(int i_renamed, boolean z_renamed) {
        if (i_renamed >= 0) {
            if (z_renamed) {
                return this.u_renamed.c_renamed(i_renamed);
            }
            return this.u_renamed.a_renamed(i_renamed);
        }
        com.oplus.camera.e_renamed.b_renamed("FaceBeautyMenu", "getValueAtIndex, index: " + i_renamed + ", so return 0!");
        return 0;
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed.a_renamed
    public int[] a_renamed(boolean z_renamed) {
        if (z_renamed) {
            return this.u_renamed.f_renamed();
        }
        return this.u_renamed.e_renamed();
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed.a_renamed
    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("FaceBeautyMenu", "currentTapChange, currentMakeup: " + z_renamed);
        this.n_renamed = z_renamed;
        if (this.n_renamed) {
            this.o_renamed = this.f_renamed.ae_renamed() != 0;
            this.f_renamed.l_renamed(7);
        }
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.f_renamed fVar) {
        this.B_renamed = fVar;
    }

    public void e_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyMenu", "notifyPreviewLayoutSizeChanged, previewType: " + i_renamed);
        this.e_renamed = i_renamed;
    }

    public void f_renamed(int i_renamed) {
        com.oplus.camera.ui.OplusNumAISeekBar oplusNumAISeekBarA;
        com.oplus.camera.ui.OplusNumAISeekBar oplusNumAISeekBarT;
        com.oplus.camera.ui.menu.facebeauty.e_renamed eVar = this.w_renamed;
        if (eVar != null && (oplusNumAISeekBarT = eVar.t_renamed()) != null) {
            oplusNumAISeekBarT.a_renamed(i_renamed, true);
        }
        com.oplus.camera.ui.menu.facebeauty.f_renamed fVar = this.v_renamed;
        if (fVar == null || (oplusNumAISeekBarA = fVar.A_renamed()) == null) {
            return;
        }
        oplusNumAISeekBarA.a_renamed(i_renamed, true);
    }

    protected java.lang.String v_renamed() {
        return 1 == this.C_renamed ? "translationX" : "translationY";
    }

    protected int w_renamed() {
        if (1 == this.C_renamed && 270 != this.D_renamed) {
            return -this.f6431a;
        }
        return this.f6431a;
    }

    public void h_renamed(boolean z_renamed) {
        this.G_renamed = z_renamed;
    }

    public void x_renamed() {
        com.oplus.camera.ui.menu.facebeauty.f_renamed fVar = this.v_renamed;
        if (fVar != null) {
            fVar.s_renamed();
        }
    }
}
