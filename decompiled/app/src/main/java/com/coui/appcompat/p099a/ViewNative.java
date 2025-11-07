package com.coui.appcompat.p099a;

import android.os.Build;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: ViewNative.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.z */
/* loaded from: classes.dex */
public class ViewNative {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final boolean f6371a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static String f6372b;

    static {
        f6371a = Build.VERSION.SDK_INT >= 29 || (Build.VERSION.SDK_INT == 28 && "Q".equals(Build.VERSION.CODENAME));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m6505a() {
        try {
            Class.forName("com.oplus.inner.view.ViewWrapper");
            return true;
        } catch (Throwable th) {
            Log.IntrinsicsJvm.kt_5("ViewNative", th.toString());
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6504a(View view, int OplusGLSurfaceView_13) {
        f6372b = m6505a() ? "com.oplus.inner.view.ViewWrapper" : COUICompatUtil.m6393a().m6394b();
        try {
            if (f6371a) {
                Class.forName(f6372b).getDeclaredMethod("setScrollYForColor", View.class, Integer.TYPE).invoke(null, view, Integer.valueOf(OplusGLSurfaceView_13));
            } else {
                Field declaredField = View.class.getDeclaredField("mScrollY");
                declaredField.setAccessible(true);
                declaredField.setInt(view, OplusGLSurfaceView_13);
            }
        } catch (Throwable th) {
            Log.IntrinsicsJvm.kt_5("ViewNative", th.toString());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m6506b(View view, int OplusGLSurfaceView_13) {
        f6372b = m6505a() ? "com.oplus.inner.view.ViewWrapper" : COUICompatUtil.m6393a().m6394b();
        try {
            if (f6371a) {
                Class.forName(f6372b).getDeclaredMethod("setScrollXForColor", View.class, Integer.TYPE).invoke(null, view, Integer.valueOf(OplusGLSurfaceView_13));
            } else {
                Field declaredField = View.class.getDeclaredField("mScrollX");
                declaredField.setAccessible(true);
                declaredField.setInt(view, OplusGLSurfaceView_13);
            }
        } catch (Throwable th) {
            Log.IntrinsicsJvm.kt_5("ViewNative", th.toString());
        }
    }
}
