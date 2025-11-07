package androidx.constraintlayout.a_renamed.a_renamed;

/* compiled from: Guideline.java */
/* loaded from: classes.dex */
public class i_renamed extends androidx.constraintlayout.a_renamed.a_renamed.f_renamed {
    protected float ai_renamed = -1.0f;
    protected int aj_renamed = -1;
    protected int ak_renamed = -1;
    private androidx.constraintlayout.a_renamed.a_renamed.e_renamed al_renamed = this.t_renamed;
    private int am_renamed = 0;
    private boolean an_renamed = false;
    private int ao_renamed = 0;
    private androidx.constraintlayout.a_renamed.a_renamed.l_renamed ap_renamed = new androidx.constraintlayout.a_renamed.a_renamed.l_renamed();
    private int aq_renamed = 8;

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public boolean a_renamed() {
        return true;
    }

    public i_renamed() {
        this.B_renamed.clear();
        this.B_renamed.add(this.al_renamed);
        int length = this.A_renamed.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            this.A_renamed[i_renamed] = this.al_renamed;
        }
    }

    public void a_renamed(int i_renamed) {
        if (this.am_renamed == i_renamed) {
            return;
        }
        this.am_renamed = i_renamed;
        this.B_renamed.clear();
        if (this.am_renamed == 1) {
            this.al_renamed = this.s_renamed;
        } else {
            this.al_renamed = this.t_renamed;
        }
        this.B_renamed.add(this.al_renamed);
        int length = this.A_renamed.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.A_renamed[i2] = this.al_renamed;
        }
    }

    public int b_renamed() {
        return this.am_renamed;
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public androidx.constraintlayout.a_renamed.a_renamed.e_renamed a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed cVar) {
        switch (cVar) {
            case LEFT:
            case RIGHT:
                if (this.am_renamed == 1) {
                    return this.al_renamed;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.am_renamed == 0) {
                    return this.al_renamed;
                }
                break;
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
        }
        throw new java.lang.AssertionError(cVar.name());
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public java.util.ArrayList<androidx.constraintlayout.a_renamed.a_renamed.e_renamed> D_renamed() {
        return this.B_renamed;
    }

    public void e_renamed(float f_renamed) {
        if (f_renamed > -1.0f) {
            this.ai_renamed = f_renamed;
            this.aj_renamed = -1;
            this.ak_renamed = -1;
        }
    }

    public void u_renamed(int i_renamed) {
        if (i_renamed > -1) {
            this.ai_renamed = -1.0f;
            this.aj_renamed = i_renamed;
            this.ak_renamed = -1;
        }
    }

    public void v_renamed(int i_renamed) {
        if (i_renamed > -1) {
            this.ai_renamed = -1.0f;
            this.aj_renamed = -1;
            this.ak_renamed = i_renamed;
        }
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public void b_renamed(int i_renamed) {
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarL = l_renamed();
        if (fVarL == null) {
            return;
        }
        if (b_renamed() == 1) {
            this.t_renamed.a_renamed().a_renamed(1, fVarL.t_renamed.a_renamed(), 0);
            this.v_renamed.a_renamed().a_renamed(1, fVarL.t_renamed.a_renamed(), 0);
            if (this.aj_renamed != -1) {
                this.s_renamed.a_renamed().a_renamed(1, fVarL.s_renamed.a_renamed(), this.aj_renamed);
                this.u_renamed.a_renamed().a_renamed(1, fVarL.s_renamed.a_renamed(), this.aj_renamed);
                return;
            } else if (this.ak_renamed != -1) {
                this.s_renamed.a_renamed().a_renamed(1, fVarL.u_renamed.a_renamed(), -this.ak_renamed);
                this.u_renamed.a_renamed().a_renamed(1, fVarL.u_renamed.a_renamed(), -this.ak_renamed);
                return;
            } else {
                if (this.ai_renamed == -1.0f || fVarL.G_renamed() != androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED) {
                    return;
                }
                int i2 = (int) (fVarL.E_renamed * this.ai_renamed);
                this.s_renamed.a_renamed().a_renamed(1, fVarL.s_renamed.a_renamed(), i2);
                this.u_renamed.a_renamed().a_renamed(1, fVarL.s_renamed.a_renamed(), i2);
                return;
            }
        }
        this.s_renamed.a_renamed().a_renamed(1, fVarL.s_renamed.a_renamed(), 0);
        this.u_renamed.a_renamed().a_renamed(1, fVarL.s_renamed.a_renamed(), 0);
        if (this.aj_renamed != -1) {
            this.t_renamed.a_renamed().a_renamed(1, fVarL.t_renamed.a_renamed(), this.aj_renamed);
            this.v_renamed.a_renamed().a_renamed(1, fVarL.t_renamed.a_renamed(), this.aj_renamed);
        } else if (this.ak_renamed != -1) {
            this.t_renamed.a_renamed().a_renamed(1, fVarL.v_renamed.a_renamed(), -this.ak_renamed);
            this.v_renamed.a_renamed().a_renamed(1, fVarL.v_renamed.a_renamed(), -this.ak_renamed);
        } else {
            if (this.ai_renamed == -1.0f || fVarL.H_renamed() != androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED) {
                return;
            }
            int i3 = (int) (fVarL.F_renamed * this.ai_renamed);
            this.t_renamed.a_renamed().a_renamed(1, fVarL.t_renamed.a_renamed(), i3);
            this.v_renamed.a_renamed().a_renamed(1, fVarL.t_renamed.a_renamed(), i3);
        }
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public void a_renamed(androidx.constraintlayout.a_renamed.e_renamed eVar) {
        androidx.constraintlayout.a_renamed.a_renamed.g_renamed gVar = (androidx.constraintlayout.a_renamed.a_renamed.g_renamed) l_renamed();
        if (gVar == null) {
            return;
        }
        androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVarA = gVar.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.LEFT);
        androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVarA2 = gVar.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.RIGHT);
        boolean z_renamed = this.D_renamed != null && this.D_renamed.C_renamed[0] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT;
        if (this.am_renamed == 0) {
            eVarA = gVar.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.TOP);
            eVarA2 = gVar.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BOTTOM);
            z_renamed = this.D_renamed != null && this.D_renamed.C_renamed[1] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT;
        }
        if (this.aj_renamed != -1) {
            androidx.constraintlayout.a_renamed.h_renamed hVarA = eVar.a_renamed(this.al_renamed);
            eVar.c_renamed(hVarA, eVar.a_renamed(eVarA), this.aj_renamed, 6);
            if (z_renamed) {
                eVar.a_renamed(eVar.a_renamed(eVarA2), hVarA, 0, 5);
                return;
            }
            return;
        }
        if (this.ak_renamed == -1) {
            if (this.ai_renamed != -1.0f) {
                eVar.a_renamed(androidx.constraintlayout.a_renamed.e_renamed.a_renamed(eVar, eVar.a_renamed(this.al_renamed), eVar.a_renamed(eVarA), eVar.a_renamed(eVarA2), this.ai_renamed, this.an_renamed));
                return;
            }
            return;
        }
        androidx.constraintlayout.a_renamed.h_renamed hVarA2 = eVar.a_renamed(this.al_renamed);
        androidx.constraintlayout.a_renamed.h_renamed hVarA3 = eVar.a_renamed(eVarA2);
        eVar.c_renamed(hVarA2, hVarA3, -this.ak_renamed, 6);
        if (z_renamed) {
            eVar.a_renamed(hVarA2, eVar.a_renamed(eVarA), 0, 5);
            eVar.a_renamed(hVarA3, hVarA2, 0, 5);
        }
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public void c_renamed(androidx.constraintlayout.a_renamed.e_renamed eVar) {
        if (l_renamed() == null) {
            return;
        }
        int iB = eVar.b_renamed(this.al_renamed);
        if (this.am_renamed == 1) {
            h_renamed(iB);
            i_renamed(0);
            k_renamed(l_renamed().s_renamed());
            j_renamed(0);
            return;
        }
        h_renamed(0);
        i_renamed(iB);
        j_renamed(l_renamed().q_renamed());
        k_renamed(0);
    }
}
