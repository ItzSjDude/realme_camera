package com.coui.appcompat.a_renamed;

/* compiled from: COUINavigationBarUtil.java */
/* loaded from: classes.dex */
public class k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.net.Uri f2393a = android.provider.Settings.Secure.getUriFor("nav_bar_immersive");

    public static boolean a_renamed(android.content.Context context) throws java.lang.ClassNotFoundException {
        if (context == null) {
            return false;
        }
        android.content.res.Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z_renamed = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            java.lang.String str = (java.lang.String) cls.getMethod("get", java.lang.String.class).invoke(cls, "qemu.hw.mainkeys");
            if ("1".equals(str)) {
                return false;
            }
            if ("0".equals(str)) {
                return true;
            }
            return z_renamed;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.d_renamed("NavigationBarUtils", "fail to get navigation bar status message is_renamed " + e_renamed.getMessage());
            return z_renamed;
        }
    }

    public static boolean b_renamed(android.content.Context context) {
        if (!a_renamed(context)) {
            return false;
        }
        int i_renamed = android.provider.Settings.Secure.getInt(context.getContentResolver(), "hide_navigationbar_enable", 0);
        return i_renamed == 0 || (i_renamed == 1 && android.provider.Settings.Secure.getInt(context.getContentResolver(), "manual_hide_navigationbar", 0) == 0) || android.os.Build.VERSION.SDK_INT > 30;
    }

    public static int c_renamed(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        if (context == null) {
            return 0;
        }
        android.content.res.Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        android.util.DisplayMetrics displayMetrics2 = new android.util.DisplayMetrics();
        ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
        if (displayMetrics2.density == displayMetrics.density) {
            return dimensionPixelSize;
        }
        return (int) ((dimensionPixelSize * (displayMetrics2.density / displayMetrics.density)) + 0.5f);
    }
}
