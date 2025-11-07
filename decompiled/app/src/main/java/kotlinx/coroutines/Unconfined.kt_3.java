package kotlinx.coroutines;

import p061c.p064c.CoroutineContext.kt_4;

/* compiled from: Unconfined.kt */
/* renamed from: kotlinx.coroutines.bq */
/* loaded from: classes2.dex */
public final class Unconfined.kt_3 extends CoroutineDispatcher.kt {

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final Unconfined.kt_3 f24671b = new Unconfined.kt_3();

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo25640a(CoroutineContext.kt_4 interfaceC0932g) {
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    public String toString() {
        return "Dispatchers.Unconfined";
    }

    private Unconfined.kt_3() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25629a(CoroutineContext.kt_4 interfaceC0932g, Runnable runnable) {
        Unconfined.kt c3915br = (Unconfined.kt) interfaceC0932g.get(Unconfined.kt.f24672b);
        if (c3915br != null) {
            c3915br.f24673a = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }
}
