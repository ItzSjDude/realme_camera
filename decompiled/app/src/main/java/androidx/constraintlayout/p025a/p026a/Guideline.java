package androidx.constraintlayout.p025a.p026a;

import androidx.constraintlayout.p025a.LinearSystem;
import androidx.constraintlayout.p025a.SolverVariable;
import androidx.constraintlayout.p025a.p026a.ConstraintAnchor;
import androidx.constraintlayout.p025a.p026a.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: Guideline.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class Guideline extends ConstraintWidget {

    /* renamed from: ai */
    protected float f2320ai = -1.0f;

    /* renamed from: aj */
    protected int f2321aj = -1;

    /* renamed from: ak */
    protected int f2322ak = -1;

    /* renamed from: al */
    private ConstraintAnchor f2323al = this.f2278t;

    /* renamed from: am */
    private int f2324am = 0;

    /* renamed from: an */
    private boolean f2325an = false;

    /* renamed from: ao */
    private int f2326ao = 0;

    /* renamed from: ap */
    private Rectangle f2327ap = new Rectangle();

    /* renamed from: aq */
    private int f2328aq = 8;

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo1922a() {
        return true;
    }

    public Guideline() {
        this.f2214B.clear();
        this.f2214B.add(this.f2323al);
        int length = this.f2213A.length;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            this.f2213A[OplusGLSurfaceView_13] = this.f2323al;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2054a(int OplusGLSurfaceView_13) {
        if (this.f2324am == OplusGLSurfaceView_13) {
            return;
        }
        this.f2324am = OplusGLSurfaceView_13;
        this.f2214B.clear();
        if (this.f2324am == 1) {
            this.f2323al = this.f2277s;
        } else {
            this.f2323al = this.f2278t;
        }
        this.f2214B.add(this.f2323al);
        int length = this.f2213A.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f2213A[i2] = this.f2323al;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m2055b() {
        return this.f2324am;
    }

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: PlatformImplementations.kt_3 */
    public ConstraintAnchor mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3 cVar) {
        switch (cVar) {
            case LEFT:
            case RIGHT:
                if (this.f2324am == 1) {
                    return this.f2323al;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.f2324am == 0) {
                    return this.f2323al;
                }
                break;
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
        }
        throw new AssertionError(cVar.name());
    }

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: D */
    public ArrayList<ConstraintAnchor> mo1952D() {
        return this.f2214B;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m2056e(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 > -1.0f) {
            this.f2320ai = COUIBaseListPopupWindow_12;
            this.f2321aj = -1;
            this.f2322ak = -1;
        }
    }

    /* renamed from: u */
    public void m2057u(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 > -1) {
            this.f2320ai = -1.0f;
            this.f2321aj = OplusGLSurfaceView_13;
            this.f2322ak = -1;
        }
    }

    /* renamed from: v */
    public void m2058v(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 > -1) {
            this.f2320ai = -1.0f;
            this.f2321aj = -1;
            this.f2322ak = OplusGLSurfaceView_13;
        }
    }

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1923b(int OplusGLSurfaceView_13) {
        ConstraintWidget c0379fL = m2003l();
        if (c0379fL == null) {
            return;
        }
        if (m2055b() == 1) {
            this.f2278t.m1932a().m2068a(1, c0379fL.f2278t.m1932a(), 0);
            this.f2280v.m1932a().m2068a(1, c0379fL.f2278t.m1932a(), 0);
            if (this.f2321aj != -1) {
                this.f2277s.m1932a().m2068a(1, c0379fL.f2277s.m1932a(), this.f2321aj);
                this.f2279u.m1932a().m2068a(1, c0379fL.f2277s.m1932a(), this.f2321aj);
                return;
            } else if (this.f2322ak != -1) {
                this.f2277s.m1932a().m2068a(1, c0379fL.f2279u.m1932a(), -this.f2322ak);
                this.f2279u.m1932a().m2068a(1, c0379fL.f2279u.m1932a(), -this.f2322ak);
                return;
            } else {
                if (this.f2320ai == -1.0f || c0379fL.m1955G() != ConstraintWidget.PlatformImplementations.kt_3.FIXED) {
                    return;
                }
                int i2 = (int) (c0379fL.f2217E * this.f2320ai);
                this.f2277s.m1932a().m2068a(1, c0379fL.f2277s.m1932a(), i2);
                this.f2279u.m1932a().m2068a(1, c0379fL.f2277s.m1932a(), i2);
                return;
            }
        }
        this.f2277s.m1932a().m2068a(1, c0379fL.f2277s.m1932a(), 0);
        this.f2279u.m1932a().m2068a(1, c0379fL.f2277s.m1932a(), 0);
        if (this.f2321aj != -1) {
            this.f2278t.m1932a().m2068a(1, c0379fL.f2278t.m1932a(), this.f2321aj);
            this.f2280v.m1932a().m2068a(1, c0379fL.f2278t.m1932a(), this.f2321aj);
        } else if (this.f2322ak != -1) {
            this.f2278t.m1932a().m2068a(1, c0379fL.f2280v.m1932a(), -this.f2322ak);
            this.f2280v.m1932a().m2068a(1, c0379fL.f2280v.m1932a(), -this.f2322ak);
        } else {
            if (this.f2320ai == -1.0f || c0379fL.m1956H() != ConstraintWidget.PlatformImplementations.kt_3.FIXED) {
                return;
            }
            int i3 = (int) (c0379fL.f2218F * this.f2320ai);
            this.f2278t.m1932a().m2068a(1, c0379fL.f2278t.m1932a(), i3);
            this.f2280v.m1932a().m2068a(1, c0379fL.f2278t.m1932a(), i3);
        }
    }

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1920a(LinearSystem c0394e) {
        ConstraintWidgetContainer c0380g = (ConstraintWidgetContainer) m2003l();
        if (c0380g == null) {
            return;
        }
        ConstraintAnchor c0378eA = c0380g.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.LEFT);
        ConstraintAnchor c0378eA2 = c0380g.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.RIGHT);
        boolean z = this.f2216D != null && this.f2216D.f2215C[0] == ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT;
        if (this.f2324am == 0) {
            c0378eA = c0380g.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.TOP);
            c0378eA2 = c0380g.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.BOTTOM);
            z = this.f2216D != null && this.f2216D.f2215C[1] == ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT;
        }
        if (this.f2321aj != -1) {
            SolverVariable c0397hM2131a = c0394e.m2131a(this.f2323al);
            c0394e.m2146c(c0397hM2131a, c0394e.m2131a(c0378eA), this.f2321aj, 6);
            if (z) {
                c0394e.m2138a(c0394e.m2131a(c0378eA2), c0397hM2131a, 0, 5);
                return;
            }
            return;
        }
        if (this.f2322ak == -1) {
            if (this.f2320ai != -1.0f) {
                c0394e.m2133a(LinearSystem.m2120a(c0394e, c0394e.m2131a(this.f2323al), c0394e.m2131a(c0378eA), c0394e.m2131a(c0378eA2), this.f2320ai, this.f2325an));
                return;
            }
            return;
        }
        SolverVariable c0397hM2131a2 = c0394e.m2131a(this.f2323al);
        SolverVariable c0397hM2131a3 = c0394e.m2131a(c0378eA2);
        c0394e.m2146c(c0397hM2131a2, c0397hM2131a3, -this.f2322ak, 6);
        if (z) {
            c0394e.m2138a(c0397hM2131a2, c0394e.m2131a(c0378eA), 0, 5);
            c0394e.m2138a(c0397hM2131a3, c0397hM2131a2, 0, 5);
        }
    }

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo1983c(LinearSystem c0394e) {
        if (m2003l() == null) {
            return;
        }
        int iM2141b = c0394e.m2141b(this.f2323al);
        if (this.f2324am == 1) {
            m1996h(iM2141b);
            m1997i(0);
            m2002k(m2003l().m2017s());
            m2000j(0);
            return;
        }
        m1996h(0);
        m1997i(iM2141b);
        m2000j(m2003l().m2013q());
        m2002k(0);
    }
}
