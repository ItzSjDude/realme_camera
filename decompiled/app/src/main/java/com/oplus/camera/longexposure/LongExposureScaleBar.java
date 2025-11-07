package com.oplus.camera.longexposure;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.Paint;
import android.os.Handler;
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

/* compiled from: LongExposureScaleBar.java */
/* renamed from: com.oplus.camera.longexposure.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class LongExposureScaleBar extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final PathInterpolator f14604a = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int f14605b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int f14606c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static int f14607d;

    /* renamed from: A */
    private float f14608A;

    /* renamed from: B */
    private float f14609B;

    /* renamed from: C */
    private int f14610C;

    /* renamed from: D */
    private boolean f14611D;

    /* renamed from: E */
    private boolean f14612E;

    /* renamed from: F */
    private boolean f14613F;

    /* renamed from: G */
    private Context f14614G;

    /* renamed from: H */
    private Paint f14615H;

    /* renamed from: I */
    private Paint f14616I;

    /* renamed from: J */
    private Paint f14617J;

    /* renamed from: K */
    private IntrinsicsJvm.kt_3 f14618K;

    /* renamed from: L */
    private VelocityTracker f14619L;

    /* renamed from: M */
    private IntrinsicsJvm.kt_4 f14620M;

    /* renamed from: N */
    private Handler f14621N;

    /* renamed from: O */
    private ValueAnimator f14622O;

    /* renamed from: P */
    private float f14623P;

    /* renamed from: Q */
    private PathInterpolator f14624Q;

    /* renamed from: R */
    private float f14625R;

    /* renamed from: S */
    private int f14626S;

    /* renamed from: T */
    private ValueAnimator f14627T;

    /* renamed from: U */
    private AnimatorSet f14628U;

    /* renamed from: V */
    private int f14629V;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f14630e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f14631f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f14632g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f14633h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f14634i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f14635j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f14636k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f14637l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f14638m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int[] f14639n;

    /* renamed from: o */
    private int f14640o;

    /* renamed from: p */
    private int f14641p;

    /* renamed from: q */
    private int f14642q;

    /* renamed from: r */
    private int f14643r;

    /* renamed from: s */
    private int f14644s;

    /* renamed from: t */
    private int f14645t;

    /* renamed from: u */
    private int f14646u;

    /* renamed from: v */
    private int f14647v;

    /* renamed from: w */
    private float f14648w;

    /* renamed from: x */
    private float f14649x;

    /* renamed from: y */
    private float f14650y;

    /* renamed from: z */
    private float f14651z;

    /* compiled from: LongExposureScaleBar.java */
    /* renamed from: com.oplus.camera.longexposure.OplusGLSurfaceView_13$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo14596a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo14600b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo14604c(boolean z);

        /* renamed from: COUIBaseListPopupWindow_8 */
        void mo14606e(int OplusGLSurfaceView_13);
    }

    public LongExposureScaleBar(Context context, int OplusGLSurfaceView_13, Handler handler) throws Resources.NotFoundException {
        super(context);
        this.f14630e = 0.0f;
        this.f14631f = 0.0f;
        this.f14632g = 0;
        this.f14636k = 0;
        this.f14642q = 1;
        this.f14644s = 4;
        this.f14645t = 2;
        this.f14648w = 0.0f;
        this.f14649x = 0.0f;
        this.f14650y = 0.0f;
        this.f14651z = 0.0f;
        this.f14608A = 0.0f;
        this.f14609B = 0.0f;
        this.f14610C = 10;
        this.f14613F = true;
        this.f14622O = null;
        this.f14623P = 0.0f;
        this.f14624Q = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f14629V = 1;
        this.f14621N = handler;
        this.f14633h = OplusGLSurfaceView_13;
        this.f14614G = context;
        m14627b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14623a() {
        this.f14627T = new ValueAnimator();
        this.f14627T.setDuration(350L);
        this.f14627T.setInterpolator(f14604a);
        this.f14627T.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.longexposure.OplusGLSurfaceView_13.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LongExposureScaleBar.this.f14608A = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LongExposureScaleBar c2805i = LongExposureScaleBar.this;
                c2805i.f14609B = (c2805i.f14608A / LongExposureScaleBar.this.f14648w) * LongExposureScaleBar.this.f14649x;
                LongExposureScaleBar.this.invalidate();
            }
        });
        this.f14628U = new AnimatorSet();
        this.f14628U.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.longexposure.OplusGLSurfaceView_13.2
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
                LongExposureScaleBar.this.m14635e();
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14627b() throws Resources.NotFoundException {
        if (this.f14633h <= 0) {
            this.f14613F = false;
            return;
        }
        this.f14613F = true;
        this.f14625R = Util.m24202a(getContext(), R.dimen.level_panel_text_shadow_radius, Util.f22962a);
        this.f14626S = getContext().getResources().getColor(R.color.color_black_with_20_percent_transparency);
        Resources resources = this.f14614G.getResources();
        this.f14640o = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_big_scale_stroke_width);
        this.f14641p = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_small_scale_stroke_width);
        this.f14636k = resources.getDimensionPixelSize(R.dimen.long_exposure_scale_bar_scale_margin);
        int OplusGLSurfaceView_13 = this.f14636k;
        this.f14648w = this.f14610C * OplusGLSurfaceView_13;
        this.f14649x = OplusGLSurfaceView_13 * 1.5f;
        this.f14637l = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height);
        this.f14638m = resources.getDimensionPixelSize(R.dimen.long_exposure_scale_bar_scale_offsetY);
        this.f14639n = new int[]{0, resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height_offset_level1), resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height_offset_level2), resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height_offset_level3), resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height_offset_level4), resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height_offset_level5)};
        f14605b = this.f14614G.getColor(R.color.professional_mode_scale_bar_big_scale_color);
        f14606c = this.f14614G.getColor(R.color.blur_menu_seek_bar_line_color);
        f14607d = Util.m24164A(this.f14614G);
        this.f14647v = resources.getDimensionPixelSize(R.dimen.long_exposure_scale_bar_pointer_offset);
        setLayerType(1, null);
        this.f14615H = new Paint();
        this.f14615H.setMaskFilter(new BlurMaskFilter(this.f14625R, BlurMaskFilter.Blur.OUTER));
        this.f14615H.setStyle(Paint.Style.FILL);
        this.f14615H.setStrokeWidth(this.f14640o);
        this.f14615H.setColor(this.f14626S);
        this.f14616I = new Paint();
        this.f14616I.setAntiAlias(true);
        this.f14616I.setColor(f14605b);
        this.f14616I.setStyle(Paint.Style.FILL);
        this.f14616I.setStrokeWidth(this.f14641p);
        this.f14617J = new Paint();
        this.f14617J.setAntiAlias(true);
        this.f14617J.setColor(f14607d);
        this.f14617J.setStyle(Paint.Style.FILL);
        this.f14617J.setStrokeWidth(this.f14640o);
        this.f14617J.setAlpha(255);
        ViewConfiguration.get(this.f14614G);
        this.f14646u = ViewConfiguration.getMaximumFlingVelocity();
        int i2 = this.f14633h;
        this.f14643r = i2 % 2 == 0 ? (i2 / 2) - 1 : i2 / 2;
        if (this.f14643r < 0) {
            this.f14643r = 0;
        }
        this.f14622O = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f14622O.setDuration(500L);
        this.f14622O.setInterpolator(ProfessionalAnimConstant.f15695b);
        this.f14622O.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.longexposure.OplusGLSurfaceView_13.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LongExposureScaleBar.this.f14623P = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LongExposureScaleBar.this.invalidate();
            }
        });
        int color = getContext().getResources().getColor(R.color.color_black_with_20_percent_transparency);
        this.f14616I.setShadowLayer(this.f14625R, 0.0f, 0.0f, color);
        this.f14617J.setShadowLayer(this.f14625R, 0.0f, 0.0f, color);
    }

    public void setCurrentIndex(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f14633h) {
            return;
        }
        this.f14632g = OplusGLSurfaceView_13;
    }

    public void setLevelNum(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        CameraLog.m12954a("LongExposureScaleBar", "setLevelNum, levelNum: " + OplusGLSurfaceView_13);
        this.f14633h = OplusGLSurfaceView_13;
        if (this.f14613F) {
            int i2 = this.f14633h;
            this.f14643r = i2 % 2 == 0 ? (i2 / 2) - 1 : i2 / 2;
        } else {
            m14627b();
        }
    }

    public int getCurrentIndex() {
        return this.f14632g;
    }

    public void setScaleBarValueChangeListener(IntrinsicsJvm.kt_3 cVar) {
        this.f14618K = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.longexposure.LongExposureScaleBar.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            float xVelocity = 0.0f;
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX() - this.f14650y;
                    float y = motionEvent.getY() - this.f14651z;
                    this.f14650y = motionEvent.getX();
                    this.f14651z = motionEvent.getY();
                    if (Math.abs(x) >= Math.abs(y)) {
                        VelocityTracker velocityTracker = this.f14619L;
                        if (velocityTracker != null) {
                            velocityTracker.addMovement(motionEvent);
                        }
                        if (1 == getLayoutDirection()) {
                            m14624a(-x);
                        } else {
                            m14624a(x);
                        }
                    }
                } else if (action == 3) {
                    if (this.f14608A != 0.0f) {
                        m14630c();
                    } else {
                        VelocityTracker velocityTracker2 = this.f14619L;
                        if (velocityTracker2 != null) {
                            velocityTracker2.recycle();
                            this.f14619L = null;
                        }
                        m14631d();
                    }
                }
            } else if (this.f14608A != 0.0f) {
                m14630c();
            } else {
                VelocityTracker velocityTracker3 = this.f14619L;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                    this.f14619L.computeCurrentVelocity(1000, this.f14646u);
                    xVelocity = this.f14619L.getXVelocity();
                    this.f14619L.clear();
                }
                if (Math.abs(xVelocity) >= 1000.0f) {
                    if (1 == getLayoutDirection()) {
                        xVelocity = -xVelocity;
                    }
                    this.f14620M = new IntrinsicsJvm.kt_4(xVelocity);
                    this.f14621N.post(this.f14620M);
                } else {
                    m14631d();
                    IntrinsicsJvm.kt_3 cVar = this.f14618K;
                    if (cVar != null) {
                        cVar.mo14600b();
                    }
                }
            }
        } else {
            this.f14650y = motionEvent.getX();
            this.f14651z = motionEvent.getY();
            this.f14619L = VelocityTracker.obtain();
            IntrinsicsJvm.kt_4 bVar = this.f14620M;
            if (bVar != null) {
                bVar.m14641a();
                this.f14620M = null;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14630c() {
        if (this.f14627T == null || this.f14628U == null) {
            m14623a();
        }
        if (this.f14627T.isRunning()) {
            this.f14627T.cancel();
        }
        if (this.f14628U.isRunning()) {
            this.f14628U.cancel();
        }
        this.f14627T.setFloatValues(this.f14608A, 0.0f);
        this.f14628U.play(this.f14627T);
        this.f14628U.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m14631d() {
        int OplusGLSurfaceView_13 = (int) ((this.f14630e - this.f14631f) % this.f14636k);
        if (OplusGLSurfaceView_13 != 0) {
            int iAbs = Math.abs(OplusGLSurfaceView_13);
            int i2 = this.f14636k;
            if (iAbs < i2 / 2) {
                this.f14630e -= OplusGLSurfaceView_13;
            } else if (OplusGLSurfaceView_13 > 0) {
                this.f14630e = (this.f14630e - OplusGLSurfaceView_13) + i2;
            } else {
                this.f14630e = (this.f14630e - OplusGLSurfaceView_13) - i2;
            }
            m14635e();
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m14624a(float COUIBaseListPopupWindow_12) {
        if (!this.f14613F) {
            CameraLog.m12967f("LongExposureScaleBar", "onMove return, is not valid");
            return;
        }
        if (COUIBaseListPopupWindow_12 == 0.0f) {
            return;
        }
        int OplusGLSurfaceView_13 = 0.0f < COUIBaseListPopupWindow_12 ? 1 : -1;
        if (this.f14629V != OplusGLSurfaceView_13) {
            float f2 = this.f14608A;
            if (0.0f != f2) {
                if (OplusGLSurfaceView_13 == 1) {
                    this.f14608A = f2 + COUIBaseListPopupWindow_12 < 0.0f ? f2 + COUIBaseListPopupWindow_12 : 0.0f;
                } else {
                    this.f14608A = f2 + COUIBaseListPopupWindow_12 > 0.0f ? f2 + COUIBaseListPopupWindow_12 : 0.0f;
                }
                this.f14609B = (this.f14608A / this.f14648w) * this.f14649x;
                invalidate();
                return;
            }
        }
        this.f14629V = OplusGLSurfaceView_13;
        this.f14630e += (int) COUIBaseListPopupWindow_12;
        float f3 = this.f14630e;
        int i2 = this.f14635j;
        if (f3 >= i2) {
            float f4 = this.f14648w;
            if (f3 <= i2 + f4) {
                float f5 = this.f14608A;
                if (f5 == 0.0f) {
                    this.f14608A = (f3 - i2) * 0.3f;
                } else {
                    float f6 = COUIBaseListPopupWindow_12 * 0.3f;
                    if (f5 + f6 < f4) {
                        f4 = f5 + f6;
                    }
                    this.f14608A = f4;
                }
            } else {
                this.f14608A = 0.0f;
            }
            this.f14630e = this.f14635j;
        } else {
            int i3 = this.f14636k;
            int i4 = this.f14633h;
            if (((i4 - 1) * i3) + f3 <= i2) {
                float f7 = ((i4 - 1) * i3) + f3;
                float f8 = this.f14648w;
                if (f7 >= i2 - f8) {
                    float f9 = this.f14608A;
                    if (f9 == 0.0f) {
                        this.f14608A = ((f3 + (i3 * (i4 - 1))) - i2) * 0.3f;
                    } else {
                        float f10 = COUIBaseListPopupWindow_12 * 0.3f;
                        this.f14608A = f9 + f10 <= (-f8) ? -f8 : f10 + f9;
                    }
                } else {
                    this.f14608A = 0.0f;
                }
                this.f14630e = this.f14635j - (this.f14636k * (this.f14633h - 1));
            }
        }
        this.f14609B = (this.f14608A / this.f14648w) * this.f14649x;
        m14635e();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m14635e() {
        if (this.f14633h != 0) {
            float fAbs = Math.abs(this.f14635j - this.f14630e);
            int OplusGLSurfaceView_13 = (int) (((fAbs + (r1 / 2)) / this.f14636k) % this.f14633h);
            IntrinsicsJvm.kt_3 cVar = this.f14618K;
            if (cVar != null && OplusGLSurfaceView_13 != this.f14632g) {
                cVar.mo14596a();
                this.f14618K.mo14606e(OplusGLSurfaceView_13);
            }
            setCurrentIndex(OplusGLSurfaceView_13);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        if (this.f14634i > 0) {
            return;
        }
        this.f14634i = getMeasuredWidth();
        this.f14635j = (this.f14634i / 2) - (this.f14640o / 2);
        this.f14631f = (r2 % this.f14636k) - (r3 / 2);
        this.f14612E = true;
        if (!this.f14611D) {
            this.f14630e = 0.0f;
        }
        int i3 = this.f14632g;
        if (i3 >= 0) {
            m14640b(i3);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14639a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f14633h) {
            return;
        }
        this.f14630e = this.f14635j - (this.f14636k * OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14640b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f14633h) {
            return;
        }
        this.f14632g = OplusGLSurfaceView_13;
        if (this.f14612E) {
            this.f14630e = this.f14635j - (this.f14636k * OplusGLSurfaceView_13);
            this.f14611D = true;
            invalidate();
        }
    }

    public void setAlign(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2) {
            this.f14642q = OplusGLSurfaceView_13;
        }
    }

    /* compiled from: LongExposureScaleBar.java */
    /* renamed from: com.oplus.camera.longexposure.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends PathInterpolator {
        PlatformImplementations.kt_3() {
            super(0.0f, 0.0f, 0.58f, 1.0f);
        }
    }

    /* compiled from: LongExposureScaleBar.java */
    /* renamed from: com.oplus.camera.longexposure.OplusGLSurfaceView_13$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements Runnable {

        /* renamed from: IntrinsicsJvm.kt_5 */
        private float f14659d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private float f14660e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private float f14661f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private float f14662g;

        /* renamed from: OplusGLSurfaceView_15 */
        private long f14665j;

        /* renamed from: OplusGLSurfaceView_5 */
        private Interpolator f14666k;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f14657b = 400;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f14658c = 16;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private float f14663h = 0.15f;

        /* renamed from: OplusGLSurfaceView_13 */
        private boolean f14664i = false;

        public IntrinsicsJvm.kt_4(float COUIBaseListPopupWindow_12) {
            this.f14666k = LongExposureScaleBar.this.new PlatformImplementations.kt_3();
            if (LongExposureScaleBar.this.f14618K != null) {
                LongExposureScaleBar.this.f14618K.mo14604c(!this.f14664i);
            }
            this.f14662g = 0.0f;
            int OplusGLSurfaceView_13 = this.f14657b;
            this.f14659d = 1.0f / OplusGLSurfaceView_13;
            this.f14660e = COUIBaseListPopupWindow_12;
            this.f14661f = ((OplusGLSurfaceView_13 * this.f14660e) / 1000.0f) * this.f14663h;
            this.f14665j = AnimationUtils.currentAnimationTimeMillis();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m14641a() {
            this.f14664i = true;
            if (LongExposureScaleBar.this.f14618K != null) {
                LongExposureScaleBar.this.f14618K.mo14604c(!this.f14664i);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14664i) {
                return;
            }
            int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f14665j);
            float interpolation = this.f14666k.getInterpolation(iCurrentAnimationTimeMillis * this.f14659d);
            float COUIBaseListPopupWindow_12 = (interpolation - this.f14662g) * this.f14661f;
            this.f14662g = interpolation;
            int OplusGLSurfaceView_13 = this.f14657b;
            if (iCurrentAnimationTimeMillis < OplusGLSurfaceView_13) {
                LongExposureScaleBar.this.m14624a(COUIBaseListPopupWindow_12);
                LongExposureScaleBar.this.f14621N.postDelayed(this, this.f14658c);
            } else if (iCurrentAnimationTimeMillis >= OplusGLSurfaceView_13) {
                this.f14662g = 0.0f;
                if (LongExposureScaleBar.this.f14608A == 0.0f) {
                    LongExposureScaleBar.this.m14631d();
                }
                LongExposureScaleBar.this.m14631d();
                this.f14664i = true;
                if (LongExposureScaleBar.this.f14618K != null) {
                    LongExposureScaleBar.this.f14618K.mo14604c(true ^ this.f14664i);
                }
            }
            if (0.0f != LongExposureScaleBar.this.f14608A) {
                LongExposureScaleBar.this.m14630c();
            }
        }
    }
}
