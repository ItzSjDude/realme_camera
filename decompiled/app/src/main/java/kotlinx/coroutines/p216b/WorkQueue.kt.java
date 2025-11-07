package kotlinx.coroutines.p216b;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.Debug.kt;

/* compiled from: WorkQueue.kt */
/* renamed from: kotlinx.coroutines.IntrinsicsJvm.kt_4.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
public final class WorkQueue.kt {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final AtomicReferenceFieldUpdater f24644b = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.kt.class, Object.class, "lastScheduledTask");

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final AtomicIntegerFieldUpdater f24645c = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.kt.class, "producerIndex");

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final AtomicIntegerFieldUpdater f24646d = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.kt.class, "consumerIndex");

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final AtomicIntegerFieldUpdater f24647e = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.kt.class, "blockingTasksInBuffer");

    /* renamed from: PlatformImplementations.kt_3 */
    private final AtomicReferenceArray<Tasks.kt_8> f24648a = new AtomicReferenceArray<>(128);
    private volatile Object lastScheduledTask = null;
    private volatile int producerIndex = 0;
    private volatile int consumerIndex = 0;
    private volatile int blockingTasksInBuffer = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    public final int m25712a() {
        return this.producerIndex - this.consumerIndex;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final int m25716b() {
        return this.lastScheduledTask != null ? m25712a() + 1 : m25712a();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final Tasks.kt_8 m25718c() {
        Tasks.kt_8 abstractRunnableC3892i = (Tasks.kt_8) f24644b.getAndSet(this, null);
        return abstractRunnableC3892i != null ? abstractRunnableC3892i : m25711d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ Tasks.kt_8 m25708a(WorkQueue.kt c3897n, Tasks.kt_8 abstractRunnableC3892i, boolean z, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            z = false;
        }
        return c3897n.m25714a(abstractRunnableC3892i, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final Tasks.kt_8 m25714a(Tasks.kt_8 abstractRunnableC3892i, boolean z) {
        if (z) {
            return m25707a(abstractRunnableC3892i);
        }
        Tasks.kt_8 abstractRunnableC3892i2 = (Tasks.kt_8) f24644b.getAndSet(this, abstractRunnableC3892i);
        if (abstractRunnableC3892i2 != null) {
            return m25707a(abstractRunnableC3892i2);
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final long m25713a(WorkQueue.kt c3897n) {
        if (Debug.kt.m25574a()) {
            if (!(m25712a() == 0)) {
                throw new AssertionError();
            }
        }
        Tasks.kt_8 abstractRunnableC3892iM25711d = c3897n.m25711d();
        if (abstractRunnableC3892iM25711d != null) {
            Tasks.kt_8 abstractRunnableC3892iM25708a = m25708a(this, abstractRunnableC3892iM25711d, false, 2, null);
            if (!Debug.kt.m25574a()) {
                return -1L;
            }
            if (abstractRunnableC3892iM25708a == null) {
                return -1L;
            }
            throw new AssertionError();
        }
        return m25706a(c3897n, false);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final long m25717b(WorkQueue.kt c3897n) {
        if (Debug.kt.m25574a()) {
            if (!(m25712a() == 0)) {
                throw new AssertionError();
            }
        }
        int OplusGLSurfaceView_13 = c3897n.producerIndex;
        AtomicReferenceArray<Tasks.kt_8> atomicReferenceArray = c3897n.f24648a;
        for (int i2 = c3897n.consumerIndex; i2 != OplusGLSurfaceView_13; i2++) {
            int i3 = i2 & 127;
            if (c3897n.blockingTasksInBuffer == 0) {
                break;
            }
            Tasks.kt_8 abstractRunnableC3892i = atomicReferenceArray.get(i3);
            if (abstractRunnableC3892i != null) {
                if ((abstractRunnableC3892i.f24636g.mo25704b() == 1) && atomicReferenceArray.compareAndSet(i3, abstractRunnableC3892i, null)) {
                    f24647e.decrementAndGet(c3897n);
                    m25708a(this, abstractRunnableC3892i, false, 2, null);
                    return -1L;
                }
            }
        }
        return m25706a(c3897n, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25715a(Tasks.kt_5 c3888e) {
        Tasks.kt_8 abstractRunnableC3892i = (Tasks.kt_8) f24644b.getAndSet(this, null);
        if (abstractRunnableC3892i != null) {
            c3888e.m25861a(abstractRunnableC3892i);
        }
        while (m25710b(c3888e)) {
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final long m25706a(WorkQueue.kt c3897n, boolean z) {
        Tasks.kt_8 abstractRunnableC3892i;
        do {
            abstractRunnableC3892i = (Tasks.kt_8) c3897n.lastScheduledTask;
            if (abstractRunnableC3892i == null) {
                return -2L;
            }
            if (z) {
                if (!(abstractRunnableC3892i.f24636g.mo25704b() == 1)) {
                    return -2L;
                }
            }
            long jMo25705a = Tasks.kt_4.f24643f.mo25705a() - abstractRunnableC3892i.f24635f;
            if (jMo25705a < Tasks.kt_4.f24638a) {
                return Tasks.kt_4.f24638a - jMo25705a;
            }
        } while (!f24644b.compareAndSet(c3897n, abstractRunnableC3892i, null));
        m25708a(this, abstractRunnableC3892i, false, 2, null);
        return -1L;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final boolean m25710b(Tasks.kt_5 c3888e) {
        Tasks.kt_8 abstractRunnableC3892iM25711d = m25711d();
        if (abstractRunnableC3892iM25711d == null) {
            return false;
        }
        c3888e.m25861a(abstractRunnableC3892iM25711d);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Tasks.kt_8 m25711d() {
        Tasks.kt_8 andSet;
        while (true) {
            int OplusGLSurfaceView_13 = this.consumerIndex;
            if (OplusGLSurfaceView_13 - this.producerIndex == 0) {
                return null;
            }
            int i2 = OplusGLSurfaceView_13 & 127;
            if (f24646d.compareAndSet(this, OplusGLSurfaceView_13, OplusGLSurfaceView_13 + 1) && (andSet = this.f24648a.getAndSet(i2, null)) != null) {
                m25709b(andSet);
                return andSet;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final Tasks.kt_8 m25707a(Tasks.kt_8 abstractRunnableC3892i) {
        if (abstractRunnableC3892i.f24636g.mo25704b() == 1) {
            f24647e.incrementAndGet(this);
        }
        if (m25712a() == 127) {
            return abstractRunnableC3892i;
        }
        int OplusGLSurfaceView_13 = this.producerIndex & 127;
        while (this.f24648a.get(OplusGLSurfaceView_13) != null) {
            Thread.yield();
        }
        this.f24648a.lazySet(OplusGLSurfaceView_13, abstractRunnableC3892i);
        f24645c.incrementAndGet(this);
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final void m25709b(Tasks.kt_8 abstractRunnableC3892i) {
        if (abstractRunnableC3892i != null) {
            if (abstractRunnableC3892i.f24636g.mo25704b() == 1) {
                int iDecrementAndGet = f24647e.decrementAndGet(this);
                if (Debug.kt.m25574a()) {
                    if (!(iDecrementAndGet >= 0)) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }
}
