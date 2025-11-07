package kotlinx.coroutines.b_renamed;

/* compiled from: Dispatcher.kt */
/* loaded from: classes2.dex */
final class f_renamed extends kotlinx.coroutines.ar_renamed implements java.util.concurrent.Executor, kotlinx.coroutines.b_renamed.j_renamed {
    private static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater e_renamed = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.b_renamed.f_renamed.class, "inFlightTasks");
    private final kotlinx.coroutines.b_renamed.d_renamed f_renamed;
    private final int g_renamed;
    private final java.lang.String h_renamed;
    private final int i_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> f7824b = new java.util.concurrent.ConcurrentLinkedQueue<>();
    private volatile int inFlightTasks = 0;

    @Override // kotlinx.coroutines.b_renamed.j_renamed
    public int b_renamed() {
        return this.i_renamed;
    }

    public f_renamed(kotlinx.coroutines.b_renamed.d_renamed dVar, int i_renamed, java.lang.String str, int i2) {
        this.f_renamed = dVar;
        this.g_renamed = i_renamed;
        this.h_renamed = str;
        this.i_renamed = i2;
    }

    @Override // java.util.concurrent.Executor
    public void execute(java.lang.Runnable runnable) {
        a_renamed(runnable, false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new java.lang.IllegalStateException("Close cannot be_renamed invoked on_renamed LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.t_renamed
    public void a_renamed(c_renamed.c_renamed.g_renamed gVar, java.lang.Runnable runnable) {
        a_renamed(runnable, false);
    }

    private final void a_renamed(java.lang.Runnable runnable, boolean z_renamed) {
        while (e_renamed.incrementAndGet(this) > this.g_renamed) {
            this.f7824b.add(runnable);
            if (e_renamed.decrementAndGet(this) >= this.g_renamed || (runnable = this.f7824b.poll()) == null) {
                return;
            }
        }
        this.f_renamed.a_renamed(runnable, this, z_renamed);
    }

    @Override // kotlinx.coroutines.t_renamed
    public java.lang.String toString() {
        java.lang.String str = this.h_renamed;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f_renamed + ']';
    }

    @Override // kotlinx.coroutines.b_renamed.j_renamed
    public void a_renamed() {
        java.lang.Runnable runnablePoll = this.f7824b.poll();
        if (runnablePoll != null) {
            this.f_renamed.a_renamed(runnablePoll, this, true);
            return;
        }
        e_renamed.decrementAndGet(this);
        java.lang.Runnable runnablePoll2 = this.f7824b.poll();
        if (runnablePoll2 != null) {
            a_renamed(runnablePoll2, true);
        }
    }
}
