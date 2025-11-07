package com.oplus.camera.ui.preview;

/* compiled from: PIAISceneUI.java */
/* loaded from: classes2.dex */
public class u_renamed extends com.oplus.camera.ui.preview.a_renamed {
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int r_renamed;
    private android.widget.RelativeLayout d_renamed = null;
    private com.oplus.camera.ui.preview.AISceneView e_renamed = null;
    private com.oplus.camera.ui.preview.u_renamed.a_renamed f_renamed = null;
    private com.oplus.camera.ui.preview.a_renamed.AISceneUI_2 g_renamed = null;
    private int n_renamed = 0;
    private int o_renamed = 0;
    private int p_renamed = 67108863;
    private int q_renamed = 0;
    private int s_renamed = 0;
    private int t_renamed = 0;
    private int u_renamed = 0;
    private com.oplus.camera.ui.r_renamed v_renamed = null;
    private android.view.View.OnLayoutChangeListener w_renamed = null;
    private boolean x_renamed = false;
    private com.oplus.camera.ui.r_renamed.a_renamed y_renamed = new com.oplus.camera.ui.r_renamed.a_renamed() { // from class: com.oplus.camera.ui.preview.u_renamed.1
        @Override // com.oplus.camera.ui.r_renamed.a_renamed
        public void a_renamed(int i_renamed) {
            com.oplus.camera.ui.preview.u_renamed.this.n_renamed = i_renamed;
            com.oplus.camera.ui.preview.u_renamed.this.f_renamed(i_renamed);
        }

        @Override // com.oplus.camera.ui.r_renamed.a_renamed
        public boolean a_renamed() {
            return com.oplus.camera.ui.preview.u_renamed.this.d_renamed != null && com.oplus.camera.ui.preview.u_renamed.this.d_renamed.getVisibility() == 0;
        }

        @Override // com.oplus.camera.ui.r_renamed.a_renamed
        public void a_renamed(float f_renamed) {
            if (com.oplus.camera.ui.preview.u_renamed.this.d_renamed != null) {
                com.oplus.camera.ui.preview.u_renamed.this.d_renamed.setAlpha(f_renamed);
            }
        }
    };
    private android.os.Handler z_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.ui.preview.u_renamed.4
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i_renamed = message.what;
            if (i_renamed == 1) {
                com.oplus.camera.e_renamed.c_renamed("PIAISceneUI", "handleMessage: 1");
                if (com.oplus.camera.ui.preview.u_renamed.this.o_renamed == 0) {
                    com.oplus.camera.ui.preview.u_renamed.this.z_renamed.removeMessages(3000);
                    com.oplus.camera.ui.preview.u_renamed.this.h_renamed();
                    return;
                }
                return;
            }
            if (i_renamed != 2) {
                return;
            }
            com.oplus.camera.e_renamed.c_renamed("PIAISceneUI", "handleMessage: 2");
            if (com.oplus.camera.ui.preview.u_renamed.this.o_renamed != 0) {
                com.oplus.camera.ui.preview.u_renamed.this.q_renamed();
            }
        }
    };

    private int a_renamed(int i_renamed, int i2, boolean z_renamed) {
        return z_renamed ? (1 << (i_renamed - 1)) | i2 : (~(1 << (i_renamed - 1))) & i2;
    }

    public u_renamed(android.app.Activity activity, android.view.ViewGroup viewGroup, com.oplus.camera.ComboPreferences comboPreferences) {
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.r_renamed = 0;
        this.f6818a = activity;
        this.f6819b = viewGroup;
        this.f6820c = comboPreferences;
        this.h_renamed = this.f6818a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.pi_ai_scene_margin_top);
        this.i_renamed = this.f6818a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.pi_ai_scene_margin_start);
        this.j_renamed = (int) (com.oplus.camera.util.Util.getScreenWidth() * 1.3333333333333333d);
        this.k_renamed = (int) ((com.oplus.camera.util.Util.getScreenWidth() / 2.0f) * 1.3333333333333333d);
        this.l_renamed = this.f6818a.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_hint_view_margin_top_offset_rotate);
        this.m_renamed = com.oplus.camera.util.Util.getScreenWidth();
        this.r_renamed = this.f6818a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.toast_margin_top);
    }

    private void l_renamed() {
        if (this.d_renamed != null || this.f6819b == null) {
            return;
        }
        this.f6818a.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.pi_ai_scene_layout, this.f6819b);
        this.d_renamed = (android.widget.RelativeLayout) this.f6818a.findViewById(com.oplus.camera.R_renamed.id_renamed.ai_scene_layout);
        this.e_renamed = (com.oplus.camera.ui.preview.AISceneView) this.d_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.ai_scene_text);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void a_renamed(boolean z_renamed) {
        n_renamed();
        if (this.d_renamed != null && this.f6819b != null) {
            this.f6819b.removeView(this.d_renamed);
            this.d_renamed = null;
            this.e_renamed = null;
        }
        this.o_renamed = 0;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void a_renamed(android.view.View.OnLayoutChangeListener onLayoutChangeListener) {
        this.w_renamed = onLayoutChangeListener;
        m_renamed();
    }

    private void m_renamed() {
        android.view.View.OnLayoutChangeListener onLayoutChangeListener;
        android.widget.RelativeLayout relativeLayout = this.d_renamed;
        if (relativeLayout == null || (onLayoutChangeListener = this.w_renamed) == null) {
            return;
        }
        relativeLayout.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void b_renamed(int i_renamed) {
        this.o_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void a_renamed(int i_renamed, int i2, int i3) {
        this.o_renamed = i_renamed;
        g_renamed(i2);
        if (i_renamed(i_renamed)) {
            if (i_renamed()) {
                h_renamed();
                return;
            }
            return;
        }
        if (this.o_renamed != 0) {
            l_renamed();
        }
        if (this.d_renamed == null) {
            return;
        }
        com.oplus.camera.ui.preview.u_renamed.a_renamed aVarA = a_renamed(i_renamed, i3);
        if (-1 == aVarA.a_renamed()) {
            h_renamed();
            return;
        }
        this.e_renamed.setText(aVarA.a_renamed());
        f_renamed(i2);
        n_renamed();
        q_renamed();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.AISceneUI_2 interfaceC0133a) {
        this.g_renamed = interfaceC0133a;
    }

    private void n_renamed() {
        com.oplus.camera.ui.preview.AISceneView aISceneView = this.e_renamed;
        if (aISceneView != null) {
            aISceneView.a_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void b_renamed(int i_renamed, boolean z_renamed) {
        this.p_renamed = a_renamed(i_renamed, this.p_renamed, z_renamed);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void c_renamed(int i_renamed) {
        android.widget.RelativeLayout relativeLayout = this.d_renamed;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i_renamed);
        }
    }

    private boolean i_renamed(int i_renamed) {
        return ((this.p_renamed >> (i_renamed - 1)) & 1) == 0;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void d_renamed() {
        this.f6820c.edit().remove("oplus.camera.ai_scene_enable_list").apply();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public boolean e_renamed(int i_renamed) {
        return i_renamed == 0 ? (this.f6820c == null || this.f6818a == null || !"on_renamed".equals(this.f6820c.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI, this.f6818a.getString(com.oplus.camera.R_renamed.string.camera_pi_ai_default_value)))) ? false : true : ((e_renamed() >> (i_renamed - 1)) & 1) > 0;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public int e_renamed() {
        return this.p_renamed & this.f6820c.getInt("oplus.camera.ai_scene_enable_list", 67108863);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void h_renamed() {
        android.os.Handler handler = this.z_renamed;
        if (handler != null && handler.hasMessages(2)) {
            this.z_renamed.removeMessages(2);
        }
        n_renamed();
        r_renamed();
    }

    private void o_renamed() {
        this.v_renamed = new com.oplus.camera.ui.r_renamed(1.0f, 0.0f);
        this.v_renamed.setDuration(300L);
        this.v_renamed.a_renamed(this.y_renamed);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void a_renamed(int i_renamed, int i2, int i3, boolean z_renamed) {
        if (this.s_renamed == i_renamed && this.t_renamed == i2 && this.m_renamed == i3 && this.x_renamed == z_renamed) {
            return;
        }
        this.s_renamed = i_renamed;
        this.t_renamed = i2;
        this.m_renamed = i3;
        this.x_renamed = z_renamed;
        f_renamed(this.n_renamed);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void d_renamed(int i_renamed) {
        this.u_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    protected void f_renamed(int i_renamed) {
        if (this.d_renamed == null || this.e_renamed == null) {
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        this.d_renamed.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredWidth = this.d_renamed.getMeasuredWidth();
        int measuredHeight = this.d_renamed.getMeasuredHeight();
        this.d_renamed.layout(0, 0, measuredWidth, measuredHeight);
        if (i_renamed == 90) {
            layoutParams.addRule(9);
            layoutParams.leftMargin = this.i_renamed - ((measuredWidth - measuredHeight) / 2);
            int iN = ((this.j_renamed - measuredHeight) / 2) + com.oplus.camera.util.Util.N_renamed();
            int i2 = this.s_renamed;
            layoutParams.topMargin = (iN + i2) - this.t_renamed;
            if (3 == this.q_renamed) {
                layoutParams.topMargin = ((this.k_renamed - measuredHeight) / 2) + i2 + this.l_renamed;
            }
        } else if (i_renamed == 270) {
            layoutParams.addRule(11);
            layoutParams.rightMargin = this.i_renamed - ((measuredWidth - measuredHeight) / 2);
            int iN2 = ((this.j_renamed - measuredHeight) / 2) + com.oplus.camera.util.Util.N_renamed();
            int i3 = this.s_renamed;
            layoutParams.topMargin = (iN2 - i3) - this.t_renamed;
            if (3 == this.q_renamed) {
                layoutParams.topMargin = (((this.k_renamed - measuredHeight) / 2) - i3) + this.l_renamed;
            }
        } else if (this.x_renamed) {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            layoutParams.leftMargin = ((p_renamed() - measuredWidth) / 2) - this.s_renamed;
            layoutParams.bottomMargin = this.f6818a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.low_rack_mode_camera_screen_hint_view_margin_bottom);
        } else {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.leftMargin = ((p_renamed() - measuredWidth) / 2) - this.s_renamed;
            layoutParams.topMargin = (((this.h_renamed + com.oplus.camera.util.Util.N_renamed()) + this.r_renamed) - this.t_renamed) + this.u_renamed;
        }
        this.e_renamed.setZ(999.0f);
        this.d_renamed.setLayoutParams(layoutParams);
        this.d_renamed.setRotation(-this.n_renamed);
    }

    private int p_renamed() {
        if (3 == this.q_renamed) {
            return this.m_renamed / 2;
        }
        return this.m_renamed;
    }

    private com.oplus.camera.ui.preview.u_renamed.a_renamed a_renamed(int i_renamed, int i2) {
        if (this.f_renamed == null) {
            this.f_renamed = new com.oplus.camera.ui.preview.u_renamed.a_renamed();
        }
        switch (i_renamed) {
            case 1:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_beach);
                break;
            case 2:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_bluesky);
                break;
            case 3:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_cat);
                break;
            case 4:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_text);
                break;
            case 5:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_dog);
                break;
            case 6:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_firework);
                break;
            case 7:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_gourmet);
                break;
            case 8:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_grass);
                break;
            case 9:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_indoor);
                break;
            case 10:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_infant);
                break;
            case 11:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_landscape);
                break;
            case 12:
                com.oplus.camera.e_renamed.b_renamed("PIAISceneUI", "getDataByAIScene, subCode: " + i2);
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_night);
                break;
            case 13:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_snow);
                break;
            case 14:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_spotlight);
                break;
            case 15:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_sunset);
                break;
            case 16:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_portrait);
                break;
            case 17:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_multi_portrait);
                break;
            case 18:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_microspur);
                break;
            case 19:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_backlight);
                break;
            case 20:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_purecolor);
                break;
            case 21:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_moire);
                break;
            case 22:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_flower);
                break;
            case 23:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_plant);
                break;
            case 24:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_birds);
                break;
            case 25:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_architecture);
                break;
            case 26:
                this.f_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_video_hdr);
                break;
            default:
                this.f_renamed.a_renamed(-1);
                break;
        }
        return this.f_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void g_renamed(int i_renamed) {
        android.widget.RelativeLayout relativeLayout;
        if (this.v_renamed == null) {
            o_renamed();
        }
        if (i_renamed == -1) {
            i_renamed = 0;
        }
        if (i_renamed % 180 == 0) {
            i_renamed = 0;
        }
        if (!this.v_renamed.b_renamed() && this.v_renamed.a_renamed() != i_renamed && this.y_renamed.a_renamed() && (relativeLayout = this.d_renamed) != null) {
            relativeLayout.startAnimation(this.v_renamed);
        }
        this.v_renamed.a_renamed(i_renamed, true);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void h_renamed(int i_renamed) {
        this.q_renamed = i_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j_renamed(int i_renamed) {
        android.widget.RelativeLayout relativeLayout = this.d_renamed;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() != i_renamed) {
                this.d_renamed.setVisibility(i_renamed);
            }
            com.oplus.camera.ui.preview.a_renamed.AISceneUI_2 interfaceC0133a = this.g_renamed;
            if (interfaceC0133a != null) {
                if (i_renamed != 0) {
                    interfaceC0133a.b_renamed(0);
                } else {
                    interfaceC0133a.b_renamed(b_renamed());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q_renamed() {
        if (this.d_renamed == null || this.e_renamed == null) {
            return;
        }
        this.g_renamed.a_renamed();
        this.e_renamed.a_renamed(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.ui.preview.u_renamed.2
            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.preview.u_renamed.this.j_renamed(0);
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public int f_renamed() {
        return this.o_renamed;
    }

    private void r_renamed() {
        if (this.d_renamed == null || this.e_renamed == null) {
            return;
        }
        this.g_renamed.b_renamed();
        if (this.d_renamed.getVisibility() == 0) {
            this.e_renamed.b_renamed(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.ui.preview.u_renamed.3
                @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.preview.u_renamed.this.j_renamed(8);
                }

                @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    com.oplus.camera.ui.preview.u_renamed.this.j_renamed(8);
                }
            });
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public boolean i_renamed() {
        android.widget.RelativeLayout relativeLayout = this.d_renamed;
        return relativeLayout != null && relativeLayout.isShown();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public boolean j_renamed() {
        com.oplus.camera.ui.preview.AISceneView aISceneView = this.e_renamed;
        return aISceneView != null && aISceneView.b_renamed();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public android.widget.RelativeLayout g_renamed() {
        return this.d_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void a_renamed(android.view.MotionEvent motionEvent) {
        if (1 == motionEvent.getAction()) {
            this.z_renamed.removeMessages(1);
            if (this.o_renamed == 0) {
                h_renamed();
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed
    public void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed("PIAISceneUI", "reversAIScene");
        c_renamed(i_renamed, z_renamed);
        com.oplus.camera.ui.preview.a_renamed.AISceneUI_2 interfaceC0133a = this.g_renamed;
        if (interfaceC0133a == null || this.o_renamed != i_renamed) {
            return;
        }
        interfaceC0133a.a_renamed(i_renamed, z_renamed, false);
    }

    private void c_renamed(int i_renamed, boolean z_renamed) {
        int iA = a_renamed(i_renamed, this.f6820c.getInt("oplus.camera.ai_scene_enable_list", 67108863), z_renamed);
        com.oplus.camera.e_renamed.a_renamed("PIAISceneUI", "setAISceneEnableStatus, scene: " + i_renamed + ", enabled: " + z_renamed + ", status: " + java.lang.Integer.toBinaryString(iA));
        this.f6820c.edit().putInt("oplus.camera.ai_scene_enable_list", iA).apply();
    }

    /* compiled from: PIAISceneUI.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private int f7153a;

        private a_renamed() {
            this.f7153a = -1;
        }

        public void a_renamed(int i_renamed) {
            this.f7153a = i_renamed;
        }

        public int a_renamed() {
            return this.f7153a;
        }
    }
}
