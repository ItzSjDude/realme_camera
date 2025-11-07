package com.oplus.camera.p172ui.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.SensorEvent;
import android.hardware.SensorEventCallback;
import android.hardware.SensorManager;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;
import com.oplusos.gradientereffects.GradienterNative;
import java.util.LinkedList;

/* compiled from: GradienterAssistView.java */
/* renamed from: com.oplus.camera.ui.preview.p */
/* loaded from: classes2.dex */
public class GradienterAssistView extends View {

    /* renamed from: A */
    private Point f22269A;

    /* renamed from: B */
    private Paint f22270B;

    /* renamed from: C */
    private PlatformImplementations.kt_3 f22271C;

    /* renamed from: D */
    private PlatformImplementations.kt_3 f22272D;

    /* renamed from: E */
    private PlatformImplementations.kt_3 f22273E;

    /* renamed from: F */
    private ValueAnimator f22274F;

    /* renamed from: G */
    private ValueAnimator f22275G;

    /* renamed from: H */
    private ValueAnimator f22276H;

    /* renamed from: I */
    private ValueAnimator f22277I;

    /* renamed from: J */
    private ValueAnimator f22278J;

    /* renamed from: K */
    private AnimatorSet f22279K;

    /* renamed from: L */
    private AnimatorSet f22280L;

    /* renamed from: M */
    private float[] f22281M;

    /* renamed from: N */
    private float[] f22282N;

    /* renamed from: O */
    private float[] f22283O;

    /* renamed from: P */
    private int[] f22284P;

    /* renamed from: Q */
    private int[] f22285Q;

    /* renamed from: R */
    private LinkedList<PlatformImplementations.kt_3> f22286R;

    /* renamed from: S */
    private IntrinsicsJvm.kt_4 f22287S;

    /* renamed from: T */
    private SensorEventCallback f22288T;

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f22289a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f22290b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f22291c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f22292d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f22293e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f22294f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f22295g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f22296h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f22297i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f22298j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f22299k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f22300l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f22301m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f22302n;

    /* renamed from: o */
    private float f22303o;

    /* renamed from: p */
    private float f22304p;

    /* renamed from: q */
    private long f22305q;

    /* renamed from: r */
    private long f22306r;

    /* renamed from: s */
    private Rect f22307s;

    /* renamed from: t */
    private Rect f22308t;

    /* renamed from: u */
    private Drawable f22309u;

    /* renamed from: v */
    private Drawable f22310v;

    /* renamed from: w */
    private Bitmap f22311w;

    /* renamed from: x */
    private Bitmap f22312x;

    /* renamed from: y */
    private Bitmap f22313y;

    /* renamed from: z */
    private Bitmap f22314z;

    /* compiled from: GradienterAssistView.java */
    /* renamed from: com.oplus.camera.ui.preview.p$IntrinsicsJvm.kt_4 */
    interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo23434a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m23726a(int OplusGLSurfaceView_13, int i2) {
        return (OplusGLSurfaceView_13 & i2) == i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public static float m23739c(float COUIBaseListPopupWindow_12, float f2) {
        float f3 = f2 - COUIBaseListPopupWindow_12;
        return f3 < -90.0f ? f3 + 180.0f : f3 > 90.0f ? f3 - 180.0f : f3;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    static /* synthetic */ int m23751f(GradienterAssistView c3453p) {
        int OplusGLSurfaceView_13 = c3453p.f22297i;
        c3453p.f22297i = OplusGLSurfaceView_13 + 1;
        return OplusGLSurfaceView_13;
    }

    public void setViewLayoutType(int OplusGLSurfaceView_13) {
        this.f22302n = OplusGLSurfaceView_13;
        this.f22293e = m23726a(this.f22302n, 1);
        this.f22294f = m23726a(this.f22302n, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m23729a(float[] fArr) {
        if (fArr == null) {
            return true;
        }
        for (float COUIBaseListPopupWindow_12 : fArr) {
            if (Float.compare(COUIBaseListPopupWindow_12, 0.0f) != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m23725a(float COUIBaseListPopupWindow_12) {
        return 1.5707963267948966d - ((double) Math.abs(this.f22283O[2])) < ((double) COUIBaseListPopupWindow_12) && Math.abs(this.f22283O[0]) < COUIBaseListPopupWindow_12 && Math.abs(this.f22283O[1]) < COUIBaseListPopupWindow_12;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m23735b(float COUIBaseListPopupWindow_12) {
        return 1.5707963267948966d - ((double) Math.abs(this.f22283O[0])) < ((double) COUIBaseListPopupWindow_12) && Math.abs(this.f22283O[2]) < COUIBaseListPopupWindow_12 && Math.abs(this.f22283O[1]) < COUIBaseListPopupWindow_12;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m23747d() {
        return 1.5707963267948966d - ((double) Math.abs(this.f22283O[0])) < 1.0d && Math.abs(this.f22283O[1]) < 1.0f;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m23749e() {
        return 1.5707963267948966d - ((double) Math.abs(this.f22283O[1])) < 1.0d && Math.abs(this.f22283O[0]) < 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a4  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m23716a(long r10) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.GradienterAssistView.m23716a(long):void");
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m23752f() {
        return 0.0f > this.f22283O[0];
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m23754g() {
        return 0.0f < this.f22283O[1];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23722a(PlatformImplementations.kt_3 aVar) {
        if (aVar.m23784a()) {
            CameraLog.m12966e("GradienterAssistView", "checkAndAddAttitude, empty attitude is dismissed.");
            return;
        }
        if (1 < this.f22286R.size()) {
            this.f22286R.removeLast();
        }
        while (!this.f22286R.isEmpty() && this.f22286R.peekLast().f22324a != aVar.f22324a) {
            this.f22286R.removeLast();
        }
        if (!this.f22271C.m23784a()) {
            if (!m23736b(this.f22271C, this.f22273E) || this.f22293e) {
                if (m23742c(this.f22271C, this.f22273E)) {
                    ValueAnimator valueAnimator = this.f22274F;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                    }
                    this.f22286R.add(this.f22273E.m23791c());
                    m23724a(true);
                    return;
                }
                ValueAnimator valueAnimator2 = this.f22274F;
                if ((valueAnimator2 == null || !valueAnimator2.isRunning()) && !this.f22286R.isEmpty()) {
                    this.f22286R.removeFirst();
                }
                this.f22286R.add(this.f22273E.m23791c());
                m23759j();
                return;
            }
            this.f22286R.add(this.f22273E.m23791c());
            m23755h();
            m23759j();
            return;
        }
        this.f22271C.m23799j(this.f22273E);
        this.f22272D.m23799j(this.f22273E);
        m23724a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m23755h() {
        if (this.f22277I == null) {
            this.f22277I = ValueAnimator.ofFloat(255.0f, 0.0f);
            this.f22277I.setDuration(250L);
            this.f22277I.setInterpolator(new LinearInterpolator());
            this.f22277I.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.p.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    GradienterAssistView.this.m23757i();
                }
            });
            this.f22277I.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$p$kyMNmhchBKZ-NtoV1RyG-_XlIiM
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.COUIBaseListPopupWindow_12$0.m23746d(valueAnimator);
                }
            });
        }
        if (this.f22278J == null) {
            this.f22278J = ValueAnimator.ofFloat(0.0f, 255.0f);
            this.f22278J.setDuration(250L);
            this.f22278J.setInterpolator(new LinearInterpolator());
            this.f22278J.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$p$abpvEjp3V7jRpu-XuvjMwNhB2_k
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.COUIBaseListPopupWindow_12$0.m23741c(valueAnimator);
                }
            });
        }
        if (this.f22280L == null) {
            this.f22280L = new AnimatorSet();
            this.f22280L.play(this.f22278J).after(this.f22277I);
            this.f22280L.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.p.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GradienterAssistView.this.f22292d) {
                        GradienterAssistView.this.m23755h();
                    }
                }
            });
        }
        if (!this.f22280L.isRunning()) {
            PlatformImplementations.kt_3 first = this.f22286R.isEmpty() ? null : this.f22286R.getFirst();
            if (first == null || Float.compare(this.f22272D.f22330g, first.f22330g) == 0) {
                return;
            }
            this.f22280L.start();
            this.f22292d = false;
            return;
        }
        this.f22292d = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m23746d(ValueAnimator valueAnimator) {
        this.f22303o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m23741c(ValueAnimator valueAnimator) {
        this.f22303o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_13 */
    public void m23757i() {
        this.f22272D.m23781a(this.f22286R.peekFirst(), this.f22273E, this.f22271C);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23724a(boolean z) {
        if (this.f22275G == null) {
            this.f22275G = ValueAnimator.ofInt(255, 0);
            this.f22275G.setDuration(250L);
            this.f22275G.setInterpolator(new LinearInterpolator());
            this.f22275G.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.p.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    GradienterAssistView.this.f22271C.m23799j(GradienterAssistView.this.f22273E);
                    GradienterAssistView.this.f22272D.m23799j(GradienterAssistView.this.f22273E);
                }
            });
            this.f22275G.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$p$huPWvN5IGm0aedMQXvphT9Z-2ZM
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.COUIBaseListPopupWindow_12$0.m23734b(valueAnimator);
                }
            });
        }
        if (this.f22276H == null) {
            this.f22276H = ValueAnimator.ofInt(0, 255);
            this.f22276H.setDuration(250L);
            this.f22276H.setInterpolator(new LinearInterpolator());
            this.f22276H.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.p.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    GradienterAssistView.this.m23757i();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    GradienterAssistView.this.m23759j();
                }
            });
            this.f22276H.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$p$L53pcdHO_AJ5Es-r3YCe22h7wl4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.COUIBaseListPopupWindow_12$0.m23718a(valueAnimator);
                }
            });
        }
        if (this.f22279K == null) {
            this.f22279K = new AnimatorSet();
            this.f22279K.play(this.f22276H).after(this.f22275G);
        }
        if (z) {
            if (this.f22279K.isRunning()) {
                return;
            }
            this.f22279K.start();
        } else {
            if (this.f22276H.isRunning()) {
                return;
            }
            this.f22276H.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m23734b(ValueAnimator valueAnimator) {
        this.f22296h = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m23718a(ValueAnimator valueAnimator) {
        this.f22296h = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m23727a(PlatformImplementations.kt_3 aVar, PlatformImplementations.kt_3 aVar2) {
        return aVar.f22324a != aVar2.f22324a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m23736b(PlatformImplementations.kt_3 aVar, PlatformImplementations.kt_3 aVar2) {
        return (aVar.f22324a == 3 && aVar2.f22324a == 2) || (aVar.f22324a == 2 && aVar2.f22324a == 3);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m23742c(PlatformImplementations.kt_3 aVar, PlatformImplementations.kt_3 aVar2) {
        return m23727a(aVar, aVar2) && !m23736b(aVar, aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public void m23759j() {
        AnimatorSet animatorSet = this.f22279K;
        if (animatorSet == null || !animatorSet.isRunning()) {
            ValueAnimator valueAnimator = this.f22276H;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.f22274F;
                if ((valueAnimator2 == null || !valueAnimator2.isRunning()) && this.f22286R.size() > 0) {
                    m23762k();
                }
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m23762k() {
        if (this.f22274F == null) {
            this.f22274F = ValueAnimator.ofFloat(0.0f, 100.0f);
            this.f22274F.setDuration(60L);
            this.f22274F.setInterpolator(new LinearInterpolator());
            this.f22274F.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.p.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) GradienterAssistView.this.f22286R.peekFirst();
                    if (aVar == null) {
                        CameraLog.m12966e("GradienterAssistView", "startTransitionAnimation, attitude list is empty.");
                        return;
                    }
                    GradienterAssistView.this.f22272D.m23780a(GradienterAssistView.this.f22271C, aVar, fFloatValue / 100.0f, GradienterAssistView.this.f22304p);
                    if (Float.compare(fFloatValue, 100.0f) == 0) {
                        GradienterAssistView.this.f22271C.m23799j(aVar);
                        GradienterAssistView.this.f22286R.removeFirst();
                    }
                    if (GradienterAssistView.this.f22291c && aVar.f22328e) {
                        return;
                    }
                    GradienterAssistView.this.invalidate();
                }
            });
            this.f22274F.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.p.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    GradienterAssistView.this.m23759j();
                }
            });
        }
        if (this.f22274F.isRunning() || this.f22286R.size() <= 0) {
            return;
        }
        this.f22274F.start();
    }

    public GradienterAssistView(Context context) {
        super(context);
        this.f22289a = false;
        this.f22290b = false;
        this.f22291c = false;
        this.f22292d = false;
        this.f22293e = false;
        this.f22294f = false;
        this.f22295g = 0;
        this.f22296h = 0;
        this.f22297i = 0;
        this.f22298j = 0;
        this.f22299k = 0;
        this.f22300l = 0;
        this.f22301m = 0;
        this.f22302n = 0;
        this.f22303o = 255.0f;
        this.f22304p = 0.0f;
        this.f22305q = 0L;
        this.f22306r = 0L;
        this.f22307s = new Rect();
        this.f22308t = new Rect();
        this.f22309u = null;
        this.f22310v = null;
        this.f22311w = null;
        this.f22312x = null;
        this.f22313y = null;
        this.f22314z = null;
        this.f22269A = new Point(0, 0);
        this.f22270B = null;
        this.f22271C = new PlatformImplementations.kt_3();
        this.f22272D = new PlatformImplementations.kt_3();
        this.f22273E = new PlatformImplementations.kt_3();
        this.f22274F = null;
        this.f22275G = null;
        this.f22276H = null;
        this.f22277I = null;
        this.f22278J = null;
        this.f22279K = null;
        this.f22280L = null;
        this.f22281M = new float[3];
        this.f22282N = new float[4];
        this.f22283O = new float[4];
        this.f22284P = new int[3];
        this.f22285Q = new int[1];
        this.f22286R = new LinkedList<>();
        this.f22287S = null;
        this.f22288T = new SensorEventCallback() { // from class: com.oplus.camera.ui.preview.p.1
            @Override // android.hardware.SensorEventCallback, android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (9 == sensorEvent.sensor.getType()) {
                    GradienterAssistView.this.f22281M = (float[]) sensorEvent.values.clone();
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                GradienterNative.processGravity(GradienterAssistView.this.f22281M[0], GradienterAssistView.this.f22281M[1], GradienterAssistView.this.f22281M[2], GradienterAssistView.this.f22283O, GradienterAssistView.this.f22284P, GradienterAssistView.this.f22285Q);
                GradienterAssistView c3453p = GradienterAssistView.this;
                if (c3453p.m23729a(c3453p.f22282N) || 0.05f <= Math.abs(GradienterAssistView.this.f22283O[0] - GradienterAssistView.this.f22282N[0]) || 0.05f <= Math.abs(GradienterAssistView.this.f22283O[1] - GradienterAssistView.this.f22282N[1])) {
                    GradienterAssistView.this.f22297i = 0;
                } else {
                    GradienterAssistView.m23751f(GradienterAssistView.this);
                }
                GradienterAssistView c3453p2 = GradienterAssistView.this;
                c3453p2.f22282N = (float[]) c3453p2.f22283O.clone();
                if (10 <= GradienterAssistView.this.f22297i) {
                    return;
                }
                GradienterAssistView.this.m23716a(jCurrentTimeMillis);
                super.onSensorChanged(sensorEvent);
            }
        };
        m23719a(context);
    }

    public void setOnAdjustedListener(IntrinsicsJvm.kt_4 bVar) {
        this.f22287S = bVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23719a(Context context) {
        this.f22270B = new Paint();
        this.f22270B.setAlpha(0);
        this.f22270B.setAntiAlias(true);
        this.f22270B.setStyle(Paint.Style.FILL);
        this.f22295g = getResources().getDimensionPixelOffset(R.dimen.gradienter_cross_max_offset);
        this.f22304p = getResources().getDimensionPixelOffset(R.dimen.gradienter_adjusted_threshold_in_distance);
        this.f22298j = Util.m24164A(context);
        this.f22299k = context.getColor(R.color.gradienter_adjusting_color);
        this.f22301m = getResources().getDimensionPixelSize(R.dimen.gradienter_base_line_length);
        this.f22300l = getResources().getDimensionPixelSize(R.dimen.gradienter_base_line_width);
        this.f22269A.set(0, getResources().getDimensionPixelOffset(R.dimen.gradienter_vertical_offset));
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        if ((i3 == 0 || i4 == 0) && OplusGLSurfaceView_13 > 0 && i2 > 0 && this.f22308t.left < 0 && isShown()) {
            CameraLog.m12959b("GradienterAssistView", "onSizeChanged, need invalidate, mBaseLineRect: " + this.f22308t);
            m23716a(System.currentTimeMillis());
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f22289a) {
            if (255 > this.f22296h) {
                CameraLog.m12959b("GradienterAssistView", "onDraw, alpha: " + this.f22296h + ", Gradienter type: " + this.f22272D.f22324a);
            }
            this.f22270B.setAlpha(this.f22296h);
            if (this.f22294f) {
                canvas.translate(this.f22269A.x, this.f22269A.y);
            }
            if (5 == this.f22272D.f22324a) {
                if (this.f22272D.f22328e) {
                    m23764l();
                    canvas.drawBitmap(this.f22314z, m23740c(0.0f), m23745d(0.0f), this.f22270B);
                } else {
                    this.f22291c = false;
                    this.f22270B.setAlpha((int) (this.f22296h * 0.3f));
                    canvas.drawBitmap(this.f22313y, m23740c(0.0f), m23745d(0.0f), this.f22270B);
                    this.f22270B.setAlpha(this.f22296h);
                    canvas.drawBitmap(this.f22313y, m23740c(this.f22272D.f22325b), m23745d(this.f22272D.f22326c), this.f22270B);
                }
            } else if (3 == this.f22272D.f22324a || 2 == this.f22272D.f22324a) {
                boolean z = Float.compare(this.f22272D.f22330g, 0.0f) != 0;
                if (this.f22293e) {
                    canvas.rotate(90.0f, getCenterX(), getCenterY());
                } else if (z) {
                    canvas.rotate(this.f22272D.f22330g, getCenterX(), getCenterY());
                }
                this.f22270B.setColor(this.f22299k);
                this.f22270B.setAlpha((int) (this.f22296h * 0.55f * (this.f22303o / 255.0f)));
                m23721a(canvas, this.f22308t, this.f22270B);
                if (this.f22293e) {
                    canvas.rotate(-90.0f, getCenterX(), getCenterY());
                } else if (z) {
                    canvas.rotate(-this.f22272D.f22330g, getCenterX(), getCenterY());
                }
                if (3 == this.f22272D.f22324a) {
                    canvas.rotate(90.0f, getCenterX(), getCenterY());
                }
                this.f22270B.setAlpha(this.f22296h);
                if ((!this.f22293e || 3 == this.f22272D.f22324a) && this.f22272D.f22328e) {
                    m23764l();
                    m23720a(canvas, this.f22307s, 0.0f, this.f22312x);
                } else {
                    this.f22291c = false;
                    m23720a(canvas, this.f22307s, this.f22272D.f22329f, this.f22311w);
                }
                if (3 == this.f22272D.f22324a) {
                    canvas.rotate(-90.0f, getCenterX(), getCenterY());
                }
            }
            if (this.f22294f) {
                canvas.translate(-this.f22269A.x, -this.f22269A.y);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23721a(Canvas canvas, Rect rect, Paint paint) {
        canvas.save();
        canvas.drawRect(rect, paint);
        canvas.rotate(180.0f, getCenterX(), getCenterY());
        canvas.drawRect(rect, paint);
        canvas.restore();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23720a(Canvas canvas, Rect rect, float COUIBaseListPopupWindow_12, Bitmap bitmap) {
        canvas.rotate(COUIBaseListPopupWindow_12, getCenterX(), getCenterY());
        canvas.drawBitmap(bitmap, rect.left, rect.top, this.f22270B);
        canvas.rotate(-COUIBaseListPopupWindow_12, getCenterX(), getCenterY());
    }

    private int getCenterX() {
        return (int) (getWidth() / 2.0f);
    }

    private int getCenterY() {
        return (int) (getHeight() / 2.0f);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m23764l() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        IntrinsicsJvm.kt_4 bVar = this.f22287S;
        if (bVar != null && 1000 < jCurrentTimeMillis - this.f22306r) {
            this.f22306r = jCurrentTimeMillis;
            bVar.mo23434a();
        }
        this.f22291c = true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m23740c(float COUIBaseListPopupWindow_12) {
        return (int) (((int) (getCenterX() - (this.f22310v.getIntrinsicWidth() / 2.0f))) + COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int m23745d(float COUIBaseListPopupWindow_12) {
        return (int) (((int) (getCenterY() - (this.f22310v.getIntrinsicHeight() / 2.0f))) - COUIBaseListPopupWindow_12);
    }

    private void getLevelLineRectF() {
        this.f22307s.set(getCenterX() - ((int) (this.f22309u.getIntrinsicWidth() / 2.0f)), getCenterY() - ((int) (this.f22309u.getIntrinsicHeight() / 2.0f)), getCenterX() + ((int) (this.f22309u.getIntrinsicWidth() / 2.0f)), getCenterY() + ((int) (this.f22309u.getIntrinsicHeight() / 2.0f)));
    }

    private void getBaseLineRectF() {
        this.f22308t.set((getCenterX() - ((int) (this.f22309u.getIntrinsicWidth() / 2.0f))) - this.f22301m, getCenterY() - ((int) (this.f22300l / 2.0f)), getCenterX() - ((int) (this.f22309u.getIntrinsicWidth() / 2.0f)), getCenterY() + ((int) (this.f22300l / 2.0f)));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m23732b(float COUIBaseListPopupWindow_12, float f2) {
        if (f2 < COUIBaseListPopupWindow_12) {
            COUIBaseListPopupWindow_12 = f2;
        }
        return (int) ((COUIBaseListPopupWindow_12 / f2) * this.f22295g);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23772a() {
        CameraLog.m12959b("GradienterAssistView", "startDrawGradienter.");
        if (this.f22289a) {
            return;
        }
        this.f22289a = true;
        setVisibility(0);
        Util.m24279a(new Runnable() { // from class: com.oplus.camera.ui.preview.p.8
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12959b("GradienterAssistView", "startDrawGradienter, run register gravitySensor");
                SensorManager sensorManager = (SensorManager) GradienterAssistView.this.getContext().getSystemService("sensor");
                if (sensorManager != null) {
                    sensorManager.registerListener(GradienterAssistView.this.f22288T, sensorManager.getDefaultSensor(9), 1);
                    GradienterAssistView.this.f22290b = true;
                    GradienterAssistView.this.f22296h = 0;
                }
            }
        });
        this.f22298j = Util.m24164A(getContext());
        if (this.f22309u == null) {
            this.f22309u = getResources().getDrawable(R.drawable.ic_level_horizontal_line, null);
        }
        if (this.f22311w == null) {
            this.f22309u.setTint(this.f22299k);
            this.f22311w = Util.m24223a(this.f22309u);
        }
        if (this.f22312x == null) {
            this.f22309u.setTint(this.f22298j);
            this.f22312x = Util.m24223a(this.f22309u);
        }
        if (this.f22310v == null) {
            this.f22310v = getResources().getDrawable(R.drawable.ic_level_cross, null);
        }
        if (this.f22313y == null) {
            this.f22310v.setTint(this.f22299k);
            this.f22313y = Util.m24223a(this.f22310v);
        }
        if (this.f22314z == null) {
            this.f22310v.setTint(this.f22298j);
            this.f22314z = Util.m24223a(this.f22310v);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23773b() {
        CameraLog.m12959b("GradienterAssistView", "stopDrawGradienter.");
        Util.m24279a(new Runnable() { // from class: com.oplus.camera.ui.preview.p.9
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12954a("GradienterAssistView", "stopDrawGradienter, run mbSensorRegistered:" + GradienterAssistView.this.f22290b);
                if (GradienterAssistView.this.f22290b) {
                    SensorManager sensorManager = (SensorManager) GradienterAssistView.this.getContext().getSystemService("sensor");
                    if (sensorManager != null) {
                        sensorManager.unregisterListener(GradienterAssistView.this.f22288T);
                    }
                    GradienterAssistView.this.f22290b = false;
                }
            }
        });
        invalidate();
        this.f22289a = false;
        this.f22296h = 0;
        this.f22297i = 0;
        this.f22271C.m23788b();
        this.f22273E.m23788b();
        setVisibility(4);
        LinkedList<PlatformImplementations.kt_3> linkedList = this.f22286R;
        if (linkedList != null && linkedList.size() > 0) {
            this.f22286R.clear();
        }
        ValueAnimator valueAnimator = this.f22274F;
        if (valueAnimator != null) {
            m23717a((Animator) valueAnimator);
            this.f22274F = null;
        }
        ValueAnimator valueAnimator2 = this.f22275G;
        if (valueAnimator2 != null) {
            m23717a((Animator) valueAnimator2);
            this.f22275G = null;
        }
        ValueAnimator valueAnimator3 = this.f22276H;
        if (valueAnimator3 != null) {
            m23717a((Animator) valueAnimator3);
            this.f22276H = null;
        }
        AnimatorSet animatorSet = this.f22279K;
        if (animatorSet != null) {
            m23717a(animatorSet);
            this.f22279K = null;
        }
        ValueAnimator valueAnimator4 = this.f22277I;
        if (valueAnimator4 != null) {
            m23717a((Animator) valueAnimator4);
            this.f22277I = null;
        }
        ValueAnimator valueAnimator5 = this.f22278J;
        if (valueAnimator5 != null) {
            m23717a((Animator) valueAnimator5);
            this.f22278J = null;
        }
        AnimatorSet animatorSet2 = this.f22280L;
        if (animatorSet2 != null) {
            m23717a(animatorSet2);
            this.f22280L = null;
        }
        Bitmap bitmap = this.f22313y;
        if (bitmap != null) {
            bitmap.recycle();
            this.f22313y = null;
        }
        Bitmap bitmap2 = this.f22314z;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f22314z = null;
        }
        Bitmap bitmap3 = this.f22311w;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.f22311w = null;
        }
        Bitmap bitmap4 = this.f22312x;
        if (bitmap4 != null) {
            bitmap4.recycle();
            this.f22312x = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23717a(Animator animator) {
        if (animator != null) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).removeAllUpdateListeners();
            }
            animator.removeAllListeners();
            if (animator.isRunning() || animator.isStarted()) {
                animator.cancel();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m23774c() {
        return 0 != this.f22305q && 1000 <= System.currentTimeMillis() - this.f22305q;
    }

    public String getOrientation() {
        return (3 == this.f22273E.f22324a || 2 == this.f22273E.f22324a) ? "vertical" : "horizontal";
    }

    /* compiled from: GradienterAssistView.java */
    /* renamed from: com.oplus.camera.ui.preview.p$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private int f22324a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f22325b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f22326c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private long f22327d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private boolean f22328e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private float f22329f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private float f22330g;

        private PlatformImplementations.kt_3() {
            this.f22324a = -1;
            this.f22325b = 0;
            this.f22326c = 0;
            this.f22327d = 0L;
            this.f22328e = false;
            this.f22329f = 0.0f;
            this.f22330g = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m23784a() {
            return -1 == this.f22324a && this.f22325b == 0 && this.f22326c == 0 && Float.compare(this.f22329f, 0.0f) == 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m23788b() {
            this.f22324a = -1;
            this.f22325b = 0;
            this.f22326c = 0;
            this.f22329f = 0.0f;
            this.f22330g = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: OplusGLSurfaceView_15 */
        public void m23799j(PlatformImplementations.kt_3 aVar) {
            this.f22324a = aVar.f22324a;
            this.f22325b = aVar.f22325b;
            this.f22326c = aVar.f22326c;
            this.f22329f = aVar.f22329f;
            this.f22328e = aVar.f22328e;
            this.f22327d = aVar.f22327d;
            this.f22330g = aVar.f22330g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_3 */
        public PlatformImplementations.kt_3 m23791c() {
            PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3();
            aVar.m23799j(this);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m23780a(PlatformImplementations.kt_3 aVar, PlatformImplementations.kt_3 aVar2, float COUIBaseListPopupWindow_12, float f2) {
            this.f22324a = aVar2.f22324a;
            this.f22327d = aVar2.f22327d;
            this.f22325b = (int) (aVar.f22325b + ((aVar2.f22325b - r0) * COUIBaseListPopupWindow_12));
            this.f22326c = (int) (aVar.f22326c + ((aVar2.f22326c - r0) * COUIBaseListPopupWindow_12));
            this.f22328e = aVar2.f22328e && f2 > ((float) Math.abs(this.f22325b - aVar2.f22325b)) && f2 > ((float) Math.abs(this.f22326c - aVar2.f22326c));
            int OplusGLSurfaceView_13 = aVar2.f22324a;
            if (2 == OplusGLSurfaceView_13 || 3 == OplusGLSurfaceView_13) {
                if (aVar2.f22324a != aVar.f22324a) {
                    float f3 = aVar.f22329f;
                    float f4 = f3 > 0.0f ? f3 - 90.0f : f3 + 90.0f;
                    this.f22329f = f4 + (COUIBaseListPopupWindow_12 * (aVar2.f22329f - f4));
                } else {
                    float f5 = aVar.f22329f;
                    this.f22329f = f5 + (COUIBaseListPopupWindow_12 * GradienterAssistView.m23739c(f5, aVar2.f22329f));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m23781a(PlatformImplementations.kt_3 aVar, PlatformImplementations.kt_3 aVar2, PlatformImplementations.kt_3 aVar3) {
            if (aVar == null) {
                aVar = aVar2;
            }
            if (aVar == null) {
                aVar = aVar3;
            }
            if (aVar != null) {
                this.f22330g = aVar.f22330g;
            }
        }

        public String toString() {
            return "attitude={\"mCanvasRotateDegree\": " + this.f22330g + ",\"mIndicatorLeftOffset\": " + this.f22325b + ",\"mIndicatorTopOffset\": " + this.f22326c + ",\"mRectRotateDegrees\": " + this.f22329f + ",\"mTimeStamp\": " + this.f22327d + ",\"mType\": " + this.f22324a + ",\"mbAdjusted\": " + this.f22328e + "\"}";
        }
    }
}
