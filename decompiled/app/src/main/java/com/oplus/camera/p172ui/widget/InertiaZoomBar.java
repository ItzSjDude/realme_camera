package com.oplus.camera.p172ui.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p137b.SimpleAnimatorListener;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class InertiaZoomBar extends View {

    /* renamed from: A */
    private Paint f22538A;

    /* renamed from: B */
    private String f22539B;

    /* renamed from: C */
    private Resources f22540C;

    /* renamed from: D */
    private ValueAnimator f22541D;

    /* renamed from: E */
    private ValueAnimator f22542E;

    /* renamed from: F */
    private ValueAnimator f22543F;

    /* renamed from: G */
    private ValueAnimator f22544G;

    /* renamed from: H */
    private ValueAnimator f22545H;

    /* renamed from: I */
    private ValueAnimator f22546I;

    /* renamed from: J */
    private ValueAnimator f22547J;

    /* renamed from: K */
    private ValueAnimator f22548K;

    /* renamed from: L */
    private PathInterpolator f22549L;

    /* renamed from: M */
    private PathInterpolator f22550M;

    /* renamed from: N */
    private PathInterpolator f22551N;

    /* renamed from: O */
    private PathInterpolator f22552O;

    /* renamed from: P */
    private PathInterpolator f22553P;

    /* renamed from: Q */
    private PathInterpolator f22554Q;

    /* renamed from: R */
    private PathInterpolator f22555R;

    /* renamed from: S */
    private PathInterpolator f22556S;

    /* renamed from: T */
    private InterfaceC3495a f22557T;

    /* renamed from: U */
    private float f22558U;

    /* renamed from: V */
    private int f22559V;

    /* renamed from: W */
    private Paint f22560W;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f22561a;

    /* renamed from: aa */
    private Paint f22562aa;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f22563b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f22564c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f22565d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f22566e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f22567f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f22568g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f22569h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f22570i;

    /* renamed from: OplusGLSurfaceView_15 */
    private long f22571j;

    /* renamed from: OplusGLSurfaceView_5 */
    private long f22572k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f22573l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f22574m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f22575n;

    /* renamed from: o */
    private float f22576o;

    /* renamed from: p */
    private float f22577p;

    /* renamed from: q */
    private boolean f22578q;

    /* renamed from: r */
    private boolean f22579r;

    /* renamed from: s */
    private boolean f22580s;

    /* renamed from: t */
    private boolean f22581t;

    /* renamed from: u */
    private Context f22582u;

    /* renamed from: v */
    private Paint f22583v;

    /* renamed from: w */
    private Paint f22584w;

    /* renamed from: x */
    private Path f22585x;

    /* renamed from: y */
    private Paint f22586y;

    /* renamed from: z */
    private TextPaint f22587z;

    /* renamed from: com.oplus.camera.ui.widget.InertiaZoomBar$PlatformImplementations.kt_3 */
    public interface InterfaceC3495a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo11566a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo11567a(float COUIBaseListPopupWindow_12);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo11568b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo11569c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo11570d();

        /* renamed from: COUIBaseListPopupWindow_8 */
        void mo11571e();

        /* renamed from: COUIBaseListPopupWindow_12 */
        void mo11572f();
    }

    public InertiaZoomBar(Context context) {
        this(context, null);
    }

    public InertiaZoomBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InertiaZoomBar(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public InertiaZoomBar(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet);
        this.f22561a = 0;
        this.f22563b = 0;
        this.f22564c = 0;
        this.f22565d = 0;
        this.f22566e = 0;
        this.f22567f = 0;
        this.f22568g = 0;
        this.f22569h = 0;
        this.f22570i = 0;
        this.f22571j = 0L;
        this.f22572k = 0L;
        this.f22573l = 0.0f;
        this.f22574m = 0.0f;
        this.f22575n = 0.0f;
        this.f22576o = -1.0f;
        this.f22577p = 0.0f;
        this.f22578q = false;
        this.f22579r = false;
        this.f22580s = false;
        this.f22581t = false;
        this.f22582u = null;
        this.f22583v = null;
        this.f22584w = null;
        this.f22585x = new Path();
        this.f22586y = null;
        this.f22587z = null;
        this.f22538A = null;
        this.f22539B = null;
        this.f22540C = null;
        this.f22541D = null;
        this.f22542E = null;
        this.f22543F = null;
        this.f22544G = null;
        this.f22545H = null;
        this.f22546I = null;
        this.f22547J = null;
        this.f22548K = null;
        this.f22549L = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f22550M = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f22551N = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f22552O = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f22553P = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f22554Q = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f22555R = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f22556S = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f22557T = null;
        this.f22582u = context;
        this.f22540C = this.f22582u.getResources();
        this.f22561a = this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_release_size);
        this.f22566e = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f22563b = this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_stroke_width);
        this.f22564c = this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_stroke_width);
        this.f22565d = this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_stroke_width);
        this.f22558U = Util.m24202a(getContext(), R.dimen.level_panel_text_shadow_radius, Util.f22962a);
        this.f22559V = getContext().getResources().getColor(R.color.color_black_with_20_percent_transparency);
        setPadding(this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_padding_horizontal), 0, this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_padding_horizontal), 0);
        m23951h();
        m23938a(this.f22540C);
        m23952i();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m23951h() {
        m23960a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23938a(Resources resources) {
        this.f22560W = new Paint();
        this.f22560W.setMaskFilter(new BlurMaskFilter(this.f22558U, BlurMaskFilter.Blur.OUTER));
        this.f22560W.setStyle(Paint.Style.FILL);
        this.f22560W.setStrokeWidth(this.f22564c);
        this.f22560W.setColor(this.f22559V);
        this.f22562aa = new Paint();
        this.f22562aa.setMaskFilter(new BlurMaskFilter(this.f22558U, BlurMaskFilter.Blur.OUTER));
        this.f22562aa.setStyle(Paint.Style.FILL);
        this.f22562aa.setAntiAlias(true);
        this.f22562aa.setColor(this.f22559V);
        this.f22583v = new Paint();
        this.f22583v.setStyle(Paint.Style.FILL);
        this.f22583v.setAntiAlias(true);
        this.f22583v.setColor(resources.getColor(R.color.inertia_zoom_bar_stroke_color));
        this.f22584w = new Paint();
        this.f22584w.setStyle(Paint.Style.STROKE);
        this.f22584w.setAntiAlias(true);
        this.f22584w.setStrokeWidth(this.f22564c);
        this.f22584w.setColor(resources.getColor(R.color.inertia_zoom_bar_heighlight_stroke_color));
        this.f22587z = new TextPaint();
        this.f22587z.setShadowLayer(this.f22558U, 0.0f, 0.0f, this.f22559V);
        this.f22587z.setAntiAlias(true);
        this.f22587z.setTypeface(Util.m24411c(true));
        this.f22587z.setTextSize(resources.getDimensionPixelSize(R.dimen.inertial_zoombar_text_size));
        this.f22587z.setColor(resources.getColor(R.color.inertia_zoom_text_color));
        this.f22587z.setTextAlign(Paint.Align.CENTER);
        this.f22586y = new Paint();
        this.f22586y.setShadowLayer(this.f22558U, 0.0f, 0.0f, this.f22559V);
        this.f22586y.setColor(resources.getColor(R.color.inertia_zoom_thumb_color));
        this.f22586y.setAntiAlias(true);
        this.f22586y.setStyle(Paint.Style.STROKE);
        this.f22586y.setStrokeWidth(this.f22565d);
        this.f22538A = new Paint();
        this.f22538A.setAlpha(255);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m23952i() {
        this.f22541D = ValueAnimator.ofFloat(1.0f, 0.5f);
        this.f22541D.setDuration(180L);
        this.f22541D.setInterpolator(this.f22549L);
        this.f22541D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                InertiaZoomBar.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.f22541D.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.10
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                InertiaZoomBar.this.setAlpha(0.5f);
            }
        });
        this.f22542E = ValueAnimator.ofFloat(0.5f, 1.0f);
        this.f22542E.setDuration(180L);
        this.f22542E.setInterpolator(this.f22550M);
        this.f22542E.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                InertiaZoomBar.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.f22542E.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.12
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                InertiaZoomBar.this.setAlpha(1.0f);
            }
        });
        this.f22543F = ValueAnimator.ofInt(0, 255);
        this.f22543F.setDuration(183L);
        this.f22543F.setInterpolator(this.f22551N);
        this.f22543F.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                InertiaZoomBar.this.f22538A.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                InertiaZoomBar.this.invalidate();
            }
        });
        this.f22543F.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.14
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                InertiaZoomBar.this.f22538A.setAlpha(255);
                InertiaZoomBar.this.invalidate();
            }
        });
        this.f22544G = ValueAnimator.ofInt(255, 0);
        this.f22544G.setDuration(183L);
        this.f22544G.setInterpolator(this.f22552O);
        this.f22544G.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                InertiaZoomBar.this.f22538A.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                InertiaZoomBar.this.invalidate();
            }
        });
        this.f22544G.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.16
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                InertiaZoomBar.this.f22538A.setAlpha(0);
                InertiaZoomBar.this.invalidate();
            }
        });
        this.f22545H = ValueAnimator.ofInt(this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_stroke_width), this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_stroke_width_dragging));
        this.f22545H.setDuration(300L);
        this.f22545H.setInterpolator(this.f22553P);
        this.f22545H.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                InertiaZoomBar.this.setLineStrokeWidth(iIntValue);
                InertiaZoomBar.this.setHighLineStrokeWidth(iIntValue);
                if (1 == InertiaZoomBar.this.f22570i) {
                    InertiaZoomBar.this.setThumbStrokeWidth(iIntValue);
                } else {
                    InertiaZoomBar.this.setThumbStrokeWidth(iIntValue / 2);
                }
                InertiaZoomBar.this.invalidate();
            }
        });
        this.f22545H.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.2
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) throws Resources.NotFoundException {
                int dimensionPixelSize = InertiaZoomBar.this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_stroke_width_dragging);
                InertiaZoomBar.this.setLineStrokeWidth(dimensionPixelSize);
                InertiaZoomBar.this.setHighLineStrokeWidth(dimensionPixelSize);
                if (1 == InertiaZoomBar.this.f22570i) {
                    InertiaZoomBar.this.setThumbStrokeWidth(dimensionPixelSize);
                } else {
                    InertiaZoomBar.this.setThumbStrokeWidth(dimensionPixelSize / 2);
                }
                InertiaZoomBar.this.invalidate();
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) throws Resources.NotFoundException {
                int dimensionPixelSize = InertiaZoomBar.this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_stroke_width_dragging);
                InertiaZoomBar.this.setLineStrokeWidth(dimensionPixelSize);
                InertiaZoomBar.this.setHighLineStrokeWidth(dimensionPixelSize);
                InertiaZoomBar.this.setThumbStrokeWidth(dimensionPixelSize / 2);
                InertiaZoomBar.this.invalidate();
            }
        });
        this.f22546I = ValueAnimator.ofInt(this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_stroke_width_dragging), this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_stroke_width));
        this.f22546I.setDuration(300L);
        this.f22546I.setInterpolator(this.f22554Q);
        this.f22546I.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                InertiaZoomBar.this.setLineStrokeWidth(iIntValue);
                InertiaZoomBar.this.setHighLineStrokeWidth(iIntValue);
                InertiaZoomBar.this.setThumbStrokeWidth(iIntValue / 2);
                InertiaZoomBar.this.invalidate();
            }
        });
        this.f22546I.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.4
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) throws Resources.NotFoundException {
                int dimensionPixelSize = InertiaZoomBar.this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_stroke_width);
                InertiaZoomBar.this.setLineStrokeWidth(dimensionPixelSize);
                InertiaZoomBar.this.setHighLineStrokeWidth(dimensionPixelSize);
                InertiaZoomBar.this.setThumbStrokeWidth(dimensionPixelSize / 2);
                InertiaZoomBar.this.invalidate();
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) throws Resources.NotFoundException {
                int dimensionPixelSize = InertiaZoomBar.this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_stroke_width_dragging);
                InertiaZoomBar.this.setLineStrokeWidth(dimensionPixelSize);
                InertiaZoomBar.this.setHighLineStrokeWidth(dimensionPixelSize);
                InertiaZoomBar.this.setThumbStrokeWidth(InertiaZoomBar.this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_stroke_width) / 2);
                InertiaZoomBar.this.invalidate();
            }
        });
        this.f22547J = ValueAnimator.ofInt(this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_release_size), this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_dragging_size));
        this.f22547J.setDuration(300L);
        this.f22547J.setInterpolator(this.f22555R);
        this.f22547J.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                InertiaZoomBar.this.setThumbWidth(((Integer) valueAnimator.getAnimatedValue()).intValue());
                InertiaZoomBar.this.invalidate();
            }
        });
        this.f22547J.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.6
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                InertiaZoomBar inertiaZoomBar = InertiaZoomBar.this;
                inertiaZoomBar.setThumbWidth(inertiaZoomBar.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_dragging_size));
                InertiaZoomBar.this.invalidate();
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                InertiaZoomBar inertiaZoomBar = InertiaZoomBar.this;
                inertiaZoomBar.setThumbWidth(inertiaZoomBar.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_dragging_size));
                InertiaZoomBar.this.invalidate();
            }
        });
        this.f22548K = ValueAnimator.ofInt(this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_dragging_size), this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_release_size));
        this.f22548K.setDuration(300L);
        this.f22548K.setInterpolator(this.f22556S);
        this.f22548K.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                InertiaZoomBar.this.setThumbWidth(((Integer) valueAnimator.getAnimatedValue()).intValue());
                InertiaZoomBar.this.invalidate();
            }
        });
        this.f22548K.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.8
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                InertiaZoomBar inertiaZoomBar = InertiaZoomBar.this;
                inertiaZoomBar.setThumbWidth(inertiaZoomBar.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_release_size));
                InertiaZoomBar.this.invalidate();
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                InertiaZoomBar inertiaZoomBar = InertiaZoomBar.this;
                inertiaZoomBar.setThumbWidth(inertiaZoomBar.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_release_size));
                InertiaZoomBar.this.invalidate();
            }
        });
    }

    public void setLineStrokeWidth(int OplusGLSurfaceView_13) {
        this.f22563b = OplusGLSurfaceView_13;
    }

    public void setHighLineStrokeWidth(int OplusGLSurfaceView_13) {
        this.f22564c = OplusGLSurfaceView_13;
    }

    public void setThumbStrokeWidth(int OplusGLSurfaceView_13) {
        this.f22565d = OplusGLSurfaceView_13;
    }

    public void setThumbWidth(int OplusGLSurfaceView_13) {
        this.f22561a = OplusGLSurfaceView_13;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (this.f22576o < 0.0f) {
            setProgress(50.0f);
        }
        this.f22584w.setStrokeWidth(this.f22564c);
        this.f22586y.setStrokeWidth(this.f22565d);
        m23947c(canvas);
        m23943b(canvas);
        m23939a(canvas);
        m23949d(canvas);
        canvas.restore();
    }

    public void setProgress(float COUIBaseListPopupWindow_12) {
        if (getHeight() == 0) {
            return;
        }
        this.f22577p = COUIBaseListPopupWindow_12;
        this.f22576o = m23934a(COUIBaseListPopupWindow_12);
        InterfaceC3495a interfaceC3495a = this.f22557T;
        if (interfaceC3495a != null) {
            interfaceC3495a.mo11567a(this.f22577p);
        }
        m23953j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public float m23934a(float COUIBaseListPopupWindow_12) {
        return (this.f22561a / 2) + getPaddingLeft() + ((COUIBaseListPopupWindow_12 / 100.0f) * (((getWidth() - getPaddingLeft()) - getPaddingRight()) - this.f22561a));
    }

    public void setThumbText(String str) {
        String str2 = this.f22539B;
        if (str2 == null || !str2.equals(str)) {
            this.f22539B = str;
            invalidate();
        }
    }

    public void setIsHighlight(boolean z) {
        this.f22580s = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23939a(Canvas canvas) {
        canvas.drawCircle(this.f22576o, getHeight() / 2.0f, (this.f22561a - this.f22565d) / 2.0f, this.f22586y);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m23943b(Canvas canvas) {
        float COUIBaseListPopupWindow_12 = this.f22576o;
        int OplusGLSurfaceView_13 = this.f22561a;
        float f2 = COUIBaseListPopupWindow_12 - (OplusGLSurfaceView_13 / 2.0f);
        float f3 = COUIBaseListPopupWindow_12 + (OplusGLSurfaceView_13 / 2.0f);
        if (Float.compare(f2, getPaddingLeft()) > 0) {
            float paddingLeft = getPaddingLeft();
            int height = getHeight();
            RectF rectF = new RectF(paddingLeft, (height - r6) / 2.0f, f2 + (this.f22563b / 2.0f), (getHeight() + this.f22563b) / 2.0f);
            int i2 = this.f22563b;
            canvas.drawRoundRect(rectF, i2 / 2.0f, i2 / 2.0f, this.f22562aa);
            int i3 = this.f22563b;
            canvas.drawRoundRect(rectF, i3 / 2.0f, i3 / 2.0f, this.f22583v);
        }
        if (Float.compare(f3, getWidth() - getPaddingRight()) < 0) {
            RectF rectF2 = new RectF(f3 - (this.f22563b / 2.0f), (getHeight() - this.f22563b) / 2.0f, getWidth() - getPaddingRight(), (getHeight() + this.f22563b) / 2.0f);
            int i4 = this.f22563b;
            canvas.drawRoundRect(rectF2, i4 / 2.0f, i4 / 2.0f, this.f22562aa);
            int i5 = this.f22563b;
            canvas.drawRoundRect(rectF2, i5 / 2.0f, i5 / 2.0f, this.f22583v);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m23947c(Canvas canvas) {
        this.f22585x.reset();
        this.f22585x.moveTo(getWidth() / 2.0f, getHeight() / 2.0f);
        float COUIBaseListPopupWindow_12 = this.f22576o;
        int width = getWidth();
        int OplusGLSurfaceView_13 = this.f22561a;
        if (COUIBaseListPopupWindow_12 > (width + OplusGLSurfaceView_13) / 2.0f) {
            this.f22585x.lineTo(this.f22576o - (OplusGLSurfaceView_13 / 2.0f), getHeight() / 2.0f);
        }
        float f2 = this.f22576o;
        int width2 = getWidth();
        int i2 = this.f22561a;
        if (f2 < (width2 - i2) / 2.0f) {
            this.f22585x.lineTo(this.f22576o + (i2 / 2.0f), getHeight() / 2.0f);
        }
        canvas.drawPath(this.f22585x, this.f22560W);
        canvas.drawPath(this.f22585x, this.f22584w);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m23949d(Canvas canvas) {
        canvas.drawBitmap(getTextBitmap(), this.f22576o - (this.f22561a / 2.0f), (getHeight() - this.f22561a) / 2.0f, this.f22538A);
    }

    private Bitmap getTextBitmap() {
        int OplusGLSurfaceView_13;
        int i2 = this.f22561a;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.save();
        if (this.f22567f != this.f22569h) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.f22572k) {
                int i3 = (int) (jCurrentAnimationTimeMillis - this.f22571j);
                int i4 = this.f22568g;
                if (!this.f22579r) {
                    i3 = -i3;
                }
                int i5 = i4 + ((i3 * 270) / 1000);
                if (i5 >= 0) {
                    OplusGLSurfaceView_13 = i5 % 360;
                } else {
                    OplusGLSurfaceView_13 = (i5 % 360) + 360;
                }
                this.f22567f = OplusGLSurfaceView_13;
                invalidate();
            } else {
                this.f22567f = this.f22569h;
            }
        }
        float COUIBaseListPopupWindow_12 = -this.f22567f;
        int i6 = this.f22561a;
        canvas.rotate(COUIBaseListPopupWindow_12, i6 / 2.0f, i6 / 2.0f);
        if (this.f22539B != null) {
            Paint.FontMetrics fontMetrics = this.f22587z.getFontMetrics();
            String str = this.f22539B;
            int i7 = this.f22561a;
            canvas.drawText(str, i7 / 2.0f, ((i7 / 2.0f) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f), this.f22587z);
        }
        canvas.restore();
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public void m23953j() {
        m23937a((this.f22561a / 2) + getPaddingLeft(), (getWidth() - (this.f22561a / 2)) - getPaddingRight());
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23937a(int OplusGLSurfaceView_13, int i2) {
        float COUIBaseListPopupWindow_12 = i2;
        if (this.f22576o > COUIBaseListPopupWindow_12) {
            this.f22576o = COUIBaseListPopupWindow_12;
        }
        float f2 = OplusGLSurfaceView_13;
        if (this.f22576o < f2) {
            this.f22576o = f2;
        }
    }

    public void setOnSeekBarListener(InterfaceC3495a interfaceC3495a) {
        this.f22557T = interfaceC3495a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23960a() {
        setProgress(50.0f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m23964b() {
        return this.f22578q;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23965c() {
        if (this.f22581t) {
            m23969e();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f22577p, 50.0f);
        PathInterpolator pathInterpolator = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.InertiaZoomBar.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                InertiaZoomBar.this.f22577p = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                InertiaZoomBar inertiaZoomBar = InertiaZoomBar.this;
                inertiaZoomBar.f22576o = inertiaZoomBar.m23934a(inertiaZoomBar.f22577p);
                InertiaZoomBar.this.m23953j();
            }
        });
        long jAbs = ((long) ((Math.abs(this.f22577p - 50.0f) / 50.0f) * 334.0f)) + 333;
        valueAnimatorOfFloat.setInterpolator(pathInterpolator);
        valueAnimatorOfFloat.setDuration(jAbs);
        valueAnimatorOfFloat.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23961a(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        if (!isShown()) {
            z = false;
        }
        if (OplusGLSurfaceView_13 >= 0) {
            i2 = OplusGLSurfaceView_13 % 360;
        } else {
            i2 = (OplusGLSurfaceView_13 % 360) + 360;
        }
        if (i2 == this.f22569h) {
            return;
        }
        this.f22569h = i2;
        if (z) {
            this.f22568g = this.f22567f;
            this.f22571j = AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f22569h - this.f22567f;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.f22579r = i3 >= 0;
            this.f22572k = this.f22571j + ((Math.abs(i3) * 1000) / 270);
        } else {
            this.f22567f = this.f22569h;
        }
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23962a(boolean z) {
        if (z) {
            if (this.f22543F.isRunning()) {
                this.f22543F.cancel();
            }
            this.f22543F.start();
        } else {
            this.f22538A.setAlpha(255);
            invalidate();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23963b(boolean z) {
        if (z) {
            if (this.f22544G.isRunning()) {
                this.f22544G.cancel();
            }
            this.f22544G.start();
        } else {
            this.f22538A.setAlpha(0);
            invalidate();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23967d() {
        this.f22581t = true;
        ValueAnimator valueAnimator = this.f22541D;
        if (valueAnimator == null || valueAnimator.isRunning()) {
            return;
        }
        this.f22541D.start();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m23969e() {
        this.f22581t = false;
        ValueAnimator valueAnimator = this.f22542E;
        if (valueAnimator == null || valueAnimator.isRunning()) {
            return;
        }
        this.f22542E.start();
    }

    public void setScreenMode(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("InertialZoomBar", "setScreenMode: " + OplusGLSurfaceView_13);
        this.f22570i = OplusGLSurfaceView_13;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f22573l = motionEvent.getX();
        } else if (action == 1) {
            if (this.f22578q) {
                m23944b(motionEvent);
                m23959p();
                setPressed(false);
            } else {
                m23954k();
                m23944b(motionEvent);
                m23959p();
            }
            invalidate();
        } else if (action != 2) {
            if (action == 3) {
                if (this.f22578q) {
                    m23959p();
                    setPressed(false);
                }
                invalidate();
            }
        } else {
            if (motionEvent.getPointerCount() >= 2) {
                return super.onTouchEvent(motionEvent);
            }
            if (this.f22578q) {
                m23944b(motionEvent);
            } else if (Math.abs(motionEvent.getX() - this.f22573l) > this.f22566e) {
                m23940a(motionEvent);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public float getProgress() {
        return this.f22577p;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23940a(MotionEvent motionEvent) {
        m23954k();
        m23944b(motionEvent);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m23954k() {
        this.f22578q = true;
        m23966c(true);
        m23970e(true);
        setIsHighlight(true);
        InterfaceC3495a interfaceC3495a = this.f22557T;
        if (interfaceC3495a != null) {
            interfaceC3495a.mo11571e();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23966c(boolean z) {
        if (m23958o()) {
            this.f22548K.cancel();
        }
        if (z) {
            if (m23957n() || this.f22580s) {
                return;
            }
            this.f22547J.start();
            return;
        }
        setThumbWidth(this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_dragging_size));
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23968d(boolean z) {
        if (m23957n()) {
            this.f22547J.cancel();
        }
        if (z) {
            if (m23958o() || !this.f22580s) {
                return;
            }
            this.f22548K.start();
            return;
        }
        setThumbWidth(this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_release_size));
        invalidate();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m23970e(boolean z) {
        if (m23956m()) {
            this.f22546I.cancel();
        }
        if (z) {
            if (m23955l() || this.f22580s) {
                return;
            }
            this.f22545H.start();
            return;
        }
        setLineStrokeWidth(this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_stroke_width_dragging));
        setHighLineStrokeWidth(this.f22540C.getDimensionPixelOffset(R.dimen.inertial_zoombar_highlight_stroke_width_dragging));
        setThumbStrokeWidth(this.f22540C.getDimensionPixelOffset(R.dimen.inertial_zoombar_thumb_stroke_width_dragging));
        invalidate();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m23971f(boolean z) {
        if (m23955l()) {
            this.f22545H.cancel();
        }
        if (z) {
            if (m23956m() || !this.f22580s) {
                return;
            }
            this.f22546I.start();
            return;
        }
        setLineStrokeWidth(this.f22540C.getDimensionPixelSize(R.dimen.inertial_zoombar_stroke_width));
        setHighLineStrokeWidth(this.f22540C.getDimensionPixelOffset(R.dimen.inertial_zoombar_stroke_width));
        setThumbStrokeWidth(this.f22540C.getDimensionPixelOffset(R.dimen.inertial_zoombar_thumb_stroke_width));
        invalidate();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean m23955l() {
        ValueAnimator valueAnimator = this.f22545H;
        return valueAnimator != null && valueAnimator.isStarted() && this.f22545H.isRunning();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean m23956m() {
        ValueAnimator valueAnimator = this.f22546I;
        return valueAnimator != null && valueAnimator.isStarted() && this.f22546I.isRunning();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean m23957n() {
        ValueAnimator valueAnimator = this.f22547J;
        return valueAnimator != null && valueAnimator.isStarted() && this.f22547J.isRunning();
    }

    /* renamed from: o */
    private boolean m23958o() {
        ValueAnimator valueAnimator = this.f22548K;
        return valueAnimator != null && valueAnimator.isStarted() && this.f22548K.isRunning();
    }

    /* renamed from: p */
    private void m23959p() {
        this.f22578q = false;
        m23968d(true);
        m23971f(true);
        setIsHighlight(false);
        InterfaceC3495a interfaceC3495a = this.f22557T;
        if (interfaceC3495a != null) {
            interfaceC3495a.mo11572f();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m23944b(MotionEvent motionEvent) {
        float COUIBaseListPopupWindow_12;
        float f2;
        InterfaceC3495a interfaceC3495a;
        InterfaceC3495a interfaceC3495a2;
        InterfaceC3495a interfaceC3495a3;
        InterfaceC3495a interfaceC3495a4;
        int iRound = Math.round(motionEvent.getX());
        Math.round(motionEvent.getY());
        int width = getWidth();
        int paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
        if (iRound < getPaddingLeft()) {
            f2 = 0.0f;
            COUIBaseListPopupWindow_12 = 0.0f;
        } else if (iRound > width - getPaddingRight()) {
            f2 = 1.0f;
            COUIBaseListPopupWindow_12 = 0.0f;
        } else {
            float paddingLeft2 = (iRound - getPaddingLeft()) / paddingLeft;
            COUIBaseListPopupWindow_12 = this.f22574m;
            f2 = paddingLeft2 + COUIBaseListPopupWindow_12;
        }
        if (Float.compare(f2, 0.0f) == 0 && Float.compare(this.f22575n, 0.0f) > 0 && (interfaceC3495a4 = this.f22557T) != null) {
            interfaceC3495a4.mo11566a();
        }
        if (Float.compare(f2, 1.0f) == 0 && Float.compare(this.f22575n, 1.0f) < 0 && (interfaceC3495a3 = this.f22557T) != null) {
            interfaceC3495a3.mo11568b();
        }
        if (this.f22581t && Float.compare(this.f22575n, 0.0f) == 0 && Float.compare(f2, 0.0f) > 0 && (interfaceC3495a2 = this.f22557T) != null) {
            interfaceC3495a2.mo11570d();
        }
        if (this.f22581t && Float.compare(this.f22575n, 1.0f) == 0 && Float.compare(f2, 1.0f) < 0 && (interfaceC3495a = this.f22557T) != null) {
            interfaceC3495a.mo11569c();
        }
        this.f22575n = f2;
        setProgress(COUIBaseListPopupWindow_12 + (f2 * 100.0f));
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m23972f() {
        return Float.compare(this.f22577p, 100.0f) == 0;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m23973g() {
        return Float.compare(this.f22577p, 0.0f) == 0;
    }
}
