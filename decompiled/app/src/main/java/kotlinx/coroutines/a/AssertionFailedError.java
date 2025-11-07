package kotlinx.coroutines.a_renamed;

/* compiled from: Undispatched.kt */
/* loaded from: classes2.dex */
public final class b_renamed {
    public static final <T_renamed> void a_renamed(c_renamed.f_renamed.a_renamed.b_renamed<? super c_renamed.c_renamed.d_renamed<? super T_renamed>, ? extends java.lang.Object> bVar, c_renamed.c_renamed.d_renamed<? super T_renamed> dVar) {
        c_renamed.c_renamed.d_renamed dVarA = c_renamed.c_renamed.b_renamed.a_renamed.g_renamed.a_renamed(dVar);
        try {
            c_renamed.c_renamed.g_renamed context = dVar.getContext();
            java.lang.Object objA = kotlinx.coroutines.internal.v_renamed.a_renamed(context, null);
            try {
                if (bVar != null) {
                    java.lang.Object objInvoke = ((c_renamed.f_renamed.a_renamed.b_renamed) c_renamed.f_renamed.b_renamed.m_renamed.b_renamed(bVar, 1)).invoke(dVarA);
                    if (objInvoke != c_renamed.c_renamed.a_renamed.b_renamed.a_renamed()) {
                        c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
                        dVarA.resumeWith(c_renamed.m_renamed.m4constructorimpl(objInvoke));
                        return;
                    }
                    return;
                }
                throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type (kotlin.coroutines.Continuation<T_renamed>) -> kotlin.Any?");
            } finally {
                kotlinx.coroutines.internal.v_renamed.b_renamed(context, objA);
            }
        } catch (java.lang.Throwable th) {
            c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
            dVarA.resumeWith(c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th)));
        }
    }

    public static final <R_renamed, T_renamed> void a_renamed(c_renamed.f_renamed.a_renamed.m_renamed<? super R_renamed, ? super c_renamed.c_renamed.d_renamed<? super T_renamed>, ? extends java.lang.Object> mVar, R_renamed r_renamed, c_renamed.c_renamed.d_renamed<? super T_renamed> dVar) {
        c_renamed.c_renamed.d_renamed dVarA = c_renamed.c_renamed.b_renamed.a_renamed.g_renamed.a_renamed(dVar);
        try {
            c_renamed.c_renamed.g_renamed context = dVar.getContext();
            java.lang.Object objA = kotlinx.coroutines.internal.v_renamed.a_renamed(context, null);
            try {
                if (mVar != null) {
                    java.lang.Object objInvoke = ((c_renamed.f_renamed.a_renamed.m_renamed) c_renamed.f_renamed.b_renamed.m_renamed.b_renamed(mVar, 2)).invoke(r_renamed, dVarA);
                    if (objInvoke != c_renamed.c_renamed.a_renamed.b_renamed.a_renamed()) {
                        c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
                        dVarA.resumeWith(c_renamed.m_renamed.m4constructorimpl(objInvoke));
                        return;
                    }
                    return;
                }
                throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type (R_renamed, kotlin.coroutines.Continuation<T_renamed>) -> kotlin.Any?");
            } finally {
                kotlinx.coroutines.internal.v_renamed.b_renamed(context, objA);
            }
        } catch (java.lang.Throwable th) {
            c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
            dVarA.resumeWith(c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th)));
        }
    }
}
