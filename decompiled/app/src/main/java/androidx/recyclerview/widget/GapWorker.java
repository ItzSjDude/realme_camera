package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.core.p032d.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* compiled from: GapWorker.java */
/* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
final class GapWorker implements Runnable {

    /* renamed from: PlatformImplementations.kt_3 */
    static final ThreadLocal<GapWorker> f4267a = new ThreadLocal<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    static Comparator<IntrinsicsJvm.kt_4> f4268e = new Comparator<IntrinsicsJvm.kt_4>() { // from class: androidx.recyclerview.widget.COUIBaseListPopupWindow_10.1
        @Override // java.util.Comparator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public int compare(IntrinsicsJvm.kt_4 bVar, IntrinsicsJvm.kt_4 bVar2) {
            if ((bVar.f4280d == null) != (bVar2.f4280d == null)) {
                return bVar.f4280d == null ? 1 : -1;
            }
            if (bVar.f4277a != bVar2.f4277a) {
                return bVar.f4277a ? -1 : 1;
            }
            int OplusGLSurfaceView_13 = bVar2.f4278b - bVar.f4278b;
            if (OplusGLSurfaceView_13 != 0) {
                return OplusGLSurfaceView_13;
            }
            int i2 = bVar.f4279c - bVar2.f4279c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };

    /* renamed from: IntrinsicsJvm.kt_3 */
    long f4270c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    long f4271d;

    /* renamed from: IntrinsicsJvm.kt_4 */
    ArrayList<RecyclerView> f4269b = new ArrayList<>();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ArrayList<IntrinsicsJvm.kt_4> f4272f = new ArrayList<>();

    GapWorker() {
    }

    /* compiled from: GapWorker.java */
    /* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_4 */
    static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean f4277a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f4278b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f4279c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public RecyclerView f4280d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f4281e;

        IntrinsicsJvm.kt_4() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4477a() {
            this.f4277a = false;
            this.f4278b = 0;
            this.f4279c = 0;
            this.f4280d = null;
            this.f4281e = 0;
        }
    }

    /* compiled from: GapWorker.java */
    @SuppressLint({"VisibleForTests"})
    /* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 implements RecyclerView.AbstractC0693i.PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        int f4273a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f4274b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int[] f4275c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f4276d;

        PlatformImplementations.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4474a(int OplusGLSurfaceView_13, int i2) {
            this.f4273a = OplusGLSurfaceView_13;
            this.f4274b = i2;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4475a(RecyclerView recyclerView, boolean z) {
            this.f4276d = 0;
            int[] iArr = this.f4275c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.AbstractC0693i abstractC0693i = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || abstractC0693i == null || !abstractC0693i.isItemPrefetchEnabled()) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.m4366d()) {
                    abstractC0693i.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                abstractC0693i.collectAdjacentPrefetchPositions(this.f4273a, this.f4274b, recyclerView.mState, this);
            }
            if (this.f4276d > abstractC0693i.mPrefetchMaxCountObserved) {
                abstractC0693i.mPrefetchMaxCountObserved = this.f4276d;
                abstractC0693i.mPrefetchMaxObservedInInitialPrefetch = z;
                recyclerView.mRecycler.m4197b();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo4153b(int OplusGLSurfaceView_13, int i2) {
            if (OplusGLSurfaceView_13 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.f4276d * 2;
            int[] iArr = this.f4275c;
            if (iArr == null) {
                this.f4275c = new int[4];
                Arrays.fill(this.f4275c, -1);
            } else if (i3 >= iArr.length) {
                this.f4275c = new int[i3 * 2];
                System.arraycopy(iArr, 0, this.f4275c, 0, iArr.length);
            }
            int[] iArr2 = this.f4275c;
            iArr2[i3] = OplusGLSurfaceView_13;
            iArr2[i3 + 1] = i2;
            this.f4276d++;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m4476a(int OplusGLSurfaceView_13) {
            if (this.f4275c != null) {
                int i2 = this.f4276d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f4275c[i3] == OplusGLSurfaceView_13) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4473a() {
            int[] iArr = this.f4275c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4276d = 0;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4469a(RecyclerView recyclerView) {
        this.f4269b.add(recyclerView);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m4471b(RecyclerView recyclerView) {
        this.f4269b.remove(recyclerView);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4470a(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f4270c == 0) {
            this.f4270c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.m4474a(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4463a() {
        IntrinsicsJvm.kt_4 bVar;
        int size = this.f4269b.size();
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f4269b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.m4475a(recyclerView, false);
                OplusGLSurfaceView_13 += recyclerView.mPrefetchRegistry.f4276d;
            }
        }
        this.f4272f.ensureCapacity(OplusGLSurfaceView_13);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f4269b.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                PlatformImplementations.kt_3 aVar = recyclerView2.mPrefetchRegistry;
                int iAbs = Math.abs(aVar.f4273a) + Math.abs(aVar.f4274b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.f4276d * 2; i6 += 2) {
                    if (i5 >= this.f4272f.size()) {
                        bVar = new IntrinsicsJvm.kt_4();
                        this.f4272f.add(bVar);
                    } else {
                        bVar = this.f4272f.get(i5);
                    }
                    int i7 = aVar.f4275c[i6 + 1];
                    bVar.f4277a = i7 <= iAbs;
                    bVar.f4278b = iAbs;
                    bVar.f4279c = i7;
                    bVar.f4280d = recyclerView2;
                    bVar.f4281e = aVar.f4275c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f4272f, f4268e);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean m4466a(RecyclerView recyclerView, int OplusGLSurfaceView_13) {
        int iM4387c = recyclerView.mChildHelper.m4387c();
        for (int i2 = 0; i2 < iM4387c; i2++) {
            RecyclerView.AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.m4390d(i2));
            if (childViewHolderInt.mPosition == OplusGLSurfaceView_13 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private RecyclerView.AbstractC0707w m4462a(RecyclerView recyclerView, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        if (m4466a(recyclerView, OplusGLSurfaceView_13)) {
            return null;
        }
        RecyclerView.C0700p c0700p = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.AbstractC0707w abstractC0707wM4183a = c0700p.m4183a(OplusGLSurfaceView_13, false, OplusGLSurfaceView_15);
            if (abstractC0707wM4183a != null) {
                if (abstractC0707wM4183a.isBound() && !abstractC0707wM4183a.isInvalid()) {
                    c0700p.m4189a(abstractC0707wM4183a.itemView);
                } else {
                    c0700p.m4193a(abstractC0707wM4183a, false);
                }
            }
            return abstractC0707wM4183a;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4464a(RecyclerView recyclerView, long OplusGLSurfaceView_15) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.m4387c() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        PlatformImplementations.kt_3 aVar = recyclerView.mPrefetchRegistry;
        aVar.m4475a(recyclerView, true);
        if (aVar.f4276d != 0) {
            try {
                TraceCompat.m2449a("RV Nested Prefetch");
                recyclerView.mState.m4225a(recyclerView.mAdapter);
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < aVar.f4276d * 2; OplusGLSurfaceView_13 += 2) {
                    m4462a(recyclerView, aVar.f4275c[OplusGLSurfaceView_13], OplusGLSurfaceView_15);
                }
            } finally {
                TraceCompat.m2448a();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4465a(IntrinsicsJvm.kt_4 bVar, long OplusGLSurfaceView_15) {
        RecyclerView.AbstractC0707w abstractC0707wM4462a = m4462a(bVar.f4280d, bVar.f4281e, bVar.f4277a ? Long.MAX_VALUE : OplusGLSurfaceView_15);
        if (abstractC0707wM4462a == null || abstractC0707wM4462a.mNestedRecyclerView == null || !abstractC0707wM4462a.isBound() || abstractC0707wM4462a.isInvalid()) {
            return;
        }
        m4464a(abstractC0707wM4462a.mNestedRecyclerView.get(), OplusGLSurfaceView_15);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4467b(long OplusGLSurfaceView_15) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4272f.size(); OplusGLSurfaceView_13++) {
            IntrinsicsJvm.kt_4 bVar = this.f4272f.get(OplusGLSurfaceView_13);
            if (bVar.f4280d == null) {
                return;
            }
            m4465a(bVar, OplusGLSurfaceView_15);
            bVar.m4477a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4468a(long OplusGLSurfaceView_15) {
        m4463a();
        m4467b(OplusGLSurfaceView_15);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TraceCompat.m2449a("RV Prefetch");
            if (!this.f4269b.isEmpty()) {
                int size = this.f4269b.size();
                long jMax = 0;
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                    RecyclerView recyclerView = this.f4269b.get(OplusGLSurfaceView_13);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    m4468a(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f4271d);
                }
            }
        } finally {
            this.f4270c = 0L;
            TraceCompat.m2448a();
        }
    }
}
