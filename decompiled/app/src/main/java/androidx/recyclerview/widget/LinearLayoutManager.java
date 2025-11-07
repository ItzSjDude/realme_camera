package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.AbstractC0693i implements RecyclerView.AbstractC0703s.IntrinsicsJvm.kt_4 {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final C0674a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final C0675b mLayoutChunkResult;
    private C0676c mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    void onAnchorReady(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, C0674a c0674a, int OplusGLSurfaceView_13) {
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int OplusGLSurfaceView_13, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C0674a();
        this.mLayoutChunkResult = new C0675b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(OplusGLSurfaceView_13);
        setReverseLayout(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C0674a();
        this.mLayoutChunkResult = new C0675b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.AbstractC0693i.IntrinsicsJvm.kt_4 properties = getProperties(context, attributeSet, OplusGLSurfaceView_13, i2);
        setOrientation(properties.f4035a);
        setReverseLayout(properties.f4037c);
        setStackFromEnd(properties.f4038d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public RecyclerView.C0694j generateDefaultLayoutParams() {
        return new RecyclerView.C0694j(-2, -2);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.C0700p c0700p) {
        super.onDetachedFromWindow(recyclerView, c0700p);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(c0700p);
            c0700p.m4185a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState2.mAnchorLayoutFromEnd = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState2.mAnchorOffset = this.mOrientationHelper.mo4507e() - this.mOrientationHelper.mo4501b(childClosestToEnd);
                savedState2.mAnchorPosition = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState2.mAnchorPosition = getPosition(childClosestToStart);
                savedState2.mAnchorOffset = this.mOrientationHelper.mo4498a(childClosestToStart) - this.mOrientationHelper.mo4505d();
            }
        } else {
            savedState2.invalidateAnchor();
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            if (this.mPendingScrollPosition != -1) {
                this.mPendingSavedState.invalidateAnchor();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0 && OplusGLSurfaceView_13 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + OplusGLSurfaceView_13);
        }
        assertNotInLayoutOrScroll(null);
        if (OplusGLSurfaceView_13 != this.mOrientation || this.mOrientationHelper == null) {
            this.mOrientationHelper = OrientationHelper.m4496a(this, OplusGLSurfaceView_13);
            this.mAnchorInfo.f3994a = this.mOrientationHelper;
            this.mOrientation = OplusGLSurfaceView_13;
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

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public View findViewByPosition(int OplusGLSurfaceView_13) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = OplusGLSurfaceView_13 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == OplusGLSurfaceView_13) {
                return childAt;
            }
        }
        return super.findViewByPosition(OplusGLSurfaceView_13);
    }

    @Deprecated
    protected int getExtraLayoutSpace(RecyclerView.C0704t c0704t) {
        if (c0704t.m4229d()) {
            return this.mOrientationHelper.mo4511g();
        }
        return 0;
    }

    protected void calculateExtraLayoutSpace(RecyclerView.C0704t c0704t, int[] iArr) {
        int OplusGLSurfaceView_13;
        int extraLayoutSpace = getExtraLayoutSpace(c0704t);
        if (this.mLayoutState.f4008f == -1) {
            OplusGLSurfaceView_13 = 0;
        } else {
            OplusGLSurfaceView_13 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = OplusGLSurfaceView_13;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.C0704t c0704t, int OplusGLSurfaceView_13) {
        LinearSmoothScroller c0723j = new LinearSmoothScroller(recyclerView.getContext());
        c0723j.setTargetPosition(OplusGLSurfaceView_13);
        startSmoothScroll(c0723j);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0703s.IntrinsicsJvm.kt_4
    public PointF computeScrollVectorForPosition(int OplusGLSurfaceView_13) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = (OplusGLSurfaceView_13 < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        if (this.mOrientation == 0) {
            return new PointF(i2, 0.0f);
        }
        return new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onLayoutChildren(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        int OplusGLSurfaceView_13;
        int i2;
        int i3;
        int i4;
        int iFixLayoutEndGap;
        int i5;
        View viewFindViewByPosition;
        int iMo4498a;
        int iMo4507e;
        int i6 = -1;
        if ((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && c0704t.m4230e() == 0) {
            removeAndRecycleAllViews(c0700p);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureLayoutState();
        this.mLayoutState.f4003a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        if (!this.mAnchorInfo.f3998e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            this.mAnchorInfo.m4072a();
            C0674a c0674a = this.mAnchorInfo;
            c0674a.f3997d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(c0700p, c0704t, c0674a);
            this.mAnchorInfo.f3998e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.mo4498a(focusedChild) >= this.mOrientationHelper.mo4507e() || this.mOrientationHelper.mo4501b(focusedChild) <= this.mOrientationHelper.mo4505d())) {
            this.mAnchorInfo.m4073a(focusedChild, getPosition(focusedChild));
        }
        C0676c c0676c = this.mLayoutState;
        c0676c.f4008f = c0676c.f4013k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(c0704t, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.mo4505d();
        int iMax2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.mo4512h();
        if (c0704t.m4226a() && (i5 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (viewFindViewByPosition = findViewByPosition(i5)) != null) {
            if (this.mShouldReverseLayout) {
                iMo4507e = this.mOrientationHelper.mo4507e() - this.mOrientationHelper.mo4501b(viewFindViewByPosition);
                iMo4498a = this.mPendingScrollPositionOffset;
            } else {
                iMo4498a = this.mOrientationHelper.mo4498a(viewFindViewByPosition) - this.mOrientationHelper.mo4505d();
                iMo4507e = this.mPendingScrollPositionOffset;
            }
            int i7 = iMo4507e - iMo4498a;
            if (i7 > 0) {
                iMax += i7;
            } else {
                iMax2 -= i7;
            }
        }
        if (!this.mAnchorInfo.f3997d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i6 = 1;
        }
        onAnchorReady(c0700p, c0704t, this.mAnchorInfo, i6);
        detachAndScrapAttachedViews(c0700p);
        this.mLayoutState.f4015m = resolveIsInfinite();
        this.mLayoutState.f4012j = c0704t.m4226a();
        this.mLayoutState.f4011i = 0;
        if (this.mAnchorInfo.f3997d) {
            updateLayoutStateToFillStart(this.mAnchorInfo);
            C0676c c0676c2 = this.mLayoutState;
            c0676c2.f4010h = iMax;
            fill(c0700p, c0676c2, c0704t, false);
            i2 = this.mLayoutState.f4004b;
            int i8 = this.mLayoutState.f4006d;
            if (this.mLayoutState.f4005c > 0) {
                iMax2 += this.mLayoutState.f4005c;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            C0676c c0676c3 = this.mLayoutState;
            c0676c3.f4010h = iMax2;
            c0676c3.f4006d += this.mLayoutState.f4007e;
            fill(c0700p, this.mLayoutState, c0704t, false);
            OplusGLSurfaceView_13 = this.mLayoutState.f4004b;
            if (this.mLayoutState.f4005c > 0) {
                int i9 = this.mLayoutState.f4005c;
                updateLayoutStateToFillStart(i8, i2);
                C0676c c0676c4 = this.mLayoutState;
                c0676c4.f4010h = i9;
                fill(c0700p, c0676c4, c0704t, false);
                i2 = this.mLayoutState.f4004b;
            }
        } else {
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            C0676c c0676c5 = this.mLayoutState;
            c0676c5.f4010h = iMax2;
            fill(c0700p, c0676c5, c0704t, false);
            OplusGLSurfaceView_13 = this.mLayoutState.f4004b;
            int i10 = this.mLayoutState.f4006d;
            if (this.mLayoutState.f4005c > 0) {
                iMax += this.mLayoutState.f4005c;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            C0676c c0676c6 = this.mLayoutState;
            c0676c6.f4010h = iMax;
            c0676c6.f4006d += this.mLayoutState.f4007e;
            fill(c0700p, this.mLayoutState, c0704t, false);
            i2 = this.mLayoutState.f4004b;
            if (this.mLayoutState.f4005c > 0) {
                int i11 = this.mLayoutState.f4005c;
                updateLayoutStateToFillEnd(i10, OplusGLSurfaceView_13);
                C0676c c0676c7 = this.mLayoutState;
                c0676c7.f4010h = i11;
                fill(c0700p, c0676c7, c0704t, false);
                OplusGLSurfaceView_13 = this.mLayoutState.f4004b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int iFixLayoutEndGap2 = fixLayoutEndGap(OplusGLSurfaceView_13, c0700p, c0704t, true);
                i3 = i2 + iFixLayoutEndGap2;
                i4 = OplusGLSurfaceView_13 + iFixLayoutEndGap2;
                iFixLayoutEndGap = fixLayoutStartGap(i3, c0700p, c0704t, false);
            } else {
                int iFixLayoutStartGap = fixLayoutStartGap(i2, c0700p, c0704t, true);
                i3 = i2 + iFixLayoutStartGap;
                i4 = OplusGLSurfaceView_13 + iFixLayoutStartGap;
                iFixLayoutEndGap = fixLayoutEndGap(i4, c0700p, c0704t, false);
            }
            i2 = i3 + iFixLayoutEndGap;
            OplusGLSurfaceView_13 = i4 + iFixLayoutEndGap;
        }
        layoutForPredictiveAnimations(c0700p, c0704t, i2, OplusGLSurfaceView_13);
        if (!c0704t.m4226a()) {
            this.mOrientationHelper.m4502b();
        } else {
            this.mAnchorInfo.m4072a();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onLayoutCompleted(RecyclerView.C0704t c0704t) {
        super.onLayoutCompleted(c0704t);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.m4072a();
    }

    private void layoutForPredictiveAnimations(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, int OplusGLSurfaceView_13, int i2) {
        if (!c0704t.m4227b() || getChildCount() == 0 || c0704t.m4226a() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.AbstractC0707w> listM4202c = c0700p.m4202c();
        int size = listM4202c.size();
        int position = getPosition(getChildAt(0));
        int iMo4508e = 0;
        int iMo4508e2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.AbstractC0707w abstractC0707w = listM4202c.get(i3);
            if (!abstractC0707w.isRemoved()) {
                if (((abstractC0707w.getLayoutPosition() < position) != this.mShouldReverseLayout ? (char) 65535 : (char) 1) == 65535) {
                    iMo4508e += this.mOrientationHelper.mo4508e(abstractC0707w.itemView);
                } else {
                    iMo4508e2 += this.mOrientationHelper.mo4508e(abstractC0707w.itemView);
                }
            }
        }
        this.mLayoutState.f4014l = listM4202c;
        if (iMo4508e > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), OplusGLSurfaceView_13);
            C0676c c0676c = this.mLayoutState;
            c0676c.f4010h = iMo4508e;
            c0676c.f4005c = 0;
            c0676c.m4080a();
            fill(c0700p, this.mLayoutState, c0704t, false);
        }
        if (iMo4508e2 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
            C0676c c0676c2 = this.mLayoutState;
            c0676c2.f4010h = iMo4508e2;
            c0676c2.f4005c = 0;
            c0676c2.m4080a();
            fill(c0700p, this.mLayoutState, c0704t, false);
        }
        this.mLayoutState.f4014l = null;
    }

    private void updateAnchorInfoForLayout(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, C0674a c0674a) {
        if (updateAnchorFromPendingData(c0704t, c0674a) || updateAnchorFromChildren(c0700p, c0704t, c0674a)) {
            return;
        }
        c0674a.m4075b();
        c0674a.f3995b = this.mStackFromEnd ? c0704t.m4230e() - 1 : 0;
    }

    private boolean updateAnchorFromChildren(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, C0674a c0674a) {
        View viewFindReferenceChildClosestToStart;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && c0674a.m4074a(focusedChild, c0704t)) {
            c0674a.m4073a(focusedChild, getPosition(focusedChild));
            return true;
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        if (c0674a.f3997d) {
            viewFindReferenceChildClosestToStart = findReferenceChildClosestToEnd(c0700p, c0704t);
        } else {
            viewFindReferenceChildClosestToStart = findReferenceChildClosestToStart(c0700p, c0704t);
        }
        if (viewFindReferenceChildClosestToStart == null) {
            return false;
        }
        c0674a.m4076b(viewFindReferenceChildClosestToStart, getPosition(viewFindReferenceChildClosestToStart));
        if (!c0704t.m4226a() && supportsPredictiveItemAnimations()) {
            int iMo4498a = this.mOrientationHelper.mo4498a(viewFindReferenceChildClosestToStart);
            int iMo4501b = this.mOrientationHelper.mo4501b(viewFindReferenceChildClosestToStart);
            int iMo4505d = this.mOrientationHelper.mo4505d();
            int iMo4507e = this.mOrientationHelper.mo4507e();
            if ((iMo4498a >= iMo4507e && iMo4501b > iMo4507e) || (iMo4501b <= iMo4505d && iMo4498a < iMo4505d)) {
                z = true;
            }
            if (z) {
                if (!c0674a.f3997d) {
                    iMo4507e = iMo4505d;
                }
                c0674a.f3996c = iMo4507e;
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.C0704t c0704t, C0674a c0674a) {
        int OplusGLSurfaceView_13;
        int iMo4498a;
        if (!c0704t.m4226a() && (OplusGLSurfaceView_13 = this.mPendingScrollPosition) != -1) {
            if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= c0704t.m4230e()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                c0674a.f3995b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.hasValidAnchor()) {
                    c0674a.f3997d = this.mPendingSavedState.mAnchorLayoutFromEnd;
                    if (c0674a.f3997d) {
                        c0674a.f3996c = this.mOrientationHelper.mo4507e() - this.mPendingSavedState.mAnchorOffset;
                    } else {
                        c0674a.f3996c = this.mOrientationHelper.mo4505d() + this.mPendingSavedState.mAnchorOffset;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (viewFindViewByPosition != null) {
                        if (this.mOrientationHelper.mo4508e(viewFindViewByPosition) > this.mOrientationHelper.mo4511g()) {
                            c0674a.m4075b();
                            return true;
                        }
                        if (this.mOrientationHelper.mo4498a(viewFindViewByPosition) - this.mOrientationHelper.mo4505d() < 0) {
                            c0674a.f3996c = this.mOrientationHelper.mo4505d();
                            c0674a.f3997d = false;
                            return true;
                        }
                        if (this.mOrientationHelper.mo4507e() - this.mOrientationHelper.mo4501b(viewFindViewByPosition) < 0) {
                            c0674a.f3996c = this.mOrientationHelper.mo4507e();
                            c0674a.f3997d = true;
                            return true;
                        }
                        if (c0674a.f3997d) {
                            iMo4498a = this.mOrientationHelper.mo4501b(viewFindViewByPosition) + this.mOrientationHelper.m4503c();
                        } else {
                            iMo4498a = this.mOrientationHelper.mo4498a(viewFindViewByPosition);
                        }
                        c0674a.f3996c = iMo4498a;
                    } else {
                        if (getChildCount() > 0) {
                            c0674a.f3997d = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                        }
                        c0674a.m4075b();
                    }
                    return true;
                }
                boolean z = this.mShouldReverseLayout;
                c0674a.f3997d = z;
                if (z) {
                    c0674a.f3996c = this.mOrientationHelper.mo4507e() - this.mPendingScrollPositionOffset;
                } else {
                    c0674a.f3996c = this.mOrientationHelper.mo4505d() + this.mPendingScrollPositionOffset;
                }
                return true;
            }
        }
        return false;
    }

    private int fixLayoutEndGap(int OplusGLSurfaceView_13, RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, boolean z) {
        int iMo4507e;
        int iMo4507e2 = this.mOrientationHelper.mo4507e() - OplusGLSurfaceView_13;
        if (iMo4507e2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(-iMo4507e2, c0700p, c0704t);
        int i3 = OplusGLSurfaceView_13 + i2;
        if (!z || (iMo4507e = this.mOrientationHelper.mo4507e() - i3) <= 0) {
            return i2;
        }
        this.mOrientationHelper.mo4500a(iMo4507e);
        return iMo4507e + i2;
    }

    private int fixLayoutStartGap(int OplusGLSurfaceView_13, RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, boolean z) {
        int iMo4505d;
        int iMo4505d2 = OplusGLSurfaceView_13 - this.mOrientationHelper.mo4505d();
        if (iMo4505d2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(iMo4505d2, c0700p, c0704t);
        int i3 = OplusGLSurfaceView_13 + i2;
        if (!z || (iMo4505d = i3 - this.mOrientationHelper.mo4505d()) <= 0) {
            return i2;
        }
        this.mOrientationHelper.mo4500a(-iMo4505d);
        return i2 - iMo4505d;
    }

    private void updateLayoutStateToFillEnd(C0674a c0674a) {
        updateLayoutStateToFillEnd(c0674a.f3995b, c0674a.f3996c);
    }

    private void updateLayoutStateToFillEnd(int OplusGLSurfaceView_13, int i2) {
        this.mLayoutState.f4005c = this.mOrientationHelper.mo4507e() - i2;
        this.mLayoutState.f4007e = this.mShouldReverseLayout ? -1 : 1;
        C0676c c0676c = this.mLayoutState;
        c0676c.f4006d = OplusGLSurfaceView_13;
        c0676c.f4008f = 1;
        c0676c.f4004b = i2;
        c0676c.f4009g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(C0674a c0674a) {
        updateLayoutStateToFillStart(c0674a.f3995b, c0674a.f3996c);
    }

    private void updateLayoutStateToFillStart(int OplusGLSurfaceView_13, int i2) {
        this.mLayoutState.f4005c = i2 - this.mOrientationHelper.mo4505d();
        C0676c c0676c = this.mLayoutState;
        c0676c.f4006d = OplusGLSurfaceView_13;
        c0676c.f4007e = this.mShouldReverseLayout ? 1 : -1;
        C0676c c0676c2 = this.mLayoutState;
        c0676c2.f4008f = -1;
        c0676c2.f4004b = i2;
        c0676c2.f4009g = Integer.MIN_VALUE;
    }

    protected boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    C0676c createLayoutState() {
        return new C0676c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void scrollToPosition(int OplusGLSurfaceView_13) {
        this.mPendingScrollPosition = OplusGLSurfaceView_13;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int OplusGLSurfaceView_13, int i2) {
        this.mPendingScrollPosition = OplusGLSurfaceView_13;
        this.mPendingScrollPositionOffset = i2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int scrollHorizontallyBy(int OplusGLSurfaceView_13, RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(OplusGLSurfaceView_13, c0700p, c0704t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int scrollVerticallyBy(int OplusGLSurfaceView_13, RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(OplusGLSurfaceView_13, c0700p, c0704t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeHorizontalScrollOffset(RecyclerView.C0704t c0704t) {
        return computeScrollOffset(c0704t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeVerticalScrollOffset(RecyclerView.C0704t c0704t) {
        return computeScrollOffset(c0704t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeHorizontalScrollExtent(RecyclerView.C0704t c0704t) {
        return computeScrollExtent(c0704t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeVerticalScrollExtent(RecyclerView.C0704t c0704t) {
        return computeScrollExtent(c0704t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeHorizontalScrollRange(RecyclerView.C0704t c0704t) {
        return computeScrollRange(c0704t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeVerticalScrollRange(RecyclerView.C0704t c0704t) {
        return computeScrollRange(c0704t);
    }

    private int computeScrollOffset(RecyclerView.C0704t c0704t) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.m4526a(c0704t, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollExtent(RecyclerView.C0704t c0704t) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.m4525a(c0704t, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollRange(RecyclerView.C0704t c0704t) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.m4527b(c0704t, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void updateLayoutState(int OplusGLSurfaceView_13, int i2, boolean z, RecyclerView.C0704t c0704t) {
        int iMo4505d;
        this.mLayoutState.f4015m = resolveIsInfinite();
        this.mLayoutState.f4008f = OplusGLSurfaceView_13;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(c0704t, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]);
        int iMax2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z2 = OplusGLSurfaceView_13 == 1;
        this.mLayoutState.f4010h = z2 ? iMax2 : iMax;
        C0676c c0676c = this.mLayoutState;
        if (!z2) {
            iMax = iMax2;
        }
        c0676c.f4011i = iMax;
        if (z2) {
            this.mLayoutState.f4010h += this.mOrientationHelper.mo4512h();
            View childClosestToEnd = getChildClosestToEnd();
            this.mLayoutState.f4007e = this.mShouldReverseLayout ? -1 : 1;
            this.mLayoutState.f4006d = getPosition(childClosestToEnd) + this.mLayoutState.f4007e;
            this.mLayoutState.f4004b = this.mOrientationHelper.mo4501b(childClosestToEnd);
            iMo4505d = this.mOrientationHelper.mo4501b(childClosestToEnd) - this.mOrientationHelper.mo4507e();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.f4010h += this.mOrientationHelper.mo4505d();
            this.mLayoutState.f4007e = this.mShouldReverseLayout ? 1 : -1;
            this.mLayoutState.f4006d = getPosition(childClosestToStart) + this.mLayoutState.f4007e;
            this.mLayoutState.f4004b = this.mOrientationHelper.mo4498a(childClosestToStart);
            iMo4505d = (-this.mOrientationHelper.mo4498a(childClosestToStart)) + this.mOrientationHelper.mo4505d();
        }
        C0676c c0676c2 = this.mLayoutState;
        c0676c2.f4005c = i2;
        if (z) {
            c0676c2.f4005c -= iMo4505d;
        }
        this.mLayoutState.f4009g = iMo4505d;
    }

    boolean resolveIsInfinite() {
        return this.mOrientationHelper.mo4513i() == 0 && this.mOrientationHelper.mo4509f() == 0;
    }

    void collectPrefetchPositionsForLayoutState(RecyclerView.C0704t c0704t, C0676c c0676c, RecyclerView.AbstractC0693i.PlatformImplementations.kt_3 aVar) {
        int OplusGLSurfaceView_13 = c0676c.f4006d;
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= c0704t.m4230e()) {
            return;
        }
        aVar.mo4153b(OplusGLSurfaceView_13, Math.max(0, c0676c.f4009g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void collectInitialPrefetchPositions(int OplusGLSurfaceView_13, RecyclerView.AbstractC0693i.PlatformImplementations.kt_3 aVar) {
        boolean z;
        int i2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor()) {
            z = this.mPendingSavedState.mAnchorLayoutFromEnd;
            i2 = this.mPendingSavedState.mAnchorPosition;
        } else {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z ? OplusGLSurfaceView_13 - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < OplusGLSurfaceView_13; i4++) {
            aVar.mo4153b(i2, 0);
            i2 += i3;
        }
    }

    public void setInitialPrefetchItemCount(int OplusGLSurfaceView_13) {
        this.mInitialPrefetchItemCount = OplusGLSurfaceView_13;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void collectAdjacentPrefetchPositions(int OplusGLSurfaceView_13, int i2, RecyclerView.C0704t c0704t, RecyclerView.AbstractC0693i.PlatformImplementations.kt_3 aVar) {
        if (this.mOrientation != 0) {
            OplusGLSurfaceView_13 = i2;
        }
        if (getChildCount() == 0 || OplusGLSurfaceView_13 == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(OplusGLSurfaceView_13 > 0 ? 1 : -1, Math.abs(OplusGLSurfaceView_13), true, c0704t);
        collectPrefetchPositionsForLayoutState(c0704t, this.mLayoutState, aVar);
    }

    int scrollBy(int OplusGLSurfaceView_13, RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        if (getChildCount() == 0 || OplusGLSurfaceView_13 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f4003a = true;
        int i2 = OplusGLSurfaceView_13 > 0 ? 1 : -1;
        int iAbs = Math.abs(OplusGLSurfaceView_13);
        updateLayoutState(i2, iAbs, true, c0704t);
        int iFill = this.mLayoutState.f4009g + fill(c0700p, this.mLayoutState, c0704t, false);
        if (iFill < 0) {
            return 0;
        }
        if (iAbs > iFill) {
            OplusGLSurfaceView_13 = i2 * iFill;
        }
        this.mOrientationHelper.mo4500a(-OplusGLSurfaceView_13);
        this.mLayoutState.f4013k = OplusGLSurfaceView_13;
        return OplusGLSurfaceView_13;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void recycleChildren(RecyclerView.C0700p c0700p, int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 == i2) {
            return;
        }
        if (i2 <= OplusGLSurfaceView_13) {
            while (OplusGLSurfaceView_13 > i2) {
                removeAndRecycleViewAt(OplusGLSurfaceView_13, c0700p);
                OplusGLSurfaceView_13--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= OplusGLSurfaceView_13; i3--) {
                removeAndRecycleViewAt(i3, c0700p);
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.C0700p c0700p, int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 < 0) {
            return;
        }
        int i3 = OplusGLSurfaceView_13 - i2;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (this.mOrientationHelper.mo4501b(childAt) > i3 || this.mOrientationHelper.mo4504c(childAt) > i3) {
                    recycleChildren(c0700p, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = childCount - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            if (this.mOrientationHelper.mo4501b(childAt2) > i3 || this.mOrientationHelper.mo4504c(childAt2) > i3) {
                recycleChildren(c0700p, i5, i6);
                return;
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.C0700p c0700p, int OplusGLSurfaceView_13, int i2) {
        int childCount = getChildCount();
        if (OplusGLSurfaceView_13 < 0) {
            return;
        }
        int iMo4509f = (this.mOrientationHelper.mo4509f() - OplusGLSurfaceView_13) + i2;
        if (this.mShouldReverseLayout) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (this.mOrientationHelper.mo4498a(childAt) < iMo4509f || this.mOrientationHelper.mo4506d(childAt) < iMo4509f) {
                    recycleChildren(c0700p, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = childCount - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View childAt2 = getChildAt(i5);
            if (this.mOrientationHelper.mo4498a(childAt2) < iMo4509f || this.mOrientationHelper.mo4506d(childAt2) < iMo4509f) {
                recycleChildren(c0700p, i4, i5);
                return;
            }
        }
    }

    private void recycleByLayoutState(RecyclerView.C0700p c0700p, C0676c c0676c) {
        if (!c0676c.f4003a || c0676c.f4015m) {
            return;
        }
        int OplusGLSurfaceView_13 = c0676c.f4009g;
        int i2 = c0676c.f4011i;
        if (c0676c.f4008f == -1) {
            recycleViewsFromEnd(c0700p, OplusGLSurfaceView_13, i2);
        } else {
            recycleViewsFromStart(c0700p, OplusGLSurfaceView_13, i2);
        }
    }

    int fill(RecyclerView.C0700p c0700p, C0676c c0676c, RecyclerView.C0704t c0704t, boolean z) {
        int OplusGLSurfaceView_13 = c0676c.f4005c;
        if (c0676c.f4009g != Integer.MIN_VALUE) {
            if (c0676c.f4005c < 0) {
                c0676c.f4009g += c0676c.f4005c;
            }
            recycleByLayoutState(c0700p, c0676c);
        }
        int i2 = c0676c.f4005c + c0676c.f4010h;
        C0675b c0675b = this.mLayoutChunkResult;
        while (true) {
            if ((!c0676c.f4015m && i2 <= 0) || !c0676c.m4082a(c0704t)) {
                break;
            }
            c0675b.m4077a();
            layoutChunk(c0700p, c0704t, c0676c, c0675b);
            if (!c0675b.f4000b) {
                c0676c.f4004b += c0675b.f3999a * c0676c.f4008f;
                if (!c0675b.f4001c || c0676c.f4014l != null || !c0704t.m4226a()) {
                    c0676c.f4005c -= c0675b.f3999a;
                    i2 -= c0675b.f3999a;
                }
                if (c0676c.f4009g != Integer.MIN_VALUE) {
                    c0676c.f4009g += c0675b.f3999a;
                    if (c0676c.f4005c < 0) {
                        c0676c.f4009g += c0676c.f4005c;
                    }
                    recycleByLayoutState(c0700p, c0676c);
                }
                if (z && c0675b.f4002d) {
                    break;
                }
            } else {
                break;
            }
        }
        return OplusGLSurfaceView_13 - c0676c.f4005c;
    }

    void layoutChunk(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, C0676c c0676c, C0675b c0675b) {
        int OplusGLSurfaceView_13;
        int i2;
        int i3;
        int paddingLeft;
        int iMo4510f;
        View viewM4079a = c0676c.m4079a(c0700p);
        if (viewM4079a == null) {
            c0675b.f4000b = true;
            return;
        }
        RecyclerView.C0694j c0694j = (RecyclerView.C0694j) viewM4079a.getLayoutParams();
        if (c0676c.f4014l == null) {
            if (this.mShouldReverseLayout == (c0676c.f4008f == -1)) {
                addView(viewM4079a);
            } else {
                addView(viewM4079a, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (c0676c.f4008f == -1)) {
                addDisappearingView(viewM4079a);
            } else {
                addDisappearingView(viewM4079a, 0);
            }
        }
        measureChildWithMargins(viewM4079a, 0, 0);
        c0675b.f3999a = this.mOrientationHelper.mo4508e(viewM4079a);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                iMo4510f = getWidth() - getPaddingRight();
                paddingLeft = iMo4510f - this.mOrientationHelper.mo4510f(viewM4079a);
            } else {
                paddingLeft = getPaddingLeft();
                iMo4510f = this.mOrientationHelper.mo4510f(viewM4079a) + paddingLeft;
            }
            if (c0676c.f4008f == -1) {
                int i4 = c0676c.f4004b;
                i2 = c0676c.f4004b - c0675b.f3999a;
                OplusGLSurfaceView_13 = iMo4510f;
                i3 = i4;
            } else {
                int i5 = c0676c.f4004b;
                i3 = c0676c.f4004b + c0675b.f3999a;
                OplusGLSurfaceView_13 = iMo4510f;
                i2 = i5;
            }
        } else {
            int paddingTop = getPaddingTop();
            int iMo4510f2 = this.mOrientationHelper.mo4510f(viewM4079a) + paddingTop;
            if (c0676c.f4008f == -1) {
                i2 = paddingTop;
                OplusGLSurfaceView_13 = c0676c.f4004b;
                i3 = iMo4510f2;
                paddingLeft = c0676c.f4004b - c0675b.f3999a;
            } else {
                int i6 = c0676c.f4004b;
                OplusGLSurfaceView_13 = c0676c.f4004b + c0675b.f3999a;
                i2 = paddingTop;
                i3 = iMo4510f2;
                paddingLeft = i6;
            }
        }
        layoutDecoratedWithMargins(viewM4079a, paddingLeft, i2, OplusGLSurfaceView_13, i3);
        if (c0694j.m4155d() || c0694j.m4156e()) {
            c0675b.f4001c = true;
        }
        c0675b.f4002d = viewM4079a.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    int convertFocusDirectionToLayoutDirection(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? OplusGLSurfaceView_13 != 17 ? OplusGLSurfaceView_13 != 33 ? OplusGLSurfaceView_13 != 66 ? (OplusGLSurfaceView_13 == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return findOneVisibleChild(0, getChildCount(), z, z2);
    }

    View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    private View findReferenceChildClosestToEnd(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        return this.mShouldReverseLayout ? findFirstReferenceChild(c0700p, c0704t) : findLastReferenceChild(c0700p, c0704t);
    }

    private View findReferenceChildClosestToStart(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        return this.mShouldReverseLayout ? findLastReferenceChild(c0700p, c0704t) : findFirstReferenceChild(c0700p, c0704t);
    }

    private View findFirstReferenceChild(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        return findReferenceChild(c0700p, c0704t, 0, getChildCount(), c0704t.m4230e());
    }

    private View findLastReferenceChild(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        return findReferenceChild(c0700p, c0704t, getChildCount() - 1, -1, c0704t.m4230e());
    }

    View findReferenceChild(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, int OplusGLSurfaceView_13, int i2, int i3) {
        ensureLayoutState();
        int iMo4505d = this.mOrientationHelper.mo4505d();
        int iMo4507e = this.mOrientationHelper.mo4507e();
        int i4 = i2 > OplusGLSurfaceView_13 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (OplusGLSurfaceView_13 != i2) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            int position = getPosition(childAt);
            int iMo4498a = this.mOrientationHelper.mo4498a(childAt);
            int iMo4501b = this.mOrientationHelper.mo4501b(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.C0694j) childAt.getLayoutParams()).m4155d()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if ((iMo4498a < iMo4507e || iMo4501b <= iMo4507e) && (iMo4501b > iMo4505d || iMo4498a >= iMo4505d)) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            OplusGLSurfaceView_13 += i4;
        }
        return view != null ? view : view2;
    }

    /* renamed from: findPartiallyOrCompletelyInvisibleChildClosestToEnd */
    private View m4068xd47ae7b4() {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    /* renamed from: findPartiallyOrCompletelyInvisibleChildClosestToStart */
    private View m4069xa227d0fb() {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public int findFirstVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    View findOneVisibleChild(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.m4552a(OplusGLSurfaceView_13, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.m4552a(OplusGLSurfaceView_13, i2, i3, i4);
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int OplusGLSurfaceView_13, int i2) {
        int i3;
        int i4;
        ensureLayoutState();
        if ((i2 > OplusGLSurfaceView_13 ? (char) 1 : i2 < OplusGLSurfaceView_13 ? (char) 65535 : (char) 0) == 0) {
            return getChildAt(OplusGLSurfaceView_13);
        }
        if (this.mOrientationHelper.mo4498a(getChildAt(OplusGLSurfaceView_13)) < this.mOrientationHelper.mo4505d()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.m4552a(OplusGLSurfaceView_13, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.m4552a(OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public View onFocusSearchFailed(View view, int OplusGLSurfaceView_13, RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        int iConvertFocusDirectionToLayoutDirection;
        View viewM4068xd47ae7b4;
        View childClosestToEnd;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(OplusGLSurfaceView_13)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(iConvertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.mo4511g() * MAX_SCROLL_FACTOR), false, c0704t);
        C0676c c0676c = this.mLayoutState;
        c0676c.f4009g = Integer.MIN_VALUE;
        c0676c.f4003a = false;
        fill(c0700p, c0676c, c0704t, true);
        if (iConvertFocusDirectionToLayoutDirection == -1) {
            viewM4068xd47ae7b4 = m4069xa227d0fb();
        } else {
            viewM4068xd47ae7b4 = m4068xd47ae7b4();
        }
        if (iConvertFocusDirectionToLayoutDirection == -1) {
            childClosestToEnd = getChildClosestToStart();
        } else {
            childClosestToEnd = getChildClosestToEnd();
        }
        if (!childClosestToEnd.hasFocusable()) {
            return viewM4068xd47ae7b4;
        }
        if (viewM4068xd47ae7b4 == null) {
            return null;
        }
        return childClosestToEnd;
    }

    private void logChildren() {
        Log.IntrinsicsJvm.kt_5(TAG, "internal representation of views on the screen");
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < getChildCount(); OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            Log.IntrinsicsJvm.kt_5(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.mo4498a(childAt));
        }
        Log.IntrinsicsJvm.kt_5(TAG, "==============");
    }

    void validateChildOrder() {
        Log.IntrinsicsJvm.kt_5(TAG, "validating child count " + getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int iMo4498a = this.mOrientationHelper.mo4498a(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 < getChildCount(); OplusGLSurfaceView_13++) {
                View childAt = getChildAt(OplusGLSurfaceView_13);
                int position2 = getPosition(childAt);
                int iMo4498a2 = this.mOrientationHelper.mo4498a(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb = new StringBuilder();
                    sb.append("detected invalid position. loc invalid? ");
                    sb.append(iMo4498a2 < iMo4498a);
                    throw new RuntimeException(sb.toString());
                }
                if (iMo4498a2 > iMo4498a) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i2 = 1; i2 < getChildCount(); i2++) {
            View childAt2 = getChildAt(i2);
            int position3 = getPosition(childAt2);
            int iMo4498a3 = this.mOrientationHelper.mo4498a(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("detected invalid position. loc invalid? ");
                sb2.append(iMo4498a3 < iMo4498a);
                throw new RuntimeException(sb2.toString());
            }
            if (iMo4498a3 < iMo4498a) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void prepareForDrop(View view, View view2, int OplusGLSurfaceView_13, int i2) {
        assertNotInLayoutOrScroll("Cannot drop PlatformImplementations.kt_3 view during PlatformImplementations.kt_3 scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c2 = position < position2 ? (char) 1 : (char) 65535;
        if (this.mShouldReverseLayout) {
            if (c2 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.mo4507e() - (this.mOrientationHelper.mo4498a(view2) + this.mOrientationHelper.mo4508e(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.mo4507e() - this.mOrientationHelper.mo4501b(view2));
                return;
            }
        }
        if (c2 == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.mo4498a(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.mo4501b(view2) - this.mOrientationHelper.mo4508e(view));
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$IntrinsicsJvm.kt_3 */
    static class C0676c {

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f4004b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f4005c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f4006d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        int f4007e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        int f4008f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        int f4009g;

        /* renamed from: OplusGLSurfaceView_5 */
        int f4013k;

        /* renamed from: OplusGLSurfaceView_6 */
        boolean f4015m;

        /* renamed from: PlatformImplementations.kt_3 */
        boolean f4003a = true;

        /* renamed from: COUIBaseListPopupWindow_10 */
        int f4010h = 0;

        /* renamed from: OplusGLSurfaceView_13 */
        int f4011i = 0;

        /* renamed from: OplusGLSurfaceView_15 */
        boolean f4012j = false;

        /* renamed from: OplusGLSurfaceView_14 */
        List<RecyclerView.AbstractC0707w> f4014l = null;

        C0676c() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m4082a(RecyclerView.C0704t c0704t) {
            int OplusGLSurfaceView_13 = this.f4006d;
            return OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < c0704t.m4230e();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        View m4079a(RecyclerView.C0700p c0700p) {
            if (this.f4014l != null) {
                return m4078b();
            }
            View viewM4201c = c0700p.m4201c(this.f4006d);
            this.f4006d += this.f4007e;
            return viewM4201c;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private View m4078b() {
            int size = this.f4014l.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                View view = this.f4014l.get(OplusGLSurfaceView_13).itemView;
                RecyclerView.C0694j c0694j = (RecyclerView.C0694j) view.getLayoutParams();
                if (!c0694j.m4155d() && this.f4006d == c0694j.m4157f()) {
                    m4081a(view);
                    return view;
                }
            }
            return null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4080a() {
            m4081a((View) null);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4081a(View view) {
            View viewM4083b = m4083b(view);
            if (viewM4083b == null) {
                this.f4006d = -1;
            } else {
                this.f4006d = ((RecyclerView.C0694j) viewM4083b.getLayoutParams()).m4157f();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public View m4083b(View view) {
            int iM4157f;
            int size = this.f4014l.size();
            View view2 = null;
            int OplusGLSurfaceView_13 = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.f4014l.get(i2).itemView;
                RecyclerView.C0694j c0694j = (RecyclerView.C0694j) view3.getLayoutParams();
                if (view3 != view && !c0694j.m4155d() && (iM4157f = (c0694j.m4157f() - this.f4006d) * this.f4007e) >= 0 && iM4157f < OplusGLSurfaceView_13) {
                    if (iM4157f == 0) {
                        return view3;
                    }
                    view2 = view3;
                    OplusGLSurfaceView_13 = iM4157f;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.LinearLayoutManager.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
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

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
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
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$PlatformImplementations.kt_3 */
    static class C0674a {

        /* renamed from: PlatformImplementations.kt_3 */
        OrientationHelper f3994a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f3995b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f3996c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean f3997d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        boolean f3998e;

        C0674a() {
            m4072a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4072a() {
            this.f3995b = -1;
            this.f3996c = Integer.MIN_VALUE;
            this.f3997d = false;
            this.f3998e = false;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m4075b() {
            int iMo4505d;
            if (this.f3997d) {
                iMo4505d = this.f3994a.mo4507e();
            } else {
                iMo4505d = this.f3994a.mo4505d();
            }
            this.f3996c = iMo4505d;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f3995b + ", mCoordinate=" + this.f3996c + ", mLayoutFromEnd=" + this.f3997d + ", mValid=" + this.f3998e + '}';
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m4074a(View view, RecyclerView.C0704t c0704t) {
            RecyclerView.C0694j c0694j = (RecyclerView.C0694j) view.getLayoutParams();
            return !c0694j.m4155d() && c0694j.m4157f() >= 0 && c0694j.m4157f() < c0704t.m4230e();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4073a(View view, int OplusGLSurfaceView_13) {
            int iM4503c = this.f3994a.m4503c();
            if (iM4503c >= 0) {
                m4076b(view, OplusGLSurfaceView_13);
                return;
            }
            this.f3995b = OplusGLSurfaceView_13;
            if (this.f3997d) {
                int iMo4507e = (this.f3994a.mo4507e() - iM4503c) - this.f3994a.mo4501b(view);
                this.f3996c = this.f3994a.mo4507e() - iMo4507e;
                if (iMo4507e > 0) {
                    int iMo4508e = this.f3996c - this.f3994a.mo4508e(view);
                    int iMo4505d = this.f3994a.mo4505d();
                    int iMin = iMo4508e - (iMo4505d + Math.min(this.f3994a.mo4498a(view) - iMo4505d, 0));
                    if (iMin < 0) {
                        this.f3996c += Math.min(iMo4507e, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iMo4498a = this.f3994a.mo4498a(view);
            int iMo4505d2 = iMo4498a - this.f3994a.mo4505d();
            this.f3996c = iMo4498a;
            if (iMo4505d2 > 0) {
                int iMo4507e2 = (this.f3994a.mo4507e() - Math.min(0, (this.f3994a.mo4507e() - iM4503c) - this.f3994a.mo4501b(view))) - (iMo4498a + this.f3994a.mo4508e(view));
                if (iMo4507e2 < 0) {
                    this.f3996c -= Math.min(iMo4505d2, -iMo4507e2);
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m4076b(View view, int OplusGLSurfaceView_13) {
            if (this.f3997d) {
                this.f3996c = this.f3994a.mo4501b(view) + this.f3994a.m4503c();
            } else {
                this.f3996c = this.f3994a.mo4498a(view);
            }
            this.f3995b = OplusGLSurfaceView_13;
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$IntrinsicsJvm.kt_4 */
    protected static class C0675b {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f3999a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean f4000b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean f4001c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean f4002d;

        protected C0675b() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4077a() {
            this.f3999a = 0;
            this.f4000b = false;
            this.f4001c = false;
            this.f4002d = false;
        }
    }
}
