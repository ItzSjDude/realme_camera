package androidx.transition;

/* compiled from: ViewUtilsBase.java */
/* loaded from: classes.dex */
class aj_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f1675a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f1676b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.lang.reflect.Field f1677c;
    private static boolean d_renamed;

    aj_renamed() {
    }

    public void a_renamed(android.view.View view, float f_renamed) {
        java.lang.Float f2 = (java.lang.Float) view.getTag(androidx.transition.R_renamed.id_renamed.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f_renamed);
        } else {
            view.setAlpha(f_renamed);
        }
    }

    public float a_renamed(android.view.View view) {
        java.lang.Float f_renamed = (java.lang.Float) view.getTag(androidx.transition.R_renamed.id_renamed.save_non_transition_alpha);
        if (f_renamed != null) {
            return view.getAlpha() / f_renamed.floatValue();
        }
        return view.getAlpha();
    }

    public void b_renamed(android.view.View view) {
        if (view.getTag(androidx.transition.R_renamed.id_renamed.save_non_transition_alpha) == null) {
            view.setTag(androidx.transition.R_renamed.id_renamed.save_non_transition_alpha, java.lang.Float.valueOf(view.getAlpha()));
        }
    }

    public void c_renamed(android.view.View view) {
        if (view.getVisibility() == 0) {
            view.setTag(androidx.transition.R_renamed.id_renamed.save_non_transition_alpha, null);
        }
    }

    public void a_renamed(android.view.View view, android.graphics.Matrix matrix) {
        java.lang.Object parent = view.getParent();
        if (parent instanceof android.view.View) {
            a_renamed((android.view.View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        android.graphics.Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void b_renamed(android.view.View view, android.graphics.Matrix matrix) {
        java.lang.Object parent = view.getParent();
        if (parent instanceof android.view.View) {
            b_renamed((android.view.View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        android.graphics.Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        android.graphics.Matrix matrix3 = new android.graphics.Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }

    public void a_renamed(android.view.View view, int i_renamed, int i2, int i3, int i4) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        a_renamed();
        java.lang.reflect.Method method = f1675a;
        if (method != null) {
            try {
                method.invoke(view, java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4));
            } catch (java.lang.IllegalAccessException unused) {
            } catch (java.lang.reflect.InvocationTargetException e_renamed) {
                throw new java.lang.RuntimeException(e_renamed.getCause());
            }
        }
    }

    public void a_renamed(android.view.View view, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        if (!d_renamed) {
            try {
                f1677c = android.view.View.class.getDeclaredField("mViewFlags");
                f1677c.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
                android.util.Log.i_renamed("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            d_renamed = true;
        }
        java.lang.reflect.Field field = f1677c;
        if (field != null) {
            try {
                f1677c.setInt(view, (field.getInt(view) & (-13)) | i_renamed);
            } catch (java.lang.IllegalAccessException unused2) {
            }
        }
    }

    @android.annotation.SuppressLint({"PrivateApi"})
    private void a_renamed() {
        if (f1676b) {
            return;
        }
        try {
            f1675a = android.view.View.class.getDeclaredMethod("setFrame", java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE);
            f1675a.setAccessible(true);
        } catch (java.lang.NoSuchMethodException e_renamed) {
            android.util.Log.i_renamed("ViewUtilsBase", "Failed to retrieve setFrame method", e_renamed);
        }
        f1676b = true;
    }
}
