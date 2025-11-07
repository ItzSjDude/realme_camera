package p061c.p064c;

import p061c.p070f.p071a.Functions.kt_19;
import p061c.p070f.p072b.Lambda.kt;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: CoroutineContext.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public interface CoroutineContext.kt_4 {

    /* compiled from: CoroutineContext.kt */
    /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3<E extends IntrinsicsJvm.kt_4> {
    }

    <R> R fold(R r, Functions.kt_19<? super R, ? super IntrinsicsJvm.kt_4, ? extends R> interfaceC0954m);

    <E extends IntrinsicsJvm.kt_4> E get(IntrinsicsJvm.kt_3<E> cVar);

    CoroutineContext.kt_4 minusKey(IntrinsicsJvm.kt_3<?> cVar);

    CoroutineContext.kt_4 plus(CoroutineContext.kt_4 interfaceC0932g);

    /* compiled from: CoroutineContext.kt */
    /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        public static CoroutineContext.kt_4 m5274a(CoroutineContext.kt_4 interfaceC0932g, CoroutineContext.kt_4 interfaceC0932g2) {
            Intrinsics.m5305d(interfaceC0932g2, "context");
            return interfaceC0932g2 == CoroutineContextImpl.kt_3.INSTANCE ? interfaceC0932g : (CoroutineContext.kt_4) interfaceC0932g2.fold(interfaceC0932g, CoroutineContext.kt_7.INSTANCE);
        }

        /* compiled from: CoroutineContext.kt */
        /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3$PlatformImplementations.kt_3, reason: collision with other inner class name */
        static final class CoroutineContext.kt_7 extends Lambda.kt implements Functions.kt_19<CoroutineContext.kt_4, IntrinsicsJvm.kt_4, CoroutineContext.kt_4> {
            public static final CoroutineContext.kt_7 INSTANCE = new CoroutineContext.kt_7();

            CoroutineContext.kt_7() {
                super(2);
            }

            @Override // p061c.p070f.p071a.Functions.kt_19
            public final CoroutineContext.kt_4 invoke(CoroutineContext.kt_4 interfaceC0932g, IntrinsicsJvm.kt_4 bVar) {
                C0928c c0928c;
                Intrinsics.m5305d(interfaceC0932g, "acc");
                Intrinsics.m5305d(bVar, "element");
                CoroutineContext.kt_4 interfaceC0932gMinusKey = interfaceC0932g.minusKey(bVar.getKey());
                if (interfaceC0932gMinusKey == CoroutineContextImpl.kt_3.INSTANCE) {
                    return bVar;
                }
                ContinuationInterceptor.kt interfaceC0930e = (ContinuationInterceptor.kt) interfaceC0932gMinusKey.get(ContinuationInterceptor.kt.f5037a);
                if (interfaceC0930e == null) {
                    c0928c = new C0928c(interfaceC0932gMinusKey, bVar);
                } else {
                    CoroutineContext.kt_4 interfaceC0932gMinusKey2 = interfaceC0932gMinusKey.minusKey(ContinuationInterceptor.kt.f5037a);
                    c0928c = interfaceC0932gMinusKey2 == CoroutineContextImpl.kt_3.INSTANCE ? new C0928c(bVar, interfaceC0930e) : new C0928c(new C0928c(interfaceC0932gMinusKey2, bVar), interfaceC0930e);
                }
                return c0928c;
            }
        }
    }

    /* compiled from: CoroutineContext.kt */
    /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 extends CoroutineContext.kt_4 {
        @Override // p061c.p064c.CoroutineContext.kt_4
        <E extends IntrinsicsJvm.kt_4> E get(IntrinsicsJvm.kt_3<E> cVar);

        IntrinsicsJvm.kt_3<?> getKey();

        /* compiled from: CoroutineContext.kt */
        /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
        public static final class PlatformImplementations.kt_3 {
            /* renamed from: PlatformImplementations.kt_3 */
            public static CoroutineContext.kt_4 m5276a(IntrinsicsJvm.kt_4 bVar, CoroutineContext.kt_4 interfaceC0932g) {
                Intrinsics.m5305d(interfaceC0932g, "context");
                return PlatformImplementations.kt_3.m5274a(bVar, interfaceC0932g);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: PlatformImplementations.kt_3 */
            public static <E extends IntrinsicsJvm.kt_4> E m5275a(IntrinsicsJvm.kt_4 bVar, IntrinsicsJvm.kt_3<E> cVar) {
                Intrinsics.m5305d(cVar, "key");
                if (!Intrinsics.m5299a(bVar.getKey(), cVar)) {
                    return null;
                }
                if (bVar != 0) {
                    return bVar;
                }
                throw new NullPointerException("null cannot be cast to non-null type E");
            }

            /* renamed from: PlatformImplementations.kt_3 */
            public static <R> R m5277a(IntrinsicsJvm.kt_4 bVar, R r, Functions.kt_19<? super R, ? super IntrinsicsJvm.kt_4, ? extends R> interfaceC0954m) {
                Intrinsics.m5305d(interfaceC0954m, "operation");
                return interfaceC0954m.invoke(r, bVar);
            }

            /* renamed from: IntrinsicsJvm.kt_4 */
            public static CoroutineContext.kt_4 m5278b(IntrinsicsJvm.kt_4 bVar, IntrinsicsJvm.kt_3<?> cVar) {
                Intrinsics.m5305d(cVar, "key");
                boolean zM5299a = Intrinsics.m5299a(bVar.getKey(), cVar);
                CoroutineContext.kt_4 interfaceC0932g = bVar;
                if (zM5299a) {
                    interfaceC0932g = CoroutineContextImpl.kt_3.INSTANCE;
                }
                return interfaceC0932g;
            }
        }
    }
}
