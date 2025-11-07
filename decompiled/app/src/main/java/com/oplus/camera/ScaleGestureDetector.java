package com.oplus.camera;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: ScaleGestureDetector.java */
/* renamed from: com.oplus.camera.ab */
/* loaded from: classes2.dex */
public class ScaleGestureDetector {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f12192a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PlatformImplementations.kt_3 f12193b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float f12194c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float f12195d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f12196e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f12197f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f12198g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f12199h;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f12200i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f12201j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f12202k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f12203l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f12204m;

    /* renamed from: OplusGLSurfaceView_11 */
    private long f12205n;

    /* renamed from: o */
    private long f12206o;

    /* renamed from: p */
    private boolean f12207p;

    /* renamed from: q */
    private int f12208q;

    /* renamed from: r */
    private int f12209r;

    /* renamed from: s */
    private final Handler f12210s;

    /* renamed from: t */
    private float f12211t;

    /* renamed from: u */
    private float f12212u;

    /* renamed from: v */
    private int f12213v;

    /* renamed from: w */
    private GestureDetector f12214w;

    /* renamed from: x */
    private boolean f12215x;

    /* compiled from: ScaleGestureDetector.java */
    /* renamed from: com.oplus.camera.ab$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo11244a(ScaleGestureDetector c2610ab);

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo11245b(ScaleGestureDetector c2610ab);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo11246c(ScaleGestureDetector c2610ab);
    }

    public ScaleGestureDetector(Context context, PlatformImplementations.kt_3 aVar) {
        this(context, aVar, null);
    }

    public ScaleGestureDetector(Context context, PlatformImplementations.kt_3 aVar, Handler handler) {
        this.f12213v = 0;
        this.f12192a = context;
        this.f12193b = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f12208q = viewConfiguration.getScaledTouchSlop() / 3;
        this.f12209r = viewConfiguration.getScaledMinimumScalingSpan() / 3;
        this.f12210s = handler;
        int OplusGLSurfaceView_13 = context.getApplicationInfo().targetSdkVersion;
        if (OplusGLSurfaceView_13 > 18) {
            m11236a(true);
        }
        if (OplusGLSurfaceView_13 > 22) {
            m11240b(true);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11238a(MotionEvent motionEvent) {
        float COUIBaseListPopupWindow_12;
        float f2;
        this.f12205n = motionEvent.getEventTime();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f12196e) {
            this.f12214w.onTouchEvent(motionEvent);
        }
        int pointerCount = motionEvent.getPointerCount();
        boolean z = (motionEvent.getButtonState() & 32) != 0;
        boolean z2 = this.f12213v == 2 && !z;
        boolean z3 = actionMasked == 1 || actionMasked == 3 || z2;
        if (actionMasked == 0 || z3) {
            if (this.f12207p) {
                this.f12193b.mo11246c(this);
                m11234c(false);
                this.f12200i = 0.0f;
                this.f12213v = 0;
            } else if (m11235f() && z3) {
                m11234c(false);
                this.f12200i = 0.0f;
                this.f12213v = 0;
            }
            if (z3) {
                return true;
            }
        }
        if (!this.f12207p && this.f12197f && !m11235f() && !z3 && z) {
            this.f12211t = motionEvent.getX();
            this.f12212u = motionEvent.getY();
            this.f12213v = 2;
            this.f12200i = 0.0f;
        }
        boolean z4 = actionMasked == 0 || actionMasked == 6 || actionMasked == 5 || z2;
        boolean z5 = actionMasked == 6;
        int actionIndex = z5 ? motionEvent.getActionIndex() : -1;
        int OplusGLSurfaceView_13 = z5 ? pointerCount - 1 : pointerCount;
        if (m11235f()) {
            f2 = this.f12211t;
            COUIBaseListPopupWindow_12 = this.f12212u;
            if (motionEvent.getY() < COUIBaseListPopupWindow_12) {
                this.f12215x = true;
            } else {
                this.f12215x = false;
            }
        } else {
            float x = 0.0f;
            float y = 0.0f;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (actionIndex != i2) {
                    x += motionEvent.getX(i2);
                    y += motionEvent.getY(i2);
                }
            }
            float f3 = OplusGLSurfaceView_13;
            float f4 = x / f3;
            COUIBaseListPopupWindow_12 = y / f3;
            f2 = f4;
        }
        float fAbs = 0.0f;
        float fAbs2 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (actionIndex != i3) {
                fAbs += Math.abs(motionEvent.getX(i3) - f2);
                fAbs2 += Math.abs(motionEvent.getY(i3) - COUIBaseListPopupWindow_12);
            }
        }
        float f5 = OplusGLSurfaceView_13;
        float f6 = (fAbs / f5) * 2.0f;
        float f7 = (fAbs2 / f5) * 2.0f;
        float fHypot = m11235f() ? f7 : (float) Math.hypot(f6, f7);
        boolean z6 = this.f12207p;
        this.f12194c = f2;
        this.f12195d = COUIBaseListPopupWindow_12;
        if (!m11235f() && this.f12207p && (fHypot < this.f12209r || z4)) {
            this.f12193b.mo11246c(this);
            m11234c(false);
            this.f12200i = fHypot;
        }
        if (z4) {
            this.f12201j = f6;
            this.f12203l = f6;
            this.f12202k = f7;
            this.f12204m = f7;
            this.f12198g = fHypot;
            this.f12199h = fHypot;
            this.f12200i = fHypot;
        }
        int i4 = m11235f() ? this.f12208q : this.f12209r;
        if (!this.f12207p && fHypot >= i4 && (z6 || Math.abs(fHypot - this.f12200i) > this.f12208q)) {
            this.f12201j = f6;
            this.f12203l = f6;
            this.f12202k = f7;
            this.f12204m = f7;
            this.f12198g = fHypot;
            this.f12199h = fHypot;
            this.f12206o = this.f12205n;
            m11234c(this.f12193b.mo11245b(this));
        }
        if (actionMasked == 2) {
            this.f12201j = f6;
            this.f12202k = f7;
            this.f12198g = fHypot;
            if (this.f12207p ? this.f12193b.mo11244a(this) : true) {
                this.f12203l = this.f12201j;
                this.f12204m = this.f12202k;
                this.f12199h = this.f12198g;
                this.f12206o = this.f12205n;
            }
        }
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m11235f() {
        return this.f12213v != 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11236a(boolean z) {
        this.f12196e = z;
        if (this.f12196e && this.f12214w == null) {
            this.f12214w = new GestureDetector(this.f12192a, new GestureDetector.SimpleOnGestureListener() { // from class: com.oplus.camera.ab.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    ScaleGestureDetector.this.f12211t = motionEvent.getX();
                    ScaleGestureDetector.this.f12212u = motionEvent.getY();
                    ScaleGestureDetector.this.f12213v = 1;
                    return true;
                }
            }, this.f12210s);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11240b(boolean z) {
        this.f12197f = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11237a() {
        return this.f12207p;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m11239b() {
        return this.f12198g;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public float m11241c() {
        return this.f12200i;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float m11242d() {
        if (m11235f()) {
            boolean z = (this.f12215x && this.f12198g < this.f12199h) || (!this.f12215x && this.f12198g > this.f12199h);
            float fAbs = Math.abs(1.0f - (this.f12198g / this.f12199h)) * 0.5f;
            if (this.f12199h <= this.f12208q) {
                return 1.0f;
            }
            return z ? 1.0f + fAbs : 1.0f - fAbs;
        }
        float COUIBaseListPopupWindow_12 = this.f12199h;
        if (COUIBaseListPopupWindow_12 > 0.0f) {
            return this.f12198g / COUIBaseListPopupWindow_12;
        }
        return 1.0f;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m11234c(boolean z) {
        CameraLog.m12954a("ScaleGestureDetector", "setInProgress: " + this.f12207p + " --> " + z);
        this.f12207p = z;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m11243e() {
        CameraLog.m12954a("ScaleGestureDetector", "forceStopScaleProgress");
        PlatformImplementations.kt_3 aVar = this.f12193b;
        if (aVar != null && this.f12207p) {
            aVar.mo11246c(this);
        }
        m11234c(false);
    }
}
