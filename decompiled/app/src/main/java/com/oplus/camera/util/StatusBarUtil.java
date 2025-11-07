package com.oplus.camera.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowInsetsController;
import com.oplus.camera.capmode.VideoMode;

/* compiled from: StatusBarUtil.java */
/* renamed from: com.oplus.camera.util.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public class StatusBarUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24602a(Activity activity) {
        m24604a(activity.getWindow(), m24605a(activity.getBaseContext()));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m24604a(Window window, boolean z) {
        if (window == null) {
            return;
        }
        m24603a(window);
        m24609c(window, z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m24606b(Activity activity) {
        m24608b(activity.getWindow(), m24605a(activity.getBaseContext()));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m24608b(Window window, boolean z) {
        if (window == null) {
            return;
        }
        m24607b(window);
        m24609c(window, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24605a(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m24603a(Window window) {
        window.addFlags(67108864);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m24607b(Window window) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(VideoMode.VIDEO_720P_WIDTH);
        window.setStatusBarColor(0);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static void m24609c(Window window, boolean z) {
        window.addFlags(Integer.MIN_VALUE);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (Build.VERSION.SDK_INT > 30) {
            WindowInsetsController windowInsetsController = window.getDecorView().getWindowInsetsController();
            int systemBarsAppearance = windowInsetsController.getSystemBarsAppearance();
            int OplusGLSurfaceView_13 = !z ? systemBarsAppearance | 8 : systemBarsAppearance & (-9);
            windowInsetsController.setSystemBarsAppearance(OplusGLSurfaceView_13, OplusGLSurfaceView_13);
        } else if (Build.VERSION.SDK_INT >= 23) {
            systemUiVisibility = !z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
        } else if (Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility = !z ? systemUiVisibility | 16 : systemUiVisibility & (-17);
        }
        window.getDecorView().setSystemUiVisibility(systemUiVisibility);
    }
}
