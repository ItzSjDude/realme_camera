package androidx.constraintlayout.p025a.p026a;

import androidx.constraintlayout.p025a.LinearSystem;
import androidx.constraintlayout.p025a.p026a.ConstraintAnchor;
import androidx.constraintlayout.p025a.p026a.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ConstraintWidgetContainer.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {

    /* renamed from: aB */
    private Snapshot f2288aB;

    /* renamed from: aj */
    int f2293aj;

    /* renamed from: ak */
    int f2294ak;

    /* renamed from: al */
    int f2295al;

    /* renamed from: am */
    int f2296am;

    /* renamed from: aA */
    private boolean f2287aA = false;

    /* renamed from: ai */
    protected LinearSystem f2292ai = new LinearSystem();

    /* renamed from: an */
    int f2297an = 0;

    /* renamed from: ao */
    int f2298ao = 0;

    /* renamed from: ap */
    ChainHead[] f2299ap = new ChainHead[4];

    /* renamed from: aq */
    ChainHead[] f2300aq = new ChainHead[4];

    /* renamed from: ar */
    public List<ConstraintWidgetGroup> f2301ar = new ArrayList();

    /* renamed from: as */
    public boolean f2302as = false;

    /* renamed from: at */
    public boolean f2303at = false;

    /* renamed from: au */
    public boolean f2304au = false;

    /* renamed from: av */
    public int f2305av = 0;

    /* renamed from: aw */
    public int f2306aw = 0;

    /* renamed from: aC */
    private int f2289aC = 7;

    /* renamed from: ax */
    public boolean f2307ax = false;

    /* renamed from: aD */
    private boolean f2290aD = false;

    /* renamed from: aE */
    private boolean f2291aE = false;

    /* renamed from: ay */
    int f2308ay = 0;

    /* renamed from: S */
    public boolean m2038S() {
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2039a(int OplusGLSurfaceView_13) {
        this.f2289aC = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m2043b() {
        return this.f2289aC;
    }

    /* renamed from: u */
    public boolean m2046u(int OplusGLSurfaceView_13) {
        return (this.f2289aC & OplusGLSurfaceView_13) == OplusGLSurfaceView_13;
    }

    @Override // androidx.constraintlayout.p025a.p026a.WidgetContainer, androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo1994g() {
        this.f2292ai.m2142b();
        this.f2293aj = 0;
        this.f2295al = 0;
        this.f2294ak = 0;
        this.f2296am = 0;
        this.f2301ar.clear();
        this.f2307ax = false;
        super.mo1994g();
    }

    /* renamed from: K */
    public boolean m2030K() {
        return this.f2290aD;
    }

    /* renamed from: L */
    public boolean m2031L() {
        return this.f2291aE;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m2044d(LinearSystem c0394e) {
        mo1920a(c0394e);
        int size = this.f2359az.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            ConstraintWidget c0379f = this.f2359az.get(OplusGLSurfaceView_13);
            if (c0379f instanceof ConstraintWidgetContainer) {
                ConstraintWidget.PlatformImplementations.kt_3 aVar = c0379f.f2215C[0];
                ConstraintWidget.PlatformImplementations.kt_3 aVar2 = c0379f.f2215C[1];
                if (aVar == ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT) {
                    c0379f.m1966a(ConstraintWidget.PlatformImplementations.kt_3.FIXED);
                }
                if (aVar2 == ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT) {
                    c0379f.m1976b(ConstraintWidget.PlatformImplementations.kt_3.FIXED);
                }
                c0379f.mo1920a(c0394e);
                if (aVar == ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT) {
                    c0379f.m1966a(aVar);
                }
                if (aVar2 == ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT) {
                    c0379f.m1976b(aVar2);
                }
            } else {
                Optimizer.m2063a(this, c0394e, c0379f);
                c0379f.mo1920a(c0394e);
            }
        }
        if (this.f2297an > 0) {
            Chain.m1927a(this, c0394e, 0);
        }
        if (this.f2298ao > 0) {
            Chain.m1927a(this, c0394e, 1);
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2041a(LinearSystem c0394e, boolean[] zArr) {
        zArr[2] = false;
        mo1983c(c0394e);
        int size = this.f2359az.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            ConstraintWidget c0379f = this.f2359az.get(OplusGLSurfaceView_13);
            c0379f.mo1983c(c0394e);
            if (c0379f.f2215C[0] == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT && c0379f.m2013q() < c0379f.m2015r()) {
                zArr[2] = true;
            }
            if (c0379f.f2215C[1] == ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT && c0379f.m2017s() < c0379f.m2019t()) {
                zArr[2] = true;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2042a(boolean z) {
        this.f2287aA = z;
    }

    /* renamed from: M */
    public boolean m2032M() {
        return this.f2287aA;
    }

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1923b(int OplusGLSurfaceView_13) {
        super.mo1923b(OplusGLSurfaceView_13);
        int size = this.f2359az.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f2359az.get(i2).mo1923b(OplusGLSurfaceView_13);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02d3 A[PHI: r0 r9
      0x02d3: PHI (r0v36 boolean) = (r0v35 boolean), (r0v38 boolean), (r0v38 boolean), (r0v38 boolean) binds: [B:115:0x0294, B:123:0x02bb, B:124:0x02bd, B:126:0x02c3] A[DONT_GENERATE, DONT_INLINE]
      0x02d3: PHI (r9v15 boolean) = (r9v14 boolean), (r9v17 boolean), (r9v17 boolean), (r9v17 boolean) binds: [B:115:0x0294, B:123:0x02bb, B:124:0x02bd, B:126:0x02c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01dd  */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v22 */
    @Override // androidx.constraintlayout.p025a.p026a.WidgetContainer
    /* renamed from: N */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo2033N() {
        /*
            Method dump skipped, instructions count: 846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p025a.p026a.ConstraintWidgetContainer.mo2033N():void");
    }

    /* renamed from: O */
    public void m2034O() {
        m2036Q();
        mo1923b(this.f2289aC);
    }

    /* renamed from: P */
    public void m2035P() {
        ResolutionAnchor c0386mM1932a = mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.LEFT).m1932a();
        ResolutionAnchor c0386mM1932a2 = mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.TOP).m1932a();
        c0386mM1932a.m2069a((ResolutionAnchor) null, 0.0f);
        c0386mM1932a2.m2069a((ResolutionAnchor) null, 0.0f);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m2045f(int OplusGLSurfaceView_13, int i2) {
        if (this.f2215C[0] != ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT && this.f2261c != null) {
            this.f2261c.m2079a(OplusGLSurfaceView_13);
        }
        if (this.f2215C[1] == ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT || this.f2262d == null) {
            return;
        }
        this.f2262d.m2079a(i2);
    }

    /* renamed from: Q */
    public void m2036Q() {
        int size = this.f2359az.size();
        mo1925c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f2359az.get(OplusGLSurfaceView_13).mo1925c();
        }
    }

    /* renamed from: R */
    public void m2037R() {
        if (!m2046u(8)) {
            mo1923b(this.f2289aC);
        }
        m2035P();
    }

    /* renamed from: V */
    private void m2027V() {
        this.f2297an = 0;
        this.f2298ao = 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m2040a(ConstraintWidget c0379f, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            m2028d(c0379f);
        } else if (OplusGLSurfaceView_13 == 1) {
            m2029e(c0379f);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m2028d(ConstraintWidget c0379f) {
        int OplusGLSurfaceView_13 = this.f2297an + 1;
        ChainHead[] c0377dArr = this.f2300aq;
        if (OplusGLSurfaceView_13 >= c0377dArr.length) {
            this.f2300aq = (ChainHead[]) Arrays.copyOf(c0377dArr, c0377dArr.length * 2);
        }
        this.f2300aq[this.f2297an] = new ChainHead(c0379f, 0, m2032M());
        this.f2297an++;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m2029e(ConstraintWidget c0379f) {
        int OplusGLSurfaceView_13 = this.f2298ao + 1;
        ChainHead[] c0377dArr = this.f2299ap;
        if (OplusGLSurfaceView_13 >= c0377dArr.length) {
            this.f2299ap = (ChainHead[]) Arrays.copyOf(c0377dArr, c0377dArr.length * 2);
        }
        this.f2299ap[this.f2298ao] = new ChainHead(c0379f, 1, m2032M());
        this.f2298ao++;
    }
}
