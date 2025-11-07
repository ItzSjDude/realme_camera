package com.oplus.camera.ui;

/* compiled from: NightCountDownUI.java */
/* loaded from: classes2.dex */
public class p_renamed extends com.oplus.camera.ui.h_renamed {
    private boolean g_renamed;

    public p_renamed(com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.h_renamed.a_renamed aVar) {
        super(cameraUIInterface, aVar);
        this.g_renamed = false;
    }

    @Override // com.oplus.camera.ui.h_renamed
    public void d_renamed() {
        super.d_renamed();
        this.g_renamed = true;
    }

    @Override // com.oplus.camera.ui.h_renamed
    public void a_renamed() {
        super.a_renamed();
        this.g_renamed = false;
    }

    @Override // com.oplus.camera.ui.h_renamed
    public void e_renamed() {
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        long j_renamed = jUptimeMillis - this.f6217a;
        this.f6219c -= j_renamed;
        this.f6217a = jUptimeMillis;
        long j2 = this.f6219c;
        if (j2 < 0) {
            j2 = 0;
        }
        com.oplus.camera.e_renamed.a_renamed("NightCountDownUI", "updateCountdownTime, currentTime: " + j2 + ", delta: " + j_renamed);
        if (this.g_renamed) {
            this.g_renamed = false;
            this.e_renamed.h_renamed((int) j2);
            com.oplus.camera.e_renamed.a_renamed("NightCountDownUI", "updateCountdownTime, setShutterButtonTime: " + j2);
        }
        this.e_renamed.a_renamed(j2);
        if (j2 > 0) {
            this.d_renamed = true;
            this.f_renamed.sendEmptyMessageDelayed(2, 100L);
        } else {
            this.f_renamed.sendEmptyMessage(3);
        }
    }
}
