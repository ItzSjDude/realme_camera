package androidx.constraintlayout.a_renamed.a_renamed;

/* compiled from: ConstraintWidgetContainer.java */
/* loaded from: classes.dex */
public class g_renamed extends androidx.constraintlayout.a_renamed.a_renamed.q_renamed {
    private androidx.constraintlayout.a_renamed.a_renamed.p_renamed aB_renamed;
    int aj_renamed;
    int ak_renamed;
    int al_renamed;
    int am_renamed;
    private boolean aA_renamed = false;
    protected androidx.constraintlayout.a_renamed.e_renamed ai_renamed = new androidx.constraintlayout.a_renamed.e_renamed();
    int an_renamed = 0;
    int ao_renamed = 0;
    androidx.constraintlayout.a_renamed.a_renamed.d_renamed[] ap_renamed = new androidx.constraintlayout.a_renamed.a_renamed.d_renamed[4];
    androidx.constraintlayout.a_renamed.a_renamed.d_renamed[] aq_renamed = new androidx.constraintlayout.a_renamed.a_renamed.d_renamed[4];
    public java.util.List<androidx.constraintlayout.a_renamed.a_renamed.h_renamed> ar_renamed = new java.util.ArrayList();
    public boolean as_renamed = false;
    public boolean at_renamed = false;
    public boolean au_renamed = false;
    public int av_renamed = 0;
    public int aw_renamed = 0;
    private int aC_renamed = 7;
    public boolean ax_renamed = false;
    private boolean aD_renamed = false;
    private boolean aE_renamed = false;
    int ay_renamed = 0;

    public boolean S_renamed() {
        return false;
    }

    public void a_renamed(int i_renamed) {
        this.aC_renamed = i_renamed;
    }

    public int b_renamed() {
        return this.aC_renamed;
    }

    public boolean u_renamed(int i_renamed) {
        return (this.aC_renamed & i_renamed) == i_renamed;
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.q_renamed, androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public void g_renamed() {
        this.ai_renamed.b_renamed();
        this.aj_renamed = 0;
        this.al_renamed = 0;
        this.ak_renamed = 0;
        this.am_renamed = 0;
        this.ar_renamed.clear();
        this.ax_renamed = false;
        super.g_renamed();
    }

    public boolean K_renamed() {
        return this.aD_renamed;
    }

    public boolean L_renamed() {
        return this.aE_renamed;
    }

    public boolean d_renamed(androidx.constraintlayout.a_renamed.e_renamed eVar) {
        a_renamed(eVar);
        int size = this.az_renamed.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar = this.az_renamed.get(i_renamed);
            if (fVar instanceof androidx.constraintlayout.a_renamed.a_renamed.g_renamed) {
                androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed aVar = fVar.C_renamed[0];
                androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed aVar2 = fVar.C_renamed[1];
                if (aVar == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT) {
                    fVar.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED);
                }
                if (aVar2 == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT) {
                    fVar.b_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED);
                }
                fVar.a_renamed(eVar);
                if (aVar == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT) {
                    fVar.a_renamed(aVar);
                }
                if (aVar2 == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT) {
                    fVar.b_renamed(aVar2);
                }
            } else {
                androidx.constraintlayout.a_renamed.a_renamed.k_renamed.a_renamed(this, eVar, fVar);
                fVar.a_renamed(eVar);
            }
        }
        if (this.an_renamed > 0) {
            androidx.constraintlayout.a_renamed.a_renamed.c_renamed.a_renamed(this, eVar, 0);
        }
        if (this.ao_renamed > 0) {
            androidx.constraintlayout.a_renamed.a_renamed.c_renamed.a_renamed(this, eVar, 1);
        }
        return true;
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.e_renamed eVar, boolean[] zArr) {
        zArr[2] = false;
        c_renamed(eVar);
        int size = this.az_renamed.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar = this.az_renamed.get(i_renamed);
            fVar.c_renamed(eVar);
            if (fVar.C_renamed[0] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT && fVar.q_renamed() < fVar.r_renamed()) {
                zArr[2] = true;
            }
            if (fVar.C_renamed[1] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT && fVar.s_renamed() < fVar.t_renamed()) {
                zArr[2] = true;
            }
        }
    }

    public void a_renamed(boolean z_renamed) {
        this.aA_renamed = z_renamed;
    }

    public boolean M_renamed() {
        return this.aA_renamed;
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public void b_renamed(int i_renamed) {
        super.b_renamed(i_renamed);
        int size = this.az_renamed.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.az_renamed.get(i2).b_renamed(i_renamed);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:107:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:110:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:113:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:114:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:116:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:128:0x02d3 A_renamed[PHI: r0 r9
      0x02d3: PHI (r0v36 boolean) = (r0v35 boolean), (r0v38 boolean), (r0v38 boolean), (r0v38 boolean) binds: [B_renamed:115:0x0294, B_renamed:123:0x02bb, B_renamed:124:0x02bd, B_renamed:126:0x02c3] A_renamed[DONT_GENERATE, DONT_INLINE]
      0x02d3: PHI (r9v15 boolean) = (r9v14 boolean), (r9v17 boolean), (r9v17 boolean), (r9v17 boolean) binds: [B_renamed:115:0x0294, B_renamed:123:0x02bb, B_renamed:124:0x02bd, B_renamed:126:0x02c3] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:72:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:74:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:88:0x01dd  */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v22 */
    @Override // androidx.constraintlayout.a_renamed.a_renamed.q_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void N_renamed() {
        /*
            Method dump skipped, instructions count: 846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a_renamed.a_renamed.g_renamed.N_renamed():void");
    }

    public void O_renamed() {
        Q_renamed();
        b_renamed(this.aC_renamed);
    }

    public void P_renamed() {
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVarA = a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.LEFT).a_renamed();
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVarA2 = a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.TOP).a_renamed();
        mVarA.a_renamed((androidx.constraintlayout.a_renamed.a_renamed.m_renamed) null, 0.0f);
        mVarA2.a_renamed((androidx.constraintlayout.a_renamed.a_renamed.m_renamed) null, 0.0f);
    }

    public void f_renamed(int i_renamed, int i2) {
        if (this.C_renamed[0] != androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT && this.f714c != null) {
            this.f714c.a_renamed(i_renamed);
        }
        if (this.C_renamed[1] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT || this.d_renamed == null) {
            return;
        }
        this.d_renamed.a_renamed(i2);
    }

    public void Q_renamed() {
        int size = this.az_renamed.size();
        c_renamed();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.az_renamed.get(i_renamed).c_renamed();
        }
    }

    public void R_renamed() {
        if (!u_renamed(8)) {
            b_renamed(this.aC_renamed);
        }
        P_renamed();
    }

    private void V_renamed() {
        this.an_renamed = 0;
        this.ao_renamed = 0;
    }

    void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, int i_renamed) {
        if (i_renamed == 0) {
            d_renamed(fVar);
        } else if (i_renamed == 1) {
            e_renamed(fVar);
        }
    }

    private void d_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
        int i_renamed = this.an_renamed + 1;
        androidx.constraintlayout.a_renamed.a_renamed.d_renamed[] dVarArr = this.aq_renamed;
        if (i_renamed >= dVarArr.length) {
            this.aq_renamed = (androidx.constraintlayout.a_renamed.a_renamed.d_renamed[]) java.util.Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.aq_renamed[this.an_renamed] = new androidx.constraintlayout.a_renamed.a_renamed.d_renamed(fVar, 0, M_renamed());
        this.an_renamed++;
    }

    private void e_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
        int i_renamed = this.ao_renamed + 1;
        androidx.constraintlayout.a_renamed.a_renamed.d_renamed[] dVarArr = this.ap_renamed;
        if (i_renamed >= dVarArr.length) {
            this.ap_renamed = (androidx.constraintlayout.a_renamed.a_renamed.d_renamed[]) java.util.Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.ap_renamed[this.ao_renamed] = new androidx.constraintlayout.a_renamed.a_renamed.d_renamed(fVar, 1, M_renamed());
        this.ao_renamed++;
    }
}
