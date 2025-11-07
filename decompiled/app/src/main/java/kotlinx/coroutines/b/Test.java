package kotlinx.coroutines.b_renamed;

/* compiled from: Dispatcher.kt */
/* loaded from: classes2.dex */
public class d_renamed extends kotlinx.coroutines.ar_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private kotlinx.coroutines.b_renamed.a_renamed f7823b;
    private final int e_renamed;
    private final int f_renamed;
    private final long g_renamed;
    private final java.lang.String h_renamed;

    public d_renamed(int i_renamed, int i2, long j_renamed, java.lang.String str) {
        this.e_renamed = i_renamed;
        this.f_renamed = i2;
        this.g_renamed = j_renamed;
        this.h_renamed = str;
        this.f7823b = a_renamed();
    }

    public /* synthetic */ d_renamed(int i_renamed, int i2, java.lang.String str, int i3, c_renamed.f_renamed.b_renamed.f_renamed fVar) {
        this((i3 & 1) != 0 ? kotlinx.coroutines.b_renamed.l_renamed.f7831c : i_renamed, (i3 & 2) != 0 ? kotlinx.coroutines.b_renamed.l_renamed.d_renamed : i2, (i3 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    public d_renamed(int i_renamed, int i2, java.lang.String str) {
        this(i_renamed, i2, kotlinx.coroutines.b_renamed.l_renamed.e_renamed, str);
    }

    @Override // kotlinx.coroutines.t_renamed
    public void a_renamed(c_renamed.c_renamed.g_renamed gVar, java.lang.Runnable runnable) {
        try {
            kotlinx.coroutines.b_renamed.a_renamed.a_renamed(this.f7823b, runnable, null, false, 6, null);
        } catch (java.util.concurrent.RejectedExecutionException unused) {
            kotlinx.coroutines.ae_renamed.f7787b.a_renamed(gVar, runnable);
        }
    }

    public void close() {
        this.f7823b.close();
    }

    @Override // kotlinx.coroutines.t_renamed
    public java.lang.String toString() {
        return super.toString() + "[scheduler = " + this.f7823b + ']';
    }

    public final void a_renamed(java.lang.Runnable runnable, kotlinx.coroutines.b_renamed.j_renamed jVar, boolean z_renamed) {
        try {
            this.f7823b.a_renamed(runnable, jVar, z_renamed);
        } catch (java.util.concurrent.RejectedExecutionException unused) {
            kotlinx.coroutines.ae_renamed.f7787b.a_renamed(this.f7823b.a_renamed(runnable, jVar));
        }
    }

    private final kotlinx.coroutines.b_renamed.a_renamed a_renamed() {
        return new kotlinx.coroutines.b_renamed.a_renamed(this.e_renamed, this.f_renamed, this.g_renamed, this.h_renamed);
    }
}
