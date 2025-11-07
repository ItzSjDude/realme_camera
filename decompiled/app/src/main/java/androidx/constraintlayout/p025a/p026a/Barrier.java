package androidx.constraintlayout.p025a.p026a;

import androidx.constraintlayout.p025a.LinearSystem;
import androidx.constraintlayout.p025a.SolverVariable;
import androidx.constraintlayout.p025a.p026a.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: Barrier.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class Barrier extends Helper {

    /* renamed from: ak */
    private int f2181ak = 0;

    /* renamed from: al */
    private ArrayList<ResolutionAnchor> f2182al = new ArrayList<>(4);

    /* renamed from: am */
    private boolean f2183am = true;

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo1922a() {
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1919a(int OplusGLSurfaceView_13) {
        this.f2181ak = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1921a(boolean z) {
        this.f2183am = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m1924b() {
        return this.f2183am;
    }

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo1925c() {
        super.mo1925c();
        this.f2182al.clear();
    }

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1923b(int OplusGLSurfaceView_13) {
        ResolutionAnchor c0386mM1932a;
        ResolutionAnchor c0386mM1932a2;
        if (this.f2216D != null && ((ConstraintWidgetContainer) this.f2216D).m2046u(2)) {
            int i2 = this.f2181ak;
            if (i2 == 0) {
                c0386mM1932a = this.f2277s.m1932a();
            } else if (i2 == 1) {
                c0386mM1932a = this.f2279u.m1932a();
            } else if (i2 == 2) {
                c0386mM1932a = this.f2278t.m1932a();
            } else if (i2 != 3) {
                return;
            } else {
                c0386mM1932a = this.f2280v.m1932a();
            }
            c0386mM1932a.m2074b(5);
            int i3 = this.f2181ak;
            if (i3 == 0 || i3 == 1) {
                this.f2278t.m1932a().m2069a((ResolutionAnchor) null, 0.0f);
                this.f2280v.m1932a().m2069a((ResolutionAnchor) null, 0.0f);
            } else {
                this.f2277s.m1932a().m2069a((ResolutionAnchor) null, 0.0f);
                this.f2279u.m1932a().m2069a((ResolutionAnchor) null, 0.0f);
            }
            this.f2182al.clear();
            for (int i4 = 0; i4 < this.f2331aj; i4++) {
                ConstraintWidget c0379f = this.f2330ai[i4];
                if (this.f2183am || c0379f.mo1922a()) {
                    int i5 = this.f2181ak;
                    if (i5 == 0) {
                        c0386mM1932a2 = c0379f.f2277s.m1932a();
                    } else if (i5 == 1) {
                        c0386mM1932a2 = c0379f.f2279u.m1932a();
                    } else if (i5 == 2) {
                        c0386mM1932a2 = c0379f.f2278t.m1932a();
                    } else {
                        c0386mM1932a2 = i5 != 3 ? null : c0379f.f2280v.m1932a();
                    }
                    if (c0386mM1932a2 != null) {
                        this.f2182al.add(c0386mM1932a2);
                        c0386mM1932a2.m2081a(c0386mM1932a);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo1926d() {
        ResolutionAnchor c0386mM1932a;
        int OplusGLSurfaceView_13 = this.f2181ak;
        float COUIBaseListPopupWindow_12 = Float.MAX_VALUE;
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 == 1) {
                c0386mM1932a = this.f2279u.m1932a();
            } else if (OplusGLSurfaceView_13 == 2) {
                c0386mM1932a = this.f2278t.m1932a();
            } else if (OplusGLSurfaceView_13 != 3) {
                return;
            } else {
                c0386mM1932a = this.f2280v.m1932a();
            }
            COUIBaseListPopupWindow_12 = 0.0f;
        } else {
            c0386mM1932a = this.f2277s.m1932a();
        }
        int size = this.f2182al.size();
        ResolutionAnchor c0386m = null;
        for (int i2 = 0; i2 < size; i2++) {
            ResolutionAnchor c0386m2 = this.f2182al.get(i2);
            if (c0386m2.f2348i != 1) {
                return;
            }
            int i3 = this.f2181ak;
            if (i3 == 0 || i3 == 2) {
                if (c0386m2.f2338f < COUIBaseListPopupWindow_12) {
                    COUIBaseListPopupWindow_12 = c0386m2.f2338f;
                    c0386m = c0386m2.f2337e;
                }
            } else if (c0386m2.f2338f > COUIBaseListPopupWindow_12) {
                COUIBaseListPopupWindow_12 = c0386m2.f2338f;
                c0386m = c0386m2.f2337e;
            }
        }
        if (LinearSystem.m2121a() != null) {
            LinearSystem.m2121a().f2415z++;
        }
        c0386mM1932a.f2337e = c0386m;
        c0386mM1932a.f2338f = COUIBaseListPopupWindow_12;
        c0386mM1932a.m2083f();
        int i4 = this.f2181ak;
        if (i4 == 0) {
            this.f2279u.m1932a().m2069a(c0386m, COUIBaseListPopupWindow_12);
            return;
        }
        if (i4 == 1) {
            this.f2277s.m1932a().m2069a(c0386m, COUIBaseListPopupWindow_12);
        } else if (i4 == 2) {
            this.f2280v.m1932a().m2069a(c0386m, COUIBaseListPopupWindow_12);
        } else {
            if (i4 != 3) {
                return;
            }
            this.f2278t.m1932a().m2069a(c0386m, COUIBaseListPopupWindow_12);
        }
    }

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1920a(LinearSystem c0394e) {
        boolean z;
        int OplusGLSurfaceView_13;
        int i2;
        this.f2213A[0] = this.f2277s;
        this.f2213A[2] = this.f2278t;
        this.f2213A[1] = this.f2279u;
        this.f2213A[3] = this.f2280v;
        for (int i3 = 0; i3 < this.f2213A.length; i3++) {
            this.f2213A[i3].f2206f = c0394e.m2131a(this.f2213A[i3]);
        }
        int i4 = this.f2181ak;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        ConstraintAnchor c0378e = this.f2213A[this.f2181ak];
        for (int i5 = 0; i5 < this.f2331aj; i5++) {
            ConstraintWidget c0379f = this.f2330ai[i5];
            if ((this.f2183am || c0379f.mo1922a()) && ((((OplusGLSurfaceView_13 = this.f2181ak) == 0 || OplusGLSurfaceView_13 == 1) && c0379f.m1955G() == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT) || (((i2 = this.f2181ak) == 2 || i2 == 3) && c0379f.m1956H() == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT))) {
                z = true;
                break;
            }
        }
        z = false;
        int i6 = this.f2181ak;
        if (i6 == 0 || i6 == 1 ? m2003l().m1955G() == ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT : m2003l().m1956H() == ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT) {
            z = false;
        }
        for (int i7 = 0; i7 < this.f2331aj; i7++) {
            ConstraintWidget c0379f2 = this.f2330ai[i7];
            if (this.f2183am || c0379f2.mo1922a()) {
                SolverVariable c0397hM2131a = c0394e.m2131a(c0379f2.f2213A[this.f2181ak]);
                ConstraintAnchor[] c0378eArr = c0379f2.f2213A;
                int i8 = this.f2181ak;
                c0378eArr[i8].f2206f = c0397hM2131a;
                if (i8 == 0 || i8 == 2) {
                    c0394e.m2144b(c0378e.f2206f, c0397hM2131a, z);
                } else {
                    c0394e.m2140a(c0378e.f2206f, c0397hM2131a, z);
                }
            }
        }
        int i9 = this.f2181ak;
        if (i9 == 0) {
            c0394e.m2146c(this.f2279u.f2206f, this.f2277s.f2206f, 0, 6);
            if (z) {
                return;
            }
            c0394e.m2146c(this.f2277s.f2206f, this.f2216D.f2279u.f2206f, 0, 5);
            return;
        }
        if (i9 == 1) {
            c0394e.m2146c(this.f2277s.f2206f, this.f2279u.f2206f, 0, 6);
            if (z) {
                return;
            }
            c0394e.m2146c(this.f2277s.f2206f, this.f2216D.f2277s.f2206f, 0, 5);
            return;
        }
        if (i9 == 2) {
            c0394e.m2146c(this.f2280v.f2206f, this.f2278t.f2206f, 0, 6);
            if (z) {
                return;
            }
            c0394e.m2146c(this.f2278t.f2206f, this.f2216D.f2280v.f2206f, 0, 5);
            return;
        }
        if (i9 == 3) {
            c0394e.m2146c(this.f2278t.f2206f, this.f2280v.f2206f, 0, 6);
            if (z) {
                return;
            }
            c0394e.m2146c(this.f2278t.f2206f, this.f2216D.f2278t.f2206f, 0, 5);
        }
    }
}
