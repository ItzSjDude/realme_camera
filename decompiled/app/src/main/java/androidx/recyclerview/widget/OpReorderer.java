package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

/* compiled from: OpReorderer.java */
/* renamed from: androidx.recyclerview.widget.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
class OpReorderer {

    /* renamed from: PlatformImplementations.kt_3 */
    final PlatformImplementations.kt_3 f4293a;

    /* compiled from: OpReorderer.java */
    /* renamed from: androidx.recyclerview.widget.OplusGLSurfaceView_6$PlatformImplementations.kt_3 */
    interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        AdapterHelper.IntrinsicsJvm.kt_4 mo4352a(int OplusGLSurfaceView_13, int i2, int i3, Object obj);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo4354a(AdapterHelper.IntrinsicsJvm.kt_4 bVar);
    }

    OpReorderer(PlatformImplementations.kt_3 aVar) {
        this.f4293a = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4492a(List<AdapterHelper.IntrinsicsJvm.kt_4> list) {
        while (true) {
            int iM4490b = m4490b(list);
            if (iM4490b == -1) {
                return;
            } else {
                m4489a(list, iM4490b, iM4490b + 1);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4489a(List<AdapterHelper.IntrinsicsJvm.kt_4> list, int OplusGLSurfaceView_13, int i2) {
        AdapterHelper.IntrinsicsJvm.kt_4 bVar = list.get(OplusGLSurfaceView_13);
        AdapterHelper.IntrinsicsJvm.kt_4 bVar2 = list.get(i2);
        int i3 = bVar2.f4140a;
        if (i3 == 1) {
            m4491c(list, OplusGLSurfaceView_13, bVar, i2, bVar2);
        } else if (i3 == 2) {
            m4493a(list, OplusGLSurfaceView_13, bVar, i2, bVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            m4494b(list, OplusGLSurfaceView_13, bVar, i2, bVar2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4493a(List<AdapterHelper.IntrinsicsJvm.kt_4> list, int OplusGLSurfaceView_13, AdapterHelper.IntrinsicsJvm.kt_4 bVar, int i2, AdapterHelper.IntrinsicsJvm.kt_4 bVar2) {
        boolean z;
        boolean z2 = false;
        if (bVar.f4141b < bVar.f4143d) {
            if (bVar2.f4141b == bVar.f4141b && bVar2.f4143d == bVar.f4143d - bVar.f4141b) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (bVar2.f4141b == bVar.f4143d + 1 && bVar2.f4143d == bVar.f4141b - bVar.f4143d) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        if (bVar.f4143d < bVar2.f4141b) {
            bVar2.f4141b--;
        } else if (bVar.f4143d < bVar2.f4141b + bVar2.f4143d) {
            bVar2.f4143d--;
            bVar.f4140a = 2;
            bVar.f4143d = 1;
            if (bVar2.f4143d == 0) {
                list.remove(i2);
                this.f4293a.mo4354a(bVar2);
                return;
            }
            return;
        }
        AdapterHelper.IntrinsicsJvm.kt_4 bVarMo4352a = null;
        if (bVar.f4141b <= bVar2.f4141b) {
            bVar2.f4141b++;
        } else if (bVar.f4141b < bVar2.f4141b + bVar2.f4143d) {
            bVarMo4352a = this.f4293a.mo4352a(2, bVar.f4141b + 1, (bVar2.f4141b + bVar2.f4143d) - bVar.f4141b, null);
            bVar2.f4143d = bVar.f4141b - bVar2.f4141b;
        }
        if (z2) {
            list.set(OplusGLSurfaceView_13, bVar2);
            list.remove(i2);
            this.f4293a.mo4354a(bVar);
            return;
        }
        if (z) {
            if (bVarMo4352a != null) {
                if (bVar.f4141b > bVarMo4352a.f4141b) {
                    bVar.f4141b -= bVarMo4352a.f4143d;
                }
                if (bVar.f4143d > bVarMo4352a.f4141b) {
                    bVar.f4143d -= bVarMo4352a.f4143d;
                }
            }
            if (bVar.f4141b > bVar2.f4141b) {
                bVar.f4141b -= bVar2.f4143d;
            }
            if (bVar.f4143d > bVar2.f4141b) {
                bVar.f4143d -= bVar2.f4143d;
            }
        } else {
            if (bVarMo4352a != null) {
                if (bVar.f4141b >= bVarMo4352a.f4141b) {
                    bVar.f4141b -= bVarMo4352a.f4143d;
                }
                if (bVar.f4143d >= bVarMo4352a.f4141b) {
                    bVar.f4143d -= bVarMo4352a.f4143d;
                }
            }
            if (bVar.f4141b >= bVar2.f4141b) {
                bVar.f4141b -= bVar2.f4143d;
            }
            if (bVar.f4143d >= bVar2.f4141b) {
                bVar.f4143d -= bVar2.f4143d;
            }
        }
        list.set(OplusGLSurfaceView_13, bVar2);
        if (bVar.f4141b != bVar.f4143d) {
            list.set(i2, bVar);
        } else {
            list.remove(i2);
        }
        if (bVarMo4352a != null) {
            list.add(OplusGLSurfaceView_13, bVarMo4352a);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m4491c(List<AdapterHelper.IntrinsicsJvm.kt_4> list, int OplusGLSurfaceView_13, AdapterHelper.IntrinsicsJvm.kt_4 bVar, int i2, AdapterHelper.IntrinsicsJvm.kt_4 bVar2) {
        int i3 = bVar.f4143d < bVar2.f4141b ? -1 : 0;
        if (bVar.f4141b < bVar2.f4141b) {
            i3++;
        }
        if (bVar2.f4141b <= bVar.f4141b) {
            bVar.f4141b += bVar2.f4143d;
        }
        if (bVar2.f4141b <= bVar.f4143d) {
            bVar.f4143d += bVar2.f4143d;
        }
        bVar2.f4141b += i3;
        list.set(OplusGLSurfaceView_13, bVar2);
        list.set(i2, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m4494b(java.util.List<androidx.recyclerview.widget.AdapterHelper.IntrinsicsJvm.kt_4> r8, int r9, androidx.recyclerview.widget.AdapterHelper.IntrinsicsJvm.kt_4 r10, int r11, androidx.recyclerview.widget.AdapterHelper.IntrinsicsJvm.kt_4 r12) {
        /*
            r7 = this;
            int r0 = r10.f4143d
            int r1 = r12.f4141b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Lf
            int r0 = r12.f4141b
            int r0 = r0 - r4
            r12.f4141b = r0
            goto L28
        Lf:
            int r0 = r10.f4143d
            int r1 = r12.f4141b
            int r5 = r12.f4143d
            int r1 = r1 + r5
            if (r0 >= r1) goto L28
            int r0 = r12.f4143d
            int r0 = r0 - r4
            r12.f4143d = r0
            androidx.recyclerview.widget.OplusGLSurfaceView_6$PlatformImplementations.kt_3 r0 = r7.f4293a
            int r1 = r10.f4141b
            java.lang.Object r5 = r12.f4142c
            androidx.recyclerview.widget.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 r0 = r0.mo4352a(r2, r1, r4, r5)
            goto L29
        L28:
            r0 = r3
        L29:
            int r1 = r10.f4141b
            int r5 = r12.f4141b
            if (r1 > r5) goto L35
            int r1 = r12.f4141b
            int r1 = r1 + r4
            r12.f4141b = r1
            goto L56
        L35:
            int r1 = r10.f4141b
            int r5 = r12.f4141b
            int r6 = r12.f4143d
            int r5 = r5 + r6
            if (r1 >= r5) goto L56
            int r1 = r12.f4141b
            int r3 = r12.f4143d
            int r1 = r1 + r3
            int r3 = r10.f4141b
            int r1 = r1 - r3
            androidx.recyclerview.widget.OplusGLSurfaceView_6$PlatformImplementations.kt_3 r3 = r7.f4293a
            int r5 = r10.f4141b
            int r5 = r5 + r4
            java.lang.Object r4 = r12.f4142c
            androidx.recyclerview.widget.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 r3 = r3.mo4352a(r2, r5, r1, r4)
            int r2 = r12.f4143d
            int r2 = r2 - r1
            r12.f4143d = r2
        L56:
            r8.set(r11, r10)
            int r10 = r12.f4143d
            if (r10 <= 0) goto L61
            r8.set(r9, r12)
            goto L69
        L61:
            r8.remove(r9)
            androidx.recyclerview.widget.OplusGLSurfaceView_6$PlatformImplementations.kt_3 r7 = r7.f4293a
            r7.mo4354a(r12)
        L69:
            if (r0 == 0) goto L6e
            r8.add(r9, r0)
        L6e:
            if (r3 == 0) goto L73
            r8.add(r9, r3)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.m4494b(java.util.List, int, androidx.recyclerview.widget.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4, int, androidx.recyclerview.widget.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4):void");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m4490b(List<AdapterHelper.IntrinsicsJvm.kt_4> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f4140a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
