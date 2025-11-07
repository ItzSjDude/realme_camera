package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public final class i_renamed extends kotlinx.coroutines.ba_renamed<kotlinx.coroutines.bc_renamed> implements kotlinx.coroutines.h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public final kotlinx.coroutines.j_renamed f7857a;

    @Override // c_renamed.f_renamed.a_renamed.b_renamed
    public /* synthetic */ c_renamed.s_renamed invoke(java.lang.Throwable th) {
        b_renamed(th);
        return c_renamed.s_renamed.f1925a;
    }

    public i_renamed(kotlinx.coroutines.bc_renamed bcVar, kotlinx.coroutines.j_renamed jVar) {
        super(bcVar);
        this.f7857a = jVar;
    }

    @Override // kotlinx.coroutines.p_renamed
    public void b_renamed(java.lang.Throwable th) {
        this.f7857a.a_renamed((kotlinx.coroutines.bj_renamed) this.f7835b);
    }

    @Override // kotlinx.coroutines.h_renamed
    public boolean a_renamed(java.lang.Throwable th) {
        return ((kotlinx.coroutines.bc_renamed) this.f7835b).b_renamed(th);
    }

    @Override // kotlinx.coroutines.internal.i_renamed
    public java.lang.String toString() {
        return "ChildHandle[" + this.f7857a + ']';
    }
}
