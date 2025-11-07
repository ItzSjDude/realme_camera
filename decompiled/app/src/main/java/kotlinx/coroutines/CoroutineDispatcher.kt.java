package kotlinx.coroutines;

import p061c.p064c.CoroutineContextImpl.kt_2;
import p061c.p064c.CoroutineContextImpl.kt;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.ContinuationInterceptor.kt;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p071a.Functions.kt_3;
import p061c.p070f.p072b.Lambda.kt;
import p061c.p070f.p072b.DefaultConstructorMarker;

/* compiled from: CoroutineDispatcher.kt */
/* renamed from: kotlinx.coroutines.t */
/* loaded from: classes2.dex */
public abstract class CoroutineDispatcher.kt extends CoroutineContextImpl.kt_2 implements ContinuationInterceptor.kt {

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final PlatformImplementations.kt_3 f24739c = new PlatformImplementations.kt_3(null);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo25629a(CoroutineContext.kt_4 interfaceC0932g, Runnable runnable);

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo25640a(CoroutineContext.kt_4 interfaceC0932g) {
        return true;
    }

    @Override // p061c.p064c.CoroutineContextImpl.kt_2, p061c.p064c.CoroutineContext.kt_4.IntrinsicsJvm.kt_4, p061c.p064c.CoroutineContext.kt_4
    public <E extends CoroutineContext.kt_4.IntrinsicsJvm.kt_4> E get(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<E> cVar) {
        return (E) ContinuationInterceptor.kt.PlatformImplementations.kt_3.m5270a(this, cVar);
    }

    @Override // p061c.p064c.CoroutineContextImpl.kt_2, p061c.p064c.CoroutineContext.kt_4
    public CoroutineContext.kt_4 minusKey(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> cVar) {
        return ContinuationInterceptor.kt.PlatformImplementations.kt_3.m5271b(this, cVar);
    }

    public CoroutineDispatcher.kt() {
        super(ContinuationInterceptor.kt.f5037a);
    }

    /* compiled from: CoroutineDispatcher.kt */
    /* renamed from: kotlinx.coroutines.t$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 extends CoroutineContextImpl.kt<ContinuationInterceptor.kt, CoroutineDispatcher.kt> {
        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }

        /* compiled from: CoroutineDispatcher.kt */
        /* renamed from: kotlinx.coroutines.t$PlatformImplementations.kt_3$1, reason: invalid class name */
        static final class COUIBaseListPopupWindow_2 extends Lambda.kt implements Functions.kt_3<CoroutineContext.kt_4.IntrinsicsJvm.kt_4, CoroutineDispatcher.kt> {
            public static final COUIBaseListPopupWindow_2 INSTANCE = new COUIBaseListPopupWindow_2();

            COUIBaseListPopupWindow_2() {
                super(1);
            }

            @Override // p061c.p070f.p071a.Functions.kt_3
            public final CoroutineDispatcher.kt invoke(CoroutineContext.kt_4.IntrinsicsJvm.kt_4 bVar) {
                if (!(bVar instanceof CoroutineDispatcher.kt)) {
                    bVar = null;
                }
                return (CoroutineDispatcher.kt) bVar;
            }
        }

        private PlatformImplementations.kt_3() {
            super(ContinuationInterceptor.kt.f5037a, COUIBaseListPopupWindow_2.INSTANCE);
        }
    }

    @Override // p061c.p064c.ContinuationInterceptor.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public final <T> Continuation.kt_2<T> mo5268a(Continuation.kt_2<? super T> interfaceC0929d) {
        return new DispatchedContinuation.kt_2(this, interfaceC0929d);
    }

    @Override // p061c.p064c.ContinuationInterceptor.kt
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo5269b(Continuation.kt_2<?> interfaceC0929d) {
        if (interfaceC0929d == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<*>");
        }
        CancellableContinuationImpl.kt<?> c3919fM25586a = ((DispatchedContinuation.kt_2) interfaceC0929d).m25586a();
        if (c3919fM25586a != null) {
            c3919fM25586a.m25820c();
        }
    }

    public String toString() {
        return DebugStrings.kt.m25580b(this) + '@' + DebugStrings.kt.m25579a(this);
    }
}
