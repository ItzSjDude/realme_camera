package com.coui.appcompat.a_renamed;

/* compiled from: ViewNative.java */
/* loaded from: classes.dex */
public class z_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final boolean f2415a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.String f2416b;

    static {
        f2415a = android.os.Build.VERSION.SDK_INT >= 29 || (android.os.Build.VERSION.SDK_INT == 28 && "Q_renamed".equals(android.os.Build.VERSION.CODENAME));
    }

    private static boolean a_renamed() {
        try {
            java.lang.Class.forName("com.oplus.inner.view.ViewWrapper");
            return true;
        } catch (java.lang.Throwable th) {
            android.util.Log.d_renamed("ViewNative", th.toString());
            return false;
        }
    }

    public static void a_renamed(android.view.View view, int i_renamed) {
        f2416b = a_renamed() ? "com.oplus.inner.view.ViewWrapper" : com.coui.appcompat.a_renamed.c_renamed.a_renamed().b_renamed();
        try {
            if (f2415a) {
                java.lang.Class.forName(f2416b).getDeclaredMethod("setScrollYForColor", android.view.View.class, java.lang.Integer.TYPE).invoke(null, view, java.lang.Integer.valueOf(i_renamed));
            } else {
                java.lang.reflect.Field declaredField = android.view.View.class.getDeclaredField("mScrollY");
                declaredField.setAccessible(true);
                declaredField.setInt(view, i_renamed);
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.d_renamed("ViewNative", th.toString());
        }
    }

    public static void b_renamed(android.view.View view, int i_renamed) {
        f2416b = a_renamed() ? "com.oplus.inner.view.ViewWrapper" : com.coui.appcompat.a_renamed.c_renamed.a_renamed().b_renamed();
        try {
            if (f2415a) {
                java.lang.Class.forName(f2416b).getDeclaredMethod("setScrollXForColor", android.view.View.class, java.lang.Integer.TYPE).invoke(null, view, java.lang.Integer.valueOf(i_renamed));
            } else {
                java.lang.reflect.Field declaredField = android.view.View.class.getDeclaredField("mScrollX");
                declaredField.setAccessible(true);
                declaredField.setInt(view, i_renamed);
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.d_renamed("ViewNative", th.toString());
        }
    }
}
