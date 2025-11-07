package com.oplus.camera.p172ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.oplus.camera.CameraLog;

/* compiled from: CountDownUI.java */
/* renamed from: com.oplus.camera.ui.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class CountDownUI {

    /* renamed from: PlatformImplementations.kt_3 */
    protected long f18676a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected long f18677b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected long f18678c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected boolean f18679d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected CameraUIInterface f18680e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected Handler f18681f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PlatformImplementations.kt_3 f18682g;

    /* compiled from: CountDownUI.java */
    /* renamed from: com.oplus.camera.ui.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo12292a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo12293a(boolean z);
    }

    public CountDownUI(CameraUIInterface cameraUIInterface, PlatformImplementations.kt_3 aVar) {
        this.f18680e = null;
        this.f18681f = null;
        this.f18682g = null;
        this.f18680e = cameraUIInterface;
        this.f18682g = aVar;
        this.f18681f = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.COUIBaseListPopupWindow_10.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int OplusGLSurfaceView_13 = message.what;
                if (OplusGLSurfaceView_13 == 2) {
                    CountDownUI.this.f18682g.mo12292a();
                    return;
                }
                if (OplusGLSurfaceView_13 == 3) {
                    CountDownUI c3212h = CountDownUI.this;
                    c3212h.f18679d = false;
                    c3212h.f18682g.mo12293a(false);
                } else {
                    if (OplusGLSurfaceView_13 != 4) {
                        return;
                    }
                    CountDownUI c3212h2 = CountDownUI.this;
                    c3212h2.f18679d = false;
                    c3212h2.f18682g.mo12293a(true);
                }
            }
        };
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20099a() {
        this.f18678c = 0L;
        this.f18679d = false;
        this.f18681f.removeMessages(2);
        this.f18681f.sendEmptyMessage(4);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20101b() {
        this.f18678c = 0L;
        this.f18679d = false;
        if (this.f18681f.hasMessages(2)) {
            this.f18681f.removeMessages(2);
            this.f18681f.sendEmptyMessage(4);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20100a(long OplusGLSurfaceView_15) {
        this.f18678c = OplusGLSurfaceView_15;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public long m20102c() {
        return this.f18678c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo20103d() {
        this.f18676a = SystemClock.uptimeMillis();
        this.f18677b = 1000L;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo20104e() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long OplusGLSurfaceView_15 = jUptimeMillis - this.f18676a;
        this.f18678c -= OplusGLSurfaceView_15;
        this.f18677b += OplusGLSurfaceView_15;
        this.f18676a = jUptimeMillis;
        long j2 = this.f18678c;
        if (j2 < 0) {
            j2 = 0;
        }
        if (this.f18677b >= 1000) {
            CameraLog.m12954a("CountDownUI", "updateCountdownTime, currentTime: " + j2 + ", delta: " + OplusGLSurfaceView_15 + ", mCountDownTemp: " + this.f18677b);
            long j3 = this.f18677b - 1000;
            this.f18678c = this.f18678c + j3;
            this.f18677b = 0L;
            this.f18680e.mo18082a(j3 + j2, false);
        }
        if (j2 > 0) {
            this.f18679d = true;
            this.f18681f.sendEmptyMessageDelayed(2, 100L);
        } else {
            this.f18681f.sendEmptyMessage(3);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m20105f() {
        Handler handler = this.f18681f;
        if (handler != null) {
            if (handler.hasMessages(2)) {
                this.f18681f.removeMessages(2);
            }
            if (this.f18681f.hasMessages(3)) {
                this.f18681f.removeMessages(3);
            }
        }
        CameraUIInterface cameraUIInterface = this.f18680e;
        if (cameraUIInterface != null) {
            cameraUIInterface.mo18217g(true);
        }
        this.f18679d = false;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m20106g() {
        return this.f18679d;
    }
}
