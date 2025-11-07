package c_renamed.c_renamed;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes.dex */
public final class h_renamed implements c_renamed.c_renamed.g_renamed, java.io.Serializable {
    public static final c_renamed.c_renamed.h_renamed INSTANCE = new c_renamed.c_renamed.h_renamed();
    private static final long serialVersionUID = 0;

    @Override // c_renamed.c_renamed.g_renamed
    public <R_renamed> R_renamed fold(R_renamed r_renamed, c_renamed.f_renamed.a_renamed.m_renamed<? super R_renamed, ? super c_renamed.c_renamed.g_renamed.b_renamed, ? extends R_renamed> mVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(mVar, "operation");
        return r_renamed;
    }

    @Override // c_renamed.c_renamed.g_renamed
    public <E_renamed extends c_renamed.c_renamed.g_renamed.b_renamed> E_renamed get(c_renamed.c_renamed.g_renamed.c_renamed<E_renamed> cVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // c_renamed.c_renamed.g_renamed
    public c_renamed.c_renamed.g_renamed plus(c_renamed.c_renamed.g_renamed gVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(gVar, "context");
        return gVar;
    }

    public java.lang.String toString() {
        return "EmptyCoroutineContext";
    }

    private h_renamed() {
    }

    private final java.lang.Object readResolve() {
        return INSTANCE;
    }

    @Override // c_renamed.c_renamed.g_renamed
    public c_renamed.c_renamed.g_renamed minusKey(c_renamed.c_renamed.g_renamed.c_renamed<?> cVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cVar, "key");
        return this;
    }
}
