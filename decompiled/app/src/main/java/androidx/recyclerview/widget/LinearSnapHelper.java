package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LinearSnapHelper.java */
/* renamed from: androidx.recyclerview.widget.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class LinearSnapHelper extends SnapHelper {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private OrientationHelper f4291b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private OrientationHelper f4292c;

    @Override // androidx.recyclerview.widget.SnapHelper
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo4488a(RecyclerView.AbstractC0693i abstractC0693i, View view) {
        int[] iArr = new int[2];
        if (abstractC0693i.canScrollHorizontally()) {
            iArr[0] = m4480a(view, m4485e(abstractC0693i));
        } else {
            iArr[0] = 0;
        }
        if (abstractC0693i.canScrollVertically()) {
            iArr[1] = m4480a(view, m4484d(abstractC0693i));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.SnapHelper
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo4486a(RecyclerView.AbstractC0693i abstractC0693i, int OplusGLSurfaceView_13, int i2) {
        int itemCount;
        View viewMo4487a;
        int position;
        int i3;
        PointF pointFComputeScrollVectorForPosition;
        int iM4481a;
        int iM4481a2;
        if (!(abstractC0693i instanceof RecyclerView.AbstractC0703s.IntrinsicsJvm.kt_4) || (itemCount = abstractC0693i.getItemCount()) == 0 || (viewMo4487a = mo4487a(abstractC0693i)) == null || (position = abstractC0693i.getPosition(viewMo4487a)) == -1 || (pointFComputeScrollVectorForPosition = ((RecyclerView.AbstractC0703s.IntrinsicsJvm.kt_4) abstractC0693i).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return -1;
        }
        if (abstractC0693i.canScrollHorizontally()) {
            iM4481a = m4481a(abstractC0693i, m4485e(abstractC0693i), OplusGLSurfaceView_13, 0);
            if (pointFComputeScrollVectorForPosition.x < 0.0f) {
                iM4481a = -iM4481a;
            }
        } else {
            iM4481a = 0;
        }
        if (abstractC0693i.canScrollVertically()) {
            iM4481a2 = m4481a(abstractC0693i, m4484d(abstractC0693i), 0, i2);
            if (pointFComputeScrollVectorForPosition.y < 0.0f) {
                iM4481a2 = -iM4481a2;
            }
        } else {
            iM4481a2 = 0;
        }
        if (!abstractC0693i.canScrollVertically()) {
            iM4481a2 = iM4481a;
        }
        if (iM4481a2 == 0) {
            return -1;
        }
        int i4 = position + iM4481a2;
        if (i4 < 0) {
            i4 = 0;
        }
        return i4 >= itemCount ? i3 : i4;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    /* renamed from: PlatformImplementations.kt_3 */
    public View mo4487a(RecyclerView.AbstractC0693i abstractC0693i) {
        if (abstractC0693i.canScrollVertically()) {
            return m4482a(abstractC0693i, m4484d(abstractC0693i));
        }
        if (abstractC0693i.canScrollHorizontally()) {
            return m4482a(abstractC0693i, m4485e(abstractC0693i));
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m4480a(View view, OrientationHelper abstractC0727n) {
        return (abstractC0727n.mo4498a(view) + (abstractC0727n.mo4508e(view) / 2)) - (abstractC0727n.mo4505d() + (abstractC0727n.mo4511g() / 2));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m4481a(RecyclerView.AbstractC0693i abstractC0693i, OrientationHelper abstractC0727n, int OplusGLSurfaceView_13, int i2) {
        int[] iArrB = m4550b(OplusGLSurfaceView_13, i2);
        float fM4483b = m4483b(abstractC0693i, abstractC0727n);
        if (fM4483b <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(iArrB[0]) > Math.abs(iArrB[1]) ? iArrB[0] : iArrB[1]) / fM4483b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private View m4482a(RecyclerView.AbstractC0693i abstractC0693i, OrientationHelper abstractC0727n) {
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

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float m4483b(RecyclerView.AbstractC0693i abstractC0693i, OrientationHelper abstractC0727n) {
        int childCount = abstractC0693i.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        int OplusGLSurfaceView_13 = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        View view2 = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = abstractC0693i.getChildAt(i3);
            int position = abstractC0693i.getPosition(childAt);
            if (position != -1) {
                if (position < i2) {
                    view = childAt;
                    i2 = position;
                }
                if (position > OplusGLSurfaceView_13) {
                    view2 = childAt;
                    OplusGLSurfaceView_13 = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int iMax = Math.max(abstractC0727n.mo4501b(view), abstractC0727n.mo4501b(view2)) - Math.min(abstractC0727n.mo4498a(view), abstractC0727n.mo4498a(view2));
        if (iMax == 0) {
            return 1.0f;
        }
        return (iMax * 1.0f) / ((OplusGLSurfaceView_13 - i2) + 1);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private OrientationHelper m4484d(RecyclerView.AbstractC0693i abstractC0693i) {
        OrientationHelper abstractC0727n = this.f4291b;
        if (abstractC0727n == null || abstractC0727n.f4294a != abstractC0693i) {
            this.f4291b = OrientationHelper.m4497b(abstractC0693i);
        }
        return this.f4291b;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private OrientationHelper m4485e(RecyclerView.AbstractC0693i abstractC0693i) {
        OrientationHelper abstractC0727n = this.f4292c;
        if (abstractC0727n == null || abstractC0727n.f4294a != abstractC0693i) {
            this.f4292c = OrientationHelper.m4495a(abstractC0693i);
        }
        return this.f4292c;
    }
}
