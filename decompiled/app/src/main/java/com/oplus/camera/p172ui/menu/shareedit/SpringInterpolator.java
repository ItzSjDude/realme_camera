package com.oplus.camera.p172ui.menu.shareedit;

import android.view.animation.Interpolator;

/* compiled from: SpringInterpolator.java */
/* renamed from: com.oplus.camera.ui.menu.shareedit.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class SpringInterpolator implements Interpolator {

    /* renamed from: PlatformImplementations.kt_3 */
    private float f20494a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f20495b;

    public SpringInterpolator() {
        this.f20494a = 10.0f;
        this.f20495b = 0.4f;
    }

    public SpringInterpolator(float COUIBaseListPopupWindow_12, float f2) {
        this.f20494a = 10.0f;
        this.f20495b = 0.4f;
        this.f20494a = COUIBaseListPopupWindow_12;
        this.f20495b = f2;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float COUIBaseListPopupWindow_12) {
        return (float) ((Math.pow(2.0d, (-this.f20494a) * COUIBaseListPopupWindow_12) * Math.sin(((9.42477796076938d / this.f20495b) * COUIBaseListPopupWindow_12) - 1.5707963267948966d)) + 1.0d);
    }
}
