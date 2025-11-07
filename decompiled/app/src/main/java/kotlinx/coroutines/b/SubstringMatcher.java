package kotlinx.coroutines.b_renamed;

/* compiled from: Tasks.kt */
/* loaded from: classes2.dex */
public final class k_renamed extends kotlinx.coroutines.b_renamed.i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public final java.lang.Runnable f7828a;

    public k_renamed(java.lang.Runnable runnable, long j_renamed, kotlinx.coroutines.b_renamed.j_renamed jVar) {
        super(j_renamed, jVar);
        this.f7828a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f7828a.run();
        } finally {
            this.g_renamed.a_renamed();
        }
    }

    public java.lang.String toString() {
        return "Task[" + kotlinx.coroutines.ad_renamed.b_renamed(this.f7828a) + '@' + kotlinx.coroutines.ad_renamed.a_renamed(this.f7828a) + ", " + this.f_renamed + ", " + this.g_renamed + ']';
    }
}
