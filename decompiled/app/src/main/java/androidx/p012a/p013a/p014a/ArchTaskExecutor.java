package androidx.p012a.p013a.p014a;

import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor.java */
/* renamed from: androidx.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class ArchTaskExecutor extends TaskExecutor {

    /* renamed from: PlatformImplementations.kt_3 */
    private static volatile ArchTaskExecutor f690a;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final Executor f691d = new Executor() { // from class: androidx.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.m691a().mo694b(runnable);
        }
    };

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final Executor f692e = new Executor() { // from class: androidx.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.m691a().mo693a(runnable);
        }
    };

    /* renamed from: IntrinsicsJvm.kt_3 */
    private TaskExecutor f694c = new DefaultTaskExecutor();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private TaskExecutor f693b = this.f694c;

    private ArchTaskExecutor() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ArchTaskExecutor m691a() {
        if (f690a != null) {
            return f690a;
        }
        synchronized (ArchTaskExecutor.class) {
            if (f690a == null) {
                f690a = new ArchTaskExecutor();
            }
        }
        return f690a;
    }

    @Override // androidx.p012a.p013a.p014a.TaskExecutor
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo693a(Runnable runnable) {
        this.f693b.mo693a(runnable);
    }

    @Override // androidx.p012a.p013a.p014a.TaskExecutor
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo694b(Runnable runnable) {
        this.f693b.mo694b(runnable);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Executor m692b() {
        return f692e;
    }

    @Override // androidx.p012a.p013a.p014a.TaskExecutor
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo695c() {
        return this.f693b.mo695c();
    }
}
