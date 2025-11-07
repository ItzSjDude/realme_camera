package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi29.java */
/* renamed from: androidx.transition.ai */
/* loaded from: classes.dex */
class ViewUtilsApi29 extends ViewUtilsApi23 {
    ViewUtilsApi29() {
    }

    @Override // androidx.transition.ViewUtilsApi19, androidx.transition.ViewUtilsBase
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4742a(View view, float COUIBaseListPopupWindow_12) {
        view.setTransitionAlpha(COUIBaseListPopupWindow_12);
    }

    @Override // androidx.transition.ViewUtilsApi19, androidx.transition.ViewUtilsBase
    /* renamed from: PlatformImplementations.kt_3 */
    public float mo4741a(View view) {
        return view.getTransitionAlpha();
    }

    @Override // androidx.transition.ViewUtilsApi23, androidx.transition.ViewUtilsBase
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4748a(View view, int OplusGLSurfaceView_13) {
        view.setTransitionVisibility(OplusGLSurfaceView_13);
    }

    @Override // androidx.transition.ViewUtilsApi22, androidx.transition.ViewUtilsBase
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4747a(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // androidx.transition.ViewUtilsApi21, androidx.transition.ViewUtilsBase
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4745a(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.ViewUtilsApi21, androidx.transition.ViewUtilsBase
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo4746b(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
