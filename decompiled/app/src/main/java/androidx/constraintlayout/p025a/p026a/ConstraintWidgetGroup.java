package androidx.constraintlayout.p025a.p026a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: ConstraintWidgetGroup.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class ConstraintWidgetGroup {

    /* renamed from: PlatformImplementations.kt_3 */
    public List<ConstraintWidget> f2309a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f2310b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f2311c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean f2312d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final int[] f2313e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    List<ConstraintWidget> f2314f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    List<ConstraintWidget> f2315g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    HashSet<ConstraintWidget> f2316h;

    /* renamed from: OplusGLSurfaceView_13 */
    HashSet<ConstraintWidget> f2317i;

    /* renamed from: OplusGLSurfaceView_15 */
    List<ConstraintWidget> f2318j;

    /* renamed from: OplusGLSurfaceView_5 */
    List<ConstraintWidget> f2319k;

    ConstraintWidgetGroup(List<ConstraintWidget> list) {
        this.f2310b = -1;
        this.f2311c = -1;
        this.f2312d = false;
        this.f2313e = new int[]{this.f2310b, this.f2311c};
        this.f2314f = new ArrayList();
        this.f2315g = new ArrayList();
        this.f2316h = new HashSet<>();
        this.f2317i = new HashSet<>();
        this.f2318j = new ArrayList();
        this.f2319k = new ArrayList();
        this.f2309a = list;
    }

    ConstraintWidgetGroup(List<ConstraintWidget> list, boolean z) {
        this.f2310b = -1;
        this.f2311c = -1;
        this.f2312d = false;
        this.f2313e = new int[]{this.f2310b, this.f2311c};
        this.f2314f = new ArrayList();
        this.f2315g = new ArrayList();
        this.f2316h = new HashSet<>();
        this.f2317i = new HashSet<>();
        this.f2318j = new ArrayList();
        this.f2319k = new ArrayList();
        this.f2309a = list;
        this.f2312d = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<ConstraintWidget> m2050a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return this.f2314f;
        }
        if (OplusGLSurfaceView_13 == 1) {
            return this.f2315g;
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    Set<ConstraintWidget> m2052b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return this.f2316h;
        }
        if (OplusGLSurfaceView_13 == 1) {
            return this.f2317i;
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m2051a(ConstraintWidget c0379f, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            this.f2316h.add(c0379f);
        } else if (OplusGLSurfaceView_13 == 1) {
            this.f2317i.add(c0379f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    List<ConstraintWidget> m2049a() {
        if (!this.f2318j.isEmpty()) {
            return this.f2318j;
        }
        int size = this.f2309a.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            ConstraintWidget c0379f = this.f2309a.get(OplusGLSurfaceView_13);
            if (!c0379f.f2234W) {
                m2048a((ArrayList<ConstraintWidget>) this.f2318j, c0379f);
            }
        }
        this.f2319k.clear();
        this.f2319k.addAll(this.f2309a);
        this.f2319k.removeAll(this.f2318j);
        return this.f2318j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2048a(ArrayList<ConstraintWidget> arrayList, ConstraintWidget c0379f) {
        if (c0379f.f2236Y) {
            return;
        }
        arrayList.add(c0379f);
        c0379f.f2236Y = true;
        if (c0379f.m1998i()) {
            return;
        }
        if (c0379f instanceof Helper) {
            Helper c0383j = (Helper) c0379f;
            int OplusGLSurfaceView_13 = c0383j.f2331aj;
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                m2048a(arrayList, c0383j.f2330ai[i2]);
            }
        }
        int length = c0379f.f2213A.length;
        for (int i3 = 0; i3 < length; i3++) {
            ConstraintAnchor c0378e = c0379f.f2213A[i3].f2203c;
            if (c0378e != null) {
                ConstraintWidget c0379f2 = c0378e.f2201a;
                if (c0378e != null && c0379f2 != c0379f.m2003l()) {
                    m2048a(arrayList, c0379f2);
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m2053b() {
        int size = this.f2319k.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            m2047a(this.f2319k.get(OplusGLSurfaceView_13));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m2047a(androidx.constraintlayout.p025a.p026a.ConstraintWidget r7) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p025a.p026a.ConstraintWidgetGroup.m2047a(androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12):void");
    }
}
