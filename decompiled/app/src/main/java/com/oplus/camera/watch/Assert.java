package com.oplus.camera.watch;

/* loaded from: classes2.dex */
public class WatchAgentService extends com.heytap.accessory.BaseAgent {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.util.concurrent.atomic.AtomicBoolean f7401a = new java.util.concurrent.atomic.AtomicBoolean(false);

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.Class<com.oplus.camera.watch.WatchAgentService.WatchAgentSocket> f7402b = com.oplus.camera.watch.WatchAgentService.WatchAgentSocket.class;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.watch.WatchAgentService.a_renamed f7403c;
    private com.oplus.camera.watch.f_renamed d_renamed;

    public WatchAgentService() {
        super("WatchAgentService", f7402b);
        this.f7403c = new com.oplus.camera.watch.WatchAgentService.a_renamed();
        this.d_renamed = null;
    }

    @Override // com.heytap.accessory.BaseAgent, android.app.Service
    public void onCreate() {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentService", "onCreate");
        super.onCreate();
        this.d_renamed = new com.oplus.camera.watch.f_renamed(this);
    }

    @Override // com.heytap.accessory.BaseAgent, android.app.Service
    public int onStartCommand(android.content.Intent intent, int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentService", "onStartCommand");
        super.onStartCommand(intent, i_renamed, i2);
        a_renamed();
        return 1;
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentService", "startForeground");
        if (android.os.Build.VERSION.SDK_INT > 26) {
            startForeground(1, new androidx.core.app.h_renamed.d_renamed(this, a_renamed("com.oplus.camera", getString(com.oplus.camera.R_renamed.string.camera_app_name))).a_renamed(true).c_renamed(-2).a_renamed("service").b_renamed());
        } else {
            startForeground(1, new android.app.Notification());
        }
    }

    private java.lang.String a_renamed(java.lang.String str, java.lang.String str2) {
        android.app.NotificationChannel notificationChannel = new android.app.NotificationChannel(str, str2, 0);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setLockscreenVisibility(0);
        ((android.app.NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
        return str;
    }

    @Override // com.heytap.accessory.BaseAgent, android.app.Service
    public void onDestroy() {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentService", "onDestroy");
        com.oplus.camera.watch.f_renamed fVar = this.d_renamed;
        if (fVar != null) {
            fVar.d_renamed();
        }
        f7401a.set(false);
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return this.f7403c;
    }

    @Override // com.heytap.accessory.BaseAgent
    protected void onServiceConnectionResponse(com.heytap.accessory.bean.PeerAgent peerAgent, com.heytap.accessory.BaseSocket baseSocket, int i_renamed) {
        if (baseSocket == null) {
            com.oplus.camera.e_renamed.a_renamed("WatchAgentService", "onServiceConnectionResponse, reject connect because of_renamed socket is_renamed null");
            return;
        }
        if (i_renamed != 0) {
            com.oplus.camera.e_renamed.a_renamed("WatchAgentService", "onServiceConnectionResponse, reject connect because of_renamed result: " + i_renamed);
            return;
        }
        if (this.d_renamed != null) {
            f7401a.set(true);
            this.d_renamed.a_renamed(new com.oplus.camera.watch.d_renamed((com.oplus.camera.watch.WatchAgentService.WatchAgentSocket) baseSocket, this, peerAgent));
        }
    }

    @Override // com.heytap.accessory.BaseAgent
    protected void onServiceConnectionRequested(com.heytap.accessory.bean.PeerAgent peerAgent) {
        if (peerAgent == null) {
            com.oplus.camera.e_renamed.a_renamed("WatchAgentService", "onServiceConnectionRequested, peerAgent is_renamed null");
            rejectServiceConnectionRequest(peerAgent);
        } else if (!"com.heytap.wearable.cameraassistant".equals(peerAgent.getAppName())) {
            com.oplus.camera.e_renamed.a_renamed("WatchAgentService", "onServiceConnectionRequested, reject connect because of_renamed package name is_renamed not correct!!!");
            rejectServiceConnectionRequest(peerAgent);
        } else {
            acceptServiceConnectionRequest(peerAgent);
        }
    }

    public class a_renamed extends android.os.Binder {
        public a_renamed() {
        }

        public com.oplus.camera.watch.f_renamed a_renamed() {
            return com.oplus.camera.watch.WatchAgentService.this.d_renamed;
        }
    }

    public class WatchAgentSocket extends com.heytap.accessory.BaseSocket {
        public WatchAgentSocket() {
            super("WatchAgentSocket");
        }

        @Override // com.heytap.accessory.BaseSocket
        public void onError(int i_renamed, java.lang.String str, int i2) {
            com.oplus.camera.e_renamed.a_renamed("WatchAgentService", "onError");
        }

        @Override // com.heytap.accessory.BaseSocket
        public void onReceive(long j_renamed, int i_renamed, byte[] bArr) {
            if (com.oplus.camera.watch.WatchAgentService.this.d_renamed != null) {
                com.oplus.camera.watch.WatchAgentService.this.d_renamed.a_renamed(bArr);
            }
        }

        @Override // com.heytap.accessory.BaseSocket
        public void onServiceConnectionLost(long j_renamed, int i_renamed) {
            com.oplus.camera.e_renamed.a_renamed("WatchAgentService", "onServiceConnectionLost");
            if (com.oplus.camera.watch.WatchAgentService.this.d_renamed != null) {
                com.oplus.camera.watch.WatchAgentService.f7401a.set(false);
                com.oplus.camera.watch.WatchAgentService.this.d_renamed.c_renamed();
            }
        }
    }
}
