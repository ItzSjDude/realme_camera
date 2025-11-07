package kotlinx.coroutines;

/* compiled from: DispatchedContinuation.kt */
/* loaded from: classes2.dex */
public final class ag_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.r_renamed f7792b = new kotlinx.coroutines.internal.r_renamed("UNDEFINED");

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.r_renamed f7791a = new kotlinx.coroutines.internal.r_renamed("REUSABLE_CLAIMED");

    public static final <T_renamed> void a_renamed(c_renamed.c_renamed.d_renamed<? super T_renamed> dVar, java.lang.Object obj) {
        boolean z_renamed;
        if (!(dVar instanceof kotlinx.coroutines.af_renamed)) {
            dVar.resumeWith(obj);
            return;
        }
        kotlinx.coroutines.af_renamed afVar = (kotlinx.coroutines.af_renamed) dVar;
        java.lang.Object objA = kotlinx.coroutines.m_renamed.a_renamed(obj);
        if (afVar.f7790c.a_renamed(afVar.getContext())) {
            afVar.f7788a = objA;
            afVar.e_renamed = 1;
            afVar.f7790c.a_renamed(afVar.getContext(), afVar);
            return;
        }
        kotlinx.coroutines.am_renamed amVarA = kotlinx.coroutines.bm_renamed.f7847a.a_renamed();
        if (amVarA.f_renamed()) {
            afVar.f7788a = objA;
            afVar.e_renamed = 1;
            amVarA.a_renamed((kotlinx.coroutines.ah_renamed<?>) afVar);
            return;
        }
        kotlinx.coroutines.af_renamed afVar2 = afVar;
        amVarA.a_renamed(true);
        try {
            try {
                kotlinx.coroutines.ay_renamed ayVar = (kotlinx.coroutines.ay_renamed) afVar.getContext().get(kotlinx.coroutines.ay_renamed.f7812b);
                if (ayVar == null || ayVar.b_renamed()) {
                    z_renamed = false;
                } else {
                    java.util.concurrent.CancellationException cancellationExceptionH = ayVar.h_renamed();
                    c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
                    afVar.resumeWith(c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed((java.lang.Throwable) cancellationExceptionH)));
                    z_renamed = true;
                }
                if (!z_renamed) {
                    c_renamed.c_renamed.g_renamed context = afVar.getContext();
                    java.lang.Object objA2 = kotlinx.coroutines.internal.v_renamed.a_renamed(context, afVar.f7789b);
                    try {
                        afVar.d_renamed.resumeWith(obj);
                        c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
                        kotlinx.coroutines.internal.v_renamed.b_renamed(context, objA2);
                    } catch (java.lang.Throwable th) {
                        kotlinx.coroutines.internal.v_renamed.b_renamed(context, objA2);
                        throw th;
                    }
                }
                while (amVarA.e_renamed()) {
                }
            } finally {
                amVarA.b_renamed(true);
            }
        } catch (java.lang.Throwable th2) {
            afVar2.a_renamed(th2, (java.lang.Throwable) null);
        }
    }
}
