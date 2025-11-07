package com.oplus.camera.watch;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.heytap.accessory.BaseAgent;
import com.heytap.accessory.BaseSocket;
import com.heytap.accessory.bean.PeerAgent;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class WatchAgentService extends BaseAgent {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final AtomicBoolean f23153a = new AtomicBoolean(false);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final Class<WatchAgentSocket> f23154b = WatchAgentSocket.class;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private BinderC3565a f23155c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private WatchAgentProxy f23156d;

    public WatchAgentService() {
        super("WatchAgentService", f23154b);
        this.f23155c = new BinderC3565a();
        this.f23156d = null;
    }

    @Override // com.heytap.accessory.BaseAgent, android.app.Service
    public void onCreate() {
        CameraLog.m12954a("WatchAgentService", "onCreate");
        super.onCreate();
        this.f23156d = new WatchAgentProxy(this);
    }

    @Override // com.heytap.accessory.BaseAgent, android.app.Service
    public int onStartCommand(Intent intent, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("WatchAgentService", "onStartCommand");
        super.onStartCommand(intent, OplusGLSurfaceView_13, i2);
        m24703a();
        return 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24703a() {
        CameraLog.m12954a("WatchAgentService", "startForeground");
        if (Build.VERSION.SDK_INT > 26) {
            startForeground(1, new NotificationCompat.IntrinsicsJvm.kt_5(this, m24702a("com.oplus.camera", getString(R.string.camera_app_name))).m2407a(true).m2412c(-2).m2406a("service").m2408b());
        } else {
            startForeground(1, new Notification());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m24702a(String str, String str2) {
        NotificationChannel notificationChannel = new NotificationChannel(str, str2, 0);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setLockscreenVisibility(0);
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
        return str;
    }

    @Override // com.heytap.accessory.BaseAgent, android.app.Service
    public void onDestroy() {
        CameraLog.m12954a("WatchAgentService", "onDestroy");
        WatchAgentProxy c3571f = this.f23156d;
        if (c3571f != null) {
            c3571f.m24798d();
        }
        f23153a.set(false);
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f23155c;
    }

    @Override // com.heytap.accessory.BaseAgent
    protected void onServiceConnectionResponse(PeerAgent peerAgent, BaseSocket baseSocket, int OplusGLSurfaceView_13) {
        if (baseSocket == null) {
            CameraLog.m12954a("WatchAgentService", "onServiceConnectionResponse, reject connect because of socket is null");
            return;
        }
        if (OplusGLSurfaceView_13 != 0) {
            CameraLog.m12954a("WatchAgentService", "onServiceConnectionResponse, reject connect because of result: " + OplusGLSurfaceView_13);
            return;
        }
        if (this.f23156d != null) {
            f23153a.set(true);
            this.f23156d.m24795a(new WatchAgentModel((WatchAgentSocket) baseSocket, this, peerAgent));
        }
    }

    @Override // com.heytap.accessory.BaseAgent
    protected void onServiceConnectionRequested(PeerAgent peerAgent) {
        if (peerAgent == null) {
            CameraLog.m12954a("WatchAgentService", "onServiceConnectionRequested, peerAgent is null");
            rejectServiceConnectionRequest(peerAgent);
        } else if (!"com.heytap.wearable.cameraassistant".equals(peerAgent.getAppName())) {
            CameraLog.m12954a("WatchAgentService", "onServiceConnectionRequested, reject connect because of package name is not correct!!!");
            rejectServiceConnectionRequest(peerAgent);
        } else {
            acceptServiceConnectionRequest(peerAgent);
        }
    }

    /* renamed from: com.oplus.camera.watch.WatchAgentService$PlatformImplementations.kt_3 */
    public class BinderC3565a extends Binder {
        public BinderC3565a() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public WatchAgentProxy m24704a() {
            return WatchAgentService.this.f23156d;
        }
    }

    public class WatchAgentSocket extends BaseSocket {
        public WatchAgentSocket() {
            super("WatchAgentSocket");
        }

        @Override // com.heytap.accessory.BaseSocket
        public void onError(int OplusGLSurfaceView_13, String str, int i2) {
            CameraLog.m12954a("WatchAgentService", "onError");
        }

        @Override // com.heytap.accessory.BaseSocket
        public void onReceive(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, byte[] bArr) {
            if (WatchAgentService.this.f23156d != null) {
                WatchAgentService.this.f23156d.m24796a(bArr);
            }
        }

        @Override // com.heytap.accessory.BaseSocket
        public void onServiceConnectionLost(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
            CameraLog.m12954a("WatchAgentService", "onServiceConnectionLost");
            if (WatchAgentService.this.f23156d != null) {
                WatchAgentService.f23153a.set(false);
                WatchAgentService.this.f23156d.m24797c();
            }
        }
    }
}
