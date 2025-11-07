package com.oplus.statistics.e_renamed;

/* compiled from: WorkThread.java */
/* loaded from: classes2.dex */
public class c_renamed extends android.os.HandlerThread {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.List<java.lang.Runnable> f7731a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.util.SparseArray<com.oplus.statistics.e_renamed.c_renamed.a_renamed> f7732b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.os.Handler f7733c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String b_renamed() {
        return "onLooperPrepared, but looper is_renamed null";
    }

    private c_renamed() {
        super("OplusTrack-thread");
        this.f7731a = new java.util.ArrayList();
        this.f7732b = new android.util.SparseArray<>();
        start();
    }

    public static com.oplus.statistics.e_renamed.c_renamed a_renamed() {
        return com.oplus.statistics.e_renamed.c_renamed.b_renamed.f7736a;
    }

    public static void a_renamed(java.lang.Runnable runnable) {
        a_renamed().b_renamed(runnable);
    }

    public synchronized void a_renamed(int i_renamed, java.lang.Runnable runnable, long j_renamed) {
        if (this.f7733c != null) {
            this.f7733c.postDelayed(runnable, j_renamed);
        } else {
            this.f7732b.put(i_renamed, new com.oplus.statistics.e_renamed.c_renamed.a_renamed(runnable, j_renamed));
        }
    }

    public synchronized void b_renamed(java.lang.Runnable runnable) {
        if (this.f7733c != null) {
            this.f7733c.post(runnable);
        } else {
            this.f7731a.add(runnable);
        }
    }

    public synchronized boolean a_renamed(int i_renamed) {
        if (this.f7733c != null) {
            return this.f7733c.hasMessages(i_renamed);
        }
        return this.f7732b.get(i_renamed) != null;
    }

    public synchronized void b_renamed(int i_renamed) {
        if (this.f7733c != null) {
            this.f7733c.removeMessages(i_renamed);
        } else {
            this.f7732b.remove(i_renamed);
        }
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        android.os.Looper looper = getLooper();
        if (looper == null) {
            com.oplus.statistics.f_renamed.d_renamed.a_renamed("WorkThread", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.e_renamed.-$$Lambda$c_renamed$Pi6FhTEOuWLeQ73TKA6FMa-c_renamed-vs
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.e_renamed.c_renamed.b_renamed();
                }
            });
            return;
        }
        synchronized (this) {
            this.f7733c = new android.os.Handler(looper);
            java.util.Iterator<java.lang.Runnable> it = this.f7731a.iterator();
            while (it.hasNext()) {
                this.f7733c.post(it.next());
            }
            this.f7731a.clear();
            for (int i_renamed = 0; i_renamed < this.f7732b.size(); i_renamed++) {
                com.oplus.statistics.e_renamed.c_renamed.a_renamed aVarValueAt = this.f7732b.valueAt(i_renamed);
                this.f7733c.postDelayed(aVarValueAt.f7734a, aVarValueAt.f7735b);
            }
            this.f7732b.clear();
        }
    }

    /* compiled from: WorkThread.java */
    private static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final com.oplus.statistics.e_renamed.c_renamed f7736a = new com.oplus.statistics.e_renamed.c_renamed();
    }

    /* compiled from: WorkThread.java */
    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.Runnable f7734a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final long f7735b;

        public a_renamed(java.lang.Runnable runnable, long j_renamed) {
            this.f7734a = runnable;
            this.f7735b = j_renamed;
        }
    }
}
