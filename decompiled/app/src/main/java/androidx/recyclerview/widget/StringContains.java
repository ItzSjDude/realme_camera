package androidx.recyclerview.widget;

/* compiled from: LinearSmoothScroller.java */
/* loaded from: classes.dex */
public class j_renamed extends androidx.recyclerview.widget.RecyclerView.s_renamed {
    private static final boolean DEBUG = false;
    private static final float MILLISECONDS_PER_INCH = 25.0f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    private final android.util.DisplayMetrics mDisplayMetrics;
    private float mMillisPerPixel;
    protected android.graphics.PointF mTargetVector;
    protected final android.view.animation.LinearInterpolator mLinearInterpolator = new android.view.animation.LinearInterpolator();
    protected final android.view.animation.DecelerateInterpolator mDecelerateInterpolator = new android.view.animation.DecelerateInterpolator();
    private boolean mHasCalculatedMillisPerPixel = false;
    protected int mInterimTargetDx = 0;
    protected int mInterimTargetDy = 0;

    private int clampApplyScroll(int i_renamed, int i2) {
        int i3 = i_renamed - i2;
        if (i_renamed * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s_renamed
    protected void onStart() {
    }

    public j_renamed(android.content.Context context) {
        this.mDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s_renamed
    protected void onTargetFound(android.view.View view, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.RecyclerView.s_renamed.a_renamed aVar) {
        int iCalculateDxToMakeVisible = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
        int iCalculateDyToMakeVisible = calculateDyToMakeVisible(view, getVerticalSnapPreference());
        int iCalculateTimeForDeceleration = calculateTimeForDeceleration((int) java.lang.Math.sqrt((iCalculateDxToMakeVisible * iCalculateDxToMakeVisible) + (iCalculateDyToMakeVisible * iCalculateDyToMakeVisible)));
        if (iCalculateTimeForDeceleration > 0) {
            aVar.a_renamed(-iCalculateDxToMakeVisible, -iCalculateDyToMakeVisible, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s_renamed
    protected void onSeekTargetStep(int i_renamed, int i2, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.RecyclerView.s_renamed.a_renamed aVar) {
        if (getChildCount() == 0) {
            stop();
            return;
        }
        this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, i_renamed);
        this.mInterimTargetDy = clampApplyScroll(this.mInterimTargetDy, i2);
        if (this.mInterimTargetDx == 0 && this.mInterimTargetDy == 0) {
            updateActionForInterimTarget(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s_renamed
    protected void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }

    protected float calculateSpeedPerPixel(android.util.DisplayMetrics displayMetrics) {
        return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
    }

    private float getSpeedPerPixel() {
        if (!this.mHasCalculatedMillisPerPixel) {
            this.mMillisPerPixel = calculateSpeedPerPixel(this.mDisplayMetrics);
            this.mHasCalculatedMillisPerPixel = true;
        }
        return this.mMillisPerPixel;
    }

    protected int calculateTimeForDeceleration(int i_renamed) {
        return (int) java.lang.Math.ceil(calculateTimeForScrolling(i_renamed) / 0.3356d);
    }

    protected int calculateTimeForScrolling(int i_renamed) {
        return (int) java.lang.Math.ceil(java.lang.Math.abs(i_renamed) * getSpeedPerPixel());
    }

    protected int getHorizontalSnapPreference() {
        android.graphics.PointF pointF = this.mTargetVector;
        if (pointF == null || pointF.x_renamed == 0.0f) {
            return 0;
        }
        return this.mTargetVector.x_renamed > 0.0f ? 1 : -1;
    }

    protected int getVerticalSnapPreference() {
        android.graphics.PointF pointF = this.mTargetVector;
        if (pointF == null || pointF.y_renamed == 0.0f) {
            return 0;
        }
        return this.mTargetVector.y_renamed > 0.0f ? 1 : -1;
    }

    protected void updateActionForInterimTarget(androidx.recyclerview.widget.RecyclerView.s_renamed.a_renamed aVar) {
        android.graphics.PointF pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(getTargetPosition());
        if (pointFComputeScrollVectorForPosition == null || (pointFComputeScrollVectorForPosition.x_renamed == 0.0f && pointFComputeScrollVectorForPosition.y_renamed == 0.0f)) {
            aVar.a_renamed(getTargetPosition());
            stop();
            return;
        }
        normalize(pointFComputeScrollVectorForPosition);
        this.mTargetVector = pointFComputeScrollVectorForPosition;
        this.mInterimTargetDx = (int) (pointFComputeScrollVectorForPosition.x_renamed * 10000.0f);
        this.mInterimTargetDy = (int) (pointFComputeScrollVectorForPosition.y_renamed * 10000.0f);
        aVar.a_renamed((int) (this.mInterimTargetDx * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (this.mInterimTargetDy * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (calculateTimeForScrolling(10000) * TARGET_SEEK_EXTRA_SCROLL_RATIO), this.mLinearInterpolator);
    }

    public int calculateDtToFit(int i_renamed, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i_renamed;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            throw new java.lang.IllegalArgumentException("snap preference should be_renamed one of_renamed the constants defined in_renamed SmoothScroller, starting with SNAP_");
        }
        int i6 = i3 - i_renamed;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public int calculateDyToMakeVisible(android.view.View view, int i_renamed) {
        androidx.recyclerview.widget.RecyclerView.i_renamed layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
        return calculateDtToFit(layoutManager.getDecoratedTop(view) - jVar.topMargin, layoutManager.getDecoratedBottom(view) + jVar.bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i_renamed);
    }

    public int calculateDxToMakeVisible(android.view.View view, int i_renamed) {
        androidx.recyclerview.widget.RecyclerView.i_renamed layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
        return calculateDtToFit(layoutManager.getDecoratedLeft(view) - jVar.leftMargin, layoutManager.getDecoratedRight(view) + jVar.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i_renamed);
    }
}
