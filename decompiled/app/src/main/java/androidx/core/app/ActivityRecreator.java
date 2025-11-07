package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: ActivityRecreator.java */
/* renamed from: androidx.core.app.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
final class ActivityRecreator {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final Handler f2731g = new Handler(Looper.getMainLooper());

    /* renamed from: PlatformImplementations.kt_3 */
    protected static final Class<?> f2725a = m2361d();

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected static final Field f2726b = m2357b();

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected static final Field f2727c = m2359c();

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected static final Method f2728d = m2353a(f2725a);

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected static final Method f2729e = m2358b(f2725a);

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected static final Method f2730f = m2360c(f2725a);

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean m2355a(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (m2354a() && f2730f == null) {
            return false;
        }
        if (f2729e == null && f2728d == null) {
            return false;
        }
        try {
            final Object obj2 = f2727c.get(activity);
            if (obj2 == null || (obj = f2726b.get(activity)) == null) {
                return false;
            }
            final Application application = activity.getApplication();
            final PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(activity);
            application.registerActivityLifecycleCallbacks(aVar);
            f2731g.post(new Runnable() { // from class: androidx.core.app.IntrinsicsJvm.kt_4.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.f2738a = obj2;
                }
            });
            try {
                if (m2354a()) {
                    f2730f.invoke(obj, obj2, null, null, 0, false, null, null, false, false);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                f2731g.post(new Runnable() { // from class: androidx.core.app.IntrinsicsJvm.kt_4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(aVar);
                    }
                });
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    /* compiled from: ActivityRecreator.java */
    /* renamed from: androidx.core.app.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 implements Application.ActivityLifecycleCallbacks {

        /* renamed from: PlatformImplementations.kt_3 */
        Object f2738a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Activity f2739b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f2740c = false;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f2741d = false;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private boolean f2742e = false;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        PlatformImplementations.kt_3(Activity activity) {
            this.f2739b = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f2739b == activity) {
                this.f2740c = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f2741d || this.f2742e || this.f2740c || !ActivityRecreator.m2356a(this.f2738a, activity)) {
                return;
            }
            this.f2742e = true;
            this.f2738a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f2739b == activity) {
                this.f2739b = null;
                this.f2741d = true;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected static boolean m2356a(Object obj, Activity activity) {
        try {
            final Object obj2 = f2727c.get(activity);
            if (obj2 != obj) {
                return false;
            }
            final Object obj3 = f2726b.get(activity);
            f2731g.postAtFrontOfQueue(new Runnable() { // from class: androidx.core.app.IntrinsicsJvm.kt_4.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ActivityRecreator.f2728d != null) {
                            ActivityRecreator.f2728d.invoke(obj3, obj2, false, "AppCompat recreation");
                        } else {
                            ActivityRecreator.f2729e.invoke(obj3, obj2, false);
                        }
                    } catch (RuntimeException COUIBaseListPopupWindow_8) {
                        if (COUIBaseListPopupWindow_8.getClass() == RuntimeException.class && COUIBaseListPopupWindow_8.getMessage() != null && COUIBaseListPopupWindow_8.getMessage().startsWith("Unable to stop")) {
                            throw COUIBaseListPopupWindow_8;
                        }
                    } catch (Throwable th) {
                        Log.COUIBaseListPopupWindow_8("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            Log.COUIBaseListPopupWindow_8("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Method m2353a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Method m2358b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m2354a() {
        return Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Method m2360c(Class<?> cls) {
        if (m2354a() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Field m2357b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Field m2359c() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Class<?> m2361d() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }
}
