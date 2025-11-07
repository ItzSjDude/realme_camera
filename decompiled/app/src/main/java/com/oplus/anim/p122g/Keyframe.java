package com.oplus.anim.p122g;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.oplus.anim.EffectiveAnimationComposition;

/* compiled from: Keyframe.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_11.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class Keyframe<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    public final T f10421a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final Interpolator f10422b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final float f10423c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public T f10424d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public Float f10425e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public PointF f10426f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public PointF f10427g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final EffectiveAnimationComposition f10428h;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f10429i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f10430j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f10431k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f10432l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f10433m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f10434n;

    public Keyframe(EffectiveAnimationComposition c2272a, T t, T t2, Interpolator interpolator, float COUIBaseListPopupWindow_12, Float f2) {
        this.f10426f = null;
        this.f10427g = null;
        this.f10429i = -3987645.8f;
        this.f10430j = -3987645.8f;
        this.f10431k = 784923401;
        this.f10432l = 784923401;
        this.f10433m = Float.MIN_VALUE;
        this.f10434n = Float.MIN_VALUE;
        this.f10428h = c2272a;
        this.f10421a = t;
        this.f10424d = t2;
        this.f10422b = interpolator;
        this.f10423c = COUIBaseListPopupWindow_12;
        this.f10425e = f2;
    }

    public Keyframe(T t) {
        this.f10426f = null;
        this.f10427g = null;
        this.f10429i = -3987645.8f;
        this.f10430j = -3987645.8f;
        this.f10431k = 784923401;
        this.f10432l = 784923401;
        this.f10433m = Float.MIN_VALUE;
        this.f10434n = Float.MIN_VALUE;
        this.f10428h = null;
        this.f10421a = t;
        this.f10424d = t;
        this.f10422b = null;
        this.f10423c = Float.MIN_VALUE;
        this.f10425e = Float.valueOf(Float.MAX_VALUE);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public float m9328c() {
        EffectiveAnimationComposition c2272a = this.f10428h;
        if (c2272a == null) {
            return 0.0f;
        }
        if (this.f10433m == Float.MIN_VALUE) {
            this.f10433m = (this.f10423c - c2272a.m8795f()) / this.f10428h.m8802m();
        }
        return this.f10433m;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float m9329d() {
        if (this.f10428h == null) {
            return 1.0f;
        }
        if (this.f10434n == Float.MIN_VALUE) {
            if (this.f10425e == null) {
                this.f10434n = 1.0f;
            } else {
                this.f10434n = m9328c() + ((this.f10425e.floatValue() - this.f10423c) / this.f10428h.m8802m());
            }
        }
        return this.f10434n;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m9330e() {
        return this.f10422b == null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m9327a(float COUIBaseListPopupWindow_12) {
        return COUIBaseListPopupWindow_12 >= m9328c() && COUIBaseListPopupWindow_12 < m9329d();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public float m9331f() {
        if (this.f10429i == -3987645.8f) {
            this.f10429i = ((Float) this.f10421a).floatValue();
        }
        return this.f10429i;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public float m9332g() {
        if (this.f10430j == -3987645.8f) {
            this.f10430j = ((Float) this.f10424d).floatValue();
        }
        return this.f10430j;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public int m9333h() {
        if (this.f10431k == 784923401) {
            this.f10431k = ((Integer) this.f10421a).intValue();
        }
        return this.f10431k;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public int m9334i() {
        if (this.f10432l == 784923401) {
            this.f10432l = ((Integer) this.f10424d).intValue();
        }
        return this.f10432l;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f10421a + ", endValue=" + this.f10424d + ", startFrame=" + this.f10423c + ", endFrame=" + this.f10425e + ", interpolator=" + this.f10422b + '}';
    }
}
