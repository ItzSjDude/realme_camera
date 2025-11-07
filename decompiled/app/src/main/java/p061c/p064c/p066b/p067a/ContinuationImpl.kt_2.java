package p061c.p064c.p066b.p067a;

import p061c.p064c.CoroutineContextImpl.kt_3;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.CoroutineContext.kt_4;

/* compiled from: ContinuationImpl.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public abstract class ContinuationImpl.kt_2 extends AbstractC0918a {
    public ContinuationImpl.kt_2(Continuation.kt_2<Object> interfaceC0929d) {
        super(interfaceC0929d);
        if (interfaceC0929d != null) {
            if (!(interfaceC0929d.getContext() == CoroutineContextImpl.kt_3.INSTANCE)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // p061c.p064c.Continuation.kt_2
    public CoroutineContext.kt_4 getContext() {
        return CoroutineContextImpl.kt_3.INSTANCE;
    }
}
