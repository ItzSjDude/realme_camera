package c_renamed.c_renamed;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes.dex */
public abstract class a_renamed implements c_renamed.c_renamed.g_renamed.b_renamed {
    private final c_renamed.c_renamed.g_renamed.c_renamed<?> key;

    public a_renamed(c_renamed.c_renamed.g_renamed.c_renamed<?> cVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cVar, "key");
        this.key = cVar;
    }

    @Override // c_renamed.c_renamed.g_renamed
    public <R_renamed> R_renamed fold(R_renamed r_renamed, c_renamed.f_renamed.a_renamed.m_renamed<? super R_renamed, ? super c_renamed.c_renamed.g_renamed.b_renamed, ? extends R_renamed> mVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(mVar, "operation");
        return (R_renamed) c_renamed.c_renamed.g_renamed.b_renamed.a_renamed.a_renamed(this, r_renamed, mVar);
    }

    @Override // c_renamed.c_renamed.g_renamed.b_renamed, c_renamed.c_renamed.g_renamed
    public <E_renamed extends c_renamed.c_renamed.g_renamed.b_renamed> E_renamed get(c_renamed.c_renamed.g_renamed.c_renamed<E_renamed> cVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cVar, "key");
        return (E_renamed) c_renamed.c_renamed.g_renamed.b_renamed.a_renamed.a_renamed(this, cVar);
    }

    @Override // c_renamed.c_renamed.g_renamed.b_renamed
    public c_renamed.c_renamed.g_renamed.c_renamed<?> getKey() {
        return this.key;
    }

    @Override // c_renamed.c_renamed.g_renamed
    public c_renamed.c_renamed.g_renamed minusKey(c_renamed.c_renamed.g_renamed.c_renamed<?> cVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cVar, "key");
        return c_renamed.c_renamed.g_renamed.b_renamed.a_renamed.b_renamed(this, cVar);
    }

    @Override // c_renamed.c_renamed.g_renamed
    public c_renamed.c_renamed.g_renamed plus(c_renamed.c_renamed.g_renamed gVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(gVar, "context");
        return c_renamed.c_renamed.g_renamed.b_renamed.a_renamed.a_renamed(this, gVar);
    }
}
