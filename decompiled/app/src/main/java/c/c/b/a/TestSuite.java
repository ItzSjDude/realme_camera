package c_renamed.c_renamed.b_renamed.a_renamed;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes.dex */
public abstract class i_renamed extends c_renamed.c_renamed.b_renamed.a_renamed.a_renamed {
    public i_renamed(c_renamed.c_renamed.d_renamed<java.lang.Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.getContext() == c_renamed.c_renamed.h_renamed.INSTANCE)) {
                throw new java.lang.IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // c_renamed.c_renamed.d_renamed
    public c_renamed.c_renamed.g_renamed getContext() {
        return c_renamed.c_renamed.h_renamed.INSTANCE;
    }
}
