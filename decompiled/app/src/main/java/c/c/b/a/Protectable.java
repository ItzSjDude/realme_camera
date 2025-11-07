package c_renamed.c_renamed.b_renamed.a_renamed;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes.dex */
public abstract class c_renamed extends c_renamed.c_renamed.b_renamed.a_renamed.a_renamed {
    private final c_renamed.c_renamed.g_renamed _context;
    private transient c_renamed.c_renamed.d_renamed<java.lang.Object> intercepted;

    public c_renamed(c_renamed.c_renamed.d_renamed<java.lang.Object> dVar, c_renamed.c_renamed.g_renamed gVar) {
        super(dVar);
        this._context = gVar;
    }

    public c_renamed(c_renamed.c_renamed.d_renamed<java.lang.Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }

    @Override // c_renamed.c_renamed.d_renamed
    public c_renamed.c_renamed.g_renamed getContext() {
        c_renamed.c_renamed.g_renamed gVar = this._context;
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(gVar);
        return gVar;
    }

    public final c_renamed.c_renamed.d_renamed<java.lang.Object> intercepted() {
        c_renamed.c_renamed.b_renamed.a_renamed.c_renamed cVarA = this.intercepted;
        if (cVarA == null) {
            c_renamed.c_renamed.e_renamed eVar = (c_renamed.c_renamed.e_renamed) getContext().get(c_renamed.c_renamed.e_renamed.f1897a);
            if (eVar == null || (cVarA = eVar.a_renamed(this)) == null) {
                cVarA = this;
            }
            this.intercepted = cVarA;
        }
        return cVarA;
    }

    @Override // c_renamed.c_renamed.b_renamed.a_renamed.a_renamed
    protected void releaseIntercepted() {
        c_renamed.c_renamed.d_renamed<?> dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            c_renamed.c_renamed.g_renamed.b_renamed bVar = getContext().get(c_renamed.c_renamed.e_renamed.f1897a);
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(bVar);
            ((c_renamed.c_renamed.e_renamed) bVar).b_renamed(dVar);
        }
        this.intercepted = c_renamed.c_renamed.b_renamed.a_renamed.b_renamed.f1890a;
    }
}
