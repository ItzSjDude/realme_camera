package com.oplus.camera.p172ui.CommonComponent;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.professional.ProfessionalAnimConstant;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class ScaleBar extends View {
    public static final int CENTER_ALIGN = 2;
    private static final float FIRST_CONTROL_POINT_X = 0.0f;
    private static final float FIRST_CONTROL_POINT_Y = 0.0f;
    private static final int FLING_VELOCITY_THRESHOLD = 1000;
    private static final String FUNCTION_ALPHA = "alpha";
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
    private static final String TAG = "ScaleBar";
    private static final int TEN_SMALL_SCALE_BETWEEN_BIG_SCALE = 10;
    private static int sBigScaleColor;
    private static int sHighlightColor;
    private static int sSmallScaleColor;
    private int mAlign;
    private AnimatorSet mAnimatorSet;
    private int mBigScaleStrokeWidth;
    private int mCenterIndex;
    private ObjectAnimator mColorObjectAnimator;
    private Context mContext;
    private int mCountBetweenBigScale;
    private int mCurrentIndex;
    private float mDownX;
    private float mDownY;
    private FlingRunnable mFlingRunnable;
    private Paint mHighlightPaint;
    private ValueAnimator mIntervalAnim;
    private int mLastMoveDirection;
    private int mLayoutWidth;
    private int mLevelNum;
    private float mLimitMaxDistance;
    private int mMaxFlingVelocity;
    private float mMaxMarginIncrease;
    private Handler mMyHandler;
    private boolean mNeedSetShadowLayer;
    private float mOffset;
    private int mOffsetCount;
    private float mOffsetMargin;
    private Paint mPaint;
    private ScaleBarValueChangeListener mScaleBarValueChangeListener;
    private int mScaleHeight;
    private int[] mScaleHeightOffSet;
    private int mScaleMargin;
    private int mScalePointerX;
    private float mScaleRatio;
    private int mScaleTopMargin;
    private ValueAnimator mScaleValueAnimator;
    private int mShadowColor;
    private Paint mShadowPaint;
    private float mShadowRadius;
    private int mSmallScaleStrokeWidth;
    private float mStartDistanceX;
    private float mStartOffsetX;
    private boolean mTouchable;
    private VelocityTracker mVelocityTracker;
    private boolean mbAuto;
    private boolean mbInitIndex;
    private boolean mbInitScalePointerX;
    private boolean mbLazySetIndex;
    private boolean mbValid;
    private static final float DAMPING = 0.3f;
    private static final PathInterpolator REBOUND_INTERPOLATOR = new PathInterpolator(DAMPING, 0.0f, 0.1f, 1.0f);

    public interface ScaleBarValueChangeListener {
        void onActionUp();

        void onBarMoving();

        void onBarScrolling(boolean z);

        void onValueChange(int OplusGLSurfaceView_13);
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

    public ScaleBar(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
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

    public ScaleBar(Context context, int OplusGLSurfaceView_13, Handler handler) throws Resources.NotFoundException {
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
        this.mLevelNum = OplusGLSurfaceView_13;
        this.mContext = context;
        init();
    }

    private void initAnimator() {
        this.mIntervalAnim = new ValueAnimator();
        this.mIntervalAnim.setDuration(REBOUND_DURATION);
        this.mIntervalAnim.setInterpolator(REBOUND_INTERPOLATOR);
        this.mIntervalAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.CommonComponent.ScaleBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScaleBar.this.mOffset = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ScaleBar scaleBar = ScaleBar.this;
                scaleBar.mOffsetMargin = (scaleBar.mOffset / ScaleBar.this.mLimitMaxDistance) * ScaleBar.this.mMaxMarginIncrease;
                ScaleBar.this.invalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.CommonComponent.ScaleBar.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ScaleBar.this.updateIndex();
            }
        });
    }

    private void init() throws Resources.NotFoundException {
        if (this.mLevelNum <= 0) {
            this.mbValid = false;
            return;
        }
        this.mbValid = true;
        setTouchable(true);
        this.mShadowRadius = Util.m24202a(getContext(), R.dimen.level_panel_text_shadow_radius, Util.f22962a);
        this.mShadowColor = getContext().getResources().getColor(R.color.color_black_with_20_percent_transparency);
        Resources resources = this.mContext.getResources();
        this.mBigScaleStrokeWidth = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_big_scale_stroke_width);
        this.mSmallScaleStrokeWidth = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_small_scale_stroke_width);
        this.mScaleTopMargin = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_top_margin);
        this.mScaleMargin = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_margin);
        int OplusGLSurfaceView_13 = this.mScaleMargin;
        this.mLimitMaxDistance = this.mOffsetCount * OplusGLSurfaceView_13;
        this.mMaxMarginIncrease = OplusGLSurfaceView_13 * LIMIT_INCREASE_SPACE;
        this.mScaleHeight = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height);
        this.mScaleHeightOffSet = new int[]{0, resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height_offset_level1), resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height_offset_level2), resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height_offset_level3), resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height_offset_level4), resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height_offset_level5)};
        this.mBigScaleStrokeWidth = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_big_scale_stroke_width);
        sBigScaleColor = this.mContext.getColor(R.color.professional_mode_scale_bar_big_scale_color);
        sSmallScaleColor = this.mContext.getColor(R.color.blur_menu_seek_bar_line_color);
        sHighlightColor = Util.m24164A(this.mContext);
        setLayerType(1, null);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setMaskFilter(new BlurMaskFilter(this.mShadowRadius, BlurMaskFilter.Blur.OUTER));
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setStrokeWidth(this.mBigScaleStrokeWidth);
        this.mShadowPaint.setColor(this.mShadowColor);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(sBigScaleColor);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(this.mSmallScaleStrokeWidth);
        this.mHighlightPaint = new Paint();
        this.mHighlightPaint.setAntiAlias(true);
        this.mHighlightPaint.setColor(sHighlightColor);
        this.mHighlightPaint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setStrokeWidth(this.mBigScaleStrokeWidth);
        this.mHighlightPaint.setAlpha(0);
        ViewConfiguration.get(this.mContext);
        this.mMaxFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
        int i2 = this.mLevelNum;
        this.mCenterIndex = i2 % 2 == 0 ? (i2 / 2) - 1 : i2 / 2;
        if (this.mCenterIndex < 0) {
            this.mCenterIndex = 0;
        }
        this.mScaleValueAnimator = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mScaleValueAnimator.setDuration(500L);
        this.mScaleValueAnimator.setInterpolator(ProfessionalAnimConstant.f15695b);
        this.mScaleValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.CommonComponent.ScaleBar.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScaleBar.this.mScaleRatio = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ScaleBar.this.invalidate();
            }
        });
        this.mColorObjectAnimator = ObjectAnimator.ofObject(this.mHighlightPaint, FUNCTION_ALPHA, new IntEvaluator(), 0, 255);
        this.mColorObjectAnimator.setDuration(500L);
        this.mColorObjectAnimator.setInterpolator(ProfessionalAnimConstant.f15694a);
        this.mColorObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.CommonComponent.ScaleBar.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScaleBar.this.invalidate();
            }
        });
        if (this.mNeedSetShadowLayer) {
            int color = getContext().getResources().getColor(R.color.color_black_with_20_percent_transparency);
            this.mPaint.setShadowLayer(this.mShadowRadius, 0.0f, 0.0f, color);
            this.mHighlightPaint.setShadowLayer(this.mShadowRadius, 0.0f, 0.0f, color);
        }
    }

    public void setShadowLayer() {
        this.mNeedSetShadowLayer = true;
    }

    public void setCurrentIndex(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.mLevelNum) {
            return;
        }
        if (this.mbAuto && this.mScaleValueAnimator.isRunning()) {
            this.mbLazySetIndex = true;
        } else {
            this.mCurrentIndex = OplusGLSurfaceView_13;
        }
    }

    public void setLevelNum(int OplusGLSurfaceView_13) {
        CameraLog.m12954a(TAG, "setLevelNum, levelNum: " + OplusGLSurfaceView_13);
        this.mLevelNum = OplusGLSurfaceView_13;
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

    public void setScaleBarValueChangeListener(ScaleBarValueChangeListener scaleBarValueChangeListener) {
        this.mScaleBarValueChangeListener = scaleBarValueChangeListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0103  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.CommonComponent.ScaleBar.onDraw(android.graphics.Canvas):void");
    }

    private void drawLine(Canvas canvas, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, Paint paint) {
        if (this.mNeedSetShadowLayer) {
            canvas.drawLine(COUIBaseListPopupWindow_12, f2, f3, f4, this.mShadowPaint);
        }
        canvas.drawLine(COUIBaseListPopupWindow_12, f2, f3, f4, paint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isTouchable()) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            float xVelocity = 0.0f;
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX() - this.mDownX;
                    float y = motionEvent.getY() - this.mDownY;
                    this.mDownX = motionEvent.getX();
                    this.mDownY = motionEvent.getY();
                    if (Math.abs(x) >= Math.abs(y)) {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        if (velocityTracker != null) {
                            velocityTracker.addMovement(motionEvent);
                        }
                        if (1 == getLayoutDirection()) {
                            onMove(-x);
                        } else {
                            onMove(x);
                        }
                    }
                } else if (action == 3) {
                    if (this.mOffset != 0.0f) {
                        startReboundAnimation();
                    } else {
                        VelocityTracker velocityTracker2 = this.mVelocityTracker;
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
                VelocityTracker velocityTracker3 = this.mVelocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
                    xVelocity = this.mVelocityTracker.getXVelocity();
                    this.mVelocityTracker.clear();
                }
                if (Math.abs(xVelocity) >= 1000.0f) {
                    if (1 == getLayoutDirection()) {
                        xVelocity = -xVelocity;
                    }
                    this.mFlingRunnable = new FlingRunnable(xVelocity);
                    this.mMyHandler.post(this.mFlingRunnable);
                } else {
                    scrollNearbyScale();
                    ScaleBarValueChangeListener scaleBarValueChangeListener = this.mScaleBarValueChangeListener;
                    if (scaleBarValueChangeListener != null) {
                        scaleBarValueChangeListener.onActionUp();
                    }
                }
            }
        } else {
            this.mDownX = motionEvent.getX();
            this.mDownY = motionEvent.getY();
            this.mVelocityTracker = VelocityTracker.obtain();
            FlingRunnable flingRunnable = this.mFlingRunnable;
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
        int OplusGLSurfaceView_13 = (int) ((this.mStartDistanceX - this.mStartOffsetX) % this.mScaleMargin);
        if (OplusGLSurfaceView_13 != 0) {
            int iAbs = Math.abs(OplusGLSurfaceView_13);
            int i2 = this.mScaleMargin;
            if (iAbs < i2 / 2) {
                this.mStartDistanceX -= OplusGLSurfaceView_13;
            } else if (OplusGLSurfaceView_13 > 0) {
                this.mStartDistanceX = (this.mStartDistanceX - OplusGLSurfaceView_13) + i2;
            } else {
                this.mStartDistanceX = (this.mStartDistanceX - OplusGLSurfaceView_13) - i2;
            }
            updateIndex();
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMove(float COUIBaseListPopupWindow_12) {
        if (!this.mbValid) {
            CameraLog.m12967f(TAG, "onMove return, is not valid");
            return;
        }
        if (COUIBaseListPopupWindow_12 == 0.0f) {
            return;
        }
        int OplusGLSurfaceView_13 = 0.0f < COUIBaseListPopupWindow_12 ? 1 : -1;
        if (this.mLastMoveDirection != OplusGLSurfaceView_13) {
            float f2 = this.mOffset;
            if (0.0f != f2) {
                if (OplusGLSurfaceView_13 == 1) {
                    this.mOffset = f2 + COUIBaseListPopupWindow_12 < 0.0f ? f2 + COUIBaseListPopupWindow_12 : 0.0f;
                } else {
                    this.mOffset = f2 + COUIBaseListPopupWindow_12 > 0.0f ? f2 + COUIBaseListPopupWindow_12 : 0.0f;
                }
                this.mOffsetMargin = (this.mOffset / this.mLimitMaxDistance) * this.mMaxMarginIncrease;
                invalidate();
                return;
            }
        }
        this.mLastMoveDirection = OplusGLSurfaceView_13;
        this.mStartDistanceX += (int) COUIBaseListPopupWindow_12;
        float f3 = this.mStartDistanceX;
        int i2 = this.mScalePointerX;
        if (f3 >= i2) {
            float f4 = this.mLimitMaxDistance;
            if (f3 <= i2 + f4) {
                float f5 = this.mOffset;
                if (f5 == 0.0f) {
                    this.mOffset = (f3 - i2) * DAMPING;
                } else {
                    float f6 = COUIBaseListPopupWindow_12 * DAMPING;
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
                        float f10 = COUIBaseListPopupWindow_12 * DAMPING;
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
            float fAbs = Math.abs(this.mScalePointerX - this.mStartDistanceX);
            int OplusGLSurfaceView_13 = (int) (((fAbs + (r1 / 2)) / this.mScaleMargin) % this.mLevelNum);
            ScaleBarValueChangeListener scaleBarValueChangeListener = this.mScaleBarValueChangeListener;
            if (scaleBarValueChangeListener != null && OplusGLSurfaceView_13 != this.mCurrentIndex) {
                scaleBarValueChangeListener.onBarMoving();
                this.mScaleBarValueChangeListener.onValueChange(OplusGLSurfaceView_13);
            }
            setCurrentIndex(OplusGLSurfaceView_13);
        }
    }

    public void sliderRight() {
        onMove(this.mScaleMargin);
    }

    public void sliderLeft() {
        onMove(-this.mScaleMargin);
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
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

    public void scrollTo(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.mLevelNum) {
            return;
        }
        if (this.mbLazySetIndex) {
            this.mCurrentIndex = OplusGLSurfaceView_13;
            this.mbLazySetIndex = false;
        }
        this.mStartDistanceX = this.mScalePointerX - (this.mScaleMargin * OplusGLSurfaceView_13);
        invalidate();
    }

    public void initDataIndex(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.mLevelNum) {
            return;
        }
        this.mCurrentIndex = OplusGLSurfaceView_13;
        if (this.mbInitScalePointerX) {
            this.mStartDistanceX = this.mScalePointerX - (this.mScaleMargin * OplusGLSurfaceView_13);
            this.mbInitIndex = true;
            invalidate();
        }
    }

    public void setAuto(boolean z, boolean z2) {
        boolean z3 = this.mbAuto != z;
        this.mbAuto = z;
        if (z3 && z2) {
            this.mScaleValueAnimator.cancel();
            this.mScaleValueAnimator.start();
            if (z) {
                this.mColorObjectAnimator.setIntValues(255, 0);
            } else {
                this.mColorObjectAnimator.setIntValues(0, 255);
            }
            this.mColorObjectAnimator.cancel();
            this.mColorObjectAnimator.start();
        }
        invalidate();
    }

    public void setAlign(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2) {
            this.mAlign = OplusGLSurfaceView_13;
        }
    }

    public boolean isTouchable() {
        return this.mTouchable;
    }

    public void setTouchable(boolean z) {
        this.mTouchable = z;
    }

    private class FlingInterpolator extends PathInterpolator {
        FlingInterpolator() {
            super(0.0f, 0.0f, ScaleBar.SECOND_CONTROL_POINT_X, 1.0f);
        }
    }

    private class FlingRunnable implements Runnable {
        private static final int DEFAULT_DURATION = 400;
        private float mDurationReciprocal;
        private Interpolator mInterpolator;
        private float mLastX;
        private long mStartTime;
        private float mTotalDistance;
        private float mVelocityX;
        private int mDuration = 400;
        private int mFrameDuration = 16;
        private float mMagicVelocityPx = 0.15f;
        private boolean mbFinish = false;

        public FlingRunnable(float COUIBaseListPopupWindow_12) {
            this.mInterpolator = ScaleBar.this.new FlingInterpolator();
            if (ScaleBar.this.mScaleBarValueChangeListener != null) {
                ScaleBar.this.mScaleBarValueChangeListener.onBarScrolling(!this.mbFinish);
            }
            this.mLastX = 0.0f;
            int OplusGLSurfaceView_13 = this.mDuration;
            this.mDurationReciprocal = 1.0f / OplusGLSurfaceView_13;
            this.mVelocityX = COUIBaseListPopupWindow_12;
            this.mTotalDistance = ((OplusGLSurfaceView_13 * this.mVelocityX) / 1000.0f) * this.mMagicVelocityPx;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        }

        public void cancelFling() {
            this.mbFinish = true;
            if (ScaleBar.this.mScaleBarValueChangeListener != null) {
                ScaleBar.this.mScaleBarValueChangeListener.onBarScrolling(!this.mbFinish);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mbFinish) {
                return;
            }
            int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
            float interpolation = this.mInterpolator.getInterpolation(iCurrentAnimationTimeMillis * this.mDurationReciprocal);
            float COUIBaseListPopupWindow_12 = (interpolation - this.mLastX) * this.mTotalDistance;
            this.mLastX = interpolation;
            int OplusGLSurfaceView_13 = this.mDuration;
            if (iCurrentAnimationTimeMillis < OplusGLSurfaceView_13) {
                ScaleBar.this.onMove(COUIBaseListPopupWindow_12);
                ScaleBar.this.mMyHandler.postDelayed(this, this.mFrameDuration);
            } else if (iCurrentAnimationTimeMillis >= OplusGLSurfaceView_13) {
                this.mLastX = 0.0f;
                if (ScaleBar.this.mOffset == 0.0f) {
                    ScaleBar.this.scrollNearbyScale();
                }
                ScaleBar.this.scrollNearbyScale();
                this.mbFinish = true;
                if (ScaleBar.this.mScaleBarValueChangeListener != null) {
                    ScaleBar.this.mScaleBarValueChangeListener.onBarScrolling(true ^ this.mbFinish);
                }
            }
            if (0.0f != ScaleBar.this.mOffset) {
                ScaleBar.this.startReboundAnimation();
            }
        }
    }
}
