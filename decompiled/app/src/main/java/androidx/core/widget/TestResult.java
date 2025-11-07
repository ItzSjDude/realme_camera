package androidx.core.widget;

/* compiled from: PopupWindowCompat.java */
/* loaded from: classes.dex */
public final class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f1027a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f1028b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.lang.reflect.Field f1029c;
    private static boolean d_renamed;

    public static void a_renamed(android.widget.PopupWindow popupWindow, android.view.View view, int i_renamed, int i2, int i3) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, i_renamed, i2, i3);
            return;
        }
        if ((androidx.core.h_renamed.c_renamed.a_renamed(i3, androidx.core.h_renamed.v_renamed.g_renamed(view)) & 7) == 5) {
            i_renamed -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i_renamed, i2);
    }

    public static void a_renamed(android.widget.PopupWindow popupWindow, boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z_renamed);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            if (!d_renamed) {
                try {
                    f1029c = android.widget.PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f1029c.setAccessible(true);
                } catch (java.lang.NoSuchFieldException e_renamed) {
                    android.util.Log.i_renamed("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e_renamed);
                }
                d_renamed = true;
            }
            java.lang.reflect.Field field = f1029c;
            if (field != null) {
                try {
                    field.set(popupWindow, java.lang.Boolean.valueOf(z_renamed));
                } catch (java.lang.IllegalAccessException e2) {
                    android.util.Log.i_renamed("PopupWindowCompatApi21", "Could not set overlap anchor field in_renamed PopupWindow", e2);
                }
            }
        }
    }

    public static void a_renamed(android.widget.PopupWindow popupWindow, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i_renamed);
            return;
        }
        if (!f1028b) {
            try {
                f1027a = android.widget.PopupWindow.class.getDeclaredMethod("setWindowLayoutType", java.lang.Integer.TYPE);
                f1027a.setAccessible(true);
            } catch (java.lang.Exception unused) {
            }
            f1028b = true;
        }
        java.lang.reflect.Method method = f1027a;
        if (method != null) {
            try {
                method.invoke(popupWindow, java.lang.Integer.valueOf(i_renamed));
            } catch (java.lang.Exception unused2) {
            }
        }
    }
}
