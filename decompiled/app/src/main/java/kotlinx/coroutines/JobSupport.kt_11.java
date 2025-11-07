package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p061c.Unit.kt;
import p061c.p070f.p071a.Functions.kt_3;

/* compiled from: JobSupport.kt */
/* renamed from: kotlinx.coroutines.aw */
/* loaded from: classes2.dex */
final class JobSupport.kt_11 extends JobSupport.kt_15<Job.kt_5> {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final AtomicIntegerFieldUpdater f24592a = AtomicIntegerFieldUpdater.newUpdater(JobSupport.kt_11.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Functions.kt_3<Throwable, Unit.kt> f24593e;

    @Override // p061c.p070f.p071a.Functions.kt_3
    public /* synthetic */ Unit.kt invoke(Throwable th) {
        mo25648b(th);
        return Unit.kt.f5071a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JobSupport.kt_11(Job.kt_5 interfaceC3881ay, Functions.kt_3<? super Throwable, Unit.kt> interfaceC0943b) {
        super(interfaceC3881ay);
        this.f24593e = interfaceC0943b;
        this._invoked = 0;
    }

    @Override // kotlinx.coroutines.CompletionHandler.kt
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo25648b(Throwable th) {
        if (f24592a.compareAndSet(this, 0, 1)) {
            this.f24593e.invoke(th);
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedList.kt
    public String toString() {
        return "InvokeOnCancelling[" + DebugStrings.kt.m25580b(this) + '@' + DebugStrings.kt.m25579a(this) + ']';
    }
}
