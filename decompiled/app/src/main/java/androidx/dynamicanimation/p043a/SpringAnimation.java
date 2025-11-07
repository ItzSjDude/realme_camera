package androidx.dynamicanimation.p043a;

import androidx.dynamicanimation.p043a.DynamicAnimation;

/* compiled from: SpringAnimation.java */
/* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {

    /* renamed from: w */
    private SpringForce f3327w;

    /* renamed from: x */
    private float f3328x;

    /* renamed from: y */
    private boolean f3329y;

    public SpringAnimation(FloatValueHolder c0551e) {
        super(c0551e);
        this.f3327w = null;
        this.f3328x = Float.MAX_VALUE;
        this.f3329y = false;
    }

    public <K> SpringAnimation(K OplusGLSurfaceView_5, FloatPropertyCompat<K> abstractC0550d, float COUIBaseListPopupWindow_12) {
        super(OplusGLSurfaceView_5, abstractC0550d);
        this.f3327w = null;
        this.f3328x = Float.MAX_VALUE;
        this.f3329y = false;
        this.f3327w = new SpringForce(COUIBaseListPopupWindow_12);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public SpringForce m3232e() {
        return this.f3327w;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public SpringAnimation m3230a(SpringForce c0553g) {
        this.f3327w = c0553g;
        return this;
    }

    @Override // androidx.dynamicanimation.p043a.DynamicAnimation
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3191a() {
        m3229f();
        this.f3327w.m3237a(m3221d());
        super.mo3191a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3231a(float COUIBaseListPopupWindow_12) {
        if (m3220c()) {
            this.f3328x = COUIBaseListPopupWindow_12;
            return;
        }
        if (this.f3327w == null) {
            this.f3327w = new SpringForce(COUIBaseListPopupWindow_12);
        }
        this.f3327w.m3240c(COUIBaseListPopupWindow_12);
        mo3191a();
    }

    @Override // androidx.dynamicanimation.p043a.DynamicAnimation
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3218b() {
        super.mo3218b();
        float COUIBaseListPopupWindow_12 = this.f3328x;
        if (COUIBaseListPopupWindow_12 != Float.MAX_VALUE) {
            SpringForce c0553g = this.f3327w;
            if (c0553g == null) {
                this.f3327w = new SpringForce(COUIBaseListPopupWindow_12);
            } else {
                c0553g.m3240c(COUIBaseListPopupWindow_12);
            }
            this.f3328x = Float.MAX_VALUE;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m3229f() {
        SpringForce c0553g = this.f3327w;
        if (c0553g == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or PlatformImplementations.kt_3 spring force needs to be set.");
        }
        double dM3234a = c0553g.m3234a();
        if (dM3234a > this.f3315u) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (dM3234a < this.f3316v) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // androidx.dynamicanimation.p043a.DynamicAnimation
    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean mo3194b(long OplusGLSurfaceView_15) {
        if (this.f3329y) {
            float COUIBaseListPopupWindow_12 = this.f3328x;
            if (COUIBaseListPopupWindow_12 != Float.MAX_VALUE) {
                this.f3327w.m3240c(COUIBaseListPopupWindow_12);
                this.f3328x = Float.MAX_VALUE;
            }
            this.f3310p = this.f3327w.m3234a();
            this.f3309o = 0.0f;
            this.f3329y = false;
            return true;
        }
        if (this.f3328x != Float.MAX_VALUE) {
            long j2 = OplusGLSurfaceView_15 / 2;
            DynamicAnimation.PlatformImplementations.kt_3 aVarM3235a = this.f3327w.m3235a(this.f3310p, this.f3309o, j2);
            this.f3327w.m3240c(this.f3328x);
            this.f3328x = Float.MAX_VALUE;
            DynamicAnimation.PlatformImplementations.kt_3 aVarM3235a2 = this.f3327w.m3235a(aVarM3235a.f3323a, aVarM3235a.f3324b, j2);
            this.f3310p = aVarM3235a2.f3323a;
            this.f3309o = aVarM3235a2.f3324b;
        } else {
            DynamicAnimation.PlatformImplementations.kt_3 aVarM3235a3 = this.f3327w.m3235a(this.f3310p, this.f3309o, OplusGLSurfaceView_15);
            this.f3310p = aVarM3235a3.f3323a;
            this.f3309o = aVarM3235a3.f3324b;
        }
        this.f3310p = Math.max(this.f3310p, this.f3316v);
        this.f3310p = Math.min(this.f3310p, this.f3315u);
        if (!mo3192a(this.f3310p, this.f3309o)) {
            return false;
        }
        this.f3310p = this.f3327w.m3234a();
        this.f3309o = 0.0f;
        return true;
    }

    @Override // androidx.dynamicanimation.p043a.DynamicAnimation
    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo3192a(float COUIBaseListPopupWindow_12, float f2) {
        return this.f3327w.m3238a(COUIBaseListPopupWindow_12, f2);
    }
}
