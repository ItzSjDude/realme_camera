package com.oplus.camera.ui.CommonComponent;

/* loaded from: classes2.dex */
public class HSScaleBar extends android.view.View {
    public static final int CENTER_ALIGN = 2;
    private static final float FIRST_CONTROL_POINT_X = 0.0f;
    private static final float FIRST_CONTROL_POINT_Y = 0.0f;
    private static final int FLING_VELOCITY_THRESHOLD = 1000;
    private static final java.lang.String FUNCTION_COLOR = "color";
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
    private static final java.lang.String TAG = "HSScaleBar";
    private static final int TEN_SMALL_SCALE_BETWEEN_BIG_SCALE = 2;
    private static int sBigScaleColor;
    private static int sHighlightColor;
    private static int sSmallScaleColor;
    private static int sTextColor;
    private int mAlign;
    private int[] mAlphaOffSet;
    private android.animation.AnimatorSet mAnimatorSet;
    private int mBigScaleStrokeWidth;
    private int mCenterIndex;
    private android.graphics.Paint mCenterPaint;
    private int mCenterStartY;
    private int mColorDuration;
    private android.content.Context mContext;
    private int mCountBetweenBigScale;
    private int mCurrentIndex;
    private float mDownX;
    private float mDownY;
    private com.oplus.camera.ui.CommonComponent.HSScaleBar.FlingRunnable mFlingRunnable;
    private android.graphics.Paint mHighlightPaint;
    private android.animation.ValueAnimator mIntervalAnim;
    private int mLastMoveDirection;
    private int mLayoutWidth;
    private int mLevelNum;
    private float mLimitMaxDistance;
    private int mLineYBottom;
    private int mLongStartY;
    private int mMaxFlingVelocity;
    private float mMaxMarginIncrease;
    private android.os.Handler mMyHandler;
    private java.util.ArrayList<java.lang.String> mNameList;
    private float mOffset;
    private int mOffsetCount;
    private int mOffsetEndY;
    private float mOffsetMargin;
    private android.graphics.Paint mPaint;
    private com.oplus.camera.ui.CommonComponent.HSScaleBar.ScaleBarValueChangeListener mScaleBarValueChangeListener;
    private int mScaleHeight;
    private int mScaleMargin;
    private int mScalePointerX;
    private float mScaleRatio;
    private android.animation.ValueAnimator mScaleValueAnimator;
    private int mShortStartY;
    private java.lang.String[] mShowText;
    private int mSmallScaleStrokeWidth;
    private float mStartDistanceX;
    private float mStartOffsetX;
    private android.graphics.Paint mTextPaint;
    private int mTickTextSize;
    private android.view.VelocityTracker mVelocityTracker;
    private int maxFadingIndex;
    private boolean mbAuto;
    private boolean mbInitIndex;
    private boolean mbInitScalePointerX;
    private boolean mbValid;
    private int minFadingIndex;
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

    public HSScaleBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStartDistanceX = 0.0f;
        this.mStartOffsetX = 0.0f;
        this.mCurrentIndex = 0;
        this.mScaleMargin = 0;
        this.mAlphaOffSet = new int[]{0, 14, 31, 51, 74, 102, 132, 162, 192, 222, 252};
        this.mNameList = null;
        this.mAlign = 1;
        this.mCountBetweenBigScale = 2;
        this.mTickTextSize = 0;
        this.mLimitMaxDistance = 0.0f;
        this.mMaxMarginIncrease = 0.0f;
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mOffset = 0.0f;
        this.mOffsetMargin = 0.0f;
        this.mOffsetCount = 10;
        this.mbValid = true;
        this.mScaleValueAnimator = null;
        this.mColorDuration = 1;
        this.mScaleRatio = 0.0f;
        this.minFadingIndex = 7;
        this.maxFadingIndex = 15;
        this.mLongStartY = 0;
        this.mShortStartY = 0;
        this.mCenterStartY = 0;
        this.mLineYBottom = 0;
        this.mOffsetEndY = 0;
        this.mLastMoveDirection = 1;
        this.mContext = context;
        init();
    }

    public HSScaleBar(android.content.Context context, int i_renamed, android.os.Handler handler) {
        super(context);
        this.mStartDistanceX = 0.0f;
        this.mStartOffsetX = 0.0f;
        this.mCurrentIndex = 0;
        this.mScaleMargin = 0;
        this.mAlphaOffSet = new int[]{0, 14, 31, 51, 74, 102, 132, 162, 192, 222, 252};
        this.mNameList = null;
        this.mAlign = 1;
        this.mCountBetweenBigScale = 2;
        this.mTickTextSize = 0;
        this.mLimitMaxDistance = 0.0f;
        this.mMaxMarginIncrease = 0.0f;
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mOffset = 0.0f;
        this.mOffsetMargin = 0.0f;
        this.mOffsetCount = 10;
        this.mbValid = true;
        this.mScaleValueAnimator = null;
        this.mColorDuration = 1;
        this.mScaleRatio = 0.0f;
        this.minFadingIndex = 7;
        this.maxFadingIndex = 15;
        this.mLongStartY = 0;
        this.mShortStartY = 0;
        this.mCenterStartY = 0;
        this.mLineYBottom = 0;
        this.mOffsetEndY = 0;
        this.mLastMoveDirection = 1;
        this.mMyHandler = handler;
        this.mLevelNum = i_renamed;
        this.mContext = context;
        init();
    }

    public HSScaleBar(android.content.Context context, int i_renamed, android.os.Handler handler, java.util.ArrayList<java.lang.String> arrayList, java.lang.String[] strArr) {
        super(context);
        this.mStartDistanceX = 0.0f;
        this.mStartOffsetX = 0.0f;
        this.mCurrentIndex = 0;
        this.mScaleMargin = 0;
        this.mAlphaOffSet = new int[]{0, 14, 31, 51, 74, 102, 132, 162, 192, 222, 252};
        this.mNameList = null;
        this.mAlign = 1;
        this.mCountBetweenBigScale = 2;
        this.mTickTextSize = 0;
        this.mLimitMaxDistance = 0.0f;
        this.mMaxMarginIncrease = 0.0f;
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mOffset = 0.0f;
        this.mOffsetMargin = 0.0f;
        this.mOffsetCount = 10;
        this.mbValid = true;
        this.mScaleValueAnimator = null;
        this.mColorDuration = 1;
        this.mScaleRatio = 0.0f;
        this.minFadingIndex = 7;
        this.maxFadingIndex = 15;
        this.mLongStartY = 0;
        this.mShortStartY = 0;
        this.mCenterStartY = 0;
        this.mLineYBottom = 0;
        this.mOffsetEndY = 0;
        this.mLastMoveDirection = 1;
        this.mMyHandler = handler;
        this.mLevelNum = i_renamed;
        this.mContext = context;
        this.mNameList = arrayList;
        this.mShowText = strArr;
        init();
    }

    private void initAnimator() {
        this.mIntervalAnim = new android.animation.ValueAnimator();
        this.mIntervalAnim.setDuration(REBOUND_DURATION);
        this.mIntervalAnim.setInterpolator(REBOUND_INTERPOLATOR);
        this.mIntervalAnim.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.CommonComponent.HSScaleBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.CommonComponent.HSScaleBar.this.mOffset = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.CommonComponent.HSScaleBar hSScaleBar = com.oplus.camera.ui.CommonComponent.HSScaleBar.this;
                hSScaleBar.mOffsetMargin = (hSScaleBar.mOffset / com.oplus.camera.ui.CommonComponent.HSScaleBar.this.mLimitMaxDistance) * com.oplus.camera.ui.CommonComponent.HSScaleBar.this.mMaxMarginIncrease;
                com.oplus.camera.ui.CommonComponent.HSScaleBar.this.invalidate();
            }
        });
        this.mAnimatorSet = new android.animation.AnimatorSet();
        this.mAnimatorSet.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.CommonComponent.HSScaleBar.2
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
                com.oplus.camera.ui.CommonComponent.HSScaleBar.this.updateIndex();
            }
        });
    }

    private void init() {
        if (this.mLevelNum <= 0) {
            this.mbValid = false;
            return;
        }
        this.mbValid = true;
        android.content.res.Resources resources = this.mContext.getResources();
        this.mBigScaleStrokeWidth = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_professional_mode_scale_bar_big_scale_stroke_width);
        this.mSmallScaleStrokeWidth = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_professional_mode_scale_bar_small_scale_stroke_width);
        this.mTickTextSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_professional_mode_tick_text_size);
        this.mScaleMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_professional_mode_scale_bar_scale_margin);
        int i_renamed = this.mScaleMargin;
        this.mLimitMaxDistance = this.mOffsetCount * i_renamed;
        this.mMaxMarginIncrease = i_renamed * LIMIT_INCREASE_SPACE;
        this.mScaleHeight = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_professional_mode_scale_bar_scale_height);
        sBigScaleColor = this.mContext.getColor(com.oplus.camera.R_renamed.color.professional_mode_scale_bar_big_scale_color);
        sSmallScaleColor = this.mContext.getColor(com.oplus.camera.R_renamed.color.blur_menu_seek_bar_line_color);
        sTextColor = this.mContext.getColor(com.oplus.camera.R_renamed.color.color_white_with_30_percent_transparency);
        sHighlightColor = com.oplus.camera.util.Util.A_renamed(this.mContext);
        this.mLongStartY = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_professional_mode_scale_bar_long_start);
        this.mShortStartY = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_professional_mode_scale_bar_short_start);
        this.mCenterStartY = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_professional_mode_scale_bar_center_start);
        this.mLineYBottom = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_professional_mode_scale_bar_line_bottom);
        this.mOffsetEndY = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_professional_mode_scale_bar_offset_end_y);
        this.mPaint = new android.graphics.Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(sBigScaleColor);
        this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mPaint.setStrokeWidth(this.mBigScaleStrokeWidth);
        this.mHighlightPaint = new android.graphics.Paint();
        this.mHighlightPaint.setAntiAlias(true);
        this.mHighlightPaint.setColor(sHighlightColor);
        this.mHighlightPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mHighlightPaint.setStrokeWidth(this.mBigScaleStrokeWidth);
        this.mHighlightPaint.setAlpha(0);
        this.mTextPaint = new android.graphics.Paint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setColor(sTextColor);
        this.mTextPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mTextPaint.setStrokeWidth(this.mBigScaleStrokeWidth);
        this.mTextPaint.setTextSize(this.mTickTextSize);
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
        this.mScaleValueAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.CommonComponent.HSScaleBar.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.CommonComponent.HSScaleBar.this.mScaleRatio = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.CommonComponent.HSScaleBar.this.invalidate();
            }
        });
    }

    public void setCurrentIndex(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.mLevelNum) {
            return;
        }
        this.mCurrentIndex = i_renamed;
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

    public void setScaleBarValueChangeListener(com.oplus.camera.ui.CommonComponent.HSScaleBar.ScaleBarValueChangeListener scaleBarValueChangeListener) {
        this.mScaleBarValueChangeListener = scaleBarValueChangeListener;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        float f_renamed;
        int i_renamed;
        float f2;
        int i2;
        float f3;
        int i3;
        int i4;
        float f4;
        int i5;
        int i6;
        if (this.mbValid) {
            if (1 == getLayoutDirection()) {
                canvas.scale(-1.0f, 1.0f, getWidth() / 2, getHeight() / 2);
            }
            int i7 = this.mAlign == 2 ? this.mCenterIndex % this.mCountBetweenBigScale : 0;
            int i8 = this.mScaleHeight - this.mOffsetEndY;
            float f5 = this.mScaleMargin >> 1;
            float fAbs = (java.lang.Math.abs((this.mScalePointerX - this.mStartDistanceX) - (this.mOffset - (r1 * ((int) (r3 / r1))))) + f5) - (this.mCurrentIndex * this.mScaleMargin);
            float fAbs2 = java.lang.Math.abs(fAbs - f5) / f5;
            int iCompare = java.lang.Float.compare(fAbs, f5);
            float f6 = this.mOffset;
            int i9 = (f6 == 0.0f || iCompare == 0) ? iCompare : f6 > 0.0f ? -1 : 1;
            int i10 = 0;
            while (i10 < this.mLevelNum) {
                int iAbs = java.lang.Math.abs((this.mCurrentIndex - ((int) (this.mOffset / this.mScaleMargin))) - i10);
                if (iAbs < this.minFadingIndex || iAbs > this.maxFadingIndex) {
                    f_renamed = 255.0f;
                } else if (i9 != -1) {
                    if (i9 == 1) {
                        if (i10 > this.mCurrentIndex) {
                            int[] iArr = this.mAlphaOffSet;
                            int i11 = 15 - iAbs;
                            f4 = iArr[i11];
                            i5 = iArr[16 - iAbs];
                            i6 = iArr[i11];
                            f_renamed = ((i5 - i6) * INTERPOLATE_VALUE * fAbs2) + f4;
                        } else {
                            int[] iArr2 = this.mAlphaOffSet;
                            int i12 = 15 - iAbs;
                            f3 = iArr2[i12];
                            i3 = iArr2[16 - iAbs];
                            i4 = iArr2[i12];
                            f_renamed = f3 - (((i3 - i4) * INTERPOLATE_VALUE) * fAbs2);
                        }
                    } else {
                        f_renamed = this.mAlphaOffSet[15 - iAbs];
                    }
                } else if (i10 < this.mCurrentIndex) {
                    int[] iArr3 = this.mAlphaOffSet;
                    int i13 = 15 - iAbs;
                    f4 = iArr3[i13];
                    i5 = iArr3[16 - iAbs];
                    i6 = iArr3[i13];
                    f_renamed = ((i5 - i6) * INTERPOLATE_VALUE * fAbs2) + f4;
                } else {
                    int[] iArr4 = this.mAlphaOffSet;
                    int i14 = 15 - iAbs;
                    f3 = iArr4[i14];
                    i3 = iArr4[16 - iAbs];
                    i4 = iArr4[i14];
                    f_renamed = f3 - (((i3 - i4) * INTERPOLATE_VALUE) * fAbs2);
                }
                if (i10 % this.mCountBetweenBigScale == i7) {
                    i_renamed = this.mShortStartY;
                } else {
                    i_renamed = this.mLongStartY;
                }
                this.mPaint.setColor(sSmallScaleColor);
                this.mPaint.setStrokeWidth(this.mSmallScaleStrokeWidth);
                this.mPaint.setAlpha((int) f_renamed);
                float f7 = this.mOffsetMargin;
                if (0.0f < f7) {
                    f2 = this.mStartDistanceX;
                    i2 = ((int) (this.mScaleMargin + f7)) * i10;
                } else {
                    f2 = this.mStartDistanceX + (this.mScaleMargin * i10);
                    i2 = (int) (((this.mLevelNum - 1) - i10) * f7);
                }
                float f8 = f2 + i2;
                float f9 = this.mOffset;
                int i15 = this.mLineYBottom;
                canvas.drawLine(f9 + f8, i_renamed - i15, f9 + f8, i8 - i15, this.mPaint);
                i10++;
                i9 = i9;
            }
            java.lang.String[] strArr = this.mShowText;
            if (strArr != null) {
                for (java.lang.String str : strArr) {
                    if (this.mNameList.indexOf(str) != -1) {
                        this.mTextPaint.getTextBounds(str, 0, str.length(), new android.graphics.Rect());
                        canvas.drawText(str, ((this.mOffset / 2.0f) + ((this.mStartDistanceX + (this.mScaleMargin * r5)) + ((int) (((this.mShowText.length - 1) - r5) * this.mOffsetMargin)))) - (r6.width() / 2), this.mScaleHeight, this.mTextPaint);
                    }
                }
            }
            int i16 = this.mCenterStartY;
            int i17 = this.mScalePointerX;
            int i18 = this.mLineYBottom;
            canvas.drawLine(i17, i16 - i18, i17, i8 - i18, this.mHighlightPaint);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
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
                    this.mFlingRunnable = new com.oplus.camera.ui.CommonComponent.HSScaleBar.FlingRunnable(xVelocity);
                    this.mMyHandler.post(this.mFlingRunnable);
                } else {
                    scrollNearbyScale();
                    com.oplus.camera.ui.CommonComponent.HSScaleBar.ScaleBarValueChangeListener scaleBarValueChangeListener = this.mScaleBarValueChangeListener;
                    if (scaleBarValueChangeListener != null) {
                        scaleBarValueChangeListener.onActionUp();
                    }
                }
            }
        } else {
            this.mDownX = motionEvent.getX();
            this.mDownY = motionEvent.getY();
            this.mVelocityTracker = android.view.VelocityTracker.obtain();
            com.oplus.camera.ui.CommonComponent.HSScaleBar.FlingRunnable flingRunnable = this.mFlingRunnable;
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
            if (f3 <= i2 + this.mLimitMaxDistance && !com.oplus.camera.util.Util.ao_renamed()) {
                float f4 = this.mOffset;
                if (f4 == 0.0f) {
                    this.mOffset = (this.mStartDistanceX - this.mScalePointerX) * DAMPING;
                } else {
                    float f5 = f_renamed * DAMPING;
                    float f6 = f4 + f5;
                    float f7 = this.mLimitMaxDistance;
                    if (f6 < f7) {
                        f7 = f4 + f5;
                    }
                    this.mOffset = f7;
                }
            } else {
                this.mOffset = 0.0f;
            }
            this.mStartDistanceX = this.mScalePointerX;
        } else {
            int i3 = this.mScaleMargin;
            int i4 = this.mLevelNum;
            if (((i4 - 1) * i3) + f3 <= i2) {
                if (f3 + (i3 * (i4 - 1)) >= i2 - this.mLimitMaxDistance && !com.oplus.camera.util.Util.ao_renamed()) {
                    float f8 = this.mOffset;
                    if (f8 == 0.0f) {
                        this.mOffset = ((this.mStartDistanceX + (this.mScaleMargin * (this.mLevelNum - 1))) - this.mScalePointerX) * DAMPING;
                    } else {
                        float f9 = f_renamed * DAMPING;
                        float f10 = f8 + f9;
                        float f11 = this.mLimitMaxDistance;
                        this.mOffset = f10 <= (-f11) ? -f11 : f9 + f8;
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
            com.oplus.camera.ui.CommonComponent.HSScaleBar.ScaleBarValueChangeListener scaleBarValueChangeListener = this.mScaleBarValueChangeListener;
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
        if (z3) {
            this.mHighlightPaint.setColor(z_renamed ? sBigScaleColor : sHighlightColor);
        }
        invalidate();
    }

    public void setAlign(int i_renamed) {
        if (i_renamed == 1 || i_renamed == 2) {
            this.mAlign = i_renamed;
        }
    }

    private class FlingInterpolator extends android.view.animation.PathInterpolator {
        FlingInterpolator() {
            super(0.0f, 0.0f, com.oplus.camera.ui.CommonComponent.HSScaleBar.SECOND_CONTROL_POINT_X, 1.0f);
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
            this.mInterpolator = com.oplus.camera.ui.CommonComponent.HSScaleBar.this.new FlingInterpolator();
            if (com.oplus.camera.ui.CommonComponent.HSScaleBar.this.mScaleBarValueChangeListener != null) {
                com.oplus.camera.ui.CommonComponent.HSScaleBar.this.mScaleBarValueChangeListener.onBarScrolling(!this.mbFinish);
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
            if (com.oplus.camera.ui.CommonComponent.HSScaleBar.this.mScaleBarValueChangeListener != null) {
                com.oplus.camera.ui.CommonComponent.HSScaleBar.this.mScaleBarValueChangeListener.onBarScrolling(!this.mbFinish);
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
                com.oplus.camera.ui.CommonComponent.HSScaleBar.this.onMove(f_renamed);
                com.oplus.camera.ui.CommonComponent.HSScaleBar.this.mMyHandler.postDelayed(this, this.mFrameDuration);
            } else if (iCurrentAnimationTimeMillis >= i_renamed) {
                this.mLastX = 0.0f;
                if (com.oplus.camera.ui.CommonComponent.HSScaleBar.this.mOffset == 0.0f) {
                    com.oplus.camera.ui.CommonComponent.HSScaleBar.this.scrollNearbyScale();
                }
                com.oplus.camera.ui.CommonComponent.HSScaleBar.this.scrollNearbyScale();
                this.mbFinish = true;
                if (com.oplus.camera.ui.CommonComponent.HSScaleBar.this.mScaleBarValueChangeListener != null) {
                    com.oplus.camera.ui.CommonComponent.HSScaleBar.this.mScaleBarValueChangeListener.onBarScrolling(true ^ this.mbFinish);
                }
            }
            if (0.0f != com.oplus.camera.ui.CommonComponent.HSScaleBar.this.mOffset) {
                com.oplus.camera.ui.CommonComponent.HSScaleBar.this.startReboundAnimation();
            }
        }
    }
}
