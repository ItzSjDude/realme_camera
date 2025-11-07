package androidx.recyclerview.widget;

/* compiled from: PagerSnapHelper.java */
/* loaded from: classes.dex */
public class o_renamed extends androidx.recyclerview.widget.s_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.recyclerview.widget.n_renamed f1544b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.recyclerview.widget.n_renamed f1545c;

    @Override // androidx.recyclerview.widget.s_renamed
    public int[] a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, android.view.View view) {
        int[] iArr = new int[2];
        if (iVar.canScrollHorizontally()) {
            iArr[0] = a_renamed(view, g_renamed(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.canScrollVertically()) {
            iArr[1] = a_renamed(view, f_renamed(iVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.s_renamed
    public android.view.View a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        if (iVar.canScrollVertically()) {
            return a_renamed(iVar, f_renamed(iVar));
        }
        if (iVar.canScrollHorizontally()) {
            return a_renamed(iVar, g_renamed(iVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.s_renamed
    public int a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, int i_renamed, int i2) {
        androidx.recyclerview.widget.n_renamed nVarE;
        int itemCount = iVar.getItemCount();
        if (itemCount == 0 || (nVarE = e_renamed(iVar)) == null) {
            return -1;
        }
        int childCount = iVar.getChildCount();
        android.view.View view = null;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        android.view.View view2 = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            android.view.View childAt = iVar.getChildAt(i5);
            if (childAt != null) {
                int iA = a_renamed(childAt, nVarE);
                if (iA <= 0 && iA > i4) {
                    view2 = childAt;
                    i4 = iA;
                }
                if (iA >= 0 && iA < i3) {
                    view = childAt;
                    i3 = iA;
                }
            }
        }
        boolean zB = b_renamed(iVar, i_renamed, i2);
        if (zB && view != null) {
            return iVar.getPosition(view);
        }
        if (!zB && view2 != null) {
            return iVar.getPosition(view2);
        }
        if (!zB) {
            view2 = view;
        }
        if (view2 == null) {
            return -1;
        }
        int position = iVar.getPosition(view2) + (d_renamed(iVar) == zB ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }

    private boolean b_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, int i_renamed, int i2) {
        return iVar.canScrollHorizontally() ? i_renamed > 0 : i2 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean d_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        android.graphics.PointF pointFComputeScrollVectorForPosition;
        int itemCount = iVar.getItemCount();
        if (!(iVar instanceof androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed) || (pointFComputeScrollVectorForPosition = ((androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed) iVar).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return pointFComputeScrollVectorForPosition.x_renamed < 0.0f || pointFComputeScrollVectorForPosition.y_renamed < 0.0f;
    }

    @Override // androidx.recyclerview.widget.s_renamed
    protected androidx.recyclerview.widget.RecyclerView.s_renamed b_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        if (iVar instanceof androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed) {
            return new androidx.recyclerview.widget.j_renamed(this.f1549a.getContext()) { // from class: androidx.recyclerview.widget.o_renamed.1
                @Override // androidx.recyclerview.widget.j_renamed, androidx.recyclerview.widget.RecyclerView.s_renamed
                protected void onTargetFound(android.view.View view, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.RecyclerView.s_renamed.a_renamed aVar) {
                    androidx.recyclerview.widget.o_renamed oVar = androidx.recyclerview.widget.o_renamed.this;
                    int[] iArrA = oVar.a_renamed(oVar.f1549a.getLayoutManager(), view);
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

                @Override // androidx.recyclerview.widget.j_renamed
                protected int calculateTimeForScrolling(int i_renamed) {
                    return java.lang.Math.min(100, super.calculateTimeForScrolling(i_renamed));
                }
            };
        }
        return null;
    }

    private int a_renamed(android.view.View view, androidx.recyclerview.widget.n_renamed nVar) {
        return (nVar.a_renamed(view) + (nVar.e_renamed(view) / 2)) - (nVar.d_renamed() + (nVar.g_renamed() / 2));
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

    private androidx.recyclerview.widget.n_renamed e_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        if (iVar.canScrollVertically()) {
            return f_renamed(iVar);
        }
        if (iVar.canScrollHorizontally()) {
            return g_renamed(iVar);
        }
        return null;
    }

    private androidx.recyclerview.widget.n_renamed f_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        androidx.recyclerview.widget.n_renamed nVar = this.f1544b;
        if (nVar == null || nVar.f1541a != iVar) {
            this.f1544b = androidx.recyclerview.widget.n_renamed.b_renamed(iVar);
        }
        return this.f1544b;
    }

    private androidx.recyclerview.widget.n_renamed g_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        androidx.recyclerview.widget.n_renamed nVar = this.f1545c;
        if (nVar == null || nVar.f1541a != iVar) {
            this.f1545c = androidx.recyclerview.widget.n_renamed.a_renamed(iVar);
        }
        return this.f1545c;
    }
}
