package c_renamed.c_renamed;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes.dex */
public interface g_renamed {

    /* compiled from: CoroutineContext.kt */
    public interface c_renamed<E_renamed extends c_renamed.c_renamed.g_renamed.b_renamed> {
    }

    <R_renamed> R_renamed fold(R_renamed r_renamed, c_renamed.f_renamed.a_renamed.m_renamed<? super R_renamed, ? super c_renamed.c_renamed.g_renamed.b_renamed, ? extends R_renamed> mVar);

    <E_renamed extends c_renamed.c_renamed.g_renamed.b_renamed> E_renamed get(c_renamed.c_renamed.g_renamed.c_renamed<E_renamed> cVar);

    c_renamed.c_renamed.g_renamed minusKey(c_renamed.c_renamed.g_renamed.c_renamed<?> cVar);

    c_renamed.c_renamed.g_renamed plus(c_renamed.c_renamed.g_renamed gVar);

    /* compiled from: CoroutineContext.kt */
    public static final class a_renamed {
        public static c_renamed.c_renamed.g_renamed a_renamed(c_renamed.c_renamed.g_renamed gVar, c_renamed.c_renamed.g_renamed gVar2) {
            c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(gVar2, "context");
            return gVar2 == c_renamed.c_renamed.h_renamed.INSTANCE ? gVar : (c_renamed.c_renamed.g_renamed) gVar2.fold(gVar, c_renamed.c_renamed.g_renamed.a_renamed.CoroutineContext.kt_4.INSTANCE);
        }

        /* compiled from: CoroutineContext.kt */
        /* renamed from: c_renamed.c_renamed.g_renamed$a_renamed$a_renamed, reason: collision with other inner class name */
        static final class CoroutineContext.kt_4 extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.m_renamed<c_renamed.c_renamed.g_renamed, c_renamed.c_renamed.g_renamed.b_renamed, c_renamed.c_renamed.g_renamed> {
            public static final c_renamed.c_renamed.g_renamed.a_renamed.CoroutineContext.kt_4 INSTANCE = new c_renamed.c_renamed.g_renamed.a_renamed.CoroutineContext.kt_4();

            CoroutineContext.kt_4() {
                super(2);
            }

            @Override // c_renamed.f_renamed.a_renamed.m_renamed
            public final c_renamed.c_renamed.g_renamed invoke(c_renamed.c_renamed.g_renamed gVar, c_renamed.c_renamed.g_renamed.b_renamed bVar) {
                c_renamed.c_renamed.c_renamed cVar;
                c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(gVar, "acc");
                c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(bVar, "element");
                c_renamed.c_renamed.g_renamed gVarMinusKey = gVar.minusKey(bVar.getKey());
                if (gVarMinusKey == c_renamed.c_renamed.h_renamed.INSTANCE) {
                    return bVar;
                }
                c_renamed.c_renamed.e_renamed eVar = (c_renamed.c_renamed.e_renamed) gVarMinusKey.get(c_renamed.c_renamed.e_renamed.f1897a);
                if (eVar == null) {
                    cVar = new c_renamed.c_renamed.c_renamed(gVarMinusKey, bVar);
                } else {
                    c_renamed.c_renamed.g_renamed gVarMinusKey2 = gVarMinusKey.minusKey(c_renamed.c_renamed.e_renamed.f1897a);
                    cVar = gVarMinusKey2 == c_renamed.c_renamed.h_renamed.INSTANCE ? new c_renamed.c_renamed.c_renamed(bVar, eVar) : new c_renamed.c_renamed.c_renamed(new c_renamed.c_renamed.c_renamed(gVarMinusKey2, bVar), eVar);
                }
                return cVar;
            }
        }
    }

    /* compiled from: CoroutineContext.kt */
    public interface b_renamed extends c_renamed.c_renamed.g_renamed {
        @Override // c_renamed.c_renamed.g_renamed
        <E_renamed extends c_renamed.c_renamed.g_renamed.b_renamed> E_renamed get(c_renamed.c_renamed.g_renamed.c_renamed<E_renamed> cVar);

        c_renamed.c_renamed.g_renamed.c_renamed<?> getKey();

        /* compiled from: CoroutineContext.kt */
        public static final class a_renamed {
            public static c_renamed.c_renamed.g_renamed a_renamed(c_renamed.c_renamed.g_renamed.b_renamed bVar, c_renamed.c_renamed.g_renamed gVar) {
                c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(gVar, "context");
                return c_renamed.c_renamed.g_renamed.a_renamed.a_renamed(bVar, gVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E_renamed extends c_renamed.c_renamed.g_renamed.b_renamed> E_renamed a_renamed(c_renamed.c_renamed.g_renamed.b_renamed bVar, c_renamed.c_renamed.g_renamed.c_renamed<E_renamed> cVar) {
                c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cVar, "key");
                if (!c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(bVar.getKey(), cVar)) {
                    return null;
                }
                if (bVar != 0) {
                    return bVar;
                }
                throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type E_renamed");
            }

            public static <R_renamed> R_renamed a_renamed(c_renamed.c_renamed.g_renamed.b_renamed bVar, R_renamed r_renamed, c_renamed.f_renamed.a_renamed.m_renamed<? super R_renamed, ? super c_renamed.c_renamed.g_renamed.b_renamed, ? extends R_renamed> mVar) {
                c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(mVar, "operation");
                return mVar.invoke(r_renamed, bVar);
            }

            public static c_renamed.c_renamed.g_renamed b_renamed(c_renamed.c_renamed.g_renamed.b_renamed bVar, c_renamed.c_renamed.g_renamed.c_renamed<?> cVar) {
                c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cVar, "key");
                boolean zA = c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(bVar.getKey(), cVar);
                c_renamed.c_renamed.g_renamed gVar = bVar;
                if (zA) {
                    gVar = c_renamed.c_renamed.h_renamed.INSTANCE;
                }
                return gVar;
            }
        }
    }
}
