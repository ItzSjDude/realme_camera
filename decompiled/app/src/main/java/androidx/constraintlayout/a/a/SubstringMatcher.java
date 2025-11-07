package androidx.constraintlayout.a_renamed.a_renamed;

/* compiled from: Optimizer.java */
/* loaded from: classes.dex */
public class k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static boolean[] f721a = new boolean[3];

    static void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.g_renamed gVar, androidx.constraintlayout.a_renamed.e_renamed eVar, androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
        if (gVar.C_renamed[0] != androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT && fVar.C_renamed[0] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_PARENT) {
            int i_renamed = fVar.s_renamed.d_renamed;
            int iQ = gVar.q_renamed() - fVar.u_renamed.d_renamed;
            fVar.s_renamed.f_renamed = eVar.a_renamed(fVar.s_renamed);
            fVar.u_renamed.f_renamed = eVar.a_renamed(fVar.u_renamed);
            eVar.a_renamed(fVar.s_renamed.f_renamed, i_renamed);
            eVar.a_renamed(fVar.u_renamed.f_renamed, iQ);
            fVar.f712a = 2;
            fVar.c_renamed(i_renamed, iQ);
        }
        if (gVar.C_renamed[1] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT || fVar.C_renamed[1] != androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_PARENT) {
            return;
        }
        int i2 = fVar.t_renamed.d_renamed;
        int iS = gVar.s_renamed() - fVar.v_renamed.d_renamed;
        fVar.t_renamed.f_renamed = eVar.a_renamed(fVar.t_renamed);
        fVar.v_renamed.f_renamed = eVar.a_renamed(fVar.v_renamed);
        eVar.a_renamed(fVar.t_renamed.f_renamed, i2);
        eVar.a_renamed(fVar.v_renamed.f_renamed, iS);
        if (fVar.O_renamed > 0 || fVar.m_renamed() == 8) {
            fVar.w_renamed.f_renamed = eVar.a_renamed(fVar.w_renamed);
            eVar.a_renamed(fVar.w_renamed.f_renamed, fVar.O_renamed + i2);
        }
        fVar.f713b = 2;
        fVar.d_renamed(i2, iS);
    }

    private static boolean a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, int i_renamed) {
        if (fVar.C_renamed[i_renamed] != androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT) {
            return false;
        }
        if (fVar.G_renamed != 0.0f) {
            if (fVar.C_renamed[i_renamed != 0 ? (char) 0 : (char) 1] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT) {
            }
            return false;
        }
        if (i_renamed == 0) {
            if (fVar.e_renamed != 0 || fVar.h_renamed != 0 || fVar.i_renamed != 0) {
                return false;
            }
        } else if (fVar.f_renamed != 0 || fVar.k_renamed != 0 || fVar.l_renamed != 0) {
            return false;
        }
        return true;
    }

    static void a_renamed(int i_renamed, androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
        fVar.h_renamed();
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVarA = fVar.s_renamed.a_renamed();
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVarA2 = fVar.t_renamed.a_renamed();
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVarA3 = fVar.u_renamed.a_renamed();
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVarA4 = fVar.v_renamed.a_renamed();
        boolean z_renamed = (i_renamed & 8) == 8;
        boolean z2 = fVar.C_renamed[0] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT && a_renamed(fVar, 0);
        if (mVarA.g_renamed != 4 && mVarA3.g_renamed != 4) {
            if (fVar.C_renamed[0] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED || (z2 && fVar.m_renamed() == 8)) {
                if (fVar.s_renamed.f710c == null && fVar.u_renamed.f710c == null) {
                    mVarA.b_renamed(1);
                    mVarA3.b_renamed(1);
                    if (z_renamed) {
                        mVarA3.a_renamed(mVarA, 1, fVar.j_renamed());
                    } else {
                        mVarA3.a_renamed(mVarA, fVar.q_renamed());
                    }
                } else if (fVar.s_renamed.f710c != null && fVar.u_renamed.f710c == null) {
                    mVarA.b_renamed(1);
                    mVarA3.b_renamed(1);
                    if (z_renamed) {
                        mVarA3.a_renamed(mVarA, 1, fVar.j_renamed());
                    } else {
                        mVarA3.a_renamed(mVarA, fVar.q_renamed());
                    }
                } else if (fVar.s_renamed.f710c == null && fVar.u_renamed.f710c != null) {
                    mVarA.b_renamed(1);
                    mVarA3.b_renamed(1);
                    mVarA.a_renamed(mVarA3, -fVar.q_renamed());
                    if (z_renamed) {
                        mVarA.a_renamed(mVarA3, -1, fVar.j_renamed());
                    } else {
                        mVarA.a_renamed(mVarA3, -fVar.q_renamed());
                    }
                } else if (fVar.s_renamed.f710c != null && fVar.u_renamed.f710c != null) {
                    mVarA.b_renamed(2);
                    mVarA3.b_renamed(2);
                    if (z_renamed) {
                        fVar.j_renamed().a_renamed(mVarA);
                        fVar.j_renamed().a_renamed(mVarA3);
                        mVarA.b_renamed(mVarA3, -1, fVar.j_renamed());
                        mVarA3.b_renamed(mVarA, 1, fVar.j_renamed());
                    } else {
                        mVarA.b_renamed(mVarA3, -fVar.q_renamed());
                        mVarA3.b_renamed(mVarA, fVar.q_renamed());
                    }
                }
            } else if (z2) {
                int iQ = fVar.q_renamed();
                mVarA.b_renamed(1);
                mVarA3.b_renamed(1);
                if (fVar.s_renamed.f710c == null && fVar.u_renamed.f710c == null) {
                    if (z_renamed) {
                        mVarA3.a_renamed(mVarA, 1, fVar.j_renamed());
                    } else {
                        mVarA3.a_renamed(mVarA, iQ);
                    }
                } else if (fVar.s_renamed.f710c == null || fVar.u_renamed.f710c != null) {
                    if (fVar.s_renamed.f710c != null || fVar.u_renamed.f710c == null) {
                        if (fVar.s_renamed.f710c != null && fVar.u_renamed.f710c != null) {
                            if (z_renamed) {
                                fVar.j_renamed().a_renamed(mVarA);
                                fVar.j_renamed().a_renamed(mVarA3);
                            }
                            if (fVar.G_renamed == 0.0f) {
                                mVarA.b_renamed(3);
                                mVarA3.b_renamed(3);
                                mVarA.b_renamed(mVarA3, 0.0f);
                                mVarA3.b_renamed(mVarA, 0.0f);
                            } else {
                                mVarA.b_renamed(2);
                                mVarA3.b_renamed(2);
                                mVarA.b_renamed(mVarA3, -iQ);
                                mVarA3.b_renamed(mVarA, iQ);
                                fVar.j_renamed(iQ);
                            }
                        }
                    } else if (z_renamed) {
                        mVarA.a_renamed(mVarA3, -1, fVar.j_renamed());
                    } else {
                        mVarA.a_renamed(mVarA3, -iQ);
                    }
                } else if (z_renamed) {
                    mVarA3.a_renamed(mVarA, 1, fVar.j_renamed());
                } else {
                    mVarA3.a_renamed(mVarA, iQ);
                }
            }
        }
        boolean z3 = fVar.C_renamed[1] == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT && a_renamed(fVar, 1);
        if (mVarA2.g_renamed == 4 || mVarA4.g_renamed == 4) {
            return;
        }
        if (fVar.C_renamed[1] != androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED && (!z3 || fVar.m_renamed() != 8)) {
            if (z3) {
                int iS = fVar.s_renamed();
                mVarA2.b_renamed(1);
                mVarA4.b_renamed(1);
                if (fVar.t_renamed.f710c == null && fVar.v_renamed.f710c == null) {
                    if (z_renamed) {
                        mVarA4.a_renamed(mVarA2, 1, fVar.k_renamed());
                        return;
                    } else {
                        mVarA4.a_renamed(mVarA2, iS);
                        return;
                    }
                }
                if (fVar.t_renamed.f710c != null && fVar.v_renamed.f710c == null) {
                    if (z_renamed) {
                        mVarA4.a_renamed(mVarA2, 1, fVar.k_renamed());
                        return;
                    } else {
                        mVarA4.a_renamed(mVarA2, iS);
                        return;
                    }
                }
                if (fVar.t_renamed.f710c == null && fVar.v_renamed.f710c != null) {
                    if (z_renamed) {
                        mVarA2.a_renamed(mVarA4, -1, fVar.k_renamed());
                        return;
                    } else {
                        mVarA2.a_renamed(mVarA4, -iS);
                        return;
                    }
                }
                if (fVar.t_renamed.f710c == null || fVar.v_renamed.f710c == null) {
                    return;
                }
                if (z_renamed) {
                    fVar.k_renamed().a_renamed(mVarA2);
                    fVar.j_renamed().a_renamed(mVarA4);
                }
                if (fVar.G_renamed == 0.0f) {
                    mVarA2.b_renamed(3);
                    mVarA4.b_renamed(3);
                    mVarA2.b_renamed(mVarA4, 0.0f);
                    mVarA4.b_renamed(mVarA2, 0.0f);
                    return;
                }
                mVarA2.b_renamed(2);
                mVarA4.b_renamed(2);
                mVarA2.b_renamed(mVarA4, -iS);
                mVarA4.b_renamed(mVarA2, iS);
                fVar.k_renamed(iS);
                if (fVar.O_renamed > 0) {
                    fVar.w_renamed.a_renamed().a_renamed(1, mVarA2, fVar.O_renamed);
                    return;
                }
                return;
            }
            return;
        }
        if (fVar.t_renamed.f710c == null && fVar.v_renamed.f710c == null) {
            mVarA2.b_renamed(1);
            mVarA4.b_renamed(1);
            if (z_renamed) {
                mVarA4.a_renamed(mVarA2, 1, fVar.k_renamed());
            } else {
                mVarA4.a_renamed(mVarA2, fVar.s_renamed());
            }
            if (fVar.w_renamed.f710c != null) {
                fVar.w_renamed.a_renamed().b_renamed(1);
                mVarA2.a_renamed(1, fVar.w_renamed.a_renamed(), -fVar.O_renamed);
                return;
            }
            return;
        }
        if (fVar.t_renamed.f710c != null && fVar.v_renamed.f710c == null) {
            mVarA2.b_renamed(1);
            mVarA4.b_renamed(1);
            if (z_renamed) {
                mVarA4.a_renamed(mVarA2, 1, fVar.k_renamed());
            } else {
                mVarA4.a_renamed(mVarA2, fVar.s_renamed());
            }
            if (fVar.O_renamed > 0) {
                fVar.w_renamed.a_renamed().a_renamed(1, mVarA2, fVar.O_renamed);
                return;
            }
            return;
        }
        if (fVar.t_renamed.f710c == null && fVar.v_renamed.f710c != null) {
            mVarA2.b_renamed(1);
            mVarA4.b_renamed(1);
            if (z_renamed) {
                mVarA2.a_renamed(mVarA4, -1, fVar.k_renamed());
            } else {
                mVarA2.a_renamed(mVarA4, -fVar.s_renamed());
            }
            if (fVar.O_renamed > 0) {
                fVar.w_renamed.a_renamed().a_renamed(1, mVarA2, fVar.O_renamed);
                return;
            }
            return;
        }
        if (fVar.t_renamed.f710c == null || fVar.v_renamed.f710c == null) {
            return;
        }
        mVarA2.b_renamed(2);
        mVarA4.b_renamed(2);
        if (z_renamed) {
            mVarA2.b_renamed(mVarA4, -1, fVar.k_renamed());
            mVarA4.b_renamed(mVarA2, 1, fVar.k_renamed());
            fVar.k_renamed().a_renamed(mVarA2);
            fVar.j_renamed().a_renamed(mVarA4);
        } else {
            mVarA2.b_renamed(mVarA4, -fVar.s_renamed());
            mVarA4.b_renamed(mVarA2, fVar.s_renamed());
        }
        if (fVar.O_renamed > 0) {
            fVar.w_renamed.a_renamed().a_renamed(1, mVarA2, fVar.O_renamed);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:14:0x0034 A_renamed[PHI: r11 r12
      0x0034: PHI (r11v29 boolean) = (r11v2 boolean), (r11v32 boolean) binds: [B_renamed:25:0x0048, B_renamed:13:0x0032] A_renamed[DONT_GENERATE, DONT_INLINE]
      0x0034: PHI (r12v13 boolean) = (r12v2 boolean), (r12v16 boolean) binds: [B_renamed:25:0x0048, B_renamed:13:0x0032] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x0036 A_renamed[PHI: r11 r12
      0x0036: PHI (r11v4 boolean) = (r11v2 boolean), (r11v32 boolean) binds: [B_renamed:25:0x0048, B_renamed:13:0x0032] A_renamed[DONT_GENERATE, DONT_INLINE]
      0x0036: PHI (r12v4 boolean) = (r12v2 boolean), (r12v16 boolean) binds: [B_renamed:25:0x0048, B_renamed:13:0x0032] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:190:0x0325 A_renamed[PHI: r6
      0x0325: PHI (r6v18 float) = (r6v14 float), (r6v12 float) binds: [B_renamed:198:0x037d, B_renamed:188:0x0322] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:76:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static boolean a_renamed(androidx.constraintlayout.a_renamed.a_renamed.g_renamed r23, androidx.constraintlayout.a_renamed.e_renamed r24, int r25, int r26, androidx.constraintlayout.a_renamed.a_renamed.d_renamed r27) {
        /*
            Method dump skipped, instructions count: 912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a_renamed.a_renamed.k_renamed.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.g_renamed, androidx.constraintlayout.a_renamed.e_renamed, int, int, androidx.constraintlayout.a_renamed.a_renamed.d_renamed):boolean");
    }

    static void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, int i_renamed, int i2) {
        int i3 = i_renamed * 2;
        int i4 = i3 + 1;
        fVar.A_renamed[i3].a_renamed().e_renamed = fVar.l_renamed().s_renamed.a_renamed();
        fVar.A_renamed[i3].a_renamed().f_renamed = i2;
        fVar.A_renamed[i3].a_renamed().i_renamed = 1;
        fVar.A_renamed[i4].a_renamed().e_renamed = fVar.A_renamed[i3].a_renamed();
        fVar.A_renamed[i4].a_renamed().f_renamed = fVar.f_renamed(i_renamed);
        fVar.A_renamed[i4].a_renamed().i_renamed = 1;
    }
}
