package kotlinx.coroutines;

import p061c.Unit.kt;
import p061c.p070f.p071a.Functions.kt_3;

/* compiled from: JobSupport.kt */
/* renamed from: kotlinx.coroutines.ax */
/* loaded from: classes2.dex */
final class JobSupport.kt_2 extends JobSupport.kt_12<Job.kt_5> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Functions.kt_3<Throwable, Unit.kt> f24594a;

    @Override // p061c.p070f.p071a.Functions.kt_3
    public /* synthetic */ Unit.kt invoke(Throwable th) {
        mo25648b(th);
        return Unit.kt.f5071a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JobSupport.kt_2(Job.kt_5 interfaceC3881ay, Functions.kt_3<? super Throwable, Unit.kt> interfaceC0943b) {
        super(interfaceC3881ay);
        this.f24594a = interfaceC0943b;
    }

    @Override // kotlinx.coroutines.CompletionHandler.kt
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo25648b(Throwable th) {
        this.f24594a.invoke(th);
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedList.kt
    public String toString() {
        return "InvokeOnCompletion[" + DebugStrings.kt.m25580b(this) + '@' + DebugStrings.kt.m25579a(this) + ']';
    }
}
