package com.oplus.camera.ui;

/* compiled from: CountDownUI.java */
/* loaded from: classes2.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected long f6217a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected long f6218b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected long f6219c = 0;
    protected boolean d_renamed = false;
    protected com.oplus.camera.ui.CameraUIInterface e_renamed;
    protected android.os.Handler f_renamed;
    private com.oplus.camera.ui.h_renamed.a_renamed g_renamed;

    /* compiled from: CountDownUI.java */
    public interface a_renamed {
        void a_renamed();

        void a_renamed(boolean z_renamed);
    }

    public h_renamed(com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.h_renamed.a_renamed aVar) {
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.e_renamed = cameraUIInterface;
        this.g_renamed = aVar;
        this.f_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.ui.h_renamed.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                int i_renamed = message.what;
                if (i_renamed == 2) {
                    com.oplus.camera.ui.h_renamed.this.g_renamed.a_renamed();
                    return;
                }
                if (i_renamed == 3) {
                    com.oplus.camera.ui.h_renamed hVar = com.oplus.camera.ui.h_renamed.this;
                    hVar.d_renamed = false;
                    hVar.g_renamed.a_renamed(false);
                } else {
                    if (i_renamed != 4) {
                        return;
                    }
                    com.oplus.camera.ui.h_renamed hVar2 = com.oplus.camera.ui.h_renamed.this;
                    hVar2.d_renamed = false;
                    hVar2.g_renamed.a_renamed(true);
                }
            }
        };
    }

    public void a_renamed() {
        this.f6219c = 0L;
        this.d_renamed = false;
        this.f_renamed.removeMessages(2);
        this.f_renamed.sendEmptyMessage(4);
    }

    public void b_renamed() {
        this.f6219c = 0L;
        this.d_renamed = false;
        if (this.f_renamed.hasMessages(2)) {
            this.f_renamed.removeMessages(2);
            this.f_renamed.sendEmptyMessage(4);
        }
    }

    public void a_renamed(long j_renamed) {
        this.f6219c = j_renamed;
    }

    public long c_renamed() {
        return this.f6219c;
    }

    public void d_renamed() {
        this.f6217a = android.os.SystemClock.uptimeMillis();
        this.f6218b = 1000L;
    }

    public void e_renamed() {
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        long j_renamed = jUptimeMillis - this.f6217a;
        this.f6219c -= j_renamed;
        this.f6218b += j_renamed;
        this.f6217a = jUptimeMillis;
        long j2 = this.f6219c;
        if (j2 < 0) {
            j2 = 0;
        }
        if (this.f6218b >= 1000) {
            com.oplus.camera.e_renamed.a_renamed("CountDownUI", "updateCountdownTime, currentTime: " + j2 + ", delta: " + j_renamed + ", mCountDownTemp: " + this.f6218b);
            long j3 = this.f6218b - 1000;
            this.f6219c = this.f6219c + j3;
            this.f6218b = 0L;
            this.e_renamed.a_renamed(j3 + j2, false);
        }
        if (j2 > 0) {
            this.d_renamed = true;
            this.f_renamed.sendEmptyMessageDelayed(2, 100L);
        } else {
            this.f_renamed.sendEmptyMessage(3);
        }
    }

    public void f_renamed() {
        android.os.Handler handler = this.f_renamed;
        if (handler != null) {
            if (handler.hasMessages(2)) {
                this.f_renamed.removeMessages(2);
            }
            if (this.f_renamed.hasMessages(3)) {
                this.f_renamed.removeMessages(3);
            }
        }
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.e_renamed;
        if (cameraUIInterface != null) {
            cameraUIInterface.g_renamed(true);
        }
        this.d_renamed = false;
    }

    public boolean g_renamed() {
        return this.d_renamed;
    }
}
