package com.oplus.camera.p181w;

import android.os.HandlerThread;
import android.os.Process;
import com.oplus.camera.perf.CameraPerformance;

/* compiled from: CameraHandlerThread.java */
/* renamed from: com.oplus.camera.w.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class CameraHandlerThread extends HandlerThread {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f23144a;

    public CameraHandlerThread(String str) {
        super(str);
        this.f23144a = false;
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.f23144a) {
            CameraPerformance.m15186a("129", Process.myTid());
            this.f23144a = false;
        }
        super.run();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24694a() {
        this.f23144a = true;
    }
}
