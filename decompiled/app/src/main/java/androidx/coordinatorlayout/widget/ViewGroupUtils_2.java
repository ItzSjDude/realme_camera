package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: ViewGroupUtils.java */
/* renamed from: androidx.coordinatorlayout.widget.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class ViewGroupUtils_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final ThreadLocal<Matrix> f2684a = new ThreadLocal<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final ThreadLocal<RectF> f2685b = new ThreadLocal<>();

    /* renamed from: PlatformImplementations.kt_3 */
    static void m2245a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix = f2684a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f2684a.set(matrix);
        } else {
            matrix.reset();
        }
        m2246a(viewGroup, view, matrix);
        RectF rectF = f2685b.get();
        if (rectF == null) {
            rectF = new RectF();
            f2685b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m2247b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m2245a(viewGroup, view, rect);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m2246a(ViewParent viewParent, View view, Matrix matrix) {
        Object parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            m2246a(viewParent, (View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }
}
