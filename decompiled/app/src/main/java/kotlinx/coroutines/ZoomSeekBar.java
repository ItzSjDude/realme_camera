package kotlinx.coroutines;

/* compiled from: DispatchedTask.kt */
/* loaded from: classes2.dex */
public final class ai_renamed {
    public static final boolean a_renamed(int i_renamed) {
        return i_renamed == 1;
    }

    public static final boolean b_renamed(int i_renamed) {
        return i_renamed == 0 || i_renamed == 1;
    }

    public static final <T_renamed> void a_renamed(kotlinx.coroutines.ah_renamed<? super T_renamed> ahVar, int i_renamed) {
        c_renamed.c_renamed.d_renamed<? super T_renamed> dVarE = ahVar.e_renamed();
        if (b_renamed(i_renamed) && (dVarE instanceof kotlinx.coroutines.af_renamed) && a_renamed(i_renamed) == a_renamed(ahVar.e_renamed)) {
            kotlinx.coroutines.t_renamed tVar = ((kotlinx.coroutines.af_renamed) dVarE).f7790c;
            c_renamed.c_renamed.g_renamed context = dVarE.getContext();
            if (tVar.a_renamed(context)) {
                tVar.a_renamed(context, ahVar);
                return;
            } else {
                a_renamed(ahVar);
                return;
            }
        }
        a_renamed(ahVar, dVarE, i_renamed);
    }

    public static final <T_renamed> void a_renamed(kotlinx.coroutines.ah_renamed<? super T_renamed> ahVar, c_renamed.c_renamed.d_renamed<? super T_renamed> dVar, int i_renamed) {
        java.lang.Object objA;
        java.lang.Object objB = ahVar.b_renamed();
        java.lang.Throwable thB = ahVar.b_renamed(objB);
        if (thB == null) {
            thB = null;
        } else if (kotlinx.coroutines.ac_renamed.c_renamed() && (dVar instanceof c_renamed.c_renamed.b_renamed.a_renamed.d_renamed)) {
            thB = kotlinx.coroutines.internal.q_renamed.b_renamed(thB, (c_renamed.c_renamed.b_renamed.a_renamed.d_renamed) dVar);
        }
        if (thB != null) {
            c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
            objA = c_renamed.n_renamed.a_renamed(thB);
        } else {
            c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
            objA = ahVar.a_renamed(objB);
        }
        java.lang.Object objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(objA);
        if (i_renamed == 0) {
            dVar.resumeWith(objM4constructorimpl);
            return;
        }
        if (i_renamed == 1) {
            kotlinx.coroutines.ag_renamed.a_renamed(dVar, objM4constructorimpl);
            return;
        }
        if (i_renamed != 2) {
            throw new java.lang.IllegalStateException(("Invalid mode " + i_renamed).toString());
        }
        if (dVar != null) {
            kotlinx.coroutines.af_renamed afVar = (kotlinx.coroutines.af_renamed) dVar;
            c_renamed.c_renamed.g_renamed context = afVar.getContext();
            java.lang.Object objA2 = kotlinx.coroutines.internal.v_renamed.a_renamed(context, afVar.f7789b);
            try {
                afVar.d_renamed.resumeWith(objM4constructorimpl);
                c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
                return;
            } finally {
                kotlinx.coroutines.internal.v_renamed.b_renamed(context, objA2);
            }
        }
        throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.DispatchedContinuation<T_renamed>");
    }

    private static final void a_renamed(kotlinx.coroutines.ah_renamed<?> ahVar) {
        kotlinx.coroutines.am_renamed amVarA = kotlinx.coroutines.bm_renamed.f7847a.a_renamed();
        if (amVarA.f_renamed()) {
            amVarA.a_renamed(ahVar);
            return;
        }
        amVarA.a_renamed(true);
        try {
            try {
                a_renamed(ahVar, ahVar.e_renamed(), 2);
                do {
                } while (amVarA.e_renamed());
            } catch (java.lang.Throwable th) {
                ahVar.a_renamed(th, (java.lang.Throwable) null);
            }
        } finally {
            amVarA.b_renamed(true);
        }
    }
}
