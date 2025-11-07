package androidx.constraintlayout.p025a;

import androidx.constraintlayout.p025a.SolverVariable;
import androidx.constraintlayout.p025a.p026a.ConstraintAnchor;
import androidx.constraintlayout.p025a.p026a.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: LinearSystem.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class LinearSystem {

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static Metrics f2368g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static int f2369h = 1000;

    /* renamed from: IntrinsicsJvm.kt_4 */
    ArrayRow[] f2371b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean f2372c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    int f2373d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    int f2374e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    final Cache f2375f;

    /* renamed from: OplusGLSurfaceView_15 */
    private PlatformImplementations.kt_3 f2377j;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f2379l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean[] f2380m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f2381n;

    /* renamed from: o */
    private SolverVariable[] f2382o;

    /* renamed from: p */
    private int f2383p;

    /* renamed from: q */
    private ArrayRow[] f2384q;

    /* renamed from: r */
    private final PlatformImplementations.kt_3 f2385r;

    /* renamed from: PlatformImplementations.kt_3 */
    int f2370a = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private HashMap<String, SolverVariable> f2376i = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f2378k = 32;

    /* compiled from: LinearSystem.java */
    /* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        SolverVariable mo2101a(LinearSystem c0394e, boolean[] zArr);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo2102a(PlatformImplementations.kt_3 aVar);

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo2115d(SolverVariable c0397h);

        /* renamed from: COUIBaseListPopupWindow_12 */
        void mo2117f();

        /* renamed from: COUIBaseListPopupWindow_11 */
        SolverVariable mo2118g();
    }

    public LinearSystem() {
        int OplusGLSurfaceView_13 = this.f2378k;
        this.f2379l = OplusGLSurfaceView_13;
        this.f2371b = null;
        this.f2372c = false;
        this.f2380m = new boolean[OplusGLSurfaceView_13];
        this.f2373d = 1;
        this.f2374e = 0;
        this.f2381n = OplusGLSurfaceView_13;
        this.f2382o = new SolverVariable[f2369h];
        this.f2383p = 0;
        this.f2384q = new ArrayRow[OplusGLSurfaceView_13];
        this.f2371b = new ArrayRow[OplusGLSurfaceView_13];
        m2128i();
        this.f2375f = new Cache();
        this.f2377j = new GoalRow(this.f2375f);
        this.f2385r = new ArrayRow(this.f2375f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Metrics m2121a() {
        return f2368g;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m2127h() {
        this.f2378k *= 2;
        this.f2371b = (ArrayRow[]) Arrays.copyOf(this.f2371b, this.f2378k);
        Cache c0392c = this.f2375f;
        c0392c.f2367c = (SolverVariable[]) Arrays.copyOf(c0392c.f2367c, this.f2378k);
        int OplusGLSurfaceView_13 = this.f2378k;
        this.f2380m = new boolean[OplusGLSurfaceView_13];
        this.f2379l = OplusGLSurfaceView_13;
        this.f2381n = OplusGLSurfaceView_13;
        Metrics c0395f = f2368g;
        if (c0395f != null) {
            c0395f.f2393d++;
            Metrics c0395f2 = f2368g;
            c0395f2.f2405p = Math.max(c0395f2.f2405p, this.f2378k);
            Metrics c0395f3 = f2368g;
            c0395f3.f2389D = c0395f3.f2405p;
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m2128i() {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            ArrayRow[] c0391bArr = this.f2371b;
            if (OplusGLSurfaceView_13 >= c0391bArr.length) {
                return;
            }
            ArrayRow c0391b = c0391bArr[OplusGLSurfaceView_13];
            if (c0391b != null) {
                this.f2375f.f2365a.mo2153a(c0391b);
            }
            this.f2371b[OplusGLSurfaceView_13] = null;
            OplusGLSurfaceView_13++;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2142b() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f2375f.f2367c.length; OplusGLSurfaceView_13++) {
            SolverVariable c0397h = this.f2375f.f2367c[OplusGLSurfaceView_13];
            if (c0397h != null) {
                c0397h.m2157b();
            }
        }
        this.f2375f.f2366b.mo2152a(this.f2382o, this.f2383p);
        this.f2383p = 0;
        Arrays.fill(this.f2375f.f2367c, (Object) null);
        HashMap<String, SolverVariable> map = this.f2376i;
        if (map != null) {
            map.clear();
        }
        this.f2370a = 0;
        this.f2377j.mo2117f();
        this.f2373d = 1;
        for (int i2 = 0; i2 < this.f2374e; i2++) {
            this.f2371b[i2].f2362c = false;
        }
        m2128i();
        this.f2374e = 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public SolverVariable m2131a(Object obj) {
        SolverVariable c0397hM1937b = null;
        if (obj == null) {
            return null;
        }
        if (this.f2373d + 1 >= this.f2379l) {
            m2127h();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor c0378e = (ConstraintAnchor) obj;
            c0397hM1937b = c0378e.m1937b();
            if (c0397hM1937b == null) {
                c0378e.m1933a(this.f2375f);
                c0397hM1937b = c0378e.m1937b();
            }
            if (c0397hM1937b.f2423a == -1 || c0397hM1937b.f2423a > this.f2370a || this.f2375f.f2367c[c0397hM1937b.f2423a] == null) {
                if (c0397hM1937b.f2423a != -1) {
                    c0397hM1937b.m2157b();
                }
                this.f2370a++;
                this.f2373d++;
                c0397hM1937b.f2423a = this.f2370a;
                c0397hM1937b.f2428f = SolverVariable.PlatformImplementations.kt_3.UNRESTRICTED;
                this.f2375f.f2367c[this.f2370a] = c0397hM1937b;
            }
        }
        return c0397hM1937b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayRow m2145c() {
        ArrayRow c0391bMo2151a = this.f2375f.f2365a.mo2151a();
        if (c0391bMo2151a == null) {
            c0391bMo2151a = new ArrayRow(this.f2375f);
        } else {
            c0391bMo2151a.m2112c();
        }
        SolverVariable.m2154a();
        return c0391bMo2151a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public SolverVariable m2147d() {
        Metrics c0395f = f2368g;
        if (c0395f != null) {
            c0395f.f2403n++;
        }
        if (this.f2373d + 1 >= this.f2379l) {
            m2127h();
        }
        SolverVariable c0397hM2122a = m2122a(SolverVariable.PlatformImplementations.kt_3.SLACK, (String) null);
        this.f2370a++;
        this.f2373d++;
        c0397hM2122a.f2423a = this.f2370a;
        this.f2375f.f2367c[this.f2370a] = c0397hM2122a;
        return c0397hM2122a;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public SolverVariable m2148e() {
        Metrics c0395f = f2368g;
        if (c0395f != null) {
            c0395f.f2404o++;
        }
        if (this.f2373d + 1 >= this.f2379l) {
            m2127h();
        }
        SolverVariable c0397hM2122a = m2122a(SolverVariable.PlatformImplementations.kt_3.SLACK, (String) null);
        this.f2370a++;
        this.f2373d++;
        c0397hM2122a.f2423a = this.f2370a;
        this.f2375f.f2367c[this.f2370a] = c0397hM2122a;
        return c0397hM2122a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m2124b(ArrayRow c0391b) {
        c0391b.m2094a(this, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m2134a(ArrayRow c0391b, int OplusGLSurfaceView_13, int i2) {
        c0391b.m2111c(m2130a(i2, (String) null), OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public SolverVariable m2130a(int OplusGLSurfaceView_13, String str) {
        Metrics c0395f = f2368g;
        if (c0395f != null) {
            c0395f.f2402m++;
        }
        if (this.f2373d + 1 >= this.f2379l) {
            m2127h();
        }
        SolverVariable c0397hM2122a = m2122a(SolverVariable.PlatformImplementations.kt_3.ERROR, str);
        this.f2370a++;
        this.f2373d++;
        c0397hM2122a.f2423a = this.f2370a;
        c0397hM2122a.f2425c = OplusGLSurfaceView_13;
        this.f2375f.f2367c[this.f2370a] = c0397hM2122a;
        this.f2377j.mo2115d(c0397hM2122a);
        return c0397hM2122a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private SolverVariable m2122a(SolverVariable.PlatformImplementations.kt_3 aVar, String str) {
        SolverVariable c0397hMo2151a = this.f2375f.f2366b.mo2151a();
        if (c0397hMo2151a == null) {
            c0397hMo2151a = new SolverVariable(aVar, str);
            c0397hMo2151a.m2156a(aVar, str);
        } else {
            c0397hMo2151a.m2157b();
            c0397hMo2151a.m2156a(aVar, str);
        }
        int OplusGLSurfaceView_13 = this.f2383p;
        int i2 = f2369h;
        if (OplusGLSurfaceView_13 >= i2) {
            f2369h = i2 * 2;
            this.f2382o = (SolverVariable[]) Arrays.copyOf(this.f2382o, f2369h);
        }
        SolverVariable[] c0397hArr = this.f2382o;
        int i3 = this.f2383p;
        this.f2383p = i3 + 1;
        c0397hArr[i3] = c0397hMo2151a;
        return c0397hMo2151a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m2141b(Object obj) {
        SolverVariable c0397hM1937b = ((ConstraintAnchor) obj).m1937b();
        if (c0397hM1937b != null) {
            return (int) (c0397hM1937b.f2426d + 0.5f);
        }
        return 0;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m2149f() throws Exception {
        Metrics c0395f = f2368g;
        if (c0395f != null) {
            c0395f.f2394e++;
        }
        if (this.f2372c) {
            Metrics c0395f2 = f2368g;
            if (c0395f2 != null) {
                c0395f2.f2407r++;
            }
            boolean z = false;
            int OplusGLSurfaceView_13 = 0;
            while (true) {
                if (OplusGLSurfaceView_13 >= this.f2374e) {
                    z = true;
                    break;
                } else if (!this.f2371b[OplusGLSurfaceView_13].f2364e) {
                    break;
                } else {
                    OplusGLSurfaceView_13++;
                }
            }
            if (!z) {
                m2135a(this.f2377j);
                return;
            }
            Metrics c0395f3 = f2368g;
            if (c0395f3 != null) {
                c0395f3.f2406q++;
            }
            m2129j();
            return;
        }
        m2135a(this.f2377j);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m2135a(PlatformImplementations.kt_3 aVar) throws Exception {
        Metrics c0395f = f2368g;
        if (c0395f != null) {
            c0395f.f2409t++;
            Metrics c0395f2 = f2368g;
            c0395f2.f2410u = Math.max(c0395f2.f2410u, this.f2373d);
            Metrics c0395f3 = f2368g;
            c0395f3.f2411v = Math.max(c0395f3.f2411v, this.f2374e);
        }
        m2125c((ArrayRow) aVar);
        m2123b(aVar);
        m2119a(aVar, false);
        m2129j();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final void m2125c(ArrayRow c0391b) {
        if (this.f2374e > 0) {
            c0391b.f2363d.m1900a(c0391b, this.f2371b);
            if (c0391b.f2363d.f2170a == 0) {
                c0391b.f2364e = true;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2133a(ArrayRow c0391b) {
        SolverVariable c0397hM2109b;
        if (c0391b == null) {
            return;
        }
        Metrics c0395f = f2368g;
        if (c0395f != null) {
            c0395f.f2395f++;
            if (c0391b.f2364e) {
                f2368g.f2396g++;
            }
        }
        if (this.f2374e + 1 >= this.f2381n || this.f2373d + 1 >= this.f2379l) {
            m2127h();
        }
        boolean z = false;
        if (!c0391b.f2364e) {
            m2125c(c0391b);
            if (c0391b.m2116e()) {
                return;
            }
            c0391b.m2114d();
            if (c0391b.m2104a(this)) {
                SolverVariable c0397hM2148e = m2148e();
                c0391b.f2360a = c0397hM2148e;
                m2126d(c0391b);
                this.f2385r.mo2102a(c0391b);
                m2119a(this.f2385r, true);
                if (c0397hM2148e.f2424b == -1) {
                    if (c0391b.f2360a == c0397hM2148e && (c0397hM2109b = c0391b.m2109b(c0397hM2148e)) != null) {
                        Metrics c0395f2 = f2368g;
                        if (c0395f2 != null) {
                            c0395f2.f2399j++;
                        }
                        c0391b.m2113c(c0397hM2109b);
                    }
                    if (!c0391b.f2364e) {
                        c0391b.f2360a.m2159c(c0391b);
                    }
                    this.f2374e--;
                }
                z = true;
            }
            if (!c0391b.m2103a()) {
                return;
            }
        }
        if (z) {
            return;
        }
        m2126d(c0391b);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final void m2126d(ArrayRow c0391b) {
        if (this.f2371b[this.f2374e] != null) {
            this.f2375f.f2365a.mo2153a(this.f2371b[this.f2374e]);
        }
        this.f2371b[this.f2374e] = c0391b;
        SolverVariable c0397h = c0391b.f2360a;
        int OplusGLSurfaceView_13 = this.f2374e;
        c0397h.f2424b = OplusGLSurfaceView_13;
        this.f2374e = OplusGLSurfaceView_13 + 1;
        c0391b.f2360a.m2159c(c0391b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final int m2119a(PlatformImplementations.kt_3 aVar, boolean z) {
        Metrics c0395f = f2368g;
        if (c0395f != null) {
            c0395f.f2397h++;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f2373d; OplusGLSurfaceView_13++) {
            this.f2380m[OplusGLSurfaceView_13] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            Metrics c0395f2 = f2368g;
            if (c0395f2 != null) {
                c0395f2.f2398i++;
            }
            i2++;
            if (i2 >= this.f2373d * 2) {
                return i2;
            }
            if (aVar.mo2118g() != null) {
                this.f2380m[aVar.mo2118g().f2423a] = true;
            }
            SolverVariable c0397hMo2101a = aVar.mo2101a(this, this.f2380m);
            if (c0397hMo2101a != null) {
                if (this.f2380m[c0397hMo2101a.f2423a]) {
                    return i2;
                }
                this.f2380m[c0397hMo2101a.f2423a] = true;
            }
            if (c0397hMo2101a != null) {
                float COUIBaseListPopupWindow_12 = Float.MAX_VALUE;
                int i3 = -1;
                for (int i4 = 0; i4 < this.f2374e; i4++) {
                    ArrayRow c0391b = this.f2371b[i4];
                    if (c0391b.f2360a.f2428f != SolverVariable.PlatformImplementations.kt_3.UNRESTRICTED && !c0391b.f2364e && c0391b.m2105a(c0397hMo2101a)) {
                        float fM1905b = c0391b.f2363d.m1905b(c0397hMo2101a);
                        if (fM1905b < 0.0f) {
                            float f2 = (-c0391b.f2361b) / fM1905b;
                            if (f2 < COUIBaseListPopupWindow_12) {
                                i3 = i4;
                                COUIBaseListPopupWindow_12 = f2;
                            }
                        }
                    }
                }
                if (i3 > -1) {
                    ArrayRow c0391b2 = this.f2371b[i3];
                    c0391b2.f2360a.f2424b = -1;
                    Metrics c0395f3 = f2368g;
                    if (c0395f3 != null) {
                        c0395f3.f2399j++;
                    }
                    c0391b2.m2113c(c0397hMo2101a);
                    c0391b2.f2360a.f2424b = i3;
                    c0391b2.f2360a.m2159c(c0391b2);
                }
            }
            z2 = true;
        }
        return i2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m2123b(PlatformImplementations.kt_3 aVar) throws Exception {
        float COUIBaseListPopupWindow_12;
        boolean z;
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            COUIBaseListPopupWindow_12 = 0.0f;
            if (OplusGLSurfaceView_13 >= this.f2374e) {
                z = false;
                break;
            }
            if (this.f2371b[OplusGLSurfaceView_13].f2360a.f2428f != SolverVariable.PlatformImplementations.kt_3.UNRESTRICTED && this.f2371b[OplusGLSurfaceView_13].f2361b < 0.0f) {
                z = true;
                break;
            }
            OplusGLSurfaceView_13++;
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            Metrics c0395f = f2368g;
            if (c0395f != null) {
                c0395f.f2400k++;
            }
            i2++;
            float f2 = Float.MAX_VALUE;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            int i6 = 0;
            while (i5 < this.f2374e) {
                ArrayRow c0391b = this.f2371b[i5];
                if (c0391b.f2360a.f2428f != SolverVariable.PlatformImplementations.kt_3.UNRESTRICTED && !c0391b.f2364e && c0391b.f2361b < COUIBaseListPopupWindow_12) {
                    int i7 = 1;
                    while (i7 < this.f2373d) {
                        SolverVariable c0397h = this.f2375f.f2367c[i7];
                        float fM1905b = c0391b.f2363d.m1905b(c0397h);
                        if (fM1905b > COUIBaseListPopupWindow_12) {
                            int i8 = i6;
                            float f3 = f2;
                            int i9 = i4;
                            int i10 = i3;
                            for (int i11 = 0; i11 < 7; i11++) {
                                float f4 = c0397h.f2427e[i11] / fM1905b;
                                if ((f4 < f3 && i11 == i8) || i11 > i8) {
                                    i9 = i7;
                                    i10 = i5;
                                    f3 = f4;
                                    i8 = i11;
                                }
                            }
                            i3 = i10;
                            i4 = i9;
                            f2 = f3;
                            i6 = i8;
                        }
                        i7++;
                        COUIBaseListPopupWindow_12 = 0.0f;
                    }
                }
                i5++;
                COUIBaseListPopupWindow_12 = 0.0f;
            }
            if (i3 != -1) {
                ArrayRow c0391b2 = this.f2371b[i3];
                c0391b2.f2360a.f2424b = -1;
                Metrics c0395f2 = f2368g;
                if (c0395f2 != null) {
                    c0395f2.f2399j++;
                }
                c0391b2.m2113c(this.f2375f.f2367c[i4]);
                c0391b2.f2360a.f2424b = i3;
                c0391b2.f2360a.m2159c(c0391b2);
            } else {
                z2 = true;
            }
            if (i2 > this.f2373d / 2) {
                z2 = true;
            }
            COUIBaseListPopupWindow_12 = 0.0f;
        }
        return i2;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m2129j() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f2374e; OplusGLSurfaceView_13++) {
            ArrayRow c0391b = this.f2371b[OplusGLSurfaceView_13];
            c0391b.f2360a.f2426d = c0391b.f2361b;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public Cache m2150g() {
        return this.f2375f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2138a(SolverVariable c0397h, SolverVariable c0397h2, int OplusGLSurfaceView_13, int i2) {
        ArrayRow c0391bM2145c = m2145c();
        SolverVariable c0397hM2147d = m2147d();
        c0397hM2147d.f2425c = 0;
        c0391bM2145c.m2099a(c0397h, c0397h2, c0397hM2147d, OplusGLSurfaceView_13);
        if (i2 != 6) {
            m2134a(c0391bM2145c, (int) (c0391bM2145c.f2363d.m1905b(c0397hM2147d) * (-1.0f)), i2);
        }
        m2133a(c0391bM2145c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2140a(SolverVariable c0397h, SolverVariable c0397h2, boolean z) {
        ArrayRow c0391bM2145c = m2145c();
        SolverVariable c0397hM2147d = m2147d();
        c0397hM2147d.f2425c = 0;
        c0391bM2145c.m2099a(c0397h, c0397h2, c0397hM2147d, 0);
        if (z) {
            m2134a(c0391bM2145c, (int) (c0391bM2145c.f2363d.m1905b(c0397hM2147d) * (-1.0f)), 1);
        }
        m2133a(c0391bM2145c);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2143b(SolverVariable c0397h, SolverVariable c0397h2, int OplusGLSurfaceView_13, int i2) {
        ArrayRow c0391bM2145c = m2145c();
        SolverVariable c0397hM2147d = m2147d();
        c0397hM2147d.f2425c = 0;
        c0391bM2145c.m2107b(c0397h, c0397h2, c0397hM2147d, OplusGLSurfaceView_13);
        if (i2 != 6) {
            m2134a(c0391bM2145c, (int) (c0391bM2145c.f2363d.m1905b(c0397hM2147d) * (-1.0f)), i2);
        }
        m2133a(c0391bM2145c);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2144b(SolverVariable c0397h, SolverVariable c0397h2, boolean z) {
        ArrayRow c0391bM2145c = m2145c();
        SolverVariable c0397hM2147d = m2147d();
        c0397hM2147d.f2425c = 0;
        c0391bM2145c.m2107b(c0397h, c0397h2, c0397hM2147d, 0);
        if (z) {
            m2134a(c0391bM2145c, (int) (c0391bM2145c.f2363d.m1905b(c0397hM2147d) * (-1.0f)), 1);
        }
        m2133a(c0391bM2145c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2137a(SolverVariable c0397h, SolverVariable c0397h2, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, SolverVariable c0397h3, SolverVariable c0397h4, int i2, int i3) {
        ArrayRow c0391bM2145c = m2145c();
        c0391bM2145c.m2097a(c0397h, c0397h2, OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, c0397h3, c0397h4, i2);
        if (i3 != 6) {
            c0391bM2145c.m2094a(this, i3);
        }
        m2133a(c0391bM2145c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2139a(SolverVariable c0397h, SolverVariable c0397h2, SolverVariable c0397h3, SolverVariable c0397h4, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        ArrayRow c0391bM2145c = m2145c();
        c0391bM2145c.m2100a(c0397h, c0397h2, c0397h3, c0397h4, COUIBaseListPopupWindow_12);
        if (OplusGLSurfaceView_13 != 6) {
            c0391bM2145c.m2094a(this, OplusGLSurfaceView_13);
        }
        m2133a(c0391bM2145c);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ArrayRow m2146c(SolverVariable c0397h, SolverVariable c0397h2, int OplusGLSurfaceView_13, int i2) {
        ArrayRow c0391bM2145c = m2145c();
        c0391bM2145c.m2096a(c0397h, c0397h2, OplusGLSurfaceView_13);
        if (i2 != 6) {
            c0391bM2145c.m2094a(this, i2);
        }
        m2133a(c0391bM2145c);
        return c0391bM2145c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2136a(SolverVariable c0397h, int OplusGLSurfaceView_13) {
        int i2 = c0397h.f2424b;
        if (c0397h.f2424b != -1) {
            ArrayRow c0391b = this.f2371b[i2];
            if (c0391b.f2364e) {
                c0391b.f2361b = OplusGLSurfaceView_13;
                return;
            }
            if (c0391b.f2363d.f2170a == 0) {
                c0391b.f2364e = true;
                c0391b.f2361b = OplusGLSurfaceView_13;
                return;
            } else {
                ArrayRow c0391bM2145c = m2145c();
                c0391bM2145c.m2106b(c0397h, OplusGLSurfaceView_13);
                m2133a(c0391bM2145c);
                return;
            }
        }
        ArrayRow c0391bM2145c2 = m2145c();
        c0391bM2145c2.m2095a(c0397h, OplusGLSurfaceView_13);
        m2133a(c0391bM2145c2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ArrayRow m2120a(LinearSystem c0394e, SolverVariable c0397h, SolverVariable c0397h2, SolverVariable c0397h3, float COUIBaseListPopupWindow_12, boolean z) {
        ArrayRow c0391bM2145c = c0394e.m2145c();
        if (z) {
            c0394e.m2124b(c0391bM2145c);
        }
        return c0391bM2145c.m2098a(c0397h, c0397h2, c0397h3, COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2132a(ConstraintWidget c0379f, ConstraintWidget c0379f2, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        SolverVariable c0397hM2131a = m2131a(c0379f.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.LEFT));
        SolverVariable c0397hM2131a2 = m2131a(c0379f.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.TOP));
        SolverVariable c0397hM2131a3 = m2131a(c0379f.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.RIGHT));
        SolverVariable c0397hM2131a4 = m2131a(c0379f.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.BOTTOM));
        SolverVariable c0397hM2131a5 = m2131a(c0379f2.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.LEFT));
        SolverVariable c0397hM2131a6 = m2131a(c0379f2.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.TOP));
        SolverVariable c0397hM2131a7 = m2131a(c0379f2.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.RIGHT));
        SolverVariable c0397hM2131a8 = m2131a(c0379f2.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.BOTTOM));
        ArrayRow c0391bM2145c = m2145c();
        double IntrinsicsJvm.kt_5 = COUIBaseListPopupWindow_12;
        double d2 = OplusGLSurfaceView_13;
        c0391bM2145c.m2108b(c0397hM2131a2, c0397hM2131a4, c0397hM2131a6, c0397hM2131a8, (float) (Math.sin(IntrinsicsJvm.kt_5) * d2));
        m2133a(c0391bM2145c);
        ArrayRow c0391bM2145c2 = m2145c();
        c0391bM2145c2.m2108b(c0397hM2131a, c0397hM2131a3, c0397hM2131a5, c0397hM2131a7, (float) (Math.cos(IntrinsicsJvm.kt_5) * d2));
        m2133a(c0391bM2145c2);
    }
}
