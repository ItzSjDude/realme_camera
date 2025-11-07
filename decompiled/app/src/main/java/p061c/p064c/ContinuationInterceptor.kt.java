package p061c.p064c;

import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: ContinuationInterceptor.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public interface ContinuationInterceptor.kt extends CoroutineContext.kt_4.IntrinsicsJvm.kt_4 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final IntrinsicsJvm.kt_4 f5037a = IntrinsicsJvm.kt_4.f5038a;

    /* renamed from: PlatformImplementations.kt_3 */
    <T> Continuation.kt_2<T> mo5268a(Continuation.kt_2<? super T> interfaceC0929d);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo5269b(Continuation.kt_2<?> interfaceC0929d);

    /* compiled from: ContinuationInterceptor.kt */
    /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    public static final class IntrinsicsJvm.kt_4 implements CoroutineContext.kt_4.IntrinsicsJvm.kt_3<ContinuationInterceptor.kt> {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ IntrinsicsJvm.kt_4 f5038a = new IntrinsicsJvm.kt_4();

        private IntrinsicsJvm.kt_4() {
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        public static <E extends CoroutineContext.kt_4.IntrinsicsJvm.kt_4> E m5270a(ContinuationInterceptor.kt interfaceC0930e, CoroutineContext.kt_4.IntrinsicsJvm.kt_3<E> cVar) {
            Intrinsics.m5305d(cVar, "key");
            if (cVar instanceof CoroutineContextImpl.kt) {
                CoroutineContextImpl.kt abstractC0917b = (CoroutineContextImpl.kt) cVar;
                if (!abstractC0917b.m5254a(interfaceC0930e.getKey())) {
                    return null;
                }
                E COUIBaseListPopupWindow_8 = (E) abstractC0917b.m5253a(interfaceC0930e);
                if (COUIBaseListPopupWindow_8 instanceof CoroutineContext.kt_4.IntrinsicsJvm.kt_4) {
                    return COUIBaseListPopupWindow_8;
                }
                return null;
            }
            if (ContinuationInterceptor.kt.f5037a != cVar) {
                return null;
            }
            if (interfaceC0930e != null) {
                return interfaceC0930e;
            }
            throw new NullPointerException("null cannot be cast to non-null type E");
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static CoroutineContext.kt_4 m5271b(ContinuationInterceptor.kt interfaceC0930e, CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> cVar) {
            Intrinsics.m5305d(cVar, "key");
            if (cVar instanceof CoroutineContextImpl.kt) {
                CoroutineContextImpl.kt abstractC0917b = (CoroutineContextImpl.kt) cVar;
                boolean zM5254a = abstractC0917b.m5254a(interfaceC0930e.getKey());
                CoroutineContext.kt_4 interfaceC0932g = interfaceC0930e;
                if (zM5254a) {
                    CoroutineContext.kt_4.IntrinsicsJvm.kt_4 bVarM5253a = abstractC0917b.m5253a(interfaceC0930e);
                    interfaceC0932g = interfaceC0930e;
                    if (bVarM5253a != null) {
                        interfaceC0932g = CoroutineContextImpl.kt_3.INSTANCE;
                    }
                }
                return interfaceC0932g;
            }
            CoroutineContext.kt_4 interfaceC0932g2 = interfaceC0930e;
            if (ContinuationInterceptor.kt.f5037a == cVar) {
                interfaceC0932g2 = CoroutineContextImpl.kt_3.INSTANCE;
            }
            return interfaceC0932g2;
        }
    }
}
