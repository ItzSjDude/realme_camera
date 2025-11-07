package com.oplus.camera.ui.preview;

/* compiled from: ZoomSeekBar.java */
/* loaded from: classes2.dex */
public abstract class ai_renamed extends com.oplus.camera.ui.b_renamed implements com.oplus.camera.ui.a_renamed.BackgroundSplitManager_2, com.oplus.camera.ui.inverse.a_renamed {
    protected static final int ao_renamed = (int) (com.oplus.camera.util.Util.getScreenWidth() * 0.104f);
    private static final android.view.animation.PathInterpolator di_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    protected boolean aA_renamed;
    protected boolean aB_renamed;
    protected int aC_renamed;
    protected int aD_renamed;
    protected int aE_renamed;
    protected int aF_renamed;
    protected int aG_renamed;
    protected int aH_renamed;
    protected int aI_renamed;
    protected int aJ_renamed;
    protected int aK_renamed;
    protected int aL_renamed;
    protected int aM_renamed;
    protected int aN_renamed;
    protected int aO_renamed;
    protected int aP_renamed;
    protected int aQ_renamed;
    protected float aR_renamed;
    protected float aS_renamed;
    protected int aT_renamed;
    protected int aU_renamed;
    protected int aV_renamed;
    protected int aW_renamed;
    protected int aX_renamed;
    protected int aY_renamed;
    protected float aZ_renamed;
    protected android.view.VelocityTracker ap_renamed;
    protected int aq_renamed;
    protected int ar_renamed;
    protected int as_renamed;
    protected float at_renamed;
    protected float au_renamed;
    protected float av_renamed;
    protected android.content.Context aw_renamed;
    protected android.content.res.Resources ax_renamed;
    protected boolean ay_renamed;
    protected boolean az_renamed;
    protected android.graphics.Paint bA_renamed;
    protected android.graphics.Paint bB_renamed;
    protected int bC_renamed;
    protected android.graphics.Paint bD_renamed;
    protected int bE_renamed;
    protected android.graphics.Paint bF_renamed;
    protected android.graphics.Paint bG_renamed;
    protected android.graphics.Paint bH_renamed;
    protected android.text.TextPaint bI_renamed;
    protected int bJ_renamed;
    protected java.util.ArrayList<java.lang.Float> bK_renamed;
    protected float[] bL_renamed;
    protected int bM_renamed;
    protected android.view.GestureDetector bN_renamed;
    protected com.oplus.camera.ui.preview.ag_renamed bO_renamed;
    protected com.oplus.camera.ah_renamed bP_renamed;
    protected android.graphics.Paint bQ_renamed;
    protected android.graphics.Paint bR_renamed;
    protected android.graphics.Paint bS_renamed;
    protected boolean bT_renamed;
    protected int bU_renamed;
    protected int bV_renamed;
    protected int bW_renamed;
    protected int bX_renamed;
    protected int bY_renamed;
    protected int bZ_renamed;
    protected float ba_renamed;
    protected int bb_renamed;
    protected int bc_renamed;
    protected int bd_renamed;
    protected float be_renamed;
    protected float bf_renamed;
    protected boolean bg_renamed;
    protected boolean bh_renamed;
    protected boolean bi_renamed;
    protected boolean bj_renamed;
    protected boolean bk_renamed;
    protected boolean bl_renamed;
    protected boolean bm_renamed;
    protected boolean bn_renamed;
    protected boolean bo_renamed;
    protected boolean bp_renamed;
    protected int bq_renamed;
    protected java.lang.String br_renamed;
    protected float bs_renamed;
    protected float bt_renamed;
    protected float bu_renamed;
    protected java.util.ArrayList<java.lang.Float> bv_renamed;
    protected java.util.ArrayList<java.lang.Float> bw_renamed;
    protected java.util.ArrayList<java.lang.Float> bx_renamed;
    protected java.util.ArrayList<java.lang.Integer> by_renamed;
    protected android.graphics.Paint bz_renamed;
    protected float cA_renamed;
    protected float cB_renamed;
    protected float cC_renamed;
    protected float cD_renamed;
    protected java.util.ArrayList<java.lang.Float> cE_renamed;
    protected android.graphics.Bitmap cF_renamed;
    protected android.graphics.Bitmap cG_renamed;
    protected android.graphics.Canvas cH_renamed;
    protected android.graphics.Canvas cI_renamed;
    protected java.text.DecimalFormat cJ_renamed;
    protected java.text.DecimalFormat cK_renamed;
    protected float cL_renamed;
    protected float cM_renamed;
    protected float cN_renamed;
    protected float cO_renamed;
    protected float cP_renamed;
    protected float cQ_renamed;
    protected float cR_renamed;
    protected boolean cS_renamed;
    protected boolean cT_renamed;
    protected int cU_renamed;
    protected java.lang.String cV_renamed;
    protected java.lang.String cW_renamed;
    protected java.lang.String cX_renamed;
    protected java.lang.String cY_renamed;
    protected float cZ_renamed;
    protected int ca_renamed;
    protected android.graphics.RectF cb_renamed;
    protected android.graphics.RectF cc_renamed;
    protected java.util.Map<com.oplus.camera.ui.preview.ai_renamed.b_renamed, android.graphics.Bitmap> cd_renamed;
    protected java.util.Map<com.oplus.camera.ui.preview.ai_renamed.b_renamed, android.graphics.Bitmap> ce_renamed;
    protected float cf_renamed;
    protected float cg_renamed;
    protected float ch_renamed;
    protected float ci_renamed;
    protected float cj_renamed;
    protected float ck_renamed;
    protected float cl_renamed;
    protected float cm_renamed;
    protected float cn_renamed;

    /* renamed from: co_renamed, reason: collision with root package name */
    protected float f7005co;
    protected float cp_renamed;
    protected float cq_renamed;
    protected boolean cr_renamed;
    protected int cs_renamed;
    protected int ct_renamed;
    protected float cu_renamed;
    protected float cv_renamed;
    protected int cw_renamed;
    protected int cx_renamed;
    protected int cy_renamed;
    protected float cz_renamed;
    private int dA_renamed;
    private int dB_renamed;
    private com.oplus.camera.ui.preview.ai_renamed.a_renamed dC_renamed;
    private com.oplus.camera.ui.preview.ai_renamed.a_renamed dD_renamed;
    private com.oplus.camera.ui.preview.ai_renamed.a_renamed dE_renamed;
    private float dF_renamed;
    private float dG_renamed;
    private int dH_renamed;
    private float dI_renamed;
    private int dJ_renamed;
    private float dK_renamed;
    private boolean dL_renamed;
    private int dM_renamed;
    private android.view.animation.PathInterpolator dN_renamed;
    private android.view.animation.PathInterpolator dO_renamed;
    protected float da_renamed;
    protected float db_renamed;
    protected float dc_renamed;
    protected float dd_renamed;
    protected float de_renamed;
    protected android.animation.AnimatorSet df_renamed;
    protected boolean dg_renamed;
    protected com.oplus.camera.screen.g_renamed dh_renamed;
    private boolean dj_renamed;
    private int dk_renamed;
    private android.graphics.Path dl_renamed;
    private float dm_renamed;
    private int dn_renamed;

    /* renamed from: do, reason: not valid java name */
    private long f2do;
    private long dp_renamed;
    private int dq_renamed;
    private int dr_renamed;
    private int[] ds_renamed;
    private android.animation.AnimatorSet dt_renamed;
    private boolean du_renamed;
    private int dv_renamed;
    private android.animation.ValueAnimator dw_renamed;
    private java.util.ArrayList<java.lang.Float> dx_renamed;
    private android.animation.ValueAnimator dy_renamed;
    private int dz_renamed;

    /* compiled from: ZoomSeekBar.java */
    public enum a_renamed {
        NORMAL,
        ICON_ONLY
    }

    /* compiled from: ZoomSeekBar.java */
    protected enum b_renamed {
        ULTRA_WIDE,
        WIDE,
        TELE
    }

    protected abstract float a_renamed(float f_renamed, android.view.VelocityTracker velocityTracker);

    public abstract java.lang.String a_renamed(float f_renamed, float f2);

    protected boolean a_renamed(android.view.MotionEvent motionEvent) {
        return true;
    }

    public abstract int getLayoutHeight();

    public abstract int getType();

    public ai_renamed(android.content.Context context) {
        super(context, null);
        this.ap_renamed = null;
        this.aq_renamed = 0;
        this.ar_renamed = 0;
        this.as_renamed = 0;
        this.at_renamed = 0.0f;
        this.au_renamed = 0.0f;
        this.av_renamed = 0.0f;
        this.aw_renamed = null;
        this.ax_renamed = null;
        this.ay_renamed = true;
        this.az_renamed = true;
        this.aA_renamed = true;
        this.aB_renamed = true;
        this.aC_renamed = 0;
        this.aD_renamed = 0;
        this.aE_renamed = 0;
        this.aF_renamed = 0;
        this.aG_renamed = 0;
        this.aH_renamed = 0;
        this.aI_renamed = 0;
        this.aJ_renamed = 0;
        this.aK_renamed = 0;
        this.aL_renamed = 0;
        this.aM_renamed = 0;
        this.aN_renamed = 0;
        this.aO_renamed = 0;
        this.aP_renamed = 0;
        this.aQ_renamed = 0;
        this.aR_renamed = 0.0f;
        this.aS_renamed = 0.0f;
        this.aT_renamed = 0;
        this.aU_renamed = 0;
        this.aV_renamed = 0;
        this.aW_renamed = 0;
        this.aX_renamed = 0;
        this.aY_renamed = 0;
        this.aZ_renamed = 0.0f;
        this.ba_renamed = 0.0f;
        this.bb_renamed = 0;
        this.bc_renamed = 0;
        this.bd_renamed = 0;
        this.be_renamed = 0.0f;
        this.bf_renamed = 0.0f;
        this.bg_renamed = false;
        this.bh_renamed = false;
        this.bi_renamed = false;
        this.bj_renamed = false;
        this.bk_renamed = false;
        this.bl_renamed = false;
        this.bm_renamed = false;
        this.bn_renamed = false;
        this.bo_renamed = false;
        this.bp_renamed = false;
        this.bq_renamed = 8;
        this.br_renamed = null;
        this.bs_renamed = 0.0f;
        this.bt_renamed = 0.0f;
        this.bu_renamed = 0.0f;
        this.bv_renamed = null;
        this.bw_renamed = null;
        this.bx_renamed = null;
        this.by_renamed = null;
        this.bz_renamed = null;
        this.bA_renamed = null;
        this.bB_renamed = null;
        this.bC_renamed = 0;
        this.bD_renamed = null;
        this.bE_renamed = 0;
        this.bF_renamed = null;
        this.bG_renamed = null;
        this.bH_renamed = null;
        this.bI_renamed = null;
        this.bJ_renamed = 0;
        this.bK_renamed = null;
        this.bL_renamed = null;
        this.bM_renamed = 1;
        this.bN_renamed = null;
        this.bO_renamed = null;
        this.bP_renamed = null;
        this.bQ_renamed = null;
        this.bR_renamed = null;
        this.bS_renamed = null;
        this.bT_renamed = false;
        this.bU_renamed = 0;
        this.bV_renamed = 0;
        this.bW_renamed = 0;
        this.bX_renamed = 0;
        this.bY_renamed = 0;
        this.bZ_renamed = 0;
        this.ca_renamed = 0;
        this.cb_renamed = new android.graphics.RectF();
        this.cc_renamed = new android.graphics.RectF();
        this.cd_renamed = new java.util.HashMap();
        this.ce_renamed = new java.util.HashMap();
        this.cf_renamed = 0.0f;
        this.cg_renamed = 1.0f;
        this.ch_renamed = 0.0f;
        this.ci_renamed = 0.0f;
        this.cj_renamed = 0.0f;
        this.ck_renamed = 0.0f;
        this.cl_renamed = 0.0f;
        this.cm_renamed = 0.0f;
        this.cn_renamed = 0.0f;
        this.f7005co = 0.0f;
        this.cp_renamed = 0.0f;
        this.cq_renamed = 0.0f;
        this.cr_renamed = false;
        this.cs_renamed = 0;
        this.ct_renamed = 0;
        this.cu_renamed = 0.0f;
        this.cv_renamed = 0.0f;
        this.cw_renamed = 2;
        this.cx_renamed = 2;
        this.cy_renamed = 2;
        this.cz_renamed = -1.0f;
        this.cA_renamed = -1.0f;
        this.cB_renamed = -1.0f;
        this.cC_renamed = -1.0f;
        this.cD_renamed = -1.0f;
        this.cE_renamed = null;
        this.cF_renamed = null;
        this.cG_renamed = null;
        this.cH_renamed = null;
        this.cI_renamed = null;
        this.cJ_renamed = null;
        this.cK_renamed = null;
        this.cL_renamed = 0.0f;
        this.cM_renamed = 0.0f;
        this.cN_renamed = 0.0f;
        this.cO_renamed = 0.0f;
        this.cP_renamed = 0.0f;
        this.cQ_renamed = 0.0f;
        this.cR_renamed = 0.31f;
        this.cS_renamed = false;
        this.cT_renamed = false;
        this.cU_renamed = 0;
        this.cV_renamed = "";
        this.cW_renamed = "";
        this.cX_renamed = "";
        this.cY_renamed = "";
        this.cZ_renamed = 0.0f;
        this.da_renamed = -1.0f;
        this.db_renamed = -1.0f;
        this.dc_renamed = -1.0f;
        this.dd_renamed = -1.0f;
        this.de_renamed = 0.0f;
        this.df_renamed = null;
        this.dg_renamed = false;
        this.dh_renamed = null;
        this.dj_renamed = false;
        this.dk_renamed = -1;
        this.dl_renamed = null;
        this.dm_renamed = 0.0f;
        this.dn_renamed = 200;
        this.f2do = 0L;
        this.dp_renamed = 0L;
        this.dq_renamed = 0;
        this.dr_renamed = 0;
        this.ds_renamed = null;
        this.du_renamed = true;
        this.dz_renamed = 0;
        this.dA_renamed = 0;
        this.dB_renamed = 0;
        this.dC_renamed = com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL;
        this.dD_renamed = com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL;
        this.dE_renamed = com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL;
        this.dF_renamed = 0.0f;
        this.dG_renamed = 0.0f;
        this.dH_renamed = 0;
        this.dI_renamed = 0.0f;
        this.dJ_renamed = 0;
        this.dK_renamed = 0.0f;
        this.dL_renamed = false;
        this.dM_renamed = 0;
        this.dN_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.dO_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.aw_renamed = context;
        this.ax_renamed = this.aw_renamed.getResources();
        u_renamed();
        setForceDarkAllowed(false);
        this.bm_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FRONT_CAMERA_AUTO_ZOOM);
    }

    private void u_renamed() {
        float f_renamed = this.ax_renamed.getDisplayMetrics().density;
        this.ar_renamed = (int) (400.0f * f_renamed);
        this.as_renamed = (int) (this.ar_renamed * 10.0f);
        this.aq_renamed = (int) (f_renamed * 20.0f);
        this.bP_renamed = new com.oplus.camera.ah_renamed();
        E_renamed();
        this.dl_renamed = new android.graphics.Path();
        this.ba_renamed = 0.0f;
        this.dF_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_seekbar_switch_bar_radius) * 0.7f;
        K_renamed();
        this.bg_renamed = false;
        this.cJ_renamed = new java.text.DecimalFormat("#.#");
        this.cK_renamed = new java.text.DecimalFormat("0.0");
        this.dq_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_click_hotspot_width_offset);
        this.dr_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_hotspot_height);
        this.aG_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_click_point_radius);
        this.aH_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_click_point_gap);
        this.aI_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_click_point_shadow_radius);
        this.aE_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_focus_circle_stroke_width);
        this.aF_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_focus_circle_width) / 2;
        this.aC_renamed = this.aF_renamed - this.aE_renamed;
        this.aD_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_focus_circle_radius_pressed);
        this.aJ_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_focus_text_size_normal);
        this.aK_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_focus_text_size_pressed);
        this.aM_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_current_text_move_distance_max);
        this.bZ_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_focus_horizontal_hot_area_offset);
        this.ca_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_focus_vertical_hot_area_offset);
        this.bG_renamed = new android.graphics.Paint();
        this.bG_renamed.setAntiAlias(true);
        this.bH_renamed = new android.graphics.Paint();
        this.bH_renamed.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        this.bz_renamed = new android.graphics.Paint();
        this.bz_renamed.setAntiAlias(true);
        this.bz_renamed.setTextSize(this.aJ_renamed);
        this.bz_renamed.setColor(this.ax_renamed.getColor(com.oplus.camera.R_renamed.color.zoom_arc_seekbar_switch_bar_oval_stroke_color, null));
        this.bz_renamed.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.bz_renamed.setTypeface(com.oplus.camera.util.Util.l_renamed(this.aw_renamed));
        this.bB_renamed = new android.graphics.Paint();
        this.bB_renamed.setAntiAlias(true);
        this.bB_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.bC_renamed = this.ax_renamed.getColor(com.oplus.camera.R_renamed.color.zoom_seekbar_focus_circle_bg_color);
        this.bB_renamed.setColor(this.bC_renamed);
        this.bD_renamed = new android.graphics.Paint();
        this.bD_renamed.setAntiAlias(true);
        this.bD_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.bD_renamed.setStrokeWidth(this.aE_renamed);
        this.bE_renamed = this.ax_renamed.getColor(com.oplus.camera.R_renamed.color.zoom_seekbar_focus_circle_stroke_color);
        this.bD_renamed.setColor(this.bE_renamed);
        this.bF_renamed = new android.graphics.Paint();
        this.bF_renamed.setAntiAlias(true);
        this.bF_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.bF_renamed.setColor(-1);
        this.bQ_renamed = new android.graphics.Paint();
        this.bQ_renamed.setAntiAlias(true);
        this.u_renamed = new android.graphics.Paint();
        this.u_renamed.setAntiAlias(true);
        this.v_renamed = new android.graphics.Paint();
        this.v_renamed.setAntiAlias(true);
        this.w_renamed = new android.graphics.Paint();
        this.w_renamed.setAntiAlias(true);
        this.x_renamed = new android.graphics.Paint();
        this.x_renamed.setAntiAlias(true);
        this.y_renamed = new android.graphics.Paint();
        this.y_renamed.setAntiAlias(true);
        this.aj_renamed = new android.graphics.Paint();
        this.aj_renamed.setAntiAlias(true);
        this.aj_renamed.setTextSize(this.aJ_renamed);
        this.bU_renamed = this.ax_renamed.getColor(com.oplus.camera.R_renamed.color.zoom_arc_seekbar_switch_bar_text_color, null);
        this.aj_renamed.setColor(this.bU_renamed);
        this.aj_renamed.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.aj_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        this.bR_renamed = new android.graphics.Paint();
        this.bR_renamed.setAntiAlias(true);
        this.bV_renamed = this.ax_renamed.getColor(com.oplus.camera.R_renamed.color.zoom_seekbar_focus_circle_bg_color, null);
        this.bW_renamed = this.ax_renamed.getColor(com.oplus.camera.R_renamed.color.zoom_seekbar_focus_circle_light_bg_color, null);
        this.bX_renamed = this.bV_renamed;
        this.bR_renamed.setColor(this.bX_renamed);
        this.bR_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.cf_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_seekbar_switch_bar_radius);
        this.ch_renamed = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_seekbar_switch_bar_spacing);
        this.bS_renamed = new android.graphics.Paint();
        this.bS_renamed.setAntiAlias(true);
        this.bY_renamed = this.ax_renamed.getColor(com.oplus.camera.R_renamed.color.zoom_arc_seekbar_switch_bar_oval_stroke_color, null);
        this.bS_renamed.setColor(this.bY_renamed);
        this.bS_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.cg_renamed = this.ax_renamed.getDimension(com.oplus.camera.R_renamed.dimen.zoom_seekbar_oval_stroke_width);
        this.bS_renamed.setStrokeWidth(this.cg_renamed);
        android.graphics.Bitmap bitmapA = a_renamed(this.ax_renamed, com.oplus.camera.R_renamed.drawable.zoom_seek_bar_ultra_angle);
        android.graphics.Bitmap bitmapA2 = a_renamed(this.ax_renamed, com.oplus.camera.R_renamed.drawable.zoom_seek_bar_normal_len);
        android.graphics.Bitmap bitmapA3 = a_renamed(this.ax_renamed, com.oplus.camera.R_renamed.drawable.zoom_seek_bar_tele);
        if (bitmapA != null) {
            this.cl_renamed = bitmapA.getWidth() / 2.0f;
            this.cm_renamed = bitmapA.getHeight() / 2.0f;
        }
        if (bitmapA3 != null) {
            this.cp_renamed = bitmapA3.getWidth() / 2.0f;
            this.cq_renamed = bitmapA3.getHeight() / 2.0f;
        }
        this.cd_renamed.put(com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE, bitmapA);
        this.cd_renamed.put(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE, bitmapA2);
        this.cd_renamed.put(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE, bitmapA3);
        this.ci_renamed = this.af_renamed;
        this.cj_renamed = (this.af_renamed - (this.cf_renamed * 2.0f)) - this.ch_renamed;
        this.ck_renamed = this.cj_renamed;
        this.cn_renamed = this.af_renamed + (this.cf_renamed * 2.0f) + this.ch_renamed;
        this.f7005co = this.cn_renamed;
        if (1 == getLayoutDirection()) {
            this.cr_renamed = true;
            float f2 = this.cj_renamed;
            this.cj_renamed = this.cn_renamed;
            this.cn_renamed = f2;
            float f3 = this.ck_renamed;
            this.ck_renamed = this.f7005co;
            this.f7005co = f3;
        }
        com.oplus.camera.ui.a_renamed.a_renamed(getContext()).a_renamed(this, "ZoomSeekBar");
    }

    private android.graphics.Bitmap a_renamed(android.content.res.Resources resources, int i_renamed) {
        android.graphics.drawable.Drawable drawableA;
        if (resources == null || (drawableA = androidx.core.a_renamed.a_renamed.f_renamed.a_renamed(this.ax_renamed, i_renamed, null)) == null) {
            return null;
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(drawableA.getIntrinsicWidth(), drawableA.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        drawableA.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableA.draw(canvas);
        return bitmapCreateBitmap;
    }

    public void setCustomUltraWideIcon(int i_renamed) {
        this.dz_renamed = i_renamed;
    }

    public void setCustomWideIcon(int i_renamed) {
        this.dA_renamed = i_renamed;
    }

    public void setCustomTeleIcon(int i_renamed) {
        this.dB_renamed = i_renamed;
    }

    public void setDisplayMode(com.oplus.camera.ui.preview.ai_renamed.a_renamed aVar) {
        this.dC_renamed = aVar;
    }

    @Override // com.oplus.camera.ui.a_renamed.BackgroundSplitManager_2
    public void a_renamed(boolean z_renamed, int i_renamed) {
        this.dL_renamed = z_renamed;
        this.dM_renamed = i_renamed;
        postInvalidate();
    }

    @Override // com.oplus.camera.ui.a_renamed.BackgroundSplitManager_2
    public void setNormalBackground(boolean z_renamed) {
        setLightBackground(z_renamed);
    }

    public void setScreenModeManager(com.oplus.camera.screen.g_renamed gVar) {
        this.dh_renamed = gVar;
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ZoomSeekBar", "setInverseColor, inverseColor: " + z_renamed);
        this.dg_renamed = z_renamed;
        this.bX_renamed = this.bT_renamed ? this.bW_renamed : this.bV_renamed;
        this.bX_renamed = z_renamed ? this.bV_renamed : this.bX_renamed;
        this.bR_renamed.setColor(this.bX_renamed);
        postInvalidate();
    }

    public void setLightBackground(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ZoomSeekBar", "setLightBackground, isLight: " + z_renamed);
        if (this.bT_renamed == z_renamed) {
            return;
        }
        this.bT_renamed = z_renamed;
        this.bX_renamed = z_renamed ? this.bW_renamed : this.bV_renamed;
        this.bX_renamed = this.dg_renamed ? this.bV_renamed : this.bX_renamed;
        this.bR_renamed.setColor(this.bX_renamed);
        postInvalidate();
    }

    private void E_renamed() {
        this.dy_renamed = new android.animation.ValueAnimator();
        this.dy_renamed.setDuration(500L);
        this.dy_renamed.setInterpolator(di_renamed);
        this.dy_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.ai_renamed.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.preview.ai_renamed.this.ad_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.dw_renamed = new android.animation.ValueAnimator();
        this.dw_renamed.setDuration(500L);
        this.dw_renamed.setInterpolator(di_renamed);
        this.dw_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.ai_renamed.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.preview.ai_renamed.this.Q_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.preview.ai_renamed.this.invalidate();
            }
        });
        this.dt_renamed = new android.animation.AnimatorSet();
        this.dt_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.ai_renamed.5
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
                com.oplus.camera.ui.preview.ai_renamed.this.al_renamed.h_renamed();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:100:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:105:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:107:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:111:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:119:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:131:0x02e2 A_renamed[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:132:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:140:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:145:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:239:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:241:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:99:0x0261  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r21) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.ai_renamed.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean b_renamed(float f_renamed, float f2) {
        this.cc_renamed.set(this.cb_renamed.left - this.bZ_renamed, this.cb_renamed.top - this.ca_renamed, this.cb_renamed.right + this.bZ_renamed, this.cb_renamed.bottom + this.ca_renamed);
        return this.cc_renamed.contains(f_renamed, f2);
    }

    private boolean F_renamed() {
        return this.bl_renamed && !this.bk_renamed;
    }

    public void a_renamed(float f_renamed, float f2, float f3, java.util.ArrayList<java.lang.Float> arrayList, java.util.ArrayList<java.lang.Float> arrayList2, int i_renamed, boolean z_renamed, boolean z2, boolean z3) {
        com.oplus.camera.ui.preview.ag_renamed agVar;
        if (java.lang.Math.abs(f_renamed - this.bu_renamed) < 1.0E-6f && java.lang.Math.abs(f2 - this.bs_renamed) < 1.0E-6f && java.lang.Math.abs(f3 - this.bt_renamed) < 1.0E-6f && i_renamed == this.bM_renamed && arrayList2.equals(this.bK_renamed) && z2 == this.bo_renamed && !z3) {
            com.oplus.camera.e_renamed.e_renamed("ZoomSeekBar", "init, skip the same configuration");
            if (!this.cV_renamed.equals(a_renamed(f_renamed(f_renamed)))) {
                b_renamed(f_renamed, false);
            }
            if (this.cs_renamed != 0 || (agVar = this.bO_renamed) == null || !agVar.f_renamed() || arrayList2.contains(java.lang.Float.valueOf(com.oplus.camera.ag_renamed.f4106a))) {
                return;
            }
            this.aB_renamed = false;
            b_renamed(2, false);
            return;
        }
        this.bl_renamed = this.bk_renamed;
        this.bn_renamed = this.bo_renamed;
        this.bk_renamed = z_renamed || z2;
        this.ay_renamed = this.az_renamed;
        this.aA_renamed = this.aB_renamed;
        this.dE_renamed = this.dD_renamed;
        this.ct_renamed = this.cs_renamed;
        java.util.ArrayList<java.lang.Float> arrayList3 = this.bK_renamed;
        if (arrayList3 != null) {
            this.cE_renamed = new java.util.ArrayList<>(arrayList3);
        } else {
            this.cE_renamed = null;
        }
        this.bu_renamed = f_renamed;
        this.bM_renamed = i_renamed;
        this.bo_renamed = z2;
        this.bK_renamed = arrayList2;
        this.bJ_renamed = arrayList2.size();
        this.bs_renamed = f2;
        this.bt_renamed = f3;
        this.dD_renamed = this.bk_renamed ? com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY : this.dC_renamed;
        if (this.S_renamed == 0) {
            for (com.oplus.camera.ui.preview.ai_renamed.b_renamed bVar : com.oplus.camera.ui.preview.ai_renamed.b_renamed.values()) {
                this.ce_renamed.put(bVar, this.cd_renamed.get(bVar));
            }
        }
        if (this.bk_renamed) {
            this.cd_renamed.put(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE, a_renamed(this.ax_renamed, com.oplus.camera.R_renamed.drawable.ic_zoom_front_camera_multi));
            this.cd_renamed.put(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE, a_renamed(this.ax_renamed, com.oplus.camera.R_renamed.drawable.ic_zoom_front_camera_single));
        } else {
            java.util.Map<com.oplus.camera.ui.preview.ai_renamed.b_renamed, android.graphics.Bitmap> map = this.cd_renamed;
            com.oplus.camera.ui.preview.ai_renamed.b_renamed bVar2 = com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE;
            android.content.res.Resources resources = this.ax_renamed;
            int i2 = this.dz_renamed;
            if (i2 <= 0) {
                i2 = com.oplus.camera.R_renamed.drawable.zoom_seek_bar_ultra_angle;
            }
            map.put(bVar2, a_renamed(resources, i2));
            java.util.Map<com.oplus.camera.ui.preview.ai_renamed.b_renamed, android.graphics.Bitmap> map2 = this.cd_renamed;
            com.oplus.camera.ui.preview.ai_renamed.b_renamed bVar3 = com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE;
            android.content.res.Resources resources2 = this.ax_renamed;
            int i3 = this.dA_renamed;
            if (i3 <= 0) {
                i3 = com.oplus.camera.R_renamed.drawable.zoom_seek_bar_normal_len;
            }
            map2.put(bVar3, a_renamed(resources2, i3));
            java.util.Map<com.oplus.camera.ui.preview.ai_renamed.b_renamed, android.graphics.Bitmap> map3 = this.cd_renamed;
            com.oplus.camera.ui.preview.ai_renamed.b_renamed bVar4 = com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE;
            android.content.res.Resources resources3 = this.ax_renamed;
            int i4 = this.dB_renamed;
            if (i4 <= 0) {
                i4 = com.oplus.camera.R_renamed.drawable.zoom_seek_bar_tele;
            }
            map3.put(bVar4, a_renamed(resources3, i4));
        }
        if (F_renamed() && !isShown()) {
            for (com.oplus.camera.ui.preview.ai_renamed.b_renamed bVar5 : com.oplus.camera.ui.preview.ai_renamed.b_renamed.values()) {
                this.ce_renamed.put(bVar5, this.cd_renamed.get(bVar5));
            }
        }
        this.bi_renamed = !arrayList.contains(java.lang.Float.valueOf(com.oplus.camera.ag_renamed.f4106a)) && arrayList2.contains(java.lang.Float.valueOf(com.oplus.camera.ag_renamed.f4106a));
        if (this.bi_renamed) {
            arrayList.add(0, java.lang.Float.valueOf(com.oplus.camera.ag_renamed.f4106a));
        }
        this.az_renamed = true;
        this.aB_renamed = true;
        int iH = h_renamed(f_renamed);
        if (this.bk_renamed) {
            iH = f_renamed == 1.0f ? 0 : 1;
        }
        this.W_renamed = false;
        if (!this.bO_renamed.f_renamed()) {
            b_renamed(0, false);
        } else if (arrayList2.contains(java.lang.Float.valueOf(com.oplus.camera.ag_renamed.f4106a))) {
            float fI_renamed = this.bO_renamed.i_renamed();
            if (java.lang.Float.compare(fI_renamed, 0.0f) != 0) {
                this.az_renamed = arrayList2.contains(java.lang.Float.valueOf(fI_renamed));
            } else {
                this.az_renamed = arrayList2.contains(java.lang.Float.valueOf(2.0f));
            }
            if (this.az_renamed) {
                b_renamed(1, false);
                if (this.ct_renamed != 1) {
                    a_renamed(iH, true);
                }
            } else {
                b_renamed(3, false);
                if (this.ct_renamed == 1) {
                    a_renamed(iH, false);
                } else if (this.bl_renamed) {
                    this.W_renamed = true;
                }
            }
        } else {
            this.aB_renamed = false;
            b_renamed(2, false);
            if (this.ct_renamed == 1) {
                a_renamed(iH, false);
            } else if (this.dE_renamed != this.dD_renamed || this.bl_renamed != this.bk_renamed) {
                this.W_renamed = true;
            }
        }
        if (this.W_renamed) {
            if (this.t_renamed.isStarted()) {
                this.t_renamed.cancel();
            }
            com.oplus.camera.e_renamed.b_renamed("ZoomSeekBar", "init, start camera switch animator");
            this.cw_renamed = this.aN_renamed;
            this.t_renamed.start();
        }
        this.aQ_renamed = iH;
        this.au_renamed = i_renamed(f3) / this.R_renamed;
        this.av_renamed = this.au_renamed * 2.0f;
        this.bv_renamed = getZoomSections();
        this.bw_renamed = getSectionStep();
        this.by_renamed = getIndicatorSections();
        java.util.ArrayList<java.lang.Integer> arrayList4 = this.by_renamed;
        this.bb_renamed = arrayList4.get(arrayList4.size() - 1).intValue() + 1;
        this.aU_renamed = this.bb_renamed - 1;
        java.util.ArrayList<java.lang.Float> arrayList5 = this.dx_renamed;
        if (arrayList5 != null) {
            arrayList5.clear();
        } else {
            this.dx_renamed = new java.util.ArrayList<>();
        }
        this.dx_renamed.addAll(arrayList);
        this.bL_renamed = new float[this.dx_renamed.size()];
        for (int i5 = 0; i5 < this.bL_renamed.length; i5++) {
            this.bL_renamed[i5] = g_renamed(this.dx_renamed.get(i5).floatValue());
        }
        w_renamed();
        float fG_renamed = g_renamed(f_renamed);
        if (1 == getLayoutDirection()) {
            fG_renamed = com.oplus.camera.util.Util.a_renamed(1.0f, fG_renamed);
        }
        this.ad_renamed = fG_renamed;
        this.ae_renamed = this.ad_renamed;
        this.cW_renamed = this.cV_renamed;
        if (this.dE_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY) {
            this.cV_renamed = a_renamed(f_renamed(f_renamed));
        }
        if (!this.bO_renamed.f_renamed() || !isShown() || ((this.ct_renamed == 0 && this.cs_renamed != 0) || this.cE_renamed == null)) {
            setCurrentDisplayText(f_renamed);
            this.cV_renamed = a_renamed(f_renamed(f_renamed));
            setCenterPointIndex(iH);
        } else {
            a_renamed(iH, f_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("ZoomSeekBar", "init, mCurrentDisplayText: " + this.cV_renamed);
        setContentDescription(getContext().getResources().getString(com.oplus.camera.R_renamed.string.camera_description_zoom_seek_bar) + this.cV_renamed);
        o_renamed();
        k_renamed();
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G_renamed() {
        if (this.dD_renamed != com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY || this.t_renamed == null || this.bn_renamed) {
            return;
        }
        if (this.t_renamed.isStarted()) {
            this.t_renamed.cancel();
        }
        this.t_renamed.start();
    }

    protected void a_renamed(int i_renamed, boolean z_renamed) {
        float f_renamed;
        com.oplus.camera.ui.preview.ag_renamed agVar;
        com.oplus.camera.e_renamed.a_renamed("ZoomSeekBar", "startTransformAnimator, mPreZoomBarType: " + this.ct_renamed + ", mZoomBarType: " + this.cs_renamed);
        if (this.ct_renamed == 0 || this.S_renamed == 15) {
            return;
        }
        com.oplus.camera.ui.preview.ag_renamed agVar2 = this.bO_renamed;
        if (agVar2 == null || !agVar2.g_renamed()) {
            com.oplus.camera.ui.preview.ag_renamed agVar3 = this.bO_renamed;
            if (agVar3 == null || !agVar3.h_renamed()) {
                this.cv_renamed = this.ag_renamed;
                this.cw_renamed = this.aN_renamed;
                this.cy_renamed = i_renamed;
                this.cx_renamed = a_renamed(this.cw_renamed, this.cE_renamed);
                if (F_renamed()) {
                    int i2 = this.aQ_renamed;
                    if (i2 == 0) {
                        this.cC_renamed = this.cu_renamed;
                    } else if (i2 == 1) {
                        this.cC_renamed = this.cz_renamed;
                    }
                } else {
                    int i3 = this.cx_renamed;
                    if (i3 == 1) {
                        this.cC_renamed = this.cA_renamed;
                    } else if (i3 == 2) {
                        this.cC_renamed = this.cB_renamed;
                    } else if (i3 == 3) {
                        this.cC_renamed = this.cz_renamed;
                    }
                }
                float f2 = this.cj_renamed;
                int i4 = this.cs_renamed;
                float f3 = 0.0f;
                if (i4 == 1) {
                    f3 = this.af_renamed;
                    f2 = this.ck_renamed;
                    f_renamed = this.f7005co;
                } else if (i4 == 2) {
                    f3 = this.cr_renamed ? this.af_renamed + this.cf_renamed : this.af_renamed - this.cf_renamed;
                    f_renamed = this.cr_renamed ? this.f7005co + this.cf_renamed : this.f7005co - this.cf_renamed;
                } else if (i4 != 3) {
                    f_renamed = 0.0f;
                } else {
                    f3 = this.cr_renamed ? (this.af_renamed - this.cf_renamed) - this.ch_renamed : this.af_renamed + this.cf_renamed + this.ch_renamed;
                    f2 = this.cr_renamed ? (this.ck_renamed - this.cf_renamed) - this.ch_renamed : this.ck_renamed + this.cf_renamed + this.ch_renamed;
                    f_renamed = 0.0f;
                }
                if (this.bk_renamed) {
                    int i5 = this.cy_renamed;
                    if (i5 == 0) {
                        this.cD_renamed = f3;
                    } else if (i5 == 1) {
                        this.cD_renamed = f_renamed;
                    }
                } else {
                    int iA = a_renamed(this.cy_renamed);
                    if (iA == 1) {
                        this.cD_renamed = f2;
                    } else if (iA == 2) {
                        this.cD_renamed = f3;
                    } else if (iA == 3) {
                        this.cD_renamed = f_renamed;
                    }
                }
                if (z_renamed && this.r_renamed != null) {
                    if (this.s_renamed != null && this.s_renamed.isStarted()) {
                        this.s_renamed.cancel();
                    }
                    this.r_renamed.start();
                } else if (!z_renamed && this.s_renamed != null) {
                    if (this.r_renamed != null && this.r_renamed.isStarted()) {
                        this.r_renamed.cancel();
                    }
                    this.s_renamed.start();
                }
                if ((b_renamed() || z_renamed()) && (agVar = this.bO_renamed) != null && agVar.k_renamed()) {
                    this.an_renamed.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.ai_renamed.6
                        @Override // java.lang.Runnable
                        public void run() {
                            com.oplus.camera.ui.preview.ai_renamed.this.G_renamed();
                            com.oplus.camera.ui.preview.ai_renamed.this.setStatus(15);
                        }
                    }, 25L);
                } else {
                    G_renamed();
                    setStatus(15);
                }
            }
        }
    }

    public void v_renamed() {
        com.oplus.camera.e_renamed.c_renamed("ZoomSeekBar", "resetZoomBarType");
        r_renamed();
        this.cs_renamed = 0;
        this.ct_renamed = 0;
    }

    protected void b_renamed(int i_renamed, boolean z_renamed) {
        if (this.cs_renamed != i_renamed || z_renamed) {
            com.oplus.camera.e_renamed.a_renamed("ZoomSeekBar", "setZoomBarType, " + this.cs_renamed + " -> " + i_renamed);
            this.cs_renamed = i_renamed;
            int i2 = this.cr_renamed ? -1 : 1;
            if (!z_renamed) {
                float f_renamed = this.ci_renamed;
                this.cu_renamed = f_renamed;
                this.cA_renamed = this.cj_renamed;
                this.cB_renamed = f_renamed;
                this.cz_renamed = this.cn_renamed;
            }
            int i3 = this.cs_renamed;
            if (i3 == 1) {
                this.cj_renamed = this.ck_renamed;
                this.ci_renamed = this.af_renamed;
                this.cn_renamed = this.f7005co;
            } else {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return;
                    }
                    float f2 = i2;
                    this.cj_renamed = this.ck_renamed + ((this.cf_renamed + this.ch_renamed) * f2);
                    this.ci_renamed = this.af_renamed + ((this.cf_renamed + this.ch_renamed) * f2);
                    this.cn_renamed = this.ci_renamed;
                    return;
                }
                float f3 = this.af_renamed;
                float f4 = this.cf_renamed;
                float f5 = i2;
                this.ci_renamed = f3 - (f4 * f5);
                this.cn_renamed = this.f7005co - (f4 * f5);
                this.cj_renamed = this.ci_renamed;
            }
        }
    }

    protected void w_renamed() {
        android.graphics.Paint.FontMetrics fontMetrics = this.aj_renamed.getFontMetrics();
        this.ba_renamed = ((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom;
    }

    @Override // com.oplus.camera.ui.b_renamed
    protected void k_renamed() {
        android.graphics.Paint paint = this.bQ_renamed;
        if (paint != null) {
            paint.setAlpha(255);
        }
        if (this.aj_renamed != null) {
            this.aj_renamed.setAlpha(android.graphics.Color.alpha(this.bU_renamed));
            this.aj_renamed.setColor(this.bU_renamed);
            this.aj_renamed.setTextSize(this.aJ_renamed);
        }
        android.graphics.Paint paint2 = this.bR_renamed;
        if (paint2 != null) {
            paint2.setAlpha(android.graphics.Color.alpha(this.bX_renamed));
            this.bR_renamed.setColor(this.bX_renamed);
        }
        android.graphics.Paint paint3 = this.bS_renamed;
        if (paint3 != null) {
            paint3.setColor(this.bY_renamed);
            this.bS_renamed.setAlpha(android.graphics.Color.alpha(this.bY_renamed));
        }
    }

    @Override // com.oplus.camera.ui.b_renamed, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        synchronized (this) {
            H_renamed();
            super.onDraw(canvas);
        }
    }

    private void H_renamed() {
        int i_renamed;
        if (this.aV_renamed != this.aX_renamed) {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.dp_renamed) {
                int i2 = (int) (jCurrentAnimationTimeMillis - this.f2do);
                int i3 = this.aW_renamed;
                if (!this.bh_renamed) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 360) / 1000);
                if (i4 >= 0) {
                    i_renamed = i4 % 360;
                } else {
                    i_renamed = (i4 % 360) + 360;
                }
                this.aV_renamed = i_renamed;
                invalidate();
                return;
            }
            this.aV_renamed = this.aX_renamed;
        }
    }

    public void x_renamed() {
        this.cF_renamed = com.oplus.camera.util.Util.a_renamed(getWidth(), getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        this.cH_renamed = new android.graphics.Canvas();
        this.cH_renamed.setBitmap(this.cF_renamed);
        this.cG_renamed = com.oplus.camera.util.Util.a_renamed(getWidth(), getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        this.cI_renamed = new android.graphics.Canvas();
        this.cI_renamed.setBitmap(this.cG_renamed);
    }

    @Override // com.oplus.camera.ui.b_renamed
    public void r_renamed() {
        super.r_renamed();
        android.animation.AnimatorSet animatorSet = this.df_renamed;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (this.bP_renamed != null) {
            this.bP_renamed = null;
        }
        o_renamed();
        this.bg_renamed = false;
        this.bp_renamed = false;
        setRate(g_renamed(1.0f));
        y_renamed();
    }

    @Override // com.oplus.camera.ui.b_renamed
    protected void o_renamed() {
        this.bz_renamed.setColor(-1);
        this.bB_renamed.setColor(this.bC_renamed);
        this.bD_renamed.setColor(this.bE_renamed);
        this.bF_renamed.setColor(-1);
    }

    public void y_renamed() {
        android.graphics.Bitmap bitmap = this.cF_renamed;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.cF_renamed.recycle();
            this.cF_renamed = null;
        }
        android.graphics.Bitmap bitmap2 = this.cG_renamed;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.cG_renamed.recycle();
            this.cG_renamed = null;
        }
        this.cI_renamed = null;
        this.cH_renamed = null;
    }

    @Override // com.oplus.camera.ui.b_renamed
    public void a_renamed(android.animation.AnimatorListenerAdapter animatorListenerAdapter, boolean z_renamed, boolean z2) {
        this.bg_renamed = false;
        q_renamed();
        super.a_renamed(animatorListenerAdapter, z_renamed, z2);
    }

    @Override // com.oplus.camera.ui.b_renamed
    public boolean b_renamed(boolean z_renamed) {
        this.bg_renamed = false;
        return super.b_renamed(z_renamed);
    }

    @Override // com.oplus.camera.ui.b_renamed
    public void c_renamed(boolean z_renamed) {
        this.aZ_renamed = 0.0f;
        super.c_renamed(z_renamed);
        x_renamed();
    }

    @Override // com.oplus.camera.ui.b_renamed
    protected void t_renamed() {
        this.cX_renamed = this.cV_renamed;
        this.aO_renamed = this.aN_renamed;
    }

    @Override // com.oplus.camera.ui.b_renamed
    protected void a_renamed(android.graphics.Canvas canvas) {
        a_renamed(canvas, this.G_renamed);
        k_renamed(canvas);
    }

    protected void a_renamed(android.graphics.Canvas canvas, android.graphics.Bitmap bitmap, float f_renamed, float f2, android.graphics.Paint paint) {
        canvas.drawBitmap(bitmap, f_renamed - this.cp_renamed, f2 - this.cq_renamed, paint);
    }

    protected void k_renamed(android.graphics.Canvas canvas) {
        java.lang.String str;
        w_renamed();
        this.w_renamed.setAlpha((int) (this.H_renamed * 255.0f));
        this.x_renamed.setAlpha((int) (this.K_renamed * 255.0f));
        this.y_renamed.setAlpha((int) (this.L_renamed * 255.0f));
        int alpha = this.v_renamed.getAlpha();
        float f_renamed = this.cA_renamed;
        float f2 = f_renamed + ((this.cj_renamed - f_renamed) * this.G_renamed);
        float f3 = this.cB_renamed;
        float f4 = f3 + ((this.ci_renamed - f3) * this.G_renamed);
        float f5 = this.cz_renamed;
        float f6 = f5 + ((this.cn_renamed - f5) * this.G_renamed);
        int iRound = java.lang.Math.round(this.G_renamed * 255.0f);
        int iRound2 = java.lang.Math.round((1.0f - this.G_renamed) * 255.0f);
        android.graphics.Bitmap bitmapA = a_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE);
        android.graphics.Bitmap bitmapB = b_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE);
        android.graphics.Bitmap bitmapA2 = a_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE);
        android.graphics.Bitmap bitmapB2 = b_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE);
        android.graphics.Bitmap bitmapA3 = a_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE);
        android.graphics.Bitmap bitmapB3 = b_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE);
        java.lang.String str2 = this.cV_renamed;
        if (this.df_renamed.isStarted()) {
            str2 = this.cY_renamed;
        }
        java.lang.String str3 = str2;
        if (this.aB_renamed) {
            canvas.save();
            canvas.rotate(-this.aV_renamed, f2, this.ag_renamed);
            if (c_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE) && (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY || this.dE_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY)) {
                canvas.scale(this.G_renamed, this.G_renamed, f2, this.ag_renamed);
            }
            if (bitmapB != null) {
                this.v_renamed.setAlpha(iRound);
                str = str3;
                a_renamed(canvas, bitmapB, f2, this.ag_renamed, this.v_renamed);
            } else {
                str = str3;
                this.aj_renamed.setAlpha(iRound);
                canvas.drawText(str, f2, this.ag_renamed + this.ba_renamed, this.aj_renamed);
            }
            canvas.restore();
        } else {
            str = str3;
        }
        if (this.aA_renamed) {
            canvas.save();
            canvas.rotate(-this.aV_renamed, f2, this.ag_renamed);
            if (d_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE) && (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY || this.dE_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY)) {
                canvas.scale(1.0f - this.G_renamed, 1.0f - this.G_renamed, f2, this.ag_renamed);
            }
            if (bitmapA != null) {
                this.v_renamed.setAlpha(iRound2);
                a_renamed(canvas, bitmapA, f2, this.ag_renamed, this.v_renamed);
            } else {
                this.aj_renamed.setAlpha(iRound2);
                canvas.drawText(this.cW_renamed, f2, this.ag_renamed + this.ba_renamed, this.aj_renamed);
            }
            canvas.restore();
        }
        canvas.save();
        canvas.rotate(-this.aV_renamed, f4, this.ag_renamed);
        if (c_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE) && (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY || this.dE_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY)) {
            canvas.scale(this.G_renamed, this.G_renamed, f4, this.ag_renamed);
        }
        if (bitmapB2 != null) {
            this.v_renamed.setAlpha(iRound);
            a_renamed(canvas, bitmapB2, f4, this.ag_renamed, this.v_renamed);
        } else {
            this.aj_renamed.setAlpha(iRound);
            canvas.drawText(str, f4, this.ag_renamed + this.ba_renamed, this.aj_renamed);
        }
        canvas.restore();
        canvas.save();
        canvas.rotate(-this.aV_renamed, f4, this.ag_renamed);
        if (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY || this.dE_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY) {
            canvas.scale(1.0f - this.G_renamed, 1.0f - this.G_renamed, f4, this.ag_renamed);
        }
        if (bitmapA2 != null) {
            this.v_renamed.setAlpha(iRound2);
            a_renamed(canvas, bitmapA2, f4, this.ag_renamed, this.v_renamed);
        } else {
            this.aj_renamed.setAlpha(iRound2);
            canvas.drawText(this.cW_renamed, f4, this.ag_renamed + this.ba_renamed, this.aj_renamed);
        }
        canvas.restore();
        if (this.az_renamed) {
            canvas.save();
            canvas.rotate(-this.aV_renamed, f6, this.ag_renamed);
            if (c_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE) && (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY || this.dE_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY)) {
                canvas.scale(this.G_renamed, this.G_renamed, f6, this.ag_renamed);
            }
            if (bitmapB3 != null) {
                this.v_renamed.setAlpha(iRound);
                a_renamed(canvas, bitmapB3, f6, this.ag_renamed, this.v_renamed);
            } else {
                this.aj_renamed.setAlpha(iRound);
                canvas.drawText(str, f6, this.ag_renamed + this.ba_renamed, this.aj_renamed);
            }
            canvas.restore();
        }
        if (this.ay_renamed) {
            canvas.save();
            canvas.rotate(-this.aV_renamed, f6, this.ag_renamed);
            if (d_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE) && (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY || this.dE_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY)) {
                canvas.scale(1.0f - this.G_renamed, 1.0f - this.G_renamed, f6, this.ag_renamed);
            }
            if (bitmapA3 != null) {
                this.v_renamed.setAlpha(iRound2);
                a_renamed(canvas, bitmapA3, f6, this.ag_renamed, this.v_renamed);
            } else {
                this.aj_renamed.setAlpha(iRound2);
                canvas.drawText(this.cW_renamed, f6, this.ag_renamed + this.ba_renamed, this.aj_renamed);
            }
            canvas.restore();
        }
        this.v_renamed.setAlpha(alpha);
        float f7 = this.cD_renamed;
        this.de_renamed = f7;
        float f8 = this.cC_renamed;
        this.da_renamed = f8 - ((f8 - f7) * this.G_renamed);
        canvas.save();
        a_renamed(canvas, this.da_renamed, this.ag_renamed);
        canvas.restore();
    }

    protected void a_renamed(android.graphics.Canvas canvas, float f_renamed) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        int i_renamed = this.cs_renamed;
        if (i_renamed == 1) {
            int i2 = this.ct_renamed;
            if (i2 == 3) {
                if (this.cr_renamed) {
                    f6 = this.cu_renamed;
                    f7 = this.cf_renamed;
                } else {
                    f6 = this.cu_renamed - (this.cf_renamed * 3.0f);
                    f7 = this.ch_renamed;
                }
                float f16 = f6 - f7;
                if (this.cr_renamed) {
                    f8 = this.cu_renamed + (this.cf_renamed * 3.0f);
                    f9 = this.ch_renamed;
                } else {
                    f8 = this.cu_renamed;
                    f9 = this.cf_renamed;
                }
                float f17 = f8 + f9;
                float f18 = this.ci_renamed;
                float f19 = this.cf_renamed;
                float f20 = this.ch_renamed;
                float f21 = (f18 - (f19 * 3.0f)) - f20;
                float f22 = f18 + (f19 * 3.0f) + f20;
                android.graphics.RectF rectF = this.cb_renamed;
                rectF.left = f16 - ((f16 - f21) * f_renamed);
                rectF.top = this.ag_renamed - this.cf_renamed;
                android.graphics.RectF rectF2 = this.cb_renamed;
                float f23 = this.ag_renamed;
                float f24 = this.cf_renamed;
                rectF2.bottom = f23 + f24;
                android.graphics.RectF rectF3 = this.cb_renamed;
                rectF3.right = f17 - ((f17 - f22) * f_renamed);
                canvas.drawRoundRect(rectF3, f24, f24, this.bR_renamed);
            } else if (i2 == 2) {
                if (this.cr_renamed) {
                    f2 = this.cu_renamed - (this.cf_renamed * 3.0f);
                    f3 = this.ch_renamed;
                } else {
                    f2 = this.cu_renamed;
                    f3 = this.cf_renamed;
                }
                float f25 = f2 - f3;
                if (this.cr_renamed) {
                    f4 = this.cu_renamed;
                    f5 = this.cf_renamed;
                } else {
                    f4 = this.cu_renamed + (this.cf_renamed * 3.0f);
                    f5 = this.ch_renamed;
                }
                float f26 = f4 + f5;
                float f27 = this.ci_renamed;
                float f28 = this.cf_renamed;
                float f29 = this.ch_renamed;
                float f30 = (f27 - (f28 * 3.0f)) - f29;
                float f31 = f27 + (f28 * 3.0f) + f29;
                android.graphics.RectF rectF4 = this.cb_renamed;
                rectF4.left = f25 - ((f25 - f30) * f_renamed);
                rectF4.top = this.ag_renamed - this.cf_renamed;
                android.graphics.RectF rectF5 = this.cb_renamed;
                float f32 = this.ag_renamed;
                float f33 = this.cf_renamed;
                rectF5.bottom = f32 + f33;
                android.graphics.RectF rectF6 = this.cb_renamed;
                rectF6.right = f26 - ((f26 - f31) * f_renamed);
                canvas.drawRoundRect(rectF6, f33, f33, this.bR_renamed);
            } else if (i2 == 1) {
                float f34 = this.ci_renamed;
                float f35 = this.cf_renamed;
                float f36 = this.ch_renamed;
                float f37 = (f34 - (f35 * 3.0f)) - f36;
                float f38 = f34 + (f35 * 3.0f) + f36;
                android.graphics.RectF rectF7 = this.cb_renamed;
                rectF7.left = f37;
                rectF7.top = this.ag_renamed - this.cf_renamed;
                android.graphics.RectF rectF8 = this.cb_renamed;
                float f39 = this.ag_renamed;
                float f40 = this.cf_renamed;
                rectF8.bottom = f39 + f40;
                android.graphics.RectF rectF9 = this.cb_renamed;
                rectF9.right = f38;
                canvas.drawRoundRect(rectF9, f40, f40, this.bR_renamed);
            }
        } else if (i_renamed == 2) {
            if (this.cr_renamed) {
                f10 = this.ci_renamed - (this.cf_renamed * 3.0f);
                f11 = this.ch_renamed;
            } else {
                f10 = this.ci_renamed;
                f11 = this.cf_renamed;
            }
            float f41 = f10 - f11;
            if (this.cr_renamed) {
                f12 = this.ci_renamed;
                f13 = this.cf_renamed;
            } else {
                f12 = this.ci_renamed + (this.cf_renamed * 3.0f);
                f13 = this.ch_renamed;
            }
            float f42 = f12 + f13;
            float f43 = this.cu_renamed;
            float f44 = this.cf_renamed;
            float f45 = this.ch_renamed;
            float f46 = (f43 - (f44 * 3.0f)) - f45;
            float f47 = f43 + (f44 * 3.0f) + f45;
            android.graphics.RectF rectF10 = this.cb_renamed;
            rectF10.left = f46 - ((f46 - f41) * f_renamed);
            rectF10.top = this.ag_renamed - this.cf_renamed;
            android.graphics.RectF rectF11 = this.cb_renamed;
            float f48 = this.ag_renamed;
            float f49 = this.cf_renamed;
            rectF11.bottom = f48 + f49;
            android.graphics.RectF rectF12 = this.cb_renamed;
            rectF12.right = f47 - ((f47 - f42) * f_renamed);
            canvas.drawRoundRect(rectF12, f49, f49, this.bR_renamed);
        } else {
            if (i_renamed != 3) {
                return;
            }
            float f50 = this.cu_renamed;
            float f51 = this.cf_renamed;
            float f52 = this.ch_renamed;
            float f53 = (f50 - (f51 * 3.0f)) - f52;
            float f54 = f50 + (f51 * 3.0f) + f52;
            float f55 = this.cr_renamed ? this.ci_renamed - f51 : (this.ci_renamed - (f51 * 3.0f)) - f52;
            if (this.cr_renamed) {
                f14 = this.ci_renamed + (this.cf_renamed * 3.0f);
                f15 = this.ch_renamed;
            } else {
                f14 = this.ci_renamed;
                f15 = this.cf_renamed;
            }
            float f56 = f14 + f15;
            android.graphics.RectF rectF13 = this.cb_renamed;
            rectF13.left = f53 - ((f53 - f55) * f_renamed);
            rectF13.top = this.ag_renamed - this.cf_renamed;
            android.graphics.RectF rectF14 = this.cb_renamed;
            float f57 = this.ag_renamed;
            float f58 = this.cf_renamed;
            rectF14.bottom = f57 + f58;
            android.graphics.RectF rectF15 = this.cb_renamed;
            rectF15.right = f54 - ((f54 - f56) * f_renamed);
            canvas.drawRoundRect(rectF15, f58, f58, this.bR_renamed);
        }
        if (this.dL_renamed) {
            com.oplus.camera.ui.a_renamed.a_renamed(getContext()).a_renamed(this, canvas, this.cb_renamed, this.dM_renamed);
        }
    }

    private void a_renamed(android.graphics.Canvas canvas, android.graphics.Bitmap bitmap, float f_renamed, float f2, float f3, float f4, float f5, android.graphics.Paint paint) {
        a_renamed(canvas, bitmap, f_renamed, 1.0f, 1.0f, f2, f3, f4, f5, paint);
    }

    private void a_renamed(android.graphics.Canvas canvas, android.graphics.Bitmap bitmap, float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7, android.graphics.Paint paint) {
        canvas.save();
        canvas.rotate(f_renamed, f4, f5);
        canvas.scale(f2, f3, f4, f5);
        a_renamed(canvas, bitmap, f6, f7, paint);
        canvas.restore();
    }

    private void a_renamed(android.graphics.Canvas canvas, java.lang.String str, float f_renamed, float f2, float f3, float f4, float f5, android.graphics.Paint paint) {
        a_renamed(canvas, str, f_renamed, 1.0f, 1.0f, f2, f3, f4, f5, paint);
    }

    private void a_renamed(android.graphics.Canvas canvas, java.lang.String str, float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7, android.graphics.Paint paint) {
        canvas.save();
        canvas.rotate(f_renamed, f4, f5);
        canvas.scale(f2, f3, f4, f5);
        canvas.drawText(str, f6, f7, paint);
        canvas.restore();
    }

    @Override // com.oplus.camera.ui.b_renamed
    protected void b_renamed(android.graphics.Canvas canvas) {
        a_renamed(canvas, this.ci_renamed, this.ag_renamed, 0.0f);
        if (!this.df_renamed.isRunning()) {
            a_renamed(canvas, this.cV_renamed, this.ci_renamed, this.ag_renamed, this.cs_renamed);
        } else {
            a_renamed(canvas, this.cV_renamed, this.ci_renamed, this.ag_renamed);
        }
        super.b_renamed(canvas);
    }

    protected void a_renamed(android.graphics.Canvas canvas, java.lang.String str, float f_renamed, float f2, int i_renamed) {
        float f3;
        float f4;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (i_renamed == 0) {
            return;
        }
        w_renamed();
        int currentBarIndex = getCurrentBarIndex();
        int iA = a_renamed(this.cw_renamed, this.cE_renamed);
        if (this.aA_renamed && !this.aB_renamed) {
            iA++;
        } else if (!this.aA_renamed && this.aB_renamed) {
            iA--;
        }
        int i10 = iA;
        boolean z_renamed = this.J_renamed < 0.999f;
        int iRound = java.lang.Math.round(this.J_renamed * 255.0f);
        int iRound2 = java.lang.Math.round((1.0f - this.J_renamed) * 255.0f);
        if (this.S_renamed == 0) {
            this.aj_renamed.setAlpha(255);
            this.bQ_renamed.setAlpha(255);
        }
        if (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY || this.dE_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY) {
            f3 = this.J_renamed;
            f4 = 1.0f - this.J_renamed;
        } else {
            f3 = 1.0f;
            f4 = 1.0f;
        }
        if (!this.aB_renamed) {
            i2 = iRound;
            i3 = i10;
            i4 = iRound2;
        } else if (z_renamed) {
            if (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL && currentBarIndex == 1) {
                this.aj_renamed.setAlpha(iRound);
                float f5 = -this.aV_renamed;
                float f6 = this.cj_renamed;
                i9 = iRound2;
                i2 = iRound;
                a_renamed(canvas, str, f5, f3, f3, f6, f2, f6, f2 + this.ba_renamed, this.aj_renamed);
            } else {
                i9 = iRound2;
                i2 = iRound;
                this.bQ_renamed.setAlpha(i2);
                android.graphics.Bitmap bitmap = this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE);
                float f7 = -this.aV_renamed;
                float f8 = this.cj_renamed;
                a_renamed(canvas, bitmap, f7, f3, f3, f8, f2, f8, f2, this.bQ_renamed);
            }
            if (this.dE_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL && i10 == 1) {
                int i11 = i9;
                this.aj_renamed.setAlpha(i11);
                java.lang.String str2 = this.cW_renamed;
                float f9 = -this.aV_renamed;
                float f10 = this.cj_renamed;
                i3 = i10;
                i4 = i11;
                a_renamed(canvas, str2, f9, f4, f4, f10, f2, f10, f2 + this.ba_renamed, this.aj_renamed);
            } else {
                i3 = i10;
                i4 = i9;
                android.graphics.Bitmap bitmap2 = this.ce_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE);
                if (!this.aA_renamed) {
                    bitmap2 = this.ce_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE);
                }
                this.bQ_renamed.setAlpha(i4);
                float f11 = -this.aV_renamed;
                float f12 = this.cj_renamed;
                a_renamed(canvas, bitmap2, f11, f4, f4, f12, f2, f12, f2, this.bQ_renamed);
            }
        } else {
            i2 = iRound;
            i3 = i10;
            i4 = iRound2;
            if (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL && currentBarIndex == 1) {
                float f13 = -this.aV_renamed;
                float f14 = this.cj_renamed;
                a_renamed(canvas, str, f13, f14, f2, f14, f2 + this.ba_renamed, this.aj_renamed);
            } else {
                android.graphics.Bitmap bitmap3 = this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE);
                float f15 = -this.aV_renamed;
                float f16 = this.cj_renamed;
                a_renamed(canvas, bitmap3, f15, f16, f2, f16, f2, this.bQ_renamed);
            }
        }
        if (z_renamed) {
            if (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL && currentBarIndex == 2) {
                this.aj_renamed.setAlpha(i2);
                float f17 = -this.aV_renamed;
                float f18 = this.ci_renamed;
                i7 = currentBarIndex;
                i8 = 2;
                a_renamed(canvas, str, f17, f3, f3, f18, f2, f18, f2 + this.ba_renamed, this.aj_renamed);
            } else {
                i7 = currentBarIndex;
                i8 = 2;
                this.bQ_renamed.setAlpha(i2);
                android.graphics.Bitmap bitmap4 = this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE);
                float f19 = -this.aV_renamed;
                float f20 = this.ci_renamed;
                a_renamed(canvas, bitmap4, f19, f3, f3, f20, f2, f20, f2, this.bQ_renamed);
            }
            if (this.dE_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL) {
                int i12 = i3;
                if (i12 == i8) {
                    this.aj_renamed.setAlpha(i4);
                    java.lang.String str3 = this.cW_renamed;
                    float f21 = -this.aV_renamed;
                    float f22 = this.ci_renamed;
                    i5 = i12;
                    a_renamed(canvas, str3, f21, f4, f4, f22, f2, f22, f2 + this.ba_renamed, this.aj_renamed);
                    i6 = i7;
                } else {
                    i5 = i12;
                }
            } else {
                i5 = i3;
            }
            android.graphics.Bitmap bitmap5 = this.ce_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE);
            if (!this.aA_renamed && this.aB_renamed) {
                bitmap5 = this.ce_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE);
            }
            this.bQ_renamed.setAlpha(i4);
            float f23 = -this.aV_renamed;
            float f24 = this.ci_renamed;
            a_renamed(canvas, bitmap5, f23, f4, f4, f24, f2, f24, f2, this.bQ_renamed);
            i6 = i7;
        } else {
            i5 = i3;
            if (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL) {
                i6 = currentBarIndex;
                if (i6 == 2) {
                    float f25 = -this.aV_renamed;
                    float f26 = this.ci_renamed;
                    a_renamed(canvas, str, f25, f26, f2, f26, f2 + this.ba_renamed, this.aj_renamed);
                }
            } else {
                i6 = currentBarIndex;
            }
            android.graphics.Bitmap bitmap6 = this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE);
            float f27 = -this.aV_renamed;
            float f28 = this.ci_renamed;
            a_renamed(canvas, bitmap6, f27, f28, f2, f28, f2, this.bQ_renamed);
        }
        if (this.az_renamed) {
            if (z_renamed) {
                if (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL && i6 == 3) {
                    this.aj_renamed.setAlpha(i2);
                    float f29 = -this.aV_renamed;
                    float f30 = this.cn_renamed;
                    a_renamed(canvas, str, f29, f3, f3, f30, f2, f30, f2 + this.ba_renamed, this.aj_renamed);
                } else {
                    this.bQ_renamed.setAlpha(i2);
                    android.graphics.Bitmap bitmap7 = this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE);
                    float f31 = -this.aV_renamed;
                    float f32 = this.cn_renamed;
                    a_renamed(canvas, bitmap7, f31, f3, f3, f32, f2, f32, f2, this.bQ_renamed);
                }
                if (this.dE_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL && i5 == 3) {
                    this.aj_renamed.setAlpha(i4);
                    java.lang.String str4 = this.cW_renamed;
                    float f33 = -this.aV_renamed;
                    float f34 = this.cn_renamed;
                    a_renamed(canvas, str4, f33, f4, f4, f34, f2, f34, f2 + this.ba_renamed, this.aj_renamed);
                } else {
                    android.graphics.Bitmap bitmap8 = this.ce_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE);
                    if (!this.ay_renamed) {
                        bitmap8 = this.ce_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE);
                    }
                    this.bQ_renamed.setAlpha(i4);
                    float f35 = -this.aV_renamed;
                    float f36 = this.cn_renamed;
                    a_renamed(canvas, bitmap8, f35, f4, f4, f36, f2, f36, f2, this.bQ_renamed);
                }
            } else if (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL && i6 == 3) {
                float f37 = -this.aV_renamed;
                float f38 = this.cn_renamed;
                a_renamed(canvas, str, f37, f3, f3, f38, f2, f38, f2 + this.ba_renamed, this.aj_renamed);
            } else {
                android.graphics.Bitmap bitmap9 = this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE);
                float f39 = -this.aV_renamed;
                float f40 = this.cn_renamed;
                a_renamed(canvas, bitmap9, f39, f3, f3, f40, f2, f40, f2, this.bQ_renamed);
            }
        }
        canvas.save();
        a_renamed(canvas, getOvalCenterX(), f2);
        canvas.restore();
    }

    protected void a_renamed(android.graphics.Canvas canvas, java.lang.String str, float f_renamed, float f2) {
        w_renamed();
        int currentBarIndex = getCurrentBarIndex();
        int slideToBarIndex = getSlideToBarIndex();
        if (java.lang.Float.compare(this.cZ_renamed, -1.0f) == 0) {
            float f3 = this.de_renamed;
            if (f3 <= 0.0f) {
                f3 = f_renamed;
            }
            this.cZ_renamed = f3;
        }
        if (this.aB_renamed) {
            canvas.save();
            canvas.translate(this.cj_renamed - f_renamed, 0.0f);
            canvas.rotate(-this.aV_renamed, f_renamed, f2);
            int i_renamed = com.oplus.camera.ui.preview.ai_renamed.ParameterContainer_6.f7010a[this.dD_renamed.ordinal()];
            if (i_renamed != 1) {
                if (i_renamed == 2) {
                    this.bQ_renamed.setAlpha(255);
                    canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE), f_renamed - this.cl_renamed, f2 - this.cm_renamed, this.bQ_renamed);
                }
            } else if (slideToBarIndex == 1) {
                this.bQ_renamed.setAlpha(this.dJ_renamed);
                this.aj_renamed.setAlpha(this.dH_renamed);
                canvas.drawText(this.cY_renamed, f_renamed, (this.ba_renamed + f2) - this.dG_renamed, this.aj_renamed);
                canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE), f_renamed - this.cl_renamed, (f2 - this.cm_renamed) + this.dI_renamed, this.bQ_renamed);
            } else if (currentBarIndex == 1) {
                this.bQ_renamed.setAlpha(this.dH_renamed);
                this.aj_renamed.setAlpha(this.dJ_renamed);
                canvas.drawText(this.cV_renamed, f_renamed, (this.ba_renamed + f2) - this.dI_renamed, this.aj_renamed);
                canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE), f_renamed - this.cl_renamed, (f2 - this.cm_renamed) + this.dG_renamed, this.bQ_renamed);
            } else {
                this.bQ_renamed.setAlpha(255);
                canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE), f_renamed - this.cl_renamed, f2 - this.cm_renamed, this.bQ_renamed);
            }
            canvas.restore();
        }
        canvas.save();
        canvas.rotate(-this.aV_renamed, f_renamed, f2);
        int i2 = com.oplus.camera.ui.preview.ai_renamed.ParameterContainer_6.f7010a[this.dD_renamed.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                this.bQ_renamed.setAlpha(255);
                canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE), f_renamed - this.cl_renamed, f2 - this.cm_renamed, this.bQ_renamed);
            }
        } else if (slideToBarIndex == 2) {
            this.bQ_renamed.setAlpha(this.dJ_renamed);
            this.aj_renamed.setAlpha(this.dH_renamed);
            canvas.drawText(this.cY_renamed, f_renamed, (this.ba_renamed + f2) - this.dG_renamed, this.aj_renamed);
            canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE), f_renamed - this.cl_renamed, (f2 - this.cm_renamed) + this.dI_renamed, this.bQ_renamed);
        } else if (currentBarIndex == 2) {
            this.bQ_renamed.setAlpha(this.dH_renamed);
            this.aj_renamed.setAlpha(this.dJ_renamed);
            canvas.drawText(this.cV_renamed, f_renamed, (this.ba_renamed + f2) - this.dI_renamed, this.aj_renamed);
            canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE), f_renamed - this.cl_renamed, (f2 - this.cm_renamed) + this.dG_renamed, this.bQ_renamed);
        } else {
            this.bQ_renamed.setAlpha(255);
            canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE), f_renamed - this.cl_renamed, f2 - this.cm_renamed, this.bQ_renamed);
        }
        canvas.restore();
        if (this.az_renamed) {
            canvas.save();
            canvas.translate(this.cn_renamed - f_renamed, 0.0f);
            canvas.rotate(-this.aV_renamed, f_renamed, f2);
            int i3 = com.oplus.camera.ui.preview.ai_renamed.ParameterContainer_6.f7010a[this.dD_renamed.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    this.bQ_renamed.setAlpha(255);
                    canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE), f_renamed - this.cp_renamed, f2 - this.cq_renamed, this.bQ_renamed);
                }
            } else if (slideToBarIndex == 3) {
                this.bQ_renamed.setAlpha(this.dJ_renamed);
                this.aj_renamed.setAlpha(this.dH_renamed);
                canvas.drawText(this.cY_renamed, f_renamed, (this.ba_renamed + f2) - this.dG_renamed, this.aj_renamed);
                canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE), f_renamed - this.cl_renamed, (f2 - this.cm_renamed) + this.dI_renamed, this.bQ_renamed);
            } else if (currentBarIndex == 3) {
                this.bQ_renamed.setAlpha(this.dH_renamed);
                this.aj_renamed.setAlpha(this.dJ_renamed);
                canvas.drawText(this.cV_renamed, f_renamed, (this.ba_renamed + f2) - this.dI_renamed, this.aj_renamed);
                canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE), f_renamed - this.cl_renamed, (f2 - this.cm_renamed) + this.dG_renamed, this.bQ_renamed);
            } else {
                this.bQ_renamed.setAlpha(255);
                canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE), f_renamed - this.cp_renamed, f2 - this.cq_renamed, this.bQ_renamed);
            }
            canvas.restore();
        }
        if (currentBarIndex == 1) {
            this.cZ_renamed = this.cj_renamed;
        } else if (currentBarIndex == 2) {
            this.cZ_renamed = this.ci_renamed;
        } else if (currentBarIndex == 3) {
            this.cZ_renamed = this.cn_renamed;
        }
        if (slideToBarIndex == 1) {
            this.de_renamed = this.cj_renamed;
        } else if (slideToBarIndex == 2) {
            this.de_renamed = this.ci_renamed;
        } else if (slideToBarIndex == 3) {
            this.de_renamed = this.cn_renamed;
        }
        float f4 = this.cZ_renamed;
        this.da_renamed = f4 - ((f4 - this.de_renamed) * this.dK_renamed);
        if (java.lang.Float.compare(-1.0f, this.N_renamed) != 0) {
            this.da_renamed = this.N_renamed - ((this.N_renamed - this.de_renamed) * this.dK_renamed);
        }
        a_renamed(canvas, this.da_renamed, f2);
    }

    protected int getSlideToBarIndex() {
        return a_renamed(this.aQ_renamed, this.bK_renamed);
    }

    protected int getCurrentBarIndex() {
        if (1 == this.S_renamed || 2 == this.S_renamed) {
            return a_renamed(this.aO_renamed, this.bK_renamed);
        }
        if (9 == this.S_renamed || 8 == this.S_renamed) {
            return a_renamed(this.aP_renamed, this.bK_renamed);
        }
        return a_renamed(this.aN_renamed, this.bK_renamed);
    }

    protected int a_renamed(int i_renamed) {
        return a_renamed(i_renamed, this.bK_renamed);
    }

    protected int a_renamed(int i_renamed, java.util.ArrayList<java.lang.Float> arrayList) {
        if (i_renamed < 0 || arrayList == null || arrayList.size() <= i_renamed) {
            return 0;
        }
        float fFloatValue = arrayList.get(i_renamed).floatValue();
        if (java.lang.Float.compare(fFloatValue, 1.0f) < 0) {
            return 1;
        }
        if (java.lang.Float.compare(fFloatValue, 1.0f) < 0 || java.lang.Float.compare(fFloatValue, 2.0f) >= 0) {
            return java.lang.Float.compare(fFloatValue, 2.0f) >= 0 ? 3 : 0;
        }
        return 2;
    }

    protected void a_renamed(android.graphics.Canvas canvas, float f_renamed, float f2) {
        canvas.drawCircle(f_renamed, f2, this.cf_renamed, this.bS_renamed);
    }

    protected void a_renamed(android.graphics.Canvas canvas, float f_renamed, float f2, float f3) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        int i_renamed = this.cs_renamed;
        if (i_renamed == 1) {
            android.graphics.RectF rectF = this.cb_renamed;
            float f10 = this.cf_renamed;
            float f11 = this.ch_renamed;
            rectF.left = ((f_renamed - (f10 * 3.0f)) - f11) + (((f10 * 2.0f) + f11) * f3);
            rectF.top = f2 - f10;
            rectF.bottom = f2 + f10;
            rectF.right = ((f_renamed + (3.0f * f10)) + f11) - (f3 * ((2.0f * f10) + f11));
            canvas.drawRoundRect(rectF, f10, f10, this.bR_renamed);
        } else if (i_renamed == 2) {
            android.graphics.RectF rectF2 = this.cb_renamed;
            if (this.cr_renamed) {
                float f12 = this.cf_renamed;
                float f13 = this.ch_renamed;
                f5 = (f_renamed - (f12 * 3.0f)) - f13;
                f4 = f12 + f13;
            } else {
                f4 = this.cf_renamed;
                f5 = f_renamed - f4;
            }
            rectF2.left = f5 + (f4 * f3);
            android.graphics.RectF rectF3 = this.cb_renamed;
            float f14 = this.cf_renamed;
            rectF3.top = f2 - f14;
            rectF3.bottom = f2 + f14;
            if (this.cr_renamed) {
                f6 = f_renamed + f14;
            } else {
                float f15 = this.ch_renamed;
                f6 = f_renamed + (3.0f * f14) + f15;
                f14 += f15;
            }
            rectF3.right = f6 - (f3 * f14);
            android.graphics.RectF rectF4 = this.cb_renamed;
            float f16 = this.cf_renamed;
            canvas.drawRoundRect(rectF4, f16, f16, this.bR_renamed);
        } else {
            if (i_renamed != 3) {
                return;
            }
            android.graphics.RectF rectF5 = this.cb_renamed;
            if (this.cr_renamed) {
                float f17 = this.cf_renamed;
                f8 = f_renamed - f17;
                f7 = f17 + this.ch_renamed;
            } else {
                f7 = this.cf_renamed;
                f8 = (f_renamed - (f7 * 3.0f)) - this.ch_renamed;
            }
            rectF5.left = f8 + (f7 * f3);
            android.graphics.RectF rectF6 = this.cb_renamed;
            float f18 = this.cf_renamed;
            rectF6.top = f2 - f18;
            rectF6.bottom = f2 + f18;
            if (this.cr_renamed) {
                f9 = f_renamed + (3.0f * f18) + this.ch_renamed;
            } else {
                f9 = f_renamed + f18;
                f18 += this.ch_renamed;
            }
            rectF6.right = f9 - (f3 * f18);
            android.graphics.RectF rectF7 = this.cb_renamed;
            float f19 = this.cf_renamed;
            canvas.drawRoundRect(rectF7, f19, f19, this.bR_renamed);
        }
        if (this.dL_renamed) {
            com.oplus.camera.ui.a_renamed.a_renamed(getContext()).a_renamed(this, canvas, this.cb_renamed, this.dM_renamed);
        }
    }

    @Override // com.oplus.camera.ui.b_renamed
    protected void g_renamed(android.graphics.Canvas canvas) {
        if (0.0f >= this.z_renamed) {
            y_renamed();
        }
        super.g_renamed(canvas);
    }

    public void a_renamed(float f_renamed, boolean z_renamed) {
        float fA_renamed = com.oplus.camera.util.Util.a_renamed(f_renamed, 0.0f, 1.0f);
        if (1 == getLayoutDirection()) {
            fA_renamed = com.oplus.camera.util.Util.a_renamed(1.0f, fA_renamed);
        }
        float fC_renamed = c_renamed(fA_renamed);
        this.cW_renamed = this.cV_renamed;
        setCurrentDisplayText(fC_renamed);
        if (this.al_renamed != null) {
            this.al_renamed.a_renamed(fC_renamed, z_renamed);
        }
        setCenterPointIndex(h_renamed(fC_renamed));
        this.aQ_renamed = this.aN_renamed;
        com.oplus.camera.e_renamed.a_renamed("ZoomSeekBar", "onChanged, mCurrentDisplayText: " + this.cV_renamed + ", zoom: " + fC_renamed);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(getContext().getResources().getString(com.oplus.camera.R_renamed.string.camera_description_zoom_seek_bar));
        sb.append(this.cV_renamed);
        setContentDescription(sb.toString());
        invalidate();
    }

    private float c_renamed(float f_renamed, float f2) {
        float fA_renamed;
        float fMin = java.lang.Math.min(f_renamed, f2);
        float fMax = java.lang.Math.max(f_renamed, f2);
        if (java.lang.Float.compare(fMin, fMax) == 0) {
            return -1.0f;
        }
        for (int i_renamed = 0; i_renamed < this.bL_renamed.length; i_renamed++) {
            if (1 == getLayoutDirection()) {
                float[] fArr = this.bL_renamed;
                fA_renamed = com.oplus.camera.util.Util.a_renamed(1.0f, fArr[(fArr.length - 1) - i_renamed]);
            } else {
                fA_renamed = this.bL_renamed[i_renamed];
            }
            if ((java.lang.Float.compare(fA_renamed, f2) > 0 && java.lang.Float.compare(fA_renamed, f_renamed) <= 0) || (java.lang.Float.compare(fA_renamed, f2) < 0 && java.lang.Float.compare(fA_renamed, f_renamed) >= 0)) {
                return fA_renamed;
            }
            if (java.lang.Float.compare(fA_renamed, fMax) > 0) {
                return -1.0f;
            }
        }
        return -1.0f;
    }

    private android.graphics.Bitmap a_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed bVar) {
        int iA = a_renamed(this.cw_renamed, this.cE_renamed);
        int i_renamed = com.oplus.camera.ui.preview.ai_renamed.ParameterContainer_6.f7011b[bVar.ordinal()];
        if (i_renamed != 1) {
            if (i_renamed != 2) {
                if (i_renamed == 3) {
                    if (!this.ay_renamed) {
                        return null;
                    }
                    if (this.dE_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL && iA == 3 && !this.bl_renamed) {
                        return null;
                    }
                }
            } else if (this.dE_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL && iA == 2 && !this.bl_renamed) {
                return null;
            }
        } else {
            if (!this.aA_renamed) {
                return null;
            }
            if (this.dE_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL && iA == 1) {
                return null;
            }
        }
        return this.ce_renamed.get(bVar);
    }

    /* compiled from: ZoomSeekBar.java */
    /* renamed from: com.oplus.camera.ui.preview.ai_renamed$3, reason: invalid class name */
    static /* synthetic */ class ParameterContainer_6 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f7010a;

        /* renamed from: b_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f7011b = new int[com.oplus.camera.ui.preview.ai_renamed.b_renamed.values().length];

        static {
            try {
                f7011b[com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f7011b[com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f7011b[com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            f7010a = new int[com.oplus.camera.ui.preview.ai_renamed.a_renamed.values().length];
            try {
                f7010a[com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                f7010a[com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    private android.graphics.Bitmap b_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed bVar) {
        int iA = a_renamed(this.cy_renamed);
        int i_renamed = com.oplus.camera.ui.preview.ai_renamed.ParameterContainer_6.f7011b[bVar.ordinal()];
        if (i_renamed != 1) {
            if (i_renamed != 2) {
                if (i_renamed == 3) {
                    if (!this.az_renamed) {
                        return null;
                    }
                    if (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL && iA == 3 && !this.bk_renamed) {
                        return null;
                    }
                }
            } else if (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL && iA == 2 && !this.bk_renamed) {
                return null;
            }
        } else {
            if (!this.aB_renamed) {
                return null;
            }
            if (this.dD_renamed == com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL && iA == 1) {
                return null;
            }
        }
        return this.cd_renamed.get(bVar);
    }

    private float getOvalCenterX() {
        int currentBarIndex = getCurrentBarIndex();
        if (currentBarIndex == 1) {
            return this.cj_renamed;
        }
        if (currentBarIndex == 2) {
            return this.ci_renamed;
        }
        if (currentBarIndex == 3) {
            return this.cn_renamed;
        }
        return this.ci_renamed;
    }

    private boolean c_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed bVar) {
        return this.aA_renamed && this.ay_renamed;
    }

    private boolean d_renamed(com.oplus.camera.ui.preview.ai_renamed.b_renamed bVar) {
        if (bVar != com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE || this.aB_renamed) {
            return bVar != com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE || this.az_renamed;
        }
        return false;
    }

    public void c_renamed(int i_renamed, boolean z_renamed) {
        int i2;
        if (i_renamed >= 0) {
            i2 = i_renamed % 360;
        } else {
            i2 = (i_renamed % 360) + 360;
        }
        if (i2 == this.aX_renamed) {
            return;
        }
        this.aX_renamed = i2;
        if (z_renamed) {
            this.aW_renamed = this.aV_renamed;
            this.f2do = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.aX_renamed - this.aV_renamed;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.bh_renamed = i3 >= 0;
            this.dp_renamed = this.f2do + ((java.lang.Math.abs(i3) * 1000) / 360);
        } else {
            this.aV_renamed = this.aX_renamed;
        }
        invalidate();
    }

    protected void a_renamed(int i_renamed, float f_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ZoomSeekBar", "startSlideTo, centerPointIndex: " + i_renamed + ", toValue: " + f_renamed);
        if ((C_renamed() && i_renamed == this.aQ_renamed) || (!C_renamed() && i_renamed == this.aN_renamed)) {
            if (this.cV_renamed.equals(a_renamed(f_renamed(f_renamed)))) {
                return;
            }
            b_renamed(f_renamed, false);
            return;
        }
        if (9 == this.S_renamed || 8 == this.S_renamed || 10 == this.S_renamed) {
            setCenterPointIndex(this.aQ_renamed);
            this.cW_renamed = this.cV_renamed;
            setCurrentDisplayText(this.aR_renamed);
            b_renamed(this.aS_renamed, false);
            return;
        }
        if ((!C_renamed() && a_renamed(i_renamed) == a_renamed(this.aN_renamed)) || i_renamed == a_renamed(i_renamed)) {
            setCenterPointIndex(i_renamed);
            if (this.cV_renamed.equals(a_renamed(f_renamed(f_renamed)))) {
                return;
            }
            b_renamed(f_renamed, false);
            return;
        }
        if (this.df_renamed.isRunning()) {
            this.df_renamed.cancel();
            this.N_renamed = this.da_renamed;
        }
        this.aZ_renamed = 0.0f;
        this.aQ_renamed = i_renamed;
        this.aR_renamed = f_renamed;
        this.aS_renamed = f_renamed;
        this.cZ_renamed = -1.0f;
        this.df_renamed.start();
    }

    public void d_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ZoomSeekBar", "startSlideToWhenFront, centerPointIndex: " + i_renamed);
        boolean z2 = this.aN_renamed != i_renamed;
        if (this.df_renamed.isRunning()) {
            z2 = this.aQ_renamed != i_renamed;
        }
        if (this.al_renamed == null || -1 == i_renamed || !z2) {
            return;
        }
        if (this.df_renamed.isRunning()) {
            this.df_renamed.cancel();
            this.N_renamed = this.da_renamed;
        }
        this.bu_renamed = i_renamed == 0 ? 1.0f : 1.17f;
        if (z_renamed) {
            this.al_renamed.a_renamed(this.bu_renamed);
        }
        this.aZ_renamed = 0.0f;
        this.aQ_renamed = i_renamed;
        this.cZ_renamed = -1.0f;
        this.df_renamed.start();
        this.cT_renamed = true;
        this.aR_renamed = 1.0f;
        this.aS_renamed = 1.0f;
        invalidate();
    }

    public boolean z_renamed() {
        return getVisibility() == 0 && (3 == this.S_renamed || 6 == this.S_renamed);
    }

    public boolean A_renamed() {
        if (getVisibility() == 0) {
            return 2 == this.S_renamed || 1 == this.S_renamed;
        }
        return false;
    }

    public boolean B_renamed() {
        android.animation.AnimatorSet animatorSet;
        return getVisibility() == 0 && this.S_renamed == 0 && (animatorSet = this.df_renamed) != null && animatorSet.isRunning();
    }

    public float getVelocityRate() {
        return this.at_renamed;
    }

    public boolean C_renamed() {
        android.animation.AnimatorSet animatorSet = this.df_renamed;
        if (animatorSet != null) {
            return animatorSet.isRunning();
        }
        return false;
    }

    public void setZoomListener(com.oplus.camera.ui.preview.ag_renamed agVar) {
        this.bO_renamed = agVar;
    }

    public void setZoomValueUnit(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ZoomSeekBar", "setZoomValueUnit, zoomUnitvalue: " + z_renamed);
        this.bp_renamed = z_renamed;
    }

    public boolean getZoomValueUnit() {
        com.oplus.camera.e_renamed.a_renamed("ZoomSeekBar", "getZoomValueUnit, mbZoomUnit: " + this.bp_renamed);
        return this.bp_renamed;
    }

    protected void setCenterPointIndex(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ZoomSeekBar", "setCenterPointIndex, index: " + i_renamed);
        this.aN_renamed = i_renamed;
    }

    public void b_renamed(float f_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ZoomSeekBar", "updateUI, zoomValue: " + f_renamed + ", rest: " + this.df_renamed.isRunning());
        if (this.bk_renamed) {
            return;
        }
        if (this.df_renamed.isRunning()) {
            this.aS_renamed = f_renamed;
            return;
        }
        if (z_renamed && A_renamed()) {
            this.an_renamed.removeMessages(1);
            this.an_renamed.sendEmptyMessageDelayed(1, getCollapseDelay());
        }
        float fG_renamed = g_renamed(f_renamed);
        if (java.lang.Float.compare(fG_renamed, -0.042f) < 0) {
            fG_renamed = -0.042f;
        } else if (java.lang.Float.compare(fG_renamed, 1.042f) > 0) {
            fG_renamed = 1.042f;
        }
        if (1 == getLayoutDirection()) {
            setRate(1.0f - fG_renamed);
        } else {
            setRate(fG_renamed);
        }
        int iH = h_renamed(f_renamed);
        if (iH != this.aN_renamed) {
            if (this.S_renamed == 0 && !this.bO_renamed.e_renamed()) {
                a_renamed(iH, f_renamed);
                return;
            } else {
                setCenterPointIndex(iH);
                this.aQ_renamed = this.aN_renamed;
            }
        }
        this.cW_renamed = this.cV_renamed;
        setCurrentDisplayText(f_renamed);
        com.oplus.camera.e_renamed.a_renamed("ZoomSeekBar", "updateUI, mCurrentDisplayText: " + this.cV_renamed + ", rate: " + fG_renamed);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(getContext().getResources().getString(com.oplus.camera.R_renamed.string.camera_description_zoom_seek_bar));
        sb.append(this.cV_renamed);
        setContentDescription(sb.toString());
        postInvalidate();
    }

    protected boolean b_renamed(float f_renamed) {
        int i_renamed = 0;
        while (true) {
            float[] fArr = this.bL_renamed;
            if (i_renamed >= fArr.length) {
                return false;
            }
            if (java.lang.Math.abs(f_renamed - fArr[i_renamed]) <= 1.0E-5f) {
                return true;
            }
            i_renamed++;
        }
    }

    public float b_renamed(int i_renamed) {
        return this.bK_renamed.get(i_renamed).floatValue();
    }

    public float c_renamed(float f_renamed) {
        float fD_renamed = d_renamed(f_renamed);
        java.util.ArrayList<java.lang.Integer> arrayList = this.by_renamed;
        float fIntValue = arrayList.get(arrayList.size() - 1).intValue();
        if (fD_renamed > fIntValue) {
            fD_renamed = fIntValue;
        }
        float fFloatValue = 0.0f;
        int i_renamed = 1;
        while (true) {
            if (i_renamed >= this.bv_renamed.size()) {
                break;
            }
            if (fD_renamed <= this.by_renamed.get(i_renamed).intValue()) {
                int i2 = i_renamed - 1;
                fFloatValue = this.bv_renamed.get(i2).floatValue() + (this.bw_renamed.get(i2).floatValue() * (fD_renamed - this.by_renamed.get(i2).intValue()));
                break;
            }
            i_renamed++;
        }
        return java.lang.Math.round(fFloatValue * 10000.0f) / 10000.0f;
    }

    public float getTotleAngle() {
        I_renamed();
        J_renamed();
        float fFloatValue = 0.0f;
        int i_renamed = 0;
        while (i_renamed < this.bw_renamed.size()) {
            int i2 = i_renamed + 1;
            fFloatValue += ((this.bv_renamed.get(i2).floatValue() - this.bv_renamed.get(i_renamed).floatValue()) / this.bw_renamed.get(i_renamed).floatValue()) * this.bx_renamed.get(i_renamed).floatValue();
            i_renamed = i2;
        }
        return fFloatValue;
    }

    private void I_renamed() {
        if (this.bv_renamed != null) {
            this.bv_renamed = null;
        }
        this.bv_renamed = getZoomSections();
    }

    private void J_renamed() {
        if (this.bx_renamed != null) {
            this.bx_renamed = null;
        }
        this.bw_renamed = getSectionStep();
    }

    public float d_renamed(float f_renamed) {
        float totleAngle = f_renamed * getTotleAngle();
        float fFloatValue = 0.0f;
        int i_renamed = 0;
        while (i_renamed < this.bw_renamed.size()) {
            int i2 = i_renamed + 1;
            float fFloatValue2 = ((this.bv_renamed.get(i2).floatValue() - this.bv_renamed.get(i_renamed).floatValue()) / this.bw_renamed.get(i_renamed).floatValue()) * this.bx_renamed.get(i_renamed).floatValue();
            if (totleAngle <= fFloatValue2) {
                return fFloatValue + (totleAngle / this.bx_renamed.get(i_renamed).floatValue());
            }
            totleAngle -= fFloatValue2;
            fFloatValue += (this.bv_renamed.get(i2).floatValue() - this.bv_renamed.get(i_renamed).floatValue()) / this.bw_renamed.get(i_renamed).floatValue();
            i_renamed = i2;
        }
        return fFloatValue;
    }

    public float e_renamed(float f_renamed) {
        float totleAngle = getTotleAngle();
        J_renamed();
        int i_renamed = 0;
        float fFloatValue = 0.0f;
        while (true) {
            if (i_renamed >= this.bw_renamed.size()) {
                break;
            }
            int i2 = i_renamed + 1;
            float fRound = java.lang.Math.round((this.bv_renamed.get(i2).floatValue() - this.bv_renamed.get(i_renamed).floatValue()) / this.bw_renamed.get(i_renamed).floatValue());
            if (f_renamed <= fRound) {
                fFloatValue += f_renamed * this.bx_renamed.get(i_renamed).floatValue();
                break;
            }
            f_renamed -= fRound;
            fFloatValue += fRound * this.bx_renamed.get(i_renamed).floatValue();
            i_renamed = i2;
        }
        float f2 = fFloatValue / totleAngle;
        if (java.lang.Float.isNaN(f2)) {
            return 0.0f;
        }
        return f2;
    }

    public float f_renamed(float f_renamed) {
        return com.oplus.camera.ag_renamed.a_renamed(f_renamed, this.bM_renamed);
    }

    public float g_renamed(float f_renamed) {
        float f2;
        if (this.bv_renamed == null) {
            this.bv_renamed = getZoomSections();
        }
        if (this.bw_renamed == null) {
            this.bw_renamed = getSectionStep();
        }
        if (this.by_renamed == null) {
            this.by_renamed = getIndicatorSections();
        }
        int i_renamed = 1;
        while (true) {
            f2 = 0.0f;
            if (i_renamed >= this.bv_renamed.size()) {
                break;
            }
            if (f_renamed <= this.bv_renamed.get(i_renamed).floatValue()) {
                int i2 = i_renamed - 1;
                float fFloatValue = (f_renamed - this.bv_renamed.get(i2).floatValue()) / (this.bv_renamed.get(i_renamed).floatValue() - this.bv_renamed.get(i2).floatValue());
                float fIntValue = this.by_renamed.get(i2).intValue();
                float fIntValue2 = this.by_renamed.get(i_renamed).intValue() - this.by_renamed.get(i2).intValue();
                if (java.lang.Float.isNaN(fFloatValue)) {
                    fFloatValue = 0.0f;
                }
                f2 = fIntValue + (fIntValue2 * fFloatValue);
            } else {
                i_renamed++;
            }
        }
        return e_renamed(f2);
    }

    public float getCurrentZoom() {
        float fC_renamed = c_renamed(1 == getLayoutDirection() ? 1.0f - this.ad_renamed : this.ad_renamed);
        float f_renamed = this.bs_renamed;
        if (this.bi_renamed) {
            f_renamed = com.oplus.camera.ag_renamed.f4106a;
        }
        if (fC_renamed < f_renamed) {
            return f_renamed;
        }
        float f2 = this.bt_renamed;
        return fC_renamed > f2 ? f2 : fC_renamed;
    }

    public java.util.ArrayList<java.lang.Integer> getIndicatorSections() {
        int size = this.bv_renamed.size();
        java.util.ArrayList<java.lang.Integer> arrayList = new java.util.ArrayList<>();
        arrayList.add(0);
        for (int i_renamed = 1; i_renamed < size; i_renamed++) {
            int i2 = i_renamed - 1;
            arrayList.add(i_renamed, java.lang.Integer.valueOf(java.lang.Math.round((this.bv_renamed.get(i_renamed).floatValue() - this.bv_renamed.get(i2).floatValue()) / this.bw_renamed.get(i2).floatValue()) + arrayList.get(i2).intValue()));
        }
        return arrayList;
    }

    public java.util.ArrayList<java.lang.Float> getZoomSections() {
        com.oplus.camera.ui.preview.ag_renamed agVar;
        java.util.ArrayList<java.lang.Float> arrayList = new java.util.ArrayList<>();
        if (java.lang.Float.compare(this.bs_renamed, 1.0f) < 0) {
            arrayList.add(java.lang.Float.valueOf(this.bs_renamed));
        } else if (this.bi_renamed) {
            arrayList.add(java.lang.Float.valueOf(com.oplus.camera.ag_renamed.f4106a));
        }
        if (java.lang.Float.compare(this.bs_renamed, 1.0f) <= 0) {
            arrayList.add(java.lang.Float.valueOf(1.0f));
        }
        if (java.lang.Float.compare(this.bt_renamed, 4.0f) > 0) {
            arrayList.add(java.lang.Float.valueOf(2.0f));
        }
        if (java.lang.Float.compare(this.bt_renamed, 4.0f) > 0 && (agVar = this.bO_renamed) != null && java.lang.Float.compare(agVar.i_renamed(), 0.0f) != 0) {
            float fI_renamed = this.bO_renamed.i_renamed();
            if (java.lang.Math.floor(fI_renamed * 10.0f) % 2.0d != 0.0d && java.lang.Float.compare(fI_renamed, 2.0f) > 0 && java.lang.Float.compare(fI_renamed, 5.0f) < 0) {
                arrayList.add(java.lang.Float.valueOf((float) (java.lang.Math.floor((fI_renamed - 0.1f) * 10.0f) / 10.0d)));
                arrayList.add(java.lang.Float.valueOf(fI_renamed));
                arrayList.add(java.lang.Float.valueOf((float) (java.lang.Math.floor((fI_renamed + 0.1f) * 10.0f) / 10.0d)));
            }
        }
        if (java.lang.Float.compare(this.bt_renamed, 8.0f) > 0) {
            arrayList.add(java.lang.Float.valueOf(5.0f));
        }
        if (java.lang.Float.compare(this.bt_renamed, 10.0f) > 0) {
            arrayList.add(java.lang.Float.valueOf(10.0f));
        }
        if (java.lang.Float.compare(this.bt_renamed, 20.0f) > 0) {
            arrayList.add(java.lang.Float.valueOf(20.0f));
        }
        arrayList.add(java.lang.Float.valueOf(this.bt_renamed));
        return arrayList;
    }

    protected java.util.ArrayList<java.lang.Float> getSectionStep() {
        com.oplus.camera.ui.preview.ag_renamed agVar;
        java.util.ArrayList<java.lang.Float> arrayList = new java.util.ArrayList<>();
        this.bx_renamed = new java.util.ArrayList<>();
        float f_renamed = this.bs_renamed;
        java.lang.Float fValueOf = java.lang.Float.valueOf(1.0f);
        int iCompare = java.lang.Float.compare(f_renamed, 1.0f);
        java.lang.Float fValueOf2 = java.lang.Float.valueOf(0.1f);
        if (iCompare < 0 || this.bi_renamed) {
            arrayList.add(fValueOf2);
            this.bx_renamed.add(java.lang.Float.valueOf(getIncreaseSpace() + 4.0540543f));
        }
        if (java.lang.Float.compare(this.bs_renamed, 1.0f) <= 0) {
            arrayList.add(fValueOf2);
            this.bx_renamed.add(java.lang.Float.valueOf(getIncreaseSpace() + 2.7027028f));
        }
        if (java.lang.Float.compare(this.bt_renamed, 4.0f) > 0) {
            arrayList.add(java.lang.Float.valueOf(0.2f));
            this.bx_renamed.add(java.lang.Float.valueOf(getIncreaseSpace() + 2.0270271f));
        }
        if (java.lang.Float.compare(this.bt_renamed, 4.0f) > 0 && (agVar = this.bO_renamed) != null && java.lang.Float.compare(agVar.i_renamed(), 0.0f) != 0) {
            float fI_renamed = this.bO_renamed.i_renamed();
            if (java.lang.Math.floor(fI_renamed * 10.0f) % 2.0d != 0.0d && java.lang.Float.compare(fI_renamed, 2.0f) > 0 && java.lang.Float.compare(fI_renamed, 5.0f) < 0) {
                arrayList.add(fValueOf2);
                this.bx_renamed.add(java.lang.Float.valueOf(getIncreaseSpace() + 2.0270271f));
                arrayList.add(fValueOf2);
                this.bx_renamed.add(java.lang.Float.valueOf(getIncreaseSpace() + 2.0270271f));
                arrayList.add(java.lang.Float.valueOf(0.2f));
                this.bx_renamed.add(java.lang.Float.valueOf(getIncreaseSpace() + 2.0270271f));
            }
        }
        if (java.lang.Float.compare(this.bt_renamed, 8.0f) > 0) {
            arrayList.add(java.lang.Float.valueOf(0.2f));
            this.bx_renamed.add(java.lang.Float.valueOf(getIncreaseSpace() + 1.3513514f));
        }
        if (java.lang.Float.compare(this.bt_renamed, 10.0f) > 0) {
            if (java.lang.Float.compare(this.bt_renamed, 30.0f) > 0) {
                arrayList.add(java.lang.Float.valueOf(2.0f));
                arrayList.add(java.lang.Float.valueOf(2.0f));
                this.bx_renamed.add(java.lang.Float.valueOf(getIncreaseSpace() + 1.0810812f));
                this.bx_renamed.add(java.lang.Float.valueOf(getIncreaseSpace() + 1.0810812f));
            } else if (java.lang.Float.compare(this.bt_renamed, 20.0f) > 0) {
                arrayList.add(fValueOf);
                arrayList.add(fValueOf);
                this.bx_renamed.add(java.lang.Float.valueOf(getIncreaseSpace() + 1.0810812f));
                this.bx_renamed.add(java.lang.Float.valueOf(getIncreaseSpace() + 1.0810812f));
            } else {
                arrayList.add(java.lang.Float.valueOf(0.5f));
                this.bx_renamed.add(java.lang.Float.valueOf(getIncreaseSpace() + 1.0810812f));
            }
        }
        return arrayList;
    }

    protected boolean a_renamed(float f_renamed, float f2, float f3, float f4, float f5) {
        return ((float) ((int) java.lang.Math.sqrt(java.lang.Math.pow((double) java.lang.Math.abs(f3 - f_renamed), 2.0d) + java.lang.Math.pow((double) java.lang.Math.abs(f4 - f2), 2.0d)))) <= f5;
    }

    protected int h_renamed(float f_renamed) {
        int i_renamed = 0;
        for (int i2 = 0; i2 < this.bK_renamed.size() && java.lang.Float.compare(this.bK_renamed.get(i2).floatValue(), f_renamed) <= 0; i2++) {
            i_renamed = i2;
        }
        return i_renamed;
    }

    protected float i_renamed(float f_renamed) {
        return java.lang.Float.compare(f_renamed, 5.0f) > 0 ? 1.1f : 1.8f;
    }

    protected void a_renamed(android.graphics.Canvas canvas, android.graphics.drawable.Drawable drawable, float f_renamed, float f2, float f3, int i_renamed) {
        float intrinsicWidth = ((drawable.getIntrinsicWidth() * f3) * 1.0f) / 2.0f;
        float intrinsicHeight = ((drawable.getIntrinsicHeight() * f3) * 1.0f) / 2.0f;
        drawable.setBounds((int) (f_renamed - intrinsicWidth), (int) (f2 - intrinsicHeight), (int) (f_renamed + intrinsicWidth), (int) (f2 + intrinsicHeight));
        drawable.setAlpha(i_renamed);
        drawable.draw(canvas);
    }

    public void setZoomClickVisibility(int i_renamed) {
        this.bq_renamed = i_renamed;
    }

    /* compiled from: ZoomSeekBar.java */
    protected class c_renamed implements android.view.GestureDetector.OnGestureListener {
        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(android.view.MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f_renamed, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(android.view.MotionEvent motionEvent) {
        }

        protected c_renamed() {
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:41:0x0136  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:47:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:50:0x016d  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:52:0x0173  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:53:0x0175  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:56:0x0180  */
        @Override // android.view.GestureDetector.OnGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onSingleTapUp(android.view.MotionEvent r13) {
            /*
                Method dump skipped, instructions count: 482
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.ai_renamed.c_renamed.onSingleTapUp(android.view.MotionEvent):boolean");
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f_renamed, float f2) {
            if (com.oplus.camera.ui.preview.ai_renamed.this.bO_renamed.b_renamed() && motionEvent != null) {
                if (com.oplus.camera.ui.preview.ai_renamed.this.S_renamed == 0) {
                    if (f2 >= 10.0f) {
                        com.oplus.camera.ui.preview.ai_renamed.this.c_renamed(false);
                        com.oplus.camera.ui.preview.ai_renamed.this.cT_renamed = true;
                    } else if ((f2 < 10.0f && f2 >= 0.0f) || java.lang.Math.abs(f2) / java.lang.Math.abs(f_renamed) < com.oplus.camera.ui.preview.ai_renamed.this.l_renamed(30.0f)) {
                        com.oplus.camera.ui.preview.ai_renamed.this.c_renamed(true);
                        com.oplus.camera.ui.preview.ai_renamed.this.cT_renamed = true;
                    }
                } else if (2 == com.oplus.camera.ui.preview.ai_renamed.this.S_renamed && f2 < 0.0f && java.lang.Math.abs(f2) > 10.0f && java.lang.Math.abs(f_renamed) / java.lang.Math.abs(f2) < com.oplus.camera.ui.preview.ai_renamed.this.l_renamed(15.0f) && motionEvent.getY() < com.oplus.camera.ui.preview.ai_renamed.this.getHeight() * 1.0f) {
                    com.oplus.camera.ui.preview.ai_renamed.this.b_renamed(false);
                    com.oplus.camera.ui.preview.ai_renamed.this.cT_renamed = true;
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(android.view.MotionEvent motionEvent) {
            if (com.oplus.camera.ui.preview.ai_renamed.this.S_renamed == 0 && com.oplus.camera.ui.preview.ai_renamed.this.bg_renamed) {
                com.oplus.camera.e_renamed.a_renamed("ZoomSeekBar", "MyGestureListener, onLongPress to performExpand");
                com.oplus.camera.ui.preview.ai_renamed.this.c_renamed(false);
                com.oplus.camera.ui.preview.ai_renamed.this.cT_renamed = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double l_renamed(float f_renamed) {
        return java.lang.Math.tan((f_renamed * 3.141592653589793d) / 180.0d);
    }

    public java.lang.String getCurrentDisplayText() {
        return this.cV_renamed;
    }

    public java.lang.String a_renamed(float f_renamed) {
        return this.bP_renamed.a_renamed(getZoomValueUnit(), f_renamed);
    }

    private void K_renamed() {
        if (this.df_renamed == null) {
            this.df_renamed = new android.animation.AnimatorSet();
            this.df_renamed.play(getEnterAnimator()).with(getExitAnimator()).with(getSlideBarAnimator());
            this.df_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.ai_renamed.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    com.oplus.camera.ui.preview.ai_renamed.this.k_renamed();
                    com.oplus.camera.ui.preview.ai_renamed aiVar = com.oplus.camera.ui.preview.ai_renamed.this;
                    aiVar.cY_renamed = aiVar.a_renamed(aiVar.f_renamed(aiVar.aR_renamed));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.preview.ai_renamed aiVar = com.oplus.camera.ui.preview.ai_renamed.this;
                    aiVar.setCenterPointIndex(aiVar.aQ_renamed);
                    com.oplus.camera.ui.preview.ai_renamed aiVar2 = com.oplus.camera.ui.preview.ai_renamed.this;
                    aiVar2.cW_renamed = aiVar2.cV_renamed;
                    com.oplus.camera.ui.preview.ai_renamed aiVar3 = com.oplus.camera.ui.preview.ai_renamed.this;
                    aiVar3.setCurrentDisplayText(aiVar3.aR_renamed);
                    com.oplus.camera.ui.preview.ai_renamed aiVar4 = com.oplus.camera.ui.preview.ai_renamed.this;
                    aiVar4.b_renamed(aiVar4.aS_renamed, false);
                    com.oplus.camera.ui.preview.ai_renamed.this.k_renamed();
                    com.oplus.camera.ui.preview.ai_renamed.this.N_renamed = -1.0f;
                }
            });
        }
    }

    private android.animation.Animator getSlideBarAnimator() {
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.01f, 1.0f);
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.setInterpolator(this.dN_renamed);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.ai_renamed.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.preview.ai_renamed.this.dK_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.preview.ai_renamed.this.invalidate();
            }
        });
        return valueAnimatorOfFloat;
    }

    private android.animation.Animator getEnterAnimator() {
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(this.dF_renamed, 0.0f);
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.setStartDelay(100L);
        valueAnimatorOfFloat.setInterpolator(this.dN_renamed);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.ai_renamed.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.preview.ai_renamed.this.dG_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.preview.ai_renamed.this.invalidate();
                if (0.0f == com.oplus.camera.ui.preview.ai_renamed.this.aS_renamed || com.oplus.camera.ui.preview.ai_renamed.this.bO_renamed == null || !com.oplus.camera.ui.preview.ai_renamed.this.bO_renamed.j_renamed()) {
                    return;
                }
                com.oplus.camera.ui.preview.ai_renamed aiVar = com.oplus.camera.ui.preview.ai_renamed.this;
                aiVar.setCurrentDisplayText(aiVar.aS_renamed);
            }
        });
        android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(0, 255);
        valueAnimatorOfInt.setDuration(400L);
        valueAnimatorOfInt.setStartDelay(100L);
        valueAnimatorOfInt.setInterpolator(this.dO_renamed);
        valueAnimatorOfInt.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.ai_renamed.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.preview.ai_renamed.this.dH_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                com.oplus.camera.ui.preview.ai_renamed.this.invalidate();
            }
        });
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfInt);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentDisplayText(float f_renamed) {
        java.lang.String strA = a_renamed(f_renamed(f_renamed));
        com.oplus.camera.e_renamed.b_renamed("ZoomSeekBar", "setCurrentDisplayText: " + this.cV_renamed + " -> " + strA);
        this.cV_renamed = strA;
    }

    private android.animation.Animator getExitAnimator() {
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, this.dF_renamed);
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.setInterpolator(this.dN_renamed);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.ai_renamed.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.preview.ai_renamed.this.dI_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.preview.ai_renamed.this.invalidate();
            }
        });
        android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(255, 0);
        valueAnimatorOfInt.setDuration(250L);
        valueAnimatorOfInt.setInterpolator(this.dO_renamed);
        valueAnimatorOfInt.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.ai_renamed.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.preview.ai_renamed.this.dJ_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                com.oplus.camera.ui.preview.ai_renamed.this.invalidate();
            }
        });
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfInt);
        return animatorSet;
    }

    public float[] getUltraWideZoomDotViewLocation() {
        java.util.ArrayList<java.lang.Float> arrayList;
        if (3 < this.aN_renamed || (arrayList = this.bK_renamed) == null || !arrayList.contains(java.lang.Float.valueOf(com.oplus.camera.ag_renamed.f4106a))) {
            return null;
        }
        return new float[]{this.cj_renamed, this.ag_renamed - this.aF_renamed};
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
        this.ds_renamed = new int[2];
        getLocationOnScreen(this.ds_renamed);
    }

    public int getFocusCircleRadius() {
        return this.aF_renamed;
    }

    public boolean b_renamed(android.view.MotionEvent motionEvent) {
        int[] iArr;
        return getParent() != null && getVisibility() == 0 && (iArr = this.ds_renamed) != null && 2 <= iArr.length && motionEvent.getRawY() > ((float) this.ds_renamed[1]) && java.lang.Math.abs(this.ag_renamed - (motionEvent.getRawY() - ((float) this.ds_renamed[1]))) <= (((float) this.dr_renamed) * 1.0f) / 2.0f;
    }

    public java.lang.String j_renamed(float f_renamed) {
        return a_renamed(f_renamed(f_renamed));
    }

    public java.lang.String k_renamed(float f_renamed) {
        return a_renamed(f_renamed(f_renamed));
    }

    public void D_renamed() {
        java.util.ArrayList<java.lang.Float> arrayList = this.dx_renamed;
        if (arrayList == null || arrayList.size() == 0 || this.bL_renamed == null) {
            return;
        }
        this.bL_renamed = null;
        this.bL_renamed = new float[this.dx_renamed.size()];
        for (int i_renamed = 0; i_renamed < this.bL_renamed.length; i_renamed++) {
            this.bL_renamed[i_renamed] = g_renamed(this.dx_renamed.get(i_renamed).floatValue());
        }
    }

    private float getIncreaseSpace() {
        return this.Q_renamed;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        com.oplus.camera.ui.a_renamed.a_renamed(getContext()).a_renamed(this);
        super.onDetachedFromWindow();
    }

    public java.lang.String getSlideToDisplayText() {
        return this.cY_renamed;
    }
}
