package com.coui.appcompat.widget;

/* compiled from: COUIFlingLocateHelper.java */
/* loaded from: classes.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.recyclerview.widget.COUIRecyclerView f2951a;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.recyclerview.widget.n_renamed f2953c;
    private androidx.recyclerview.widget.RecyclerView.i_renamed d_renamed;
    private android.content.Context e_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f2952b = 0;
    private androidx.recyclerview.widget.RecyclerView.n_renamed f_renamed = new androidx.recyclerview.widget.RecyclerView.n_renamed() { // from class: com.coui.appcompat.widget.g_renamed.1

        /* renamed from: a_renamed, reason: collision with root package name */
        boolean f2954a = false;

        @Override // androidx.recyclerview.widget.RecyclerView.n_renamed
        public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed) {
            super.onScrollStateChanged(recyclerView, i_renamed);
            if (i_renamed == 0 && this.f2954a) {
                this.f2954a = false;
                com.coui.appcompat.widget.g_renamed.this.b_renamed();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n_renamed
        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
            if (i_renamed == 0 && i2 == 0) {
                return;
            }
            this.f2954a = true;
        }
    };

    public void a_renamed(androidx.recyclerview.widget.COUIRecyclerView cOUIRecyclerView) {
        this.f2951a = cOUIRecyclerView;
        this.e_renamed = cOUIRecyclerView.getContext();
    }

    public void a_renamed(int i_renamed) {
        this.f2952b = i_renamed;
        this.f2951a.addOnScrollListener(this.f_renamed);
    }

    public int a_renamed() {
        return this.f2952b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed() {
        android.view.View viewA;
        int iA;
        int iD;
        androidx.recyclerview.widget.RecyclerView.i_renamed iVarC = c_renamed();
        if (iVarC == null || (viewA = a_renamed(iVarC)) == null) {
            return;
        }
        int i_renamed = this.f2952b;
        if (i_renamed == 2) {
            int iD2 = b_renamed(iVarC).d_renamed() + (b_renamed(iVarC).g_renamed() / 2);
            int itemCount = iVarC.getItemCount() - 1;
            if (iVarC.getPosition(viewA) == 0) {
                iD2 = a_renamed(this.e_renamed) ? b_renamed(iVarC).e_renamed() - (b_renamed(iVarC).e_renamed(viewA) / 2) : b_renamed(iVarC).d_renamed() + (b_renamed(iVarC).e_renamed(viewA) / 2);
            }
            if (iVarC.getPosition(viewA) == itemCount) {
                iD2 = a_renamed(this.e_renamed) ? b_renamed(iVarC).d_renamed() + (b_renamed(iVarC).e_renamed(viewA) / 2) : b_renamed(iVarC).e_renamed() - (b_renamed(iVarC).e_renamed(viewA) / 2);
            }
            int iA2 = (b_renamed(iVarC).a_renamed(viewA) + (b_renamed(iVarC).e_renamed(viewA) / 2)) - iD2;
            if (java.lang.Math.abs(iA2) > 1.0f) {
                this.f2951a.smoothScrollBy(iA2, 0);
                return;
            }
            return;
        }
        if (i_renamed == 1) {
            if (a_renamed(this.e_renamed)) {
                iA = b_renamed(iVarC).b_renamed(viewA);
                iD = b_renamed(iVarC).e_renamed();
            } else {
                iA = b_renamed(iVarC).a_renamed(viewA);
                iD = b_renamed(iVarC).d_renamed();
            }
            int i2 = iA - iD;
            if (java.lang.Math.abs(i2) > 1.0f) {
                this.f2951a.smoothScrollBy(i2, 0);
            }
        }
    }

    private float a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, androidx.recyclerview.widget.n_renamed nVar) {
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
            if (position != -1 && position != iVar.getItemCount() - 1 && position != 0) {
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

    public android.view.View a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        if (iVar.canScrollHorizontally()) {
            int i_renamed = this.f2952b;
            if (i_renamed == 2) {
                return c_renamed(iVar, b_renamed(iVar));
            }
            if (i_renamed == 1) {
                return b_renamed(iVar, b_renamed(iVar));
            }
        }
        return null;
    }

    private androidx.recyclerview.widget.n_renamed b_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        androidx.recyclerview.widget.n_renamed nVar = this.f2953c;
        if (nVar == null || nVar.a_renamed() != iVar) {
            this.f2953c = androidx.recyclerview.widget.n_renamed.a_renamed(iVar);
        }
        return this.f2953c;
    }

    private androidx.recyclerview.widget.RecyclerView.i_renamed c_renamed() {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.d_renamed;
        if (iVar == null || iVar != this.f2951a.getLayoutManager()) {
            this.d_renamed = this.f2951a.getLayoutManager();
        }
        return this.d_renamed;
    }

    private android.view.View b_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, androidx.recyclerview.widget.n_renamed nVar) {
        int iD;
        int childCount = iVar.getChildCount();
        android.view.View view = null;
        if (childCount == 0) {
            return null;
        }
        if (iVar instanceof androidx.recyclerview.widget.LinearLayoutManager) {
            if (((androidx.recyclerview.widget.LinearLayoutManager) iVar).findFirstCompletelyVisibleItemPosition() == iVar.getItemCount() - 1) {
                return null;
            }
        }
        if (a_renamed(this.e_renamed)) {
            iD = nVar.e_renamed();
        } else {
            iD = nVar.d_renamed();
        }
        int i_renamed = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            android.view.View childAt = iVar.getChildAt(i2);
            int iAbs = java.lang.Math.abs((a_renamed(this.e_renamed) ? nVar.b_renamed(childAt) : nVar.a_renamed(childAt)) - iD);
            if (iAbs < i_renamed) {
                view = childAt;
                i_renamed = iAbs;
            }
        }
        return view;
    }

    private android.view.View c_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, androidx.recyclerview.widget.n_renamed nVar) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public int b_renamed(int i_renamed) {
        android.view.View viewA;
        int iRound;
        int iA;
        androidx.recyclerview.widget.RecyclerView.i_renamed iVarC = c_renamed();
        int itemCount = iVarC.getItemCount();
        if (itemCount == 0 || (viewA = a_renamed(iVarC)) == null) {
            return -1;
        }
        int position = iVarC.getPosition(viewA);
        int i2 = itemCount - 1;
        android.graphics.PointF pointFComputeScrollVectorForPosition = ((androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed) iVarC).computeScrollVectorForPosition(i2);
        if (pointFComputeScrollVectorForPosition == null) {
            return -1;
        }
        float fA_renamed = 1.0f;
        if (iVarC.canScrollHorizontally()) {
            fA_renamed = a_renamed(iVarC, b_renamed(iVarC));
            iRound = java.lang.Math.round(i_renamed / fA_renamed);
            if (pointFComputeScrollVectorForPosition.x_renamed < 0.0f) {
                iRound = -iRound;
            }
        } else {
            iRound = 0;
        }
        int i3 = iRound + position;
        if (i3 != position && i3 >= 0 && i3 < itemCount) {
            int i4 = this.f2952b;
            if (i4 == 2) {
                android.view.View childAt = null;
                if (iVarC.getPosition(viewA) == 0 && iVarC.getChildCount() != 0) {
                    childAt = iVarC.getChildAt(iVarC.getChildCount() - 1);
                }
                if (iVarC.getPosition(viewA) == i2 && iVarC.getChildCount() != 0) {
                    childAt = iVarC.getChildAt(0);
                }
                int iD = b_renamed(iVarC).d_renamed() + (b_renamed(iVarC).g_renamed() / 2);
                if (childAt != null) {
                    iA = b_renamed(iVarC).a_renamed(childAt) + (b_renamed(iVarC).e_renamed(childAt) / 2) + (a_renamed(this.e_renamed) ? -((int) ((i3 - iVarC.getPosition(childAt)) * fA_renamed)) : (int) ((i3 - iVarC.getPosition(childAt)) * fA_renamed));
                } else {
                    iA = b_renamed(iVarC).a_renamed(viewA) + (b_renamed(iVarC).e_renamed(viewA) / 2) + (a_renamed(this.e_renamed) ? -((int) ((i3 - iVarC.getPosition(viewA)) * fA_renamed)) : (int) ((i3 - iVarC.getPosition(viewA)) * fA_renamed));
                }
                return iA - iD;
            }
            if (i4 == 1) {
                return ((a_renamed(this.e_renamed) ? b_renamed(iVarC).b_renamed(viewA) : b_renamed(iVarC).a_renamed(viewA)) + (a_renamed(this.e_renamed) ? -((int) ((i3 - position) * fA_renamed)) : (int) ((i3 - position) * fA_renamed))) - (a_renamed(this.e_renamed) ? b_renamed(iVarC).e_renamed() : b_renamed(iVarC).d_renamed());
            }
        }
        return -1;
    }

    private boolean a_renamed(android.content.Context context) {
        return context != null && android.os.Build.VERSION.SDK_INT > 16 && context.getResources().getConfiguration().getLayoutDirection() == 1;
    }
}
