package androidx.core.h_renamed;

/* compiled from: ViewConfigurationCompat.java */
/* loaded from: classes.dex */
public final class w_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f1003a;

    static {
        if (android.os.Build.VERSION.SDK_INT == 25) {
            try {
                f1003a = android.view.ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new java.lang.Class[0]);
            } catch (java.lang.Exception unused) {
                android.util.Log.i_renamed("ViewConfigCompat", "Could not find method getScaledScrollFactor() on_renamed ViewConfiguration");
            }
        }
    }

    public static float a_renamed(android.view.ViewConfiguration viewConfiguration, android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }
        return d_renamed(viewConfiguration, context);
    }

    public static float b_renamed(android.view.ViewConfiguration viewConfiguration, android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
        return d_renamed(viewConfiguration, context);
    }

    private static float d_renamed(android.view.ViewConfiguration viewConfiguration, android.content.Context context) {
        java.lang.reflect.Method method;
        if (android.os.Build.VERSION.SDK_INT >= 25 && (method = f1003a) != null) {
            try {
                return ((java.lang.Integer) method.invoke(viewConfiguration, new java.lang.Object[0])).intValue();
            } catch (java.lang.Exception unused) {
                android.util.Log.i_renamed("ViewConfigCompat", "Could not find method getScaledScrollFactor() on_renamed ViewConfiguration");
            }
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (context.getTheme().resolveAttribute(android.R_renamed.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static int a_renamed(android.view.ViewConfiguration viewConfiguration) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return viewConfiguration.getScaledHoverSlop();
        }
        return viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static boolean c_renamed(android.view.ViewConfiguration viewConfiguration, android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
        android.content.res.Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
        return identifier != 0 && resources.getBoolean(identifier);
    }
}
