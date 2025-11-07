package kotlinx.coroutines;

import p061c.Unit.kt;

/* compiled from: JobSupport.kt */
/* renamed from: kotlinx.coroutines.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public final class JobSupport.kt_14 extends JobSupport.kt_15<JobSupport.kt_6> implements Job.kt_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    public final Job.kt f24679a;

    @Override // p061c.p070f.p071a.Functions.kt_3
    public /* synthetic */ Unit.kt invoke(Throwable th) {
        mo25648b(th);
        return Unit.kt.f5071a;
    }

    public JobSupport.kt_14(JobSupport.kt_6 c3900bc, Job.kt interfaceC3948j) {
        super(c3900bc);
        this.f24679a = interfaceC3948j;
    }

    @Override // kotlinx.coroutines.CompletionHandler.kt
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo25648b(Throwable th) {
        this.f24679a.mo25751a((Job.kt_8) this.f24649b);
    }

    @Override // kotlinx.coroutines.Job.kt_2
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo25788a(Throwable th) {
        return ((JobSupport.kt_6) this.f24649b).m25753b(th);
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedList.kt
    public String toString() {
        return "ChildHandle[" + this.f24679a + ']';
    }
}
