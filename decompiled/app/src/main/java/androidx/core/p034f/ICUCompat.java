package androidx.core.p034f;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public final class ICUCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Method f2906a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Method f2907b;

    static {
        if (Build.VERSION.SDK_INT < 21) {
            try {
                Class<?> cls = Class.forName("libcore.icu.ICU");
                if (cls != null) {
                    f2906a = cls.getMethod("getScript", String.class);
                    f2907b = cls.getMethod("addLikelySubtags", String.class);
                    return;
                }
                return;
            } catch (Exception COUIBaseListPopupWindow_8) {
                f2906a = null;
                f2907b = null;
                Log.w("ICUCompat", COUIBaseListPopupWindow_8);
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f2907b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m2506a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f2907b.invoke(null, locale)).getScript();
            } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
                Log.w("ICUCompat", COUIBaseListPopupWindow_8);
                return locale.getScript();
            } catch (InvocationTargetException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            }
        }
        String strM2507b = m2507b(locale);
        if (strM2507b != null) {
            return m2505a(strM2507b);
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m2505a(String str) {
        try {
            if (f2906a != null) {
                return (String) f2906a.invoke(null, str);
            }
        } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
            Log.w("ICUCompat", COUIBaseListPopupWindow_8);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static String m2507b(Locale locale) {
        String string = locale.toString();
        try {
            if (f2907b != null) {
                return (String) f2907b.invoke(null, string);
            }
        } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
            Log.w("ICUCompat", COUIBaseListPopupWindow_8);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return string;
    }
}
