package androidx.constraintlayout.a_renamed.a_renamed;

/* compiled from: ConstraintWidget.java */
/* loaded from: classes.dex */
public class f_renamed {
    public static float R_renamed = 0.5f;
    protected int P_renamed;
    protected int Q_renamed;
    float S_renamed;
    float T_renamed;
    boolean U_renamed;
    boolean V_renamed;
    boolean W_renamed;
    boolean X_renamed;
    boolean Y_renamed;
    int Z_renamed;
    int aa_renamed;
    boolean ab_renamed;
    boolean ac_renamed;
    float[] ad_renamed;
    protected androidx.constraintlayout.a_renamed.a_renamed.f_renamed[] ae_renamed;
    protected androidx.constraintlayout.a_renamed.a_renamed.f_renamed[] af_renamed;
    androidx.constraintlayout.a_renamed.a_renamed.f_renamed ag_renamed;
    androidx.constraintlayout.a_renamed.a_renamed.f_renamed ah_renamed;
    private int ao_renamed;
    private int ap_renamed;
    private java.lang.Object aq_renamed;
    private int ar_renamed;
    private int as_renamed;
    private java.lang.String at_renamed;
    private java.lang.String au_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    androidx.constraintlayout.a_renamed.a_renamed.n_renamed f714c;
    androidx.constraintlayout.a_renamed.a_renamed.n_renamed d_renamed;
    boolean n_renamed;
    boolean o_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f712a = -1;

    /* renamed from: b_renamed, reason: collision with root package name */
    public int f713b = -1;
    int e_renamed = 0;
    int f_renamed = 0;
    int[] g_renamed = new int[2];
    int h_renamed = 0;
    int i_renamed = 0;
    float j_renamed = 1.0f;
    int k_renamed = 0;
    int l_renamed = 0;
    float m_renamed = 1.0f;
    int p_renamed = -1;
    float q_renamed = 1.0f;
    androidx.constraintlayout.a_renamed.a_renamed.h_renamed r_renamed = null;
    private int[] ai_renamed = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float aj_renamed = 0.0f;
    androidx.constraintlayout.a_renamed.a_renamed.e_renamed s_renamed = new androidx.constraintlayout.a_renamed.a_renamed.e_renamed(this, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.LEFT);
    androidx.constraintlayout.a_renamed.a_renamed.e_renamed t_renamed = new androidx.constraintlayout.a_renamed.a_renamed.e_renamed(this, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.TOP);
    androidx.constraintlayout.a_renamed.a_renamed.e_renamed u_renamed = new androidx.constraintlayout.a_renamed.a_renamed.e_renamed(this, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.RIGHT);
    androidx.constraintlayout.a_renamed.a_renamed.e_renamed v_renamed = new androidx.constraintlayout.a_renamed.a_renamed.e_renamed(this, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BOTTOM);
    androidx.constraintlayout.a_renamed.a_renamed.e_renamed w_renamed = new androidx.constraintlayout.a_renamed.a_renamed.e_renamed(this, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BASELINE);
    androidx.constraintlayout.a_renamed.a_renamed.e_renamed x_renamed = new androidx.constraintlayout.a_renamed.a_renamed.e_renamed(this, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.CENTER_X);
    androidx.constraintlayout.a_renamed.a_renamed.e_renamed y_renamed = new androidx.constraintlayout.a_renamed.a_renamed.e_renamed(this, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.CENTER_Y);
    androidx.constraintlayout.a_renamed.a_renamed.e_renamed z_renamed = new androidx.constraintlayout.a_renamed.a_renamed.e_renamed(this, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.CENTER);
    protected androidx.constraintlayout.a_renamed.a_renamed.e_renamed[] A_renamed = {this.s_renamed, this.u_renamed, this.t_renamed, this.v_renamed, this.w_renamed, this.z_renamed};
    protected java.util.ArrayList<androidx.constraintlayout.a_renamed.a_renamed.e_renamed> B_renamed = new java.util.ArrayList<>();
    protected androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed[] C_renamed = {androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED, androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED};
    androidx.constraintlayout.a_renamed.a_renamed.f_renamed D_renamed = null;
    int E_renamed = 0;
    int F_renamed = 0;
    protected float G_renamed = 0.0f;
    protected int H_renamed = -1;
    protected int I_renamed = 0;
    protected int J_renamed = 0;
    int K_renamed = 0;
    int L_renamed = 0;
    private int ak_renamed = 0;
    private int al_renamed = 0;
    private int am_renamed = 0;
    private int an_renamed = 0;
    protected int M_renamed = 0;
    protected int N_renamed = 0;
    int O_renamed = 0;

    /* compiled from: ConstraintWidget.java */
    public enum a_renamed {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public void d_renamed() {
    }

    public void c_renamed(int i_renamed) {
        this.ai_renamed[0] = i_renamed;
    }

    public void d_renamed(int i_renamed) {
        this.ai_renamed[1] = i_renamed;
    }

    public boolean e_renamed() {
        return this.e_renamed == 0 && this.G_renamed == 0.0f && this.h_renamed == 0 && this.i_renamed == 0 && this.C_renamed[0] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT;
    }

    public boolean f_renamed() {
        return this.f_renamed == 0 && this.G_renamed == 0.0f && this.k_renamed == 0 && this.l_renamed == 0 && this.C_renamed[1] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT;
    }

    public void g_renamed() {
        this.s_renamed.i_renamed();
        this.t_renamed.i_renamed();
        this.u_renamed.i_renamed();
        this.v_renamed.i_renamed();
        this.w_renamed.i_renamed();
        this.x_renamed.i_renamed();
        this.y_renamed.i_renamed();
        this.z_renamed.i_renamed();
        this.D_renamed = null;
        this.aj_renamed = 0.0f;
        this.E_renamed = 0;
        this.F_renamed = 0;
        this.G_renamed = 0.0f;
        this.H_renamed = -1;
        this.I_renamed = 0;
        this.J_renamed = 0;
        this.ak_renamed = 0;
        this.al_renamed = 0;
        this.am_renamed = 0;
        this.an_renamed = 0;
        this.M_renamed = 0;
        this.N_renamed = 0;
        this.O_renamed = 0;
        this.P_renamed = 0;
        this.Q_renamed = 0;
        this.ao_renamed = 0;
        this.ap_renamed = 0;
        float f_renamed = R_renamed;
        this.S_renamed = f_renamed;
        this.T_renamed = f_renamed;
        this.C_renamed[0] = androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED;
        this.C_renamed[1] = androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED;
        this.aq_renamed = null;
        this.ar_renamed = 0;
        this.as_renamed = 0;
        this.au_renamed = null;
        this.U_renamed = false;
        this.V_renamed = false;
        this.Z_renamed = 0;
        this.aa_renamed = 0;
        this.ab_renamed = false;
        this.ac_renamed = false;
        float[] fArr = this.ad_renamed;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f712a = -1;
        this.f713b = -1;
        int[] iArr = this.ai_renamed;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.j_renamed = 1.0f;
        this.m_renamed = 1.0f;
        this.i_renamed = Integer.MAX_VALUE;
        this.l_renamed = Integer.MAX_VALUE;
        this.h_renamed = 0;
        this.k_renamed = 0;
        this.p_renamed = -1;
        this.q_renamed = 1.0f;
        androidx.constraintlayout.a_renamed.a_renamed.n_renamed nVar = this.f714c;
        if (nVar != null) {
            nVar.b_renamed();
        }
        androidx.constraintlayout.a_renamed.a_renamed.n_renamed nVar2 = this.d_renamed;
        if (nVar2 != null) {
            nVar2.b_renamed();
        }
        this.r_renamed = null;
        this.W_renamed = false;
        this.X_renamed = false;
        this.Y_renamed = false;
    }

    public void c_renamed() {
        for (int i_renamed = 0; i_renamed < 6; i_renamed++) {
            this.A_renamed[i_renamed].a_renamed().b_renamed();
        }
    }

    public void h_renamed() {
        for (int i_renamed = 0; i_renamed < 6; i_renamed++) {
            this.A_renamed[i_renamed].a_renamed().c_renamed();
        }
    }

    public void b_renamed(int i_renamed) {
        androidx.constraintlayout.a_renamed.a_renamed.k_renamed.a_renamed(i_renamed, this);
    }

    public boolean i_renamed() {
        return this.s_renamed.a_renamed().i_renamed == 1 && this.u_renamed.a_renamed().i_renamed == 1 && this.t_renamed.a_renamed().i_renamed == 1 && this.v_renamed.a_renamed().i_renamed == 1;
    }

    public androidx.constraintlayout.a_renamed.a_renamed.n_renamed j_renamed() {
        if (this.f714c == null) {
            this.f714c = new androidx.constraintlayout.a_renamed.a_renamed.n_renamed();
        }
        return this.f714c;
    }

    public androidx.constraintlayout.a_renamed.a_renamed.n_renamed k_renamed() {
        if (this.d_renamed == null) {
            this.d_renamed = new androidx.constraintlayout.a_renamed.a_renamed.n_renamed();
        }
        return this.d_renamed;
    }

    public f_renamed() {
        float f_renamed = R_renamed;
        this.S_renamed = f_renamed;
        this.T_renamed = f_renamed;
        this.ar_renamed = 0;
        this.as_renamed = 0;
        this.at_renamed = null;
        this.au_renamed = null;
        this.W_renamed = false;
        this.X_renamed = false;
        this.Y_renamed = false;
        this.Z_renamed = 0;
        this.aa_renamed = 0;
        this.ad_renamed = new float[]{-1.0f, -1.0f};
        this.ae_renamed = new androidx.constraintlayout.a_renamed.a_renamed.f_renamed[]{null, null};
        this.af_renamed = new androidx.constraintlayout.a_renamed.a_renamed.f_renamed[]{null, null};
        this.ag_renamed = null;
        this.ah_renamed = null;
        b_renamed();
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.c_renamed cVar) {
        this.s_renamed.a_renamed(cVar);
        this.t_renamed.a_renamed(cVar);
        this.u_renamed.a_renamed(cVar);
        this.v_renamed.a_renamed(cVar);
        this.w_renamed.a_renamed(cVar);
        this.z_renamed.a_renamed(cVar);
        this.x_renamed.a_renamed(cVar);
        this.y_renamed.a_renamed(cVar);
    }

    private void b_renamed() {
        this.B_renamed.add(this.s_renamed);
        this.B_renamed.add(this.t_renamed);
        this.B_renamed.add(this.u_renamed);
        this.B_renamed.add(this.v_renamed);
        this.B_renamed.add(this.x_renamed);
        this.B_renamed.add(this.y_renamed);
        this.B_renamed.add(this.z_renamed);
        this.B_renamed.add(this.w_renamed);
    }

    public androidx.constraintlayout.a_renamed.a_renamed.f_renamed l_renamed() {
        return this.D_renamed;
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
        this.D_renamed = fVar;
    }

    public void b_renamed(boolean z_renamed) {
        this.n_renamed = z_renamed;
    }

    public void c_renamed(boolean z_renamed) {
        this.o_renamed = z_renamed;
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, float f_renamed, int i_renamed) {
        a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.CENTER, fVar, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.CENTER, i_renamed, 0);
        this.aj_renamed = f_renamed;
    }

    public void e_renamed(int i_renamed) {
        this.as_renamed = i_renamed;
    }

    public int m_renamed() {
        return this.as_renamed;
    }

    public java.lang.String n_renamed() {
        return this.at_renamed;
    }

    public void a_renamed(java.lang.String str) {
        this.at_renamed = str;
    }

    public void b_renamed(androidx.constraintlayout.a_renamed.e_renamed eVar) {
        eVar.a_renamed(this.s_renamed);
        eVar.a_renamed(this.t_renamed);
        eVar.a_renamed(this.u_renamed);
        eVar.a_renamed(this.v_renamed);
        if (this.O_renamed > 0) {
            eVar.a_renamed(this.w_renamed);
        }
    }

    public java.lang.String toString() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str2 = "";
        if (this.au_renamed != null) {
            str = "type: " + this.au_renamed + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.at_renamed != null) {
            str2 = "id_renamed: " + this.at_renamed + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.I_renamed);
        sb.append(", ");
        sb.append(this.J_renamed);
        sb.append(") - (");
        sb.append(this.E_renamed);
        sb.append(" x_renamed ");
        sb.append(this.F_renamed);
        sb.append(") wrap: (");
        sb.append(this.ao_renamed);
        sb.append(" x_renamed ");
        sb.append(this.ap_renamed);
        sb.append(")");
        return sb.toString();
    }

    public int o_renamed() {
        return this.I_renamed;
    }

    public int p_renamed() {
        return this.J_renamed;
    }

    public int q_renamed() {
        if (this.as_renamed == 8) {
            return 0;
        }
        return this.E_renamed;
    }

    public int r_renamed() {
        return this.ao_renamed;
    }

    public int s_renamed() {
        if (this.as_renamed == 8) {
            return 0;
        }
        return this.F_renamed;
    }

    public int t_renamed() {
        return this.ap_renamed;
    }

    public int f_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return q_renamed();
        }
        if (i_renamed == 1) {
            return s_renamed();
        }
        return 0;
    }

    public int u_renamed() {
        return this.ak_renamed + this.M_renamed;
    }

    public int v_renamed() {
        return this.al_renamed + this.N_renamed;
    }

    protected int w_renamed() {
        return this.I_renamed + this.M_renamed;
    }

    protected int x_renamed() {
        return this.J_renamed + this.N_renamed;
    }

    public int y_renamed() {
        return o_renamed() + this.E_renamed;
    }

    public int z_renamed() {
        return p_renamed() + this.F_renamed;
    }

    public float g_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return this.S_renamed;
        }
        if (i_renamed == 1) {
            return this.T_renamed;
        }
        return -1.0f;
    }

    public boolean A_renamed() {
        return this.O_renamed > 0;
    }

    public int B_renamed() {
        return this.O_renamed;
    }

    public java.lang.Object C_renamed() {
        return this.aq_renamed;
    }

    public java.util.ArrayList<androidx.constraintlayout.a_renamed.a_renamed.e_renamed> D_renamed() {
        return this.B_renamed;
    }

    public void h_renamed(int i_renamed) {
        this.I_renamed = i_renamed;
    }

    public void i_renamed(int i_renamed) {
        this.J_renamed = i_renamed;
    }

    public void a_renamed(int i_renamed, int i2) {
        this.I_renamed = i_renamed;
        this.J_renamed = i2;
    }

    public void b_renamed(int i_renamed, int i2) {
        this.M_renamed = i_renamed;
        this.N_renamed = i2;
    }

    public void E_renamed() {
        int i_renamed = this.I_renamed;
        int i2 = this.J_renamed;
        int i3 = this.E_renamed + i_renamed;
        int i4 = this.F_renamed + i2;
        this.ak_renamed = i_renamed;
        this.al_renamed = i2;
        this.am_renamed = i3 - i_renamed;
        this.an_renamed = i4 - i2;
    }

    public void j_renamed(int i_renamed) {
        this.E_renamed = i_renamed;
        int i2 = this.E_renamed;
        int i3 = this.P_renamed;
        if (i2 < i3) {
            this.E_renamed = i3;
        }
    }

    public void k_renamed(int i_renamed) {
        this.F_renamed = i_renamed;
        int i2 = this.F_renamed;
        int i3 = this.Q_renamed;
        if (i2 < i3) {
            this.F_renamed = i3;
        }
    }

    public void a_renamed(int i_renamed, int i2, int i3, float f_renamed) {
        this.e_renamed = i_renamed;
        this.h_renamed = i2;
        this.i_renamed = i3;
        this.j_renamed = f_renamed;
        if (f_renamed >= 1.0f || this.e_renamed != 0) {
            return;
        }
        this.e_renamed = 2;
    }

    public void b_renamed(int i_renamed, int i2, int i3, float f_renamed) {
        this.f_renamed = i_renamed;
        this.k_renamed = i2;
        this.l_renamed = i3;
        this.m_renamed = f_renamed;
        if (f_renamed >= 1.0f || this.f_renamed != 0) {
            return;
        }
        this.f_renamed = 2;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:38:0x0084 A_renamed[PHI: r0
      0x0084: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B_renamed:45:0x0084, B_renamed:35:0x007d, B_renamed:23:0x004f, B_renamed:25:0x0055, B_renamed:27:0x0061, B_renamed:29:0x0065] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B_renamed:38:0x0084 -> B_renamed:39:0x0085). Please report as_renamed a_renamed decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b_renamed(java.lang.String r9) throws java.lang.NumberFormatException {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L8e
            int r1 = r9.length()
            if (r1 != 0) goto Lb
            goto L8e
        Lb:
            r1 = -1
            int r2 = r9.length()
            r3 = 44
            int r3 = r9.indexOf(r3)
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L37
            int r6 = r2 + (-1)
            if (r3 >= r6) goto L37
            java.lang.String r6 = r9.substring(r4, r3)
            java.lang.String r7 = "W_renamed"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L2c
            r1 = r4
            goto L35
        L2c:
            java.lang.String r4 = "H_renamed"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L35
            r1 = r5
        L35:
            int r4 = r3 + 1
        L37:
            r3 = 58
            int r3 = r9.indexOf(r3)
            if (r3 < 0) goto L75
            int r2 = r2 - r5
            if (r3 >= r2) goto L75
            java.lang.String r2 = r9.substring(r4, r3)
            int r3 = r3 + r5
            java.lang.String r9 = r9.substring(r3)
            int r3 = r2.length()
            if (r3 <= 0) goto L84
            int r3 = r9.length()
            if (r3 <= 0) goto L84
            float r2 = java.lang.Float.parseFloat(r2)     // Catch: java.lang.NumberFormatException -> L84
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L84
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 <= 0) goto L84
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L84
            if (r1 != r5) goto L6f
            float r9 = r9 / r2
            float r9 = java.lang.Math.abs(r9)     // Catch: java.lang.NumberFormatException -> L84
            goto L85
        L6f:
            float r2 = r2 / r9
            float r9 = java.lang.Math.abs(r2)     // Catch: java.lang.NumberFormatException -> L84
            goto L85
        L75:
            java.lang.String r9 = r9.substring(r4)
            int r2 = r9.length()
            if (r2 <= 0) goto L84
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L84
            goto L85
        L84:
            r9 = r0
        L85:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L8d
            r8.G_renamed = r9
            r8.H_renamed = r1
        L8d:
            return
        L8e:
            r8.G_renamed = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a_renamed.a_renamed.f_renamed.b_renamed(java.lang.String):void");
    }

    public void a_renamed(float f_renamed) {
        this.S_renamed = f_renamed;
    }

    public void b_renamed(float f_renamed) {
        this.T_renamed = f_renamed;
    }

    public void l_renamed(int i_renamed) {
        if (i_renamed < 0) {
            this.P_renamed = 0;
        } else {
            this.P_renamed = i_renamed;
        }
    }

    public void m_renamed(int i_renamed) {
        if (i_renamed < 0) {
            this.Q_renamed = 0;
        } else {
            this.Q_renamed = i_renamed;
        }
    }

    public void n_renamed(int i_renamed) {
        this.ao_renamed = i_renamed;
    }

    public void o_renamed(int i_renamed) {
        this.ap_renamed = i_renamed;
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i_renamed;
        int i8 = i4 - i2;
        this.I_renamed = i_renamed;
        this.J_renamed = i2;
        if (this.as_renamed == 8) {
            this.E_renamed = 0;
            this.F_renamed = 0;
            return;
        }
        if (this.C_renamed[0] != androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED || i7 >= (i5 = this.E_renamed)) {
            i5 = i7;
        }
        if (this.C_renamed[1] != androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED || i8 >= (i6 = this.F_renamed)) {
            i6 = i8;
        }
        this.E_renamed = i5;
        this.F_renamed = i6;
        int i9 = this.F_renamed;
        int i10 = this.Q_renamed;
        if (i9 < i10) {
            this.F_renamed = i10;
        }
        int i11 = this.E_renamed;
        int i12 = this.P_renamed;
        if (i11 < i12) {
            this.E_renamed = i12;
        }
        this.X_renamed = true;
    }

    public void a_renamed(int i_renamed, int i2, int i3) {
        if (i3 == 0) {
            c_renamed(i_renamed, i2);
        } else if (i3 == 1) {
            d_renamed(i_renamed, i2);
        }
        this.X_renamed = true;
    }

    public void c_renamed(int i_renamed, int i2) {
        this.I_renamed = i_renamed;
        this.E_renamed = i2 - i_renamed;
        int i3 = this.E_renamed;
        int i4 = this.P_renamed;
        if (i3 < i4) {
            this.E_renamed = i4;
        }
    }

    public void d_renamed(int i_renamed, int i2) {
        this.J_renamed = i_renamed;
        this.F_renamed = i2 - i_renamed;
        int i3 = this.F_renamed;
        int i4 = this.Q_renamed;
        if (i3 < i4) {
            this.F_renamed = i4;
        }
    }

    int p_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return this.K_renamed;
        }
        if (i_renamed == 1) {
            return this.L_renamed;
        }
        return 0;
    }

    void e_renamed(int i_renamed, int i2) {
        if (i2 == 0) {
            this.K_renamed = i_renamed;
        } else if (i2 == 1) {
            this.L_renamed = i_renamed;
        }
    }

    public void q_renamed(int i_renamed) {
        this.O_renamed = i_renamed;
    }

    public void a_renamed(java.lang.Object obj) {
        this.aq_renamed = obj;
    }

    public void c_renamed(float f_renamed) {
        this.ad_renamed[0] = f_renamed;
    }

    public void d_renamed(float f_renamed) {
        this.ad_renamed[1] = f_renamed;
    }

    public void r_renamed(int i_renamed) {
        this.Z_renamed = i_renamed;
    }

    public void s_renamed(int i_renamed) {
        this.aa_renamed = i_renamed;
    }

    public boolean a_renamed() {
        return this.as_renamed != 8;
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed cVar, androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed cVar2, int i_renamed, int i2) {
        a_renamed(cVar).a_renamed(fVar.a_renamed(cVar2), i_renamed, i2, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.b_renamed.STRONG, 0, true);
    }

    public void F_renamed() {
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarL = l_renamed();
        if (fVarL != null && (fVarL instanceof androidx.constraintlayout.a_renamed.a_renamed.g_renamed) && ((androidx.constraintlayout.a_renamed.a_renamed.g_renamed) l_renamed()).S_renamed()) {
            return;
        }
        int size = this.B_renamed.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.B_renamed.get(i_renamed).i_renamed();
        }
    }

    public androidx.constraintlayout.a_renamed.a_renamed.e_renamed a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed cVar) {
        switch (cVar) {
            case LEFT:
                return this.s_renamed;
            case TOP:
                return this.t_renamed;
            case RIGHT:
                return this.u_renamed;
            case BOTTOM:
                return this.v_renamed;
            case BASELINE:
                return this.w_renamed;
            case CENTER:
                return this.z_renamed;
            case CENTER_X:
                return this.x_renamed;
            case CENTER_Y:
                return this.y_renamed;
            case NONE:
                return null;
            default:
                throw new java.lang.AssertionError(cVar.name());
        }
    }

    public androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed G_renamed() {
        return this.C_renamed[0];
    }

    public androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed H_renamed() {
        return this.C_renamed[1];
    }

    public androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed t_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return G_renamed();
        }
        if (i_renamed == 1) {
            return H_renamed();
        }
        return null;
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed aVar) {
        this.C_renamed[0] = aVar;
        if (aVar == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT) {
            j_renamed(this.ao_renamed);
        }
    }

    public void b_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed aVar) {
        this.C_renamed[1] = aVar;
        if (aVar == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT) {
            k_renamed(this.ap_renamed);
        }
    }

    public boolean I_renamed() {
        if (this.s_renamed.f710c == null || this.s_renamed.f710c.f710c != this.s_renamed) {
            return this.u_renamed.f710c != null && this.u_renamed.f710c.f710c == this.u_renamed;
        }
        return true;
    }

    public boolean J_renamed() {
        if (this.t_renamed.f710c == null || this.t_renamed.f710c.f710c != this.t_renamed) {
            return this.v_renamed.f710c != null && this.v_renamed.f710c.f710c == this.v_renamed;
        }
        return true;
    }

    private boolean a_renamed(int i_renamed) {
        int i2 = i_renamed * 2;
        if (this.A_renamed[i2].f710c != null) {
            androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar = this.A_renamed[i2].f710c.f710c;
            androidx.constraintlayout.a_renamed.a_renamed.e_renamed[] eVarArr = this.A_renamed;
            if (eVar != eVarArr[i2]) {
                int i3 = i2 + 1;
                if (eVarArr[i3].f710c != null && this.A_renamed[i3].f710c.f710c == this.A_renamed[i3]) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:106:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:110:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:113:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:116:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:125:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:128:0x025e A_renamed[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:129:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:155:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:156:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:159:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:160:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:163:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:167:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:170:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:172:? A_renamed[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:99:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed(androidx.constraintlayout.a_renamed.e_renamed r39) {
        /*
            Method dump skipped, instructions count: 870
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed(androidx.constraintlayout.a_renamed.e_renamed):void");
    }

    public void a_renamed(boolean z_renamed, boolean z2, boolean z3, boolean z4) {
        if (this.p_renamed == -1) {
            if (z3 && !z4) {
                this.p_renamed = 0;
            } else if (!z3 && z4) {
                this.p_renamed = 1;
                if (this.H_renamed == -1) {
                    this.q_renamed = 1.0f / this.q_renamed;
                }
            }
        }
        if (this.p_renamed == 0 && (!this.t_renamed.j_renamed() || !this.v_renamed.j_renamed())) {
            this.p_renamed = 1;
        } else if (this.p_renamed == 1 && (!this.s_renamed.j_renamed() || !this.u_renamed.j_renamed())) {
            this.p_renamed = 0;
        }
        if (this.p_renamed == -1 && (!this.t_renamed.j_renamed() || !this.v_renamed.j_renamed() || !this.s_renamed.j_renamed() || !this.u_renamed.j_renamed())) {
            if (this.t_renamed.j_renamed() && this.v_renamed.j_renamed()) {
                this.p_renamed = 0;
            } else if (this.s_renamed.j_renamed() && this.u_renamed.j_renamed()) {
                this.q_renamed = 1.0f / this.q_renamed;
                this.p_renamed = 1;
            }
        }
        if (this.p_renamed == -1) {
            if (z_renamed && !z2) {
                this.p_renamed = 0;
            } else if (!z_renamed && z2) {
                this.q_renamed = 1.0f / this.q_renamed;
                this.p_renamed = 1;
            }
        }
        if (this.p_renamed == -1) {
            if (this.h_renamed > 0 && this.k_renamed == 0) {
                this.p_renamed = 0;
            } else if (this.h_renamed == 0 && this.k_renamed > 0) {
                this.q_renamed = 1.0f / this.q_renamed;
                this.p_renamed = 1;
            }
        }
        if (this.p_renamed == -1 && z_renamed && z2) {
            this.q_renamed = 1.0f / this.q_renamed;
            this.p_renamed = 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:105:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:136:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:148:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:165:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:172:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:175:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:176:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:178:0x0303 A_renamed[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:179:0x0305 A_renamed[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:182:0x0310 A_renamed[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:183:0x0312 A_renamed[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:186:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:187:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:190:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:199:? A_renamed[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:98:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(androidx.constraintlayout.a_renamed.e_renamed r26, boolean r27, androidx.constraintlayout.a_renamed.h_renamed r28, androidx.constraintlayout.a_renamed.h_renamed r29, androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed r30, boolean r31, androidx.constraintlayout.a_renamed.a_renamed.e_renamed r32, androidx.constraintlayout.a_renamed.a_renamed.e_renamed r33, int r34, int r35, int r36, int r37, float r38, boolean r39, boolean r40, int r41, int r42, int r43, float r44, boolean r45) {
        /*
            Method dump skipped, instructions count: 836
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed(androidx.constraintlayout.a_renamed.e_renamed, boolean, androidx.constraintlayout.a_renamed.h_renamed, androidx.constraintlayout.a_renamed.h_renamed, androidx.constraintlayout.a_renamed.a_renamed.f_renamed$a_renamed, boolean, androidx.constraintlayout.a_renamed.a_renamed.e_renamed, androidx.constraintlayout.a_renamed.a_renamed.e_renamed, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }

    /* compiled from: ConstraintWidget.java */
    /* renamed from: androidx.constraintlayout.a_renamed.a_renamed.f_renamed$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {

        /* renamed from: b_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f716b = new int[androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.values().length];

        static {
            try {
                f716b[androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f716b[androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f716b[androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_PARENT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f716b[androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            f715a = new int[androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.values().length];
            try {
                f715a[androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.LEFT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                f715a[androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.TOP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                f715a[androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.RIGHT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                f715a[androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BOTTOM.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                f715a[androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BASELINE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                f715a[androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.CENTER.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                f715a[androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.CENTER_X.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                f715a[androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.CENTER_Y.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                f715a[androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.NONE.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
        }
    }

    public void c_renamed(androidx.constraintlayout.a_renamed.e_renamed eVar) {
        int iB = eVar.b_renamed(this.s_renamed);
        int iB2 = eVar.b_renamed(this.t_renamed);
        int iB3 = eVar.b_renamed(this.u_renamed);
        int iB4 = eVar.b_renamed(this.v_renamed);
        int i_renamed = iB4 - iB2;
        if (iB3 - iB < 0 || i_renamed < 0 || iB == Integer.MIN_VALUE || iB == Integer.MAX_VALUE || iB2 == Integer.MIN_VALUE || iB2 == Integer.MAX_VALUE || iB3 == Integer.MIN_VALUE || iB3 == Integer.MAX_VALUE || iB4 == Integer.MIN_VALUE || iB4 == Integer.MAX_VALUE) {
            iB4 = 0;
            iB = 0;
            iB2 = 0;
            iB3 = 0;
        }
        a_renamed(iB, iB2, iB3, iB4);
    }
}
