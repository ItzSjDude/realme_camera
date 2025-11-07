package androidx.core.f_renamed;

/* compiled from: TextUtilsCompat.java */
/* loaded from: classes.dex */
public final class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.Locale f915a = new java.util.Locale("", "");

    public static int a_renamed(java.util.Locale locale) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            return android.text.TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(f915a)) {
            return 0;
        }
        java.lang.String strA = androidx.core.f_renamed.b_renamed.a_renamed(locale);
        if (strA == null) {
            return b_renamed(locale);
        }
        return (strA.equalsIgnoreCase("Arab") || strA.equalsIgnoreCase("Hebr")) ? 1 : 0;
    }

    private static int b_renamed(java.util.Locale locale) {
        byte directionality = java.lang.Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }
}
