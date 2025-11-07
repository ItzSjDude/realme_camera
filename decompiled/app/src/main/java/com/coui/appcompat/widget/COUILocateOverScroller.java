package com.coui.appcompat.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* compiled from: COUILocateOverScroller.java */
/* renamed from: com.coui.appcompat.widget.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public class COUILocateOverScroller extends OverScroller implements COUIIOverScroller {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final Interpolator f8124d = new Interpolator() { // from class: com.coui.appcompat.widget.OplusGLSurfaceView_15.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float COUIBaseListPopupWindow_12) {
            float f2 = COUIBaseListPopupWindow_12 - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    private PlatformImplementations.kt_3 f8125a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PlatformImplementations.kt_3 f8126b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Interpolator f8127c;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f8128e;

    public COUILocateOverScroller(Context context) {
        this(context, null);
    }

    public COUILocateOverScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.f8125a = new PlatformImplementations.kt_3(context);
        this.f8126b = new PlatformImplementations.kt_3(context);
        if (interpolator == null) {
            this.f8127c = f8124d;
        } else {
            this.f8127c = interpolator;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7799a(float COUIBaseListPopupWindow_12) {
        this.f8125a.m7819a(COUIBaseListPopupWindow_12);
        this.f8126b.m7819a(COUIBaseListPopupWindow_12);
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo7782a(Interpolator interpolator) {
        if (interpolator == null) {
            this.f8127c = f8124d;
        } else {
            this.f8127c = interpolator;
        }
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.COUIIOverScroller
    public boolean computeScrollOffset() {
        if (mo7783a()) {
            return false;
        }
        int OplusGLSurfaceView_13 = this.f8128e;
        if (OplusGLSurfaceView_13 == 0) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f8125a.f8138g;
            int i2 = this.f8125a.f8139h;
            if (jCurrentAnimationTimeMillis < i2) {
                float interpolation = this.f8127c.getInterpolation(jCurrentAnimationTimeMillis / i2);
                this.f8125a.m7823b(interpolation);
                this.f8126b.m7823b(interpolation);
            } else {
                abortAnimation();
            }
        } else if (OplusGLSurfaceView_13 == 1) {
            if (!this.f8125a.f8142k && !this.f8125a.m7827c() && !this.f8125a.m7824b()) {
                this.f8125a.m7818a();
            }
            if (!this.f8126b.f8142k && !this.f8126b.m7827c() && !this.f8126b.m7824b()) {
                this.f8126b.m7818a();
            }
        }
        return true;
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo7783a() {
        return this.f8125a.f8142k && this.f8126b.f8142k;
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo7784b() {
        return this.f8125a.f8133b;
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo7785c() {
        return this.f8126b.f8133b;
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: IntrinsicsJvm.kt_5 */
    public int mo7786d() {
        return this.f8125a.f8134c;
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: COUIBaseListPopupWindow_8 */
    public int mo7787e() {
        return this.f8126b.f8134c;
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    public void setFinalX(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == -1) {
            return;
        }
        this.f8125a.m7820a(OplusGLSurfaceView_13);
    }

    public void setFinalY(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == -1) {
            return;
        }
        this.f8126b.m7820a(OplusGLSurfaceView_13);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.COUIIOverScroller
    public void fling(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(OplusGLSurfaceView_13, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    @Override // android.widget.OverScroller
    public void fling(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (i2 <= i8 && i2 >= i7) {
            m7800a(OplusGLSurfaceView_13, i2, i3, i4);
            return;
        }
        springBack(OplusGLSurfaceView_13, i2, i5, i6, i7, i8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7800a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f8128e = 1;
        this.f8125a.m7822a(OplusGLSurfaceView_13, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        this.f8126b.m7822a(i2, i4, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

    @Override // android.widget.OverScroller
    public boolean springBack(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6) {
        boolean zM7825b = this.f8125a.m7825b(OplusGLSurfaceView_13, i3, i4);
        boolean zM7825b2 = this.f8126b.m7825b(i2, i5, i6);
        if (zM7825b || zM7825b2) {
            this.f8128e = 1;
        }
        return zM7825b || zM7825b2;
    }

    @Override // android.widget.OverScroller
    public void startScroll(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        startScroll(OplusGLSurfaceView_13, i2, i3, i4, 250);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.COUIIOverScroller
    public void startScroll(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        this.f8128e = 0;
        this.f8125a.m7821a(OplusGLSurfaceView_13, i3, i5);
        this.f8126b.m7821a(i2, i4, i5);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.COUIIOverScroller
    public void abortAnimation() {
        this.f8125a.m7818a();
        this.f8126b.m7818a();
    }

    public boolean isScrollingInDirection(float COUIBaseListPopupWindow_12, float f2) {
        return !isFinished() && Math.signum(COUIBaseListPopupWindow_12) == Math.signum((float) (this.f8125a.f8134c - this.f8125a.f8132a)) && Math.signum(f2) == Math.signum((float) (this.f8126b.f8134c - this.f8126b.f8132a));
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.COUIIOverScroller
    public void notifyVerticalEdgeReached(int OplusGLSurfaceView_13, int i2, int i3) {
        this.f8126b.m7826c(OplusGLSurfaceView_13, i2, i3);
        springBack(0, OplusGLSurfaceView_13, 0, 0, 0, 0);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.COUIIOverScroller
    public void notifyHorizontalEdgeReached(int OplusGLSurfaceView_13, int i2, int i3) {
        this.f8125a.m7826c(OplusGLSurfaceView_13, i2, i3);
        springBack(OplusGLSurfaceView_13, 0, 0, 0, 0, 0);
    }

    @Override // android.widget.OverScroller
    public float getCurrVelocity() {
        return (float) Math.hypot(this.f8125a.f8136e, this.f8126b.f8136e);
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: COUIBaseListPopupWindow_12 */
    public float mo7788f() {
        return this.f8125a.f8136e;
    }

    @Override // com.coui.appcompat.widget.COUIIOverScroller
    /* renamed from: COUIBaseListPopupWindow_11 */
    public float mo7789g() {
        return this.f8126b.f8136e;
    }

    /* compiled from: COUILocateOverScroller.java */
    /* renamed from: com.coui.appcompat.widget.OplusGLSurfaceView_15$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: p */
        private static float f8129p = (float) (Math.log(0.78d) / Math.log(0.9d));

        /* renamed from: q */
        private static final float[] f8130q = new float[101];

        /* renamed from: r */
        private static final float[] f8131r = new float[101];

        /* renamed from: PlatformImplementations.kt_3 */
        private int f8132a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f8133b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f8134c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f8135d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private float f8136e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private float f8137f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private long f8138g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private int f8139h;

        /* renamed from: OplusGLSurfaceView_13 */
        private int f8140i;

        /* renamed from: OplusGLSurfaceView_15 */
        private int f8141j;

        /* renamed from: OplusGLSurfaceView_14 */
        private int f8143l;

        /* renamed from: o */
        private float f8146o;

        /* renamed from: OplusGLSurfaceView_6 */
        private float f8144m = ViewConfiguration.getScrollFriction() * 2.5f;

        /* renamed from: OplusGLSurfaceView_11 */
        private int f8145n = 0;

        /* renamed from: OplusGLSurfaceView_5 */
        private boolean f8142k = true;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private static float m7803b(int OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13 > 0 ? -2000.0f : 2000.0f;
        }

        static {
            float COUIBaseListPopupWindow_12;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11 = 0.0f;
            float f12 = 0.0f;
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 100; OplusGLSurfaceView_13++) {
                float f13 = OplusGLSurfaceView_13 / 100.0f;
                float f14 = 1.0f;
                while (true) {
                    COUIBaseListPopupWindow_12 = 2.0f;
                    f2 = ((f14 - f11) / 2.0f) + f11;
                    f3 = 3.0f;
                    f4 = 1.0f - f2;
                    f5 = f2 * 3.0f * f4;
                    f6 = f2 * f2 * f2;
                    float f15 = (((f4 * 0.175f) + (f2 * 0.35000002f)) * f5) + f6;
                    if (Math.abs(f15 - f13) < 1.0E-5d) {
                        break;
                    } else if (f15 > f13) {
                        f14 = f2;
                    } else {
                        f11 = f2;
                    }
                }
                f8130q[OplusGLSurfaceView_13] = (f5 * ((f4 * 0.5f) + f2)) + f6;
                float f16 = 1.0f;
                while (true) {
                    f7 = ((f16 - f12) / COUIBaseListPopupWindow_12) + f12;
                    f8 = 1.0f - f7;
                    f9 = f7 * f3 * f8;
                    f10 = f7 * f7 * f7;
                    float f17 = (((f8 * 0.5f) + f7) * f9) + f10;
                    if (Math.abs(f17 - f13) < 1.0E-5d) {
                        break;
                    }
                    if (f17 > f13) {
                        f16 = f7;
                    } else {
                        f12 = f7;
                    }
                    COUIBaseListPopupWindow_12 = 2.0f;
                    f3 = 3.0f;
                }
                f8131r[OplusGLSurfaceView_13] = (f9 * ((f8 * 0.175f) + (f7 * 0.35000002f))) + f10;
            }
            float[] fArr = f8130q;
            f8131r[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m7819a(float COUIBaseListPopupWindow_12) {
            this.f8144m = COUIBaseListPopupWindow_12;
        }

        PlatformImplementations.kt_3(Context context) {
            this.f8146o = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m7823b(float COUIBaseListPopupWindow_12) {
            this.f8133b = this.f8132a + Math.round(COUIBaseListPopupWindow_12 * (this.f8134c - r0));
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        private void m7810d(int OplusGLSurfaceView_13, int i2, int i3) {
            float fAbs = Math.abs((i3 - OplusGLSurfaceView_13) / (i2 - OplusGLSurfaceView_13));
            int i4 = (int) (fAbs * 100.0f);
            if (i4 < 100) {
                float COUIBaseListPopupWindow_12 = i4 / 100.0f;
                int i5 = i4 + 1;
                float[] fArr = f8131r;
                float f2 = fArr[i4];
                this.f8139h = (int) (this.f8139h * (f2 + (((fAbs - COUIBaseListPopupWindow_12) / ((i5 / 100.0f) - COUIBaseListPopupWindow_12)) * (fArr[i5] - f2))));
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m7821a(int OplusGLSurfaceView_13, int i2, int i3) {
            this.f8142k = false;
            this.f8132a = OplusGLSurfaceView_13;
            this.f8133b = OplusGLSurfaceView_13;
            this.f8134c = OplusGLSurfaceView_13 + i2;
            this.f8138g = AnimationUtils.currentAnimationTimeMillis();
            this.f8139h = i3;
            this.f8137f = 0.0f;
            this.f8135d = 0;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m7818a() {
            this.f8133b = this.f8134c;
            this.f8142k = true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m7820a(int OplusGLSurfaceView_13) {
            this.f8134c = OplusGLSurfaceView_13;
            this.f8141j = this.f8134c - this.f8132a;
            this.f8142k = false;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean m7825b(int OplusGLSurfaceView_13, int i2, int i3) {
            this.f8142k = true;
            this.f8134c = OplusGLSurfaceView_13;
            this.f8132a = OplusGLSurfaceView_13;
            this.f8133b = OplusGLSurfaceView_13;
            this.f8135d = 0;
            this.f8138g = AnimationUtils.currentAnimationTimeMillis();
            this.f8139h = 0;
            if (OplusGLSurfaceView_13 < i2) {
                m7813e(OplusGLSurfaceView_13, i2, 0);
            } else if (OplusGLSurfaceView_13 > i3) {
                m7813e(OplusGLSurfaceView_13, i3, 0);
            }
            return !this.f8142k;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        private void m7813e(int OplusGLSurfaceView_13, int i2, int i3) {
            this.f8142k = false;
            this.f8145n = 1;
            this.f8132a = OplusGLSurfaceView_13;
            this.f8133b = OplusGLSurfaceView_13;
            this.f8134c = i2;
            int i4 = OplusGLSurfaceView_13 - i2;
            this.f8137f = m7803b(i4);
            this.f8135d = -i4;
            this.f8143l = Math.abs(i4);
            this.f8139h = (int) (Math.sqrt((i4 * (-2.0d)) / this.f8137f) * 1000.0d);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m7822a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
            this.f8143l = i5;
            this.f8142k = false;
            this.f8135d = i2;
            this.f8136e = i2;
            this.f8140i = 0;
            this.f8139h = 0;
            this.f8138g = AnimationUtils.currentAnimationTimeMillis();
            this.f8132a = OplusGLSurfaceView_13;
            this.f8133b = OplusGLSurfaceView_13;
            if (OplusGLSurfaceView_13 > i4 || OplusGLSurfaceView_13 < i3) {
                m7802a(OplusGLSurfaceView_13, i3, i4, i2);
                return;
            }
            this.f8145n = 0;
            double dM7807d = 0.0d;
            if (i2 != 0) {
                int iM7811e = m7811e(i2);
                this.f8140i = iM7811e;
                this.f8139h = iM7811e;
                dM7807d = m7807d(i2);
            }
            this.f8141j = (int) (dM7807d * Math.signum(r0));
            this.f8134c = OplusGLSurfaceView_13 + this.f8141j;
            int i6 = this.f8134c;
            if (i6 < i3) {
                m7810d(this.f8132a, i6, i3);
                this.f8134c = i3;
            }
            int i7 = this.f8134c;
            if (i7 > i4) {
                m7810d(this.f8132a, i7, i4);
                this.f8134c = i4;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private double m7805c(int OplusGLSurfaceView_13) {
            return Math.log((Math.abs(OplusGLSurfaceView_13) * 0.35f) / (this.f8144m * this.f8146o));
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        private double m7807d(int OplusGLSurfaceView_13) {
            double dM7805c = m7805c(OplusGLSurfaceView_13);
            float COUIBaseListPopupWindow_12 = f8129p;
            return this.f8144m * this.f8146o * Math.exp((COUIBaseListPopupWindow_12 / (COUIBaseListPopupWindow_12 - 1.0d)) * dM7805c);
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int m7811e(int OplusGLSurfaceView_13) {
            return (int) (Math.exp(m7805c(OplusGLSurfaceView_13) / (f8129p - 1.0d)) * 1000.0d);
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        private void m7815f(int OplusGLSurfaceView_13, int i2, int i3) {
            float COUIBaseListPopupWindow_12 = (-i3) / this.f8137f;
            float f2 = i3;
            float fSqrt = (float) Math.sqrt((((((f2 * f2) / 2.0f) / Math.abs(r1)) + Math.abs(i2 - OplusGLSurfaceView_13)) * 2.0d) / Math.abs(this.f8137f));
            this.f8138g -= (int) ((fSqrt - COUIBaseListPopupWindow_12) * 1000.0f);
            this.f8132a = i2;
            this.f8133b = i2;
            this.f8135d = (int) ((-this.f8137f) * fSqrt);
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        private void m7817g(int OplusGLSurfaceView_13, int i2, int i3) {
            this.f8137f = m7803b(i3 == 0 ? OplusGLSurfaceView_13 - i2 : i3);
            m7815f(OplusGLSurfaceView_13, i2, i3);
            m7809d();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m7802a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            if (OplusGLSurfaceView_13 > i2 && OplusGLSurfaceView_13 < i3) {
                Log.COUIBaseListPopupWindow_8("COUILocateOverScroller", "startAfterEdge called from PlatformImplementations.kt_3 valid position");
                this.f8142k = true;
                return;
            }
            boolean z = OplusGLSurfaceView_13 > i3;
            int i5 = z ? i3 : i2;
            if ((OplusGLSurfaceView_13 - i5) * i4 >= 0) {
                m7817g(OplusGLSurfaceView_13, i5, i4);
            } else if (m7807d(i4) > Math.abs(r4)) {
                m7822a(OplusGLSurfaceView_13, i4, z ? i2 : OplusGLSurfaceView_13, z ? OplusGLSurfaceView_13 : i3, this.f8143l);
            } else {
                m7813e(OplusGLSurfaceView_13, i5, i4);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        void m7826c(int OplusGLSurfaceView_13, int i2, int i3) {
            if (this.f8145n == 0) {
                this.f8143l = i3;
                this.f8138g = AnimationUtils.currentAnimationTimeMillis();
                m7802a(OplusGLSurfaceView_13, i2, i2, (int) this.f8136e);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        private void m7809d() {
            int OplusGLSurfaceView_13 = this.f8135d;
            float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13 * OplusGLSurfaceView_13;
            float fAbs = COUIBaseListPopupWindow_12 / (Math.abs(this.f8137f) * 2.0f);
            float fSignum = Math.signum(this.f8135d);
            int i2 = this.f8143l;
            if (fAbs > i2) {
                this.f8137f = ((-fSignum) * COUIBaseListPopupWindow_12) / (i2 * 2.0f);
                fAbs = i2;
            }
            this.f8143l = (int) fAbs;
            this.f8145n = 2;
            int i3 = this.f8132a;
            if (this.f8135d <= 0) {
                fAbs = -fAbs;
            }
            this.f8134c = i3 + ((int) fAbs);
            this.f8139h = -((int) ((this.f8135d * 1000.0f) / this.f8137f));
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean m7824b() {
            int OplusGLSurfaceView_13 = this.f8145n;
            if (OplusGLSurfaceView_13 != 0) {
                if (OplusGLSurfaceView_13 == 1) {
                    return false;
                }
                if (OplusGLSurfaceView_13 == 2) {
                    this.f8138g += this.f8139h;
                    m7813e(this.f8134c, this.f8132a, 0);
                }
            } else {
                if (this.f8139h >= this.f8140i) {
                    return false;
                }
                int i2 = this.f8134c;
                this.f8132a = i2;
                this.f8133b = i2;
                this.f8135d = (int) this.f8136e;
                this.f8137f = m7803b(this.f8135d);
                this.f8138g += this.f8139h;
                m7809d();
            }
            m7827c();
            return true;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean m7827c() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f8138g;
            if (jCurrentAnimationTimeMillis == 0) {
                return this.f8139h > 0;
            }
            int OplusGLSurfaceView_13 = this.f8139h;
            if (jCurrentAnimationTimeMillis > OplusGLSurfaceView_13) {
                return false;
            }
            double IntrinsicsJvm.kt_5 = 0.0d;
            int i2 = this.f8145n;
            if (i2 == 0) {
                float COUIBaseListPopupWindow_12 = jCurrentAnimationTimeMillis / this.f8140i;
                int i3 = (int) (COUIBaseListPopupWindow_12 * 100.0f);
                float f2 = 1.0f;
                float f3 = 0.0f;
                if (i3 < 100) {
                    float f4 = i3 / 100.0f;
                    int i4 = i3 + 1;
                    float[] fArr = f8130q;
                    float f5 = fArr[i3];
                    f3 = (fArr[i4] - f5) / ((i4 / 100.0f) - f4);
                    f2 = f5 + ((COUIBaseListPopupWindow_12 - f4) * f3);
                }
                int i5 = this.f8141j;
                this.f8136e = ((f3 * i5) / this.f8140i) * 1000.0f;
                IntrinsicsJvm.kt_5 = f2 * i5;
            } else if (i2 == 1) {
                float f6 = jCurrentAnimationTimeMillis / OplusGLSurfaceView_13;
                float f7 = f6 * f6;
                float fSignum = Math.signum(this.f8135d);
                int i6 = this.f8143l;
                IntrinsicsJvm.kt_5 = i6 * fSignum * ((3.0f * f7) - ((2.0f * f6) * f7));
                this.f8136e = fSignum * i6 * 6.0f * ((-f6) + f7);
            } else if (i2 == 2) {
                float f8 = jCurrentAnimationTimeMillis / 1000.0f;
                int i7 = this.f8135d;
                float f9 = this.f8137f;
                this.f8136e = i7 + (f9 * f8);
                IntrinsicsJvm.kt_5 = (i7 * f8) + (((f9 * f8) * f8) / 2.0f);
            }
            this.f8133b = this.f8132a + ((int) Math.round(IntrinsicsJvm.kt_5));
            return true;
        }
    }
}
