package com.oplus.camera.p172ui.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.util.Property;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.preview.ExposureSeekbarContainer;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.util.Util;

/* compiled from: TrackFocusView.java */
/* renamed from: com.oplus.camera.ui.preview.ac */
/* loaded from: classes2.dex */
public class TrackFocusView extends RelativeLayout implements ExposureSeekbarContainer.InterfaceC3377a, FocusIndicator {

    /* renamed from: A */
    private boolean f21603A;

    /* renamed from: B */
    private int f21604B;

    /* renamed from: C */
    private Runnable f21605C;

    /* renamed from: PlatformImplementations.kt_3 */
    private Rect f21606a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private RectF f21607b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RectF f21608c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RectF f21609d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private RectF f21610e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Paint f21611f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Matrix f21612g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f21613h;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f21614i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f21615j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f21616k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f21617l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f21618m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f21619n;

    /* renamed from: o */
    private int f21620o;

    /* renamed from: p */
    private int f21621p;

    /* renamed from: q */
    private int f21622q;

    /* renamed from: r */
    private float f21623r;

    /* renamed from: s */
    private int f21624s;

    /* renamed from: t */
    private ExposureSeekbarContainer f21625t;

    /* renamed from: u */
    private ObjectAnimator f21626u;

    /* renamed from: v */
    private ObjectAnimator f21627v;

    /* renamed from: w */
    private TimeInterpolator f21628w;

    /* renamed from: x */
    private IFocusManagerProxy f21629x;

    /* renamed from: y */
    private volatile int f21630y;

    /* renamed from: z */
    private volatile long f21631z;

    @Override // com.oplus.camera.p172ui.preview.FocusIndicator
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22148a(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public /* synthetic */ void m23019n() {
        if (3 == this.f21630y) {
            m23013a(m23027e());
        }
    }

    public TrackFocusView(Context context) {
        super(context);
        this.f21606a = new Rect();
        this.f21607b = new RectF();
        this.f21608c = new RectF();
        this.f21609d = new RectF();
        this.f21610e = new RectF();
        this.f21611f = new Paint();
        this.f21612g = new Matrix();
        this.f21613h = 0;
        this.f21614i = 1.0f;
        this.f21615j = 1.0f;
        this.f21616k = 0.55f;
        this.f21617l = false;
        this.f21618m = true;
        this.f21619n = false;
        this.f21620o = 0;
        this.f21621p = 0;
        this.f21622q = 0;
        this.f21623r = 0.0f;
        this.f21624s = 0;
        this.f21625t = null;
        this.f21626u = null;
        this.f21627v = null;
        this.f21628w = new LinearInterpolator();
        this.f21629x = null;
        this.f21630y = 0;
        this.f21631z = 0L;
        this.f21603A = false;
        this.f21604B = 0;
        this.f21605C = new Runnable() { // from class: com.oplus.camera.ui.preview.-$$Lambda$ac$40H0SWpkIUCK3KXF3oihDw9ET3M
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m23019n();
            }
        };
        m23012a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23012a(Context context) {
        this.f21611f = new Paint(1);
        this.f21623r = context.getResources().getDimension(R.dimen.video_tracking_focus_frame_radius);
        this.f21611f.setAntiAlias(true);
        this.f21611f.setDither(true);
        this.f21611f.setStyle(Paint.Style.STROKE);
        this.f21611f.setStrokeCap(Paint.Cap.ROUND);
        this.f21611f.setStrokeWidth(context.getResources().getDimensionPixelSize(R.dimen.track_focus_circle_stroke_width));
        this.f21611f.setColor(Util.m24164A(context));
        setWillNotDraw(false);
        LayoutInflater.from(context).inflate(R.layout.track_focus_layout, this);
        this.f21625t = (ExposureSeekbarContainer) findViewById(R.id_renamed.exposure_seekbar_container);
        this.f21625t.setOnSeekbarChangeListener(this);
        this.f21604B = context.getResources().getDimensionPixelSize(R.dimen.exposure_seekbar_margin);
        this.f21622q = getResources().getDimensionPixelSize(R.dimen.exposure_indicator_width);
        m23016k();
    }

    public void setFocusManager(IFocusManagerProxy interfaceC3456s) {
        this.f21629x = interfaceC3456s;
    }

    public void setZoomValue(float COUIBaseListPopupWindow_12) {
        this.f21614i = COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23021a(Rect rect, Rect rect2, Size size, Size size2) {
        CameraLog.m12954a("TrackFocusView", "initTrackRegionParams, cropRegion: " + rect + ", inputRegion: " + rect2 + ", trackHalAlgoSize: " + size);
        if (rect == null) {
            return;
        }
        this.f21606a = rect;
        if (size2 != null) {
            this.f21615j = size2.getWidth() / this.f21606a.height();
        } else {
            this.f21615j = Util.getScreenWidth() / this.f21606a.height();
        }
        if (Math.abs((size.getWidth() / size.getHeight()) - (this.f21606a.width() / this.f21606a.height())) > 0.01d) {
            this.f21619n = true;
            this.f21620o = this.f21606a.top;
            this.f21621p = this.f21606a.height();
            return;
        }
        this.f21619n = false;
    }

    public void setDisplayOrientation(int OplusGLSurfaceView_13) {
        this.f21613h = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23023a(int[] iArr) {
        if (iArr == null) {
            this.f21618m = false;
            return;
        }
        if (this.f21617l || this.f21618m) {
            return;
        }
        m23015b(iArr);
        if (2 == this.f21630y && !this.f21609d.isEmpty()) {
            this.f21610e.setEmpty();
            this.f21631z = 0L;
            this.f21630y = 3;
        }
        if (3 != this.f21630y) {
            return;
        }
        this.f21607b.set(this.f21609d);
        post(this.f21605C);
        postInvalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23013a(boolean z) {
        CameraLog.m12959b("TrackFocusView", "fadeInOutSeekbar, fadeIn: " + z);
        if (z) {
            ObjectAnimator objectAnimator = this.f21627v;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f21627v.cancel();
            }
            if (this.f21626u == null) {
                this.f21626u = ObjectAnimator.ofFloat(this.f21625t, (Property<ExposureSeekbarContainer, Float>) ALPHA, 0.0f, 1.0f);
                this.f21626u.setDuration(150L);
                this.f21626u.setInterpolator(this.f21628w);
            }
            if (this.f21626u.isRunning()) {
                CameraLog.m12959b("TrackFocusView", "fadeInOutSeekbar, mSeekbarFadeInAnimator is running.");
                return;
            }
            this.f21625t.setVisibility(0);
            this.f21626u.setFloatValues(this.f21625t.getAlpha(), this.f21616k);
            this.f21626u.start();
            return;
        }
        ObjectAnimator objectAnimator2 = this.f21626u;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.f21626u.cancel();
        }
        if (this.f21627v == null) {
            this.f21627v = ObjectAnimator.ofFloat(this.f21625t, (Property<ExposureSeekbarContainer, Float>) ALPHA, 1.0f, 0.0f);
            this.f21627v.setDuration(150L);
            this.f21627v.setInterpolator(this.f21628w);
            this.f21627v.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.ac.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    TrackFocusView.this.f21625t.setVisibility(8);
                }
            });
        }
        if (this.f21627v.isRunning()) {
            CameraLog.m12959b("TrackFocusView", "fadeInOutSeekbar, mSeekbarFadeOutAnimator is running.");
        } else {
            this.f21627v.setFloatValues(this.f21625t.getAlpha(), 0.0f);
            this.f21627v.start();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m23015b(int[] iArr) {
        if (this.f21619n) {
            int OplusGLSurfaceView_13 = iArr[1];
            int i2 = this.f21620o;
            int i3 = OplusGLSurfaceView_13 - i2;
            int i4 = iArr[3] - i2;
            RectF rectF = this.f21609d;
            float COUIBaseListPopupWindow_12 = iArr[0];
            if (i3 <= 0) {
                i3 = 0;
            }
            float f2 = i3;
            float f3 = iArr[2];
            int i5 = this.f21621p;
            if (i4 < i5) {
                i5 = i4;
            }
            rectF.set(COUIBaseListPopupWindow_12, f2, f3, i5);
            return;
        }
        this.f21609d.set(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23024b() {
        CameraLog.m12959b("TrackFocusView", VideoRecordMsgData.EVENT_PAUSE);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            setVisibility(8);
            this.f21625t.setVisibility(8);
        } else {
            post(new Runnable() { // from class: com.oplus.camera.ui.preview.-$$Lambda$ac$Hxdc_daVzghpBU2wzaYssQCP7J8
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m23018m();
                }
            });
        }
        this.f21617l = true;
        this.f21618m = true;
        m23030h();
        this.f21630y = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public /* synthetic */ void m23018m() {
        setVisibility(8);
        this.f21625t.setVisibility(8);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23025c() {
        CameraLog.m12959b("TrackFocusView", "resume");
        setVisibility(0);
        setAlpha(0.55f);
        m23016k();
        this.f21625t.setToggleViewEnable(true);
        this.f21625t.m22114b(true);
        setLockState(this.f21629x.mo23649I());
        this.f21617l = false;
        this.f21630y = 1;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m23026d() {
        return getVisibility() == 0 && (this.f21625t.getVisibility() == 0 || m23027e());
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m23027e() {
        return !this.f21607b.isEmpty();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m23028f() {
        return 2 == this.f21630y && System.currentTimeMillis() - this.f21631z > 1000;
    }

    public void setLockState(boolean z) {
        this.f21625t.setLockedState(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23022a(RectF rectF) {
        CameraLog.m12959b("TrackFocusView", "initDrawRect");
        this.f21610e.set(rectF);
        m23013a(true);
        postInvalidate();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m23029g() {
        CameraLog.m12959b("TrackFocusView", "cancelFadeInOutAnimation");
        ObjectAnimator objectAnimator = this.f21626u;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f21627v;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.f21607b.isEmpty()) {
            this.f21612g.reset();
            this.f21612g.setTranslate((-this.f21606a.width()) / 2, (-this.f21606a.height()) / 2);
            this.f21612g.postScale(1.0f, this.f21603A ? -1.0f : 1.0f);
            this.f21612g.postRotate(this.f21613h);
            Matrix matrix = this.f21612g;
            float COUIBaseListPopupWindow_12 = this.f21615j;
            float f2 = this.f21614i;
            matrix.postScale(COUIBaseListPopupWindow_12 * f2, COUIBaseListPopupWindow_12 * f2);
            this.f21612g.postTranslate(getWidth() / 2, getHeight() / 2);
            this.f21612g.mapRect(this.f21608c, this.f21607b);
            RectF rectF = this.f21608c;
            rectF.inset((rectF.width() - this.f21622q) / 2.0f, (this.f21608c.height() - this.f21622q) / 2.0f);
        } else if (this.f21610e.isEmpty()) {
            return;
        } else {
            this.f21608c.set(this.f21610e);
        }
        m23014b(this.f21608c);
        RectF rectF2 = this.f21608c;
        float f3 = this.f21623r;
        canvas.drawRoundRect(rectF2, f3, f3, this.f21611f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m23014b(RectF rectF) {
        if (rectF.right > getRight()) {
            rectF.right = getRight();
        } else if (rectF.right < 0.0f) {
            rectF.right = 0.0f;
        }
        if (rectF.left < getLeft()) {
            rectF.left = getLeft();
        } else if (rectF.left > getRight()) {
            rectF.left = getRight();
        }
        if (rectF.bottom > getBottom()) {
            rectF.bottom = getBottom();
        } else if (rectF.bottom < 0.0f) {
            rectF.bottom = 0.0f;
        }
        if (rectF.top > getBottom()) {
            rectF.top = getBottom();
        } else if (rectF.top < 0.0f) {
            rectF.top = 0.0f;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m23030h() {
        this.f21607b.setEmpty();
        this.f21609d.setEmpty();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            m23029g();
            this.f21625t.m22113a(true);
            invalidate();
            return;
        }
        post(new Runnable() { // from class: com.oplus.camera.ui.preview.-$$Lambda$ac$yPty0RqQsX0Vzw0Tm9AtT3dj6b8
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m23017l();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public /* synthetic */ void m23017l() {
        m23029g();
        this.f21625t.m22113a(true);
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23020a(int OplusGLSurfaceView_13, boolean z) {
        this.f21624s = OplusGLSurfaceView_13;
        m23016k();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m23016k() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f21625t.getLayoutParams();
        int OplusGLSurfaceView_13 = this.f21604B;
        layoutParams.setMargins(OplusGLSurfaceView_13, 0, OplusGLSurfaceView_13, 0);
        layoutParams.addRule(15);
        int i2 = this.f21624s;
        if (i2 == 0 || i2 == 90) {
            layoutParams.removeRule(20);
            layoutParams.addRule(21);
        } else if (i2 == 180 || i2 == 270) {
            layoutParams.removeRule(21);
            layoutParams.addRule(20);
        }
        this.f21625t.m22112a(this.f21624s, true);
        this.f21625t.requestLayout();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m23031i() {
        return this.f21625t.isShown();
    }

    @Override // android.view.View
    public void setAlpha(float COUIBaseListPopupWindow_12) {
        CameraLog.m12954a("TrackFocusView", "setAlpha, alpha:" + COUIBaseListPopupWindow_12);
        ExposureSeekbarContainer exposureSeekbarContainer = this.f21625t;
        if (exposureSeekbarContainer != null) {
            this.f21616k = COUIBaseListPopupWindow_12;
            exposureSeekbarContainer.setAlpha(COUIBaseListPopupWindow_12);
        }
    }

    public void setMoveDistance(float COUIBaseListPopupWindow_12) {
        this.f21625t.setMoveDistance(COUIBaseListPopupWindow_12);
    }

    @Override // com.oplus.camera.p172ui.preview.ExposureSeekbarContainer.InterfaceC3377a
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22117a(float COUIBaseListPopupWindow_12) {
        IFocusManagerProxy interfaceC3456s = this.f21629x;
        if (interfaceC3456s != null) {
            interfaceC3456s.mo23657a(COUIBaseListPopupWindow_12);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.ExposureSeekbarContainer.InterfaceC3377a
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22116a() {
        setAlpha(1.0f);
        IFocusManagerProxy interfaceC3456s = this.f21629x;
        if (interfaceC3456s != null) {
            interfaceC3456s.mo23648H();
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m23032j() {
        CameraLog.m12959b("TrackFocusView", "track, object searching.");
        this.f21630y = 2;
        this.f21631z = System.currentTimeMillis();
    }

    public void setRearMirrorEnable(boolean z) {
        this.f21603A = z;
    }

    public boolean getRearMirrorEnable() {
        return this.f21603A;
    }
}
