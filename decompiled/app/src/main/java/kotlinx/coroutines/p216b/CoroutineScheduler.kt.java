package kotlinx.coroutines.p216b;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.Debug.kt;
import kotlinx.coroutines.DebugStrings.kt;
import kotlinx.coroutines.TimeSource.kt_2;
import kotlinx.coroutines.TimeSource.kt;
import kotlinx.coroutines.internal.Symbol.kt;
import p061c.Unit.kt;
import p061c.p070f.p072b.DefaultConstructorMarker;
import p061c.p070f.p072b.Intrinsics;
import p061c.p073g.Random.kt;
import p061c.p074h.C0987d;

/* compiled from: CoroutineScheduler.kt */
/* renamed from: kotlinx.coroutines.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public final class CoroutineScheduler.kt implements Closeable, Executor {
    private volatile int _isTerminated;

    /* renamed from: PlatformImplementations.kt_3 */
    public final Tasks.kt_5 f24603a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final Tasks.kt_5 f24604b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final AtomicReferenceArray<IntrinsicsJvm.kt_4> f24605c;
    volatile long controlState;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final int f24606e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public final int f24607f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public final long f24608g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public final String f24609h;
    private volatile long parkedWorkersStack;

    /* renamed from: OplusGLSurfaceView_15 */
    public static final PlatformImplementations.kt_3 f24600j = new PlatformImplementations.kt_3(null);

    /* renamed from: OplusGLSurfaceView_13 */
    public static final Symbol.kt f24599i = new Symbol.kt("NOT_IN_STACK");

    /* renamed from: OplusGLSurfaceView_5 */
    private static final AtomicLongFieldUpdater f24601k = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.kt.class, "parkedWorkersStack");

    /* renamed from: IntrinsicsJvm.kt_5 */
    static final AtomicLongFieldUpdater f24598d = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.kt.class, "controlState");

    /* renamed from: OplusGLSurfaceView_14 */
    private static final AtomicIntegerFieldUpdater f24602l = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.kt.class, "_isTerminated");

    /* compiled from: CoroutineScheduler.kt */
    /* renamed from: kotlinx.coroutines.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    public enum IntrinsicsJvm.kt_3 {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public CoroutineScheduler.kt(int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15, String str) {
        this.f24606e = OplusGLSurfaceView_13;
        this.f24607f = i2;
        this.f24608g = OplusGLSurfaceView_15;
        this.f24609h = str;
        if (!(this.f24606e >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + this.f24606e + " should be at least 1").toString());
        }
        if (!(this.f24607f >= this.f24606e)) {
            throw new IllegalArgumentException(("Max pool size " + this.f24607f + " should be greater than or equals to core pool size " + this.f24606e).toString());
        }
        if (!(this.f24607f <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + this.f24607f + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(this.f24608g > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + this.f24608g + " must be positive").toString());
        }
        this.f24603a = new Tasks.kt_5();
        this.f24604b = new Tasks.kt_5();
        this.parkedWorkersStack = 0L;
        this.f24605c = new AtomicReferenceArray<>(this.f24607f + 1);
        this.controlState = this.f24606e << 42;
        this._isTerminated = 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m25677a(IntrinsicsJvm.kt_4 bVar) {
        long OplusGLSurfaceView_15;
        long j2;
        int iM25692a;
        if (bVar.m25698b() != f24599i) {
            return false;
        }
        do {
            OplusGLSurfaceView_15 = this.parkedWorkersStack;
            int OplusGLSurfaceView_13 = (int) (2097151 & OplusGLSurfaceView_15);
            j2 = (2097152 + OplusGLSurfaceView_15) & (-2097152);
            iM25692a = bVar.m25692a();
            if (Debug.kt.m25574a()) {
                if (!(iM25692a != 0)) {
                    throw new AssertionError();
                }
            }
            bVar.m25695a(this.f24605c.get(OplusGLSurfaceView_13));
        } while (!f24601k.compareAndSet(this, OplusGLSurfaceView_15, iM25692a | j2));
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int m25663b(IntrinsicsJvm.kt_4 bVar) {
        Object objM25698b = bVar.m25698b();
        while (objM25698b != f24599i) {
            if (objM25698b == null) {
                return 0;
            }
            IntrinsicsJvm.kt_4 bVar2 = (IntrinsicsJvm.kt_4) objM25698b;
            int iM25692a = bVar2.m25692a();
            if (iM25692a != 0) {
                return iM25692a;
            }
            objM25698b = bVar2.m25698b();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public final int m25667d() {
        return (int) (this.controlState & 2097151);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m25676a() {
        return this._isTerminated;
    }

    /* compiled from: CoroutineScheduler.kt */
    /* renamed from: kotlinx.coroutines.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {
        private PlatformImplementations.kt_3() {
        }

        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        m25660a(this, runnable, null, false, 6, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m25672a(10000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m25672a(long r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.p216b.CoroutineScheduler.kt.f24602l
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            kotlinx.coroutines.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 r0 = r8.m25670g()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4> r3 = r8.f24605c
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch: java.lang.Throwable -> Lbc
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r3)
            if (r2 > r4) goto L60
            r3 = r2
        L1d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4> r5 = r8.f24605c
            java.lang.Object r5 = r5.get(r3)
            p061c.p070f.p072b.Intrinsics.m5296a(r5)
            kotlinx.coroutines.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 r5 = (kotlinx.coroutines.p216b.CoroutineScheduler.kt.IntrinsicsJvm.kt_4) r5
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
            kotlinx.coroutines.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 r6 = r5.f24612b
            boolean r7 = kotlinx.coroutines.Debug.kt.m25574a()
            if (r7 == 0) goto L54
            kotlinx.coroutines.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 r7 = kotlinx.coroutines.p216b.CoroutineScheduler.kt.IntrinsicsJvm.kt_3.TERMINATED
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
            kotlinx.coroutines.IntrinsicsJvm.kt_4.OplusGLSurfaceView_11 r5 = r5.f24611a
            kotlinx.coroutines.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 r6 = r8.f24604b
            r5.m25715a(r6)
        L5b:
            if (r3 == r4) goto L60
            int r3 = r3 + 1
            goto L1d
        L60:
            kotlinx.coroutines.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 r9 = r8.f24604b
            r9.m25862b()
            kotlinx.coroutines.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 r9 = r8.f24603a
            r9.m25862b()
        L6a:
            if (r0 == 0) goto L73
            kotlinx.coroutines.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13 r9 = r0.m25693a(r2)
            if (r9 == 0) goto L73
            goto L7b
        L73:
            kotlinx.coroutines.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 r9 = r8.f24603a
            java.lang.Object r9 = r9.m25863c()
            kotlinx.coroutines.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13 r9 = (kotlinx.coroutines.p216b.Tasks.kt_8) r9
        L7b:
            if (r9 == 0) goto L7e
            goto L86
        L7e:
            kotlinx.coroutines.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 r9 = r8.f24604b
            java.lang.Object r9 = r9.m25863c()
            kotlinx.coroutines.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13 r9 = (kotlinx.coroutines.p216b.Tasks.kt_8) r9
        L86:
            if (r9 == 0) goto L8c
            r8.m25675a(r9)
            goto L6a
        L8c:
            if (r0 == 0) goto L93
            kotlinx.coroutines.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 r9 = kotlinx.coroutines.p216b.CoroutineScheduler.kt.IntrinsicsJvm.kt_3.TERMINATED
            r0.m25696a(r9)
        L93:
            boolean r9 = kotlinx.coroutines.Debug.kt.m25574a()
            if (r9 == 0) goto Lb5
            long r9 = r8.controlState
            r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r3
            r0 = 42
            long r9 = r9 >> r0
            int r9 = (int) r9
            int r10 = r8.f24606e
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.p216b.CoroutineScheduler.kt.m25672a(long):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m25660a(CoroutineScheduler.kt executorC3884a, Runnable runnable, Tasks.kt_6 interfaceC3893j, boolean z, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            interfaceC3893j = Tasks.kt_2.f24633a;
        }
        if ((OplusGLSurfaceView_13 & 4) != 0) {
            z = false;
        }
        executorC3884a.m25673a(runnable, interfaceC3893j, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25673a(Runnable runnable, Tasks.kt_6 interfaceC3893j, boolean z) {
        TimeSource.kt interfaceC3911bnM25806a = TimeSource.kt_2.m25806a();
        if (interfaceC3911bnM25806a != null) {
            interfaceC3911bnM25806a.m25802b();
        }
        Tasks.kt_8 abstractRunnableC3892iM25671a = m25671a(runnable, interfaceC3893j);
        IntrinsicsJvm.kt_4 bVarM25670g = m25670g();
        Tasks.kt_8 abstractRunnableC3892iM25659a = m25659a(bVarM25670g, abstractRunnableC3892iM25671a, z);
        if (abstractRunnableC3892iM25659a != null && !m25665b(abstractRunnableC3892iM25659a)) {
            throw new RejectedExecutionException(this.f24609h + " was terminated");
        }
        boolean z2 = z && bVarM25670g != null;
        if (abstractRunnableC3892iM25671a.f24636g.mo25704b() != 0) {
            m25661a(z2);
        } else {
            if (z2) {
                return;
            }
            m25678b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final Tasks.kt_8 m25671a(Runnable runnable, Tasks.kt_6 interfaceC3893j) {
        long jMo25705a = Tasks.kt_4.f24643f.mo25705a();
        if (runnable instanceof Tasks.kt_8) {
            Tasks.kt_8 abstractRunnableC3892i = (Tasks.kt_8) runnable;
            abstractRunnableC3892i.f24635f = jMo25705a;
            abstractRunnableC3892i.f24636g = interfaceC3893j;
            return abstractRunnableC3892i;
        }
        return new Tasks.kt_3(runnable, jMo25705a, interfaceC3893j);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m25678b() {
        if (m25668e() || m25662a(this, 0L, 1, null)) {
            return;
        }
        m25668e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static /* synthetic */ boolean m25662a(CoroutineScheduler.kt executorC3884a, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 1) != 0) {
            OplusGLSurfaceView_15 = executorC3884a.controlState;
        }
        return executorC3884a.m25664b(OplusGLSurfaceView_15);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final boolean m25664b(long OplusGLSurfaceView_15) {
        if (C0987d.m5336b(((int) (2097151 & OplusGLSurfaceView_15)) - ((int) ((OplusGLSurfaceView_15 & 4398044413952L) >> 21)), 0) < this.f24606e) {
            int iM25669f = m25669f();
            if (iM25669f == 1 && this.f24606e > 1) {
                m25669f();
            }
            if (iM25669f > 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean m25668e() {
        IntrinsicsJvm.kt_4 bVarM25666c;
        do {
            bVarM25666c = m25666c();
            if (bVarM25666c == null) {
                return false;
            }
        } while (!IntrinsicsJvm.kt_4.f24610c.compareAndSet(bVarM25666c, -1, 0));
        LockSupport.unpark(bVarM25666c);
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final int m25669f() {
        synchronized (this.f24605c) {
            if (m25676a()) {
                return -1;
            }
            long OplusGLSurfaceView_15 = this.controlState;
            int OplusGLSurfaceView_13 = (int) (OplusGLSurfaceView_15 & 2097151);
            int iB = C0987d.m5336b(OplusGLSurfaceView_13 - ((int) ((OplusGLSurfaceView_15 & 4398044413952L) >> 21)), 0);
            if (iB >= this.f24606e) {
                return 0;
            }
            if (OplusGLSurfaceView_13 >= this.f24607f) {
                return 0;
            }
            int i2 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i2 > 0 && this.f24605c.get(i2) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4(this, i2);
            this.f24605c.set(i2, bVar);
            if (!(i2 == ((int) (2097151 & f24598d.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            bVar.start();
            return iB + 1;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final Tasks.kt_8 m25659a(IntrinsicsJvm.kt_4 bVar, Tasks.kt_8 abstractRunnableC3892i, boolean z) {
        if (bVar == null || bVar.f24612b == IntrinsicsJvm.kt_3.TERMINATED) {
            return abstractRunnableC3892i;
        }
        if (abstractRunnableC3892i.f24636g.mo25704b() == 0 && bVar.f24612b == IntrinsicsJvm.kt_3.BLOCKING) {
            return abstractRunnableC3892i;
        }
        bVar.f24613d = true;
        return bVar.f24611a.m25714a(abstractRunnableC3892i, z);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final IntrinsicsJvm.kt_4 m25670g() {
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof IntrinsicsJvm.kt_4)) {
            threadCurrentThread = null;
        }
        IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) threadCurrentThread;
        if (bVar == null || !Intrinsics.m5299a(CoroutineScheduler.kt.this, this)) {
            return null;
        }
        return bVar;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.f24605c.length();
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            IntrinsicsJvm.kt_4 bVar = this.f24605c.get(i6);
            if (bVar != null) {
                int iM25716b = bVar.f24611a.m25716b();
                int i7 = C3885b.f24618a[bVar.f24612b.ordinal()];
                if (i7 == 1) {
                    i3++;
                } else if (i7 == 2) {
                    i2++;
                    arrayList.add(String.valueOf(iM25716b) + "IntrinsicsJvm.kt_4");
                } else if (i7 == 3) {
                    OplusGLSurfaceView_13++;
                    arrayList.add(String.valueOf(iM25716b) + "IntrinsicsJvm.kt_3");
                } else if (i7 == 4) {
                    i4++;
                    if (iM25716b > 0) {
                        arrayList.add(String.valueOf(iM25716b) + "IntrinsicsJvm.kt_5");
                    }
                } else if (i7 == 5) {
                    i5++;
                }
            }
        }
        long OplusGLSurfaceView_15 = this.controlState;
        return this.f24609h + '@' + DebugStrings.kt.m25579a(this) + "[Pool Size {core = " + this.f24606e + ", max = " + this.f24607f + "}, Worker States {CPU = " + OplusGLSurfaceView_13 + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f24603a.m25860a() + ", global blocking queue size = " + this.f24604b.m25860a() + ", Control State {created workers= " + ((int) (2097151 & OplusGLSurfaceView_15)) + ", blocking tasks = " + ((int) ((4398044413952L & OplusGLSurfaceView_15) >> 21)) + ", CPUs acquired = " + (this.f24606e - ((int) ((OplusGLSurfaceView_15 & 9223367638808264704L) >> 42))) + "}]";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25675a(Tasks.kt_8 abstractRunnableC3892i) {
        TimeSource.kt interfaceC3911bnM25806a;
        try {
            try {
                abstractRunnableC3892i.run();
                interfaceC3911bnM25806a = TimeSource.kt_2.m25806a();
                if (interfaceC3911bnM25806a == null) {
                    return;
                }
            } catch (Throwable th) {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                interfaceC3911bnM25806a = TimeSource.kt_2.m25806a();
                if (interfaceC3911bnM25806a == null) {
                    return;
                }
            }
            interfaceC3911bnM25806a.m25803c();
        } catch (Throwable th2) {
            TimeSource.kt interfaceC3911bnM25806a2 = TimeSource.kt_2.m25806a();
            if (interfaceC3911bnM25806a2 != null) {
                interfaceC3911bnM25806a2.m25803c();
            }
            throw th2;
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    /* renamed from: kotlinx.coroutines.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public final class IntrinsicsJvm.kt_4 extends Thread {

        /* renamed from: IntrinsicsJvm.kt_3 */
        static final AtomicIntegerFieldUpdater f24610c = AtomicIntegerFieldUpdater.newUpdater(IntrinsicsJvm.kt_4.class, "workerCtl");

        /* renamed from: PlatformImplementations.kt_3 */
        public final WorkQueue.kt f24611a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public IntrinsicsJvm.kt_3 f24612b;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean f24613d;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private long f24615f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private long f24616g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private int f24617h;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile int workerCtl;

        private IntrinsicsJvm.kt_4() {
            setDaemon(true);
            this.f24611a = new WorkQueue.kt();
            this.f24612b = IntrinsicsJvm.kt_3.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.kt.f24599i;
            this.f24617h = Random.kt.f5056a.mo5323b();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final int m25692a() {
            return this.indexInArray;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final void m25694a(int OplusGLSurfaceView_13) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.kt.this.f24609h);
            sb.append("-worker-");
            sb.append(OplusGLSurfaceView_13 == 0 ? "TERMINATED" : String.valueOf(OplusGLSurfaceView_13));
            setName(sb.toString());
            this.indexInArray = OplusGLSurfaceView_13;
        }

        public IntrinsicsJvm.kt_4(CoroutineScheduler.kt executorC3884a, int OplusGLSurfaceView_13) {
            this();
            m25694a(OplusGLSurfaceView_13);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final void m25695a(Object obj) {
            this.nextParkedWorker = obj;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final Object m25698b() {
            return this.nextParkedWorker;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final boolean m25683c() {
            boolean z;
            if (this.f24612b == IntrinsicsJvm.kt_3.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler.kt executorC3884a = CoroutineScheduler.kt.this;
            while (true) {
                long OplusGLSurfaceView_15 = executorC3884a.controlState;
                if (((int) ((9223367638808264704L & OplusGLSurfaceView_15) >> 42)) == 0) {
                    z = false;
                    break;
                }
                if (CoroutineScheduler.kt.f24598d.compareAndSet(executorC3884a, OplusGLSurfaceView_15, OplusGLSurfaceView_15 - 4398046511104L)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return false;
            }
            this.f24612b = IntrinsicsJvm.kt_3.CPU_ACQUIRED;
            return true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final boolean m25696a(IntrinsicsJvm.kt_3 cVar) {
            IntrinsicsJvm.kt_3 cVar2 = this.f24612b;
            boolean z = cVar2 == IntrinsicsJvm.kt_3.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.kt.f24598d.addAndGet(CoroutineScheduler.kt.this, 4398046511104L);
            }
            if (cVar2 != cVar) {
                this.f24612b = cVar;
            }
            return z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m25684d();
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final void m25684d() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.kt.this.m25676a() && this.f24612b != IntrinsicsJvm.kt_3.TERMINATED) {
                    Tasks.kt_8 abstractRunnableC3892iM25693a = m25693a(this.f24613d);
                    if (abstractRunnableC3892iM25693a != null) {
                        this.f24616g = 0L;
                        m25679a(abstractRunnableC3892iM25693a);
                    } else {
                        this.f24613d = false;
                        if (this.f24616g == 0) {
                            m25686e();
                        } else if (z) {
                            m25696a(IntrinsicsJvm.kt_3.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f24616g);
                            this.f24616g = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
                break loop0;
            }
            m25696a(IntrinsicsJvm.kt_3.TERMINATED);
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final void m25686e() {
            if (!m25688f()) {
                CoroutineScheduler.kt.this.m25677a(this);
                return;
            }
            if (Debug.kt.m25574a()) {
                if (!(this.f24611a.m25716b() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (m25688f() && !CoroutineScheduler.kt.this.m25676a() && this.f24612b != IntrinsicsJvm.kt_3.TERMINATED) {
                m25696a(IntrinsicsJvm.kt_3.PARKING);
                Thread.interrupted();
                m25689g();
            }
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        private final boolean m25688f() {
            return this.nextParkedWorker != CoroutineScheduler.kt.f24599i;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final void m25682c(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 != 0 && m25696a(IntrinsicsJvm.kt_3.BLOCKING)) {
                CoroutineScheduler.kt.this.m25678b();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final void m25685d(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 0) {
                return;
            }
            CoroutineScheduler.kt.f24598d.addAndGet(CoroutineScheduler.kt.this, -2097152L);
            IntrinsicsJvm.kt_3 cVar = this.f24612b;
            if (cVar != IntrinsicsJvm.kt_3.TERMINATED) {
                if (Debug.kt.m25574a()) {
                    if (!(cVar == IntrinsicsJvm.kt_3.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.f24612b = IntrinsicsJvm.kt_3.DORMANT;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final int m25697b(int OplusGLSurfaceView_13) {
            int i2 = this.f24617h;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.f24617h = i5;
            int i6 = OplusGLSurfaceView_13 - 1;
            return (i6 & OplusGLSurfaceView_13) == 0 ? i6 & i5 : (Integer.MAX_VALUE & i5) % OplusGLSurfaceView_13;
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        private final void m25689g() {
            if (this.f24615f == 0) {
                this.f24615f = System.nanoTime() + CoroutineScheduler.kt.this.f24608g;
            }
            LockSupport.parkNanos(CoroutineScheduler.kt.this.f24608g);
            if (System.nanoTime() - this.f24615f >= 0) {
                this.f24615f = 0L;
                m25690h();
            }
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        private final void m25690h() {
            synchronized (CoroutineScheduler.kt.this.f24605c) {
                if (CoroutineScheduler.kt.this.m25676a()) {
                    return;
                }
                if (CoroutineScheduler.kt.this.m25667d() <= CoroutineScheduler.kt.this.f24606e) {
                    return;
                }
                if (f24610c.compareAndSet(this, -1, 1)) {
                    int OplusGLSurfaceView_13 = this.indexInArray;
                    m25694a(0);
                    CoroutineScheduler.kt.this.m25674a(this, OplusGLSurfaceView_13, 0);
                    int andDecrement = (int) (CoroutineScheduler.kt.f24598d.getAndDecrement(CoroutineScheduler.kt.this) & 2097151);
                    if (andDecrement != OplusGLSurfaceView_13) {
                        IntrinsicsJvm.kt_4 bVar = CoroutineScheduler.kt.this.f24605c.get(andDecrement);
                        Intrinsics.m5296a(bVar);
                        IntrinsicsJvm.kt_4 bVar2 = bVar;
                        CoroutineScheduler.kt.this.f24605c.set(OplusGLSurfaceView_13, bVar2);
                        bVar2.m25694a(OplusGLSurfaceView_13);
                        CoroutineScheduler.kt.this.m25674a(bVar2, andDecrement, OplusGLSurfaceView_13);
                    }
                    CoroutineScheduler.kt.this.f24605c.set(andDecrement, null);
                    Unit.kt c1025s = Unit.kt.f5071a;
                    this.f24612b = IntrinsicsJvm.kt_3.TERMINATED;
                }
            }
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final void m25687e(int OplusGLSurfaceView_13) {
            this.f24615f = 0L;
            if (this.f24612b == IntrinsicsJvm.kt_3.PARKING) {
                if (Debug.kt.m25574a()) {
                    if (!(OplusGLSurfaceView_13 == 1)) {
                        throw new AssertionError();
                    }
                }
                this.f24612b = IntrinsicsJvm.kt_3.BLOCKING;
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final Tasks.kt_8 m25693a(boolean z) {
            Tasks.kt_8 abstractRunnableC3892iC;
            if (m25683c()) {
                return m25680b(z);
            }
            if (!z || (abstractRunnableC3892iC = this.f24611a.m25718c()) == null) {
                abstractRunnableC3892iC = CoroutineScheduler.kt.this.f24604b.m25863c();
            }
            return abstractRunnableC3892iC != null ? abstractRunnableC3892iC : m25681c(true);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Tasks.kt_8 m25680b(boolean z) {
            Tasks.kt_8 abstractRunnableC3892iM25691i;
            Tasks.kt_8 abstractRunnableC3892iM25691i2;
            if (z) {
                boolean z2 = m25697b(CoroutineScheduler.kt.this.f24606e * 2) == 0;
                if (z2 && (abstractRunnableC3892iM25691i2 = m25691i()) != null) {
                    return abstractRunnableC3892iM25691i2;
                }
                Tasks.kt_8 abstractRunnableC3892iM25718c = this.f24611a.m25718c();
                if (abstractRunnableC3892iM25718c != null) {
                    return abstractRunnableC3892iM25718c;
                }
                if (!z2 && (abstractRunnableC3892iM25691i = m25691i()) != null) {
                    return abstractRunnableC3892iM25691i;
                }
            } else {
                Tasks.kt_8 abstractRunnableC3892iM25691i3 = m25691i();
                if (abstractRunnableC3892iM25691i3 != null) {
                    return abstractRunnableC3892iM25691i3;
                }
            }
            return m25681c(false);
        }

        /* renamed from: OplusGLSurfaceView_13 */
        private final Tasks.kt_8 m25691i() {
            if (m25697b(2) == 0) {
                Tasks.kt_8 abstractRunnableC3892iC = CoroutineScheduler.kt.this.f24603a.m25863c();
                return abstractRunnableC3892iC != null ? abstractRunnableC3892iC : CoroutineScheduler.kt.this.f24604b.m25863c();
            }
            Tasks.kt_8 abstractRunnableC3892iC2 = CoroutineScheduler.kt.this.f24604b.m25863c();
            return abstractRunnableC3892iC2 != null ? abstractRunnableC3892iC2 : CoroutineScheduler.kt.this.f24603a.m25863c();
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final Tasks.kt_8 m25681c(boolean z) {
            long jM25713a;
            if (Debug.kt.m25574a()) {
                if (!(this.f24611a.m25716b() == 0)) {
                    throw new AssertionError();
                }
            }
            int iM25667d = CoroutineScheduler.kt.this.m25667d();
            if (iM25667d < 2) {
                return null;
            }
            int iM25697b = m25697b(iM25667d);
            long jMin = Long.MAX_VALUE;
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM25667d; OplusGLSurfaceView_13++) {
                iM25697b++;
                if (iM25697b > iM25667d) {
                    iM25697b = 1;
                }
                IntrinsicsJvm.kt_4 bVar = CoroutineScheduler.kt.this.f24605c.get(iM25697b);
                if (bVar != null && bVar != this) {
                    if (Debug.kt.m25574a()) {
                        if (!(this.f24611a.m25716b() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    if (z) {
                        jM25713a = this.f24611a.m25717b(bVar.f24611a);
                    } else {
                        jM25713a = this.f24611a.m25713a(bVar.f24611a);
                    }
                    if (jM25713a == -1) {
                        return this.f24611a.m25718c();
                    }
                    if (jM25713a > 0) {
                        jMin = Math.min(jMin, jM25713a);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f24616g = jMin;
            return null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private final void m25679a(Tasks.kt_8 abstractRunnableC3892i) {
            int iMo25704b = abstractRunnableC3892i.f24636g.mo25704b();
            m25687e(iMo25704b);
            m25682c(iMo25704b);
            CoroutineScheduler.kt.this.m25675a(abstractRunnableC3892i);
            m25685d(iMo25704b);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final boolean m25665b(Tasks.kt_8 abstractRunnableC3892i) {
        if (abstractRunnableC3892i.f24636g.mo25704b() == 1) {
            return this.f24604b.m25861a(abstractRunnableC3892i);
        }
        return this.f24603a.m25861a(abstractRunnableC3892i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25674a(IntrinsicsJvm.kt_4 bVar, int OplusGLSurfaceView_13, int i2) {
        while (true) {
            long OplusGLSurfaceView_15 = this.parkedWorkersStack;
            int iM25663b = (int) (2097151 & OplusGLSurfaceView_15);
            long j2 = (2097152 + OplusGLSurfaceView_15) & (-2097152);
            if (iM25663b == OplusGLSurfaceView_13) {
                iM25663b = i2 == 0 ? m25663b(bVar) : i2;
            }
            if (iM25663b >= 0 && f24601k.compareAndSet(this, OplusGLSurfaceView_15, j2 | iM25663b)) {
                return;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final IntrinsicsJvm.kt_4 m25666c() {
        while (true) {
            long OplusGLSurfaceView_15 = this.parkedWorkersStack;
            IntrinsicsJvm.kt_4 bVar = this.f24605c.get((int) (2097151 & OplusGLSurfaceView_15));
            if (bVar == null) {
                return null;
            }
            long j2 = (2097152 + OplusGLSurfaceView_15) & (-2097152);
            int iM25663b = m25663b(bVar);
            if (iM25663b >= 0 && f24601k.compareAndSet(this, OplusGLSurfaceView_15, iM25663b | j2)) {
                bVar.m25695a(f24599i);
                return bVar;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final void m25661a(boolean z) {
        long jAddAndGet = f24598d.addAndGet(this, 2097152L);
        if (z || m25668e() || m25664b(jAddAndGet)) {
            return;
        }
        m25668e();
    }
}
