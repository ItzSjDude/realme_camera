package kotlinx.coroutines;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes2.dex */
public abstract class an_renamed extends kotlinx.coroutines.ao_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater f7798b = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.an_renamed.class, java.lang.Object.class, "_queue");
    private static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater d_renamed = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.an_renamed.class, java.lang.Object.class, "_delayed");
    private volatile java.lang.Object _queue = null;
    private volatile java.lang.Object _delayed = null;
    private volatile int _isCompleted = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public final boolean k_renamed() {
        return this._isCompleted;
    }

    private final void c_renamed(boolean z_renamed) {
        this._isCompleted = z_renamed ? 1 : 0;
    }

    @Override // kotlinx.coroutines.am_renamed
    protected boolean c_renamed() {
        boolean zA = false;
        if (!g_renamed()) {
            return false;
        }
        kotlinx.coroutines.an_renamed.b_renamed bVar = (kotlinx.coroutines.an_renamed.b_renamed) this._delayed;
        if (bVar != null && !bVar.b_renamed()) {
            return false;
        }
        java.lang.Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        if (obj instanceof kotlinx.coroutines.internal.k_renamed) {
            zA = ((kotlinx.coroutines.internal.k_renamed) obj).a_renamed();
        } else if (obj == kotlinx.coroutines.aq_renamed.f7806b) {
            return true;
        }
        return zA;
    }

    @Override // kotlinx.coroutines.am_renamed
    protected long d_renamed() {
        kotlinx.coroutines.an_renamed.a_renamed aVarC;
        if (super.d_renamed() == 0) {
            return 0L;
        }
        java.lang.Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.k_renamed)) {
                return obj == kotlinx.coroutines.aq_renamed.f7806b ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.k_renamed) obj).a_renamed()) {
                return 0L;
            }
        }
        kotlinx.coroutines.an_renamed.b_renamed bVar = (kotlinx.coroutines.an_renamed.b_renamed) this._delayed;
        if (bVar == null || (aVarC = bVar.c_renamed()) == null) {
            return Long.MAX_VALUE;
        }
        long j_renamed = aVarC.f7799a;
        kotlinx.coroutines.bn_renamed bnVarA = kotlinx.coroutines.bo_renamed.a_renamed();
        return c_renamed.h_renamed.d_renamed.a_renamed(j_renamed - (bnVarA != null ? bnVarA.a_renamed() : java.lang.System.nanoTime()), 0L);
    }

    @Override // kotlinx.coroutines.am_renamed
    protected void h_renamed() {
        kotlinx.coroutines.bm_renamed.f7847a.b_renamed();
        c_renamed(true);
        m_renamed();
        while (b_renamed() <= 0) {
        }
        n_renamed();
    }

    @Override // kotlinx.coroutines.am_renamed
    public long b_renamed() {
        kotlinx.coroutines.an_renamed.a_renamed aVarA;
        if (e_renamed()) {
            return 0L;
        }
        kotlinx.coroutines.an_renamed.b_renamed bVar = (kotlinx.coroutines.an_renamed.b_renamed) this._delayed;
        if (bVar != null && !bVar.b_renamed()) {
            kotlinx.coroutines.bn_renamed bnVarA = kotlinx.coroutines.bo_renamed.a_renamed();
            long jA = bnVarA != null ? bnVarA.a_renamed() : java.lang.System.nanoTime();
            do {
                kotlinx.coroutines.an_renamed.b_renamed bVar2 = bVar;
                synchronized (bVar2) {
                    kotlinx.coroutines.an_renamed.a_renamed aVarE = bVar2.e_renamed();
                    if (aVarE != null) {
                        kotlinx.coroutines.an_renamed.a_renamed aVar = aVarE;
                        aVarA = aVar.a_renamed(jA) ? b_renamed(aVar) : false ? bVar2.a_renamed(0) : null;
                    }
                }
            } while (aVarA != null);
        }
        java.lang.Runnable runnableL = l_renamed();
        if (runnableL != null) {
            runnableL.run();
            return 0L;
        }
        return d_renamed();
    }

    @Override // kotlinx.coroutines.t_renamed
    public final void a_renamed(c_renamed.c_renamed.g_renamed gVar, java.lang.Runnable runnable) {
        a_renamed(runnable);
    }

    public final void a_renamed(java.lang.Runnable runnable) {
        if (b_renamed(runnable)) {
            j_renamed();
        } else {
            kotlinx.coroutines.ae_renamed.f7787b.a_renamed(runnable);
        }
    }

    private final void m_renamed() {
        if (kotlinx.coroutines.ac_renamed.a_renamed() && !k_renamed()) {
            throw new java.lang.AssertionError();
        }
        while (true) {
            java.lang.Object obj = this._queue;
            if (obj == null) {
                if (f7798b.compareAndSet(this, null, kotlinx.coroutines.aq_renamed.f7806b)) {
                    return;
                }
            } else if (!(obj instanceof kotlinx.coroutines.internal.k_renamed)) {
                if (obj == kotlinx.coroutines.aq_renamed.f7806b) {
                    return;
                }
                kotlinx.coroutines.internal.k_renamed kVar = new kotlinx.coroutines.internal.k_renamed(8, true);
                if (obj != null) {
                    kVar.a_renamed((kotlinx.coroutines.internal.k_renamed) obj);
                    if (f7798b.compareAndSet(this, obj, kVar)) {
                        return;
                    }
                } else {
                    throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            } else {
                ((kotlinx.coroutines.internal.k_renamed) obj).c_renamed();
                return;
            }
        }
    }

    public final void a_renamed(long j_renamed, kotlinx.coroutines.an_renamed.a_renamed aVar) {
        int iC = c_renamed(j_renamed, aVar);
        if (iC == 0) {
            if (a_renamed(aVar)) {
                j_renamed();
            }
        } else if (iC == 1) {
            b_renamed(j_renamed, aVar);
        } else if (iC != 2) {
            throw new java.lang.IllegalStateException("unexpected result".toString());
        }
    }

    private final boolean a_renamed(kotlinx.coroutines.an_renamed.a_renamed aVar) {
        kotlinx.coroutines.an_renamed.b_renamed bVar = (kotlinx.coroutines.an_renamed.b_renamed) this._delayed;
        return (bVar != null ? bVar.c_renamed() : null) == aVar;
    }

    private final int c_renamed(long j_renamed, kotlinx.coroutines.an_renamed.a_renamed aVar) {
        if (k_renamed()) {
            return 1;
        }
        kotlinx.coroutines.an_renamed.b_renamed bVar = (kotlinx.coroutines.an_renamed.b_renamed) this._delayed;
        if (bVar == null) {
            kotlinx.coroutines.an_renamed anVar = this;
            d_renamed.compareAndSet(anVar, null, new kotlinx.coroutines.an_renamed.b_renamed(j_renamed));
            java.lang.Object obj = anVar._delayed;
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(obj);
            bVar = (kotlinx.coroutines.an_renamed.b_renamed) obj;
        }
        return aVar.a_renamed(j_renamed, bVar, this);
    }

    protected final void i_renamed() {
        this._queue = null;
        this._delayed = null;
    }

    private final void n_renamed() {
        kotlinx.coroutines.an_renamed.a_renamed aVarD;
        kotlinx.coroutines.bn_renamed bnVarA = kotlinx.coroutines.bo_renamed.a_renamed();
        long jA = bnVarA != null ? bnVarA.a_renamed() : java.lang.System.nanoTime();
        while (true) {
            kotlinx.coroutines.an_renamed.b_renamed bVar = (kotlinx.coroutines.an_renamed.b_renamed) this._delayed;
            if (bVar == null || (aVarD = bVar.d_renamed()) == null) {
                return;
            } else {
                b_renamed(jA, aVarD);
            }
        }
    }

    /* compiled from: EventLoop.common.kt */
    public static abstract class a_renamed implements java.lang.Comparable<kotlinx.coroutines.an_renamed.a_renamed>, java.lang.Runnable, kotlinx.coroutines.ak_renamed, kotlinx.coroutines.internal.x_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public long f7799a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.Object f7800b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f7801c;

        @Override // kotlinx.coroutines.internal.x_renamed
        public kotlinx.coroutines.internal.w_renamed<?> b_renamed() {
            java.lang.Object obj = this.f7800b;
            if (!(obj instanceof kotlinx.coroutines.internal.w_renamed)) {
                obj = null;
            }
            return (kotlinx.coroutines.internal.w_renamed) obj;
        }

        @Override // kotlinx.coroutines.internal.x_renamed
        public void a_renamed(kotlinx.coroutines.internal.w_renamed<?> wVar) {
            if (!(this.f7800b != kotlinx.coroutines.aq_renamed.f7805a)) {
                throw new java.lang.IllegalArgumentException("Failed requirement.".toString());
            }
            this.f7800b = wVar;
        }

        @Override // kotlinx.coroutines.internal.x_renamed
        public void a_renamed(int i_renamed) {
            this.f7801c = i_renamed;
        }

        @Override // kotlinx.coroutines.internal.x_renamed
        public int c_renamed() {
            return this.f7801c;
        }

        @Override // java.lang.Comparable
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public int compareTo(kotlinx.coroutines.an_renamed.a_renamed aVar) {
            long j_renamed = this.f7799a - aVar.f7799a;
            if (j_renamed > 0) {
                return 1;
            }
            return j_renamed < 0 ? -1 : 0;
        }

        public final boolean a_renamed(long j_renamed) {
            return j_renamed - this.f7799a >= 0;
        }

        public final synchronized int a_renamed(long j_renamed, kotlinx.coroutines.an_renamed.b_renamed bVar, kotlinx.coroutines.an_renamed anVar) {
            if (this.f7800b == kotlinx.coroutines.aq_renamed.f7805a) {
                return 2;
            }
            kotlinx.coroutines.an_renamed.b_renamed bVar2 = bVar;
            kotlinx.coroutines.an_renamed.a_renamed aVar = this;
            synchronized (bVar2) {
                kotlinx.coroutines.an_renamed.a_renamed aVarE = bVar2.e_renamed();
                if (anVar.k_renamed()) {
                    return 1;
                }
                if (aVarE == null) {
                    bVar.f7802a = j_renamed;
                } else {
                    long j2 = aVarE.f7799a;
                    if (j2 - j_renamed < 0) {
                        j_renamed = j2;
                    }
                    if (j_renamed - bVar.f7802a > 0) {
                        bVar.f7802a = j_renamed;
                    }
                }
                if (this.f7799a - bVar.f7802a < 0) {
                    this.f7799a = bVar.f7802a;
                }
                bVar2.b_renamed((kotlinx.coroutines.an_renamed.b_renamed) aVar);
                return 0;
            }
        }

        @Override // kotlinx.coroutines.ak_renamed
        public final synchronized void a_renamed() {
            java.lang.Object obj = this.f7800b;
            if (obj == kotlinx.coroutines.aq_renamed.f7805a) {
                return;
            }
            if (!(obj instanceof kotlinx.coroutines.an_renamed.b_renamed)) {
                obj = null;
            }
            kotlinx.coroutines.an_renamed.b_renamed bVar = (kotlinx.coroutines.an_renamed.b_renamed) obj;
            if (bVar != null) {
                bVar.a_renamed((kotlinx.coroutines.an_renamed.b_renamed) this);
            }
            this.f7800b = kotlinx.coroutines.aq_renamed.f7805a;
        }

        public java.lang.String toString() {
            return "Delayed[nanos=" + this.f7799a + ']';
        }
    }

    /* compiled from: EventLoop.common.kt */
    public static final class b_renamed extends kotlinx.coroutines.internal.w_renamed<kotlinx.coroutines.an_renamed.a_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        public long f7802a;

        public b_renamed(long j_renamed) {
            this.f7802a = j_renamed;
        }
    }

    private final boolean b_renamed(java.lang.Runnable runnable) {
        while (true) {
            java.lang.Object obj = this._queue;
            if (k_renamed()) {
                return false;
            }
            if (obj == null) {
                if (f7798b.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.k_renamed) {
                if (obj != null) {
                    kotlinx.coroutines.internal.k_renamed kVar = (kotlinx.coroutines.internal.k_renamed) obj;
                    int iA = kVar.a_renamed((kotlinx.coroutines.internal.k_renamed) runnable);
                    if (iA == 0) {
                        return true;
                    }
                    if (iA == 1) {
                        f7798b.compareAndSet(this, obj, kVar.e_renamed());
                    } else if (iA == 2) {
                        return false;
                    }
                } else {
                    throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
            } else {
                if (obj == kotlinx.coroutines.aq_renamed.f7806b) {
                    return false;
                }
                kotlinx.coroutines.internal.k_renamed kVar2 = new kotlinx.coroutines.internal.k_renamed(8, true);
                if (obj != null) {
                    kVar2.a_renamed((kotlinx.coroutines.internal.k_renamed) obj);
                    kVar2.a_renamed((kotlinx.coroutines.internal.k_renamed) runnable);
                    if (f7798b.compareAndSet(this, obj, kVar2)) {
                        return true;
                    }
                } else {
                    throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }

    private final java.lang.Runnable l_renamed() {
        while (true) {
            java.lang.Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.k_renamed) {
                if (obj != null) {
                    kotlinx.coroutines.internal.k_renamed kVar = (kotlinx.coroutines.internal.k_renamed) obj;
                    java.lang.Object objD = kVar.d_renamed();
                    if (objD != kotlinx.coroutines.internal.k_renamed.f7874a) {
                        return (java.lang.Runnable) objD;
                    }
                    f7798b.compareAndSet(this, obj, kVar.e_renamed());
                } else {
                    throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
            } else {
                if (obj == kotlinx.coroutines.aq_renamed.f7806b) {
                    return null;
                }
                if (f7798b.compareAndSet(this, obj, null)) {
                    if (obj != null) {
                        return (java.lang.Runnable) obj;
                    }
                    throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }
}
