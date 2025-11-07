package androidx.constraintlayout.p025a.p026a;

import androidx.constraintlayout.p025a.p026a.ConstraintAnchor;
import java.util.ArrayList;

/* compiled from: Snapshot.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.p */
/* loaded from: classes.dex */
public class Snapshot {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f2349a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f2350b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f2351c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f2352d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ArrayList<PlatformImplementations.kt_3> f2353e = new ArrayList<>();

    /* compiled from: Snapshot.java */
    /* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.p$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private ConstraintAnchor f2354a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private ConstraintAnchor f2355b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f2356c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private ConstraintAnchor.IntrinsicsJvm.kt_4 f2357d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f2358e;

        public PlatformImplementations.kt_3(ConstraintAnchor c0378e) {
            this.f2354a = c0378e;
            this.f2355b = c0378e.m1942g();
            this.f2356c = c0378e.m1940e();
            this.f2357d = c0378e.m1941f();
            this.f2358e = c0378e.m1943h();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m2087a(ConstraintWidget c0379f) {
            this.f2354a = c0379f.mo1959a(this.f2354a.m1939d());
            ConstraintAnchor c0378e = this.f2354a;
            if (c0378e != null) {
                this.f2355b = c0378e.m1942g();
                this.f2356c = this.f2354a.m1940e();
                this.f2357d = this.f2354a.m1941f();
                this.f2358e = this.f2354a.m1943h();
                return;
            }
            this.f2355b = null;
            this.f2356c = 0;
            this.f2357d = ConstraintAnchor.IntrinsicsJvm.kt_4.STRONG;
            this.f2358e = 0;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m2088b(ConstraintWidget c0379f) {
            c0379f.mo1959a(this.f2354a.m1939d()).m1936a(this.f2355b, this.f2356c, this.f2357d, this.f2358e);
        }
    }

    public Snapshot(ConstraintWidget c0379f) {
        this.f2349a = c0379f.m2009o();
        this.f2350b = c0379f.m2011p();
        this.f2351c = c0379f.m2013q();
        this.f2352d = c0379f.m2017s();
        ArrayList<ConstraintAnchor> arrayListMo1952D = c0379f.mo1952D();
        int size = arrayListMo1952D.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f2353e.add(new PlatformImplementations.kt_3(arrayListMo1952D.get(OplusGLSurfaceView_13)));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2085a(ConstraintWidget c0379f) {
        this.f2349a = c0379f.m2009o();
        this.f2350b = c0379f.m2011p();
        this.f2351c = c0379f.m2013q();
        this.f2352d = c0379f.m2017s();
        int size = this.f2353e.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f2353e.get(OplusGLSurfaceView_13).m2087a(c0379f);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2086b(ConstraintWidget c0379f) {
        c0379f.m1996h(this.f2349a);
        c0379f.m1997i(this.f2350b);
        c0379f.m2000j(this.f2351c);
        c0379f.m2002k(this.f2352d);
        int size = this.f2353e.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f2353e.get(OplusGLSurfaceView_13).m2088b(c0379f);
        }
    }
}
