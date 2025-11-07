package kotlinx.coroutines;

/* compiled from: DefaultExecutor.kt */
/* loaded from: classes2.dex */
public final class ae_renamed extends kotlinx.coroutines.an_renamed implements java.lang.Runnable {
    private static volatile java.lang.Thread _thread;

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.ae_renamed f7787b;
    private static final long d_renamed;
    private static volatile int debugStatus;

    static {
        java.lang.Long l_renamed;
        kotlinx.coroutines.ae_renamed aeVar = new kotlinx.coroutines.ae_renamed();
        f7787b = aeVar;
        kotlinx.coroutines.am_renamed.a_renamed(aeVar, false, 1, null);
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        try {
            l_renamed = java.lang.Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (java.lang.SecurityException unused) {
            l_renamed = 1000L;
        }
        d_renamed = timeUnit.toNanos(l_renamed.longValue());
    }

    private ae_renamed() {
    }

    @Override // kotlinx.coroutines.ao_renamed
    protected java.lang.Thread a_renamed() {
        java.lang.Thread thread = _thread;
        return thread != null ? thread : l_renamed();
    }

    private final boolean k_renamed() {
        int i_renamed = debugStatus;
        return i_renamed == 2 || i_renamed == 3;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zC;
        kotlinx.coroutines.bm_renamed.f7847a.a_renamed(this);
        kotlinx.coroutines.bn_renamed bnVarA = kotlinx.coroutines.bo_renamed.a_renamed();
        if (bnVarA != null) {
            bnVarA.d_renamed();
        }
        try {
            if (!m_renamed()) {
                if (zC) {
                    return;
                } else {
                    return;
                }
            }
            long j_renamed = Long.MAX_VALUE;
            while (true) {
                java.lang.Thread.interrupted();
                long jB = b_renamed();
                if (jB == Long.MAX_VALUE) {
                    kotlinx.coroutines.bn_renamed bnVarA2 = kotlinx.coroutines.bo_renamed.a_renamed();
                    long jA = bnVarA2 != null ? bnVarA2.a_renamed() : java.lang.System.nanoTime();
                    if (j_renamed == Long.MAX_VALUE) {
                        j_renamed = d_renamed + jA;
                    }
                    long j2 = j_renamed - jA;
                    if (j2 <= 0) {
                        _thread = (java.lang.Thread) null;
                        n_renamed();
                        kotlinx.coroutines.bn_renamed bnVarA3 = kotlinx.coroutines.bo_renamed.a_renamed();
                        if (bnVarA3 != null) {
                            bnVarA3.e_renamed();
                        }
                        if (c_renamed()) {
                            return;
                        }
                        a_renamed();
                        return;
                    }
                    jB = c_renamed.h_renamed.d_renamed.b_renamed(jB, j2);
                } else {
                    j_renamed = Long.MAX_VALUE;
                }
                if (jB > 0) {
                    if (k_renamed()) {
                        _thread = (java.lang.Thread) null;
                        n_renamed();
                        kotlinx.coroutines.bn_renamed bnVarA4 = kotlinx.coroutines.bo_renamed.a_renamed();
                        if (bnVarA4 != null) {
                            bnVarA4.e_renamed();
                        }
                        if (c_renamed()) {
                            return;
                        }
                        a_renamed();
                        return;
                    }
                    kotlinx.coroutines.bn_renamed bnVarA5 = kotlinx.coroutines.bo_renamed.a_renamed();
                    if (bnVarA5 != null) {
                        bnVarA5.a_renamed(this, jB);
                    } else {
                        java.util.concurrent.locks.LockSupport.parkNanos(this, jB);
                    }
                }
            }
        } finally {
            _thread = (java.lang.Thread) null;
            n_renamed();
            kotlinx.coroutines.bn_renamed bnVarA6 = kotlinx.coroutines.bo_renamed.a_renamed();
            if (bnVarA6 != null) {
                bnVarA6.e_renamed();
            }
            if (!c_renamed()) {
                a_renamed();
            }
        }
    }

    private final synchronized java.lang.Thread l_renamed() {
        java.lang.Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new java.lang.Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final synchronized boolean m_renamed() {
        if (k_renamed()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final synchronized void n_renamed() {
        if (k_renamed()) {
            debugStatus = 3;
            i_renamed();
            notifyAll();
        }
    }
}
