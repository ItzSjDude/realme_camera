package com.oplus.camera.p172ui.menu.levelcontrol;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
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
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu;
import com.oplus.camera.p172ui.p173a.HintManager;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class BlurMenuSeekBar extends View {

    /* renamed from: OplusGLSurfaceView_13 */
    private static final PathInterpolator f19476i = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: OplusGLSurfaceView_15 */
    private static final PathInterpolator f19477j = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: OplusGLSurfaceView_5 */
    private static int f19478k;

    /* renamed from: OplusGLSurfaceView_14 */
    private static int f19479l;

    /* renamed from: A */
    private float f19480A;

    /* renamed from: B */
    private float f19481B;

    /* renamed from: C */
    private float f19482C;

    /* renamed from: D */
    private float f19483D;

    /* renamed from: E */
    private float f19484E;

    /* renamed from: F */
    private float f19485F;

    /* renamed from: G */
    private int f19486G;

    /* renamed from: H */
    private ValueAnimator f19487H;

    /* renamed from: I */
    private AnimatorSet f19488I;

    /* renamed from: J */
    private int f19489J;

    /* renamed from: K */
    private boolean f19490K;

    /* renamed from: L */
    private boolean f19491L;

    /* renamed from: M */
    private boolean f19492M;

    /* renamed from: N */
    private Paint f19493N;

    /* renamed from: O */
    private Paint f19494O;

    /* renamed from: P */
    private Paint f19495P;

    /* renamed from: Q */
    private InterfaceC3274d f19496Q;

    /* renamed from: R */
    private VelocityTracker f19497R;

    /* renamed from: S */
    private RunnableC3272b f19498S;

    /* renamed from: T */
    private Handler f19499T;

    /* renamed from: U */
    private boolean f19500U;

    /* renamed from: V */
    private BlurMenu.PlatformImplementations.kt_3 f19501V;

    /* renamed from: W */
    private float f19502W;

    /* renamed from: PlatformImplementations.kt_3 */
    protected Context f19503a;

    /* renamed from: aa */
    private float f19504aa;

    /* renamed from: ab */
    private float f19505ab;

    /* renamed from: ac */
    private int f19506ac;

    /* renamed from: ad */
    private int f19507ad;

    /* renamed from: ae */
    private int f19508ae;

    /* renamed from: af */
    private int f19509af;

    /* renamed from: ag */
    private int f19510ag;

    /* renamed from: ah */
    private int f19511ah;

    /* renamed from: ai */
    private int f19512ai;

    /* renamed from: aj */
    private boolean f19513aj;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected int f19514b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected int f19515c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected int f19516d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected int f19517e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected int f19518f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected int[] f19519g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected int f19520h;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f19521m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f19522n;

    /* renamed from: o */
    private float f19523o;

    /* renamed from: p */
    private int f19524p;

    /* renamed from: q */
    private int f19525q;

    /* renamed from: r */
    private int f19526r;

    /* renamed from: s */
    private int f19527s;

    /* renamed from: t */
    private int f19528t;

    /* renamed from: u */
    private int f19529u;

    /* renamed from: v */
    private int f19530v;

    /* renamed from: w */
    private int f19531w;

    /* renamed from: x */
    private int f19532x;

    /* renamed from: y */
    private int f19533y;

    /* renamed from: z */
    private int f19534z;

    /* renamed from: com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar$IntrinsicsJvm.kt_3 */
    public static abstract class AbstractC3273c implements InterfaceC3274d {
        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.InterfaceC3274d
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17422a() {
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.InterfaceC3274d
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17423a(int OplusGLSurfaceView_13) {
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.InterfaceC3274d
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17424a(boolean z) {
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.InterfaceC3274d
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo17425b() {
        }
    }

    /* renamed from: com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar$IntrinsicsJvm.kt_5 */
    public interface InterfaceC3274d {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17422a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17423a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17424a(boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo17425b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo17414a(int OplusGLSurfaceView_13) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo17418b() {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo17420c() {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean mo17421d() {
        return true;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        return 1.0f;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        return 1.0f;
    }

    public BlurMenuSeekBar(Context context) {
        this(context, null);
    }

    public BlurMenuSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BlurMenuSeekBar(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f19515c = 0;
        this.f19521m = 0;
        this.f19517e = 30;
        this.f19518f = 0;
        this.f19519g = null;
        this.f19522n = 0.0f;
        this.f19523o = 0.0f;
        this.f19527s = 0;
        this.f19528t = 0;
        this.f19533y = 0;
        this.f19534z = 0;
        this.f19480A = 0.0f;
        this.f19481B = 0.0f;
        this.f19482C = 0.0f;
        this.f19483D = 0.0f;
        this.f19484E = 0.0f;
        this.f19485F = 0.0f;
        this.f19486G = 10;
        this.f19489J = 1;
        this.f19492M = true;
        this.f19500U = false;
        this.f19501V = null;
        this.f19504aa = 0.0f;
        this.f19505ab = 0.0f;
        this.f19507ad = 0;
        this.f19508ae = 0;
        this.f19509af = 0;
        this.f19510ag = 0;
        this.f19511ah = 0;
        this.f19512ai = 0;
        this.f19513aj = false;
        this.f19503a = context;
        m20758g();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m20758g() {
        if (this.f19516d <= 0) {
            this.f19492M = false;
            return;
        }
        this.f19492M = true;
        this.f19502W = Util.m24202a(getContext(), R.dimen.level_panel_text_shadow_radius, Util.f22962a);
        this.f19506ac = getContext().getResources().getColor(R.color.color_black_with_20_percent_transparency);
        this.f19499T = new Handler(Looper.getMainLooper());
        Resources resources = this.f19503a.getResources();
        this.f19529u = resources.getDimensionPixelSize(R.dimen.blur_menu_seekbar_stroke_line_width);
        this.f19530v = resources.getDimensionPixelSize(R.dimen.blur_menu_seekbar_stroke_line_width);
        this.f19504aa = resources.getDimension(R.dimen.blur_default_index_radus);
        this.f19505ab = resources.getDimension(R.dimen.blur_default_circle_top_margin);
        if (0.0f == getRotation()) {
            this.f19528t = resources.getDimensionPixelSize(R.dimen.blur_menu_seekbar_pannel_height);
        } else {
            this.f19528t = resources.getDimensionPixelOffset(R.dimen.vertical_blur_menu_seekbar_pannel_height);
        }
        this.f19517e = resources.getDimensionPixelSize(R.dimen.blur_menu_seekbar_line_margin);
        this.f19526r = resources.getDimensionPixelSize(R.dimen.blur_menu_seekbar_line_height);
        this.f19520h = resources.getDimensionPixelSize(R.dimen.blur_menu_seekbar_center_line_height);
        int OplusGLSurfaceView_13 = this.f19517e;
        this.f19482C = this.f19486G * OplusGLSurfaceView_13;
        this.f19483D = OplusGLSurfaceView_13 * 1.5f;
        this.f19533y = 0.0f == getRotation() ? resources.getDimensionPixelSize(R.dimen.blur_menu_seekbar_padding_bottom) : resources.getDimensionPixelSize(R.dimen.vertical_blur_menu_seekbar_margin_left);
        f19479l = this.f19503a.getColor(R.color.camera_white);
        this.f19514b = Util.m24164A(this.f19503a);
        f19478k = this.f19503a.getColor(R.color.blur_menu_seek_bar_line_color);
        this.f19507ad = resources.getDimensionPixelSize(R.dimen.blur_menu_seekbar_line_height_offset0);
        this.f19508ae = resources.getDimensionPixelSize(R.dimen.blur_menu_seekbar_line_height_offset1);
        this.f19509af = resources.getDimensionPixelSize(R.dimen.blur_menu_seekbar_line_height_offset2);
        this.f19510ag = resources.getDimensionPixelSize(R.dimen.blur_menu_seekbar_line_height_offset3);
        this.f19511ah = resources.getDimensionPixelSize(R.dimen.blur_menu_seekbar_line_height_offset4);
        mo17413a();
        this.f19527s = this.f19519g.length;
        setLayerType(1, null);
        this.f19494O = new Paint();
        this.f19494O.setAntiAlias(true);
        this.f19494O.setMaskFilter(new BlurMaskFilter(this.f19502W, BlurMaskFilter.Blur.OUTER));
        this.f19494O.setStyle(Paint.Style.FILL);
        this.f19494O.setStrokeWidth(this.f19529u);
        this.f19494O.setColor(this.f19506ac);
        this.f19493N = new Paint();
        this.f19493N.setAntiAlias(true);
        this.f19493N.setColor(f19479l);
        this.f19493N.setStyle(Paint.Style.FILL);
        this.f19493N.setStrokeWidth(this.f19530v);
        this.f19495P = new Paint();
        this.f19495P.setAntiAlias(true);
        this.f19495P.setColor(getResources().getColor(R.color.camera_white));
        this.f19495P.setShadowLayer(this.f19502W, 0.0f, 0.0f, this.f19506ac);
        this.f19495P.setStyle(Paint.Style.FILL);
        this.f19532x = ViewConfiguration.getMaximumFlingVelocity();
        int i2 = this.f19516d;
        this.f19531w = i2 % 2 == 0 ? (i2 / 2) - 1 : i2 / 2;
        if (this.f19531w < 0) {
            this.f19531w = 0;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo17413a() {
        this.f19519g = new int[]{this.f19507ad, this.f19508ae, this.f19509af, this.f19510ag, this.f19511ah, this.f19512ai};
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m20760h() {
        this.f19487H = new ValueAnimator();
        this.f19487H.setDuration(350L);
        this.f19487H.setInterpolator(f19476i);
        this.f19487H.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BlurMenuSeekBar.this.f19484E = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BlurMenuSeekBar blurMenuSeekBar = BlurMenuSeekBar.this;
                blurMenuSeekBar.f19485F = (blurMenuSeekBar.f19484E / BlurMenuSeekBar.this.f19482C) * BlurMenuSeekBar.this.f19483D;
                BlurMenuSeekBar.this.invalidate();
            }
        });
        this.f19488I = new AnimatorSet();
        this.f19488I.play(this.f19487H);
        this.f19488I.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.2
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
                BlurMenuSeekBar.this.m20764k();
            }
        });
    }

    public void setCurrentIndex(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f19516d) {
            return;
        }
        this.f19515c = OplusGLSurfaceView_13;
        InterfaceC3274d interfaceC3274d = this.f19496Q;
        if (interfaceC3274d != null) {
            interfaceC3274d.mo17423a(this.f19515c);
        }
    }

    public void setLevelNum(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("BlurMenuSeekBar", "setLevelNum, levelNum: " + OplusGLSurfaceView_13);
        this.f19516d = OplusGLSurfaceView_13;
        if (this.f19492M) {
            int i2 = this.f19516d;
            this.f19531w = i2 % 2 == 0 ? (i2 / 2) - 1 : i2 / 2;
        } else {
            m20758g();
        }
    }

    public void setDefaultDotPosition(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("BlurMenuSeekBar", "setDefaultDotPosition, dotPosition: " + OplusGLSurfaceView_13);
        this.f19521m = OplusGLSurfaceView_13;
    }

    public void setScaleBarValueChangeListener(InterfaceC3274d interfaceC3274d) {
        this.f19496Q = interfaceC3274d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m20769e() {
        this.f19500U = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d5 A[SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r21) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.onDraw(android.graphics.Canvas):void");
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m20770f() {
        return this.f19521m != 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20749a(Canvas canvas, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, Paint paint) {
        if (this.f19500U) {
            canvas.drawLine(COUIBaseListPopupWindow_12, f2, f3, f4, this.f19494O);
        }
        canvas.drawLine(COUIBaseListPopupWindow_12, f2, f3, f4, paint);
    }

    public void setRemainder(int OplusGLSurfaceView_13) {
        this.f19534z = OplusGLSurfaceView_13;
    }

    private int getRemainder() {
        return this.f19534z;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20768c(boolean z) throws Resources.NotFoundException {
        m20765a(z, null, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20765a(boolean z, final Runnable runnable, final Runnable runnable2) throws Resources.NotFoundException {
        if (this.f19519g == null) {
            return;
        }
        this.f19513aj = z;
        float[] fArr = new float[2];
        fArr[0] = z ? 0.0f : 1.0f;
        fArr[1] = z ? 1.0f : 0.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(f19476i);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.levelcontrol.-$$Lambda$BlurMenuSeekBar$GMW0HA0VquiQGyuQwef8UQZYKVM
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m20752b(valueAnimator);
            }
        });
        int color = getResources().getColor(R.color.color_white_with_0_percent_transparency);
        int iM24164A = Util.m24164A(this.f19503a);
        int[] iArr = new int[2];
        iArr[0] = z ? color : iM24164A;
        if (z) {
            color = iM24164A;
        }
        iArr[1] = color;
        ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(iArr);
        valueAnimatorOfArgb.setInterpolator(f19477j);
        valueAnimatorOfArgb.setDuration(500L);
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.levelcontrol.-$$Lambda$BlurMenuSeekBar$d3YQmsW6XCpsFb7gm72TtG88zbg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m20748a(valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfArgb);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Runnable runnable3 = runnable;
                if (runnable3 != null) {
                    runnable3.run();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Runnable runnable3 = runnable2;
                if (runnable3 != null) {
                    runnable3.run();
                }
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m20752b(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int[] iArr = this.f19519g;
        iArr[0] = (int) (this.f19507ad * fFloatValue);
        iArr[1] = (int) (this.f19508ae * fFloatValue);
        iArr[2] = (int) (this.f19509af * fFloatValue);
        iArr[3] = (int) (this.f19510ag * fFloatValue);
        iArr[4] = (int) (this.f19511ah * fFloatValue);
        this.f19520h = this.f19526r + iArr[0];
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m20748a(ValueAnimator valueAnimator) {
        this.f19514b = ((Integer) valueAnimator.getAnimatedValue()).intValue();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            float xVelocity = 0.0f;
            if (action == 1) {
                mo17420c();
                if (this.f19484E != 0.0f) {
                    m20762i();
                } else {
                    VelocityTracker velocityTracker = this.f19497R;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(motionEvent);
                        this.f19497R.computeCurrentVelocity(1000, this.f19532x);
                        xVelocity = this.f19497R.getXVelocity();
                        this.f19497R.clear();
                    }
                    if (Math.abs(xVelocity) >= 1000.0f) {
                        if (1 == getLayoutDirection()) {
                            xVelocity = -xVelocity;
                        }
                        this.f19498S = new RunnableC3272b(xVelocity);
                        this.f19499T.post(this.f19498S);
                    } else {
                        m20763j();
                        InterfaceC3274d interfaceC3274d = this.f19496Q;
                        if (interfaceC3274d != null) {
                            interfaceC3274d.mo17425b();
                        }
                    }
                }
            } else if (action == 2) {
                float x = motionEvent.getX() - this.f19480A;
                float y = motionEvent.getY() - this.f19481B;
                this.f19480A = motionEvent.getX();
                this.f19481B = motionEvent.getY();
                if (Math.abs(x) >= Math.abs(y)) {
                    VelocityTracker velocityTracker2 = this.f19497R;
                    if (velocityTracker2 != null) {
                        velocityTracker2.addMovement(motionEvent);
                    }
                    if (1 == getLayoutDirection()) {
                        m20747a(-x);
                    } else {
                        m20747a(x);
                    }
                }
            } else if (action == 3) {
                if (this.f19484E != 0.0f) {
                    m20762i();
                } else {
                    VelocityTracker velocityTracker3 = this.f19497R;
                    if (velocityTracker3 != null) {
                        velocityTracker3.recycle();
                        this.f19497R = null;
                    }
                    m20763j();
                }
            }
        } else {
            this.f19480A = motionEvent.getX();
            this.f19481B = motionEvent.getY();
            if (motionEvent.getY() < getHeight() * 0.2f) {
                return false;
            }
            AnimatorSet animatorSet = this.f19488I;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.f19488I.cancel();
            }
            this.f19497R = VelocityTracker.obtain();
            RunnableC3272b runnableC3272b = this.f19498S;
            if (runnableC3272b != null) {
                runnableC3272b.m20771a();
                this.f19498S = null;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_13 */
    public void m20762i() {
        if (this.f19487H == null || this.f19488I == null) {
            m20760h();
        }
        if (this.f19487H.isRunning()) {
            this.f19487H.cancel();
        }
        if (this.f19488I.isRunning()) {
            this.f19488I.cancel();
        }
        this.f19487H.setFloatValues(this.f19484E, 0.0f);
        this.f19488I.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public void m20763j() {
        int OplusGLSurfaceView_13 = (int) ((this.f19522n - this.f19523o) % this.f19517e);
        if (OplusGLSurfaceView_13 != 0) {
            int iAbs = Math.abs(OplusGLSurfaceView_13);
            int i2 = this.f19517e;
            if (iAbs < i2 / 2) {
                this.f19522n -= OplusGLSurfaceView_13;
            } else if (OplusGLSurfaceView_13 > 0) {
                this.f19522n = (this.f19522n - OplusGLSurfaceView_13) + i2;
            } else {
                this.f19522n = (this.f19522n - OplusGLSurfaceView_13) - i2;
            }
            m20764k();
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20747a(float COUIBaseListPopupWindow_12) {
        if (!this.f19492M) {
            CameraLog.m12967f("BlurMenuSeekBar", "onMove return, is not valid");
            return;
        }
        mo17418b();
        if (COUIBaseListPopupWindow_12 == 0.0f) {
            return;
        }
        int OplusGLSurfaceView_13 = 0.0f < COUIBaseListPopupWindow_12 ? 1 : -1;
        if (this.f19489J != OplusGLSurfaceView_13) {
            float f2 = this.f19484E;
            if (0.0f != f2) {
                if (OplusGLSurfaceView_13 == 1) {
                    this.f19484E = f2 + COUIBaseListPopupWindow_12 < 0.0f ? f2 + COUIBaseListPopupWindow_12 : 0.0f;
                } else {
                    this.f19484E = f2 + COUIBaseListPopupWindow_12 > 0.0f ? f2 + COUIBaseListPopupWindow_12 : 0.0f;
                }
                this.f19485F = (this.f19484E / this.f19482C) * this.f19483D;
                invalidate();
                return;
            }
        }
        this.f19489J = OplusGLSurfaceView_13;
        this.f19522n += (int) COUIBaseListPopupWindow_12;
        float f3 = this.f19522n;
        int i2 = this.f19525q;
        if (f3 >= i2) {
            float f4 = this.f19482C;
            if (f3 <= i2 + f4) {
                float f5 = this.f19484E;
                if (f5 == 0.0f) {
                    this.f19484E = (f3 - i2) * 0.3f;
                } else {
                    float f6 = COUIBaseListPopupWindow_12 * 0.3f;
                    if (f5 + f6 < f4) {
                        f4 = f5 + f6;
                    }
                    this.f19484E = f4;
                }
            } else {
                this.f19484E = 0.0f;
            }
            this.f19522n = this.f19525q;
        } else {
            int i3 = this.f19517e;
            int i4 = this.f19516d;
            if (((i4 - 1) * i3) + f3 <= i2) {
                float f7 = ((i4 - 1) * i3) + f3;
                float f8 = this.f19482C;
                if (f7 >= i2 - f8) {
                    float f9 = this.f19484E;
                    if (f9 == 0.0f) {
                        this.f19484E = ((f3 + (i3 * (i4 - 1))) - i2) * 0.3f;
                    } else {
                        float f10 = COUIBaseListPopupWindow_12 * 0.3f;
                        this.f19484E = f9 + f10 <= (-f8) ? -f8 : f10 + f9;
                    }
                } else {
                    this.f19484E = 0.0f;
                }
                this.f19522n = this.f19525q - (this.f19517e * (this.f19516d - 1));
            }
        }
        this.f19485F = (this.f19484E / this.f19482C) * this.f19483D;
        m20764k();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_5 */
    public void m20764k() {
        if (this.f19516d != 0) {
            float fAbs = Math.abs(this.f19525q - this.f19522n);
            int OplusGLSurfaceView_13 = (int) (((fAbs + (r1 / 2)) / this.f19517e) % this.f19516d);
            if (this.f19496Q != null && OplusGLSurfaceView_13 != this.f19515c) {
                BlurMenu.PlatformImplementations.kt_3 aVar = this.f19501V;
                HintManager c3130aMo20022n = aVar != null ? aVar.mo20022n() : null;
                if (c3130aMo20022n != null) {
                    c3130aMo20022n.m18488a(true);
                    c3130aMo20022n.m18492b(CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX);
                }
                this.f19496Q.mo17422a();
                this.f19496Q.mo17423a(OplusGLSurfaceView_13);
                if (c3130aMo20022n != null) {
                    c3130aMo20022n.m18488a(false);
                    c3130aMo20022n.m18492b((String) null);
                }
            }
            setCurrentIndex(OplusGLSurfaceView_13);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        if (this.f19524p > 0 || !this.f19492M) {
            return;
        }
        CameraLog.m12954a("BlurMenuSeekBar", "onMeasure, widthMeasureSpec: " + OplusGLSurfaceView_13 + ", heightMeasureSpec: " + i2);
        this.f19524p = getMeasuredWidth();
        int i3 = this.f19524p / 2;
        int i4 = this.f19529u;
        this.f19525q = i3 - (i4 / 2);
        this.f19523o = (float) ((i3 % this.f19517e) - (i4 / 2));
        this.f19491L = true;
        if (!this.f19490K) {
            this.f19522n = 0.0f;
        }
        int i5 = this.f19515c;
        if (i5 >= 0) {
            m20767c(i5);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20766b(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("BlurMenuSeekBar", "scrollTo, index: " + OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f19516d) {
            return;
        }
        this.f19515c = OplusGLSurfaceView_13;
        mo17414a(OplusGLSurfaceView_13);
        this.f19522n = this.f19525q - (this.f19517e * OplusGLSurfaceView_13);
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20767c(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.f19516d) {
            return;
        }
        this.f19515c = OplusGLSurfaceView_13;
        if (this.f19491L) {
            this.f19522n = this.f19525q - (this.f19517e * OplusGLSurfaceView_13);
            this.f19490K = true;
            invalidate();
        }
    }

    public void setBlurListener(BlurMenu.PlatformImplementations.kt_3 aVar) {
        this.f19501V = aVar;
    }

    /* renamed from: com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar$PlatformImplementations.kt_3 */
    private static class C3271a extends PathInterpolator {
        C3271a() {
            super(0.0f, 0.0f, 0.58f, 1.0f);
        }
    }

    /* renamed from: com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar$IntrinsicsJvm.kt_4 */
    private class RunnableC3272b implements Runnable {

        /* renamed from: IntrinsicsJvm.kt_5 */
        private float f19543d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private float f19544e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private float f19545f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private float f19546g;

        /* renamed from: OplusGLSurfaceView_15 */
        private long f19549j;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f19541b = 400;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f19542c = 16;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private float f19547h = 0.15f;

        /* renamed from: OplusGLSurfaceView_5 */
        private Interpolator f19550k = new C3271a();

        /* renamed from: OplusGLSurfaceView_13 */
        private boolean f19548i = false;

        public RunnableC3272b(float COUIBaseListPopupWindow_12) {
            if (BlurMenuSeekBar.this.f19496Q != null) {
                BlurMenuSeekBar.this.f19496Q.mo17424a(!this.f19548i);
            }
            this.f19546g = 0.0f;
            int OplusGLSurfaceView_13 = this.f19541b;
            this.f19543d = 1.0f / OplusGLSurfaceView_13;
            this.f19544e = COUIBaseListPopupWindow_12;
            this.f19545f = ((OplusGLSurfaceView_13 * this.f19544e) / 1000.0f) * this.f19547h;
            this.f19549j = AnimationUtils.currentAnimationTimeMillis();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m20771a() {
            this.f19548i = true;
            if (BlurMenuSeekBar.this.f19496Q != null) {
                BlurMenuSeekBar.this.f19496Q.mo17424a(false);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19548i) {
                return;
            }
            int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f19549j);
            float interpolation = this.f19550k.getInterpolation(iCurrentAnimationTimeMillis * this.f19543d);
            float COUIBaseListPopupWindow_12 = (interpolation - this.f19546g) * this.f19545f;
            this.f19546g = interpolation;
            if (iCurrentAnimationTimeMillis < this.f19541b) {
                BlurMenuSeekBar.this.m20747a(COUIBaseListPopupWindow_12);
                BlurMenuSeekBar.this.f19499T.postDelayed(this, this.f19542c);
            } else {
                this.f19546g = 0.0f;
                BlurMenuSeekBar.this.m20763j();
                this.f19548i = true;
                if (BlurMenuSeekBar.this.f19496Q != null) {
                    BlurMenuSeekBar.this.f19496Q.mo17424a(true ^ this.f19548i);
                }
            }
            if (0.0f != BlurMenuSeekBar.this.f19484E) {
                BlurMenuSeekBar.this.m20762i();
            }
        }
    }
}
