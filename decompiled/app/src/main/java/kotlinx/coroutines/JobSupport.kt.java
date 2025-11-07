package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* renamed from: kotlinx.coroutines.al */
/* loaded from: classes2.dex */
final class JobSupport.kt implements JobSupport.kt_13 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final boolean f24571a;

    @Override // kotlinx.coroutines.JobSupport.kt_13
    /* renamed from: k_ */
    public JobSupport.kt_4 mo25606k_() {
        return null;
    }

    public JobSupport.kt(boolean z) {
        this.f24571a = z;
    }

    @Override // kotlinx.coroutines.JobSupport.kt_13
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo25605b() {
        return this.f24571a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(mo25605b() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
