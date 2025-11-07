package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
final class ax_renamed extends kotlinx.coroutines.bb_renamed<kotlinx.coroutines.ay_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final c_renamed.f_renamed.a_renamed.b_renamed<java.lang.Throwable, c_renamed.s_renamed> f7811a;

    @Override // c_renamed.f_renamed.a_renamed.b_renamed
    public /* synthetic */ c_renamed.s_renamed invoke(java.lang.Throwable th) {
        b_renamed(th);
        return c_renamed.s_renamed.f1925a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ax_renamed(kotlinx.coroutines.ay_renamed ayVar, c_renamed.f_renamed.a_renamed.b_renamed<? super java.lang.Throwable, c_renamed.s_renamed> bVar) {
        super(ayVar);
        this.f7811a = bVar;
    }

    @Override // kotlinx.coroutines.p_renamed
    public void b_renamed(java.lang.Throwable th) {
        this.f7811a.invoke(th);
    }

    @Override // kotlinx.coroutines.internal.i_renamed
    public java.lang.String toString() {
        return "InvokeOnCompletion[" + kotlinx.coroutines.ad_renamed.b_renamed(this) + '@' + kotlinx.coroutines.ad_renamed.a_renamed(this) + ']';
    }
}
