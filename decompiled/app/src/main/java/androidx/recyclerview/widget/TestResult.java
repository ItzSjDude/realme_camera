package androidx.recyclerview.widget;

/* compiled from: GapWorker.java */
/* loaded from: classes.dex */
final class h_renamed implements java.lang.Runnable {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final java.lang.ThreadLocal<androidx.recyclerview.widget.h_renamed> f1526a = new java.lang.ThreadLocal<>();
    static java.util.Comparator<androidx.recyclerview.widget.h_renamed.b_renamed> e_renamed = new java.util.Comparator<androidx.recyclerview.widget.h_renamed.b_renamed>() { // from class: androidx.recyclerview.widget.h_renamed.1
        @Override // java.util.Comparator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public int compare(androidx.recyclerview.widget.h_renamed.b_renamed bVar, androidx.recyclerview.widget.h_renamed.b_renamed bVar2) {
            if ((bVar.d_renamed == null) != (bVar2.d_renamed == null)) {
                return bVar.d_renamed == null ? 1 : -1;
            }
            if (bVar.f1532a != bVar2.f1532a) {
                return bVar.f1532a ? -1 : 1;
            }
            int i_renamed = bVar2.f1533b - bVar.f1533b;
            if (i_renamed != 0) {
                return i_renamed;
            }
            int i2 = bVar.f1534c - bVar2.f1534c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };

    /* renamed from: c_renamed, reason: collision with root package name */
    long f1528c;
    long d_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    java.util.ArrayList<androidx.recyclerview.widget.RecyclerView> f1527b = new java.util.ArrayList<>();
    private java.util.ArrayList<androidx.recyclerview.widget.h_renamed.b_renamed> f_renamed = new java.util.ArrayList<>();

    h_renamed() {
    }

    /* compiled from: GapWorker.java */
    static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public boolean f1532a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f1533b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f1534c;
        public androidx.recyclerview.widget.RecyclerView d_renamed;
        public int e_renamed;

        b_renamed() {
        }

        public void a_renamed() {
            this.f1532a = false;
            this.f1533b = 0;
            this.f1534c = 0;
            this.d_renamed = null;
            this.e_renamed = 0;
        }
    }

    /* compiled from: GapWorker.java */
    @android.annotation.SuppressLint({"VisibleForTests"})
    static class a_renamed implements androidx.recyclerview.widget.RecyclerView.i_renamed.a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f1529a;

        /* renamed from: b_renamed, reason: collision with root package name */
        int f1530b;

        /* renamed from: c_renamed, reason: collision with root package name */
        int[] f1531c;
        int d_renamed;

        a_renamed() {
        }

        void a_renamed(int i_renamed, int i2) {
            this.f1529a = i_renamed;
            this.f1530b = i2;
        }

        void a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, boolean z_renamed) {
            this.d_renamed = 0;
            int[] iArr = this.f1531c;
            if (iArr != null) {
                java.util.Arrays.fill(iArr, -1);
            }
            androidx.recyclerview.widget.RecyclerView.i_renamed iVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || iVar == null || !iVar.isItemPrefetchEnabled()) {
                return;
            }
            if (z_renamed) {
                if (!recyclerView.mAdapterHelper.d_renamed()) {
                    iVar.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                iVar.collectAdjacentPrefetchPositions(this.f1529a, this.f1530b, recyclerView.mState, this);
            }
            if (this.d_renamed > iVar.mPrefetchMaxCountObserved) {
                iVar.mPrefetchMaxCountObserved = this.d_renamed;
                iVar.mPrefetchMaxObservedInInitialPrefetch = z_renamed;
                recyclerView.mRecycler.b_renamed();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i_renamed.a_renamed
        public void b_renamed(int i_renamed, int i2) {
            if (i_renamed < 0) {
                throw new java.lang.IllegalArgumentException("Layout positions must be_renamed non-negative");
            }
            if (i2 < 0) {
                throw new java.lang.IllegalArgumentException("Pixel distance must be_renamed non-negative");
            }
            int i3 = this.d_renamed * 2;
            int[] iArr = this.f1531c;
            if (iArr == null) {
                this.f1531c = new int[4];
                java.util.Arrays.fill(this.f1531c, -1);
            } else if (i3 >= iArr.length) {
                this.f1531c = new int[i3 * 2];
                java.lang.System.arraycopy(iArr, 0, this.f1531c, 0, iArr.length);
            }
            int[] iArr2 = this.f1531c;
            iArr2[i3] = i_renamed;
            iArr2[i3 + 1] = i2;
            this.d_renamed++;
        }

        boolean a_renamed(int i_renamed) {
            if (this.f1531c != null) {
                int i2 = this.d_renamed * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f1531c[i3] == i_renamed) {
                        return true;
                    }
                }
            }
            return false;
        }

        void a_renamed() {
            int[] iArr = this.f1531c;
            if (iArr != null) {
                java.util.Arrays.fill(iArr, -1);
            }
            this.d_renamed = 0;
        }
    }

    public void a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.f1527b.add(recyclerView);
    }

    public void b_renamed(androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.f1527b.remove(recyclerView);
    }

    void a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f1528c == 0) {
            this.f1528c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.a_renamed(i_renamed, i2);
    }

    private void a_renamed() {
        androidx.recyclerview.widget.h_renamed.b_renamed bVar;
        int size = this.f1527b.size();
        int i_renamed = 0;
        for (int i2 = 0; i2 < size; i2++) {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.f1527b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.a_renamed(recyclerView, false);
                i_renamed += recyclerView.mPrefetchRegistry.d_renamed;
            }
        }
        this.f_renamed.ensureCapacity(i_renamed);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            androidx.recyclerview.widget.RecyclerView recyclerView2 = this.f1527b.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                androidx.recyclerview.widget.h_renamed.a_renamed aVar = recyclerView2.mPrefetchRegistry;
                int iAbs = java.lang.Math.abs(aVar.f1529a) + java.lang.Math.abs(aVar.f1530b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.d_renamed * 2; i6 += 2) {
                    if (i5 >= this.f_renamed.size()) {
                        bVar = new androidx.recyclerview.widget.h_renamed.b_renamed();
                        this.f_renamed.add(bVar);
                    } else {
                        bVar = this.f_renamed.get(i5);
                    }
                    int i7 = aVar.f1531c[i6 + 1];
                    bVar.f1532a = i7 <= iAbs;
                    bVar.f1533b = iAbs;
                    bVar.f1534c = i7;
                    bVar.d_renamed = recyclerView2;
                    bVar.e_renamed = aVar.f1531c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        java.util.Collections.sort(this.f_renamed, e_renamed);
    }

    static boolean a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed) {
        int iC = recyclerView.mChildHelper.c_renamed();
        for (int i2 = 0; i2 < iC; i2++) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.d_renamed(i2));
            if (childViewHolderInt.mPosition == i_renamed && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private androidx.recyclerview.widget.RecyclerView.w_renamed a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, long j_renamed) {
        if (a_renamed(recyclerView, i_renamed)) {
            return null;
        }
        androidx.recyclerview.widget.RecyclerView.p_renamed pVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            androidx.recyclerview.widget.RecyclerView.w_renamed wVarA = pVar.a_renamed(i_renamed, false, j_renamed);
            if (wVarA != null) {
                if (wVarA.isBound() && !wVarA.isInvalid()) {
                    pVar.a_renamed(wVarA.itemView);
                } else {
                    pVar.a_renamed(wVarA, false);
                }
            }
            return wVarA;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    private void a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, long j_renamed) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.c_renamed() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        androidx.recyclerview.widget.h_renamed.a_renamed aVar = recyclerView.mPrefetchRegistry;
        aVar.a_renamed(recyclerView, true);
        if (aVar.d_renamed != 0) {
            try {
                androidx.core.d_renamed.a_renamed.a_renamed("RV Nested Prefetch");
                recyclerView.mState.a_renamed(recyclerView.mAdapter);
                for (int i_renamed = 0; i_renamed < aVar.d_renamed * 2; i_renamed += 2) {
                    a_renamed(recyclerView, aVar.f1531c[i_renamed], j_renamed);
                }
            } finally {
                androidx.core.d_renamed.a_renamed.a_renamed();
            }
        }
    }

    private void a_renamed(androidx.recyclerview.widget.h_renamed.b_renamed bVar, long j_renamed) {
        androidx.recyclerview.widget.RecyclerView.w_renamed wVarA = a_renamed(bVar.d_renamed, bVar.e_renamed, bVar.f1532a ? Long.MAX_VALUE : j_renamed);
        if (wVarA == null || wVarA.mNestedRecyclerView == null || !wVarA.isBound() || wVarA.isInvalid()) {
            return;
        }
        a_renamed(wVarA.mNestedRecyclerView.get(), j_renamed);
    }

    private void b_renamed(long j_renamed) {
        for (int i_renamed = 0; i_renamed < this.f_renamed.size(); i_renamed++) {
            androidx.recyclerview.widget.h_renamed.b_renamed bVar = this.f_renamed.get(i_renamed);
            if (bVar.d_renamed == null) {
                return;
            }
            a_renamed(bVar, j_renamed);
            bVar.a_renamed();
        }
    }

    void a_renamed(long j_renamed) {
        a_renamed();
        b_renamed(j_renamed);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            androidx.core.d_renamed.a_renamed.a_renamed("RV Prefetch");
            if (!this.f1527b.isEmpty()) {
                int size = this.f1527b.size();
                long jMax = 0;
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    androidx.recyclerview.widget.RecyclerView recyclerView = this.f1527b.get(i_renamed);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = java.lang.Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    a_renamed(java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(jMax) + this.d_renamed);
                }
            }
        } finally {
            this.f1528c = 0L;
            androidx.core.d_renamed.a_renamed.a_renamed();
        }
    }
}
