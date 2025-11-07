package androidx.coordinatorlayout.widget;

/* compiled from: ViewGroupUtils.java */
/* loaded from: classes.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.ThreadLocal<android.graphics.Matrix> f778a = new java.lang.ThreadLocal<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.ThreadLocal<android.graphics.RectF> f779b = new java.lang.ThreadLocal<>();

    static void a_renamed(android.view.ViewGroup viewGroup, android.view.View view, android.graphics.Rect rect) {
        android.graphics.Matrix matrix = f778a.get();
        if (matrix == null) {
            matrix = new android.graphics.Matrix();
            f778a.set(matrix);
        } else {
            matrix.reset();
        }
        a_renamed(viewGroup, view, matrix);
        android.graphics.RectF rectF = f779b.get();
        if (rectF == null) {
            rectF = new android.graphics.RectF();
            f779b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public static void b_renamed(android.view.ViewGroup viewGroup, android.view.View view, android.graphics.Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        a_renamed(viewGroup, view, rect);
    }

    private static void a_renamed(android.view.ViewParent viewParent, android.view.View view, android.graphics.Matrix matrix) {
        java.lang.Object parent = view.getParent();
        if ((parent instanceof android.view.View) && parent != viewParent) {
            a_renamed(viewParent, (android.view.View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }
}
