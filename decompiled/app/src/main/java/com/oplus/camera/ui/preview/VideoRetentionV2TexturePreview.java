package com.oplus.camera.ui.preview;

/* compiled from: ZoomArcSeekBar.java */
/* loaded from: classes2.dex */
public class af_renamed extends com.oplus.camera.ui.preview.ai_renamed {
    private static float di_renamed = 0.5f;
    private android.graphics.RectF dA_renamed;
    private android.graphics.SweepGradient dB_renamed;
    private int[] dC_renamed;
    private float[] dD_renamed;
    private int dE_renamed;
    private int dF_renamed;
    private int dG_renamed;
    private int dH_renamed;
    private int dI_renamed;
    private int dJ_renamed;
    private int dK_renamed;
    private float dL_renamed;
    private float dM_renamed;
    private float dN_renamed;
    private float dO_renamed;
    private android.graphics.Paint dP_renamed;
    private android.graphics.Paint dQ_renamed;
    private java.util.Map<java.lang.String, android.util.Size> dR_renamed;
    private int dS_renamed;
    private int dj_renamed;
    private int dk_renamed;
    private int dl_renamed;
    private float dm_renamed;
    private float dn_renamed;

    /* renamed from: do, reason: not valid java name */
    private android.graphics.Paint f1do;
    private android.graphics.Paint dp_renamed;
    private android.graphics.Paint dq_renamed;
    private int dr_renamed;
    private int ds_renamed;
    private int dt_renamed;
    private int du_renamed;
    private int dv_renamed;
    private int dw_renamed;
    private int dx_renamed;
    private android.text.TextPaint dy_renamed;
    private int dz_renamed;

    @Override // com.oplus.camera.ui.preview.ai_renamed
    public int getType() {
        return 1;
    }

    public af_renamed(android.content.Context context) {
        super(context);
        this.dj_renamed = 0;
        this.dk_renamed = 0;
        this.dl_renamed = 0;
        this.dm_renamed = 27.0f;
        this.dn_renamed = 39.0f;
        this.f1do = null;
        this.dp_renamed = null;
        this.dq_renamed = null;
        this.dr_renamed = 0;
        this.ds_renamed = 0;
        this.dt_renamed = 0;
        this.du_renamed = 0;
        this.dv_renamed = 0;
        this.dw_renamed = 0;
        this.dx_renamed = 0;
        this.dy_renamed = null;
        this.dz_renamed = 0;
        this.dA_renamed = null;
        this.dB_renamed = null;
        this.dC_renamed = null;
        this.dD_renamed = null;
        this.dE_renamed = 0;
        this.dF_renamed = 0;
        this.dG_renamed = 0;
        this.dH_renamed = 0;
        this.dI_renamed = 0;
        this.dJ_renamed = 0;
        this.dK_renamed = 0;
        this.dL_renamed = 0.0f;
        this.dM_renamed = 0.0f;
        this.dN_renamed = 0.0f;
        this.dO_renamed = 0.0f;
        this.dP_renamed = null;
        this.dQ_renamed = null;
        this.dR_renamed = new java.util.HashMap();
        this.dS_renamed = 0;
        E_renamed();
    }

    @Override // com.oplus.camera.ui.preview.ai_renamed
    public void a_renamed(float f_renamed, float f2, float f3, java.util.ArrayList<java.lang.Float> arrayList, java.util.ArrayList<java.lang.Float> arrayList2, int i_renamed, boolean z_renamed, boolean z2, boolean z3) {
        if (arrayList.size() > 0 && java.lang.Float.compare(f3, arrayList.get(arrayList.size() - 1).floatValue()) > 0) {
            arrayList.add(java.lang.Float.valueOf(f3));
        }
        this.dR_renamed.clear();
        super.a_renamed(f_renamed, com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OPLUS_NIGHT_MODE_MAX_ZOOM_SUPPORT) ? new java.math.BigDecimal(f2).setScale(1, 1).floatValue() : f2, f3, arrayList, arrayList2, i_renamed, z_renamed, z2, z3);
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4, float f_renamed, float f2, float f3) {
        this.R_renamed = i_renamed;
        this.af_renamed = (this.R_renamed * 1.0f) / 2.0f;
        this.cf_renamed = i3;
        this.ck_renamed = (this.af_renamed - (this.cf_renamed * 2.0f)) - this.ch_renamed;
        this.f7005co = this.af_renamed + (this.cf_renamed * 2.0f) + this.ch_renamed;
        if (1 == getLayoutDirection()) {
            float f4 = this.ck_renamed;
            this.ck_renamed = this.f7005co;
            this.f7005co = f4;
        }
        b_renamed(this.cs_renamed, true);
        this.dk_renamed = i2;
        this.dO_renamed = (this.dk_renamed - (this.dH_renamed / 2)) - this.aw_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_indicator_line_padding_top);
        this.ag_renamed = i4;
        this.ah_renamed = f_renamed;
        this.cg_renamed = f2 * this.ax_renamed.getDimension(com.oplus.camera.R_renamed.dimen.zoom_seekbar_oval_stroke_width);
        this.bS_renamed.setStrokeWidth(this.cg_renamed);
        this.dm_renamed = 27.0f + f3;
        this.dn_renamed = f3 + 39.0f;
    }

    private void E_renamed() {
        android.content.res.Resources resources = this.aw_renamed.getResources();
        this.dj_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_unfold_anim_radius_between_distance);
        this.dk_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_bg_circle_radius);
        this.ag_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_focus_circle_center_y);
        this.dM_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_indicator_focus_center_y);
        this.dN_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_indicator_icon_y);
        this.dK_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.num_seekbar_section_radius);
        this.dx_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_current_focus_change_move_distance);
        this.dr_renamed = com.oplus.camera.util.c_renamed.a_renamed(resources.getColor(com.oplus.camera.R_renamed.color.zoom_arc_seekbar_bg_color));
        this.f1do = new android.graphics.Paint();
        this.f1do.setAntiAlias(true);
        this.f1do.setStyle(android.graphics.Paint.Style.FILL);
        this.f1do.setColor(this.dr_renamed);
        this.du_renamed = this.f1do.getAlpha();
        this.dl_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_bg_stroke_width);
        this.ds_renamed = resources.getColor(com.oplus.camera.R_renamed.color.zoom_arc_seekbar_bg_stroke_color);
        this.dp_renamed = new android.graphics.Paint();
        this.dp_renamed.setAntiAlias(true);
        this.dp_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.dp_renamed.setStrokeWidth(this.dl_renamed);
        this.dp_renamed.setColor(this.ds_renamed);
        this.dt_renamed = this.dp_renamed.getAlpha();
        this.dq_renamed = new android.graphics.Paint();
        this.dq_renamed.setAntiAlias(true);
        this.dq_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.dq_renamed.setStrokeWidth(this.dl_renamed);
        this.dz_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_marker_arc_radius);
        int i_renamed = this.ds_renamed;
        this.dC_renamed = new int[]{android.graphics.Color.parseColor("#00FFFFFF"), i_renamed, i_renamed, android.graphics.Color.parseColor("#00FFFFFF")};
        this.dD_renamed = getSweepGradientPositions();
        this.dB_renamed = new android.graphics.SweepGradient(this.af_renamed, this.dk_renamed, this.dC_renamed, this.dD_renamed);
        this.aD_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_focus_circle_radius_pressed);
        this.aL_renamed = resources.getColor(com.oplus.camera.R_renamed.color.zoom_arc_seekbar_indicator_circle_color);
        this.dE_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_indicator_circle_stroke_width);
        this.dF_renamed = resources.getColor(com.oplus.camera.R_renamed.color.zoom_arc_seekbar_indicator_circle_stroke_color);
        this.bA_renamed = new android.graphics.Paint();
        this.bA_renamed.setAntiAlias(true);
        this.bA_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.bA_renamed.setColor(this.aL_renamed);
        this.aY_renamed = this.bA_renamed.getAlpha();
        this.dQ_renamed = new android.graphics.Paint();
        this.dQ_renamed.setAntiAlias(true);
        this.dQ_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.dQ_renamed.setStrokeWidth(this.dE_renamed);
        this.dQ_renamed.setColor(this.dF_renamed);
        this.bI_renamed = new android.text.TextPaint(1);
        this.aT_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_indicator_text_size);
        this.bI_renamed.setTextSize(this.aT_renamed);
        this.bI_renamed.setColor(-1);
        this.bI_renamed.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.bI_renamed.setTypeface(com.oplus.camera.util.Util.l_renamed(this.aw_renamed));
        this.dy_renamed = new android.text.TextPaint(1);
        this.dv_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_mark_text_size);
        this.dy_renamed.setTextSize(this.dv_renamed);
        this.dy_renamed.setColor(-1);
        this.dy_renamed.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.dy_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        this.dw_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_marker_center_margin_top);
        this.dS_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_seek_arc_bar_mark_button_click_size);
        android.graphics.Paint.FontMetrics fontMetrics = this.bI_renamed.getFontMetrics();
        this.dL_renamed = ((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom;
        this.dG_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_indicator_line_width);
        this.dH_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_indicator_line_height);
        this.dO_renamed = (this.dk_renamed - (this.dH_renamed / 2)) - resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_indicator_line_padding_top);
        this.dP_renamed = new android.graphics.Paint(1);
        this.dI_renamed = this.aw_renamed.getColor(com.oplus.camera.R_renamed.color.color_white_with_50_percent_transparency);
        this.dJ_renamed = this.aw_renamed.getColor(com.oplus.camera.R_renamed.color.color_white_with_15_percent_transparency);
    }

    @Override // com.oplus.camera.ui.preview.ai_renamed
    public int getLayoutHeight() {
        return this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_height);
    }

    private void l_renamed(float f_renamed) {
        n_renamed(f_renamed);
    }

    @Override // com.oplus.camera.ui.b_renamed
    protected void f_renamed() {
        super.f_renamed();
        l_renamed(1.0f);
    }

    @Override // com.oplus.camera.ui.preview.ai_renamed
    public java.lang.String a_renamed(float f_renamed, float f2) {
        for (java.util.Map.Entry<java.lang.String, android.util.Size> entry : this.dR_renamed.entrySet()) {
            android.util.Size value = entry.getValue();
            if (((int) java.lang.Math.pow(java.lang.Math.abs(value.getWidth() - f_renamed) + java.lang.Math.abs(value.getHeight() - f2), 2.0d)) <= java.lang.Math.pow(this.dS_renamed, 2.0d)) {
                com.oplus.camera.e_renamed.a_renamed("ZoomArcSeekBar", "onClickZoomArcSeekBar, touched zoom value : " + entry.getKey());
                return entry.getKey();
            }
        }
        return "";
    }

    @Override // com.oplus.camera.ui.preview.ai_renamed, com.oplus.camera.ui.b_renamed
    protected void g_renamed(android.graphics.Canvas canvas) throws android.content.res.Resources.NotFoundException {
        if (0.0f != this.z_renamed) {
            l_renamed(this.C_renamed);
            b_renamed(canvas, this.D_renamed);
            if (this.cI_renamed == null || this.cH_renamed == null) {
                x_renamed();
            }
            this.cI_renamed.drawPaint(this.bH_renamed);
            this.cH_renamed.drawPaint(this.bH_renamed);
            b_renamed(this.cI_renamed, this.cV_renamed, this.E_renamed, this.D_renamed);
            this.cI_renamed.drawBitmap(this.cF_renamed, 0.0f, 0.0f, this.bG_renamed);
            canvas.drawBitmap(this.cG_renamed, 0.0f, 0.0f, this.bG_renamed);
        }
        a_renamed(canvas, this.cV_renamed);
        super.g_renamed(canvas);
    }

    @Override // com.oplus.camera.ui.b_renamed
    protected void f_renamed(android.graphics.Canvas canvas) throws android.content.res.Resources.NotFoundException {
        l_renamed(this.C_renamed);
        u_renamed();
        if (1.0f != this.z_renamed) {
            b_renamed(canvas, this.D_renamed);
            if (this.cI_renamed == null || this.cH_renamed == null) {
                x_renamed();
            }
            this.cI_renamed.drawPaint(this.bH_renamed);
            this.cH_renamed.drawPaint(this.bH_renamed);
            b_renamed(this.cI_renamed, this.cV_renamed, this.E_renamed, this.D_renamed);
            this.cI_renamed.drawBitmap(this.cF_renamed, 0.0f, 0.0f, this.bG_renamed);
            canvas.drawBitmap(this.cG_renamed, 0.0f, 0.0f, this.bG_renamed);
        }
        a_renamed(canvas, this.cX_renamed);
        super.f_renamed(canvas);
    }

    private void a_renamed(android.graphics.Canvas canvas, java.lang.String str) {
        float f_renamed = this.A_renamed;
        float f2 = this.B_renamed;
        this.bQ_renamed.setAlpha(java.lang.Math.round(255.0f * f_renamed));
        this.bR_renamed.setAlpha(java.lang.Math.round(android.graphics.Color.alpha(this.bX_renamed) * f_renamed));
        this.aj_renamed.setAlpha(java.lang.Math.round(android.graphics.Color.alpha(this.bU_renamed) * f_renamed));
        this.bS_renamed.setAlpha(java.lang.Math.round(f_renamed * android.graphics.Color.alpha(this.bY_renamed)));
        a_renamed(canvas, this.ci_renamed, this.ag_renamed - (this.dx_renamed * f2), 0.0f);
        a_renamed(canvas, str, this.ci_renamed, this.ag_renamed - (f2 * this.dx_renamed), this.cs_renamed);
    }

    @Override // com.oplus.camera.ui.b_renamed
    public void j_renamed(android.graphics.Canvas canvas) throws android.content.res.Resources.NotFoundException {
        u_renamed();
        b_renamed(canvas, 1.0f);
        if (this.cI_renamed == null || this.cH_renamed == null) {
            x_renamed();
        }
        this.cI_renamed.drawPaint(this.bH_renamed);
        this.cH_renamed.drawPaint(this.bH_renamed);
        b_renamed(this.cI_renamed, this.cV_renamed, 1.0f, 1.0f);
        this.cI_renamed.drawBitmap(this.cF_renamed, 0.0f, 0.0f, this.bG_renamed);
        canvas.drawBitmap(this.cG_renamed, 0.0f, 0.0f, this.bG_renamed);
    }

    @Override // com.oplus.camera.ui.b_renamed
    public void p_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ZoomArcSeekBar", "onScaleBegin, mStatus: " + this.S_renamed);
        if (!isShown() || this.T_renamed || this.V_renamed) {
            return;
        }
        if (this.S_renamed == 0 || 10 == this.S_renamed) {
            this.V_renamed = true;
            if (this.o_renamed != null && this.o_renamed.isStarted()) {
                this.N_renamed = this.da_renamed;
                this.P_renamed = this.dc_renamed;
                this.O_renamed = this.db_renamed;
                this.n_renamed.setCurrentFraction(a_renamed(this.n_renamed.getInterpolator(), this.F_renamed, 0.0f, 1.0f));
                this.o_renamed.cancel();
            } else {
                this.N_renamed = -1.0f;
                this.P_renamed = -1.0f;
                this.O_renamed = -1.0f;
            }
            this.aP_renamed = this.aN_renamed;
            if (this.p_renamed != null && this.p_renamed.isStarted()) {
                this.q_renamed.setCurrentFraction(a_renamed(this.q_renamed.getInterpolator(), this.M_renamed, 255.0f, 0.0f));
                this.p_renamed.cancel();
            }
            this.q_renamed.start();
            this.n_renamed.start();
            setStatus(8);
        }
    }

    @Override // com.oplus.camera.ui.b_renamed
    public void q_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ZoomArcSeekBar", "onScaleEnd, mStatus: " + this.S_renamed);
        if (9 == this.S_renamed || 8 == this.S_renamed) {
            this.V_renamed = false;
            if (this.n_renamed != null && this.n_renamed.isStarted()) {
                if (a_renamed(this.aP_renamed) != a_renamed(this.aN_renamed)) {
                    this.N_renamed = this.da_renamed;
                    this.P_renamed = this.dc_renamed;
                    this.O_renamed = this.db_renamed;
                    this.o_renamed.setCurrentFraction(a_renamed(this.o_renamed.getInterpolator(), 1.0f - this.F_renamed, 1.0f, 0.0f));
                } else {
                    this.o_renamed.setCurrentFraction(a_renamed(this.o_renamed.getInterpolator(), this.F_renamed, 1.0f, 0.0f));
                }
                this.n_renamed.cancel();
            } else {
                this.N_renamed = -1.0f;
                this.P_renamed = -1.0f;
                this.O_renamed = -1.0f;
            }
            if (this.q_renamed != null && this.q_renamed.isStarted()) {
                this.p_renamed.setCurrentFraction(a_renamed(this.p_renamed.getInterpolator(), this.M_renamed, 0.0f, 255.0f));
                this.q_renamed.cancel();
            }
            this.p_renamed.start();
            this.o_renamed.start();
            setStatus(10);
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

    @Override // com.oplus.camera.ui.b_renamed
    protected void c_renamed(android.graphics.Canvas canvas) {
        w_renamed();
        if (1.0f > this.F_renamed) {
            a_renamed(canvas, this.ci_renamed, this.ag_renamed, this.F_renamed);
            a_renamed(canvas, this.M_renamed, this.F_renamed);
            int currentBarIndex = getCurrentBarIndex();
            if (currentBarIndex == 1) {
                this.cZ_renamed = this.cj_renamed;
            } else if (currentBarIndex == 2) {
                this.cZ_renamed = this.ci_renamed;
            } else if (currentBarIndex == 3) {
                this.cZ_renamed = this.cn_renamed;
            }
            this.da_renamed = this.cZ_renamed - ((this.cZ_renamed - this.af_renamed) * this.F_renamed);
            a_renamed(canvas, this.da_renamed, this.ag_renamed);
            canvas.save();
            canvas.rotate(-this.aV_renamed, this.da_renamed, this.ag_renamed);
            canvas.drawText(this.cV_renamed, this.da_renamed, this.ag_renamed + this.ba_renamed, this.aj_renamed);
            canvas.restore();
            return;
        }
        d_renamed(canvas);
        setStatus(9);
    }

    private void a_renamed(android.graphics.Canvas canvas, int i_renamed, float f_renamed) {
        this.u_renamed.setAlpha(i_renamed);
        if (this.cs_renamed == 1 && getCurrentBarIndex() != 1) {
            this.db_renamed = this.cj_renamed - ((this.cj_renamed - this.af_renamed) * f_renamed);
            canvas.save();
            canvas.rotate(-this.aV_renamed, this.db_renamed, this.ag_renamed);
            canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE), this.db_renamed - this.cl_renamed, this.ag_renamed - this.cm_renamed, this.u_renamed);
            canvas.restore();
        }
        if (getCurrentBarIndex() != 3 && this.az_renamed) {
            this.dc_renamed = this.cn_renamed - ((this.cn_renamed - this.af_renamed) * f_renamed);
            canvas.save();
            canvas.rotate(-this.aV_renamed, this.dc_renamed, this.ag_renamed);
            canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE), this.dc_renamed - this.cp_renamed, this.ag_renamed - this.cq_renamed, this.u_renamed);
            canvas.restore();
        }
        if (getCurrentBarIndex() != 2) {
            this.dd_renamed = this.ci_renamed - ((this.ci_renamed - this.af_renamed) * f_renamed);
            canvas.save();
            canvas.rotate(-this.aV_renamed, this.dd_renamed, this.ag_renamed);
            canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE), this.dd_renamed - this.cp_renamed, this.ag_renamed - this.cq_renamed, this.u_renamed);
            canvas.restore();
        }
    }

    private void b_renamed(android.graphics.Canvas canvas, int i_renamed, float f_renamed) {
        this.u_renamed.setAlpha(i_renamed);
        if (this.cs_renamed == 1 && getCurrentBarIndex() != 1) {
            this.db_renamed = this.cj_renamed - ((this.cj_renamed - this.af_renamed) * f_renamed);
            canvas.save();
            canvas.rotate(-this.aV_renamed, this.db_renamed, this.ag_renamed);
            canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.ULTRA_WIDE), this.db_renamed - this.cl_renamed, this.ag_renamed - this.cm_renamed, this.u_renamed);
            canvas.restore();
        }
        if (getCurrentBarIndex() != 3 && this.az_renamed) {
            this.dc_renamed = this.cn_renamed - ((this.cn_renamed - this.af_renamed) * f_renamed);
            canvas.save();
            canvas.rotate(-this.aV_renamed, this.dc_renamed, this.ag_renamed);
            canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.TELE), this.dc_renamed - this.cp_renamed, this.ag_renamed - this.cq_renamed, this.u_renamed);
            canvas.restore();
        }
        if (getCurrentBarIndex() != 2) {
            this.dd_renamed = this.ci_renamed - ((this.ci_renamed - this.af_renamed) * f_renamed);
            canvas.save();
            canvas.rotate(-this.aV_renamed, this.dd_renamed, this.ag_renamed);
            canvas.drawBitmap(this.cd_renamed.get(com.oplus.camera.ui.preview.ai_renamed.b_renamed.WIDE), this.dd_renamed - this.cp_renamed, this.ag_renamed - this.cq_renamed, this.u_renamed);
            canvas.restore();
        }
    }

    @Override // com.oplus.camera.ui.b_renamed
    protected void d_renamed(android.graphics.Canvas canvas) {
        w_renamed();
        a_renamed(canvas, this.ci_renamed, this.ag_renamed, 1.0f);
        a_renamed(canvas, this.af_renamed, this.ag_renamed);
        canvas.save();
        canvas.rotate(-this.aV_renamed, this.af_renamed, this.ag_renamed);
        canvas.drawText(this.cV_renamed, this.af_renamed, this.ag_renamed + this.ba_renamed, this.aj_renamed);
        canvas.restore();
    }

    @Override // com.oplus.camera.ui.b_renamed
    protected void e_renamed(android.graphics.Canvas canvas) {
        w_renamed();
        if (0.0f < this.F_renamed) {
            a_renamed(canvas, this.ci_renamed, this.ag_renamed, this.F_renamed);
            b_renamed(canvas, this.M_renamed, this.F_renamed);
            int currentBarIndex = getCurrentBarIndex();
            if (currentBarIndex == 1) {
                this.de_renamed = this.cj_renamed;
            } else if (currentBarIndex == 2) {
                this.de_renamed = this.ci_renamed;
            } else if (currentBarIndex == 3) {
                this.de_renamed = this.cn_renamed;
            }
            this.da_renamed = this.de_renamed - ((this.de_renamed - this.af_renamed) * this.F_renamed);
            if (java.lang.Float.compare(-1.0f, this.N_renamed) != 0) {
                this.da_renamed = this.de_renamed - ((this.de_renamed - this.N_renamed) * this.F_renamed);
            }
            a_renamed(canvas, this.da_renamed, this.ag_renamed);
            canvas.save();
            canvas.rotate(-this.aV_renamed, this.da_renamed, this.ag_renamed);
            canvas.drawText(this.cV_renamed, this.da_renamed, this.ag_renamed + this.ba_renamed, this.aj_renamed);
            canvas.restore();
            return;
        }
        b_renamed(canvas);
        setStatus(0);
    }

    private void b_renamed(android.graphics.Canvas canvas, java.lang.String str, float f_renamed, float f2) throws android.content.res.Resources.NotFoundException {
        float totleAngle;
        float f3;
        float f4;
        int i_renamed;
        int i2;
        float f5;
        float totleAngle2 = (getTotleAngle() * this.ad_renamed) + 90.0f;
        if (android.text.TextUtils.isEmpty(str)) {
            com.oplus.camera.e_renamed.f_renamed("ZoomArcSeekBar", "drawIndicatorLines, text is_renamed null");
            return;
        }
        D_renamed();
        float f6 = this.dO_renamed;
        int i3 = this.dj_renamed;
        float f7 = (f6 - i3) + (i3 * f2);
        int i4 = 0;
        while (i4 < this.bb_renamed) {
            float fE_renamed = e_renamed(i4);
            boolean zB = b_renamed(fE_renamed);
            float fRound = java.lang.Math.round(c_renamed(fE_renamed) * 100.0f) / 100.0f;
            boolean z_renamed = (java.lang.Float.compare(fRound, 10.0f) < 0 && 1.0E-5f >= java.lang.Math.abs(fRound % 1.0f)) || (java.lang.Float.compare(fRound, 10.0f) > 0 && 1.0E-5f >= java.lang.Math.abs(fRound % 10.0f));
            if (1 == getLayoutDirection()) {
                totleAngle = getTotleAngle();
                fE_renamed = 1.0f - fE_renamed;
            } else {
                totleAngle = getTotleAngle();
            }
            float f8 = totleAngle2 - (totleAngle * fE_renamed);
            double d_renamed = f8;
            int i5 = i4;
            float fCos = (float) java.lang.Math.cos(java.lang.Math.toRadians(d_renamed));
            float fSin = (float) java.lang.Math.sin(java.lang.Math.toRadians(d_renamed));
            float f9 = this.af_renamed + (f7 * fCos);
            float f10 = this.dk_renamed - (f7 * fSin);
            this.dP_renamed.setStrokeWidth(this.dH_renamed);
            int i6 = this.dG_renamed;
            float f11 = f9 - ((i6 * 1.0f) / 2.0f);
            float f12 = ((i6 * 1.0f) / 2.0f) + f9;
            if (zB) {
                this.dP_renamed.setColor(-1);
            } else if (z_renamed) {
                this.dP_renamed.setColor(this.dI_renamed);
            } else {
                this.dP_renamed.setColor(this.dJ_renamed);
            }
            int iM = m_renamed(f8);
            if (java.lang.Float.compare(f_renamed, 1.0f) <= 0) {
                iM = (int) (iM * f_renamed);
            }
            int i7 = iM;
            this.dP_renamed.setAlpha(i7);
            int iSave = canvas.save();
            float f13 = 90.0f - f8;
            canvas.rotate(f13, f9, f10);
            if (java.lang.Float.compare(fRound, 1.0f) < 0 && !zB && this.bi_renamed) {
                canvas.drawCircle((f11 + f12) / 2.0f, (f10 + f10) / 2.0f, this.dK_renamed / 2, this.dP_renamed);
                f3 = f13;
                i2 = i7;
                f4 = totleAngle2;
                i_renamed = iSave;
                f5 = fRound;
            } else {
                f3 = f13;
                f4 = totleAngle2;
                i_renamed = iSave;
                i2 = i7;
                f5 = fRound;
                canvas.drawLine(f11, f10, f12, f10, this.dP_renamed);
            }
            canvas.restoreToCount(i_renamed);
            if (zB) {
                java.lang.String strA = a_renamed(f_renamed(f5));
                int iSave2 = canvas.save();
                this.dy_renamed.getTextBounds(strA, 0, strA.length(), new android.graphics.Rect());
                float f14 = (f7 - (this.dH_renamed / 2)) - this.dw_renamed;
                float f15 = this.af_renamed + (fCos * f14);
                float f16 = this.dk_renamed - (f14 * fSin);
                canvas.rotate(f3, f15, f16);
                canvas.rotate(-this.aV_renamed, f15, f16);
                if (java.lang.Float.compare(f_renamed, 1.0f) <= 0) {
                    this.dy_renamed.setAlpha((int) (255.0f * f_renamed));
                } else {
                    this.dy_renamed.setAlpha(255);
                }
                int dimensionPixelSize = this.ax_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_marker_text_y_offset);
                this.dy_renamed.setAlpha(i2);
                canvas.drawText(strA, f15, dimensionPixelSize + f16, this.dy_renamed);
                this.dR_renamed.put(java.lang.Float.toString(f_renamed(f5)), new android.util.Size((int) f15, ((int) f16) + dimensionPixelSize));
                canvas.restoreToCount(iSave2);
            }
            i4 = i5 + 1;
            totleAngle2 = f4;
        }
        int iSave3 = canvas.save();
        float f17 = this.dN_renamed;
        int i8 = this.dj_renamed;
        float f18 = (f17 + i8) - (i8 * f2);
        int i9 = java.lang.Float.compare(f_renamed, 1.0f) <= 0 ? (int) (255 * f_renamed) : 255;
        a_renamed(canvas, this.ax_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.zoom_indicator), this.af_renamed, (r2.getIntrinsicHeight() / 2) + f18, 1.0f, i9);
        canvas.restoreToCount(iSave3);
    }

    private float[] getSweepGradientPositions() {
        float f_renamed = this.dm_renamed;
        float f2 = this.dn_renamed;
        return new float[]{((f_renamed + 180.0f) * 1.0f) / 360.0f, ((180.0f + f2) * 1.0f) / 360.0f, ((360.0f - f2) * 1.0f) / 360.0f, ((360.0f - f_renamed) * 1.0f) / 360.0f};
    }

    private int m_renamed(float f_renamed) {
        float f2;
        float f3;
        float f4 = this.dm_renamed;
        float f5 = this.dn_renamed;
        int alpha = this.dP_renamed.getAlpha();
        if (f_renamed < f5 || f_renamed > 180.0f - f5) {
            if (f_renamed >= f4 && f_renamed <= f5) {
                f2 = (alpha * 1.0f) / (f5 - f4);
                f3 = f_renamed - f4;
            } else if (f_renamed < 180.0f - f5 || f_renamed > 180.0f - f4) {
                alpha = 0;
            } else {
                f2 = (alpha * 1.0f) / (f4 - f5);
                f3 = (f_renamed + f4) - 180.0f;
            }
            alpha = (int) (f2 * f3);
        }
        return java.lang.Math.max(alpha, 0);
    }

    private void b_renamed(android.graphics.Canvas canvas, float f_renamed) {
        canvas.clipRect(this.dh_renamed.a_renamed().a_renamed(this.aw_renamed.getResources(), new android.graphics.Rect(0, 0, canvas.getWidth(), canvas.getHeight())), android.graphics.Region.Op.INTERSECT);
        float f2 = this.dk_renamed - (this.dj_renamed * (1.0f - f_renamed));
        canvas.drawCircle(this.af_renamed, this.dk_renamed, f2 - this.dl_renamed, this.f1do);
        canvas.drawCircle(this.af_renamed, this.dk_renamed, f2 - (this.dl_renamed * 0.5f), this.dp_renamed);
    }

    @Override // com.oplus.camera.ui.preview.ai_renamed
    protected boolean a_renamed(android.view.MotionEvent motionEvent) {
        float x_renamed = motionEvent.getX();
        float y_renamed = motionEvent.getY();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (0.0f > y_renamed || y_renamed > measuredHeight) {
            return true;
        }
        int i_renamed = measuredWidth / 2;
        return java.lang.Math.pow((double) java.lang.Math.abs(x_renamed - ((float) i_renamed)), 2.0d) + java.lang.Math.pow(java.lang.Math.abs(((double) y_renamed) - (java.lang.Math.sqrt(java.lang.Math.pow((double) this.dk_renamed, 2.0d) - java.lang.Math.pow((double) i_renamed, 2.0d)) + ((double) measuredHeight))), 2.0d) < java.lang.Math.pow((double) this.dk_renamed, 2.0d);
    }

    @Override // com.oplus.camera.ui.preview.ai_renamed
    public java.lang.String a_renamed(float f_renamed) {
        boolean zoomValueUnit = getZoomValueUnit();
        com.oplus.camera.e_renamed.a_renamed("ZoomArcSeekBar", "zoomValueUnit, changeUnit:" + zoomValueUnit);
        if (this.bP_renamed == null) {
            this.bP_renamed = new com.oplus.camera.ah_renamed();
        }
        return this.bP_renamed.a_renamed(zoomValueUnit, f_renamed);
    }

    private void n_renamed(float f_renamed) {
        if (f_renamed > 1.0f || f_renamed < 0.0f) {
            this.f1do.setColor(this.dr_renamed);
            this.dp_renamed.setColor(this.ds_renamed);
            this.dq_renamed.setColor(this.ds_renamed);
        } else {
            this.f1do.setColor(this.dr_renamed);
            this.f1do.setAlpha((int) (this.du_renamed * f_renamed));
            this.dp_renamed.setColor(-1);
            this.dp_renamed.setAlpha((int) (this.dt_renamed * f_renamed));
            this.dq_renamed.setColor(-1);
            this.dq_renamed.setAlpha((int) (this.dt_renamed * f_renamed));
        }
    }

    @Override // com.oplus.camera.ui.preview.ai_renamed
    public float a_renamed(float f_renamed, android.view.VelocityTracker velocityTracker) {
        float fMin = java.lang.Math.min(java.lang.Math.max(this.au_renamed + (((this.av_renamed - this.au_renamed) / (this.as_renamed - this.ar_renamed)) * (java.lang.Math.abs((int) velocityTracker.getXVelocity()) - this.ar_renamed)), this.au_renamed), this.av_renamed);
        if (java.lang.Math.abs(f_renamed) <= this.aq_renamed && fMin > this.au_renamed * 2.0f) {
            fMin /= 2.0f;
        }
        return (-f_renamed) * fMin;
    }

    public void u_renamed() {
        if (this.dh_renamed == null || this.dh_renamed.a_renamed().j_renamed() != 4 || this.dh_renamed.a_renamed().q_renamed()) {
            return;
        }
        this.f1do.setColor(this.aw_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.zoom_seekbar_focus_circle_stroke_color));
    }
}
