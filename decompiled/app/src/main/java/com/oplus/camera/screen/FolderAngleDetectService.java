package com.oplus.camera.screen;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import com.oplus.camera.CameraLog;
import com.oplus.camera.screen.p163a.IScreenSwitchInterface;
import com.oplus.camera.util.Util;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class FolderAngleDetectService extends Service {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final Boolean f15955d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final List<IScreenSwitchInterface.PlatformImplementations.kt_3> f15956e = new CopyOnWriteArrayList();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ContentObserver f15960f;

    /* renamed from: PlatformImplementations.kt_3 */
    Sensor f15957a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    SensorManager f15958b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    C2926a f15959c = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private SensorEventListener f15961g = new SensorEventListener() { // from class: com.oplus.camera.screen.FolderAngleDetectService.2
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent == null || sensorEvent.values == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("FolderAngleSensorEventListener onSensorChanged,");
                sb.append(sensorEvent == null ? " event is null! " : "event values is null");
                CameraLog.m12959b("FolderAngleDetectService", sb.toString());
                return;
            }
            if (sensorEvent == null || sensorEvent.values == null || sensorEvent.values.length <= 0) {
                return;
            }
            int OplusGLSurfaceView_13 = (int) sensorEvent.values[0];
            if (FolderAngleDetectService.f15955d.booleanValue()) {
                CameraLog.m12959b("FolderAngleDetectService", "FolderAngleSensorEventListener current: " + OplusGLSurfaceView_13);
            }
            Util.m24439e(OplusGLSurfaceView_13);
            Iterator it = FolderAngleDetectService.f15956e.iterator();
            while (it.hasNext()) {
                ((IScreenSwitchInterface.PlatformImplementations.kt_3) it.next()).onEvent(Util.f23001i);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int OplusGLSurfaceView_13) {
            CameraLog.m12959b("FolderAngleDetectService", "FolderAngleSensorEventListener onAccuracyChanged ");
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (this.f15958b == null) {
            this.f15958b = (SensorManager) getApplicationContext().getSystemService("sensor");
        }
        this.f15957a = this.f15958b.getDefaultSensor(33171038, false);
        this.f15958b.registerListener(this.f15961g, this.f15957a, 3);
        Uri uriFor = Settings.Global.getUriFor("oplus_system_folding_mode");
        if (this.f15960f == null) {
            this.f15960f = new ContentObserver(new Handler()) { // from class: com.oplus.camera.screen.FolderAngleDetectService.1
                @Override // android.database.ContentObserver
                public void onChange(boolean z, Uri uri) {
                    super.onChange(z, uri);
                    Iterator it = FolderAngleDetectService.f15956e.iterator();
                    while (it.hasNext()) {
                        ((IScreenSwitchInterface.PlatformImplementations.kt_3) it.next()).onEvent(Util.f23001i);
                    }
                    CameraLog.m12954a("FolderAngleDetectService", "onChange, uri: " + uri + ", foldingMode: " + Util.f23002j);
                }
            };
        }
        getContentResolver().registerContentObserver(uriFor, false, this.f15960f);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        this.f15959c = new C2926a();
        registerReceiver(this.f15959c, intentFilter);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12962c("FolderAngleDetectService", "onStartCommand");
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        SensorManager sensorManager = this.f15958b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f15961g);
            this.f15961g = null;
        }
        if (this.f15960f != null) {
            getContentResolver().unregisterContentObserver(this.f15960f);
        }
        C2926a c2926a = this.f15959c;
        if (c2926a != null) {
            unregisterReceiver(c2926a);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m16408a(IScreenSwitchInterface.PlatformImplementations.kt_3 aVar) {
        f15956e.add(aVar);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m16410b(IScreenSwitchInterface.PlatformImplementations.kt_3 aVar) {
        f15956e.remove(aVar);
    }

    /* renamed from: com.oplus.camera.screen.FolderAngleDetectService$PlatformImplementations.kt_3 */
    class C2926a extends BroadcastReceiver {
        C2926a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                if (FolderAngleDetectService.this.f15958b != null) {
                    FolderAngleDetectService.this.f15958b.unregisterListener(FolderAngleDetectService.this.f15961g);
                }
            } else {
                if (!"android.intent.action.SCREEN_ON".equals(intent.getAction()) || FolderAngleDetectService.this.f15958b == null || FolderAngleDetectService.this.f15957a == null) {
                    return;
                }
                FolderAngleDetectService.this.f15958b.registerListener(FolderAngleDetectService.this.f15961g, FolderAngleDetectService.this.f15957a, 3);
            }
        }
    }
}
