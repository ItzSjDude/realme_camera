package androidx.room;

/* compiled from: EntityInsertionAdapter.java */
/* loaded from: classes.dex */
public abstract class b_renamed<T_renamed> extends androidx.room.m_renamed {
    protected abstract void a_renamed(androidx.f_renamed.a_renamed.f_renamed fVar, T_renamed t_renamed);

    public b_renamed(androidx.room.g_renamed gVar) {
        super(gVar);
    }

    public final void a_renamed(T_renamed t_renamed) {
        androidx.f_renamed.a_renamed.f_renamed fVarC = c_renamed();
        try {
            a_renamed(fVarC, t_renamed);
            fVarC.b_renamed();
        } finally {
            a_renamed(fVarC);
        }
    }
}
