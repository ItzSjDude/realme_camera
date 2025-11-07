package kotlinx.coroutines;

/* compiled from: ThreadContextElement.kt */
/* loaded from: classes2.dex */
public interface bl_renamed<S_renamed> extends c_renamed.c_renamed.g_renamed.b_renamed {

    /* compiled from: ThreadContextElement.kt */
    public static final class a_renamed {
        public static <S_renamed, E_renamed extends c_renamed.c_renamed.g_renamed.b_renamed> E_renamed a_renamed(kotlinx.coroutines.bl_renamed<S_renamed> blVar, c_renamed.c_renamed.g_renamed.c_renamed<E_renamed> cVar) {
            return (E_renamed) c_renamed.c_renamed.g_renamed.b_renamed.a_renamed.a_renamed(blVar, cVar);
        }

        public static <S_renamed> c_renamed.c_renamed.g_renamed a_renamed(kotlinx.coroutines.bl_renamed<S_renamed> blVar, c_renamed.c_renamed.g_renamed gVar) {
            return c_renamed.c_renamed.g_renamed.b_renamed.a_renamed.a_renamed(blVar, gVar);
        }

        public static <S_renamed, R_renamed> R_renamed a_renamed(kotlinx.coroutines.bl_renamed<S_renamed> blVar, R_renamed r_renamed, c_renamed.f_renamed.a_renamed.m_renamed<? super R_renamed, ? super c_renamed.c_renamed.g_renamed.b_renamed, ? extends R_renamed> mVar) {
            return (R_renamed) c_renamed.c_renamed.g_renamed.b_renamed.a_renamed.a_renamed(blVar, r_renamed, mVar);
        }

        public static <S_renamed> c_renamed.c_renamed.g_renamed b_renamed(kotlinx.coroutines.bl_renamed<S_renamed> blVar, c_renamed.c_renamed.g_renamed.c_renamed<?> cVar) {
            return c_renamed.c_renamed.g_renamed.b_renamed.a_renamed.b_renamed(blVar, cVar);
        }
    }

    void a_renamed(c_renamed.c_renamed.g_renamed gVar, S_renamed s_renamed);

    S_renamed b_renamed(c_renamed.c_renamed.g_renamed gVar);
}
