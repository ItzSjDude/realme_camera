package com.oplus.camera.panorama;

/* loaded from: classes2.dex */
public class PanoramaProgressBar extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static int f4933a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static int f4934b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static int f4935c = 0;
    private static int d_renamed = 0;
    private static int e_renamed = 6;
    private static float f_renamed = 6.0f;
    private static float g_renamed = 6.0f;
    private static int h_renamed = 120;
    private static int i_renamed = 120;
    private static int j_renamed = 0;
    private static int k_renamed = 0;
    private static int l_renamed = 0;
    private static int m_renamed = 36;
    private static int n_renamed = 0;
    private static int o_renamed = 36;
    private static int p_renamed;
    private static int q_renamed;
    private static int r_renamed;
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
    private android.graphics.drawable.Drawable K_renamed;
    private android.graphics.drawable.Drawable L_renamed;
    private android.view.animation.PathInterpolator M_renamed;
    private android.view.animation.PathInterpolator N_renamed;
    private android.animation.ObjectAnimator O_renamed;
    private android.animation.ObjectAnimator P_renamed;
    private android.animation.ObjectAnimator Q_renamed;
    private android.animation.ObjectAnimator R_renamed;
    private android.animation.ObjectAnimator S_renamed;
    private android.animation.ObjectAnimator T_renamed;
    private android.animation.ObjectAnimator U_renamed;
    private android.animation.ObjectAnimator V_renamed;
    private android.animation.ObjectAnimator W_renamed;
    private android.graphics.drawable.Drawable aa_renamed;
    private android.graphics.Rect ab_renamed;
    private android.graphics.Rect ac_renamed;
    private android.graphics.Rect ad_renamed;
    private android.graphics.Rect ae_renamed;
    private android.graphics.Rect af_renamed;
    private android.content.res.Resources ag_renamed;
    private android.graphics.Paint ah_renamed;
    private android.graphics.Paint ai_renamed;
    private android.graphics.Paint aj_renamed;
    private android.graphics.Path ak_renamed;
    private android.graphics.DashPathEffect al_renamed;
    private android.graphics.Paint am_renamed;
    private android.graphics.Paint an_renamed;
    private int ao_renamed;
    private float ap_renamed;
    private int aq_renamed;
    private com.oplus.camera.panorama.PanoramaProgressBar.RearPanoramaInterface ar_renamed;
    private int as_renamed;
    private android.graphics.Rect at_renamed;
    private int au_renamed;
    private int av_renamed;
    private int aw_renamed;
    private android.graphics.Bitmap ax_renamed;
    private android.graphics.Bitmap s_renamed;
    private android.graphics.Bitmap t_renamed;
    private android.graphics.Canvas u_renamed;
    private android.graphics.Paint v_renamed;
    private boolean w_renamed;
    private int x_renamed;
    private int y_renamed;
    private int z_renamed;

    public interface RearPanoramaInterface {
        void onReportDirectionChange(int i_renamed);
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("PanoramaProgressBar", "startArrowAnimation, mDirection: " + this.x_renamed);
        int i2 = this.x_renamed;
        if (i2 != -1) {
            if (i2 == 2) {
                p_renamed();
                return;
            } else {
                if (i2 != 3) {
                    return;
                }
                n_renamed();
                return;
            }
        }
        int i3 = this.y_renamed;
        if (4 == i3) {
            m_renamed();
        } else if (5 == i3) {
            o_renamed();
        }
    }

    public PanoramaProgressBar(android.content.Context context) {
        super(context);
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = false;
        this.x_renamed = -1;
        this.y_renamed = 0;
        this.z_renamed = 0;
        this.A_renamed = 0;
        this.B_renamed = 0;
        this.C_renamed = 0;
        this.D_renamed = 0;
        this.E_renamed = 0;
        this.F_renamed = 0;
        this.G_renamed = 0;
        this.H_renamed = 0;
        this.I_renamed = 0;
        this.J_renamed = 0;
        this.K_renamed = null;
        this.L_renamed = null;
        this.M_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.N_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.O_renamed = null;
        this.P_renamed = null;
        this.Q_renamed = null;
        this.R_renamed = null;
        this.S_renamed = null;
        this.T_renamed = null;
        this.U_renamed = null;
        this.V_renamed = null;
        this.W_renamed = null;
        this.aa_renamed = null;
        this.ab_renamed = new android.graphics.Rect();
        this.ac_renamed = new android.graphics.Rect();
        this.ad_renamed = new android.graphics.Rect();
        this.ae_renamed = new android.graphics.Rect();
        this.af_renamed = new android.graphics.Rect();
        this.ag_renamed = null;
        this.ah_renamed = null;
        this.ai_renamed = null;
        this.aj_renamed = null;
        this.ak_renamed = null;
        this.al_renamed = null;
        this.am_renamed = null;
        this.an_renamed = null;
        this.ao_renamed = 0;
        this.ap_renamed = 0.0f;
        this.aq_renamed = 0;
        this.ar_renamed = null;
        this.as_renamed = 0;
        this.at_renamed = new android.graphics.Rect();
        this.au_renamed = -1;
        this.av_renamed = 0;
        this.aw_renamed = 0;
        this.ax_renamed = null;
        this.ag_renamed = context.getApplicationContext().getResources();
        this.aa_renamed = this.ag_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.panrama_progress_bar_bg);
        this.K_renamed = this.ag_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.arrow_left);
        this.L_renamed = this.ag_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.arrow_right);
        i_renamed();
        h_renamed = this.ag_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.panorama_arrow_width);
        i_renamed = this.ag_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.panorama_arrow_height);
        e_renamed = this.ag_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.panorama_line_width);
        f_renamed = this.ag_renamed.getDimension(com.oplus.camera.R_renamed.dimen.panorama_line_dash_width);
        g_renamed = this.ag_renamed.getDimension(com.oplus.camera.R_renamed.dimen.panorama_line_spacing_width);
        m_renamed = this.ag_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.panorama_progressbar_margin_left);
        o_renamed = this.ag_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.panorama_arrow_margin_left);
        p_renamed = this.ag_renamed.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency);
        q_renamed = com.oplus.camera.util.Util.A_renamed(context);
        r_renamed = this.ag_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.panorama_line_offset_threshold);
        this.D_renamed = com.oplus.camera.util.Util.t_renamed() ? this.ag_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.full_screen_panorama_init_rect_width) : this.ag_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.panorama_init_rect_width);
        this.ao_renamed = this.ag_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.panorama_rim_width);
        this.ap_renamed = this.ao_renamed / 2.0f;
        this.aq_renamed = com.oplus.camera.util.Util.t_renamed() ? this.ag_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.full_screen_panorama_rim_rect_width) : this.ag_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.panorama_rim_rect_width);
        this.an_renamed = new android.graphics.Paint();
        this.an_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.an_renamed.setStrokeWidth(this.ao_renamed);
        this.an_renamed.setColor(-1);
    }

    private void i_renamed() {
        android.graphics.drawable.Drawable drawable = this.K_renamed;
        if (drawable != null) {
            this.O_renamed = android.animation.ObjectAnimator.ofInt(drawable, "alpha", 0, 255);
            this.O_renamed.setInterpolator(this.N_renamed);
            this.O_renamed.setDuration(250L);
            this.P_renamed = android.animation.ObjectAnimator.ofInt(this.K_renamed, "alpha", 255, 0);
            this.P_renamed.setInterpolator(this.N_renamed);
            this.P_renamed.setDuration(250L);
        }
        android.graphics.drawable.Drawable drawable2 = this.L_renamed;
        if (drawable2 != null) {
            this.Q_renamed = android.animation.ObjectAnimator.ofInt(drawable2, "alpha", 0, 255);
            this.Q_renamed.setInterpolator(this.N_renamed);
            this.Q_renamed.setDuration(250L);
            this.R_renamed = android.animation.ObjectAnimator.ofInt(this.L_renamed, "alpha", 255, 0);
            this.R_renamed.setInterpolator(this.N_renamed);
            this.R_renamed.setDuration(250L);
        }
    }

    public void setRearPanoramaInterface(com.oplus.camera.panorama.PanoramaProgressBar.RearPanoramaInterface rearPanoramaInterface) {
        this.ar_renamed = rearPanoramaInterface;
    }

    public void a_renamed(int i2, int i3, int i4, int i5, int i6, int i7) {
        f4933a = i2;
        f4934b = i3;
        f4935c = i4;
        d_renamed = i5;
        n_renamed = i6;
        m_renamed = i7;
        android.graphics.Bitmap bitmap = this.t_renamed;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.t_renamed = com.oplus.camera.util.Util.a_renamed(f4933a, f4934b, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Rect rect = this.ab_renamed;
        int i8 = f4935c;
        int i9 = d_renamed;
        rect.set(i8, i9, f4933a + i8, f4934b + i9);
        this.ah_renamed = new android.graphics.Paint();
        this.ah_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.ah_renamed.setAntiAlias(true);
        this.ah_renamed.setStrokeWidth(e_renamed);
        this.ah_renamed.setColor(q_renamed);
        this.ai_renamed = new android.graphics.Paint();
        this.ai_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.ai_renamed.setAntiAlias(true);
        this.ai_renamed.setStrokeWidth(e_renamed);
        this.ai_renamed.setColor(p_renamed);
        this.al_renamed = new android.graphics.DashPathEffect(new float[]{f_renamed, g_renamed}, 0.0f);
        this.ai_renamed.setPathEffect(this.al_renamed);
        this.ak_renamed = new android.graphics.Path();
        this.ak_renamed.moveTo(f4935c, d_renamed + (this.ab_renamed.height() / 2.0f));
        this.ak_renamed.lineTo(this.ab_renamed.right, d_renamed + (this.ab_renamed.height() / 2.0f));
        this.am_renamed = new android.graphics.Paint();
        this.v_renamed = new android.graphics.Paint();
        this.v_renamed.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC));
        this.aj_renamed = new android.graphics.Paint();
        j_renamed();
    }

    private void j_renamed() {
        android.graphics.Paint paint = this.ah_renamed;
        if (paint != null) {
            this.T_renamed = android.animation.ObjectAnimator.ofInt(paint, "alpha", 0, 255);
            this.T_renamed.setInterpolator(this.N_renamed);
            this.T_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.panorama.PanoramaProgressBar.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    if (com.oplus.camera.panorama.PanoramaProgressBar.this.ah_renamed != null) {
                        com.oplus.camera.panorama.PanoramaProgressBar.this.ah_renamed.setColor(com.oplus.camera.panorama.PanoramaProgressBar.q_renamed);
                    }
                }
            });
            this.T_renamed.setDuration(250L);
            this.S_renamed = android.animation.ObjectAnimator.ofInt(this.ah_renamed, "alpha", 255, 0);
            this.S_renamed.setInterpolator(this.N_renamed);
            this.S_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.panorama.PanoramaProgressBar.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    if (com.oplus.camera.panorama.PanoramaProgressBar.this.ah_renamed != null) {
                        com.oplus.camera.panorama.PanoramaProgressBar.this.ah_renamed.setColor(com.oplus.camera.panorama.PanoramaProgressBar.q_renamed);
                    }
                }
            });
            this.S_renamed.setDuration(250L);
        }
        android.graphics.Paint paint2 = this.ai_renamed;
        if (paint2 != null) {
            this.V_renamed = android.animation.ObjectAnimator.ofInt(paint2, "alpha", 0, 255);
            this.V_renamed.setInterpolator(this.N_renamed);
            this.V_renamed.setDuration(250L);
            this.U_renamed = android.animation.ObjectAnimator.ofInt(this.ai_renamed, "alpha", 255, 0);
            this.U_renamed.setInterpolator(this.N_renamed);
            this.U_renamed.setDuration(250L);
        }
        android.graphics.Paint paint3 = this.aj_renamed;
        if (paint3 != null) {
            this.W_renamed = android.animation.ObjectAnimator.ofInt(paint3, "alpha", 255, 0);
            this.W_renamed.setInterpolator(this.N_renamed);
            this.W_renamed.setDuration(250L);
        }
    }

    public void b_renamed() {
        int i2;
        int i3 = this.x_renamed;
        if (i3 == -1) {
            int i4 = f4933a / 2;
            int i5 = this.D_renamed;
            this.z_renamed = (i4 - (i5 / 2)) + this.as_renamed;
            int i6 = this.z_renamed;
            this.B_renamed = i5 + i6;
            this.A_renamed = d_renamed;
            int i7 = this.A_renamed;
            this.C_renamed = f4934b + i7;
            android.graphics.Rect rect = this.ac_renamed;
            int i8 = n_renamed;
            rect.set(i6, i7 + i8, this.B_renamed, this.C_renamed - i8);
            this.ae_renamed.set((this.z_renamed - o_renamed) - h_renamed, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2), this.z_renamed - o_renamed, this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2));
            this.af_renamed.set(this.B_renamed + o_renamed, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2), this.B_renamed + o_renamed + h_renamed, this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2));
            int i9 = this.y_renamed;
            if (i9 == 0) {
                return;
            }
            if (2 == i9) {
                this.H_renamed++;
                this.G_renamed = (int) (k_renamed * this.M_renamed.getInterpolation(this.H_renamed / 48.0f));
                if (48 == this.H_renamed) {
                    this.G_renamed = k_renamed;
                }
                android.graphics.Rect rect2 = this.ac_renamed;
                int i10 = this.z_renamed;
                int i11 = this.G_renamed;
                rect2.left = i10 - i11;
                rect2.right = this.B_renamed - i11;
                this.ae_renamed.set(((i10 - o_renamed) - h_renamed) - i11, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, (this.z_renamed - o_renamed) - this.G_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
                this.af_renamed.set((this.B_renamed + o_renamed) - this.G_renamed, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2), ((this.B_renamed + o_renamed) + h_renamed) - this.G_renamed, this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2));
                if (48 == this.H_renamed) {
                    this.ad_renamed.set(this.af_renamed);
                    this.G_renamed = 0;
                    this.H_renamed = 0;
                    setContentDescription(getContext().getString(com.oplus.camera.R_renamed.string.camera_description_arrow_left_to_right));
                    this.x_renamed = 3;
                    this.w_renamed = true;
                    return;
                }
                return;
            }
            if (3 == i9) {
                this.H_renamed++;
                this.G_renamed = (int) (k_renamed * this.M_renamed.getInterpolation(this.H_renamed / 48.0f));
                if (48 == this.H_renamed) {
                    this.G_renamed = k_renamed;
                }
                android.graphics.Rect rect3 = this.ac_renamed;
                int i12 = this.z_renamed;
                int i13 = this.G_renamed;
                rect3.left = i12 + i13;
                rect3.right = this.B_renamed + i13;
                this.ae_renamed.set(((i12 - o_renamed) - h_renamed) + i13, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, (this.z_renamed - o_renamed) + this.G_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
                this.af_renamed.set(this.B_renamed + o_renamed + this.G_renamed, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, this.B_renamed + o_renamed + h_renamed + this.G_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
                if (48 == this.H_renamed) {
                    this.ad_renamed.set(this.ae_renamed);
                    this.G_renamed = 0;
                    this.H_renamed = 0;
                    setContentDescription(getContext().getString(com.oplus.camera.R_renamed.string.camera_description_arrow_right_to_left));
                    this.x_renamed = 2;
                    this.w_renamed = true;
                    return;
                }
                return;
            }
            if (4 == i9) {
                this.H_renamed++;
                this.G_renamed = (int) ((this.z_renamed - this.as_renamed) * this.M_renamed.getInterpolation(this.H_renamed / 48.0f));
                if (48 == this.H_renamed) {
                    this.G_renamed = this.z_renamed - this.as_renamed;
                }
                android.graphics.Rect rect4 = this.ac_renamed;
                int i14 = this.z_renamed;
                int i15 = this.G_renamed;
                rect4.left = i14 - i15;
                rect4.right = this.B_renamed - i15;
                this.ae_renamed.set(((i14 - o_renamed) - h_renamed) - i15, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, (this.z_renamed - o_renamed) - this.G_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
                this.af_renamed.set((this.B_renamed + o_renamed) - this.G_renamed, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, ((this.B_renamed + o_renamed) + h_renamed) - this.G_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
                if (48 == this.H_renamed) {
                    this.ad_renamed.set(this.af_renamed);
                    this.H_renamed = 0;
                    this.G_renamed = 0;
                    this.x_renamed = 3;
                    this.w_renamed = true;
                    return;
                }
                return;
            }
            if (5 == i9) {
                this.H_renamed++;
                this.G_renamed = (int) ((this.z_renamed - this.as_renamed) * this.M_renamed.getInterpolation(this.H_renamed / 48.0f));
                android.graphics.Rect rect5 = this.ac_renamed;
                int i16 = this.z_renamed;
                int i17 = this.G_renamed;
                rect5.left = i16 + i17;
                rect5.right = this.B_renamed + i17;
                this.ae_renamed.set(((i16 - o_renamed) - h_renamed) + i17, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, (this.z_renamed - o_renamed) + this.G_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
                this.af_renamed.set(this.B_renamed + o_renamed + this.G_renamed, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, this.B_renamed + o_renamed + h_renamed + this.G_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
                if (48 == this.H_renamed) {
                    this.ad_renamed.set(this.ae_renamed);
                    this.H_renamed = 0;
                    this.G_renamed = 0;
                    this.x_renamed = 2;
                    this.w_renamed = true;
                    return;
                }
                return;
            }
            if (7 == i9) {
                this.H_renamed++;
                this.aw_renamed = (int) (this.E_renamed * this.M_renamed.getInterpolation(this.H_renamed / 48.0f));
                int i18 = this.au_renamed;
                if (2 == i18 || 5 == (i2 = this.av_renamed)) {
                    this.G_renamed = (int) ((this.at_renamed.left - this.z_renamed) * this.M_renamed.getInterpolation(this.H_renamed / 48.0f));
                    this.ac_renamed.left = this.at_renamed.left - this.G_renamed;
                    android.graphics.Rect rect6 = this.ac_renamed;
                    rect6.right = rect6.left + this.D_renamed;
                    this.ae_renamed.set((this.ac_renamed.left - o_renamed) - h_renamed, ((this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed) - this.aw_renamed, this.ac_renamed.left - o_renamed, ((this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed) - this.aw_renamed);
                    this.af_renamed.set(this.ac_renamed.right + o_renamed, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2), this.ac_renamed.right + o_renamed + h_renamed, this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2));
                } else if (3 == i18 || 4 == i2) {
                    this.G_renamed = (int) ((this.at_renamed.right - this.B_renamed) * this.M_renamed.getInterpolation(this.H_renamed / 48.0f));
                    this.ac_renamed.right = this.at_renamed.right - this.G_renamed;
                    android.graphics.Rect rect7 = this.ac_renamed;
                    rect7.left = rect7.right - this.D_renamed;
                    this.ae_renamed.set((this.ac_renamed.left - o_renamed) - h_renamed, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2), this.ac_renamed.left - o_renamed, this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2));
                    this.af_renamed.set(this.ac_renamed.right + o_renamed, ((this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed) - this.aw_renamed, this.ac_renamed.right + o_renamed + h_renamed, ((this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed) - this.aw_renamed);
                }
                if (48 == this.H_renamed) {
                    this.H_renamed = 0;
                    this.G_renamed = 0;
                    this.x_renamed = -1;
                    this.w_renamed = true;
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 2) {
            int i19 = f4935c;
            this.B_renamed = (f4933a + i19) - m_renamed;
            this.z_renamed = this.B_renamed - this.D_renamed;
            this.A_renamed = d_renamed;
            this.C_renamed = this.A_renamed + f4934b;
            if (this.z_renamed <= i19) {
                this.z_renamed = i19;
            }
            android.graphics.Rect rect8 = this.ac_renamed;
            int i20 = this.z_renamed;
            int i21 = this.A_renamed;
            int i22 = n_renamed;
            rect8.set(i20, i21 + i22, this.B_renamed, this.C_renamed - i22);
            int i23 = this.y_renamed;
            if (i23 == 0) {
                int i24 = this.z_renamed;
                int i25 = f4935c;
                int i26 = m_renamed + i25;
                int i27 = o_renamed;
                int i28 = h_renamed;
                if (i24 <= i26 + i27 + i28) {
                    this.ad_renamed.set(i25 + i27, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, f4935c + o_renamed + h_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
                    return;
                } else {
                    this.ad_renamed.set((i24 - i27) - i28, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, this.z_renamed - o_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
                    return;
                }
            }
            if (3 == i23) {
                this.H_renamed++;
                this.G_renamed = (int) (k_renamed * a_renamed(this.H_renamed / 48.0f));
                if (48 == this.H_renamed) {
                    this.G_renamed = k_renamed;
                }
                this.ad_renamed.set((this.z_renamed - o_renamed) - (this.G_renamed - (k_renamed - h_renamed)), this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, this.z_renamed - o_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
                if (this.ad_renamed.right - this.ad_renamed.left >= h_renamed) {
                    android.graphics.Rect rect9 = this.ad_renamed;
                    rect9.left = rect9.right - h_renamed;
                    this.G_renamed = 0;
                    this.H_renamed = 0;
                    return;
                }
                return;
            }
            if (1 == i23) {
                this.H_renamed++;
                this.G_renamed = (int) (j_renamed * this.M_renamed.getInterpolation(this.H_renamed / 48.0f));
                if (48 == this.H_renamed) {
                    this.G_renamed = j_renamed;
                }
                android.graphics.Rect rect10 = this.ac_renamed;
                int i29 = this.z_renamed;
                int i30 = this.G_renamed;
                rect10.left = i29 - i30;
                rect10.right = this.B_renamed - i30;
                this.ae_renamed.set(((i29 - o_renamed) - h_renamed) - i30, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, (this.z_renamed - o_renamed) - this.G_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
                this.af_renamed.set((this.B_renamed + o_renamed) - this.G_renamed, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2), ((this.B_renamed + o_renamed) + h_renamed) - this.G_renamed, this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2));
                if (48 == this.H_renamed) {
                    this.H_renamed = 0;
                    this.G_renamed = 0;
                    this.x_renamed = 3;
                    this.w_renamed = true;
                    return;
                }
                return;
            }
            if (6 == i23) {
                this.H_renamed++;
                this.G_renamed = (int) (l_renamed * this.M_renamed.getInterpolation(this.H_renamed / 48.0f));
                android.graphics.Rect rect11 = this.ac_renamed;
                int i31 = this.z_renamed;
                int i32 = this.G_renamed;
                rect11.left = i31 - i32;
                rect11.right = this.B_renamed - i32;
                this.ae_renamed.set(((i31 - o_renamed) - h_renamed) - i32, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, (this.z_renamed - o_renamed) - this.G_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
                this.af_renamed.set((this.B_renamed + o_renamed) - this.G_renamed, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2), ((this.B_renamed + o_renamed) + h_renamed) - this.G_renamed, this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2));
                if (48 == this.H_renamed) {
                    this.H_renamed = 0;
                    this.G_renamed = 0;
                    this.x_renamed = -1;
                    this.w_renamed = true;
                    return;
                }
                return;
            }
            return;
        }
        if (i3 != 3) {
            return;
        }
        this.z_renamed = f4935c + m_renamed;
        int i33 = this.z_renamed;
        this.B_renamed = this.D_renamed + i33;
        this.A_renamed = d_renamed;
        this.C_renamed = this.A_renamed + f4934b;
        int i34 = this.B_renamed;
        if (i33 >= i34) {
            this.z_renamed = i34;
        }
        android.graphics.Rect rect12 = this.ac_renamed;
        int i35 = this.z_renamed;
        int i36 = this.A_renamed;
        int i37 = n_renamed;
        rect12.set(i35, i36 + i37, this.B_renamed, this.C_renamed - i37);
        int i38 = this.y_renamed;
        if (i38 == 0) {
            int i39 = this.B_renamed;
            int i40 = o_renamed;
            int i41 = h_renamed;
            int i42 = i39 + i40 + i41;
            int i43 = f4935c;
            int i44 = f4933a;
            if (i42 >= (i43 + i44) - i40) {
                this.ad_renamed.set(((i43 + i44) - i41) - i40, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, (f4935c + f4933a) - o_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
                return;
            } else {
                this.ad_renamed.set(i39 + i40, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, this.B_renamed + o_renamed + h_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
                return;
            }
        }
        if (2 == i38) {
            this.H_renamed++;
            this.G_renamed = (int) (k_renamed * a_renamed(this.H_renamed / 48.0f));
            if (48 == this.H_renamed) {
                this.G_renamed = k_renamed;
            }
            this.ad_renamed.set(this.B_renamed + o_renamed, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, this.B_renamed + o_renamed + (this.G_renamed - (k_renamed - h_renamed)), (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
            if (this.ad_renamed.right - this.ad_renamed.left >= h_renamed) {
                android.graphics.Rect rect13 = this.ad_renamed;
                rect13.right = rect13.left + h_renamed;
                this.G_renamed = 0;
                this.H_renamed = 0;
                return;
            }
            return;
        }
        if (1 == i38) {
            this.H_renamed++;
            this.G_renamed = (int) (j_renamed * this.M_renamed.getInterpolation(this.H_renamed / 48.0f));
            if (48 == this.H_renamed) {
                this.G_renamed = j_renamed;
            }
            android.graphics.Rect rect14 = this.ac_renamed;
            int i45 = this.z_renamed;
            int i46 = this.G_renamed;
            rect14.left = i45 + i46;
            rect14.right = this.B_renamed + i46;
            this.ae_renamed.set(((i45 - o_renamed) - h_renamed) + i46, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, (this.z_renamed - o_renamed) + this.G_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
            this.af_renamed.set(this.B_renamed + o_renamed + this.G_renamed, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2), this.B_renamed + o_renamed + h_renamed + this.G_renamed, this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2));
            if (48 == this.H_renamed) {
                this.H_renamed = 0;
                this.G_renamed = 0;
                this.x_renamed = 2;
                this.w_renamed = true;
                return;
            }
            return;
        }
        if (6 == i38) {
            this.H_renamed++;
            this.G_renamed = (int) (l_renamed * this.M_renamed.getInterpolation(this.H_renamed / 48.0f));
            android.graphics.Rect rect15 = this.ac_renamed;
            int i47 = this.z_renamed;
            int i48 = this.G_renamed;
            rect15.left = i47 + i48;
            rect15.right = this.B_renamed + i48;
            this.ae_renamed.set(((i47 - o_renamed) - h_renamed) + i48, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2) + this.E_renamed, (this.z_renamed - o_renamed) + this.G_renamed, (this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2)) + this.E_renamed);
            this.af_renamed.set(this.B_renamed + o_renamed + this.G_renamed, this.A_renamed + ((this.ab_renamed.height() - i_renamed) / 2), this.B_renamed + o_renamed + h_renamed + this.G_renamed, this.C_renamed - ((this.ab_renamed.height() - i_renamed) / 2));
            if (48 == this.H_renamed) {
                this.H_renamed = 0;
                this.G_renamed = 0;
                this.x_renamed = -1;
                this.w_renamed = true;
            }
        }
    }

    public void setDisplay(android.graphics.Canvas canvas) {
        this.aa_renamed.setBounds(this.ab_renamed);
        this.aa_renamed.draw(canvas);
        b_renamed(canvas);
        a_renamed(canvas);
        android.graphics.Bitmap bitmap = this.s_renamed;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.ac_renamed.left, this.ac_renamed.top, this.am_renamed);
        } else {
            android.graphics.Bitmap bitmap2 = this.t_renamed;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, this.ac_renamed.left, this.ac_renamed.top, this.am_renamed);
            }
        }
        c_renamed(canvas);
        int i2 = this.x_renamed;
        if (i2 == -1) {
            this.K_renamed.setBounds(this.ae_renamed);
            this.K_renamed.draw(canvas);
            this.L_renamed.setBounds(this.af_renamed);
            this.L_renamed.draw(canvas);
        } else if (i2 == 2) {
            int i3 = this.y_renamed;
            if (6 == i3 || 1 == i3) {
                this.K_renamed.setBounds(this.ae_renamed);
                this.K_renamed.draw(canvas);
                this.L_renamed.setBounds(this.af_renamed);
                this.L_renamed.draw(canvas);
            } else {
                this.K_renamed.setBounds(this.ad_renamed);
                this.K_renamed.draw(canvas);
            }
        } else if (i2 == 3) {
            int i4 = this.y_renamed;
            if (6 == i4 || 1 == i4) {
                this.K_renamed.setBounds(this.ae_renamed);
                this.K_renamed.draw(canvas);
                this.L_renamed.setBounds(this.af_renamed);
                this.L_renamed.draw(canvas);
            } else {
                this.L_renamed.setBounds(this.ad_renamed);
                this.L_renamed.draw(canvas);
            }
        }
        if (this.w_renamed && this.G_renamed == 0) {
            setAnimationState(0);
            this.w_renamed = false;
            com.oplus.camera.e_renamed.a_renamed("PanoramaProgressBar", "setDisplay, animate end");
        }
        this.am_renamed.reset();
        if (this.y_renamed == 0) {
            if (!com.oplus.camera.util.Util.t_renamed()) {
                this.K_renamed.setAlpha(255);
                this.L_renamed.setAlpha(255);
            }
            this.ah_renamed.setAlpha(255);
            this.ai_renamed.setAlpha(255);
        }
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        int i2;
        if (this.ax_renamed == null || 7 != this.y_renamed) {
            return;
        }
        int i3 = this.au_renamed;
        if (3 == i3 || 4 == (i2 = this.av_renamed)) {
            canvas.drawBitmap(this.ax_renamed, this.ac_renamed.right - this.ax_renamed.getWidth(), this.ac_renamed.top, this.aj_renamed);
        } else if (2 == i3 || 5 == i2) {
            canvas.drawBitmap(this.ax_renamed, this.ac_renamed.left, this.ac_renamed.top, this.aj_renamed);
        }
    }

    private void b_renamed(android.graphics.Canvas canvas) {
        int i2 = this.x_renamed;
        if (i2 == 2 || i2 == 3) {
            if (6 == this.y_renamed) {
                canvas.drawPath(this.ak_renamed, this.ai_renamed);
            } else if (java.lang.Math.abs(this.ad_renamed.centerY() - this.ab_renamed.centerY()) < r_renamed) {
                this.ah_renamed.setColor(q_renamed);
            } else {
                this.ah_renamed.setColor(p_renamed);
            }
            canvas.drawPath(this.ak_renamed, this.ah_renamed);
            return;
        }
        int i3 = this.y_renamed;
        if (2 == i3 || 7 == i3 || 3 == i3 || 4 == i3 || 5 == i3) {
            canvas.drawPath(this.ak_renamed, this.ah_renamed);
        }
        canvas.drawPath(this.ak_renamed, this.ai_renamed);
    }

    private void c_renamed(android.graphics.Canvas canvas) {
        int i2;
        int i3 = this.x_renamed;
        if (i3 != -1) {
            if (i3 == 2) {
                canvas.drawRect(this.ac_renamed.left + this.ap_renamed, this.ac_renamed.top + this.ap_renamed, this.ac_renamed.left + this.ap_renamed + this.aq_renamed, this.ac_renamed.bottom - this.ap_renamed, this.an_renamed);
                return;
            } else {
                if (i3 != 3) {
                    return;
                }
                canvas.drawRect((this.ac_renamed.right - this.ap_renamed) - this.aq_renamed, this.ac_renamed.top + this.ap_renamed, this.ac_renamed.right - this.ap_renamed, this.ac_renamed.bottom - this.ap_renamed, this.an_renamed);
                return;
            }
        }
        int i4 = this.y_renamed;
        if (4 == i4) {
            canvas.drawRect((this.ac_renamed.right - this.ap_renamed) - this.aq_renamed, this.ac_renamed.top + this.ap_renamed, this.ac_renamed.right - this.ap_renamed, this.ac_renamed.bottom - this.ap_renamed, this.an_renamed);
            return;
        }
        if (5 == i4) {
            canvas.drawRect(this.ac_renamed.left + this.ap_renamed, this.ac_renamed.top + this.ap_renamed, this.ac_renamed.left + this.ap_renamed + this.aq_renamed, this.ac_renamed.bottom - this.ap_renamed, this.an_renamed);
            return;
        }
        if (7 == i4) {
            int i5 = this.au_renamed;
            if (3 == i5 || 4 == (i2 = this.av_renamed)) {
                canvas.drawRect((this.ac_renamed.right - this.ap_renamed) - this.aq_renamed, this.ac_renamed.top + this.ap_renamed, this.ac_renamed.right - this.ap_renamed, this.ac_renamed.bottom - this.ap_renamed, this.an_renamed);
                return;
            } else {
                if (2 == i5 || 5 == i2) {
                    canvas.drawRect(this.ac_renamed.left + this.ap_renamed, this.ac_renamed.top + this.ap_renamed, this.ac_renamed.left + this.ap_renamed + this.aq_renamed, this.ac_renamed.bottom - this.ap_renamed, this.an_renamed);
                    return;
                }
                return;
            }
        }
        canvas.drawRect(this.ac_renamed.left + this.ap_renamed, this.ac_renamed.top + this.ap_renamed, this.ac_renamed.right - this.ap_renamed, this.ac_renamed.bottom - this.ap_renamed, this.an_renamed);
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        b_renamed();
        setDisplay(canvas);
        if (e_renamed()) {
            invalidate();
        }
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.b_renamed("TAG", "resetProgressBar");
        android.graphics.Bitmap bitmap = this.s_renamed;
        if (bitmap != null) {
            bitmap.recycle();
            this.s_renamed = null;
        }
        android.graphics.Bitmap bitmap2 = this.t_renamed;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.t_renamed = null;
        }
        this.z_renamed = 0;
        this.A_renamed = 0;
        this.B_renamed = 0;
        this.C_renamed = 0;
        this.D_renamed = com.oplus.camera.util.Util.t_renamed() ? this.ag_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.full_screen_panorama_rim_rect_width) : this.ag_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.panorama_rim_rect_width);
        this.E_renamed = 0;
        this.F_renamed = 0;
        this.ac_renamed.setEmpty();
        f_renamed();
        setAnimationState(0);
        setDirection(-1);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 == 0) {
            this.s_renamed = null;
        }
        super.setVisibility(i2);
    }

    public void a_renamed(android.graphics.Bitmap bitmap, int i2, int i3) {
        android.graphics.Bitmap bitmap2;
        this.E_renamed = i3;
        if (i2 == 0 && this.D_renamed > this.F_renamed) {
            this.x_renamed = -1;
        }
        if (i2 < 0) {
            this.D_renamed = this.F_renamed;
        } else {
            this.D_renamed = this.F_renamed + i2;
        }
        if (i2 > 0 && (bitmap2 = this.s_renamed) != null) {
            int width = bitmap2.getWidth();
            int i4 = f4933a;
            if (width != i4) {
                this.s_renamed = com.oplus.camera.util.Util.a_renamed(i4, f4934b, android.graphics.Bitmap.Config.ARGB_8888);
                this.u_renamed = new android.graphics.Canvas(this.s_renamed);
            }
            this.u_renamed.save();
            this.u_renamed.drawBitmap(bitmap, 0.0f, 0.0f, this.v_renamed);
            this.u_renamed.restore();
        } else {
            this.s_renamed = bitmap;
        }
        invalidate();
    }

    public void setFrameSize(int i2) {
        if (this.F_renamed == i2) {
            return;
        }
        this.F_renamed = i2;
        int i3 = f4933a;
        int i4 = this.F_renamed;
        j_renamed = i3 - i4;
        int i5 = m_renamed;
        k_renamed = ((i3 - i4) / 2) - i5;
        l_renamed = ((i3 - i4) / 2) - i5;
    }

    public void d_renamed() {
        android.graphics.Bitmap bitmap = this.s_renamed;
        if (bitmap != null) {
            bitmap.recycle();
            this.s_renamed = null;
        }
        android.graphics.Bitmap bitmap2 = this.t_renamed;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.t_renamed = null;
        }
        android.graphics.Bitmap bitmap3 = this.ax_renamed;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.ax_renamed = null;
        }
    }

    public void setAnimationState(int i2) {
        com.oplus.camera.e_renamed.a_renamed("PanoramaProgressBar", "setAnimationStateState, animationState: " + i2);
        this.y_renamed = i2;
    }

    public boolean e_renamed() {
        return this.y_renamed != 0;
    }

    public float a_renamed(float f2) {
        return ((float) (java.lang.Math.cos((f2 + 1.0f) * 3.141592653589793d) * 0.5d)) + 0.5f;
    }

    private void a_renamed(int i2) {
        if (e_renamed()) {
            return;
        }
        setAnimationState(i2);
        this.G_renamed = 0;
        this.H_renamed = 0;
        this.I_renamed = 0;
        b_renamed(i2);
        invalidate();
    }

    private void b_renamed(int i2) {
        if (i2 == 1) {
            this.ar_renamed.onReportDirectionChange(3 == this.x_renamed ? 1 : 2);
        } else if (i2 == 2) {
            this.ar_renamed.onReportDirectionChange(5);
        } else {
            if (i2 != 3) {
                return;
            }
            this.ar_renamed.onReportDirectionChange(4);
        }
    }

    public void setDirection(int i2) {
        this.x_renamed = i2;
        postInvalidate();
    }

    public int getDirection() {
        return this.x_renamed;
    }

    public void f_renamed() {
        this.ad_renamed.setEmpty();
    }

    public void g_renamed() {
        f_renamed();
        this.G_renamed = 0;
        this.H_renamed = 0;
        setAnimationState(0);
        setDirection(-1);
    }

    protected boolean a_renamed(android.view.MotionEvent motionEvent) {
        int x_renamed = (int) motionEvent.getX();
        int y_renamed = (int) motionEvent.getY();
        android.graphics.Rect rect = this.ab_renamed;
        if (rect == null || !rect.contains(x_renamed, y_renamed) || this.D_renamed != this.F_renamed) {
            return false;
        }
        if (-1 == this.x_renamed) {
            if (x_renamed < this.z_renamed) {
                a_renamed(2);
                m_renamed();
            } else if (x_renamed > this.B_renamed) {
                a_renamed(3);
                o_renamed();
            }
        } else if (!e_renamed()) {
            int i2 = this.x_renamed;
            if (3 == i2) {
                k_renamed();
            } else if (2 == i2) {
                l_renamed();
            }
            a_renamed(1);
        }
        return true;
    }

    public void a_renamed(android.graphics.Bitmap bitmap) {
        int i2;
        com.oplus.camera.e_renamed.a_renamed("PanoramaProgressBar", "finishAndReset");
        if (-1 == this.x_renamed && this.y_renamed == 0) {
            this.G_renamed = 0;
            this.H_renamed = 0;
            return;
        }
        this.aw_renamed = 0;
        this.G_renamed = 0;
        this.H_renamed = 0;
        this.at_renamed.set(this.ac_renamed);
        this.au_renamed = this.x_renamed;
        this.av_renamed = this.y_renamed;
        setForceResetBitmap(bitmap);
        setDirection(-1);
        setAnimationState(7);
        android.animation.ObjectAnimator objectAnimator = this.W_renamed;
        if (objectAnimator != null && this.aj_renamed != null) {
            if (objectAnimator.isRunning()) {
                this.W_renamed.cancel();
            }
            this.aj_renamed.setAlpha(255);
            this.W_renamed.start();
        }
        int i3 = this.au_renamed;
        if (3 == i3 || 4 == (i2 = this.av_renamed)) {
            n_renamed();
        } else if (2 == i3 || 5 == i2) {
            p_renamed();
        }
    }

    public void setForceResetBitmap(android.graphics.Bitmap bitmap) {
        android.graphics.Bitmap bitmap2 = this.ax_renamed;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.ax_renamed = null;
        }
        if (bitmap != null) {
            this.ax_renamed = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        }
    }

    private void k_renamed() {
        com.oplus.camera.e_renamed.a_renamed("PanoramaProgressBar", "startArrowLeftToRightAnimator");
        r_renamed();
        s_renamed();
    }

    private void l_renamed() {
        com.oplus.camera.e_renamed.a_renamed("PanoramaProgressBar", "startArrowLeftToRightAnimator");
        q_renamed();
        t_renamed();
    }

    private void m_renamed() {
        com.oplus.camera.e_renamed.a_renamed("PanoramaProgressBar", "startArrowNoneToLeftAnimator");
        q_renamed();
        u_renamed();
    }

    private void n_renamed() {
        com.oplus.camera.e_renamed.a_renamed("PanoramaProgressBar", "startArrowLeftToNoneAnimator");
        r_renamed();
        v_renamed();
    }

    private void o_renamed() {
        com.oplus.camera.e_renamed.a_renamed("PanoramaProgressBar", "startArrowNoneToRightAnimator");
        s_renamed();
        u_renamed();
    }

    private void p_renamed() {
        com.oplus.camera.e_renamed.a_renamed("PanoramaProgressBar", "startArrowRightToNoneAnimator");
        t_renamed();
        v_renamed();
    }

    private void q_renamed() {
        android.animation.ObjectAnimator objectAnimator = this.O_renamed;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.O_renamed.cancel();
        }
        android.animation.ObjectAnimator objectAnimator2 = this.P_renamed;
        if (objectAnimator2 != null) {
            if (objectAnimator2.isRunning()) {
                this.P_renamed.cancel();
            }
            this.P_renamed.start();
        }
    }

    private void r_renamed() {
        android.animation.ObjectAnimator objectAnimator = this.P_renamed;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.P_renamed.cancel();
        }
        android.animation.ObjectAnimator objectAnimator2 = this.O_renamed;
        if (objectAnimator2 != null) {
            if (objectAnimator2.isRunning()) {
                this.O_renamed.cancel();
            }
            this.O_renamed.start();
        }
    }

    private void s_renamed() {
        android.animation.ObjectAnimator objectAnimator = this.Q_renamed;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.Q_renamed.cancel();
        }
        android.animation.ObjectAnimator objectAnimator2 = this.R_renamed;
        if (objectAnimator2 != null) {
            if (objectAnimator2.isRunning()) {
                this.R_renamed.cancel();
            }
            this.R_renamed.start();
        }
    }

    private void t_renamed() {
        android.animation.ObjectAnimator objectAnimator = this.R_renamed;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.R_renamed.cancel();
        }
        android.animation.ObjectAnimator objectAnimator2 = this.Q_renamed;
        if (objectAnimator2 != null) {
            if (objectAnimator2.isRunning()) {
                this.Q_renamed.cancel();
            }
            this.Q_renamed.start();
        }
    }

    private void u_renamed() {
        android.animation.ObjectAnimator objectAnimator = this.S_renamed;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.S_renamed.cancel();
        }
        android.animation.ObjectAnimator objectAnimator2 = this.T_renamed;
        if (objectAnimator2 != null) {
            if (objectAnimator2.isRunning()) {
                this.T_renamed.cancel();
            }
            this.T_renamed.start();
        }
        android.animation.ObjectAnimator objectAnimator3 = this.V_renamed;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.V_renamed.cancel();
        }
        android.animation.ObjectAnimator objectAnimator4 = this.U_renamed;
        if (objectAnimator4 != null) {
            if (objectAnimator4.isRunning()) {
                this.U_renamed.cancel();
            }
            this.U_renamed.start();
        }
    }

    private void v_renamed() {
        android.animation.ObjectAnimator objectAnimator = this.T_renamed;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.T_renamed.cancel();
        }
        android.animation.ObjectAnimator objectAnimator2 = this.S_renamed;
        if (objectAnimator2 != null) {
            if (objectAnimator2.isRunning()) {
                this.S_renamed.cancel();
            }
            this.S_renamed.start();
        }
        android.animation.ObjectAnimator objectAnimator3 = this.U_renamed;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.U_renamed.cancel();
        }
        android.animation.ObjectAnimator objectAnimator4 = this.V_renamed;
        if (objectAnimator4 != null) {
            if (objectAnimator4.isRunning()) {
                this.V_renamed.cancel();
            }
            this.V_renamed.start();
        }
    }

    public void setRectMarginLeft(int i2) {
        this.as_renamed = i2;
    }
}
