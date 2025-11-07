package androidx.constraintlayout.p025a.p026a;

import androidx.constraintlayout.p025a.p026a.ConstraintAnchor;
import androidx.constraintlayout.p025a.p026a.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Analyzer.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class Analyzer {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m1913a(ConstraintWidgetContainer c0380g) {
        if ((c0380g.m2043b() & 32) != 32) {
            m1918b(c0380g);
            return;
        }
        c0380g.f2307ax = true;
        c0380g.f2302as = false;
        c0380g.f2303at = false;
        c0380g.f2304au = false;
        ArrayList<ConstraintWidget> arrayList = c0380g.f2359az;
        List<ConstraintWidgetGroup> list = c0380g.f2301ar;
        boolean z = c0380g.m1955G() == ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT;
        boolean z2 = c0380g.m1956H() == ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (ConstraintWidget c0379f : arrayList) {
            c0379f.f2276r = null;
            c0379f.f2236Y = false;
            c0379f.mo1925c();
        }
        for (ConstraintWidget c0379f2 : arrayList) {
            if (c0379f2.f2276r == null && !m1917a(c0379f2, list, z3)) {
                m1918b(c0380g);
                c0380g.f2307ax = false;
                return;
            }
        }
        int iMax = 0;
        int iMax2 = 0;
        for (ConstraintWidgetGroup c0381h : list) {
            iMax = Math.max(iMax, m1910a(c0381h, 0));
            iMax2 = Math.max(iMax2, m1910a(c0381h, 1));
        }
        if (z) {
            c0380g.m1966a(ConstraintWidget.PlatformImplementations.kt_3.FIXED);
            c0380g.m2000j(iMax);
            c0380g.f2302as = true;
            c0380g.f2303at = true;
            c0380g.f2305av = iMax;
        }
        if (z2) {
            c0380g.m1976b(ConstraintWidget.PlatformImplementations.kt_3.FIXED);
            c0380g.m2002k(iMax2);
            c0380g.f2302as = true;
            c0380g.f2304au = true;
            c0380g.f2306aw = iMax2;
        }
        m1915a(list, 0, c0380g.m2013q());
        m1915a(list, 1, c0380g.m2017s());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m1917a(ConstraintWidget c0379f, List<ConstraintWidgetGroup> list, boolean z) {
        ConstraintWidgetGroup c0381h = new ConstraintWidgetGroup(new ArrayList(), true);
        list.add(c0381h);
        return m1916a(c0379f, c0381h, list, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m1916a(ConstraintWidget c0379f, ConstraintWidgetGroup c0381h, List<ConstraintWidgetGroup> list, boolean z) {
        if (c0379f == null) {
            return true;
        }
        c0379f.f2235X = false;
        ConstraintWidgetContainer c0380g = (ConstraintWidgetContainer) c0379f.m2003l();
        if (c0379f.f2276r == null) {
            c0379f.f2234W = true;
            c0381h.f2309a.add(c0379f);
            c0379f.f2276r = c0381h;
            if (c0379f.f2277s.f2203c == null && c0379f.f2279u.f2203c == null && c0379f.f2278t.f2203c == null && c0379f.f2280v.f2203c == null && c0379f.f2281w.f2203c == null && c0379f.f2284z.f2203c == null) {
                m1914a(c0380g, c0379f, c0381h);
                if (z) {
                    return false;
                }
            }
            if (c0379f.f2278t.f2203c != null && c0379f.f2280v.f2203c != null) {
                c0380g.m1956H();
                ConstraintWidget.PlatformImplementations.kt_3 aVar = ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT;
                if (z) {
                    m1914a(c0380g, c0379f, c0381h);
                    return false;
                }
                if (c0379f.f2278t.f2203c.f2201a != c0379f.m2003l() || c0379f.f2280v.f2203c.f2201a != c0379f.m2003l()) {
                    m1914a(c0380g, c0379f, c0381h);
                }
            }
            if (c0379f.f2277s.f2203c != null && c0379f.f2279u.f2203c != null) {
                c0380g.m1955G();
                ConstraintWidget.PlatformImplementations.kt_3 aVar2 = ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT;
                if (z) {
                    m1914a(c0380g, c0379f, c0381h);
                    return false;
                }
                if (c0379f.f2277s.f2203c.f2201a != c0379f.m2003l() || c0379f.f2279u.f2203c.f2201a != c0379f.m2003l()) {
                    m1914a(c0380g, c0379f, c0381h);
                }
            }
            if (((c0379f.m1955G() == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT) ^ (c0379f.m1956H() == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT)) && c0379f.f2219G != 0.0f) {
                m1907a(c0379f);
            } else if (c0379f.m1955G() == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT || c0379f.m1956H() == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT) {
                m1914a(c0380g, c0379f, c0381h);
                if (z) {
                    return false;
                }
            }
            if (((c0379f.f2277s.f2203c == null && c0379f.f2279u.f2203c == null) || ((c0379f.f2277s.f2203c != null && c0379f.f2277s.f2203c.f2201a == c0379f.f2216D && c0379f.f2279u.f2203c == null) || ((c0379f.f2279u.f2203c != null && c0379f.f2279u.f2203c.f2201a == c0379f.f2216D && c0379f.f2277s.f2203c == null) || (c0379f.f2277s.f2203c != null && c0379f.f2277s.f2203c.f2201a == c0379f.f2216D && c0379f.f2279u.f2203c != null && c0379f.f2279u.f2203c.f2201a == c0379f.f2216D)))) && c0379f.f2284z.f2203c == null && !(c0379f instanceof Guideline) && !(c0379f instanceof Helper)) {
                c0381h.f2314f.add(c0379f);
            }
            if (((c0379f.f2278t.f2203c == null && c0379f.f2280v.f2203c == null) || ((c0379f.f2278t.f2203c != null && c0379f.f2278t.f2203c.f2201a == c0379f.f2216D && c0379f.f2280v.f2203c == null) || ((c0379f.f2280v.f2203c != null && c0379f.f2280v.f2203c.f2201a == c0379f.f2216D && c0379f.f2278t.f2203c == null) || (c0379f.f2278t.f2203c != null && c0379f.f2278t.f2203c.f2201a == c0379f.f2216D && c0379f.f2280v.f2203c != null && c0379f.f2280v.f2203c.f2201a == c0379f.f2216D)))) && c0379f.f2284z.f2203c == null && c0379f.f2281w.f2203c == null && !(c0379f instanceof Guideline) && !(c0379f instanceof Helper)) {
                c0381h.f2315g.add(c0379f);
            }
            if (c0379f instanceof Helper) {
                m1914a(c0380g, c0379f, c0381h);
                if (z) {
                    return false;
                }
                Helper c0383j = (Helper) c0379f;
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < c0383j.f2331aj; OplusGLSurfaceView_13++) {
                    if (!m1916a(c0383j.f2330ai[OplusGLSurfaceView_13], c0381h, list, z)) {
                        return false;
                    }
                }
            }
            int length = c0379f.f2213A.length;
            for (int i2 = 0; i2 < length; i2++) {
                ConstraintAnchor c0378e = c0379f.f2213A[i2];
                if (c0378e.f2203c != null && c0378e.f2203c.f2201a != c0379f.m2003l()) {
                    if (c0378e.f2202b == ConstraintAnchor.IntrinsicsJvm.kt_3.CENTER) {
                        m1914a(c0380g, c0379f, c0381h);
                        if (z) {
                            return false;
                        }
                    } else {
                        m1911a(c0378e);
                    }
                    if (!m1916a(c0378e.f2203c.f2201a, c0381h, list, z)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (c0379f.f2276r != c0381h) {
            c0381h.f2309a.addAll(c0379f.f2276r.f2309a);
            c0381h.f2314f.addAll(c0379f.f2276r.f2314f);
            c0381h.f2315g.addAll(c0379f.f2276r.f2315g);
            if (!c0379f.f2276r.f2312d) {
                c0381h.f2312d = false;
            }
            list.remove(c0379f.f2276r);
            Iterator<ConstraintWidget> it = c0379f.f2276r.f2309a.iterator();
            while (it.hasNext()) {
                it.next().f2276r = c0381h;
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m1914a(ConstraintWidgetContainer c0380g, ConstraintWidget c0379f, ConstraintWidgetGroup c0381h) {
        c0381h.f2312d = false;
        c0380g.f2307ax = false;
        c0379f.f2234W = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m1910a(ConstraintWidgetGroup c0381h, int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 * 2;
        List<ConstraintWidget> listM2050a = c0381h.m2050a(OplusGLSurfaceView_13);
        int size = listM2050a.size();
        int iMax = 0;
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget c0379f = listM2050a.get(i3);
            int i4 = i2 + 1;
            iMax = Math.max(iMax, m1909a(c0379f, OplusGLSurfaceView_13, c0379f.f2213A[i4].f2203c == null || !(c0379f.f2213A[i2].f2203c == null || c0379f.f2213A[i4].f2203c == null), 0));
        }
        c0381h.f2313e[OplusGLSurfaceView_13] = iMax;
        return iMax;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m1909a(ConstraintWidget c0379f, int OplusGLSurfaceView_13, boolean z, int i2) {
        int iM2017s;
        int iM1950B;
        int i3;
        int i4;
        int i5;
        int i6;
        int iM2013q;
        int i7;
        int i8;
        ConstraintWidget c0379fM2003l;
        int i9;
        int iMax = 0;
        if (!c0379f.f2234W) {
            return 0;
        }
        boolean z2 = c0379f.f2281w.f2203c != null && OplusGLSurfaceView_13 == 1;
        if (z) {
            iM2017s = c0379f.m1950B();
            iM1950B = c0379f.m2017s() - c0379f.m1950B();
            i4 = OplusGLSurfaceView_13 * 2;
            i3 = i4 + 1;
        } else {
            iM2017s = c0379f.m2017s() - c0379f.m1950B();
            iM1950B = c0379f.m1950B();
            i3 = OplusGLSurfaceView_13 * 2;
            i4 = i3 + 1;
        }
        if (c0379f.f2213A[i3].f2203c == null || c0379f.f2213A[i4].f2203c != null) {
            i5 = i3;
            i6 = 1;
        } else {
            i5 = i4;
            i4 = i3;
            i6 = -1;
        }
        int i10 = z2 ? i2 - iM2017s : i2;
        int iM1940e = (c0379f.f2213A[i4].m1940e() * i6) + m1908a(c0379f, OplusGLSurfaceView_13);
        int i11 = i10 + iM1940e;
        int iM2013q2 = (OplusGLSurfaceView_13 == 0 ? c0379f.m2013q() : c0379f.m2017s()) * i6;
        Iterator<ResolutionNode> it = c0379f.f2213A[i4].m1932a().f2347h.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, m1909a(((ResolutionAnchor) it.next()).f2333a.f2201a, OplusGLSurfaceView_13, z, i11));
        }
        int iMax2 = 0;
        for (Iterator<ResolutionNode> it2 = c0379f.f2213A[i5].m1932a().f2347h.iterator(); it2.hasNext(); it2 = it2) {
            iMax2 = Math.max(iMax2, m1909a(((ResolutionAnchor) it2.next()).f2333a.f2201a, OplusGLSurfaceView_13, z, iM2013q2 + i11));
        }
        if (z2) {
            iMax -= iM2017s;
            iM2013q = iMax2 + iM1950B;
        } else {
            iM2013q = iMax2 + ((OplusGLSurfaceView_13 == 0 ? c0379f.m2013q() : c0379f.m2017s()) * i6);
        }
        int i12 = 1;
        if (OplusGLSurfaceView_13 == 1) {
            Iterator<ResolutionNode> it3 = c0379f.f2281w.m1932a().f2347h.iterator();
            int iMax3 = 0;
            while (it3.hasNext()) {
                Iterator<ResolutionNode> it4 = it3;
                ResolutionAnchor c0386m = (ResolutionAnchor) it3.next();
                if (i6 == i12) {
                    iMax3 = Math.max(iMax3, m1909a(c0386m.f2333a.f2201a, OplusGLSurfaceView_13, z, iM2017s + i11));
                    i9 = i5;
                } else {
                    i9 = i5;
                    iMax3 = Math.max(iMax3, m1909a(c0386m.f2333a.f2201a, OplusGLSurfaceView_13, z, (iM1950B * i6) + i11));
                }
                it3 = it4;
                i5 = i9;
                i12 = 1;
            }
            i7 = i5;
            int i13 = iMax3;
            i8 = (c0379f.f2281w.m1932a().f2347h.size() <= 0 || z2) ? i13 : i6 == 1 ? i13 + iM2017s : i13 - iM1950B;
        } else {
            i7 = i5;
            i8 = 0;
        }
        int iMax4 = iM1940e + Math.max(iMax, Math.max(iM2013q, i8));
        int i14 = i11 + iM2013q2;
        if (i6 == -1) {
            i11 = i14;
            i14 = i11;
        }
        if (z) {
            Optimizer.m2062a(c0379f, OplusGLSurfaceView_13, i11);
            c0379f.m1962a(i11, i14, OplusGLSurfaceView_13);
        } else {
            c0379f.f2276r.m2051a(c0379f, OplusGLSurfaceView_13);
            c0379f.m1989e(i11, OplusGLSurfaceView_13);
        }
        if (c0379f.m2020t(OplusGLSurfaceView_13) == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT && c0379f.f2219G != 0.0f) {
            c0379f.f2276r.m2051a(c0379f, OplusGLSurfaceView_13);
        }
        if (c0379f.f2213A[i4].f2203c != null && c0379f.f2213A[i7].f2203c != null && c0379f.f2213A[i4].f2203c.f2201a == (c0379fM2003l = c0379f.m2003l()) && c0379f.f2213A[i7].f2203c.f2201a == c0379fM2003l) {
            c0379f.f2276r.m2051a(c0379f, OplusGLSurfaceView_13);
        }
        return iMax4;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m1911a(ConstraintAnchor c0378e) {
        ResolutionAnchor c0386mM1932a = c0378e.m1932a();
        if (c0378e.f2203c == null || c0378e.f2203c.f2203c == c0378e) {
            return;
        }
        c0378e.f2203c.m1932a().m2081a(c0386mM1932a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m1918b(ConstraintWidgetContainer c0380g) {
        c0380g.f2301ar.clear();
        c0380g.f2301ar.add(0, new ConstraintWidgetGroup(c0380g.f2359az));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m1915a(List<ConstraintWidgetGroup> list, int OplusGLSurfaceView_13, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (ConstraintWidget c0379f : list.get(i3).m2052b(OplusGLSurfaceView_13)) {
                if (c0379f.f2234W) {
                    m1912a(c0379f, OplusGLSurfaceView_13, i2);
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m1912a(ConstraintWidget c0379f, int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 * 2;
        ConstraintAnchor c0378e = c0379f.f2213A[i3];
        ConstraintAnchor c0378e2 = c0379f.f2213A[i3 + 1];
        if ((c0378e.f2203c == null || c0378e2.f2203c == null) ? false : true) {
            Optimizer.m2062a(c0379f, OplusGLSurfaceView_13, m1908a(c0379f, OplusGLSurfaceView_13) + c0378e.m1940e());
            return;
        }
        if (c0379f.f2219G != 0.0f && c0379f.m2020t(OplusGLSurfaceView_13) == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT) {
            int iM1907a = m1907a(c0379f);
            int i4 = (int) c0379f.f2213A[i3].m1932a().f2338f;
            c0378e2.m1932a().f2337e = c0378e.m1932a();
            c0378e2.m1932a().f2338f = iM1907a;
            c0378e2.m1932a().f2348i = 1;
            c0379f.m1962a(i4, i4 + iM1907a, OplusGLSurfaceView_13);
            return;
        }
        int iM2012p = i2 - c0379f.m2012p(OplusGLSurfaceView_13);
        int iM1991f = iM2012p - c0379f.m1991f(OplusGLSurfaceView_13);
        c0379f.m1962a(iM1991f, iM2012p, OplusGLSurfaceView_13);
        Optimizer.m2062a(c0379f, OplusGLSurfaceView_13, iM1991f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m1908a(ConstraintWidget c0379f, int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 * 2;
        ConstraintAnchor c0378e = c0379f.f2213A[i2];
        ConstraintAnchor c0378e2 = c0379f.f2213A[i2 + 1];
        if (c0378e.f2203c == null || c0378e.f2203c.f2201a != c0379f.f2216D || c0378e2.f2203c == null || c0378e2.f2203c.f2201a != c0379f.f2216D) {
            return 0;
        }
        return (int) ((((c0379f.f2216D.m1991f(OplusGLSurfaceView_13) - c0378e.m1940e()) - c0378e2.m1940e()) - c0379f.m1991f(OplusGLSurfaceView_13)) * (OplusGLSurfaceView_13 == 0 ? c0379f.f2230S : c0379f.f2231T));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m1907a(ConstraintWidget c0379f) {
        float fM2013q;
        float fM2017s;
        if (c0379f.m1955G() == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT) {
            if (c0379f.f2220H == 0) {
                fM2017s = c0379f.m2017s() * c0379f.f2219G;
            } else {
                fM2017s = c0379f.m2017s() / c0379f.f2219G;
            }
            int OplusGLSurfaceView_13 = (int) fM2017s;
            c0379f.m2000j(OplusGLSurfaceView_13);
            return OplusGLSurfaceView_13;
        }
        if (c0379f.m1956H() != ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT) {
            return -1;
        }
        if (c0379f.f2220H == 1) {
            fM2013q = c0379f.m2013q() * c0379f.f2219G;
        } else {
            fM2013q = c0379f.m2013q() / c0379f.f2219G;
        }
        int i2 = (int) fM2013q;
        c0379f.m2002k(i2);
        return i2;
    }
}
