package androidx.constraintlayout.p025a;

import androidx.constraintlayout.p025a.LinearSystem;
import androidx.constraintlayout.p025a.SolverVariable;

/* compiled from: ArrayRow.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class ArrayRow implements LinearSystem.PlatformImplementations.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final ArrayLinkedVariables f2363d;

    /* renamed from: PlatformImplementations.kt_3 */
    SolverVariable f2360a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    float f2361b = 0.0f;

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean f2362c = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean f2364e = false;

    public ArrayRow(Cache c0392c) {
        this.f2363d = new ArrayLinkedVariables(this, c0392c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m2103a() {
        SolverVariable c0397h = this.f2360a;
        return c0397h != null && (c0397h.f2428f == SolverVariable.PlatformImplementations.kt_3.UNRESTRICTED || this.f2361b >= 0.0f);
    }

    public String toString() {
        return m2110b();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cd  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.lang.String m2110b() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p025a.ArrayRow.m2110b():java.lang.String");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m2112c() {
        this.f2360a = null;
        this.f2363d.m1897a();
        this.f2361b = 0.0f;
        this.f2364e = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m2105a(SolverVariable c0397h) {
        return this.f2363d.m1903a(c0397h);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    ArrayRow m2095a(SolverVariable c0397h, int OplusGLSurfaceView_13) {
        this.f2360a = c0397h;
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        c0397h.f2426d = COUIBaseListPopupWindow_12;
        this.f2361b = COUIBaseListPopupWindow_12;
        this.f2364e = true;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ArrayRow m2106b(SolverVariable c0397h, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            this.f2361b = OplusGLSurfaceView_13 * (-1);
            this.f2363d.m1901a(c0397h, 1.0f);
        } else {
            this.f2361b = OplusGLSurfaceView_13;
            this.f2363d.m1901a(c0397h, -1.0f);
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ArrayRow m2096a(SolverVariable c0397h, SolverVariable c0397h2, int OplusGLSurfaceView_13) {
        boolean z = false;
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 < 0) {
                OplusGLSurfaceView_13 *= -1;
                z = true;
            }
            this.f2361b = OplusGLSurfaceView_13;
        }
        if (!z) {
            this.f2363d.m1901a(c0397h, -1.0f);
            this.f2363d.m1901a(c0397h2, 1.0f);
        } else {
            this.f2363d.m1901a(c0397h, 1.0f);
            this.f2363d.m1901a(c0397h2, -1.0f);
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    ArrayRow m2111c(SolverVariable c0397h, int OplusGLSurfaceView_13) {
        this.f2363d.m1901a(c0397h, OplusGLSurfaceView_13);
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ArrayRow m2099a(SolverVariable c0397h, SolverVariable c0397h2, SolverVariable c0397h3, int OplusGLSurfaceView_13) {
        boolean z = false;
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 < 0) {
                OplusGLSurfaceView_13 *= -1;
                z = true;
            }
            this.f2361b = OplusGLSurfaceView_13;
        }
        if (!z) {
            this.f2363d.m1901a(c0397h, -1.0f);
            this.f2363d.m1901a(c0397h2, 1.0f);
            this.f2363d.m1901a(c0397h3, 1.0f);
        } else {
            this.f2363d.m1901a(c0397h, 1.0f);
            this.f2363d.m1901a(c0397h2, -1.0f);
            this.f2363d.m1901a(c0397h3, -1.0f);
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ArrayRow m2107b(SolverVariable c0397h, SolverVariable c0397h2, SolverVariable c0397h3, int OplusGLSurfaceView_13) {
        boolean z = false;
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 < 0) {
                OplusGLSurfaceView_13 *= -1;
                z = true;
            }
            this.f2361b = OplusGLSurfaceView_13;
        }
        if (!z) {
            this.f2363d.m1901a(c0397h, -1.0f);
            this.f2363d.m1901a(c0397h2, 1.0f);
            this.f2363d.m1901a(c0397h3, -1.0f);
        } else {
            this.f2363d.m1901a(c0397h, 1.0f);
            this.f2363d.m1901a(c0397h2, -1.0f);
            this.f2363d.m1901a(c0397h3, 1.0f);
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ArrayRow m2093a(float COUIBaseListPopupWindow_12, float f2, float f3, SolverVariable c0397h, SolverVariable c0397h2, SolverVariable c0397h3, SolverVariable c0397h4) {
        this.f2361b = 0.0f;
        if (f2 == 0.0f || COUIBaseListPopupWindow_12 == f3) {
            this.f2363d.m1901a(c0397h, 1.0f);
            this.f2363d.m1901a(c0397h2, -1.0f);
            this.f2363d.m1901a(c0397h4, 1.0f);
            this.f2363d.m1901a(c0397h3, -1.0f);
        } else if (COUIBaseListPopupWindow_12 == 0.0f) {
            this.f2363d.m1901a(c0397h, 1.0f);
            this.f2363d.m1901a(c0397h2, -1.0f);
        } else if (f3 == 0.0f) {
            this.f2363d.m1901a(c0397h3, 1.0f);
            this.f2363d.m1901a(c0397h4, -1.0f);
        } else {
            float f4 = (COUIBaseListPopupWindow_12 / f2) / (f3 / f2);
            this.f2363d.m1901a(c0397h, 1.0f);
            this.f2363d.m1901a(c0397h2, -1.0f);
            this.f2363d.m1901a(c0397h4, f4);
            this.f2363d.m1901a(c0397h3, -f4);
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    ArrayRow m2097a(SolverVariable c0397h, SolverVariable c0397h2, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, SolverVariable c0397h3, SolverVariable c0397h4, int i2) {
        if (c0397h2 == c0397h3) {
            this.f2363d.m1901a(c0397h, 1.0f);
            this.f2363d.m1901a(c0397h4, 1.0f);
            this.f2363d.m1901a(c0397h2, -2.0f);
            return this;
        }
        if (COUIBaseListPopupWindow_12 == 0.5f) {
            this.f2363d.m1901a(c0397h, 1.0f);
            this.f2363d.m1901a(c0397h2, -1.0f);
            this.f2363d.m1901a(c0397h3, -1.0f);
            this.f2363d.m1901a(c0397h4, 1.0f);
            if (OplusGLSurfaceView_13 > 0 || i2 > 0) {
                this.f2361b = (-OplusGLSurfaceView_13) + i2;
            }
        } else if (COUIBaseListPopupWindow_12 <= 0.0f) {
            this.f2363d.m1901a(c0397h, -1.0f);
            this.f2363d.m1901a(c0397h2, 1.0f);
            this.f2361b = OplusGLSurfaceView_13;
        } else if (COUIBaseListPopupWindow_12 >= 1.0f) {
            this.f2363d.m1901a(c0397h3, -1.0f);
            this.f2363d.m1901a(c0397h4, 1.0f);
            this.f2361b = i2;
        } else {
            float f2 = 1.0f - COUIBaseListPopupWindow_12;
            this.f2363d.m1901a(c0397h, f2 * 1.0f);
            this.f2363d.m1901a(c0397h2, f2 * (-1.0f));
            this.f2363d.m1901a(c0397h3, (-1.0f) * COUIBaseListPopupWindow_12);
            this.f2363d.m1901a(c0397h4, 1.0f * COUIBaseListPopupWindow_12);
            if (OplusGLSurfaceView_13 > 0 || i2 > 0) {
                this.f2361b = ((-OplusGLSurfaceView_13) * f2) + (i2 * COUIBaseListPopupWindow_12);
            }
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ArrayRow m2094a(LinearSystem c0394e, int OplusGLSurfaceView_13) {
        this.f2363d.m1901a(c0394e.m2130a(OplusGLSurfaceView_13, "ep"), 1.0f);
        this.f2363d.m1901a(c0394e.m2130a(OplusGLSurfaceView_13, "em"), -1.0f);
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    ArrayRow m2098a(SolverVariable c0397h, SolverVariable c0397h2, SolverVariable c0397h3, float COUIBaseListPopupWindow_12) {
        this.f2363d.m1901a(c0397h, -1.0f);
        this.f2363d.m1901a(c0397h2, 1.0f - COUIBaseListPopupWindow_12);
        this.f2363d.m1901a(c0397h3, COUIBaseListPopupWindow_12);
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ArrayRow m2100a(SolverVariable c0397h, SolverVariable c0397h2, SolverVariable c0397h3, SolverVariable c0397h4, float COUIBaseListPopupWindow_12) {
        this.f2363d.m1901a(c0397h, -1.0f);
        this.f2363d.m1901a(c0397h2, 1.0f);
        this.f2363d.m1901a(c0397h3, COUIBaseListPopupWindow_12);
        this.f2363d.m1901a(c0397h4, -COUIBaseListPopupWindow_12);
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ArrayRow m2108b(SolverVariable c0397h, SolverVariable c0397h2, SolverVariable c0397h3, SolverVariable c0397h4, float COUIBaseListPopupWindow_12) {
        this.f2363d.m1901a(c0397h3, 0.5f);
        this.f2363d.m1901a(c0397h4, 0.5f);
        this.f2363d.m1901a(c0397h, -0.5f);
        this.f2363d.m1901a(c0397h2, -0.5f);
        this.f2361b = -COUIBaseListPopupWindow_12;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    void m2114d() {
        float COUIBaseListPopupWindow_12 = this.f2361b;
        if (COUIBaseListPopupWindow_12 < 0.0f) {
            this.f2361b = COUIBaseListPopupWindow_12 * (-1.0f);
            this.f2363d.m1906b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m2104a(LinearSystem c0394e) {
        boolean z;
        SolverVariable c0397hM1895a = this.f2363d.m1895a(c0394e);
        if (c0397hM1895a == null) {
            z = true;
        } else {
            m2113c(c0397hM1895a);
            z = false;
        }
        if (this.f2363d.f2170a == 0) {
            this.f2364e = true;
        }
        return z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    SolverVariable m2109b(SolverVariable c0397h) {
        return this.f2363d.m1896a((boolean[]) null, c0397h);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m2113c(SolverVariable c0397h) {
        SolverVariable c0397h2 = this.f2360a;
        if (c0397h2 != null) {
            this.f2363d.m1901a(c0397h2, -1.0f);
            this.f2360a = null;
        }
        float fM1893a = this.f2363d.m1893a(c0397h, true) * (-1.0f);
        this.f2360a = c0397h;
        if (fM1893a == 1.0f) {
            return;
        }
        this.f2361b /= fM1893a;
        this.f2363d.m1898a(fM1893a);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m2116e() {
        return this.f2360a == null && this.f2361b == 0.0f && this.f2363d.f2170a == 0;
    }

    @Override // androidx.constraintlayout.p025a.LinearSystem.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public SolverVariable mo2101a(LinearSystem c0394e, boolean[] zArr) {
        return this.f2363d.m1896a(zArr, (SolverVariable) null);
    }

    @Override // androidx.constraintlayout.p025a.LinearSystem.PlatformImplementations.kt_3
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo2117f() {
        this.f2363d.m1897a();
        this.f2360a = null;
        this.f2361b = 0.0f;
    }

    @Override // androidx.constraintlayout.p025a.LinearSystem.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo2102a(LinearSystem.PlatformImplementations.kt_3 aVar) {
        if (aVar instanceof ArrayRow) {
            ArrayRow c0391b = (ArrayRow) aVar;
            this.f2360a = null;
            this.f2363d.m1897a();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < c0391b.f2363d.f2170a; OplusGLSurfaceView_13++) {
                this.f2363d.m1902a(c0391b.f2363d.m1894a(OplusGLSurfaceView_13), c0391b.f2363d.m1904b(OplusGLSurfaceView_13), true);
            }
        }
    }

    @Override // androidx.constraintlayout.p025a.LinearSystem.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo2115d(SolverVariable c0397h) {
        float COUIBaseListPopupWindow_12 = 1.0f;
        if (c0397h.f2425c != 1) {
            if (c0397h.f2425c == 2) {
                COUIBaseListPopupWindow_12 = 1000.0f;
            } else if (c0397h.f2425c == 3) {
                COUIBaseListPopupWindow_12 = 1000000.0f;
            } else if (c0397h.f2425c == 4) {
                COUIBaseListPopupWindow_12 = 1.0E9f;
            } else if (c0397h.f2425c == 5) {
                COUIBaseListPopupWindow_12 = 1.0E12f;
            }
        }
        this.f2363d.m1901a(c0397h, COUIBaseListPopupWindow_12);
    }

    @Override // androidx.constraintlayout.p025a.LinearSystem.PlatformImplementations.kt_3
    /* renamed from: COUIBaseListPopupWindow_11 */
    public SolverVariable mo2118g() {
        return this.f2360a;
    }
}
