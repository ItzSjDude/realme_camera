package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.EventLoop.common.kt_2;

/* compiled from: EventLoop.kt */
/* renamed from: kotlinx.coroutines.ao */
/* loaded from: classes2.dex */
public abstract class EventLoop.kt_2 extends EventLoop.common.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract Thread mo25585a();

    /* renamed from: OplusGLSurfaceView_15 */
    protected final void m25644j() {
        Thread threadMo25585a = mo25585a();
        if (Thread.currentThread() != threadMo25585a) {
            TimeSource.kt interfaceC3911bnM25806a = TimeSource.kt_2.m25806a();
            if (interfaceC3911bnM25806a != null) {
                interfaceC3911bnM25806a.m25801a(threadMo25585a);
            } else {
                LockSupport.unpark(threadMo25585a);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected final void m25643b(long OplusGLSurfaceView_15, EventLoop.common.kt_2.PlatformImplementations.kt_3 aVar) {
        if (Debug.kt.m25574a()) {
            if (!(this != DefaultExecutor.kt.f24556b)) {
                throw new AssertionError();
            }
        }
        DefaultExecutor.kt.f24556b.m25628a(OplusGLSurfaceView_15, aVar);
    }
}
