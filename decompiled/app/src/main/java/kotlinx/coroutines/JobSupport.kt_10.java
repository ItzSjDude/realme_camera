package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* renamed from: kotlinx.coroutines.at */
/* loaded from: classes2.dex */
public final class JobSupport.kt_10 implements JobSupport.kt_13 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final JobSupport.kt_4 f24590a;

    @Override // kotlinx.coroutines.JobSupport.kt_13
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo25605b() {
        return false;
    }

    public JobSupport.kt_10(JobSupport.kt_4 c3904bg) {
        this.f24590a = c3904bg;
    }

    @Override // kotlinx.coroutines.JobSupport.kt_13
    /* renamed from: k_ */
    public JobSupport.kt_4 mo25606k_() {
        return this.f24590a;
    }

    public String toString() {
        return Debug.kt.m25575b() ? mo25606k_().m25787a("New") : super.toString();
    }
}
