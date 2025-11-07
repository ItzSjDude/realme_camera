package com.oplus.camera.util;

/* compiled from: MultipleTaskUtils.java */
/* loaded from: classes2.dex */
public class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.util.i_renamed.b_renamed f7346a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.concurrent.ScheduledThreadPoolExecutor f7347b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.ScheduledFuture> f7348c;

    public static com.oplus.camera.util.i_renamed a_renamed() {
        return com.oplus.camera.util.i_renamed.a_renamed.f7349a;
    }

    private i_renamed() {
        this.f7346a = new com.oplus.camera.util.i_renamed.b_renamed();
        this.f7347b = null;
        this.f7348c = new java.util.concurrent.ConcurrentHashMap<>();
        this.f7347b = new java.util.concurrent.ScheduledThreadPoolExecutor(1, this.f7346a);
    }

    public void a_renamed(long j_renamed, java.lang.String str, java.lang.Runnable runnable) {
        this.f7346a.a_renamed(str);
        if (this.f7348c.containsKey(str)) {
            this.f7348c.get(str).cancel(true);
        }
        this.f7348c.put(str, this.f7347b.schedule(runnable, j_renamed, java.util.concurrent.TimeUnit.MILLISECONDS));
    }

    public void a_renamed(java.lang.String str) {
        if (this.f7348c.containsKey(str)) {
            this.f7348c.get(str).cancel(true);
        }
    }

    /* compiled from: MultipleTaskUtils.java */
    private static final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final com.oplus.camera.util.i_renamed f7349a = new com.oplus.camera.util.i_renamed();
    }

    /* compiled from: MultipleTaskUtils.java */
    private class b_renamed implements java.util.concurrent.ThreadFactory {

        /* renamed from: a_renamed, reason: collision with root package name */
        java.lang.String f7350a;

        private b_renamed() {
            this.f7350a = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a_renamed(java.lang.String str) {
            this.f7350a = str;
            com.oplus.camera.e_renamed.a_renamed("MultipleTaskUtils", "setName，name: " + str);
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            if (this.f7350a == null) {
                com.oplus.camera.e_renamed.f_renamed("MultipleTaskUtils", "newThread，mName is_renamed null");
                this.f7350a = "MultipleTaskUtils";
            }
            java.lang.Thread thread = new java.lang.Thread(runnable, this.f7350a);
            thread.setPriority(5);
            return thread;
        }
    }
}
