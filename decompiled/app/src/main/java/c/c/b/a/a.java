package c_renamed.c_renamed.b_renamed.a_renamed;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes.dex */
public abstract class a_renamed implements c_renamed.c_renamed.b_renamed.a_renamed.d_renamed, c_renamed.c_renamed.d_renamed<java.lang.Object>, java.io.Serializable {
    private final c_renamed.c_renamed.d_renamed<java.lang.Object> completion;

    protected abstract java.lang.Object invokeSuspend(java.lang.Object obj);

    protected void releaseIntercepted() {
    }

    public a_renamed(c_renamed.c_renamed.d_renamed<java.lang.Object> dVar) {
        this.completion = dVar;
    }

    public final c_renamed.c_renamed.d_renamed<java.lang.Object> getCompletion() {
        return this.completion;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [c_renamed.c_renamed.d_renamed, c_renamed.c_renamed.d_renamed<java.lang.Object>, java.lang.Object] */
    @Override // c_renamed.c_renamed.d_renamed
    public final void resumeWith(java.lang.Object obj) {
        java.lang.Object objInvokeSuspend;
        while (true) {
            c_renamed.c_renamed.b_renamed.a_renamed.a_renamed aVar = this;
            c_renamed.c_renamed.b_renamed.a_renamed.g_renamed.b_renamed(aVar);
            ?? r0 = aVar.completion;
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) r0);
            try {
                objInvokeSuspend = aVar.invokeSuspend(obj);
            } catch (java.lang.Throwable th) {
                c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
                obj = c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th));
            }
            if (objInvokeSuspend == c_renamed.c_renamed.a_renamed.b_renamed.a_renamed()) {
                return;
            }
            c_renamed.m_renamed.a_renamed aVar3 = c_renamed.m_renamed.Companion;
            obj = c_renamed.m_renamed.m4constructorimpl(objInvokeSuspend);
            aVar.releaseIntercepted();
            if (r0 instanceof c_renamed.c_renamed.b_renamed.a_renamed.a_renamed) {
                this = r0;
            } else {
                r0.resumeWith(obj);
                return;
            }
        }
    }

    public c_renamed.c_renamed.d_renamed<c_renamed.s_renamed> create(c_renamed.c_renamed.d_renamed<?> dVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(dVar, "completion");
        throw new java.lang.UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public c_renamed.c_renamed.d_renamed<c_renamed.s_renamed> create(java.lang.Object obj, c_renamed.c_renamed.d_renamed<?> dVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(dVar, "completion");
        throw new java.lang.UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Continuation at_renamed ");
        java.lang.StackTraceElement stackTraceElement = getStackTraceElement();
        sb.append(stackTraceElement != null ? stackTraceElement : getClass().getName());
        return sb.toString();
    }

    @Override // c_renamed.c_renamed.b_renamed.a_renamed.d_renamed
    public c_renamed.c_renamed.b_renamed.a_renamed.d_renamed getCallerFrame() {
        c_renamed.c_renamed.d_renamed<java.lang.Object> dVar = this.completion;
        if (!(dVar instanceof c_renamed.c_renamed.b_renamed.a_renamed.d_renamed)) {
            dVar = null;
        }
        return (c_renamed.c_renamed.b_renamed.a_renamed.d_renamed) dVar;
    }

    @Override // c_renamed.c_renamed.b_renamed.a_renamed.d_renamed
    public java.lang.StackTraceElement getStackTraceElement() {
        return c_renamed.c_renamed.b_renamed.a_renamed.f_renamed.a_renamed(this);
    }
}
