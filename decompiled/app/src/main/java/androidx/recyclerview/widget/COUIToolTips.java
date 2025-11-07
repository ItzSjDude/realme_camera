package androidx.recyclerview.widget;

/* compiled from: SnapHelper.java */
/* loaded from: classes.dex */
public abstract class s_renamed extends androidx.recyclerview.widget.RecyclerView.l_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.recyclerview.widget.RecyclerView f1549a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.widget.Scroller f1550b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final androidx.recyclerview.widget.RecyclerView.n_renamed f1551c = new androidx.recyclerview.widget.RecyclerView.n_renamed() { // from class: androidx.recyclerview.widget.s_renamed.1

        /* renamed from: a_renamed, reason: collision with root package name */
        boolean f1552a = false;

        @Override // androidx.recyclerview.widget.RecyclerView.n_renamed
        public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed) {
            super.onScrollStateChanged(recyclerView, i_renamed);
            if (i_renamed == 0 && this.f1552a) {
                this.f1552a = false;
                androidx.recyclerview.widget.s_renamed.this.a_renamed();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n_renamed
        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
            if (i_renamed == 0 && i2 == 0) {
                return;
            }
            this.f1552a = true;
        }
    };

    public abstract int a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, int i_renamed, int i2);

    public abstract android.view.View a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar);

    public abstract int[] a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, android.view.View view);

    @Override // androidx.recyclerview.widget.RecyclerView.l_renamed
    public boolean a_renamed(int i_renamed, int i2) {
        androidx.recyclerview.widget.RecyclerView.i_renamed layoutManager = this.f1549a.getLayoutManager();
        if (layoutManager == null || this.f1549a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f1549a.getMinFlingVelocity();
        return (java.lang.Math.abs(i2) > minFlingVelocity || java.lang.Math.abs(i_renamed) > minFlingVelocity) && b_renamed(layoutManager, i_renamed, i2);
    }

    public void a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView) throws java.lang.IllegalStateException {
        androidx.recyclerview.widget.RecyclerView recyclerView2 = this.f1549a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            c_renamed();
        }
        this.f1549a = recyclerView;
        if (this.f1549a != null) {
            b_renamed();
            this.f1550b = new android.widget.Scroller(this.f1549a.getContext(), new android.view.animation.DecelerateInterpolator());
            a_renamed();
        }
    }

    private void b_renamed() throws java.lang.IllegalStateException {
        if (this.f1549a.getOnFlingListener() != null) {
            throw new java.lang.IllegalStateException("An instance of_renamed OnFlingListener already set.");
        }
        this.f1549a.addOnScrollListener(this.f1551c);
        this.f1549a.setOnFlingListener(this);
    }

    private void c_renamed() {
        this.f1549a.removeOnScrollListener(this.f1551c);
        this.f1549a.setOnFlingListener(null);
    }

    public int[] b_renamed(int i_renamed, int i2) {
        this.f1550b.fling(0, 0, i_renamed, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f1550b.getFinalX(), this.f1550b.getFinalY()};
    }

    private boolean b_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, int i_renamed, int i2) {
        androidx.recyclerview.widget.RecyclerView.s_renamed sVarB;
        int iA;
        if (!(iVar instanceof androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed) || (sVarB = b_renamed(iVar)) == null || (iA = a_renamed(iVar, i_renamed, i2)) == -1) {
            return false;
        }
        sVarB.setTargetPosition(iA);
        iVar.startSmoothScroll(sVarB);
        return true;
    }

    void a_renamed() {
        androidx.recyclerview.widget.RecyclerView.i_renamed layoutManager;
        android.view.View viewA;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.f1549a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewA = a_renamed(layoutManager)) == null) {
            return;
        }
        int[] iArrA = a_renamed(layoutManager, viewA);
        if (iArrA[0] == 0 && iArrA[1] == 0) {
            return;
        }
        this.f1549a.smoothScrollBy(iArrA[0], iArrA[1]);
    }

    protected androidx.recyclerview.widget.RecyclerView.s_renamed b_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        return c_renamed(iVar);
    }

    @java.lang.Deprecated
    protected androidx.recyclerview.widget.j_renamed c_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        if (iVar instanceof androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed) {
            return new androidx.recyclerview.widget.j_renamed(this.f1549a.getContext()) { // from class: androidx.recyclerview.widget.s_renamed.2
                @Override // androidx.recyclerview.widget.j_renamed, androidx.recyclerview.widget.RecyclerView.s_renamed
                protected void onTargetFound(android.view.View view, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.RecyclerView.s_renamed.a_renamed aVar) {
                    if (androidx.recyclerview.widget.s_renamed.this.f1549a == null) {
                        return;
                    }
                    androidx.recyclerview.widget.s_renamed sVar = androidx.recyclerview.widget.s_renamed.this;
                    int[] iArrA = sVar.a_renamed(sVar.f1549a.getLayoutManager(), view);
                    int i_renamed = iArrA[0];
                    int i2 = iArrA[1];
                    int iCalculateTimeForDeceleration = calculateTimeForDeceleration(java.lang.Math.max(java.lang.Math.abs(i_renamed), java.lang.Math.abs(i2)));
                    if (iCalculateTimeForDeceleration > 0) {
                        aVar.a_renamed(i_renamed, i2, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }

                @Override // androidx.recyclerview.widget.j_renamed
                protected float calculateSpeedPerPixel(android.util.DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }
}
