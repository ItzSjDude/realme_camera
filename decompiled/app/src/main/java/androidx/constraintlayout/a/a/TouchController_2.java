package androidx.constraintlayout.a_renamed.a_renamed;

/* compiled from: ResolutionAnchor.java */
/* loaded from: classes.dex */
public class m_renamed extends androidx.constraintlayout.a_renamed.a_renamed.o_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.constraintlayout.a_renamed.a_renamed.e_renamed f722a;

    /* renamed from: b_renamed, reason: collision with root package name */
    float f723b;

    /* renamed from: c_renamed, reason: collision with root package name */
    androidx.constraintlayout.a_renamed.a_renamed.m_renamed f724c;
    float d_renamed;
    androidx.constraintlayout.a_renamed.a_renamed.m_renamed e_renamed;
    float f_renamed;
    private androidx.constraintlayout.a_renamed.a_renamed.m_renamed j_renamed;
    private float k_renamed;
    int g_renamed = 0;
    private androidx.constraintlayout.a_renamed.a_renamed.n_renamed l_renamed = null;
    private int m_renamed = 1;
    private androidx.constraintlayout.a_renamed.a_renamed.n_renamed n_renamed = null;
    private int o_renamed = 1;

    java.lang.String a_renamed(int i_renamed) {
        return i_renamed == 1 ? "DIRECT" : i_renamed == 2 ? "CENTER" : i_renamed == 3 ? "MATCH" : i_renamed == 4 ? "CHAIN" : i_renamed == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public m_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar) {
        this.f722a = eVar;
    }

    public java.lang.String toString() {
        if (this.i_renamed == 1) {
            if (this.e_renamed == this) {
                return "[" + this.f722a + ", RESOLVED: " + this.f_renamed + "]  type: " + a_renamed(this.g_renamed);
            }
            return "[" + this.f722a + ", RESOLVED: " + this.e_renamed + ":" + this.f_renamed + "] type: " + a_renamed(this.g_renamed);
        }
        return "{ " + this.f722a + " UNRESOLVED} type: " + a_renamed(this.g_renamed);
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar, float f_renamed) {
        if (this.i_renamed == 0 || !(this.e_renamed == mVar || this.f_renamed == f_renamed)) {
            this.e_renamed = mVar;
            this.f_renamed = f_renamed;
            if (this.i_renamed == 1) {
                e_renamed();
            }
            f_renamed();
        }
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.o_renamed
    public void a_renamed() {
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar;
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar2;
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar3;
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar4;
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar5;
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar6;
        float f_renamed;
        float f2;
        float fQ_renamed;
        float f3;
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar7;
        boolean z_renamed = true;
        if (this.i_renamed == 1 || this.g_renamed == 4) {
            return;
        }
        androidx.constraintlayout.a_renamed.a_renamed.n_renamed nVar = this.l_renamed;
        if (nVar != null) {
            if (nVar.i_renamed != 1) {
                return;
            } else {
                this.d_renamed = this.m_renamed * this.l_renamed.f725a;
            }
        }
        androidx.constraintlayout.a_renamed.a_renamed.n_renamed nVar2 = this.n_renamed;
        if (nVar2 != null) {
            if (nVar2.i_renamed != 1) {
                return;
            } else {
                this.k_renamed = this.o_renamed * this.n_renamed.f725a;
            }
        }
        if (this.g_renamed == 1 && ((mVar7 = this.f724c) == null || mVar7.i_renamed == 1)) {
            androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar8 = this.f724c;
            if (mVar8 == null) {
                this.e_renamed = this;
                this.f_renamed = this.d_renamed;
            } else {
                this.e_renamed = mVar8.e_renamed;
                this.f_renamed = mVar8.f_renamed + this.d_renamed;
            }
            f_renamed();
            return;
        }
        if (this.g_renamed == 2 && (mVar4 = this.f724c) != null && mVar4.i_renamed == 1 && (mVar5 = this.j_renamed) != null && (mVar6 = mVar5.f724c) != null && mVar6.i_renamed == 1) {
            if (androidx.constraintlayout.a_renamed.e_renamed.a_renamed() != null) {
                androidx.constraintlayout.a_renamed.e_renamed.a_renamed().w_renamed++;
            }
            this.e_renamed = this.f724c.e_renamed;
            androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar9 = this.j_renamed;
            mVar9.e_renamed = mVar9.f724c.e_renamed;
            int i_renamed = 0;
            if (this.f722a.f709b != androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.RIGHT && this.f722a.f709b != androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BOTTOM) {
                z_renamed = false;
            }
            if (z_renamed) {
                f_renamed = this.f724c.f_renamed;
                f2 = this.j_renamed.f724c.f_renamed;
            } else {
                f_renamed = this.j_renamed.f724c.f_renamed;
                f2 = this.f724c.f_renamed;
            }
            float f4 = f_renamed - f2;
            if (this.f722a.f709b == androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.LEFT || this.f722a.f709b == androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.RIGHT) {
                fQ_renamed = f4 - this.f722a.f708a.q_renamed();
                f3 = this.f722a.f708a.S_renamed;
            } else {
                fQ_renamed = f4 - this.f722a.f708a.s_renamed();
                f3 = this.f722a.f708a.T_renamed;
            }
            int iE = this.f722a.e_renamed();
            int iE2 = this.j_renamed.f722a.e_renamed();
            if (this.f722a.g_renamed() == this.j_renamed.f722a.g_renamed()) {
                f3 = 0.5f;
                iE2 = 0;
            } else {
                i_renamed = iE;
            }
            float f5 = i_renamed;
            float f6 = iE2;
            float f7 = (fQ_renamed - f5) - f6;
            if (z_renamed) {
                androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar10 = this.j_renamed;
                mVar10.f_renamed = mVar10.f724c.f_renamed + f6 + (f7 * f3);
                this.f_renamed = (this.f724c.f_renamed - f5) - (f7 * (1.0f - f3));
            } else {
                this.f_renamed = this.f724c.f_renamed + f5 + (f7 * f3);
                androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar11 = this.j_renamed;
                mVar11.f_renamed = (mVar11.f724c.f_renamed - f6) - (f7 * (1.0f - f3));
            }
            f_renamed();
            this.j_renamed.f_renamed();
            return;
        }
        if (this.g_renamed == 3 && (mVar = this.f724c) != null && mVar.i_renamed == 1 && (mVar2 = this.j_renamed) != null && (mVar3 = mVar2.f724c) != null && mVar3.i_renamed == 1) {
            if (androidx.constraintlayout.a_renamed.e_renamed.a_renamed() != null) {
                androidx.constraintlayout.a_renamed.e_renamed.a_renamed().x_renamed++;
            }
            androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar12 = this.f724c;
            this.e_renamed = mVar12.e_renamed;
            androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar13 = this.j_renamed;
            androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar14 = mVar13.f724c;
            mVar13.e_renamed = mVar14.e_renamed;
            this.f_renamed = mVar12.f_renamed + this.d_renamed;
            mVar13.f_renamed = mVar14.f_renamed + mVar13.d_renamed;
            f_renamed();
            this.j_renamed.f_renamed();
            return;
        }
        if (this.g_renamed == 5) {
            this.f722a.f708a.d_renamed();
        }
    }

    public void b_renamed(int i_renamed) {
        this.g_renamed = i_renamed;
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.o_renamed
    public void b_renamed() {
        super.b_renamed();
        this.f724c = null;
        this.d_renamed = 0.0f;
        this.l_renamed = null;
        this.m_renamed = 1;
        this.n_renamed = null;
        this.o_renamed = 1;
        this.e_renamed = null;
        this.f_renamed = 0.0f;
        this.f723b = 0.0f;
        this.j_renamed = null;
        this.k_renamed = 0.0f;
        this.g_renamed = 0;
    }

    public void c_renamed() {
        androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVarG = this.f722a.g_renamed();
        if (eVarG == null) {
            return;
        }
        if (eVarG.g_renamed() == this.f722a) {
            this.g_renamed = 4;
            eVarG.a_renamed().g_renamed = 4;
        }
        int iE = this.f722a.e_renamed();
        if (this.f722a.f709b == androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.RIGHT || this.f722a.f709b == androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BOTTOM) {
            iE = -iE;
        }
        a_renamed(eVarG.a_renamed(), iE);
    }

    public void a_renamed(int i_renamed, androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar, int i2) {
        this.g_renamed = i_renamed;
        this.f724c = mVar;
        this.d_renamed = i2;
        this.f724c.a_renamed(this);
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar, int i_renamed) {
        this.f724c = mVar;
        this.d_renamed = i_renamed;
        this.f724c.a_renamed(this);
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar, int i_renamed, androidx.constraintlayout.a_renamed.a_renamed.n_renamed nVar) {
        this.f724c = mVar;
        this.f724c.a_renamed(this);
        this.l_renamed = nVar;
        this.m_renamed = i_renamed;
        this.l_renamed.a_renamed(this);
    }

    public void b_renamed(androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar, float f_renamed) {
        this.j_renamed = mVar;
        this.k_renamed = f_renamed;
    }

    public void b_renamed(androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar, int i_renamed, androidx.constraintlayout.a_renamed.a_renamed.n_renamed nVar) {
        this.j_renamed = mVar;
        this.n_renamed = nVar;
        this.o_renamed = i_renamed;
    }

    void a_renamed(androidx.constraintlayout.a_renamed.e_renamed eVar) {
        androidx.constraintlayout.a_renamed.h_renamed hVarB = this.f722a.b_renamed();
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar = this.e_renamed;
        if (mVar == null) {
            eVar.a_renamed(hVarB, (int) (this.f_renamed + 0.5f));
        } else {
            eVar.c_renamed(hVarB, eVar.a_renamed(mVar.f722a), (int) (this.f_renamed + 0.5f), 6);
        }
    }

    public float d_renamed() {
        return this.f_renamed;
    }
}
