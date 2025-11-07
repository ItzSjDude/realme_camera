package androidx.core.app;

/* compiled from: ActivityRecreator.java */
/* loaded from: classes.dex */
final class b_renamed {
    private static final android.os.Handler g_renamed = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: a_renamed, reason: collision with root package name */
    protected static final java.lang.Class<?> f812a = d_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    protected static final java.lang.reflect.Field f813b = b_renamed();

    /* renamed from: c_renamed, reason: collision with root package name */
    protected static final java.lang.reflect.Field f814c = c_renamed();
    protected static final java.lang.reflect.Method d_renamed = a_renamed(f812a);
    protected static final java.lang.reflect.Method e_renamed = b_renamed(f812a);
    protected static final java.lang.reflect.Method f_renamed = c_renamed(f812a);

    static boolean a_renamed(android.app.Activity activity) {
        java.lang.Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (a_renamed() && f_renamed == null) {
            return false;
        }
        if (e_renamed == null && d_renamed == null) {
            return false;
        }
        try {
            final java.lang.Object obj2 = f814c.get(activity);
            if (obj2 == null || (obj = f813b.get(activity)) == null) {
                return false;
            }
            final android.app.Application application = activity.getApplication();
            final androidx.core.app.b_renamed.a_renamed aVar = new androidx.core.app.b_renamed.a_renamed(activity);
            application.registerActivityLifecycleCallbacks(aVar);
            g_renamed.post(new java.lang.Runnable() { // from class: androidx.core.app.b_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.f821a = obj2;
                }
            });
            try {
                if (a_renamed()) {
                    f_renamed.invoke(obj, obj2, null, null, 0, false, null, null, false, false);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                g_renamed.post(new java.lang.Runnable() { // from class: androidx.core.app.b_renamed.2
                    @Override // java.lang.Runnable
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(aVar);
                    }
                });
            }
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    /* compiled from: ActivityRecreator.java */
    private static final class a_renamed implements android.app.Application.ActivityLifecycleCallbacks {

        /* renamed from: a_renamed, reason: collision with root package name */
        java.lang.Object f821a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.app.Activity f822b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f823c = false;
        private boolean d_renamed = false;
        private boolean e_renamed = false;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
        }

        a_renamed(android.app.Activity activity) {
            this.f822b = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
            if (this.f822b == activity) {
                this.f823c = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
            if (!this.d_renamed || this.e_renamed || this.f823c || !androidx.core.app.b_renamed.a_renamed(this.f821a, activity)) {
                return;
            }
            this.e_renamed = true;
            this.f821a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
            if (this.f822b == activity) {
                this.f822b = null;
                this.d_renamed = true;
            }
        }
    }

    protected static boolean a_renamed(java.lang.Object obj, android.app.Activity activity) {
        try {
            final java.lang.Object obj2 = f814c.get(activity);
            if (obj2 != obj) {
                return false;
            }
            final java.lang.Object obj3 = f813b.get(activity);
            g_renamed.postAtFrontOfQueue(new java.lang.Runnable() { // from class: androidx.core.app.b_renamed.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (androidx.core.app.b_renamed.d_renamed != null) {
                            androidx.core.app.b_renamed.d_renamed.invoke(obj3, obj2, false, "AppCompat recreation");
                        } else {
                            androidx.core.app.b_renamed.e_renamed.invoke(obj3, obj2, false);
                        }
                    } catch (java.lang.RuntimeException e2) {
                        if (e2.getClass() == java.lang.RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                            throw e2;
                        }
                    } catch (java.lang.Throwable th) {
                        android.util.Log.e_renamed("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    }
                }
            });
            return true;
        } catch (java.lang.Throwable th) {
            android.util.Log.e_renamed("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    private static java.lang.reflect.Method a_renamed(java.lang.Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("performStopActivity", android.os.IBinder.class, java.lang.Boolean.TYPE, java.lang.String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.reflect.Method b_renamed(java.lang.Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("performStopActivity", android.os.IBinder.class, java.lang.Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static boolean a_renamed() {
        return android.os.Build.VERSION.SDK_INT == 26 || android.os.Build.VERSION.SDK_INT == 27;
    }

    private static java.lang.reflect.Method c_renamed(java.lang.Class<?> cls) {
        if (a_renamed() && cls != null) {
            try {
                java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", android.os.IBinder.class, java.util.List.class, java.util.List.class, java.lang.Integer.TYPE, java.lang.Boolean.TYPE, android.content.res.Configuration.class, android.content.res.Configuration.class, java.lang.Boolean.TYPE, java.lang.Boolean.TYPE);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (java.lang.Throwable unused) {
            }
        }
        return null;
    }

    private static java.lang.reflect.Field b_renamed() {
        try {
            java.lang.reflect.Field declaredField = android.app.Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.reflect.Field c_renamed() {
        try {
            java.lang.reflect.Field declaredField = android.app.Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.Class<?> d_renamed() {
        try {
            return java.lang.Class.forName("android.app.ActivityThread");
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
