package androidx.recyclerview.widget;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SnapHelper.java */
/* renamed from: androidx.recyclerview.widget.s */
/* loaded from: classes.dex */
public abstract class SnapHelper extends RecyclerView.AbstractC0696l {

    /* renamed from: PlatformImplementations.kt_3 */
    RecyclerView f4303a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Scroller f4304b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final RecyclerView.AbstractC0698n f4305c = new RecyclerView.AbstractC0698n() { // from class: androidx.recyclerview.widget.s.1

        /* renamed from: PlatformImplementations.kt_3 */
        boolean f4306a = false;

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0698n
        public void onScrollStateChanged(RecyclerView recyclerView, int OplusGLSurfaceView_13) {
            super.onScrollStateChanged(recyclerView, OplusGLSurfaceView_13);
            if (OplusGLSurfaceView_13 == 0 && this.f4306a) {
                this.f4306a = false;
                SnapHelper.this.m4548a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0698n
        public void onScrolled(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2) {
            if (OplusGLSurfaceView_13 == 0 && i2 == 0) {
                return;
            }
            this.f4306a = true;
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract int mo4486a(RecyclerView.AbstractC0693i abstractC0693i, int OplusGLSurfaceView_13, int i2);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract View mo4487a(RecyclerView.AbstractC0693i abstractC0693i);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract int[] mo4488a(RecyclerView.AbstractC0693i abstractC0693i, View view);

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0696l
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo4162a(int OplusGLSurfaceView_13, int i2) {
        RecyclerView.AbstractC0693i layoutManager = this.f4303a.getLayoutManager();
        if (layoutManager == null || this.f4303a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f4303a.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(OplusGLSurfaceView_13) > minFlingVelocity) && m4546b(layoutManager, OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4549a(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f4303a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            m4547c();
        }
        this.f4303a = recyclerView;
        if (this.f4303a != null) {
            m4545b();
            this.f4304b = new Scroller(this.f4303a.getContext(), new DecelerateInterpolator());
            m4548a();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4545b() throws IllegalStateException {
        if (this.f4303a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f4303a.addOnScrollListener(this.f4305c);
        this.f4303a.setOnFlingListener(this);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m4547c() {
        this.f4303a.removeOnScrollListener(this.f4305c);
        this.f4303a.setOnFlingListener(null);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int[] m4550b(int OplusGLSurfaceView_13, int i2) {
        this.f4304b.fling(0, 0, OplusGLSurfaceView_13, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f4304b.getFinalX(), this.f4304b.getFinalY()};
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m4546b(RecyclerView.AbstractC0693i abstractC0693i, int OplusGLSurfaceView_13, int i2) {
        RecyclerView.AbstractC0703s abstractC0703sMo4522b;
        int iMo4486a;
        if (!(abstractC0693i instanceof RecyclerView.AbstractC0703s.IntrinsicsJvm.kt_4) || (abstractC0703sMo4522b = mo4522b(abstractC0693i)) == null || (iMo4486a = mo4486a(abstractC0693i, OplusGLSurfaceView_13, i2)) == -1) {
            return false;
        }
        abstractC0703sMo4522b.setTargetPosition(iMo4486a);
        abstractC0693i.startSmoothScroll(abstractC0703sMo4522b);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4548a() {
        RecyclerView.AbstractC0693i layoutManager;
        View viewMo4487a;
        RecyclerView recyclerView = this.f4303a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewMo4487a = mo4487a(layoutManager)) == null) {
            return;
        }
        int[] iArrMo4488a = mo4488a(layoutManager, viewMo4487a);
        if (iArrMo4488a[0] == 0 && iArrMo4488a[1] == 0) {
            return;
        }
        this.f4303a.smoothScrollBy(iArrMo4488a[0], iArrMo4488a[1]);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected RecyclerView.AbstractC0703s mo4522b(RecyclerView.AbstractC0693i abstractC0693i) {
        return m4551c(abstractC0693i);
    }

    @Deprecated
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected LinearSmoothScroller m4551c(RecyclerView.AbstractC0693i abstractC0693i) {
        if (abstractC0693i instanceof RecyclerView.AbstractC0703s.IntrinsicsJvm.kt_4) {
            return new LinearSmoothScroller(this.f4303a.getContext()) { // from class: androidx.recyclerview.widget.s.2
                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.AbstractC0703s
                protected void onTargetFound(View view, RecyclerView.C0704t c0704t, RecyclerView.AbstractC0703s.PlatformImplementations.kt_3 aVar) {
                    if (SnapHelper.this.f4303a == null) {
                        return;
                    }
                    SnapHelper abstractC0732s = SnapHelper.this;
                    int[] iArrMo4488a = abstractC0732s.mo4488a(abstractC0732s.f4303a.getLayoutManager(), view);
                    int OplusGLSurfaceView_13 = iArrMo4488a[0];
                    int i2 = iArrMo4488a[1];
                    int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(OplusGLSurfaceView_13), Math.abs(i2)));
                    if (iCalculateTimeForDeceleration > 0) {
                        aVar.m4221a(OplusGLSurfaceView_13, i2, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }
}
