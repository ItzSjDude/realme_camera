package com.oplus.camera.ui.menu.a_renamed;

/* compiled from: ModePickerView.java */
/* loaded from: classes2.dex */
public class e_renamed extends android.view.View implements com.oplus.camera.ui.inverse.a_renamed {
    private int A_renamed;
    private int B_renamed;
    private int C_renamed;
    private int D_renamed;
    private int E_renamed;
    private int F_renamed;
    private int G_renamed;
    private int H_renamed;
    private int I_renamed;
    private int J_renamed;
    private int K_renamed;
    private int L_renamed;
    private int M_renamed;
    private int N_renamed;
    private int O_renamed;
    private float P_renamed;
    private float Q_renamed;
    private float R_renamed;
    private float S_renamed;
    private float T_renamed;
    private com.a_renamed.a_renamed.f_renamed U_renamed;
    private java.lang.String[] V_renamed;
    private float[] W_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Object f6352a;
    private boolean aA_renamed;
    private boolean aB_renamed;
    private boolean aC_renamed;
    private boolean aD_renamed;
    private android.graphics.Paint aE_renamed;
    private android.view.GestureDetector aF_renamed;
    private com.oplus.camera.ui.menu.a_renamed.e_renamed.ModePickerView_2 aG_renamed;
    private com.oplus.camera.ui.menu.a_renamed.a_renamed aH_renamed;
    private float aI_renamed;
    private boolean aJ_renamed;
    private int aK_renamed;
    private boolean aL_renamed;
    private int aM_renamed;
    private float aN_renamed;
    private int aO_renamed;
    private com.oplus.camera.screen.b_renamed.a_renamed aP_renamed;
    private boolean aQ_renamed;
    private float[] aa_renamed;
    private android.content.Context ab_renamed;
    private com.oplus.camera.ui.menu.a_renamed.b_renamed ac_renamed;
    private int ad_renamed;
    private int ae_renamed;
    private int af_renamed;
    private float[] ag_renamed;
    private float[] ah_renamed;
    private boolean ai_renamed;
    private int aj_renamed;
    private int ak_renamed;
    private int al_renamed;
    private int am_renamed;
    private int an_renamed;
    private int ao_renamed;
    private int ap_renamed;
    private int aq_renamed;
    private int ar_renamed;
    private float as_renamed;
    private float at_renamed;
    private int au_renamed;
    private int av_renamed;
    private float aw_renamed;
    private float ax_renamed;
    private int ay_renamed;
    private boolean az_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Object f6353b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.Object f6354c;
    private final java.util.ArrayList<java.lang.String> d_renamed;
    private volatile int e_renamed;
    private volatile int f_renamed;
    private volatile boolean g_renamed;
    private com.oplus.camera.ui.CameraUIListener h_renamed;
    private android.animation.ValueAnimator i_renamed;
    private android.animation.ValueAnimator j_renamed;
    private android.animation.ValueAnimator k_renamed;
    private android.view.animation.PathInterpolator l_renamed;
    private android.view.animation.PathInterpolator m_renamed;
    private android.view.animation.PathInterpolator n_renamed;
    private float[] o_renamed;
    private android.text.TextPaint p_renamed;
    private android.text.TextPaint q_renamed;
    private android.text.TextPaint r_renamed;
    private java.lang.String[] s_renamed;
    private android.graphics.drawable.Drawable t_renamed;
    private float u_renamed;
    private float v_renamed;
    private float w_renamed;
    private float x_renamed;
    private float y_renamed;
    private float z_renamed;

    /* compiled from: ModePickerView.java */
    /* renamed from: com.oplus.camera.ui.menu.a_renamed.e_renamed$e_renamed, reason: collision with other inner class name */
    public interface ModePickerView_2 {
        boolean X_renamed();

        boolean Y_renamed();

        boolean Z_renamed();

        void ay_renamed();

        boolean az_renamed();

        void o_renamed(int i_renamed);

        boolean p_renamed(int i_renamed);
    }

    public e_renamed(android.content.Context context, com.oplus.camera.ui.CameraUIListener cameraUIListener) {
        super(context);
        this.f6352a = new java.lang.Object();
        this.f6353b = new java.lang.Object();
        this.f6354c = new java.lang.Object();
        this.d_renamed = new java.util.ArrayList<>();
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = true;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.m_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.n_renamed = new android.view.animation.PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = 0.0f;
        this.v_renamed = 0.0f;
        this.w_renamed = 0.0f;
        this.x_renamed = 0.0f;
        this.y_renamed = 0.0f;
        this.z_renamed = 0.0f;
        this.A_renamed = 0;
        this.B_renamed = 1;
        this.C_renamed = 0;
        this.D_renamed = 0;
        this.E_renamed = 0;
        this.F_renamed = 0;
        this.G_renamed = 0;
        this.H_renamed = 0;
        this.I_renamed = 0;
        this.J_renamed = -1;
        this.K_renamed = 0;
        this.L_renamed = 0;
        this.M_renamed = 0;
        this.N_renamed = 0;
        this.O_renamed = 0;
        this.P_renamed = 0.0f;
        this.Q_renamed = 1.0f;
        this.R_renamed = 0.0f;
        this.S_renamed = 0.0f;
        this.T_renamed = 0.0f;
        this.U_renamed = null;
        this.V_renamed = null;
        this.W_renamed = null;
        this.aa_renamed = null;
        this.ac_renamed = null;
        this.ad_renamed = 0;
        this.ae_renamed = 255;
        this.af_renamed = 255;
        this.ag_renamed = null;
        this.ah_renamed = null;
        this.ai_renamed = false;
        this.aj_renamed = 0;
        this.ak_renamed = 0;
        this.al_renamed = 0;
        this.am_renamed = 0;
        this.an_renamed = 0;
        this.ao_renamed = 0;
        this.ap_renamed = 0;
        this.aq_renamed = 0;
        this.ar_renamed = 0;
        this.as_renamed = 0.0f;
        this.at_renamed = 0.0f;
        this.au_renamed = 0;
        this.av_renamed = 0;
        this.aw_renamed = 0.0f;
        this.ax_renamed = 0.0f;
        this.ay_renamed = -1;
        this.az_renamed = false;
        this.aA_renamed = false;
        this.aB_renamed = true;
        this.aC_renamed = false;
        this.aD_renamed = true;
        this.aE_renamed = null;
        this.aF_renamed = null;
        this.aG_renamed = null;
        this.aH_renamed = null;
        this.aI_renamed = 0.0f;
        this.aJ_renamed = true;
        this.aK_renamed = 0;
        this.aL_renamed = false;
        this.aM_renamed = 255;
        this.aN_renamed = 0.0f;
        this.aO_renamed = 0;
        this.aP_renamed = null;
        this.aQ_renamed = false;
        this.ab_renamed = context;
        this.I_renamed = this.ab_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.headline_item_extra_touch_offset);
        this.h_renamed = cameraUIListener;
    }

    public void setListener(com.oplus.camera.ui.menu.a_renamed.e_renamed.ModePickerView_2 interfaceC0131e) {
        this.aG_renamed = interfaceC0131e;
    }

    public void a_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        this.B_renamed = i_renamed;
        int previewFrameWidth = getPreviewFrameWidth();
        int iT = com.oplus.camera.util.Util.T_renamed();
        this.ak_renamed = (int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.headline_item_gap);
        if (com.oplus.camera.util.Util.al_renamed()) {
            this.al_renamed = (int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.max_seven_mode_headline_item_gap);
            this.am_renamed = this.ak_renamed;
        }
        if (1 == this.aO_renamed) {
            previewFrameWidth = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_width);
            iT = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_text_height);
            this.ak_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_item_gap);
            this.an_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_item_gap_offset);
            this.M_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_headline_double_line_background_height);
            this.N_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_headline_double_line_text_height);
            this.ao_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_headline_text_max_width);
        }
        this.aj_renamed = this.ab_renamed.getColor(com.oplus.camera.R_renamed.color.inverse_text_color);
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.ab_renamed, this);
        this.t_renamed = this.ab_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.mode_edit);
        this.C_renamed = (int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.mode_edit_icon_size);
        this.D_renamed = this.ab_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_edit_icon_touch_size);
        this.K_renamed = (int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.head_line_background_height);
        this.F_renamed = (int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.mode_edit_icon_margin_right);
        this.E_renamed = (int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.mode_edit_icon_margin_top);
        this.ay_renamed = iT;
        this.J_renamed = previewFrameWidth;
        float f2 = iT;
        this.as_renamed = f2 / 2.0f;
        float f3 = this.as_renamed;
        this.aw_renamed = previewFrameWidth / f3;
        this.ax_renamed = f2 / f3;
        this.at_renamed = (float) (this.aw_renamed / java.lang.Math.sin(java.lang.Math.toRadians(22.5d)));
        this.au_renamed = (int) (this.at_renamed * java.lang.Math.toRadians(126.0d) * this.as_renamed);
        this.av_renamed = this.ay_renamed;
        if (1 == this.aO_renamed) {
            this.aF_renamed = new android.view.GestureDetector(getContext(), new com.oplus.camera.ui.menu.a_renamed.e_renamed.d_renamed());
        } else {
            this.aF_renamed = new android.view.GestureDetector(getContext(), new com.oplus.camera.ui.menu.a_renamed.e_renamed.a_renamed());
        }
        this.G_renamed = (int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.mode_edit_icon_red_dot_xoffset);
        this.H_renamed = (int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.mode_edit_icon_red_dot_yoffset);
        this.p_renamed = new android.text.TextPaint();
        this.q_renamed = new android.text.TextPaint();
        this.r_renamed = new android.text.TextPaint();
        this.aE_renamed = new android.graphics.Paint();
        a_renamed();
        q_renamed();
        this.aK_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.headline_change_move_distance);
    }

    public void setHeadlineBackground(com.oplus.camera.ui.menu.a_renamed.b_renamed bVar) {
        this.ac_renamed = bVar;
        com.oplus.camera.ui.menu.a_renamed.b_renamed bVar2 = this.ac_renamed;
        if (bVar2 != null) {
            bVar2.a_renamed(this);
        }
    }

    private void p_renamed() {
        if (this.aH_renamed != null) {
            return;
        }
        this.aH_renamed = new com.oplus.camera.ui.menu.a_renamed.a_renamed(this.ac_renamed, this, this.q_renamed);
        this.aH_renamed.a_renamed(this.aO_renamed);
        this.aH_renamed.a_renamed(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.a_renamed.e_renamed.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.ac_renamed.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aD_renamed = false;
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.setArrangeAlpha(0);
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.setRotateMode(2);
                com.oplus.camera.ui.menu.a_renamed.e_renamed eVar = com.oplus.camera.ui.menu.a_renamed.e_renamed.this;
                eVar.a_renamed(eVar.q_renamed);
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.invalidate();
                java.lang.Runnable runnableA = com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aH_renamed.a_renamed();
                if (runnableA != null) {
                    runnableA.run();
                }
            }
        });
        this.aH_renamed.b_renamed(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.a_renamed.e_renamed.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aD_renamed = true;
                if (com.oplus.camera.util.Util.t_renamed() && com.oplus.camera.ui.menu.a_renamed.e_renamed.this.h_renamed != null && com.oplus.camera.ui.menu.a_renamed.e_renamed.this.h_renamed.bW_renamed()) {
                    return;
                }
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.ac_renamed.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.h_renamed == null || !(com.oplus.camera.ui.menu.a_renamed.e_renamed.this.h_renamed.bh_renamed() || com.oplus.camera.ui.menu.a_renamed.e_renamed.this.h_renamed.be_renamed())) {
                    com.oplus.camera.ui.menu.a_renamed.e_renamed.this.setRotateMode(2);
                    com.oplus.camera.ui.menu.a_renamed.e_renamed eVar = com.oplus.camera.ui.menu.a_renamed.e_renamed.this;
                    eVar.a_renamed(eVar.q_renamed);
                    com.oplus.camera.ui.menu.a_renamed.e_renamed.this.invalidate();
                    com.oplus.camera.ui.menu.a_renamed.e_renamed.this.setClipToOutline(true);
                    com.oplus.camera.ui.menu.a_renamed.e_renamed.this.ac_renamed.setVisibility(0);
                }
            }
        });
    }

    public void a_renamed() throws android.content.res.Resources.NotFoundException {
        this.aE_renamed.setAntiAlias(true);
        this.aE_renamed.setColor(this.ab_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.camera_red_dot_hint_color, null));
    }

    private void q_renamed() throws android.content.res.Resources.NotFoundException {
        this.q_renamed.reset();
        if (!this.ai_renamed) {
            int color = getResources().getColor(com.oplus.camera.R_renamed.color.num_seekbar_thumb_text_shadow_color, null);
            if (this.aL_renamed) {
                color = android.graphics.Color.argb(java.lang.Math.round(this.Q_renamed * android.graphics.Color.alpha(color)), android.graphics.Color.red(color), android.graphics.Color.green(color), android.graphics.Color.blue(color));
            }
            this.q_renamed.setShadowLayer(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_text_shadow_radius), 0.0f, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_text_shadow_y), color);
        }
        this.q_renamed.setAntiAlias(true);
        this.q_renamed.setTextSize(com.oplus.camera.k_renamed.m_renamed());
        this.q_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        this.q_renamed.setColor(this.ai_renamed ? this.aj_renamed : -1);
        this.q_renamed.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.p_renamed.setAntiAlias(true);
        this.p_renamed.setTextSize(com.oplus.camera.k_renamed.m_renamed());
        this.p_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        this.p_renamed.setColor(this.ai_renamed ? this.aj_renamed : -1);
        this.p_renamed.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.p_renamed.setShadowLayer(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_text_shadow_radius), 0.0f, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_text_shadow_y), getResources().getColor(com.oplus.camera.R_renamed.color.num_seekbar_thumb_text_shadow_color, null));
    }

    private void r_renamed() {
        this.r_renamed.setAntiAlias(true);
        this.r_renamed.setTextSize(com.oplus.camera.k_renamed.m_renamed());
        this.r_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        this.r_renamed.setColor(this.ai_renamed ? this.ab_renamed.getColor(com.oplus.camera.R_renamed.color.camera_white) : this.ab_renamed.getColor(com.oplus.camera.R_renamed.color.background_color));
        this.r_renamed.setTextAlign(android.graphics.Paint.Align.CENTER);
    }

    private void a_renamed(java.lang.String[] strArr) {
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "updateTextArray, textArray: " + java.util.Arrays.toString(strArr));
        if (strArr == null || strArr.length <= 0) {
            throw new java.lang.IllegalArgumentException("the text array can't_renamed be_renamed null or it's_renamed length can't_renamed be_renamed 0");
        }
        synchronized (this.f6353b) {
            this.V_renamed = strArr;
        }
        java.lang.String[] strArr2 = this.V_renamed;
        this.o_renamed = new float[strArr2.length + 1];
        this.W_renamed = new float[strArr2.length + 1];
        this.aa_renamed = new float[strArr2.length + 1];
        a_renamed(this.q_renamed);
    }

    public void a_renamed(java.util.List<java.lang.Integer> list, int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "updateText, textIdList: " + list + ", currentIndex: " + i_renamed);
        if (list == null || list.size() <= 0 || i_renamed < 0 || i_renamed >= list.size()) {
            com.oplus.camera.e_renamed.f_renamed("ModePickerView", "updateText, the parameter is_renamed illegal");
            return;
        }
        synchronized (this.f6354c) {
            this.s_renamed = a_renamed(list);
        }
        synchronized (this.f6352a) {
            this.O_renamed = this.s_renamed.length - 1;
            setCurrentIndex(i_renamed);
        }
        a_renamed(this.s_renamed);
        b_renamed(i_renamed, true);
    }

    public void a_renamed(java.util.List<java.lang.Integer> list, boolean z_renamed, java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "updateTextAndIndex, textIdList: " + list);
        if (list == null || list.size() <= 0) {
            com.oplus.camera.e_renamed.f_renamed("ModePickerView", "updateText, the parameter is_renamed illegal");
            return;
        }
        synchronized (this.f6354c) {
            this.s_renamed = a_renamed(list);
        }
        synchronized (this.f6352a) {
            this.O_renamed = this.s_renamed.length - 1;
            this.A_renamed = a_renamed(this.s_renamed, z_renamed, str);
        }
    }

    private int a_renamed(java.lang.String[] strArr, boolean z_renamed, java.lang.String str) {
        com.oplus.camera.e_renamed.b_renamed("ModePickerView", "updateTextAndIndex, textArray: " + java.util.Arrays.toString(strArr) + ", curMode: " + str);
        if (strArr == null || strArr.length <= 0) {
            throw new java.lang.IllegalArgumentException("the text array can't_renamed be_renamed null or it's_renamed length can't_renamed be_renamed 0");
        }
        synchronized (this.f6353b) {
            java.lang.String strB = b_renamed(strArr, z_renamed, str);
            java.lang.String str2 = this.V_renamed[this.f_renamed];
            this.V_renamed = strArr;
            this.o_renamed = new float[this.V_renamed.length + 1];
            this.W_renamed = new float[this.V_renamed.length + 1];
            this.aa_renamed = new float[this.V_renamed.length + 1];
            a_renamed(strB, str2);
        }
        return this.f_renamed;
    }

    public void a_renamed(java.lang.String str, java.lang.String str2) {
        int i_renamed = this.ap_renamed;
        int i2 = this.f_renamed;
        int i3 = 0;
        while (true) {
            java.lang.String[] strArr = this.V_renamed;
            if (i3 >= strArr.length) {
                i3 = 0;
                break;
            } else if (str.equals(strArr[i3])) {
                break;
            } else {
                i3++;
            }
        }
        int i4 = 0;
        while (true) {
            java.lang.String[] strArr2 = this.V_renamed;
            if (i4 >= strArr2.length) {
                i4 = 0;
                break;
            } else if (str2.equals(strArr2[i4])) {
                break;
            } else {
                i4++;
            }
        }
        if (i_renamed != i3) {
            this.ap_renamed = i3;
        }
        b_renamed(i4, false);
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "updateIndex, mLastIndex: " + this.ap_renamed + ", mCurrentIndex: " + this.A_renamed + ", " + str + ", " + str2 + ", " + i4);
    }

    private java.lang.String b_renamed(java.lang.String[] strArr, boolean z_renamed, java.lang.String str) {
        if (!z_renamed) {
            return this.V_renamed[this.ap_renamed];
        }
        for (java.lang.String str2 : strArr) {
            if (str.equals(str2)) {
                return str;
            }
        }
        return this.ab_renamed.getString(com.oplus.camera.R_renamed.string.camera_mode_photo);
    }

    public int getLastIndex() {
        return this.ap_renamed;
    }

    public boolean b_renamed() {
        synchronized (this.f6354c) {
            if (this.s_renamed == null) {
                return false;
            }
            if (this.A_renamed >= 0 && this.A_renamed < this.s_renamed.length) {
                return this.s_renamed[this.A_renamed].equals(getContext().getString(com.oplus.camera.R_renamed.string.camera_mode_more));
            }
            return false;
        }
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "slideNextItem");
        com.oplus.camera.ui.menu.a_renamed.e_renamed.ModePickerView_2 interfaceC0131e = this.aG_renamed;
        if (interfaceC0131e == null || !interfaceC0131e.p_renamed(this.A_renamed)) {
            com.oplus.camera.e_renamed.f_renamed("ModePickerView", "slideNextItem, can not slide");
            return;
        }
        synchronized (this.f6352a) {
            if (this.A_renamed + 1 > this.O_renamed) {
                setCurrentIndex(this.O_renamed);
                com.oplus.camera.e_renamed.f_renamed("ModePickerView", "slideNextItem, current index is_renamed max, can not slide");
            } else {
                setCurrentIndex(this.A_renamed + 1);
                b_renamed(this.A_renamed);
            }
        }
    }

    public void d_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "slidePreviousItem");
        com.oplus.camera.ui.menu.a_renamed.e_renamed.ModePickerView_2 interfaceC0131e = this.aG_renamed;
        if (interfaceC0131e == null || !interfaceC0131e.p_renamed(this.A_renamed)) {
            com.oplus.camera.e_renamed.f_renamed("ModePickerView", "slidePreviousItem, can not slide");
            return;
        }
        synchronized (this.f6352a) {
            if (this.A_renamed - 1 < 0) {
                setCurrentIndex(0);
                com.oplus.camera.e_renamed.f_renamed("ModePickerView", "slidePreviousItem, current index is_renamed min, can not slide");
            } else {
                setCurrentIndex(this.A_renamed - 1);
                b_renamed(this.A_renamed);
            }
        }
    }

    public boolean b_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "setCurrentIndexWithAnim, index: " + i_renamed + ", mCurrentAnimIndex: " + this.f_renamed);
        setRotateMode(0);
        synchronized (this.f6353b) {
            if (this.V_renamed != null && this.V_renamed.length > 0 && i_renamed >= 0 && i_renamed < this.V_renamed.length) {
                if (this.o_renamed != null && this.o_renamed.length > 0 && i_renamed + 1 < this.o_renamed.length) {
                    this.ap_renamed = this.f_renamed;
                    this.f_renamed = i_renamed;
                    this.g_renamed = true;
                    return a_renamed(this.ap_renamed, this.f_renamed);
                }
                com.oplus.camera.e_renamed.f_renamed("ModePickerView", "setCurrentIndexWithAnim, mTextItemTransit is_renamed illegal");
                return false;
            }
            com.oplus.camera.e_renamed.f_renamed("ModePickerView", "setCurrentIndexWithAnim, mTextArray: " + this.V_renamed + ", index: " + i_renamed + ", mCurrentAnimIndex: " + this.f_renamed);
            return false;
        }
    }

    private boolean a_renamed(int i_renamed, int i2) {
        float[] fArr = this.o_renamed;
        return a_renamed((fArr[i_renamed] + fArr[i_renamed + 1]) / 2.0f, (fArr[i2] + fArr[i2 + 1]) / 2.0f, i2);
    }

    private boolean a_renamed(float f2, float f3, int i_renamed) {
        if (this.U_renamed == null) {
            t_renamed();
        }
        this.U_renamed.a_renamed(f2).b_renamed(f3);
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "startAnimation, startTransit: " + f2 + ", endTransit: " + f3);
        if (this.aG_renamed == null) {
            return true;
        }
        c_renamed(i_renamed);
        synchronized (this.f6352a) {
            setCurrentIndex(i_renamed);
            this.aG_renamed.o_renamed(i_renamed);
        }
        return true;
    }

    public void a_renamed(boolean z_renamed) {
        synchronized (this.f6352a) {
            if (this.s_renamed[this.A_renamed].equals(getContext().getString(com.oplus.camera.R_renamed.string.camera_mode_more))) {
                setCurrentIndex(getLastIndex());
            }
        }
        setVisibility(z_renamed ? 0 : 4);
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "backToLastHeadlineIndex, last index: " + this.A_renamed);
        b_renamed(this.A_renamed, false);
        setHeadlineAngle(this.ad_renamed);
        invalidate();
    }

    public void setTextArray(java.util.List<java.lang.Integer> list) {
        this.V_renamed = a_renamed(list);
        java.lang.String[] strArr = this.V_renamed;
        this.o_renamed = new float[strArr.length + 1];
        this.W_renamed = new float[strArr.length + 1];
        this.aa_renamed = new float[strArr.length + 1];
        post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.a_renamed.e_renamed.4
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.menu.a_renamed.e_renamed eVar = com.oplus.camera.ui.menu.a_renamed.e_renamed.this;
                eVar.a_renamed(eVar.q_renamed);
            }
        });
    }

    private java.lang.String[] a_renamed(java.util.List<java.lang.Integer> list) {
        java.lang.String[] strArr = new java.lang.String[list.size()];
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            strArr[i_renamed] = getContext().getString(list.get(i_renamed).intValue());
        }
        return strArr;
    }

    public void c_renamed(int i_renamed) {
        synchronized (this.f6353b) {
            if (this.V_renamed != null && this.V_renamed.length > 0 && i_renamed >= 0 && i_renamed < this.V_renamed.length) {
                if (i_renamed != this.A_renamed) {
                    this.ap_renamed = this.f_renamed;
                    this.f_renamed = i_renamed;
                }
                com.oplus.camera.e_renamed.a_renamed("ModePickerView", "updateCurrentIndex, mLastIndex: " + this.ap_renamed + ", mCurrentAnimIndex: " + this.f_renamed);
                return;
            }
            com.oplus.camera.e_renamed.e_renamed("ModePickerView", "updateCurrentIndex, mTextArray: " + this.V_renamed + ", index: " + i_renamed + ", mCurrentIndex: " + this.f_renamed);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        float[] fArr;
        float[] fArr2;
        int length;
        com.oplus.camera.ui.menu.a_renamed.e_renamed.ModePickerView_2 interfaceC0131e = this.aG_renamed;
        int length2 = 0;
        if (interfaceC0131e == null) {
            return false;
        }
        if (interfaceC0131e.X_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("ModePickerView", "onTouchEvent, return when isTimerSnapShotRunning");
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.w_renamed = motionEvent.getX();
            this.z_renamed = motionEvent.getY();
            this.x_renamed = this.w_renamed;
            this.y_renamed = this.z_renamed;
            this.u_renamed = 0.0f;
            this.az_renamed = false;
            this.aB_renamed = this.aG_renamed.p_renamed(this.A_renamed);
        } else if (action != 1) {
            if (action != 2) {
                if (action == 3 && d_renamed(1)) {
                    return b_renamed(false);
                }
            } else {
                if (!this.aB_renamed) {
                    return false;
                }
                float x_renamed = motionEvent.getX() - this.w_renamed;
                if (1 == this.aO_renamed) {
                    x_renamed = motionEvent.getY() - this.z_renamed;
                }
                if (a_renamed(motionEvent)) {
                    com.oplus.camera.e_renamed.a_renamed("ModePickerView", "onTouchEvent, return when envet out of_renamed view");
                    return true;
                }
                if (10.0f > java.lang.Math.abs(x_renamed)) {
                    com.oplus.camera.e_renamed.a_renamed("ModePickerView", "onTouchEvent, return when distance too small");
                    return true;
                }
                float width = (x_renamed / getWidth()) * 75.0f;
                if (1 == this.aO_renamed) {
                    width = (x_renamed / com.oplus.camera.util.Util.getScreenHeight()) * 75.0f;
                }
                float f2 = this.R_renamed - x_renamed;
                if (b_renamed(x_renamed)) {
                    this.u_renamed = width;
                } else if (d_renamed(f2) || c_renamed(f2)) {
                    this.u_renamed = this.v_renamed + width;
                } else {
                    this.v_renamed = this.u_renamed;
                    this.u_renamed = x_renamed;
                }
                if (s_renamed()) {
                    com.oplus.camera.e_renamed.a_renamed("ModePickerView", "onTouchEvent, spring animation is_renamed running, set at_renamed rest");
                    this.aQ_renamed = true;
                    this.U_renamed.j_renamed();
                }
                int i_renamed = this.A_renamed;
                if (1 == this.aO_renamed) {
                    float f3 = this.R_renamed - this.u_renamed;
                    int i2 = i_renamed;
                    int i3 = 0;
                    while (true) {
                        fArr2 = this.o_renamed;
                        if (i3 >= fArr2.length - 1) {
                            break;
                        }
                        if (f3 > fArr2[i3] && f3 < fArr2[i3 + 1]) {
                            com.oplus.camera.e_renamed.a_renamed("ModePickerView", "onTouchEvent, new index: " + i3 + ", currentIndex: " + this.A_renamed);
                            i2 = i3;
                        }
                        i3++;
                    }
                    if (f3 < 0.0f) {
                        length = 0;
                    } else {
                        java.lang.String[] strArr = this.V_renamed;
                        length = f3 > fArr2[strArr.length - 1] ? strArr.length - 1 : i2;
                    }
                    int i4 = length - this.A_renamed;
                    if (motionEvent.getEventTime() - motionEvent.getDownTime() >= 200.0f) {
                        setFinalTransit(f3);
                    } else if (i4 != 0) {
                        length = this.A_renamed + (i4 < 0 ? -1 : 1);
                    }
                    setRotateMode(1);
                    this.aD_renamed = false;
                    length2 = length;
                } else {
                    setFinalTransit(this.R_renamed - this.u_renamed);
                    setRotateMode(1);
                    this.aD_renamed = false;
                    int i5 = this.A_renamed;
                    int i6 = 0;
                    while (true) {
                        fArr = this.o_renamed;
                        if (i6 >= fArr.length - 1) {
                            break;
                        }
                        float f4 = this.S_renamed;
                        if (f4 > fArr[i6] && f4 < fArr[i6 + 1]) {
                            com.oplus.camera.e_renamed.a_renamed("ModePickerView", "onTouchEvent, new index: " + i6 + ", currentIndex: " + this.A_renamed);
                            i5 = i6;
                        }
                        i6++;
                    }
                    float f5 = this.S_renamed;
                    if (f5 >= 0.0f) {
                        length2 = f5 > fArr[this.V_renamed.length - 1] ? r1.length - 1 : i5;
                    }
                }
                this.e_renamed = length2;
                this.g_renamed = true;
                invalidate();
            }
        } else if (d_renamed(1)) {
            return b_renamed(true);
        }
        android.view.GestureDetector gestureDetector = this.aF_renamed;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        return true;
    }

    private boolean a_renamed(android.view.MotionEvent motionEvent) {
        float y_renamed = motionEvent.getY();
        float x_renamed = motionEvent.getX();
        boolean z_renamed = java.lang.Math.abs(x_renamed - this.x_renamed) < 100.0f;
        int i_renamed = this.aO_renamed;
        if (1 == i_renamed) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            boolean z2 = java.lang.Math.abs(y2 - this.y_renamed) < 100.0f;
            this.y_renamed = y2;
            return (x2 < 0.0f || x2 > ((float) getWidth())) && !z2;
        }
        if (4 == i_renamed) {
            this.x_renamed = x_renamed;
            return (y_renamed < 0.0f || y_renamed > ((float) getHeight())) && !z_renamed;
        }
        this.x_renamed = x_renamed;
        return (y_renamed > ((float) getBottom()) || y_renamed < ((float) getTop())) && !z_renamed;
    }

    private boolean b_renamed(float f2) {
        if (this.A_renamed != 0 || 0.0f >= f2) {
            return this.A_renamed == this.V_renamed.length - 1 && 0.0f > f2;
        }
        return true;
    }

    private boolean b_renamed(boolean z_renamed) {
        setRotateMode(0);
        this.aD_renamed = true;
        float f2 = this.R_renamed - this.u_renamed;
        if (1 == this.aO_renamed) {
            f2 = this.S_renamed;
        }
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "performMoveAction, computeMoveAnimation: " + z_renamed);
        if (!z_renamed || !this.aG_renamed.p_renamed(this.A_renamed)) {
            e_renamed(f2);
            return true;
        }
        this.S_renamed = f2;
        float f3 = (this.o_renamed[this.e_renamed] + this.o_renamed[this.e_renamed + 1]) / 2.0f;
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "performMoveAction, mScrollCurrentIndex: " + this.e_renamed + ", mCurrentIndex: " + this.A_renamed + ", startTransit: " + f2 + ", endTransit: " + f3);
        if (this.e_renamed != this.A_renamed) {
            a_renamed(f2, f3, this.e_renamed);
        } else {
            e_renamed(f2);
        }
        return true;
    }

    private boolean c_renamed(float f2) {
        if (d_renamed(1)) {
            int i_renamed = this.e_renamed;
            java.lang.String[] strArr = this.V_renamed;
            if (i_renamed == strArr.length - 1) {
                float[] fArr = this.o_renamed;
                if (f2 > (fArr[strArr.length - 1] + fArr[strArr.length]) / 2.0f) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean d_renamed(float f2) {
        return d_renamed(1) && this.e_renamed == 0 && f2 < this.o_renamed[1] / 2.0f;
    }

    private void e_renamed(float f2) {
        int i_renamed = this.A_renamed;
        this.e_renamed = i_renamed;
        a_renamed(f2, this.R_renamed, i_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s_renamed() {
        com.a_renamed.a_renamed.f_renamed fVar = this.U_renamed;
        return (fVar == null || fVar.i_renamed()) ? false : true;
    }

    private void setFinalTransit(float f2) {
        this.S_renamed = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.text.TextPaint textPaint) {
        if (1 == this.aO_renamed) {
            c_renamed(textPaint);
        } else {
            b_renamed(textPaint);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:18:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b_renamed(android.text.TextPaint r5) {
        /*
            r4 = this;
            float[] r0 = r4.o_renamed
            r1 = 0
            r2 = 0
            r0[r1] = r2
            boolean r0 = com.oplus.camera.util.Util.al_renamed()
            if (r0 == 0) goto L19
            java.lang.String[] r0 = r4.V_renamed
            int r0 = r0.length
            r3 = 5
            if (r0 <= r3) goto L15
            int r0 = r4.al_renamed
            goto L17
        L15:
            int r0 = r4.am_renamed
        L17:
            r4.ak_renamed = r0
        L19:
            java.lang.String[] r0 = r4.V_renamed
            int r3 = r0.length
            if (r1 >= r3) goto L30
            r0 = r0[r1]
            float r0 = r5.measureText(r0)
            float r2 = r2 + r0
            int r0 = r4.ak_renamed
            float r0 = (float) r0
            float r2 = r2 + r0
            float[] r0 = r4.o_renamed
            int r1 = r1 + 1
            r0[r1] = r2
            goto L19
        L30:
            int r5 = r4.A_renamed
            if (r5 < 0) goto L4e
            float[] r0 = r4.o_renamed
            int r1 = r0.length
            int r1 = r1 + (-2)
            if (r5 <= r1) goto L3c
            goto L4e
        L3c:
            r1 = r0[r5]
            int r5 = r5 + 1
            r5 = r0[r5]
            float r1 = r1 + r5
            r5 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r5
            r4.R_renamed = r1
            float r5 = r4.R_renamed
            r4.setFinalTransit(r5)
            goto L55
        L4e:
            java.lang.String r5 = "ModePickerView"
            java.lang.String r0 = "setHeadlineAngle, ROTATE_MODE_NO_ANIMATION , the parameter is_renamed illegal"
            com.oplus.camera.e_renamed.f_renamed(r5, r0)
        L55:
            r4.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.a_renamed.e_renamed.b_renamed(android.text.TextPaint):void");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:22:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c_renamed(android.text.TextPaint r6) {
        /*
            r5 = this;
            android.content.res.Resources r6 = r5.getResources()
            r0 = 2131168417(0x7f070ca1, float:1.7951135E38)
            int r6 = r6.getDimensionPixelSize(r0)
            float r6 = (float) r6
            r0 = 0
            float r0 = r0 - r6
            float[] r6 = r5.o_renamed
            r1 = 0
            r6[r1] = r0
            r6 = r1
        L14:
            java.lang.String[] r2 = r5.V_renamed
            int r3 = r2.length
            if (r6 >= r3) goto L3a
            int r3 = r5.av_renamed
            float r3 = (float) r3
            float r3 = r3 + r0
            int r4 = r5.ak_renamed
            float r4 = (float) r4
            float r3 = r3 + r4
            r2 = r2[r6]
            boolean r2 = r5.a_renamed(r2)
            if (r2 == 0) goto L32
            int r2 = r5.ak_renamed
            float r2 = (float) r2
            float r0 = r0 + r2
            int r2 = r5.N_renamed
            float r2 = (float) r2
            float r0 = r0 + r2
            goto L33
        L32:
            r0 = r3
        L33:
            float[] r2 = r5.o_renamed
            int r6 = r6 + 1
            r2[r6] = r0
            goto L14
        L3a:
            int r6 = r2.length
            r0 = 1073741824(0x40000000, float:2.0)
            r2 = 2
            if (r6 <= r2) goto L61
            float[] r6 = r5.o_renamed
            r3 = r6[r2]
            r4 = 3
            r6 = r6[r4]
            float r3 = r3 + r6
            int r6 = r5.ak_renamed
            float r6 = (float) r6
            float r3 = r3 - r6
            float r3 = r3 / r0
            int r6 = r5.getHeight()
            float r6 = (float) r6
            float r6 = r6 / r0
            float r3 = r3 - r6
        L54:
            float[] r6 = r5.o_renamed
            int r4 = r6.length
            if (r1 >= r4) goto L61
            r4 = r6[r1]
            float r4 = r4 - r3
            r6[r1] = r4
            int r1 = r1 + 1
            goto L54
        L61:
            int r6 = r5.A_renamed
            java.lang.String r1 = "ModePickerView"
            if (r6 < 0) goto L7d
            float[] r3 = r5.o_renamed
            int r4 = r3.length
            int r4 = r4 - r2
            if (r6 <= r4) goto L6e
            goto L7d
        L6e:
            r2 = r3[r6]
            int r6 = r6 + 1
            r6 = r3[r6]
            float r2 = r2 + r6
            float r2 = r2 / r0
            r5.R_renamed = r2
            float r6 = r5.R_renamed
            r5.S_renamed = r6
            goto L82
        L7d:
            java.lang.String r6 = "setHeadlineAngle, ROTATE_MODE_NO_ANIMATION , the parameter is_renamed illegal"
            com.oplus.camera.e_renamed.f_renamed(r1, r6)
        L82:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "initVerticalMeasure, mTextArray: "
            r6.append(r0)
            java.lang.String[] r0 = r5.V_renamed
            java.lang.String r0 = java.util.Arrays.toString(r0)
            r6.append(r0)
            java.lang.String r0 = ", mTextItemTransit: "
            r6.append(r0)
            float[] r0 = r5.o_renamed
            java.lang.String r0 = java.util.Arrays.toString(r0)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            com.oplus.camera.e_renamed.b_renamed(r1, r6)
            r5.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.a_renamed.e_renamed.c_renamed(android.text.TextPaint):void");
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) throws android.content.res.Resources.NotFoundException {
        super.onDraw(canvas);
        if (1 == this.aO_renamed) {
            a_renamed(canvas);
        } else {
            b_renamed(canvas);
        }
    }

    private void b_renamed(android.graphics.Canvas canvas) throws android.content.res.Resources.NotFoundException {
        int i_renamed;
        float f2;
        int i2;
        android.graphics.Paint.FontMetrics fontMetrics;
        android.graphics.Paint.FontMetrics fontMetrics2;
        float f3;
        canvas.drawColor(0);
        q_renamed();
        r_renamed();
        a_renamed();
        android.graphics.Paint.FontMetrics fontMetrics3 = this.q_renamed.getFontMetrics();
        android.graphics.Paint.FontMetrics fontMetrics4 = this.r_renamed.getFontMetrics();
        float f4 = ((this.av_renamed / 2.0f) - (fontMetrics3.bottom / 2.0f)) - (fontMetrics3.top / 2.0f);
        float f5 = ((this.av_renamed / 2.0f) - (fontMetrics4.bottom / 2.0f)) - (fontMetrics4.top / 2.0f);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.baseline_arrange_vertical_offset);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.mode_picker_view_offset_a);
        int dimensionPixelOffset3 = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.mode_picker_view_offset_b);
        float f6 = dimensionPixelOffset;
        float f7 = dimensionPixelOffset2;
        float f8 = (f4 - f6) + f7;
        float f9 = (f5 - f6) + f7 + this.aN_renamed;
        float f10 = 0.0f;
        this.o_renamed[0] = 0.0f;
        int i3 = 3;
        if (this.ad_renamed == 3) {
            this.aH_renamed.a_renamed(f4, f5, fontMetrics3, this.ai_renamed, this.aj_renamed);
        }
        canvas.translate((getWidth() / 2.0f) - this.S_renamed, 0.0f);
        int i4 = 0;
        float f11 = 0.0f;
        float fMeasureText = 0.0f;
        while (true) {
            java.lang.String[] strArr = this.V_renamed;
            if (i4 >= strArr.length) {
                break;
            }
            fMeasureText = this.q_renamed.measureText(strArr[i4]);
            if (com.oplus.camera.util.Util.al_renamed()) {
                f_renamed(i4);
            }
            if (i4 == this.V_renamed.length - 1) {
                this.aq_renamed = (int) fMeasureText;
            }
            float f12 = f11 + fMeasureText + this.ak_renamed;
            float f13 = (f11 + f12) / 2.0f;
            if (i4 == this.A_renamed - 2) {
                f13 += f7;
            }
            if (i4 == this.A_renamed - 1) {
                f13 -= dimensionPixelOffset3;
            }
            if (i4 == this.A_renamed + 1) {
                f13 += dimensionPixelOffset3;
            }
            if (i4 == this.A_renamed + 2) {
                f13 -= f7;
            }
            float f14 = f13;
            this.r_renamed.setAlpha(this.aL_renamed ? this.aM_renamed : this.ae_renamed);
            this.q_renamed.setAlpha(this.aL_renamed ? (int) (this.Q_renamed * 255.0f) : this.ae_renamed);
            this.W_renamed[i4] = f14;
            int i5 = this.ad_renamed;
            if (i5 == 1) {
                i_renamed = i3;
                f2 = f7;
                i2 = dimensionPixelOffset3;
                fontMetrics = fontMetrics4;
                a_renamed(canvas, f14, f8, f9, i4, this.e_renamed);
            } else {
                i_renamed = i3;
                f2 = f7;
                i2 = dimensionPixelOffset3;
                fontMetrics = fontMetrics4;
                if (i5 == i_renamed) {
                    this.aH_renamed.a_renamed(i4, canvas, this.r_renamed, this.V_renamed, this.ae_renamed, fMeasureText);
                } else {
                    a_renamed(canvas, f14, f8, f9, i4, this.f_renamed);
                }
            }
            if (d_renamed(this.V_renamed[i4])) {
                float fA_renamed = f14 + (fMeasureText / 2.0f) + com.oplus.camera.util.Util.a_renamed(3.0f);
                if (i4 != this.A_renamed) {
                    f3 = fontMetrics3.top;
                    fontMetrics2 = fontMetrics;
                } else {
                    fontMetrics2 = fontMetrics;
                    f3 = fontMetrics2.top;
                }
                a_renamed(canvas, fA_renamed, f4 + f3);
            } else {
                fontMetrics2 = fontMetrics;
            }
            if (!d_renamed(1)) {
                this.o_renamed[i4 + 1] = f12;
            }
            i4++;
            fontMetrics4 = fontMetrics2;
            f11 = f12;
            f10 = f11;
            i3 = i_renamed;
            f7 = f2;
            dimensionPixelOffset3 = i2;
        }
        if (1 == this.B_renamed && this.aD_renamed) {
            a_renamed(canvas, f10, fMeasureText, com.oplus.camera.util.Util.T_renamed(), f4 + fontMetrics3.top);
        }
        setHeadlineAngle(this.ad_renamed);
        h_renamed();
    }

    private void a_renamed(android.graphics.Canvas canvas, float f2, float f3, float f4, int i_renamed, int i2) {
        if (i_renamed != i2) {
            canvas.drawText(this.V_renamed[i_renamed], f2, f3 + this.aI_renamed, this.q_renamed);
        } else {
            canvas.drawText(this.V_renamed[i_renamed], f2, f4 + this.aI_renamed, this.r_renamed);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:18:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f_renamed(int r13) {
        /*
            r12 = this;
            java.lang.String[] r0 = r12.V_renamed
            int r0 = r0.length
            r1 = 5
            if (r0 <= r1) goto L86
            float r0 = r12.S_renamed
            int r1 = r12.getWidth()
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            float r3 = r0 - r1
            int r0 = r12.getWidth()
            float r0 = (float) r0
            float r5 = r0 + r3
            android.text.TextPaint r0 = r12.q_renamed
            java.lang.String[] r1 = r12.V_renamed
            r1 = r1[r13]
            float r0 = r0.measureText(r1)
            int r1 = r12.ak_renamed
            float r1 = (float) r1
            float r0 = r0 + r1
            r1 = 2131167119(0x7f07078f, float:1.7948503E38)
            float r1 = com.oplus.camera.util.Util.h_renamed(r1)
            boolean r2 = r12.ai_renamed
            if (r2 == 0) goto L35
            int r2 = r12.aj_renamed
            goto L36
        L35:
            r2 = -1
        L36:
            r4 = 16777215(0xffffff, float:2.3509886E-38)
            r4 = r4 & r2
            float[] r6 = r12.o_renamed
            r7 = r6[r13]
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            r8 = 1
            r9 = 0
            r10 = 2
            if (r7 <= 0) goto L61
            r6 = r6[r13]
            float r6 = r6 + r0
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 >= 0) goto L61
            android.graphics.LinearGradient r13 = new android.graphics.LinearGradient
            r0 = 0
            float r5 = r3 + r1
            r6 = 0
            int[] r7 = new int[r10]
            r7[r9] = r4
            r7[r8] = r2
            r8 = 0
            android.graphics.Shader$TileMode r9 = android.graphics.Shader.TileMode.CLAMP
            r2 = r13
            r4 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            goto L87
        L61:
            float[] r3 = r12.o_renamed
            r6 = r3[r13]
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 <= 0) goto L86
            r13 = r3[r13]
            float r13 = r13 + r0
            int r13 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r13 >= 0) goto L86
            android.graphics.LinearGradient r13 = new android.graphics.LinearGradient
            r6 = 0
            float r7 = r5 - r1
            r0 = 0
            int[] r1 = new int[r10]
            r1[r9] = r4
            r1[r8] = r2
            r10 = 0
            android.graphics.Shader$TileMode r11 = android.graphics.Shader.TileMode.CLAMP
            r4 = r13
            r8 = r0
            r9 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            goto L87
        L86:
            r13 = 0
        L87:
            android.text.TextPaint r12 = r12.q_renamed
            r12.setShader(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.a_renamed.e_renamed.f_renamed(int):void");
    }

    public float getVerticalOffset() {
        return this.T_renamed;
    }

    protected void a_renamed(android.graphics.Canvas canvas) throws android.content.res.Resources.NotFoundException {
        android.graphics.Paint.FontMetrics fontMetrics;
        int i_renamed;
        int i2;
        int i3;
        float f2;
        android.graphics.Paint.FontMetrics fontMetrics2;
        char c2;
        float f3;
        int i4 = this.ad_renamed;
        canvas.drawColor(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_mode_picker_view_offset_a);
        q_renamed();
        r_renamed();
        a_renamed();
        this.T_renamed = ((com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.vertical_headline_height) / 2.0f) + (com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.vertical_headline_item_gap) / 2.0f)) - this.S_renamed;
        canvas.translate(0.0f, this.T_renamed);
        if (i4 != 3) {
            int[] iArrU = u_renamed();
            float f4 = this.T_renamed;
            android.graphics.LinearGradient linearGradient = new android.graphics.LinearGradient(0.0f, -f4, 0.0f, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_height) + (-f4), iArrU, new float[]{0.0f, 0.0833f, 0.4f, 0.4028f, 0.5972f, 0.6f, 0.9167f, 1.0f}, android.graphics.Shader.TileMode.CLAMP);
            float f5 = this.T_renamed;
            android.graphics.LinearGradient linearGradient2 = new android.graphics.LinearGradient(0.0f, -f5, 0.0f, (-f5) + getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_height), iArrU, new float[]{0.0f, 0.0833f, 0.345f, 0.3472f, 0.6528f, 0.655f, 0.9167f, 1.0f}, android.graphics.Shader.TileMode.CLAMP);
            if (this.ac_renamed.getBGHeight() < (this.M_renamed + getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_headline_bg_height)) / 2) {
                this.q_renamed.setShader(linearGradient);
                this.r_renamed.setShader(linearGradient);
            } else {
                this.q_renamed.setShader(linearGradient2);
                this.r_renamed.setShader(linearGradient2);
            }
        } else {
            this.q_renamed.setShader(null);
            this.r_renamed.setShader(null);
        }
        android.graphics.Paint.FontMetrics fontMetrics3 = this.q_renamed.getFontMetrics();
        android.graphics.Paint.FontMetrics fontMetrics4 = this.r_renamed.getFontMetrics();
        float f6 = ((this.av_renamed / 2.0f) - (fontMetrics3.bottom / 2.0f)) - (fontMetrics3.top / 2.0f);
        float f7 = ((this.av_renamed / 2.0f) - (fontMetrics4.bottom / 2.0f)) - (fontMetrics4.top / 2.0f);
        float f8 = this.T_renamed;
        float f9 = this.o_renamed[0];
        if (i4 == 3) {
            this.aH_renamed.a_renamed(f6, f7, fontMetrics3, this.ai_renamed, this.aj_renamed);
        }
        int i5 = this.aC_renamed ? this.e_renamed : this.A_renamed;
        float width = getWidth() / 2.0f;
        int i6 = 0;
        while (true) {
            java.lang.String[] strArr = this.V_renamed;
            if (i6 >= strArr.length) {
                break;
            }
            float fMeasureText = this.q_renamed.measureText(strArr[i6]);
            boolean z_renamed = fMeasureText > ((float) this.ao_renamed);
            float f10 = this.ay_renamed;
            int i7 = this.ak_renamed;
            float dimensionPixelSize = i7 + f10;
            float f11 = f6 + f9;
            float f12 = f7 + f9;
            if (z_renamed) {
                dimensionPixelSize = i7 + getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_double_line_text_height);
            }
            if (i6 == i5 - 1) {
                float f13 = dimensionPixelOffset;
                f11 -= f13;
                f12 -= f13;
            }
            if (i6 == i5 + 1) {
                float f14 = dimensionPixelOffset;
                f11 += f14;
                f12 += f14;
            }
            float f15 = f11;
            float f16 = f12;
            float f17 = f9 + dimensionPixelSize;
            this.r_renamed.setAlpha(this.ae_renamed);
            this.q_renamed.setAlpha(this.ae_renamed);
            this.aa_renamed[i6] = f15;
            if (i4 == 1) {
                if (i6 != this.e_renamed) {
                    if (z_renamed) {
                        java.lang.String[] strArrB = b_renamed(this.V_renamed[i6]);
                        float f18 = ((int) (f10 - (this.N_renamed / 2))) / 2;
                        canvas.drawText(strArrB[0], width, f15 - f18, this.q_renamed);
                        canvas.drawText(strArrB[1], width, ((this.N_renamed / 2) + f15) - f18, this.q_renamed);
                    } else {
                        canvas.drawText(this.V_renamed[i6], width, f15, this.q_renamed);
                    }
                } else if (z_renamed) {
                    java.lang.String[] strArrB2 = b_renamed(this.V_renamed[i6]);
                    float f19 = ((int) (f10 - (this.N_renamed / 2))) / 2;
                    canvas.drawText(strArrB2[0], width, f16 - f19, this.r_renamed);
                    canvas.drawText(strArrB2[1], width, ((this.N_renamed / 2) + f15) - f19, this.r_renamed);
                } else {
                    canvas.drawText(this.V_renamed[i6], width, f16, this.r_renamed);
                }
                fontMetrics = fontMetrics4;
                i_renamed = i4;
                i2 = dimensionPixelOffset;
                i3 = i6;
                f2 = width;
            } else if (i4 == 3) {
                i2 = dimensionPixelOffset;
                i3 = i6;
                i_renamed = i4;
                f2 = width;
                fontMetrics = fontMetrics4;
                this.aH_renamed.a_renamed(i6, canvas, this.r_renamed, this.V_renamed, this.ae_renamed, fMeasureText, width, getWidth(), this.T_renamed);
            } else {
                fontMetrics = fontMetrics4;
                i_renamed = i4;
                i2 = dimensionPixelOffset;
                i3 = i6;
                f2 = width;
                if (i3 != this.f_renamed) {
                    if (z_renamed) {
                        java.lang.String[] strArrB3 = b_renamed(this.V_renamed[i3]);
                        float f20 = ((int) (f10 - (this.N_renamed / 2))) / 2;
                        canvas.drawText(strArrB3[0], f2, f15 - f20, this.q_renamed);
                        canvas.drawText(strArrB3[1], f2, ((this.N_renamed / 2) + f15) - f20, this.q_renamed);
                    } else {
                        canvas.drawText(this.V_renamed[i3], f2, f15, this.q_renamed);
                    }
                } else if (z_renamed) {
                    java.lang.String[] strArrB4 = b_renamed(this.V_renamed[i3]);
                    float f21 = ((int) (f10 - (this.N_renamed / 2))) / 2;
                    canvas.drawText(strArrB4[0], f2, f16 - f21, this.r_renamed);
                    canvas.drawText(strArrB4[1], f2, (f16 + (this.N_renamed / 2)) - f21, this.r_renamed);
                } else {
                    canvas.drawText(this.V_renamed[i3], f2, f16, this.r_renamed);
                }
            }
            if (d_renamed(this.V_renamed[i3])) {
                this.aE_renamed.setShader(e_renamed());
                c2 = 0;
                float fA_renamed = f2 + (fMeasureText / 2.0f) + com.oplus.camera.util.Util.a_renamed(3.0f);
                if (i3 != this.A_renamed) {
                    f3 = fontMetrics3.top;
                    fontMetrics2 = fontMetrics;
                } else {
                    fontMetrics2 = fontMetrics;
                    f3 = fontMetrics2.top;
                }
                a_renamed(canvas, fA_renamed, f15 + f3);
            } else {
                fontMetrics2 = fontMetrics;
                c2 = 0;
            }
            i6 = i3 + 1;
            this.o_renamed[i6] = f17;
            fontMetrics4 = fontMetrics2;
            width = f2;
            f9 = f17;
            dimensionPixelOffset = i2;
            i4 = i_renamed;
        }
        int i8 = i4;
        setHeadlineAngle(this.ad_renamed);
        if (i8 != 3) {
            h_renamed();
        }
    }

    public boolean a_renamed(java.lang.String str) {
        android.text.TextPaint textPaint = this.q_renamed;
        return textPaint != null && textPaint.measureText(str) > ((float) this.ao_renamed);
    }

    public java.lang.String[] b_renamed(java.lang.String str) {
        if (str.contains(" ") && java.lang.Float.compare(this.q_renamed.measureText(str.substring(0, str.indexOf(" "))), this.ao_renamed) < 0) {
            return str.split("\\s_renamed");
        }
        int i_renamed = 1;
        while (i_renamed < str.length() && java.lang.Float.compare(this.q_renamed.measureText(str.substring(0, i_renamed)), this.ao_renamed) < 0) {
            i_renamed++;
        }
        int i2 = i_renamed - 1;
        java.lang.String[] strArr = new java.lang.String[2];
        strArr[0] = str.substring(0, i2);
        if (java.lang.Float.compare(this.q_renamed.measureText(str.substring(i2)), this.ao_renamed) < 0) {
            strArr[1] = str.substring(i2);
        } else {
            int i3 = i2 + 1;
            while (i3 < str.length()) {
                if (java.lang.Float.compare(this.q_renamed.measureText(str.substring(i2, i3) + "..."), this.ao_renamed) >= 0) {
                    break;
                }
                i3++;
            }
            strArr[1] = str.substring(i2, i3) + "...";
        }
        return strArr;
    }

    public android.graphics.LinearGradient e_renamed() {
        int[] iArr = {15348807, getResources().getColor(com.oplus.camera.R_renamed.color.camera_red_dot_hint_color, null), getResources().getColor(com.oplus.camera.R_renamed.color.camera_red_dot_hint_color, null), 15348807};
        float f2 = this.T_renamed;
        return new android.graphics.LinearGradient(0.0f, -f2, 0.0f, (-f2) + getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_height), iArr, new float[]{0.0f, 0.1216f, 0.8784f, 1.0f}, android.graphics.Shader.TileMode.CLAMP);
    }

    public boolean f_renamed() {
        return this.aA_renamed;
    }

    public boolean g_renamed() {
        return this.az_renamed;
    }

    public void setMultiFinger(boolean z_renamed) {
        this.az_renamed = z_renamed;
    }

    public int getLastTextWidth() {
        return this.aq_renamed;
    }

    public boolean d_renamed(int i_renamed) {
        return i_renamed == this.ad_renamed;
    }

    private void a_renamed(android.graphics.Canvas canvas, float f2, float f3) {
        this.aE_renamed.setAlpha(this.aL_renamed ? (int) (this.Q_renamed * 255.0f) : this.af_renamed);
        canvas.drawCircle(f2, f3 + this.aI_renamed, com.oplus.camera.util.Util.a_renamed(3.0f), this.aE_renamed);
    }

    public void a_renamed(int... iArr) {
        int i_renamed = 0;
        if (iArr != null && iArr.length > 0) {
            int length = iArr.length;
            int i2 = 0;
            while (i_renamed < length) {
                java.lang.String string = this.ab_renamed.getString(iArr[i_renamed]);
                if (d_renamed(string)) {
                    this.d_renamed.remove(string);
                    this.g_renamed = true;
                    i2 = 1;
                }
                i_renamed++;
            }
            i_renamed = i2;
        } else if (!this.d_renamed.isEmpty()) {
            this.d_renamed.clear();
            this.g_renamed = true;
            i_renamed = 1;
        }
        if (i_renamed != 0) {
            invalidate();
        }
    }

    public void b_renamed(int... iArr) {
        int i_renamed = 0;
        if (iArr != null && iArr.length > 0) {
            int length = iArr.length;
            int i2 = 0;
            while (i_renamed < length) {
                java.lang.String string = this.ab_renamed.getString(iArr[i_renamed]);
                if (!d_renamed(string)) {
                    this.d_renamed.add(string);
                    i2 = 1;
                }
                i_renamed++;
            }
            i_renamed = i2;
        }
        if (i_renamed != 0) {
            invalidate();
        }
    }

    private boolean d_renamed(java.lang.String str) {
        return !this.d_renamed.isEmpty() && this.d_renamed.contains(str);
    }

    private void a_renamed(android.graphics.Canvas canvas, float f2, float f3, int i_renamed, float f4) {
        float previewFrameWidth = f2 + ((getPreviewFrameWidth() - f3) / 2.0f);
        int i2 = this.C_renamed;
        int i3 = (i_renamed - i2) / 2;
        int i4 = (i_renamed / 2) + (i2 / 2);
        if (((int) ((((int) ((previewFrameWidth - i2) - this.F_renamed)) + (getPreviewFrameWidth() / 2.0f)) - this.S_renamed)) > getPreviewFrameWidth()) {
            return;
        }
        int previewFrameWidth2 = getPreviewFrameWidth() / 2;
        int i5 = this.C_renamed;
        int i6 = (int) ((previewFrameWidth2 - (this.F_renamed + i5)) + this.S_renamed);
        this.t_renamed.setBounds(i6, i3, i5 + i6, i4);
        this.t_renamed.setAlpha(this.aL_renamed ? (int) (this.Q_renamed * 255.0f) : this.af_renamed);
        this.t_renamed.draw(canvas);
        this.ag_renamed = new float[2];
        float[] fArr = this.ag_renamed;
        int i7 = this.D_renamed;
        int i8 = this.C_renamed;
        fArr[0] = i6 - ((i7 - i8) / 2);
        fArr[1] = i6 + i8 + ((i7 - i8) / 2);
        this.ah_renamed = new float[2];
        float[] fArr2 = this.ah_renamed;
        fArr2[0] = this.E_renamed - ((i7 - i8) / 2);
        fArr2[1] = fArr2[0] + i7;
        if (d_renamed(this.ab_renamed.getString(com.oplus.camera.R_renamed.string.camera_mode_arrange))) {
            a_renamed(canvas, ((i6 + (this.C_renamed / 2)) - this.G_renamed) + (f3 / 2.0f) + com.oplus.camera.util.Util.a_renamed(3.0f), f4 - this.H_renamed);
        }
    }

    private void setHeadlineAngle(int i_renamed) {
        if (i_renamed == 0) {
            int i2 = this.ap_renamed;
            if (i2 < 0 || i2 > this.o_renamed.length - 2 || this.f_renamed < 0 || this.f_renamed > this.o_renamed.length - 2) {
                com.oplus.camera.e_renamed.f_renamed("ModePickerView", "setHeadlineAngle, ROTATE_MODE_SLIDE, the parameter is_renamed illegal");
                return;
            }
            if (this.ap_renamed != this.f_renamed) {
                float f2 = this.R_renamed;
                float[] fArr = this.o_renamed;
                int i3 = this.ap_renamed;
                float fAbs = java.lang.Math.abs(f2 - ((fArr[i3] + fArr[i3 + 1]) / 2.0f));
                float f3 = (this.o_renamed[this.f_renamed] + this.o_renamed[this.f_renamed + 1]) / 2.0f;
                float[] fArr2 = this.o_renamed;
                int i4 = this.ap_renamed;
                this.P_renamed = fAbs / java.lang.Math.abs(f3 - ((fArr2[i4] + fArr2[i4 + 1]) / 2.0f));
                if (this.P_renamed > 1.0f) {
                    this.P_renamed = 1.0f;
                }
            } else {
                this.P_renamed = 1.0f;
            }
            setFinalTransit(this.R_renamed);
            com.oplus.camera.e_renamed.a_renamed("ModePickerView", "setHeadlineAngle, ROTATE_MODE_SLIDE, angle:" + this.R_renamed);
            return;
        }
        if (i_renamed != 1) {
            if (i_renamed != 2) {
                return;
            }
            if (this.f_renamed >= 0) {
                int i5 = this.f_renamed;
                float[] fArr3 = this.o_renamed;
                if (i5 <= fArr3.length - 2) {
                    this.R_renamed = (fArr3[this.f_renamed] + this.o_renamed[this.f_renamed + 1]) / 2.0f;
                    setFinalTransit(this.R_renamed);
                    this.P_renamed = 1.0f;
                    com.oplus.camera.e_renamed.a_renamed("ModePickerView", "setHeadlineAngle, ROTATE_MODE_NO_ANIMATION, angle:" + this.R_renamed);
                    return;
                }
            }
            com.oplus.camera.e_renamed.f_renamed("ModePickerView", "setHeadlineAngle, ROTATE_MODE_NO_ANIMATION , the parameter is_renamed illegal");
            return;
        }
        int i6 = this.A_renamed;
        if (i6 < 0 || i6 > this.o_renamed.length - 2 || this.e_renamed < 0 || this.e_renamed > this.o_renamed.length - 2) {
            com.oplus.camera.e_renamed.f_renamed("ModePickerView", "setHeadlineAngle, ROTATE_MODE_FOLLOW_FINGER , the parameter is_renamed illegal");
            return;
        }
        int i7 = this.e_renamed;
        int i8 = this.A_renamed;
        if (i7 != i8) {
            float f4 = this.S_renamed;
            float[] fArr4 = this.o_renamed;
            float fAbs2 = java.lang.Math.abs(f4 - ((fArr4[i8] + fArr4[i8 + 1]) / 2.0f));
            float f5 = (this.o_renamed[this.e_renamed] + this.o_renamed[this.e_renamed + 1]) / 2.0f;
            float[] fArr5 = this.o_renamed;
            int i9 = this.A_renamed;
            this.P_renamed = fAbs2 / java.lang.Math.abs(f5 - ((fArr5[i9] + fArr5[i9 + 1]) / 2.0f));
            if (this.P_renamed > 1.0f) {
                this.P_renamed = 1.0f;
            }
        } else {
            this.P_renamed = 1.0f;
        }
        if (1 != this.aO_renamed) {
            setFinalTransit(this.R_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "setHeadlineAngle, ROTATE_MODE_FOLLOW_FINGER, angle:" + this.R_renamed);
    }

    public void c_renamed(java.lang.String str) {
        int i_renamed = 0;
        while (true) {
            java.lang.String[] strArr = this.s_renamed;
            if (i_renamed >= strArr.length) {
                i_renamed = -1;
                break;
            } else if (strArr[i_renamed].equals(str)) {
                break;
            } else {
                i_renamed++;
            }
        }
        synchronized (this.f6352a) {
            setCurrentIndex(i_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "setIndex, index: " + i_renamed);
        setVisibility(0);
        b_renamed(this.A_renamed, false);
    }

    public void h_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "setHeadlineDrawer, mAnimationRatio: " + this.P_renamed);
        float f2 = f_renamed(this.n_renamed.getInterpolation(this.P_renamed));
        float fB_renamed = ((((float) this.K_renamed) / 2.0f) / this.as_renamed) / (this.ax_renamed / 2.0f);
        float f3 = this.aL_renamed ? 1.0f : this.Q_renamed;
        boolean z_renamed = this.aJ_renamed || !this.aL_renamed;
        if (1 == this.aO_renamed) {
            fB_renamed = b_renamed(getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_headline_bg_height) / this.ay_renamed, this.M_renamed / this.ay_renamed);
        }
        if (z_renamed) {
            a_renamed((int) f2, (int) (this.ay_renamed * fB_renamed), f3);
        }
    }

    private float b_renamed(float f2, float f3) {
        int i_renamed = this.ap_renamed;
        int i2 = this.A_renamed;
        if (this.ad_renamed == 1) {
            i2 = this.e_renamed;
            i_renamed = i2;
        }
        float f4 = f3 - f2;
        if (!a_renamed(this.V_renamed[i_renamed]) && a_renamed(this.V_renamed[i2])) {
            return f2 + (f4 * this.n_renamed.getInterpolation(this.P_renamed));
        }
        if (!a_renamed(this.V_renamed[i_renamed]) || a_renamed(this.V_renamed[i2])) {
            return (a_renamed(this.V_renamed[i_renamed]) && a_renamed(this.V_renamed[i2])) ? f3 : f2;
        }
        return f3 - (f4 * this.n_renamed.getInterpolation(this.P_renamed));
    }

    public void a_renamed(int i_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (this.aO_renamed == i_renamed) {
            return;
        }
        this.aO_renamed = i_renamed;
        com.oplus.camera.ui.menu.a_renamed.b_renamed bVar = this.ac_renamed;
        if (bVar != null) {
            bVar.setScreenLayoutMode(i_renamed);
        }
        com.oplus.camera.ui.menu.a_renamed.a_renamed aVar = this.aH_renamed;
        if (aVar != null) {
            aVar.a_renamed(this.aO_renamed);
        }
        com.oplus.camera.e_renamed.b_renamed("ModePickerView", "setLayoutMode, " + i_renamed);
        if (s_renamed()) {
            this.aQ_renamed = true;
            this.U_renamed.j_renamed();
        }
        a_renamed(this.B_renamed);
        b_renamed(this.A_renamed, z_renamed);
        a_renamed(this.q_renamed);
    }

    public void a_renamed(com.oplus.camera.screen.b_renamed.a_renamed aVar, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        this.aP_renamed = aVar;
        a_renamed(aVar.j_renamed(), z_renamed);
    }

    public void a_renamed(int i_renamed, int i2, float f2) {
        com.oplus.camera.ui.menu.a_renamed.b_renamed bVar = this.ac_renamed;
        if (bVar != null) {
            bVar.a_renamed(i_renamed, i2);
            this.ac_renamed.setAlpha(f2);
            this.ac_renamed.setOffsetY(this.aI_renamed);
        }
    }

    private float f_renamed(float f2) {
        float fG_renamed;
        float fG2;
        float fMeasureText;
        if (this.aO_renamed == 1) {
            if (this.ad_renamed == 1) {
                fG_renamed = this.q_renamed.measureText(this.V_renamed[this.A_renamed]);
                fMeasureText = this.q_renamed.measureText(this.V_renamed[this.e_renamed]);
            } else {
                fG_renamed = this.q_renamed.measureText(this.V_renamed[this.ap_renamed]);
                fMeasureText = this.q_renamed.measureText(this.V_renamed[this.A_renamed]);
            }
            fG2 = getWidth() - (getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_bg_paddingX) * 2);
            if (fG_renamed > fG2) {
                fG_renamed = fG2;
            }
            if (fMeasureText <= fG2) {
                fG2 = fMeasureText;
            }
        } else if (this.ad_renamed == 1) {
            fG_renamed = g_renamed(this.A_renamed);
            fG2 = g_renamed(this.e_renamed);
        } else {
            fG_renamed = g_renamed(this.ap_renamed);
            fG2 = g_renamed(this.A_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "getCurrentBackgroundLocation, startLocation: " + fG_renamed + ", endLocation: " + fG2);
        return fG_renamed + ((fG2 - fG_renamed) * f2);
    }

    public boolean i_renamed() {
        com.oplus.camera.ui.menu.a_renamed.a_renamed aVar = this.aH_renamed;
        return aVar != null && aVar.d_renamed();
    }

    public void j_renamed() {
        com.oplus.camera.ui.menu.a_renamed.a_renamed aVar = this.aH_renamed;
        if (aVar != null) {
            aVar.e_renamed();
        }
    }

    private float g_renamed(int i_renamed) {
        float[] fArr = this.o_renamed;
        double d2 = (fArr[i_renamed + 1] - fArr[i_renamed]) / 2.0d;
        float f2 = this.ak_renamed / 2;
        float f3 = this.as_renamed;
        return (float) (((d2 - (f2 / f3)) + (this.L_renamed / f3)) * 2.0d);
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.ai_renamed = z_renamed;
        invalidate();
    }

    public boolean k_renamed() {
        android.animation.ValueAnimator valueAnimator = this.i_renamed;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    public void setRotateMode(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "setRotateMode, rotateMode: " + i_renamed);
        this.ad_renamed = i_renamed;
    }

    public boolean b_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "setCurrentIndex, from mCurrentAnimIndex: " + this.f_renamed + " to target index: " + i_renamed + ", updateLastIndex: " + z_renamed);
        synchronized (this.f6353b) {
            if (this.V_renamed != null && this.V_renamed.length > 0 && i_renamed >= 0 && i_renamed < this.V_renamed.length) {
                setRotateMode(2);
                if (z_renamed) {
                    this.ap_renamed = this.f_renamed;
                }
                this.f_renamed = i_renamed;
                this.g_renamed = true;
                invalidate();
                return true;
            }
            com.oplus.camera.e_renamed.f_renamed("ModePickerView", "setCurrentIndex, mTextArray: " + this.V_renamed + ", index: " + i_renamed + ", mCurrentAnimIndex: " + this.f_renamed);
            return false;
        }
    }

    public int a_renamed(float f2, float f3) {
        synchronized (this.f6353b) {
            if (this.o_renamed != null && this.o_renamed.length > 0) {
                float fAbs = java.lang.Math.abs(f2);
                float f4 = (this.o_renamed[this.f_renamed] + this.o_renamed[this.f_renamed + 1]) / 2.0f;
                float f5 = f2 >= 0.0f ? f4 + fAbs : f4 - fAbs;
                if (this.ag_renamed != null && this.ah_renamed != null && java.lang.Float.compare(f5, this.ag_renamed[0]) >= 0 && java.lang.Float.compare(f5, this.ag_renamed[1]) < 0 && java.lang.Float.compare(f3, this.ah_renamed[0]) >= 0 && java.lang.Float.compare(f3, this.ah_renamed[1]) < 0) {
                    return -2;
                }
                int i_renamed = 0;
                while (true) {
                    if (i_renamed >= this.o_renamed.length - 1) {
                        i_renamed = -1;
                        break;
                    }
                    float fMeasureText = this.q_renamed.measureText(this.V_renamed[i_renamed]) / 2.0f;
                    float f6 = (this.W_renamed[i_renamed] - fMeasureText) - this.I_renamed;
                    float f7 = this.W_renamed[i_renamed] + fMeasureText + this.I_renamed;
                    if (java.lang.Float.compare(f5, f6) >= 0 && java.lang.Float.compare(f5, f7) < 0) {
                        break;
                    }
                    i_renamed++;
                }
                if (this.V_renamed != null && this.V_renamed.length > 0 && i_renamed >= 0 && i_renamed < this.V_renamed.length && this.f_renamed != i_renamed) {
                    this.ap_renamed = this.f_renamed;
                    this.f_renamed = i_renamed;
                    setRotateMode(0);
                    this.g_renamed = true;
                    float f8 = (this.o_renamed[this.ap_renamed] + this.o_renamed[this.ap_renamed + 1]) / 2.0f;
                    float f9 = (this.o_renamed[this.f_renamed] + this.o_renamed[this.f_renamed + 1]) / 2.0f;
                    if (this.U_renamed == null) {
                        t_renamed();
                    }
                    this.U_renamed.a_renamed(f8).b_renamed(f9);
                    com.oplus.camera.e_renamed.a_renamed("ModePickerView", "computeIndexOnTap, mCurrentAnimIndex: " + this.f_renamed);
                    return this.f_renamed;
                }
                com.oplus.camera.e_renamed.f_renamed("ModePickerView", "computeIndexOnTap, mTextArray: " + this.V_renamed + ", targetIndex: " + i_renamed + ", mCurrentAnimIndex: " + this.f_renamed);
                return -1;
            }
            com.oplus.camera.e_renamed.f_renamed("ModePickerView", "computeIndexOnTap, mTextItemTransit is_renamed illegal");
            return -1;
        }
    }

    public int a_renamed(float f2) {
        synchronized (this.f6353b) {
            if (this.o_renamed != null && this.o_renamed.length > 0) {
                float fAbs = java.lang.Math.abs(f2);
                float f3 = (this.o_renamed[this.f_renamed] + this.o_renamed[this.f_renamed + 1]) / 2.0f;
                float f4 = f2 >= 0.0f ? f3 + fAbs : f3 - fAbs;
                if (this.ag_renamed != null && java.lang.Float.compare(f4, this.ag_renamed[0]) >= 0 && java.lang.Float.compare(f4, this.ag_renamed[1]) < 0) {
                    return -2;
                }
                int i_renamed = 0;
                while (true) {
                    if (i_renamed >= this.o_renamed.length - 1) {
                        i_renamed = -1;
                        break;
                    }
                    if (java.lang.Float.compare(f4, this.o_renamed[i_renamed]) >= 0 && java.lang.Float.compare(f4, this.o_renamed[i_renamed + 1]) < 0) {
                        break;
                    }
                    i_renamed++;
                }
                if (this.V_renamed != null && this.V_renamed.length > 0 && i_renamed >= 0 && i_renamed < this.V_renamed.length && this.f_renamed != i_renamed) {
                    this.ap_renamed = this.f_renamed;
                    this.f_renamed = i_renamed;
                    setRotateMode(0);
                    this.g_renamed = true;
                    float f5 = (this.o_renamed[this.ap_renamed] + this.o_renamed[this.ap_renamed + 1]) / 2.0f;
                    float f6 = (this.o_renamed[this.f_renamed] + this.o_renamed[this.f_renamed + 1]) / 2.0f;
                    if (this.U_renamed == null) {
                        t_renamed();
                    }
                    this.U_renamed.a_renamed(f5).b_renamed(f6);
                    com.oplus.camera.e_renamed.a_renamed("ModePickerView", "computeVerticalIndexOnTap,  mCurrentAnimIndex: " + this.f_renamed + " , startAngle: " + f5 + ", endAngle: " + f6);
                    return this.f_renamed;
                }
                com.oplus.camera.e_renamed.f_renamed("ModePickerView", "computeVerticalIndexOnTap, mTextArray: " + this.V_renamed + ", targetIndex: " + i_renamed + ", mCurrentAnimIndex: " + this.f_renamed);
                return -1;
            }
            com.oplus.camera.e_renamed.f_renamed("ModePickerView", "computeVerticalIndexOnTap, mTextItemTransit is_renamed illegal");
            return -1;
        }
    }

    public void setArrangeAlpha(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "setArrangeAlpha, alpha: " + i_renamed);
        synchronized (this.f6353b) {
            this.ae_renamed = i_renamed;
            this.g_renamed = true;
        }
    }

    public void setArrangeEditAlpha(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "setArrangeEditAlpha, alpha: " + i_renamed);
        synchronized (this.f6353b) {
            this.af_renamed = i_renamed;
        }
    }

    public boolean l_renamed() {
        com.oplus.camera.ui.menu.a_renamed.a_renamed aVar = this.aH_renamed;
        return aVar != null && aVar.b_renamed();
    }

    public void a_renamed(int i_renamed, java.lang.Runnable runnable) {
        p_renamed();
        this.aH_renamed.a_renamed(runnable);
        this.aH_renamed.a_renamed(i_renamed, this.V_renamed, this.W_renamed);
        setRotateMode(3);
        if (1 == this.aO_renamed) {
            setVisibility(4);
        }
    }

    public void a_renamed(int[] iArr, java.lang.Runnable runnable, int i_renamed) {
        p_renamed();
        this.aH_renamed.a_renamed(runnable);
        this.aH_renamed.a_renamed(iArr, this.V_renamed, this.aa_renamed, i_renamed);
        setRotateMode(3);
    }

    public void c_renamed(int[] iArr) {
        p_renamed();
        a_renamed(this.q_renamed);
        this.aH_renamed.a_renamed(iArr, this.V_renamed, this.S_renamed);
        setArrangeAlpha(255);
        setRotateMode(3);
        if (1 == this.aO_renamed) {
            setVisibility(0);
        }
    }

    public void a_renamed(int[] iArr, int i_renamed) {
        p_renamed();
        a_renamed(this.q_renamed);
        this.aH_renamed.a_renamed(iArr, this.V_renamed, this.S_renamed, i_renamed);
        setArrangeAlpha(255);
        setRotateMode(3);
        setVisibility(0);
    }

    public float getTextGap() {
        return this.ak_renamed;
    }

    public void m_renamed() {
        com.oplus.camera.ui.menu.a_renamed.a_renamed aVar = this.aH_renamed;
        if (aVar != null) {
            aVar.c_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentIndex(int i_renamed) {
        if (i_renamed < 0 || i_renamed > this.O_renamed) {
            com.oplus.camera.e_renamed.f_renamed("ModePickerView", "setCurrentIndex, index is_renamed wrong, index: " + i_renamed);
            return;
        }
        if (i_renamed != this.A_renamed) {
            this.A_renamed = i_renamed;
            if (this.ac_renamed != null) {
                post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.a_renamed.e_renamed.5
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.f6354c) {
                            com.oplus.camera.ui.menu.a_renamed.e_renamed.this.ac_renamed.setContentDescription(com.oplus.camera.ui.menu.a_renamed.e_renamed.this.s_renamed[com.oplus.camera.ui.menu.a_renamed.e_renamed.this.A_renamed]);
                        }
                    }
                });
            }
        }
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "setCurrentIndex, mCurrentIndex: " + this.A_renamed);
    }

    public void a_renamed(int i_renamed, long j_renamed, long j2, android.animation.TimeInterpolator timeInterpolator, boolean z_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        a_renamed(i_renamed, j_renamed, j2, timeInterpolator, null, z_renamed, i2);
    }

    public void a_renamed(int i_renamed, long j_renamed, long j2, android.animation.TimeInterpolator timeInterpolator, android.animation.Animator.AnimatorListener animatorListener, boolean z_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "setVisibilityWithAnimator, visibility: " + i_renamed + ", duration: " + j_renamed + ", startDelay: " + j2 + ", interpolator: " + timeInterpolator + ", listener: " + animatorListener + ", animType: " + i2);
        android.animation.ValueAnimator valueAnimator = this.i_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.i_renamed.cancel();
            this.i_renamed = null;
        }
        this.aJ_renamed = i_renamed == 0;
        if (i_renamed == 0) {
            a_renamed(j_renamed, j2, timeInterpolator, animatorListener, z_renamed, i2);
        } else {
            b_renamed(j_renamed, j2, timeInterpolator, animatorListener, z_renamed, i2);
        }
    }

    private void a_renamed(long j_renamed, long j2, android.animation.TimeInterpolator timeInterpolator, android.animation.Animator.AnimatorListener animatorListener, boolean z_renamed, int i_renamed) throws android.content.res.Resources.NotFoundException {
        long j3;
        android.animation.TimeInterpolator interpolator;
        android.animation.TimeInterpolator timeInterpolator2 = timeInterpolator == null ? this.m_renamed : timeInterpolator;
        long duration = j_renamed <= 0 ? 300L : j_renamed;
        if (z_renamed) {
            android.view.animation.Animation animationC = c_renamed(true);
            duration = animationC.getDuration();
            long startOffset = animationC.getStartOffset();
            interpolator = animationC.getInterpolator();
            j3 = startOffset;
        } else {
            j3 = j2;
            interpolator = timeInterpolator2;
        }
        this.i_renamed = a_renamed(0.0f, 1.0f, duration, j3, interpolator, new com.oplus.camera.ui.menu.a_renamed.e_renamed.c_renamed(animatorListener));
        this.aL_renamed = 3 == i_renamed;
        g_renamed(0.0f);
        com.oplus.camera.ui.menu.a_renamed.b_renamed bVar = this.ac_renamed;
        if (bVar != null) {
            bVar.setAlpha(0.0f);
        }
        setVisibility(0);
        setEnabled(false);
        this.i_renamed.start();
        if (2 != i_renamed) {
            if (3 == i_renamed) {
                d_renamed(true);
            }
        } else {
            this.k_renamed = android.animation.ValueAnimator.ofFloat(-this.aK_renamed, 0.0f);
            this.k_renamed.setDuration(300L);
            this.k_renamed.setStartDelay(100L);
            this.k_renamed.setInterpolator(this.l_renamed);
            this.k_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.a_renamed.e_renamed.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aI_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    com.oplus.camera.ui.menu.a_renamed.e_renamed.this.invalidate();
                }
            });
            this.k_renamed.start();
        }
    }

    private void b_renamed(long j_renamed, long j2, android.animation.TimeInterpolator timeInterpolator, android.animation.Animator.AnimatorListener animatorListener, boolean z_renamed, int i_renamed) throws android.content.res.Resources.NotFoundException {
        long j3;
        android.animation.TimeInterpolator interpolator;
        android.animation.TimeInterpolator timeInterpolator2 = timeInterpolator == null ? this.m_renamed : timeInterpolator;
        long duration = j_renamed <= 0 ? 250L : j_renamed;
        if (z_renamed) {
            android.view.animation.Animation animationC = c_renamed(false);
            duration = animationC.getDuration();
            long startOffset = animationC.getStartOffset();
            interpolator = animationC.getInterpolator();
            j3 = startOffset;
        } else {
            j3 = j2;
            interpolator = timeInterpolator2;
        }
        this.i_renamed = a_renamed(1.0f, 0.0f, duration, j3, interpolator, new com.oplus.camera.ui.menu.a_renamed.e_renamed.b_renamed(animatorListener));
        this.aL_renamed = 3 == i_renamed;
        g_renamed(1.0f);
        com.oplus.camera.ui.menu.a_renamed.b_renamed bVar = this.ac_renamed;
        if (bVar != null) {
            bVar.setAlpha(1.0f);
        }
        setEnabled(false);
        this.i_renamed.start();
        if (2 != i_renamed) {
            if (3 == i_renamed) {
                d_renamed(false);
            }
        } else {
            this.k_renamed = android.animation.ValueAnimator.ofFloat(0.0f, -this.aK_renamed);
            this.k_renamed.setDuration(300L);
            this.k_renamed.setInterpolator(this.l_renamed);
            this.k_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.a_renamed.e_renamed.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aI_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    com.oplus.camera.ui.menu.a_renamed.e_renamed.this.invalidate();
                }
            });
            this.k_renamed.start();
        }
    }

    private android.view.animation.Animation c_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        android.view.animation.Animation animationLoadAnimation;
        if (z_renamed) {
            animationLoadAnimation = android.view.animation.AnimationUtils.loadAnimation(getContext(), com.oplus.camera.R_renamed.anim.headline_vertical_in);
        } else {
            animationLoadAnimation = android.view.animation.AnimationUtils.loadAnimation(getContext(), com.oplus.camera.R_renamed.anim.headline_vertical_out);
        }
        startAnimation(animationLoadAnimation);
        this.ac_renamed.startAnimation(animationLoadAnimation);
        return animationLoadAnimation;
    }

    private android.animation.ValueAnimator a_renamed(float f2, float f3, long j_renamed, long j2, android.animation.TimeInterpolator timeInterpolator, android.animation.Animator.AnimatorListener animatorListener) {
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(f2, f3);
        valueAnimatorOfFloat.setDuration(j_renamed);
        valueAnimatorOfFloat.setStartDelay(j2);
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.a_renamed.e_renamed.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.g_renamed(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.invalidate();
            }
        });
        valueAnimatorOfFloat.addListener(animatorListener);
        return valueAnimatorOfFloat;
    }

    private void d_renamed(boolean z_renamed) {
        int i_renamed = z_renamed ? 0 : 255;
        int i2 = z_renamed ? 255 : 0;
        int i3 = z_renamed ? -this.aK_renamed : 0;
        int i4 = z_renamed ? 0 : -this.aK_renamed;
        int i5 = z_renamed ? 150 : 0;
        this.aM_renamed = i_renamed;
        float f2 = i3;
        this.aN_renamed = f2;
        invalidate();
        this.j_renamed = android.animation.ValueAnimator.ofInt(i_renamed, i2);
        long j_renamed = 400;
        this.j_renamed.setDuration(j_renamed);
        long j2 = i5;
        this.j_renamed.setStartDelay(j2);
        this.j_renamed.setInterpolator(this.m_renamed);
        this.j_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.a_renamed.e_renamed.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aM_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.invalidate();
            }
        });
        this.j_renamed.start();
        this.k_renamed = android.animation.ValueAnimator.ofFloat(f2, i4);
        this.k_renamed.setDuration(j_renamed);
        this.k_renamed.setStartDelay(j2);
        this.k_renamed.setInterpolator(this.l_renamed);
        this.k_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.a_renamed.e_renamed.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aN_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.invalidate();
            }
        });
        this.k_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.a_renamed.e_renamed.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.invalidate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aL_renamed = false;
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.invalidate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aL_renamed = false;
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.invalidate();
            }
        });
        this.k_renamed.start();
    }

    @Override // android.view.View
    public void setVisibility(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "setVisibility, visibility: " + i_renamed);
        super.setVisibility(i_renamed);
        com.oplus.camera.ui.menu.a_renamed.b_renamed bVar = this.ac_renamed;
        if (bVar != null) {
            bVar.a_renamed(i_renamed, this);
        }
    }

    private void h_renamed(int i_renamed) {
        g_renamed(1.0f);
        this.aI_renamed = 0.0f;
        this.aN_renamed = 0.0f;
        this.aM_renamed = 255;
        setVisibility(i_renamed);
    }

    public void e_renamed(int i_renamed) {
        h_renamed(i_renamed);
        this.ac_renamed.setOffsetY(this.aI_renamed);
        invalidate();
    }

    public void n_renamed() {
        this.aI_renamed = 0.0f;
        this.ac_renamed.setOffsetY(this.aI_renamed);
        invalidate();
    }

    public void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        android.animation.ValueAnimator valueAnimator;
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "setVisibility, visibility: " + i_renamed + ", animType: " + i2);
        if (getVisibility() != i_renamed || ((valueAnimator = this.i_renamed) != null && valueAnimator.isRunning())) {
            android.animation.ValueAnimator valueAnimator2 = this.i_renamed;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.i_renamed.cancel();
                this.i_renamed = null;
            }
            if (i2 == 0) {
                h_renamed(i_renamed);
            } else if (i2 == 1) {
                android.animation.ValueAnimator valueAnimator3 = this.k_renamed;
                if (valueAnimator3 != null && valueAnimator3.isRunning()) {
                    this.k_renamed.cancel();
                }
                android.animation.ValueAnimator valueAnimator4 = this.j_renamed;
                if (valueAnimator4 != null && valueAnimator4.isRunning()) {
                    this.j_renamed.cancel();
                    this.j_renamed = null;
                }
                this.aI_renamed = 0.0f;
                this.aN_renamed = 0.0f;
                this.aM_renamed = 255;
                if (i_renamed == 0) {
                    a_renamed(i_renamed, 160L, 0L, this.m_renamed, z_renamed, i2);
                } else {
                    a_renamed(i_renamed, 250L, 0L, this.m_renamed, z_renamed, i2);
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    if (i_renamed == 0) {
                        if (this.ac_renamed != null) {
                            this.ac_renamed.a_renamed((int) f_renamed(this.n_renamed.getInterpolation(1.0f)), (int) (((this.K_renamed / 2.0f) / this.as_renamed) / (this.ax_renamed / 2.0f)), 250, 150);
                        }
                        a_renamed(i_renamed, 250L, 150L, this.m_renamed, z_renamed, i2);
                    } else {
                        a_renamed(i_renamed, 250L, 0L, this.m_renamed, z_renamed, i2);
                    }
                }
            } else if (i_renamed == 0) {
                a_renamed(i_renamed, 300L, z2 ? 300 : 100, this.m_renamed, z_renamed, i2);
            } else {
                a_renamed(i_renamed, 250L, 0L, this.m_renamed, z_renamed, i2);
            }
            this.ac_renamed.setOffsetY(this.aI_renamed);
        }
    }

    /* compiled from: ModePickerView.java */
    private class f_renamed extends com.a_renamed.a_renamed.e_renamed {
        private f_renamed() {
        }

        @Override // com.a_renamed.a_renamed.e_renamed, com.a_renamed.a_renamed.h_renamed
        public void a_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
            synchronized (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.f6353b) {
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.R_renamed = (float) fVar.c_renamed();
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.invalidate();
            }
        }

        @Override // com.a_renamed.a_renamed.e_renamed, com.a_renamed.a_renamed.h_renamed
        public void b_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
            com.oplus.camera.e_renamed.a_renamed("ModePickerView", "onSpringAtRest, mSlideAnim completed");
            if (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aQ_renamed) {
                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aQ_renamed = false;
                com.oplus.camera.ui.menu.a_renamed.e_renamed eVar = com.oplus.camera.ui.menu.a_renamed.e_renamed.this;
                eVar.a_renamed(eVar.q_renamed);
            }
        }
    }

    private void t_renamed() {
        this.U_renamed = com.a_renamed.a_renamed.j_renamed.c_renamed().b_renamed().a_renamed(com.a_renamed.a_renamed.g_renamed.b_renamed(2.0d, 35.0d));
        this.U_renamed.a_renamed(new com.oplus.camera.ui.menu.a_renamed.e_renamed.f_renamed());
    }

    /* compiled from: ModePickerView.java */
    private class a_renamed extends android.view.GestureDetector.SimpleOnGestureListener {
        private a_renamed() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(android.view.MotionEvent motionEvent) throws android.content.res.Resources.NotFoundException {
            if (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed != null && com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed.p_renamed(com.oplus.camera.ui.menu.a_renamed.e_renamed.this.A_renamed)) {
                if (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed != null && (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed.Y_renamed() || com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed.Z_renamed())) {
                    com.oplus.camera.e_renamed.a_renamed("ModePickerView", "DefaultGestureDetector, onSingleTapUp, so return when isCapturingOrVideoRecording or isNoneSatUltraWideAngleChanging");
                    return false;
                }
                if (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.k_renamed() || com.oplus.camera.ui.menu.a_renamed.e_renamed.this.l_renamed() || com.oplus.camera.ui.menu.a_renamed.e_renamed.this.getVisibility() != 0 || com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed.az_renamed()) {
                    com.oplus.camera.e_renamed.a_renamed("ModePickerView", "DefaultGestureDetector, onSingleTapUp, can't_renamed response TouchEvent , isAnimationRunning or View is_renamed not visible");
                    return false;
                }
                if (!com.oplus.camera.ui.menu.a_renamed.e_renamed.this.d_renamed(1)) {
                    if (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.s_renamed()) {
                        com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aQ_renamed = true;
                        com.oplus.camera.ui.menu.a_renamed.e_renamed.this.U_renamed.j_renamed();
                    }
                    float rawX = motionEvent.getRawX();
                    float y_renamed = motionEvent.getY();
                    int previewFrameWidth = com.oplus.camera.ui.menu.a_renamed.e_renamed.this.getPreviewFrameWidth();
                    if (3 == com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aO_renamed) {
                        previewFrameWidth = com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aP_renamed.b_renamed();
                        rawX -= com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aP_renamed.a_renamed(com.oplus.camera.ui.menu.a_renamed.e_renamed.this.ab_renamed).a_renamed();
                    } else if (4 == com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aO_renamed) {
                        previewFrameWidth = com.oplus.camera.ui.menu.a_renamed.e_renamed.this.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_headline_width);
                        rawX = motionEvent.getX(motionEvent.getActionIndex());
                    }
                    if (previewFrameWidth > 0 && java.lang.Float.compare(rawX, 0.0f) >= 0 && java.lang.Float.compare(rawX, previewFrameWidth) <= 0) {
                        int iA = com.oplus.camera.ui.menu.a_renamed.e_renamed.this.a_renamed(rawX - (previewFrameWidth / 2), y_renamed);
                        com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aA_renamed = false;
                        synchronized (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.f6352a) {
                            if (iA >= 0) {
                                try {
                                    com.oplus.camera.ui.menu.a_renamed.e_renamed.this.setCurrentIndex(iA);
                                } catch (java.lang.Throwable th) {
                                    throw th;
                                }
                            }
                            if (iA < 0 || com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed == null) {
                                if (iA == -2 && com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed != null) {
                                    com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed.ay_renamed();
                                }
                            } else {
                                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed.o_renamed(com.oplus.camera.ui.menu.a_renamed.e_renamed.this.A_renamed);
                            }
                        }
                        return true;
                    }
                    return super.onSingleTapUp(motionEvent);
                }
                com.oplus.camera.e_renamed.a_renamed("ModePickerView", "DefaultGestureDetector, onSingleTapUp, follow finger can't_renamed response TouchEvent");
                return false;
            }
            com.oplus.camera.e_renamed.b_renamed("ModePickerView", "DefaultGestureDetector, onSingleTapUp, can't_renamed response TouchEvent.");
            return false;
        }
    }

    /* compiled from: ModePickerView.java */
    private class d_renamed extends android.view.GestureDetector.SimpleOnGestureListener {
        private d_renamed() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(android.view.MotionEvent motionEvent) throws android.content.res.Resources.NotFoundException {
            if (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aB_renamed) {
                if (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed != null && (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed.Y_renamed() || com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed.Z_renamed())) {
                    com.oplus.camera.e_renamed.a_renamed("ModePickerView", "DefaultVerticalGestureDetector, onSingleTapUp, so return when isCapturingOrVideoRecording or isNoneSatUltraWideAngleChanging");
                    return false;
                }
                if (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.k_renamed() || com.oplus.camera.ui.menu.a_renamed.e_renamed.this.getVisibility() != 0) {
                    com.oplus.camera.e_renamed.a_renamed("ModePickerView", "DefaultVerticalGestureDetector, onSingleTapUp, can't_renamed response TouchEvent , isAnimationRunning or View is_renamed not visible");
                    return false;
                }
                if (!com.oplus.camera.ui.menu.a_renamed.e_renamed.this.d_renamed(1)) {
                    if (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.s_renamed()) {
                        com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aQ_renamed = true;
                        com.oplus.camera.ui.menu.a_renamed.e_renamed.this.U_renamed.j_renamed();
                    }
                    float y_renamed = motionEvent.getY(motionEvent.getActionIndex());
                    int dimensionPixelSize = com.oplus.camera.ui.menu.a_renamed.e_renamed.this.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_height);
                    if (dimensionPixelSize > 0 && java.lang.Float.compare(y_renamed, 0.0f) >= 0 && java.lang.Float.compare(y_renamed, dimensionPixelSize) <= 0) {
                        int iA = com.oplus.camera.ui.menu.a_renamed.e_renamed.this.a_renamed(y_renamed - (dimensionPixelSize / 2));
                        com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aA_renamed = false;
                        synchronized (com.oplus.camera.ui.menu.a_renamed.e_renamed.this.f6352a) {
                            if (iA >= 0) {
                                try {
                                    com.oplus.camera.ui.menu.a_renamed.e_renamed.this.setCurrentIndex(iA);
                                } catch (java.lang.Throwable th) {
                                    throw th;
                                }
                            }
                            if (iA < 0 || com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed == null) {
                                if (iA == -2 && com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed != null) {
                                    com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed.ay_renamed();
                                }
                            } else {
                                com.oplus.camera.ui.menu.a_renamed.e_renamed.this.aG_renamed.o_renamed(com.oplus.camera.ui.menu.a_renamed.e_renamed.this.A_renamed);
                            }
                        }
                        return true;
                    }
                    return super.onSingleTapUp(motionEvent);
                }
                com.oplus.camera.e_renamed.a_renamed("ModePickerView", "DefaultVerticalGestureDetector, onSingleTapUp, follow finger can't_renamed response TouchEvent");
                return false;
            }
            com.oplus.camera.e_renamed.b_renamed("ModePickerView", "DefaultVerticalGestureDetector, onSingleTapUp, can't_renamed response TouchEvent.");
            return false;
        }
    }

    public boolean o_renamed() {
        return getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g_renamed(float f2) {
        com.oplus.camera.e_renamed.a_renamed("ModePickerView", "updateAlpha, alpha: " + f2);
        if (!this.aL_renamed) {
            setAlpha(f2);
        }
        setBGAlphaValue(f2);
        h_renamed();
    }

    private void setBGAlphaValue(float f2) {
        synchronized (this.f6353b) {
            this.Q_renamed = f2;
            invalidate();
        }
    }

    /* compiled from: ModePickerView.java */
    private class c_renamed implements android.animation.Animator.AnimatorListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.animation.Animator.AnimatorListener f6369b;

        public c_renamed(android.animation.Animator.AnimatorListener animatorListener) {
            this.f6369b = null;
            this.f6369b = animatorListener;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.oplus.camera.e_renamed.a_renamed("ModePickerView", "DefaultShowAnimatorListener, onAnimationStart");
            android.animation.Animator.AnimatorListener animatorListener = this.f6369b;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.oplus.camera.e_renamed.a_renamed("ModePickerView", "DefaultShowAnimatorListener, onAnimationEnd");
            com.oplus.camera.ui.menu.a_renamed.e_renamed.this.g_renamed(1.0f);
            com.oplus.camera.ui.menu.a_renamed.e_renamed.this.setEnabled(true);
            android.animation.Animator.AnimatorListener animatorListener = this.f6369b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            com.oplus.camera.e_renamed.a_renamed("ModePickerView", "DefaultShowAnimatorListener, onAnimationCancel");
            com.oplus.camera.ui.menu.a_renamed.e_renamed.this.g_renamed(1.0f);
            com.oplus.camera.ui.menu.a_renamed.e_renamed.this.setEnabled(true);
            android.animation.Animator.AnimatorListener animatorListener = this.f6369b;
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
            android.animation.Animator.AnimatorListener animatorListener = this.f6369b;
            if (animatorListener != null) {
                animatorListener.onAnimationRepeat(animator);
            }
        }
    }

    /* compiled from: ModePickerView.java */
    private class b_renamed implements android.animation.Animator.AnimatorListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.animation.Animator.AnimatorListener f6367b;

        public b_renamed(android.animation.Animator.AnimatorListener animatorListener) {
            this.f6367b = null;
            this.f6367b = animatorListener;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.oplus.camera.e_renamed.a_renamed("ModePickerView", "DefaultHideAnimatorListener, onAnimationStart");
            com.oplus.camera.ui.menu.a_renamed.e_renamed.this.setVisibility(0);
            android.animation.Animator.AnimatorListener animatorListener = this.f6367b;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.oplus.camera.e_renamed.a_renamed("ModePickerView", "DefaultHideAnimatorListener, onAnimationEnd");
            com.oplus.camera.ui.menu.a_renamed.e_renamed.this.setVisibility(4);
            com.oplus.camera.ui.menu.a_renamed.e_renamed.this.g_renamed(1.0f);
            com.oplus.camera.ui.menu.a_renamed.e_renamed.this.setEnabled(true);
            android.animation.Animator.AnimatorListener animatorListener = this.f6367b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            com.oplus.camera.e_renamed.a_renamed("ModePickerView", "DefaultHideAnimatorListener, onAnimationCancel");
            com.oplus.camera.ui.menu.a_renamed.e_renamed.this.setVisibility(4);
            com.oplus.camera.ui.menu.a_renamed.e_renamed.this.g_renamed(1.0f);
            com.oplus.camera.ui.menu.a_renamed.e_renamed.this.setEnabled(true);
            android.animation.Animator.AnimatorListener animatorListener = this.f6367b;
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
            android.animation.Animator.AnimatorListener animatorListener = this.f6367b;
            if (animatorListener != null) {
                animatorListener.onAnimationRepeat(animator);
            }
        }
    }

    private int[] u_renamed() {
        if (this.ai_renamed) {
            return new int[]{436207616, getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency), getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency), getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency), getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency), getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency), getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency), 436207616};
        }
        return new int[]{getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_0_percent_transparency), getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency), getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency), getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency), getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency), getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency), getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency), getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_0_percent_transparency)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPreviewFrameWidth() {
        int i_renamed = this.aO_renamed;
        if (3 == i_renamed) {
            return com.oplus.camera.util.Util.getScreenWidth() / 2;
        }
        if (4 == i_renamed) {
            return getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_headline_width);
        }
        return com.oplus.camera.util.Util.getScreenWidth();
    }
}
