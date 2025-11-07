package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* compiled from: RectEvaluator.java */
/* renamed from: androidx.transition.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {

    /* renamed from: PlatformImplementations.kt_3 */
    private Rect f4623a;

    RectEvaluator() {
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float COUIBaseListPopupWindow_12, Rect rect, Rect rect2) {
        int OplusGLSurfaceView_13 = rect.left + ((int) ((rect2.left - rect.left) * COUIBaseListPopupWindow_12));
        int i2 = rect.top + ((int) ((rect2.top - rect.top) * COUIBaseListPopupWindow_12));
        int i3 = rect.right + ((int) ((rect2.right - rect.right) * COUIBaseListPopupWindow_12));
        int i4 = rect.bottom + ((int) ((rect2.bottom - rect.bottom) * COUIBaseListPopupWindow_12));
        Rect rect3 = this.f4623a;
        if (rect3 == null) {
            return new Rect(OplusGLSurfaceView_13, i2, i3, i4);
        }
        rect3.set(OplusGLSurfaceView_13, i2, i3, i4);
        return this.f4623a;
    }
}
