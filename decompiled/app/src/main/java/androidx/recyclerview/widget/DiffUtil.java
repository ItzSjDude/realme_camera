package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: DiffUtil.java */
/* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class DiffUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Comparator<IntrinsicsJvm.kt_3> f4206a = new Comparator<IntrinsicsJvm.kt_3>() { // from class: androidx.recyclerview.widget.COUIBaseListPopupWindow_12.1
        @Override // java.util.Comparator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public int compare(IntrinsicsJvm.kt_3 cVar, IntrinsicsJvm.kt_3 cVar2) {
            return cVar.f4209a - cVar2.f4209a;
        }
    };

    /* compiled from: DiffUtil.java */
    /* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    public static abstract class PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        public abstract int mo3966a();

        /* renamed from: PlatformImplementations.kt_3 */
        public abstract boolean mo3967a(int OplusGLSurfaceView_13, int i2);

        /* renamed from: IntrinsicsJvm.kt_4 */
        public abstract int mo3968b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        public abstract boolean mo3969b(int OplusGLSurfaceView_13, int i2);

        /* renamed from: IntrinsicsJvm.kt_3 */
        public Object m4423c(int OplusGLSurfaceView_13, int i2) {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static IntrinsicsJvm.kt_5 m4417a(PlatformImplementations.kt_3 aVar) {
        return m4418a(aVar, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static IntrinsicsJvm.kt_5 m4418a(PlatformImplementations.kt_3 aVar, boolean z) {
        int iMo3966a = aVar.mo3966a();
        int iMo3968b = aVar.mo3968b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new COUIBaseListPopupWindow_12(0, iMo3966a, 0, iMo3968b));
        int OplusGLSurfaceView_13 = ((((iMo3966a + iMo3968b) + 1) / 2) * 2) + 1;
        IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4(OplusGLSurfaceView_13);
        IntrinsicsJvm.kt_4 bVar2 = new IntrinsicsJvm.kt_4(OplusGLSurfaceView_13);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            COUIBaseListPopupWindow_12 fVar = (COUIBaseListPopupWindow_12) arrayList2.remove(arrayList2.size() - 1);
            COUIBaseListPopupWindow_11 gVarM4419a = m4419a(fVar, aVar, bVar, bVar2);
            if (gVarM4419a != null) {
                if (gVarM4419a.m4440c() > 0) {
                    arrayList.add(gVarM4419a.m4441d());
                }
                COUIBaseListPopupWindow_12 fVar2 = arrayList3.isEmpty() ? new COUIBaseListPopupWindow_12() : (COUIBaseListPopupWindow_12) arrayList3.remove(arrayList3.size() - 1);
                fVar2.f4222a = fVar.f4222a;
                fVar2.f4224c = fVar.f4224c;
                fVar2.f4223b = gVarM4419a.f4226a;
                fVar2.f4225d = gVarM4419a.f4227b;
                arrayList2.add(fVar2);
                fVar.f4223b = fVar.f4223b;
                fVar.f4225d = fVar.f4225d;
                fVar.f4222a = gVarM4419a.f4228c;
                fVar.f4224c = gVarM4419a.f4229d;
                arrayList2.add(fVar);
            } else {
                arrayList3.add(fVar);
            }
        }
        Collections.sort(arrayList, f4206a);
        return new IntrinsicsJvm.kt_5(aVar, arrayList, bVar.m4426a(), bVar2.m4426a(), z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static COUIBaseListPopupWindow_11 m4419a(COUIBaseListPopupWindow_12 fVar, PlatformImplementations.kt_3 aVar, IntrinsicsJvm.kt_4 bVar, IntrinsicsJvm.kt_4 bVar2) {
        if (fVar.m4436a() >= 1 && fVar.m4437b() >= 1) {
            int iM4436a = ((fVar.m4436a() + fVar.m4437b()) + 1) / 2;
            bVar.m4425a(1, fVar.f4222a);
            bVar2.m4425a(1, fVar.f4223b);
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM4436a; OplusGLSurfaceView_13++) {
                COUIBaseListPopupWindow_11 gVarM4420a = m4420a(fVar, aVar, bVar, bVar2, OplusGLSurfaceView_13);
                if (gVarM4420a != null) {
                    return gVarM4420a;
                }
                COUIBaseListPopupWindow_11 gVarM4421b = m4421b(fVar, aVar, bVar, bVar2, OplusGLSurfaceView_13);
                if (gVarM4421b != null) {
                    return gVarM4421b;
                }
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static COUIBaseListPopupWindow_11 m4420a(COUIBaseListPopupWindow_12 fVar, PlatformImplementations.kt_3 aVar, IntrinsicsJvm.kt_4 bVar, IntrinsicsJvm.kt_4 bVar2, int OplusGLSurfaceView_13) {
        int iM4424a;
        int i2;
        int i3;
        boolean z = Math.abs(fVar.m4436a() - fVar.m4437b()) % 2 == 1;
        int iM4436a = fVar.m4436a() - fVar.m4437b();
        int i4 = -OplusGLSurfaceView_13;
        for (int i5 = i4; i5 <= OplusGLSurfaceView_13; i5 += 2) {
            if (i5 == i4 || (i5 != OplusGLSurfaceView_13 && bVar.m4424a(i5 + 1) > bVar.m4424a(i5 - 1))) {
                iM4424a = bVar.m4424a(i5 + 1);
                i2 = iM4424a;
            } else {
                int iM4424a2 = bVar.m4424a(i5 - 1);
                i2 = iM4424a2;
                iM4424a = iM4424a2 + 1;
            }
            int i6 = (fVar.f4224c + (iM4424a - fVar.f4222a)) - i5;
            int i7 = (OplusGLSurfaceView_13 == 0 || iM4424a != i2) ? i6 : i6 - 1;
            while (iM4424a < fVar.f4223b && i6 < fVar.f4225d) {
                if (!aVar.mo3967a(iM4424a, i6)) {
                    break;
                }
                iM4424a++;
                i6++;
            }
            bVar.m4425a(i5, iM4424a);
            if (z && (i3 = iM4436a - i5) >= i4 + 1 && i3 <= OplusGLSurfaceView_13 - 1) {
                if (bVar2.m4424a(i3) <= iM4424a) {
                    COUIBaseListPopupWindow_11 gVar = new COUIBaseListPopupWindow_11();
                    gVar.f4226a = i2;
                    gVar.f4227b = i7;
                    gVar.f4228c = iM4424a;
                    gVar.f4229d = i6;
                    gVar.f4230e = false;
                    return gVar;
                }
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static COUIBaseListPopupWindow_11 m4421b(COUIBaseListPopupWindow_12 fVar, PlatformImplementations.kt_3 aVar, IntrinsicsJvm.kt_4 bVar, IntrinsicsJvm.kt_4 bVar2, int OplusGLSurfaceView_13) {
        int iM4424a;
        int i2;
        int i3;
        boolean z = (fVar.m4436a() - fVar.m4437b()) % 2 == 0;
        int iM4436a = fVar.m4436a() - fVar.m4437b();
        int i4 = -OplusGLSurfaceView_13;
        for (int i5 = i4; i5 <= OplusGLSurfaceView_13; i5 += 2) {
            if (i5 == i4 || (i5 != OplusGLSurfaceView_13 && bVar2.m4424a(i5 + 1) < bVar2.m4424a(i5 - 1))) {
                iM4424a = bVar2.m4424a(i5 + 1);
                i2 = iM4424a;
            } else {
                int iM4424a2 = bVar2.m4424a(i5 - 1);
                i2 = iM4424a2;
                iM4424a = iM4424a2 - 1;
            }
            int i6 = fVar.f4225d - ((fVar.f4223b - iM4424a) - i5);
            int i7 = (OplusGLSurfaceView_13 == 0 || iM4424a != i2) ? i6 : i6 + 1;
            while (iM4424a > fVar.f4222a && i6 > fVar.f4224c) {
                if (!aVar.mo3967a(iM4424a - 1, i6 - 1)) {
                    break;
                }
                iM4424a--;
                i6--;
            }
            bVar2.m4425a(i5, iM4424a);
            if (z && (i3 = iM4436a - i5) >= i4 && i3 <= OplusGLSurfaceView_13) {
                if (bVar.m4424a(i3) >= iM4424a) {
                    COUIBaseListPopupWindow_11 gVar = new COUIBaseListPopupWindow_11();
                    gVar.f4226a = iM4424a;
                    gVar.f4227b = i6;
                    gVar.f4228c = i2;
                    gVar.f4229d = i7;
                    gVar.f4230e = true;
                    return gVar;
                }
            }
        }
        return null;
    }

    /* compiled from: DiffUtil.java */
    /* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_12$IntrinsicsJvm.kt_3 */
    static class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final int f4209a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final int f4210b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public final int f4211c;

        IntrinsicsJvm.kt_3(int OplusGLSurfaceView_13, int i2, int i3) {
            this.f4209a = OplusGLSurfaceView_13;
            this.f4210b = i2;
            this.f4211c = i3;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m4427a() {
            return this.f4209a + this.f4211c;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        int m4428b() {
            return this.f4210b + this.f4211c;
        }
    }

    /* compiled from: DiffUtil.java */
    /* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_12$COUIBaseListPopupWindow_11 */
    static class COUIBaseListPopupWindow_11 {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f4226a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f4227b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f4228c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int f4229d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean f4230e;

        COUIBaseListPopupWindow_11() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m4438a() {
            return this.f4229d - this.f4227b != this.f4228c - this.f4226a;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean m4439b() {
            return this.f4229d - this.f4227b > this.f4228c - this.f4226a;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        int m4440c() {
            return Math.min(this.f4228c - this.f4226a, this.f4229d - this.f4227b);
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        IntrinsicsJvm.kt_3 m4441d() {
            if (m4438a()) {
                if (this.f4230e) {
                    return new IntrinsicsJvm.kt_3(this.f4226a, this.f4227b, m4440c());
                }
                if (m4439b()) {
                    return new IntrinsicsJvm.kt_3(this.f4226a, this.f4227b + 1, m4440c());
                }
                return new IntrinsicsJvm.kt_3(this.f4226a + 1, this.f4227b, m4440c());
            }
            int OplusGLSurfaceView_13 = this.f4226a;
            return new IntrinsicsJvm.kt_3(OplusGLSurfaceView_13, this.f4227b, this.f4228c - OplusGLSurfaceView_13);
        }
    }

    /* compiled from: DiffUtil.java */
    /* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_12$COUIBaseListPopupWindow_12 */
    static class COUIBaseListPopupWindow_12 {

        /* renamed from: PlatformImplementations.kt_3 */
        int f4222a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f4223b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f4224c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f4225d;

        public COUIBaseListPopupWindow_12() {
        }

        public COUIBaseListPopupWindow_12(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            this.f4222a = OplusGLSurfaceView_13;
            this.f4223b = i2;
            this.f4224c = i3;
            this.f4225d = i4;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m4436a() {
            return this.f4223b - this.f4222a;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        int m4437b() {
            return this.f4225d - this.f4224c;
        }
    }

    /* compiled from: DiffUtil.java */
    /* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_12$IntrinsicsJvm.kt_5 */
    public static class IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final List<IntrinsicsJvm.kt_3> f4212a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int[] f4213b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final int[] f4214c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final PlatformImplementations.kt_3 f4215d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final int f4216e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private final int f4217f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private final boolean f4218g;

        IntrinsicsJvm.kt_5(PlatformImplementations.kt_3 aVar, List<IntrinsicsJvm.kt_3> list, int[] iArr, int[] iArr2, boolean z) {
            this.f4212a = list;
            this.f4213b = iArr;
            this.f4214c = iArr2;
            Arrays.fill(this.f4213b, 0);
            Arrays.fill(this.f4214c, 0);
            this.f4215d = aVar;
            this.f4216e = aVar.mo3966a();
            this.f4217f = aVar.mo3968b();
            this.f4218g = z;
            m4430a();
            m4432b();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4430a() {
            IntrinsicsJvm.kt_3 cVar = this.f4212a.isEmpty() ? null : this.f4212a.get(0);
            if (cVar == null || cVar.f4209a != 0 || cVar.f4210b != 0) {
                this.f4212a.add(0, new IntrinsicsJvm.kt_3(0, 0, 0));
            }
            this.f4212a.add(new IntrinsicsJvm.kt_3(this.f4216e, this.f4217f, 0));
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m4432b() {
            for (IntrinsicsJvm.kt_3 cVar : this.f4212a) {
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < cVar.f4211c; OplusGLSurfaceView_13++) {
                    int i2 = cVar.f4209a + OplusGLSurfaceView_13;
                    int i3 = cVar.f4210b + OplusGLSurfaceView_13;
                    int i4 = this.f4215d.mo3969b(i2, i3) ? 1 : 2;
                    this.f4213b[i2] = (i3 << 4) | i4;
                    this.f4214c[i3] = (i2 << 4) | i4;
                }
            }
            if (this.f4218g) {
                m4433c();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private void m4433c() {
            int iM4427a = 0;
            for (IntrinsicsJvm.kt_3 cVar : this.f4212a) {
                while (iM4427a < cVar.f4209a) {
                    if (this.f4213b[iM4427a] == 0) {
                        m4431a(iM4427a);
                    }
                    iM4427a++;
                }
                iM4427a = cVar.m4427a();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4431a(int OplusGLSurfaceView_13) {
            int size = this.f4212a.size();
            int iM4428b = 0;
            for (int i2 = 0; i2 < size; i2++) {
                IntrinsicsJvm.kt_3 cVar = this.f4212a.get(i2);
                while (iM4428b < cVar.f4210b) {
                    if (this.f4214c[iM4428b] == 0 && this.f4215d.mo3967a(OplusGLSurfaceView_13, iM4428b)) {
                        int i3 = this.f4215d.mo3969b(OplusGLSurfaceView_13, iM4428b) ? 8 : 4;
                        this.f4213b[OplusGLSurfaceView_13] = (iM4428b << 4) | i3;
                        this.f4214c[iM4428b] = (OplusGLSurfaceView_13 << 4) | i3;
                        return;
                    }
                    iM4428b++;
                }
                iM4428b = cVar.m4428b();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4434a(RecyclerView.AbstractC0685a abstractC0685a) {
            m4435a(new AdapterListUpdateCallback(abstractC0685a));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4435a(ListUpdateCallback interfaceC0725l) {
            BatchingListUpdateCallback c0716c;
            int OplusGLSurfaceView_13;
            if (interfaceC0725l instanceof BatchingListUpdateCallback) {
                c0716c = (BatchingListUpdateCallback) interfaceC0725l;
            } else {
                c0716c = new BatchingListUpdateCallback(interfaceC0725l);
            }
            int i2 = this.f4216e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i3 = this.f4216e;
            int i4 = this.f4217f;
            for (int size = this.f4212a.size() - 1; size >= 0; size--) {
                IntrinsicsJvm.kt_3 cVar = this.f4212a.get(size);
                int iM4427a = cVar.m4427a();
                int iM4428b = cVar.m4428b();
                while (true) {
                    if (i3 <= iM4427a) {
                        break;
                    }
                    i3--;
                    int i5 = this.f4213b[i3];
                    if ((i5 & 12) != 0) {
                        int i6 = i5 >> 4;
                        COUIBaseListPopupWindow_8 eVarM4429a = m4429a(arrayDeque, i6, false);
                        if (eVarM4429a != null) {
                            int i7 = (i2 - eVarM4429a.f4220b) - 1;
                            c0716c.mo4373c(i3, i7);
                            if ((i5 & 4) != 0) {
                                c0716c.mo4371a(i7, 1, this.f4215d.m4423c(i3, i6));
                            }
                        } else {
                            arrayDeque.add(new COUIBaseListPopupWindow_8(i3, (i2 - i3) - 1, true));
                        }
                    } else {
                        c0716c.mo4372b(i3, 1);
                        i2--;
                    }
                }
                while (i4 > iM4428b) {
                    i4--;
                    int i8 = this.f4214c[i4];
                    if ((i8 & 12) != 0) {
                        int i9 = i8 >> 4;
                        COUIBaseListPopupWindow_8 eVarM4429a2 = m4429a(arrayDeque, i9, true);
                        if (eVarM4429a2 == null) {
                            arrayDeque.add(new COUIBaseListPopupWindow_8(i4, i2 - i3, false));
                        } else {
                            c0716c.mo4373c((i2 - eVarM4429a2.f4220b) - 1, i3);
                            if ((i8 & 4) != 0) {
                                c0716c.mo4371a(i3, 1, this.f4215d.m4423c(i9, i4));
                            }
                        }
                    } else {
                        c0716c.mo4370a(i3, 1);
                        i2++;
                    }
                }
                int i10 = cVar.f4209a;
                int i11 = cVar.f4210b;
                for (OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < cVar.f4211c; OplusGLSurfaceView_13++) {
                    if ((this.f4213b[i10] & 15) == 2) {
                        c0716c.mo4371a(i10, 1, this.f4215d.m4423c(i10, i11));
                    }
                    i10++;
                    i11++;
                }
                i3 = cVar.f4209a;
                i4 = cVar.f4210b;
            }
            c0716c.m4374a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private static COUIBaseListPopupWindow_8 m4429a(Collection<COUIBaseListPopupWindow_8> collection, int OplusGLSurfaceView_13, boolean z) {
            COUIBaseListPopupWindow_8 next;
            Iterator<COUIBaseListPopupWindow_8> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.f4219a == OplusGLSurfaceView_13 && next.f4221c == z) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                COUIBaseListPopupWindow_8 next2 = it.next();
                if (z) {
                    next2.f4220b--;
                } else {
                    next2.f4220b++;
                }
            }
            return next;
        }
    }

    /* compiled from: DiffUtil.java */
    /* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_12$COUIBaseListPopupWindow_8 */
    private static class COUIBaseListPopupWindow_8 {

        /* renamed from: PlatformImplementations.kt_3 */
        int f4219a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f4220b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean f4221c;

        COUIBaseListPopupWindow_8(int OplusGLSurfaceView_13, int i2, boolean z) {
            this.f4219a = OplusGLSurfaceView_13;
            this.f4220b = i2;
            this.f4221c = z;
        }
    }

    /* compiled from: DiffUtil.java */
    /* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_12$IntrinsicsJvm.kt_4 */
    static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final int[] f4207a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f4208b;

        IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13) {
            this.f4207a = new int[OplusGLSurfaceView_13];
            this.f4208b = this.f4207a.length / 2;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m4424a(int OplusGLSurfaceView_13) {
            return this.f4207a[OplusGLSurfaceView_13 + this.f4208b];
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int[] m4426a() {
            return this.f4207a;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4425a(int OplusGLSurfaceView_13, int i2) {
            this.f4207a[OplusGLSurfaceView_13 + this.f4208b] = i2;
        }
    }
}
