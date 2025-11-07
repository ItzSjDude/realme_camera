package com.oplus.camera.e_renamed;

/* compiled from: CameraRequestTag.java */
/* loaded from: classes2.dex */
public class c_renamed implements java.lang.Cloneable {

    /* renamed from: a_renamed, reason: collision with root package name */
    public boolean f4423a = false;

    /* renamed from: b_renamed, reason: collision with root package name */
    public boolean f4424b = false;

    /* renamed from: c_renamed, reason: collision with root package name */
    public boolean f4425c = false;
    public java.lang.String d_renamed = null;
    public java.lang.String e_renamed = "rosy_nude";
    public int f_renamed = 0;
    public boolean g_renamed = false;
    public boolean h_renamed = false;
    public java.lang.String i_renamed = "default";
    public boolean j_renamed = false;
    public boolean k_renamed = false;
    public boolean l_renamed = false;
    public int m_renamed = 0;
    public boolean n_renamed = false;
    public boolean o_renamed = false;
    public boolean p_renamed = false;
    public java.lang.String q_renamed = null;
    public boolean r_renamed = false;
    public boolean s_renamed = false;
    public boolean t_renamed = false;
    public int u_renamed = 0;
    public int v_renamed = -1;
    public boolean w_renamed = false;
    public boolean x_renamed = false;
    public int y_renamed = 1;
    public int z_renamed = 0;
    public java.lang.String A_renamed = "";
    public int B_renamed = 0;
    public java.lang.String C_renamed = "";
    public boolean D_renamed = false;
    public java.lang.String E_renamed = "";
    public boolean F_renamed = false;
    public java.lang.String G_renamed = "";
    public java.lang.String H_renamed = "";
    public java.lang.String I_renamed = "";
    public int J_renamed = -1;
    public java.lang.String[] K_renamed = null;
    public int[] L_renamed = null;
    public boolean M_renamed = false;
    public com.oplus.camera.aps.util.CameraApsDecision N_renamed = null;
    public int O_renamed = 0;
    public int P_renamed = 0;
    public boolean Q_renamed = false;
    public int R_renamed = 60;
    public float S_renamed = 0.0f;
    public int T_renamed = 1;
    public int U_renamed = 0;
    public int V_renamed = 0;
    public int W_renamed = 0;
    public int X_renamed = 0;
    public boolean Y_renamed = false;
    public java.lang.String Z_renamed = null;
    public boolean aa_renamed = false;
    public long ab_renamed = 0;
    public boolean ac_renamed = false;
    public long ad_renamed = 0;
    public boolean ae_renamed = false;
    public int af_renamed = 0;
    public boolean ag_renamed = false;
    private com.oplus.camera.e_renamed.c_renamed.a_renamed ah_renamed = com.oplus.camera.e_renamed.c_renamed.a_renamed.PREVIEW;

    /* compiled from: CameraRequestTag.java */
    public enum a_renamed {
        PREVIEW,
        CAPTURE,
        CAPTURE_RAW,
        CAPTURE_REPROCESS
    }

    public void a_renamed(com.oplus.camera.e_renamed.c_renamed.a_renamed aVar) {
        this.ah_renamed = aVar;
    }

    public com.oplus.camera.e_renamed.c_renamed.a_renamed a_renamed() {
        return this.ah_renamed;
    }

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException e_renamed) {
            e_renamed.printStackTrace();
            return this;
        }
    }
}
