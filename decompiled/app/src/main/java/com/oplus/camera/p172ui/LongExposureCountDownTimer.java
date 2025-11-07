package com.oplus.camera.p172ui;

import android.os.SystemClock;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p172ui.CountDownTimer;

/* compiled from: LongExposureCountDownTimer.java */
/* renamed from: com.oplus.camera.ui.o */
/* loaded from: classes2.dex */
public class LongExposureCountDownTimer extends CountDownTimer {
    public LongExposureCountDownTimer(CameraUIInterface cameraUIInterface, CountDownTimer.PlatformImplementations.kt_3 aVar) {
        super(cameraUIInterface, aVar);
    }

    @Override // com.oplus.camera.p172ui.CountDownTimer
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo20097e() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long OplusGLSurfaceView_15 = jUptimeMillis - this.f18668a;
        this.f18670c -= OplusGLSurfaceView_15;
        this.f18669b += OplusGLSurfaceView_15;
        this.f18668a = jUptimeMillis;
        long j2 = this.f18670c;
        if (j2 < 0) {
            j2 = 0;
        }
        if (this.f18669b >= 100) {
            CameraLog.m12954a("LongExposureCountDownUI", "updateCountdownTime, currentTime: " + j2 + ", delta: " + OplusGLSurfaceView_15 + ", mCountDownTemp: " + this.f18669b);
            long j3 = this.f18669b - 100;
            this.f18670c = this.f18670c + j3;
            this.f18669b = 0L;
            this.f18671d.mo18168b(j3 + j2);
        }
        if (j2 > 0) {
            this.f18672e.sendEmptyMessageDelayed(2, 100L);
        } else {
            this.f18672e.sendEmptyMessage(3);
        }
    }
}
