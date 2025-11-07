package com.oplus.camera.w_renamed;

/* compiled from: CameraHandlerThread.java */
/* loaded from: classes2.dex */
public class c_renamed extends android.os.HandlerThread {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f7395a;

    public c_renamed(java.lang.String str) {
        super(str);
        this.f7395a = false;
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.f7395a) {
            com.oplus.camera.perf.b_renamed.a_renamed("129", android.os.Process.myTid());
            this.f7395a = false;
        }
        super.run();
    }

    public void a_renamed() {
        this.f7395a = true;
    }
}
