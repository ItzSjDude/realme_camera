package androidx.recyclerview.widget;

/* compiled from: LinearSnapHelper.java */
/* loaded from: classes.dex */
public class k_renamed extends androidx.recyclerview.widget.s_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.recyclerview.widget.n_renamed f1538b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.recyclerview.widget.n_renamed f1539c;

    @Override // androidx.recyclerview.widget.s_renamed
    public int[] a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, android.view.View view) {
        int[] iArr = new int[2];
        if (iVar.canScrollHorizontally()) {
            iArr[0] = a_renamed(view, e_renamed(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.canScrollVertically()) {
            iArr[1] = a_renamed(view, d_renamed(iVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.s_renamed
    public int a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, int i_renamed, int i2) {
        int itemCount;
        android.view.View viewA;
        int position;
        int i3;
        android.graphics.PointF pointFComputeScrollVectorForPosition;
        int iA;
        int iA2;
        if (!(iVar instanceof androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed) || (itemCount = iVar.getItemCount()) == 0 || (viewA = a_renamed(iVar)) == null || (position = iVar.getPosition(viewA)) == -1 || (pointFComputeScrollVectorForPosition = ((androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed) iVar).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return -1;
        }
        if (iVar.canScrollHorizontally()) {
            iA = a_renamed(iVar, e_renamed(iVar), i_renamed, 0);
            if (pointFComputeScrollVectorForPosition.x_renamed < 0.0f) {
                iA = -iA;
            }
        } else {
            iA = 0;
        }
        if (iVar.canScrollVertically()) {
            iA2 = a_renamed(iVar, d_renamed(iVar), 0, i2);
            if (pointFComputeScrollVectorForPosition.y_renamed < 0.0f) {
                iA2 = -iA2;
            }
        } else {
            iA2 = 0;
        }
        if (!iVar.canScrollVertically()) {
            iA2 = iA;
        }
        if (iA2 == 0) {
            return -1;
        }
        int i4 = position + iA2;
        if (i4 < 0) {
            i4 = 0;
        }
        return i4 >= itemCount ? i3 : i4;
    }

    @Override // androidx.recyclerview.widget.s_renamed
    public android.view.View a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        if (iVar.canScrollVertically()) {
            return a_renamed(iVar, d_renamed(iVar));
        }
        if (iVar.canScrollHorizontally()) {
            return a_renamed(iVar, e_renamed(iVar));
        }
        return null;
    }

    private int a_renamed(android.view.View view, androidx.recyclerview.widget.n_renamed nVar) {
        return (nVar.a_renamed(view) + (nVar.e_renamed(view) / 2)) - (nVar.d_renamed() + (nVar.g_renamed() / 2));
    }

    private int a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, androidx.recyclerview.widget.n_renamed nVar, int i_renamed, int i2) {
        int[] iArrB = b_renamed(i_renamed, i2);
        float fB_renamed = b_renamed(iVar, nVar);
        if (fB_renamed <= 0.0f) {
            return 0;
        }
        return java.lang.Math.round((java.lang.Math.abs(iArrB[0]) > java.lang.Math.abs(iArrB[1]) ? iArrB[0] : iArrB[1]) / fB_renamed);
    }

    private android.view.View a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, androidx.recyclerview.widget.n_renamed nVar) {
        int childCount = iVar.getChildCount();
        android.view.View view = null;
        if (childCount == 0) {
            return null;
        }
        int iD = nVar.d_renamed() + (nVar.g_renamed() / 2);
        int i_renamed = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            android.view.View childAt = iVar.getChildAt(i2);
            int iAbs = java.lang.Math.abs((nVar.a_renamed(childAt) + (nVar.e_renamed(childAt) / 2)) - iD);
            if (iAbs < i_renamed) {
                view = childAt;
                i_renamed = iAbs;
            }
        }
        return view;
    }

    private float b_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, androidx.recyclerview.widget.n_renamed nVar) {
        int childCount = iVar.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        android.view.View view = null;
        int i_renamed = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        android.view.View view2 = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            android.view.View childAt = iVar.getChildAt(i3);
            int position = iVar.getPosition(childAt);
            if (position != -1) {
                if (position < i2) {
                    view = childAt;
                    i2 = position;
                }
                if (position > i_renamed) {
                    view2 = childAt;
                    i_renamed = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int iMax = java.lang.Math.max(nVar.b_renamed(view), nVar.b_renamed(view2)) - java.lang.Math.min(nVar.a_renamed(view), nVar.a_renamed(view2));
        if (iMax == 0) {
            return 1.0f;
        }
        return (iMax * 1.0f) / ((i_renamed - i2) + 1);
    }

    private androidx.recyclerview.widget.n_renamed d_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        androidx.recyclerview.widget.n_renamed nVar = this.f1538b;
        if (nVar == null || nVar.f1541a != iVar) {
            this.f1538b = androidx.recyclerview.widget.n_renamed.b_renamed(iVar);
        }
        return this.f1538b;
    }

    private androidx.recyclerview.widget.n_renamed e_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        androidx.recyclerview.widget.n_renamed nVar = this.f1539c;
        if (nVar == null || nVar.f1541a != iVar) {
            this.f1539c = androidx.recyclerview.widget.n_renamed.a_renamed(iVar);
        }
        return this.f1539c;
    }
}
