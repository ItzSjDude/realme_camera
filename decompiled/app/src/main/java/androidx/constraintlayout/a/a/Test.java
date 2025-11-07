package androidx.constraintlayout.a_renamed.a_renamed;

/* compiled from: ChainHead.java */
/* loaded from: classes.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected androidx.constraintlayout.a_renamed.a_renamed.f_renamed f705a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected androidx.constraintlayout.a_renamed.a_renamed.f_renamed f706b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected androidx.constraintlayout.a_renamed.a_renamed.f_renamed f707c;
    protected androidx.constraintlayout.a_renamed.a_renamed.f_renamed d_renamed;
    protected androidx.constraintlayout.a_renamed.a_renamed.f_renamed e_renamed;
    protected androidx.constraintlayout.a_renamed.a_renamed.f_renamed f_renamed;
    protected androidx.constraintlayout.a_renamed.a_renamed.f_renamed g_renamed;
    protected java.util.ArrayList<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> h_renamed;
    protected int i_renamed;
    protected int j_renamed;
    protected float k_renamed = 0.0f;
    protected boolean l_renamed;
    protected boolean m_renamed;
    protected boolean n_renamed;
    private int o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;

    public d_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, int i_renamed, boolean z_renamed) {
        this.p_renamed = false;
        this.f705a = fVar;
        this.o_renamed = i_renamed;
        this.p_renamed = z_renamed;
    }

    private static boolean a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, int i_renamed) {
        return fVar.m_renamed() != 8 && fVar.C_renamed[i_renamed] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT && (fVar.g_renamed[i_renamed] == 0 || fVar.g_renamed[i_renamed] == 3);
    }

    private void b_renamed() {
        int i_renamed = this.o_renamed * 2;
        boolean z_renamed = false;
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar = this.f705a;
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar2 = fVar;
        boolean z2 = false;
        while (!z2) {
            this.i_renamed++;
            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar3 = null;
            fVar.af_renamed[this.o_renamed] = null;
            fVar.ae_renamed[this.o_renamed] = null;
            if (fVar.m_renamed() != 8) {
                if (this.f706b == null) {
                    this.f706b = fVar;
                }
                this.d_renamed = fVar;
                if (fVar.C_renamed[this.o_renamed] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT && (fVar.g_renamed[this.o_renamed] == 0 || fVar.g_renamed[this.o_renamed] == 3 || fVar.g_renamed[this.o_renamed] == 2)) {
                    this.j_renamed++;
                    float f_renamed = fVar.ad_renamed[this.o_renamed];
                    if (f_renamed > 0.0f) {
                        this.k_renamed += fVar.ad_renamed[this.o_renamed];
                    }
                    if (a_renamed(fVar, this.o_renamed)) {
                        if (f_renamed < 0.0f) {
                            this.l_renamed = true;
                        } else {
                            this.m_renamed = true;
                        }
                        if (this.h_renamed == null) {
                            this.h_renamed = new java.util.ArrayList<>();
                        }
                        this.h_renamed.add(fVar);
                    }
                    if (this.f_renamed == null) {
                        this.f_renamed = fVar;
                    }
                    androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar4 = this.g_renamed;
                    if (fVar4 != null) {
                        fVar4.ae_renamed[this.o_renamed] = fVar;
                    }
                    this.g_renamed = fVar;
                }
            }
            if (fVar2 != fVar) {
                fVar2.af_renamed[this.o_renamed] = fVar;
            }
            androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar = fVar.A_renamed[i_renamed + 1].f710c;
            if (eVar != null) {
                androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar5 = eVar.f708a;
                if (fVar5.A_renamed[i_renamed].f710c != null && fVar5.A_renamed[i_renamed].f710c.f708a == fVar) {
                    fVar3 = fVar5;
                }
            }
            if (fVar3 == null) {
                fVar3 = fVar;
                z2 = true;
            }
            fVar2 = fVar;
            fVar = fVar3;
        }
        this.f707c = fVar;
        if (this.o_renamed == 0 && this.p_renamed) {
            this.e_renamed = this.f707c;
        } else {
            this.e_renamed = this.f705a;
        }
        if (this.m_renamed && this.l_renamed) {
            z_renamed = true;
        }
        this.n_renamed = z_renamed;
    }

    public void a_renamed() {
        if (!this.q_renamed) {
            b_renamed();
        }
        this.q_renamed = true;
    }
}
