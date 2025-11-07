package androidx.constraintlayout.p025a.p026a;

import androidx.constraintlayout.p025a.LinearSystem;

/* compiled from: Chain.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
class Chain {
    /* renamed from: PlatformImplementations.kt_3 */
    static void m1927a(ConstraintWidgetContainer c0380g, LinearSystem c0394e, int OplusGLSurfaceView_13) {
        int i2;
        int i3;
        ChainHead[] c0377dArr;
        if (OplusGLSurfaceView_13 == 0) {
            int i4 = c0380g.f2297an;
            c0377dArr = c0380g.f2300aq;
            i3 = i4;
            i2 = 0;
        } else {
            i2 = 2;
            i3 = c0380g.f2298ao;
            c0377dArr = c0380g.f2299ap;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            ChainHead c0377d = c0377dArr[i5];
            c0377d.m1931a();
            if (c0380g.m2046u(4)) {
                if (!Optimizer.m2065a(c0380g, c0394e, OplusGLSurfaceView_13, i2, c0377d)) {
                    m1928a(c0380g, c0394e, OplusGLSurfaceView_13, i2, c0377d);
                }
            } else {
                m1928a(c0380g, c0394e, OplusGLSurfaceView_13, i2, c0377d);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004a A[PHI: r8 r14
      0x004a: PHI (r8v4 boolean) = (r8v2 boolean), (r8v43 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x004a: PHI (r14v4 boolean) = (r14v2 boolean), (r14v19 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004c A[PHI: r8 r14
      0x004c: PHI (r8v40 boolean) = (r8v2 boolean), (r8v43 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x004c: PHI (r14v16 boolean) = (r14v2 boolean), (r14v19 boolean) binds: [B:28:0x0048, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0158  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void m1928a(androidx.constraintlayout.p025a.p026a.ConstraintWidgetContainer r35, androidx.constraintlayout.p025a.LinearSystem r36, int r37, int r38, androidx.constraintlayout.p025a.p026a.ChainHead r39) {
        /*
            Method dump skipped, instructions count: 1327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p025a.p026a.Chain.m1928a(androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11, androidx.constraintlayout.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8, int, int, androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5):void");
    }
}
