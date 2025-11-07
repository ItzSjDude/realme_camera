package androidx.a_renamed.a_renamed.a_renamed;

/* compiled from: ArchTaskExecutor.java */
/* loaded from: classes.dex */
public class a_renamed extends androidx.a_renamed.a_renamed.a_renamed.c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static volatile androidx.a_renamed.a_renamed.a_renamed.a_renamed f156a;
    private static final java.util.concurrent.Executor d_renamed = new java.util.concurrent.Executor() { // from class: androidx.a_renamed.a_renamed.a_renamed.a_renamed.1
        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            androidx.a_renamed.a_renamed.a_renamed.a_renamed.a_renamed().b_renamed(runnable);
        }
    };
    private static final java.util.concurrent.Executor e_renamed = new java.util.concurrent.Executor() { // from class: androidx.a_renamed.a_renamed.a_renamed.a_renamed.2
        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            androidx.a_renamed.a_renamed.a_renamed.a_renamed.a_renamed().a_renamed(runnable);
        }
    };

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.a_renamed.a_renamed.a_renamed.c_renamed f158c = new androidx.a_renamed.a_renamed.a_renamed.b_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.a_renamed.a_renamed.a_renamed.c_renamed f157b = this.f158c;

    private a_renamed() {
    }

    public static androidx.a_renamed.a_renamed.a_renamed.a_renamed a_renamed() {
        if (f156a != null) {
            return f156a;
        }
        synchronized (androidx.a_renamed.a_renamed.a_renamed.a_renamed.class) {
            if (f156a == null) {
                f156a = new androidx.a_renamed.a_renamed.a_renamed.a_renamed();
            }
        }
        return f156a;
    }

    @Override // androidx.a_renamed.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.lang.Runnable runnable) {
        this.f157b.a_renamed(runnable);
    }

    @Override // androidx.a_renamed.a_renamed.a_renamed.c_renamed
    public void b_renamed(java.lang.Runnable runnable) {
        this.f157b.b_renamed(runnable);
    }

    public static java.util.concurrent.Executor b_renamed() {
        return e_renamed;
    }

    @Override // androidx.a_renamed.a_renamed.a_renamed.c_renamed
    public boolean c_renamed() {
        return this.f157b.c_renamed();
    }
}
