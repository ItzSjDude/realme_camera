package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: ViewUtilsApi19.java */
/* renamed from: androidx.transition.ae */
/* loaded from: classes.dex */
class ViewUtilsApi19 extends ViewUtilsBase {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f4532a = true;

    @Override // androidx.transition.ViewUtilsBase
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo4743b(View view) {
    }

    @Override // androidx.transition.ViewUtilsBase
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo4744c(View view) {
    }

    ViewUtilsApi19() {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4742a(View view, float COUIBaseListPopupWindow_12) {
        if (f4532a) {
            try {
                view.setTransitionAlpha(COUIBaseListPopupWindow_12);
                return;
            } catch (NoSuchMethodError unused) {
                f4532a = false;
            }
        }
        view.setAlpha(COUIBaseListPopupWindow_12);
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    /* renamed from: PlatformImplementations.kt_3 */
    public float mo4741a(View view) {
        if (f4532a) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f4532a = false;
            }
        }
        return view.getAlpha();
    }
}
