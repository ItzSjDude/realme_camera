package com.oplus.camera.p172ui;

import android.os.SystemClock;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p172ui.CountDownUI;

/* compiled from: NightCountDownUI.java */
/* renamed from: com.oplus.camera.ui.p */
/* loaded from: classes2.dex */
public class NightCountDownUI extends CountDownUI {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f20667g;

    public NightCountDownUI(CameraUIInterface cameraUIInterface, CountDownUI.PlatformImplementations.kt_3 aVar) {
        super(cameraUIInterface, aVar);
        this.f20667g = false;
    }

    @Override // com.oplus.camera.p172ui.CountDownUI
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo20103d() {
        super.mo20103d();
        this.f20667g = true;
    }

    @Override // com.oplus.camera.p172ui.CountDownUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20099a() {
        super.mo20099a();
        this.f20667g = false;
    }

    @Override // com.oplus.camera.p172ui.CountDownUI
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo20104e() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long OplusGLSurfaceView_15 = jUptimeMillis - this.f18676a;
        this.f18678c -= OplusGLSurfaceView_15;
        this.f18676a = jUptimeMillis;
        long j2 = this.f18678c;
        if (j2 < 0) {
            j2 = 0;
        }
        CameraLog.m12954a("NightCountDownUI", "updateCountdownTime, currentTime: " + j2 + ", delta: " + OplusGLSurfaceView_15);
        if (this.f20667g) {
            this.f20667g = false;
            this.f18680e.mo18221h((int) j2);
            CameraLog.m12954a("NightCountDownUI", "updateCountdownTime, setShutterButtonTime: " + j2);
        }
        this.f18680e.mo18079a(j2);
        if (j2 > 0) {
            this.f18679d = true;
            this.f18681f.sendEmptyMessageDelayed(2, 100L);
        } else {
            this.f18681f.sendEmptyMessage(3);
        }
    }
}
