package kotlinx.coroutines.internal;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes2.dex */
public class i_renamed {
    volatile java.lang.Object _next = this;
    volatile java.lang.Object _prev = this;
    private volatile java.lang.Object _removedRef = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater f7872c = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.i_renamed.class, java.lang.Object.class, "_next");
    static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater d_renamed = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.i_renamed.class, java.lang.Object.class, "_prev");

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater f7871a = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.i_renamed.class, java.lang.Object.class, "_removedRef");

    private final kotlinx.coroutines.internal.p_renamed i_renamed() {
        kotlinx.coroutines.internal.p_renamed pVar = (kotlinx.coroutines.internal.p_renamed) this._removedRef;
        if (pVar != null) {
            return pVar;
        }
        kotlinx.coroutines.internal.p_renamed pVar2 = new kotlinx.coroutines.internal.p_renamed(this);
        f7871a.lazySet(this, pVar2);
        return pVar2;
    }

    /* compiled from: LockFreeLinkedList.kt */
    public static abstract class a_renamed extends kotlinx.coroutines.internal.c_renamed<kotlinx.coroutines.internal.i_renamed> {
        public kotlinx.coroutines.internal.i_renamed d_renamed;
        public final kotlinx.coroutines.internal.i_renamed e_renamed;

        public a_renamed(kotlinx.coroutines.internal.i_renamed iVar) {
            this.e_renamed = iVar;
        }

        @Override // kotlinx.coroutines.internal.c_renamed
        public void a_renamed(kotlinx.coroutines.internal.i_renamed iVar, java.lang.Object obj) {
            boolean z_renamed = obj == null;
            kotlinx.coroutines.internal.i_renamed iVar2 = z_renamed ? this.e_renamed : this.d_renamed;
            if (iVar2 != null && kotlinx.coroutines.internal.i_renamed.f7872c.compareAndSet(iVar, this, iVar2) && z_renamed) {
                kotlinx.coroutines.internal.i_renamed iVar3 = this.e_renamed;
                kotlinx.coroutines.internal.i_renamed iVar4 = this.d_renamed;
                c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(iVar4);
                iVar3.c_renamed(iVar4);
            }
        }
    }

    public boolean d_renamed() {
        return e_renamed() instanceof kotlinx.coroutines.internal.p_renamed;
    }

    public final kotlinx.coroutines.internal.i_renamed f_renamed() {
        return kotlinx.coroutines.internal.h_renamed.a_renamed(e_renamed());
    }

    public final kotlinx.coroutines.internal.i_renamed g_renamed() {
        kotlinx.coroutines.internal.i_renamed iVarA = a_renamed((kotlinx.coroutines.internal.o_renamed) null);
        return iVarA != null ? iVarA : b_renamed((kotlinx.coroutines.internal.i_renamed) this._prev);
    }

    private final kotlinx.coroutines.internal.i_renamed b_renamed(kotlinx.coroutines.internal.i_renamed iVar) {
        while (iVar.d_renamed()) {
            iVar = (kotlinx.coroutines.internal.i_renamed) iVar._prev;
        }
        return iVar;
    }

    public final boolean a_renamed(kotlinx.coroutines.internal.i_renamed iVar) {
        d_renamed.lazySet(iVar, this);
        f7872c.lazySet(iVar, this);
        while (e_renamed() == this) {
            if (f7872c.compareAndSet(this, this, iVar)) {
                iVar.c_renamed(this);
                return true;
            }
        }
        return false;
    }

    public final int a_renamed(kotlinx.coroutines.internal.i_renamed iVar, kotlinx.coroutines.internal.i_renamed iVar2, kotlinx.coroutines.internal.i_renamed.a_renamed aVar) {
        d_renamed.lazySet(iVar, this);
        f7872c.lazySet(iVar, iVar2);
        aVar.d_renamed = iVar2;
        if (f7872c.compareAndSet(this, iVar2, aVar)) {
            return aVar.c_renamed(this) == null ? 1 : 2;
        }
        return 0;
    }

    public boolean c_renamed() {
        return h_renamed() == null;
    }

    public final kotlinx.coroutines.internal.i_renamed h_renamed() {
        java.lang.Object objE;
        kotlinx.coroutines.internal.i_renamed iVar;
        do {
            objE = e_renamed();
            if (objE instanceof kotlinx.coroutines.internal.p_renamed) {
                return ((kotlinx.coroutines.internal.p_renamed) objE).f7883a;
            }
            if (objE == this) {
                return (kotlinx.coroutines.internal.i_renamed) objE;
            }
            if (objE != null) {
                iVar = (kotlinx.coroutines.internal.i_renamed) objE;
            } else {
                throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!f7872c.compareAndSet(this, objE, iVar.i_renamed()));
        iVar.a_renamed((kotlinx.coroutines.internal.o_renamed) null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:28:0x004e, code lost:
    
        if (kotlinx.coroutines.internal.i_renamed.f7872c.compareAndSet(r4, r3, ((kotlinx.coroutines.internal.p_renamed) r5).f7883a) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlinx.coroutines.internal.i_renamed a_renamed(kotlinx.coroutines.internal.o_renamed r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.i_renamed r0 = (kotlinx.coroutines.internal.i_renamed) r0
            r1 = 0
            r2 = r1
            kotlinx.coroutines.internal.i_renamed r2 = (kotlinx.coroutines.internal.i_renamed) r2
            r3 = r0
        L9:
            r4 = r2
        La:
            java.lang.Object r5 = r3._next
            r6 = r7
            kotlinx.coroutines.internal.i_renamed r6 = (kotlinx.coroutines.internal.i_renamed) r6
            if (r5 != r6) goto L1e
            if (r0 != r3) goto L14
            return r3
        L14:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.i_renamed.d_renamed
            boolean r0 = r1.compareAndSet(r7, r0, r3)
            if (r0 != 0) goto L1d
            goto L0
        L1d:
            return r3
        L1e:
            boolean r6 = r7.d_renamed()
            if (r6 == 0) goto L25
            return r1
        L25:
            if (r5 != r8) goto L28
            return r3
        L28:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.o_renamed
            if (r6 == 0) goto L3e
            if (r8 == 0) goto L38
            r0 = r5
            kotlinx.coroutines.internal.o_renamed r0 = (kotlinx.coroutines.internal.o_renamed) r0
            boolean r0 = r8.a_renamed(r0)
            if (r0 == 0) goto L38
            return r1
        L38:
            kotlinx.coroutines.internal.o_renamed r5 = (kotlinx.coroutines.internal.o_renamed) r5
            r5.c_renamed(r3)
            goto L0
        L3e:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.p_renamed
            if (r6 == 0) goto L58
            if (r4 == 0) goto L53
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = kotlinx.coroutines.internal.i_renamed.f7872c
            kotlinx.coroutines.internal.p_renamed r5 = (kotlinx.coroutines.internal.p_renamed) r5
            kotlinx.coroutines.internal.i_renamed r5 = r5.f7883a
            boolean r3 = r6.compareAndSet(r4, r3, r5)
            if (r3 != 0) goto L51
            goto L0
        L51:
            r3 = r4
            goto L9
        L53:
            java.lang.Object r3 = r3._prev
            kotlinx.coroutines.internal.i_renamed r3 = (kotlinx.coroutines.internal.i_renamed) r3
            goto La
        L58:
            if (r5 == 0) goto L5f
            kotlinx.coroutines.internal.i_renamed r5 = (kotlinx.coroutines.internal.i_renamed) r5
            r4 = r3
            r3 = r5
            goto La
        L5f:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
        */
        //  java.lang.String r8 = "null cannot be_renamed cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.i_renamed.a_renamed(kotlinx.coroutines.internal.o_renamed):kotlinx.coroutines.internal.i_renamed");
    }

    public java.lang.String toString() {
        return getClass().getSimpleName() + '@' + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this));
    }

    public final java.lang.Object e_renamed() {
        while (true) {
            java.lang.Object obj = this._next;
            if (!(obj instanceof kotlinx.coroutines.internal.o_renamed)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.o_renamed) obj).c_renamed(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c_renamed(kotlinx.coroutines.internal.i_renamed iVar) {
        kotlinx.coroutines.internal.i_renamed iVar2;
        do {
            iVar2 = (kotlinx.coroutines.internal.i_renamed) iVar._prev;
            if (e_renamed() != iVar) {
                return;
            }
        } while (!d_renamed.compareAndSet(iVar, iVar2, this));
        if (d_renamed()) {
            iVar.a_renamed((kotlinx.coroutines.internal.o_renamed) null);
        }
    }
}
