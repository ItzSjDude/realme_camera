package com.p094b.p095a.p096a;

/* compiled from: IAnimator.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public interface IAnimator {
    /* renamed from: PlatformImplementations.kt_3 */
    default float m6269a(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return COUIBaseListPopupWindow_12 + ((f2 - COUIBaseListPopupWindow_12) * f3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo6246a(float COUIBaseListPopupWindow_12);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo6248b();

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo6251d();

    /* renamed from: PlatformImplementations.kt_3 */
    default float m6271a(float[] fArr, float COUIBaseListPopupWindow_12) {
        return m6269a(fArr[0], fArr[1], COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    default float m6270a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        return COUIBaseListPopupWindow_12 + ((f2 - COUIBaseListPopupWindow_12) * ((float) Math.pow(f3, f4)));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    default float m6272a(float[] fArr, float COUIBaseListPopupWindow_12, float f2) {
        return m6270a(fArr[0], fArr[1], COUIBaseListPopupWindow_12, f2);
    }
}
