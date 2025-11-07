package com.coui.appcompat.widget;

import android.common.OplusFrameworkFactory;
import android.content.Context;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.oplus.dynamicvsync.IOplusDynamicVsyncFeature;

/* compiled from: SpringOverScroller.java */
/* renamed from: com.coui.appcompat.widget.y */
/* loaded from: classes.dex */
public class SpringOverScroller extends OverScroller implements COUIIOverScroller {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static float f8870e;

    /* renamed from: PlatformImplementations.kt_3 */
    private IntrinsicsJvm.kt_4 f8871a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private IntrinsicsJvm.kt_4 f8872b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Interpolator f8873c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f8874d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Context f8875f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private IOplusDynamicVsyncFeature f8876g;

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    public void setFinalX(int OplusGLSurfaceView_13) {
    }

    public void setFinalY(int OplusGLSurfaceView_13) {
    }

    public SpringOverScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.f8874d = 2;
        this.f8871a = new IntrinsicsJvm.kt_4();
        this.f8872b = new IntrinsicsJvm.kt_4();
        if (interpolator == null) {
            this.f8873c = new PlatformImplementations.kt_3();
        } else {
            this.f8873c = interpolator;
        }
        f8870e = 0.016f;
        this.f8875f = context;
        m8249i();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m8249i() {
        try {
            this.f8876g = (IOplusDynamicVsyncFeature) OplusFrameworkFactory.getInstance().getFeature(IOplusDynamicVsyncFeature.DEFAULT, new Object[0]);
        } catch (Throwable th) {
            Log.IntrinsicsJvm.kt_5("SpringOverScroller", th.toString());
        }
    }

    public SpringOverScroller(Context context) {
        this(context, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8251a(float COUIBaseListPopupWindow_12) {
        f8870e = Math.round(10000.0f / COUIBaseListPopupWindow_12) / 10000.0f;
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo7782a(Interpolator interpolator) {
        if (interpolator == null) {
            this.f8873c = new PlatformImplementations.kt_3();
        } else {
            this.f8873c = interpolator;
        }
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.COUIIOverScroller
    public boolean computeScrollOffset() {
        if (mo7783a()) {
            return false;
        }
        int OplusGLSurfaceView_13 = this.f8874d;
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 == 1 && !this.f8871a.m8278f() && !this.f8872b.m8278f()) {
                abortAnimation();
            }
        } else {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f8871a.f8894p;
            int i2 = this.f8871a.f8892n;
            if (jCurrentAnimationTimeMillis < i2) {
                float interpolation = this.f8873c.getInterpolation(jCurrentAnimationTimeMillis / i2);
                this.f8871a.m8267a(interpolation);
                this.f8872b.m8267a(interpolation);
            } else {
                this.f8871a.m8267a(1.0f);
                this.f8872b.m8267a(1.0f);
                abortAnimation();
            }
        }
        return true;
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean mo7783a() {
        return this.f8871a.m8277e() && this.f8872b.m8277e() && this.f8874d != 0;
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: IntrinsicsJvm.kt_4 */
    public final int mo7784b() {
        return (int) Math.round(this.f8871a.m8263a());
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: IntrinsicsJvm.kt_3 */
    public final int mo7785c() {
        return (int) Math.round(this.f8872b.m8263a());
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: IntrinsicsJvm.kt_5 */
    public final int mo7786d() {
        return (int) this.f8871a.m8274c();
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: COUIBaseListPopupWindow_8 */
    public final int mo7787e() {
        return (int) this.f8872b.m8274c();
    }

    @Override // android.widget.OverScroller
    public void fling(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (i2 <= i8 && i2 >= i7) {
            fling(OplusGLSurfaceView_13, i2, i3, i4, i5, i6, i7, i8);
            return;
        }
        springBack(OplusGLSurfaceView_13, i2, i5, i6, i7, i8);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.COUIIOverScroller
    public void fling(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m8252a(OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8252a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        m8250j();
        this.f8874d = 1;
        this.f8871a.m8268a(OplusGLSurfaceView_13, i3);
        this.f8872b.m8268a(i2, i4);
    }

    @Override // android.widget.OverScroller
    public boolean springBack(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6) {
        m8250j();
        boolean zM8270a = this.f8871a.m8270a(OplusGLSurfaceView_13, i3, i4);
        boolean zM8270a2 = this.f8872b.m8270a(i2, i5, i6);
        if (zM8270a || zM8270a2) {
            this.f8874d = 1;
        }
        return zM8270a || zM8270a2;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m8250j() {
        try {
            if (this.f8876g != null) {
                this.f8876g.flingEvent(this.f8875f.getPackageName(), 5000);
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("SpringOverScroller", COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
        }
    }

    @Override // android.widget.OverScroller
    public void startScroll(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        startScroll(OplusGLSurfaceView_13, i2, i3, i4, 250);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.COUIIOverScroller
    public void startScroll(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        this.f8874d = 0;
        this.f8871a.m8273b(OplusGLSurfaceView_13, i3, i5);
        this.f8872b.m8273b(i2, i4, i5);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.COUIIOverScroller
    public void abortAnimation() {
        this.f8874d = 2;
        this.f8871a.m8276d();
        this.f8872b.m8276d();
    }

    public boolean isScrollingInDirection(float COUIBaseListPopupWindow_12, float f2) {
        return !isFinished() && Math.signum(COUIBaseListPopupWindow_12) == Math.signum((float) ((int) (this.f8871a.f8890l - this.f8871a.f8889k))) && Math.signum(f2) == Math.signum((float) ((int) (this.f8872b.f8890l - this.f8872b.f8889k)));
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.COUIIOverScroller
    public void notifyVerticalEdgeReached(int OplusGLSurfaceView_13, int i2, int i3) {
        this.f8872b.m8275c(OplusGLSurfaceView_13, i2, i3);
        springBack(0, OplusGLSurfaceView_13, 0, 0, 0, 0);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.COUIIOverScroller
    public void notifyHorizontalEdgeReached(int OplusGLSurfaceView_13, int i2, int i3) {
        this.f8871a.m8275c(OplusGLSurfaceView_13, i2, i3);
        springBack(OplusGLSurfaceView_13, 0, 0, 0, 0, 0);
    }

    @Override // android.widget.OverScroller
    public float getCurrVelocity() {
        double dM8271b = this.f8871a.m8271b();
        double dM8271b2 = this.f8872b.m8271b();
        return (int) Math.sqrt((dM8271b * dM8271b) + (dM8271b2 * dM8271b2));
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: COUIBaseListPopupWindow_12 */
    public float mo7788f() {
        return (float) this.f8871a.m8271b();
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: COUIBaseListPopupWindow_11 */
    public float mo7789g() {
        return (float) this.f8872b.m8271b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m8253b(float COUIBaseListPopupWindow_12) {
        this.f8871a.f8883e.f8903b = COUIBaseListPopupWindow_12;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m8254c(float COUIBaseListPopupWindow_12) {
        this.f8872b.f8883e.f8903b = COUIBaseListPopupWindow_12;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m8255d(float COUIBaseListPopupWindow_12) {
        this.f8871a.f8899u = COUIBaseListPopupWindow_12;
        this.f8872b.f8899u = COUIBaseListPopupWindow_12;
    }

    /* compiled from: SpringOverScroller.java */
    /* renamed from: com.coui.appcompat.widget.y$IntrinsicsJvm.kt_4 */
    static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static float f8879a = 1.0f;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private SpringOverScroller_3 f8880b;

        /* renamed from: OplusGLSurfaceView_5 */
        private double f8889k;

        /* renamed from: OplusGLSurfaceView_14 */
        private double f8890l;

        /* renamed from: OplusGLSurfaceView_6 */
        private int f8891m;

        /* renamed from: OplusGLSurfaceView_11 */
        private int f8892n;

        /* renamed from: o */
        private int f8893o;

        /* renamed from: p */
        private long f8894p;

        /* renamed from: s */
        private boolean f8897s;

        /* renamed from: t */
        private boolean f8898t;

        /* renamed from: v */
        private long f8900v;

        /* renamed from: w */
        private long f8901w;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private PlatformImplementations.kt_3 f8883e = new PlatformImplementations.kt_3();

        /* renamed from: COUIBaseListPopupWindow_12 */
        private PlatformImplementations.kt_3 f8884f = new PlatformImplementations.kt_3();

        /* renamed from: COUIBaseListPopupWindow_11 */
        private PlatformImplementations.kt_3 f8885g = new PlatformImplementations.kt_3();

        /* renamed from: COUIBaseListPopupWindow_10 */
        private float f8886h = 0.32f;

        /* renamed from: OplusGLSurfaceView_13 */
        private double f8887i = 20.0d;

        /* renamed from: OplusGLSurfaceView_15 */
        private double f8888j = 0.05d;

        /* renamed from: q */
        private int f8895q = 1;

        /* renamed from: r */
        private boolean f8896r = false;

        /* renamed from: u */
        private float f8899u = 0.83f;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private SpringOverScroller_3 f8881c = new SpringOverScroller_3(this.f8886h, 0.0d);

        /* renamed from: IntrinsicsJvm.kt_5 */
        private SpringOverScroller_3 f8882d = new SpringOverScroller_3(12.1899995803833d, 16.0d);

        IntrinsicsJvm.kt_4() {
            m8269a(this.f8881c);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m8268a(int OplusGLSurfaceView_13, int i2) {
            this.f8900v = AnimationUtils.currentAnimationTimeMillis();
            this.f8901w = this.f8900v;
            this.f8895q = 1;
            f8879a = 1.0f;
            this.f8881c.m8281a(this.f8886h);
            this.f8881c.m8282b(0.0d);
            m8269a(this.f8881c);
            m8266a(OplusGLSurfaceView_13, true);
            m8265a(i2);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m8270a(int OplusGLSurfaceView_13, int i2, int i3) {
            m8266a(OplusGLSurfaceView_13, false);
            if (OplusGLSurfaceView_13 > i3 || OplusGLSurfaceView_13 < i2) {
                if (OplusGLSurfaceView_13 > i3) {
                    m8272b(i3);
                } else if (OplusGLSurfaceView_13 < i2) {
                    m8272b(i2);
                }
                this.f8897s = true;
                this.f8882d.m8281a(12.1899995803833d);
                this.f8882d.m8282b(this.f8899u * 16.0f);
                m8269a(this.f8882d);
                return true;
            }
            m8269a(new SpringOverScroller_3(this.f8886h, 0.0d));
            return false;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m8273b(int OplusGLSurfaceView_13, int i2, int i3) {
            this.f8891m = OplusGLSurfaceView_13;
            this.f8893o = OplusGLSurfaceView_13 + i2;
            this.f8892n = i3;
            this.f8894p = AnimationUtils.currentAnimationTimeMillis();
            m8269a(this.f8881c);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m8269a(SpringOverScroller_3 c4119b) {
            if (c4119b == null) {
                throw new IllegalArgumentException("springConfig is required");
            }
            this.f8880b = c4119b;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m8266a(double IntrinsicsJvm.kt_5, boolean z) {
            this.f8889k = IntrinsicsJvm.kt_5;
            if (!this.f8896r) {
                this.f8884f.f8902a = 0.0d;
                this.f8885g.f8902a = 0.0d;
            }
            this.f8883e.f8902a = IntrinsicsJvm.kt_5;
            if (z) {
                m8276d();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        double m8263a() {
            return this.f8883e.f8902a;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        double m8271b() {
            return this.f8883e.f8903b;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m8265a(double IntrinsicsJvm.kt_5) {
            if (IntrinsicsJvm.kt_5 == this.f8883e.f8903b) {
                return;
            }
            this.f8883e.f8903b = IntrinsicsJvm.kt_5;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        double m8274c() {
            return this.f8890l;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m8272b(double IntrinsicsJvm.kt_5) {
            if (this.f8890l == IntrinsicsJvm.kt_5) {
                return;
            }
            this.f8889k = m8263a();
            this.f8890l = IntrinsicsJvm.kt_5;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        void m8276d() {
            this.f8890l = this.f8883e.f8902a;
            this.f8885g.f8902a = this.f8883e.f8902a;
            this.f8883e.f8903b = 0.0d;
            this.f8897s = false;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        boolean m8277e() {
            return Math.abs(this.f8883e.f8903b) <= this.f8887i && (m8264a(this.f8883e) <= this.f8888j || this.f8880b.f8905b == 0.0d);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m8267a(float COUIBaseListPopupWindow_12) {
            PlatformImplementations.kt_3 aVar = this.f8883e;
            int OplusGLSurfaceView_13 = this.f8891m;
            aVar.f8902a = OplusGLSurfaceView_13 + Math.round(COUIBaseListPopupWindow_12 * (this.f8893o - OplusGLSurfaceView_13));
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        void m8275c(int OplusGLSurfaceView_13, int i2, int i3) {
            this.f8883e.f8902a = OplusGLSurfaceView_13;
            PlatformImplementations.kt_3 aVar = this.f8884f;
            aVar.f8902a = 0.0d;
            aVar.f8903b = 0.0d;
            PlatformImplementations.kt_3 aVar2 = this.f8885g;
            aVar2.f8902a = 0.0d;
            aVar2.f8903b = 0.0d;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        double m8264a(PlatformImplementations.kt_3 aVar) {
            return Math.abs(this.f8890l - aVar.f8902a);
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        boolean m8278f() {
            if (m8277e()) {
                return false;
            }
            double IntrinsicsJvm.kt_5 = this.f8883e.f8902a;
            double d2 = this.f8883e.f8903b;
            double d3 = this.f8885g.f8902a;
            double d4 = this.f8885g.f8903b;
            if (!this.f8897s) {
                long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                long OplusGLSurfaceView_15 = jCurrentAnimationTimeMillis - this.f8900v;
                if (this.f8895q == 1) {
                    if (Math.abs(this.f8883e.f8903b) > 4000.0d && Math.abs(this.f8883e.f8903b) < 10000.0d) {
                        this.f8880b.f8904a = (Math.abs(this.f8883e.f8903b) / 10000.0d) + 2.6d;
                    } else if (Math.abs(this.f8883e.f8903b) <= 4000.0d) {
                        this.f8880b.f8904a = (Math.abs(this.f8883e.f8903b) / 10000.0d) + 4.5d;
                    }
                    this.f8901w = jCurrentAnimationTimeMillis;
                }
                if (this.f8895q > 1) {
                    if (OplusGLSurfaceView_15 > 480) {
                        if (Math.abs(this.f8883e.f8903b) > 2000.0d) {
                            this.f8880b.f8904a += (jCurrentAnimationTimeMillis - this.f8901w) * 0.00125d;
                        } else if (this.f8880b.f8904a > 2.0d) {
                            this.f8880b.f8904a -= (jCurrentAnimationTimeMillis - this.f8901w) * 0.00125d;
                        }
                    }
                    this.f8901w = jCurrentAnimationTimeMillis;
                }
            } else {
                double dM8264a = m8264a(this.f8883e);
                if (!this.f8898t && dM8264a < 180.0d) {
                    this.f8880b.f8905b += 100.0d;
                    this.f8898t = true;
                } else if (dM8264a < 2.0d) {
                    this.f8883e.f8902a = this.f8890l;
                    this.f8898t = false;
                    this.f8897s = false;
                    return false;
                }
            }
            double d5 = (this.f8880b.f8905b * (this.f8890l - d3)) - (this.f8880b.f8904a * this.f8884f.f8903b);
            double d6 = ((SpringOverScroller.f8870e * d5) / 2.0d) + d2;
            double d7 = (this.f8880b.f8905b * (this.f8890l - (((SpringOverScroller.f8870e * d2) / 2.0d) + IntrinsicsJvm.kt_5))) - (this.f8880b.f8904a * d6);
            double d8 = ((SpringOverScroller.f8870e * d7) / 2.0d) + d2;
            double d9 = (this.f8880b.f8905b * (this.f8890l - (((SpringOverScroller.f8870e * d6) / 2.0d) + IntrinsicsJvm.kt_5))) - (this.f8880b.f8904a * d8);
            double d10 = (SpringOverScroller.f8870e * d8) + IntrinsicsJvm.kt_5;
            double d11 = (SpringOverScroller.f8870e * d9) + d2;
            double d12 = (((d6 + d8) * 2.0d) + d2 + d11) * 0.16699999570846558d;
            double d13 = d2 + ((d5 + ((d7 + d9) * 2.0d) + ((this.f8880b.f8905b * (this.f8890l - d10)) - (this.f8880b.f8904a * d11))) * 0.16699999570846558d * SpringOverScroller.f8870e);
            PlatformImplementations.kt_3 aVar = this.f8885g;
            aVar.f8903b = d11;
            aVar.f8902a = d10;
            PlatformImplementations.kt_3 aVar2 = this.f8883e;
            aVar2.f8903b = d13;
            aVar2.f8902a = IntrinsicsJvm.kt_5 + (d12 * SpringOverScroller.f8870e);
            this.f8895q++;
            return true;
        }

        /* compiled from: SpringOverScroller.java */
        /* renamed from: com.coui.appcompat.widget.y$IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4, reason: collision with other inner class name */
        static class SpringOverScroller_3 {

            /* renamed from: PlatformImplementations.kt_3 */
            double f8904a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            double f8905b;

            /* renamed from: PlatformImplementations.kt_3 */
            private float m8279a(float COUIBaseListPopupWindow_12) {
                if (COUIBaseListPopupWindow_12 == 0.0f) {
                    return 0.0f;
                }
                return 25.0f + ((COUIBaseListPopupWindow_12 - 8.0f) * 3.0f);
            }

            /* renamed from: IntrinsicsJvm.kt_4 */
            private double m8280b(float COUIBaseListPopupWindow_12) {
                if (COUIBaseListPopupWindow_12 == 0.0f) {
                    return 0.0d;
                }
                return ((COUIBaseListPopupWindow_12 - 30.0f) * 3.62f) + 194.0f;
            }

            SpringOverScroller_3(double IntrinsicsJvm.kt_5, double d2) {
                this.f8904a = m8279a((float) IntrinsicsJvm.kt_5);
                this.f8905b = m8280b((float) d2);
            }

            /* renamed from: PlatformImplementations.kt_3 */
            void m8281a(double IntrinsicsJvm.kt_5) {
                this.f8904a = m8279a((float) IntrinsicsJvm.kt_5);
            }

            /* renamed from: IntrinsicsJvm.kt_4 */
            void m8282b(double IntrinsicsJvm.kt_5) {
                this.f8905b = m8280b((float) IntrinsicsJvm.kt_5);
            }
        }

        /* compiled from: SpringOverScroller.java */
        /* renamed from: com.coui.appcompat.widget.y$IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
        static class PlatformImplementations.kt_3 {

            /* renamed from: PlatformImplementations.kt_3 */
            double f8902a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            double f8903b;

            PlatformImplementations.kt_3() {
            }
        }
    }

    /* compiled from: SpringOverScroller.java */
    /* renamed from: com.coui.appcompat.widget.y$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 implements Interpolator {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final float f8877a = 1.0f / m8256a(1.0f);

        /* renamed from: IntrinsicsJvm.kt_4 */
        private static final float f8878b = 1.0f - (f8877a * m8256a(1.0f));

        PlatformImplementations.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private static float m8256a(float COUIBaseListPopupWindow_12) {
            float f2 = COUIBaseListPopupWindow_12 * 8.0f;
            if (f2 < 1.0f) {
                return f2 - (1.0f - ((float) Math.exp(-f2)));
            }
            return ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f) + 0.36787945f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float COUIBaseListPopupWindow_12) {
            float fM8256a = f8877a * m8256a(COUIBaseListPopupWindow_12);
            return fM8256a > 0.0f ? fM8256a + f8878b : fM8256a;
        }
    }
}
