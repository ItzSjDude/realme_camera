package com.oplus.camera.ui;

/* compiled from: CountDownTimer.java */
/* loaded from: classes2.dex */
public class g_renamed {
    protected com.oplus.camera.ui.CameraUIInterface d_renamed;
    protected android.os.Handler e_renamed;
    private com.oplus.camera.ui.g_renamed.a_renamed g_renamed;
    private boolean f_renamed = false;

    /* renamed from: a_renamed, reason: collision with root package name */
    protected long f6213a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected long f6214b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected long f6215c = 0;

    /* compiled from: CountDownTimer.java */
    public interface a_renamed {
        void a_renamed();

        void a_renamed(boolean z_renamed);
    }

    public g_renamed(com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.g_renamed.a_renamed aVar) {
        this.d_renamed = null;
        this.e_renamed = null;
        this.g_renamed = null;
        this.d_renamed = cameraUIInterface;
        this.g_renamed = aVar;
        this.e_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.ui.g_renamed.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                int i_renamed = message.what;
                if (i_renamed == 2) {
                    com.oplus.camera.ui.g_renamed.this.g_renamed.a_renamed();
                    return;
                }
                if (i_renamed == 3) {
                    com.oplus.camera.ui.g_renamed.this.g_renamed.a_renamed(false);
                    com.oplus.camera.ui.g_renamed.this.f_renamed = false;
                } else {
                    if (i_renamed != 4) {
                        return;
                    }
                    com.oplus.camera.ui.g_renamed.this.g_renamed.a_renamed(true);
                    com.oplus.camera.ui.g_renamed.this.f_renamed = false;
                }
            }
        };
    }

    public void a_renamed() {
        this.f_renamed = false;
        this.e_renamed.removeMessages(2);
        this.e_renamed.sendEmptyMessage(4);
    }

    public void a_renamed(long j_renamed) {
        this.f6215c = j_renamed;
    }

    public long b_renamed() {
        return this.f6215c;
    }

    public void c_renamed() {
        this.f6213a = android.os.SystemClock.uptimeMillis();
        this.f_renamed = true;
    }

    public boolean d_renamed() {
        return this.f_renamed;
    }

    public void e_renamed() {
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        long j_renamed = jUptimeMillis - this.f6213a;
        this.f6215c -= j_renamed;
        this.f6214b += j_renamed;
        this.f6213a = jUptimeMillis;
        long j2 = this.f6215c;
        if (j2 < 0) {
            j2 = 0;
        }
        if (this.f6214b >= 1000) {
            com.oplus.camera.e_renamed.a_renamed("CountDownUI", "updateCountdownTime, currentTime: " + j2 + ", delta: " + j_renamed + ", mCountDownTemp: " + this.f6214b);
            long j3 = this.f6214b - 1000;
            this.f6215c = this.f6215c + j3;
            this.f6214b = 0L;
            this.d_renamed.a_renamed(j3 + j2, false);
        }
        if (j2 > 0) {
            this.e_renamed.sendEmptyMessageDelayed(2, 100L);
        } else {
            this.e_renamed.sendEmptyMessage(3);
        }
    }
}
