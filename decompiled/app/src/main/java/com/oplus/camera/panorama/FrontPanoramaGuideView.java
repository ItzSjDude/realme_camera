package com.oplus.camera.panorama;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class FrontPanoramaGuideView extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private Path f14829a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Paint f14830b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f14831c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PathMeasure f14832d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f14833e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f14834f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float[] f14835g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float[] f14836h;

    /* renamed from: OplusGLSurfaceView_13 */
    private RectF f14837i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Path f14838j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f14839k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f14840l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f14841m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f14842n;

    /* renamed from: o */
    private Bitmap f14843o;

    /* renamed from: p */
    private int f14844p;

    /* renamed from: q */
    private DirectionMode f14845q;

    /* renamed from: r */
    private DirectionMode f14846r;

    /* renamed from: s */
    private DirectionMode f14847s;

    /* renamed from: t */
    private ValueAnimator f14848t;

    /* renamed from: u */
    private InterfaceC2832a f14849u;

    /* renamed from: v */
    private Runnable f14850v;

    /* renamed from: com.oplus.camera.panorama.FrontPanoramaGuideView$PlatformImplementations.kt_3 */
    public interface InterfaceC2832a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo14880a(int OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m14868a(float COUIBaseListPopupWindow_12) {
        return (float) ((COUIBaseListPopupWindow_12 * 3.141592653589793d) / 180.0d);
    }

    public FrontPanoramaGuideView(Context context) {
        super(context);
        this.f14829a = null;
        this.f14830b = null;
        this.f14831c = true;
        this.f14832d = null;
        this.f14833e = 100.0f;
        this.f14834f = 50.0f;
        this.f14835g = null;
        this.f14836h = null;
        this.f14837i = null;
        this.f14838j = null;
        this.f14839k = 30.0f;
        this.f14840l = 5.0f;
        this.f14841m = -256;
        this.f14842n = 40;
        this.f14843o = null;
        this.f14844p = 1;
        this.f14845q = null;
        this.f14846r = null;
        this.f14847s = null;
        this.f14848t = null;
        this.f14849u = null;
        this.f14850v = new Runnable() { // from class: com.oplus.camera.panorama.FrontPanoramaGuideView.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrontPanoramaGuideView.this.f14848t == null || FrontPanoramaGuideView.this.f14848t.isRunning()) {
                    return;
                }
                if (FrontPanoramaGuideView.this.f14847s.m14921b() != FrontPanoramaGuideView.this.f14844p) {
                    FrontPanoramaGuideView.this.m14876e();
                }
                FrontPanoramaGuideView.this.f14847s.mo14915a();
                FrontPanoramaGuideView.this.f14848t.start();
            }
        };
    }

    public FrontPanoramaGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14829a = null;
        this.f14830b = null;
        this.f14831c = true;
        this.f14832d = null;
        this.f14833e = 100.0f;
        this.f14834f = 50.0f;
        this.f14835g = null;
        this.f14836h = null;
        this.f14837i = null;
        this.f14838j = null;
        this.f14839k = 30.0f;
        this.f14840l = 5.0f;
        this.f14841m = -256;
        this.f14842n = 40;
        this.f14843o = null;
        this.f14844p = 1;
        this.f14845q = null;
        this.f14846r = null;
        this.f14847s = null;
        this.f14848t = null;
        this.f14849u = null;
        this.f14850v = new Runnable() { // from class: com.oplus.camera.panorama.FrontPanoramaGuideView.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrontPanoramaGuideView.this.f14848t == null || FrontPanoramaGuideView.this.f14848t.isRunning()) {
                    return;
                }
                if (FrontPanoramaGuideView.this.f14847s.m14921b() != FrontPanoramaGuideView.this.f14844p) {
                    FrontPanoramaGuideView.this.m14876e();
                }
                FrontPanoramaGuideView.this.f14847s.mo14915a();
                FrontPanoramaGuideView.this.f14848t.start();
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FrontPanoramaGuideView);
        this.f14839k = typedArrayObtainStyledAttributes.getDimension(0, this.f14839k);
        this.f14840l = typedArrayObtainStyledAttributes.getDimension(2, this.f14840l);
        this.f14833e = typedArrayObtainStyledAttributes.getDimension(3, this.f14833e);
        this.f14834f = typedArrayObtainStyledAttributes.getDimension(4, this.f14834f);
        this.f14841m = typedArrayObtainStyledAttributes.getColor(1, -256);
        typedArrayObtainStyledAttributes.recycle();
        m14872c();
    }

    public FrontPanoramaGuideView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f14829a = null;
        this.f14830b = null;
        this.f14831c = true;
        this.f14832d = null;
        this.f14833e = 100.0f;
        this.f14834f = 50.0f;
        this.f14835g = null;
        this.f14836h = null;
        this.f14837i = null;
        this.f14838j = null;
        this.f14839k = 30.0f;
        this.f14840l = 5.0f;
        this.f14841m = -256;
        this.f14842n = 40;
        this.f14843o = null;
        this.f14844p = 1;
        this.f14845q = null;
        this.f14846r = null;
        this.f14847s = null;
        this.f14848t = null;
        this.f14849u = null;
        this.f14850v = new Runnable() { // from class: com.oplus.camera.panorama.FrontPanoramaGuideView.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrontPanoramaGuideView.this.f14848t == null || FrontPanoramaGuideView.this.f14848t.isRunning()) {
                    return;
                }
                if (FrontPanoramaGuideView.this.f14847s.m14921b() != FrontPanoramaGuideView.this.f14844p) {
                    FrontPanoramaGuideView.this.m14876e();
                }
                FrontPanoramaGuideView.this.f14847s.mo14915a();
                FrontPanoramaGuideView.this.f14848t.start();
            }
        };
    }

    public void setOnDirectionChangeListener(InterfaceC2832a interfaceC2832a) {
        this.f14849u = interfaceC2832a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m14872c() {
        this.f14830b = new Paint();
        this.f14830b.setAntiAlias(true);
        this.f14830b.setDither(true);
        this.f14830b.setStyle(Paint.Style.STROKE);
        this.f14830b.setColor(this.f14841m);
        this.f14830b.setStrokeWidth(this.f14840l);
        this.f14830b.setStrokeJoin(Paint.Join.ROUND);
        this.f14830b.setStrokeCap(Paint.Cap.ROUND);
        this.f14829a = new Path();
        this.f14835g = new float[2];
        this.f14836h = new float[2];
        this.f14832d = new PathMeasure(this.f14829a, false);
        float fM14868a = m14868a(this.f14842n);
        this.f14838j = new Path();
        double IntrinsicsJvm.kt_5 = fM14868a;
        this.f14838j.setLastPoint(-((float) (this.f14839k * Math.cos(IntrinsicsJvm.kt_5))), (float) (this.f14839k * Math.sin(IntrinsicsJvm.kt_5)));
        this.f14838j.lineTo(0.0f, 0.0f);
        this.f14838j.lineTo(-((float) (this.f14839k * Math.cos(IntrinsicsJvm.kt_5))), -((float) (this.f14839k * Math.sin(IntrinsicsJvm.kt_5))));
        this.f14843o = BitmapFactory.decodeResource(getResources(), R.drawable.front_panorama_guide_phone_icon);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14878a(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("FrontPanoramaGuideView", "startAnimation, direction: " + OplusGLSurfaceView_13);
        this.f14844p = OplusGLSurfaceView_13;
        m14876e();
        this.f14831c = false;
        if (this.f14848t == null) {
            this.f14848t = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f14848t.setDuration(820L);
            this.f14848t.setInterpolator(new PathInterpolator(0.43f, 0.0f, 0.42f, 1.0f));
            this.f14848t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.panorama.FrontPanoramaGuideView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FrontPanoramaGuideView.this.f14847s.mo14916a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    FrontPanoramaGuideView.this.invalidate();
                }
            });
            this.f14848t.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.panorama.FrontPanoramaGuideView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    FrontPanoramaGuideView frontPanoramaGuideView = FrontPanoramaGuideView.this;
                    frontPanoramaGuideView.removeCallbacks(frontPanoramaGuideView.f14850v);
                    FrontPanoramaGuideView frontPanoramaGuideView2 = FrontPanoramaGuideView.this;
                    frontPanoramaGuideView2.postDelayed(frontPanoramaGuideView2.f14850v, 680L);
                }
            });
            this.f14848t.start();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14877a() {
        CameraLog.m12954a("FrontPanoramaGuideView", "stopAnimation");
        this.f14831c = true;
        removeCallbacks(this.f14850v);
        ValueAnimator valueAnimator = this.f14848t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f14848t = null;
        }
    }

    public void setNextDirection(int OplusGLSurfaceView_13) {
        this.f14844p = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14879b() {
        Bitmap bitmap = this.f14843o;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f14843o.recycle();
            this.f14843o = null;
        }
        this.f14831c = true;
    }

    public String getCurrentGuideTips() {
        DirectionMode abstractC2837c = this.f14847s;
        return abstractC2837c != null ? abstractC2837c.mo14914a(getContext()) : "";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        m14873d();
        if (this.f14831c) {
            return;
        }
        canvas.drawBitmap(this.f14843o, this.f14847s.m14920a(this.f14843o.getWidth(), this.f14843o.getHeight(), getWidth(), getHeight()), this.f14830b);
        this.f14829a.reset();
        this.f14829a.addArc(this.f14837i, this.f14847s.m14924d(), this.f14847s.m14925e());
        canvas.drawPath(this.f14829a, this.f14830b);
        this.f14832d.setPath(this.f14829a, false);
        this.f14832d.getPosTan(this.f14847s.mo14918b(this.f14832d.getLength()), this.f14835g, this.f14836h);
        float[] fArr = this.f14836h;
        float fMo14919c = this.f14847s.mo14919c((float) ((Math.atan2(fArr[1], fArr[0]) * 180.0d) / 3.141592653589793d));
        canvas.save();
        float[] fArr2 = this.f14835g;
        canvas.rotate(fMo14919c, fArr2[0], fArr2[1]);
        canvas.save();
        float[] fArr3 = this.f14835g;
        canvas.translate(fArr3[0], fArr3[1]);
        canvas.drawPath(this.f14838j, this.f14830b);
        canvas.restore();
        canvas.restore();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m14873d() {
        if (this.f14837i == null) {
            float width = (getWidth() - (this.f14833e * 2.0f)) / 2.0f;
            float height = (getHeight() / 2) - getResources().getDimensionPixelSize(R.dimen.front_panorama_guide_ellipse_margin_top_by_center);
            this.f14837i = new RectF(width, height, (this.f14833e * 2.0f) + width, (this.f14834f * 2.0f) + height);
            CameraLog.m12954a("FrontPanoramaGuideView", "initEllipseRect, mEllipseRect: " + this.f14837i);
        }
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != getVisibility()) {
            if (OplusGLSurfaceView_13 == 8 || OplusGLSurfaceView_13 == 4) {
                m14877a();
            } else {
                m14878a(this.f14844p);
            }
        }
        super.setVisibility(OplusGLSurfaceView_13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m14876e() {
        CameraLog.m12954a("FrontPanoramaGuideView", "changeDirectionMode, mNextDirection: " + this.f14844p);
        int OplusGLSurfaceView_13 = this.f14844p;
        if (OplusGLSurfaceView_13 == 0) {
            if (this.f14845q == null) {
                this.f14845q = new ClockwiseDirection(getContext());
            }
            this.f14847s = this.f14845q;
        } else if (OplusGLSurfaceView_13 == 1) {
            if (this.f14846r == null) {
                this.f14846r = new AntiClockwiseDirection(getContext());
            }
            this.f14847s = this.f14846r;
        }
        InterfaceC2832a interfaceC2832a = this.f14849u;
        if (interfaceC2832a != null) {
            interfaceC2832a.mo14880a(this.f14847s.m14921b());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f14831c = true;
    }
}
