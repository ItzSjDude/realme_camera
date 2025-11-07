package kotlinx.coroutines;

/* compiled from: CompletedExceptionally.kt */
/* loaded from: classes2.dex */
public final class m_renamed {
    public static final <T_renamed> java.lang.Object a_renamed(java.lang.Object obj) {
        java.lang.Throwable thM7exceptionOrNullimpl = c_renamed.m_renamed.m7exceptionOrNullimpl(obj);
        return thM7exceptionOrNullimpl == null ? obj : new kotlinx.coroutines.l_renamed(thM7exceptionOrNullimpl, false, 2, null);
    }

    public static final <T_renamed> java.lang.Object a_renamed(java.lang.Object obj, kotlinx.coroutines.e_renamed<?> eVar) {
        java.lang.Throwable thM7exceptionOrNullimpl = c_renamed.m_renamed.m7exceptionOrNullimpl(obj);
        if (thM7exceptionOrNullimpl != null) {
            kotlinx.coroutines.e_renamed<?> eVar2 = eVar;
            if (kotlinx.coroutines.ac_renamed.c_renamed() && (eVar2 instanceof c_renamed.c_renamed.b_renamed.a_renamed.d_renamed)) {
                thM7exceptionOrNullimpl = kotlinx.coroutines.internal.q_renamed.b_renamed(thM7exceptionOrNullimpl, (c_renamed.c_renamed.b_renamed.a_renamed.d_renamed) eVar2);
            }
            obj = new kotlinx.coroutines.l_renamed(thM7exceptionOrNullimpl, false, 2, null);
        }
        return obj;
    }
}
