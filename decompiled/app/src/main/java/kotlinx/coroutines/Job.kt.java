package kotlinx.coroutines;

/* compiled from: Job.kt */
/* loaded from: classes2.dex */
public interface ay_renamed extends c_renamed.c_renamed.g_renamed.b_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.ay_renamed.b_renamed f7812b = kotlinx.coroutines.ay_renamed.b_renamed.f7813a;

    kotlinx.coroutines.ak_renamed a_renamed(boolean z_renamed, boolean z2, c_renamed.f_renamed.a_renamed.b_renamed<? super java.lang.Throwable, c_renamed.s_renamed> bVar);

    kotlinx.coroutines.h_renamed a_renamed(kotlinx.coroutines.j_renamed jVar);

    boolean b_renamed();

    java.util.concurrent.CancellationException h_renamed();

    boolean i_renamed();

    /* compiled from: Job.kt */
    public static final class b_renamed implements c_renamed.c_renamed.g_renamed.c_renamed<kotlinx.coroutines.ay_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ kotlinx.coroutines.ay_renamed.b_renamed f7813a = new kotlinx.coroutines.ay_renamed.b_renamed();

        static {
            kotlinx.coroutines.CoroutineExceptionHandler.kt_2.a_renamed aVar = kotlinx.coroutines.CoroutineExceptionHandler.kt_2.f7778a;
        }

        private b_renamed() {
        }
    }

    /* compiled from: Job.kt */
    public static final class a_renamed {
        public static <E_renamed extends c_renamed.c_renamed.g_renamed.b_renamed> E_renamed a_renamed(kotlinx.coroutines.ay_renamed ayVar, c_renamed.c_renamed.g_renamed.c_renamed<E_renamed> cVar) {
            return (E_renamed) c_renamed.c_renamed.g_renamed.b_renamed.a_renamed.a_renamed(ayVar, cVar);
        }

        public static c_renamed.c_renamed.g_renamed a_renamed(kotlinx.coroutines.ay_renamed ayVar, c_renamed.c_renamed.g_renamed gVar) {
            return c_renamed.c_renamed.g_renamed.b_renamed.a_renamed.a_renamed(ayVar, gVar);
        }

        public static <R_renamed> R_renamed a_renamed(kotlinx.coroutines.ay_renamed ayVar, R_renamed r_renamed, c_renamed.f_renamed.a_renamed.m_renamed<? super R_renamed, ? super c_renamed.c_renamed.g_renamed.b_renamed, ? extends R_renamed> mVar) {
            return (R_renamed) c_renamed.c_renamed.g_renamed.b_renamed.a_renamed.a_renamed(ayVar, r_renamed, mVar);
        }

        public static c_renamed.c_renamed.g_renamed b_renamed(kotlinx.coroutines.ay_renamed ayVar, c_renamed.c_renamed.g_renamed.c_renamed<?> cVar) {
            return c_renamed.c_renamed.g_renamed.b_renamed.a_renamed.b_renamed(ayVar, cVar);
        }

        public static /* synthetic */ kotlinx.coroutines.ak_renamed a_renamed(kotlinx.coroutines.ay_renamed ayVar, boolean z_renamed, boolean z2, c_renamed.f_renamed.a_renamed.b_renamed bVar, int i_renamed, java.lang.Object obj) {
            if (obj != null) {
                throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in_renamed this target, function: invokeOnCompletion");
            }
            if ((i_renamed & 1) != 0) {
                z_renamed = false;
            }
            if ((i_renamed & 2) != 0) {
                z2 = true;
            }
            return ayVar.a_renamed(z_renamed, z2, bVar);
        }
    }
}
