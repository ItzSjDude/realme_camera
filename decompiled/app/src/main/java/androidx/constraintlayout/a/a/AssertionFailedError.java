package androidx.constraintlayout.a_renamed.a_renamed;

/* compiled from: Barrier.java */
/* loaded from: classes.dex */
public class b_renamed extends androidx.constraintlayout.a_renamed.a_renamed.j_renamed {
    private int ak_renamed = 0;
    private java.util.ArrayList<androidx.constraintlayout.a_renamed.a_renamed.m_renamed> al_renamed = new java.util.ArrayList<>(4);
    private boolean am_renamed = true;

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public boolean a_renamed() {
        return true;
    }

    public void a_renamed(int i_renamed) {
        this.ak_renamed = i_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.am_renamed = z_renamed;
    }

    public boolean b_renamed() {
        return this.am_renamed;
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public void c_renamed() {
        super.c_renamed();
        this.al_renamed.clear();
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public void b_renamed(int i_renamed) {
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVarA;
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVarA2;
        if (this.D_renamed != null && ((androidx.constraintlayout.a_renamed.a_renamed.g_renamed) this.D_renamed).u_renamed(2)) {
            int i2 = this.ak_renamed;
            if (i2 == 0) {
                mVarA = this.s_renamed.a_renamed();
            } else if (i2 == 1) {
                mVarA = this.u_renamed.a_renamed();
            } else if (i2 == 2) {
                mVarA = this.t_renamed.a_renamed();
            } else if (i2 != 3) {
                return;
            } else {
                mVarA = this.v_renamed.a_renamed();
            }
            mVarA.b_renamed(5);
            int i3 = this.ak_renamed;
            if (i3 == 0 || i3 == 1) {
                this.t_renamed.a_renamed().a_renamed((androidx.constraintlayout.a_renamed.a_renamed.m_renamed) null, 0.0f);
                this.v_renamed.a_renamed().a_renamed((androidx.constraintlayout.a_renamed.a_renamed.m_renamed) null, 0.0f);
            } else {
                this.s_renamed.a_renamed().a_renamed((androidx.constraintlayout.a_renamed.a_renamed.m_renamed) null, 0.0f);
                this.u_renamed.a_renamed().a_renamed((androidx.constraintlayout.a_renamed.a_renamed.m_renamed) null, 0.0f);
            }
            this.al_renamed.clear();
            for (int i4 = 0; i4 < this.aj_renamed; i4++) {
                androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar = this.ai_renamed[i4];
                if (this.am_renamed || fVar.a_renamed()) {
                    int i5 = this.ak_renamed;
                    if (i5 == 0) {
                        mVarA2 = fVar.s_renamed.a_renamed();
                    } else if (i5 == 1) {
                        mVarA2 = fVar.u_renamed.a_renamed();
                    } else if (i5 == 2) {
                        mVarA2 = fVar.t_renamed.a_renamed();
                    } else {
                        mVarA2 = i5 != 3 ? null : fVar.v_renamed.a_renamed();
                    }
                    if (mVarA2 != null) {
                        this.al_renamed.add(mVarA2);
                        mVarA2.a_renamed(mVarA);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public void d_renamed() {
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVarA;
        int i_renamed = this.ak_renamed;
        float f_renamed = Float.MAX_VALUE;
        if (i_renamed != 0) {
            if (i_renamed == 1) {
                mVarA = this.u_renamed.a_renamed();
            } else if (i_renamed == 2) {
                mVarA = this.t_renamed.a_renamed();
            } else if (i_renamed != 3) {
                return;
            } else {
                mVarA = this.v_renamed.a_renamed();
            }
            f_renamed = 0.0f;
        } else {
            mVarA = this.s_renamed.a_renamed();
        }
        int size = this.al_renamed.size();
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar2 = this.al_renamed.get(i2);
            if (mVar2.i_renamed != 1) {
                return;
            }
            int i3 = this.ak_renamed;
            if (i3 == 0 || i3 == 2) {
                if (mVar2.f_renamed < f_renamed) {
                    f_renamed = mVar2.f_renamed;
                    mVar = mVar2.e_renamed;
                }
            } else if (mVar2.f_renamed > f_renamed) {
                f_renamed = mVar2.f_renamed;
                mVar = mVar2.e_renamed;
            }
        }
        if (androidx.constraintlayout.a_renamed.e_renamed.a_renamed() != null) {
            androidx.constraintlayout.a_renamed.e_renamed.a_renamed().z_renamed++;
        }
        mVarA.e_renamed = mVar;
        mVarA.f_renamed = f_renamed;
        mVarA.f_renamed();
        int i4 = this.ak_renamed;
        if (i4 == 0) {
            this.u_renamed.a_renamed().a_renamed(mVar, f_renamed);
            return;
        }
        if (i4 == 1) {
            this.s_renamed.a_renamed().a_renamed(mVar, f_renamed);
        } else if (i4 == 2) {
            this.v_renamed.a_renamed().a_renamed(mVar, f_renamed);
        } else {
            if (i4 != 3) {
                return;
            }
            this.t_renamed.a_renamed().a_renamed(mVar, f_renamed);
        }
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public void a_renamed(androidx.constraintlayout.a_renamed.e_renamed eVar) {
        boolean z_renamed;
        int i_renamed;
        int i2;
        this.A_renamed[0] = this.s_renamed;
        this.A_renamed[2] = this.t_renamed;
        this.A_renamed[1] = this.u_renamed;
        this.A_renamed[3] = this.v_renamed;
        for (int i3 = 0; i3 < this.A_renamed.length; i3++) {
            this.A_renamed[i3].f_renamed = eVar.a_renamed(this.A_renamed[i3]);
        }
        int i4 = this.ak_renamed;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar2 = this.A_renamed[this.ak_renamed];
        for (int i5 = 0; i5 < this.aj_renamed; i5++) {
            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar = this.ai_renamed[i5];
            if ((this.am_renamed || fVar.a_renamed()) && ((((i_renamed = this.ak_renamed) == 0 || i_renamed == 1) && fVar.G_renamed() == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT) || (((i2 = this.ak_renamed) == 2 || i2 == 3) && fVar.H_renamed() == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT))) {
                z_renamed = true;
                break;
            }
        }
        z_renamed = false;
        int i6 = this.ak_renamed;
        if (i6 == 0 || i6 == 1 ? l_renamed().G_renamed() == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT : l_renamed().H_renamed() == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT) {
            z_renamed = false;
        }
        for (int i7 = 0; i7 < this.aj_renamed; i7++) {
            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar2 = this.ai_renamed[i7];
            if (this.am_renamed || fVar2.a_renamed()) {
                androidx.constraintlayout.a_renamed.h_renamed hVarA = eVar.a_renamed(fVar2.A_renamed[this.ak_renamed]);
                androidx.constraintlayout.a_renamed.a_renamed.e_renamed[] eVarArr = fVar2.A_renamed;
                int i8 = this.ak_renamed;
                eVarArr[i8].f_renamed = hVarA;
                if (i8 == 0 || i8 == 2) {
                    eVar.b_renamed(eVar2.f_renamed, hVarA, z_renamed);
                } else {
                    eVar.a_renamed(eVar2.f_renamed, hVarA, z_renamed);
                }
            }
        }
        int i9 = this.ak_renamed;
        if (i9 == 0) {
            eVar.c_renamed(this.u_renamed.f_renamed, this.s_renamed.f_renamed, 0, 6);
            if (z_renamed) {
                return;
            }
            eVar.c_renamed(this.s_renamed.f_renamed, this.D_renamed.u_renamed.f_renamed, 0, 5);
            return;
        }
        if (i9 == 1) {
            eVar.c_renamed(this.s_renamed.f_renamed, this.u_renamed.f_renamed, 0, 6);
            if (z_renamed) {
                return;
            }
            eVar.c_renamed(this.s_renamed.f_renamed, this.D_renamed.s_renamed.f_renamed, 0, 5);
            return;
        }
        if (i9 == 2) {
            eVar.c_renamed(this.v_renamed.f_renamed, this.t_renamed.f_renamed, 0, 6);
            if (z_renamed) {
                return;
            }
            eVar.c_renamed(this.t_renamed.f_renamed, this.D_renamed.v_renamed.f_renamed, 0, 5);
            return;
        }
        if (i9 == 3) {
            eVar.c_renamed(this.t_renamed.f_renamed, this.v_renamed.f_renamed, 0, 6);
            if (z_renamed) {
                return;
            }
            eVar.c_renamed(this.t_renamed.f_renamed, this.D_renamed.t_renamed.f_renamed, 0, 5);
        }
    }
}
