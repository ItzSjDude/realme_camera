package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.p036h.ViewCompat;

/* compiled from: AutoScrollHelper.java */
/* renamed from: androidx.core.widget.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {

    /* renamed from: r */
    private static final int f3136r = ViewConfiguration.getTapTimeout();

    /* renamed from: IntrinsicsJvm.kt_4 */
    final View f3138b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean f3139c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean f3140d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean f3141e;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Runnable f3143g;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f3146j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f3147k;

    /* renamed from: o */
    private boolean f3151o;

    /* renamed from: p */
    private boolean f3152p;

    /* renamed from: q */
    private boolean f3153q;

    /* renamed from: PlatformImplementations.kt_3 */
    final PlatformImplementations.kt_3 f3137a = new PlatformImplementations.kt_3();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Interpolator f3142f = new AccelerateInterpolator();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float[] f3144h = {0.0f, 0.0f};

    /* renamed from: OplusGLSurfaceView_13 */
    private float[] f3145i = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: OplusGLSurfaceView_14 */
    private float[] f3148l = {0.0f, 0.0f};

    /* renamed from: OplusGLSurfaceView_6 */
    private float[] f3149m = {0.0f, 0.0f};

    /* renamed from: OplusGLSurfaceView_11 */
    private float[] f3150n = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: PlatformImplementations.kt_3 */
    static float m2995a(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return COUIBaseListPopupWindow_12 > f3 ? f3 : COUIBaseListPopupWindow_12 < f2 ? f2 : COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m2998a(int OplusGLSurfaceView_13, int i2, int i3) {
        return OplusGLSurfaceView_13 > i3 ? i3 : OplusGLSurfaceView_13 < i2 ? i2 : OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3005a(int OplusGLSurfaceView_13, int i2);

    /* renamed from: COUIBaseListPopupWindow_8 */
    public abstract boolean mo3015e(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_12 */
    public abstract boolean mo3016f(int OplusGLSurfaceView_13);

    public AutoScrollHelper(View view) {
        this.f3138b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int OplusGLSurfaceView_13 = (int) ((displayMetrics.density * 1575.0f) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        m3002a(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
        float f2 = i2;
        m3007b(f2, f2);
        m3003a(1);
        m3014e(Float.MAX_VALUE, Float.MAX_VALUE);
        m3012d(0.2f, 0.2f);
        m3010c(1.0f, 1.0f);
        m3008b(f3136r);
        m3011c(500);
        m3013d(500);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public AutoScrollHelper m3004a(boolean z) {
        if (this.f3152p && !z) {
            m3000d();
        }
        this.f3152p = z;
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public AutoScrollHelper m3002a(float COUIBaseListPopupWindow_12, float f2) {
        float[] fArr = this.f3150n;
        fArr[0] = COUIBaseListPopupWindow_12 / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AutoScrollHelper m3007b(float COUIBaseListPopupWindow_12, float f2) {
        float[] fArr = this.f3149m;
        fArr[0] = COUIBaseListPopupWindow_12 / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AutoScrollHelper m3010c(float COUIBaseListPopupWindow_12, float f2) {
        float[] fArr = this.f3148l;
        fArr[0] = COUIBaseListPopupWindow_12 / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public AutoScrollHelper m3003a(int OplusGLSurfaceView_13) {
        this.f3146j = OplusGLSurfaceView_13;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AutoScrollHelper m3012d(float COUIBaseListPopupWindow_12, float f2) {
        float[] fArr = this.f3144h;
        fArr[0] = COUIBaseListPopupWindow_12;
        fArr[1] = f2;
        return this;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public AutoScrollHelper m3014e(float COUIBaseListPopupWindow_12, float f2) {
        float[] fArr = this.f3145i;
        fArr[0] = COUIBaseListPopupWindow_12;
        fArr[1] = f2;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AutoScrollHelper m3008b(int OplusGLSurfaceView_13) {
        this.f3147k = OplusGLSurfaceView_13;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AutoScrollHelper m3011c(int OplusGLSurfaceView_13) {
        this.f3137a.m3021a(OplusGLSurfaceView_13);
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AutoScrollHelper m3013d(int OplusGLSurfaceView_13) {
        this.f3137a.m3023b(OplusGLSurfaceView_13);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f3152p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.m3000d()
            goto L58
        L1a:
            r5.f3140d = r2
            r5.f3151o = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f3138b
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.m2997a(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f3138b
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.m2997a(r2, r7, r6, r3)
            androidx.core.widget.PlatformImplementations.kt_3$PlatformImplementations.kt_3 r7 = r5.f3137a
            r7.m3020a(r0, r6)
            boolean r6 = r5.f3141e
            if (r6 != 0) goto L58
            boolean r6 = r5.m3006a()
            if (r6 == 0) goto L58
            r5.m2999c()
        L58:
            boolean r6 = r5.f3153q
            if (r6 == 0) goto L61
            boolean r5 = r5.f3141e
            if (r5 == 0) goto L61
            r1 = r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m3006a() {
        PlatformImplementations.kt_3 aVar = this.f3137a;
        int iM3027f = aVar.m3027f();
        int iM3026e = aVar.m3026e();
        return (iM3027f != 0 && mo3016f(iM3027f)) || (iM3026e != 0 && mo3015e(iM3026e));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m2999c() {
        int OplusGLSurfaceView_13;
        if (this.f3143g == null) {
            this.f3143g = new IntrinsicsJvm.kt_4();
        }
        this.f3141e = true;
        this.f3139c = true;
        if (!this.f3151o && (OplusGLSurfaceView_13 = this.f3147k) > 0) {
            ViewCompat.m2858a(this.f3138b, this.f3143g, OplusGLSurfaceView_13);
        } else {
            this.f3143g.run();
        }
        this.f3151o = true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m3000d() {
        if (this.f3139c) {
            this.f3141e = false;
        } else {
            this.f3137a.m3022b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m2997a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, float f2, float f3) {
        float fM2996a = m2996a(this.f3144h[OplusGLSurfaceView_13], f2, this.f3145i[OplusGLSurfaceView_13], COUIBaseListPopupWindow_12);
        if (fM2996a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f3148l[OplusGLSurfaceView_13];
        float f5 = this.f3149m[OplusGLSurfaceView_13];
        float f6 = this.f3150n[OplusGLSurfaceView_13];
        float f7 = f4 * f3;
        if (fM2996a > 0.0f) {
            return m2995a(fM2996a * f7, f5, f6);
        }
        return -m2995a((-fM2996a) * f7, f5, f6);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m2996a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        float interpolation;
        float fM2995a = m2995a(COUIBaseListPopupWindow_12 * f2, 0.0f, f3);
        float fM3001f = m3001f(f2 - f4, fM2995a) - m3001f(f4, fM2995a);
        if (fM3001f < 0.0f) {
            interpolation = -this.f3142f.getInterpolation(-fM3001f);
        } else {
            if (fM3001f <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f3142f.getInterpolation(fM3001f);
        }
        return m2995a(interpolation, -1.0f, 1.0f);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float m3001f(float COUIBaseListPopupWindow_12, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int OplusGLSurfaceView_13 = this.f3146j;
        if (OplusGLSurfaceView_13 == 0 || OplusGLSurfaceView_13 == 1) {
            if (COUIBaseListPopupWindow_12 < f2) {
                if (COUIBaseListPopupWindow_12 >= 0.0f) {
                    return 1.0f - (COUIBaseListPopupWindow_12 / f2);
                }
                if (this.f3141e && this.f3146j == 1) {
                    return 1.0f;
                }
            }
        } else if (OplusGLSurfaceView_13 == 2 && COUIBaseListPopupWindow_12 < 0.0f) {
            return COUIBaseListPopupWindow_12 / (-f2);
        }
        return 0.0f;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m3009b() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f3138b.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: androidx.core.widget.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements Runnable {
        IntrinsicsJvm.kt_4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AutoScrollHelper.this.f3141e) {
                if (AutoScrollHelper.this.f3139c) {
                    AutoScrollHelper abstractViewOnTouchListenerC0521a = AutoScrollHelper.this;
                    abstractViewOnTouchListenerC0521a.f3139c = false;
                    abstractViewOnTouchListenerC0521a.f3137a.m3019a();
                }
                PlatformImplementations.kt_3 aVar = AutoScrollHelper.this.f3137a;
                if (aVar.m3024c() || !AutoScrollHelper.this.m3006a()) {
                    AutoScrollHelper.this.f3141e = false;
                    return;
                }
                if (AutoScrollHelper.this.f3140d) {
                    AutoScrollHelper abstractViewOnTouchListenerC0521a2 = AutoScrollHelper.this;
                    abstractViewOnTouchListenerC0521a2.f3140d = false;
                    abstractViewOnTouchListenerC0521a2.m3009b();
                }
                aVar.m3025d();
                AutoScrollHelper.this.mo3005a(aVar.m3028g(), aVar.m3029h());
                ViewCompat.m2857a(AutoScrollHelper.this.f3138b, this);
            }
        }
    }

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: androidx.core.widget.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private int f3154a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f3155b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private float f3156c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private float f3157d;

        /* renamed from: OplusGLSurfaceView_15 */
        private float f3163j;

        /* renamed from: OplusGLSurfaceView_5 */
        private int f3164k;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private long f3158e = Long.MIN_VALUE;

        /* renamed from: OplusGLSurfaceView_13 */
        private long f3162i = -1;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private long f3159f = 0;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private int f3160g = 0;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private int f3161h = 0;

        /* renamed from: PlatformImplementations.kt_3 */
        private float m3017a(float COUIBaseListPopupWindow_12) {
            return ((-4.0f) * COUIBaseListPopupWindow_12 * COUIBaseListPopupWindow_12) + (COUIBaseListPopupWindow_12 * 4.0f);
        }

        PlatformImplementations.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m3021a(int OplusGLSurfaceView_13) {
            this.f3154a = OplusGLSurfaceView_13;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m3023b(int OplusGLSurfaceView_13) {
            this.f3155b = OplusGLSurfaceView_13;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m3019a() {
            this.f3158e = AnimationUtils.currentAnimationTimeMillis();
            this.f3162i = -1L;
            this.f3159f = this.f3158e;
            this.f3163j = 0.5f;
            this.f3160g = 0;
            this.f3161h = 0;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m3022b() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f3164k = AutoScrollHelper.m2998a((int) (jCurrentAnimationTimeMillis - this.f3158e), 0, this.f3155b);
            this.f3163j = m3018a(jCurrentAnimationTimeMillis);
            this.f3162i = jCurrentAnimationTimeMillis;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean m3024c() {
            return this.f3162i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f3162i + ((long) this.f3164k);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private float m3018a(long OplusGLSurfaceView_15) {
            if (OplusGLSurfaceView_15 < this.f3158e) {
                return 0.0f;
            }
            long j2 = this.f3162i;
            if (j2 < 0 || OplusGLSurfaceView_15 < j2) {
                return AutoScrollHelper.m2995a((OplusGLSurfaceView_15 - this.f3158e) / this.f3154a, 0.0f, 1.0f) * 0.5f;
            }
            long j3 = OplusGLSurfaceView_15 - j2;
            float COUIBaseListPopupWindow_12 = this.f3163j;
            return (1.0f - COUIBaseListPopupWindow_12) + (COUIBaseListPopupWindow_12 * AutoScrollHelper.m2995a(j3 / this.f3164k, 0.0f, 1.0f));
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void m3025d() {
            if (this.f3159f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fM3017a = m3017a(m3018a(jCurrentAnimationTimeMillis));
            long OplusGLSurfaceView_15 = jCurrentAnimationTimeMillis - this.f3159f;
            this.f3159f = jCurrentAnimationTimeMillis;
            float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_15 * fM3017a;
            this.f3160g = (int) (this.f3156c * COUIBaseListPopupWindow_12);
            this.f3161h = (int) (COUIBaseListPopupWindow_12 * this.f3157d);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m3020a(float COUIBaseListPopupWindow_12, float f2) {
            this.f3156c = COUIBaseListPopupWindow_12;
            this.f3157d = f2;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int m3026e() {
            float COUIBaseListPopupWindow_12 = this.f3156c;
            return (int) (COUIBaseListPopupWindow_12 / Math.abs(COUIBaseListPopupWindow_12));
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int m3027f() {
            float COUIBaseListPopupWindow_12 = this.f3157d;
            return (int) (COUIBaseListPopupWindow_12 / Math.abs(COUIBaseListPopupWindow_12));
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        public int m3028g() {
            return this.f3160g;
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public int m3029h() {
            return this.f3161h;
        }
    }
}
