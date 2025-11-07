package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public class LinearLayoutManager extends androidx.recyclerview.widget.RecyclerView.i_renamed implements androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final java.lang.String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final androidx.recyclerview.widget.LinearLayoutManager.a_renamed mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final androidx.recyclerview.widget.LinearLayoutManager.b_renamed mLayoutChunkResult;
    private androidx.recyclerview.widget.LinearLayoutManager.c_renamed mLayoutState;
    int mOrientation;
    androidx.recyclerview.widget.n_renamed mOrientationHelper;
    androidx.recyclerview.widget.LinearLayoutManager.SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    void onAnchorReady(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.LinearLayoutManager.a_renamed aVar, int i_renamed) {
    }

    public LinearLayoutManager(android.content.Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(android.content.Context context, int i_renamed, boolean z_renamed) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new androidx.recyclerview.widget.LinearLayoutManager.a_renamed();
        this.mLayoutChunkResult = new androidx.recyclerview.widget.LinearLayoutManager.b_renamed();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i_renamed);
        setReverseLayout(z_renamed);
    }

    public LinearLayoutManager(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new androidx.recyclerview.widget.LinearLayoutManager.a_renamed();
        this.mLayoutChunkResult = new androidx.recyclerview.widget.LinearLayoutManager.b_renamed();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        androidx.recyclerview.widget.RecyclerView.i_renamed.b_renamed properties = getProperties(context, attributeSet, i_renamed, i2);
        setOrientation(properties.f1419a);
        setReverseLayout(properties.f1421c);
        setStackFromEnd(properties.d_renamed);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public androidx.recyclerview.widget.RecyclerView.j_renamed generateDefaultLayoutParams() {
        return new androidx.recyclerview.widget.RecyclerView.j_renamed(-2, -2);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean z_renamed) {
        this.mRecycleChildrenOnDetach = z_renamed;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onDetachedFromWindow(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.p_renamed pVar) {
        super.onDetachedFromWindow(recyclerView, pVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(pVar);
            pVar.a_renamed();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public android.os.Parcelable onSaveInstanceState() {
        androidx.recyclerview.widget.LinearLayoutManager.SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            return new androidx.recyclerview.widget.LinearLayoutManager.SavedState(savedState);
        }
        androidx.recyclerview.widget.LinearLayoutManager.SavedState savedState2 = new androidx.recyclerview.widget.LinearLayoutManager.SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z_renamed = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState2.mAnchorLayoutFromEnd = z_renamed;
            if (z_renamed) {
                android.view.View childClosestToEnd = getChildClosestToEnd();
                savedState2.mAnchorOffset = this.mOrientationHelper.e_renamed() - this.mOrientationHelper.b_renamed(childClosestToEnd);
                savedState2.mAnchorPosition = getPosition(childClosestToEnd);
            } else {
                android.view.View childClosestToStart = getChildClosestToStart();
                savedState2.mAnchorPosition = getPosition(childClosestToStart);
                savedState2.mAnchorOffset = this.mOrientationHelper.a_renamed(childClosestToStart) - this.mOrientationHelper.d_renamed();
            }
        } else {
            savedState2.invalidateAnchor();
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (parcelable instanceof androidx.recyclerview.widget.LinearLayoutManager.SavedState) {
            this.mPendingSavedState = (androidx.recyclerview.widget.LinearLayoutManager.SavedState) parcelable;
            if (this.mPendingScrollPosition != -1) {
                this.mPendingSavedState.invalidateAnchor();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public void setStackFromEnd(boolean z_renamed) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z_renamed) {
            return;
        }
        this.mStackFromEnd = z_renamed;
        requestLayout();
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i_renamed) {
        if (i_renamed != 0 && i_renamed != 1) {
            throw new java.lang.IllegalArgumentException("invalid orientation:" + i_renamed);
        }
        assertNotInLayoutOrScroll(null);
        if (i_renamed != this.mOrientation || this.mOrientationHelper == null) {
            this.mOrientationHelper = androidx.recyclerview.widget.n_renamed.a_renamed(this, i_renamed);
            this.mAnchorInfo.f1395a = this.mOrientationHelper;
            this.mOrientation = i_renamed;
            requestLayout();
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public void setReverseLayout(boolean z_renamed) {
        assertNotInLayoutOrScroll(null);
        if (z_renamed == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z_renamed;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public android.view.View findViewByPosition(int i_renamed) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i_renamed - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            android.view.View childAt = getChildAt(position);
            if (getPosition(childAt) == i_renamed) {
                return childAt;
            }
        }
        return super.findViewByPosition(i_renamed);
    }

    @java.lang.Deprecated
    protected int getExtraLayoutSpace(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (tVar.d_renamed()) {
            return this.mOrientationHelper.g_renamed();
        }
        return 0;
    }

    protected void calculateExtraLayoutSpace(androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int[] iArr) {
        int i_renamed;
        int extraLayoutSpace = getExtraLayoutSpace(tVar);
        if (this.mLayoutState.f_renamed == -1) {
            i_renamed = 0;
        } else {
            i_renamed = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i_renamed;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void smoothScrollToPosition(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed) {
        androidx.recyclerview.widget.j_renamed jVar = new androidx.recyclerview.widget.j_renamed(recyclerView.getContext());
        jVar.setTargetPosition(i_renamed);
        startSmoothScroll(jVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed
    public android.graphics.PointF computeScrollVectorForPosition(int i_renamed) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = (i_renamed < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        if (this.mOrientation == 0) {
            return new android.graphics.PointF(i2, 0.0f);
        }
        return new android.graphics.PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        int i_renamed;
        int i2;
        int i3;
        int i4;
        int iFixLayoutEndGap;
        int i5;
        android.view.View viewFindViewByPosition;
        int iA;
        int iE;
        int i6 = -1;
        if ((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && tVar.e_renamed() == 0) {
            removeAndRecycleAllViews(pVar);
            return;
        }
        androidx.recyclerview.widget.LinearLayoutManager.SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureLayoutState();
        this.mLayoutState.f1401a = false;
        resolveShouldLayoutReverse();
        android.view.View focusedChild = getFocusedChild();
        if (!this.mAnchorInfo.e_renamed || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            this.mAnchorInfo.a_renamed();
            androidx.recyclerview.widget.LinearLayoutManager.a_renamed aVar = this.mAnchorInfo;
            aVar.d_renamed = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(pVar, tVar, aVar);
            this.mAnchorInfo.e_renamed = true;
        } else if (focusedChild != null && (this.mOrientationHelper.a_renamed(focusedChild) >= this.mOrientationHelper.e_renamed() || this.mOrientationHelper.b_renamed(focusedChild) <= this.mOrientationHelper.d_renamed())) {
            this.mAnchorInfo.a_renamed(focusedChild, getPosition(focusedChild));
        }
        androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar = this.mLayoutState;
        cVar.f_renamed = cVar.k_renamed >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(tVar, iArr);
        int iMax = java.lang.Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.d_renamed();
        int iMax2 = java.lang.Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.h_renamed();
        if (tVar.a_renamed() && (i5 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (viewFindViewByPosition = findViewByPosition(i5)) != null) {
            if (this.mShouldReverseLayout) {
                iE = this.mOrientationHelper.e_renamed() - this.mOrientationHelper.b_renamed(viewFindViewByPosition);
                iA = this.mPendingScrollPositionOffset;
            } else {
                iA = this.mOrientationHelper.a_renamed(viewFindViewByPosition) - this.mOrientationHelper.d_renamed();
                iE = this.mPendingScrollPositionOffset;
            }
            int i7 = iE - iA;
            if (i7 > 0) {
                iMax += i7;
            } else {
                iMax2 -= i7;
            }
        }
        if (!this.mAnchorInfo.d_renamed ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i6 = 1;
        }
        onAnchorReady(pVar, tVar, this.mAnchorInfo, i6);
        detachAndScrapAttachedViews(pVar);
        this.mLayoutState.m_renamed = resolveIsInfinite();
        this.mLayoutState.j_renamed = tVar.a_renamed();
        this.mLayoutState.i_renamed = 0;
        if (this.mAnchorInfo.d_renamed) {
            updateLayoutStateToFillStart(this.mAnchorInfo);
            androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar2 = this.mLayoutState;
            cVar2.h_renamed = iMax;
            fill(pVar, cVar2, tVar, false);
            i2 = this.mLayoutState.f1402b;
            int i8 = this.mLayoutState.d_renamed;
            if (this.mLayoutState.f1403c > 0) {
                iMax2 += this.mLayoutState.f1403c;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar3 = this.mLayoutState;
            cVar3.h_renamed = iMax2;
            cVar3.d_renamed += this.mLayoutState.e_renamed;
            fill(pVar, this.mLayoutState, tVar, false);
            i_renamed = this.mLayoutState.f1402b;
            if (this.mLayoutState.f1403c > 0) {
                int i9 = this.mLayoutState.f1403c;
                updateLayoutStateToFillStart(i8, i2);
                androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar4 = this.mLayoutState;
                cVar4.h_renamed = i9;
                fill(pVar, cVar4, tVar, false);
                i2 = this.mLayoutState.f1402b;
            }
        } else {
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar5 = this.mLayoutState;
            cVar5.h_renamed = iMax2;
            fill(pVar, cVar5, tVar, false);
            i_renamed = this.mLayoutState.f1402b;
            int i10 = this.mLayoutState.d_renamed;
            if (this.mLayoutState.f1403c > 0) {
                iMax += this.mLayoutState.f1403c;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar6 = this.mLayoutState;
            cVar6.h_renamed = iMax;
            cVar6.d_renamed += this.mLayoutState.e_renamed;
            fill(pVar, this.mLayoutState, tVar, false);
            i2 = this.mLayoutState.f1402b;
            if (this.mLayoutState.f1403c > 0) {
                int i11 = this.mLayoutState.f1403c;
                updateLayoutStateToFillEnd(i10, i_renamed);
                androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar7 = this.mLayoutState;
                cVar7.h_renamed = i11;
                fill(pVar, cVar7, tVar, false);
                i_renamed = this.mLayoutState.f1402b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int iFixLayoutEndGap2 = fixLayoutEndGap(i_renamed, pVar, tVar, true);
                i3 = i2 + iFixLayoutEndGap2;
                i4 = i_renamed + iFixLayoutEndGap2;
                iFixLayoutEndGap = fixLayoutStartGap(i3, pVar, tVar, false);
            } else {
                int iFixLayoutStartGap = fixLayoutStartGap(i2, pVar, tVar, true);
                i3 = i2 + iFixLayoutStartGap;
                i4 = i_renamed + iFixLayoutStartGap;
                iFixLayoutEndGap = fixLayoutEndGap(i4, pVar, tVar, false);
            }
            i2 = i3 + iFixLayoutEndGap;
            i_renamed = i4 + iFixLayoutEndGap;
        }
        layoutForPredictiveAnimations(pVar, tVar, i2, i_renamed);
        if (!tVar.a_renamed()) {
            this.mOrientationHelper.b_renamed();
        } else {
            this.mAnchorInfo.a_renamed();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onLayoutCompleted(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        super.onLayoutCompleted(tVar);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.a_renamed();
    }

    private void layoutForPredictiveAnimations(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed, int i2) {
        if (!tVar.b_renamed() || getChildCount() == 0 || tVar.a_renamed() || !supportsPredictiveItemAnimations()) {
            return;
        }
        java.util.List<androidx.recyclerview.widget.RecyclerView.w_renamed> listC = pVar.c_renamed();
        int size = listC.size();
        int position = getPosition(getChildAt(0));
        int iE = 0;
        int iE2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            androidx.recyclerview.widget.RecyclerView.w_renamed wVar = listC.get(i3);
            if (!wVar.isRemoved()) {
                if (((wVar.getLayoutPosition() < position) != this.mShouldReverseLayout ? (char) 65535 : (char) 1) == 65535) {
                    iE += this.mOrientationHelper.e_renamed(wVar.itemView);
                } else {
                    iE2 += this.mOrientationHelper.e_renamed(wVar.itemView);
                }
            }
        }
        this.mLayoutState.l_renamed = listC;
        if (iE > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i_renamed);
            androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar = this.mLayoutState;
            cVar.h_renamed = iE;
            cVar.f1403c = 0;
            cVar.a_renamed();
            fill(pVar, this.mLayoutState, tVar, false);
        }
        if (iE2 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
            androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar2 = this.mLayoutState;
            cVar2.h_renamed = iE2;
            cVar2.f1403c = 0;
            cVar2.a_renamed();
            fill(pVar, this.mLayoutState, tVar, false);
        }
        this.mLayoutState.l_renamed = null;
    }

    private void updateAnchorInfoForLayout(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.LinearLayoutManager.a_renamed aVar) {
        if (updateAnchorFromPendingData(tVar, aVar) || updateAnchorFromChildren(pVar, tVar, aVar)) {
            return;
        }
        aVar.b_renamed();
        aVar.f1396b = this.mStackFromEnd ? tVar.e_renamed() - 1 : 0;
    }

    private boolean updateAnchorFromChildren(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.LinearLayoutManager.a_renamed aVar) {
        android.view.View viewFindReferenceChildClosestToStart;
        boolean z_renamed = false;
        if (getChildCount() == 0) {
            return false;
        }
        android.view.View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.a_renamed(focusedChild, tVar)) {
            aVar.a_renamed(focusedChild, getPosition(focusedChild));
            return true;
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        if (aVar.d_renamed) {
            viewFindReferenceChildClosestToStart = findReferenceChildClosestToEnd(pVar, tVar);
        } else {
            viewFindReferenceChildClosestToStart = findReferenceChildClosestToStart(pVar, tVar);
        }
        if (viewFindReferenceChildClosestToStart == null) {
            return false;
        }
        aVar.b_renamed(viewFindReferenceChildClosestToStart, getPosition(viewFindReferenceChildClosestToStart));
        if (!tVar.a_renamed() && supportsPredictiveItemAnimations()) {
            int iA = this.mOrientationHelper.a_renamed(viewFindReferenceChildClosestToStart);
            int iB = this.mOrientationHelper.b_renamed(viewFindReferenceChildClosestToStart);
            int iD = this.mOrientationHelper.d_renamed();
            int iE = this.mOrientationHelper.e_renamed();
            if ((iA >= iE && iB > iE) || (iB <= iD && iA < iD)) {
                z_renamed = true;
            }
            if (z_renamed) {
                if (!aVar.d_renamed) {
                    iE = iD;
                }
                aVar.f1397c = iE;
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.LinearLayoutManager.a_renamed aVar) {
        int i_renamed;
        int iA;
        if (!tVar.a_renamed() && (i_renamed = this.mPendingScrollPosition) != -1) {
            if (i_renamed < 0 || i_renamed >= tVar.e_renamed()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                aVar.f1396b = this.mPendingScrollPosition;
                androidx.recyclerview.widget.LinearLayoutManager.SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.hasValidAnchor()) {
                    aVar.d_renamed = this.mPendingSavedState.mAnchorLayoutFromEnd;
                    if (aVar.d_renamed) {
                        aVar.f1397c = this.mOrientationHelper.e_renamed() - this.mPendingSavedState.mAnchorOffset;
                    } else {
                        aVar.f1397c = this.mOrientationHelper.d_renamed() + this.mPendingSavedState.mAnchorOffset;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    android.view.View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (viewFindViewByPosition != null) {
                        if (this.mOrientationHelper.e_renamed(viewFindViewByPosition) > this.mOrientationHelper.g_renamed()) {
                            aVar.b_renamed();
                            return true;
                        }
                        if (this.mOrientationHelper.a_renamed(viewFindViewByPosition) - this.mOrientationHelper.d_renamed() < 0) {
                            aVar.f1397c = this.mOrientationHelper.d_renamed();
                            aVar.d_renamed = false;
                            return true;
                        }
                        if (this.mOrientationHelper.e_renamed() - this.mOrientationHelper.b_renamed(viewFindViewByPosition) < 0) {
                            aVar.f1397c = this.mOrientationHelper.e_renamed();
                            aVar.d_renamed = true;
                            return true;
                        }
                        if (aVar.d_renamed) {
                            iA = this.mOrientationHelper.b_renamed(viewFindViewByPosition) + this.mOrientationHelper.c_renamed();
                        } else {
                            iA = this.mOrientationHelper.a_renamed(viewFindViewByPosition);
                        }
                        aVar.f1397c = iA;
                    } else {
                        if (getChildCount() > 0) {
                            aVar.d_renamed = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                        }
                        aVar.b_renamed();
                    }
                    return true;
                }
                boolean z_renamed = this.mShouldReverseLayout;
                aVar.d_renamed = z_renamed;
                if (z_renamed) {
                    aVar.f1397c = this.mOrientationHelper.e_renamed() - this.mPendingScrollPositionOffset;
                } else {
                    aVar.f1397c = this.mOrientationHelper.d_renamed() + this.mPendingScrollPositionOffset;
                }
                return true;
            }
        }
        return false;
    }

    private int fixLayoutEndGap(int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, boolean z_renamed) {
        int iE;
        int iE2 = this.mOrientationHelper.e_renamed() - i_renamed;
        if (iE2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(-iE2, pVar, tVar);
        int i3 = i_renamed + i2;
        if (!z_renamed || (iE = this.mOrientationHelper.e_renamed() - i3) <= 0) {
            return i2;
        }
        this.mOrientationHelper.a_renamed(iE);
        return iE + i2;
    }

    private int fixLayoutStartGap(int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, boolean z_renamed) {
        int iD;
        int iD2 = i_renamed - this.mOrientationHelper.d_renamed();
        if (iD2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(iD2, pVar, tVar);
        int i3 = i_renamed + i2;
        if (!z_renamed || (iD = i3 - this.mOrientationHelper.d_renamed()) <= 0) {
            return i2;
        }
        this.mOrientationHelper.a_renamed(-iD);
        return i2 - iD;
    }

    private void updateLayoutStateToFillEnd(androidx.recyclerview.widget.LinearLayoutManager.a_renamed aVar) {
        updateLayoutStateToFillEnd(aVar.f1396b, aVar.f1397c);
    }

    private void updateLayoutStateToFillEnd(int i_renamed, int i2) {
        this.mLayoutState.f1403c = this.mOrientationHelper.e_renamed() - i2;
        this.mLayoutState.e_renamed = this.mShouldReverseLayout ? -1 : 1;
        androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar = this.mLayoutState;
        cVar.d_renamed = i_renamed;
        cVar.f_renamed = 1;
        cVar.f1402b = i2;
        cVar.g_renamed = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(androidx.recyclerview.widget.LinearLayoutManager.a_renamed aVar) {
        updateLayoutStateToFillStart(aVar.f1396b, aVar.f1397c);
    }

    private void updateLayoutStateToFillStart(int i_renamed, int i2) {
        this.mLayoutState.f1403c = i2 - this.mOrientationHelper.d_renamed();
        androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar = this.mLayoutState;
        cVar.d_renamed = i_renamed;
        cVar.e_renamed = this.mShouldReverseLayout ? 1 : -1;
        androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar2 = this.mLayoutState;
        cVar2.f_renamed = -1;
        cVar2.f1402b = i2;
        cVar2.g_renamed = Integer.MIN_VALUE;
    }

    protected boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    androidx.recyclerview.widget.LinearLayoutManager.c_renamed createLayoutState() {
        return new androidx.recyclerview.widget.LinearLayoutManager.c_renamed();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void scrollToPosition(int i_renamed) {
        this.mPendingScrollPosition = i_renamed;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        androidx.recyclerview.widget.LinearLayoutManager.SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i_renamed, int i2) {
        this.mPendingScrollPosition = i_renamed;
        this.mPendingScrollPositionOffset = i2;
        androidx.recyclerview.widget.LinearLayoutManager.SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int scrollHorizontallyBy(int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i_renamed, pVar, tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int scrollVerticallyBy(int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i_renamed, pVar, tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeHorizontalScrollOffset(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return computeScrollOffset(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeVerticalScrollOffset(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return computeScrollOffset(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeHorizontalScrollExtent(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return computeScrollExtent(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeVerticalScrollExtent(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return computeScrollExtent(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeHorizontalScrollRange(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return computeScrollRange(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeVerticalScrollRange(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return computeScrollRange(tVar);
    }

    private int computeScrollOffset(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return androidx.recyclerview.widget.q_renamed.a_renamed(tVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollExtent(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return androidx.recyclerview.widget.q_renamed.a_renamed(tVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollRange(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return androidx.recyclerview.widget.q_renamed.b_renamed(tVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean z_renamed) {
        this.mSmoothScrollbarEnabled = z_renamed;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void updateLayoutState(int i_renamed, int i2, boolean z_renamed, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        int iD;
        this.mLayoutState.m_renamed = resolveIsInfinite();
        this.mLayoutState.f_renamed = i_renamed;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(tVar, iArr);
        int iMax = java.lang.Math.max(0, this.mReusableIntPair[0]);
        int iMax2 = java.lang.Math.max(0, this.mReusableIntPair[1]);
        boolean z2 = i_renamed == 1;
        this.mLayoutState.h_renamed = z2 ? iMax2 : iMax;
        androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar = this.mLayoutState;
        if (!z2) {
            iMax = iMax2;
        }
        cVar.i_renamed = iMax;
        if (z2) {
            this.mLayoutState.h_renamed += this.mOrientationHelper.h_renamed();
            android.view.View childClosestToEnd = getChildClosestToEnd();
            this.mLayoutState.e_renamed = this.mShouldReverseLayout ? -1 : 1;
            this.mLayoutState.d_renamed = getPosition(childClosestToEnd) + this.mLayoutState.e_renamed;
            this.mLayoutState.f1402b = this.mOrientationHelper.b_renamed(childClosestToEnd);
            iD = this.mOrientationHelper.b_renamed(childClosestToEnd) - this.mOrientationHelper.e_renamed();
        } else {
            android.view.View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.h_renamed += this.mOrientationHelper.d_renamed();
            this.mLayoutState.e_renamed = this.mShouldReverseLayout ? 1 : -1;
            this.mLayoutState.d_renamed = getPosition(childClosestToStart) + this.mLayoutState.e_renamed;
            this.mLayoutState.f1402b = this.mOrientationHelper.a_renamed(childClosestToStart);
            iD = (-this.mOrientationHelper.a_renamed(childClosestToStart)) + this.mOrientationHelper.d_renamed();
        }
        androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar2 = this.mLayoutState;
        cVar2.f1403c = i2;
        if (z_renamed) {
            cVar2.f1403c -= iD;
        }
        this.mLayoutState.g_renamed = iD;
    }

    boolean resolveIsInfinite() {
        return this.mOrientationHelper.i_renamed() == 0 && this.mOrientationHelper.f_renamed() == 0;
    }

    void collectPrefetchPositionsForLayoutState(androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.i_renamed.a_renamed aVar) {
        int i_renamed = cVar.d_renamed;
        if (i_renamed < 0 || i_renamed >= tVar.e_renamed()) {
            return;
        }
        aVar.b_renamed(i_renamed, java.lang.Math.max(0, cVar.g_renamed));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void collectInitialPrefetchPositions(int i_renamed, androidx.recyclerview.widget.RecyclerView.i_renamed.a_renamed aVar) {
        boolean z_renamed;
        int i2;
        androidx.recyclerview.widget.LinearLayoutManager.SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor()) {
            z_renamed = this.mPendingSavedState.mAnchorLayoutFromEnd;
            i2 = this.mPendingSavedState.mAnchorPosition;
        } else {
            resolveShouldLayoutReverse();
            z_renamed = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z_renamed ? i_renamed - 1 : 0;
            }
        }
        int i3 = z_renamed ? -1 : 1;
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i_renamed; i4++) {
            aVar.b_renamed(i2, 0);
            i2 += i3;
        }
    }

    public void setInitialPrefetchItemCount(int i_renamed) {
        this.mInitialPrefetchItemCount = i_renamed;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void collectAdjacentPrefetchPositions(int i_renamed, int i2, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.RecyclerView.i_renamed.a_renamed aVar) {
        if (this.mOrientation != 0) {
            i_renamed = i2;
        }
        if (getChildCount() == 0 || i_renamed == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(i_renamed > 0 ? 1 : -1, java.lang.Math.abs(i_renamed), true, tVar);
        collectPrefetchPositionsForLayoutState(tVar, this.mLayoutState, aVar);
    }

    int scrollBy(int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (getChildCount() == 0 || i_renamed == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f1401a = true;
        int i2 = i_renamed > 0 ? 1 : -1;
        int iAbs = java.lang.Math.abs(i_renamed);
        updateLayoutState(i2, iAbs, true, tVar);
        int iFill = this.mLayoutState.g_renamed + fill(pVar, this.mLayoutState, tVar, false);
        if (iFill < 0) {
            return 0;
        }
        if (iAbs > iFill) {
            i_renamed = i2 * iFill;
        }
        this.mOrientationHelper.a_renamed(-i_renamed);
        this.mLayoutState.k_renamed = i_renamed;
        return i_renamed;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void assertNotInLayoutOrScroll(java.lang.String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void recycleChildren(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, int i_renamed, int i2) {
        if (i_renamed == i2) {
            return;
        }
        if (i2 <= i_renamed) {
            while (i_renamed > i2) {
                removeAndRecycleViewAt(i_renamed, pVar);
                i_renamed--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i_renamed; i3--) {
                removeAndRecycleViewAt(i3, pVar);
            }
        }
    }

    private void recycleViewsFromStart(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, int i_renamed, int i2) {
        if (i_renamed < 0) {
            return;
        }
        int i3 = i_renamed - i2;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i4 = 0; i4 < childCount; i4++) {
                android.view.View childAt = getChildAt(i4);
                if (this.mOrientationHelper.b_renamed(childAt) > i3 || this.mOrientationHelper.c_renamed(childAt) > i3) {
                    recycleChildren(pVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = childCount - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            android.view.View childAt2 = getChildAt(i6);
            if (this.mOrientationHelper.b_renamed(childAt2) > i3 || this.mOrientationHelper.c_renamed(childAt2) > i3) {
                recycleChildren(pVar, i5, i6);
                return;
            }
        }
    }

    private void recycleViewsFromEnd(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, int i_renamed, int i2) {
        int childCount = getChildCount();
        if (i_renamed < 0) {
            return;
        }
        int iF = (this.mOrientationHelper.f_renamed() - i_renamed) + i2;
        if (this.mShouldReverseLayout) {
            for (int i3 = 0; i3 < childCount; i3++) {
                android.view.View childAt = getChildAt(i3);
                if (this.mOrientationHelper.a_renamed(childAt) < iF || this.mOrientationHelper.d_renamed(childAt) < iF) {
                    recycleChildren(pVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = childCount - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            android.view.View childAt2 = getChildAt(i5);
            if (this.mOrientationHelper.a_renamed(childAt2) < iF || this.mOrientationHelper.d_renamed(childAt2) < iF) {
                recycleChildren(pVar, i4, i5);
                return;
            }
        }
    }

    private void recycleByLayoutState(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar) {
        if (!cVar.f1401a || cVar.m_renamed) {
            return;
        }
        int i_renamed = cVar.g_renamed;
        int i2 = cVar.i_renamed;
        if (cVar.f_renamed == -1) {
            recycleViewsFromEnd(pVar, i_renamed, i2);
        } else {
            recycleViewsFromStart(pVar, i_renamed, i2);
        }
    }

    int fill(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, boolean z_renamed) {
        int i_renamed = cVar.f1403c;
        if (cVar.g_renamed != Integer.MIN_VALUE) {
            if (cVar.f1403c < 0) {
                cVar.g_renamed += cVar.f1403c;
            }
            recycleByLayoutState(pVar, cVar);
        }
        int i2 = cVar.f1403c + cVar.h_renamed;
        androidx.recyclerview.widget.LinearLayoutManager.b_renamed bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.m_renamed && i2 <= 0) || !cVar.a_renamed(tVar)) {
                break;
            }
            bVar.a_renamed();
            layoutChunk(pVar, tVar, cVar, bVar);
            if (!bVar.f1399b) {
                cVar.f1402b += bVar.f1398a * cVar.f_renamed;
                if (!bVar.f1400c || cVar.l_renamed != null || !tVar.a_renamed()) {
                    cVar.f1403c -= bVar.f1398a;
                    i2 -= bVar.f1398a;
                }
                if (cVar.g_renamed != Integer.MIN_VALUE) {
                    cVar.g_renamed += bVar.f1398a;
                    if (cVar.f1403c < 0) {
                        cVar.g_renamed += cVar.f1403c;
                    }
                    recycleByLayoutState(pVar, cVar);
                }
                if (z_renamed && bVar.d_renamed) {
                    break;
                }
            } else {
                break;
            }
        }
        return i_renamed - cVar.f1403c;
    }

    void layoutChunk(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar, androidx.recyclerview.widget.LinearLayoutManager.b_renamed bVar) {
        int i_renamed;
        int i2;
        int i3;
        int paddingLeft;
        int iF;
        android.view.View viewA = cVar.a_renamed(pVar);
        if (viewA == null) {
            bVar.f1399b = true;
            return;
        }
        androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) viewA.getLayoutParams();
        if (cVar.l_renamed == null) {
            if (this.mShouldReverseLayout == (cVar.f_renamed == -1)) {
                addView(viewA);
            } else {
                addView(viewA, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f_renamed == -1)) {
                addDisappearingView(viewA);
            } else {
                addDisappearingView(viewA, 0);
            }
        }
        measureChildWithMargins(viewA, 0, 0);
        bVar.f1398a = this.mOrientationHelper.e_renamed(viewA);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                iF = getWidth() - getPaddingRight();
                paddingLeft = iF - this.mOrientationHelper.f_renamed(viewA);
            } else {
                paddingLeft = getPaddingLeft();
                iF = this.mOrientationHelper.f_renamed(viewA) + paddingLeft;
            }
            if (cVar.f_renamed == -1) {
                int i4 = cVar.f1402b;
                i2 = cVar.f1402b - bVar.f1398a;
                i_renamed = iF;
                i3 = i4;
            } else {
                int i5 = cVar.f1402b;
                i3 = cVar.f1402b + bVar.f1398a;
                i_renamed = iF;
                i2 = i5;
            }
        } else {
            int paddingTop = getPaddingTop();
            int iF2 = this.mOrientationHelper.f_renamed(viewA) + paddingTop;
            if (cVar.f_renamed == -1) {
                i2 = paddingTop;
                i_renamed = cVar.f1402b;
                i3 = iF2;
                paddingLeft = cVar.f1402b - bVar.f1398a;
            } else {
                int i6 = cVar.f1402b;
                i_renamed = cVar.f1402b + bVar.f1398a;
                i2 = paddingTop;
                i3 = iF2;
                paddingLeft = i6;
            }
        }
        layoutDecoratedWithMargins(viewA, paddingLeft, i2, i_renamed, i3);
        if (jVar.d_renamed() || jVar.e_renamed()) {
            bVar.f1400c = true;
        }
        bVar.d_renamed = viewA.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    int convertFocusDirectionToLayoutDirection(int i_renamed) {
        return i_renamed != 1 ? i_renamed != 2 ? i_renamed != 17 ? i_renamed != 33 ? i_renamed != 66 ? (i_renamed == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    private android.view.View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private android.view.View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    android.view.View findFirstVisibleChildClosestToStart(boolean z_renamed, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z_renamed, z2);
        }
        return findOneVisibleChild(0, getChildCount(), z_renamed, z2);
    }

    android.view.View findFirstVisibleChildClosestToEnd(boolean z_renamed, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z_renamed, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z_renamed, z2);
    }

    private android.view.View findReferenceChildClosestToEnd(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return this.mShouldReverseLayout ? findFirstReferenceChild(pVar, tVar) : findLastReferenceChild(pVar, tVar);
    }

    private android.view.View findReferenceChildClosestToStart(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return this.mShouldReverseLayout ? findLastReferenceChild(pVar, tVar) : findFirstReferenceChild(pVar, tVar);
    }

    private android.view.View findFirstReferenceChild(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return findReferenceChild(pVar, tVar, 0, getChildCount(), tVar.e_renamed());
    }

    private android.view.View findLastReferenceChild(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return findReferenceChild(pVar, tVar, getChildCount() - 1, -1, tVar.e_renamed());
    }

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
            int iA = this.mOrientationHelper.a_renamed(childAt);
            int iB = this.mOrientationHelper.b_renamed(childAt);
            if (position >= 0 && position < i3) {
                if (((androidx.recyclerview.widget.RecyclerView.j_renamed) childAt.getLayoutParams()).d_renamed()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if ((iA < iE || iB <= iE) && (iB > iD || iA >= iD)) {
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

    private android.view.View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    private android.view.View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private android.view.View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private android.view.View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public int findFirstVisibleItemPosition() {
        android.view.View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        android.view.View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        android.view.View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        android.view.View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    android.view.View findOneVisibleChild(int i_renamed, int i2, boolean z_renamed, boolean z2) {
        ensureLayoutState();
        int i3 = z_renamed ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a_renamed(i_renamed, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.a_renamed(i_renamed, i2, i3, i4);
    }

    android.view.View findOnePartiallyOrCompletelyInvisibleChild(int i_renamed, int i2) {
        int i3;
        int i4;
        ensureLayoutState();
        if ((i2 > i_renamed ? (char) 1 : i2 < i_renamed ? (char) 65535 : (char) 0) == 0) {
            return getChildAt(i_renamed);
        }
        if (this.mOrientationHelper.a_renamed(getChildAt(i_renamed)) < this.mOrientationHelper.d_renamed()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a_renamed(i_renamed, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.a_renamed(i_renamed, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public android.view.View onFocusSearchFailed(android.view.View view, int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        int iConvertFocusDirectionToLayoutDirection;
        android.view.View viewFindPartiallyOrCompletelyInvisibleChildClosestToEnd;
        android.view.View childClosestToEnd;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i_renamed)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(iConvertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.g_renamed() * MAX_SCROLL_FACTOR), false, tVar);
        androidx.recyclerview.widget.LinearLayoutManager.c_renamed cVar = this.mLayoutState;
        cVar.g_renamed = Integer.MIN_VALUE;
        cVar.f1401a = false;
        fill(pVar, cVar, tVar, true);
        if (iConvertFocusDirectionToLayoutDirection == -1) {
            viewFindPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            viewFindPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (iConvertFocusDirectionToLayoutDirection == -1) {
            childClosestToEnd = getChildClosestToStart();
        } else {
            childClosestToEnd = getChildClosestToEnd();
        }
        if (!childClosestToEnd.hasFocusable()) {
            return viewFindPartiallyOrCompletelyInvisibleChildClosestToEnd;
        }
        if (viewFindPartiallyOrCompletelyInvisibleChildClosestToEnd == null) {
            return null;
        }
        return childClosestToEnd;
    }

    private void logChildren() {
        android.util.Log.d_renamed(TAG, "internal representation of_renamed views on_renamed the screen");
        for (int i_renamed = 0; i_renamed < getChildCount(); i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            android.util.Log.d_renamed(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.a_renamed(childAt));
        }
        android.util.Log.d_renamed(TAG, "==============");
    }

    void validateChildOrder() {
        android.util.Log.d_renamed(TAG, "validating child count " + getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int iA = this.mOrientationHelper.a_renamed(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i_renamed = 1; i_renamed < getChildCount(); i_renamed++) {
                android.view.View childAt = getChildAt(i_renamed);
                int position2 = getPosition(childAt);
                int iA2 = this.mOrientationHelper.a_renamed(childAt);
                if (position2 < position) {
                    logChildren();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("detected invalid position. loc invalid? ");
                    sb.append(iA2 < iA);
                    throw new java.lang.RuntimeException(sb.toString());
                }
                if (iA2 > iA) {
                    logChildren();
                    throw new java.lang.RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i2 = 1; i2 < getChildCount(); i2++) {
            android.view.View childAt2 = getChildAt(i2);
            int position3 = getPosition(childAt2);
            int iA3 = this.mOrientationHelper.a_renamed(childAt2);
            if (position3 < position) {
                logChildren();
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("detected invalid position. loc invalid? ");
                sb2.append(iA3 < iA);
                throw new java.lang.RuntimeException(sb2.toString());
            }
            if (iA3 < iA) {
                logChildren();
                throw new java.lang.RuntimeException("detected invalid location");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void prepareForDrop(android.view.View view, android.view.View view2, int i_renamed, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a_renamed view during a_renamed scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c2 = position < position2 ? (char) 1 : (char) 65535;
        if (this.mShouldReverseLayout) {
            if (c2 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.e_renamed() - (this.mOrientationHelper.a_renamed(view2) + this.mOrientationHelper.e_renamed(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.e_renamed() - this.mOrientationHelper.b_renamed(view2));
                return;
            }
        }
        if (c2 == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.a_renamed(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.b_renamed(view2) - this.mOrientationHelper.e_renamed(view));
        }
    }

    static class c_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        int f1402b;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f1403c;
        int d_renamed;
        int e_renamed;
        int f_renamed;
        int g_renamed;
        int k_renamed;
        boolean m_renamed;

        /* renamed from: a_renamed, reason: collision with root package name */
        boolean f1401a = true;
        int h_renamed = 0;
        int i_renamed = 0;
        boolean j_renamed = false;
        java.util.List<androidx.recyclerview.widget.RecyclerView.w_renamed> l_renamed = null;

        c_renamed() {
        }

        boolean a_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            int i_renamed = this.d_renamed;
            return i_renamed >= 0 && i_renamed < tVar.e_renamed();
        }

        android.view.View a_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar) {
            if (this.l_renamed != null) {
                return b_renamed();
            }
            android.view.View viewC = pVar.c_renamed(this.d_renamed);
            this.d_renamed += this.e_renamed;
            return viewC;
        }

        private android.view.View b_renamed() {
            int size = this.l_renamed.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                android.view.View view = this.l_renamed.get(i_renamed).itemView;
                androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
                if (!jVar.d_renamed() && this.d_renamed == jVar.f_renamed()) {
                    a_renamed(view);
                    return view;
                }
            }
            return null;
        }

        public void a_renamed() {
            a_renamed((android.view.View) null);
        }

        public void a_renamed(android.view.View view) {
            android.view.View viewB = b_renamed(view);
            if (viewB == null) {
                this.d_renamed = -1;
            } else {
                this.d_renamed = ((androidx.recyclerview.widget.RecyclerView.j_renamed) viewB.getLayoutParams()).f_renamed();
            }
        }

        public android.view.View b_renamed(android.view.View view) {
            int iF;
            int size = this.l_renamed.size();
            android.view.View view2 = null;
            int i_renamed = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                android.view.View view3 = this.l_renamed.get(i2).itemView;
                androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view3.getLayoutParams();
                if (view3 != view && !jVar.d_renamed() && (iF = (jVar.f_renamed() - this.d_renamed) * this.e_renamed) >= 0 && iF < i_renamed) {
                    if (iF == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i_renamed = iF;
                }
            }
            return view2;
        }
    }

    @android.annotation.SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<androidx.recyclerview.widget.LinearLayoutManager.SavedState> CREATOR = new android.os.Parcelable.Creator<androidx.recyclerview.widget.LinearLayoutManager.SavedState>() { // from class: androidx.recyclerview.widget.LinearLayoutManager.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.recyclerview.widget.LinearLayoutManager.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.recyclerview.widget.LinearLayoutManager.SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.recyclerview.widget.LinearLayoutManager.SavedState[] newArray(int i_renamed) {
                return new androidx.recyclerview.widget.LinearLayoutManager.SavedState[i_renamed];
            }
        };
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(android.os.Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
        }

        public SavedState(androidx.recyclerview.widget.LinearLayoutManager.SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }

        boolean hasValidAnchor() {
            return this.mAnchorPosition >= 0;
        }

        void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }
    }

    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        androidx.recyclerview.widget.n_renamed f1395a;

        /* renamed from: b_renamed, reason: collision with root package name */
        int f1396b;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f1397c;
        boolean d_renamed;
        boolean e_renamed;

        a_renamed() {
            a_renamed();
        }

        void a_renamed() {
            this.f1396b = -1;
            this.f1397c = Integer.MIN_VALUE;
            this.d_renamed = false;
            this.e_renamed = false;
        }

        void b_renamed() {
            int iD;
            if (this.d_renamed) {
                iD = this.f1395a.e_renamed();
            } else {
                iD = this.f1395a.d_renamed();
            }
            this.f1397c = iD;
        }

        public java.lang.String toString() {
            return "AnchorInfo{mPosition=" + this.f1396b + ", mCoordinate=" + this.f1397c + ", mLayoutFromEnd=" + this.d_renamed + ", mValid=" + this.e_renamed + '}';
        }

        boolean a_renamed(android.view.View view, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
            return !jVar.d_renamed() && jVar.f_renamed() >= 0 && jVar.f_renamed() < tVar.e_renamed();
        }

        public void a_renamed(android.view.View view, int i_renamed) {
            int iC = this.f1395a.c_renamed();
            if (iC >= 0) {
                b_renamed(view, i_renamed);
                return;
            }
            this.f1396b = i_renamed;
            if (this.d_renamed) {
                int iE = (this.f1395a.e_renamed() - iC) - this.f1395a.b_renamed(view);
                this.f1397c = this.f1395a.e_renamed() - iE;
                if (iE > 0) {
                    int iE2 = this.f1397c - this.f1395a.e_renamed(view);
                    int iD = this.f1395a.d_renamed();
                    int iMin = iE2 - (iD + java.lang.Math.min(this.f1395a.a_renamed(view) - iD, 0));
                    if (iMin < 0) {
                        this.f1397c += java.lang.Math.min(iE, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iA = this.f1395a.a_renamed(view);
            int iD2 = iA - this.f1395a.d_renamed();
            this.f1397c = iA;
            if (iD2 > 0) {
                int iE3 = (this.f1395a.e_renamed() - java.lang.Math.min(0, (this.f1395a.e_renamed() - iC) - this.f1395a.b_renamed(view))) - (iA + this.f1395a.e_renamed(view));
                if (iE3 < 0) {
                    this.f1397c -= java.lang.Math.min(iD2, -iE3);
                }
            }
        }

        public void b_renamed(android.view.View view, int i_renamed) {
            if (this.d_renamed) {
                this.f1397c = this.f1395a.b_renamed(view) + this.f1395a.c_renamed();
            } else {
                this.f1397c = this.f1395a.a_renamed(view);
            }
            this.f1396b = i_renamed;
        }
    }

    protected static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f1398a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public boolean f1399b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public boolean f1400c;
        public boolean d_renamed;

        protected b_renamed() {
        }

        void a_renamed() {
            this.f1398a = 0;
            this.f1399b = false;
            this.f1400c = false;
            this.d_renamed = false;
        }
    }
}
