package com.coui.appcompat.p099a;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

/* compiled from: COUINavigationBarUtil.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class COUINavigationBarUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Uri f6333a = Settings.Secure.getUriFor("nav_bar_immersive");

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m6431a(Context context) throws ClassNotFoundException {
        if (context == null) {
            return false;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
            if ("1".equals(str)) {
                return false;
            }
            if ("0".equals(str)) {
                return true;
            }
            return z;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.IntrinsicsJvm.kt_5("NavigationBarUtils", "fail to get navigation bar status message is " + COUIBaseListPopupWindow_8.getMessage());
            return z;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m6432b(Context context) {
        if (!m6431a(context)) {
            return false;
        }
        int OplusGLSurfaceView_13 = Settings.Secure.getInt(context.getContentResolver(), "hide_navigationbar_enable", 0);
        return OplusGLSurfaceView_13 == 0 || (OplusGLSurfaceView_13 == 1 && Settings.Secure.getInt(context.getContentResolver(), "manual_hide_navigationbar", 0) == 0) || Build.VERSION.SDK_INT > 30;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m6433c(Context context) throws Resources.NotFoundException {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
        if (displayMetrics2.density == displayMetrics.density) {
            return dimensionPixelSize;
        }
        return (int) ((dimensionPixelSize * (displayMetrics2.density / displayMetrics.density)) + 0.5f);
    }
}
