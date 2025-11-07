package kotlinx.coroutines.b_renamed;

/* compiled from: CoroutineScheduler.kt */
/* loaded from: classes2.dex */
public final class a_renamed implements java.io.Closeable, java.util.concurrent.Executor {
    private volatile int _isTerminated;

    /* renamed from: a_renamed, reason: collision with root package name */
    public final kotlinx.coroutines.b_renamed.e_renamed f7815a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public final kotlinx.coroutines.b_renamed.e_renamed f7816b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public final java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.b_renamed.a_renamed.b_renamed> f7817c;
    volatile long controlState;
    public final int e_renamed;
    public final int f_renamed;
    public final long g_renamed;
    public final java.lang.String h_renamed;
    private volatile long parkedWorkersStack;
    public static final kotlinx.coroutines.b_renamed.a_renamed.CoroutineScheduler.kt_3 j_renamed = new kotlinx.coroutines.b_renamed.a_renamed.CoroutineScheduler.kt_3(null);
    public static final kotlinx.coroutines.internal.r_renamed i_renamed = new kotlinx.coroutines.internal.r_renamed("NOT_IN_STACK");
    private static final java.util.concurrent.atomic.AtomicLongFieldUpdater k_renamed = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.b_renamed.a_renamed.class, "parkedWorkersStack");
    static final java.util.concurrent.atomic.AtomicLongFieldUpdater d_renamed = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.b_renamed.a_renamed.class, "controlState");
    private static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater l_renamed = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.b_renamed.a_renamed.class, "_isTerminated");

    /* compiled from: CoroutineScheduler.kt */
    public enum c_renamed {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a_renamed(int i2, int i3, long j2, java.lang.String str) {
        this.e_renamed = i2;
        this.f_renamed = i3;
        this.g_renamed = j2;
        this.h_renamed = str;
        if (!(this.e_renamed >= 1)) {
            throw new java.lang.IllegalArgumentException(("Core pool size " + this.e_renamed + " should be_renamed at_renamed least 1").toString());
        }
        if (!(this.f_renamed >= this.e_renamed)) {
            throw new java.lang.IllegalArgumentException(("Max pool size " + this.f_renamed + " should be_renamed greater than or equals to core pool size " + this.e_renamed).toString());
        }
        if (!(this.f_renamed <= 2097150)) {
            throw new java.lang.IllegalArgumentException(("Max pool size " + this.f_renamed + " should not exceed maximal supported number of_renamed threads 2097150").toString());
        }
        if (!(this.g_renamed > 0)) {
            throw new java.lang.IllegalArgumentException(("Idle worker keep alive time " + this.g_renamed + " must be_renamed positive").toString());
        }
        this.f7815a = new kotlinx.coroutines.b_renamed.e_renamed();
        this.f7816b = new kotlinx.coroutines.b_renamed.e_renamed();
        this.parkedWorkersStack = 0L;
        this.f7817c = new java.util.concurrent.atomic.AtomicReferenceArray<>(this.f_renamed + 1);
        this.controlState = this.e_renamed << 42;
        this._isTerminated = 0;
    }

    public final boolean a_renamed(kotlinx.coroutines.b_renamed.a_renamed.b_renamed bVar) {
        long j2;
        long j3;
        int iA;
        if (bVar.b_renamed() != i_renamed) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            int i2 = (int) (2097151 & j2);
            j3 = (2097152 + j2) & (-2097152);
            iA = bVar.a_renamed();
            if (kotlinx.coroutines.ac_renamed.a_renamed()) {
                if (!(iA != 0)) {
                    throw new java.lang.AssertionError();
                }
            }
            bVar.a_renamed(this.f7817c.get(i2));
        } while (!k_renamed.compareAndSet(this, j2, iA | j3));
        return true;
    }

    private final int b_renamed(kotlinx.coroutines.b_renamed.a_renamed.b_renamed bVar) {
        java.lang.Object objB = bVar.b_renamed();
        while (objB != i_renamed) {
            if (objB == null) {
                return 0;
            }
            kotlinx.coroutines.b_renamed.a_renamed.b_renamed bVar2 = (kotlinx.coroutines.b_renamed.a_renamed.b_renamed) objB;
            int iA = bVar2.a_renamed();
            if (iA != 0) {
                return iA;
            }
            objB = bVar2.b_renamed();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int d_renamed() {
        return (int) (this.controlState & 2097151);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public final boolean a_renamed() {
        return this._isTerminated;
    }

    /* compiled from: CoroutineScheduler.kt */
    /* renamed from: kotlinx.coroutines.b_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public static final class CoroutineScheduler.kt_3 {
        private CoroutineScheduler.kt_3() {
        }

        public /* synthetic */ CoroutineScheduler.kt_3(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(java.lang.Runnable runnable) {
        a_renamed(this, runnable, null, false, 6, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a_renamed(10000L);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a_renamed(long r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.b_renamed.a_renamed.l_renamed
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            kotlinx.coroutines.b_renamed.a_renamed$b_renamed r0 = r8.g_renamed()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.b_renamed.a_renamed$b_renamed> r3 = r8.f7817c
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch: java.lang.Throwable -> Lbc
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r3)
            if (r2 > r4) goto L60
            r3 = r2
        L1d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.b_renamed.a_renamed$b_renamed> r5 = r8.f7817c
            java.lang.Object r5 = r5.get(r3)
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(r5)
            kotlinx.coroutines.b_renamed.a_renamed$b_renamed r5 = (kotlinx.coroutines.b_renamed.a_renamed.b_renamed) r5
            if (r5 == r0) goto L5b
        L2a:
            boolean r6 = r5.isAlive()
            if (r6 == 0) goto L3a
            r6 = r5
            java.lang.Thread r6 = (java.lang.Thread) r6
            java.util.concurrent.locks.LockSupport.unpark(r6)
            r5.join(r9)
            goto L2a
        L3a:
            kotlinx.coroutines.b_renamed.a_renamed$c_renamed r6 = r5.f7820b
            boolean r7 = kotlinx.coroutines.ac_renamed.a_renamed()
            if (r7 == 0) goto L54
            kotlinx.coroutines.b_renamed.a_renamed$c_renamed r7 = kotlinx.coroutines.b_renamed.a_renamed.c_renamed.TERMINATED
            if (r6 != r7) goto L48
            r6 = r2
            goto L49
        L48:
            r6 = r1
        L49:
            if (r6 == 0) goto L4c
            goto L54
        L4c:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        L54:
            kotlinx.coroutines.b_renamed.n_renamed r5 = r5.f7819a
            kotlinx.coroutines.b_renamed.e_renamed r6 = r8.f7816b
            r5.a_renamed(r6)
        L5b:
            if (r3 == r4) goto L60
            int r3 = r3 + 1
            goto L1d
        L60:
            kotlinx.coroutines.b_renamed.e_renamed r9 = r8.f7816b
            r9.b_renamed()
            kotlinx.coroutines.b_renamed.e_renamed r9 = r8.f7815a
            r9.b_renamed()
        L6a:
            if (r0 == 0) goto L73
            kotlinx.coroutines.b_renamed.i_renamed r9 = r0.a_renamed(r2)
            if (r9 == 0) goto L73
            goto L7b
        L73:
            kotlinx.coroutines.b_renamed.e_renamed r9 = r8.f7815a
            java.lang.Object r9 = r9.c_renamed()
            kotlinx.coroutines.b_renamed.i_renamed r9 = (kotlinx.coroutines.b_renamed.i_renamed) r9
        L7b:
            if (r9 == 0) goto L7e
            goto L86
        L7e:
            kotlinx.coroutines.b_renamed.e_renamed r9 = r8.f7816b
            java.lang.Object r9 = r9.c_renamed()
            kotlinx.coroutines.b_renamed.i_renamed r9 = (kotlinx.coroutines.b_renamed.i_renamed) r9
        L86:
            if (r9 == 0) goto L8c
            r8.a_renamed(r9)
            goto L6a
        L8c:
            if (r0 == 0) goto L93
            kotlinx.coroutines.b_renamed.a_renamed$c_renamed r9 = kotlinx.coroutines.b_renamed.a_renamed.c_renamed.TERMINATED
            r0.a_renamed(r9)
        L93:
            boolean r9 = kotlinx.coroutines.ac_renamed.a_renamed()
            if (r9 == 0) goto Lb5
            long r9 = r8.controlState
            r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r3
            r0 = 42
            long r9 = r9 >> r0
            int r9 = (int) r9
            int r10 = r8.e_renamed
            if (r9 != r10) goto Laa
            r1 = r2
        Laa:
            if (r1 == 0) goto Lad
            goto Lb5
        Lad:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        Lb5:
            r9 = 0
            r8.parkedWorkersStack = r9
            r8.controlState = r9
            return
        Lbc:
            r8 = move-exception
            monitor-exit(r3)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.b_renamed.a_renamed.a_renamed(long):void");
    }

    public static /* synthetic */ void a_renamed(kotlinx.coroutines.b_renamed.a_renamed aVar, java.lang.Runnable runnable, kotlinx.coroutines.b_renamed.j_renamed jVar, boolean z_renamed, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            jVar = kotlinx.coroutines.b_renamed.h_renamed.f7826a;
        }
        if ((i2 & 4) != 0) {
            z_renamed = false;
        }
        aVar.a_renamed(runnable, jVar, z_renamed);
    }

    public final void a_renamed(java.lang.Runnable runnable, kotlinx.coroutines.b_renamed.j_renamed jVar, boolean z_renamed) {
        kotlinx.coroutines.bn_renamed bnVarA = kotlinx.coroutines.bo_renamed.a_renamed();
        if (bnVarA != null) {
            bnVarA.b_renamed();
        }
        kotlinx.coroutines.b_renamed.i_renamed iVarA = a_renamed(runnable, jVar);
        kotlinx.coroutines.b_renamed.a_renamed.b_renamed bVarG = g_renamed();
        kotlinx.coroutines.b_renamed.i_renamed iVarA2 = a_renamed(bVarG, iVarA, z_renamed);
        if (iVarA2 != null && !b_renamed(iVarA2)) {
            throw new java.util.concurrent.RejectedExecutionException(this.h_renamed + " was terminated");
        }
        boolean z2 = z_renamed && bVarG != null;
        if (iVarA.g_renamed.b_renamed() != 0) {
            a_renamed(z2);
        } else {
            if (z2) {
                return;
            }
            b_renamed();
        }
    }

    public final kotlinx.coroutines.b_renamed.i_renamed a_renamed(java.lang.Runnable runnable, kotlinx.coroutines.b_renamed.j_renamed jVar) {
        long jA = kotlinx.coroutines.b_renamed.l_renamed.f_renamed.a_renamed();
        if (runnable instanceof kotlinx.coroutines.b_renamed.i_renamed) {
            kotlinx.coroutines.b_renamed.i_renamed iVar = (kotlinx.coroutines.b_renamed.i_renamed) runnable;
            iVar.f_renamed = jA;
            iVar.g_renamed = jVar;
            return iVar;
        }
        return new kotlinx.coroutines.b_renamed.k_renamed(runnable, jA, jVar);
    }

    public final void b_renamed() {
        if (e_renamed() || a_renamed(this, 0L, 1, null)) {
            return;
        }
        e_renamed();
    }

    static /* synthetic */ boolean a_renamed(kotlinx.coroutines.b_renamed.a_renamed aVar, long j2, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            j2 = aVar.controlState;
        }
        return aVar.b_renamed(j2);
    }

    private final boolean b_renamed(long j2) {
        if (c_renamed.h_renamed.d_renamed.b_renamed(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.e_renamed) {
            int iF = f_renamed();
            if (iF == 1 && this.e_renamed > 1) {
                f_renamed();
            }
            if (iF > 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean e_renamed() {
        kotlinx.coroutines.b_renamed.a_renamed.b_renamed bVarC;
        do {
            bVarC = c_renamed();
            if (bVarC == null) {
                return false;
            }
        } while (!kotlinx.coroutines.b_renamed.a_renamed.b_renamed.f7818c.compareAndSet(bVarC, -1, 0));
        java.util.concurrent.locks.LockSupport.unpark(bVarC);
        return true;
    }

    private final int f_renamed() {
        synchronized (this.f7817c) {
            if (a_renamed()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int iB = c_renamed.h_renamed.d_renamed.b_renamed(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (iB >= this.e_renamed) {
                return 0;
            }
            if (i2 >= this.f_renamed) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i3 > 0 && this.f7817c.get(i3) == null)) {
                throw new java.lang.IllegalArgumentException("Failed requirement.".toString());
            }
            kotlinx.coroutines.b_renamed.a_renamed.b_renamed bVar = new kotlinx.coroutines.b_renamed.a_renamed.b_renamed(this, i3);
            this.f7817c.set(i3, bVar);
            if (!(i3 == ((int) (2097151 & d_renamed.incrementAndGet(this))))) {
                throw new java.lang.IllegalArgumentException("Failed requirement.".toString());
            }
            bVar.start();
            return iB + 1;
        }
    }

    private final kotlinx.coroutines.b_renamed.i_renamed a_renamed(kotlinx.coroutines.b_renamed.a_renamed.b_renamed bVar, kotlinx.coroutines.b_renamed.i_renamed iVar, boolean z_renamed) {
        if (bVar == null || bVar.f7820b == kotlinx.coroutines.b_renamed.a_renamed.c_renamed.TERMINATED) {
            return iVar;
        }
        if (iVar.g_renamed.b_renamed() == 0 && bVar.f7820b == kotlinx.coroutines.b_renamed.a_renamed.c_renamed.BLOCKING) {
            return iVar;
        }
        bVar.d_renamed = true;
        return bVar.f7819a.a_renamed(iVar, z_renamed);
    }

    private final kotlinx.coroutines.b_renamed.a_renamed.b_renamed g_renamed() {
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (!(threadCurrentThread instanceof kotlinx.coroutines.b_renamed.a_renamed.b_renamed)) {
            threadCurrentThread = null;
        }
        kotlinx.coroutines.b_renamed.a_renamed.b_renamed bVar = (kotlinx.coroutines.b_renamed.a_renamed.b_renamed) threadCurrentThread;
        if (bVar == null || !c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(kotlinx.coroutines.b_renamed.a_renamed.this, this)) {
            return null;
        }
        return bVar;
    }

    public java.lang.String toString() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int length = this.f7817c.length();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < length; i7++) {
            kotlinx.coroutines.b_renamed.a_renamed.b_renamed bVar = this.f7817c.get(i7);
            if (bVar != null) {
                int iB = bVar.f7819a.b_renamed();
                int i8 = kotlinx.coroutines.b_renamed.b_renamed.f7821a[bVar.f7820b.ordinal()];
                if (i8 == 1) {
                    i4++;
                } else if (i8 == 2) {
                    i3++;
                    arrayList.add(java.lang.String.valueOf(iB) + "b_renamed");
                } else if (i8 == 3) {
                    i2++;
                    arrayList.add(java.lang.String.valueOf(iB) + "c_renamed");
                } else if (i8 == 4) {
                    i5++;
                    if (iB > 0) {
                        arrayList.add(java.lang.String.valueOf(iB) + "d_renamed");
                    }
                } else if (i8 == 5) {
                    i6++;
                }
            }
        }
        long j2 = this.controlState;
        return this.h_renamed + '@' + kotlinx.coroutines.ad_renamed.a_renamed(this) + "[Pool Size {core = " + this.e_renamed + ", max = " + this.f_renamed + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f7815a.a_renamed() + ", global blocking queue size = " + this.f7816b.a_renamed() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.e_renamed - ((int) ((j2 & 9223367638808264704L) >> 42))) + "}]";
    }

    public final void a_renamed(kotlinx.coroutines.b_renamed.i_renamed iVar) {
        kotlinx.coroutines.bn_renamed bnVarA;
        try {
            try {
                iVar.run();
                bnVarA = kotlinx.coroutines.bo_renamed.a_renamed();
                if (bnVarA == null) {
                    return;
                }
            } catch (java.lang.Throwable th) {
                java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                bnVarA = kotlinx.coroutines.bo_renamed.a_renamed();
                if (bnVarA == null) {
                    return;
                }
            }
            bnVarA.c_renamed();
        } catch (java.lang.Throwable th2) {
            kotlinx.coroutines.bn_renamed bnVarA2 = kotlinx.coroutines.bo_renamed.a_renamed();
            if (bnVarA2 != null) {
                bnVarA2.c_renamed();
            }
            throw th2;
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    public final class b_renamed extends java.lang.Thread {

        /* renamed from: c_renamed, reason: collision with root package name */
        static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater f7818c = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.b_renamed.a_renamed.b_renamed.class, "workerCtl");

        /* renamed from: a_renamed, reason: collision with root package name */
        public final kotlinx.coroutines.b_renamed.n_renamed f7819a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public kotlinx.coroutines.b_renamed.a_renamed.c_renamed f7820b;
        public boolean d_renamed;
        private long f_renamed;
        private long g_renamed;
        private int h_renamed;
        private volatile int indexInArray;
        private volatile java.lang.Object nextParkedWorker;
        volatile int workerCtl;

        private b_renamed() {
            setDaemon(true);
            this.f7819a = new kotlinx.coroutines.b_renamed.n_renamed();
            this.f7820b = kotlinx.coroutines.b_renamed.a_renamed.c_renamed.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = kotlinx.coroutines.b_renamed.a_renamed.i_renamed;
            this.h_renamed = c_renamed.g_renamed.c_renamed.f1912a.b_renamed();
        }

        public final int a_renamed() {
            return this.indexInArray;
        }

        public final void a_renamed(int i_renamed) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(kotlinx.coroutines.b_renamed.a_renamed.this.h_renamed);
            sb.append("-worker-");
            sb.append(i_renamed == 0 ? "TERMINATED" : java.lang.String.valueOf(i_renamed));
            setName(sb.toString());
            this.indexInArray = i_renamed;
        }

        public b_renamed(kotlinx.coroutines.b_renamed.a_renamed aVar, int i_renamed) {
            this();
            a_renamed(i_renamed);
        }

        public final void a_renamed(java.lang.Object obj) {
            this.nextParkedWorker = obj;
        }

        public final java.lang.Object b_renamed() {
            return this.nextParkedWorker;
        }

        private final boolean c_renamed() {
            boolean z_renamed;
            if (this.f7820b == kotlinx.coroutines.b_renamed.a_renamed.c_renamed.CPU_ACQUIRED) {
                return true;
            }
            kotlinx.coroutines.b_renamed.a_renamed aVar = kotlinx.coroutines.b_renamed.a_renamed.this;
            while (true) {
                long j_renamed = aVar.controlState;
                if (((int) ((9223367638808264704L & j_renamed) >> 42)) == 0) {
                    z_renamed = false;
                    break;
                }
                if (kotlinx.coroutines.b_renamed.a_renamed.d_renamed.compareAndSet(aVar, j_renamed, j_renamed - 4398046511104L)) {
                    z_renamed = true;
                    break;
                }
            }
            if (!z_renamed) {
                return false;
            }
            this.f7820b = kotlinx.coroutines.b_renamed.a_renamed.c_renamed.CPU_ACQUIRED;
            return true;
        }

        public final boolean a_renamed(kotlinx.coroutines.b_renamed.a_renamed.c_renamed cVar) {
            kotlinx.coroutines.b_renamed.a_renamed.c_renamed cVar2 = this.f7820b;
            boolean z_renamed = cVar2 == kotlinx.coroutines.b_renamed.a_renamed.c_renamed.CPU_ACQUIRED;
            if (z_renamed) {
                kotlinx.coroutines.b_renamed.a_renamed.d_renamed.addAndGet(kotlinx.coroutines.b_renamed.a_renamed.this, 4398046511104L);
            }
            if (cVar2 != cVar) {
                this.f7820b = cVar;
            }
            return z_renamed;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d_renamed();
        }

        private final void d_renamed() {
            loop0: while (true) {
                boolean z_renamed = false;
                while (!kotlinx.coroutines.b_renamed.a_renamed.this.a_renamed() && this.f7820b != kotlinx.coroutines.b_renamed.a_renamed.c_renamed.TERMINATED) {
                    kotlinx.coroutines.b_renamed.i_renamed iVarA = a_renamed(this.d_renamed);
                    if (iVarA != null) {
                        this.g_renamed = 0L;
                        a_renamed(iVarA);
                    } else {
                        this.d_renamed = false;
                        if (this.g_renamed == 0) {
                            e_renamed();
                        } else if (z_renamed) {
                            a_renamed(kotlinx.coroutines.b_renamed.a_renamed.c_renamed.PARKING);
                            java.lang.Thread.interrupted();
                            java.util.concurrent.locks.LockSupport.parkNanos(this.g_renamed);
                            this.g_renamed = 0L;
                        } else {
                            z_renamed = true;
                        }
                    }
                }
                break loop0;
            }
            a_renamed(kotlinx.coroutines.b_renamed.a_renamed.c_renamed.TERMINATED);
        }

        private final void e_renamed() {
            if (!f_renamed()) {
                kotlinx.coroutines.b_renamed.a_renamed.this.a_renamed(this);
                return;
            }
            if (kotlinx.coroutines.ac_renamed.a_renamed()) {
                if (!(this.f7819a.b_renamed() == 0)) {
                    throw new java.lang.AssertionError();
                }
            }
            this.workerCtl = -1;
            while (f_renamed() && !kotlinx.coroutines.b_renamed.a_renamed.this.a_renamed() && this.f7820b != kotlinx.coroutines.b_renamed.a_renamed.c_renamed.TERMINATED) {
                a_renamed(kotlinx.coroutines.b_renamed.a_renamed.c_renamed.PARKING);
                java.lang.Thread.interrupted();
                g_renamed();
            }
        }

        private final boolean f_renamed() {
            return this.nextParkedWorker != kotlinx.coroutines.b_renamed.a_renamed.i_renamed;
        }

        private final void c_renamed(int i_renamed) {
            if (i_renamed != 0 && a_renamed(kotlinx.coroutines.b_renamed.a_renamed.c_renamed.BLOCKING)) {
                kotlinx.coroutines.b_renamed.a_renamed.this.b_renamed();
            }
        }

        private final void d_renamed(int i_renamed) {
            if (i_renamed == 0) {
                return;
            }
            kotlinx.coroutines.b_renamed.a_renamed.d_renamed.addAndGet(kotlinx.coroutines.b_renamed.a_renamed.this, -2097152L);
            kotlinx.coroutines.b_renamed.a_renamed.c_renamed cVar = this.f7820b;
            if (cVar != kotlinx.coroutines.b_renamed.a_renamed.c_renamed.TERMINATED) {
                if (kotlinx.coroutines.ac_renamed.a_renamed()) {
                    if (!(cVar == kotlinx.coroutines.b_renamed.a_renamed.c_renamed.BLOCKING)) {
                        throw new java.lang.AssertionError();
                    }
                }
                this.f7820b = kotlinx.coroutines.b_renamed.a_renamed.c_renamed.DORMANT;
            }
        }

        public final int b_renamed(int i_renamed) {
            int i2 = this.h_renamed;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.h_renamed = i5;
            int i6 = i_renamed - 1;
            return (i6 & i_renamed) == 0 ? i6 & i5 : (Integer.MAX_VALUE & i5) % i_renamed;
        }

        private final void g_renamed() {
            if (this.f_renamed == 0) {
                this.f_renamed = java.lang.System.nanoTime() + kotlinx.coroutines.b_renamed.a_renamed.this.g_renamed;
            }
            java.util.concurrent.locks.LockSupport.parkNanos(kotlinx.coroutines.b_renamed.a_renamed.this.g_renamed);
            if (java.lang.System.nanoTime() - this.f_renamed >= 0) {
                this.f_renamed = 0L;
                h_renamed();
            }
        }

        private final void h_renamed() {
            synchronized (kotlinx.coroutines.b_renamed.a_renamed.this.f7817c) {
                if (kotlinx.coroutines.b_renamed.a_renamed.this.a_renamed()) {
                    return;
                }
                if (kotlinx.coroutines.b_renamed.a_renamed.this.d_renamed() <= kotlinx.coroutines.b_renamed.a_renamed.this.e_renamed) {
                    return;
                }
                if (f7818c.compareAndSet(this, -1, 1)) {
                    int i_renamed = this.indexInArray;
                    a_renamed(0);
                    kotlinx.coroutines.b_renamed.a_renamed.this.a_renamed(this, i_renamed, 0);
                    int andDecrement = (int) (kotlinx.coroutines.b_renamed.a_renamed.d_renamed.getAndDecrement(kotlinx.coroutines.b_renamed.a_renamed.this) & 2097151);
                    if (andDecrement != i_renamed) {
                        kotlinx.coroutines.b_renamed.a_renamed.b_renamed bVar = kotlinx.coroutines.b_renamed.a_renamed.this.f7817c.get(andDecrement);
                        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(bVar);
                        kotlinx.coroutines.b_renamed.a_renamed.b_renamed bVar2 = bVar;
                        kotlinx.coroutines.b_renamed.a_renamed.this.f7817c.set(i_renamed, bVar2);
                        bVar2.a_renamed(i_renamed);
                        kotlinx.coroutines.b_renamed.a_renamed.this.a_renamed(bVar2, andDecrement, i_renamed);
                    }
                    kotlinx.coroutines.b_renamed.a_renamed.this.f7817c.set(andDecrement, null);
                    c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
                    this.f7820b = kotlinx.coroutines.b_renamed.a_renamed.c_renamed.TERMINATED;
                }
            }
        }

        private final void e_renamed(int i_renamed) {
            this.f_renamed = 0L;
            if (this.f7820b == kotlinx.coroutines.b_renamed.a_renamed.c_renamed.PARKING) {
                if (kotlinx.coroutines.ac_renamed.a_renamed()) {
                    if (!(i_renamed == 1)) {
                        throw new java.lang.AssertionError();
                    }
                }
                this.f7820b = kotlinx.coroutines.b_renamed.a_renamed.c_renamed.BLOCKING;
            }
        }

        public final kotlinx.coroutines.b_renamed.i_renamed a_renamed(boolean z_renamed) {
            kotlinx.coroutines.b_renamed.i_renamed iVarC;
            if (c_renamed()) {
                return b_renamed(z_renamed);
            }
            if (!z_renamed || (iVarC = this.f7819a.c_renamed()) == null) {
                iVarC = kotlinx.coroutines.b_renamed.a_renamed.this.f7816b.c_renamed();
            }
            return iVarC != null ? iVarC : c_renamed(true);
        }

        private final kotlinx.coroutines.b_renamed.i_renamed b_renamed(boolean z_renamed) {
            kotlinx.coroutines.b_renamed.i_renamed iVarI;
            kotlinx.coroutines.b_renamed.i_renamed iVarI2;
            if (z_renamed) {
                boolean z2 = b_renamed(kotlinx.coroutines.b_renamed.a_renamed.this.e_renamed * 2) == 0;
                if (z2 && (iVarI2 = i_renamed()) != null) {
                    return iVarI2;
                }
                kotlinx.coroutines.b_renamed.i_renamed iVarC = this.f7819a.c_renamed();
                if (iVarC != null) {
                    return iVarC;
                }
                if (!z2 && (iVarI = i_renamed()) != null) {
                    return iVarI;
                }
            } else {
                kotlinx.coroutines.b_renamed.i_renamed iVarI3 = i_renamed();
                if (iVarI3 != null) {
                    return iVarI3;
                }
            }
            return c_renamed(false);
        }

        private final kotlinx.coroutines.b_renamed.i_renamed i_renamed() {
            if (b_renamed(2) == 0) {
                kotlinx.coroutines.b_renamed.i_renamed iVarC = kotlinx.coroutines.b_renamed.a_renamed.this.f7815a.c_renamed();
                return iVarC != null ? iVarC : kotlinx.coroutines.b_renamed.a_renamed.this.f7816b.c_renamed();
            }
            kotlinx.coroutines.b_renamed.i_renamed iVarC2 = kotlinx.coroutines.b_renamed.a_renamed.this.f7816b.c_renamed();
            return iVarC2 != null ? iVarC2 : kotlinx.coroutines.b_renamed.a_renamed.this.f7815a.c_renamed();
        }

        private final kotlinx.coroutines.b_renamed.i_renamed c_renamed(boolean z_renamed) {
            long jA;
            if (kotlinx.coroutines.ac_renamed.a_renamed()) {
                if (!(this.f7819a.b_renamed() == 0)) {
                    throw new java.lang.AssertionError();
                }
            }
            int iD = kotlinx.coroutines.b_renamed.a_renamed.this.d_renamed();
            if (iD < 2) {
                return null;
            }
            int iB = b_renamed(iD);
            long jMin = Long.MAX_VALUE;
            for (int i_renamed = 0; i_renamed < iD; i_renamed++) {
                iB++;
                if (iB > iD) {
                    iB = 1;
                }
                kotlinx.coroutines.b_renamed.a_renamed.b_renamed bVar = kotlinx.coroutines.b_renamed.a_renamed.this.f7817c.get(iB);
                if (bVar != null && bVar != this) {
                    if (kotlinx.coroutines.ac_renamed.a_renamed()) {
                        if (!(this.f7819a.b_renamed() == 0)) {
                            throw new java.lang.AssertionError();
                        }
                    }
                    if (z_renamed) {
                        jA = this.f7819a.b_renamed(bVar.f7819a);
                    } else {
                        jA = this.f7819a.a_renamed(bVar.f7819a);
                    }
                    if (jA == -1) {
                        return this.f7819a.c_renamed();
                    }
                    if (jA > 0) {
                        jMin = java.lang.Math.min(jMin, jA);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.g_renamed = jMin;
            return null;
        }

        private final void a_renamed(kotlinx.coroutines.b_renamed.i_renamed iVar) {
            int iB = iVar.g_renamed.b_renamed();
            e_renamed(iB);
            c_renamed(iB);
            kotlinx.coroutines.b_renamed.a_renamed.this.a_renamed(iVar);
            d_renamed(iB);
        }
    }

    private final boolean b_renamed(kotlinx.coroutines.b_renamed.i_renamed iVar) {
        if (iVar.g_renamed.b_renamed() == 1) {
            return this.f7816b.a_renamed(iVar);
        }
        return this.f7815a.a_renamed(iVar);
    }

    public final void a_renamed(kotlinx.coroutines.b_renamed.a_renamed.b_renamed bVar, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int iB = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (iB == i2) {
                iB = i3 == 0 ? b_renamed(bVar) : i3;
            }
            if (iB >= 0 && k_renamed.compareAndSet(this, j2, j3 | iB)) {
                return;
            }
        }
    }

    private final kotlinx.coroutines.b_renamed.a_renamed.b_renamed c_renamed() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            kotlinx.coroutines.b_renamed.a_renamed.b_renamed bVar = this.f7817c.get((int) (2097151 & j2));
            if (bVar == null) {
                return null;
            }
            long j3 = (2097152 + j2) & (-2097152);
            int iB = b_renamed(bVar);
            if (iB >= 0 && k_renamed.compareAndSet(this, j2, iB | j3)) {
                bVar.a_renamed(i_renamed);
                return bVar;
            }
        }
    }

    private final void a_renamed(boolean z_renamed) {
        long jAddAndGet = d_renamed.addAndGet(this, 2097152L);
        if (z_renamed || e_renamed() || b_renamed(jAddAndGet)) {
            return;
        }
        e_renamed();
    }
}
