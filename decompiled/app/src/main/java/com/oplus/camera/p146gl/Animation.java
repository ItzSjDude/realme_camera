package com.oplus.camera.p146gl;

import android.view.animation.Interpolator;

/* compiled from: Animation.java */
/* renamed from: com.oplus.camera.gl.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public abstract class Animation {

    /* renamed from: PlatformImplementations.kt_3 */
    protected long f13851a = -2;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected long f13852b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected Interpolator f13853c;

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void m13819a(float COUIBaseListPopupWindow_12);

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13820a(long OplusGLSurfaceView_15) {
        this.f13851a = OplusGLSurfaceView_15;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m13821b(long OplusGLSurfaceView_15) {
        long j2 = this.f13851a;
        if (j2 == -2) {
            return false;
        }
        if (j2 == -1) {
            this.f13851a = OplusGLSurfaceView_15;
        }
        long j3 = OplusGLSurfaceView_15 - this.f13851a;
        float fM14287a = Utils_3.m14287a(j3 / this.f13852b, 0.0f, 1.0f);
        Interpolator interpolator = this.f13853c;
        if (interpolator != null) {
            fM14287a = interpolator.getInterpolation(fM14287a);
        }
        m13819a(fM14287a);
        if (j3 >= this.f13852b) {
            this.f13851a = -2L;
        }
        return this.f13851a != -2;
    }
}
