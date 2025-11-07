package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.LockFreeTaskQueue.kt_2;
import kotlinx.coroutines.internal.ThreadSafeHeap.kt_2;
import kotlinx.coroutines.internal.ThreadSafeHeap.kt;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p072b.Intrinsics;
import p061c.p074h.C0987d;

/* compiled from: EventLoop.common.kt */
/* renamed from: kotlinx.coroutines.an */
/* loaded from: classes2.dex */
public abstract class EventLoop.common.kt_2 extends EventLoop.kt_2 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final AtomicReferenceFieldUpdater f24575b = AtomicReferenceFieldUpdater.newUpdater(EventLoop.common.kt_2.class, Object.class, "_queue");

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final AtomicReferenceFieldUpdater f24576d = AtomicReferenceFieldUpdater.newUpdater(EventLoop.common.kt_2.class, Object.class, "_delayed");
    private volatile Object _queue = null;
    private volatile Object _delayed = null;
    private volatile int _isCompleted = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    /* renamed from: OplusGLSurfaceView_5 */
    public final boolean m25624k() {
        return this._isCompleted;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final void m25623c(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    @Override // kotlinx.coroutines.EventLoop.common.kt
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected boolean mo25613c() {
        boolean zM25870a = false;
        if (!m25617g()) {
            return false;
        }
        IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) this._delayed;
        if (bVar != null && !bVar.m25924b()) {
            return false;
        }
        Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        if (obj instanceof LockFreeTaskQueue.kt_2) {
            zM25870a = ((LockFreeTaskQueue.kt_2) obj).m25870a();
        } else if (obj == EventLoop.common.kt_6.f24587b) {
            return true;
        }
        return zM25870a;
    }

    @Override // kotlinx.coroutines.EventLoop.common.kt
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected long mo25614d() {
        PlatformImplementations.kt_3 aVarC;
        if (super.mo25614d() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof LockFreeTaskQueue.kt_2)) {
                return obj == EventLoop.common.kt_6.f24587b ? Long.MAX_VALUE : 0L;
            }
            if (!((LockFreeTaskQueue.kt_2) obj).m25870a()) {
                return 0L;
            }
        }
        IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) this._delayed;
        if (bVar == null || (aVarC = bVar.m25925c()) == null) {
            return Long.MAX_VALUE;
        }
        long OplusGLSurfaceView_15 = aVarC.f24577a;
        TimeSource.kt interfaceC3911bnM25806a = TimeSource.kt_2.m25806a();
        return C0987d.m5334a(OplusGLSurfaceView_15 - (interfaceC3911bnM25806a != null ? interfaceC3911bnM25806a.m25798a() : System.nanoTime()), 0L);
    }

    @Override // kotlinx.coroutines.EventLoop.common.kt
    /* renamed from: COUIBaseListPopupWindow_10 */
    protected void mo25618h() {
        EventLoop.common.kt_5.f24668a.m25797b();
        m25623c(true);
        m25626m();
        while (mo25611b() <= 0) {
        }
        m25627n();
    }

    @Override // kotlinx.coroutines.EventLoop.common.kt
    /* renamed from: IntrinsicsJvm.kt_4 */
    public long mo25611b() {
        PlatformImplementations.kt_3 aVarM25921a;
        if (m25615e()) {
            return 0L;
        }
        IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) this._delayed;
        if (bVar != null && !bVar.m25924b()) {
            TimeSource.kt interfaceC3911bnM25806a = TimeSource.kt_2.m25806a();
            long jM25798a = interfaceC3911bnM25806a != null ? interfaceC3911bnM25806a.m25798a() : System.nanoTime();
            do {
                IntrinsicsJvm.kt_4 bVar2 = bVar;
                synchronized (bVar2) {
                    PlatformImplementations.kt_3 aVarM25927e = bVar2.m25927e();
                    if (aVarM25927e != null) {
                        PlatformImplementations.kt_3 aVar = aVarM25927e;
                        aVarM25921a = aVar.m25636a(jM25798a) ? m25621b(aVar) : false ? bVar2.m25921a(0) : null;
                    }
                }
            } while (aVarM25921a != null);
        }
        Runnable runnableM25625l = m25625l();
        if (runnableM25625l != null) {
            runnableM25625l.run();
            return 0L;
        }
        return mo25614d();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public final void mo25629a(CoroutineContext.kt_4 interfaceC0932g, Runnable runnable) {
        m25630a(runnable);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25630a(Runnable runnable) {
        if (m25621b(runnable)) {
            m25644j();
        } else {
            DefaultExecutor.kt.f24556b.m25630a(runnable);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private final void m25626m() {
        if (Debug.kt.m25574a() && !m25624k()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (f24575b.compareAndSet(this, null, EventLoop.common.kt_6.f24587b)) {
                    return;
                }
            } else if (!(obj instanceof LockFreeTaskQueue.kt_2)) {
                if (obj == EventLoop.common.kt_6.f24587b) {
                    return;
                }
                LockFreeTaskQueue.kt_2 c3933k = new LockFreeTaskQueue.kt_2(8, true);
                if (obj != null) {
                    c3933k.m25869a((LockFreeTaskQueue.kt_2) obj);
                    if (f24575b.compareAndSet(this, obj, c3933k)) {
                        return;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            } else {
                ((LockFreeTaskQueue.kt_2) obj).m25872c();
                return;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25628a(long OplusGLSurfaceView_15, PlatformImplementations.kt_3 aVar) {
        int iM25622c = m25622c(OplusGLSurfaceView_15, aVar);
        if (iM25622c == 0) {
            if (m25619a(aVar)) {
                m25644j();
            }
        } else if (iM25622c == 1) {
            m25643b(OplusGLSurfaceView_15, aVar);
        } else if (iM25622c != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final boolean m25619a(PlatformImplementations.kt_3 aVar) {
        IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) this._delayed;
        return (bVar != null ? bVar.m25925c() : null) == aVar;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int m25622c(long OplusGLSurfaceView_15, PlatformImplementations.kt_3 aVar) {
        if (m25624k()) {
            return 1;
        }
        IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) this._delayed;
        if (bVar == null) {
            EventLoop.common.kt_2 abstractC3867an = this;
            f24576d.compareAndSet(abstractC3867an, null, new IntrinsicsJvm.kt_4(OplusGLSurfaceView_15));
            Object obj = abstractC3867an._delayed;
            Intrinsics.m5296a(obj);
            bVar = (IntrinsicsJvm.kt_4) obj;
        }
        return aVar.m25632a(OplusGLSurfaceView_15, bVar, this);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    protected final void m25631i() {
        this._queue = null;
        this._delayed = null;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private final void m25627n() {
        PlatformImplementations.kt_3 aVarD;
        TimeSource.kt interfaceC3911bnM25806a = TimeSource.kt_2.m25806a();
        long jM25798a = interfaceC3911bnM25806a != null ? interfaceC3911bnM25806a.m25798a() : System.nanoTime();
        while (true) {
            IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) this._delayed;
            if (bVar == null || (aVarD = bVar.m25926d()) == null) {
                return;
            } else {
                m25643b(jM25798a, aVarD);
            }
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* renamed from: kotlinx.coroutines.an$PlatformImplementations.kt_3 */
    public static abstract class PlatformImplementations.kt_3 implements Comparable<PlatformImplementations.kt_3>, Runnable, Job.kt_4, ThreadSafeHeap.kt {

        /* renamed from: PlatformImplementations.kt_3 */
        public long f24577a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Object f24578b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f24579c;

        @Override // kotlinx.coroutines.internal.ThreadSafeHeap.kt
        /* renamed from: IntrinsicsJvm.kt_4 */
        public ThreadSafeHeap.kt_2<?> mo25637b() {
            Object obj = this.f24578b;
            if (!(obj instanceof ThreadSafeHeap.kt_2)) {
                obj = null;
            }
            return (ThreadSafeHeap.kt_2) obj;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeap.kt
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo25635a(ThreadSafeHeap.kt_2<?> c3945w) {
            if (!(this.f24578b != EventLoop.common.kt_6.f24586a)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.f24578b = c3945w;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeap.kt
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo25634a(int OplusGLSurfaceView_13) {
            this.f24579c = OplusGLSurfaceView_13;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeap.kt
        /* renamed from: IntrinsicsJvm.kt_3 */
        public int mo25638c() {
            return this.f24579c;
        }

        @Override // java.lang.Comparable
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public int compareTo(PlatformImplementations.kt_3 aVar) {
            long OplusGLSurfaceView_15 = this.f24577a - aVar.f24577a;
            if (OplusGLSurfaceView_15 > 0) {
                return 1;
            }
            return OplusGLSurfaceView_15 < 0 ? -1 : 0;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final boolean m25636a(long OplusGLSurfaceView_15) {
            return OplusGLSurfaceView_15 - this.f24577a >= 0;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final synchronized int m25632a(long OplusGLSurfaceView_15, IntrinsicsJvm.kt_4 bVar, EventLoop.common.kt_2 abstractC3867an) {
            if (this.f24578b == EventLoop.common.kt_6.f24586a) {
                return 2;
            }
            IntrinsicsJvm.kt_4 bVar2 = bVar;
            PlatformImplementations.kt_3 aVar = this;
            synchronized (bVar2) {
                PlatformImplementations.kt_3 aVarM25927e = bVar2.m25927e();
                if (abstractC3867an.m25624k()) {
                    return 1;
                }
                if (aVarM25927e == null) {
                    bVar.f24580a = OplusGLSurfaceView_15;
                } else {
                    long j2 = aVarM25927e.f24577a;
                    if (j2 - OplusGLSurfaceView_15 < 0) {
                        OplusGLSurfaceView_15 = j2;
                    }
                    if (OplusGLSurfaceView_15 - bVar.f24580a > 0) {
                        bVar.f24580a = OplusGLSurfaceView_15;
                    }
                }
                if (this.f24577a - bVar.f24580a < 0) {
                    this.f24577a = bVar.f24580a;
                }
                bVar2.m25923b((IntrinsicsJvm.kt_4) aVar);
                return 0;
            }
        }

        @Override // kotlinx.coroutines.Job.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public final synchronized void mo25604a() {
            Object obj = this.f24578b;
            if (obj == EventLoop.common.kt_6.f24586a) {
                return;
            }
            if (!(obj instanceof IntrinsicsJvm.kt_4)) {
                obj = null;
            }
            IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) obj;
            if (bVar != null) {
                bVar.m25922a((IntrinsicsJvm.kt_4) this);
            }
            this.f24578b = EventLoop.common.kt_6.f24586a;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f24577a + ']';
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* renamed from: kotlinx.coroutines.an$IntrinsicsJvm.kt_4 */
    public static final class IntrinsicsJvm.kt_4 extends ThreadSafeHeap.kt_2<PlatformImplementations.kt_3> {

        /* renamed from: PlatformImplementations.kt_3 */
        public long f24580a;

        public IntrinsicsJvm.kt_4(long OplusGLSurfaceView_15) {
            this.f24580a = OplusGLSurfaceView_15;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final boolean m25621b(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (m25624k()) {
                return false;
            }
            if (obj == null) {
                if (f24575b.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof LockFreeTaskQueue.kt_2) {
                if (obj != null) {
                    LockFreeTaskQueue.kt_2 c3933k = (LockFreeTaskQueue.kt_2) obj;
                    int iM25869a = c3933k.m25869a((LockFreeTaskQueue.kt_2) runnable);
                    if (iM25869a == 0) {
                        return true;
                    }
                    if (iM25869a == 1) {
                        f24575b.compareAndSet(this, obj, c3933k.m25874e());
                    } else if (iM25869a == 2) {
                        return false;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
            } else {
                if (obj == EventLoop.common.kt_6.f24587b) {
                    return false;
                }
                LockFreeTaskQueue.kt_2 c3933k2 = new LockFreeTaskQueue.kt_2(8, true);
                if (obj != null) {
                    c3933k2.m25869a((LockFreeTaskQueue.kt_2) obj);
                    c3933k2.m25869a((LockFreeTaskQueue.kt_2) runnable);
                    if (f24575b.compareAndSet(this, obj, c3933k2)) {
                        return true;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private final Runnable m25625l() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof LockFreeTaskQueue.kt_2) {
                if (obj != null) {
                    LockFreeTaskQueue.kt_2 c3933k = (LockFreeTaskQueue.kt_2) obj;
                    Object objM25873d = c3933k.m25873d();
                    if (objM25873d != LockFreeTaskQueue.kt_2.f24699a) {
                        return (Runnable) objM25873d;
                    }
                    f24575b.compareAndSet(this, obj, c3933k.m25874e());
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
            } else {
                if (obj == EventLoop.common.kt_6.f24587b) {
                    return null;
                }
                if (f24575b.compareAndSet(this, obj, null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }
}
