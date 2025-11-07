package kotlinx.coroutines;

import kotlinx.coroutines.Job.kt_5;

/* compiled from: JobSupport.kt */
/* renamed from: kotlinx.coroutines.bb */
/* loaded from: classes2.dex */
public abstract class JobSupport.kt_12<J extends Job.kt_5> extends CompletionHandler.kt implements Job.kt_4, JobSupport.kt_13 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final J f24649b;

    @Override // kotlinx.coroutines.JobSupport.kt_13
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo25605b() {
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport.kt_13
    /* renamed from: k_ */
    public JobSupport.kt_4 mo25606k_() {
        return null;
    }

    public JobSupport.kt_12(J OplusGLSurfaceView_15) {
        this.f24649b = OplusGLSurfaceView_15;
    }

    @Override // kotlinx.coroutines.Job.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25604a() {
        J OplusGLSurfaceView_15 = this.f24649b;
        if (OplusGLSurfaceView_15 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        }
        ((JobSupport.kt_6) OplusGLSurfaceView_15).m25750a((JobSupport.kt_12<?>) this);
    }
}
