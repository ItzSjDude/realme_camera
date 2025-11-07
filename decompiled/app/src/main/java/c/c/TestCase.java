package c_renamed.c_renamed;

/* compiled from: ContinuationInterceptor.kt */
/* loaded from: classes.dex */
public interface e_renamed extends c_renamed.c_renamed.g_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final c_renamed.c_renamed.e_renamed.b_renamed f1897a = c_renamed.c_renamed.e_renamed.b_renamed.f1898a;

    <T_renamed> c_renamed.c_renamed.d_renamed<T_renamed> a_renamed(c_renamed.c_renamed.d_renamed<? super T_renamed> dVar);

    void b_renamed(c_renamed.c_renamed.d_renamed<?> dVar);

    /* compiled from: ContinuationInterceptor.kt */
    public static final class b_renamed implements c_renamed.c_renamed.g_renamed.c_renamed<c_renamed.c_renamed.e_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ c_renamed.c_renamed.e_renamed.b_renamed f1898a = new c_renamed.c_renamed.e_renamed.b_renamed();

        private b_renamed() {
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    public static final class a_renamed {
        public static <E_renamed extends c_renamed.c_renamed.g_renamed.b_renamed> E_renamed a_renamed(c_renamed.c_renamed.e_renamed eVar, c_renamed.c_renamed.g_renamed.c_renamed<E_renamed> cVar) {
            c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cVar, "key");
            if (cVar instanceof c_renamed.c_renamed.b_renamed) {
                c_renamed.c_renamed.b_renamed bVar = (c_renamed.c_renamed.b_renamed) cVar;
                if (!bVar.a_renamed(eVar.getKey())) {
                    return null;
                }
                E_renamed e_renamed = (E_renamed) bVar.a_renamed(eVar);
                if (e_renamed instanceof c_renamed.c_renamed.g_renamed.b_renamed) {
                    return e_renamed;
                }
                return null;
            }
            if (c_renamed.c_renamed.e_renamed.f1897a != cVar) {
                return null;
            }
            if (eVar != null) {
                return eVar;
            }
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type E_renamed");
        }

        public static c_renamed.c_renamed.g_renamed b_renamed(c_renamed.c_renamed.e_renamed eVar, c_renamed.c_renamed.g_renamed.c_renamed<?> cVar) {
            c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cVar, "key");
            if (cVar instanceof c_renamed.c_renamed.b_renamed) {
                c_renamed.c_renamed.b_renamed bVar = (c_renamed.c_renamed.b_renamed) cVar;
                boolean zA = bVar.a_renamed(eVar.getKey());
                c_renamed.c_renamed.g_renamed gVar = eVar;
                if (zA) {
                    c_renamed.c_renamed.g_renamed.b_renamed bVarA = bVar.a_renamed(eVar);
                    gVar = eVar;
                    if (bVarA != null) {
                        gVar = c_renamed.c_renamed.h_renamed.INSTANCE;
                    }
                }
                return gVar;
            }
            c_renamed.c_renamed.g_renamed gVar2 = eVar;
            if (c_renamed.c_renamed.e_renamed.f1897a == cVar) {
                gVar2 = c_renamed.c_renamed.h_renamed.INSTANCE;
            }
            return gVar2;
        }
    }
}
