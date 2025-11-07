package androidx.constraintlayout.p025a.p026a;

import androidx.constraintlayout.p025a.Cache;
import androidx.constraintlayout.p025a.SolverVariable;

/* compiled from: ConstraintAnchor.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class ConstraintAnchor {

    /* renamed from: PlatformImplementations.kt_3 */
    final ConstraintWidget f2201a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final IntrinsicsJvm.kt_3 f2202b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    ConstraintAnchor f2203c;

    /* renamed from: COUIBaseListPopupWindow_12 */
    SolverVariable f2206f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ResolutionAnchor f2207g = new ResolutionAnchor(this);

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int f2204d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    int f2205e = -1;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private IntrinsicsJvm.kt_4 f2208h = IntrinsicsJvm.kt_4.NONE;

    /* renamed from: OplusGLSurfaceView_13 */
    private PlatformImplementations.kt_3 f2209i = PlatformImplementations.kt_3.RELAXED;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f2210j = 0;

    /* compiled from: ConstraintAnchor.java */
    /* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        RELAXED,
        STRICT
    }

    /* compiled from: ConstraintAnchor.java */
    /* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    public enum IntrinsicsJvm.kt_4 {
        NONE,
        STRONG,
        WEAK
    }

    /* compiled from: ConstraintAnchor.java */
    /* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_3 */
    public enum IntrinsicsJvm.kt_3 {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ResolutionAnchor m1932a() {
        return this.f2207g;
    }

    public ConstraintAnchor(ConstraintWidget c0379f, IntrinsicsJvm.kt_3 cVar) {
        this.f2201a = c0379f;
        this.f2202b = cVar;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public SolverVariable m1937b() {
        return this.f2206f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1933a(Cache c0392c) {
        SolverVariable c0397h = this.f2206f;
        if (c0397h == null) {
            this.f2206f = new SolverVariable(SolverVariable.PlatformImplementations.kt_3.UNRESTRICTED, null);
        } else {
            c0397h.m2157b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ConstraintWidget m1938c() {
        return this.f2201a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public IntrinsicsJvm.kt_3 m1939d() {
        return this.f2202b;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m1940e() {
        ConstraintAnchor c0378e;
        if (this.f2201a.m2005m() == 8) {
            return 0;
        }
        if (this.f2205e > -1 && (c0378e = this.f2203c) != null && c0378e.f2201a.m2005m() == 8) {
            return this.f2205e;
        }
        return this.f2204d;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public IntrinsicsJvm.kt_4 m1941f() {
        return this.f2208h;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public ConstraintAnchor m1942g() {
        return this.f2203c;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public int m1943h() {
        return this.f2210j;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m1944i() {
        this.f2203c = null;
        this.f2204d = 0;
        this.f2205e = -1;
        this.f2208h = IntrinsicsJvm.kt_4.STRONG;
        this.f2210j = 0;
        this.f2209i = PlatformImplementations.kt_3.RELAXED;
        this.f2207g.mo2073b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m1936a(ConstraintAnchor c0378e, int OplusGLSurfaceView_13, IntrinsicsJvm.kt_4 bVar, int i2) {
        return m1935a(c0378e, OplusGLSurfaceView_13, -1, bVar, i2, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m1935a(ConstraintAnchor c0378e, int OplusGLSurfaceView_13, int i2, IntrinsicsJvm.kt_4 bVar, int i3, boolean z) {
        if (c0378e == null) {
            this.f2203c = null;
            this.f2204d = 0;
            this.f2205e = -1;
            this.f2208h = IntrinsicsJvm.kt_4.NONE;
            this.f2210j = 2;
            return true;
        }
        if (!z && !m1934a(c0378e)) {
            return false;
        }
        this.f2203c = c0378e;
        if (OplusGLSurfaceView_13 > 0) {
            this.f2204d = OplusGLSurfaceView_13;
        } else {
            this.f2204d = 0;
        }
        this.f2205e = i2;
        this.f2208h = bVar;
        this.f2210j = i3;
        return true;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m1945j() {
        return this.f2203c != null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m1934a(ConstraintAnchor c0378e) {
        if (c0378e == null) {
            return false;
        }
        IntrinsicsJvm.kt_3 cVarM1939d = c0378e.m1939d();
        IntrinsicsJvm.kt_3 cVar = this.f2202b;
        if (cVarM1939d == cVar) {
            return cVar != IntrinsicsJvm.kt_3.BASELINE || (c0378e.m1938c().m1949A() && m1938c().m1949A());
        }
        switch (this.f2202b) {
            case CENTER:
                return (cVarM1939d == IntrinsicsJvm.kt_3.BASELINE || cVarM1939d == IntrinsicsJvm.kt_3.CENTER_X || cVarM1939d == IntrinsicsJvm.kt_3.CENTER_Y) ? false : true;
            case LEFT:
            case RIGHT:
                boolean z = cVarM1939d == IntrinsicsJvm.kt_3.LEFT || cVarM1939d == IntrinsicsJvm.kt_3.RIGHT;
                return c0378e.m1938c() instanceof Guideline ? z || cVarM1939d == IntrinsicsJvm.kt_3.CENTER_X : z;
            case TOP:
            case BOTTOM:
                boolean z2 = cVarM1939d == IntrinsicsJvm.kt_3.TOP || cVarM1939d == IntrinsicsJvm.kt_3.BOTTOM;
                return c0378e.m1938c() instanceof Guideline ? z2 || cVarM1939d == IntrinsicsJvm.kt_3.CENTER_Y : z2;
            case BASELINE:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return false;
            default:
                throw new AssertionError(this.f2202b.name());
        }
    }

    public String toString() {
        return this.f2201a.m2007n() + ":" + this.f2202b.toString();
    }
}
