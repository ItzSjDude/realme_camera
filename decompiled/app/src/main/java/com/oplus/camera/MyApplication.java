package com.oplus.camera;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.preference.PreferenceManager;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.service.ApsService;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.OneCameraProxy;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p153l.MyRegionAdapter;
import com.oplus.camera.p172ui.menu.setting.CameraSettingBaseActivity;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.screen.FolderAngleDetectService;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.tuningupgrade.TuningParameterUpgradeService;
import com.oplus.camera.util.Util;
import com.oplus.compat.p183b.p184a.AdapterHelper_4;
import com.oplus.ocs.camera.CameraUnit;
import com.oplus.ocs.camera.CameraUnitClient;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes2.dex */
public class MyApplication extends Application {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Context f11233a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static CameraUnitClient f11234b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean f11235c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Stack<Activity> f11236d = new Stack<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static OneCamera f11237e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ConditionVariable f11238f = new ConditionVariable();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ConditionVariable f11239g = new ConditionVariable();

    /* renamed from: PlatformImplementations.kt_3 */
    public static OneCamera m11085a() {
        if (f11237e == null) {
            f11237e = new OneCameraProxy();
        }
        return f11237e;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m11089b() {
        return f11235c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m11090c() {
        CameraLog.m12954a("MyApplication", "finishActivities E");
        while (!f11236d.isEmpty()) {
            Activity activityPop = f11236d.pop();
            CameraLog.m12954a("MyApplication", "finishActivities, activity: " + activityPop);
            if (!activityPop.isFinishing()) {
                activityPop.finishAndRemoveTask();
            }
        }
        CameraLog.m12954a("MyApplication", "finishActivities X");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static Context m11092d() {
        return f11233a;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m11094e() {
        Iterator<Activity> it = f11236d.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if ((next instanceof CameraImageActivity) && !next.isFinishing()) {
                CameraLog.m12954a("MyApplication", "finishCameraImageActivityIfExist activity: " + next);
                next.finish();
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static CameraUnitClient m11095f() {
        return f11234b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m11086a(Context context) {
        if (f11234b != null) {
            CameraLog.m12967f("MyApplication", "initCameraUnit, already init");
        } else if (CameraPermission.m14305a(context)) {
            f11234b = CameraUnit.getCameraClient(f11233a);
        } else {
            CameraLog.m12967f("MyApplication", "initCameraUnit, without camera permission, init CameraUnit failed! ");
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static boolean m11096g() {
        Iterator<Activity> it = f11236d.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if ((next instanceof Camera) && !next.isFinishing() && next.getWindow().getDecorView().getVisibility() == 0) {
                CameraLog.m12954a("MyApplication", "isCameraActivityRunning, activity: " + next);
                return true;
            }
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static void m11097h() {
        Iterator<Activity> it = f11236d.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if ((next instanceof CameraSettingBaseActivity) && !next.isFinishing()) {
                CameraLog.m12954a("MyApplication", "finishCameraSettingBaseActivityIfExist activity: " + next);
                next.finish();
            }
        }
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(Util.m24489q(context));
        CameraLog.m12952a("attachBaseContext");
        Util.m24257a(this);
        CameraLog.m12958b("attachBaseContext");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m11088b(final Context context) {
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.MyApplication.1
            @Override // java.lang.Runnable
            public void run() {
                Util.m24385b(context);
                CameraConfig.initialize(context);
                CameraCharacteristicsUtil.m12973a(context);
                Util.m24431d(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_HW_MANUFACTURER_QUALCOMM));
                MyApplication.this.f11238f.open();
                MyApplication.this.f11239g.open();
                Util.m24415c(context);
                MyApplication.this.m11103p();
                if (Util.m24495t()) {
                    MyApplication.f11233a.startService(new Intent(MyApplication.f11233a, (Class<?>) FolderAngleDetectService.class));
                }
                AdapterHelper_4.m24883a(context);
                MyApplication.this.m11100m();
                CameraLog.m12951a(context);
                DcsMsgData.init(context);
            }
        }, "Camera Initialize");
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.-$$Lambda$8Dx7trwBYg9W64pF8jpKEwJajzQ
            @Override // java.lang.Runnable
            public final void run() {
                MyRegionAdapter.m14511a();
            }
        }, "init MyRegionAdapter");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public void m11100m() {
        CameraLog.m12959b("MyApplication", "checkTuningUpgrade");
        try {
            SharedPreferences sharedPreferencesM3981a = PreferenceManager.m3981a(this);
            if (sharedPreferencesM3981a == null) {
                CameraLog.m12959b("MyApplication", "checkTuningUpgrade, cannot get SharedPreferences");
                m11101n();
            } else {
                int OplusGLSurfaceView_13 = sharedPreferencesM3981a.getInt("copy_tuning_file_state", 0);
                if (OplusGLSurfaceView_13 == 0 || 1 == OplusGLSurfaceView_13) {
                    m11101n();
                }
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("MyApplication", "checkTuningUpgrade, ex: " + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT > 23) {
            Util.m24450f(getApplicationContext());
            Util.f22994b = configuration.densityDpi;
            Util.f22995c = configuration.fontScale;
            configuration.densityDpi = Util.f22962a;
            CameraLog.m12959b("MyApplication", "onConfigurationChanged, config sDefaultDensity: " + Util.f22962a + ", sysDensityDpi: " + Util.f22994b + ", sysFontScale: " + Util.f22995c);
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Application
    public void onCreate() {
        CameraLog.m12952a("CameraStartupPerformance.onCameraApplicationCreated");
        f11233a = this;
        m11086a(f11233a);
        m11088b((Context) this);
        super.onCreate();
        Util.m24450f(getApplicationContext());
        Util.m24489q(getApplicationContext());
        Storage.m11111a(getApplicationContext());
        m11102o();
        CameraLog.m12958b("CameraStartupPerformance.onCameraApplicationCreated");
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m11104i() {
        this.f11238f.block();
        CameraLog.m12954a("MyApplication", "checkPreInitStatus X");
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m11105j() {
        this.f11239g.block();
        CameraLog.m12954a("MyApplication", "checkPreviewConfigStatus X");
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m11101n() {
        Intent intent = new Intent(this, (Class<?>) TuningParameterUpgradeService.class);
        intent.setAction("com.oplus.camera.TUNING_UPGRADE");
        intent.putExtra("from", "MyApplication");
        intent.putExtra(CameraStatisticsUtil.RUS_FILE_VERSION, "1.0");
        intent.putExtra("code", "camera_tuning_upgrade");
        startService(intent);
    }

    /* renamed from: o */
    private void m11102o() {
        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.oplus.camera.MyApplication.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                CameraLog.m12954a("MyApplication", "onActivityCreated, activity: " + activity);
                MyApplication.f11236d.push(activity);
                if (1 == MyApplication.f11236d.size() && (activity instanceof Camera)) {
                    CameraTipsManager.m14374a().m14380e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                CameraLog.m12954a("MyApplication", "onActivityDestroyed, activity: " + activity);
                if (MyApplication.f11236d.contains(activity)) {
                    MyApplication.f11236d.remove(activity);
                }
            }
        });
    }

    @Override // android.app.Application
    public void onTerminate() {
        Util.m24469k();
        CameraThreadExector.m24695a().m24698c();
        m11085a().mo13081d();
        super.onTerminate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m11103p() {
        Intent intent = new Intent(this, (Class<?>) ApsService.class);
        try {
            CameraLog.m12954a("MyApplication", "startDaemonService, stopService and startForegroundService");
            stopService(intent);
            startForegroundService(intent);
        } catch (IllegalStateException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }
}
