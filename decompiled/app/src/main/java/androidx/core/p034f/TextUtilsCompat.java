package androidx.core.p034f;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: TextUtilsCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public final class TextUtilsCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Locale f2934a = new Locale("", "");

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2525a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(f2934a)) {
            return 0;
        }
        String strM2506a = ICUCompat.m2506a(locale);
        if (strM2506a == null) {
            return m2526b(locale);
        }
        return (strM2506a.equalsIgnoreCase("Arab") || strM2506a.equalsIgnoreCase("Hebr")) ? 1 : 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int m2526b(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }
}
