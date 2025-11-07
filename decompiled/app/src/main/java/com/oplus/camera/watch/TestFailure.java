package com.oplus.camera.watch;

/* compiled from: WatchAgentProxy.java */
/* loaded from: classes2.dex */
public class f_renamed implements com.oplus.camera.watch.b_renamed.WatchAgentContract_3 {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.util.List<java.lang.String> f7422a = java.util.List.of_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_NIGHT, com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON, "portrait");

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.watch.WatchAgentService f7423b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.watch.b_renamed.a_renamed f7424c = null;
    private com.oplus.camera.watch.d_renamed d_renamed = null;
    private com.oplus.camera.watch.a_renamed e_renamed = null;
    private java.util.concurrent.atomic.AtomicBoolean f_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
    private java.util.concurrent.atomic.AtomicBoolean g_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
    private java.util.concurrent.atomic.AtomicBoolean h_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
    private java.util.concurrent.atomic.AtomicBoolean i_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
    private com.oplus.camera.watch.c_renamed j_renamed = new com.oplus.camera.watch.c_renamed();
    private com.oplus.camera.watch.a_renamed.WatchAgentCodec_2 k_renamed = new com.oplus.camera.watch.a_renamed.WatchAgentCodec_2() { // from class: com.oplus.camera.watch.f_renamed.1
        @Override // com.oplus.camera.watch.a_renamed.WatchAgentCodec_2
        public void a_renamed(byte[] bArr) {
            if (com.oplus.camera.watch.f_renamed.this.d_renamed != null) {
                com.oplus.camera.watch.f_renamed.this.d_renamed.a_renamed(bArr, false);
            }
        }
    };

    public f_renamed(com.oplus.camera.watch.WatchAgentService watchAgentService) {
        this.f7423b = null;
        this.f7423b = watchAgentService;
    }

    @Override // com.oplus.camera.watch.b_renamed.WatchAgentContract_3
    public void a_renamed(com.oplus.camera.watch.b_renamed.a_renamed aVar) {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "attachCameraContract, mbAgentReady: " + this.g_renamed.get());
        this.f7423b.a_renamed();
        this.f7424c = aVar;
        this.f_renamed.set(true);
        g_renamed();
    }

    @Override // com.oplus.camera.watch.b_renamed.WatchAgentContract_3
    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "detachCameraContract");
        if (this.i_renamed.getAndSet(false)) {
            this.e_renamed.c_renamed();
            this.e_renamed = null;
        }
        this.f7424c = null;
        this.f_renamed.set(false);
        this.h_renamed.set(false);
    }

    public void a_renamed(com.oplus.camera.watch.d_renamed dVar) {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "attachWatchAgent, mbCameraReady: " + this.f_renamed.get());
        this.d_renamed = dVar;
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "detachWatchAgent");
        if (!this.g_renamed.get()) {
            com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "detachWatchAgent, mbAgentReady is_renamed false");
            return;
        }
        com.oplus.camera.watch.b_renamed.a_renamed aVar = this.f7424c;
        if (aVar != null) {
            aVar.b_renamed();
        }
        if (this.i_renamed.getAndSet(false)) {
            this.e_renamed.c_renamed();
            this.e_renamed = null;
        }
        com.oplus.camera.watch.d_renamed dVar = this.d_renamed;
        if (dVar != null) {
            dVar.b_renamed();
        }
        this.g_renamed.set(false);
    }

    public void d_renamed() {
        com.oplus.camera.watch.d_renamed dVar = this.d_renamed;
        if (dVar != null) {
            dVar.d_renamed();
        }
    }

    public void a_renamed(byte[] bArr) {
        com.oplus.camera.watch.e_renamed.a_renamed aVarB = com.oplus.camera.watch.e_renamed.b_renamed(bArr);
        com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "onMessageReceived, itemInfo: " + aVarB);
        int iA = aVarB.a_renamed();
        if (iA == 1) {
            com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage watchConnectPreviewMessage = (com.oplus.camera.watch.proto.WatchAgentProto.WatchConnectPreviewMessage) aVarB.b_renamed();
            this.j_renamed.b_renamed(new android.util.Size(watchConnectPreviewMessage.getPreviewWidth(), watchConnectPreviewMessage.getPreviewHeight()));
            this.j_renamed.a_renamed(watchConnectPreviewMessage.getBitRate());
            this.j_renamed.b_renamed(watchConnectPreviewMessage.getFrameRate());
            this.j_renamed.c_renamed(watchConnectPreviewMessage.getFrameInterval());
            this.j_renamed.d_renamed(watchConnectPreviewMessage.getCaptureQuality());
            this.j_renamed.e_renamed(watchConnectPreviewMessage.getSinglePackageSize());
            this.j_renamed.f_renamed(watchConnectPreviewMessage.getSinglePackageDelay());
            if (watchConnectPreviewMessage.getIsNeedLauncherCamera()) {
                e_renamed();
            }
            this.g_renamed.set(true);
            g_renamed();
            return;
        }
        if (iA == 21) {
            if (this.i_renamed.getAndSet(false)) {
                this.e_renamed.c_renamed();
                this.e_renamed = null;
                return;
            }
            return;
        }
        if (iA == 4) {
            if (this.f_renamed.get()) {
                this.f7424c.a_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON);
                return;
            }
            return;
        }
        if (iA == 5) {
            if (this.h_renamed.get()) {
                com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "onMessageReceived, delayCapturing");
                return;
            }
            com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage watchCaptureMessage = (com.oplus.camera.watch.proto.WatchAgentProto.WatchCaptureMessage) aVarB.b_renamed();
            java.lang.String str = "off";
            if (watchCaptureMessage.getCountDown() != 0) {
                if (1 == watchCaptureMessage.getCountDown()) {
                    str = "3";
                } else if (2 == watchCaptureMessage.getCountDown()) {
                    str = com.oplus.camera.statistics.model.FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE;
                }
            }
            if (this.f_renamed.get()) {
                this.f7424c.b_renamed(str);
                return;
            }
            return;
        }
        if (iA == 6 && this.f_renamed.get()) {
            this.f7424c.g_renamed();
        }
    }

    private void e_renamed() {
        boolean zG = com.oplus.camera.MyApplication.g_renamed();
        android.content.Intent intent = new android.content.Intent();
        com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "decideWayCameraBindWatchAgent, isCameraRunning: " + zG);
        if (zG) {
            intent.setAction("filter_bind_watch_agent");
            intent.putExtra("android_camera_launch_type", "watch_launch_from_framework");
            androidx.e_renamed.a_renamed.a_renamed.a_renamed(this.f7423b).a_renamed(intent);
        } else {
            intent.setComponent(new android.content.ComponentName(this.f7423b, (java.lang.Class<?>) com.oplus.camera.Camera.class));
            intent.addFlags(872415232);
            intent.putExtra("android_camera_launch_type", "watch_launch_from_framework");
            if (!((android.app.KeyguardManager) this.f7423b.getSystemService("keyguard")).isKeyguardSecure()) {
                intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
            } else {
                intent.setAction("android.media.action.STILL_IMAGE_CAMERA_SECURE");
            }
            try {
                com.oplus.compat.content.a_renamed.a_renamed(intent);
            } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e_renamed) {
                e_renamed.printStackTrace();
                this.f7423b.startActivity(intent);
            }
        }
        com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "decideWayCameraBindWatchAgent X_renamed");
    }

    private void f_renamed() {
        com.oplus.camera.watch.b_renamed.a_renamed aVar = this.f7424c;
        if (aVar == null) {
            com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "prepareWatchAgentCodec, mCameraContract is_renamed null");
            return;
        }
        this.j_renamed.a_renamed(aVar.e_renamed());
        android.util.Size sizeC = this.j_renamed.c_renamed();
        if (sizeC == null) {
            com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "prepareWatchAgentCodec, codecSize is_renamed null");
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "prepareWatchAgentCodec");
        this.i_renamed.set(true);
        this.f7424c.a_renamed(sizeC);
        this.e_renamed = new com.oplus.camera.watch.a_renamed();
        this.e_renamed.a_renamed(sizeC);
        this.e_renamed.a_renamed(this.f7424c.c_renamed());
        this.e_renamed.a_renamed(this.k_renamed);
        this.e_renamed.a_renamed(this.j_renamed.d_renamed());
        this.e_renamed.b_renamed(this.j_renamed.e_renamed());
        this.e_renamed.c_renamed(this.j_renamed.f_renamed());
        this.e_renamed.a_renamed(this.j_renamed.j_renamed());
        this.e_renamed.b_renamed();
        this.d_renamed.a_renamed(this.j_renamed);
        this.d_renamed.a_renamed(this.f7424c.d_renamed(), sizeC, this.f7424c.f_renamed());
    }

    private void g_renamed() {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "connectCameraPreviewIfAtomicReady, mbAgentReady: " + this.g_renamed.get() + ", mbCameraReady: " + this.f_renamed.get() + ", mbCodecRunning: " + this.i_renamed.get());
        if (this.g_renamed.get() && this.f_renamed.get() && !this.i_renamed.get()) {
            com.oplus.camera.watch.b_renamed.a_renamed aVar = this.f7424c;
            if (aVar != null) {
                aVar.a_renamed();
            }
            f_renamed();
        }
    }

    @Override // com.oplus.camera.watch.b_renamed.WatchAgentContract_3
    public void b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "onPause");
        if (!this.g_renamed.get()) {
            com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "onPause, mbAgentReady is_renamed false");
            return;
        }
        if (this.i_renamed.getAndSet(false)) {
            this.e_renamed.c_renamed();
            this.e_renamed = null;
        }
        com.oplus.camera.watch.d_renamed dVar = this.d_renamed;
        if (dVar != null) {
            dVar.c_renamed();
        }
    }

    @Override // com.oplus.camera.watch.b_renamed.WatchAgentContract_3
    public void a_renamed(boolean z_renamed) {
        if (this.j_renamed.a_renamed() != null && this.f7424c != null && this.j_renamed.a_renamed().equals(this.f7424c.e_renamed()) && this.i_renamed.get() && this.j_renamed.j_renamed() == z_renamed) {
            com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "createNewConfig, size no change");
            this.d_renamed.a_renamed(this.f7424c.d_renamed(), this.j_renamed.c_renamed(), this.f7424c.f_renamed());
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "createNewConfig");
        if (this.i_renamed.getAndSet(false)) {
            this.e_renamed.c_renamed();
            this.e_renamed = null;
        }
        this.j_renamed.a_renamed(z_renamed);
        g_renamed();
    }

    @Override // com.oplus.camera.watch.b_renamed.WatchAgentContract_3
    public void a_renamed(int i_renamed, android.graphics.Bitmap bitmap) {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentProxy", "captureStatusChange, status: " + i_renamed + ", mbAgentReady: " + this.g_renamed.get());
        if (this.g_renamed.get()) {
            if (i_renamed == 0) {
                this.d_renamed.a_renamed(true);
                this.h_renamed.set(true);
            } else if (i_renamed == 1) {
                this.d_renamed.a_renamed(false);
                this.h_renamed.set(false);
            } else {
                if (i_renamed != 2) {
                    return;
                }
                this.d_renamed.a_renamed(bitmap, this.j_renamed.b_renamed().getHeight(), this.j_renamed.b_renamed().getHeight());
                this.h_renamed.set(false);
            }
        }
    }

    @Override // com.oplus.camera.watch.b_renamed.WatchAgentContract_3
    public void a_renamed(int i_renamed, long j_renamed) {
        if (this.g_renamed.get()) {
            this.d_renamed.a_renamed(i_renamed, j_renamed);
        }
    }

    @Override // com.oplus.camera.watch.b_renamed.WatchAgentContract_3
    public void a_renamed(int i_renamed) {
        if (this.g_renamed.get()) {
            this.d_renamed.a_renamed(i_renamed);
        }
    }
}
