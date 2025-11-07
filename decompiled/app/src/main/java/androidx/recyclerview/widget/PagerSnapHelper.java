package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PagerSnapHelper.java */
/* renamed from: androidx.recyclerview.widget.o */
/* loaded from: classes.dex */
public class PagerSnapHelper extends SnapHelper {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private OrientationHelper f4297b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private OrientationHelper f4298c;

    @Override // androidx.recyclerview.widget.SnapHelper
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo4488a(RecyclerView.AbstractC0693i abstractC0693i, View view) {
        int[] iArr = new int[2];
        if (abstractC0693i.canScrollHorizontally()) {
            iArr[0] = m4515a(view, m4521g(abstractC0693i));
        } else {
            iArr[0] = 0;
        }
        if (abstractC0693i.canScrollVertically()) {
            iArr[1] = m4515a(view, m4520f(abstractC0693i));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    /* renamed from: PlatformImplementations.kt_3 */
    public View mo4487a(RecyclerView.AbstractC0693i abstractC0693i) {
        if (abstractC0693i.canScrollVertically()) {
            return m4516a(abstractC0693i, m4520f(abstractC0693i));
        }
        if (abstractC0693i.canScrollHorizontally()) {
            return m4516a(abstractC0693i, m4521g(abstractC0693i));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo4486a(RecyclerView.AbstractC0693i abstractC0693i, int OplusGLSurfaceView_13, int i2) {
        OrientationHelper abstractC0727nM4519e;
        int itemCount = abstractC0693i.getItemCount();
        if (itemCount == 0 || (abstractC0727nM4519e = m4519e(abstractC0693i)) == null) {
            return -1;
        }
        int childCount = abstractC0693i.getChildCount();
        View view = null;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = abstractC0693i.getChildAt(i5);
            if (childAt != null) {
                int iM4515a = m4515a(childAt, abstractC0727nM4519e);
                if (iM4515a <= 0 && iM4515a > i4) {
                    view2 = childAt;
                    i4 = iM4515a;
                }
                if (iM4515a >= 0 && iM4515a < i3) {
                    view = childAt;
                    i3 = iM4515a;
                }
            }
        }
        boolean zM4517b = m4517b(abstractC0693i, OplusGLSurfaceView_13, i2);
        if (zM4517b && view != null) {
            return abstractC0693i.getPosition(view);
        }
        if (!zM4517b && view2 != null) {
            return abstractC0693i.getPosition(view2);
        }
        if (!zM4517b) {
            view2 = view;
        }
        if (view2 == null) {
            return -1;
        }
        int position = abstractC0693i.getPosition(view2) + (m4518d(abstractC0693i) == zM4517b ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m4517b(RecyclerView.AbstractC0693i abstractC0693i, int OplusGLSurfaceView_13, int i2) {
        return abstractC0693i.canScrollHorizontally() ? OplusGLSurfaceView_13 > 0 : i2 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m4518d(RecyclerView.AbstractC0693i abstractC0693i) {
        PointF pointFComputeScrollVectorForPosition;
        int itemCount = abstractC0693i.getItemCount();
        if (!(abstractC0693i instanceof RecyclerView.AbstractC0703s.IntrinsicsJvm.kt_4) || (pointFComputeScrollVectorForPosition = ((RecyclerView.AbstractC0703s.IntrinsicsJvm.kt_4) abstractC0693i).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return pointFComputeScrollVectorForPosition.x < 0.0f || pointFComputeScrollVectorForPosition.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected RecyclerView.AbstractC0703s mo4522b(RecyclerView.AbstractC0693i abstractC0693i) {
        if (abstractC0693i instanceof RecyclerView.AbstractC0703s.IntrinsicsJvm.kt_4) {
            return new LinearSmoothScroller(this.f4303a.getContext()) { // from class: androidx.recyclerview.widget.o.1
                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.AbstractC0703s
                protected void onTargetFound(View view, RecyclerView.C0704t c0704t, RecyclerView.AbstractC0703s.PlatformImplementations.kt_3 aVar) {
                    PagerSnapHelper c0728o = PagerSnapHelper.this;
                    int[] iArrMo4488a = c0728o.mo4488a(c0728o.f4303a.getLayoutManager(), view);
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

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected int calculateTimeForScrolling(int OplusGLSurfaceView_13) {
                    return Math.min(100, super.calculateTimeForScrolling(OplusGLSurfaceView_13));
                }
            };
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m4515a(View view, OrientationHelper abstractC0727n) {
        return (abstractC0727n.mo4498a(view) + (abstractC0727n.mo4508e(view) / 2)) - (abstractC0727n.mo4505d() + (abstractC0727n.mo4511g() / 2));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private View m4516a(RecyclerView.AbstractC0693i abstractC0693i, OrientationHelper abstractC0727n) {
        int childCount = abstractC0693i.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int iMo4505d = abstractC0727n.mo4505d() + (abstractC0727n.mo4511g() / 2);
        int OplusGLSurfaceView_13 = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = abstractC0693i.getChildAt(i2);
            int iAbs = Math.abs((abstractC0727n.mo4498a(childAt) + (abstractC0727n.mo4508e(childAt) / 2)) - iMo4505d);
            if (iAbs < OplusGLSurfaceView_13) {
                view = childAt;
                OplusGLSurfaceView_13 = iAbs;
            }
        }
        return view;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private OrientationHelper m4519e(RecyclerView.AbstractC0693i abstractC0693i) {
        if (abstractC0693i.canScrollVertically()) {
            return m4520f(abstractC0693i);
        }
        if (abstractC0693i.canScrollHorizontally()) {
            return m4521g(abstractC0693i);
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private OrientationHelper m4520f(RecyclerView.AbstractC0693i abstractC0693i) {
        OrientationHelper abstractC0727n = this.f4297b;
        if (abstractC0727n == null || abstractC0727n.f4294a != abstractC0693i) {
            this.f4297b = OrientationHelper.m4497b(abstractC0693i);
        }
        return this.f4297b;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private OrientationHelper m4521g(RecyclerView.AbstractC0693i abstractC0693i) {
        OrientationHelper abstractC0727n = this.f4298c;
        if (abstractC0727n == null || abstractC0727n.f4294a != abstractC0693i) {
            this.f4298c = OrientationHelper.m4495a(abstractC0693i);
        }
        return this.f4298c;
    }
}
