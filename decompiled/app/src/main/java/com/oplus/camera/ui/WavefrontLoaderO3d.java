package com.oplus.camera.ui;

/* compiled from: LongExposureCountDownTimer.java */
/* loaded from: classes2.dex */
public class o_renamed extends com.oplus.camera.ui.g_renamed {
    public o_renamed(com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.g_renamed.a_renamed aVar) {
        super(cameraUIInterface, aVar);
    }

    @Override // com.oplus.camera.ui.g_renamed
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
        if (this.f6214b >= 100) {
            com.oplus.camera.e_renamed.a_renamed("LongExposureCountDownUI", "updateCountdownTime, currentTime: " + j2 + ", delta: " + j_renamed + ", mCountDownTemp: " + this.f6214b);
            long j3 = this.f6214b - 100;
            this.f6215c = this.f6215c + j3;
            this.f6214b = 0L;
            this.d_renamed.b_renamed(j3 + j2);
        }
        if (j2 > 0) {
            this.e_renamed.sendEmptyMessageDelayed(2, 100L);
        } else {
            this.e_renamed.sendEmptyMessage(3);
        }
    }
}
