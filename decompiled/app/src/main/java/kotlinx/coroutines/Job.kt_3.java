package kotlinx.coroutines;

/* compiled from: Job.kt */
/* renamed from: kotlinx.coroutines.bh */
/* loaded from: classes2.dex */
public final class Job.kt_3 implements Job.kt_4, Job.kt_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Job.kt_3 f24667a = new Job.kt_3();

    @Override // kotlinx.coroutines.Job.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25604a() {
    }

    @Override // kotlinx.coroutines.Job.kt_2
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo25788a(Throwable th) {
        return false;
    }

    public String toString() {
        return "NonDisposableHandle";
    }

    private Job.kt_3() {
    }
}
