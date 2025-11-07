package kotlinx.coroutines.p216b;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.Executors.kt;
import p061c.p064c.CoroutineContext.kt_4;

/* compiled from: Dispatcher.kt */
/* renamed from: kotlinx.coroutines.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
final class Dispatcher.kt_2 extends Executors.kt implements Executor, Tasks.kt_6 {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final AtomicIntegerFieldUpdater f24626e = AtomicIntegerFieldUpdater.newUpdater(Dispatcher.kt_2.class, "inFlightTasks");

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Dispatcher.kt f24628f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final int f24629g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final String f24630h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final int f24631i;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ConcurrentLinkedQueue<Runnable> f24627b = new ConcurrentLinkedQueue<>();
    private volatile int inFlightTasks = 0;

    @Override // kotlinx.coroutines.p216b.Tasks.kt_6
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo25704b() {
        return this.f24631i;
    }

    public Dispatcher.kt_2(Dispatcher.kt c3887d, int OplusGLSurfaceView_13, String str, int i2) {
        this.f24628f = c3887d;
        this.f24629g = OplusGLSurfaceView_13;
        this.f24630h = str;
        this.f24631i = i2;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        m25702a(runnable, false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25629a(CoroutineContext.kt_4 interfaceC0932g, Runnable runnable) {
        m25702a(runnable, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final void m25702a(Runnable runnable, boolean z) {
        while (f24626e.incrementAndGet(this) > this.f24629g) {
            this.f24627b.add(runnable);
            if (f24626e.decrementAndGet(this) >= this.f24629g || (runnable = this.f24627b.poll()) == null) {
                return;
            }
        }
        this.f24628f.m25701a(runnable, this, z);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    public String toString() {
        String str = this.f24630h;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f24628f + ']';
    }

    @Override // kotlinx.coroutines.p216b.Tasks.kt_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25703a() {
        Runnable runnablePoll = this.f24627b.poll();
        if (runnablePoll != null) {
            this.f24628f.m25701a(runnablePoll, this, true);
            return;
        }
        f24626e.decrementAndGet(this);
        Runnable runnablePoll2 = this.f24627b.poll();
        if (runnablePoll2 != null) {
            m25702a(runnablePoll2, true);
        }
    }
}
