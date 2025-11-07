package androidx.core.f_renamed;

/* compiled from: ICUCompat.java */
/* loaded from: classes.dex */
public final class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f895a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f896b;

    static {
        if (android.os.Build.VERSION.SDK_INT < 21) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("libcore.icu.ICU");
                if (cls != null) {
                    f895a = cls.getMethod("getScript", java.lang.String.class);
                    f896b = cls.getMethod("addLikelySubtags", java.lang.String.class);
                    return;
                }
                return;
            } catch (java.lang.Exception e_renamed) {
                f895a = null;
                f896b = null;
                android.util.Log.w_renamed("ICUCompat", e_renamed);
                return;
            }
        }
        if (android.os.Build.VERSION.SDK_INT < 24) {
            try {
                f896b = java.lang.Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", java.util.Locale.class);
            } catch (java.lang.Exception e2) {
                throw new java.lang.IllegalStateException(e2);
            }
        }
    }

    public static java.lang.String a_renamed(java.util.Locale locale) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return android.icu.util.ULocale.addLikelySubtags(android.icu.util.ULocale.forLocale(locale)).getScript();
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            try {
                return ((java.util.Locale) f896b.invoke(null, locale)).getScript();
            } catch (java.lang.IllegalAccessException e_renamed) {
                android.util.Log.w_renamed("ICUCompat", e_renamed);
                return locale.getScript();
            } catch (java.lang.reflect.InvocationTargetException e2) {
                android.util.Log.w_renamed("ICUCompat", e2);
                return locale.getScript();
            }
        }
        java.lang.String strB = b_renamed(locale);
        if (strB != null) {
            return a_renamed(strB);
        }
        return null;
    }

    private static java.lang.String a_renamed(java.lang.String str) {
        try {
            if (f895a != null) {
                return (java.lang.String) f895a.invoke(null, str);
            }
        } catch (java.lang.IllegalAccessException e_renamed) {
            android.util.Log.w_renamed("ICUCompat", e_renamed);
        } catch (java.lang.reflect.InvocationTargetException e2) {
            android.util.Log.w_renamed("ICUCompat", e2);
        }
        return null;
    }

    private static java.lang.String b_renamed(java.util.Locale locale) {
        java.lang.String string = locale.toString();
        try {
            if (f896b != null) {
                return (java.lang.String) f896b.invoke(null, string);
            }
        } catch (java.lang.IllegalAccessException e_renamed) {
            android.util.Log.w_renamed("ICUCompat", e_renamed);
        } catch (java.lang.reflect.InvocationTargetException e2) {
            android.util.Log.w_renamed("ICUCompat", e2);
        }
        return string;
    }
}
