package com.oplus.camera.algovisualization;

/* compiled from: AppAlgoProcessor.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f4153a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f4154b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f4155c;
    private boolean d_renamed;
    private boolean e_renamed;
    private boolean f_renamed;
    private boolean g_renamed;
    private boolean h_renamed;
    private boolean i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private boolean s_renamed;
    private float t_renamed;
    private int u_renamed;
    private java.lang.String v_renamed = "FR";
    private java.lang.String w_renamed = "SB";
    private java.lang.String x_renamed = "FI";
    private java.lang.String y_renamed = "FB";
    private java.lang.String z_renamed = "DE";
    private java.lang.String A_renamed = "VB";
    private java.lang.String B_renamed = "VR";
    private java.lang.String C_renamed = "FLM";
    private java.lang.String D_renamed = "FL";
    private java.lang.String E_renamed = "EE";
    private java.lang.String F_renamed = "ST";
    private java.lang.String G_renamed = "SBT";
    private java.lang.String H_renamed = "FE";
    private java.lang.String I_renamed = "TS";
    private java.lang.String J_renamed = "RM";
    private java.lang.String K_renamed = "UP";
    private java.lang.String L_renamed = "WM";
    private java.lang.String M_renamed = "SK";
    private java.lang.String N_renamed = "AMJ";
    private java.lang.String O_renamed = "DE";
    private java.lang.String P_renamed = "BL";
    private java.lang.String Q_renamed = com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MACRO;
    private java.lang.String R_renamed = com.oplus.camera.aps.constant.ApsConstant.REC_MODE_MICROSCOPE;
    private final int S_renamed = 0;

    public d_renamed(boolean z_renamed, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, float f_renamed, int i_renamed) {
        this.f4153a = z_renamed;
        this.f4154b = z2;
        this.f4155c = z3;
        this.d_renamed = z4;
        this.e_renamed = z5;
        this.f_renamed = z6;
        this.g_renamed = z7;
        this.h_renamed = z8;
        this.i_renamed = z9;
        this.j_renamed = z10;
        this.k_renamed = z11;
        this.l_renamed = z12;
        this.m_renamed = z13;
        this.n_renamed = z14;
        this.o_renamed = z15;
        this.p_renamed = z16;
        this.q_renamed = z17;
        this.r_renamed = z18;
        this.s_renamed = z19;
        this.t_renamed = f_renamed;
        this.u_renamed = i_renamed;
    }

    public java.util.ArrayList<java.lang.String> a_renamed() {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        if (this.f4153a) {
            arrayList.add(this.P_renamed + ":" + com.oplus.camera.ui.preview.a_renamed.e_renamed.f6890a);
        }
        if (this.f4154b) {
            arrayList.add(this.D_renamed + ":" + com.oplus.camera.ui.preview.a_renamed.l_renamed.f6911a);
        }
        if (this.f4155c && com.oplus.camera.algovisualization.g_renamed.b_renamed() > 0) {
            arrayList.add(this.y_renamed + ":" + com.oplus.camera.ui.preview.a_renamed.h_renamed.f6898a);
        }
        if (this.d_renamed) {
            arrayList.add(this.M_renamed + ":" + com.oplus.camera.ui.preview.a_renamed.w_renamed.f6968a);
        }
        if (this.e_renamed) {
            arrayList.add(this.N_renamed + ":" + com.oplus.camera.ui.preview.a_renamed.c_renamed.f6878a);
        }
        if ((this.f_renamed && this.f4153a) || this.g_renamed) {
            arrayList.add(this.A_renamed + ":" + com.oplus.camera.ui.preview.a_renamed.ac_renamed.f6842a);
        }
        if (this.h_renamed) {
            arrayList.add(this.F_renamed + ":" + com.oplus.camera.ui.preview.a_renamed.x_renamed.f6972a);
        }
        if (this.i_renamed) {
            arrayList.add(this.B_renamed + ":" + com.oplus.camera.ui.preview.a_renamed.ae_renamed.f6857a);
        }
        if (this.j_renamed && this.t_renamed > 0.0f) {
            arrayList.add(this.I_renamed + ":" + com.oplus.camera.ui.preview.a_renamed.ab_renamed.f6836a);
        }
        if (this.k_renamed) {
            arrayList.add(this.O_renamed + ":" + com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed.f6821a);
        }
        if (this.l_renamed) {
            arrayList.add(this.H_renamed + ":" + com.oplus.camera.ui.preview.a_renamed.n_renamed.f6918a);
        }
        return arrayList;
    }

    public java.util.ArrayList<java.lang.String> a_renamed(com.oplus.camera.e_renamed.c_renamed cVar) {
        java.lang.String strValueOf;
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        if (this.n_renamed && !this.m_renamed && com.oplus.camera.algovisualization.g_renamed.b_renamed() > 0) {
            arrayList.add(java.lang.String.valueOf(this.v_renamed));
        }
        if (cVar.d_renamed != null) {
            arrayList.add(java.lang.String.valueOf(this.w_renamed));
        }
        java.lang.String str = cVar.A_renamed;
        if (cVar.f4424b || ((this.o_renamed && this.p_renamed) || !"none".equals(cVar.e_renamed))) {
            if (com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(str, this.u_renamed, com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_FACE_INFO)) {
                arrayList.add(java.lang.String.valueOf(this.x_renamed));
            }
            if (cVar.f4424b && 4 != cVar.m_renamed && 5 != cVar.m_renamed && 3 != cVar.m_renamed && com.oplus.camera.algovisualization.g_renamed.b_renamed() > 0 && !this.d_renamed) {
                arrayList.add(java.lang.String.valueOf(this.y_renamed));
            } else if (!"none".equals(cVar.e_renamed) && !arrayList.contains(com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_FACE_BEAUTY) && com.oplus.camera.algovisualization.g_renamed.b_renamed() > 0 && !this.d_renamed) {
                arrayList.add(java.lang.String.valueOf(this.y_renamed));
            }
            if (this.o_renamed && this.p_renamed) {
                arrayList.add(java.lang.String.valueOf(this.z_renamed));
            }
        }
        if ((this.f_renamed && this.f4153a) || this.g_renamed) {
            arrayList.add(java.lang.String.valueOf(this.A_renamed));
        }
        if (this.q_renamed && this.i_renamed) {
            arrayList.add(java.lang.String.valueOf(this.B_renamed));
        }
        if (this.f4154b) {
            if (str.equals(this.Q_renamed) || str.equals(this.R_renamed)) {
                strValueOf = java.lang.String.valueOf(this.C_renamed);
            } else {
                strValueOf = java.lang.String.valueOf(this.D_renamed);
            }
            arrayList.add(strValueOf);
        }
        if (cVar.p_renamed) {
            arrayList.add(java.lang.String.valueOf(this.E_renamed));
        }
        if (this.h_renamed && this.r_renamed) {
            arrayList.add(java.lang.String.valueOf(this.F_renamed));
        }
        if (com.oplus.camera.e_renamed.c_renamed.a_renamed.CAPTURE_REPROCESS == cVar.a_renamed() && cVar.r_renamed) {
            arrayList.add(java.lang.String.valueOf(this.G_renamed));
        }
        if (this.l_renamed) {
            arrayList.add(java.lang.String.valueOf(this.H_renamed));
        }
        if (this.j_renamed && this.t_renamed > 0.0f) {
            arrayList.add(java.lang.String.valueOf(this.I_renamed));
        }
        if (com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(str, this.u_renamed, com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_ROTATE_MIRROR) || cVar.w_renamed) {
            arrayList.add(java.lang.String.valueOf(this.J_renamed));
        }
        if (com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(str, this.u_renamed, com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_UPSCALE)) {
            arrayList.add(java.lang.String.valueOf(this.K_renamed));
        }
        if (this.s_renamed) {
            arrayList.add(java.lang.String.valueOf(this.L_renamed));
        }
        return arrayList;
    }
}
