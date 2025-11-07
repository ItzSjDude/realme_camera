package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.Debug.kt;
import p061c.p070f.p072b.DefaultConstructorMarker;

/* compiled from: LockFreeTaskQueue.kt */
/* renamed from: kotlinx.coroutines.internal.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public final class LockFreeTaskQueue.kt_2<E> {
    private volatile Object _next;
    private volatile long _state;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f24703c;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private AtomicReferenceArray f24704f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final int f24705g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final boolean f24706h;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final PlatformImplementations.kt_3 f24700b = new PlatformImplementations.kt_3(null);

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Symbol.kt f24699a = new Symbol.kt("REMOVE_FROZEN");

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final AtomicReferenceFieldUpdater f24701d = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.kt_2.class, Object.class, "_next");

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final AtomicLongFieldUpdater f24702e = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueue.kt_2.class, "_state");

    public LockFreeTaskQueue.kt_2(int OplusGLSurfaceView_13, boolean z) {
        this.f24705g = OplusGLSurfaceView_13;
        this.f24706h = z;
        int i2 = this.f24705g;
        this.f24703c = i2 - 1;
        this._next = null;
        this._state = 0L;
        this.f24704f = new AtomicReferenceArray(i2);
        if (!(this.f24703c <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((this.f24703c & this.f24705g) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m25870a() {
        PlatformImplementations.kt_3 aVar = f24700b;
        long OplusGLSurfaceView_15 = this._state;
        return ((int) ((1073741823 & OplusGLSurfaceView_15) >> 0)) == ((int) ((OplusGLSurfaceView_15 & 1152921503533105152L) >> 30));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final int m25871b() {
        PlatformImplementations.kt_3 aVar = f24700b;
        long OplusGLSurfaceView_15 = this._state;
        return 1073741823 & (((int) ((OplusGLSurfaceView_15 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & OplusGLSurfaceView_15) >> 0)));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final LockFreeTaskQueue.kt_2<E> m25865a(int OplusGLSurfaceView_13, E COUIBaseListPopupWindow_8) {
        Object obj = this.f24704f.get(this.f24703c & OplusGLSurfaceView_13);
        if (!(obj instanceof IntrinsicsJvm.kt_4) || ((IntrinsicsJvm.kt_4) obj).f24707a != OplusGLSurfaceView_13) {
            return null;
        }
        this.f24704f.set(OplusGLSurfaceView_13 & this.f24703c, COUIBaseListPopupWindow_8);
        return this;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final LockFreeTaskQueue.kt_2<E> m25874e() {
        return m25866a(m25868f());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_4 */
    private final LockFreeTaskQueue.kt_2<E> m25867b(long OplusGLSurfaceView_15) {
        LockFreeTaskQueue.kt_2<E> c3933k = new LockFreeTaskQueue.kt_2<>(this.f24705g * 2, this.f24706h);
        PlatformImplementations.kt_3 aVar = f24700b;
        int OplusGLSurfaceView_13 = (int) ((1073741823 & OplusGLSurfaceView_15) >> 0);
        int i2 = (int) ((1152921503533105152L & OplusGLSurfaceView_15) >> 30);
        while (true) {
            int i3 = this.f24703c;
            if ((OplusGLSurfaceView_13 & i3) != (i2 & i3)) {
                Object bVar = this.f24704f.get(i3 & OplusGLSurfaceView_13);
                if (bVar == null) {
                    bVar = new IntrinsicsJvm.kt_4(OplusGLSurfaceView_13);
                }
                c3933k.f24704f.set(c3933k.f24703c & OplusGLSurfaceView_13, bVar);
                OplusGLSurfaceView_13++;
            } else {
                c3933k._state = f24700b.m25877a(OplusGLSurfaceView_15, 1152921504606846976L);
                return c3933k;
            }
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    /* renamed from: kotlinx.coroutines.internal.OplusGLSurfaceView_5$IntrinsicsJvm.kt_4 */
    public static final class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final int f24707a;

        public IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13) {
            this.f24707a = OplusGLSurfaceView_13;
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    /* renamed from: kotlinx.coroutines.internal.OplusGLSurfaceView_5$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        public final int m25875a(long OplusGLSurfaceView_15) {
            return (OplusGLSurfaceView_15 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final long m25877a(long OplusGLSurfaceView_15, long j2) {
            return OplusGLSurfaceView_15 & (~j2);
        }

        private PlatformImplementations.kt_3() {
        }

        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final long m25876a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
            return m25877a(OplusGLSurfaceView_15, 1073741823L) | (OplusGLSurfaceView_13 << 0);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final long m25878b(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
            return m25877a(OplusGLSurfaceView_15, 1152921503533105152L) | (OplusGLSurfaceView_13 << 30);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final boolean m25872c() {
        long OplusGLSurfaceView_15;
        do {
            OplusGLSurfaceView_15 = this._state;
            if ((OplusGLSurfaceView_15 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & OplusGLSurfaceView_15) != 0) {
                return false;
            }
        } while (!f24702e.compareAndSet(this, OplusGLSurfaceView_15, OplusGLSurfaceView_15 | 2305843009213693952L));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
    
        return 1;
     */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m25869a(E r13) {
        /*
            r12 = this;
        L0:
            long r2 = r12._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 == 0) goto L12
            kotlinx.coroutines.internal.OplusGLSurfaceView_5$PlatformImplementations.kt_3 r12 = kotlinx.coroutines.internal.LockFreeTaskQueue.kt_2.f24700b
            int r12 = r12.m25875a(r2)
            return r12
        L12:
            kotlinx.coroutines.internal.OplusGLSurfaceView_5$PlatformImplementations.kt_3 r0 = kotlinx.coroutines.internal.LockFreeTaskQueue.kt_2.f24700b
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            r8 = 0
            long r0 = r0 >> r8
            int r0 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r1 = 30
            long r4 = r4 >> r1
            int r9 = (int) r4
            int r10 = r12.f24703c
            int r1 = r9 + 2
            r1 = r1 & r10
            r4 = r0 & r10
            r5 = 1
            if (r1 != r4) goto L30
            return r5
        L30:
            boolean r1 = r12.f24706h
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r12.f24704f
            r11 = r9 & r10
            java.lang.Object r1 = r1.get(r11)
            if (r1 == 0) goto L4f
            int r1 = r12.f24705g
            r2 = 1024(0x400, float:1.435E-42)
            if (r1 < r2) goto L4e
            int r9 = r9 - r0
            r0 = r9 & r4
            int r1 = r1 >> 1
            if (r0 <= r1) goto L0
        L4e:
            return r5
        L4f:
            int r0 = r9 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.LockFreeTaskQueue.kt_2.f24702e
            kotlinx.coroutines.internal.OplusGLSurfaceView_5$PlatformImplementations.kt_3 r4 = kotlinx.coroutines.internal.LockFreeTaskQueue.kt_2.f24700b
            long r4 = r4.m25878b(r2, r0)
            r0 = r1
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f24704f
            r1 = r9 & r10
            r0.set(r1, r13)
            kotlinx.coroutines.internal.OplusGLSurfaceView_5 r12 = (kotlinx.coroutines.internal.LockFreeTaskQueue.kt_2) r12
        L6b:
            long r0 = r12._state
            r2 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r0 = r0 & r2
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 != 0) goto L75
            goto L80
        L75:
            kotlinx.coroutines.internal.OplusGLSurfaceView_5 r12 = r12.m25874e()
            kotlinx.coroutines.internal.OplusGLSurfaceView_5 r12 = r12.m25865a(r9, r13)
            if (r12 == 0) goto L80
            goto L6b
        L80:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeTaskQueue.kt_2.m25869a(java.lang.Object):int");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final Object m25873d() {
        while (true) {
            long OplusGLSurfaceView_15 = this._state;
            if ((1152921504606846976L & OplusGLSurfaceView_15) != 0) {
                return f24699a;
            }
            PlatformImplementations.kt_3 aVar = f24700b;
            int OplusGLSurfaceView_13 = (int) ((1073741823 & OplusGLSurfaceView_15) >> 0);
            int i2 = this.f24703c;
            if ((((int) ((1152921503533105152L & OplusGLSurfaceView_15) >> 30)) & i2) == (OplusGLSurfaceView_13 & i2)) {
                return null;
            }
            Object obj = this.f24704f.get(i2 & OplusGLSurfaceView_13);
            if (obj == null) {
                if (this.f24706h) {
                    return null;
                }
            } else {
                if (obj instanceof IntrinsicsJvm.kt_4) {
                    return null;
                }
                int i3 = (OplusGLSurfaceView_13 + 1) & 1073741823;
                if (f24702e.compareAndSet(this, OplusGLSurfaceView_15, f24700b.m25876a(OplusGLSurfaceView_15, i3))) {
                    this.f24704f.set(this.f24703c & OplusGLSurfaceView_13, null);
                    return obj;
                }
                if (this.f24706h) {
                    LockFreeTaskQueue.kt_2<E> c3933kM25864a = this;
                    do {
                        c3933kM25864a = c3933kM25864a.m25864a(OplusGLSurfaceView_13, i3);
                    } while (c3933kM25864a != null);
                    return obj;
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final LockFreeTaskQueue.kt_2<E> m25864a(int OplusGLSurfaceView_13, int i2) {
        long OplusGLSurfaceView_15;
        int i3;
        do {
            OplusGLSurfaceView_15 = this._state;
            PlatformImplementations.kt_3 aVar = f24700b;
            i3 = (int) ((1073741823 & OplusGLSurfaceView_15) >> 0);
            if (Debug.kt.m25574a()) {
                if (!(i3 == OplusGLSurfaceView_13)) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & OplusGLSurfaceView_15) != 0) {
                return m25874e();
            }
        } while (!f24702e.compareAndSet(this, OplusGLSurfaceView_15, f24700b.m25876a(OplusGLSurfaceView_15, i2)));
        this.f24704f.set(this.f24703c & i3, null);
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final long m25868f() {
        long OplusGLSurfaceView_15;
        long j2;
        do {
            OplusGLSurfaceView_15 = this._state;
            if ((OplusGLSurfaceView_15 & 1152921504606846976L) != 0) {
                return OplusGLSurfaceView_15;
            }
            j2 = OplusGLSurfaceView_15 | 1152921504606846976L;
        } while (!f24702e.compareAndSet(this, OplusGLSurfaceView_15, j2));
        return j2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final LockFreeTaskQueue.kt_2<E> m25866a(long OplusGLSurfaceView_15) {
        while (true) {
            LockFreeTaskQueue.kt_2<E> c3933k = (LockFreeTaskQueue.kt_2) this._next;
            if (c3933k != null) {
                return c3933k;
            }
            f24701d.compareAndSet(this, null, m25867b(OplusGLSurfaceView_15));
        }
    }
}
