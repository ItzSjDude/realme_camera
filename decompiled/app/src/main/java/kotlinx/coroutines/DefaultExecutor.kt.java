package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import p061c.p074h.C0987d;

/* compiled from: DefaultExecutor.kt */
/* renamed from: kotlinx.coroutines.ae */
/* loaded from: classes2.dex */
public final class DefaultExecutor.kt extends EventLoop.common.kt_2 implements Runnable {
    private static volatile Thread _thread;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final DefaultExecutor.kt f24556b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final long f24557d;
    private static volatile int debugStatus;

    static {
        Long OplusGLSurfaceView_14;
        DefaultExecutor.kt runnableC3858ae = new DefaultExecutor.kt();
        f24556b = runnableC3858ae;
        EventLoop.common.kt.m25607a(runnableC3858ae, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            OplusGLSurfaceView_14 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            OplusGLSurfaceView_14 = 1000L;
        }
        f24557d = timeUnit.toNanos(OplusGLSurfaceView_14.longValue());
    }

    private DefaultExecutor.kt() {
    }

    @Override // kotlinx.coroutines.EventLoop.kt_2
    /* renamed from: PlatformImplementations.kt_3 */
    protected Thread mo25585a() {
        Thread thread = _thread;
        return thread != null ? thread : m25582l();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private final boolean m25581k() {
        int OplusGLSurfaceView_13 = debugStatus;
        return OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zC;
        EventLoop.common.kt_5.f24668a.m25796a(this);
        TimeSource.kt interfaceC3911bnM25806a = TimeSource.kt_2.m25806a();
        if (interfaceC3911bnM25806a != null) {
            interfaceC3911bnM25806a.m25804d();
        }
        try {
            if (!m25583m()) {
                if (zC) {
                    return;
                } else {
                    return;
                }
            }
            long OplusGLSurfaceView_15 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jB = mo25611b();
                if (jB == Long.MAX_VALUE) {
                    TimeSource.kt interfaceC3911bnM25806a2 = TimeSource.kt_2.m25806a();
                    long jM25798a = interfaceC3911bnM25806a2 != null ? interfaceC3911bnM25806a2.m25798a() : System.nanoTime();
                    if (OplusGLSurfaceView_15 == Long.MAX_VALUE) {
                        OplusGLSurfaceView_15 = f24557d + jM25798a;
                    }
                    long j2 = OplusGLSurfaceView_15 - jM25798a;
                    if (j2 <= 0) {
                        _thread = (Thread) null;
                        m25584n();
                        TimeSource.kt interfaceC3911bnM25806a3 = TimeSource.kt_2.m25806a();
                        if (interfaceC3911bnM25806a3 != null) {
                            interfaceC3911bnM25806a3.m25805e();
                        }
                        if (mo25613c()) {
                            return;
                        }
                        mo25585a();
                        return;
                    }
                    jB = C0987d.m5337b(jB, j2);
                } else {
                    OplusGLSurfaceView_15 = Long.MAX_VALUE;
                }
                if (jB > 0) {
                    if (m25581k()) {
                        _thread = (Thread) null;
                        m25584n();
                        TimeSource.kt interfaceC3911bnM25806a4 = TimeSource.kt_2.m25806a();
                        if (interfaceC3911bnM25806a4 != null) {
                            interfaceC3911bnM25806a4.m25805e();
                        }
                        if (mo25613c()) {
                            return;
                        }
                        mo25585a();
                        return;
                    }
                    TimeSource.kt interfaceC3911bnM25806a5 = TimeSource.kt_2.m25806a();
                    if (interfaceC3911bnM25806a5 != null) {
                        interfaceC3911bnM25806a5.m25800a(this, jB);
                    } else {
                        LockSupport.parkNanos(this, jB);
                    }
                }
            }
        } finally {
            _thread = (Thread) null;
            m25584n();
            TimeSource.kt interfaceC3911bnM25806a6 = TimeSource.kt_2.m25806a();
            if (interfaceC3911bnM25806a6 != null) {
                interfaceC3911bnM25806a6.m25805e();
            }
            if (!mo25613c()) {
                mo25585a();
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private final synchronized Thread m25582l() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private final synchronized boolean m25583m() {
        if (m25581k()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private final synchronized void m25584n() {
        if (m25581k()) {
            debugStatus = 3;
            m25631i();
            notifyAll();
        }
    }
}
