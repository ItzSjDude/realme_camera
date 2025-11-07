package androidx.core.e_renamed;

/* compiled from: SelfDestructiveThread.java */
/* loaded from: classes.dex */
public class c_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.os.HandlerThread f875b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.os.Handler f876c;
    private final int f_renamed;
    private final int g_renamed;
    private final java.lang.String h_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Object f874a = new java.lang.Object();
    private android.os.Handler.Callback e_renamed = new android.os.Handler.Callback() { // from class: androidx.core.e_renamed.c_renamed.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i_renamed = message.what;
            if (i_renamed == 0) {
                androidx.core.e_renamed.c_renamed.this.a_renamed();
                return true;
            }
            if (i_renamed != 1) {
                return true;
            }
            androidx.core.e_renamed.c_renamed.this.a_renamed((java.lang.Runnable) message.obj);
            return true;
        }
    };
    private int d_renamed = 0;

    /* compiled from: SelfDestructiveThread.java */
    public interface a_renamed<T_renamed> {
        void a_renamed(T_renamed t_renamed);
    }

    public c_renamed(java.lang.String str, int i_renamed, int i2) {
        this.h_renamed = str;
        this.g_renamed = i_renamed;
        this.f_renamed = i2;
    }

    private void b_renamed(java.lang.Runnable runnable) {
        synchronized (this.f874a) {
            if (this.f875b == null) {
                this.f875b = new android.os.HandlerThread(this.h_renamed, this.g_renamed);
                this.f875b.start();
                this.f876c = new android.os.Handler(this.f875b.getLooper(), this.e_renamed);
                this.d_renamed++;
            }
            this.f876c.removeMessages(0);
            this.f876c.sendMessage(this.f876c.obtainMessage(1, runnable));
        }
    }

    public <T_renamed> void a_renamed(final java.util.concurrent.Callable<T_renamed> callable, final androidx.core.e_renamed.c_renamed.a_renamed<T_renamed> aVar) {
        final android.os.Handler handler = new android.os.Handler();
        b_renamed(new java.lang.Runnable() { // from class: androidx.core.e_renamed.c_renamed.2
            @Override // java.lang.Runnable
            public void run() throws java.lang.Exception {
                final java.lang.Object objCall;
                try {
                    objCall = callable.call();
                } catch (java.lang.Exception unused) {
                    objCall = null;
                }
                handler.post(new java.lang.Runnable() { // from class: androidx.core.e_renamed.c_renamed.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a_renamed(objCall);
                    }
                });
            }
        });
    }

    public <T_renamed> T_renamed a_renamed(final java.util.concurrent.Callable<T_renamed> callable, int i_renamed) throws java.lang.InterruptedException {
        final java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        final java.util.concurrent.locks.Condition conditionNewCondition = reentrantLock.newCondition();
        final java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
        final java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(true);
        b_renamed(new java.lang.Runnable() { // from class: androidx.core.e_renamed.c_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    atomicReference.set(callable.call());
                } catch (java.lang.Exception unused) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    conditionNewCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T_renamed) atomicReference.get();
            }
            long nanos = java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(i_renamed);
            do {
                try {
                    nanos = conditionNewCondition.awaitNanos(nanos);
                } catch (java.lang.InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T_renamed) atomicReference.get();
                }
            } while (nanos > 0);
            throw new java.lang.InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }

    void a_renamed(java.lang.Runnable runnable) {
        runnable.run();
        synchronized (this.f874a) {
            this.f876c.removeMessages(0);
            this.f876c.sendMessageDelayed(this.f876c.obtainMessage(0), this.f_renamed);
        }
    }

    void a_renamed() {
        synchronized (this.f874a) {
            if (this.f876c.hasMessages(1)) {
                return;
            }
            this.f875b.quit();
            this.f875b = null;
            this.f876c = null;
        }
    }
}
