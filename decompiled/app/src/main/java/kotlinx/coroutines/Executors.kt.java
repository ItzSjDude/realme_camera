package kotlinx.coroutines;

/* compiled from: Executors.kt */
/* loaded from: classes2.dex */
public abstract class ar_renamed extends kotlinx.coroutines.t_renamed implements java.io.Closeable {
    public static final kotlinx.coroutines.ar_renamed.a_renamed d_renamed = new kotlinx.coroutines.ar_renamed.a_renamed(null);

    /* compiled from: Executors.kt */
    public static final class a_renamed extends c_renamed.c_renamed.b_renamed<kotlinx.coroutines.t_renamed, kotlinx.coroutines.ar_renamed> {
        public /* synthetic */ a_renamed(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }

        /* compiled from: Executors.kt */
        /* renamed from: kotlinx.coroutines.ar_renamed$a_renamed$1, reason: invalid class name */
        static final class SceneLoader_2 extends c_renamed.f_renamed.b_renamed.i_renamed implements c_renamed.f_renamed.a_renamed.b_renamed<c_renamed.c_renamed.g_renamed.b_renamed, kotlinx.coroutines.ar_renamed> {
            public static final kotlinx.coroutines.ar_renamed.a_renamed.SceneLoader_2 INSTANCE = new kotlinx.coroutines.ar_renamed.a_renamed.SceneLoader_2();

            SceneLoader_2() {
                super(1);
            }

            @Override // c_renamed.f_renamed.a_renamed.b_renamed
            public final kotlinx.coroutines.ar_renamed invoke(c_renamed.c_renamed.g_renamed.b_renamed bVar) {
                if (!(bVar instanceof kotlinx.coroutines.ar_renamed)) {
                    bVar = null;
                }
                return (kotlinx.coroutines.ar_renamed) bVar;
            }
        }

        private a_renamed() {
            super(kotlinx.coroutines.t_renamed.f7904c, kotlinx.coroutines.ar_renamed.a_renamed.SceneLoader_2.INSTANCE);
        }
    }
}
