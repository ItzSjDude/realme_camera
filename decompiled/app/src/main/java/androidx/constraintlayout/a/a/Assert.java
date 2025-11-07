package androidx.constraintlayout.a_renamed.a_renamed;

/* compiled from: Analyzer.java */
/* loaded from: classes.dex */
public class a_renamed {
    public static void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.g_renamed gVar) {
        if ((gVar.b_renamed() & 32) != 32) {
            b_renamed(gVar);
            return;
        }
        gVar.ax_renamed = true;
        gVar.as_renamed = false;
        gVar.at_renamed = false;
        gVar.au_renamed = false;
        java.util.ArrayList<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> arrayList = gVar.az_renamed;
        java.util.List<androidx.constraintlayout.a_renamed.a_renamed.h_renamed> list = gVar.ar_renamed;
        boolean z_renamed = gVar.G_renamed() == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT;
        boolean z2 = gVar.H_renamed() == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT;
        boolean z3 = z_renamed || z2;
        list.clear();
        for (androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar : arrayList) {
            fVar.r_renamed = null;
            fVar.Y_renamed = false;
            fVar.c_renamed();
        }
        for (androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar2 : arrayList) {
            if (fVar2.r_renamed == null && !a_renamed(fVar2, list, z3)) {
                b_renamed(gVar);
                gVar.ax_renamed = false;
                return;
            }
        }
        int iMax = 0;
        int iMax2 = 0;
        for (androidx.constraintlayout.a_renamed.a_renamed.h_renamed hVar : list) {
            iMax = java.lang.Math.max(iMax, a_renamed(hVar, 0));
            iMax2 = java.lang.Math.max(iMax2, a_renamed(hVar, 1));
        }
        if (z_renamed) {
            gVar.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED);
            gVar.j_renamed(iMax);
            gVar.as_renamed = true;
            gVar.at_renamed = true;
            gVar.av_renamed = iMax;
        }
        if (z2) {
            gVar.b_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED);
            gVar.k_renamed(iMax2);
            gVar.as_renamed = true;
            gVar.au_renamed = true;
            gVar.aw_renamed = iMax2;
        }
        a_renamed(list, 0, gVar.q_renamed());
        a_renamed(list, 1, gVar.s_renamed());
    }

    private static boolean a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, java.util.List<androidx.constraintlayout.a_renamed.a_renamed.h_renamed> list, boolean z_renamed) {
        androidx.constraintlayout.a_renamed.a_renamed.h_renamed hVar = new androidx.constraintlayout.a_renamed.a_renamed.h_renamed(new java.util.ArrayList(), true);
        list.add(hVar);
        return a_renamed(fVar, hVar, list, z_renamed);
    }

    private static boolean a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, androidx.constraintlayout.a_renamed.a_renamed.h_renamed hVar, java.util.List<androidx.constraintlayout.a_renamed.a_renamed.h_renamed> list, boolean z_renamed) {
        if (fVar == null) {
            return true;
        }
        fVar.X_renamed = false;
        androidx.constraintlayout.a_renamed.a_renamed.g_renamed gVar = (androidx.constraintlayout.a_renamed.a_renamed.g_renamed) fVar.l_renamed();
        if (fVar.r_renamed == null) {
            fVar.W_renamed = true;
            hVar.f717a.add(fVar);
            fVar.r_renamed = hVar;
            if (fVar.s_renamed.f710c == null && fVar.u_renamed.f710c == null && fVar.t_renamed.f710c == null && fVar.v_renamed.f710c == null && fVar.w_renamed.f710c == null && fVar.z_renamed.f710c == null) {
                a_renamed(gVar, fVar, hVar);
                if (z_renamed) {
                    return false;
                }
            }
            if (fVar.t_renamed.f710c != null && fVar.v_renamed.f710c != null) {
                gVar.H_renamed();
                androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed aVar = androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT;
                if (z_renamed) {
                    a_renamed(gVar, fVar, hVar);
                    return false;
                }
                if (fVar.t_renamed.f710c.f708a != fVar.l_renamed() || fVar.v_renamed.f710c.f708a != fVar.l_renamed()) {
                    a_renamed(gVar, fVar, hVar);
                }
            }
            if (fVar.s_renamed.f710c != null && fVar.u_renamed.f710c != null) {
                gVar.G_renamed();
                androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed aVar2 = androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT;
                if (z_renamed) {
                    a_renamed(gVar, fVar, hVar);
                    return false;
                }
                if (fVar.s_renamed.f710c.f708a != fVar.l_renamed() || fVar.u_renamed.f710c.f708a != fVar.l_renamed()) {
                    a_renamed(gVar, fVar, hVar);
                }
            }
            if (((fVar.G_renamed() == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT) ^ (fVar.H_renamed() == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT)) && fVar.G_renamed != 0.0f) {
                a_renamed(fVar);
            } else if (fVar.G_renamed() == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT || fVar.H_renamed() == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT) {
                a_renamed(gVar, fVar, hVar);
                if (z_renamed) {
                    return false;
                }
            }
            if (((fVar.s_renamed.f710c == null && fVar.u_renamed.f710c == null) || ((fVar.s_renamed.f710c != null && fVar.s_renamed.f710c.f708a == fVar.D_renamed && fVar.u_renamed.f710c == null) || ((fVar.u_renamed.f710c != null && fVar.u_renamed.f710c.f708a == fVar.D_renamed && fVar.s_renamed.f710c == null) || (fVar.s_renamed.f710c != null && fVar.s_renamed.f710c.f708a == fVar.D_renamed && fVar.u_renamed.f710c != null && fVar.u_renamed.f710c.f708a == fVar.D_renamed)))) && fVar.z_renamed.f710c == null && !(fVar instanceof androidx.constraintlayout.a_renamed.a_renamed.i_renamed) && !(fVar instanceof androidx.constraintlayout.a_renamed.a_renamed.j_renamed)) {
                hVar.f_renamed.add(fVar);
            }
            if (((fVar.t_renamed.f710c == null && fVar.v_renamed.f710c == null) || ((fVar.t_renamed.f710c != null && fVar.t_renamed.f710c.f708a == fVar.D_renamed && fVar.v_renamed.f710c == null) || ((fVar.v_renamed.f710c != null && fVar.v_renamed.f710c.f708a == fVar.D_renamed && fVar.t_renamed.f710c == null) || (fVar.t_renamed.f710c != null && fVar.t_renamed.f710c.f708a == fVar.D_renamed && fVar.v_renamed.f710c != null && fVar.v_renamed.f710c.f708a == fVar.D_renamed)))) && fVar.z_renamed.f710c == null && fVar.w_renamed.f710c == null && !(fVar instanceof androidx.constraintlayout.a_renamed.a_renamed.i_renamed) && !(fVar instanceof androidx.constraintlayout.a_renamed.a_renamed.j_renamed)) {
                hVar.g_renamed.add(fVar);
            }
            if (fVar instanceof androidx.constraintlayout.a_renamed.a_renamed.j_renamed) {
                a_renamed(gVar, fVar, hVar);
                if (z_renamed) {
                    return false;
                }
                androidx.constraintlayout.a_renamed.a_renamed.j_renamed jVar = (androidx.constraintlayout.a_renamed.a_renamed.j_renamed) fVar;
                for (int i_renamed = 0; i_renamed < jVar.aj_renamed; i_renamed++) {
                    if (!a_renamed(jVar.ai_renamed[i_renamed], hVar, list, z_renamed)) {
                        return false;
                    }
                }
            }
            int length = fVar.A_renamed.length;
            for (int i2 = 0; i2 < length; i2++) {
                androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar = fVar.A_renamed[i2];
                if (eVar.f710c != null && eVar.f710c.f708a != fVar.l_renamed()) {
                    if (eVar.f709b == androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.CENTER) {
                        a_renamed(gVar, fVar, hVar);
                        if (z_renamed) {
                            return false;
                        }
                    } else {
                        a_renamed(eVar);
                    }
                    if (!a_renamed(eVar.f710c.f708a, hVar, list, z_renamed)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (fVar.r_renamed != hVar) {
            hVar.f717a.addAll(fVar.r_renamed.f717a);
            hVar.f_renamed.addAll(fVar.r_renamed.f_renamed);
            hVar.g_renamed.addAll(fVar.r_renamed.g_renamed);
            if (!fVar.r_renamed.d_renamed) {
                hVar.d_renamed = false;
            }
            list.remove(fVar.r_renamed);
            java.util.Iterator<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> it = fVar.r_renamed.f717a.iterator();
            while (it.hasNext()) {
                it.next().r_renamed = hVar;
            }
        }
        return true;
    }

    private static void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.g_renamed gVar, androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, androidx.constraintlayout.a_renamed.a_renamed.h_renamed hVar) {
        hVar.d_renamed = false;
        gVar.ax_renamed = false;
        fVar.W_renamed = false;
    }

    private static int a_renamed(androidx.constraintlayout.a_renamed.a_renamed.h_renamed hVar, int i_renamed) {
        int i2 = i_renamed * 2;
        java.util.List<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> listA = hVar.a_renamed(i_renamed);
        int size = listA.size();
        int iMax = 0;
        for (int i3 = 0; i3 < size; i3++) {
            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar = listA.get(i3);
            int i4 = i2 + 1;
            iMax = java.lang.Math.max(iMax, a_renamed(fVar, i_renamed, fVar.A_renamed[i4].f710c == null || !(fVar.A_renamed[i2].f710c == null || fVar.A_renamed[i4].f710c == null), 0));
        }
        hVar.e_renamed[i_renamed] = iMax;
        return iMax;
    }

    private static int a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, int i_renamed, boolean z_renamed, int i2) {
        int iS;
        int iB;
        int i3;
        int i4;
        int i5;
        int i6;
        int iQ;
        int i7;
        int i8;
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarL;
        int i9;
        int iMax = 0;
        if (!fVar.W_renamed) {
            return 0;
        }
        boolean z2 = fVar.w_renamed.f710c != null && i_renamed == 1;
        if (z_renamed) {
            iS = fVar.B_renamed();
            iB = fVar.s_renamed() - fVar.B_renamed();
            i4 = i_renamed * 2;
            i3 = i4 + 1;
        } else {
            iS = fVar.s_renamed() - fVar.B_renamed();
            iB = fVar.B_renamed();
            i3 = i_renamed * 2;
            i4 = i3 + 1;
        }
        if (fVar.A_renamed[i3].f710c == null || fVar.A_renamed[i4].f710c != null) {
            i5 = i3;
            i6 = 1;
        } else {
            i5 = i4;
            i4 = i3;
            i6 = -1;
        }
        int i10 = z2 ? i2 - iS : i2;
        int iE = (fVar.A_renamed[i4].e_renamed() * i6) + a_renamed(fVar, i_renamed);
        int i11 = i10 + iE;
        int iQ2 = (i_renamed == 0 ? fVar.q_renamed() : fVar.s_renamed()) * i6;
        java.util.Iterator<androidx.constraintlayout.a_renamed.a_renamed.o_renamed> it = fVar.A_renamed[i4].a_renamed().h_renamed.iterator();
        while (it.hasNext()) {
            iMax = java.lang.Math.max(iMax, a_renamed(((androidx.constraintlayout.a_renamed.a_renamed.m_renamed) it.next()).f722a.f708a, i_renamed, z_renamed, i11));
        }
        int iMax2 = 0;
        for (java.util.Iterator<androidx.constraintlayout.a_renamed.a_renamed.o_renamed> it2 = fVar.A_renamed[i5].a_renamed().h_renamed.iterator(); it2.hasNext(); it2 = it2) {
            iMax2 = java.lang.Math.max(iMax2, a_renamed(((androidx.constraintlayout.a_renamed.a_renamed.m_renamed) it2.next()).f722a.f708a, i_renamed, z_renamed, iQ2 + i11));
        }
        if (z2) {
            iMax -= iS;
            iQ = iMax2 + iB;
        } else {
            iQ = iMax2 + ((i_renamed == 0 ? fVar.q_renamed() : fVar.s_renamed()) * i6);
        }
        int i12 = 1;
        if (i_renamed == 1) {
            java.util.Iterator<androidx.constraintlayout.a_renamed.a_renamed.o_renamed> it3 = fVar.w_renamed.a_renamed().h_renamed.iterator();
            int iMax3 = 0;
            while (it3.hasNext()) {
                java.util.Iterator<androidx.constraintlayout.a_renamed.a_renamed.o_renamed> it4 = it3;
                androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVar = (androidx.constraintlayout.a_renamed.a_renamed.m_renamed) it3.next();
                if (i6 == i12) {
                    iMax3 = java.lang.Math.max(iMax3, a_renamed(mVar.f722a.f708a, i_renamed, z_renamed, iS + i11));
                    i9 = i5;
                } else {
                    i9 = i5;
                    iMax3 = java.lang.Math.max(iMax3, a_renamed(mVar.f722a.f708a, i_renamed, z_renamed, (iB * i6) + i11));
                }
                it3 = it4;
                i5 = i9;
                i12 = 1;
            }
            i7 = i5;
            int i13 = iMax3;
            i8 = (fVar.w_renamed.a_renamed().h_renamed.size() <= 0 || z2) ? i13 : i6 == 1 ? i13 + iS : i13 - iB;
        } else {
            i7 = i5;
            i8 = 0;
        }
        int iMax4 = iE + java.lang.Math.max(iMax, java.lang.Math.max(iQ, i8));
        int i14 = i11 + iQ2;
        if (i6 == -1) {
            i11 = i14;
            i14 = i11;
        }
        if (z_renamed) {
            androidx.constraintlayout.a_renamed.a_renamed.k_renamed.a_renamed(fVar, i_renamed, i11);
            fVar.a_renamed(i11, i14, i_renamed);
        } else {
            fVar.r_renamed.a_renamed(fVar, i_renamed);
            fVar.e_renamed(i11, i_renamed);
        }
        if (fVar.t_renamed(i_renamed) == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT && fVar.G_renamed != 0.0f) {
            fVar.r_renamed.a_renamed(fVar, i_renamed);
        }
        if (fVar.A_renamed[i4].f710c != null && fVar.A_renamed[i7].f710c != null && fVar.A_renamed[i4].f710c.f708a == (fVarL = fVar.l_renamed()) && fVar.A_renamed[i7].f710c.f708a == fVarL) {
            fVar.r_renamed.a_renamed(fVar, i_renamed);
        }
        return iMax4;
    }

    private static void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar) {
        androidx.constraintlayout.a_renamed.a_renamed.m_renamed mVarA = eVar.a_renamed();
        if (eVar.f710c == null || eVar.f710c.f710c == eVar) {
            return;
        }
        eVar.f710c.a_renamed().a_renamed(mVarA);
    }

    private static void b_renamed(androidx.constraintlayout.a_renamed.a_renamed.g_renamed gVar) {
        gVar.ar_renamed.clear();
        gVar.ar_renamed.add(0, new androidx.constraintlayout.a_renamed.a_renamed.h_renamed(gVar.az_renamed));
    }

    public static void a_renamed(java.util.List<androidx.constraintlayout.a_renamed.a_renamed.h_renamed> list, int i_renamed, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar : list.get(i3).b_renamed(i_renamed)) {
                if (fVar.W_renamed) {
                    a_renamed(fVar, i_renamed, i2);
                }
            }
        }
    }

    private static void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, int i_renamed, int i2) {
        int i3 = i_renamed * 2;
        androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar = fVar.A_renamed[i3];
        androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar2 = fVar.A_renamed[i3 + 1];
        if ((eVar.f710c == null || eVar2.f710c == null) ? false : true) {
            androidx.constraintlayout.a_renamed.a_renamed.k_renamed.a_renamed(fVar, i_renamed, a_renamed(fVar, i_renamed) + eVar.e_renamed());
            return;
        }
        if (fVar.G_renamed != 0.0f && fVar.t_renamed(i_renamed) == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT) {
            int iA = a_renamed(fVar);
            int i4 = (int) fVar.A_renamed[i3].a_renamed().f_renamed;
            eVar2.a_renamed().e_renamed = eVar.a_renamed();
            eVar2.a_renamed().f_renamed = iA;
            eVar2.a_renamed().i_renamed = 1;
            fVar.a_renamed(i4, i4 + iA, i_renamed);
            return;
        }
        int iP = i2 - fVar.p_renamed(i_renamed);
        int iF = iP - fVar.f_renamed(i_renamed);
        fVar.a_renamed(iF, iP, i_renamed);
        androidx.constraintlayout.a_renamed.a_renamed.k_renamed.a_renamed(fVar, i_renamed, iF);
    }

    private static int a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar, int i_renamed) {
        int i2 = i_renamed * 2;
        androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar = fVar.A_renamed[i2];
        androidx.constraintlayout.a_renamed.a_renamed.e_renamed eVar2 = fVar.A_renamed[i2 + 1];
        if (eVar.f710c == null || eVar.f710c.f708a != fVar.D_renamed || eVar2.f710c == null || eVar2.f710c.f708a != fVar.D_renamed) {
            return 0;
        }
        return (int) ((((fVar.D_renamed.f_renamed(i_renamed) - eVar.e_renamed()) - eVar2.e_renamed()) - fVar.f_renamed(i_renamed)) * (i_renamed == 0 ? fVar.S_renamed : fVar.T_renamed));
    }

    private static int a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
        float fQ_renamed;
        float fS_renamed;
        if (fVar.G_renamed() == androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT) {
            if (fVar.H_renamed == 0) {
                fS_renamed = fVar.s_renamed() * fVar.G_renamed;
            } else {
                fS_renamed = fVar.s_renamed() / fVar.G_renamed;
            }
            int i_renamed = (int) fS_renamed;
            fVar.j_renamed(i_renamed);
            return i_renamed;
        }
        if (fVar.H_renamed() != androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT) {
            return -1;
        }
        if (fVar.H_renamed == 1) {
            fQ_renamed = fVar.q_renamed() * fVar.G_renamed;
        } else {
            fQ_renamed = fVar.q_renamed() / fVar.G_renamed;
        }
        int i2 = (int) fQ_renamed;
        fVar.k_renamed(i2);
        return i2;
    }
}
