package com.oplus.camera.util;

/* compiled from: StatusBarUtil.java */
/* loaded from: classes2.dex */
public class m_renamed {
    public static void a_renamed(android.app.Activity activity) {
        a_renamed(activity.getWindow(), a_renamed(activity.getBaseContext()));
    }

    private static void a_renamed(android.view.Window window, boolean z_renamed) {
        if (window == null) {
            return;
        }
        a_renamed(window);
        c_renamed(window, z_renamed);
    }

    public static void b_renamed(android.app.Activity activity) {
        b_renamed(activity.getWindow(), a_renamed(activity.getBaseContext()));
    }

    private static void b_renamed(android.view.Window window, boolean z_renamed) {
        if (window == null) {
            return;
        }
        b_renamed(window);
        c_renamed(window, z_renamed);
    }

    public static boolean a_renamed(android.content.Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static void a_renamed(android.view.Window window) {
        window.addFlags(67108864);
    }

    private static void b_renamed(android.view.Window window) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(com.oplus.camera.capmode.w_renamed.VIDEO_720P_WIDTH);
        window.setStatusBarColor(0);
    }

    private static void c_renamed(android.view.Window window, boolean z_renamed) {
        window.addFlags(Integer.MIN_VALUE);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (android.os.Build.VERSION.SDK_INT > 30) {
            android.view.WindowInsetsController windowInsetsController = window.getDecorView().getWindowInsetsController();
            int systemBarsAppearance = windowInsetsController.getSystemBarsAppearance();
            int i_renamed = !z_renamed ? systemBarsAppearance | 8 : systemBarsAppearance & (-9);
            windowInsetsController.setSystemBarsAppearance(i_renamed, i_renamed);
        } else if (android.os.Build.VERSION.SDK_INT >= 23) {
            systemUiVisibility = !z_renamed ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
        } else if (android.os.Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility = !z_renamed ? systemUiVisibility | 16 : systemUiVisibility & (-17);
        }
        window.getDecorView().setSystemUiVisibility(systemUiVisibility);
    }
}
