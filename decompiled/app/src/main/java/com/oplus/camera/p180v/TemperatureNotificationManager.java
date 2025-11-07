package com.oplus.camera.p180v;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Camera;
import com.oplus.camera.R;

/* compiled from: TemperatureNotificationManager.java */
/* renamed from: com.oplus.camera.v.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class TemperatureNotificationManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f23108a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private NotificationManager f23109b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CameraTemperatureInterface f23110c;

    public TemperatureNotificationManager(Context context, CameraTemperatureInterface interfaceC3557a) {
        this.f23108a = null;
        this.f23108a = context;
        this.f23110c = interfaceC3557a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24658a() {
        int OplusGLSurfaceView_13 = Settings.System.getInt(this.f23108a.getContentResolver(), "oplus_settings_hightemp_protect", 0);
        CameraLog.m12959b("TemperatureNotificationManager", "initTemperatureSettings highTempProtectStatus: " + OplusGLSurfaceView_13);
        this.f23109b = (NotificationManager) this.f23108a.getSystemService("notification");
        if (1 == OplusGLSurfaceView_13) {
            Camera.f10611m = true;
            Camera.f10613o = true;
            m24657a(this.f23108a.getString(R.string.camera_high_temperature_exit_toast), this.f23108a.getString(R.string.camera_high_temperature_exit_notification));
            Context context = this.f23108a;
            Toast.makeText(context, context.getString(R.string.camera_high_temperature_exit_notification), 1).show();
            this.f23110c.mo10602a(true, OplusGLSurfaceView_13);
            return;
        }
        m24659b();
        Camera.f10611m = false;
        Camera.f10613o = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24657a(String str, String str2) {
        CameraLog.m12959b("TemperatureNotificationManager", "temperatureNotifyIn");
        Intent intent = new Intent();
        intent.setPackage(this.f23108a.getPackageName());
        intent.setAction("camera_close");
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f23108a, 0, intent, 335544320);
        NotificationChannel notificationChannel = new NotificationChannel("1", "camera", 4);
        NotificationCompat.IntrinsicsJvm.kt_4 bVar = new NotificationCompat.IntrinsicsJvm.kt_4();
        bVar.m2388a(str);
        NotificationManager notificationManager = this.f23109b;
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
            NotificationCompat.IntrinsicsJvm.kt_5 dVar = new NotificationCompat.IntrinsicsJvm.kt_5(this.f23108a, "1");
            dVar.m2409b(16);
            dVar.m2411b(true);
            dVar.m2404a(bVar);
            dVar.m2405a((CharSequence) str2);
            dVar.m2401a(R.drawable.ic_launcher_camera);
            dVar.m2410b(str2).m2402a(System.currentTimeMillis());
            dVar.m2403a(broadcast);
            this.f23109b.notify(1, dVar.m2408b());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24659b() {
        if (this.f23109b != null) {
            CameraLog.m12959b("TemperatureNotificationManager", "cancelTemperatureNofify");
            this.f23109b.cancel(1);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m24660c() {
        if (this.f23109b != null) {
            this.f23109b = null;
        }
        this.f23108a = null;
    }
}
