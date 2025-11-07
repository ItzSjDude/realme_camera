package com.oplus.camera.p172ui.menu.levelcontrol;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar;
import com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel;
import com.oplus.camera.p172ui.p173a.HintManager;
import com.oplus.camera.util.Util;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/* compiled from: BlurMenu.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class BlurMenu extends ExpandableMenuPanel {
    protected static final int ANGLE_360 = 360;
    public static final int BLUR_TEXT_SHADOW_RADIUS = 4;
    private static final String DECIMAL_PATTERN = "0.#";
    private static final String DECIMAL_PATTERN_LESS_ONE = "0.00";
    protected static final float DISPLA_ROTATE_Y = 0.6f;
    private static final int DURATION_190 = 190;
    private static final int DURATION_300 = 300;
    public static final int MAX_BLUR_MENU_VALUE = 25;
    public static final int MAX_VALUE = 100;
    private static final int PORTRAIT_BLUR_MIN_VALUE = 1;
    public static final int PORTRAIT_BLUR_TYPE = 2;
    private static final String TAG = "BlurMenu";
    protected static final String TEXT_NEGATIVE_SIGN = "-";
    public static final int TILT_SHIFT_BLUR_MIN_VALUE = 0;
    public static final int TILT_SHIFT_BLUR_TYPE = 1;
    public static final int VIDEO_BLUR_MIN_VALUE = 0;
    public static final int VIDEO_BLUR_TYPE = 0;
    private Activity mActivity;
    private PathInterpolator mAlphaInterpolator;
    private long mAnimationEndTime;
    private long mAnimationStartTime;
    private View mBackGroundView;
    private PlatformImplementations.kt_3 mBlurListener;
    protected BlurMenuSeekBar mBlurMenuSeekBar;
    private TextView mBlurMenuValuePrefixText;
    private TextView mBlurMenuValueText;
    private int mBlurOneTextMaxWidth;
    private int mBlurThreeTextMaxWidth;
    private int mBlurTwoTextMaxWidth;
    private int mBlurTwoTextWithPointMaxWidth;
    private int mBlurType;
    private LinearLayout mBlurView;
    protected int mCurrentDegree;
    DecimalFormat mDecimalFormat;
    DecimalFormat mDecimalFormatLessOne;
    private ValueAnimator mDispalyAnimation;
    private LinearLayout mDisplayView;
    private int mLastOrientation;
    private int mLastSeekBarValue;
    private int mLayoutMode;
    private AnimatorSet mMeneAnim;
    private int mMenuBgHeight;
    private int mMinValue;
    private BlurMenuSeekBar.InterfaceC3274d mOnProgressChangedListener;
    private RelativeLayout mParentContainerView;
    private PathInterpolator mPosInterpolator;
    private int mScreenRotation;
    protected int mStartDegree;
    private int mTargetDegree;
    private int mValueTextColor;
    private int mValueTextPercentSize;
    private int mValueTextSize;
    protected boolean mbClockwise;
    private boolean mbMenuOpen;
    private boolean mbVideoRecordingHideMenu;
    protected static final float DISPLA_ROTATE_X = 2.0f;
    public static final float[] BLUR_SHOWING_TEXT_VALUES = {16.0f, 14.0f, 13.0f, 11.0f, 10.0f, 9.0f, 8.0f, 7.1f, 6.3f, 5.6f, 5.0f, 4.5f, 4.0f, 3.5f, 3.2f, 2.8f, 2.5f, 2.2f, DISPLA_ROTATE_X, 1.8f, 1.6f, 1.4f, 1.2f, 1.1f, 0.95f};
    private static final float[] BLUR_HAL_FRONT_VALUES = {0.0f, DISPLA_ROTATE_X, 3.0f, 7.0f, 10.0f, 15.0f, 20.0f, 26.0f, 33.0f, 40.0f, 46.0f, 53.0f, 60.0f, 68.0f, 73.0f, 79.0f, 83.0f, 88.0f, 90.0f, 92.0f, 94.0f, 96.0f, 98.0f, 99.0f, 100.0f};
    private static final float[] BLUR_HAL_REAR_VALUES = {0.0f, 5.0f, 7.0f, 12.0f, 14.0f, 16.0f, 18.0f, 20.0f, 22.0f, 24.0f, 27.0f, 32.0f, 38.0f, 45.0f, 51.0f, 60.0f, 68.0f, 76.0f, 81.0f, 86.0f, 90.0f, 94.0f, 97.0f, 98.0f, 100.0f};

    /* compiled from: BlurMenu.java */
    /* renamed from: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo20006a(int OplusGLSurfaceView_13, boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo20007a(boolean z, boolean z2);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo20008a(boolean z, boolean z2, boolean z3);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo20009a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo20010b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo20011c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo20012d();

        /* renamed from: COUIBaseListPopupWindow_8 */
        void mo20013e();

        /* renamed from: COUIBaseListPopupWindow_12 */
        int mo20014f();

        /* renamed from: COUIBaseListPopupWindow_11 */
        boolean mo20015g();

        /* renamed from: COUIBaseListPopupWindow_10 */
        boolean mo20016h();

        /* renamed from: OplusGLSurfaceView_13 */
        boolean mo20017i();

        /* renamed from: OplusGLSurfaceView_15 */
        boolean mo20018j();

        /* renamed from: OplusGLSurfaceView_5 */
        void mo20019k();

        /* renamed from: OplusGLSurfaceView_14 */
        int mo20020l();

        /* renamed from: OplusGLSurfaceView_6 */
        int mo20021m();

        /* renamed from: OplusGLSurfaceView_11 */
        HintManager mo20022n();
    }

    protected int getMaxValue() {
        return 25;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public boolean openMenuCanDisableHighLight() {
        return true;
    }

    public BlurMenu(Activity activity, PlatformImplementations.kt_3 aVar) {
        super(activity);
        this.mDecimalFormat = new DecimalFormat(DECIMAL_PATTERN);
        this.mDecimalFormatLessOne = new DecimalFormat(DECIMAL_PATTERN_LESS_ONE);
        this.mCurrentDegree = 0;
        this.mStartDegree = 0;
        this.mbClockwise = false;
        this.mBlurOneTextMaxWidth = 0;
        this.mBlurTwoTextMaxWidth = 0;
        this.mBlurTwoTextWithPointMaxWidth = 0;
        this.mBlurThreeTextMaxWidth = 0;
        this.mTargetDegree = 0;
        this.mAnimationStartTime = 0L;
        this.mAnimationEndTime = 0L;
        this.mLastOrientation = 0;
        this.mActivity = null;
        this.mbMenuOpen = false;
        this.mbVideoRecordingHideMenu = false;
        this.mMinValue = 0;
        this.mBlurType = 0;
        this.mAlphaInterpolator = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.mPosInterpolator = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.mParentContainerView = null;
        this.mBackGroundView = null;
        this.mBlurView = null;
        this.mDisplayView = null;
        this.mBlurMenuSeekBar = null;
        this.mBlurMenuValueText = null;
        this.mBlurMenuValuePrefixText = null;
        this.mBlurListener = null;
        this.mMeneAnim = null;
        this.mDispalyAnimation = null;
        this.mMenuBgHeight = 0;
        this.mValueTextColor = 0;
        this.mValueTextSize = 0;
        this.mValueTextPercentSize = 0;
        this.mLastSeekBarValue = -1;
        this.mLayoutMode = 0;
        this.mScreenRotation = 0;
        this.mOnProgressChangedListener = new BlurMenuSeekBar.AbstractC3273c() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_3.1
            @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.AbstractC3273c, com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.InterfaceC3274d
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17423a(int OplusGLSurfaceView_13) {
                int realValue = BlurMenu.this.getRealValue(OplusGLSurfaceView_13);
                if (realValue != BlurMenu.this.mLastSeekBarValue) {
                    float fConvertBlurMenuValueToTextValue = BlurMenu.this.convertBlurMenuValueToTextValue(OplusGLSurfaceView_13);
                    BlurMenu.this.mLastSeekBarValue = realValue;
                    BlurMenu.this.mBlurListener.mo20006a(realValue, false);
                    BlurMenu.this.mBlurListener.mo20019k();
                    if (BlurMenu.this.mBlurMenuValueText != null) {
                        BlurMenu.this.mBlurMenuValueText.setText(BlurMenu.this.convertValueToFocus(fConvertBlurMenuValueToTextValue));
                    }
                }
            }
        };
        this.mActivity = activity;
        this.mBlurListener = aVar;
    }

    public void setBlurType(int OplusGLSurfaceView_13) {
        this.mBlurType = OplusGLSurfaceView_13;
    }

    public int getBlurType() {
        return this.mBlurType;
    }

    public boolean isTiltShiftBlurType() {
        return this.mBlurType == 1;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public void showMenuPanel(String str, boolean z, boolean z2) throws Resources.NotFoundException {
        if (!this.mBlurListener.mo20009a()) {
            CameraLog.m12954a(TAG, "showMenuPanel, return cannotExpandMenu");
        } else {
            show(true, z2);
            super.showMenuPanel(str, z, z2);
        }
    }

    public void showMenuPanelWithoutAnim(String str, boolean z, boolean z2) throws Resources.NotFoundException {
        show(true, z2);
        super.showMenuPanel(str, z, z2);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public void hideMenuPanel(boolean z, boolean z2) {
        if (isAnimationRunning()) {
            return;
        }
        boolean z3 = false;
        if (4 == this.mLayoutMode) {
            z2 = false;
        } else {
            z3 = true;
        }
        hideMenu(z, true, z2, z3);
    }

    public void show(boolean z, boolean z2) throws Resources.NotFoundException {
        this.mbMenuOpen = true;
        if (this.mBlurView == null) {
            initBlurView();
        }
        LinearLayout linearLayout = this.mDisplayView;
        if (linearLayout != null) {
            linearLayout.setRotation(-this.mLastOrientation);
        }
        if (this.mBlurView.getParent() == null) {
            if (z) {
                this.mBackGroundView.setLayoutParams(getBlurTextLayoutParams());
                showMenuWithAnim();
            } else {
                this.mBackGroundView.setAlpha(1.0f);
                this.mBlurView.setAlpha(1.0f);
                RelativeLayout relativeLayout = this.mParentContainerView;
                relativeLayout.addView(this.mBackGroundView, relativeLayout.indexOfChild(relativeLayout.findViewById(R.id_renamed.control_panel_layout)) + 1, getBlurTextLayoutParams());
                this.mParentContainerView.addView(this.mBlurView);
                this.mBlurListener.mo20013e();
            }
        }
        if (!this.mBlurListener.mo20010b() && !this.mbVideoRecordingHideMenu && !isTiltShiftBlurType()) {
            this.mBlurListener.mo20007a(true, z2);
        }
        int iMo20014f = this.mBlurListener.mo20014f();
        if (this.mBlurListener.mo20015g()) {
            if (iMo20014f == 0 && !this.mbVideoRecordingHideMenu) {
                iMo20014f = this.mBlurListener.mo20020l();
                this.mBlurListener.mo20006a(iMo20014f, false);
            }
            this.mMinValue = 0;
        } else if (this.mBlurListener.mo20016h()) {
            this.mMinValue = 0;
        } else {
            this.mMinValue = 1;
        }
        this.mBlurListener.mo20006a(iMo20014f, false);
        this.mBlurMenuSeekBar.setLevelNum(getMaxValue());
        initBlurSeekbarDefaultDotPosition();
        int iConvertToBlurMenuValue = convertToBlurMenuValue(iMo20014f);
        this.mBlurMenuSeekBar.setCurrentIndex(iConvertToBlurMenuValue);
        float fConvertBlurMenuValueToTextValue = convertBlurMenuValueToTextValue(iConvertToBlurMenuValue);
        TextView textView = this.mBlurMenuValueText;
        if (textView != null) {
            textView.setText(convertValueToFocus(fConvertBlurMenuValueToTextValue));
        }
        CameraLog.m12954a(TAG, "show, index: " + iMo20014f);
    }

    protected void initBlurSeekbarDefaultDotPosition() {
        if (!this.mBlurMenuSeekBar.mo17421d() || this.mBlurMenuSeekBar.m20770f()) {
            return;
        }
        float fConvertBlurMenuValueToTextValue = convertBlurMenuValueToTextValue(convertToBlurMenuValue(this.mBlurListener.mo20020l()));
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < getMaxValue(); OplusGLSurfaceView_13++) {
            if (fConvertBlurMenuValueToTextValue == convertBlurMenuValueToTextValue(OplusGLSurfaceView_13)) {
                this.mBlurMenuSeekBar.setDefaultDotPosition(OplusGLSurfaceView_13);
                return;
            }
        }
    }

    private RelativeLayout.LayoutParams getBlurTextLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int OplusGLSurfaceView_13 = this.mLayoutMode;
        if (1 == OplusGLSurfaceView_13) {
            int dimensionPixelOffset = this.mActivity.getResources().getDimensionPixelOffset(R.dimen.vertical_blur_menu_seekbar_margin_top) + this.mActivity.getResources().getDimensionPixelOffset(R.dimen.vertical_blur_menu_seekbar_layout_height) + this.mActivity.getResources().getDimensionPixelOffset(R.dimen.blur_text_top_margin);
            if (270 == this.mScreenRotation) {
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.mActivity.getResources().getDimensionPixelOffset(R.dimen.blur_text_left_margin);
            } else {
                layoutParams.addRule(9);
                layoutParams.leftMargin = this.mActivity.getResources().getDimensionPixelOffset(R.dimen.blur_text_left_margin);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            return layoutParams;
        }
        if (4 == OplusGLSurfaceView_13) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            layoutParams2.addRule(14);
            layoutParams2.bottomMargin = this.mActivity.getResources().getDimensionPixelOffset(R.dimen.fold_rack_screen_blur_menu_text_margin_bottom);
            return layoutParams2;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.mMenuBgHeight);
        layoutParams3.addRule(12);
        return layoutParams3;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public boolean isEffectMenuOpen() {
        return this.mbMenuOpen;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public boolean isEffectOpen() {
        return this.mBlurListener.mo20010b() && this.mBlurListener.mo20014f() > 0;
    }

    private void initBlurView() throws Resources.NotFoundException {
        Resources resources = this.mActivity.getApplicationContext().getResources();
        this.mMenuBgHeight = getMenuBgHeight();
        this.mValueTextColor = this.mActivity.getColor(R.color.color_white_with_full_percent_transparency);
        this.mValueTextSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.blur_menu_seekbar_value_text_size);
        this.mValueTextPercentSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.blur_menu_seekbar_value_text_percent_size);
        initBackgroundView();
        this.mParentContainerView = (RelativeLayout) this.mActivity.findViewById(R.id_renamed.camera);
        this.mBlurView = (LinearLayout) this.mActivity.getLayoutInflater().inflate(getMenuLayoutId(), (ViewGroup) null);
        this.mBlurMenuSeekBar = (BlurMenuSeekBar) this.mBlurView.findViewById(R.id_renamed.video_blur_seek_bar);
        this.mBlurMenuSeekBar.m20769e();
        this.mBlurMenuSeekBar.setBlurListener(this.mBlurListener);
        float dimension = getResources().getDimension(R.dimen.blure_notice_width);
        TextView textView = (TextView) this.mBlurView.findViewById(R.id_renamed.blur_strong_tv);
        TextView textView2 = (TextView) this.mBlurView.findViewById(R.id_renamed.blur_weak_tv);
        String string = getResources().getString(R.string.blur_notice_strong);
        String string2 = getResources().getString(R.string.blur_notice_weak);
        float fMeasureText = textView.getPaint().measureText(string);
        float fMeasureText2 = textView2.getPaint().measureText(string2);
        if (isTiltShiftBlurType()) {
            textView.setText(string2);
            textView2.setText(string);
            fMeasureText = textView2.getPaint().measureText(string2);
            fMeasureText2 = textView.getPaint().measureText(string);
        }
        CameraLog.m12967f(TAG, "initBlurView, strongTextWidth: " + fMeasureText + ", weakTextWidth: " + fMeasureText2 + ", textMinWidth: " + dimension);
        boolean z = fMeasureText > dimension;
        boolean z2 = fMeasureText2 > dimension;
        if (1 != this.mLayoutMode) {
            if (z) {
                textView.setGravity(3);
            }
            if (z2) {
                textView2.setGravity(5);
            }
        }
        this.mDisplayView = (LinearLayout) this.mBlurView.findViewById(R.id_renamed.blur_menu_display_text);
        LinearLayout linearLayout = this.mDisplayView;
        if (linearLayout != null) {
            linearLayout.post(new Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_3.2
                @Override // java.lang.Runnable
                public void run() {
                    BlurMenu.this.mDisplayView.setPivotX(BlurMenu.this.mDisplayView.getWidth() / BlurMenu.DISPLA_ROTATE_X);
                    BlurMenu.this.mDisplayView.setPivotY(BlurMenu.this.mDisplayView.getHeight() * 0.6f);
                }
            });
        }
        this.mBlurMenuValueText = (TextView) this.mBlurView.findViewById(R.id_renamed.blur_menu_value_text);
        float fMeasureText3 = this.mBlurMenuValueText.getPaint().measureText(getResources().getString(R.string.camera_percent_text));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBlurMenuValueText.getLayoutParams();
        layoutParams.setMargins((int) (fMeasureText3 / DISPLA_ROTATE_X), 0, 0, 0);
        this.mBlurMenuValueText.setLayoutParams(layoutParams);
        this.mBlurMenuValuePrefixText = (TextView) this.mBlurView.findViewById(R.id_renamed.blur_menu_value_prefix_text);
        this.mBlurMenuSeekBar.setScaleBarValueChangeListener(this.mOnProgressChangedListener);
        initTextPaint(this.mBlurMenuValueText.getPaint(), this.mBlurMenuValuePrefixText.getPaint());
        Util.m24275a(this.mBlurMenuValuePrefixText);
        Util.m24275a(this.mBlurMenuValueText);
        this.mBackGroundView.setLayoutParams(getBlurTextLayoutParams());
        this.mBlurView.setLayoutParams(getMenuLayoutParams(resources));
        this.mBlurView.setAlpha(0.0f);
        this.mBackGroundView.setAlpha(0.0f);
    }

    protected void hideBlurMenuValuePrefixText() {
        TextView textView = this.mBlurMenuValuePrefixText;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public void setOrientation(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        if (OplusGLSurfaceView_13 >= 0) {
            i2 = OplusGLSurfaceView_13 % ANGLE_360;
        } else {
            i2 = (OplusGLSurfaceView_13 % ANGLE_360) + ANGLE_360;
        }
        if (i2 != this.mTargetDegree || this.mDisplayView == null) {
            this.mTargetDegree = i2;
            if (this.mDisplayView != null) {
                if (z) {
                    this.mStartDegree = this.mCurrentDegree;
                    this.mAnimationStartTime = AnimationUtils.currentAnimationTimeMillis();
                    int i3 = this.mTargetDegree - this.mCurrentDegree;
                    if (i3 < 0) {
                        i3 += ANGLE_360;
                    }
                    if (i3 > 180) {
                        i3 -= 360;
                    }
                    this.mbClockwise = i3 >= 0;
                    this.mAnimationEndTime = this.mAnimationStartTime + ((Math.abs(i3) * 1000) / ANGLE_360);
                    ValueAnimator valueAnimator = this.mDispalyAnimation;
                    if (valueAnimator != null && valueAnimator.isRunning()) {
                        this.mDispalyAnimation.cancel();
                    }
                    this.mDispalyAnimation = ValueAnimator.ofFloat(this.mCurrentDegree, this.mTargetDegree);
                    this.mDispalyAnimation.setDuration(this.mAnimationEndTime - this.mAnimationStartTime);
                    this.mDispalyAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_3.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            int i4;
                            if (BlurMenu.this.mCurrentDegree != BlurMenu.this.mTargetDegree) {
                                long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                                if (jCurrentAnimationTimeMillis < BlurMenu.this.mAnimationEndTime) {
                                    int i5 = (int) (jCurrentAnimationTimeMillis - BlurMenu.this.mAnimationStartTime);
                                    int i6 = BlurMenu.this.mStartDegree;
                                    if (!BlurMenu.this.mbClockwise) {
                                        i5 = -i5;
                                    }
                                    int i7 = i6 + ((i5 * BlurMenu.ANGLE_360) / 1000);
                                    if (i7 >= 0) {
                                        i4 = i7 % BlurMenu.ANGLE_360;
                                    } else {
                                        i4 = (i7 % BlurMenu.ANGLE_360) + BlurMenu.ANGLE_360;
                                    }
                                    BlurMenu c3278c = BlurMenu.this;
                                    c3278c.mCurrentDegree = i4;
                                    c3278c.invalidate();
                                } else {
                                    BlurMenu c3278c2 = BlurMenu.this;
                                    c3278c2.mCurrentDegree = c3278c2.mTargetDegree;
                                }
                            }
                            BlurMenu.this.mDisplayView.setRotation(-BlurMenu.this.mCurrentDegree);
                        }
                    });
                    this.mDispalyAnimation.start();
                } else {
                    this.mCurrentDegree = this.mTargetDegree;
                    return;
                }
            }
            this.mLastOrientation = i2;
        }
    }

    private int getMenuBgHeight() {
        if (3 == this.mLayoutMode) {
            return this.mActivity.getResources().getDimensionPixelOffset(R.dimen.fold_split_screen_blur_menu_margin_bottom);
        }
        return Util.m24187O();
    }

    private void initBackgroundView() throws Resources.NotFoundException {
        if (1 == this.mLayoutMode) {
            this.mBackGroundView = LayoutInflater.from(this.mActivity).inflate(R.layout.blur_menu_background_vertical, (ViewGroup) null);
            Util.m24275a((TextView) this.mBackGroundView.findViewById(R.id_renamed.blur_bg_tv));
        } else {
            this.mBackGroundView = LayoutInflater.from(this.mActivity).inflate(R.layout.blur_menu_background, (ViewGroup) null);
            Util.m24275a((TextView) this.mBackGroundView.findViewById(R.id_renamed.blur_bg_tv));
        }
    }

    private RelativeLayout.LayoutParams getMenuLayoutParams(Resources resources) throws Resources.NotFoundException {
        int OplusGLSurfaceView_13 = this.mLayoutMode;
        if (1 == OplusGLSurfaceView_13) {
            if (270 == this.mScreenRotation) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelOffset(R.dimen.vertical_blur_menu_seekbar_layout_height));
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.vertical_blur_menu_seekbar_margin_top);
                layoutParams.rightMargin = 0;
                layoutParams.topMargin = dimensionPixelOffset;
                return layoutParams;
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelOffset(R.dimen.vertical_blur_menu_seekbar_layout_height));
            layoutParams2.addRule(9);
            layoutParams2.addRule(10);
            int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.vertical_blur_menu_seekbar_margin_top);
            layoutParams2.leftMargin = 0;
            layoutParams2.topMargin = dimensionPixelOffset2;
            return layoutParams2;
        }
        if (3 == OplusGLSurfaceView_13) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = resources.getDimensionPixelOffset(R.dimen.fold_split_screen_blur_menu_margin_bottom);
            return layoutParams3;
        }
        if (4 == OplusGLSurfaceView_13) {
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams4.addRule(12);
            layoutParams4.addRule(14);
            layoutParams4.bottomMargin = Util.m24460i(R.dimen.fold_rack_screen_blur_menu_margin_bottom);
            return layoutParams4;
        }
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(12);
        layoutParams5.bottomMargin = Util.m24187O() - resources.getDimensionPixelOffset(R.dimen.blur_menu_seekbar_padding_bottom_offset);
        return layoutParams5;
    }

    private int getMenuLayoutId() {
        int OplusGLSurfaceView_13 = this.mLayoutMode;
        return 1 == OplusGLSurfaceView_13 ? 270 == this.mScreenRotation ? R.layout.blur_menu_layout_vertical_270 : R.layout.blur_menu_layout_vertical : 4 == OplusGLSurfaceView_13 ? R.layout.blur_menu_layout_rack : R.layout.blur_menu_layout;
    }

    private void initTextPaint(Paint paint, Paint paint2) {
        if (paint != null) {
            paint.setAntiAlias(true);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setColor(this.mValueTextColor);
            paint.setTextSize(this.mValueTextSize);
            paint.setTypeface(Util.m24503x());
            computeDigitWidth(paint);
        }
        if (paint2 != null) {
            paint2.setAntiAlias(true);
            paint2.setStrokeCap(Paint.Cap.ROUND);
            paint2.setTextAlign(Paint.Align.LEFT);
            paint2.setColor(this.mValueTextColor);
            paint2.setTextSize(this.mValueTextPercentSize);
            paint2.setTypeface(Util.m24165A());
        }
    }

    protected String convertValueToFocus(float COUIBaseListPopupWindow_12) {
        int OplusGLSurfaceView_13 = (int) COUIBaseListPopupWindow_12;
        if (Float.compare(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12) == 0) {
            return NumberFormat.getInstance().format(OplusGLSurfaceView_13);
        }
        if (Float.compare(COUIBaseListPopupWindow_12, 1.0f) < 0) {
            return this.mDecimalFormatLessOne.format(COUIBaseListPopupWindow_12);
        }
        return this.mDecimalFormat.format(COUIBaseListPopupWindow_12);
    }

    protected int getRealValue(int OplusGLSurfaceView_13) {
        return Math.round(getVideoBlurValues(CameraCharacteristicsUtil.m12974a(this.mBlurListener.mo20021m()))[(r1.length - 1) - OplusGLSurfaceView_13]);
    }

    protected float getOffset(int OplusGLSurfaceView_13, int i2) {
        return Math.abs(getVideoBlurValues(CameraCharacteristicsUtil.m12974a(this.mBlurListener.mo20021m()))[(r1.length - 1) - OplusGLSurfaceView_13] - i2);
    }

    protected int getBlurTextWidth(float COUIBaseListPopupWindow_12) {
        boolean z = Float.compare(Math.abs(COUIBaseListPopupWindow_12 - ((float) ((int) COUIBaseListPopupWindow_12))), 0.0f) > 0;
        if (Float.compare(COUIBaseListPopupWindow_12, 1.0f) < 0 || Float.compare(COUIBaseListPopupWindow_12, 10.0f) >= 0) {
            if (z) {
                return this.mBlurThreeTextMaxWidth;
            }
            return this.mBlurTwoTextMaxWidth;
        }
        if (z) {
            return this.mBlurTwoTextWithPointMaxWidth;
        }
        return this.mBlurOneTextMaxWidth;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b A[PHI: r7
      0x003b: PHI (r7v7 float) = (r7v5 float), (r7v9 float) binds: [B:24:0x005a, B:14:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041 A[PHI: r7
      0x0041: PHI (r7v6 float) = (r7v5 float), (r7v9 float) binds: [B:27:0x005f, B:17:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void computeDigitWidth(android.graphics.Paint r13) {
        /*
            r12 = this;
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
        L7:
            int r7 = r12.getTextValuesLength()
            if (r2 >= r7) goto L7d
            float r7 = r12.convertBlurMenuValueToTextValue(r2)
            int r8 = (int) r7
            float r8 = (float) r8
            float r8 = r7 - r8
            float r8 = java.lang.Math.abs(r8)
            int r8 = java.lang.Float.compare(r8, r1)
            if (r8 <= 0) goto L21
            r8 = 1
            goto L22
        L21:
            r8 = r0
        L22:
            r9 = 1065353216(0x3f800000, float:1.0)
            int r9 = java.lang.Float.compare(r7, r9)
            if (r9 >= 0) goto L43
            java.text.DecimalFormat r9 = r12.mDecimalFormatLessOne
            double r10 = (double) r7
            java.lang.String r7 = r9.format(r10)
            float r7 = r13.measureText(r7)
            if (r8 == 0) goto L3d
            int r8 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r8 <= 0) goto L7a
        L3b:
            r6 = r7
            goto L7a
        L3d:
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 <= 0) goto L7a
        L41:
            r4 = r7
            goto L7a
        L43:
            r9 = 1092616192(0x41200000, float:10.0)
            int r9 = java.lang.Float.compare(r7, r9)
            if (r9 < 0) goto L62
            java.text.DecimalFormat r9 = r12.mDecimalFormat
            double r10 = (double) r7
            java.lang.String r7 = r9.format(r10)
            float r7 = r13.measureText(r7)
            if (r8 == 0) goto L5d
            int r8 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r8 <= 0) goto L7a
            goto L3b
        L5d:
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 <= 0) goto L7a
            goto L41
        L62:
            java.text.DecimalFormat r9 = r12.mDecimalFormat
            double r10 = (double) r7
            java.lang.String r7 = r9.format(r10)
            float r7 = r13.measureText(r7)
            if (r8 == 0) goto L75
            int r8 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r8 <= 0) goto L7a
            r5 = r7
            goto L7a
        L75:
            int r8 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r8 <= 0) goto L7a
            r3 = r7
        L7a:
            int r2 = r2 + 1
            goto L7
        L7d:
            double r0 = (double) r3
            double r0 = java.lang.Math.floor(r0)
            int r13 = (int) r0
            r12.mBlurOneTextMaxWidth = r13
            double r0 = (double) r4
            double r0 = java.lang.Math.floor(r0)
            int r13 = (int) r0
            r12.mBlurTwoTextMaxWidth = r13
            double r0 = (double) r5
            double r0 = java.lang.Math.floor(r0)
            int r13 = (int) r0
            r12.mBlurTwoTextWithPointMaxWidth = r13
            double r0 = (double) r6
            double r0 = java.lang.Math.floor(r0)
            int r13 = (int) r0
            r12.mBlurThreeTextMaxWidth = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu.computeDigitWidth(android.graphics.Paint):void");
    }

    private void showMenuWithAnim() {
        AnimatorSet animatorSet = this.mMeneAnim;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.mMeneAnim.cancel();
        }
        RelativeLayout relativeLayout = this.mParentContainerView;
        relativeLayout.addView(this.mBackGroundView, relativeLayout.indexOfChild(relativeLayout.findViewById(R.id_renamed.control_panel_layout)) + 1);
        RelativeLayout relativeLayout2 = this.mParentContainerView;
        relativeLayout2.addView(this.mBlurView, relativeLayout2.indexOfChild(this.mBackGroundView) + 1);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mBackGroundView, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.mAlphaInterpolator);
        objectAnimatorOfFloat.setDuration(400L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.mBlurView, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat2.setInterpolator(this.mAlphaInterpolator);
        objectAnimatorOfFloat2.setDuration(400L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.mBackGroundView, getAnimationTranslateProp(), getAnimationTranslateDistance(false), 0.0f);
        objectAnimatorOfFloat3.setInterpolator(this.mPosInterpolator);
        objectAnimatorOfFloat3.setDuration(400L);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.mBlurView, getAnimationTranslateProp(), getAnimationTranslateDistance(false), 0.0f);
        objectAnimatorOfFloat4.setInterpolator(this.mPosInterpolator);
        objectAnimatorOfFloat4.setDuration(400L);
        this.mMeneAnim = new AnimatorSet();
        this.mMeneAnim.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4);
        this.mMeneAnim.setStartDelay(150L);
        this.mMeneAnim.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_3.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (BlurMenu.this.mBlurListener != null) {
                    BlurMenu.this.mBlurListener.mo20013e();
                }
                BlurMenu.this.mbEnterAnimationRunning = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BlurMenu.this.mbEnterAnimationRunning = true;
            }
        });
        this.mMeneAnim.start();
        PlatformImplementations.kt_3 aVar = this.mBlurListener;
        if (aVar != null) {
            aVar.mo20012d();
        }
    }

    public void hideMenu(boolean z, boolean z2, boolean z3, boolean z4) {
        hideMenu(z, z2, z3, z4, false);
    }

    public void hideMenu(boolean z, boolean z2, final boolean z3, final boolean z4, boolean z5) {
        this.mbMenuOpen = false;
        if (this.mBlurListener.mo20014f() == 0) {
            if (this.mBlurListener.mo20017i() && this.mBlurListener.mo20018j()) {
                this.mbVideoRecordingHideMenu = true;
            } else {
                this.mBlurListener.mo20007a(false, false);
            }
        }
        if (!z2) {
            removeMenu();
            this.mBlurListener.mo20008a(z3, z4, false);
            super.hideMenuPanel(z, z3);
            return;
        }
        RelativeLayout relativeLayout = this.mParentContainerView;
        if (relativeLayout != null) {
            if (relativeLayout.getParent() == null && this.mBlurView.getParent() == null) {
                return;
            }
            AnimatorSet animatorSet = this.mMeneAnim;
            if (animatorSet != null && animatorSet.isStarted()) {
                this.mMeneAnim.cancel();
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mBackGroundView, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.mAlphaInterpolator);
            objectAnimatorOfFloat.setDuration(250L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.mBlurView, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.mAlphaInterpolator);
            objectAnimatorOfFloat2.setDuration(250L);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.mBackGroundView, getAnimationTranslateProp(), 0.0f, getAnimationTranslateDistance(z5));
            objectAnimatorOfFloat3.setInterpolator(this.mPosInterpolator);
            objectAnimatorOfFloat3.setDuration(400L);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.mBlurView, getAnimationTranslateProp(), 0.0f, getAnimationTranslateDistance(z5));
            objectAnimatorOfFloat4.setInterpolator(this.mPosInterpolator);
            objectAnimatorOfFloat4.setDuration(400L);
            this.mMeneAnim = new AnimatorSet();
            this.mMeneAnim.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4);
            this.mMeneAnim.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_3.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    BlurMenu.this.mbExitAnimationRunning = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BlurMenu.this.removeMenu();
                    BlurMenu c3278c = BlurMenu.this;
                    c3278c.mbExitAnimationRunning = false;
                    if (1 == c3278c.mLayoutMode) {
                        BlurMenu.this.mBlurListener.mo20011c();
                    } else {
                        BlurMenu.this.mBlurListener.mo20008a(z3, z4, true);
                    }
                }
            });
            this.mMeneAnim.start();
            this.mBlurListener.mo20008a(z3, z4, true);
            super.hideMenuPanel(z, z3);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public boolean onSingleTapUp(int OplusGLSurfaceView_13, int i2) {
        if (isMenuOpen()) {
            if (this.mMeneAnim.isStarted()) {
                this.mMeneAnim.cancel();
            }
            hideMenuPanel(true, false);
            return true;
        }
        return super.onSingleTapUp(OplusGLSurfaceView_13, i2);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public boolean onBackPressed() {
        if (isMenuOpen()) {
            if (this.mMeneAnim.isStarted()) {
                this.mMeneAnim.cancel();
            }
            hideMenuPanel(true, false);
            return true;
        }
        return super.onBackPressed();
    }

    public void stopVideoRecording() throws Resources.NotFoundException {
        if (this.mbVideoRecordingHideMenu) {
            if (this.mBlurListener.mo20015g()) {
                showMenuPanel(CameraUIInterface.KEY_VIDEO_BLUR_MENU, false, false);
            } else if (this.mBlurListener.mo20016h()) {
                showMenuPanel(CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU, false, false);
            }
            this.mbVideoRecordingHideMenu = false;
        }
    }

    public void setVideoRecordingHideMenu(boolean z) {
        this.mbVideoRecordingHideMenu = z;
    }

    public boolean isVideoRecordingHideMenu() {
        return this.mbVideoRecordingHideMenu;
    }

    public void updateBlurMenuIndex(int OplusGLSurfaceView_13) {
        this.mBlurListener.mo20006a(OplusGLSurfaceView_13, false);
        BlurMenuSeekBar blurMenuSeekBar = this.mBlurMenuSeekBar;
        if (blurMenuSeekBar != null) {
            blurMenuSeekBar.setLevelNum(getMaxValue());
            initBlurSeekbarDefaultDotPosition();
            this.mBlurMenuSeekBar.setCurrentIndex(convertToBlurMenuValue(OplusGLSurfaceView_13));
        }
    }

    private int convertToBlurMenuValue(int OplusGLSurfaceView_13) {
        float COUIBaseListPopupWindow_12 = 2.14748365E9f;
        int i2 = 0;
        for (int i3 = 0; i3 < getTextValuesLength(); i3++) {
            float offset = getOffset(i3, OplusGLSurfaceView_13);
            if (COUIBaseListPopupWindow_12 > offset) {
                i2 = i3;
                COUIBaseListPopupWindow_12 = offset;
            }
        }
        return i2;
    }

    protected int getTextValuesLength() {
        return BLUR_SHOWING_TEXT_VALUES.length;
    }

    protected float convertBlurMenuValueToTextValue(int OplusGLSurfaceView_13) {
        return BLUR_SHOWING_TEXT_VALUES[(r1.length - 1) - OplusGLSurfaceView_13];
    }

    public void setScreenMode(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a(TAG, "setScreenMode, layoutMode: " + OplusGLSurfaceView_13 + ", screenRotation: " + i2);
        this.mLayoutMode = OplusGLSurfaceView_13;
        this.mScreenRotation = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMenu() {
        LinearLayout linearLayout;
        View view;
        RelativeLayout relativeLayout = this.mParentContainerView;
        if (relativeLayout != null && (view = this.mBackGroundView) != null) {
            relativeLayout.removeView(view);
            this.mBackGroundView = null;
        }
        RelativeLayout relativeLayout2 = this.mParentContainerView;
        if (relativeLayout2 == null || (linearLayout = this.mBlurView) == null) {
            return;
        }
        relativeLayout2.removeView(linearLayout);
        this.mBlurView = null;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public boolean isAnimationRunning() {
        AnimatorSet animatorSet = this.mMeneAnim;
        return animatorSet != null && animatorSet.isRunning();
    }

    public boolean isMenuOpen() {
        return this.mbMenuOpen;
    }

    protected String getAnimationTranslateProp() {
        return 1 == this.mLayoutMode ? "translationX" : "translationY";
    }

    public static float[] getVideoBlurValues(boolean z) {
        float[] configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(z ? ConfigDataBase.KEY_VIDEO_BLUR_APP_FRONT_LIST : ConfigDataBase.KEY_VIDEO_BLUR_APP_REAR_LIST);
        if (configFloatArrayValue != null) {
            return configFloatArrayValue;
        }
        CameraLog.m12954a(TAG, "getVideoBlurValues, blur config is null");
        return z ? BLUR_HAL_FRONT_VALUES : BLUR_HAL_REAR_VALUES;
    }

    protected int getAnimationTranslateDistance(boolean z) {
        if (1 != this.mLayoutMode || 270 == this.mScreenRotation) {
            return z ? -this.mMenuTranslateY : this.mMenuTranslateY;
        }
        return -this.mMenuTranslateY;
    }
}
