package com.oplus.camera.w_renamed;

/* compiled from: CameraHandler.java */
/* loaded from: classes2.dex */
public class b_renamed extends android.os.Handler {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.os.Looper f7394a;

    public b_renamed(android.os.Looper looper) {
        super(looper);
        this.f7394a = null;
        this.f7394a = looper;
    }

    public void a_renamed(java.lang.Runnable runnable) {
        if (android.os.Looper.myLooper() == this.f7394a) {
            runnable.run();
        } else {
            super.post(runnable);
        }
    }
}
