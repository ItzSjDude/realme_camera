package kotlinx.coroutines;

/* compiled from: CoroutineStart.kt */
/* loaded from: classes2.dex */
public enum z_renamed {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public static /* synthetic */ void isLazy$annotations() {
    }

    public final <T_renamed> void invoke(c_renamed.f_renamed.a_renamed.b_renamed<? super c_renamed.c_renamed.d_renamed<? super T_renamed>, ? extends java.lang.Object> bVar, c_renamed.c_renamed.d_renamed<? super T_renamed> dVar) {
        int i_renamed = kotlinx.coroutines.aa_renamed.f7782a[ordinal()];
        if (i_renamed == 1) {
            kotlinx.coroutines.a_renamed.a_renamed.a_renamed(bVar, dVar);
            return;
        }
        if (i_renamed == 2) {
            c_renamed.c_renamed.f_renamed.a_renamed(bVar, dVar);
        } else if (i_renamed == 3) {
            kotlinx.coroutines.a_renamed.b_renamed.a_renamed(bVar, dVar);
        } else if (i_renamed != 4) {
            throw new c_renamed.k_renamed();
        }
    }

    public final <R_renamed, T_renamed> void invoke(c_renamed.f_renamed.a_renamed.m_renamed<? super R_renamed, ? super c_renamed.c_renamed.d_renamed<? super T_renamed>, ? extends java.lang.Object> mVar, R_renamed r_renamed, c_renamed.c_renamed.d_renamed<? super T_renamed> dVar) {
        int i_renamed = kotlinx.coroutines.aa_renamed.f7783b[ordinal()];
        if (i_renamed == 1) {
            kotlinx.coroutines.a_renamed.a_renamed.a_renamed(mVar, r_renamed, dVar);
            return;
        }
        if (i_renamed == 2) {
            c_renamed.c_renamed.f_renamed.a_renamed(mVar, r_renamed, dVar);
        } else if (i_renamed == 3) {
            kotlinx.coroutines.a_renamed.b_renamed.a_renamed(mVar, r_renamed, dVar);
        } else if (i_renamed != 4) {
            throw new c_renamed.k_renamed();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }
}
