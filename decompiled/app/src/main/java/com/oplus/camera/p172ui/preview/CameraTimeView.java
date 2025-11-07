package com.oplus.camera.p172ui.preview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p137b.SimpleAnimatorListener;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseListener;
import com.oplus.camera.p172ui.inverse.InverseImageView;
import com.oplus.camera.p172ui.inverse.InverseTextView;
import com.oplus.camera.perf.CameraPerformance;
import com.oplus.camera.util.Util;
import java.util.Locale;

/* loaded from: classes2.dex */
public class CameraTimeView extends LinearLayout {

    /* renamed from: A */
    private PathInterpolator f20703A;

    /* renamed from: B */
    private boolean f20704B;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f20705a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f20706b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ImageView f20707c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private InverseTextView f20708d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private InverseTextView f20709e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private InverseImageView f20710f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private InverseImageView f20711g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private InverseTextView f20712h;

    /* renamed from: OplusGLSurfaceView_13 */
    private InverseTextView f20713i;

    /* renamed from: OplusGLSurfaceView_15 */
    private InverseTextView f20714j;

    /* renamed from: OplusGLSurfaceView_5 */
    private InverseTextView f20715k;

    /* renamed from: OplusGLSurfaceView_14 */
    private View f20716l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f20717m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f20718n;

    /* renamed from: o */
    private int f20719o;

    /* renamed from: p */
    private int f20720p;

    /* renamed from: q */
    private int f20721q;

    /* renamed from: r */
    private boolean f20722r;

    /* renamed from: s */
    private boolean f20723s;

    /* renamed from: t */
    private InterfaceC3375a f20724t;

    /* renamed from: u */
    private int f20725u;

    /* renamed from: v */
    private int f20726v;

    /* renamed from: w */
    private InverseListener f20727w;

    /* renamed from: x */
    private AnimatorSet f20728x;

    /* renamed from: y */
    private AnimatorSet f20729y;

    /* renamed from: z */
    private PathInterpolator f20730z;

    /* renamed from: com.oplus.camera.ui.preview.CameraTimeView$PlatformImplementations.kt_3 */
    public interface InterfaceC3375a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo22103a(int OplusGLSurfaceView_13);
    }

    public CameraTimeView(Context context) {
        this(context, null);
    }

    public CameraTimeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraTimeView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f20705a = 0;
        this.f20706b = false;
        this.f20707c = null;
        this.f20708d = null;
        this.f20709e = null;
        this.f20710f = null;
        this.f20711g = null;
        this.f20712h = null;
        this.f20713i = null;
        this.f20714j = null;
        this.f20715k = null;
        this.f20716l = null;
        this.f20717m = 0;
        this.f20718n = 0;
        this.f20719o = 0;
        this.f20720p = 0;
        this.f20721q = 0;
        this.f20722r = false;
        this.f20723s = false;
        this.f20724t = null;
        this.f20725u = 0;
        this.f20726v = 0;
        this.f20727w = null;
        this.f20728x = null;
        this.f20729y = null;
        this.f20730z = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f20703A = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f20704B = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22091a() throws Resources.NotFoundException {
        m22097a(false, 0, 0, 0, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22097a(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) throws Resources.NotFoundException {
        this.f20717m = OplusGLSurfaceView_13;
        this.f20718n = i2;
        this.f20719o = i3;
        this.f20720p = i4;
        this.f20722r = z;
        this.f20721q = getResources().getDimensionPixelSize(R.dimen.camera_time_view_horizontal_margin);
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_radius_size);
        float dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_dx);
        float dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_dy);
        int color = getResources().getColor(R.color.camera_time_shadow_color);
        this.f20707c = (ImageView) findViewById(R.id_renamed.blink_record_icon);
        this.f20708d = (InverseTextView) findViewById(R.id_renamed.video_hour_ten);
        this.f20709e = (InverseTextView) findViewById(R.id_renamed.video_hour_unit);
        this.f20712h = (InverseTextView) findViewById(R.id_renamed.video_minute_ten);
        this.f20713i = (InverseTextView) findViewById(R.id_renamed.video_minute_unit);
        this.f20710f = (InverseImageView) findViewById(R.id_renamed.video_colon);
        this.f20711g = (InverseImageView) findViewById(R.id_renamed.video_colon_second);
        this.f20714j = (InverseTextView) findViewById(R.id_renamed.video_second_ten);
        this.f20715k = (InverseTextView) findViewById(R.id_renamed.video_second_unit);
        this.f20708d.setHorizontalInverseAble(false);
        this.f20709e.setHorizontalInverseAble(false);
        this.f20712h.setHorizontalInverseAble(false);
        this.f20713i.setHorizontalInverseAble(false);
        this.f20710f.setHorizontalInverseAble(false);
        this.f20711g.setHorizontalInverseAble(false);
        this.f20714j.setHorizontalInverseAble(false);
        this.f20715k.setHorizontalInverseAble(false);
        this.f20727w = new InverseListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$CameraTimeView$pE24saXlV9swSvsgrK01eUBulPI
            @Override // com.oplus.camera.p172ui.inverse.InverseListener
            public final boolean inverseAble() {
                return this.COUIBaseListPopupWindow_12$0.m22090n();
            }
        };
        this.f20710f.setInverseListener(this.f20727w);
        this.f20711g.setInverseListener(this.f20727w);
        this.f20708d.setInverseListener(this.f20727w);
        this.f20709e.setInverseListener(this.f20727w);
        this.f20712h.setInverseListener(this.f20727w);
        this.f20713i.setInverseListener(this.f20727w);
        this.f20714j.setInverseListener(this.f20727w);
        this.f20715k.setInverseListener(this.f20727w);
        this.f20708d.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color);
        this.f20709e.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color);
        this.f20712h.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color);
        this.f20713i.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color);
        this.f20714j.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color);
        this.f20715k.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color);
        this.f20708d.setTypeface(Util.m24411c(false));
        this.f20709e.setTypeface(Util.m24411c(false));
        this.f20712h.setTypeface(Util.m24411c(false));
        this.f20713i.setTypeface(Util.m24411c(false));
        this.f20714j.setTypeface(Util.m24411c(false));
        this.f20715k.setTypeface(Util.m24411c(false));
        if (this.f20722r) {
            this.f20716l = findViewById(R.id_renamed.record_split_view);
            this.f20716l.setVisibility(0);
            this.f20707c.setVisibility(8);
            this.f20707c = null;
        }
        this.f20725u = getResources().getDimensionPixelSize(R.dimen.inertial_zoombar_anim_transx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public /* synthetic */ boolean m22090n() {
        return (Util.m24495t() && 3 == this.f20726v) ? false : true;
    }

    public void setTypeface(Typeface typeface) {
        this.f20708d.setTypeface(typeface);
        this.f20709e.setTypeface(typeface);
        this.f20712h.setTypeface(typeface);
        this.f20713i.setTypeface(typeface);
        this.f20714j.setTypeface(typeface);
        this.f20715k.setTypeface(typeface);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m22099b() {
        this.f20707c.setVisibility(8);
        this.f20707c = null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m22100c() {
        InverseManager.INS.unRegisterInverse(getContext(), this.f20708d);
        InverseManager.INS.unRegisterInverse(getContext(), this.f20709e);
        InverseManager.INS.unRegisterInverse(getContext(), this.f20712h);
        InverseManager.INS.unRegisterInverse(getContext(), this.f20713i);
        InverseManager.INS.unRegisterInverse(getContext(), this.f20710f);
        InverseManager.INS.unRegisterInverse(getContext(), this.f20711g);
        InverseManager.INS.unRegisterInverse(getContext(), this.f20714j);
        InverseManager.INS.unRegisterInverse(getContext(), this.f20715k);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22092a(int OplusGLSurfaceView_13) {
        this.f20720p = OplusGLSurfaceView_13;
        m22087k();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22093a(int OplusGLSurfaceView_13, int i2, int i3, boolean z, boolean z2) {
        CameraLog.m12954a("CameraTimeView", "showTimeUI");
        if (z) {
            this.f20721q = i2;
        } else {
            this.f20721q = getResources().getDimensionPixelSize(R.dimen.camera_time_view_horizontal_margin);
        }
        this.f20723s = z;
        this.f20705a = i3;
        m22082f();
        this.f20717m = OplusGLSurfaceView_13;
        m22087k();
        this.f20706b = true;
        if (!z2 || z) {
            if (z2) {
                LayoutAnimationController layoutAnimationController = new LayoutAnimationController(m22079a(0.1f, 1.0f));
                layoutAnimationController.setDelay(0.0f);
                layoutAnimationController.setOrder(0);
                setLayoutAnimation(layoutAnimationController);
                setVisibility(0);
                startLayoutAnimation();
                return;
            }
            setVisibility(0);
            return;
        }
        AnimatorSet animatorSet = this.f20729y;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f20729y.cancel();
        }
        AnimatorSet animatorSet2 = this.f20728x;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            if (this.f20728x == null) {
                if (1 == this.f20726v) {
                    m22083g();
                } else {
                    m22084h();
                }
            }
            setAlpha(0.0f);
            setVisibility(0);
            this.f20728x.start();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m22082f() {
        this.f20708d.setOrientation(this.f20705a);
        this.f20709e.setOrientation(this.f20705a);
        this.f20712h.setOrientation(this.f20705a);
        this.f20713i.setOrientation(this.f20705a);
        this.f20710f.setOrientation(this.f20705a);
        this.f20711g.setOrientation(this.f20705a);
        this.f20714j.setOrientation(this.f20705a);
        this.f20715k.setOrientation(this.f20705a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22098a(boolean z, boolean z2) {
        CameraLog.m12967f("CameraTimeView", "hideTimeUI");
        if (8 == getVisibility()) {
            CameraLog.m12959b("CameraTimeView", "hideTimeUI, return");
            return;
        }
        this.f20723s = z2;
        this.f20706b = false;
        clearAnimation();
        this.f20706b = true;
        if (z && !z2) {
            if (this.f20728x != null && m22102e()) {
                this.f20728x.cancel();
            }
            if (this.f20729y == null) {
                if (1 == this.f20726v) {
                    m22085i();
                } else {
                    m22086j();
                }
            }
            this.f20729y.start();
            return;
        }
        if (z) {
            Animation.AnimationListener animationListener = new Animation.AnimationListener() { // from class: com.oplus.camera.ui.preview.CameraTimeView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    CameraLog.m12954a("CameraTimeView", "hideTimeUI, onAnimationStart");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    CameraTimeView.this.f20706b = false;
                    CameraLog.m12954a("CameraTimeView", "hideTimeUI, onAnimationEnd");
                }
            };
            AnimationSet animationSetM22079a = m22079a(1.0f, 0.0f);
            animationSetM22079a.setDuration(100L);
            animationSetM22079a.setAnimationListener(animationListener);
            startAnimation(animationSetM22079a);
            setVisibility(8);
            return;
        }
        setVisibility(8);
        this.f20706b = false;
        CameraLog.m12954a("CameraTimeView", "hideTimeUI, without Animation");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m22101d() {
        AnimatorSet animatorSet = this.f20729y;
        if (animatorSet != null) {
            return animatorSet.isRunning();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m22083g() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.f20730z);
        objectAnimatorOfFloat.setDuration(250L);
        this.f20728x = new AnimatorSet();
        this.f20728x.play(objectAnimatorOfFloat);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m22084h() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.f20730z);
        objectAnimatorOfFloat.setDuration(400L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "translationY", this.f20725u, 0.0f);
        objectAnimatorOfFloat2.setInterpolator(this.f20703A);
        objectAnimatorOfFloat2.setDuration(400L);
        this.f20728x = new AnimatorSet();
        this.f20728x.setStartDelay(150L);
        this.f20728x.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.f20728x.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.preview.CameraTimeView.2
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CameraLog.m12954a("CameraTimeView", "showTimeUI, onAnimationEnd");
                CameraTimeView.this.f20706b = false;
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                CameraLog.m12954a("CameraTimeView", "showTimeUI, onAnimationCancel");
                CameraTimeView.this.f20706b = false;
            }
        });
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m22085i() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.f20730z);
        objectAnimatorOfFloat.setDuration(250L);
        this.f20729y = new AnimatorSet();
        this.f20729y.play(objectAnimatorOfFloat);
        this.f20729y.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.preview.CameraTimeView.3
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                CameraLog.m12954a("CameraTimeView", "hideTimeUI, onAnimationStart");
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CameraLog.m12954a("CameraTimeView", "hideTimeUI, onAnimationEnd");
                CameraTimeView.this.f20706b = false;
                CameraTimeView.this.setVisibility(8);
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                CameraTimeView.this.f20706b = false;
                CameraTimeView.this.setVisibility(8);
            }
        });
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m22086j() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.f20730z);
        objectAnimatorOfFloat.setDuration(250L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "translationY", 0.0f, this.f20725u);
        objectAnimatorOfFloat2.setInterpolator(this.f20703A);
        objectAnimatorOfFloat2.setDuration(400L);
        this.f20729y = new AnimatorSet();
        this.f20729y.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.f20729y.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.preview.CameraTimeView.4
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                CameraLog.m12954a("CameraTimeView", "hideTimeUI, onAnimationStart");
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CameraLog.m12954a("CameraTimeView", "hideTimeUI, onAnimationEnd");
                CameraTimeView.this.f20706b = false;
                CameraTimeView.this.setVisibility(8);
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                CameraTimeView.this.f20706b = false;
                CameraTimeView.this.setVisibility(8);
            }
        });
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        super.setVisibility(OplusGLSurfaceView_13);
        if (8 == OplusGLSurfaceView_13) {
            this.f20706b = false;
        }
    }

    public int getBlinkRecordIconWidth() {
        ImageView imageView = this.f20707c;
        if (imageView != null) {
            return m22078a(imageView).getWidth();
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Size m22078a(View view) {
        view.measure(getPreviewFrameWidth(), getPreviewFrameWidth());
        return new Size(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setNeedRelayout(boolean z) {
        this.f20704B = z;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m22087k() {
        if (this.f20704B) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            Size sizeM22078a = m22078a(this);
            ImageView imageView = this.f20707c;
            int OplusGLSurfaceView_13 = 0;
            int blinkRecordIconWidth = (getBlinkRecordIconWidth() + (imageView != null ? ((LinearLayout.LayoutParams) imageView.getLayoutParams()).rightMargin : 0)) / 2;
            int i2 = this.f20705a;
            if (i2 == 90) {
                layoutParams.addRule(10);
                layoutParams.addRule(this.f20723s ? 9 : 11);
                layoutParams.topMargin = (((this.f20718n + (this.f20719o / 2)) + blinkRecordIconWidth) - (sizeM22078a.getHeight() / 2)) - this.f20720p;
                layoutParams.rightMargin = this.f20721q - (sizeM22078a.getWidth() / 2);
                OplusGLSurfaceView_13 = 90;
            } else if (i2 == 180) {
                layoutParams.addRule(9);
                layoutParams.addRule(10);
                layoutParams.leftMargin = ((getPreviewFrameWidth() / 2) - (sizeM22078a.getWidth() / 2)) + this.f20720p + blinkRecordIconWidth;
                layoutParams.topMargin = this.f20717m;
                OplusGLSurfaceView_13 = 180;
            } else if (i2 == 270) {
                layoutParams.addRule(9);
                layoutParams.addRule(10);
                layoutParams.topMargin = (((this.f20718n + (this.f20719o / 2)) - blinkRecordIconWidth) - (sizeM22078a.getHeight() / 2)) + this.f20720p;
                layoutParams.leftMargin = this.f20721q - (sizeM22078a.getWidth() / 2);
                OplusGLSurfaceView_13 = 270;
            } else if (4 == this.f20726v) {
                layoutParams.addRule(12);
                layoutParams.addRule(14);
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.fold_opened_movie_mode_record_time_margin_bottom);
            } else {
                layoutParams.addRule(9);
                layoutParams.leftMargin = (((getPreviewFrameWidth() / 2) - (sizeM22078a.getWidth() / 2)) + this.f20720p) - blinkRecordIconWidth;
                layoutParams.addRule(10);
                layoutParams.topMargin = this.f20717m;
            }
            setLayoutParams(layoutParams);
            setRotation(-OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private AnimationSet m22079a(float COUIBaseListPopupWindow_12, float f2) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(COUIBaseListPopupWindow_12, f2));
        animationSet.setDuration(300L);
        return animationSet;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22096a(boolean z) {
        ImageView imageView = this.f20707c;
        if (imageView != null) {
            if (z) {
                imageView.setImageResource(R.drawable.ic_recording_indicator);
            } else {
                imageView.setVisibility(4);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22094a(long OplusGLSurfaceView_15, boolean z) {
        m22095a(OplusGLSurfaceView_15, z, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22095a(long OplusGLSurfaceView_15, boolean z, boolean z2) {
        if (OplusGLSurfaceView_15 < 0) {
            CameraLog.m12967f("CameraTimeView", "updateRecordingTime: parameter is invalid");
            return;
        }
        m22081b(OplusGLSurfaceView_15, z2);
        ImageView imageView = this.f20707c;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 4);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22081b(long OplusGLSurfaceView_15, boolean z) {
        int iCeil;
        if (this.f20708d == null || this.f20709e == null || this.f20710f == null || this.f20712h == null || this.f20713i == null || this.f20714j == null || this.f20715k == null) {
            CameraLog.m12967f("CameraTimeView", "updateNormalRecordTimeView: parameter is invalid");
            return;
        }
        if (AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS <= OplusGLSurfaceView_15 && 3000 >= OplusGLSurfaceView_15) {
            CameraPerformance.m15188b("start_video_record");
        }
        int OplusGLSurfaceView_13 = (int) (OplusGLSurfaceView_15 / 3600000);
        int i2 = (int) ((OplusGLSurfaceView_15 % 3600000) / DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS);
        if (z) {
            iCeil = (int) Math.ceil((OplusGLSurfaceView_15 % DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS) / 1000.0f);
        } else {
            iCeil = (int) ((OplusGLSurfaceView_15 % DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS) / 1000);
        }
        if (OplusGLSurfaceView_13 > 0) {
            this.f20708d.setText(Util.m24474l(OplusGLSurfaceView_13 / 10));
            this.f20709e.setText(Util.m24474l(OplusGLSurfaceView_13 % 10));
            m22088l();
            InterfaceC3375a interfaceC3375a = this.f20724t;
            if (interfaceC3375a != null) {
                interfaceC3375a.mo22103a(getWidth());
            }
        } else {
            m22089m();
        }
        this.f20712h.setText(Util.m24474l(i2 / 10));
        this.f20713i.setText(Util.m24474l(i2 % 10));
        this.f20714j.setText(Util.m24474l(iCeil / 10));
        this.f20715k.setText(Util.m24474l(iCeil % 10));
        CameraLog.m12954a("CameraTimeView", String.format(Locale.getDefault(), "updateNormalRecordTimeView, time: %IntrinsicsJvm.kt_5:%IntrinsicsJvm.kt_5:%IntrinsicsJvm.kt_5, setText done.", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(iCeil)));
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m22088l() {
        InverseTextView inverseTextView;
        InverseImageView inverseImageView;
        InverseTextView inverseTextView2 = this.f20708d;
        if (inverseTextView2 == null || inverseTextView2.getVisibility() == 0 || (inverseTextView = this.f20709e) == null || inverseTextView.getVisibility() == 0 || (inverseImageView = this.f20710f) == null || inverseImageView.getVisibility() == 0) {
            return;
        }
        this.f20708d.setVisibility(0);
        this.f20709e.setVisibility(0);
        this.f20710f.setVisibility(0);
        m22087k();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m22089m() {
        InverseTextView inverseTextView = this.f20708d;
        if (inverseTextView != null) {
            inverseTextView.setVisibility(8);
        }
        InverseTextView inverseTextView2 = this.f20709e;
        if (inverseTextView2 != null) {
            inverseTextView2.setVisibility(8);
        }
        InverseImageView inverseImageView = this.f20710f;
        if (inverseImageView != null) {
            inverseImageView.setVisibility(8);
        }
    }

    public void setCameraTimeListener(InterfaceC3375a interfaceC3375a) {
        this.f20724t = interfaceC3375a;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m22102e() {
        return this.f20706b && getVisibility() == 0;
    }

    public void setScreenLayoutMode(int OplusGLSurfaceView_13) {
        if (1 == OplusGLSurfaceView_13 || 1 == this.f20726v) {
            AnimatorSet animatorSet = this.f20729y;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.f20729y.cancel();
            }
            AnimatorSet animatorSet2 = this.f20728x;
            if (animatorSet2 != null && animatorSet2.isRunning()) {
                this.f20728x.cancel();
            }
            this.f20729y = null;
            this.f20728x = null;
        }
        this.f20726v = OplusGLSurfaceView_13;
    }

    private int getPreviewFrameWidth() {
        if (3 == this.f20726v) {
            return Util.getScreenWidth() / 2;
        }
        return Util.getScreenWidth();
    }
}
