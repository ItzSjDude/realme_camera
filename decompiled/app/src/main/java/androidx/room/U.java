package androidx.room;

/* compiled from: TransactionExecutor.java */
/* loaded from: classes.dex */
class n_renamed implements java.util.concurrent.Executor {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.concurrent.Executor f1641a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.ArrayDeque<java.lang.Runnable> f1642b = new java.util.ArrayDeque<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.Runnable f1643c;

    n_renamed(java.util.concurrent.Executor executor) {
        this.f1641a = executor;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final java.lang.Runnable runnable) {
        this.f1642b.offer(new java.lang.Runnable() { // from class: androidx.room.n_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } finally {
                    androidx.room.n_renamed.this.a_renamed();
                }
            }
        });
        if (this.f1643c == null) {
            a_renamed();
        }
    }

    synchronized void a_renamed() {
        java.lang.Runnable runnablePoll = this.f1642b.poll();
        this.f1643c = runnablePoll;
        if (runnablePoll != null) {
            this.f1641a.execute(this.f1643c);
        }
    }
}
