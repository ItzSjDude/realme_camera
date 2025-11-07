package androidx.constraintlayout.p025a.p026a;

import androidx.constraintlayout.p025a.LinearSystem;
import androidx.constraintlayout.p025a.p026a.ConstraintWidget;

/* compiled from: Optimizer.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class Optimizer {

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean[] f2332a = new boolean[3];

    /* renamed from: PlatformImplementations.kt_3 */
    static void m2063a(ConstraintWidgetContainer c0380g, LinearSystem c0394e, ConstraintWidget c0379f) {
        if (c0380g.f2215C[0] != ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT && c0379f.f2215C[0] == ConstraintWidget.PlatformImplementations.kt_3.MATCH_PARENT) {
            int OplusGLSurfaceView_13 = c0379f.f2277s.f2204d;
            int iQ = c0380g.m2013q() - c0379f.f2279u.f2204d;
            c0379f.f2277s.f2206f = c0394e.m2131a(c0379f.f2277s);
            c0379f.f2279u.f2206f = c0394e.m2131a(c0379f.f2279u);
            c0394e.m2136a(c0379f.f2277s.f2206f, OplusGLSurfaceView_13);
            c0394e.m2136a(c0379f.f2279u.f2206f, iQ);
            c0379f.f2238a = 2;
            c0379f.m1982c(OplusGLSurfaceView_13, iQ);
        }
        if (c0380g.f2215C[1] == ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT || c0379f.f2215C[1] != ConstraintWidget.PlatformImplementations.kt_3.MATCH_PARENT) {
            return;
        }
        int i2 = c0379f.f2278t.f2204d;
        int iS = c0380g.m2017s() - c0379f.f2280v.f2204d;
        c0379f.f2278t.f2206f = c0394e.m2131a(c0379f.f2278t);
        c0379f.f2280v.f2206f = c0394e.m2131a(c0379f.f2280v);
        c0394e.m2136a(c0379f.f2278t.f2206f, i2);
        c0394e.m2136a(c0379f.f2280v.f2206f, iS);
        if (c0379f.f2227O > 0 || c0379f.m2005m() == 8) {
            c0379f.f2281w.f2206f = c0394e.m2131a(c0379f.f2281w);
            c0394e.m2136a(c0379f.f2281w.f2206f, c0379f.f2227O + i2);
        }
        c0379f.f2260b = 2;
        c0379f.m1987d(i2, iS);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m2064a(ConstraintWidget c0379f, int OplusGLSurfaceView_13) {
        if (c0379f.f2215C[OplusGLSurfaceView_13] != ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT) {
            return false;
        }
        if (c0379f.f2219G != 0.0f) {
            if (c0379f.f2215C[OplusGLSurfaceView_13 != 0 ? (char) 0 : (char) 1] == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT) {
            }
            return false;
        }
        if (OplusGLSurfaceView_13 == 0) {
            if (c0379f.f2263e != 0 || c0379f.f2266h != 0 || c0379f.f2267i != 0) {
                return false;
            }
        } else if (c0379f.f2264f != 0 || c0379f.f2269k != 0 || c0379f.f2270l != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m2061a(int OplusGLSurfaceView_13, ConstraintWidget c0379f) {
        c0379f.m1995h();
        ResolutionAnchor c0386mM1932a = c0379f.f2277s.m1932a();
        ResolutionAnchor c0386mM1932a2 = c0379f.f2278t.m1932a();
        ResolutionAnchor c0386mM1932a3 = c0379f.f2279u.m1932a();
        ResolutionAnchor c0386mM1932a4 = c0379f.f2280v.m1932a();
        boolean z = (OplusGLSurfaceView_13 & 8) == 8;
        boolean z2 = c0379f.f2215C[0] == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT && m2064a(c0379f, 0);
        if (c0386mM1932a.f2339g != 4 && c0386mM1932a3.f2339g != 4) {
            if (c0379f.f2215C[0] == ConstraintWidget.PlatformImplementations.kt_3.FIXED || (z2 && c0379f.m2005m() == 8)) {
                if (c0379f.f2277s.f2203c == null && c0379f.f2279u.f2203c == null) {
                    c0386mM1932a.m2074b(1);
                    c0386mM1932a3.m2074b(1);
                    if (z) {
                        c0386mM1932a3.m2071a(c0386mM1932a, 1, c0379f.m1999j());
                    } else {
                        c0386mM1932a3.m2070a(c0386mM1932a, c0379f.m2013q());
                    }
                } else if (c0379f.f2277s.f2203c != null && c0379f.f2279u.f2203c == null) {
                    c0386mM1932a.m2074b(1);
                    c0386mM1932a3.m2074b(1);
                    if (z) {
                        c0386mM1932a3.m2071a(c0386mM1932a, 1, c0379f.m1999j());
                    } else {
                        c0386mM1932a3.m2070a(c0386mM1932a, c0379f.m2013q());
                    }
                } else if (c0379f.f2277s.f2203c == null && c0379f.f2279u.f2203c != null) {
                    c0386mM1932a.m2074b(1);
                    c0386mM1932a3.m2074b(1);
                    c0386mM1932a.m2070a(c0386mM1932a3, -c0379f.m2013q());
                    if (z) {
                        c0386mM1932a.m2071a(c0386mM1932a3, -1, c0379f.m1999j());
                    } else {
                        c0386mM1932a.m2070a(c0386mM1932a3, -c0379f.m2013q());
                    }
                } else if (c0379f.f2277s.f2203c != null && c0379f.f2279u.f2203c != null) {
                    c0386mM1932a.m2074b(2);
                    c0386mM1932a3.m2074b(2);
                    if (z) {
                        c0379f.m1999j().m2081a(c0386mM1932a);
                        c0379f.m1999j().m2081a(c0386mM1932a3);
                        c0386mM1932a.m2076b(c0386mM1932a3, -1, c0379f.m1999j());
                        c0386mM1932a3.m2076b(c0386mM1932a, 1, c0379f.m1999j());
                    } else {
                        c0386mM1932a.m2075b(c0386mM1932a3, -c0379f.m2013q());
                        c0386mM1932a3.m2075b(c0386mM1932a, c0379f.m2013q());
                    }
                }
            } else if (z2) {
                int iM2013q = c0379f.m2013q();
                c0386mM1932a.m2074b(1);
                c0386mM1932a3.m2074b(1);
                if (c0379f.f2277s.f2203c == null && c0379f.f2279u.f2203c == null) {
                    if (z) {
                        c0386mM1932a3.m2071a(c0386mM1932a, 1, c0379f.m1999j());
                    } else {
                        c0386mM1932a3.m2070a(c0386mM1932a, iM2013q);
                    }
                } else if (c0379f.f2277s.f2203c == null || c0379f.f2279u.f2203c != null) {
                    if (c0379f.f2277s.f2203c != null || c0379f.f2279u.f2203c == null) {
                        if (c0379f.f2277s.f2203c != null && c0379f.f2279u.f2203c != null) {
                            if (z) {
                                c0379f.m1999j().m2081a(c0386mM1932a);
                                c0379f.m1999j().m2081a(c0386mM1932a3);
                            }
                            if (c0379f.f2219G == 0.0f) {
                                c0386mM1932a.m2074b(3);
                                c0386mM1932a3.m2074b(3);
                                c0386mM1932a.m2075b(c0386mM1932a3, 0.0f);
                                c0386mM1932a3.m2075b(c0386mM1932a, 0.0f);
                            } else {
                                c0386mM1932a.m2074b(2);
                                c0386mM1932a3.m2074b(2);
                                c0386mM1932a.m2075b(c0386mM1932a3, -iM2013q);
                                c0386mM1932a3.m2075b(c0386mM1932a, iM2013q);
                                c0379f.m2000j(iM2013q);
                            }
                        }
                    } else if (z) {
                        c0386mM1932a.m2071a(c0386mM1932a3, -1, c0379f.m1999j());
                    } else {
                        c0386mM1932a.m2070a(c0386mM1932a3, -iM2013q);
                    }
                } else if (z) {
                    c0386mM1932a3.m2071a(c0386mM1932a, 1, c0379f.m1999j());
                } else {
                    c0386mM1932a3.m2070a(c0386mM1932a, iM2013q);
                }
            }
        }
        boolean z3 = c0379f.f2215C[1] == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT && m2064a(c0379f, 1);
        if (c0386mM1932a2.f2339g == 4 || c0386mM1932a4.f2339g == 4) {
            return;
        }
        if (c0379f.f2215C[1] != ConstraintWidget.PlatformImplementations.kt_3.FIXED && (!z3 || c0379f.m2005m() != 8)) {
            if (z3) {
                int iM2017s = c0379f.m2017s();
                c0386mM1932a2.m2074b(1);
                c0386mM1932a4.m2074b(1);
                if (c0379f.f2278t.f2203c == null && c0379f.f2280v.f2203c == null) {
                    if (z) {
                        c0386mM1932a4.m2071a(c0386mM1932a2, 1, c0379f.m2001k());
                        return;
                    } else {
                        c0386mM1932a4.m2070a(c0386mM1932a2, iM2017s);
                        return;
                    }
                }
                if (c0379f.f2278t.f2203c != null && c0379f.f2280v.f2203c == null) {
                    if (z) {
                        c0386mM1932a4.m2071a(c0386mM1932a2, 1, c0379f.m2001k());
                        return;
                    } else {
                        c0386mM1932a4.m2070a(c0386mM1932a2, iM2017s);
                        return;
                    }
                }
                if (c0379f.f2278t.f2203c == null && c0379f.f2280v.f2203c != null) {
                    if (z) {
                        c0386mM1932a2.m2071a(c0386mM1932a4, -1, c0379f.m2001k());
                        return;
                    } else {
                        c0386mM1932a2.m2070a(c0386mM1932a4, -iM2017s);
                        return;
                    }
                }
                if (c0379f.f2278t.f2203c == null || c0379f.f2280v.f2203c == null) {
                    return;
                }
                if (z) {
                    c0379f.m2001k().m2081a(c0386mM1932a2);
                    c0379f.m1999j().m2081a(c0386mM1932a4);
                }
                if (c0379f.f2219G == 0.0f) {
                    c0386mM1932a2.m2074b(3);
                    c0386mM1932a4.m2074b(3);
                    c0386mM1932a2.m2075b(c0386mM1932a4, 0.0f);
                    c0386mM1932a4.m2075b(c0386mM1932a2, 0.0f);
                    return;
                }
                c0386mM1932a2.m2074b(2);
                c0386mM1932a4.m2074b(2);
                c0386mM1932a2.m2075b(c0386mM1932a4, -iM2017s);
                c0386mM1932a4.m2075b(c0386mM1932a2, iM2017s);
                c0379f.m2002k(iM2017s);
                if (c0379f.f2227O > 0) {
                    c0379f.f2281w.m1932a().m2068a(1, c0386mM1932a2, c0379f.f2227O);
                    return;
                }
                return;
            }
            return;
        }
        if (c0379f.f2278t.f2203c == null && c0379f.f2280v.f2203c == null) {
            c0386mM1932a2.m2074b(1);
            c0386mM1932a4.m2074b(1);
            if (z) {
                c0386mM1932a4.m2071a(c0386mM1932a2, 1, c0379f.m2001k());
            } else {
                c0386mM1932a4.m2070a(c0386mM1932a2, c0379f.m2017s());
            }
            if (c0379f.f2281w.f2203c != null) {
                c0379f.f2281w.m1932a().m2074b(1);
                c0386mM1932a2.m2068a(1, c0379f.f2281w.m1932a(), -c0379f.f2227O);
                return;
            }
            return;
        }
        if (c0379f.f2278t.f2203c != null && c0379f.f2280v.f2203c == null) {
            c0386mM1932a2.m2074b(1);
            c0386mM1932a4.m2074b(1);
            if (z) {
                c0386mM1932a4.m2071a(c0386mM1932a2, 1, c0379f.m2001k());
            } else {
                c0386mM1932a4.m2070a(c0386mM1932a2, c0379f.m2017s());
            }
            if (c0379f.f2227O > 0) {
                c0379f.f2281w.m1932a().m2068a(1, c0386mM1932a2, c0379f.f2227O);
                return;
            }
            return;
        }
        if (c0379f.f2278t.f2203c == null && c0379f.f2280v.f2203c != null) {
            c0386mM1932a2.m2074b(1);
            c0386mM1932a4.m2074b(1);
            if (z) {
                c0386mM1932a2.m2071a(c0386mM1932a4, -1, c0379f.m2001k());
            } else {
                c0386mM1932a2.m2070a(c0386mM1932a4, -c0379f.m2017s());
            }
            if (c0379f.f2227O > 0) {
                c0379f.f2281w.m1932a().m2068a(1, c0386mM1932a2, c0379f.f2227O);
                return;
            }
            return;
        }
        if (c0379f.f2278t.f2203c == null || c0379f.f2280v.f2203c == null) {
            return;
        }
        c0386mM1932a2.m2074b(2);
        c0386mM1932a4.m2074b(2);
        if (z) {
            c0386mM1932a2.m2076b(c0386mM1932a4, -1, c0379f.m2001k());
            c0386mM1932a4.m2076b(c0386mM1932a2, 1, c0379f.m2001k());
            c0379f.m2001k().m2081a(c0386mM1932a2);
            c0379f.m1999j().m2081a(c0386mM1932a4);
        } else {
            c0386mM1932a2.m2075b(c0386mM1932a4, -c0379f.m2017s());
            c0386mM1932a4.m2075b(c0386mM1932a2, c0379f.m2017s());
        }
        if (c0379f.f2227O > 0) {
            c0379f.f2281w.m1932a().m2068a(1, c0386mM1932a2, c0379f.f2227O);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[PHI: r11 r12
      0x0034: PHI (r11v29 boolean) = (r11v2 boolean), (r11v32 boolean) binds: [B:25:0x0048, B:13:0x0032] A[DONT_GENERATE, DONT_INLINE]
      0x0034: PHI (r12v13 boolean) = (r12v2 boolean), (r12v16 boolean) binds: [B:25:0x0048, B:13:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[PHI: r11 r12
      0x0036: PHI (r11v4 boolean) = (r11v2 boolean), (r11v32 boolean) binds: [B:25:0x0048, B:13:0x0032] A[DONT_GENERATE, DONT_INLINE]
      0x0036: PHI (r12v4 boolean) = (r12v2 boolean), (r12v16 boolean) binds: [B:25:0x0048, B:13:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0325 A[PHI: r6
      0x0325: PHI (r6v18 float) = (r6v14 float), (r6v12 float) binds: [B:198:0x037d, B:188:0x0322] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0101  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static boolean m2065a(androidx.constraintlayout.p025a.p026a.ConstraintWidgetContainer r23, androidx.constraintlayout.p025a.LinearSystem r24, int r25, int r26, androidx.constraintlayout.p025a.p026a.ChainHead r27) {
        /*
            Method dump skipped, instructions count: 912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p025a.p026a.Optimizer.m2065a(androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11, androidx.constraintlayout.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8, int, int, androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m2062a(ConstraintWidget c0379f, int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 * 2;
        int i4 = i3 + 1;
        c0379f.f2213A[i3].m1932a().f2337e = c0379f.m2003l().f2277s.m1932a();
        c0379f.f2213A[i3].m1932a().f2338f = i2;
        c0379f.f2213A[i3].m1932a().f2348i = 1;
        c0379f.f2213A[i4].m1932a().f2337e = c0379f.f2213A[i3].m1932a();
        c0379f.f2213A[i4].m1932a().f2338f = c0379f.m1991f(OplusGLSurfaceView_13);
        c0379f.f2213A[i4].m1932a().f2348i = 1;
    }
}
