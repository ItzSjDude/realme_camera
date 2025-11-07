package kotlinx.coroutines;

import p061c.Unit.kt;
import p061c.p064c.CoroutineContext.kt_4;

/* compiled from: Builders.common.kt */
/* renamed from: kotlinx.coroutines.bk */
/* loaded from: classes2.dex */
class Builders.common.kt_3 extends AbstractCoroutine.kt<Unit.kt> {
    public Builders.common.kt_3(CoroutineContext.kt_4 interfaceC0932g, boolean z) {
        super(interfaceC0932g, z);
    }

    @Override // kotlinx.coroutines.JobSupport.kt_6
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected boolean mo25756d(Throwable th) {
        CoroutineExceptionHandler.kt.m25946a(getContext(), th);
        return true;
    }
}
