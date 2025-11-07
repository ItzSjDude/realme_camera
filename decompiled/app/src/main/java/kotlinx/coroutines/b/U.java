package kotlinx.coroutines.b_renamed;

/* compiled from: WorkQueue.kt */
/* loaded from: classes2.dex */
public final class n_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater f7832b = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.b_renamed.n_renamed.class, java.lang.Object.class, "lastScheduledTask");

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater f7833c = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.b_renamed.n_renamed.class, "producerIndex");
    private static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater d_renamed = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.b_renamed.n_renamed.class, "consumerIndex");
    private static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater e_renamed = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.b_renamed.n_renamed.class, "blockingTasksInBuffer");

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.b_renamed.i_renamed> f7834a = new java.util.concurrent.atomic.AtomicReferenceArray<>(128);
    private volatile java.lang.Object lastScheduledTask = null;
    private volatile int producerIndex = 0;
    private volatile int consumerIndex = 0;
    private volatile int blockingTasksInBuffer = 0;

    public final int a_renamed() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int b_renamed() {
        return this.lastScheduledTask != null ? a_renamed() + 1 : a_renamed();
    }

    public final kotlinx.coroutines.b_renamed.i_renamed c_renamed() {
        kotlinx.coroutines.b_renamed.i_renamed iVar = (kotlinx.coroutines.b_renamed.i_renamed) f7832b.getAndSet(this, null);
        return iVar != null ? iVar : d_renamed();
    }

    public static /* synthetic */ kotlinx.coroutines.b_renamed.i_renamed a_renamed(kotlinx.coroutines.b_renamed.n_renamed nVar, kotlinx.coroutines.b_renamed.i_renamed iVar, boolean z_renamed, int i_renamed, java.lang.Object obj) {
        if ((i_renamed & 2) != 0) {
            z_renamed = false;
        }
        return nVar.a_renamed(iVar, z_renamed);
    }

    public final kotlinx.coroutines.b_renamed.i_renamed a_renamed(kotlinx.coroutines.b_renamed.i_renamed iVar, boolean z_renamed) {
        if (z_renamed) {
            return a_renamed(iVar);
        }
        kotlinx.coroutines.b_renamed.i_renamed iVar2 = (kotlinx.coroutines.b_renamed.i_renamed) f7832b.getAndSet(this, iVar);
        if (iVar2 != null) {
            return a_renamed(iVar2);
        }
        return null;
    }

    public final long a_renamed(kotlinx.coroutines.b_renamed.n_renamed nVar) {
        if (kotlinx.coroutines.ac_renamed.a_renamed()) {
            if (!(a_renamed() == 0)) {
                throw new java.lang.AssertionError();
            }
        }
        kotlinx.coroutines.b_renamed.i_renamed iVarD = nVar.d_renamed();
        if (iVarD != null) {
            kotlinx.coroutines.b_renamed.i_renamed iVarA = a_renamed(this, iVarD, false, 2, null);
            if (!kotlinx.coroutines.ac_renamed.a_renamed()) {
                return -1L;
            }
            if (iVarA == null) {
                return -1L;
            }
            throw new java.lang.AssertionError();
        }
        return a_renamed(nVar, false);
    }

    public final long b_renamed(kotlinx.coroutines.b_renamed.n_renamed nVar) {
        if (kotlinx.coroutines.ac_renamed.a_renamed()) {
            if (!(a_renamed() == 0)) {
                throw new java.lang.AssertionError();
            }
        }
        int i_renamed = nVar.producerIndex;
        java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.b_renamed.i_renamed> atomicReferenceArray = nVar.f7834a;
        for (int i2 = nVar.consumerIndex; i2 != i_renamed; i2++) {
            int i3 = i2 & 127;
            if (nVar.blockingTasksInBuffer == 0) {
                break;
            }
            kotlinx.coroutines.b_renamed.i_renamed iVar = atomicReferenceArray.get(i3);
            if (iVar != null) {
                if ((iVar.g_renamed.b_renamed() == 1) && atomicReferenceArray.compareAndSet(i3, iVar, null)) {
                    e_renamed.decrementAndGet(nVar);
                    a_renamed(this, iVar, false, 2, null);
                    return -1L;
                }
            }
        }
        return a_renamed(nVar, true);
    }

    public final void a_renamed(kotlinx.coroutines.b_renamed.e_renamed eVar) {
        kotlinx.coroutines.b_renamed.i_renamed iVar = (kotlinx.coroutines.b_renamed.i_renamed) f7832b.getAndSet(this, null);
        if (iVar != null) {
            eVar.a_renamed(iVar);
        }
        while (b_renamed(eVar)) {
        }
    }

    private final long a_renamed(kotlinx.coroutines.b_renamed.n_renamed nVar, boolean z_renamed) {
        kotlinx.coroutines.b_renamed.i_renamed iVar;
        do {
            iVar = (kotlinx.coroutines.b_renamed.i_renamed) nVar.lastScheduledTask;
            if (iVar == null) {
                return -2L;
            }
            if (z_renamed) {
                if (!(iVar.g_renamed.b_renamed() == 1)) {
                    return -2L;
                }
            }
            long jA = kotlinx.coroutines.b_renamed.l_renamed.f_renamed.a_renamed() - iVar.f_renamed;
            if (jA < kotlinx.coroutines.b_renamed.l_renamed.f7829a) {
                return kotlinx.coroutines.b_renamed.l_renamed.f7829a - jA;
            }
        } while (!f7832b.compareAndSet(nVar, iVar, null));
        a_renamed(this, iVar, false, 2, null);
        return -1L;
    }

    private final boolean b_renamed(kotlinx.coroutines.b_renamed.e_renamed eVar) {
        kotlinx.coroutines.b_renamed.i_renamed iVarD = d_renamed();
        if (iVarD == null) {
            return false;
        }
        eVar.a_renamed(iVarD);
        return true;
    }

    private final kotlinx.coroutines.b_renamed.i_renamed d_renamed() {
        kotlinx.coroutines.b_renamed.i_renamed andSet;
        while (true) {
            int i_renamed = this.consumerIndex;
            if (i_renamed - this.producerIndex == 0) {
                return null;
            }
            int i2 = i_renamed & 127;
            if (d_renamed.compareAndSet(this, i_renamed, i_renamed + 1) && (andSet = this.f7834a.getAndSet(i2, null)) != null) {
                b_renamed(andSet);
                return andSet;
            }
        }
    }

    private final kotlinx.coroutines.b_renamed.i_renamed a_renamed(kotlinx.coroutines.b_renamed.i_renamed iVar) {
        if (iVar.g_renamed.b_renamed() == 1) {
            e_renamed.incrementAndGet(this);
        }
        if (a_renamed() == 127) {
            return iVar;
        }
        int i_renamed = this.producerIndex & 127;
        while (this.f7834a.get(i_renamed) != null) {
            java.lang.Thread.yield();
        }
        this.f7834a.lazySet(i_renamed, iVar);
        f7833c.incrementAndGet(this);
        return null;
    }

    private final void b_renamed(kotlinx.coroutines.b_renamed.i_renamed iVar) {
        if (iVar != null) {
            if (iVar.g_renamed.b_renamed() == 1) {
                int iDecrementAndGet = e_renamed.decrementAndGet(this);
                if (kotlinx.coroutines.ac_renamed.a_renamed()) {
                    if (!(iDecrementAndGet >= 0)) {
                        throw new java.lang.AssertionError();
                    }
                }
            }
        }
    }
}
