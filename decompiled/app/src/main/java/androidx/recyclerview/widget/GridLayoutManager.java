package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public class GridLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {

    /* renamed from: a_renamed, reason: collision with root package name */
    boolean f1387a;

    /* renamed from: b_renamed, reason: collision with root package name */
    int f1388b;

    /* renamed from: c_renamed, reason: collision with root package name */
    int[] f1389c;
    android.view.View[] d_renamed;
    final android.util.SparseIntArray e_renamed;
    final android.util.SparseIntArray f_renamed;
    androidx.recyclerview.widget.GridLayoutManager.c_renamed g_renamed;
    final android.graphics.Rect h_renamed;
    private boolean i_renamed;

    public GridLayoutManager(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.f1387a = false;
        this.f1388b = -1;
        this.e_renamed = new android.util.SparseIntArray();
        this.f_renamed = new android.util.SparseIntArray();
        this.g_renamed = new androidx.recyclerview.widget.GridLayoutManager.a_renamed();
        this.h_renamed = new android.graphics.Rect();
        a_renamed(getProperties(context, attributeSet, i_renamed, i2).f1420b);
    }

    public GridLayoutManager(android.content.Context context, int i_renamed) {
        super(context);
        this.f1387a = false;
        this.f1388b = -1;
        this.e_renamed = new android.util.SparseIntArray();
        this.f_renamed = new android.util.SparseIntArray();
        this.g_renamed = new androidx.recyclerview.widget.GridLayoutManager.a_renamed();
        this.h_renamed = new android.graphics.Rect();
        a_renamed(i_renamed);
    }

    public GridLayoutManager(android.content.Context context, int i_renamed, int i2, boolean z_renamed) {
        super(context, i2, z_renamed);
        this.f1387a = false;
        this.f1388b = -1;
        this.e_renamed = new android.util.SparseIntArray();
        this.f_renamed = new android.util.SparseIntArray();
        this.g_renamed = new androidx.recyclerview.widget.GridLayoutManager.a_renamed();
        this.h_renamed = new android.graphics.Rect();
        a_renamed(i_renamed);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z_renamed) {
        if (z_renamed) {
            throw new java.lang.UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int getRowCountForAccessibility(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (this.mOrientation == 0) {
            return this.f1388b;
        }
        if (tVar.e_renamed() < 1) {
            return 0;
        }
        return a_renamed(pVar, tVar, tVar.e_renamed() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int getColumnCountForAccessibility(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (this.mOrientation == 1) {
            return this.f1388b;
        }
        if (tVar.e_renamed() < 1) {
            return 0;
        }
        return a_renamed(pVar, tVar, tVar.e_renamed() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onInitializeAccessibilityNodeInfoForItem(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof androidx.recyclerview.widget.GridLayoutManager.b_renamed)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, dVar);
            return;
        }
        androidx.recyclerview.widget.GridLayoutManager.b_renamed bVar = (androidx.recyclerview.widget.GridLayoutManager.b_renamed) layoutParams;
        int iA = a_renamed(pVar, tVar, bVar.f_renamed());
        if (this.mOrientation == 0) {
            dVar.b_renamed(androidx.core.h_renamed.a_renamed.d_renamed.c_renamed.a_renamed(bVar.a_renamed(), bVar.b_renamed(), iA, 1, false, false));
        } else {
            dVar.b_renamed(androidx.core.h_renamed.a_renamed.d_renamed.c_renamed.a_renamed(iA, 1, bVar.a_renamed(), bVar.b_renamed(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (tVar.a_renamed()) {
            c_renamed();
        }
        super.onLayoutChildren(pVar, tVar);
        b_renamed();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onLayoutCompleted(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        super.onLayoutCompleted(tVar);
        this.f1387a = false;
    }

    private void b_renamed() {
        this.e_renamed.clear();
        this.f_renamed.clear();
    }

    private void c_renamed() {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            androidx.recyclerview.widget.GridLayoutManager.b_renamed bVar = (androidx.recyclerview.widget.GridLayoutManager.b_renamed) getChildAt(i_renamed).getLayoutParams();
            int iF = bVar.f_renamed();
            this.e_renamed.put(iF, bVar.b_renamed());
            this.f_renamed.put(iF, bVar.a_renamed());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onItemsAdded(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
        this.g_renamed.a_renamed();
        this.g_renamed.b_renamed();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onItemsChanged(androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.g_renamed.a_renamed();
        this.g_renamed.b_renamed();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onItemsRemoved(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
        this.g_renamed.a_renamed();
        this.g_renamed.b_renamed();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onItemsUpdated(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2, java.lang.Object obj) {
        this.g_renamed.a_renamed();
        this.g_renamed.b_renamed();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onItemsMoved(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2, int i3) {
        this.g_renamed.a_renamed();
        this.g_renamed.b_renamed();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    public androidx.recyclerview.widget.RecyclerView.j_renamed generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new androidx.recyclerview.widget.GridLayoutManager.b_renamed(-2, -1);
        }
        return new androidx.recyclerview.widget.GridLayoutManager.b_renamed(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public androidx.recyclerview.widget.RecyclerView.j_renamed generateLayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.recyclerview.widget.GridLayoutManager.b_renamed(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public androidx.recyclerview.widget.RecyclerView.j_renamed generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
            return new androidx.recyclerview.widget.GridLayoutManager.b_renamed((android.view.ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new androidx.recyclerview.widget.GridLayoutManager.b_renamed(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public boolean checkLayoutParams(androidx.recyclerview.widget.RecyclerView.j_renamed jVar) {
        return jVar instanceof androidx.recyclerview.widget.GridLayoutManager.b_renamed;
    }

    private void d_renamed() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        b_renamed(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void setMeasuredDimension(android.graphics.Rect rect, int i_renamed, int i2) {
        int iChooseSize;
        int iChooseSize2;
        if (this.f1389c == null) {
            super.setMeasuredDimension(rect, i_renamed, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            iChooseSize2 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.f1389c;
            iChooseSize = chooseSize(i_renamed, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = chooseSize(i_renamed, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.f1389c;
            iChooseSize2 = chooseSize(i2, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    private void b_renamed(int i_renamed) {
        this.f1389c = a_renamed(this.f1389c, this.f1388b, i_renamed);
    }

    static int[] a_renamed(int[] iArr, int i_renamed, int i2) {
        int i3;
        if (iArr == null || iArr.length != i_renamed + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i_renamed + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i_renamed;
        int i6 = i2 % i_renamed;
        int i7 = 0;
        for (int i8 = 1; i8 <= i_renamed; i8++) {
            i4 += i6;
            if (i4 <= 0 || i_renamed - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i_renamed;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    int a_renamed(int i_renamed, int i2) {
        if (this.mOrientation == 1 && isLayoutRTL()) {
            int[] iArr = this.f1389c;
            int i3 = this.f1388b;
            return iArr[i3 - i_renamed] - iArr[(i3 - i_renamed) - i2];
        }
        int[] iArr2 = this.f1389c;
        return iArr2[i2 + i_renamed] - iArr2[i_renamed];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void onAnchorReady(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.LinearLayoutManager.a_renamed aVar, int i_renamed) {
        super.onAnchorReady(pVar, tVar, aVar, i_renamed);
        d_renamed();
        if (tVar.e_renamed() > 0 && !tVar.a_renamed()) {
            a_renamed(pVar, tVar, aVar, i_renamed);
        }
        e_renamed();
    }

    private void e_renamed() {
        android.view.View[] viewArr = this.d_renamed;
        if (viewArr == null || viewArr.length != this.f1388b) {
            this.d_renamed = new android.view.View[this.f1388b];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    public int scrollHorizontallyBy(int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        d_renamed();
        e_renamed();
        return super.scrollHorizontallyBy(i_renamed, pVar, tVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    public int scrollVerticallyBy(int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        d_renamed();
        e_renamed();
        return super.scrollVerticallyBy(i_renamed, pVar, tVar);
    }

    private void a_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.LinearLayoutManager.a_renamed aVar, int i_renamed) {
        boolean z_renamed = i_renamed == 1;
        int iB = b_renamed(pVar, tVar, aVar.f1396b);
        if (z_renamed) {
            while (iB > 0 && aVar.f1396b > 0) {
                aVar.f1396b--;
                iB = b_renamed(pVar, tVar, aVar.f1396b);
            }
            return;
        }
        int iE = tVar.e_renamed() - 1;
        int i2 = aVar.f1396b;
        while (i2 < iE) {
            int i3 = i2 + 1;
            int iB2 = b_renamed(pVar, tVar, i3);
            if (iB2 <= iB) {
                break;
            }
            i2 = i3;
            iB = iB2;
        }
        aVar.f1396b = i2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    android.view.View findReferenceChild(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed, int i2, int i3) {
        ensureLayoutState();
        int iD = this.mOrientationHelper.d_renamed();
        int iE = this.mOrientationHelper.e_renamed();
        int i4 = i2 > i_renamed ? 1 : -1;
        android.view.View view = null;
        android.view.View view2 = null;
        while (i_renamed != i2) {
            android.view.View childAt = getChildAt(i_renamed);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3 && b_renamed(pVar, tVar, position) == 0) {
                if (((androidx.recyclerview.widget.RecyclerView.j_renamed) childAt.getLayoutParams()).d_renamed()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.a_renamed(childAt) < iE && this.mOrientationHelper.b_renamed(childAt) >= iD) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i_renamed += i4;
        }
        return view != null ? view : view2;
    }

    private int a_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed) {
        if (!tVar.a_renamed()) {
            return this.g_renamed.c_renamed(i_renamed, this.f1388b);
        }
        int iB = pVar.b_renamed(i_renamed);
        if (iB == -1) {
            android.util.Log.w_renamed("GridLayoutManager", "Cannot find span size for pre layout position. " + i_renamed);
            return 0;
        }
        return this.g_renamed.c_renamed(iB, this.f1388b);
    }

    private int b_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed) {
        if (!tVar.a_renamed()) {
            return this.g_renamed.b_renamed(i_renamed, this.f1388b);
        }
        int i2 = this.f_renamed.get(i_renamed, -1);
        if (i2 != -1) {
            return i2;
        }
        int iB = pVar.b_renamed(i_renamed);
        if (iB == -1) {
            android.util.Log.w_renamed("GridLayoutManager", "Cannot find span size for pre layout position. It is_renamed not cached, not in_renamed the adapter. Pos:" + i_renamed);
            return 0;
        }
        return this.g_renamed.b_renamed(iB, this.f1388b);
    }

    private int c_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed) {
        if (!tVar.a_renamed()) {
            return this.g_renamed.a_renamed(i_renamed);
        }
        int i2 = this.e_renamed.get(i_renamed, -1);
        if (i2 != -1) {
            return i2;
        }
        int iB = pVar.b_renamed(i_renamed);
        if (iB == -1) {
            android.util.Log.w_renamed("GridLayoutManager", "Cannot find span size for pre layout position. It is_renamed not cached, not in_renamed the adapter. Pos:" + i_renamed);
            return 1;
        }
        return this.g_renamed.a_renamed(iB);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.i_renamed.a_renamed aVar) {
        int iA = this.f1388b;
        for (int i_renamed = 0; i_renamed < this.f1388b && cVar.a_renamed(tVar) && iA > 0; i_renamed++) {
            int i2 = cVar.d_renamed;
            aVar.b_renamed(i2, java.lang.Math.max(0, cVar.g_renamed));
            iA -= this.g_renamed.a_renamed(i2);
            cVar.d_renamed += cVar.e_renamed;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v28 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void layoutChunk(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar, androidx.recyclerview.widget.LinearLayoutManager.b_renamed bVar) {
        int i_renamed;
        int i2;
        int i3;
        int i4;
        int iF;
        int i5;
        int iF2;
        int iF3;
        int childMeasureSpec;
        int childMeasureSpec2;
        android.view.View viewA;
        int iJ = this.mOrientationHelper.j_renamed();
        ?? r5 = 0;
        boolean z_renamed = iJ != 1073741824;
        int i6 = getChildCount() > 0 ? this.f1389c[this.f1388b] : 0;
        if (z_renamed) {
            d_renamed();
        }
        boolean z2 = cVar.e_renamed == 1;
        int iB = this.f1388b;
        if (!z2) {
            iB = b_renamed(pVar, tVar, cVar.d_renamed) + c_renamed(pVar, tVar, cVar.d_renamed);
        }
        int i7 = iB;
        int i8 = 0;
        while (i8 < this.f1388b && cVar.a_renamed(tVar) && i7 > 0) {
            int i9 = cVar.d_renamed;
            int iC = c_renamed(pVar, tVar, i9);
            if (iC > this.f1388b) {
                throw new java.lang.IllegalArgumentException("Item at_renamed position " + i9 + " requires " + iC + " spans but GridLayoutManager has only " + this.f1388b + " spans.");
            }
            i7 -= iC;
            if (i7 < 0 || (viewA = cVar.a_renamed(pVar)) == null) {
                break;
            }
            this.d_renamed[i8] = viewA;
            i8++;
        }
        if (i8 == 0) {
            bVar.f1399b = true;
            return;
        }
        float f_renamed = 0.0f;
        a_renamed(pVar, tVar, i8, z2);
        int i10 = 0;
        int i11 = 0;
        while (i10 < i8) {
            android.view.View view = this.d_renamed[i10];
            if (cVar.l_renamed == null) {
                if (z2) {
                    addView(view);
                } else {
                    addView(view, r5);
                }
            } else if (z2) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, r5);
            }
            calculateItemDecorationsForChild(view, this.h_renamed);
            a_renamed(view, iJ, (boolean) r5);
            int iE = this.mOrientationHelper.e_renamed(view);
            if (iE > i11) {
                i11 = iE;
            }
            float f2 = (this.mOrientationHelper.f_renamed(view) * 1.0f) / ((androidx.recyclerview.widget.GridLayoutManager.b_renamed) view.getLayoutParams()).f1391b;
            if (f2 > f_renamed) {
                f_renamed = f2;
            }
            i10++;
            r5 = 0;
        }
        if (z_renamed) {
            a_renamed(f_renamed, i6);
            i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                android.view.View view2 = this.d_renamed[i12];
                a_renamed(view2, 1073741824, true);
                int iE2 = this.mOrientationHelper.e_renamed(view2);
                if (iE2 > i11) {
                    i11 = iE2;
                }
            }
        }
        for (int i13 = 0; i13 < i8; i13++) {
            android.view.View view3 = this.d_renamed[i13];
            if (this.mOrientationHelper.e_renamed(view3) != i11) {
                androidx.recyclerview.widget.GridLayoutManager.b_renamed bVar2 = (androidx.recyclerview.widget.GridLayoutManager.b_renamed) view3.getLayoutParams();
                android.graphics.Rect rect = bVar2.d_renamed;
                int i14 = rect.top + rect.bottom + bVar2.topMargin + bVar2.bottomMargin;
                int i15 = rect.left + rect.right + bVar2.leftMargin + bVar2.rightMargin;
                int iA = a_renamed(bVar2.f1390a, bVar2.f1391b);
                if (this.mOrientation == 1) {
                    childMeasureSpec2 = getChildMeasureSpec(iA, 1073741824, i15, bVar2.width, false);
                    childMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(i11 - i14, 1073741824);
                } else {
                    int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(i11 - i15, 1073741824);
                    childMeasureSpec = getChildMeasureSpec(iA, 1073741824, i14, bVar2.height, false);
                    childMeasureSpec2 = iMakeMeasureSpec;
                }
                a_renamed(view3, childMeasureSpec2, childMeasureSpec, true);
            }
        }
        int i16 = 0;
        bVar.f1398a = i11;
        if (this.mOrientation == 1) {
            if (cVar.f_renamed == -1) {
                int i17 = cVar.f1402b;
                i_renamed = i17 - i11;
                i2 = i17;
            } else {
                int i18 = cVar.f1402b;
                i2 = i18 + i11;
                i_renamed = i18;
            }
            i4 = 0;
            i3 = 0;
        } else if (cVar.f_renamed == -1) {
            i3 = cVar.f1402b;
            i4 = i3 - i11;
            i_renamed = 0;
            i2 = 0;
        } else {
            int i19 = cVar.f1402b;
            int i20 = i19 + i11;
            i_renamed = 0;
            i2 = 0;
            i3 = i20;
            i4 = i19;
        }
        while (i16 < i8) {
            android.view.View view4 = this.d_renamed[i16];
            androidx.recyclerview.widget.GridLayoutManager.b_renamed bVar3 = (androidx.recyclerview.widget.GridLayoutManager.b_renamed) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.f1389c[this.f1388b - bVar3.f1390a];
                    iF3 = paddingLeft;
                    i5 = i_renamed;
                    iF2 = i2;
                    iF = paddingLeft - this.mOrientationHelper.f_renamed(view4);
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.f1389c[bVar3.f1390a];
                    iF = paddingLeft2;
                    i5 = i_renamed;
                    iF2 = i2;
                    iF3 = this.mOrientationHelper.f_renamed(view4) + paddingLeft2;
                }
            } else {
                int paddingTop = getPaddingTop() + this.f1389c[bVar3.f1390a];
                iF = i4;
                i5 = paddingTop;
                iF2 = this.mOrientationHelper.f_renamed(view4) + paddingTop;
                iF3 = i3;
            }
            layoutDecoratedWithMargins(view4, iF, i5, iF3, iF2);
            if (bVar3.d_renamed() || bVar3.e_renamed()) {
                bVar.f1400c = true;
            }
            bVar.d_renamed |= view4.hasFocusable();
            i16++;
            i4 = iF;
            i_renamed = i5;
            i3 = iF3;
            i2 = iF2;
        }
        java.util.Arrays.fill(this.d_renamed, (java.lang.Object) null);
    }

    private void a_renamed(android.view.View view, int i_renamed, boolean z_renamed) {
        int childMeasureSpec;
        int childMeasureSpec2;
        androidx.recyclerview.widget.GridLayoutManager.b_renamed bVar = (androidx.recyclerview.widget.GridLayoutManager.b_renamed) view.getLayoutParams();
        android.graphics.Rect rect = bVar.d_renamed;
        int i2 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i3 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int iA = a_renamed(bVar.f1390a, bVar.f1391b);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = getChildMeasureSpec(iA, i_renamed, i3, bVar.width, false);
            childMeasureSpec = getChildMeasureSpec(this.mOrientationHelper.g_renamed(), getHeightMode(), i2, bVar.height, true);
        } else {
            int childMeasureSpec3 = getChildMeasureSpec(iA, i_renamed, i2, bVar.height, false);
            int childMeasureSpec4 = getChildMeasureSpec(this.mOrientationHelper.g_renamed(), getWidthMode(), i3, bVar.width, true);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        a_renamed(view, childMeasureSpec2, childMeasureSpec, z_renamed);
    }

    private void a_renamed(float f_renamed, int i_renamed) {
        b_renamed(java.lang.Math.max(java.lang.Math.round(f_renamed * this.f1388b), i_renamed));
    }

    private void a_renamed(android.view.View view, int i_renamed, int i2, boolean z_renamed) {
        boolean zShouldMeasureChild;
        androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
        if (z_renamed) {
            zShouldMeasureChild = shouldReMeasureChild(view, i_renamed, i2, jVar);
        } else {
            zShouldMeasureChild = shouldMeasureChild(view, i_renamed, i2, jVar);
        }
        if (zShouldMeasureChild) {
            view.measure(i_renamed, i2);
        }
    }

    private void a_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed, boolean z_renamed) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z_renamed) {
            i3 = 1;
            i5 = i_renamed;
            i2 = 0;
        } else {
            i2 = i_renamed - 1;
            i3 = -1;
        }
        while (i2 != i5) {
            android.view.View view = this.d_renamed[i2];
            androidx.recyclerview.widget.GridLayoutManager.b_renamed bVar = (androidx.recyclerview.widget.GridLayoutManager.b_renamed) view.getLayoutParams();
            bVar.f1391b = c_renamed(pVar, tVar, getPosition(view));
            bVar.f1390a = i4;
            i4 += bVar.f1391b;
            i2 += i3;
        }
    }

    public int a_renamed() {
        return this.f1388b;
    }

    public void a_renamed(int i_renamed) {
        if (i_renamed == this.f1388b) {
            return;
        }
        this.f1387a = true;
        if (i_renamed < 1) {
            throw new java.lang.IllegalArgumentException("Span count should be_renamed at_renamed least 1. Provided " + i_renamed);
        }
        this.f1388b = i_renamed;
        this.g_renamed.a_renamed();
        requestLayout();
    }

    public static abstract class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final android.util.SparseIntArray f1392a = new android.util.SparseIntArray();

        /* renamed from: b_renamed, reason: collision with root package name */
        final android.util.SparseIntArray f1393b = new android.util.SparseIntArray();

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f1394c = false;
        private boolean d_renamed = false;

        public abstract int a_renamed(int i_renamed);

        public void a_renamed() {
            this.f1392a.clear();
        }

        public void b_renamed() {
            this.f1393b.clear();
        }

        int b_renamed(int i_renamed, int i2) {
            if (!this.f1394c) {
                return a_renamed(i_renamed, i2);
            }
            int i3 = this.f1392a.get(i_renamed, -1);
            if (i3 != -1) {
                return i3;
            }
            int iA = a_renamed(i_renamed, i2);
            this.f1392a.put(i_renamed, iA);
            return iA;
        }

        int c_renamed(int i_renamed, int i2) {
            if (!this.d_renamed) {
                return d_renamed(i_renamed, i2);
            }
            int i3 = this.f1393b.get(i_renamed, -1);
            if (i3 != -1) {
                return i3;
            }
            int iD = d_renamed(i_renamed, i2);
            this.f1393b.put(i_renamed, iD);
            return iD;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:18:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B_renamed:14:0x002b -> B_renamed:17:0x0030). Please report as_renamed a_renamed decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B_renamed:15:0x002d -> B_renamed:17:0x0030). Please report as_renamed a_renamed decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B_renamed:16:0x002f -> B_renamed:17:0x0030). Please report as_renamed a_renamed decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int a_renamed(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.a_renamed(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.f1394c
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.f1392a
                int r2 = a_renamed(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.f1392a
                int r3 = r3.get(r2)
                int r4 = r5.a_renamed(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = r1
                r3 = r2
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.a_renamed(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = r1
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c_renamed.a_renamed(int, int):int");
        }

        static int a_renamed(android.util.SparseIntArray sparseIntArray, int i_renamed) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i_renamed) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        public int d_renamed(int i_renamed, int i2) {
            int iA;
            int i3;
            int i4;
            int iA2;
            if (!this.d_renamed || (iA2 = a_renamed(this.f1393b, i_renamed)) == -1) {
                iA = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i3 = this.f1393b.get(iA2);
                i4 = iA2 + 1;
                iA = a_renamed(iA2) + b_renamed(iA2, i2);
                if (iA == i2) {
                    i3++;
                    iA = 0;
                }
            }
            int iA3 = a_renamed(i_renamed);
            while (i4 < i_renamed) {
                int iA4 = a_renamed(i4);
                iA += iA4;
                if (iA == i2) {
                    i3++;
                    iA = 0;
                } else if (iA > i2) {
                    i3++;
                    iA = iA4;
                }
                i4++;
            }
            return iA + iA3 > i2 ? i3 + 1 : i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:58:0x00d7, code lost:
    
        if (r13 == (r2 > r8)) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B_renamed:78:0x0105  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onFocusSearchFailed(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.p_renamed r25, androidx.recyclerview.widget.RecyclerView.t_renamed r26) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$p_renamed, androidx.recyclerview.widget.RecyclerView$t_renamed):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f1387a;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeHorizontalScrollRange(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (this.i_renamed) {
            return a_renamed(tVar);
        }
        return super.computeHorizontalScrollRange(tVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeVerticalScrollRange(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (this.i_renamed) {
            return a_renamed(tVar);
        }
        return super.computeVerticalScrollRange(tVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeHorizontalScrollOffset(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (this.i_renamed) {
            return b_renamed(tVar);
        }
        return super.computeHorizontalScrollOffset(tVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeVerticalScrollOffset(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (this.i_renamed) {
            return b_renamed(tVar);
        }
        return super.computeVerticalScrollOffset(tVar);
    }

    private int a_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (getChildCount() != 0 && tVar.e_renamed() != 0) {
            ensureLayoutState();
            android.view.View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            android.view.View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.g_renamed.c_renamed(tVar.e_renamed() - 1, this.f1388b) + 1;
                }
                int iB = this.mOrientationHelper.b_renamed(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.a_renamed(viewFindFirstVisibleChildClosestToStart);
                int iC = this.g_renamed.c_renamed(getPosition(viewFindFirstVisibleChildClosestToStart), this.f1388b);
                return (int) ((iB / ((this.g_renamed.c_renamed(getPosition(viewFindFirstVisibleChildClosestToEnd), this.f1388b) - iC) + 1)) * (this.g_renamed.c_renamed(tVar.e_renamed() - 1, this.f1388b) + 1));
            }
        }
        return 0;
    }

    private int b_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        int iMax;
        if (getChildCount() != 0 && tVar.e_renamed() != 0) {
            ensureLayoutState();
            boolean zIsSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            android.view.View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!zIsSmoothScrollbarEnabled, true);
            android.view.View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!zIsSmoothScrollbarEnabled, true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                int iC = this.g_renamed.c_renamed(getPosition(viewFindFirstVisibleChildClosestToStart), this.f1388b);
                int iC2 = this.g_renamed.c_renamed(getPosition(viewFindFirstVisibleChildClosestToEnd), this.f1388b);
                int iMin = java.lang.Math.min(iC, iC2);
                int iMax2 = java.lang.Math.max(iC, iC2);
                int iC3 = this.g_renamed.c_renamed(tVar.e_renamed() - 1, this.f1388b) + 1;
                if (this.mShouldReverseLayout) {
                    iMax = java.lang.Math.max(0, (iC3 - iMax2) - 1);
                } else {
                    iMax = java.lang.Math.max(0, iMin);
                }
                if (!zIsSmoothScrollbarEnabled) {
                    return iMax;
                }
                return java.lang.Math.round((iMax * (java.lang.Math.abs(this.mOrientationHelper.b_renamed(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.a_renamed(viewFindFirstVisibleChildClosestToStart)) / ((this.g_renamed.c_renamed(getPosition(viewFindFirstVisibleChildClosestToEnd), this.f1388b) - this.g_renamed.c_renamed(getPosition(viewFindFirstVisibleChildClosestToStart), this.f1388b)) + 1))) + (this.mOrientationHelper.d_renamed() - this.mOrientationHelper.a_renamed(viewFindFirstVisibleChildClosestToStart)));
            }
        }
        return 0;
    }

    public static final class a_renamed extends androidx.recyclerview.widget.GridLayoutManager.c_renamed {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c_renamed
        public int a_renamed(int i_renamed) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c_renamed
        public int a_renamed(int i_renamed, int i2) {
            return i_renamed % i2;
        }
    }

    public static class b_renamed extends androidx.recyclerview.widget.RecyclerView.j_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f1390a;

        /* renamed from: b_renamed, reason: collision with root package name */
        int f1391b;

        public b_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1390a = -1;
            this.f1391b = 0;
        }

        public b_renamed(int i_renamed, int i2) {
            super(i_renamed, i2);
            this.f1390a = -1;
            this.f1391b = 0;
        }

        public b_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1390a = -1;
            this.f1391b = 0;
        }

        public b_renamed(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1390a = -1;
            this.f1391b = 0;
        }

        public int a_renamed() {
            return this.f1390a;
        }

        public int b_renamed() {
            return this.f1391b;
        }
    }
}
