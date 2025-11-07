package com.oplus.camera.ui.control;

/* loaded from: classes2.dex */
public class MainShutterButton extends com.oplus.camera.ui.control.ShutterButton {
    private static final android.view.animation.Interpolator o_renamed = new android.view.animation.LinearInterpolator();
    private static final android.view.animation.Interpolator p_renamed = new android.view.animation.AccelerateDecelerateInterpolator();
    private static final int q_renamed = android.graphics.Color.parseColor("#FFEA3447");
    private static final int r_renamed = android.graphics.Color.parseColor("#E3E3E3");
    private static final int s_renamed = android.graphics.Color.parseColor("#4D4D4D");
    private static final int t_renamed = android.graphics.Color.parseColor("#FB822A");
    private static final int u_renamed = android.graphics.Color.parseColor("#E1651F");
    private static final int v_renamed = android.graphics.Color.parseColor("#757575");
    private static final int w_renamed = android.graphics.Color.parseColor("#33FB822A");
    private int A_renamed;
    private int B_renamed;
    private float C_renamed;
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
    private float O_renamed;
    private float P_renamed;
    private int Q_renamed;
    private int R_renamed;
    private int S_renamed;
    private int T_renamed;
    private int U_renamed;
    private int V_renamed;
    private int W_renamed;
    private float aA_renamed;
    private float aB_renamed;
    private float aC_renamed;
    private float aD_renamed;
    private float aE_renamed;
    private float aF_renamed;
    private float aG_renamed;
    private float aH_renamed;
    private java.lang.String aI_renamed;
    private java.lang.String aJ_renamed;
    private java.lang.String aK_renamed;
    private boolean aL_renamed;
    private boolean aM_renamed;
    private boolean aN_renamed;
    private boolean aO_renamed;
    private boolean aP_renamed;
    private boolean aQ_renamed;
    private android.animation.AnimatorSet aR_renamed;
    private android.animation.ValueAnimator aS_renamed;
    private android.animation.ValueAnimator aT_renamed;
    private android.graphics.Canvas aU_renamed;
    private android.graphics.Bitmap aV_renamed;
    private android.graphics.Bitmap aW_renamed;
    private android.graphics.Bitmap aX_renamed;
    private android.graphics.Bitmap aY_renamed;
    private android.graphics.Bitmap aZ_renamed;
    private int aa_renamed;
    private int ab_renamed;
    private int ac_renamed;
    private int ad_renamed;
    private int ae_renamed;
    private int af_renamed;
    private int ag_renamed;
    private int ah_renamed;
    private int ai_renamed;
    private int aj_renamed;
    private int ak_renamed;
    private int al_renamed;
    private int am_renamed;
    private int an_renamed;
    private int ao_renamed;
    private int ap_renamed;
    private int aq_renamed;
    private int ar_renamed;
    private int as_renamed;
    private int at_renamed;
    private int au_renamed;
    private int av_renamed;
    private int aw_renamed;
    private int ax_renamed;
    private int ay_renamed;
    private int az_renamed;
    private android.animation.ObjectAnimator bA_renamed;
    private android.animation.ValueAnimator bB_renamed;
    private android.animation.ValueAnimator bC_renamed;
    private android.animation.ValueAnimator bD_renamed;
    private android.animation.ValueAnimator bE_renamed;
    private android.animation.ValueAnimator bF_renamed;
    private android.animation.ValueAnimator bG_renamed;
    private android.animation.ValueAnimator bH_renamed;
    private android.animation.ValueAnimator bI_renamed;
    private android.animation.ValueAnimator bJ_renamed;
    private android.animation.ValueAnimator bK_renamed;
    private android.animation.ValueAnimator bL_renamed;
    private android.animation.ValueAnimator bM_renamed;
    private android.animation.ValueAnimator bN_renamed;
    private android.animation.ValueAnimator bO_renamed;
    private android.animation.ValueAnimator bP_renamed;
    private android.animation.ValueAnimator bQ_renamed;
    private android.animation.ValueAnimator bR_renamed;
    private android.view.animation.PathInterpolator bS_renamed;
    private android.view.animation.PathInterpolator bT_renamed;
    private android.animation.ValueAnimator.AnimatorUpdateListener bU_renamed;
    private android.graphics.Path bV_renamed;
    private android.graphics.Bitmap ba_renamed;
    private android.graphics.RectF bb_renamed;
    private android.graphics.RectF bc_renamed;
    private android.graphics.RectF bd_renamed;
    private android.graphics.RectF be_renamed;
    private android.graphics.RectF bf_renamed;
    private android.graphics.RectF bg_renamed;
    private android.graphics.Paint bh_renamed;
    private android.graphics.Paint bi_renamed;
    private android.graphics.Paint bj_renamed;
    private android.graphics.Paint bk_renamed;
    private android.graphics.Paint bl_renamed;
    private android.graphics.Paint bm_renamed;
    private android.graphics.Paint bn_renamed;
    private android.graphics.Paint bo_renamed;
    private android.graphics.Paint bp_renamed;
    private android.graphics.Paint bq_renamed;
    private android.graphics.Paint br_renamed;
    private android.graphics.Paint bs_renamed;
    private android.graphics.Paint bt_renamed;
    private android.graphics.Paint bu_renamed;
    private android.util.Property<com.oplus.camera.ui.control.MainShutterButton, java.lang.Float> bv_renamed;
    private android.util.Property<com.oplus.camera.ui.control.MainShutterButton, java.lang.Float> bw_renamed;
    private android.util.Property<com.oplus.camera.ui.control.MainShutterButton, java.lang.Integer> bx_renamed;
    private android.animation.ObjectAnimator by_renamed;
    private android.animation.ObjectAnimator bz_renamed;
    private int x_renamed;
    private int y_renamed;
    private int z_renamed;

    private float a_renamed(float f_renamed, float f2, float f3, boolean z_renamed) {
        return z_renamed ? f_renamed - (((f2 - 1.0f) / 2.0f) * f3) : f_renamed + (((f2 - 1.0f) / 2.0f) * f3);
    }

    private void c_renamed(android.graphics.Canvas canvas, android.graphics.Bitmap bitmap) {
    }

    public MainShutterButton(android.content.Context context) {
        super(context);
        this.x_renamed = 1;
        this.y_renamed = 1;
        this.z_renamed = 0;
        this.A_renamed = 0;
        this.B_renamed = 0;
        this.C_renamed = 0.0f;
        this.D_renamed = 0;
        this.E_renamed = 0;
        this.F_renamed = 0;
        this.G_renamed = 0;
        this.H_renamed = 0;
        this.I_renamed = 0;
        this.J_renamed = 0;
        this.K_renamed = 0;
        this.L_renamed = 0;
        this.M_renamed = 0;
        this.N_renamed = 0;
        this.O_renamed = 0.0f;
        this.P_renamed = 0.0f;
        this.Q_renamed = 0;
        this.R_renamed = 0;
        this.S_renamed = 0;
        this.T_renamed = 0;
        this.U_renamed = 0;
        this.V_renamed = 0;
        this.W_renamed = 0;
        this.aa_renamed = 0;
        this.ab_renamed = 0;
        this.ac_renamed = 0;
        this.ad_renamed = 0;
        this.ae_renamed = 0;
        this.af_renamed = 0;
        this.ag_renamed = 0;
        this.ah_renamed = 0;
        this.ai_renamed = 0;
        this.aj_renamed = 0;
        this.ak_renamed = 0;
        this.al_renamed = 0;
        this.am_renamed = 0;
        this.an_renamed = 255;
        this.ao_renamed = 0;
        this.ap_renamed = 6;
        this.aq_renamed = 12;
        this.ar_renamed = 6;
        this.as_renamed = 9;
        this.at_renamed = 12;
        this.au_renamed = 4;
        this.av_renamed = 6;
        this.aw_renamed = 0;
        this.ax_renamed = 24;
        this.ay_renamed = 128;
        this.az_renamed = -1;
        this.aA_renamed = 0.0f;
        this.aB_renamed = 0.0f;
        this.aC_renamed = 0.0f;
        this.aD_renamed = 0.0f;
        this.aE_renamed = 0.0f;
        this.aF_renamed = 0.0f;
        this.aG_renamed = 0.0f;
        this.aH_renamed = 0.0f;
        this.aI_renamed = null;
        this.aJ_renamed = null;
        this.aK_renamed = null;
        this.aL_renamed = false;
        this.aM_renamed = true;
        this.aN_renamed = true;
        this.aO_renamed = false;
        this.aP_renamed = false;
        this.aQ_renamed = false;
        this.aR_renamed = null;
        this.aS_renamed = null;
        this.aT_renamed = null;
        this.aU_renamed = null;
        this.aV_renamed = null;
        this.aW_renamed = null;
        this.aX_renamed = null;
        this.aY_renamed = null;
        this.aZ_renamed = null;
        this.ba_renamed = null;
        this.bb_renamed = null;
        this.bc_renamed = null;
        this.bd_renamed = null;
        this.be_renamed = null;
        this.bf_renamed = null;
        this.bg_renamed = null;
        this.bh_renamed = null;
        this.bi_renamed = null;
        this.bj_renamed = null;
        this.bk_renamed = null;
        this.bl_renamed = null;
        this.bm_renamed = null;
        this.bn_renamed = null;
        this.bo_renamed = null;
        this.bp_renamed = null;
        this.bq_renamed = null;
        this.br_renamed = null;
        this.bs_renamed = null;
        this.bt_renamed = null;
        this.bu_renamed = null;
        this.bv_renamed = null;
        this.bw_renamed = null;
        this.bx_renamed = null;
        this.by_renamed = null;
        this.bz_renamed = null;
        this.bA_renamed = null;
        this.bB_renamed = null;
        this.bC_renamed = null;
        this.bD_renamed = null;
        this.bE_renamed = null;
        this.bF_renamed = null;
        this.bG_renamed = null;
        this.bH_renamed = null;
        this.bI_renamed = null;
        this.bJ_renamed = null;
        this.bK_renamed = null;
        this.bL_renamed = null;
        this.bM_renamed = null;
        this.bN_renamed = null;
        this.bO_renamed = null;
        this.bP_renamed = null;
        this.bQ_renamed = null;
        this.bR_renamed = null;
        this.bS_renamed = null;
        this.bT_renamed = null;
        this.bU_renamed = null;
        this.bV_renamed = new android.graphics.Path();
    }

    public MainShutterButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x_renamed = 1;
        this.y_renamed = 1;
        this.z_renamed = 0;
        this.A_renamed = 0;
        this.B_renamed = 0;
        this.C_renamed = 0.0f;
        this.D_renamed = 0;
        this.E_renamed = 0;
        this.F_renamed = 0;
        this.G_renamed = 0;
        this.H_renamed = 0;
        this.I_renamed = 0;
        this.J_renamed = 0;
        this.K_renamed = 0;
        this.L_renamed = 0;
        this.M_renamed = 0;
        this.N_renamed = 0;
        this.O_renamed = 0.0f;
        this.P_renamed = 0.0f;
        this.Q_renamed = 0;
        this.R_renamed = 0;
        this.S_renamed = 0;
        this.T_renamed = 0;
        this.U_renamed = 0;
        this.V_renamed = 0;
        this.W_renamed = 0;
        this.aa_renamed = 0;
        this.ab_renamed = 0;
        this.ac_renamed = 0;
        this.ad_renamed = 0;
        this.ae_renamed = 0;
        this.af_renamed = 0;
        this.ag_renamed = 0;
        this.ah_renamed = 0;
        this.ai_renamed = 0;
        this.aj_renamed = 0;
        this.ak_renamed = 0;
        this.al_renamed = 0;
        this.am_renamed = 0;
        this.an_renamed = 255;
        this.ao_renamed = 0;
        this.ap_renamed = 6;
        this.aq_renamed = 12;
        this.ar_renamed = 6;
        this.as_renamed = 9;
        this.at_renamed = 12;
        this.au_renamed = 4;
        this.av_renamed = 6;
        this.aw_renamed = 0;
        this.ax_renamed = 24;
        this.ay_renamed = 128;
        this.az_renamed = -1;
        this.aA_renamed = 0.0f;
        this.aB_renamed = 0.0f;
        this.aC_renamed = 0.0f;
        this.aD_renamed = 0.0f;
        this.aE_renamed = 0.0f;
        this.aF_renamed = 0.0f;
        this.aG_renamed = 0.0f;
        this.aH_renamed = 0.0f;
        this.aI_renamed = null;
        this.aJ_renamed = null;
        this.aK_renamed = null;
        this.aL_renamed = false;
        this.aM_renamed = true;
        this.aN_renamed = true;
        this.aO_renamed = false;
        this.aP_renamed = false;
        this.aQ_renamed = false;
        this.aR_renamed = null;
        this.aS_renamed = null;
        this.aT_renamed = null;
        this.aU_renamed = null;
        this.aV_renamed = null;
        this.aW_renamed = null;
        this.aX_renamed = null;
        this.aY_renamed = null;
        this.aZ_renamed = null;
        this.ba_renamed = null;
        this.bb_renamed = null;
        this.bc_renamed = null;
        this.bd_renamed = null;
        this.be_renamed = null;
        this.bf_renamed = null;
        this.bg_renamed = null;
        this.bh_renamed = null;
        this.bi_renamed = null;
        this.bj_renamed = null;
        this.bk_renamed = null;
        this.bl_renamed = null;
        this.bm_renamed = null;
        this.bn_renamed = null;
        this.bo_renamed = null;
        this.bp_renamed = null;
        this.bq_renamed = null;
        this.br_renamed = null;
        this.bs_renamed = null;
        this.bt_renamed = null;
        this.bu_renamed = null;
        this.bv_renamed = null;
        this.bw_renamed = null;
        this.bx_renamed = null;
        this.by_renamed = null;
        this.bz_renamed = null;
        this.bA_renamed = null;
        this.bB_renamed = null;
        this.bC_renamed = null;
        this.bD_renamed = null;
        this.bE_renamed = null;
        this.bF_renamed = null;
        this.bG_renamed = null;
        this.bH_renamed = null;
        this.bI_renamed = null;
        this.bJ_renamed = null;
        this.bK_renamed = null;
        this.bL_renamed = null;
        this.bM_renamed = null;
        this.bN_renamed = null;
        this.bO_renamed = null;
        this.bP_renamed = null;
        this.bQ_renamed = null;
        this.bR_renamed = null;
        this.bS_renamed = null;
        this.bT_renamed = null;
        this.bU_renamed = null;
        this.bV_renamed = new android.graphics.Path();
        a_renamed(context, attributeSet, 0);
    }

    public MainShutterButton(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.x_renamed = 1;
        this.y_renamed = 1;
        this.z_renamed = 0;
        this.A_renamed = 0;
        this.B_renamed = 0;
        this.C_renamed = 0.0f;
        this.D_renamed = 0;
        this.E_renamed = 0;
        this.F_renamed = 0;
        this.G_renamed = 0;
        this.H_renamed = 0;
        this.I_renamed = 0;
        this.J_renamed = 0;
        this.K_renamed = 0;
        this.L_renamed = 0;
        this.M_renamed = 0;
        this.N_renamed = 0;
        this.O_renamed = 0.0f;
        this.P_renamed = 0.0f;
        this.Q_renamed = 0;
        this.R_renamed = 0;
        this.S_renamed = 0;
        this.T_renamed = 0;
        this.U_renamed = 0;
        this.V_renamed = 0;
        this.W_renamed = 0;
        this.aa_renamed = 0;
        this.ab_renamed = 0;
        this.ac_renamed = 0;
        this.ad_renamed = 0;
        this.ae_renamed = 0;
        this.af_renamed = 0;
        this.ag_renamed = 0;
        this.ah_renamed = 0;
        this.ai_renamed = 0;
        this.aj_renamed = 0;
        this.ak_renamed = 0;
        this.al_renamed = 0;
        this.am_renamed = 0;
        this.an_renamed = 255;
        this.ao_renamed = 0;
        this.ap_renamed = 6;
        this.aq_renamed = 12;
        this.ar_renamed = 6;
        this.as_renamed = 9;
        this.at_renamed = 12;
        this.au_renamed = 4;
        this.av_renamed = 6;
        this.aw_renamed = 0;
        this.ax_renamed = 24;
        this.ay_renamed = 128;
        this.az_renamed = -1;
        this.aA_renamed = 0.0f;
        this.aB_renamed = 0.0f;
        this.aC_renamed = 0.0f;
        this.aD_renamed = 0.0f;
        this.aE_renamed = 0.0f;
        this.aF_renamed = 0.0f;
        this.aG_renamed = 0.0f;
        this.aH_renamed = 0.0f;
        this.aI_renamed = null;
        this.aJ_renamed = null;
        this.aK_renamed = null;
        this.aL_renamed = false;
        this.aM_renamed = true;
        this.aN_renamed = true;
        this.aO_renamed = false;
        this.aP_renamed = false;
        this.aQ_renamed = false;
        this.aR_renamed = null;
        this.aS_renamed = null;
        this.aT_renamed = null;
        this.aU_renamed = null;
        this.aV_renamed = null;
        this.aW_renamed = null;
        this.aX_renamed = null;
        this.aY_renamed = null;
        this.aZ_renamed = null;
        this.ba_renamed = null;
        this.bb_renamed = null;
        this.bc_renamed = null;
        this.bd_renamed = null;
        this.be_renamed = null;
        this.bf_renamed = null;
        this.bg_renamed = null;
        this.bh_renamed = null;
        this.bi_renamed = null;
        this.bj_renamed = null;
        this.bk_renamed = null;
        this.bl_renamed = null;
        this.bm_renamed = null;
        this.bn_renamed = null;
        this.bo_renamed = null;
        this.bp_renamed = null;
        this.bq_renamed = null;
        this.br_renamed = null;
        this.bs_renamed = null;
        this.bt_renamed = null;
        this.bu_renamed = null;
        this.bv_renamed = null;
        this.bw_renamed = null;
        this.bx_renamed = null;
        this.by_renamed = null;
        this.bz_renamed = null;
        this.bA_renamed = null;
        this.bB_renamed = null;
        this.bC_renamed = null;
        this.bD_renamed = null;
        this.bE_renamed = null;
        this.bF_renamed = null;
        this.bG_renamed = null;
        this.bH_renamed = null;
        this.bI_renamed = null;
        this.bJ_renamed = null;
        this.bK_renamed = null;
        this.bL_renamed = null;
        this.bM_renamed = null;
        this.bN_renamed = null;
        this.bO_renamed = null;
        this.bP_renamed = null;
        this.bQ_renamed = null;
        this.bR_renamed = null;
        this.bS_renamed = null;
        this.bT_renamed = null;
        this.bU_renamed = null;
        this.bV_renamed = new android.graphics.Path();
        a_renamed(context, attributeSet, i_renamed);
    }

    protected void a_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        setButtonTypeAndInvalidate(new com.oplus.camera.ui.control.b_renamed(1, "button_color_inside_none", "button_shape_ring_none"));
        b_renamed(context, attributeSet, i_renamed);
    }

    private void b_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.oplus.camera.R_renamed.styleable.MainShutterButton, i_renamed, 0);
        android.content.res.Resources resources = context.getResources();
        try {
            try {
                this.z_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(18, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_big_circle_radius));
                this.A_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(14, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_small_circle_radius));
                this.D_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_inside_rect_length));
                this.E_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(15, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_inside_rect_corner_radius));
                this.H_renamed = typedArrayObtainStyledAttributes.getInt(0, resources.getInteger(com.oplus.camera.R_renamed.integer.main_btn_default_angleAnimationDurationMillis));
                this.I_renamed = typedArrayObtainStyledAttributes.getInt(22, resources.getInteger(com.oplus.camera.R_renamed.integer.main_btn_default_sweepAnimationDuration));
                this.J_renamed = typedArrayObtainStyledAttributes.getInt(17, resources.getInteger(com.oplus.camera.R_renamed.integer.main_btn_default_miniSweepAngle));
                this.aE_renamed = 360 - this.J_renamed;
                this.N_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_big_circle_radius_scaled));
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
            typedArrayObtainStyledAttributes.recycle();
            this.Q_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.camera_button_path_width);
            this.R_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.step_next_width);
            this.S_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.step_next_height);
            this.U_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.step_next_top);
            this.T_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.step_next_left);
            this.W_renamed = this.U_renamed + this.S_renamed;
            this.V_renamed = this.T_renamed + this.R_renamed;
            this.aa_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.step_complete_width);
            this.ab_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.step_complete_height);
            this.ac_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.step_complete_left);
            this.ad_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.step_complete_top);
            this.ae_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.step_complete_hook_x1);
            this.af_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.step_complete_hook_y1);
            this.ag_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.step_complete_hook_x2);
            this.ah_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.step_complete_hook_y2);
            this.ai_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.step_complete_hook_x3);
            this.aj_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.step_complete_hook_y3);
            this.au_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.double_exposure_shutter_shadow_offset);
            this.O_renamed = this.z_renamed - this.A_renamed;
            this.bh_renamed = new android.graphics.Paint();
            this.bh_renamed.setAntiAlias(true);
            this.bh_renamed.setStyle(android.graphics.Paint.Style.STROKE);
            this.bh_renamed.setStrokeWidth(this.O_renamed);
            this.bi_renamed = new android.graphics.Paint();
            this.bi_renamed.setAntiAlias(true);
            this.bi_renamed.setStyle(android.graphics.Paint.Style.FILL);
            this.bi_renamed.setAlpha(128);
            this.bj_renamed = new android.graphics.Paint();
            this.bj_renamed.setAntiAlias(true);
            this.bj_renamed.setStyle(android.graphics.Paint.Style.FILL);
            this.bj_renamed.setColor(q_renamed);
            this.bk_renamed = new android.graphics.Paint();
            this.bk_renamed.setAntiAlias(true);
            this.bk_renamed.setStyle(android.graphics.Paint.Style.FILL);
            this.bk_renamed.setAlpha(51);
            this.bm_renamed = new android.graphics.Paint();
            this.bm_renamed.setAntiAlias(true);
            this.bm_renamed.setStyle(android.graphics.Paint.Style.STROKE);
            this.bm_renamed.setStrokeWidth(this.O_renamed);
            this.bn_renamed = new android.graphics.Paint();
            this.bn_renamed.setAntiAlias(true);
            this.bn_renamed.setStyle(android.graphics.Paint.Style.FILL);
            this.bp_renamed = new android.graphics.Paint();
            this.bp_renamed.setAntiAlias(true);
            this.bp_renamed.setColor(-1);
            this.bp_renamed.setStyle(android.graphics.Paint.Style.STROKE);
            this.bp_renamed.setStrokeWidth(this.Q_renamed);
            this.bp_renamed.setStrokeCap(android.graphics.Paint.Cap.SQUARE);
            this.bp_renamed.setStrokeJoin(android.graphics.Paint.Join.ROUND);
            this.bq_renamed = new android.graphics.Paint(this.bp_renamed);
            if (com.oplus.camera.util.Util.ao_renamed()) {
                this.P_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.shutter_button_hasseiblad_arc_thickness);
                this.br_renamed = new android.graphics.Paint();
                this.br_renamed.setAntiAlias(true);
                this.br_renamed.setColor(t_renamed);
                this.br_renamed.setStyle(android.graphics.Paint.Style.FILL);
                android.graphics.Paint paint = this.br_renamed;
                paint.setAlpha(paint.getColor() >>> 24);
                this.br_renamed.setShader(e_renamed(t_renamed, u_renamed));
                this.bs_renamed = new android.graphics.Paint();
                this.bs_renamed.setAntiAlias(true);
                this.bs_renamed.setColor(t_renamed);
                this.bs_renamed.setStyle(android.graphics.Paint.Style.STROKE);
                android.graphics.Paint paint2 = this.bs_renamed;
                paint2.setAlpha(paint2.getColor() >>> 24);
                this.bs_renamed.setShader(e_renamed(t_renamed, u_renamed));
                this.bt_renamed = new android.graphics.Paint();
                this.bt_renamed.setAntiAlias(true);
                this.bt_renamed.setColor(w_renamed);
                this.bt_renamed.setStyle(android.graphics.Paint.Style.STROKE);
                this.bt_renamed.setStrokeWidth(this.P_renamed);
                this.bu_renamed = new android.graphics.Paint();
                this.bu_renamed.setAntiAlias(true);
                this.bu_renamed.setColor(t_renamed);
                this.bu_renamed.setStyle(android.graphics.Paint.Style.STROKE);
                this.bu_renamed.setStrokeCap(android.graphics.Paint.Cap.ROUND);
                this.bu_renamed.setStrokeWidth(this.P_renamed);
                this.bl_renamed = new android.graphics.Paint();
                this.bl_renamed.setAntiAlias(true);
                this.bl_renamed.setStyle(android.graphics.Paint.Style.FILL);
                this.bl_renamed.setColor(t_renamed);
                android.graphics.Paint paint3 = this.bl_renamed;
                paint3.setAlpha(paint3.getColor() >>> 24);
                this.bl_renamed.setShader(e_renamed(t_renamed, u_renamed));
            }
            k_renamed();
            p_renamed();
        } catch (java.lang.Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, int i_renamed) {
        android.graphics.drawable.Drawable drawable = getContext().getDrawable(i_renamed);
        drawable.setState(getDrawableState());
        if (bitmap == null) {
            bitmap = android.graphics.Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        }
        android.graphics.Canvas canvas = this.aU_renamed;
        if (canvas == null) {
            this.aU_renamed = new android.graphics.Canvas(bitmap);
        } else {
            canvas.setBitmap(bitmap);
        }
        drawable.setBounds(0, 0, this.aU_renamed.getWidth(), this.aU_renamed.getHeight());
        this.aU_renamed.drawColor(0, android.graphics.BlendMode.CLEAR);
        drawable.draw(this.aU_renamed);
        return bitmap;
    }

    private android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, int i_renamed, float f_renamed) {
        android.graphics.drawable.Drawable drawable = getContext().getDrawable(i_renamed);
        drawable.setState(getDrawableState());
        if (bitmap == null) {
            bitmap = android.graphics.Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        }
        android.graphics.Canvas canvas = this.aU_renamed;
        if (canvas == null) {
            this.aU_renamed = new android.graphics.Canvas(bitmap);
        } else {
            canvas.setBitmap(bitmap);
        }
        drawable.setTint(v_renamed);
        double d_renamed = 1.0d - f_renamed;
        drawable.setBounds((int) (((this.aU_renamed.getWidth() / 2.0f) * d_renamed) + 0.0d), (int) (((this.aU_renamed.getHeight() / 2.0f) * d_renamed) + 0.0d), (int) (this.aU_renamed.getWidth() - ((this.aU_renamed.getWidth() / 2.0f) * d_renamed)), (int) (this.aU_renamed.getHeight() - ((this.aU_renamed.getHeight() / 2.0f) * d_renamed)));
        this.aU_renamed.drawColor(0, android.graphics.BlendMode.CLEAR);
        drawable.draw(this.aU_renamed);
        return bitmap;
    }

    @Override // com.oplus.camera.ui.control.ShutterButton, com.oplus.camera.ui.RotateImageView, com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(final boolean z_renamed) {
        this.n_renamed = z_renamed;
        k_renamed();
        refreshDrawableState();
        x_renamed();
        post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.control.-$$Lambda$MainShutterButton$K6b3K5fIqeHI87OactLQ4tWRGNo
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.a_renamed(z_renamed);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(boolean z_renamed) {
        if (z_renamed) {
            setBackgroundColor(0);
        } else if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_UI_SHUTTER_BUTTON_TYPE_LOW_LIGHT)) {
            setBackgroundResource(com.oplus.camera.R_renamed.drawable.button_shutter_low_shadow_background);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k_renamed() {
        int i_renamed;
        if (this.n_renamed) {
            i_renamed = s_renamed;
        } else {
            i_renamed = (this.aO_renamed || !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_UI_SHUTTER_BUTTON_TYPE_LOW_LIGHT)) ? -1 : r_renamed;
        }
        this.al_renamed = i_renamed;
        this.am_renamed = com.oplus.camera.util.Util.A_renamed(getContext());
        int i2 = this.al_renamed;
        this.az_renamed = i2;
        android.animation.ValueAnimator valueAnimator = this.bD_renamed;
        if (valueAnimator != null) {
            valueAnimator.setIntValues(this.am_renamed, i2);
        }
        android.graphics.Paint paint = this.bh_renamed;
        if (paint != null) {
            paint.setColor(this.al_renamed);
        }
        android.graphics.Paint paint2 = this.bi_renamed;
        if (paint2 != null) {
            paint2.setColor(this.al_renamed);
        }
        android.graphics.Paint paint3 = this.bk_renamed;
        if (paint3 != null) {
            paint3.setColor(this.al_renamed);
        }
        android.graphics.Paint paint4 = this.bm_renamed;
        if (paint4 != null) {
            paint4.setColor(this.al_renamed);
        }
        android.graphics.Paint paint5 = this.bn_renamed;
        if (paint5 != null) {
            paint5.setColor(this.al_renamed);
        }
        android.graphics.Paint paint6 = this.bp_renamed;
        if (paint6 != null) {
            paint6.setColor(this.al_renamed);
        }
        if (com.oplus.camera.util.Util.ao_renamed()) {
            android.graphics.Paint paint7 = this.br_renamed;
            if (paint7 != null) {
                paint7.setColor(t_renamed);
                android.graphics.Paint paint8 = this.br_renamed;
                paint8.setAlpha(paint8.getColor() >>> 24);
                this.br_renamed.setShader(e_renamed(t_renamed, u_renamed));
            }
            android.graphics.Paint paint9 = this.bs_renamed;
            if (paint9 != null) {
                paint9.setColor(t_renamed);
                android.graphics.Paint paint10 = this.bs_renamed;
                paint10.setAlpha(paint10.getColor() >>> 24);
                this.bs_renamed.setShader(e_renamed(t_renamed, u_renamed));
            }
            android.graphics.Paint paint11 = this.bt_renamed;
            if (paint11 != null) {
                paint11.setColor(w_renamed);
            }
            android.graphics.Paint paint12 = this.bu_renamed;
            if (paint12 != null) {
                paint12.setColor(t_renamed);
            }
            android.graphics.Paint paint13 = this.bl_renamed;
            if (paint13 != null) {
                paint13.setColor(t_renamed);
                android.graphics.Paint paint14 = this.bl_renamed;
                paint14.setAlpha(paint14.getColor() >>> 24);
                this.bl_renamed.setShader(e_renamed(t_renamed, u_renamed));
            }
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z_renamed) {
        if (this.bF_renamed == null || this.bE_renamed == null) {
            com.oplus.camera.e_renamed.a_renamed("MainShutterButton", "setPressed, return because Animator is_renamed null");
            return;
        }
        boolean z2 = z_renamed != isPressed();
        super.setPressed(z_renamed);
        if (z2) {
            u_renamed();
            if (isPressed()) {
                float f_renamed = this.aA_renamed;
                int i_renamed = this.z_renamed;
                if (f_renamed <= i_renamed) {
                    f_renamed = i_renamed;
                }
                this.bE_renamed.setFloatValues(f_renamed, this.N_renamed);
                this.bF_renamed.setDuration((long) (((this.N_renamed - f_renamed) * 100.0f) / (r2 - this.z_renamed)));
                this.bE_renamed.start();
            } else {
                float f2 = this.aA_renamed;
                int i2 = this.z_renamed;
                if (f2 <= i2) {
                    f2 = i2;
                }
                this.bF_renamed.setFloatValues(f2, this.z_renamed);
                this.bF_renamed.setDuration((long) (((f2 - this.z_renamed) * 100.0f) / (this.N_renamed - r2)));
                this.bF_renamed.start();
            }
            invalidate();
        }
    }

    private void l_renamed() {
        if (n_renamed()) {
            return;
        }
        this.aL_renamed = true;
        android.animation.ValueAnimator valueAnimator = this.aS_renamed;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(-1);
            this.aS_renamed.start();
        }
        android.animation.AnimatorSet animatorSet = this.aR_renamed;
        if (animatorSet != null) {
            animatorSet.start();
        }
        invalidate();
    }

    private void m_renamed() {
        if (n_renamed()) {
            this.aL_renamed = false;
            android.animation.ValueAnimator valueAnimator = this.aS_renamed;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            android.animation.AnimatorSet animatorSet = this.aR_renamed;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            invalidate();
        }
    }

    private boolean n_renamed() {
        return this.aL_renamed;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:172:0x096a  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:173:0x0972  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:91:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:92:0x02ec  */
    @Override // com.oplus.camera.ui.control.ShutterButton, com.oplus.camera.ui.RotateImageView, android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instructions count: 4233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.control.MainShutterButton.onDraw(android.graphics.Canvas):void");
    }

    private void a_renamed(android.graphics.Canvas canvas, boolean z_renamed) {
        a_renamed(canvas, z_renamed, false);
    }

    private void a_renamed(android.graphics.Canvas canvas, boolean z_renamed, boolean z2) {
        if ("button_color_inside_red".equals(this.aI_renamed)) {
            this.bj_renamed.setAlpha(this.an_renamed);
            this.bo_renamed = this.bj_renamed;
        } else if ("button_color_inside_grey".equals(this.aI_renamed)) {
            this.bk_renamed.setAlpha(51);
            this.bo_renamed = this.bk_renamed;
        }
        if (z_renamed) {
            if (isPressed()) {
                android.graphics.Paint paint = this.bo_renamed;
                if (paint != null) {
                    paint.setAlpha(51);
                }
                this.bm_renamed.setAlpha(128);
            } else {
                this.bm_renamed.setAlpha(255);
            }
        }
        if (this.bo_renamed != null && 2 != this.x_renamed) {
            int i_renamed = "button_shape_ring_none".equals(this.aJ_renamed) ? this.A_renamed : this.B_renamed;
            android.graphics.RectF rectF = "button_shape_ring_none".equals(this.aJ_renamed) ? this.bb_renamed : this.bc_renamed;
            float f_renamed = i_renamed;
            android.graphics.RectF rectF2 = new android.graphics.RectF((rectF.left + f_renamed) - (((rectF.right - rectF.left) / 2.0f) * this.aG_renamed), (rectF.top + f_renamed) - (((rectF.bottom - rectF.top) / 2.0f) * this.aG_renamed), (rectF.right - f_renamed) + (((rectF.right - rectF.left) / 2.0f) * this.aG_renamed), (rectF.bottom - f_renamed) + (((rectF.bottom - rectF.top) / 2.0f) * this.aG_renamed));
            int alpha = this.bo_renamed.getAlpha();
            this.bo_renamed.setAlpha((int) (this.aH_renamed * 255.0f));
            canvas.drawRoundRect(rectF2, f_renamed, f_renamed, this.bo_renamed);
            this.bo_renamed.setAlpha(alpha);
        }
        if (this.aO_renamed && !isPressed()) {
            android.graphics.Bitmap bitmap = this.aZ_renamed;
            if (bitmap == null) {
                this.aZ_renamed = a_renamed(bitmap, com.oplus.camera.R_renamed.drawable.shutter_button_shadow);
            }
            android.graphics.Bitmap bitmap2 = this.aZ_renamed;
            canvas.drawBitmap(bitmap2, new android.graphics.Rect(0, 0, bitmap2.getWidth(), this.aZ_renamed.getHeight()), this.be_renamed, this.bq_renamed);
        }
        if (z2) {
            android.graphics.RectF rectF3 = this.bd_renamed;
            int i2 = this.z_renamed;
            canvas.drawRoundRect(rectF3, i2, i2, this.br_renamed);
        } else {
            android.graphics.RectF rectF4 = this.bd_renamed;
            int i3 = this.z_renamed;
            canvas.drawRoundRect(rectF4, i3, i3, this.bm_renamed);
        }
    }

    private void a_renamed(android.graphics.Canvas canvas, android.graphics.Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(bitmap, (android.graphics.Rect) null, new android.graphics.RectF((getWidth() - bitmap.getWidth()) / 2, (getHeight() - bitmap.getHeight()) / 2, (getWidth() + bitmap.getWidth()) / 2, (getHeight() + bitmap.getHeight()) / 2), (android.graphics.Paint) null);
    }

    private void b_renamed(android.graphics.Canvas canvas, android.graphics.Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(bitmap, (android.graphics.Rect) null, new android.graphics.RectF((getWidth() - bitmap.getWidth()) / 2, (getHeight() - bitmap.getHeight()) / 2, (getWidth() + bitmap.getWidth()) / 2, (getHeight() + bitmap.getHeight()) / 2), (android.graphics.Paint) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o_renamed() {
        setModeAppearing(!this.aM_renamed);
        if (this.aM_renamed) {
            return;
        }
        this.aB_renamed = (this.aB_renamed + this.J_renamed) % 360.0f;
    }

    private void p_renamed() {
        q_renamed();
        y_renamed();
        z_renamed();
    }

    private void q_renamed() {
        this.bv_renamed = new android.util.Property<com.oplus.camera.ui.control.MainShutterButton, java.lang.Float>(java.lang.Float.class, "angle") { // from class: com.oplus.camera.ui.control.MainShutterButton.1
            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public java.lang.Float get(com.oplus.camera.ui.control.MainShutterButton mainShutterButton) {
                return java.lang.Float.valueOf(mainShutterButton.getCurrentGlobalAngle());
            }

            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public void set(com.oplus.camera.ui.control.MainShutterButton mainShutterButton, java.lang.Float f_renamed) {
                mainShutterButton.setCurrentGlobalAngle(f_renamed.floatValue());
            }
        };
        this.bw_renamed = new android.util.Property<com.oplus.camera.ui.control.MainShutterButton, java.lang.Float>(java.lang.Float.class, "arc") { // from class: com.oplus.camera.ui.control.MainShutterButton.12
            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public java.lang.Float get(com.oplus.camera.ui.control.MainShutterButton mainShutterButton) {
                return java.lang.Float.valueOf(mainShutterButton.getCurrentSweepAngle());
            }

            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public void set(com.oplus.camera.ui.control.MainShutterButton mainShutterButton, java.lang.Float f_renamed) {
                mainShutterButton.setCurrentSweepAngle(f_renamed.floatValue());
            }
        };
        this.aS_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 360.0f);
        this.aS_renamed.setInterpolator(o_renamed);
        this.aS_renamed.setDuration(this.H_renamed);
        this.aS_renamed.setRepeatMode(1);
        this.aS_renamed.setRepeatCount(-1);
        this.aS_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.23
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.control.MainShutterButton.this.setCurrentGlobalAngle(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.aR_renamed = new android.animation.AnimatorSet();
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(360.0f, this.J_renamed);
        valueAnimatorOfFloat.setInterpolator(o_renamed);
        valueAnimatorOfFloat.setDuration(this.I_renamed);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.31
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.control.MainShutterButton.this.setCurrentSweepAngle(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.control.MainShutterButton.32
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.control.MainShutterButton.this.setModeAppearing(false);
            }
        });
        android.animation.ValueAnimator valueAnimatorOfFloat2 = android.animation.ValueAnimator.ofFloat(this.J_renamed, 270.0f);
        valueAnimatorOfFloat2.setInterpolator(o_renamed);
        valueAnimatorOfFloat2.setDuration(this.I_renamed);
        valueAnimatorOfFloat2.setRepeatMode(2);
        valueAnimatorOfFloat2.setRepeatCount(-1);
        valueAnimatorOfFloat2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.33
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.control.MainShutterButton.this.setCurrentSweepAngle(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat2.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.control.MainShutterButton.34
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.control.MainShutterButton.this.o_renamed();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.control.MainShutterButton.this.setModeAppearing(true);
            }
        });
        this.aR_renamed.playSequentially(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.aT_renamed = android.animation.ValueAnimator.ofFloat(360.0f, this.J_renamed);
        this.aT_renamed.setInterpolator(o_renamed);
        this.aT_renamed.setDuration(this.I_renamed);
        this.aT_renamed.setRepeatMode(2);
        this.aT_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.35
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.control.MainShutterButton.this.setCurrentSweepAngle(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.aT_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.control.MainShutterButton.36
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.control.MainShutterButton.this.a_renamed(false, false);
                com.oplus.camera.ui.control.MainShutterButton.this.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.control.MainShutterButton.this.setButtonTypeAndInvalidate(1);
                com.oplus.camera.ui.control.MainShutterButton.this.setEnabled(true);
                com.oplus.camera.ui.control.MainShutterButton.this.setClickable(true);
                if (com.oplus.camera.ui.control.MainShutterButton.this.aS_renamed != null) {
                    com.oplus.camera.ui.control.MainShutterButton.this.aS_renamed.cancel();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.oplus.camera.ui.control.MainShutterButton.this.setButtonTypeAndInvalidate(1);
                com.oplus.camera.ui.control.MainShutterButton.this.setEnabled(true);
                com.oplus.camera.ui.control.MainShutterButton.this.setClickable(true);
                if (com.oplus.camera.ui.control.MainShutterButton.this.aS_renamed != null) {
                    com.oplus.camera.ui.control.MainShutterButton.this.aS_renamed.cancel();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
                com.oplus.camera.ui.control.MainShutterButton.this.o_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModeAppearing(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("MainShutterButton", "setModeAppearing, " + this.aM_renamed + " -> " + z_renamed);
        this.aM_renamed = z_renamed;
    }

    public float getCurrentGlobalAngle() {
        return this.aC_renamed;
    }

    public void setCurrentGlobalAngle(float f_renamed) {
        this.aC_renamed = f_renamed;
        invalidate();
    }

    public float getCurrentSweepAngle() {
        return this.aD_renamed;
    }

    public void setCurrentSweepAngle(float f_renamed) {
        this.aD_renamed = f_renamed;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        com.oplus.camera.e_renamed.a_renamed("MainShutterButton", "onAttachedToWindow, mButtonType: " + this.x_renamed);
        if (4 == this.x_renamed) {
            l_renamed();
        }
        super.onAttachedToWindow();
    }

    @Override // com.oplus.camera.ui.RotateImageView, android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        com.oplus.camera.e_renamed.a_renamed("MainShutterButton", " onDetachedFromWindow, mButtonType: " + this.x_renamed);
        if (4 == this.x_renamed) {
            m_renamed();
        }
        super.onDetachedFromWindow();
    }

    public void setButtonTypeAndInvalidate(com.oplus.camera.ui.control.b_renamed bVar) {
        com.oplus.camera.e_renamed.a_renamed("MainShutterButton", "setButtonTypeAndInvalidate, mShutterButtonType: " + bVar.a_renamed() + ", mInfoInsideColor: " + bVar.b_renamed() + ", mRingShape: " + bVar.d_renamed() + ", mInfoInsideRectColor: " + bVar.e_renamed() + ", mbMoreModeShown: " + bVar.h_renamed());
        android.animation.ObjectAnimator objectAnimator = this.by_renamed;
        if (objectAnimator != null && objectAnimator.isRunning() && 6 == bVar.a_renamed()) {
            this.by_renamed.cancel();
        }
        android.animation.ValueAnimator valueAnimator = this.bM_renamed;
        if (valueAnimator != null && valueAnimator.isRunning() && 22 == bVar.a_renamed()) {
            this.bM_renamed.cancel();
        }
        android.animation.ValueAnimator valueAnimator2 = this.aT_renamed;
        if (valueAnimator2 != null && valueAnimator2.isRunning() && 13 == bVar.a_renamed()) {
            this.aT_renamed.cancel();
        }
        s_renamed();
        t_renamed();
        int i_renamed = this.x_renamed;
        java.lang.String str = this.aI_renamed;
        java.lang.String str2 = this.aJ_renamed;
        boolean z_renamed = this.aO_renamed;
        java.lang.String str3 = this.aK_renamed;
        this.aO_renamed = bVar.g_renamed();
        this.aI_renamed = bVar.b_renamed();
        this.aJ_renamed = bVar.d_renamed();
        this.aK_renamed = bVar.c_renamed();
        this.aw_renamed = bVar.e_renamed();
        setButtonType(bVar.a_renamed());
        setNextButtonType(bVar.i_renamed());
        if (z_renamed != bVar.g_renamed()) {
            k_renamed();
        }
        if (this.x_renamed != 4 && n_renamed()) {
            this.aL_renamed = false;
            r_renamed();
        }
        if (bVar.f_renamed()) {
            if ("button_color_inside_red".equals(this.aI_renamed)) {
                this.an_renamed = 0;
            }
            c_renamed();
        } else {
            this.an_renamed = 255;
        }
        int i2 = this.x_renamed;
        if (3 == i2 || 29 == i2 || 34 == i2) {
            D_renamed();
            return;
        }
        if (4 == i2 && 3 == i_renamed && "button_color_ring_theme".equals(str3)) {
            E_renamed();
            l_renamed();
            return;
        }
        if (32 == this.x_renamed && 4 == i_renamed) {
            F_renamed();
            return;
        }
        int i3 = this.x_renamed;
        if (4 == i3) {
            l_renamed();
            return;
        }
        if (14 == i3) {
            l_renamed();
            return;
        }
        if (5 == i3 && "button_shape_dial_rotate".equals(this.aJ_renamed)) {
            d_renamed();
            return;
        }
        int i4 = this.x_renamed;
        if (16 == i4) {
            H_renamed();
            return;
        }
        if (17 == i4) {
            K_renamed();
            return;
        }
        if (18 == i4) {
            I_renamed();
            return;
        }
        if (19 == i4) {
            J_renamed();
            return;
        }
        if (25 == i4) {
            L_renamed();
            return;
        }
        if (26 == i4 && i_renamed != i4) {
            M_renamed();
            return;
        }
        int i5 = this.x_renamed;
        if (28 == i5) {
            l_renamed();
            return;
        }
        if ((1 == i5 || 23 == i5) && str != null && !str.equals(this.aI_renamed)) {
            d_renamed("button_color_inside_red".equals(this.aI_renamed), bVar.h_renamed() && "button_shape_ring_none".equals(str2) && "button_shape_ring_none".equals(this.aJ_renamed));
            return;
        }
        int i6 = this.x_renamed;
        if (31 == i6 || 36 == i6) {
            G_renamed();
        } else {
            invalidate();
        }
    }

    private void a_renamed(int i_renamed, java.lang.String str) {
        this.aI_renamed = str;
        setButtonTypeAndInvalidate(i_renamed);
    }

    private void d_renamed(int i_renamed, int i2) {
        this.aw_renamed = i2;
        setButtonTypeAndInvalidate(i_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setButtonTypeAndInvalidate(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("MainShutterButton", "setButtonTypeAndInvalidate, buttonType: " + i_renamed);
        s_renamed();
        t_renamed();
        int i2 = this.x_renamed;
        java.lang.String str = this.aK_renamed;
        setButtonType(i_renamed);
        if (this.x_renamed != 4 && n_renamed()) {
            this.aL_renamed = false;
            r_renamed();
        }
        int i3 = this.x_renamed;
        if (3 == i3 || 29 == i3 || 34 == i3) {
            D_renamed();
            return;
        }
        if (4 == i3 && 3 == i2 && "button_color_ring_theme".equals(str)) {
            E_renamed();
            l_renamed();
            return;
        }
        if (32 == this.x_renamed && 4 == i2) {
            F_renamed();
            return;
        }
        int i4 = this.x_renamed;
        if (4 == i4) {
            l_renamed();
            return;
        }
        if (14 == i4) {
            l_renamed();
            return;
        }
        if (5 == i4 && "button_shape_dial_rotate".equals(this.aJ_renamed)) {
            d_renamed();
            return;
        }
        int i5 = this.x_renamed;
        if (25 == i5) {
            L_renamed();
        } else if (31 == i5 || 36 == i5) {
            G_renamed();
        } else {
            invalidate();
        }
    }

    public void a_renamed(com.oplus.camera.ui.control.b_renamed bVar) {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = getShutterButtonInfo();
        if (shutterButtonInfo == null) {
            com.oplus.camera.e_renamed.f_renamed("MainShutterButton", "switchToModeType, null == currentButtonInfo");
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("MainShutterButton", "switchToModeType, before shutterButtonType: " + shutterButtonInfo.a_renamed() + ", before insideColor: " + shutterButtonInfo.b_renamed() + ", before ringShape: " + shutterButtonInfo.d_renamed() + " -> after shutterButtonType: " + bVar.a_renamed() + ", after insideColor: " + bVar.b_renamed() + ", after ringShape: " + bVar.d_renamed());
        setButtonTypeAndInvalidate(bVar);
    }

    public boolean b_renamed(com.oplus.camera.ui.control.b_renamed bVar) {
        return bVar.a_renamed() == this.x_renamed && bVar.b_renamed().equals(this.aI_renamed) && bVar.d_renamed().equals(this.aJ_renamed);
    }

    private void r_renamed() {
        android.animation.ValueAnimator valueAnimator = this.aS_renamed;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        android.animation.AnimatorSet animatorSet = this.aR_renamed;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        invalidate();
    }

    private void s_renamed() {
        android.animation.ValueAnimator valueAnimator = this.bB_renamed;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.bB_renamed.cancel();
    }

    private void t_renamed() {
        android.animation.ValueAnimator valueAnimator = this.bR_renamed;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.bR_renamed.cancel();
    }

    private void u_renamed() {
        android.animation.ValueAnimator valueAnimator = this.bE_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.bE_renamed.cancel();
        }
        android.animation.ValueAnimator valueAnimator2 = this.bF_renamed;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.bF_renamed.cancel();
    }

    public void setButtonType(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("MainShutterButton", "setButtonType, type: " + this.x_renamed + " => " + i_renamed);
        this.x_renamed = i_renamed;
        if (12 == this.x_renamed) {
            this.ak_renamed = 0;
        }
        if (this.G_renamed != 0) {
            this.G_renamed = 0;
        }
    }

    public void setNextButtonType(int i_renamed) {
        this.y_renamed = i_renamed;
    }

    public void a_renamed(int i_renamed, java.lang.String str, int i2) {
        com.oplus.camera.e_renamed.a_renamed("MainShutterButton", "setButtonType, insideRectColor: " + this.aw_renamed + " => " + i2 + ", inSideColor: " + this.aI_renamed + " => " + str);
        this.aI_renamed = str;
        this.aw_renamed = i2;
        setButtonType(i_renamed);
    }

    public int getButtonType() {
        return this.x_renamed;
    }

    public java.lang.String getInsideColor() {
        return this.aI_renamed;
    }

    public java.lang.String getRingShape() {
        return this.aJ_renamed;
    }

    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        return new com.oplus.camera.ui.control.b_renamed(this.x_renamed, this.aI_renamed);
    }

    public void a_renamed() {
        v_renamed();
        w_renamed();
        C_renamed();
        x_renamed();
    }

    private void v_renamed() {
        this.bb_renamed = null;
        this.bd_renamed = null;
        this.bf_renamed = null;
        this.bh_renamed = null;
        this.bi_renamed = null;
        this.bj_renamed = null;
        this.bk_renamed = null;
    }

    private void w_renamed() {
        this.aS_renamed = null;
        this.aR_renamed = null;
        this.bv_renamed = null;
        this.bw_renamed = null;
        this.bx_renamed = null;
    }

    private void x_renamed() {
        android.graphics.Bitmap bitmap = this.aV_renamed;
        if (bitmap != null) {
            bitmap.recycle();
            this.aV_renamed = null;
        }
        android.graphics.Bitmap bitmap2 = this.aW_renamed;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.aW_renamed = null;
        }
        android.graphics.Bitmap bitmap3 = this.aX_renamed;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.aX_renamed = null;
        }
        android.graphics.Bitmap bitmap4 = this.aY_renamed;
        if (bitmap4 != null) {
            bitmap4.recycle();
            this.aY_renamed = null;
        }
        this.aU_renamed = null;
    }

    public void b_renamed() {
        android.animation.ObjectAnimator objectAnimator = this.bz_renamed;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.M_renamed = 0;
        }
        android.animation.ObjectAnimator objectAnimator2 = this.by_renamed;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    private void y_renamed() {
        android.content.res.Resources resources = getResources();
        this.ap_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_line_height);
        this.at_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_long_line_height);
        this.av_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_long_line_padding);
        int i_renamed = this.av_renamed;
        this.ax_renamed = (i_renamed * 2) + this.at_renamed;
        int i2 = this.A_renamed;
        int i3 = this.ax_renamed;
        this.B_renamed = i2 - i3;
        this.ar_renamed = i_renamed;
        int i4 = this.ap_renamed;
        this.aq_renamed = (i3 - i4) - this.ar_renamed;
        this.as_renamed = (i3 - i4) / 2;
        this.bx_renamed = new android.util.Property<com.oplus.camera.ui.control.MainShutterButton, java.lang.Integer>(java.lang.Integer.class, "dial") { // from class: com.oplus.camera.ui.control.MainShutterButton.2
            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public java.lang.Integer get(com.oplus.camera.ui.control.MainShutterButton mainShutterButton) {
                return java.lang.Integer.valueOf(mainShutterButton.getDialValue());
            }

            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public void set(com.oplus.camera.ui.control.MainShutterButton mainShutterButton, java.lang.Integer num) {
                mainShutterButton.setDialValue(num.intValue());
            }
        };
        this.by_renamed = android.animation.ObjectAnimator.ofInt(this, this.bx_renamed, 0, 60);
        this.by_renamed.setInterpolator(new android.view.animation.LinearInterpolator());
        this.by_renamed.setDuration(600L);
        this.by_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.3
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
                com.oplus.camera.ui.control.MainShutterButton.this.F_renamed = 0;
                com.oplus.camera.e_renamed.a_renamed("MainShutterButton", "onAnimationEnd, mRingDotPrepareAnimator end, mButtonType: " + com.oplus.camera.ui.control.MainShutterButton.this.x_renamed);
                if (com.oplus.camera.ui.control.MainShutterButton.this.bz_renamed != null) {
                    if ((2 == com.oplus.camera.ui.control.MainShutterButton.this.x_renamed || 5 == com.oplus.camera.ui.control.MainShutterButton.this.x_renamed) && "button_shape_dial_rotate".equals(com.oplus.camera.ui.control.MainShutterButton.this.aJ_renamed)) {
                        com.oplus.camera.ui.control.MainShutterButton.this.bz_renamed.setCurrentFraction(0.5f);
                        com.oplus.camera.ui.control.MainShutterButton.this.bz_renamed.start();
                        if (2 != com.oplus.camera.ui.control.MainShutterButton.this.x_renamed) {
                            com.oplus.camera.ui.control.MainShutterButton.this.setButtonType(2);
                        }
                    }
                }
            }
        });
        this.bB_renamed = android.animation.ValueAnimator.ofInt(0, 360);
        this.bB_renamed.setInterpolator(new android.view.animation.LinearInterpolator());
        this.bB_renamed.setDuration(this.L_renamed);
        this.bB_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.control.MainShutterButton.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.control.MainShutterButton.this.k_renamed();
            }
        });
        this.bB_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                int iIntValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                if (com.oplus.camera.ui.control.MainShutterButton.this.K_renamed != iIntValue) {
                    com.oplus.camera.ui.control.MainShutterButton.this.K_renamed = iIntValue;
                    com.oplus.camera.ui.control.MainShutterButton.this.invalidate();
                }
                if (360 != iIntValue || 1 >= com.oplus.camera.ui.control.MainShutterButton.this.y_renamed) {
                    return;
                }
                com.oplus.camera.ui.control.MainShutterButton.this.setButtonTypeAndInvalidate(4);
            }
        });
        this.bC_renamed = android.animation.ValueAnimator.ofInt(255, 77);
        this.bC_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        this.bC_renamed.setDuration(180L);
        this.bC_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.control.MainShutterButton.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.control.MainShutterButton.this.ay_renamed = 255;
            }
        });
        this.bC_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                if (((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue() != com.oplus.camera.ui.control.MainShutterButton.this.ay_renamed) {
                    com.oplus.camera.ui.control.MainShutterButton.this.ay_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                    com.oplus.camera.ui.control.MainShutterButton.this.invalidate();
                }
            }
        });
        this.bD_renamed = android.animation.ValueAnimator.ofObject(new android.animation.ArgbEvaluator(), java.lang.Integer.valueOf(this.am_renamed), java.lang.Integer.valueOf(this.al_renamed));
        this.bD_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        this.bD_renamed.setDuration(250L);
        this.bD_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.control.MainShutterButton.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.control.MainShutterButton mainShutterButton = com.oplus.camera.ui.control.MainShutterButton.this;
                mainShutterButton.az_renamed = mainShutterButton.am_renamed;
            }
        });
        this.bD_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.-$$Lambda$MainShutterButton$kAPST3TKwqPRkOCehgR5ePHHd_M
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.a_renamed(valueAnimator);
            }
        });
        this.bR_renamed = android.animation.ValueAnimator.ofInt(0, 360);
        this.bR_renamed.setInterpolator(new android.view.animation.LinearInterpolator());
        this.bR_renamed.setDuration(this.L_renamed);
        this.bR_renamed.setRepeatCount(-1);
        this.bR_renamed.setRepeatMode(1);
        this.bR_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.control.MainShutterButton.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                super.onAnimationStart(animator);
                if (com.oplus.camera.util.Util.ao_renamed()) {
                    com.oplus.camera.ui.control.MainShutterButton.this.aQ_renamed = false;
                } else {
                    com.oplus.camera.ui.control.MainShutterButton.this.bm_renamed.setAlpha(128);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
                super.onAnimationRepeat(animator);
                if (!com.oplus.camera.util.Util.ao_renamed()) {
                    if (128 == com.oplus.camera.ui.control.MainShutterButton.this.bm_renamed.getAlpha()) {
                        com.oplus.camera.ui.control.MainShutterButton.this.bm_renamed.setAlpha(255);
                        com.oplus.camera.ui.control.MainShutterButton.this.bh_renamed.setColor(-7829368);
                        return;
                    } else {
                        com.oplus.camera.ui.control.MainShutterButton.this.bm_renamed.setAlpha(128);
                        com.oplus.camera.ui.control.MainShutterButton.this.bh_renamed.setColor(-1);
                        return;
                    }
                }
                com.oplus.camera.ui.control.MainShutterButton.this.aQ_renamed = !r1.aQ_renamed;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                super.onAnimationEnd(animator);
                if (com.oplus.camera.util.Util.ao_renamed()) {
                    com.oplus.camera.ui.control.MainShutterButton.this.aQ_renamed = false;
                }
                com.oplus.camera.ui.control.MainShutterButton.this.k_renamed();
            }
        });
        this.bR_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                int iIntValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                if (com.oplus.camera.ui.control.MainShutterButton.this.K_renamed != iIntValue) {
                    com.oplus.camera.ui.control.MainShutterButton.this.K_renamed = iIntValue;
                    com.oplus.camera.ui.control.MainShutterButton.this.invalidate();
                }
            }
        });
        this.bz_renamed = android.animation.ObjectAnimator.ofInt(this, this.bx_renamed, 0, 120);
        this.bz_renamed.setRepeatMode(1);
        this.bz_renamed.setRepeatCount(-1);
        this.bz_renamed.setInterpolator(new android.view.animation.LinearInterpolator());
        this.bz_renamed.setDuration(12000L);
        this.bz_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.11
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
                com.oplus.camera.ui.control.MainShutterButton.this.B_renamed();
                com.oplus.camera.ui.control.MainShutterButton.this.bA_renamed.start();
            }
        });
        this.bA_renamed = android.animation.ObjectAnimator.ofInt(this, this.bx_renamed, 0, 60);
        this.bA_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.576f, 0.16f, 0.421f, 0.853f));
        this.bA_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.13
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
                com.oplus.camera.ui.control.MainShutterButton.this.M_renamed = 0;
                com.oplus.camera.ui.control.MainShutterButton.this.G_renamed = 0;
                if (6 == com.oplus.camera.ui.control.MainShutterButton.this.x_renamed && "button_shape_dial_rotate".equals(com.oplus.camera.ui.control.MainShutterButton.this.aJ_renamed)) {
                    com.oplus.camera.ui.control.MainShutterButton.this.setButtonType(1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.animation.ValueAnimator valueAnimator) {
        this.az_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
    }

    private void z_renamed() {
        this.bU_renamed = new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.control.MainShutterButton.this.aA_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                float f_renamed = com.oplus.camera.ui.control.MainShutterButton.this.aA_renamed - com.oplus.camera.ui.control.MainShutterButton.this.A_renamed;
                if (com.oplus.camera.ui.control.MainShutterButton.this.bd_renamed == null) {
                    float f2 = f_renamed / 2.0f;
                    com.oplus.camera.ui.control.MainShutterButton.this.bd_renamed = new android.graphics.RectF(((r0.getWidth() / 2) - com.oplus.camera.ui.control.MainShutterButton.this.aA_renamed) + f2, ((com.oplus.camera.ui.control.MainShutterButton.this.getHeight() / 2) - com.oplus.camera.ui.control.MainShutterButton.this.aA_renamed) + f2, ((com.oplus.camera.ui.control.MainShutterButton.this.getWidth() / 2) + com.oplus.camera.ui.control.MainShutterButton.this.aA_renamed) - f2, ((com.oplus.camera.ui.control.MainShutterButton.this.getWidth() / 2) + com.oplus.camera.ui.control.MainShutterButton.this.aA_renamed) - f2);
                } else {
                    float f3 = f_renamed / 2.0f;
                    com.oplus.camera.ui.control.MainShutterButton.this.bd_renamed.set(((com.oplus.camera.ui.control.MainShutterButton.this.getWidth() / 2) - com.oplus.camera.ui.control.MainShutterButton.this.aA_renamed) + f3, ((com.oplus.camera.ui.control.MainShutterButton.this.getHeight() / 2) - com.oplus.camera.ui.control.MainShutterButton.this.aA_renamed) + f3, ((com.oplus.camera.ui.control.MainShutterButton.this.getWidth() / 2) + com.oplus.camera.ui.control.MainShutterButton.this.aA_renamed) - f3, ((com.oplus.camera.ui.control.MainShutterButton.this.getWidth() / 2) + com.oplus.camera.ui.control.MainShutterButton.this.aA_renamed) - f3);
                }
                com.oplus.camera.ui.control.MainShutterButton.this.bm_renamed.setStrokeWidth(f_renamed);
                com.oplus.camera.ui.control.MainShutterButton.this.O_renamed = f_renamed;
                if (com.oplus.camera.ui.control.MainShutterButton.this.bh_renamed != null) {
                    com.oplus.camera.ui.control.MainShutterButton.this.bh_renamed.setStrokeWidth(f_renamed);
                }
                com.oplus.camera.ui.control.MainShutterButton.this.invalidate();
            }
        };
        this.bE_renamed = android.animation.ValueAnimator.ofFloat(this.z_renamed, this.N_renamed);
        this.bE_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f));
        this.bE_renamed.setDuration(100L);
        this.bE_renamed.addUpdateListener(this.bU_renamed);
        this.bF_renamed = android.animation.ValueAnimator.ofFloat(this.N_renamed, this.z_renamed);
        this.bF_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f));
        this.bF_renamed.setDuration(100L);
        this.bF_renamed.addUpdateListener(this.bU_renamed);
    }

    private void A_renamed() {
        this.bI_renamed = android.animation.ValueAnimator.ofInt(0, 255);
        this.bI_renamed.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(getContext(), com.oplus.camera.R_renamed.anim.accelerate_decelerate_path_interpolator));
        this.bI_renamed.setDuration(440L);
        this.bI_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.control.MainShutterButton.this.an_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                com.oplus.camera.ui.control.MainShutterButton.this.invalidate();
            }
        });
    }

    public void c_renamed() {
        if (this.bI_renamed == null) {
            A_renamed();
        }
        android.animation.ValueAnimator valueAnimator = this.bI_renamed;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B_renamed() {
        this.bA_renamed.setIntValues(this.M_renamed, 120);
        this.bA_renamed.setDuration(((120 - this.M_renamed) * 800) / 120);
    }

    private void C_renamed() {
        this.by_renamed = null;
        this.bz_renamed = null;
        this.bA_renamed = null;
        this.bB_renamed = null;
        this.bE_renamed = null;
        this.bF_renamed = null;
        this.bR_renamed = null;
        android.animation.ValueAnimator valueAnimator = this.bG_renamed;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.bG_renamed = null;
        }
        android.animation.ValueAnimator valueAnimator2 = this.bH_renamed;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.bH_renamed = null;
        }
        android.animation.ValueAnimator valueAnimator3 = this.bI_renamed;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.bI_renamed = null;
        }
        android.animation.ValueAnimator valueAnimator4 = this.aT_renamed;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
            this.aT_renamed = null;
        }
    }

    public int getDialValue() {
        return this.M_renamed;
    }

    public void setDialValue(int i_renamed) {
        this.M_renamed = i_renamed;
        invalidate();
    }

    public void d_renamed() {
        android.animation.ObjectAnimator objectAnimator = this.by_renamed;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    private void D_renamed() {
        if (this.bB_renamed != null) {
            long j_renamed = com.oplus.camera.util.Util.ao_renamed() ? (long) (this.ao_renamed + 133.36f) : 133L;
            this.ao_renamed = 0;
            this.bB_renamed.setDuration(java.lang.Math.max(0L, this.L_renamed - j_renamed));
            this.bB_renamed.start();
        }
        android.animation.ValueAnimator valueAnimator = this.bC_renamed;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    private void E_renamed() {
        android.animation.ValueAnimator valueAnimator = this.bD_renamed;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    private void F_renamed() {
        android.animation.ValueAnimator valueAnimator = this.aS_renamed;
        if (valueAnimator != null) {
            valueAnimator.setCurrentFraction(valueAnimator.getAnimatedFraction());
            this.aS_renamed.start();
        }
        if (this.aT_renamed != null) {
            float f_renamed = this.aM_renamed ? this.J_renamed : 360.0f;
            float f2 = this.aM_renamed ? 360.0f : this.J_renamed;
            this.aT_renamed.setRepeatCount(!this.aM_renamed ? 1 : 0);
            this.aT_renamed.setFloatValues(f_renamed, f2);
            this.aT_renamed.setCurrentFraction(a_renamed(this.aT_renamed.getInterpolator(), this.aD_renamed, f_renamed, f2));
            this.aT_renamed.start();
        }
    }

    private float a_renamed(android.animation.TimeInterpolator timeInterpolator, float f_renamed, float f2, float f3) {
        if (timeInterpolator == null) {
            return 0.0f;
        }
        float f4 = f3 - f2;
        float f5 = Float.MAX_VALUE;
        float f6 = 0.0f;
        for (float f7 = 0.0f; f7 < 1.0f; f7 += 0.02f) {
            float fAbs = java.lang.Math.abs(f_renamed - ((timeInterpolator.getInterpolation(f7) * f4) + f2));
            if (fAbs < f5) {
                f6 = f7;
                f5 = fAbs;
            }
        }
        return f6;
    }

    private void G_renamed() {
        android.animation.ValueAnimator valueAnimator = this.bR_renamed;
        if (valueAnimator != null) {
            valueAnimator.setDuration(this.L_renamed);
            this.bR_renamed.start();
        }
    }

    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("MainShutterButton", "pauseFastVideoDialAnimator");
        android.animation.ObjectAnimator objectAnimator = this.bz_renamed;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.bz_renamed.pause();
    }

    public void f_renamed() {
        android.animation.ValueAnimator valueAnimator = this.bB_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.bB_renamed.resume();
        }
        android.animation.ValueAnimator valueAnimator2 = this.bC_renamed;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.bC_renamed.resume();
    }

    public void g_renamed() {
        android.animation.ValueAnimator valueAnimator = this.bB_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.bB_renamed.pause();
        }
        android.animation.ValueAnimator valueAnimator2 = this.bC_renamed;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.bC_renamed.pause();
    }

    public void h_renamed() {
        com.oplus.camera.e_renamed.a_renamed("MainShutterButton", "resumeFastVideoDialAnimator");
        android.animation.ObjectAnimator objectAnimator = this.bz_renamed;
        if (objectAnimator != null) {
            objectAnimator.resume();
        }
    }

    public void setShutterButtonTime(int i_renamed) {
        this.L_renamed = i_renamed;
    }

    public void setShutterButtonProgress(float f_renamed) {
        if (this.x_renamed != 12) {
            com.oplus.camera.e_renamed.f_renamed("MainShutterButton", "setShutterButtonProgress, button type is_renamed error, mButtonType: " + this.x_renamed);
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("MainShutterButton", "setShutterButtonProgress, progress: " + f_renamed);
        this.ak_renamed = (int) (f_renamed * 360.0f);
        if (this.ak_renamed > 360) {
            this.ak_renamed = 360;
        }
        invalidate();
    }

    private void H_renamed() {
        if (this.bJ_renamed == null) {
            this.bJ_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            this.bJ_renamed.setDuration(300L);
            this.bJ_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.17f, 0.0f, 0.83f, 1.0f));
            this.bJ_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.16
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.ui.control.MainShutterButton.this.aF_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    com.oplus.camera.ui.control.MainShutterButton.this.invalidate();
                }
            });
            this.bJ_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.17
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
                    com.oplus.camera.ui.control.MainShutterButton.this.setButtonTypeAndInvalidate(20);
                }
            });
        }
        this.bJ_renamed.start();
    }

    private void I_renamed() {
        if (this.bL_renamed == null) {
            this.bL_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            this.bL_renamed.setDuration(300L);
            this.bL_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
            this.bL_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.18
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.ui.control.MainShutterButton.this.aF_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    com.oplus.camera.ui.control.MainShutterButton.this.invalidate();
                }
            });
            this.bL_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.19
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
                    com.oplus.camera.ui.control.MainShutterButton.this.setButtonTypeAndInvalidate(1);
                }
            });
        }
        this.bL_renamed.start();
    }

    private void J_renamed() {
        if (this.bM_renamed == null) {
            this.bM_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            this.bM_renamed.setDuration(300L);
            this.bM_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
            this.bM_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.20
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.ui.control.MainShutterButton.this.aF_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    com.oplus.camera.ui.control.MainShutterButton.this.invalidate();
                }
            });
            this.bM_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.21
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
                    com.oplus.camera.ui.control.MainShutterButton.this.setButtonTypeAndInvalidate(1);
                }
            });
        }
        this.bM_renamed.start();
    }

    private void K_renamed() {
        if (this.bK_renamed == null) {
            this.bK_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            this.bK_renamed.setDuration(300L);
            this.bK_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
            this.bK_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.22
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.ui.control.MainShutterButton.this.aF_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    com.oplus.camera.ui.control.MainShutterButton.this.invalidate();
                }
            });
            this.bK_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.24
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
                    com.oplus.camera.ui.control.MainShutterButton.this.setButtonTypeAndInvalidate(21);
                }
            });
        }
        this.bK_renamed.start();
    }

    private void d_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("MainShutterButton", "startInsideRedAnimator, show: " + z_renamed + ", mInsideRedScaleValue: " + this.aG_renamed + ", mInsideRedAlphaValue: " + this.aH_renamed + ", needAnimation: " + z2 + ", visible: " + getVisibility());
        if (getVisibility() != 0 || !z2) {
            this.aG_renamed = z_renamed ? 1.0f : 0.7f;
            this.aH_renamed = z_renamed ? 1.0f : 0.0f;
            return;
        }
        android.animation.ValueAnimator valueAnimator = this.bN_renamed;
        if (valueAnimator == null) {
            this.bN_renamed = new android.animation.ValueAnimator();
            this.bN_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
            this.bN_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.25
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                    com.oplus.camera.ui.control.MainShutterButton.this.aG_renamed = ((java.lang.Float) valueAnimator2.getAnimatedValue()).floatValue();
                    com.oplus.camera.ui.control.MainShutterButton.this.invalidate();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        android.animation.ValueAnimator valueAnimator2 = this.bO_renamed;
        if (valueAnimator2 == null) {
            this.bO_renamed = new android.animation.ValueAnimator();
            this.bO_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
            this.bO_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.26
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator3) {
                    com.oplus.camera.ui.control.MainShutterButton.this.aH_renamed = ((java.lang.Float) valueAnimator3.getAnimatedValue()).floatValue();
                }
            });
        } else {
            valueAnimator2.cancel();
        }
        if (z_renamed) {
            this.bN_renamed.setFloatValues(this.aG_renamed, 1.0f);
            this.bO_renamed.setFloatValues(this.aH_renamed, 1.0f);
        } else {
            this.bN_renamed.setFloatValues(this.aG_renamed, 0.7f);
            this.bO_renamed.setFloatValues(this.aH_renamed, 0.0f);
        }
        this.bN_renamed.setDuration(500L);
        this.bO_renamed.setDuration(250L);
        this.bN_renamed.start();
        this.bO_renamed.start();
    }

    private void L_renamed() {
        android.animation.ValueAnimator valueAnimator = this.bP_renamed;
        if (valueAnimator == null) {
            this.bP_renamed = android.animation.ValueAnimator.ofFloat(this.z_renamed, 0.0f);
            this.bP_renamed.setInterpolator(new android.view.animation.DecelerateInterpolator(1.0f));
            this.bP_renamed.setDuration(300L);
            this.bP_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.27
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                    com.oplus.camera.ui.control.MainShutterButton.this.C_renamed = ((java.lang.Float) valueAnimator2.getAnimatedValue()).floatValue();
                    com.oplus.camera.ui.control.MainShutterButton.this.invalidate();
                }
            });
            this.bP_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.28
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
                    int i_renamed = com.oplus.camera.ui.control.MainShutterButton.this.aP_renamed ? 29 : 28;
                    com.oplus.camera.ui.control.MainShutterButton.this.aP_renamed = false;
                    if (25 == com.oplus.camera.ui.control.MainShutterButton.this.x_renamed) {
                        com.oplus.camera.ui.control.MainShutterButton.this.ao_renamed = 300;
                        com.oplus.camera.ui.control.MainShutterButton.this.setButtonTypeAndInvalidate(new com.oplus.camera.ui.control.b_renamed(i_renamed));
                    }
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.bP_renamed.start();
    }

    private void M_renamed() {
        android.animation.ValueAnimator valueAnimator = this.bQ_renamed;
        if (valueAnimator == null) {
            this.bQ_renamed = android.animation.ValueAnimator.ofFloat(0.0f, this.z_renamed);
            this.bQ_renamed.setInterpolator(new android.view.animation.DecelerateInterpolator(1.0f));
            this.bQ_renamed.setDuration(300L);
            this.bQ_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.29
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                    com.oplus.camera.ui.control.MainShutterButton.this.C_renamed = ((java.lang.Float) valueAnimator2.getAnimatedValue()).floatValue();
                    com.oplus.camera.ui.control.MainShutterButton.this.invalidate();
                }
            });
            this.bQ_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.30
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    com.oplus.camera.ui.control.MainShutterButton.this.setButtonType(26);
                    com.oplus.camera.ui.control.MainShutterButton.this.invalidate();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.control.MainShutterButton.this.setButtonType(23);
                    com.oplus.camera.ui.control.MainShutterButton.this.invalidate();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.bQ_renamed.start();
    }

    private void b_renamed(android.graphics.Canvas canvas, boolean z_renamed) {
        canvas.save();
        canvas.translate(getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.rotate(180.0f);
        int i_renamed = 0;
        while (i_renamed < 60) {
            if (!z_renamed) {
                int i2 = this.B_renamed;
                int i3 = this.as_renamed;
                canvas.drawLine(0.0f, i2 + i3, 0.0f, i2 + i3 + this.ap_renamed, this.bn_renamed);
            } else if (i_renamed % 5 == 0) {
                int i4 = this.B_renamed;
                int i5 = this.av_renamed;
                canvas.drawLine(0.0f, i4 + i5, 0.0f, i4 + i5 + this.at_renamed, this.bn_renamed);
            } else {
                int i6 = this.M_renamed;
                if (i6 <= 60 || i6 == 0) {
                    int i7 = i_renamed == this.M_renamed ? this.av_renamed : this.aq_renamed;
                    int i8 = i_renamed == this.M_renamed ? this.at_renamed : this.ap_renamed;
                    if (i_renamed >= this.M_renamed) {
                        int i9 = this.B_renamed;
                        canvas.drawLine(0.0f, i9 + i7, 0.0f, i9 + i7 + i8, this.bn_renamed);
                    }
                } else {
                    int i10 = i_renamed == i6 + (-60) ? this.av_renamed : this.aq_renamed;
                    int i11 = i_renamed == this.M_renamed - 60 ? this.at_renamed : this.ap_renamed;
                    int i12 = this.M_renamed;
                    if (i_renamed <= i12 - 60 || i12 == 0) {
                        int i13 = this.B_renamed;
                        canvas.drawLine(0.0f, i13 + i10, 0.0f, i13 + i10 + i11, this.bn_renamed);
                    }
                }
            }
            canvas.rotate(6.0f, 0.0f, 0.0f);
            i_renamed++;
        }
        canvas.restore();
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        if ("button_shape_ring_none".equals(this.aJ_renamed)) {
            return;
        }
        int i_renamed = this.x_renamed;
        if (i_renamed != 9) {
            if (i_renamed != 24) {
                if (i_renamed != 31) {
                    switch (i_renamed) {
                        case 6:
                            if ("button_shape_dial_still".equals(this.aJ_renamed)) {
                                this.aN_renamed = false;
                                b_renamed(canvas, this.aN_renamed);
                                break;
                            } else if ("button_shape_dial_rotate".equals(this.aJ_renamed)) {
                                android.animation.ObjectAnimator objectAnimator = this.bz_renamed;
                                if (objectAnimator != null && objectAnimator.isRunning()) {
                                    this.bz_renamed.cancel();
                                }
                                this.aN_renamed = true;
                                b_renamed(canvas, this.aN_renamed);
                                break;
                            }
                            break;
                    }
                    return;
                }
                if ("button_shape_dial_still".equals(this.aJ_renamed)) {
                    this.aN_renamed = false;
                    b_renamed(canvas, this.aN_renamed);
                    return;
                }
                return;
            }
            android.graphics.Bitmap bitmap = this.ba_renamed;
            if (bitmap == null) {
                this.ba_renamed = a_renamed(bitmap, com.oplus.camera.R_renamed.drawable.countdown_cancel_button, 0.35f);
            }
            b_renamed(canvas, this.ba_renamed);
            return;
        }
        if ("button_shape_dial_still".equals(this.aJ_renamed)) {
            this.aN_renamed = false;
            b_renamed(canvas, this.aN_renamed);
            return;
        }
        if ("button_shape_dial_rotate".equals(this.aJ_renamed)) {
            this.aN_renamed = true;
            b_renamed(canvas, this.aN_renamed);
            return;
        }
        if ("button_shape_countdown_ten_seconds".equals(this.aJ_renamed)) {
            android.graphics.Bitmap bitmap2 = this.aW_renamed;
            if (bitmap2 == null) {
                this.aW_renamed = a_renamed(bitmap2, com.oplus.camera.R_renamed.drawable.countdown_10s_selector);
            }
            a_renamed(canvas, this.aW_renamed);
            return;
        }
        if ("button_shape_countdown_three_seconds".equals(this.aJ_renamed)) {
            android.graphics.Bitmap bitmap3 = this.aV_renamed;
            if (bitmap3 == null) {
                this.aV_renamed = a_renamed(bitmap3, com.oplus.camera.R_renamed.drawable.countdown_3s_selector);
            }
            a_renamed(canvas, this.aV_renamed);
            return;
        }
        if ("button_shape_next_step".equals(this.aJ_renamed)) {
            android.graphics.Bitmap bitmap4 = this.aX_renamed;
            if (bitmap4 == null) {
                this.aX_renamed = a_renamed(bitmap4, com.oplus.camera.R_renamed.drawable.ic_next_step);
            }
            c_renamed(canvas, this.aX_renamed);
            return;
        }
        if ("button_shape_complete".equals(this.aJ_renamed)) {
            android.graphics.Bitmap bitmap5 = this.aY_renamed;
            if (bitmap5 == null) {
                this.aY_renamed = a_renamed(bitmap5, com.oplus.camera.R_renamed.drawable.ic_complete);
            }
            c_renamed(canvas, this.aY_renamed);
        }
    }

    public int getShutterPadding() {
        return (getMeasuredHeight() / 2) - this.z_renamed;
    }

    private android.graphics.Shader e_renamed(int i_renamed, int i2) {
        return new android.graphics.LinearGradient(0.0f, 0.0f, 0.0f, getHeight() * 1.0f, i_renamed, i2, android.graphics.Shader.TileMode.CLAMP);
    }
}
