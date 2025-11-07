package com.oplus.camera.p172ui.CommonComponent;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
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
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class HSScaleBar extends View {
    public static final int CENTER_ALIGN = 2;
    private static final float FIRST_CONTROL_POINT_X = 0.0f;
    private static final float FIRST_CONTROL_POINT_Y = 0.0f;
    private static final int FLING_VELOCITY_THRESHOLD = 1000;
    private static final String FUNCTION_COLOR = "color";
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
    private static final String TAG = "HSScaleBar";
    private static final int TEN_SMALL_SCALE_BETWEEN_BIG_SCALE = 2;
    private static int sBigScaleColor;
    private static int sHighlightColor;
    private static int sSmallScaleColor;
    private static int sTextColor;
    private int mAlign;
    private int[] mAlphaOffSet;
    private AnimatorSet mAnimatorSet;
    private int mBigScaleStrokeWidth;
    private int mCenterIndex;
    private Paint mCenterPaint;
    private int mCenterStartY;
    private int mColorDuration;
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
    private int mLineYBottom;
    private int mLongStartY;
    private int mMaxFlingVelocity;
    private float mMaxMarginIncrease;
    private Handler mMyHandler;
    private ArrayList<String> mNameList;
    private float mOffset;
    private int mOffsetCount;
    private int mOffsetEndY;
    private float mOffsetMargin;
    private Paint mPaint;
    private ScaleBarValueChangeListener mScaleBarValueChangeListener;
    private int mScaleHeight;
    private int mScaleMargin;
    private int mScalePointerX;
    private float mScaleRatio;
    private ValueAnimator mScaleValueAnimator;
    private int mShortStartY;
    private String[] mShowText;
    private int mSmallScaleStrokeWidth;
    private float mStartDistanceX;
    private float mStartOffsetX;
    private Paint mTextPaint;
    private int mTickTextSize;
    private VelocityTracker mVelocityTracker;
    private int maxFadingIndex;
    private boolean mbAuto;
    private boolean mbInitIndex;
    private boolean mbInitScalePointerX;
    private boolean mbValid;
    private int minFadingIndex;
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

    public HSScaleBar(Context context, AttributeSet attributeSet) {
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

    public HSScaleBar(Context context, int OplusGLSurfaceView_13, Handler handler) {
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
        this.mLevelNum = OplusGLSurfaceView_13;
        this.mContext = context;
        init();
    }

    public HSScaleBar(Context context, int OplusGLSurfaceView_13, Handler handler, ArrayList<String> arrayList, String[] strArr) {
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
        this.mLevelNum = OplusGLSurfaceView_13;
        this.mContext = context;
        this.mNameList = arrayList;
        this.mShowText = strArr;
        init();
    }

    private void initAnimator() {
        this.mIntervalAnim = new ValueAnimator();
        this.mIntervalAnim.setDuration(REBOUND_DURATION);
        this.mIntervalAnim.setInterpolator(REBOUND_INTERPOLATOR);
        this.mIntervalAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.CommonComponent.HSScaleBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HSScaleBar.this.mOffset = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HSScaleBar hSScaleBar = HSScaleBar.this;
                hSScaleBar.mOffsetMargin = (hSScaleBar.mOffset / HSScaleBar.this.mLimitMaxDistance) * HSScaleBar.this.mMaxMarginIncrease;
                HSScaleBar.this.invalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.CommonComponent.HSScaleBar.2
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
                HSScaleBar.this.updateIndex();
            }
        });
    }

    private void init() {
        if (this.mLevelNum <= 0) {
            this.mbValid = false;
            return;
        }
        this.mbValid = true;
        Resources resources = this.mContext.getResources();
        this.mBigScaleStrokeWidth = resources.getDimensionPixelSize(R.dimen.hs_professional_mode_scale_bar_big_scale_stroke_width);
        this.mSmallScaleStrokeWidth = resources.getDimensionPixelSize(R.dimen.hs_professional_mode_scale_bar_small_scale_stroke_width);
        this.mTickTextSize = resources.getDimensionPixelSize(R.dimen.hs_professional_mode_tick_text_size);
        this.mScaleMargin = resources.getDimensionPixelSize(R.dimen.hs_professional_mode_scale_bar_scale_margin);
        int OplusGLSurfaceView_13 = this.mScaleMargin;
        this.mLimitMaxDistance = this.mOffsetCount * OplusGLSurfaceView_13;
        this.mMaxMarginIncrease = OplusGLSurfaceView_13 * LIMIT_INCREASE_SPACE;
        this.mScaleHeight = resources.getDimensionPixelSize(R.dimen.hs_professional_mode_scale_bar_scale_height);
        sBigScaleColor = this.mContext.getColor(R.color.professional_mode_scale_bar_big_scale_color);
        sSmallScaleColor = this.mContext.getColor(R.color.blur_menu_seek_bar_line_color);
        sTextColor = this.mContext.getColor(R.color.color_white_with_30_percent_transparency);
        sHighlightColor = Util.m24164A(this.mContext);
        this.mLongStartY = resources.getDimensionPixelSize(R.dimen.hs_professional_mode_scale_bar_long_start);
        this.mShortStartY = resources.getDimensionPixelSize(R.dimen.hs_professional_mode_scale_bar_short_start);
        this.mCenterStartY = resources.getDimensionPixelSize(R.dimen.hs_professional_mode_scale_bar_center_start);
        this.mLineYBottom = resources.getDimensionPixelSize(R.dimen.hs_professional_mode_scale_bar_line_bottom);
        this.mOffsetEndY = resources.getDimensionPixelSize(R.dimen.hs_professional_mode_scale_bar_offset_end_y);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(sBigScaleColor);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(this.mBigScaleStrokeWidth);
        this.mHighlightPaint = new Paint();
        this.mHighlightPaint.setAntiAlias(true);
        this.mHighlightPaint.setColor(sHighlightColor);
        this.mHighlightPaint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setStrokeWidth(this.mBigScaleStrokeWidth);
        this.mHighlightPaint.setAlpha(0);
        this.mTextPaint = new Paint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setColor(sTextColor);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setStrokeWidth(this.mBigScaleStrokeWidth);
        this.mTextPaint.setTextSize(this.mTickTextSize);
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
        this.mScaleValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.CommonComponent.HSScaleBar.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HSScaleBar.this.mScaleRatio = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HSScaleBar.this.invalidate();
            }
        });
    }

    public void setCurrentIndex(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.mLevelNum) {
            return;
        }
        this.mCurrentIndex = OplusGLSurfaceView_13;
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

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float COUIBaseListPopupWindow_12;
        int OplusGLSurfaceView_13;
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
            float fAbs = (Math.abs((this.mScalePointerX - this.mStartDistanceX) - (this.mOffset - (r1 * ((int) (r3 / r1))))) + f5) - (this.mCurrentIndex * this.mScaleMargin);
            float fAbs2 = Math.abs(fAbs - f5) / f5;
            int iCompare = Float.compare(fAbs, f5);
            float f6 = this.mOffset;
            int i9 = (f6 == 0.0f || iCompare == 0) ? iCompare : f6 > 0.0f ? -1 : 1;
            int i10 = 0;
            while (i10 < this.mLevelNum) {
                int iAbs = Math.abs((this.mCurrentIndex - ((int) (this.mOffset / this.mScaleMargin))) - i10);
                if (iAbs < this.minFadingIndex || iAbs > this.maxFadingIndex) {
                    COUIBaseListPopupWindow_12 = 255.0f;
                } else if (i9 != -1) {
                    if (i9 == 1) {
                        if (i10 > this.mCurrentIndex) {
                            int[] iArr = this.mAlphaOffSet;
                            int i11 = 15 - iAbs;
                            f4 = iArr[i11];
                            i5 = iArr[16 - iAbs];
                            i6 = iArr[i11];
                            COUIBaseListPopupWindow_12 = ((i5 - i6) * INTERPOLATE_VALUE * fAbs2) + f4;
                        } else {
                            int[] iArr2 = this.mAlphaOffSet;
                            int i12 = 15 - iAbs;
                            f3 = iArr2[i12];
                            i3 = iArr2[16 - iAbs];
                            i4 = iArr2[i12];
                            COUIBaseListPopupWindow_12 = f3 - (((i3 - i4) * INTERPOLATE_VALUE) * fAbs2);
                        }
                    } else {
                        COUIBaseListPopupWindow_12 = this.mAlphaOffSet[15 - iAbs];
                    }
                } else if (i10 < this.mCurrentIndex) {
                    int[] iArr3 = this.mAlphaOffSet;
                    int i13 = 15 - iAbs;
                    f4 = iArr3[i13];
                    i5 = iArr3[16 - iAbs];
                    i6 = iArr3[i13];
                    COUIBaseListPopupWindow_12 = ((i5 - i6) * INTERPOLATE_VALUE * fAbs2) + f4;
                } else {
                    int[] iArr4 = this.mAlphaOffSet;
                    int i14 = 15 - iAbs;
                    f3 = iArr4[i14];
                    i3 = iArr4[16 - iAbs];
                    i4 = iArr4[i14];
                    COUIBaseListPopupWindow_12 = f3 - (((i3 - i4) * INTERPOLATE_VALUE) * fAbs2);
                }
                if (i10 % this.mCountBetweenBigScale == i7) {
                    OplusGLSurfaceView_13 = this.mShortStartY;
                } else {
                    OplusGLSurfaceView_13 = this.mLongStartY;
                }
                this.mPaint.setColor(sSmallScaleColor);
                this.mPaint.setStrokeWidth(this.mSmallScaleStrokeWidth);
                this.mPaint.setAlpha((int) COUIBaseListPopupWindow_12);
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
                canvas.drawLine(f9 + f8, OplusGLSurfaceView_13 - i15, f9 + f8, i8 - i15, this.mPaint);
                i10++;
                i9 = i9;
            }
            String[] strArr = this.mShowText;
            if (strArr != null) {
                for (String str : strArr) {
                    if (this.mNameList.indexOf(str) != -1) {
                        this.mTextPaint.getTextBounds(str, 0, str.length(), new Rect());
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
    public boolean onTouchEvent(MotionEvent motionEvent) {
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
            if (f3 <= i2 + this.mLimitMaxDistance && !Util.m24352ao()) {
                float f4 = this.mOffset;
                if (f4 == 0.0f) {
                    this.mOffset = (this.mStartDistanceX - this.mScalePointerX) * DAMPING;
                } else {
                    float f5 = COUIBaseListPopupWindow_12 * DAMPING;
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
                if (f3 + (i3 * (i4 - 1)) >= i2 - this.mLimitMaxDistance && !Util.m24352ao()) {
                    float f8 = this.mOffset;
                    if (f8 == 0.0f) {
                        this.mOffset = ((this.mStartDistanceX + (this.mScaleMargin * (this.mLevelNum - 1))) - this.mScalePointerX) * DAMPING;
                    } else {
                        float f9 = COUIBaseListPopupWindow_12 * DAMPING;
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
        if (z3) {
            this.mHighlightPaint.setColor(z ? sBigScaleColor : sHighlightColor);
        }
        invalidate();
    }

    public void setAlign(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2) {
            this.mAlign = OplusGLSurfaceView_13;
        }
    }

    private class FlingInterpolator extends PathInterpolator {
        FlingInterpolator() {
            super(0.0f, 0.0f, HSScaleBar.SECOND_CONTROL_POINT_X, 1.0f);
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
            this.mInterpolator = HSScaleBar.this.new FlingInterpolator();
            if (HSScaleBar.this.mScaleBarValueChangeListener != null) {
                HSScaleBar.this.mScaleBarValueChangeListener.onBarScrolling(!this.mbFinish);
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
            if (HSScaleBar.this.mScaleBarValueChangeListener != null) {
                HSScaleBar.this.mScaleBarValueChangeListener.onBarScrolling(!this.mbFinish);
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
                HSScaleBar.this.onMove(COUIBaseListPopupWindow_12);
                HSScaleBar.this.mMyHandler.postDelayed(this, this.mFrameDuration);
            } else if (iCurrentAnimationTimeMillis >= OplusGLSurfaceView_13) {
                this.mLastX = 0.0f;
                if (HSScaleBar.this.mOffset == 0.0f) {
                    HSScaleBar.this.scrollNearbyScale();
                }
                HSScaleBar.this.scrollNearbyScale();
                this.mbFinish = true;
                if (HSScaleBar.this.mScaleBarValueChangeListener != null) {
                    HSScaleBar.this.mScaleBarValueChangeListener.onBarScrolling(true ^ this.mbFinish);
                }
            }
            if (0.0f != HSScaleBar.this.mOffset) {
                HSScaleBar.this.startReboundAnimation();
            }
        }
    }
}
