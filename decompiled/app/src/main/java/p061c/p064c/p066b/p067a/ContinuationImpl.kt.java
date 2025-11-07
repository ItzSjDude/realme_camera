package p061c.p064c.p066b.p067a;

import p061c.p064c.Continuation.kt_2;
import p061c.p064c.ContinuationInterceptor.kt;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: ContinuationImpl.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public abstract class ContinuationImpl.kt extends AbstractC0918a {
    private final CoroutineContext.kt_4 _context;
    private transient Continuation.kt_2<Object> intercepted;

    public ContinuationImpl.kt(Continuation.kt_2<Object> interfaceC0929d, CoroutineContext.kt_4 interfaceC0932g) {
        super(interfaceC0929d);
        this._context = interfaceC0932g;
    }

    public ContinuationImpl.kt(Continuation.kt_2<Object> interfaceC0929d) {
        this(interfaceC0929d, interfaceC0929d != null ? interfaceC0929d.getContext() : null);
    }

    @Override // p061c.p064c.Continuation.kt_2
    public CoroutineContext.kt_4 getContext() {
        CoroutineContext.kt_4 interfaceC0932g = this._context;
        Intrinsics.m5296a(interfaceC0932g);
        return interfaceC0932g;
    }

    public final Continuation.kt_2<Object> intercepted() {
        ContinuationImpl.kt abstractC0920cMo5268a = this.intercepted;
        if (abstractC0920cMo5268a == null) {
            ContinuationInterceptor.kt interfaceC0930e = (ContinuationInterceptor.kt) getContext().get(ContinuationInterceptor.kt.f5037a);
            if (interfaceC0930e == null || (abstractC0920cMo5268a = interfaceC0930e.mo5268a(this)) == null) {
                abstractC0920cMo5268a = this;
            }
            this.intercepted = abstractC0920cMo5268a;
        }
        return abstractC0920cMo5268a;
    }

    @Override // p061c.p064c.p066b.p067a.AbstractC0918a
    protected void releaseIntercepted() {
        Continuation.kt_2<?> interfaceC0929d = this.intercepted;
        if (interfaceC0929d != null && interfaceC0929d != this) {
            CoroutineContext.kt_4.IntrinsicsJvm.kt_4 bVar = getContext().get(ContinuationInterceptor.kt.f5037a);
            Intrinsics.m5296a(bVar);
            ((ContinuationInterceptor.kt) bVar).mo5269b(interfaceC0929d);
        }
        this.intercepted = ContinuationImpl.kt_4.f5030a;
    }
}
