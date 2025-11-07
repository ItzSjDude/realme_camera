package androidx.p040d.p041a.p042a;

import android.view.animation.Interpolator;

/* compiled from: LookupTableInterpolator.java */
/* renamed from: androidx.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {

    /* renamed from: PlatformImplementations.kt_3 */
    private final float[] f3216a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final float f3217b;

    protected LookupTableInterpolator(float[] fArr) {
        this.f3216a = fArr;
        this.f3217b = 1.0f / (this.f3216a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 >= 1.0f) {
            return 1.0f;
        }
        if (COUIBaseListPopupWindow_12 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f3216a;
        int iMin = Math.min((int) ((fArr.length - 1) * COUIBaseListPopupWindow_12), fArr.length - 2);
        float f2 = this.f3217b;
        float f3 = (COUIBaseListPopupWindow_12 - (iMin * f2)) / f2;
        float[] fArr2 = this.f3216a;
        return fArr2[iMin] + (f3 * (fArr2[iMin + 1] - fArr2[iMin]));
    }
}
