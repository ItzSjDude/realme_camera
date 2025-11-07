package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.p035g.Pools;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ViewInfoStore.java */
/* renamed from: androidx.recyclerview.widget.u */
/* loaded from: classes.dex */
class ViewInfoStore {

    /* renamed from: PlatformImplementations.kt_3 */
    final SimpleArrayMap<RecyclerView.AbstractC0707w, PlatformImplementations.kt_3> f4316a = new SimpleArrayMap<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    final LongSparseArray<RecyclerView.AbstractC0707w> f4317b = new LongSparseArray<>();

    /* compiled from: ViewInfoStore.java */
    /* renamed from: androidx.recyclerview.widget.u$IntrinsicsJvm.kt_4 */
    interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo4084a(RecyclerView.AbstractC0707w abstractC0707w);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo4085a(RecyclerView.AbstractC0707w abstractC0707w, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar2);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo4086b(RecyclerView.AbstractC0707w abstractC0707w, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar2);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo4087c(RecyclerView.AbstractC0707w abstractC0707w, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar2);
    }

    ViewInfoStore() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4561a() {
        this.f4316a.clear();
        this.f4317b.clear();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4563a(RecyclerView.AbstractC0707w abstractC0707w, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar) {
        PlatformImplementations.kt_3 aVarM4576a = this.f4316a.get(abstractC0707w);
        if (aVarM4576a == null) {
            aVarM4576a = PlatformImplementations.kt_3.m4576a();
            this.f4316a.put(abstractC0707w, aVarM4576a);
        }
        aVarM4576a.f4320b = cVar;
        aVarM4576a.f4319a |= 4;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m4565a(RecyclerView.AbstractC0707w abstractC0707w) {
        PlatformImplementations.kt_3 aVar = this.f4316a.get(abstractC0707w);
        return (aVar == null || (aVar.f4319a & 1) == 0) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 m4566b(RecyclerView.AbstractC0707w abstractC0707w) {
        return m4559a(abstractC0707w, 4);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 m4569c(RecyclerView.AbstractC0707w abstractC0707w) {
        return m4559a(abstractC0707w, 8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 m4559a(RecyclerView.AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVarValueAt;
        RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar;
        int iIndexOfKey = this.f4316a.indexOfKey(abstractC0707w);
        if (iIndexOfKey < 0 || (aVarValueAt = this.f4316a.valueAt(iIndexOfKey)) == null || (aVarValueAt.f4319a & OplusGLSurfaceView_13) == 0) {
            return null;
        }
        aVarValueAt.f4319a &= ~OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 == 4) {
            cVar = aVarValueAt.f4320b;
        } else if (OplusGLSurfaceView_13 == 8) {
            cVar = aVarValueAt.f4321c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((aVarValueAt.f4319a & 12) == 0) {
            this.f4316a.removeAt(iIndexOfKey);
            PlatformImplementations.kt_3.m4577a(aVarValueAt);
        }
        return cVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4562a(long OplusGLSurfaceView_15, RecyclerView.AbstractC0707w abstractC0707w) {
        this.f4317b.put(OplusGLSurfaceView_15, abstractC0707w);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m4568b(RecyclerView.AbstractC0707w abstractC0707w, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar) {
        PlatformImplementations.kt_3 aVarM4576a = this.f4316a.get(abstractC0707w);
        if (aVarM4576a == null) {
            aVarM4576a = PlatformImplementations.kt_3.m4576a();
            this.f4316a.put(abstractC0707w, aVarM4576a);
        }
        aVarM4576a.f4319a |= 2;
        aVarM4576a.f4320b = cVar;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean m4571d(RecyclerView.AbstractC0707w abstractC0707w) {
        PlatformImplementations.kt_3 aVar = this.f4316a.get(abstractC0707w);
        return (aVar == null || (aVar.f4319a & 4) == 0) ? false : true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    RecyclerView.AbstractC0707w m4560a(long OplusGLSurfaceView_15) {
        return this.f4317b.get(OplusGLSurfaceView_15);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m4570c(RecyclerView.AbstractC0707w abstractC0707w, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar) {
        PlatformImplementations.kt_3 aVarM4576a = this.f4316a.get(abstractC0707w);
        if (aVarM4576a == null) {
            aVarM4576a = PlatformImplementations.kt_3.m4576a();
            this.f4316a.put(abstractC0707w, aVarM4576a);
        }
        aVarM4576a.f4321c = cVar;
        aVarM4576a.f4319a |= 8;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    void m4572e(RecyclerView.AbstractC0707w abstractC0707w) {
        PlatformImplementations.kt_3 aVarM4576a = this.f4316a.get(abstractC0707w);
        if (aVarM4576a == null) {
            aVarM4576a = PlatformImplementations.kt_3.m4576a();
            this.f4316a.put(abstractC0707w, aVarM4576a);
        }
        aVarM4576a.f4319a |= 1;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    void m4573f(RecyclerView.AbstractC0707w abstractC0707w) {
        PlatformImplementations.kt_3 aVar = this.f4316a.get(abstractC0707w);
        if (aVar == null) {
            return;
        }
        aVar.f4319a &= -2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4564a(IntrinsicsJvm.kt_4 bVar) {
        for (int size = this.f4316a.size() - 1; size >= 0; size--) {
            RecyclerView.AbstractC0707w abstractC0707wKeyAt = this.f4316a.keyAt(size);
            PlatformImplementations.kt_3 aVarRemoveAt = this.f4316a.removeAt(size);
            if ((aVarRemoveAt.f4319a & 3) == 3) {
                bVar.mo4084a(abstractC0707wKeyAt);
            } else if ((aVarRemoveAt.f4319a & 1) != 0) {
                if (aVarRemoveAt.f4320b == null) {
                    bVar.mo4084a(abstractC0707wKeyAt);
                } else {
                    bVar.mo4085a(abstractC0707wKeyAt, aVarRemoveAt.f4320b, aVarRemoveAt.f4321c);
                }
            } else if ((aVarRemoveAt.f4319a & 14) == 14) {
                bVar.mo4086b(abstractC0707wKeyAt, aVarRemoveAt.f4320b, aVarRemoveAt.f4321c);
            } else if ((aVarRemoveAt.f4319a & 12) == 12) {
                bVar.mo4087c(abstractC0707wKeyAt, aVarRemoveAt.f4320b, aVarRemoveAt.f4321c);
            } else if ((aVarRemoveAt.f4319a & 4) != 0) {
                bVar.mo4085a(abstractC0707wKeyAt, aVarRemoveAt.f4320b, null);
            } else if ((aVarRemoveAt.f4319a & 8) != 0) {
                bVar.mo4086b(abstractC0707wKeyAt, aVarRemoveAt.f4320b, aVarRemoveAt.f4321c);
            } else {
                int OplusGLSurfaceView_13 = aVarRemoveAt.f4319a;
            }
            PlatformImplementations.kt_3.m4577a(aVarRemoveAt);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    void m4574g(RecyclerView.AbstractC0707w abstractC0707w) {
        int size = this.f4317b.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (abstractC0707w == this.f4317b.valueAt(size)) {
                this.f4317b.removeAt(size);
                break;
            }
            size--;
        }
        PlatformImplementations.kt_3 aVarRemove = this.f4316a.remove(abstractC0707w);
        if (aVarRemove != null) {
            PlatformImplementations.kt_3.m4577a(aVarRemove);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m4567b() {
        PlatformImplementations.kt_3.m4578b();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m4575h(RecyclerView.AbstractC0707w abstractC0707w) {
        m4573f(abstractC0707w);
    }

    /* compiled from: ViewInfoStore.java */
    /* renamed from: androidx.recyclerview.widget.u$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_5 */
        static Pools.PlatformImplementations.kt_3<PlatformImplementations.kt_3> f4318d = new Pools.IntrinsicsJvm.kt_4(20);

        /* renamed from: PlatformImplementations.kt_3 */
        int f4319a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 f4320b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 f4321c;

        private PlatformImplementations.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        static PlatformImplementations.kt_3 m4576a() {
            PlatformImplementations.kt_3 aVarMo2532a = f4318d.mo2532a();
            return aVarMo2532a == null ? new PlatformImplementations.kt_3() : aVarMo2532a;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        static void m4577a(PlatformImplementations.kt_3 aVar) {
            aVar.f4319a = 0;
            aVar.f4320b = null;
            aVar.f4321c = null;
            f4318d.mo2533a(aVar);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        static void m4578b() {
            while (f4318d.mo2532a() != null) {
            }
        }
    }
}
