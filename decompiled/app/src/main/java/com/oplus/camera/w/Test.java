package com.oplus.camera.w_renamed;

/* compiled from: CameraThreadExector.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int f7396a = java.lang.Runtime.getRuntime().availableProcessors();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final int f7397b = java.lang.Math.max(2, java.lang.Math.min(f7396a - 1, 4));

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final int f7398c = (f7396a * 2) + 1;
    private static volatile com.oplus.camera.w_renamed.d_renamed f_renamed;
    private com.oplus.camera.w_renamed.d_renamed.a_renamed d_renamed = new com.oplus.camera.w_renamed.d_renamed.a_renamed();
    private final java.util.concurrent.ThreadPoolExecutor e_renamed = new java.util.concurrent.ThreadPoolExecutor(f7397b, f7398c, 5, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), this.d_renamed);

    public static com.oplus.camera.w_renamed.d_renamed a_renamed() {
        if (f_renamed == null) {
            synchronized (com.oplus.camera.w_renamed.d_renamed.class) {
                if (f_renamed == null) {
                    f_renamed = new com.oplus.camera.w_renamed.d_renamed();
                }
            }
        }
        return f_renamed;
    }

    private d_renamed() {
        this.e_renamed.allowCoreThreadTimeOut(true);
    }

    public java.util.concurrent.ThreadPoolExecutor b_renamed() {
        return this.e_renamed;
    }

    public void a_renamed(java.lang.Runnable runnable, java.lang.String str) {
        this.d_renamed.a_renamed(str);
        this.e_renamed.execute(runnable);
    }

    public void c_renamed() {
        this.e_renamed.shutdown();
    }

    /* compiled from: CameraThreadExector.java */
    private class a_renamed implements java.util.concurrent.ThreadFactory {

        /* renamed from: a_renamed, reason: collision with root package name */
        java.lang.String f7399a;

        private a_renamed() {
            this.f7399a = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a_renamed(java.lang.String str) {
            com.oplus.camera.e_renamed.a_renamed("CameraThreadExector", "thread name: " + str);
            this.f7399a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            if (this.f7399a == null) {
                com.oplus.camera.e_renamed.f_renamed("CameraThreadExector", "thread name is_renamed null");
                this.f7399a = "CameraThreadExector";
            }
            java.lang.Thread thread = new java.lang.Thread(runnable, this.f7399a);
            thread.setPriority(5);
            return thread;
        }
    }
}
