package com.oplus.camera.p180v;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.util.Util;
import com.oplus.compat.p182a.SettingsNative;
import com.oplus.util.OplusHoraeThermalHelper;

/* compiled from: TemperatureProvider.java */
/* renamed from: com.oplus.camera.v.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class TemperatureProvider {

    /* renamed from: PlatformImplementations.kt_3 */
    private ComboPreferences f23111a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CameraTemperatureInterface f23112b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ContentResolver f23114d;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private PlatformImplementations.kt_3 f23113c = new PlatformImplementations.kt_3();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private IntrinsicsJvm.kt_4 f23115e = null;

    public TemperatureProvider(Context context, ComboPreferences comboPreferences, CameraTemperatureInterface interfaceC3557a) {
        this.f23111a = null;
        this.f23112b = null;
        this.f23114d = null;
        this.f23112b = interfaceC3557a;
        this.f23114d = context.getContentResolver();
        this.f23111a = comboPreferences;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24666a(final boolean z) {
        Util.m24279a(new Runnable() { // from class: com.oplus.camera.v.IntrinsicsJvm.kt_3.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z2 = z;
                CameraLog.m12959b("TemperatureProvider", "notifyCameraOpened: " + (z2 ? 1 : 0));
                SettingsNative.IntrinsicsJvm.kt_4.m24845a("temperature_o_camera_open", z2 ? 1 : 0);
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24665a(final String str) {
        Util.m24279a(new Runnable() { // from class: com.oplus.camera.v.IntrinsicsJvm.kt_3.2
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12959b("TemperatureProvider", "notifyFlashState: " + str);
                SettingsNative.IntrinsicsJvm.kt_4.m24846a("temperature_o_camera_flash_status", str);
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24664a() {
        ContentResolver contentResolver = this.f23114d;
        if (contentResolver != null) {
            contentResolver.registerContentObserver(Settings.System.getUriFor("oplus.camera.flash"), false, this.f23113c);
            this.f23114d.registerContentObserver(Settings.System.getUriFor("oplus.camera.video"), false, this.f23113c);
            this.f23114d.registerContentObserver(Settings.System.getUriFor("oplus.camera.exit"), false, this.f23113c);
            this.f23114d.registerContentObserver(Settings.System.getUriFor("oplus.camera.brightness"), false, this.f23113c);
            this.f23114d.registerContentObserver(Settings.System.getUriFor("oplus_settings_hightemp_protect"), false, this.f23113c);
        }
        m24667b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24667b() {
        boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TEMPERATURE_CONTROL_STOP_VIDEO_RECORDING);
        boolean configBooleanValue2 = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TEMPERATURE_SEND_TO_HAL);
        boolean zM24495t = Util.m24495t();
        CameraLog.m12959b("TemperatureProvider", "registerTemperatureReceiver, mTemperatureReceiver: " + this.f23115e + ", controlVideo: " + configBooleanValue + ", sendToHal: " + configBooleanValue2 + ", foldProject: " + zM24495t);
        if (this.f23115e == null) {
            if (configBooleanValue || configBooleanValue2 || zM24495t) {
                this.f23115e = new IntrinsicsJvm.kt_4();
                Util.m24472l().registerReceiver(this.f23115e, new IntentFilter("oplus.intent.action.THERMAL_LEVEL_CHANGE"));
                CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.v.IntrinsicsJvm.kt_3.3
                    @Override // java.lang.Runnable
                    public void run() {
                        float currentThermal = OplusHoraeThermalHelper.getInstance().getCurrentThermal();
                        if (TemperatureProvider.this.f23111a != null) {
                            TemperatureProvider.this.f23111a.edit().putFloat(CameraUIInterface.KEY_CURRENT_TEMPERATURE, currentThermal).apply();
                        }
                        CameraLog.m12959b("TemperatureProvider", "registerTemperatureReceiver, getCurrentThermal, currentThermal: " + currentThermal);
                    }
                }, "GetCurTemperature");
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m24668c() {
        ContentResolver contentResolver;
        PlatformImplementations.kt_3 aVar = this.f23113c;
        if (aVar != null && (contentResolver = this.f23114d) != null) {
            contentResolver.unregisterContentObserver(aVar);
            this.f23114d = null;
            this.f23113c = null;
        }
        if (this.f23115e != null) {
            Util.m24472l().unregisterReceiver(this.f23115e);
            this.f23115e = null;
        }
    }

    /* compiled from: TemperatureProvider.java */
    /* renamed from: com.oplus.camera.v.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    private final class PlatformImplementations.kt_3 extends ContentObserver {
        public PlatformImplementations.kt_3() {
            super(new Handler(Looper.getMainLooper()));
        }

        /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            String lastPathSegment = uri == null ? null : uri.getLastPathSegment();
            CameraLog.m12959b("TemperatureProvider", "onChange ur: " + uri + ", settingsNam: " + lastPathSegment);
            if (TemperatureProvider.this.f23114d == null || TextUtils.isEmpty(lastPathSegment)) {
                return;
            }
            char c2 = 65535;
            switch (lastPathSegment.hashCode()) {
                case -1694432468:
                    if (lastPathSegment.equals("oplus.camera.flash")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1679743049:
                    if (lastPathSegment.equals("oplus.camera.video")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -885961118:
                    if (lastPathSegment.equals("oplus.camera.exit")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -91767147:
                    if (lastPathSegment.equals("oplus.camera.brightness")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 844777068:
                    if (lastPathSegment.equals("oplus_settings_hightemp_protect")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                int OplusGLSurfaceView_13 = Settings.System.getInt(TemperatureProvider.this.f23114d, lastPathSegment, 0);
                CameraLog.m12959b("TemperatureProvider", "onChange, oplus.camera.flash: " + OplusGLSurfaceView_13);
                if (1 == OplusGLSurfaceView_13) {
                    TemperatureProvider.this.f23112b.mo10598a();
                    return;
                }
                return;
            }
            if (c2 == 1) {
                int i2 = Settings.System.getInt(TemperatureProvider.this.f23114d, lastPathSegment, 0);
                CameraLog.m12959b("TemperatureProvider", "onChange, oplus.camera.video: " + i2);
                TemperatureProvider.this.f23112b.mo10600a(i2);
                return;
            }
            if (c2 == 2) {
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_TEMPERATURE_PROTECTION)) {
                    int i3 = Settings.System.getInt(TemperatureProvider.this.f23114d, lastPathSegment, 0);
                    CameraLog.m12959b("TemperatureProvider", "onChange, oplus.camera.exit: " + i3);
                    TemperatureProvider.this.f23112b.mo10602a(false, i3);
                    return;
                }
                return;
            }
            if (c2 == 3) {
                float COUIBaseListPopupWindow_12 = Settings.System.getInt(TemperatureProvider.this.f23114d, lastPathSegment, 0);
                float f2 = Settings.System.getInt(TemperatureProvider.this.f23114d, CameraStatisticsUtil.SCREEN_BRIGHTNESS, 130);
                CameraLog.m12959b("TemperatureProvider", "onChange, brightness: " + COUIBaseListPopupWindow_12 + ", currBrightness: " + f2);
                if (f2 > COUIBaseListPopupWindow_12) {
                    TemperatureProvider.this.f23112b.mo10599a(COUIBaseListPopupWindow_12);
                    return;
                }
                return;
            }
            if (c2 == 4 && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_TEMPERATURE_PROTECTION)) {
                int i4 = Settings.System.getInt(TemperatureProvider.this.f23114d, lastPathSegment, 0);
                CameraLog.m12959b("TemperatureProvider", "onChange, oplus_settings_hightemp_protect: " + i4);
                TemperatureProvider.this.f23112b.mo10602a(false, i4);
            }
        }
    }

    /* compiled from: TemperatureProvider.java */
    /* renamed from: com.oplus.camera.v.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends BroadcastReceiver {
        private IntrinsicsJvm.kt_4() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("currenttemperature", -1);
            int intExtra2 = intent.getIntExtra("thermallevel", -1);
            TemperatureProvider.this.f23112b.mo10601a(intExtra2, intExtra);
            TemperatureProvider.this.f23112b.mo10603b(intExtra);
            CameraLog.m12959b("TemperatureProvider", "onReceive, curTemperatureLevel: " + intExtra2 + ", curTemperature: " + intExtra);
        }
    }
}
