package com.oplus.camera.p172ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.oplus.camera.CameraLog;

/* compiled from: CountDownTimer.java */
/* renamed from: com.oplus.camera.ui.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class CountDownTimer {

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected CameraUIInterface f18671d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected Handler f18672e;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PlatformImplementations.kt_3 f18674g;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f18673f = false;

    /* renamed from: PlatformImplementations.kt_3 */
    protected long f18668a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected long f18669b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected long f18670c = 0;

    /* compiled from: CountDownTimer.java */
    /* renamed from: com.oplus.camera.ui.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo12533a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo12534a(boolean z);
    }

    public CountDownTimer(CameraUIInterface cameraUIInterface, PlatformImplementations.kt_3 aVar) {
        this.f18671d = null;
        this.f18672e = null;
        this.f18674g = null;
        this.f18671d = cameraUIInterface;
        this.f18674g = aVar;
        this.f18672e = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.COUIBaseListPopupWindow_11.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int OplusGLSurfaceView_13 = message.what;
                if (OplusGLSurfaceView_13 == 2) {
                    CountDownTimer.this.f18674g.mo12533a();
                    return;
                }
                if (OplusGLSurfaceView_13 == 3) {
                    CountDownTimer.this.f18674g.mo12534a(false);
                    CountDownTimer.this.f18673f = false;
                } else {
                    if (OplusGLSurfaceView_13 != 4) {
                        return;
                    }
                    CountDownTimer.this.f18674g.mo12534a(true);
                    CountDownTimer.this.f18673f = false;
                }
            }
        };
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20092a() {
        this.f18673f = false;
        this.f18672e.removeMessages(2);
        this.f18672e.sendEmptyMessage(4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20093a(long OplusGLSurfaceView_15) {
        this.f18670c = OplusGLSurfaceView_15;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public long m20094b() {
        return this.f18670c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20095c() {
        this.f18668a = SystemClock.uptimeMillis();
        this.f18673f = true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m20096d() {
        return this.f18673f;
    }

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
        if (this.f18669b >= 1000) {
            CameraLog.m12954a("CountDownUI", "updateCountdownTime, currentTime: " + j2 + ", delta: " + OplusGLSurfaceView_15 + ", mCountDownTemp: " + this.f18669b);
            long j3 = this.f18669b - 1000;
            this.f18670c = this.f18670c + j3;
            this.f18669b = 0L;
            this.f18671d.mo18082a(j3 + j2, false);
        }
        if (j2 > 0) {
            this.f18672e.sendEmptyMessageDelayed(2, 100L);
        } else {
            this.f18672e.sendEmptyMessage(3);
        }
    }
}
