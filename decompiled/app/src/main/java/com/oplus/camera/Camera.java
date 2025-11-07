package com.oplus.camera;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.OplusPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Size;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.p044e.p045a.LocalBroadcastManager;
import com.android.providers.downloads.Downloads;
import com.coui.appcompat.p099a.COUIThemeOverlay;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.oplus.camera.CameraPermission;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.service.ApsService;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p153l.RegionCommonFeatureAdapter;
import com.oplus.camera.p160q.DocumentUtil;
import com.oplus.camera.p172ui.BackgroundSplitManager;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.ThumbnailHolder;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.perf.CameraPerformance;
import com.oplus.camera.perf.CameraExitPerformance;
import com.oplus.camera.perf.FluencyPerformance;
import com.oplus.camera.perf.LaunchPerformance;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.EnterExitDcsMsgData;
import com.oplus.camera.update.UpdateReceiver;
import com.oplus.camera.update.UpdateUtil;
import com.oplus.camera.util.Util;
import com.oplus.camera.watch.WatchAgentService;
import com.oplus.p110a.OplusBlurProcess;
import com.oplus.p125c.p126a.BitmapCacheClearManager.kt;
import com.oplus.tblplayer.config.PreCacheConfig;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class Camera extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener, CameraConstant, CameraManagerInterface {

    /* renamed from: OplusGLSurfaceView_5 */
    public static final List<String> f10609k = Arrays.asList("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");

    /* renamed from: OplusGLSurfaceView_14 */
    public static boolean f10610l = false;

    /* renamed from: OplusGLSurfaceView_6 */
    public static boolean f10611m = false;

    /* renamed from: OplusGLSurfaceView_11 */
    public static boolean f10612n = false;

    /* renamed from: o */
    public static boolean f10613o = false;

    /* renamed from: p */
    private static int f10614p = 120000;

    /* renamed from: q */
    private static String f10615q = null;

    /* renamed from: C */
    private C2495b f10618C;

    /* renamed from: E */
    private long f10620E;
    private CameraManager mCameraManager;

    /* renamed from: v */
    private boolean f10646v;

    /* renamed from: r */
    private final Handler f10642r = new HandlerC2494a();

    /* renamed from: s */
    private int f10643s = -1;

    /* renamed from: t */
    private int f10644t = -1;

    /* renamed from: u */
    private int f10645u = 0;

    /* renamed from: w */
    private boolean f10647w = true;

    /* renamed from: x */
    private boolean f10648x = false;

    /* renamed from: y */
    private boolean f10649y = false;

    /* renamed from: z */
    private boolean f10650z = false;

    /* renamed from: A */
    private String f10616A = null;

    /* renamed from: B */
    private ComboPreferences f10617B = null;

    /* renamed from: D */
    private ServiceConnection f10619D = null;

    /* renamed from: F */
    private boolean f10621F = false;

    /* renamed from: G */
    private ConditionVariable f10622G = new ConditionVariable();

    /* renamed from: H */
    private CameraEntry f10623H = new CameraEntry();

    /* renamed from: I */
    private CameraPermission f10624I = null;

    /* renamed from: J */
    private ServiceConnection f10625J = null;

    /* renamed from: K */
    private KeyguardManager f10626K = null;

    /* renamed from: L */
    private Runnable f10627L = new Runnable() { // from class: com.oplus.camera.Camera.1
        @Override // java.lang.Runnable
        public void run() {
            if (Camera.this.f10619D == null) {
                Intent intent = new Intent(Camera.this, (Class<?>) ApsService.class);
                Camera.this.f10619D = new ServiceConnection() { // from class: com.oplus.camera.Camera.1.1
                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        CameraLog.m12959b("OplusCamera", "mIpaConnection.onServiceConnected");
                        CameraLog.m12952a("ApsService.onServiceConnected");
                        Camera.this.f10622G.block();
                        if (Camera.this.mCameraManager != null) {
                            Camera.this.mCameraManager.m10237a(componentName, iBinder);
                        } else {
                            CameraLog.m12967f("OplusCamera", "mCameraManager already closed!");
                        }
                        CameraLog.m12958b("ApsService.onServiceConnected");
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                        CameraLog.m12959b("OplusCamera", "mIpaConnection.onServiceDisconnected");
                    }
                };
                Camera.this.bindService(intent, 1, CameraThreadExector.m24695a().m24697b(), Camera.this.f10619D);
            }
        }
    };

    /* renamed from: M */
    private final BroadcastReceiver f10628M = new BroadcastReceiver() { // from class: com.oplus.camera.Camera.23
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            CameraLog.m12959b("OplusCamera", "onReceive, mReceiverForWatchAgent intent: " + intent.toString());
            if ("filter_bind_watch_agent".equals(intent.getAction())) {
                Camera.this.m9542c(intent);
            }
        }
    };

    /* renamed from: N */
    private final BroadcastReceiver f10629N = new BroadcastReceiver() { // from class: com.oplus.camera.Camera.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Camera.this.f10646v || Camera.this.mCameraManager == null) {
                return;
            }
            Camera.this.mCameraManager.m10320b(intent);
        }
    };

    /* renamed from: O */
    private BroadcastReceiver f10630O = new BroadcastReceiver() { // from class: com.oplus.camera.Camera.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Camera.this.mCameraManager != null) {
                Camera.this.mCameraManager.m10320b(intent);
            }
        }
    };

    /* renamed from: P */
    private final BroadcastReceiver f10631P = new BroadcastReceiver() { // from class: com.oplus.camera.Camera.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            CameraLog.m12959b("OplusCamera", "onReceive, action: " + action);
            if (!"android.intent.action.PHONE_STATE".equals(action) || Camera.this.mCameraManager == null) {
                return;
            }
            Camera.this.mCameraManager.m10320b(intent);
        }
    };

    /* renamed from: Q */
    private BroadcastReceiver f10632Q = new BroadcastReceiver() { // from class: com.oplus.camera.Camera.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Camera.this.f10646v || Camera.this.mCameraManager == null) {
                return;
            }
            Camera.this.mCameraManager.m10320b(intent);
        }
    };

    /* renamed from: R */
    private BroadcastReceiver f10633R = new BroadcastReceiver() { // from class: com.oplus.camera.Camera.6
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Camera.this.mCameraManager != null) {
                Camera.this.mCameraManager.m10320b(intent);
            }
        }
    };

    /* renamed from: S */
    private BroadcastReceiver f10634S = new BroadcastReceiver() { // from class: com.oplus.camera.Camera.7
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Camera.this.mCameraManager != null) {
                Camera.this.mCameraManager.m10320b(intent);
            }
            if (Camera.this.f10646v || Camera.this.f10624I == null) {
                return;
            }
            Camera.this.f10624I.m14328f();
        }
    };

    /* renamed from: T */
    private BroadcastReceiver f10635T = new BroadcastReceiver() { // from class: com.oplus.camera.Camera.8
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Camera.this.mCameraManager != null) {
                Camera.this.mCameraManager.m10320b(intent);
            }
        }
    };

    /* renamed from: U */
    private BroadcastReceiver f10636U = new BroadcastReceiver() { // from class: com.oplus.camera.Camera.9
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Camera.this.mCameraManager != null) {
                Camera.this.mCameraManager.m10320b(intent);
            }
        }
    };

    /* renamed from: V */
    private BroadcastReceiver f10637V = new BroadcastReceiver() { // from class: com.oplus.camera.Camera.10
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Camera.this.mCameraManager != null) {
                Camera.this.mCameraManager.m10320b(intent);
            }
        }
    };

    /* renamed from: W */
    private UpdateReceiver f10638W = new UpdateReceiver();

    /* renamed from: X */
    private Runnable f10639X = new Runnable() { // from class: com.oplus.camera.Camera.11
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3, types: [com.oplus.camera.Camera] */
        @Override // java.lang.Runnable
        public void run() {
            if (Camera.this.f10650z) {
                try {
                    try {
                        Camera.this.unregisterReceiver(Camera.this.f10629N);
                        Camera.this.unregisterReceiver(Camera.this.f10631P);
                        Camera.this.unregisterReceiver(Camera.this.f10632Q);
                        Camera.this.unregisterReceiver(Camera.this.f10636U);
                    } catch (IllegalArgumentException COUIBaseListPopupWindow_8) {
                        CameraLog.m12967f("OplusCamera", "mUnregisterPauseReceiver, unregister fail, exception: " + COUIBaseListPopupWindow_8.getMessage());
                    }
                } finally {
                    Camera.this.f10650z = false;
                }
            }
        }
    };

    /* renamed from: Y */
    private ContentObserver f10640Y = new ContentObserver(this.f10642r) { // from class: com.oplus.camera.Camera.13
        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            if (Camera.this.mCameraManager != null) {
                Camera.this.mCameraManager.m10275aK();
                CameraLog.m12959b("OplusCamera", "onChange,updateThumbnail");
            }
        }
    };

    /* renamed from: Z */
    private Runnable f10641Z = new Runnable() { // from class: com.oplus.camera.Camera.14
        @Override // java.lang.Runnable
        public void run() {
            if (Camera.this.f10650z || Camera.this.f10646v) {
                return;
            }
            Camera.this.f10650z = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_CHECKING");
            intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
            intentFilter.addAction("android.intent.action.MEDIA_SHARED");
            intentFilter.addAction("android.intent.action.MEDIA_EJECT");
            intentFilter.addAction("android.intent.action.MEDIA_PRE_SHARED");
            intentFilter.addDataScheme("file");
            Camera camera = Camera.this;
            camera.registerReceiver(camera.f10629N, intentFilter, "oplus.permission.OPLUS_COMPONENT_SAFE", null);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.PHONE_STATE");
            Camera camera2 = Camera.this;
            camera2.registerReceiver(camera2.f10631P, intentFilter2, "oplus.permission.OPLUS_COMPONENT_SAFE", null);
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("com.oplus.camera.IOT_CAPTURE");
            Camera camera3 = Camera.this;
            camera3.registerReceiver(camera3.f10636U, intentFilter3, "oplus.permission.OPLUS_COMPONENT_SAFE", null);
            IntentFilter intentFilter4 = new IntentFilter();
            intentFilter4.addAction("android.intent.action.BATTERY_CHANGED");
            Camera camera4 = Camera.this;
            camera4.registerReceiver(camera4.f10632Q, intentFilter4);
            if (Util.m24284a()) {
                IntentFilter intentFilter5 = new IntentFilter();
                intentFilter5.addAction("android.bluetooth.binauralrecord.profile.action.CONNECTION_STATE_CHANGED");
                Camera camera5 = Camera.this;
                camera5.registerReceiver(camera5.f10637V, intentFilter5);
                IntentFilter intentFilter6 = new IntentFilter();
                intentFilter6.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
                Camera camera6 = Camera.this;
                camera6.registerReceiver(camera6.f10637V, intentFilter6);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m9542c(final Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("checkAndBindWatchAgent, mWatchConnection: ");
        sb.append(this.f10625J);
        sb.append(", extra: ");
        sb.append(intent != null ? intent.getExtras() : null);
        sb.append(", sbConnectAlive: ");
        sb.append(WatchAgentService.f23153a.get());
        CameraLog.m12954a("OplusCamera", sb.toString());
        if (intent == null || intent.getExtras() == null || this.f10625J != null) {
            return;
        }
        Util.m24279a(new Runnable() { // from class: com.oplus.camera.Camera.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if ("watch_launch_from_framework".equals(intent.getStringExtra("android_camera_launch_type")) || WatchAgentService.f23153a.get()) {
                        Intent intent2 = new Intent(Camera.this, (Class<?>) WatchAgentService.class);
                        Camera.this.f10625J = new ServiceConnection() { // from class: com.oplus.camera.Camera.12.1
                            @Override // android.content.ServiceConnection
                            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                                CameraLog.m12959b("OplusCamera", "checkAndBindWatchAgent, mWatchConnection.onServiceConnected");
                                Camera.this.mCameraManager.m10237a(componentName, iBinder);
                            }

                            @Override // android.content.ServiceConnection
                            public void onServiceDisconnected(ComponentName componentName) {
                                CameraLog.m12959b("OplusCamera", "checkAndBindWatchAgent, mWatchConnection.onServiceDisconnected");
                            }
                        };
                        Camera.this.bindService(intent2, 1, CameraThreadExector.m24695a().m24697b(), Camera.this.f10625J);
                    }
                } catch (Exception COUIBaseListPopupWindow_8) {
                    CameraLog.m12954a("OplusCamera", "checkAndBindWatchAgent, exception");
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        });
    }

    /* renamed from: t */
    private void m9558t() {
        if (!Util.m24321aJ() || this.f10617B.getBoolean(CameraUIInterface.KEY_IS_ANDROID_S_DATA_MIGRATED, false)) {
            return;
        }
        CameraLog.m12952a("checkAndroidSDataMigration");
        SharedPreferences sharedPreferences = getSharedPreferences("op_legacy_com.oneplus.camera_preferences", 0);
        if (sharedPreferences.contains("Version")) {
            String string = sharedPreferences.getString("AspectRatio.Photo", null);
            if (string != null) {
                if ("NORMAL".equals(string)) {
                    this.f10617B.edit().putString(CameraUIInterface.KEY_PHOTO_RATIO, "standard").apply();
                } else if ("SQUARE".equals(string)) {
                    this.f10617B.edit().putString(CameraUIInterface.KEY_PHOTO_RATIO, "square").apply();
                } else if ("FULL_SCREEN".equals(string)) {
                    this.f10617B.edit().putString(CameraUIInterface.KEY_PHOTO_RATIO, DcsMsgData.FULL).apply();
                }
            }
            String string2 = getSharedPreferences("op_legacy_video", 0).getString("Resolution.Video.Back", null);
            if (string2 != null) {
                if (string2.contains("3840x")) {
                    this.f10617B.m11072a(this, 0).edit().putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_4kuhd").apply();
                }
                if (string2.contains("@60")) {
                    this.f10617B.m11072a(this, 0).edit().putString(CameraUIInterface.KEY_VIDEO_FPS, String.valueOf(60)).apply();
                }
            }
        }
        SharedPreferences sharedPreferencesM11075b = this.f10617B.m11075b();
        if (sharedPreferencesM11075b.contains(CameraUIInterface.KEY_MIRROR)) {
            if ("on".equals(sharedPreferencesM11075b.getString(CameraUIInterface.KEY_MIRROR, "off"))) {
                sharedPreferencesM11075b.edit().putString(CameraUIInterface.KEY_MIRROR, "on").putString(CameraUIInterface.KEY_MIRROR_SETTING, "off").apply();
            } else {
                sharedPreferencesM11075b.edit().putString(CameraUIInterface.KEY_MIRROR, "off").putString(CameraUIInterface.KEY_MIRROR_SETTING, "on").apply();
            }
        }
        if (sharedPreferencesM11075b.contains(CameraTipsManager.f14378b) || sharedPreferencesM11075b.contains(CameraTipsManager.f14377a)) {
            boolean z = sharedPreferencesM11075b.getBoolean(CameraTipsManager.f14378b, false);
            sharedPreferencesM11075b.edit().putBoolean("com.oplus.camera.CLICK_ULTRA_WIDE", z).putInt("com.oplus.camera.OPEN_CAMERA_TIME", sharedPreferencesM11075b.getInt(CameraTipsManager.f14377a, 0)).remove(CameraTipsManager.f14378b).remove(CameraTipsManager.f14377a).apply();
        }
        Executors.newFixedThreadPool(1).execute(new Runnable() { // from class: com.oplus.camera.-$$Lambda$Camera$nRdCWuXp-Ce96hN_BATejEh1EtM
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m9525E();
            }
        });
        CameraLog.m12958b("checkAndroidSDataMigration");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ void m9525E() {
        File file = new File(getFilesDir().getParent(), "my_tmp");
        if (file.exists() && file.isDirectory()) {
            try {
                if (((Boolean) OplusPackageManager.class.getDeclaredMethod("fixupAppData", String.class, String.class, Integer.TYPE).invoke(OplusPackageManager.getOplusPackageManager(this), "com.oplus.camera", "/my_tmp/sticker", 2)).booleanValue()) {
                    CameraLog.m12959b("OplusCamera", "onCreate, Success to fix app data");
                    if (new File(file, ApsConstant.CAPTURE_MODE_STICKER).renameTo(new File(getFilesDir(), ApsConstant.CAPTURE_MODE_STICKER))) {
                        file.delete();
                    } else {
                        CameraLog.m12967f("OplusCamera", "onCreate, Rename failed");
                    }
                } else {
                    CameraLog.m12966e("OplusCamera", "onCreate, Fail to fix app data");
                }
            } catch (Throwable th) {
                CameraLog.m12965d("OplusCamera", "onCreate, Cannot to fix app data", th);
            }
        } else {
            CameraLog.m12959b("OplusCamera", "onCreate, Sticker temp folder not exist, no need to fix app data");
        }
        this.f10642r.post(new Runnable() { // from class: com.oplus.camera.-$$Lambda$Camera$UrfHqZ-jawnYiV_-odTkCW7FG_k
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m9526F();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void m9526F() {
        ComboPreferences comboPreferences = this.f10617B;
        if (comboPreferences != null) {
            comboPreferences.edit().putBoolean(CameraUIInterface.KEY_IS_ANDROID_S_DATA_MIGRATED, true).apply();
        }
    }

    public Camera() {
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.Camera.17
            @Override // java.lang.Runnable
            public void run() {
                Camera camera = Camera.this;
                camera.mCameraManager = new CameraManager(camera, camera);
                Camera.this.f10622G.open();
            }
        }, "CameraManager instance");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        if (Util.f22962a != context.getApplicationContext().getResources().getConfiguration().densityDpi) {
            Util.m24489q(context.getApplicationContext());
            CameraLog.m12966e("OplusCamera", "attachBaseContext, dpi not same, so change it");
        }
        super.attachBaseContext(Util.m24489q(context));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity_3, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        CameraLog.m12952a("CameraStartupPerformance.onCameraActivityCreate");
        CameraLog.m12967f("OplusCamera", "onCreate, this: " + this);
        CameraLog.m12952a("beforeOpenCamera");
        CameraPerformance.m15189c("launch_on_create");
        LaunchPerformance.setMemBeforeCreate(Util.m24468k(MyApplication.m11092d()));
        Runnable runnable = this.f10627L;
        if (runnable != null) {
            Util.m24279a(runnable);
        }
        if (isInMultiWindowMode()) {
            if (this.f10626K == null) {
                this.f10626K = (KeyguardManager) getApplicationContext().getSystemService("keyguard");
            }
            boolean zIsKeyguardLocked = this.f10626K.isKeyguardLocked();
            CameraLog.m12954a("OplusCamera", "onCreate, isKeyguardLocked: " + zIsKeyguardLocked);
            if (!zIsKeyguardLocked) {
                super.onCreate(bundle);
                m9534a(getString(R.string.camera_in_multiwindow_cannot_use));
                return;
            }
        }
        try {
            this.f10617B = new ComboPreferences(this);
        } catch (IllegalStateException unused) {
            this.f10617B = new ComboPreferences(getApplicationContext().createDeviceProtectedStorageContext());
        }
        m9558t();
        this.f10623H.m13331a(getIntent(), this, this.f10617B, bundle);
        this.f10624I = new CameraPermission(this, this.f10617B);
        this.f10622G.block();
        if (!this.f10617B.getBoolean("pref_camera_statement_key", false)) {
            this.f10647w = false;
        } else {
            this.f10647w = this.f10624I.m14327e();
        }
        MyApplication.m11086a(getApplicationContext());
        CameraCharacteristicsUtil.m12973a(getApplicationContext());
        this.mCameraManager.m10402y(true);
        CameraLog.m12958b("beforeOpenCamera");
        this.mCameraManager.m10247a(this.f10617B, this.f10623H, this.f10647w);
        CameraLog.m12952a("beforeSetContentView");
        Util.m24384b((Activity) this);
        Util.m24440e(getApplicationContext());
        m9559u();
        this.f10624I.m14322a(this.mCameraManager.m10288aX());
        if (this.f10623H.m13350m() == 1 && TextUtils.equals("portrait", this.f10623H.m13330a(1)) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AYSNC_INIT_BLUR_ALGO_SUPPORT)) {
            CameraLog.m12967f("OplusCamera", "onCreate, OplusBlurInitThread, start");
            CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.Camera.18
                @Override // java.lang.Runnable
                public void run() {
                    Size sizeConfigValue = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_FRONT_PORTRAIT_PREVIEW_SIZE);
                    OplusBlurProcess.m8735a(sizeConfigValue.getWidth(), sizeConfigValue.getHeight());
                }
            }, "OplusBlurInitThread");
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SCREEN_BRIGHTNESS)) {
            InverseManager.INS.init(this, this.f10623H.m13317J(), CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_SOFT_LIGHT), CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SCREEN_BRIGHTNESS_VALUE), CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SCREEN_BRIGHTNESS_VIDEO_VALUE), CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SCREEN_BRIGHTNESS_THRESHOLD), CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SCREEN_BRIGHTNESS_RECOVER_THRESHOLD), CameraConfig.getConfigColorValue(ConfigDataBase.KEY_FRONT_INVERSE_COLOR));
        }
        if (getResources() != null && getResources().getConfiguration().densityDpi != Util.f22962a) {
            Util.m24489q(this);
        }
        Util.m24482n(this);
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.Camera.19
            @Override // java.lang.Runnable
            public void run() {
                Util.m24430d(Camera.this);
                UpdateUtil.getInstance(Camera.this).startUpdateAllPara();
            }
        }, "CameraInit");
        super.onCreate(bundle);
        if (!Util.m24352ao()) {
            COUIThemeOverlay.m6468a().m6479a(this);
        } else {
            setTheme(R.style.ThemeCameraMoon_FullScreen);
        }
        CameraLog.m12958b("beforeSetContentView");
        CameraLog.m12952a("setContentView");
        setContentView(R.layout.camera);
        CameraLog.m12958b("setContentView");
        getWindow().getDecorView().setForceDarkAllowed(false);
        this.mCameraManager.m10295ae();
        this.f10624I.m14320a();
        try {
            this.f10616A = getIntent().getStringExtra("keyguard_start_timestamp");
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        m9561w();
        m9542c(getIntent());
        FluencyPerformance.m15124a(System.currentTimeMillis());
        this.f10645u = getResources().getConfiguration().uiMode;
        Util.m24316aE();
        Util.m24467j(this);
        CameraLog.m12954a("OplusCamera", "onCreate X, this: " + this);
        CameraLog.m12958b("CameraStartupPerformance.onCameraActivityCreate");
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public CameraEntry m9565k() {
        return this.f10623H;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9534a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Toast.makeText(this, str, 0).show();
        }
        CameraLog.m12954a("OplusCamera", "finishActivityWithToast, toastMsg: " + str);
        this.f10646v = true;
        finish();
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        super.onMultiWindowModeChanged(z, configuration);
        if (z) {
            m9534a(getString(R.string.camera_in_multiwindow_cannot_use));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        this.mCameraManager.m10402y(true);
        super.onNewIntent(intent);
        CameraLog.m12954a("OplusCamera", "onNewIntent");
        if (this.f10623H.m13334a(intent)) {
            m9559u();
            try {
                this.f10616A = intent.getStringExtra("keyguard_start_timestamp");
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            this.mCameraManager.m10239a(intent);
            m9542c(intent);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m9544d(Intent intent) {
        boolean booleanExtra = false;
        try {
            booleanExtra = intent.getBooleanExtra("need_screen_on", false);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        CameraLog.m12954a("OplusCamera", "checkIfNeedScreenOn, isNeedScreenOn: " + booleanExtra);
        return booleanExtra;
    }

    /* renamed from: u */
    private void m9559u() {
        if (this.f10623H.m13321N() || (getIntent() != null && m9544d(getIntent()))) {
            if (this.f10623H.m13359w()) {
                setShowWhenLocked(true);
                CameraLog.m12959b("OplusCamera", "blackGestureOpen, setShowWhenLocked true");
            }
            setTurnScreenOn(true);
            CameraLog.m12959b("OplusCamera", "blackGestureOpen, setTurnScreenOn true");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (MyApplication.m11089b()) {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        DevicePolicyManager devicePolicyManager;
        CameraLog.m12952a("CameraStartupPerformance.onCameraActivityResume");
        CameraLog.m12967f("OplusCamera", "onResume, this: " + this + ", mbDisplayOnLock: " + this.mCameraManager.m10303am() + ", mVersionInfo: " + f10615q);
        this.f10623H.m13313F();
        super.onResume();
        if (Util.m24348ak() && (devicePolicyManager = (DevicePolicyManager) getSystemService("device_policy")) != null && devicePolicyManager.getCameraDisabled(null)) {
            CameraLog.m12967f("OplusCamera", "onResume, camera disabled, finish");
            this.f10646v = true;
            finish();
            return;
        }
        if (this.f10624I != null) {
            if (!this.f10617B.getBoolean("pref_camera_statement_key", false)) {
                this.f10647w = false;
            } else {
                this.f10647w = this.f10624I.m14327e();
            }
            if (!this.f10617B.getBoolean("pref_camera_statement_key", false)) {
                this.f10624I.m14323a(this.mCameraManager.m10287aW());
            }
        }
        if (this.f10647w) {
            m9560v();
        }
        CameraPermission c2776h = this.f10624I;
        if (c2776h != null) {
            c2776h.m14326d();
        }
        if (getResources().getConfiguration().densityDpi != Util.f22962a) {
            Util.m24489q(this);
        }
        if (getApplicationContext().getResources().getConfiguration().densityDpi != Util.f22962a) {
            Util.m24489q(getApplicationContext());
        }
        if (!this.f10617B.getBoolean("pref_camera_statement_key", false)) {
            m9573s();
        }
        this.f10620E = System.currentTimeMillis();
        this.f10646v = false;
        this.f10648x = false;
        this.mCameraManager.m10251a(new Runnable() { // from class: com.oplus.camera.Camera.20
            @Override // java.lang.Runnable
            public void run() {
                if (Camera.this.f10618C == null) {
                    Camera camera = Camera.this;
                    camera.f10618C = camera.new C2495b(camera.getApplicationContext());
                }
                CameraLog.m12954a("OplusCamera", "onResume, enable mOrientationListener");
                Camera.this.f10618C.enable();
            }
        }, 0L);
        Storage.m11125b(getApplicationContext());
        Util.m24482n(this);
        this.f10617B.registerOnSharedPreferenceChangeListener(this);
        this.mCameraManager.m10341d(this.f10647w, m9540b(Util.m24327aP()));
        m9522B();
        this.mCameraManager.m10385q(false);
        try {
            RegionCommonFeatureAdapter.m14525a(this, this.f10623H.m13336b(), this.f10617B, this.f10623H.m13317J());
            mo9570p();
            m9562x();
            RegionCommonFeatureAdapter.m14526a(getContentResolver(), 0);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        Util.m24492r();
        if (!this.f10621F) {
            if (Util.m24478m(this)) {
                getWindow().addFlags(256);
                getWindow().setFlags(-65537, 65536);
                getWindow().addFlags(Integer.MIN_VALUE);
                getWindow().setNavigationBarContrastEnforced(false);
                getWindow().setNavigationBarColor(0);
            }
            if (27 < Build.VERSION.SDK_INT) {
                getWindow().getDecorView().setSystemUiVisibility(5636);
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
            this.f10621F = true;
        }
        Util.m24323aL();
        MyApplication.m11094e();
        this.mCameraManager.m10404z(true);
        if (this.mCameraManager.m10330bb()) {
            this.f10642r.post(new Runnable() { // from class: com.oplus.camera.Camera.21
                @Override // java.lang.Runnable
                public void run() {
                    Camera.this.mo9567m();
                }
            });
        }
        CameraLog.m12967f("OplusCamera", "onResume X, this: " + this + ", mbDisplayOnLock: " + this.mCameraManager.m10303am());
        CameraLog.m12958b("CameraStartupPerformance.onCameraActivityResume");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        CameraPerformance.m15189c("camera_exit_onpause_start");
        CameraLog.m12967f("OplusCamera", "onPause, this: " + this);
        FluencyPerformance.m15133b(System.currentTimeMillis(), true);
        this.mCameraManager.m10402y(false);
        this.mCameraManager.m10292ab();
        ThumbnailHolder.m19300a();
        this.f10646v = true;
        this.mCameraManager.m10251a(new Runnable() { // from class: com.oplus.camera.Camera.22
            @Override // java.lang.Runnable
            public void run() {
                if (Camera.this.f10618C != null) {
                    CameraLog.m12954a("OplusCamera", "onPause, disable mOrientationListener");
                    Camera.this.f10618C.disable();
                }
            }
        }, 0L);
        this.mCameraManager.m10382o(m9564z());
        if (this.f10648x || m9521A()) {
            CameraLog.m12959b("OplusCamera", "onPause, clear light gallery cache");
            BitmapCacheClearManager.kt.m9370a(Util.m24472l());
            BitmapCacheClearManager.kt.m9371b(Util.m24472l());
        }
        this.f10617B.unregisterOnSharedPreferenceChangeListener(this);
        m9532a(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        super.onPause();
        this.f10642r.removeCallbacksAndMessages(null);
        this.f10623H.m13312E();
        if ((this.f10647w && !this.mCameraManager.m10289aY()) || (!this.f10623H.m13346i() && (!this.mCameraManager.m10289aY() || !this.f10623H.m13344g()))) {
            this.f10623H.m13338c(false);
        }
        Util.m24166B();
        Util.m24493s();
        UpdateUtil.getInstance(this).onPause();
        m9523C();
        CameraPermission c2776h = this.f10624I;
        if (c2776h != null) {
            c2776h.m14325c();
        }
        CameraLog.m12967f("OplusCamera", "onPause X, this: " + this);
    }

    @Override // com.oplus.camera.CameraManagerInterface
    /* renamed from: OplusGLSurfaceView_14 */
    public boolean mo9566l() {
        return this.f10647w;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        CameraPerformance.m15189c("camera_exit_onstop_start");
        FluencyPerformance.m15133b(System.currentTimeMillis(), true);
        CameraLog.m12967f("OplusCamera", "onStop, this: " + this + ", mbExitCameraUseBackKey: " + this.f10648x + ", mKeyguardStartTimeStamp: " + this.f10616A);
        CameraEntry c2701b = this.f10623H;
        CameraManager cameraManager = this.mCameraManager;
        boolean booleanExtra = false;
        c2701b.m13341d((cameraManager == null || cameraManager.m10284aT()) ? false : true);
        InverseManager.INS.clear();
        super.onStop();
        CameraManager cameraManager2 = this.mCameraManager;
        if (cameraManager2 != null) {
            cameraManager2.m10229a();
        }
        RegionCommonFeatureAdapter.m14526a(getContentResolver(), 0);
        String str = this.f10616A;
        String str2 = str == null ? null : new String(str);
        this.f10616A = null;
        CameraManager cameraManager3 = this.mCameraManager;
        if (cameraManager3 != null && cameraManager3.m10228Z()) {
            setTurnScreenOn(false);
            CameraLog.m12959b("OplusCamera", "onStop, setTurnScreenOn false");
        }
        try {
            booleanExtra = getIntent().getBooleanExtra("com.oplus.camera.extra.IS_VOICE_INTERACTION_ROOT", false);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        if (getIntent() != null && booleanExtra) {
            finish();
        }
        CameraLog.m12967f("OplusCamera", "onStop X, this: " + this + ", timeStamp: " + str2);
        CameraExitPerformance.setOnStopMemory(Util.m24468k(MyApplication.m11092d()));
        CameraPerformance.m15189c("camera_exit_onstop_end");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        CameraLog.m12967f("OplusCamera", "onAttachedToWindow");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CameraLog.m12967f("OplusCamera", "onDetachedFromWindow");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() throws InterruptedException {
        CameraLog.m12967f("OplusCamera", "onDestroy, this: " + this);
        CameraPermission c2776h = this.f10624I;
        if (c2776h != null) {
            c2776h.m14324b();
            this.f10624I = null;
        }
        if (!this.f10649y) {
            this.mCameraManager.m10297ag();
        }
        super.onDestroy();
        UpdateUtil.release();
        m9563y();
        this.f10646v = true;
        this.f10649y = false;
        InverseManager.INS.release(this);
        BackgroundSplitManager.m18437b(this);
        if (this.mCameraManager != null) {
            CameraEntry c2701b = this.f10623H;
            if (c2701b != null && c2701b.m13359w() && !Util.m24348ak()) {
                CameraLog.m12967f("OplusCamera", "onDestroy, forceResetDeviceStateClosed when isLockScreenStart");
                this.mCameraManager.m10329ba();
            }
            this.mCameraManager.m10301ak();
            this.mCameraManager = null;
        }
        CameraConfig.release();
        Util.m24317aF();
        Util.m24481n();
        FilterHelper.m22651y();
        ServiceConnection serviceConnection = this.f10619D;
        if (serviceConnection != null) {
            unbindService(serviceConnection);
            this.f10619D = null;
        }
        ServiceConnection serviceConnection2 = this.f10625J;
        if (serviceConnection2 != null) {
            unbindService(serviceConnection2);
            this.f10625J = null;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STOP_SERVICE_ON_DESTROY_SUPPORT)) {
            m9524D();
        }
        ComboPreferences comboPreferences = this.f10617B;
        if (comboPreferences != null) {
            comboPreferences.m11074a(this);
            this.f10617B = null;
        }
        CameraEntry c2701b2 = this.f10623H;
        if (c2701b2 != null) {
            c2701b2.m13314G();
            this.f10623H = null;
        }
        if (MyApplication.m11089b()) {
            Process.killProcess(Process.myPid());
        }
        if (Util.m24342ae()) {
            MyApplication.m11097h();
        }
        CameraLog.m12967f("OplusCamera", "onDestroy X, this: " + this);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        CameraLog.m12967f("OplusCamera", "finish, isFinishing: " + isFinishing());
        boolean booleanExtra = false;
        if (this.f10617B != null && this.f10647w) {
            this.f10623H.m13332a(false);
        }
        this.f10649y = true;
        CameraEntry c2701b = this.f10623H;
        if (c2701b != null && c2701b.m13321N()) {
            setShowWhenLocked(false);
            if (this.f10623H.m13359w()) {
                getWindow().clearFlags(STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
            }
            getWindow().clearFlags(PreCacheConfig.DEFAULT_MAX_CACHE_FILE_SIZE);
            CameraLog.m12959b("OplusCamera", "finish, clearFlag success finish");
        }
        try {
            booleanExtra = getIntent().getBooleanExtra("open_from_dialog", false);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        if (booleanExtra) {
            overridePendingTransition(R.anim.oplus_dialog_open_enter, R.anim.oplus_dialog_open_exit);
        }
    }

    @Override // androidx.activity.ComponentActivity_3, android.app.Activity
    public void onBackPressed() {
        CameraLog.m12967f("OplusCamera", "onBackPressed");
        if (this.mCameraManager.onBackPressed()) {
            this.f10648x = true;
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        CameraLog.m12954a("OplusCamera", "onKeyDown, keycode: " + OplusGLSurfaceView_13);
        if (this.f10646v) {
            return false;
        }
        if (this.mCameraManager.onKeyDown(OplusGLSurfaceView_13, keyEvent)) {
            return true;
        }
        return super.onKeyDown(OplusGLSurfaceView_13, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        CameraLog.m12954a("OplusCamera", "onKeyUp, keyCode: " + OplusGLSurfaceView_13);
        if (this.f10646v) {
            return false;
        }
        if (this.mCameraManager.onKeyUp(OplusGLSurfaceView_13, keyEvent)) {
            return true;
        }
        return super.onKeyUp(OplusGLSurfaceView_13, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchKeyEvent(android.view.KeyEvent r3) {
        /*
            r2 = this;
            int r0 = r3.getKeyCode()
            r1 = 57
            if (r0 == r1) goto L14
            r1 = 58
            if (r0 == r1) goto L14
            r1 = 82
            if (r0 == r1) goto L14
            switch(r0) {
                case 19: goto L14;
                case 20: goto L14;
                case 21: goto L14;
                case 22: goto L14;
                default: goto L13;
            }
        L13:
            goto L1c
        L14:
            boolean r0 = com.oplus.camera.util.Util.m24342ae()
            if (r0 == 0) goto L1c
            r2 = 1
            return r2
        L1c:
            boolean r2 = super.dispatchKeyEvent(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.Camera.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEventM10332c = this.mCameraManager.m10332c(motionEvent);
        if (motionEventM10332c == null) {
            return true;
        }
        this.mCameraManager.m10246a(motionEventM10332c);
        if (motionEventM10332c.getAction() != 1 && (motionEventM10332c.getX() < 0.0f || motionEventM10332c.getY() < 0.0f || motionEventM10332c.getX() > Util.getScreenWidth())) {
            CameraLog.m12954a("OplusCamera", "dispatchTouchEvent, X: " + motionEventM10332c.getX() + ", Y: " + motionEventM10332c.getY());
            return false;
        }
        this.mCameraManager.m10346e(motionEventM10332c);
        if (this.mCameraManager.m10206D()) {
            CameraLog.m12954a("OplusCamera", "dispatchTouchEvent, camera on switching....");
            return true;
        }
        if (this.mCameraManager.m10327b(CameraUIInterface.KEY_NEED_INTERCEPT_TOUCH)) {
            CameraLog.m12954a("OplusCamera", "dispatchTouchEvent, need intercept touch...");
            return true;
        }
        if (this.mCameraManager.m10270aF()) {
            CameraLog.m12954a("OplusCamera", "dispatchTouchEvent, camera on video stopping...");
            return true;
        }
        if (super.dispatchTouchEvent(this.mCameraManager.m10338d(motionEventM10332c))) {
            CameraLog.m12954a("OplusCamera", "dispatchTouchEvent, consume by super");
            this.mCameraManager.m10358g(motionEventM10332c);
            this.mCameraManager.m10216N();
            return true;
        }
        if (this.mCameraManager.m10326b(motionEventM10332c)) {
            CameraLog.m12954a("OplusCamera", "dispatchTouchEvent, consume by double finger capture");
            return true;
        }
        return this.mCameraManager.m10355f(motionEventM10332c);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        super.onUserInteraction();
        mo9570p();
        CameraEntry c2701b = this.f10623H;
        if (c2701b != null && c2701b.m13360x()) {
            this.f10623H.m13362z();
        }
        CameraEntry c2701b2 = this.f10623H;
        if (c2701b2 != null && c2701b2.m13355s()) {
            this.f10623H.m13356t();
        }
        CameraManager cameraManager = this.mCameraManager;
        if (cameraManager != null) {
            cameraManager.m10290aZ();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        configuration.densityDpi = Util.f22962a;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        CameraLog.m12954a("OplusCamera", "onConfigurationChanged, config sDefaultDensity: " + configuration.densityDpi + ", uiMode: " + configuration.uiMode + ", sysDensityDpi: " + Util.f22994b);
        CameraPermission c2776h = this.f10624I;
        if (c2776h != null) {
            c2776h.m14329g();
        }
        if (this.f10645u != configuration.uiMode) {
            this.f10645u = configuration.uiMode;
            CameraPermission c2776h2 = this.f10624I;
            if (c2776h2 != null) {
                c2776h2.m14330h();
            }
            CameraManager cameraManager = this.mCameraManager;
            if (cameraManager != null) {
                cameraManager.m10311au();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int OplusGLSurfaceView_13, int i2, Intent intent) throws FileNotFoundException {
        Bundle extras;
        CameraLog.m12954a("OplusCamera", "onActivityResult, resultCode: " + i2);
        super.onActivityResult(OplusGLSurfaceView_13, i2, intent);
        if (OplusGLSurfaceView_13 == 1000) {
            Intent intent2 = new Intent();
            if (intent != null && (extras = intent.getExtras()) != null) {
                intent2.putExtras(extras);
            }
            setResult(i2, intent2);
            finish();
            DocumentUtil.m16205c(getFileStreamPath("crop-temp").getAbsolutePath());
            return;
        }
        if (OplusGLSurfaceView_13 == 11111) {
            if (-1 == i2 && intent != null) {
                Cursor cursorQuery = getContentResolver().query(intent.getData(), new String[]{Downloads.Impl._DATA}, null, null, null);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(Downloads.Impl._DATA));
                CameraLog.m12954a("OplusCamera", "onActivityResult, videoPath: " + string);
                CameraManager cameraManager = this.mCameraManager;
                if (cameraManager != null && string != null) {
                    cameraManager.m10252a(string);
                }
                cursorQuery.close();
                return;
            }
            CameraManager cameraManager2 = this.mCameraManager;
            if (cameraManager2 != null) {
                cameraManager2.m10317b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m9560v() {
        MyApplication.m11086a(this);
        CameraCharacteristicsUtil.m12973a(getApplicationContext());
        CameraManager cameraManager = this.mCameraManager;
        if (cameraManager != null) {
            cameraManager.m10274aJ();
        }
    }

    /* renamed from: w */
    private void m9561w() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        registerReceiver(this.f10630O, intentFilter, "oplus.permission.OPLUS_COMPONENT_SAFE", null);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.heytap.speechassist.intent.action.WINDOW_MANAGER_OCCUPIED");
        intentFilter2.addAction("com.heytap.speechassist.intent.action.FLOAT_ACTIVITY_START");
        registerReceiver(this.f10633R, intentFilter2, "heytap.speechassist.permission.FLOAT_WINDOW_STATUS", null);
        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction(UpdateReceiver.ROM_UPDATE_ACTION);
        intentFilter3.addAction(UpdateReceiver.ACTION_OTA_SUCCESSED);
        registerReceiver(this.f10638W, intentFilter3, "oplus.permission.OPLUS_COMPONENT_SAFE", null);
        registerReceiver(this.f10634S, new IntentFilter("android.location.MODE_CHANGED"));
        LocalBroadcastManager.m3241a(Util.m24472l()).m3244a(this.f10635T, new IntentFilter("com.oplus.camera.TIPS_MANAGER_BR_ACTION"));
        CameraMotorManager.m13703a(getApplicationContext()).m13707a((Activity) this);
        LocalBroadcastManager.m3241a(getApplicationContext()).m3244a(this.f10628M, new IntentFilter("filter_bind_watch_agent"));
        getContentResolver().registerContentObserver(Uri.parse("content://media/external/images/media"), false, this.f10640Y);
        getContentResolver().registerContentObserver(Uri.parse("content://media/external/video/media"), false, this.f10640Y);
    }

    /* renamed from: x */
    private void m9562x() {
        CameraManager cameraManager = this.mCameraManager;
        if (cameraManager != null) {
            cameraManager.m10250a(this.f10639X);
            this.mCameraManager.m10251a(this.f10641Z, 0L);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9532a(long OplusGLSurfaceView_15) {
        CameraManager cameraManager = this.mCameraManager;
        if (cameraManager != null) {
            cameraManager.m10251a(this.f10639X, OplusGLSurfaceView_15);
        }
    }

    /* renamed from: y */
    private void m9563y() {
        try {
            if (this.mCameraManager != null) {
                this.mCameraManager.m10250a(this.f10639X);
            }
            m9532a(0L);
            unregisterReceiver(this.f10630O);
            unregisterReceiver(this.f10633R);
            unregisterReceiver(this.f10634S);
            unregisterReceiver(this.f10638W);
            LocalBroadcastManager.m3241a(Util.m24472l()).m3243a(this.f10635T);
            LocalBroadcastManager.m3241a(getApplicationContext()).m3243a(this.f10628M);
            CameraMotorManager.m13703a(getApplicationContext()).m13711b((Activity) this);
        } catch (IllegalArgumentException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        getContentResolver().unregisterContentObserver(this.f10640Y);
    }

    @Override // com.oplus.camera.CameraManagerInterface
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo9567m() {
        if (this.mCameraManager != null && !m9564z()) {
            this.mCameraManager.m10323b(false, true);
        }
        CameraLog.m12967f("OplusCamera", "killCameraProcess");
        Process.killProcess(Process.myPid());
    }

    @Override // com.oplus.camera.CameraManagerInterface
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo9568n() throws PackageManager.NameNotFoundException {
        String string;
        CameraLog.m12954a("OplusCamera", "onPreviewOKMessage");
        try {
            if (f10615q == null) {
                PackageManager packageManager = getPackageManager();
                String packageName = getPackageName();
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 128);
                if (packageInfo == null || applicationInfo == null) {
                    return;
                }
                Object obj = applicationInfo.metaData.get("versionCommit");
                Object obj2 = applicationInfo.metaData.get("versionDate");
                if (obj != null) {
                    string = obj.toString();
                    if (!string.startsWith("_")) {
                        string = "_" + string;
                    }
                } else {
                    string = null;
                }
                f10615q = packageInfo.versionName + string + "_" + (obj2 != null ? obj2.toString() : null);
                StringBuilder sb = new StringBuilder();
                sb.append("onPreviewOKMessage, Camera versionInfo: ");
                sb.append(f10615q);
                CameraLog.m12954a("OplusCamera", sb.toString());
            }
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    @Override // com.oplus.camera.CameraManagerInterface
    /* renamed from: o */
    public boolean mo9569o() {
        this.f10647w = this.f10624I.m14327e();
        return this.f10647w;
    }

    @Override // com.oplus.camera.CameraManagerInterface
    /* renamed from: p */
    public void mo9570p() {
        CameraLog.m12954a("OplusCamera", "keepScreenOnAwhile");
        this.f10642r.removeMessages(1);
        getWindow().addFlags(128);
        this.f10642r.sendEmptyMessageDelayed(1, f10614p);
    }

    @Override // com.oplus.camera.CameraManagerInterface
    /* renamed from: q */
    public void mo9571q() {
        CameraLog.m12954a("OplusCamera", "keepScreenOn");
        this.f10642r.removeMessages(1);
        getWindow().addFlags(128);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.PlatformImplementations.kt_3
    public void onRequestPermissionsResult(int OplusGLSurfaceView_13, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(OplusGLSurfaceView_13, strArr, iArr);
        CameraLog.m12954a("OplusCamera", "onRequestPermissionsResult, requestCode: " + OplusGLSurfaceView_13 + ", permissions: " + Arrays.toString(strArr) + ", grantResults: " + Arrays.toString(iArr));
        CameraPermission c2776h = this.f10624I;
        if (c2776h != null) {
            c2776h.m14321a(OplusGLSurfaceView_13, strArr, iArr, new CameraPermission.COUIBaseListPopupWindow_8() { // from class: com.oplus.camera.Camera.15
                @Override // com.oplus.camera.CameraPermission.COUIBaseListPopupWindow_8
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo9574a() {
                    Camera camera = Camera.this;
                    camera.f10647w = camera.f10624I.m14327e();
                    if (Camera.this.f10647w) {
                        Camera.this.m9560v();
                    }
                    CameraLog.m12954a("OplusCamera", "onRequestPermissionsResult, mbHasNecessaryPermission: " + Camera.this.f10647w);
                }

                @Override // com.oplus.camera.CameraPermission.COUIBaseListPopupWindow_8
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo9575b() {
                    if (Camera.this.mCameraManager != null) {
                        Camera.this.mCameraManager.m10273aI();
                    }
                }
            });
        }
        CameraPermission.m14301a(this, OplusGLSurfaceView_13, strArr, iArr);
    }

    @Override // com.oplus.camera.CameraManagerInterface
    /* renamed from: r */
    public boolean mo9572r() {
        return checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        CameraManager cameraManager;
        if ((!this.f10646v || CameraUIInterface.KEY_SUB_SETTING.equals(str) || CameraUIInterface.KEY_PI_AI.equals(str)) && (cameraManager = this.mCameraManager) != null) {
            cameraManager.m10240a(sharedPreferences, str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m9540b(String str) {
        return TextUtils.isEmpty(str) ? false : false;
    }

    /* renamed from: z */
    private boolean m9564z() {
        CameraManager cameraManager = this.mCameraManager;
        if (cameraManager == null || !cameraManager.m10228Z()) {
            return false;
        }
        return !m9540b(Util.m24327aP());
    }

    /* renamed from: A */
    private boolean m9521A() {
        CameraManager cameraManager = this.mCameraManager;
        return cameraManager != null && cameraManager.m10226X();
    }

    /* renamed from: com.oplus.camera.Camera$PlatformImplementations.kt_3 */
    private class HandlerC2494a extends Handler {
        private HandlerC2494a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CameraLog.m12954a("OplusCamera", "handleMessage, message: " + message.what);
            if (message.what == 1) {
                if (Camera.this.mCameraManager == null || !Camera.this.mCameraManager.m10272aH()) {
                    if (Camera.this.mCameraManager != null && !Camera.this.mCameraManager.m10269aE()) {
                        Camera.this.getWindow().clearFlags(128);
                        Camera.this.finish();
                    }
                } else {
                    Camera.this.mo9570p();
                }
            }
            CameraLog.m12954a("OplusCamera", "handleMessage, message: " + message.what + " X");
        }
    }

    /* renamed from: com.oplus.camera.Camera$IntrinsicsJvm.kt_4 */
    private class C2495b extends OrientationEventListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f10681b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private long f10682c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f10683d;

        public C2495b(Context context) {
            super(context);
            this.f10681b = 0;
            this.f10682c = 0L;
            this.f10683d = 0;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int OplusGLSurfaceView_13) {
            if (Camera.this.f10644t != OplusGLSurfaceView_13) {
                Camera.this.f10644t = OplusGLSurfaceView_13;
                if (Camera.this.mCameraManager != null) {
                    Camera.this.mCameraManager.m10357g(OplusGLSurfaceView_13);
                }
            }
            if (OplusGLSurfaceView_13 == -1) {
                if (Camera.this.mCameraManager != null) {
                    Camera.this.mCameraManager.m10345e(-1);
                    return;
                }
                return;
            }
            long jNanoTime = System.nanoTime();
            if (this.f10683d == 0) {
                this.f10681b = OplusGLSurfaceView_13;
            } else {
                if (Math.abs(this.f10681b - OplusGLSurfaceView_13) > 180) {
                    OplusGLSurfaceView_13 += 360;
                }
                this.f10681b = (this.f10681b + OplusGLSurfaceView_13) / 2;
            }
            this.f10683d++;
            if (jNanoTime - this.f10682c > 190000000) {
                this.f10682c = jNanoTime;
                int i2 = this.f10681b;
                this.f10681b = 0;
                this.f10683d = 0;
                int iM24405c = Util.m24405c(i2, Camera.this.f10643s);
                if (Camera.this.f10643s != iM24405c) {
                    CameraLog.m12966e("OplusCamera", "onOrientationChanged, mOrientation: " + Camera.this.f10643s + " -> " + iM24405c);
                    Camera.this.f10643s = iM24405c;
                    if (Camera.this.mCameraManager != null) {
                        Camera.this.mCameraManager.m10352f(Camera.this.f10643s);
                        Camera.this.mCameraManager.m10345e(Camera.this.f10643s);
                    }
                }
            }
        }
    }

    /* renamed from: B */
    private void m9522B() {
        EnterExitDcsMsgData enterExitDcsMsgData = new EnterExitDcsMsgData(this, "enter");
        enterExitDcsMsgData.mCameraEnterTimeGap = this.f10623H.m13318K();
        enterExitDcsMsgData.mEnterCallPackage = this.f10623H.m13358v();
        enterExitDcsMsgData.mShortcutType = this.f10623H.m13316I();
        enterExitDcsMsgData.mCameraEnterType = String.valueOf(this.f10623H.m13320M());
        enterExitDcsMsgData.mbFromLock = this.f10623H.m13323P();
        enterExitDcsMsgData.mCaptureMode = this.f10623H.m13340d();
        enterExitDcsMsgData.mMagneticShellStatus = Util.m24320aI() ? "on" : "off";
        enterExitDcsMsgData.mEnterTemperature = this.f10617B.getFloat(CameraUIInterface.KEY_CURRENT_TEMPERATURE, -1.0f);
        int iM10285aU = this.mCameraManager.m10285aU();
        enterExitDcsMsgData.mCameraId = iM10285aU;
        enterExitDcsMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(iM10285aU) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_EXPLORER_SUPPORT)) {
            enterExitDcsMsgData.mChipStatus = this.f10617B.getInt(CameraUIInterface.KEY_EXPLORER_CHIP_STATE, 1);
        }
        enterExitDcsMsgData.onResume();
        enterExitDcsMsgData.report();
    }

    /* renamed from: C */
    private void m9523C() {
        EnterExitDcsMsgData enterExitDcsMsgData = new EnterExitDcsMsgData(this, "exit");
        enterExitDcsMsgData.mExitCallPackage = this.f10623H.m13358v();
        enterExitDcsMsgData.mShortcutType = this.f10623H.m13316I();
        enterExitDcsMsgData.mbToGallery = this.mCameraManager.m10228Z();
        enterExitDcsMsgData.mResumePauseTime = System.currentTimeMillis() - this.f10620E;
        enterExitDcsMsgData.mCameraEnterType = String.valueOf(this.f10623H.m13317J());
        enterExitDcsMsgData.mResumePauseVideoTime = this.mCameraManager.m10276aL();
        enterExitDcsMsgData.mCaptureMode = this.f10623H.m13340d();
        enterExitDcsMsgData.mCameraId = this.mCameraManager.m10285aU();
        enterExitDcsMsgData.onPause();
        enterExitDcsMsgData.report();
    }

    /* renamed from: s */
    public void m9573s() {
        CameraLog.m12954a("OplusCamera", "copyOdmFileToCache");
        final String str = getApplicationContext().getCacheDir().getAbsolutePath() + File.separator + "anc_cache";
        File file = new File(str);
        final String str2 = "odm/etc/camera/megvii/anc_cache";
        File file2 = new File("odm/etc/camera/megvii/anc_cache");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
        if (file2.exists()) {
            CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.Camera.16
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    Util.m24280a(str2, str);
                }
            }, "Video blur and retention cache copy");
        }
    }

    /* renamed from: D */
    private void m9524D() {
        Intent intent = new Intent(this, (Class<?>) ApsService.class);
        try {
            CameraLog.m12954a("OplusCamera", "startDaemonService, stopService and startForegroundService");
            stopService(intent);
            startForegroundService(intent);
        } catch (IllegalStateException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }
}
