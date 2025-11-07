package com.oplus.camera;

/* loaded from: classes2.dex */
public class MyApplication extends android.app.Application {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static android.content.Context f4057a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static com.oplus.ocs.camera.CameraUnitClient f4058b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static boolean f4059c;
    private static java.util.Stack<android.app.Activity> d_renamed = new java.util.Stack<>();
    private static com.oplus.camera.e_renamed.d_renamed e_renamed = null;
    private android.os.ConditionVariable f_renamed = new android.os.ConditionVariable();
    private android.os.ConditionVariable g_renamed = new android.os.ConditionVariable();

    public static com.oplus.camera.e_renamed.d_renamed a_renamed() {
        if (e_renamed == null) {
            e_renamed = new com.oplus.camera.e_renamed.f_renamed();
        }
        return e_renamed;
    }

    public static boolean b_renamed() {
        return f4059c;
    }

    public static void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("MyApplication", "finishActivities E_renamed");
        while (!d_renamed.isEmpty()) {
            android.app.Activity activityPop = d_renamed.pop();
            com.oplus.camera.e_renamed.a_renamed("MyApplication", "finishActivities, activity: " + activityPop);
            if (!activityPop.isFinishing()) {
                activityPop.finishAndRemoveTask();
            }
        }
        com.oplus.camera.e_renamed.a_renamed("MyApplication", "finishActivities X_renamed");
    }

    public static android.content.Context d_renamed() {
        return f4057a;
    }

    public static void e_renamed() {
        java.util.Iterator<android.app.Activity> it = d_renamed.iterator();
        while (it.hasNext()) {
            android.app.Activity next = it.next();
            if ((next instanceof com.oplus.camera.CameraImageActivity) && !next.isFinishing()) {
                com.oplus.camera.e_renamed.a_renamed("MyApplication", "finishCameraImageActivityIfExist activity: " + next);
                next.finish();
            }
        }
    }

    public static com.oplus.ocs.camera.CameraUnitClient f_renamed() {
        return f4058b;
    }

    public static void a_renamed(android.content.Context context) {
        if (f4058b != null) {
            com.oplus.camera.e_renamed.f_renamed("MyApplication", "initCameraUnit, already init");
        } else if (com.oplus.camera.h_renamed.a_renamed(context)) {
            f4058b = com.oplus.ocs.camera.CameraUnit.getCameraClient(f4057a);
        } else {
            com.oplus.camera.e_renamed.f_renamed("MyApplication", "initCameraUnit, without camera permission, init CameraUnit failed! ");
        }
    }

    public static boolean g_renamed() {
        java.util.Iterator<android.app.Activity> it = d_renamed.iterator();
        while (it.hasNext()) {
            android.app.Activity next = it.next();
            if ((next instanceof com.oplus.camera.Camera) && !next.isFinishing() && next.getWindow().getDecorView().getVisibility() == 0) {
                com.oplus.camera.e_renamed.a_renamed("MyApplication", "isCameraActivityRunning, activity: " + next);
                return true;
            }
        }
        return false;
    }

    public static void h_renamed() {
        java.util.Iterator<android.app.Activity> it = d_renamed.iterator();
        while (it.hasNext()) {
            android.app.Activity next = it.next();
            if ((next instanceof com.oplus.camera.ui.menu.setting.l_renamed) && !next.isFinishing()) {
                com.oplus.camera.e_renamed.a_renamed("MyApplication", "finishCameraSettingBaseActivityIfExist activity: " + next);
                next.finish();
            }
        }
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(android.content.Context context) {
        super.attachBaseContext(com.oplus.camera.util.Util.q_renamed(context));
        com.oplus.camera.e_renamed.a_renamed("attachBaseContext");
        com.oplus.camera.util.Util.a_renamed(this);
        com.oplus.camera.e_renamed.b_renamed("attachBaseContext");
    }

    private void b_renamed(final android.content.Context context) {
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.MyApplication.1
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.util.Util.b_renamed(context);
                com.oplus.camera.aps.config.CameraConfig.initialize(context);
                com.oplus.camera.e_renamed.a_renamed.a_renamed(context);
                com.oplus.camera.util.Util.d_renamed(com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HW_MANUFACTURER_QUALCOMM));
                com.oplus.camera.MyApplication.this.f_renamed.open();
                com.oplus.camera.MyApplication.this.g_renamed.open();
                com.oplus.camera.util.Util.c_renamed(context);
                com.oplus.camera.MyApplication.this.p_renamed();
                if (com.oplus.camera.util.Util.t_renamed()) {
                    com.oplus.camera.MyApplication.f4057a.startService(new android.content.Intent(com.oplus.camera.MyApplication.f4057a, (java.lang.Class<?>) com.oplus.camera.screen.FolderAngleDetectService.class));
                }
                com.oplus.compat.b_renamed.a_renamed.a_renamed.a_renamed(context);
                com.oplus.camera.MyApplication.this.m_renamed();
                com.oplus.camera.e_renamed.a_renamed(context);
                com.oplus.camera.statistics.model.DcsMsgData.init(context);
            }
        }, "Camera Initialize");
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.-$$Lambda$8Dx7trwBYg9W64pF8jpKEwJajzQ
            @Override // java.lang.Runnable
            public final void run() {
                com.oplus.camera.l_renamed.a_renamed.a_renamed();
            }
        }, "init MyRegionAdapter");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_renamed() {
        com.oplus.camera.e_renamed.b_renamed("MyApplication", "checkTuningUpgrade");
        try {
            android.content.SharedPreferences sharedPreferencesA = androidx.preference.j_renamed.a_renamed(this);
            if (sharedPreferencesA == null) {
                com.oplus.camera.e_renamed.b_renamed("MyApplication", "checkTuningUpgrade, cannot get SharedPreferences");
                n_renamed();
            } else {
                int i_renamed = sharedPreferencesA.getInt("copy_tuning_file_state", 0);
                if (i_renamed == 0 || 1 == i_renamed) {
                    n_renamed();
                }
            }
        } catch (java.lang.Exception e2) {
            com.oplus.camera.e_renamed.e_renamed("MyApplication", "checkTuningUpgrade, ex_renamed: " + e2.getMessage());
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        if (android.os.Build.VERSION.SDK_INT > 23) {
            com.oplus.camera.util.Util.f_renamed(getApplicationContext());
            com.oplus.camera.util.Util.f7298b = configuration.densityDpi;
            com.oplus.camera.util.Util.f7299c = configuration.fontScale;
            configuration.densityDpi = com.oplus.camera.util.Util.f7297a;
            com.oplus.camera.e_renamed.b_renamed("MyApplication", "onConfigurationChanged, config sDefaultDensity: " + com.oplus.camera.util.Util.f7297a + ", sysDensityDpi: " + com.oplus.camera.util.Util.f7298b + ", sysFontScale: " + com.oplus.camera.util.Util.f7299c);
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Application
    public void onCreate() {
        com.oplus.camera.e_renamed.a_renamed("CameraStartupPerformance.onCameraApplicationCreated");
        f4057a = this;
        a_renamed(f4057a);
        b_renamed((android.content.Context) this);
        super.onCreate();
        com.oplus.camera.util.Util.f_renamed(getApplicationContext());
        com.oplus.camera.util.Util.q_renamed(getApplicationContext());
        com.oplus.camera.Storage.a_renamed(getApplicationContext());
        o_renamed();
        com.oplus.camera.e_renamed.b_renamed("CameraStartupPerformance.onCameraApplicationCreated");
    }

    public void i_renamed() {
        this.f_renamed.block();
        com.oplus.camera.e_renamed.a_renamed("MyApplication", "checkPreInitStatus X_renamed");
    }

    public void j_renamed() {
        this.g_renamed.block();
        com.oplus.camera.e_renamed.a_renamed("MyApplication", "checkPreviewConfigStatus X_renamed");
    }

    private void n_renamed() {
        android.content.Intent intent = new android.content.Intent(this, (java.lang.Class<?>) com.oplus.camera.tuningupgrade.TuningParameterUpgradeService.class);
        intent.setAction("com.oplus.camera.TUNING_UPGRADE");
        intent.putExtra("from", "MyApplication");
        intent.putExtra(com.oplus.camera.statistics.CameraStatisticsUtil.RUS_FILE_VERSION, "1.0");
        intent.putExtra("code", "camera_tuning_upgrade");
        startService(intent);
    }

    private void o_renamed() {
        registerActivityLifecycleCallbacks(new android.app.Application.ActivityLifecycleCallbacks() { // from class: com.oplus.camera.MyApplication.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(android.app.Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(android.app.Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(android.app.Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(android.app.Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
                com.oplus.camera.e_renamed.a_renamed("MyApplication", "onActivityCreated, activity: " + activity);
                com.oplus.camera.MyApplication.d_renamed.push(activity);
                if (1 == com.oplus.camera.MyApplication.d_renamed.size() && (activity instanceof com.oplus.camera.Camera)) {
                    com.oplus.camera.j_renamed.a_renamed().e_renamed();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(android.app.Activity activity) {
                com.oplus.camera.e_renamed.a_renamed("MyApplication", "onActivityDestroyed, activity: " + activity);
                if (com.oplus.camera.MyApplication.d_renamed.contains(activity)) {
                    com.oplus.camera.MyApplication.d_renamed.remove(activity);
                }
            }
        });
    }

    @Override // android.app.Application
    public void onTerminate() {
        com.oplus.camera.util.Util.k_renamed();
        com.oplus.camera.w_renamed.d_renamed.a_renamed().c_renamed();
        a_renamed().d_renamed();
        super.onTerminate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p_renamed() {
        android.content.Intent intent = new android.content.Intent(this, (java.lang.Class<?>) com.oplus.camera.aps.service.ApsService.class);
        try {
            com.oplus.camera.e_renamed.a_renamed("MyApplication", "startDaemonService, stopService and startForegroundService");
            stopService(intent);
            startForegroundService(intent);
        } catch (java.lang.IllegalStateException e2) {
            e2.printStackTrace();
        }
    }
}
