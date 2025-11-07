package com.coui.appcompat.widget.floatingbutton;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: ViewGroupUtils.java */
/* renamed from: com.coui.appcompat.widget.floatingbutton.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
class ViewGroupUtils_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final ThreadLocal<Matrix> f8105a = new ThreadLocal<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final ThreadLocal<RectF> f8106b = new ThreadLocal<>();

    /* renamed from: PlatformImplementations.kt_3 */
    static void m7766a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix = f8105a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f8105a.set(matrix);
        } else {
            matrix.reset();
        }
        m7767a(viewGroup, view, matrix);
        RectF rectF = f8106b.get();
        if (rectF == null) {
            rectF = new RectF();
            f8106b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static void m7768b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m7766a(viewGroup, view, rect);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m7767a(ViewParent viewParent, View view, Matrix matrix) {
        Object parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            m7767a(viewParent, (View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }
}
