package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: LockFreeLinkedList.kt */
/* renamed from: kotlinx.coroutines.internal.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class LockFreeLinkedList.kt {
    volatile Object _next = this;
    volatile Object _prev = this;
    private volatile Object _removedRef = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    static final AtomicReferenceFieldUpdater f24694c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedList.kt.class, Object.class, "_next");

    /* renamed from: IntrinsicsJvm.kt_5 */
    static final AtomicReferenceFieldUpdater f24695d = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedList.kt.class, Object.class, "_prev");

    /* renamed from: PlatformImplementations.kt_3 */
    private static final AtomicReferenceFieldUpdater f24693a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedList.kt.class, Object.class, "_removedRef");

    /* renamed from: OplusGLSurfaceView_13 */
    private final LockFreeLinkedList.kt_4 m25853i() {
        LockFreeLinkedList.kt_4 c3938p = (LockFreeLinkedList.kt_4) this._removedRef;
        if (c3938p != null) {
            return c3938p;
        }
        LockFreeLinkedList.kt_4 c3938p2 = new LockFreeLinkedList.kt_4(this);
        f24693a.lazySet(this, c3938p2);
        return c3938p2;
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* renamed from: kotlinx.coroutines.internal.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    public static abstract class PlatformImplementations.kt_3 extends Atomic.kt<LockFreeLinkedList.kt> {

        /* renamed from: IntrinsicsJvm.kt_5 */
        public LockFreeLinkedList.kt f24696d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public final LockFreeLinkedList.kt f24697e;

        public PlatformImplementations.kt_3(LockFreeLinkedList.kt c3931i) {
            this.f24697e = c3931i;
        }

        @Override // kotlinx.coroutines.internal.Atomic.kt
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo25829a(LockFreeLinkedList.kt c3931i, Object obj) {
            boolean z = obj == null;
            LockFreeLinkedList.kt c3931i2 = z ? this.f24697e : this.f24696d;
            if (c3931i2 != null && LockFreeLinkedList.kt.f24694c.compareAndSet(c3931i, this, c3931i2) && z) {
                LockFreeLinkedList.kt c3931i3 = this.f24697e;
                LockFreeLinkedList.kt c3931i4 = this.f24696d;
                Intrinsics.m5296a(c3931i4);
                c3931i3.m25852c(c3931i4);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean mo25846d() {
        return m25856e() instanceof LockFreeLinkedList.kt_4;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public final LockFreeLinkedList.kt m25857f() {
        return LockFreeLinkedList.kt_3.m25848a(m25856e());
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public final LockFreeLinkedList.kt m25858g() {
        LockFreeLinkedList.kt c3931iM25849a = m25849a((Atomic.kt_3) null);
        return c3931iM25849a != null ? c3931iM25849a : m25851b((LockFreeLinkedList.kt) this._prev);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final LockFreeLinkedList.kt m25851b(LockFreeLinkedList.kt c3931i) {
        while (c3931i.mo25846d()) {
            c3931i = (LockFreeLinkedList.kt) c3931i._prev;
        }
        return c3931i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m25855a(LockFreeLinkedList.kt c3931i) {
        f24695d.lazySet(c3931i, this);
        f24694c.lazySet(c3931i, this);
        while (m25856e() == this) {
            if (f24694c.compareAndSet(this, this, c3931i)) {
                c3931i.m25852c(this);
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final int m25854a(LockFreeLinkedList.kt c3931i, LockFreeLinkedList.kt c3931i2, PlatformImplementations.kt_3 aVar) {
        f24695d.lazySet(c3931i, this);
        f24694c.lazySet(c3931i, c3931i2);
        aVar.f24696d = c3931i2;
        if (f24694c.compareAndSet(this, c3931i2, aVar)) {
            return aVar.mo25832c(this) == null ? 1 : 2;
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo25845c() {
        return m25859h() == null;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public final LockFreeLinkedList.kt m25859h() {
        Object objM25856e;
        LockFreeLinkedList.kt c3931i;
        do {
            objM25856e = m25856e();
            if (objM25856e instanceof LockFreeLinkedList.kt_4) {
                return ((LockFreeLinkedList.kt_4) objM25856e).f24714a;
            }
            if (objM25856e == this) {
                return (LockFreeLinkedList.kt) objM25856e;
            }
            if (objM25856e != null) {
                c3931i = (LockFreeLinkedList.kt) objM25856e;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!f24694c.compareAndSet(this, objM25856e, c3931i.m25853i()));
        c3931i.m25849a((Atomic.kt_3) null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
    
        if (kotlinx.coroutines.internal.LockFreeLinkedList.kt.f24694c.compareAndSet(r4, r3, ((kotlinx.coroutines.internal.LockFreeLinkedList.kt_4) r5).f24714a) != false) goto L30;
     */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlinx.coroutines.internal.LockFreeLinkedList.kt m25849a(kotlinx.coroutines.internal.Atomic.kt_3 r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.OplusGLSurfaceView_13 r0 = (kotlinx.coroutines.internal.LockFreeLinkedList.kt) r0
            r1 = 0
            r2 = r1
            kotlinx.coroutines.internal.OplusGLSurfaceView_13 r2 = (kotlinx.coroutines.internal.LockFreeLinkedList.kt) r2
            r3 = r0
        L9:
            r4 = r2
        La:
            java.lang.Object r5 = r3._next
            r6 = r7
            kotlinx.coroutines.internal.OplusGLSurfaceView_13 r6 = (kotlinx.coroutines.internal.LockFreeLinkedList.kt) r6
            if (r5 != r6) goto L1e
            if (r0 != r3) goto L14
            return r3
        L14:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.LockFreeLinkedList.kt.f24695d
            boolean r0 = r1.compareAndSet(r7, r0, r3)
            if (r0 != 0) goto L1d
            goto L0
        L1d:
            return r3
        L1e:
            boolean r6 = r7.mo25846d()
            if (r6 == 0) goto L25
            return r1
        L25:
            if (r5 != r8) goto L28
            return r3
        L28:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.Atomic.kt_3
            if (r6 == 0) goto L3e
            if (r8 == 0) goto L38
            r0 = r5
            kotlinx.coroutines.internal.o r0 = (kotlinx.coroutines.internal.Atomic.kt_3) r0
            boolean r0 = r8.m25886a(r0)
            if (r0 == 0) goto L38
            return r1
        L38:
            kotlinx.coroutines.internal.o r5 = (kotlinx.coroutines.internal.Atomic.kt_3) r5
            r5.mo25832c(r3)
            goto L0
        L3e:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.LockFreeLinkedList.kt_4
            if (r6 == 0) goto L58
            if (r4 == 0) goto L53
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = kotlinx.coroutines.internal.LockFreeLinkedList.kt.f24694c
            kotlinx.coroutines.internal.p r5 = (kotlinx.coroutines.internal.LockFreeLinkedList.kt_4) r5
            kotlinx.coroutines.internal.OplusGLSurfaceView_13 r5 = r5.f24714a
            boolean r3 = r6.compareAndSet(r4, r3, r5)
            if (r3 != 0) goto L51
            goto L0
        L51:
            r3 = r4
            goto L9
        L53:
            java.lang.Object r3 = r3._prev
            kotlinx.coroutines.internal.OplusGLSurfaceView_13 r3 = (kotlinx.coroutines.internal.LockFreeLinkedList.kt) r3
            goto La
        L58:
            if (r5 == 0) goto L5f
            kotlinx.coroutines.internal.OplusGLSurfaceView_13 r5 = (kotlinx.coroutines.internal.LockFreeLinkedList.kt) r5
            r4 = r3
            r3 = r5
            goto La
        L5f:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
        */
        //  java.lang.String r8 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedList.kt.m25849a(kotlinx.coroutines.internal.o):kotlinx.coroutines.internal.OplusGLSurfaceView_13");
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final Object m25856e() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof Atomic.kt_3)) {
                return obj;
            }
            ((Atomic.kt_3) obj).mo25832c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public final void m25852c(LockFreeLinkedList.kt c3931i) {
        LockFreeLinkedList.kt c3931i2;
        do {
            c3931i2 = (LockFreeLinkedList.kt) c3931i._prev;
            if (m25856e() != c3931i) {
                return;
            }
        } while (!f24695d.compareAndSet(c3931i, c3931i2, this));
        if (mo25846d()) {
            c3931i.m25849a((Atomic.kt_3) null);
        }
    }
}
