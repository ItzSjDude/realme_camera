package androidx.core.app;

/* compiled from: BundleCompat.java */
/* loaded from: classes.dex */
public final class d_renamed {

    /* compiled from: BundleCompat.java */
    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static java.lang.reflect.Method f824a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private static boolean f825b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private static java.lang.reflect.Method f826c;
        private static boolean d_renamed;

        public static android.os.IBinder a_renamed(android.os.Bundle bundle, java.lang.String str) {
            if (!f825b) {
                try {
                    f824a = android.os.Bundle.class.getMethod("getIBinder", java.lang.String.class);
                    f824a.setAccessible(true);
                } catch (java.lang.NoSuchMethodException e_renamed) {
                    android.util.Log.i_renamed("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e_renamed);
                }
                f825b = true;
            }
            java.lang.reflect.Method method = f824a;
            if (method != null) {
                try {
                    return (android.os.IBinder) method.invoke(bundle, str);
                } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.reflect.InvocationTargetException e2) {
                    android.util.Log.i_renamed("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
                    f824a = null;
                }
            }
            return null;
        }

        public static void a_renamed(android.os.Bundle bundle, java.lang.String str, android.os.IBinder iBinder) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (!d_renamed) {
                try {
                    f826c = android.os.Bundle.class.getMethod("putIBinder", java.lang.String.class, android.os.IBinder.class);
                    f826c.setAccessible(true);
                } catch (java.lang.NoSuchMethodException e_renamed) {
                    android.util.Log.i_renamed("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e_renamed);
                }
                d_renamed = true;
            }
            java.lang.reflect.Method method = f826c;
            if (method != null) {
                try {
                    method.invoke(bundle, str, iBinder);
                } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.reflect.InvocationTargetException e2) {
                    android.util.Log.i_renamed("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", e2);
                    f826c = null;
                }
            }
        }
    }

    public static android.os.IBinder a_renamed(android.os.Bundle bundle, java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return androidx.core.app.d_renamed.a_renamed.a_renamed(bundle, str);
    }

    public static void a_renamed(android.os.Bundle bundle, java.lang.String str, android.os.IBinder iBinder) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            androidx.core.app.d_renamed.a_renamed.a_renamed(bundle, str, iBinder);
        }
    }
}
