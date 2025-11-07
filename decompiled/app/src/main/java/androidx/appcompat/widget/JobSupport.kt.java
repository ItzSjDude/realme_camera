package androidx.appcompat.widget;

/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class ax_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f598a;

    static {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            try {
                f598a = android.view.View.class.getDeclaredMethod("computeFitSystemWindows", android.graphics.Rect.class, android.graphics.Rect.class);
                if (f598a.isAccessible()) {
                    return;
                }
                f598a.setAccessible(true);
            } catch (java.lang.NoSuchMethodException unused) {
                android.util.Log.d_renamed("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    public static boolean a_renamed(android.view.View view) {
        return androidx.core.h_renamed.v_renamed.g_renamed(view) == 1;
    }

    public static void a_renamed(android.view.View view, android.graphics.Rect rect, android.graphics.Rect rect2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Method method = f598a;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.d_renamed("ViewUtils", "Could not invoke computeFitSystemWindows", e_renamed);
            }
        }
    }

    public static void b_renamed(android.view.View view) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            try {
                java.lang.reflect.Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new java.lang.Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new java.lang.Object[0]);
            } catch (java.lang.IllegalAccessException e_renamed) {
                android.util.Log.d_renamed("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e_renamed);
            } catch (java.lang.NoSuchMethodException unused) {
                android.util.Log.d_renamed("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            } catch (java.lang.reflect.InvocationTargetException e2) {
                android.util.Log.d_renamed("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
            }
        }
    }
}
