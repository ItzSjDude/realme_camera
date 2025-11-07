package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* compiled from: ViewUtilsApi23.java */
/* renamed from: androidx.transition.ah */
/* loaded from: classes.dex */
class ViewUtilsApi23 extends ViewUtilsApi22 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f4537a = true;

    ViewUtilsApi23() {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4748a(View view, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT == 28) {
            super.mo4748a(view, OplusGLSurfaceView_13);
        } else if (f4537a) {
            try {
                view.setTransitionVisibility(OplusGLSurfaceView_13);
            } catch (NoSuchMethodError unused) {
                f4537a = false;
            }
        }
    }
}
