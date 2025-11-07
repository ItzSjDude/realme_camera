package androidx.constraintlayout.p025a.p026a;

import androidx.constraintlayout.p025a.p026a.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: ChainHead.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class ChainHead {

    /* renamed from: PlatformImplementations.kt_3 */
    protected ConstraintWidget f2184a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected ConstraintWidget f2185b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected ConstraintWidget f2186c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected ConstraintWidget f2187d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected ConstraintWidget f2188e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected ConstraintWidget f2189f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected ConstraintWidget f2190g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected ArrayList<ConstraintWidget> f2191h;

    /* renamed from: OplusGLSurfaceView_13 */
    protected int f2192i;

    /* renamed from: OplusGLSurfaceView_15 */
    protected int f2193j;

    /* renamed from: OplusGLSurfaceView_5 */
    protected float f2194k = 0.0f;

    /* renamed from: OplusGLSurfaceView_14 */
    protected boolean f2195l;

    /* renamed from: OplusGLSurfaceView_6 */
    protected boolean f2196m;

    /* renamed from: OplusGLSurfaceView_11 */
    protected boolean f2197n;

    /* renamed from: o */
    private int f2198o;

    /* renamed from: p */
    private boolean f2199p;

    /* renamed from: q */
    private boolean f2200q;

    public ChainHead(ConstraintWidget c0379f, int OplusGLSurfaceView_13, boolean z) {
        this.f2199p = false;
        this.f2184a = c0379f;
        this.f2198o = OplusGLSurfaceView_13;
        this.f2199p = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m1929a(ConstraintWidget c0379f, int OplusGLSurfaceView_13) {
        return c0379f.m2005m() != 8 && c0379f.f2215C[OplusGLSurfaceView_13] == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT && (c0379f.f2265g[OplusGLSurfaceView_13] == 0 || c0379f.f2265g[OplusGLSurfaceView_13] == 3);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1930b() {
        int OplusGLSurfaceView_13 = this.f2198o * 2;
        boolean z = false;
        ConstraintWidget c0379f = this.f2184a;
        ConstraintWidget c0379f2 = c0379f;
        boolean z2 = false;
        while (!z2) {
            this.f2192i++;
            ConstraintWidget c0379f3 = null;
            c0379f.f2244af[this.f2198o] = null;
            c0379f.f2243ae[this.f2198o] = null;
            if (c0379f.m2005m() != 8) {
                if (this.f2185b == null) {
                    this.f2185b = c0379f;
                }
                this.f2187d = c0379f;
                if (c0379f.f2215C[this.f2198o] == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT && (c0379f.f2265g[this.f2198o] == 0 || c0379f.f2265g[this.f2198o] == 3 || c0379f.f2265g[this.f2198o] == 2)) {
                    this.f2193j++;
                    float COUIBaseListPopupWindow_12 = c0379f.f2242ad[this.f2198o];
                    if (COUIBaseListPopupWindow_12 > 0.0f) {
                        this.f2194k += c0379f.f2242ad[this.f2198o];
                    }
                    if (m1929a(c0379f, this.f2198o)) {
                        if (COUIBaseListPopupWindow_12 < 0.0f) {
                            this.f2195l = true;
                        } else {
                            this.f2196m = true;
                        }
                        if (this.f2191h == null) {
                            this.f2191h = new ArrayList<>();
                        }
                        this.f2191h.add(c0379f);
                    }
                    if (this.f2189f == null) {
                        this.f2189f = c0379f;
                    }
                    ConstraintWidget c0379f4 = this.f2190g;
                    if (c0379f4 != null) {
                        c0379f4.f2243ae[this.f2198o] = c0379f;
                    }
                    this.f2190g = c0379f;
                }
            }
            if (c0379f2 != c0379f) {
                c0379f2.f2244af[this.f2198o] = c0379f;
            }
            ConstraintAnchor c0378e = c0379f.f2213A[OplusGLSurfaceView_13 + 1].f2203c;
            if (c0378e != null) {
                ConstraintWidget c0379f5 = c0378e.f2201a;
                if (c0379f5.f2213A[OplusGLSurfaceView_13].f2203c != null && c0379f5.f2213A[OplusGLSurfaceView_13].f2203c.f2201a == c0379f) {
                    c0379f3 = c0379f5;
                }
            }
            if (c0379f3 == null) {
                c0379f3 = c0379f;
                z2 = true;
            }
            c0379f2 = c0379f;
            c0379f = c0379f3;
        }
        this.f2186c = c0379f;
        if (this.f2198o == 0 && this.f2199p) {
            this.f2188e = this.f2186c;
        } else {
            this.f2188e = this.f2184a;
        }
        if (this.f2196m && this.f2195l) {
            z = true;
        }
        this.f2197n = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1931a() {
        if (!this.f2200q) {
            m1930b();
        }
        this.f2200q = true;
    }
}
