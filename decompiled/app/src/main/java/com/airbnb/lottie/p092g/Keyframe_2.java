package com.airbnb.lottie.p092g;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;

/* compiled from: Keyframe.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_11.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class Keyframe_2<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    public final T f5894a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public T f5895b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final Interpolator f5896c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final Interpolator f5897d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final Interpolator f5898e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public final float f5899f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public Float f5900g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public PointF f5901h;

    /* renamed from: OplusGLSurfaceView_13 */
    public PointF f5902i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final LottieComposition f5903j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f5904k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f5905l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f5906m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f5907n;

    /* renamed from: o */
    private float f5908o;

    /* renamed from: p */
    private float f5909p;

    public Keyframe_2(LottieComposition c1136d, T t, T t2, Interpolator interpolator, float COUIBaseListPopupWindow_12, Float f2) {
        this.f5904k = -3987645.8f;
        this.f5905l = -3987645.8f;
        this.f5906m = 784923401;
        this.f5907n = 784923401;
        this.f5908o = Float.MIN_VALUE;
        this.f5909p = Float.MIN_VALUE;
        this.f5901h = null;
        this.f5902i = null;
        this.f5903j = c1136d;
        this.f5894a = t;
        this.f5895b = t2;
        this.f5896c = interpolator;
        this.f5897d = null;
        this.f5898e = null;
        this.f5899f = COUIBaseListPopupWindow_12;
        this.f5900g = f2;
    }

    public Keyframe_2(LottieComposition c1136d, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float COUIBaseListPopupWindow_12, Float f2) {
        this.f5904k = -3987645.8f;
        this.f5905l = -3987645.8f;
        this.f5906m = 784923401;
        this.f5907n = 784923401;
        this.f5908o = Float.MIN_VALUE;
        this.f5909p = Float.MIN_VALUE;
        this.f5901h = null;
        this.f5902i = null;
        this.f5903j = c1136d;
        this.f5894a = t;
        this.f5895b = t2;
        this.f5896c = null;
        this.f5897d = interpolator;
        this.f5898e = interpolator2;
        this.f5899f = COUIBaseListPopupWindow_12;
        this.f5900g = f2;
    }

    protected Keyframe_2(LottieComposition c1136d, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float COUIBaseListPopupWindow_12, Float f2) {
        this.f5904k = -3987645.8f;
        this.f5905l = -3987645.8f;
        this.f5906m = 784923401;
        this.f5907n = 784923401;
        this.f5908o = Float.MIN_VALUE;
        this.f5909p = Float.MIN_VALUE;
        this.f5901h = null;
        this.f5902i = null;
        this.f5903j = c1136d;
        this.f5894a = t;
        this.f5895b = t2;
        this.f5896c = interpolator;
        this.f5897d = interpolator2;
        this.f5898e = interpolator3;
        this.f5899f = COUIBaseListPopupWindow_12;
        this.f5900g = f2;
    }

    public Keyframe_2(T t) {
        this.f5904k = -3987645.8f;
        this.f5905l = -3987645.8f;
        this.f5906m = 784923401;
        this.f5907n = 784923401;
        this.f5908o = Float.MIN_VALUE;
        this.f5909p = Float.MIN_VALUE;
        this.f5901h = null;
        this.f5902i = null;
        this.f5903j = null;
        this.f5894a = t;
        this.f5895b = t;
        this.f5896c = null;
        this.f5897d = null;
        this.f5898e = null;
        this.f5899f = Float.MIN_VALUE;
        this.f5900g = Float.valueOf(Float.MAX_VALUE);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public float m6164c() {
        LottieComposition c1136d = this.f5903j;
        if (c1136d == null) {
            return 0.0f;
        }
        if (this.f5908o == Float.MIN_VALUE) {
            this.f5908o = (this.f5899f - c1136d.m5853f()) / this.f5903j.m5860m();
        }
        return this.f5908o;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float m6165d() {
        if (this.f5903j == null) {
            return 1.0f;
        }
        if (this.f5909p == Float.MIN_VALUE) {
            if (this.f5900g == null) {
                this.f5909p = 1.0f;
            } else {
                this.f5909p = m6164c() + ((this.f5900g.floatValue() - this.f5899f) / this.f5903j.m5860m());
            }
        }
        return this.f5909p;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m6166e() {
        return this.f5896c == null && this.f5897d == null && this.f5898e == null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m6163a(float COUIBaseListPopupWindow_12) {
        return COUIBaseListPopupWindow_12 >= m6164c() && COUIBaseListPopupWindow_12 < m6165d();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public float m6167f() {
        if (this.f5904k == -3987645.8f) {
            this.f5904k = ((Float) this.f5894a).floatValue();
        }
        return this.f5904k;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public float m6168g() {
        if (this.f5905l == -3987645.8f) {
            this.f5905l = ((Float) this.f5895b).floatValue();
        }
        return this.f5905l;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public int m6169h() {
        if (this.f5906m == 784923401) {
            this.f5906m = ((Integer) this.f5894a).intValue();
        }
        return this.f5906m;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public int m6170i() {
        if (this.f5907n == 784923401) {
            this.f5907n = ((Integer) this.f5895b).intValue();
        }
        return this.f5907n;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f5894a + ", endValue=" + this.f5895b + ", startFrame=" + this.f5899f + ", endFrame=" + this.f5900g + ", interpolator=" + this.f5896c + '}';
    }
}
