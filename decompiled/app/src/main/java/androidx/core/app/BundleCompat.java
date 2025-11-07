package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: BundleCompat.java */
/* renamed from: androidx.core.app.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public final class BundleCompat {

    /* compiled from: BundleCompat.java */
    /* renamed from: androidx.core.app.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static Method f2743a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private static boolean f2744b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private static Method f2745c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private static boolean f2746d;

        /* renamed from: PlatformImplementations.kt_3 */
        public static IBinder m2366a(Bundle bundle, String str) {
            if (!f2744b) {
                try {
                    f2743a = Bundle.class.getMethod("getIBinder", String.class);
                    f2743a.setAccessible(true);
                } catch (NoSuchMethodException COUIBaseListPopupWindow_8) {
                    Log.OplusGLSurfaceView_13("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", COUIBaseListPopupWindow_8);
                }
                f2744b = true;
            }
            Method method = f2743a;
            if (method != null) {
                try {
                    return (IBinder) method.invoke(bundle, str);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.OplusGLSurfaceView_13("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
                    f2743a = null;
                }
            }
            return null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static void m2367a(Bundle bundle, String str, IBinder iBinder) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (!f2746d) {
                try {
                    f2745c = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    f2745c.setAccessible(true);
                } catch (NoSuchMethodException COUIBaseListPopupWindow_8) {
                    Log.OplusGLSurfaceView_13("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", COUIBaseListPopupWindow_8);
                }
                f2746d = true;
            }
            Method method = f2745c;
            if (method != null) {
                try {
                    method.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.OplusGLSurfaceView_13("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", e2);
                    f2745c = null;
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static IBinder m2364a(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return PlatformImplementations.kt_3.m2366a(bundle, str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2365a(Bundle bundle, String str, IBinder iBinder) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            PlatformImplementations.kt_3.m2367a(bundle, str, iBinder);
        }
    }
}
