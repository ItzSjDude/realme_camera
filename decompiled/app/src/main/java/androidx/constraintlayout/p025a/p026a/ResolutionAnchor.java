package androidx.constraintlayout.p025a.p026a;

import androidx.constraintlayout.p025a.LinearSystem;
import androidx.constraintlayout.p025a.SolverVariable;
import androidx.constraintlayout.p025a.p026a.ConstraintAnchor;

/* compiled from: ResolutionAnchor.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public class ResolutionAnchor extends ResolutionNode {

    /* renamed from: PlatformImplementations.kt_3 */
    ConstraintAnchor f2333a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    float f2334b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    ResolutionAnchor f2335c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    float f2336d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    ResolutionAnchor f2337e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    float f2338f;

    /* renamed from: OplusGLSurfaceView_15 */
    private ResolutionAnchor f2340j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f2341k;

    /* renamed from: COUIBaseListPopupWindow_11 */
    int f2339g = 0;

    /* renamed from: OplusGLSurfaceView_14 */
    private ResolutionDimension f2342l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f2343m = 1;

    /* renamed from: OplusGLSurfaceView_11 */
    private ResolutionDimension f2344n = null;

    /* renamed from: o */
    private int f2345o = 1;

    /* renamed from: PlatformImplementations.kt_3 */
    String m2066a(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 1 ? "DIRECT" : OplusGLSurfaceView_13 == 2 ? "CENTER" : OplusGLSurfaceView_13 == 3 ? "MATCH" : OplusGLSurfaceView_13 == 4 ? "CHAIN" : OplusGLSurfaceView_13 == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public ResolutionAnchor(ConstraintAnchor c0378e) {
        this.f2333a = c0378e;
    }

    public String toString() {
        if (this.f2348i == 1) {
            if (this.f2337e == this) {
                return "[" + this.f2333a + ", RESOLVED: " + this.f2338f + "]  type: " + m2066a(this.f2339g);
            }
            return "[" + this.f2333a + ", RESOLVED: " + this.f2337e + ":" + this.f2338f + "] type: " + m2066a(this.f2339g);
        }
        return "{ " + this.f2333a + " UNRESOLVED} type: " + m2066a(this.f2339g);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2069a(ResolutionAnchor c0386m, float COUIBaseListPopupWindow_12) {
        if (this.f2348i == 0 || !(this.f2337e == c0386m || this.f2338f == COUIBaseListPopupWindow_12)) {
            this.f2337e = c0386m;
            this.f2338f = COUIBaseListPopupWindow_12;
            if (this.f2348i == 1) {
                m2082e();
            }
            m2083f();
        }
    }

    @Override // androidx.constraintlayout.p025a.p026a.ResolutionNode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo2067a() {
        ResolutionAnchor c0386m;
        ResolutionAnchor c0386m2;
        ResolutionAnchor c0386m3;
        ResolutionAnchor c0386m4;
        ResolutionAnchor c0386m5;
        ResolutionAnchor c0386m6;
        float COUIBaseListPopupWindow_12;
        float f2;
        float fM2013q;
        float f3;
        ResolutionAnchor c0386m7;
        boolean z = true;
        if (this.f2348i == 1 || this.f2339g == 4) {
            return;
        }
        ResolutionDimension c0387n = this.f2342l;
        if (c0387n != null) {
            if (c0387n.f2348i != 1) {
                return;
            } else {
                this.f2336d = this.f2343m * this.f2342l.f2346a;
            }
        }
        ResolutionDimension c0387n2 = this.f2344n;
        if (c0387n2 != null) {
            if (c0387n2.f2348i != 1) {
                return;
            } else {
                this.f2341k = this.f2345o * this.f2344n.f2346a;
            }
        }
        if (this.f2339g == 1 && ((c0386m7 = this.f2335c) == null || c0386m7.f2348i == 1)) {
            ResolutionAnchor c0386m8 = this.f2335c;
            if (c0386m8 == null) {
                this.f2337e = this;
                this.f2338f = this.f2336d;
            } else {
                this.f2337e = c0386m8.f2337e;
                this.f2338f = c0386m8.f2338f + this.f2336d;
            }
            m2083f();
            return;
        }
        if (this.f2339g == 2 && (c0386m4 = this.f2335c) != null && c0386m4.f2348i == 1 && (c0386m5 = this.f2340j) != null && (c0386m6 = c0386m5.f2335c) != null && c0386m6.f2348i == 1) {
            if (LinearSystem.m2121a() != null) {
                LinearSystem.m2121a().f2412w++;
            }
            this.f2337e = this.f2335c.f2337e;
            ResolutionAnchor c0386m9 = this.f2340j;
            c0386m9.f2337e = c0386m9.f2335c.f2337e;
            int OplusGLSurfaceView_13 = 0;
            if (this.f2333a.f2202b != ConstraintAnchor.IntrinsicsJvm.kt_3.RIGHT && this.f2333a.f2202b != ConstraintAnchor.IntrinsicsJvm.kt_3.BOTTOM) {
                z = false;
            }
            if (z) {
                COUIBaseListPopupWindow_12 = this.f2335c.f2338f;
                f2 = this.f2340j.f2335c.f2338f;
            } else {
                COUIBaseListPopupWindow_12 = this.f2340j.f2335c.f2338f;
                f2 = this.f2335c.f2338f;
            }
            float f4 = COUIBaseListPopupWindow_12 - f2;
            if (this.f2333a.f2202b == ConstraintAnchor.IntrinsicsJvm.kt_3.LEFT || this.f2333a.f2202b == ConstraintAnchor.IntrinsicsJvm.kt_3.RIGHT) {
                fM2013q = f4 - this.f2333a.f2201a.m2013q();
                f3 = this.f2333a.f2201a.f2230S;
            } else {
                fM2013q = f4 - this.f2333a.f2201a.m2017s();
                f3 = this.f2333a.f2201a.f2231T;
            }
            int iM1940e = this.f2333a.m1940e();
            int iM1940e2 = this.f2340j.f2333a.m1940e();
            if (this.f2333a.m1942g() == this.f2340j.f2333a.m1942g()) {
                f3 = 0.5f;
                iM1940e2 = 0;
            } else {
                OplusGLSurfaceView_13 = iM1940e;
            }
            float f5 = OplusGLSurfaceView_13;
            float f6 = iM1940e2;
            float f7 = (fM2013q - f5) - f6;
            if (z) {
                ResolutionAnchor c0386m10 = this.f2340j;
                c0386m10.f2338f = c0386m10.f2335c.f2338f + f6 + (f7 * f3);
                this.f2338f = (this.f2335c.f2338f - f5) - (f7 * (1.0f - f3));
            } else {
                this.f2338f = this.f2335c.f2338f + f5 + (f7 * f3);
                ResolutionAnchor c0386m11 = this.f2340j;
                c0386m11.f2338f = (c0386m11.f2335c.f2338f - f6) - (f7 * (1.0f - f3));
            }
            m2083f();
            this.f2340j.m2083f();
            return;
        }
        if (this.f2339g == 3 && (c0386m = this.f2335c) != null && c0386m.f2348i == 1 && (c0386m2 = this.f2340j) != null && (c0386m3 = c0386m2.f2335c) != null && c0386m3.f2348i == 1) {
            if (LinearSystem.m2121a() != null) {
                LinearSystem.m2121a().f2413x++;
            }
            ResolutionAnchor c0386m12 = this.f2335c;
            this.f2337e = c0386m12.f2337e;
            ResolutionAnchor c0386m13 = this.f2340j;
            ResolutionAnchor c0386m14 = c0386m13.f2335c;
            c0386m13.f2337e = c0386m14.f2337e;
            this.f2338f = c0386m12.f2338f + this.f2336d;
            c0386m13.f2338f = c0386m14.f2338f + c0386m13.f2336d;
            m2083f();
            this.f2340j.m2083f();
            return;
        }
        if (this.f2339g == 5) {
            this.f2333a.f2201a.mo1926d();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2074b(int OplusGLSurfaceView_13) {
        this.f2339g = OplusGLSurfaceView_13;
    }

    @Override // androidx.constraintlayout.p025a.p026a.ResolutionNode
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo2073b() {
        super.mo2073b();
        this.f2335c = null;
        this.f2336d = 0.0f;
        this.f2342l = null;
        this.f2343m = 1;
        this.f2344n = null;
        this.f2345o = 1;
        this.f2337e = null;
        this.f2338f = 0.0f;
        this.f2334b = 0.0f;
        this.f2340j = null;
        this.f2341k = 0.0f;
        this.f2339g = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m2077c() {
        ConstraintAnchor c0378eM1942g = this.f2333a.m1942g();
        if (c0378eM1942g == null) {
            return;
        }
        if (c0378eM1942g.m1942g() == this.f2333a) {
            this.f2339g = 4;
            c0378eM1942g.m1932a().f2339g = 4;
        }
        int iM1940e = this.f2333a.m1940e();
        if (this.f2333a.f2202b == ConstraintAnchor.IntrinsicsJvm.kt_3.RIGHT || this.f2333a.f2202b == ConstraintAnchor.IntrinsicsJvm.kt_3.BOTTOM) {
            iM1940e = -iM1940e;
        }
        m2070a(c0378eM1942g.m1932a(), iM1940e);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2068a(int OplusGLSurfaceView_13, ResolutionAnchor c0386m, int i2) {
        this.f2339g = OplusGLSurfaceView_13;
        this.f2335c = c0386m;
        this.f2336d = i2;
        this.f2335c.m2081a(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2070a(ResolutionAnchor c0386m, int OplusGLSurfaceView_13) {
        this.f2335c = c0386m;
        this.f2336d = OplusGLSurfaceView_13;
        this.f2335c.m2081a(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2071a(ResolutionAnchor c0386m, int OplusGLSurfaceView_13, ResolutionDimension c0387n) {
        this.f2335c = c0386m;
        this.f2335c.m2081a(this);
        this.f2342l = c0387n;
        this.f2343m = OplusGLSurfaceView_13;
        this.f2342l.m2081a(this);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2075b(ResolutionAnchor c0386m, float COUIBaseListPopupWindow_12) {
        this.f2340j = c0386m;
        this.f2341k = COUIBaseListPopupWindow_12;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2076b(ResolutionAnchor c0386m, int OplusGLSurfaceView_13, ResolutionDimension c0387n) {
        this.f2340j = c0386m;
        this.f2344n = c0387n;
        this.f2345o = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m2072a(LinearSystem c0394e) {
        SolverVariable c0397hM1937b = this.f2333a.m1937b();
        ResolutionAnchor c0386m = this.f2337e;
        if (c0386m == null) {
            c0394e.m2136a(c0397hM1937b, (int) (this.f2338f + 0.5f));
        } else {
            c0394e.m2146c(c0397hM1937b, c0394e.m2131a(c0386m.f2333a), (int) (this.f2338f + 0.5f), 6);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float m2078d() {
        return this.f2338f;
    }
}
