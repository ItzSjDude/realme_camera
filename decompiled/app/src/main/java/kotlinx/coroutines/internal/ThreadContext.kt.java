package kotlinx.coroutines.internal;

import kotlinx.coroutines.ThreadContextElement.kt;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p071a.Functions.kt_19;
import p061c.p070f.p072b.Lambda.kt;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: ThreadContext.kt */
/* renamed from: kotlinx.coroutines.internal.v */
/* loaded from: classes2.dex */
public final class ThreadContext.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Symbol.kt f24719a = new Symbol.kt("ZERO");

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final Functions.kt_19<Object, CoroutineContext.kt_4.IntrinsicsJvm.kt_4, Object> f24720b = PlatformImplementations.kt_3.INSTANCE;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final Functions.kt_19<ThreadContextElement.kt<?>, CoroutineContext.kt_4.IntrinsicsJvm.kt_4, ThreadContextElement.kt<?>> f24721c = IntrinsicsJvm.kt_4.INSTANCE;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final Functions.kt_19<ThreadContext.kt_6, CoroutineContext.kt_4.IntrinsicsJvm.kt_4, ThreadContext.kt_6> f24722d = IntrinsicsJvm.kt_5.INSTANCE;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final Functions.kt_19<ThreadContext.kt_6, CoroutineContext.kt_4.IntrinsicsJvm.kt_4, ThreadContext.kt_6> f24723e = IntrinsicsJvm.kt_3.INSTANCE;

    /* compiled from: ThreadContext.kt */
    /* renamed from: kotlinx.coroutines.internal.v$PlatformImplementations.kt_3 */
    static final class PlatformImplementations.kt_3 extends Lambda.kt implements Functions.kt_19<Object, CoroutineContext.kt_4.IntrinsicsJvm.kt_4, Object> {
        public static final PlatformImplementations.kt_3 INSTANCE = new PlatformImplementations.kt_3();

        PlatformImplementations.kt_3() {
            super(2);
        }

        @Override // p061c.p070f.p071a.Functions.kt_19
        public final Object invoke(Object obj, CoroutineContext.kt_4.IntrinsicsJvm.kt_4 bVar) {
            if (!(bVar instanceof ThreadContextElement.kt)) {
                return obj;
            }
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    /* compiled from: ThreadContext.kt */
    /* renamed from: kotlinx.coroutines.internal.v$IntrinsicsJvm.kt_4 */
    static final class IntrinsicsJvm.kt_4 extends Lambda.kt implements Functions.kt_19<ThreadContextElement.kt<?>, CoroutineContext.kt_4.IntrinsicsJvm.kt_4, ThreadContextElement.kt<?>> {
        public static final IntrinsicsJvm.kt_4 INSTANCE = new IntrinsicsJvm.kt_4();

        IntrinsicsJvm.kt_4() {
            super(2);
        }

        @Override // p061c.p070f.p071a.Functions.kt_19
        public final ThreadContextElement.kt<?> invoke(ThreadContextElement.kt<?> interfaceC3909bl, CoroutineContext.kt_4.IntrinsicsJvm.kt_4 bVar) {
            if (interfaceC3909bl != null) {
                return interfaceC3909bl;
            }
            if (!(bVar instanceof ThreadContextElement.kt)) {
                bVar = null;
            }
            return (ThreadContextElement.kt) bVar;
        }
    }

    /* compiled from: ThreadContext.kt */
    /* renamed from: kotlinx.coroutines.internal.v$IntrinsicsJvm.kt_5 */
    static final class IntrinsicsJvm.kt_5 extends Lambda.kt implements Functions.kt_19<ThreadContext.kt_6, CoroutineContext.kt_4.IntrinsicsJvm.kt_4, ThreadContext.kt_6> {
        public static final IntrinsicsJvm.kt_5 INSTANCE = new IntrinsicsJvm.kt_5();

        IntrinsicsJvm.kt_5() {
            super(2);
        }

        @Override // p061c.p070f.p071a.Functions.kt_19
        public final ThreadContext.kt_6 invoke(ThreadContext.kt_6 c3947y, CoroutineContext.kt_4.IntrinsicsJvm.kt_4 bVar) {
            if (bVar instanceof ThreadContextElement.kt) {
                c3947y.m25929a(((ThreadContextElement.kt) bVar).mo25790b(c3947y.m25931c()));
            }
            return c3947y;
        }
    }

    /* compiled from: ThreadContext.kt */
    /* renamed from: kotlinx.coroutines.internal.v$IntrinsicsJvm.kt_3 */
    static final class IntrinsicsJvm.kt_3 extends Lambda.kt implements Functions.kt_19<ThreadContext.kt_6, CoroutineContext.kt_4.IntrinsicsJvm.kt_4, ThreadContext.kt_6> {
        public static final IntrinsicsJvm.kt_3 INSTANCE = new IntrinsicsJvm.kt_3();

        IntrinsicsJvm.kt_3() {
            super(2);
        }

        @Override // p061c.p070f.p071a.Functions.kt_19
        public final ThreadContext.kt_6 invoke(ThreadContext.kt_6 c3947y, CoroutineContext.kt_4.IntrinsicsJvm.kt_4 bVar) {
            if (bVar instanceof ThreadContextElement.kt) {
                ((ThreadContextElement.kt) bVar).mo25789a(c3947y.m25931c(), c3947y.m25928a());
            }
            return c3947y;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Object m25912a(CoroutineContext.kt_4 interfaceC0932g) {
        Object objFold = interfaceC0932g.fold(0, f24720b);
        Intrinsics.m5296a(objFold);
        return objFold;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Object m25913a(CoroutineContext.kt_4 interfaceC0932g, Object obj) {
        if (obj == null) {
            obj = m25912a(interfaceC0932g);
        }
        if (obj == 0) {
            return f24719a;
        }
        if (obj instanceof Integer) {
            return interfaceC0932g.fold(new ThreadContext.kt_6(interfaceC0932g, ((Number) obj).intValue()), f24722d);
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        return ((ThreadContextElement.kt) obj).mo25790b(interfaceC0932g);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final void m25914b(CoroutineContext.kt_4 interfaceC0932g, Object obj) {
        if (obj == f24719a) {
            return;
        }
        if (obj instanceof ThreadContext.kt_6) {
            ((ThreadContext.kt_6) obj).m25930b();
            interfaceC0932g.fold(obj, f24723e);
        } else {
            Object objFold = interfaceC0932g.fold(null, f24721c);
            if (objFold == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            }
            ((ThreadContextElement.kt) objFold).mo25789a(interfaceC0932g, obj);
        }
    }
}
