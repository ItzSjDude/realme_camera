package com.oplus.camera.longexposure;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.oplus.camera.VibrateManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.longexposure.LongExposureScaleBar;
import com.oplus.camera.professional.SubModeBarData;
import com.oplus.camera.util.Util;
import java.util.ArrayList;

/* compiled from: LongExposureLevelPanel.java */
/* renamed from: com.oplus.camera.longexposure.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class LongExposureLevelPanel implements LongExposureScaleBar.IntrinsicsJvm.kt_3 {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Context f14562e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Activity f14563f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private SharedPreferences f14564g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Handler f14565h;

    /* renamed from: OplusGLSurfaceView_13 */
    private CameraInterface f14566i;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f14558a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f14559b = false;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private SubModeBarData f14560c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private LongExposureScaleBar f14561d = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private Resources f14567j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private RelativeLayout f14568k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private LongExposureRotableTextView f14569l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private LongExposureRotableTextView f14570m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private AnimatorSet f14571n = null;

    /* renamed from: o */
    private AnimatorSet f14572o = null;

    /* renamed from: p */
    private int f14573p = 0;

    /* renamed from: q */
    private PathInterpolator f14574q = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: r */
    private PathInterpolator f14575r = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    public LongExposureLevelPanel(Context context, Activity activity, SharedPreferences sharedPreferences, Handler handler, CameraInterface interfaceC2646a) {
        this.f14562e = null;
        this.f14563f = null;
        this.f14564g = null;
        this.f14565h = null;
        this.f14562e = context;
        this.f14563f = activity;
        this.f14564g = sharedPreferences;
        this.f14565h = handler;
        this.f14566i = interfaceC2646a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14597a(int OplusGLSurfaceView_13) {
        if (this.f14567j == null) {
            this.f14567j = this.f14563f.getResources();
        }
        if (this.f14568k == null) {
            this.f14568k = (RelativeLayout) this.f14563f.findViewById(R.id_renamed.camera);
        }
        this.f14558a = OplusGLSurfaceView_13;
        this.f14573p = this.f14567j.getDimensionPixelSize(R.dimen.long_exposure_scale_translate_y);
        m14582a(25, 1);
        m14591c();
        m14593d();
        m14602b(false);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m14591c() {
        if (this.f14569l == null) {
            this.f14569l = new LongExposureRotableTextView(this.f14562e);
            this.f14569l.setGravity(17);
            this.f14569l.setId(View.generateViewId());
            this.f14569l.setShadowLayer(this.f14567j.getDimension(R.dimen.long_exposure_text_radius_shadow), 0.0f, 0.0f, this.f14567j.getColor(R.color.color_black_with_20_percent_transparency));
            this.f14569l.setTextSize(0, this.f14567j.getDimension(R.dimen.long_exposure_exposure_time_text_size));
            this.f14569l.setTypeface(Util.m24473l(this.f14562e));
            this.f14569l.setTextColor(-1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f14567j.getDimensionPixelSize(R.dimen.long_exposure_exposure_time_text_width), this.f14567j.getDimensionPixelSize(R.dimen.long_exposure_exposure_time_text_height));
            layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            layoutParams.setMarginStart((int) this.f14567j.getDimension(R.dimen.long_exposure_exposure_time_text_margin_left));
            layoutParams.setMargins(0, (int) this.f14567j.getDimension(R.dimen.long_exposure_exposure_time_text_margin_top), 0, 0);
            this.f14568k.addView(this.f14569l, layoutParams);
        }
        if (this.f14570m == null) {
            this.f14570m = new LongExposureRotableTextView(this.f14563f);
            this.f14570m.setGravity(17);
            this.f14570m.setId(View.generateViewId());
            this.f14570m.setTextSize(0, this.f14567j.getDimension(R.dimen.long_exposure_capture_time_text_size));
            this.f14570m.setTypeface(Util.m24473l(this.f14562e));
            this.f14570m.setTextColor(Util.m24164A(this.f14563f));
            this.f14570m.setText(R.string.long_exposure_capture_time_text);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.f14567j.getDimensionPixelSize(R.dimen.long_exposure_capture_time_text_width), this.f14567j.getDimensionPixelSize(R.dimen.long_exposure_capture_time_text_height));
            layoutParams2.gravity = BadgeDrawable.BOTTOM_START;
            layoutParams2.setMarginStart((int) this.f14567j.getDimension(R.dimen.long_exposure_capture_time_text_margin_left));
            layoutParams2.setMargins(0, (int) this.f14567j.getDimension(R.dimen.long_exposure_capture_time_text_margin_top), 0, 0);
            this.f14568k.addView(this.f14570m, layoutParams2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14601b(int OplusGLSurfaceView_13) {
        if (this.f14558a != OplusGLSurfaceView_13) {
            this.f14559b = true;
        } else {
            this.f14559b = false;
        }
        this.f14558a = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14598a(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("LongExposureLevelPanel", "changeScene, currentType: " + OplusGLSurfaceView_13);
        if (1 == OplusGLSurfaceView_13) {
            if (this.f14564g.getBoolean("pref_long_exposure_streamer_portrait_auto_key", true)) {
                this.f14564g.edit().putString("pref_key_long_exposure_exposure_time", "auto").apply();
                int i2 = this.f14564g.getInt("pref_long_exposure_streamer_portrait_key", 6);
                this.f14561d.setCurrentIndex(i2);
                this.f14561d.m14639a(i2);
                m14585a(true, z);
                return;
            }
            this.f14564g.edit().putString("pref_key_long_exposure_exposure_time", "manual").apply();
            this.f14561d.setCurrentIndex(0);
            this.f14561d.m14639a(0);
            m14585a(false, z);
            return;
        }
        if (2 == OplusGLSurfaceView_13) {
            if (this.f14564g.getBoolean("pref_long_exposure_busy_traffic_auto_key", true)) {
                this.f14564g.edit().putString("pref_key_long_exposure_exposure_time", "auto").apply();
                int i3 = this.f14564g.getInt("pref_long_exposure_busy_traffic_key", 10);
                this.f14561d.setCurrentIndex(i3);
                this.f14561d.m14639a(i3);
                m14585a(true, z);
                return;
            }
            this.f14564g.edit().putString("pref_key_long_exposure_exposure_time", "manual").apply();
            this.f14561d.setCurrentIndex(0);
            this.f14561d.m14639a(0);
            m14585a(false, z);
            return;
        }
        if (3 == OplusGLSurfaceView_13) {
            if (this.f14564g.getBoolean("pref_long_exposure_flowing_clouds_and_water_auto_key", true)) {
                this.f14564g.edit().putString("pref_key_long_exposure_exposure_time", "auto").apply();
                int i4 = this.f14564g.getInt("pref_long_exposure_flowing_clouds_and_water_key", 8);
                this.f14561d.setCurrentIndex(i4);
                this.f14561d.m14639a(i4);
                m14585a(true, z);
                return;
            }
            this.f14564g.edit().putString("pref_key_long_exposure_exposure_time", "manual").apply();
            this.f14561d.setCurrentIndex(0);
            this.f14561d.m14639a(0);
            m14585a(false, z);
            return;
        }
        if (4 == OplusGLSurfaceView_13) {
            if (this.f14564g.getBoolean("pref_long_exposure_light_painting_auto_key", false)) {
                this.f14564g.edit().putString("pref_key_long_exposure_exposure_time", "auto").apply();
                int i5 = this.f14564g.getInt("pref_long_exposure_light_painting_key", 0);
                this.f14561d.setCurrentIndex(i5);
                this.f14561d.m14639a(i5);
                m14585a(true, z);
                return;
            }
            this.f14564g.edit().putString("pref_key_long_exposure_exposure_time", "manual").apply();
            this.f14561d.setCurrentIndex(0);
            this.f14561d.m14639a(0);
            this.f14564g.edit().putString("pref_key_long_exposure_exposure_time", "manual").apply();
            m14585a(false, z);
            return;
        }
        if (5 == OplusGLSurfaceView_13) {
            if (this.f14564g.getBoolean("pref_long_exposure_moving_crowd_auto_key", true)) {
                this.f14564g.edit().putString("pref_key_long_exposure_exposure_time", "auto").apply();
                int i6 = this.f14564g.getInt("pref_long_exposure_moving_crowd_key", 2);
                this.f14561d.setCurrentIndex(i6);
                this.f14561d.m14639a(i6);
                m14585a(true, z);
                return;
            }
            this.f14564g.edit().putString("pref_key_long_exposure_exposure_time", "manual").apply();
            this.f14561d.setCurrentIndex(0);
            this.f14561d.m14639a(0);
            m14585a(false, z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14599a(boolean z) {
        LongExposureScaleBar c2805i = this.f14561d;
        if (c2805i != null) {
            c2805i.setEnabled(true);
        }
        m14586a(z, this.f14561d, this.f14569l, this.f14570m);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14602b(boolean z) {
        LongExposureScaleBar c2805i = this.f14561d;
        if (c2805i != null) {
            c2805i.setEnabled(false);
        }
        m14589b(z, this.f14561d, this.f14569l, this.f14570m);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m14593d() {
        this.f14561d = new LongExposureScaleBar(this.f14562e, this.f14560c.m16147c().size(), this.f14565h);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f14567j.getDimensionPixelSize(R.dimen.long_exposure_scale_bar_width), this.f14567j.getDimensionPixelSize(R.dimen.long_exposure_scale_bar_height));
        layoutParams.gravity = BadgeDrawable.BOTTOM_START;
        layoutParams.setMarginStart((int) this.f14567j.getDimension(R.dimen.long_exposure_scale_bar_margin_left));
        layoutParams.setMarginEnd((int) this.f14567j.getDimension(R.dimen.long_exposure_scale_bar_margin_left));
        layoutParams.setMargins(0, (int) this.f14567j.getDimension(R.dimen.long_exposure_scale_bar_margin_top), 0, 0);
        this.f14561d.setScaleBarValueChangeListener(this);
        this.f14568k.addView(this.f14561d, layoutParams);
        this.f14561d.m14640b(this.f14564g.getInt("pref_long_exposure_streamer_portrait_key", 6));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14582a(int OplusGLSurfaceView_13, int i2) {
        this.f14560c = new SubModeBarData(this.f14562e);
        m14584a(this.f14560c, OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14584a(SubModeBarData c2908z, int OplusGLSurfaceView_13, int i2) {
        ArrayList<String> arrayListM16145b = c2908z.m16145b();
        ArrayList<String> arrayListM16147c = c2908z.m16147c();
        if (OplusGLSurfaceView_13 <= 0 || i2 <= 0 || OplusGLSurfaceView_13 == i2) {
            CameraLog.m12967f("LongExposureLevelPanel", "generateIsoValues, return null, maxISOValue: " + OplusGLSurfaceView_13 + ", minISOValue: " + i2 + ", maxISOValue: " + OplusGLSurfaceView_13);
            return;
        }
        arrayListM16145b.clear();
        arrayListM16147c.clear();
        while (i2 <= OplusGLSurfaceView_13) {
            arrayListM16145b.add(Integer.toString(i2));
            arrayListM16147c.add(Integer.toString(i2));
            i2++;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m14595f(int OplusGLSurfaceView_13) {
        VibrateManager c2613aeMo10528ad = this.f14566i.mo10528ad();
        if (c2613aeMo10528ad != null) {
            if (OplusGLSurfaceView_13 % 4 == 0) {
                c2613aeMo10528ad.m11294f();
            } else {
                c2613aeMo10528ad.m11292d();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public float m14603c(int OplusGLSurfaceView_13) {
        int i2 = 0;
        if (1 == OplusGLSurfaceView_13) {
            i2 = this.f14564g.getInt("pref_long_exposure_streamer_portrait_key", 6);
        } else if (2 == OplusGLSurfaceView_13) {
            i2 = this.f14564g.getInt("pref_long_exposure_busy_traffic_key", 10);
        } else if (3 == OplusGLSurfaceView_13) {
            i2 = this.f14564g.getInt("pref_long_exposure_flowing_clouds_and_water_key", 8);
        } else if (4 == OplusGLSurfaceView_13) {
            i2 = this.f14564g.getInt("pref_long_exposure_light_painting_key", 0);
        } else if (5 == OplusGLSurfaceView_13) {
            i2 = this.f14564g.getInt("pref_long_exposure_moving_crowd_key", 2);
        }
        return i2 * 0.5f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14585a(final boolean z, boolean z2) {
        if (!this.f14559b || !z2) {
            if (z) {
                this.f14569l.setText(m14603c(this.f14558a) + " s");
                return;
            }
            this.f14569l.setText("∞");
            return;
        }
        this.f14569l.clearAnimation();
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f14569l, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.f14574q);
        objectAnimatorOfFloat.setDuration(250L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f14569l, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat2.setInterpolator(this.f14574q);
        objectAnimatorOfFloat2.setDuration(250L);
        objectAnimatorOfFloat2.setStartDelay(150L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f14570m, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat3.setInterpolator(this.f14574q);
        objectAnimatorOfFloat3.setDuration(250L);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.f14570m, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat4.setInterpolator(this.f14574q);
        objectAnimatorOfFloat4.setDuration(250L);
        objectAnimatorOfFloat4.setStartDelay(150L);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.f14561d, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat5.setInterpolator(this.f14574q);
        objectAnimatorOfFloat5.setDuration(250L);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.f14561d, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat6.setInterpolator(this.f14574q);
        objectAnimatorOfFloat6.setDuration(250L);
        objectAnimatorOfFloat6.setStartDelay(150L);
        objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.longexposure.COUIBaseListPopupWindow_8.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z) {
                    LongExposureRotableTextView c2804h = LongExposureLevelPanel.this.f14569l;
                    StringBuilder sb = new StringBuilder();
                    LongExposureLevelPanel c2801e = LongExposureLevelPanel.this;
                    sb.append(c2801e.m14603c(c2801e.f14558a));
                    sb.append(" s");
                    c2804h.setText(sb.toString());
                } else {
                    LongExposureLevelPanel.this.f14569l.setText("∞");
                }
                LongExposureLevelPanel.this.f14561d.invalidate();
            }
        });
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4).with(objectAnimatorOfFloat5).with(objectAnimatorOfFloat6);
        animatorSet.start();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m14605d(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("LongExposureLevelPanel", "setOrientation: " + OplusGLSurfaceView_13);
        if (this.f14569l.getVisibility() == 0) {
            LongExposureRotableTextView c2804h = this.f14569l;
            c2804h.startAnimation(m14581a(c2804h, OplusGLSurfaceView_13, true));
        } else {
            m14588b(this.f14569l, OplusGLSurfaceView_13, true);
        }
        if (this.f14570m.getVisibility() == 0) {
            LongExposureRotableTextView c2804h2 = this.f14570m;
            c2804h2.startAnimation(m14581a(c2804h2, OplusGLSurfaceView_13, false));
        } else {
            m14588b(this.f14570m, OplusGLSurfaceView_13, false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14586a(boolean z, final View... viewArr) {
        AnimatorSet animatorSet = this.f14572o;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        CameraLog.m12954a("LongExposureLevelPanel", "showViews");
        if (viewArr == null) {
            CameraLog.m12954a("LongExposureLevelPanel", "showViews, view is null, so return!");
            return;
        }
        AnimatorSet animatorSet2 = this.f14571n;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            if (z) {
                ObjectAnimator[] objectAnimatorArrM14592c = m14592c(true, viewArr);
                ObjectAnimator[] objectAnimatorArrM14594d = m14594d(true, viewArr);
                this.f14571n = new AnimatorSet();
                this.f14571n.playTogether(objectAnimatorArrM14592c);
                this.f14571n.playTogether(objectAnimatorArrM14594d);
                this.f14571n.setStartDelay(150L);
                this.f14571n.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.longexposure.COUIBaseListPopupWindow_8.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        int OplusGLSurfaceView_13 = 0;
                        while (true) {
                            View[] viewArr2 = viewArr;
                            if (OplusGLSurfaceView_13 >= viewArr2.length) {
                                return;
                            }
                            View view = viewArr2[OplusGLSurfaceView_13];
                            view.setAlpha(1.0f);
                            view.setVisibility(0);
                            OplusGLSurfaceView_13++;
                        }
                    }
                });
                this.f14571n.start();
                return;
            }
            for (View view : viewArr) {
                view.setTranslationY(0.0f);
                view.setAlpha(1.0f);
                view.setVisibility(0);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14589b(boolean z, final View... viewArr) {
        CameraLog.m12954a("LongExposureLevelPanel", "hideViews");
        if (viewArr == null) {
            CameraLog.m12954a("LongExposureLevelPanel", "hideViews, view is null, so return!");
            return;
        }
        AnimatorSet animatorSet = this.f14571n;
        if (animatorSet != null && (animatorSet.isStarted() || this.f14571n.isRunning())) {
            CameraLog.m12954a("LongExposureLevelPanel", "hideViews, views are showing, just invisible and return!");
            this.f14571n.cancel();
        }
        AnimatorSet animatorSet2 = this.f14572o;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            if (z) {
                ObjectAnimator[] objectAnimatorArrM14592c = m14592c(false, viewArr);
                ObjectAnimator[] objectAnimatorArrM14594d = m14594d(false, viewArr);
                this.f14572o = new AnimatorSet();
                this.f14572o.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.longexposure.COUIBaseListPopupWindow_8.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        int OplusGLSurfaceView_13 = 0;
                        while (true) {
                            View[] viewArr2 = viewArr;
                            if (OplusGLSurfaceView_13 >= viewArr2.length) {
                                return;
                            }
                            View view = viewArr2[OplusGLSurfaceView_13];
                            view.setAlpha(0.0f);
                            view.setVisibility(4);
                            OplusGLSurfaceView_13++;
                        }
                    }
                });
                this.f14572o.playTogether(objectAnimatorArrM14592c);
                this.f14572o.playTogether(objectAnimatorArrM14594d);
                this.f14572o.start();
                return;
            }
            for (View view : viewArr) {
                view.setVisibility(4);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ObjectAnimator[] m14592c(boolean z, View... viewArr) {
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[viewArr.length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < viewArr.length; OplusGLSurfaceView_13++) {
            View view = viewArr[OplusGLSurfaceView_13];
            if (z) {
                view.setAlpha(0.0f);
                view.setVisibility(0);
            }
            objectAnimatorArr[OplusGLSurfaceView_13] = m14578a(view, z);
        }
        return objectAnimatorArr;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ObjectAnimator[] m14594d(boolean z, View... viewArr) {
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[viewArr.length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < viewArr.length; OplusGLSurfaceView_13++) {
            View view = viewArr[OplusGLSurfaceView_13];
            if (z) {
                objectAnimatorArr[OplusGLSurfaceView_13] = ObjectAnimator.ofFloat(view, "translationY", this.f14573p, 0.0f);
            } else {
                objectAnimatorArr[OplusGLSurfaceView_13] = ObjectAnimator.ofFloat(view, "translationY", 0.0f, this.f14573p);
            }
            objectAnimatorArr[OplusGLSurfaceView_13].setInterpolator(this.f14575r);
            objectAnimatorArr[OplusGLSurfaceView_13].setDuration(400L);
        }
        return objectAnimatorArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ObjectAnimator m14578a(View view, boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.f14574q);
        if (z) {
            objectAnimatorOfFloat.setDuration(400L);
        } else {
            objectAnimatorOfFloat.setDuration(250L);
        }
        return objectAnimatorOfFloat;
    }

    @Override // com.oplus.camera.longexposure.LongExposureScaleBar.IntrinsicsJvm.kt_3
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo14606e(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("LongExposureLevelPanel", "onValueChange" + this.f14558a + ",value: " + OplusGLSurfaceView_13);
        m14595f(OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 != 0) {
            this.f14564g.edit().putString("pref_key_long_exposure_exposure_time", "auto").apply();
            int i2 = this.f14558a;
            if (1 == i2) {
                this.f14564g.edit().putInt("pref_long_exposure_streamer_portrait_key", OplusGLSurfaceView_13).apply();
                this.f14564g.edit().putBoolean("pref_long_exposure_streamer_portrait_auto_key", true).apply();
            } else if (2 == i2) {
                this.f14564g.edit().putInt("pref_long_exposure_busy_traffic_key", OplusGLSurfaceView_13).apply();
                this.f14564g.edit().putBoolean("pref_long_exposure_busy_traffic_auto_key", true).apply();
            } else if (3 == i2) {
                this.f14564g.edit().putInt("pref_long_exposure_flowing_clouds_and_water_key", OplusGLSurfaceView_13).apply();
                this.f14564g.edit().putBoolean("pref_long_exposure_flowing_clouds_and_water_auto_key", true).apply();
            } else if (4 == i2) {
                this.f14564g.edit().putInt("pref_long_exposure_light_painting_key", OplusGLSurfaceView_13).apply();
                this.f14564g.edit().putBoolean("pref_long_exposure_light_painting_auto_key", true).apply();
            } else if (5 == i2) {
                this.f14564g.edit().putInt("pref_long_exposure_moving_crowd_key", OplusGLSurfaceView_13).apply();
                this.f14564g.edit().putBoolean("pref_long_exposure_moving_crowd_auto_key", true).apply();
            }
            m14585a(true, false);
            return;
        }
        this.f14564g.edit().putString("pref_key_long_exposure_exposure_time", "manual").apply();
        int i3 = this.f14558a;
        if (1 == i3) {
            this.f14564g.edit().putBoolean("pref_long_exposure_streamer_portrait_auto_key", false).apply();
        } else if (2 == i3) {
            this.f14564g.edit().putBoolean("pref_long_exposure_busy_traffic_auto_key", false).apply();
        } else if (3 == i3) {
            this.f14564g.edit().putBoolean("pref_long_exposure_flowing_clouds_and_water_auto_key", false).apply();
        } else if (4 == i3) {
            this.f14564g.edit().putBoolean("pref_long_exposure_light_painting_auto_key", false).apply();
        } else if (5 == i3) {
            this.f14564g.edit().putBoolean("pref_long_exposure_moving_crowd_auto_key", false).apply();
        }
        m14585a(false, false);
    }

    @Override // com.oplus.camera.longexposure.LongExposureScaleBar.IntrinsicsJvm.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14596a() {
        CameraLog.m12954a("LongExposureLevelPanel", "onBarMoving");
    }

    @Override // com.oplus.camera.longexposure.LongExposureScaleBar.IntrinsicsJvm.kt_3
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo14604c(boolean z) {
        CameraLog.m12954a("LongExposureLevelPanel", "onBarScrolling scrolling: " + z);
    }

    @Override // com.oplus.camera.longexposure.LongExposureScaleBar.IntrinsicsJvm.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo14600b() {
        CameraLog.m12954a("LongExposureLevelPanel", "onActionUp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public AnimationSet m14579a(float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(COUIBaseListPopupWindow_12, f2));
        animationSet.setDuration(OplusGLSurfaceView_13);
        animationSet.setInterpolator(this.f14562e, R.anim.ultra_wide_hint_alpha_path_interpolator);
        return animationSet;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private AnimationSet m14581a(final LongExposureRotableTextView c2804h, final int OplusGLSurfaceView_13, final boolean z) {
        AnimationSet animationSetM14579a = m14579a(1.0f, 0.0f, 180);
        animationSetM14579a.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.longexposure.COUIBaseListPopupWindow_8.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LongExposureLevelPanel.this.m14588b(c2804h, OplusGLSurfaceView_13, z);
                c2804h.startAnimation(LongExposureLevelPanel.this.m14579a(0.0f, 1.0f, 180));
            }
        });
        return animationSetM14579a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14588b(LongExposureRotableTextView c2804h, int OplusGLSurfaceView_13, boolean z) {
        if (OplusGLSurfaceView_13 == 90) {
            c2804h.setGravity(3);
        } else if (OplusGLSurfaceView_13 == 270) {
            c2804h.setGravity(5);
        } else {
            c2804h.setGravity(17);
        }
        if (z) {
            c2804h.m14619a(OplusGLSurfaceView_13);
        } else {
            c2804h.m14620b(OplusGLSurfaceView_13);
        }
    }
}
