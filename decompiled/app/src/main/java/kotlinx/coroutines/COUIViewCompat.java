package kotlinx.coroutines;

/* compiled from: CoroutineDispatcher.kt */
/* loaded from: classes2.dex */
public abstract class t_renamed extends c_renamed.c_renamed.a_renamed implements c_renamed.c_renamed.e_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.t_renamed.a_renamed f7904c = new kotlinx.coroutines.t_renamed.a_renamed(null);

    public abstract void a_renamed(c_renamed.c_renamed.g_renamed gVar, java.lang.Runnable runnable);

    public boolean a_renamed(c_renamed.c_renamed.g_renamed gVar) {
        return true;
    }

    @Override // c_renamed.c_renamed.a_renamed, c_renamed.c_renamed.g_renamed.b_renamed, c_renamed.c_renamed.g_renamed
    public <E_renamed extends c_renamed.c_renamed.g_renamed.b_renamed> E_renamed get(c_renamed.c_renamed.g_renamed.c_renamed<E_renamed> cVar) {
        return (E_renamed) c_renamed.c_renamed.e_renamed.a_renamed.a_renamed(this, cVar);
    }

    @Override // c_renamed.c_renamed.a_renamed, c_renamed.c_renamed.g_renamed
    public c_renamed.c_renamed.g_renamed minusKey(c_renamed.c_renamed.g_renamed.c_renamed<?> cVar) {
        return c_renamed.c_renamed.e_renamed.a_renamed.b_renamed(this, cVar);
    }

    public t_renamed() {
        super(c_renamed.c_renamed.e_renamed.f1897a);
    }

    /* compiled from: CoroutineDispatcher.kt */
    public static final class a_renamed extends c_renamed.c_renamed.b_renamed<c_renamed.c_renamed.e_renamed, kotlinx.coroutines.t_renamed> {
        public /* synthetic */ a_renamed(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }

        /* compiled from: CoroutineDispatcher.kt */
        /* renamed from: kotlinx.coroutines.t_renamed$a_renamed$1, reason: invalid class name */
        static final class SceneLoader_2 extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.b_renamed<c_renamed.c_renamed.g_renamed.b_renamed, kotlinx.coroutines.t_renamed> {
            public static final kotlinx.coroutines.t_renamed.a_renamed.SceneLoader_2 INSTANCE = new kotlinx.coroutines.t_renamed.a_renamed.SceneLoader_2();

            SceneLoader_2() {
                super(1);
            }

            @Override // c_renamed.f_renamed.a_renamed.b_renamed
            public final kotlinx.coroutines.t_renamed invoke(c_renamed.c_renamed.g_renamed.b_renamed bVar) {
                if (!(bVar instanceof kotlinx.coroutines.t_renamed)) {
                    bVar = null;
                }
                return (kotlinx.coroutines.t_renamed) bVar;
            }
        }

        private a_renamed() {
            super(c_renamed.c_renamed.e_renamed.f1897a, kotlinx.coroutines.t_renamed.a_renamed.SceneLoader_2.INSTANCE);
        }
    }

    @Override // c_renamed.c_renamed.e_renamed
    public final <T_renamed> c_renamed.c_renamed.d_renamed<T_renamed> a_renamed(c_renamed.c_renamed.d_renamed<? super T_renamed> dVar) {
        return new kotlinx.coroutines.af_renamed(this, dVar);
    }

    @Override // c_renamed.c_renamed.e_renamed
    public void b_renamed(c_renamed.c_renamed.d_renamed<?> dVar) {
        if (dVar == null) {
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.DispatchedContinuation<*>");
        }
        kotlinx.coroutines.f_renamed<?> fVarA = ((kotlinx.coroutines.af_renamed) dVar).a_renamed();
        if (fVarA != null) {
            fVarA.c_renamed();
        }
    }

    public java.lang.String toString() {
        return kotlinx.coroutines.ad_renamed.b_renamed(this) + '@' + kotlinx.coroutines.ad_renamed.a_renamed(this);
    }
}
