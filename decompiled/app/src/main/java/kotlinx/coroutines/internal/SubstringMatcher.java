package kotlinx.coroutines.internal;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes2.dex */
public final class k_renamed<E_renamed> {
    private volatile java.lang.Object _next;
    private volatile long _state;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f7876c;
    private java.util.concurrent.atomic.AtomicReferenceArray f_renamed;
    private final int g_renamed;
    private final boolean h_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.k_renamed.a_renamed f7875b = new kotlinx.coroutines.internal.k_renamed.a_renamed(null);

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.r_renamed f7874a = new kotlinx.coroutines.internal.r_renamed("REMOVE_FROZEN");
    private static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater d_renamed = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.k_renamed.class, java.lang.Object.class, "_next");
    private static final java.util.concurrent.atomic.AtomicLongFieldUpdater e_renamed = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.internal.k_renamed.class, "_state");

    public k_renamed(int i_renamed, boolean z_renamed) {
        this.g_renamed = i_renamed;
        this.h_renamed = z_renamed;
        int i2 = this.g_renamed;
        this.f7876c = i2 - 1;
        this._next = null;
        this._state = 0L;
        this.f_renamed = new java.util.concurrent.atomic.AtomicReferenceArray(i2);
        if (!(this.f7876c <= 1073741823)) {
            throw new java.lang.IllegalStateException("Check failed.".toString());
        }
        if (!((this.f7876c & this.g_renamed) == 0)) {
            throw new java.lang.IllegalStateException("Check failed.".toString());
        }
    }

    public final boolean a_renamed() {
        kotlinx.coroutines.internal.k_renamed.a_renamed aVar = f7875b;
        long j_renamed = this._state;
        return ((int) ((1073741823 & j_renamed) >> 0)) == ((int) ((j_renamed & 1152921503533105152L) >> 30));
    }

    public final int b_renamed() {
        kotlinx.coroutines.internal.k_renamed.a_renamed aVar = f7875b;
        long j_renamed = this._state;
        return 1073741823 & (((int) ((j_renamed & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j_renamed) >> 0)));
    }

    private final kotlinx.coroutines.internal.k_renamed<E_renamed> a_renamed(int i_renamed, E_renamed e2) {
        java.lang.Object obj = this.f_renamed.get(this.f7876c & i_renamed);
        if (!(obj instanceof kotlinx.coroutines.internal.k_renamed.b_renamed) || ((kotlinx.coroutines.internal.k_renamed.b_renamed) obj).f7877a != i_renamed) {
            return null;
        }
        this.f_renamed.set(i_renamed & this.f7876c, e2);
        return this;
    }

    public final kotlinx.coroutines.internal.k_renamed<E_renamed> e_renamed() {
        return a_renamed(f_renamed());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final kotlinx.coroutines.internal.k_renamed<E_renamed> b_renamed(long j_renamed) {
        kotlinx.coroutines.internal.k_renamed<E_renamed> kVar = new kotlinx.coroutines.internal.k_renamed<>(this.g_renamed * 2, this.h_renamed);
        kotlinx.coroutines.internal.k_renamed.a_renamed aVar = f7875b;
        int i_renamed = (int) ((1073741823 & j_renamed) >> 0);
        int i2 = (int) ((1152921503533105152L & j_renamed) >> 30);
        while (true) {
            int i3 = this.f7876c;
            if ((i_renamed & i3) != (i2 & i3)) {
                java.lang.Object bVar = this.f_renamed.get(i3 & i_renamed);
                if (bVar == null) {
                    bVar = new kotlinx.coroutines.internal.k_renamed.b_renamed(i_renamed);
                }
                kVar.f_renamed.set(kVar.f7876c & i_renamed, bVar);
                i_renamed++;
            } else {
                kVar._state = f7875b.a_renamed(j_renamed, 1152921504606846976L);
                return kVar;
            }
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    public static final class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final int f7877a;

        public b_renamed(int i_renamed) {
            this.f7877a = i_renamed;
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    public static final class a_renamed {
        public final int a_renamed(long j_renamed) {
            return (j_renamed & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long a_renamed(long j_renamed, long j2) {
            return j_renamed & (~j2);
        }

        private a_renamed() {
        }

        public /* synthetic */ a_renamed(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }

        public final long a_renamed(long j_renamed, int i_renamed) {
            return a_renamed(j_renamed, 1073741823L) | (i_renamed << 0);
        }

        public final long b_renamed(long j_renamed, int i_renamed) {
            return a_renamed(j_renamed, 1152921503533105152L) | (i_renamed << 30);
        }
    }

    public final boolean c_renamed() {
        long j_renamed;
        do {
            j_renamed = this._state;
            if ((j_renamed & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j_renamed) != 0) {
                return false;
            }
        } while (!e_renamed.compareAndSet(this, j_renamed, j_renamed | 2305843009213693952L));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:17:0x004e, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a_renamed(E_renamed r13) {
        /*
            r12 = this;
        L0:
            long r2 = r12._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 == 0) goto L12
            kotlinx.coroutines.internal.k_renamed$a_renamed r12 = kotlinx.coroutines.internal.k_renamed.f7875b
            int r12 = r12.a_renamed(r2)
            return r12
        L12:
            kotlinx.coroutines.internal.k_renamed$a_renamed r0 = kotlinx.coroutines.internal.k_renamed.f7875b
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
            int r10 = r12.f7876c
            int r1 = r9 + 2
            r1 = r1 & r10
            r4 = r0 & r10
            r5 = 1
            if (r1 != r4) goto L30
            return r5
        L30:
            boolean r1 = r12.h_renamed
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r12.f_renamed
            r11 = r9 & r10
            java.lang.Object r1 = r1.get(r11)
            if (r1 == 0) goto L4f
            int r1 = r12.g_renamed
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
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.k_renamed.e_renamed
            kotlinx.coroutines.internal.k_renamed$a_renamed r4 = kotlinx.coroutines.internal.k_renamed.f7875b
            long r4 = r4.b_renamed(r2, r0)
            r0 = r1
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f_renamed
            r1 = r9 & r10
            r0.set(r1, r13)
            kotlinx.coroutines.internal.k_renamed r12 = (kotlinx.coroutines.internal.k_renamed) r12
        L6b:
            long r0 = r12._state
            r2 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r0 = r0 & r2
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 != 0) goto L75
            goto L80
        L75:
            kotlinx.coroutines.internal.k_renamed r12 = r12.e_renamed()
            kotlinx.coroutines.internal.k_renamed r12 = r12.a_renamed(r9, r13)
            if (r12 == 0) goto L80
            goto L6b
        L80:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.k_renamed.a_renamed(java.lang.Object):int");
    }

    public final java.lang.Object d_renamed() {
        while (true) {
            long j_renamed = this._state;
            if ((1152921504606846976L & j_renamed) != 0) {
                return f7874a;
            }
            kotlinx.coroutines.internal.k_renamed.a_renamed aVar = f7875b;
            int i_renamed = (int) ((1073741823 & j_renamed) >> 0);
            int i2 = this.f7876c;
            if ((((int) ((1152921503533105152L & j_renamed) >> 30)) & i2) == (i_renamed & i2)) {
                return null;
            }
            java.lang.Object obj = this.f_renamed.get(i2 & i_renamed);
            if (obj == null) {
                if (this.h_renamed) {
                    return null;
                }
            } else {
                if (obj instanceof kotlinx.coroutines.internal.k_renamed.b_renamed) {
                    return null;
                }
                int i3 = (i_renamed + 1) & 1073741823;
                if (e_renamed.compareAndSet(this, j_renamed, f7875b.a_renamed(j_renamed, i3))) {
                    this.f_renamed.set(this.f7876c & i_renamed, null);
                    return obj;
                }
                if (this.h_renamed) {
                    kotlinx.coroutines.internal.k_renamed<E_renamed> kVarA = this;
                    do {
                        kVarA = kVarA.a_renamed(i_renamed, i3);
                    } while (kVarA != null);
                    return obj;
                }
            }
        }
    }

    private final kotlinx.coroutines.internal.k_renamed<E_renamed> a_renamed(int i_renamed, int i2) {
        long j_renamed;
        int i3;
        do {
            j_renamed = this._state;
            kotlinx.coroutines.internal.k_renamed.a_renamed aVar = f7875b;
            i3 = (int) ((1073741823 & j_renamed) >> 0);
            if (kotlinx.coroutines.ac_renamed.a_renamed()) {
                if (!(i3 == i_renamed)) {
                    throw new java.lang.AssertionError();
                }
            }
            if ((1152921504606846976L & j_renamed) != 0) {
                return e_renamed();
            }
        } while (!e_renamed.compareAndSet(this, j_renamed, f7875b.a_renamed(j_renamed, i2)));
        this.f_renamed.set(this.f7876c & i3, null);
        return null;
    }

    private final long f_renamed() {
        long j_renamed;
        long j2;
        do {
            j_renamed = this._state;
            if ((j_renamed & 1152921504606846976L) != 0) {
                return j_renamed;
            }
            j2 = j_renamed | 1152921504606846976L;
        } while (!e_renamed.compareAndSet(this, j_renamed, j2));
        return j2;
    }

    private final kotlinx.coroutines.internal.k_renamed<E_renamed> a_renamed(long j_renamed) {
        while (true) {
            kotlinx.coroutines.internal.k_renamed<E_renamed> kVar = (kotlinx.coroutines.internal.k_renamed) this._next;
            if (kVar != null) {
                return kVar;
            }
            d_renamed.compareAndSet(this, null, b_renamed(j_renamed));
        }
    }
}
