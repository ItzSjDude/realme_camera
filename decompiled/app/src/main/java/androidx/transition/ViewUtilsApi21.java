package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi21.java */
/* renamed from: androidx.transition.af */
/* loaded from: classes.dex */
class ViewUtilsApi21 extends ViewUtilsApi19 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f4533a = true;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f4534b = true;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean f4535c = true;

    ViewUtilsApi21() {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4745a(View view, Matrix matrix) {
        if (f4534b) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f4534b = false;
            }
        }
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo4746b(View view, Matrix matrix) {
        if (f4535c) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f4535c = false;
            }
        }
    }
}
