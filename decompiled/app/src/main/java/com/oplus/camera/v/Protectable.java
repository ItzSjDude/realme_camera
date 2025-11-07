package com.oplus.camera.v_renamed;

/* compiled from: TemperatureProvider.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.ComboPreferences f7373a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.v_renamed.a_renamed f7374b;
    private android.content.ContentResolver d_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.v_renamed.c_renamed.a_renamed f7375c = new com.oplus.camera.v_renamed.c_renamed.a_renamed();
    private com.oplus.camera.v_renamed.c_renamed.b_renamed e_renamed = null;

    public c_renamed(android.content.Context context, com.oplus.camera.ComboPreferences comboPreferences, com.oplus.camera.v_renamed.a_renamed aVar) {
        this.f7373a = null;
        this.f7374b = null;
        this.d_renamed = null;
        this.f7374b = aVar;
        this.d_renamed = context.getContentResolver();
        this.f7373a = comboPreferences;
    }

    public void a_renamed(final boolean z_renamed) {
        com.oplus.camera.util.Util.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.v_renamed.c_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z2 = z_renamed;
                com.oplus.camera.e_renamed.b_renamed("TemperatureProvider", "notifyCameraOpened: " + (z2 ? 1 : 0));
                com.oplus.compat.a_renamed.a_renamed.b_renamed.a_renamed("temperature_o_camera_open", z2 ? 1 : 0);
            }
        });
    }

    public void a_renamed(final java.lang.String str) {
        com.oplus.camera.util.Util.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.v_renamed.c_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.b_renamed("TemperatureProvider", "notifyFlashState: " + str);
                com.oplus.compat.a_renamed.a_renamed.b_renamed.a_renamed("temperature_o_camera_flash_status", str);
            }
        });
    }

    public void a_renamed() {
        android.content.ContentResolver contentResolver = this.d_renamed;
        if (contentResolver != null) {
            contentResolver.registerContentObserver(android.provider.Settings.System.getUriFor("oplus.camera.flash"), false, this.f7375c);
            this.d_renamed.registerContentObserver(android.provider.Settings.System.getUriFor("oplus.camera.video"), false, this.f7375c);
            this.d_renamed.registerContentObserver(android.provider.Settings.System.getUriFor("oplus.camera.exit"), false, this.f7375c);
            this.d_renamed.registerContentObserver(android.provider.Settings.System.getUriFor("oplus.camera.brightness"), false, this.f7375c);
            this.d_renamed.registerContentObserver(android.provider.Settings.System.getUriFor("oplus_settings_hightemp_protect"), false, this.f7375c);
        }
        b_renamed();
    }

    public void b_renamed() {
        boolean configBooleanValue = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TEMPERATURE_CONTROL_STOP_VIDEO_RECORDING);
        boolean configBooleanValue2 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TEMPERATURE_SEND_TO_HAL);
        boolean zT = com.oplus.camera.util.Util.t_renamed();
        com.oplus.camera.e_renamed.b_renamed("TemperatureProvider", "registerTemperatureReceiver, mTemperatureReceiver: " + this.e_renamed + ", controlVideo: " + configBooleanValue + ", sendToHal: " + configBooleanValue2 + ", foldProject: " + zT);
        if (this.e_renamed == null) {
            if (configBooleanValue || configBooleanValue2 || zT) {
                this.e_renamed = new com.oplus.camera.v_renamed.c_renamed.b_renamed();
                com.oplus.camera.util.Util.l_renamed().registerReceiver(this.e_renamed, new android.content.IntentFilter("oplus.intent.action.THERMAL_LEVEL_CHANGE"));
                com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.v_renamed.c_renamed.3
                    @Override // java.lang.Runnable
                    public void run() {
                        float currentThermal = com.oplus.util.OplusHoraeThermalHelper.getInstance().getCurrentThermal();
                        if (com.oplus.camera.v_renamed.c_renamed.this.f7373a != null) {
                            com.oplus.camera.v_renamed.c_renamed.this.f7373a.edit().putFloat(com.oplus.camera.ui.CameraUIInterface.KEY_CURRENT_TEMPERATURE, currentThermal).apply();
                        }
                        com.oplus.camera.e_renamed.b_renamed("TemperatureProvider", "registerTemperatureReceiver, getCurrentThermal, currentThermal: " + currentThermal);
                    }
                }, "GetCurTemperature");
            }
        }
    }

    public void c_renamed() {
        android.content.ContentResolver contentResolver;
        com.oplus.camera.v_renamed.c_renamed.a_renamed aVar = this.f7375c;
        if (aVar != null && (contentResolver = this.d_renamed) != null) {
            contentResolver.unregisterContentObserver(aVar);
            this.d_renamed = null;
            this.f7375c = null;
        }
        if (this.e_renamed != null) {
            com.oplus.camera.util.Util.l_renamed().unregisterReceiver(this.e_renamed);
            this.e_renamed = null;
        }
    }

    /* compiled from: TemperatureProvider.java */
    private final class a_renamed extends android.database.ContentObserver {
        public a_renamed() {
            super(new android.os.Handler(android.os.Looper.getMainLooper()));
        }

        /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
        @Override // android.database.ContentObserver
        public void onChange(boolean z_renamed, android.net.Uri uri) {
            java.lang.String lastPathSegment = uri == null ? null : uri.getLastPathSegment();
            com.oplus.camera.e_renamed.b_renamed("TemperatureProvider", "onChange ur: " + uri + ", settingsNam: " + lastPathSegment);
            if (com.oplus.camera.v_renamed.c_renamed.this.d_renamed == null || android.text.TextUtils.isEmpty(lastPathSegment)) {
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
                int i_renamed = android.provider.Settings.System.getInt(com.oplus.camera.v_renamed.c_renamed.this.d_renamed, lastPathSegment, 0);
                com.oplus.camera.e_renamed.b_renamed("TemperatureProvider", "onChange, oplus.camera.flash: " + i_renamed);
                if (1 == i_renamed) {
                    com.oplus.camera.v_renamed.c_renamed.this.f7374b.a_renamed();
                    return;
                }
                return;
            }
            if (c2 == 1) {
                int i2 = android.provider.Settings.System.getInt(com.oplus.camera.v_renamed.c_renamed.this.d_renamed, lastPathSegment, 0);
                com.oplus.camera.e_renamed.b_renamed("TemperatureProvider", "onChange, oplus.camera.video: " + i2);
                com.oplus.camera.v_renamed.c_renamed.this.f7374b.a_renamed(i2);
                return;
            }
            if (c2 == 2) {
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_TEMPERATURE_PROTECTION)) {
                    int i3 = android.provider.Settings.System.getInt(com.oplus.camera.v_renamed.c_renamed.this.d_renamed, lastPathSegment, 0);
                    com.oplus.camera.e_renamed.b_renamed("TemperatureProvider", "onChange, oplus.camera.exit: " + i3);
                    com.oplus.camera.v_renamed.c_renamed.this.f7374b.a_renamed(false, i3);
                    return;
                }
                return;
            }
            if (c2 == 3) {
                float f_renamed = android.provider.Settings.System.getInt(com.oplus.camera.v_renamed.c_renamed.this.d_renamed, lastPathSegment, 0);
                float f2 = android.provider.Settings.System.getInt(com.oplus.camera.v_renamed.c_renamed.this.d_renamed, com.oplus.camera.statistics.CameraStatisticsUtil.SCREEN_BRIGHTNESS, 130);
                com.oplus.camera.e_renamed.b_renamed("TemperatureProvider", "onChange, brightness: " + f_renamed + ", currBrightness: " + f2);
                if (f2 > f_renamed) {
                    com.oplus.camera.v_renamed.c_renamed.this.f7374b.a_renamed(f_renamed);
                    return;
                }
                return;
            }
            if (c2 == 4 && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_TEMPERATURE_PROTECTION)) {
                int i4 = android.provider.Settings.System.getInt(com.oplus.camera.v_renamed.c_renamed.this.d_renamed, lastPathSegment, 0);
                com.oplus.camera.e_renamed.b_renamed("TemperatureProvider", "onChange, oplus_settings_hightemp_protect: " + i4);
                com.oplus.camera.v_renamed.c_renamed.this.f7374b.a_renamed(false, i4);
            }
        }
    }

    /* compiled from: TemperatureProvider.java */
    private class b_renamed extends android.content.BroadcastReceiver {
        private b_renamed() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            int intExtra = intent.getIntExtra("currenttemperature", -1);
            int intExtra2 = intent.getIntExtra("thermallevel", -1);
            com.oplus.camera.v_renamed.c_renamed.this.f7374b.a_renamed(intExtra2, intExtra);
            com.oplus.camera.v_renamed.c_renamed.this.f7374b.b_renamed(intExtra);
            com.oplus.camera.e_renamed.b_renamed("TemperatureProvider", "onReceive, curTemperatureLevel: " + intExtra2 + ", curTemperature: " + intExtra);
        }
    }
}
