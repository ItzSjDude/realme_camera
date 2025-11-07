package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.common.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class d_renamed {
    public static /* synthetic */ kotlinx.coroutines.ay_renamed a_renamed(kotlinx.coroutines.y_renamed yVar, c_renamed.c_renamed.g_renamed gVar, kotlinx.coroutines.z_renamed zVar, c_renamed.f_renamed.a_renamed.m_renamed mVar, int i_renamed, java.lang.Object obj) {
        if ((i_renamed & 1) != 0) {
            gVar = c_renamed.c_renamed.h_renamed.INSTANCE;
        }
        if ((i_renamed & 2) != 0) {
            zVar = kotlinx.coroutines.z_renamed.DEFAULT;
        }
        return kotlinx.coroutines.c_renamed.a_renamed(yVar, gVar, zVar, mVar);
    }

    public static final kotlinx.coroutines.ay_renamed a_renamed(kotlinx.coroutines.y_renamed yVar, c_renamed.c_renamed.g_renamed gVar, kotlinx.coroutines.z_renamed zVar, c_renamed.f_renamed.a_renamed.m_renamed<? super kotlinx.coroutines.y_renamed, ? super c_renamed.c_renamed.d_renamed<? super c_renamed.s_renamed>, ? extends java.lang.Object> mVar) {
        kotlinx.coroutines.be_renamed bkVar;
        c_renamed.c_renamed.g_renamed gVarA = kotlinx.coroutines.s_renamed.a_renamed(yVar, gVar);
        if (zVar.isLazy()) {
            bkVar = new kotlinx.coroutines.be_renamed(gVarA, mVar);
        } else {
            bkVar = new kotlinx.coroutines.bk_renamed(gVarA, true);
        }
        bkVar.a_renamed(zVar, (kotlinx.coroutines.z_renamed) bkVar, (c_renamed.f_renamed.a_renamed.m_renamed<? super kotlinx.coroutines.z_renamed, ? super c_renamed.c_renamed.d_renamed<? super T_renamed>, ? extends java.lang.Object>) mVar);
        return bkVar;
    }
}
