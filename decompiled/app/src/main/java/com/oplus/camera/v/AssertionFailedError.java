package com.oplus.camera.v_renamed;

/* compiled from: TemperatureNotificationManager.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f7370a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.app.NotificationManager f7371b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.v_renamed.a_renamed f7372c;

    public b_renamed(android.content.Context context, com.oplus.camera.v_renamed.a_renamed aVar) {
        this.f7370a = null;
        this.f7370a = context;
        this.f7372c = aVar;
    }

    public void a_renamed() {
        int i_renamed = android.provider.Settings.System.getInt(this.f7370a.getContentResolver(), "oplus_settings_hightemp_protect", 0);
        com.oplus.camera.e_renamed.b_renamed("TemperatureNotificationManager", "initTemperatureSettings highTempProtectStatus: " + i_renamed);
        this.f7371b = (android.app.NotificationManager) this.f7370a.getSystemService("notification");
        if (1 == i_renamed) {
            com.oplus.camera.Camera.m_renamed = true;
            com.oplus.camera.Camera.o_renamed = true;
            a_renamed(this.f7370a.getString(com.oplus.camera.R_renamed.string.camera_high_temperature_exit_toast), this.f7370a.getString(com.oplus.camera.R_renamed.string.camera_high_temperature_exit_notification));
            android.content.Context context = this.f7370a;
            android.widget.Toast.makeText(context, context.getString(com.oplus.camera.R_renamed.string.camera_high_temperature_exit_notification), 1).show();
            this.f7372c.a_renamed(true, i_renamed);
            return;
        }
        b_renamed();
        com.oplus.camera.Camera.m_renamed = false;
        com.oplus.camera.Camera.o_renamed = false;
    }

    private void a_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.camera.e_renamed.b_renamed("TemperatureNotificationManager", "temperatureNotifyIn");
        android.content.Intent intent = new android.content.Intent();
        intent.setPackage(this.f7370a.getPackageName());
        intent.setAction("camera_close");
        android.app.PendingIntent broadcast = android.app.PendingIntent.getBroadcast(this.f7370a, 0, intent, 335544320);
        android.app.NotificationChannel notificationChannel = new android.app.NotificationChannel("1", "camera", 4);
        androidx.core.app.h_renamed.b_renamed bVar = new androidx.core.app.h_renamed.b_renamed();
        bVar.a_renamed(str);
        android.app.NotificationManager notificationManager = this.f7371b;
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
            androidx.core.app.h_renamed.d_renamed dVar = new androidx.core.app.h_renamed.d_renamed(this.f7370a, "1");
            dVar.b_renamed(16);
            dVar.b_renamed(true);
            dVar.a_renamed(bVar);
            dVar.a_renamed((java.lang.CharSequence) str2);
            dVar.a_renamed(com.oplus.camera.R_renamed.drawable.ic_launcher_camera);
            dVar.b_renamed(str2).a_renamed(java.lang.System.currentTimeMillis());
            dVar.a_renamed(broadcast);
            this.f7371b.notify(1, dVar.b_renamed());
        }
    }

    public void b_renamed() {
        if (this.f7371b != null) {
            com.oplus.camera.e_renamed.b_renamed("TemperatureNotificationManager", "cancelTemperatureNofify");
            this.f7371b.cancel(1);
        }
    }

    public void c_renamed() {
        if (this.f7371b != null) {
            this.f7371b = null;
        }
        this.f7370a = null;
    }
}
