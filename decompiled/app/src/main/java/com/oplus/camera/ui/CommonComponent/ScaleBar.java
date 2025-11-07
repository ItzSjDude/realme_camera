package com.oplus.camera.ui.CommonComponent;

/* loaded from: classes2.dex */
public class ScaleBar extends android.view.View {
    public static final int CENTER_ALIGN = 2;
    private static final float FIRST_CONTROL_POINT_X = 0.0f;
    private static final float FIRST_CONTROL_POINT_Y = 0.0f;
    private static final int FLING_VELOCITY_THRESHOLD = 1000;
    private static final java.lang.String FUNCTION_ALPHA = "alpha";
    private static final float INTERPOLATE_VALUE = 0.5f;
    public static final int LEFT_ALIGN = 1;
    private static final float LIMIT_INCREASE_SPACE = 1.5f;
    private static final float MAX_ANIMATION_PROGRESS = 1.0f;
    private static final float MIN_ANIMATION_PROGRESS = 0.0f;
    private static final int MOVE_LEFT = -1;
    private static final int MOVE_RIGHT = 1;
    private static final int NEGATIVE_DIRECTION = -1;
    private static final int POSITIVE_DIRECTION = 1;
    private static final long REBOUND_DURATION = 350;
    private static final int SECOND = 1000;
    private static final float SECOND_CONTROL_POINT_X = 0.58f;
    private static final float SECOND_CONTROL_POINT_Y = 1.0f;
    private static final java.lang.String TAG = "ScaleBar";
    private static final int TEN_SMALL_SCALE_BETWEEN_BIG_SCALE = 10;
    private static int sBigScaleColor;
    private static int sHighlightColor;
    private static int sSmallScaleColor;
    private int mAlign;
    private android.animation.AnimatorSet mAnimatorSet;
    private int mBigScaleStrokeWidth;
    private int mCenterIndex;
    private android.animation.ObjectAnimator mColorObjectAnimator;
    private android.content.Context mContext;
    private int mCountBetweenBigScale;
    private int mCurrentIndex;
    private float mDownX;
    private float mDownY;
    private com.oplus.camera.ui.CommonComponent.ScaleBar.FlingRunnable mFlingRunnable;
    private android.graphics.Paint mHighlightPaint;
    private android.animation.ValueAnimator mIntervalAnim;
    private int mLastMoveDirection;
    private int mLayoutWidth;
    private int mLevelNum;
    private float mLimitMaxDistance;
    private int mMaxFlingVelocity;
    private float mMaxMarginIncrease;
    private android.os.Handler mMyHandler;
    private boolean mNeedSetShadowLayer;
    private float mOffset;
    private int mOffsetCount;
    private float mOffsetMargin;
    private android.graphics.Paint mPaint;
    private com.oplus.camera.ui.CommonComponent.ScaleBar.ScaleBarValueChangeListener mScaleBarValueChangeListener;
    private int mScaleHeight;
    private int[] mScaleHeightOffSet;
    private int mScaleMargin;
    private int mScalePointerX;
    private float mScaleRatio;
    private int mScaleTopMargin;
    private android.animation.ValueAnimator mScaleValueAnimator;
    private int mShadowColor;
    private android.graphics.Paint mShadowPaint;
    private float mShadowRadius;
    private int mSmallScaleStrokeWidth;
    private float mStartDistanceX;
    private float mStartOffsetX;
    private boolean mTouchable;
    private android.view.VelocityTracker mVelocityTracker;
    private boolean mbAuto;
    private boolean mbInitIndex;
    private boolean mbInitScalePointerX;
    private boolean mbLazySetIndex;
    private boolean mbValid;
    private static final float DAMPING = 0.3f;
    private static final android.view.animation.PathInterpolator REBOUND_INTERPOLATOR = new android.view.animation.PathInterpolator(DAMPING, 0.0f, 0.1f, 1.0f);

    public interface ScaleBarValueChangeListener {
        void onActionUp();

        void onBarMoving();

        void onBarScrolling(boolean z_renamed);

        void onValueChange(int i_renamed);
    }

    @Override // android.view.View
    public float getLeftFadingEdgeStrength() {
        return 1.0f;
    }

    @Override // android.view.View
    public float getRightFadingEdgeStrength() {
        return 1.0f;
    }

    public boolean needChangeValue() {
        return false;
    }

    public ScaleBar(android.content.Context context, android.util.AttributeSet attributeSet) throws android.content.res.Resources.NotFoundException {
        super(context, attributeSet);
        this.mStartDistanceX = 0.0f;
        this.mStartOffsetX = 0.0f;
        this.mCurrentIndex = 0;
        this.mScaleTopMargin = 0;
        this.mScaleMargin = 0;
        this.mAlign = 1;
        this.mCountBetweenBigScale = 10;
        this.mLimitMaxDistance = 0.0f;
        this.mMaxMarginIncrease = 0.0f;
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mOffset = 0.0f;
        this.mOffsetMargin = 0.0f;
        this.mOffsetCount = 10;
        this.mbValid = true;
        this.mScaleValueAnimator = null;
        this.mColorObjectAnimator = null;
        this.mScaleRatio = 0.0f;
        this.mLastMoveDirection = 1;
        this.mNeedSetShadowLayer = false;
        this.mTouchable = false;
        this.mContext = context;
        init();
    }

    public ScaleBar(android.content.Context context, int i_renamed, android.os.Handler handler) throws android.content.res.Resources.NotFoundException {
        super(context);
        this.mStartDistanceX = 0.0f;
        this.mStartOffsetX = 0.0f;
        this.mCurrentIndex = 0;
        this.mScaleTopMargin = 0;
        this.mScaleMargin = 0;
        this.mAlign = 1;
        this.mCountBetweenBigScale = 10;
        this.mLimitMaxDistance = 0.0f;
        this.mMaxMarginIncrease = 0.0f;
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mOffset = 0.0f;
        this.mOffsetMargin = 0.0f;
        this.mOffsetCount = 10;
        this.mbValid = true;
        this.mScaleValueAnimator = null;
        this.mColorObjectAnimator = null;
        this.mScaleRatio = 0.0f;
        this.mLastMoveDirection = 1;
        this.mNeedSetShadowLayer = false;
        this.mTouchable = false;
        this.mMyHandler = handler;
        this.mLevelNum = i_renamed;
        this.mContext = context;
        init();
    }

    private void initAnimator() {
        this.mIntervalAnim = new android.animation.ValueAnimator();
        this.mIntervalAnim.setDuration(REBOUND_DURATION);
        this.mIntervalAnim.setInterpolator(REBOUND_INTERPOLATOR);
        this.mIntervalAnim.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.CommonComponent.ScaleBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.CommonComponent.ScaleBar.this.mOffset = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.CommonComponent.ScaleBar scaleBar = com.oplus.camera.ui.CommonComponent.ScaleBar.this;
                scaleBar.mOffsetMargin = (scaleBar.mOffset / com.oplus.camera.ui.CommonComponent.ScaleBar.this.mLimitMaxDistance) * com.oplus.camera.ui.CommonComponent.ScaleBar.this.mMaxMarginIncrease;
                com.oplus.camera.ui.CommonComponent.ScaleBar.this.invalidate();
            }
        });
        this.mAnimatorSet = new android.animation.AnimatorSet();
        this.mAnimatorSet.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.CommonComponent.ScaleBar.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.CommonComponent.ScaleBar.this.updateIndex();
            }
        });
    }

    private void init() throws android.content.res.Resources.NotFoundException {
        if (this.mLevelNum <= 0) {
            this.mbValid = false;
            return;
        }
        this.mbValid = true;
        setTouchable(true);
        this.mShadowRadius = com.oplus.camera.util.Util.a_renamed(getContext(), com.oplus.camera.R_renamed.dimen.level_panel_text_shadow_radius, com.oplus.camera.util.Util.f7297a);
        this.mShadowColor = getContext().getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_20_percent_transparency);
        android.content.res.Resources resources = this.mContext.getResources();
        this.mBigScaleStrokeWidth = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_big_scale_stroke_width);
        this.mSmallScaleStrokeWidth = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_small_scale_stroke_width);
        this.mScaleTopMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_top_margin);
        this.mScaleMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_margin);
        int i_renamed = this.mScaleMargin;
        this.mLimitMaxDistance = this.mOffsetCount * i_renamed;
        this.mMaxMarginIncrease = i_renamed * LIMIT_INCREASE_SPACE;
        this.mScaleHeight = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height);
        this.mScaleHeightOffSet = new int[]{0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height_offset_level1), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height_offset_level2), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height_offset_level3), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height_offset_level4), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height_offset_level5)};
        this.mBigScaleStrokeWidth = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_big_scale_stroke_width);
        sBigScaleColor = this.mContext.getColor(com.oplus.camera.R_renamed.color.professional_mode_scale_bar_big_scale_color);
        sSmallScaleColor = this.mContext.getColor(com.oplus.camera.R_renamed.color.blur_menu_seek_bar_line_color);
        sHighlightColor = com.oplus.camera.util.Util.A_renamed(this.mContext);
        setLayerType(1, null);
        this.mShadowPaint = new android.graphics.Paint();
        this.mShadowPaint.setMaskFilter(new android.graphics.BlurMaskFilter(this.mShadowRadius, android.graphics.BlurMaskFilter.Blur.OUTER));
        this.mShadowPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mShadowPaint.setStrokeWidth(this.mBigScaleStrokeWidth);
        this.mShadowPaint.setColor(this.mShadowColor);
        this.mPaint = new android.graphics.Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(sBigScaleColor);
        this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mPaint.setStrokeWidth(this.mSmallScaleStrokeWidth);
        this.mHighlightPaint = new android.graphics.Paint();
        this.mHighlightPaint.setAntiAlias(true);
        this.mHighlightPaint.setColor(sHighlightColor);
        this.mHighlightPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mHighlightPaint.setStrokeWidth(this.mBigScaleStrokeWidth);
        this.mHighlightPaint.setAlpha(0);
        android.view.ViewConfiguration.get(this.mContext);
        this.mMaxFlingVelocity = android.view.ViewConfiguration.getMaximumFlingVelocity();
        int i2 = this.mLevelNum;
        this.mCenterIndex = i2 % 2 == 0 ? (i2 / 2) - 1 : i2 / 2;
        if (this.mCenterIndex < 0) {
            this.mCenterIndex = 0;
        }
        this.mScaleValueAnimator = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mScaleValueAnimator.setDuration(500L);
        this.mScaleValueAnimator.setInterpolator(com.oplus.camera.professional.t_renamed.f5228b);
        this.mScaleValueAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.CommonComponent.ScaleBar.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.CommonComponent.ScaleBar.this.mScaleRatio = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.CommonComponent.ScaleBar.this.invalidate();
            }
        });
        this.mColorObjectAnimator = android.animation.ObjectAnimator.ofObject(this.mHighlightPaint, FUNCTION_ALPHA, new android.animation.IntEvaluator(), 0, 255);
        this.mColorObjectAnimator.setDuration(500L);
        this.mColorObjectAnimator.setInterpolator(com.oplus.camera.professional.t_renamed.f5227a);
        this.mColorObjectAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.CommonComponent.ScaleBar.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.CommonComponent.ScaleBar.this.invalidate();
            }
        });
        if (this.mNeedSetShadowLayer) {
            int color = getContext().getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_20_percent_transparency);
            this.mPaint.setShadowLayer(this.mShadowRadius, 0.0f, 0.0f, color);
            this.mHighlightPaint.setShadowLayer(this.mShadowRadius, 0.0f, 0.0f, color);
        }
    }

    public void setShadowLayer() {
        this.mNeedSetShadowLayer = true;
    }

    public void setCurrentIndex(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.mLevelNum) {
            return;
        }
        if (this.mbAuto && this.mScaleValueAnimator.isRunning()) {
            this.mbLazySetIndex = true;
        } else {
            this.mCurrentIndex = i_renamed;
        }
    }

    public void setLevelNum(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "setLevelNum, levelNum: " + i_renamed);
        this.mLevelNum = i_renamed;
        if (this.mbValid) {
            int i2 = this.mLevelNum;
            this.mCenterIndex = i2 % 2 == 0 ? (i2 / 2) - 1 : i2 / 2;
        } else {
            init();
        }
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public void setScaleBarValueChangeListener(com.oplus.camera.ui.CommonComponent.ScaleBar.ScaleBarValueChangeListener scaleBarValueChangeListener) {
        this.mScaleBarValueChangeListener = scaleBarValueChangeListener;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:47:0x0103  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.CommonComponent.ScaleBar.onDraw(android.graphics.Canvas):void");
    }

    private void drawLine(android.graphics.Canvas canvas, float f_renamed, float f2, float f3, float f4, android.graphics.Paint paint) {
        if (this.mNeedSetShadowLayer) {
            canvas.drawLine(f_renamed, f2, f3, f4, this.mShadowPaint);
        }
        canvas.drawLine(f_renamed, f2, f3, f4, paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!isTouchable()) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            float xVelocity = 0.0f;
            if (action != 1) {
                if (action == 2) {
                    float x_renamed = motionEvent.getX() - this.mDownX;
                    float y_renamed = motionEvent.getY() - this.mDownY;
                    this.mDownX = motionEvent.getX();
                    this.mDownY = motionEvent.getY();
                    if (java.lang.Math.abs(x_renamed) >= java.lang.Math.abs(y_renamed)) {
                        android.view.VelocityTracker velocityTracker = this.mVelocityTracker;
                        if (velocityTracker != null) {
                            velocityTracker.addMovement(motionEvent);
                        }
                        if (1 == getLayoutDirection()) {
                            onMove(-x_renamed);
                        } else {
                            onMove(x_renamed);
                        }
                    }
                } else if (action == 3) {
                    if (this.mOffset != 0.0f) {
                        startReboundAnimation();
                    } else {
                        android.view.VelocityTracker velocityTracker2 = this.mVelocityTracker;
                        if (velocityTracker2 != null) {
                            velocityTracker2.recycle();
                            this.mVelocityTracker = null;
                        }
                        scrollNearbyScale();
                    }
                }
            } else if (this.mOffset != 0.0f) {
                startReboundAnimation();
            } else {
                android.view.VelocityTracker velocityTracker3 = this.mVelocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
                    xVelocity = this.mVelocityTracker.getXVelocity();
                    this.mVelocityTracker.clear();
                }
                if (java.lang.Math.abs(xVelocity) >= 1000.0f) {
                    if (1 == getLayoutDirection()) {
                        xVelocity = -xVelocity;
                    }
                    this.mFlingRunnable = new com.oplus.camera.ui.CommonComponent.ScaleBar.FlingRunnable(xVelocity);
                    this.mMyHandler.post(this.mFlingRunnable);
                } else {
                    scrollNearbyScale();
                    com.oplus.camera.ui.CommonComponent.ScaleBar.ScaleBarValueChangeListener scaleBarValueChangeListener = this.mScaleBarValueChangeListener;
                    if (scaleBarValueChangeListener != null) {
                        scaleBarValueChangeListener.onActionUp();
                    }
                }
            }
        } else {
            this.mDownX = motionEvent.getX();
            this.mDownY = motionEvent.getY();
            this.mVelocityTracker = android.view.VelocityTracker.obtain();
            com.oplus.camera.ui.CommonComponent.ScaleBar.FlingRunnable flingRunnable = this.mFlingRunnable;
            if (flingRunnable != null) {
                flingRunnable.cancelFling();
                this.mFlingRunnable = null;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startReboundAnimation() {
        if (this.mIntervalAnim == null || this.mAnimatorSet == null) {
            initAnimator();
        }
        if (this.mIntervalAnim.isRunning()) {
            this.mIntervalAnim.cancel();
        }
        if (this.mAnimatorSet.isRunning()) {
            this.mAnimatorSet.cancel();
        }
        this.mIntervalAnim.setFloatValues(this.mOffset, 0.0f);
        this.mAnimatorSet.play(this.mIntervalAnim);
        this.mAnimatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollNearbyScale() {
        int i_renamed = (int) ((this.mStartDistanceX - this.mStartOffsetX) % this.mScaleMargin);
        if (i_renamed != 0) {
            int iAbs = java.lang.Math.abs(i_renamed);
            int i2 = this.mScaleMargin;
            if (iAbs < i2 / 2) {
                this.mStartDistanceX -= i_renamed;
            } else if (i_renamed > 0) {
                this.mStartDistanceX = (this.mStartDistanceX - i_renamed) + i2;
            } else {
                this.mStartDistanceX = (this.mStartDistanceX - i_renamed) - i2;
            }
            updateIndex();
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMove(float f_renamed) {
        if (!this.mbValid) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "onMove return, is_renamed not valid");
            return;
        }
        if (f_renamed == 0.0f) {
            return;
        }
        int i_renamed = 0.0f < f_renamed ? 1 : -1;
        if (this.mLastMoveDirection != i_renamed) {
            float f2 = this.mOffset;
            if (0.0f != f2) {
                if (i_renamed == 1) {
                    this.mOffset = f2 + f_renamed < 0.0f ? f2 + f_renamed : 0.0f;
                } else {
                    this.mOffset = f2 + f_renamed > 0.0f ? f2 + f_renamed : 0.0f;
                }
                this.mOffsetMargin = (this.mOffset / this.mLimitMaxDistance) * this.mMaxMarginIncrease;
                invalidate();
                return;
            }
        }
        this.mLastMoveDirection = i_renamed;
        this.mStartDistanceX += (int) f_renamed;
        float f3 = this.mStartDistanceX;
        int i2 = this.mScalePointerX;
        if (f3 >= i2) {
            float f4 = this.mLimitMaxDistance;
            if (f3 <= i2 + f4) {
                float f5 = this.mOffset;
                if (f5 == 0.0f) {
                    this.mOffset = (f3 - i2) * DAMPING;
                } else {
                    float f6 = f_renamed * DAMPING;
                    if (f5 + f6 < f4) {
                        f4 = f5 + f6;
                    }
                    this.mOffset = f4;
                }
            } else {
                this.mOffset = 0.0f;
            }
            this.mStartDistanceX = this.mScalePointerX;
        } else {
            int i3 = this.mScaleMargin;
            int i4 = this.mLevelNum;
            if (((i4 - 1) * i3) + f3 <= i2) {
                float f7 = ((i4 - 1) * i3) + f3;
                float f8 = this.mLimitMaxDistance;
                if (f7 >= i2 - f8) {
                    float f9 = this.mOffset;
                    if (f9 == 0.0f) {
                        this.mOffset = ((f3 + (i3 * (i4 - 1))) - i2) * DAMPING;
                    } else {
                        float f10 = f_renamed * DAMPING;
                        this.mOffset = f9 + f10 <= (-f8) ? -f8 : f10 + f9;
                    }
                } else {
                    this.mOffset = 0.0f;
                }
                this.mStartDistanceX = this.mScalePointerX - (this.mScaleMargin * (this.mLevelNum - 1));
            }
        }
        this.mOffsetMargin = (this.mOffset / this.mLimitMaxDistance) * this.mMaxMarginIncrease;
        updateIndex();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIndex() {
        if (this.mLevelNum != 0) {
            float fAbs = java.lang.Math.abs(this.mScalePointerX - this.mStartDistanceX);
            int i_renamed = (int) (((fAbs + (r1 / 2)) / this.mScaleMargin) % this.mLevelNum);
            com.oplus.camera.ui.CommonComponent.ScaleBar.ScaleBarValueChangeListener scaleBarValueChangeListener = this.mScaleBarValueChangeListener;
            if (scaleBarValueChangeListener != null && i_renamed != this.mCurrentIndex) {
                scaleBarValueChangeListener.onBarMoving();
                this.mScaleBarValueChangeListener.onValueChange(i_renamed);
            }
            setCurrentIndex(i_renamed);
        }
    }

    public void sliderRight() {
        onMove(this.mScaleMargin);
    }

    public void sliderLeft() {
        onMove(-this.mScaleMargin);
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        if (this.mLayoutWidth > 0 || !this.mbValid) {
            return;
        }
        this.mLayoutWidth = getMeasuredWidth();
        this.mScalePointerX = (this.mLayoutWidth / 2) - (this.mBigScaleStrokeWidth / 2);
        this.mStartOffsetX = (r2 % this.mScaleMargin) - (r3 / 2);
        this.mbInitScalePointerX = true;
        if (!this.mbInitIndex) {
            this.mStartDistanceX = 0.0f;
        }
        int i3 = this.mCurrentIndex;
        if (i3 >= 0) {
            initDataIndex(i3);
        }
    }

    public void scrollTo(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.mLevelNum) {
            return;
        }
        if (this.mbLazySetIndex) {
            this.mCurrentIndex = i_renamed;
            this.mbLazySetIndex = false;
        }
        this.mStartDistanceX = this.mScalePointerX - (this.mScaleMargin * i_renamed);
        invalidate();
    }

    public void initDataIndex(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.mLevelNum) {
            return;
        }
        this.mCurrentIndex = i_renamed;
        if (this.mbInitScalePointerX) {
            this.mStartDistanceX = this.mScalePointerX - (this.mScaleMargin * i_renamed);
            this.mbInitIndex = true;
            invalidate();
        }
    }

    public void setAuto(boolean z_renamed, boolean z2) {
        boolean z3 = this.mbAuto != z_renamed;
        this.mbAuto = z_renamed;
        if (z3 && z2) {
            this.mScaleValueAnimator.cancel();
            this.mScaleValueAnimator.start();
            if (z_renamed) {
                this.mColorObjectAnimator.setIntValues(255, 0);
            } else {
                this.mColorObjectAnimator.setIntValues(0, 255);
            }
            this.mColorObjectAnimator.cancel();
            this.mColorObjectAnimator.start();
        }
        invalidate();
    }

    public void setAlign(int i_renamed) {
        if (i_renamed == 1 || i_renamed == 2) {
            this.mAlign = i_renamed;
        }
    }

    public boolean isTouchable() {
        return this.mTouchable;
    }

    public void setTouchable(boolean z_renamed) {
        this.mTouchable = z_renamed;
    }

    private class FlingInterpolator extends android.view.animation.PathInterpolator {
        FlingInterpolator() {
            super(0.0f, 0.0f, com.oplus.camera.ui.CommonComponent.ScaleBar.SECOND_CONTROL_POINT_X, 1.0f);
        }
    }

    private class FlingRunnable implements java.lang.Runnable {
        private static final int DEFAULT_DURATION = 400;
        private float mDurationReciprocal;
        private android.view.animation.Interpolator mInterpolator;
        private float mLastX;
        private long mStartTime;
        private float mTotalDistance;
        private float mVelocityX;
        private int mDuration = 400;
        private int mFrameDuration = 16;
        private float mMagicVelocityPx = 0.15f;
        private boolean mbFinish = false;

        public FlingRunnable(float f_renamed) {
            this.mInterpolator = com.oplus.camera.ui.CommonComponent.ScaleBar.this.new FlingInterpolator();
            if (com.oplus.camera.ui.CommonComponent.ScaleBar.this.mScaleBarValueChangeListener != null) {
                com.oplus.camera.ui.CommonComponent.ScaleBar.this.mScaleBarValueChangeListener.onBarScrolling(!this.mbFinish);
            }
            this.mLastX = 0.0f;
            int i_renamed = this.mDuration;
            this.mDurationReciprocal = 1.0f / i_renamed;
            this.mVelocityX = f_renamed;
            this.mTotalDistance = ((i_renamed * this.mVelocityX) / 1000.0f) * this.mMagicVelocityPx;
            this.mStartTime = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
        }

        public void cancelFling() {
            this.mbFinish = true;
            if (com.oplus.camera.ui.CommonComponent.ScaleBar.this.mScaleBarValueChangeListener != null) {
                com.oplus.camera.ui.CommonComponent.ScaleBar.this.mScaleBarValueChangeListener.onBarScrolling(!this.mbFinish);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mbFinish) {
                return;
            }
            int iCurrentAnimationTimeMillis = (int) (android.view.animation.AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
            float interpolation = this.mInterpolator.getInterpolation(iCurrentAnimationTimeMillis * this.mDurationReciprocal);
            float f_renamed = (interpolation - this.mLastX) * this.mTotalDistance;
            this.mLastX = interpolation;
            int i_renamed = this.mDuration;
            if (iCurrentAnimationTimeMillis < i_renamed) {
                com.oplus.camera.ui.CommonComponent.ScaleBar.this.onMove(f_renamed);
                com.oplus.camera.ui.CommonComponent.ScaleBar.this.mMyHandler.postDelayed(this, this.mFrameDuration);
            } else if (iCurrentAnimationTimeMillis >= i_renamed) {
                this.mLastX = 0.0f;
                if (com.oplus.camera.ui.CommonComponent.ScaleBar.this.mOffset == 0.0f) {
                    com.oplus.camera.ui.CommonComponent.ScaleBar.this.scrollNearbyScale();
                }
                com.oplus.camera.ui.CommonComponent.ScaleBar.this.scrollNearbyScale();
                this.mbFinish = true;
                if (com.oplus.camera.ui.CommonComponent.ScaleBar.this.mScaleBarValueChangeListener != null) {
                    com.oplus.camera.ui.CommonComponent.ScaleBar.this.mScaleBarValueChangeListener.onBarScrolling(true ^ this.mbFinish);
                }
            }
            if (0.0f != com.oplus.camera.ui.CommonComponent.ScaleBar.this.mOffset) {
                com.oplus.camera.ui.CommonComponent.ScaleBar.this.startReboundAnimation();
            }
        }
    }
}
