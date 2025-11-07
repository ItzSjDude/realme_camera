package com.oplus.camera.ui;

/* compiled from: CountUpTimer.java */
/* loaded from: classes2.dex */
public class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f6221a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private long f6222b = 1000;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f6223c = false;
    private com.oplus.camera.ui.CameraUIInterface d_renamed;
    private android.os.Handler e_renamed;
    private com.oplus.camera.ui.i_renamed.a_renamed f_renamed;

    /* compiled from: CountUpTimer.java */
    public interface a_renamed {
        void a_renamed();

        void a_renamed(boolean z_renamed);
    }

    public i_renamed(com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.i_renamed.a_renamed aVar) {
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.d_renamed = cameraUIInterface;
        this.f_renamed = aVar;
        this.e_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.ui.i_renamed.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                int i_renamed = message.what;
                if (i_renamed == 1) {
                    com.oplus.camera.ui.i_renamed.this.f_renamed.a_renamed();
                    return;
                }
                if (i_renamed == 2) {
                    com.oplus.camera.ui.i_renamed.this.f_renamed.a_renamed(false);
                    com.oplus.camera.ui.i_renamed.this.f6223c = false;
                } else {
                    if (i_renamed != 3) {
                        return;
                    }
                    com.oplus.camera.ui.i_renamed.this.f_renamed.a_renamed(true);
                    com.oplus.camera.ui.i_renamed.this.f6223c = false;
                }
            }
        };
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CountUpTimer", "stop");
        this.f6223c = false;
        this.e_renamed.removeMessages(1);
        this.e_renamed.sendEmptyMessage(3);
    }

    public long a_renamed(long j_renamed) {
        this.f6221a = j_renamed;
        return j_renamed;
    }

    public long b_renamed() {
        return this.f6221a;
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CountUpTimer", com.google.android.exoplayer2.text.ttml.TtmlNode.START);
        this.f6223c = true;
        a_renamed(0L);
        this.d_renamed.b_renamed(b_renamed());
        this.e_renamed.sendEmptyMessageDelayed(1, this.f6222b);
    }

    public void b_renamed(long j_renamed) {
        this.f6222b = j_renamed;
    }

    public boolean d_renamed() {
        return this.f6223c;
    }

    public void e_renamed() {
        a_renamed(this.f6221a + this.f6222b);
        com.oplus.camera.e_renamed.a_renamed("CountUpTimer", "updateTime, mTotalTime: " + this.f6221a);
        this.d_renamed.b_renamed(b_renamed());
        this.e_renamed.sendEmptyMessageDelayed(1, this.f6222b);
    }
}
