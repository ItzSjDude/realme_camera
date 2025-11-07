package com.oplus.camera.filmvideomode;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p137b.SimpleAnimatorListener;
import com.oplus.camera.p172ui.control.ShutterButton;
import com.oplus.camera.p172ui.control.ThumbImageView;
import com.oplus.camera.p172ui.modepanel.MoreUIControl;
import com.oplus.camera.util.Util;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FilmAnimatorUtil.java */
/* renamed from: com.oplus.camera.filmvideomode.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class FilmAnimatorUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f13610a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static ValueAnimator.AnimatorUpdateListener f13611b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static List<AnimatorSet> f13612c = new CopyOnWriteArrayList();

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13460a() {
        for (AnimatorSet animatorSet : f13612c) {
            if (animatorSet.isStarted() || animatorSet.isRunning()) {
                CameraLog.m12959b("FilmAnimatorUtil", "cancel alphaAndTranslation animation");
                animatorSet.cancel();
            }
        }
        f13612c.clear();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m13479b(AnimatorSet animatorSet) {
        if (animatorSet == null || f13612c.contains(animatorSet)) {
            return;
        }
        f13612c.add(animatorSet);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m13481b() {
        return f13610a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13478a(boolean z) {
        f13610a = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13464a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        f13611b = animatorUpdateListener;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13467a(final View view, int OplusGLSurfaceView_13, boolean z, int i2, boolean z2) throws Resources.NotFoundException {
        Drawable background;
        if (view != null) {
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(Util.m24498u() ? R.dimen.fold_opened_movie_mode_menu_item_distance : R.dimen.movie_mode_menu_item_move_x);
            if (i2 < 5) {
                dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_item_move_20x);
            }
            final boolean z3 = view.getVisibility() == 0;
            int i3 = z3 ? dimensionPixelSize * OplusGLSurfaceView_13 : 0;
            boolean z4 = 3 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13;
            if (Util.m24451g() == 0 && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_10_BITS_HEIC_ENCODE_SUPPORT) && z4) {
                i3 -= dimensionPixelSize;
            }
            final AnimatorSet animatorSet = new AnimatorSet();
            if (z2) {
                animatorSet.setDuration(0L);
            } else {
                animatorSet.setDuration(200L);
            }
            animatorSet.setInterpolator(AnimationUtils.loadInterpolator(view.getContext(), R.anim.accelerate_decelerate_path_interpolator));
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "translationX", i3));
            if (OplusGLSurfaceView_13 != 0 && !z2) {
                float COUIBaseListPopupWindow_12 = view.isEnabled() ? 1.0f : 0.5f;
                float[] fArr = new float[2];
                fArr[0] = z3 ? 0.0f : COUIBaseListPopupWindow_12;
                if (!z3) {
                    COUIBaseListPopupWindow_12 = 0.0f;
                }
                fArr[1] = COUIBaseListPopupWindow_12;
                animatorSet.playTogether(ObjectAnimator.ofFloat(view, "alpha", fArr));
            }
            if (OplusGLSurfaceView_13 == 0 && !z2 && (background = view.getBackground()) != null) {
                background.setAlpha(255);
            }
            animatorSet.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.filmvideomode.IntrinsicsJvm.kt_4.1
                @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (!z3) {
                        view.setVisibility(0);
                    }
                    view.setTag(true);
                }

                @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!z3) {
                        view.setVisibility(8);
                    } else if (Util.m24498u()) {
                        view.setVisibility(0);
                    }
                    view.setTag(false);
                    FilmAnimatorUtil.m13482c(animatorSet);
                }

                @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (!z3) {
                        view.setVisibility(8);
                    } else if (Util.m24498u()) {
                        view.setVisibility(0);
                    }
                    view.setTag(false);
                    FilmAnimatorUtil.m13482c(animatorSet);
                }
            });
            m13479b(animatorSet);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m13482c(AnimatorSet animatorSet) {
        if (animatorSet == null) {
            return;
        }
        f13612c.remove(animatorSet);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13472a(FilmParamsContainer c2716k, View view) {
        if (c2716k != null) {
            int dimensionPixelSize = c2716k.getResources().getDimensionPixelSize(R.dimen.movie_mode_params_item_move_x);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(c2716k, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(view, "translationX", dimensionPixelSize, 0.0f), ObjectAnimator.ofFloat(c2716k, "scaleX", 0.9f, 1.0f));
            animatorSet.setDuration(200L);
            animatorSet.setInterpolator(AnimationUtils.loadInterpolator(c2716k.getContext(), R.anim.accelerate_decelerate_path_interpolator));
            animatorSet.start();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m13480b(final FilmParamsContainer c2716k, View view) {
        if (c2716k != null) {
            int dimensionPixelSize = c2716k.getResources().getDimensionPixelSize(R.dimen.movie_mode_params_item_move_x);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(c2716k, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(view, "translationX", 0.0f, dimensionPixelSize), ObjectAnimator.ofFloat(c2716k, "scaleX", 1.0f, 0.9f));
            animatorSet.setDuration(200L);
            animatorSet.setInterpolator(AnimationUtils.loadInterpolator(c2716k.getContext(), R.anim.accelerate_decelerate_path_interpolator));
            animatorSet.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.filmvideomode.IntrinsicsJvm.kt_4.2
                @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c2716k.setVisibility(8);
                }

                @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c2716k.setVisibility(8);
                }
            });
            animatorSet.start();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13470a(final ViewGroup viewGroup, ShutterButton shutterButton, final ThumbImageView thumbImageView, final RelativeLayout relativeLayout, final MoreUIControl c3358p, final ShutterButton shutterButton2, final View view, final View view2, final View view3) throws Resources.NotFoundException {
        float COUIBaseListPopupWindow_12;
        Interpolator interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(viewGroup.getContext(), R.anim.accelerate_decelerate_path_interpolator);
        Interpolator interpolatorLoadInterpolator2 = AnimationUtils.loadInterpolator(viewGroup.getContext(), R.anim.movie_enter_exit_path_interpolator);
        if (shutterButton != null) {
            float fM13459a = 0.0f;
            if (Util.m24498u()) {
                COUIBaseListPopupWindow_12 = 0.0f;
            } else {
                fM13459a = m13459a(shutterButton.getResources());
                COUIBaseListPopupWindow_12 = -shutterButton.getResources().getDimensionPixelSize(R.dimen.movie_mode_shutter_move_x);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(440L);
            animatorSet.setInterpolator(interpolatorLoadInterpolator);
            animatorSet.playTogether(ObjectAnimator.ofFloat(shutterButton, "translationX", COUIBaseListPopupWindow_12), ObjectAnimator.ofFloat(shutterButton, "translationY", fM13459a));
            animatorSet.start();
            if (c3358p != null) {
                ValueAnimator duration = ValueAnimator.ofInt(255, 0).setDuration(80L);
                duration.setInterpolator(interpolatorLoadInterpolator);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$IntrinsicsJvm.kt_4$-eYkpBtvA5jPYsG_6g7JERDDMoY
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FilmAnimatorUtil.m13476a(c3358p, valueAnimator);
                    }
                });
                ValueAnimator duration2 = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(180L);
                duration2.setInterpolator(interpolatorLoadInterpolator2);
                final ValueAnimator duration3 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(180L);
                duration3.setInterpolator(interpolatorLoadInterpolator2);
                duration2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$IntrinsicsJvm.kt_4$aUquX6hr7AXzK_wkNrzj_4WngF4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FilmAnimatorUtil.m13477a(c3358p, thumbImageView, shutterButton2, duration3, view, view2, view3, viewGroup, relativeLayout, valueAnimator);
                    }
                });
                duration3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$IntrinsicsJvm.kt_4$6Tp2IIjwyT71_XpOZCr9IXf0dd0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FilmAnimatorUtil.m13468a(view, view2, view3, thumbImageView, valueAnimator);
                    }
                });
                duration2.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m13476a(MoreUIControl c3358p, ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        c3358p.m22050e(iIntValue);
        if (iIntValue == 0) {
            c3358p.m22050e(255);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m13477a(MoreUIControl c3358p, ThumbImageView thumbImageView, ShutterButton shutterButton, ValueAnimator valueAnimator, View view, View view2, View view3, ViewGroup viewGroup, RelativeLayout relativeLayout, ValueAnimator valueAnimator2) {
        m13462a(((Float) valueAnimator2.getAnimatedValue()).floatValue(), c3358p, thumbImageView, shutterButton, valueAnimator, view, view2, view3, viewGroup, relativeLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m13468a(View view, View view2, View view3, ThumbImageView thumbImageView, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        m13465a(view, fFloatValue);
        m13465a(view2, fFloatValue);
        m13465a(view3, fFloatValue);
        if (Util.m24498u()) {
            return;
        }
        m13465a(thumbImageView, fFloatValue);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m13459a(Resources resources) throws Resources.NotFoundException {
        int iM24187O = Util.m24187O();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.control_panel_margin_top) + resources.getDimensionPixelSize(R.dimen.main_shutter_button_margin_top);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.shutter_button_length);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.movie_mode_params_bottom) + Util.m24318aG();
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.movie_mode_params_item_height);
        int screenHeight = (Util.getScreenHeight() - iM24187O) + dimensionPixelSize + (dimensionPixelSize2 / 2);
        int screenHeight2 = (Util.getScreenHeight() - dimensionPixelSize3) - (dimensionPixelSize4 / 2);
        CameraLog.m12959b("FilmAnimatorUtil", "getMovieShutterMoveDistance, navbar height: " + Util.m24318aG() + ", screeny: " + Util.getScreenHeight() + ", without nav: " + Util.m24193U() + ", shutterCenterY: " + screenHeight + ", movieParamsCenterY: " + screenHeight2 + ", movieParamsMarginBottom: " + dimensionPixelSize3 + ", panelHeight: " + iM24187O);
        return screenHeight2 - screenHeight;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m13462a(float COUIBaseListPopupWindow_12, MoreUIControl c3358p, ThumbImageView thumbImageView, ShutterButton shutterButton, ValueAnimator valueAnimator, View view, View view2, View view3, ViewGroup viewGroup, RelativeLayout relativeLayout) {
        c3358p.m22038a(COUIBaseListPopupWindow_12);
        shutterButton.setAlpha(COUIBaseListPopupWindow_12);
        if (!Util.m24498u()) {
            thumbImageView.setAlpha(COUIBaseListPopupWindow_12);
        }
        if (0.0f == COUIBaseListPopupWindow_12) {
            viewGroup.setLayoutDirection(0);
            c3358p.m22045b(false);
            c3358p.m22038a(1.0f);
            valueAnimator.start();
            m13466a(view, Util.m24498u() ? 4 : 0);
            m13466a(view2, 0);
            m13466a(view3, 0);
            m13466a((View) shutterButton, 8);
            m13465a((View) shutterButton, 1.0f);
            if (Util.m24498u()) {
                return;
            }
            m13471a(viewGroup, thumbImageView, relativeLayout);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m13471a(ViewGroup viewGroup, ThumbImageView thumbImageView, RelativeLayout relativeLayout) {
        if (viewGroup.indexOfChild(thumbImageView) < 0) {
            relativeLayout.removeView(thumbImageView);
            viewGroup.addView(thumbImageView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = thumbImageView.getResources().getDimensionPixelSize(R.dimen.movie_mode_thumbnail_width);
            layoutParams.height = thumbImageView.getResources().getDimensionPixelSize(R.dimen.movie_mode_thumbnail_height);
            layoutParams.topMargin = viewGroup.getResources().getDimensionPixelSize(R.dimen.movie_mode_thumbnail_top);
            layoutParams.leftMargin = viewGroup.getResources().getDimensionPixelSize(R.dimen.movie_mode_thumbnail_left);
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR)) {
                layoutParams.topMargin += thumbImageView.getResources().getDimensionPixelSize(R.dimen.setting_menu_move_down_y);
            }
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            thumbImageView.setLayoutParams(layoutParams);
            thumbImageView.setPadding(0, 0, 0, 0);
            thumbImageView.m18985a(thumbImageView.getResources().getDimensionPixelSize(R.dimen.movie_thumbnail_round_corner_radius), true, 0);
            thumbImageView.setRotation(90.0f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13469a(final ViewGroup viewGroup, ShutterButton shutterButton, final ThumbImageView thumbImageView, final RelativeLayout relativeLayout, final View view, final View view2, final View view3, final int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        Interpolator interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(viewGroup.getContext(), R.anim.accelerate_decelerate_path_interpolator);
        Interpolator interpolatorLoadInterpolator2 = AnimationUtils.loadInterpolator(viewGroup.getContext(), R.anim.movie_enter_exit_path_interpolator);
        if (shutterButton != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(440L);
            animatorSet.setInterpolator(interpolatorLoadInterpolator);
            float COUIBaseListPopupWindow_12 = 0;
            animatorSet.playTogether(ObjectAnimator.ofFloat(shutterButton, "translationX", COUIBaseListPopupWindow_12), ObjectAnimator.ofFloat(shutterButton, "translationY", COUIBaseListPopupWindow_12));
            animatorSet.start();
        }
        if (relativeLayout.indexOfChild(thumbImageView) < 0 && thumbImageView != null) {
            final ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(180L);
            duration.setInterpolator(interpolatorLoadInterpolator2);
            ValueAnimator duration2 = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(180L);
            duration.setInterpolator(interpolatorLoadInterpolator2);
            duration2.setInterpolator(interpolatorLoadInterpolator2);
            duration2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$IntrinsicsJvm.kt_4$tc_a1G7pNG4JfHn9RlerYqzLmSg
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) throws Resources.NotFoundException {
                    FilmAnimatorUtil.m13475a(thumbImageView, view, view2, view3, viewGroup, relativeLayout, duration, OplusGLSurfaceView_13, valueAnimator);
                }
            });
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$IntrinsicsJvm.kt_4$GtA1ce9wBKD-SQ-CBQvK6lI0cPI
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FilmAnimatorUtil.m13473a(thumbImageView, valueAnimator);
                }
            });
            duration2.start();
        }
        if (!Util.m24498u() || view2 == null) {
            return;
        }
        ValueAnimator duration3 = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(180L);
        duration3.setInterpolator(interpolatorLoadInterpolator2);
        duration3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$IntrinsicsJvm.kt_4$cnGIe0j8CsVt1WwzEF31IYaLBeg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) throws Resources.NotFoundException {
                FilmAnimatorUtil.m13474a(thumbImageView, view, view2, view3, viewGroup, relativeLayout, OplusGLSurfaceView_13, valueAnimator);
            }
        });
        duration3.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m13475a(ThumbImageView thumbImageView, View view, View view2, View view3, ViewGroup viewGroup, RelativeLayout relativeLayout, ValueAnimator valueAnimator, int OplusGLSurfaceView_13, ValueAnimator valueAnimator2) throws Resources.NotFoundException {
        m13461a(((Float) valueAnimator2.getAnimatedValue()).floatValue(), thumbImageView, view, view2, view3, viewGroup, relativeLayout, valueAnimator, OplusGLSurfaceView_13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m13473a(ThumbImageView thumbImageView, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        m13465a(thumbImageView, fFloatValue);
        if (1.0f == fFloatValue) {
            m13466a((View) thumbImageView, 0);
            if (f13610a) {
                m13478a(false);
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = f13611b;
                if (animatorUpdateListener != null) {
                    animatorUpdateListener.onAnimationUpdate(valueAnimator);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m13474a(ThumbImageView thumbImageView, View view, View view2, View view3, ViewGroup viewGroup, RelativeLayout relativeLayout, int OplusGLSurfaceView_13, ValueAnimator valueAnimator) throws Resources.NotFoundException {
        m13461a(((Float) valueAnimator.getAnimatedValue()).floatValue(), thumbImageView, view, view2, view3, viewGroup, relativeLayout, (ValueAnimator) null, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m13461a(float COUIBaseListPopupWindow_12, ThumbImageView thumbImageView, View view, View view2, View view3, ViewGroup viewGroup, RelativeLayout relativeLayout, ValueAnimator valueAnimator, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        if (!Util.m24498u()) {
            m13465a(thumbImageView, COUIBaseListPopupWindow_12);
            m13465a(view, COUIBaseListPopupWindow_12);
        }
        m13465a(view2, COUIBaseListPopupWindow_12);
        m13465a(view3, COUIBaseListPopupWindow_12);
        if (0.0f == COUIBaseListPopupWindow_12) {
            if (!Util.m24498u() && valueAnimator != null) {
                if (relativeLayout.indexOfChild(thumbImageView) < 0) {
                    viewGroup.removeView(thumbImageView);
                    relativeLayout.addView(thumbImageView);
                }
                viewGroup.setLayoutDirection(3);
                Resources resources = thumbImageView.getResources();
                int dimensionPixelSize = thumbImageView.getResources().getDimensionPixelSize(R.dimen.thumbnail_view_padding);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.thumbnail_view_width);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.width = dimensionPixelSize2;
                layoutParams.height = dimensionPixelSize2;
                layoutParams.leftMargin = resources.getDimensionPixelOffset(R.dimen.thumbnail_margin_start);
                layoutParams.topMargin = resources.getDimensionPixelOffset(R.dimen.fold_out_thumbnail_margin_top);
                thumbImageView.setLayoutParams(layoutParams);
                thumbImageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                thumbImageView.m18985a(resources.getDimensionPixelSize(R.dimen.thumbnail_round_corner_radius), false, OplusGLSurfaceView_13);
                thumbImageView.setRotation(0.0f);
                valueAnimator.start();
                m13466a(view, 8);
            }
            m13466a(view2, 8);
            m13466a(view3, 8);
            m13465a(view, 1.0f);
            m13465a(view2, 1.0f);
            m13465a(view3, 1.0f);
            viewGroup.removeView(view2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m13465a(View view, float COUIBaseListPopupWindow_12) {
        if (view != null) {
            view.setAlpha(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m13466a(View view, int OplusGLSurfaceView_13) {
        if (view != null) {
            view.setVisibility(OplusGLSurfaceView_13);
        }
    }
}
