package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: ViewUtilsApi22.java */
/* renamed from: androidx.transition.ag */
/* loaded from: classes.dex */
class ViewUtilsApi22 extends ViewUtilsApi21 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f4536a = true;

    ViewUtilsApi22() {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4747a(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (f4536a) {
            try {
                view.setLeftTopRightBottom(OplusGLSurfaceView_13, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                f4536a = false;
            }
        }
    }
}
