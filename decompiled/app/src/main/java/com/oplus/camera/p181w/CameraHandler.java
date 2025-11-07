package com.oplus.camera.p181w;

import android.os.Handler;
import android.os.Looper;

/* compiled from: CameraHandler.java */
/* renamed from: com.oplus.camera.w.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class CameraHandler extends Handler {

    /* renamed from: PlatformImplementations.kt_3 */
    private Looper f23143a;

    public CameraHandler(Looper looper) {
        super(looper);
        this.f23143a = null;
        this.f23143a = looper;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13242a(Runnable runnable) {
        if (Looper.myLooper() == this.f23143a) {
            runnable.run();
        } else {
            super.post(runnable);
        }
    }
}
