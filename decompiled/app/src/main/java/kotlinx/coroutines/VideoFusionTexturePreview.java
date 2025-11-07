package kotlinx.coroutines;

/* compiled from: DebugStrings.kt */
/* loaded from: classes2.dex */
public final class ad_renamed {
    public static final java.lang.String a_renamed(java.lang.Object obj) {
        return java.lang.Integer.toHexString(java.lang.System.identityHashCode(obj));
    }

    public static final java.lang.String a_renamed(c_renamed.c_renamed.d_renamed<?> dVar) {
        java.lang.Object objM4constructorimpl;
        if (dVar instanceof kotlinx.coroutines.af_renamed) {
            return dVar.toString();
        }
        try {
            c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
            objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(dVar + '@' + a_renamed((java.lang.Object) dVar));
        } catch (java.lang.Throwable th) {
            c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
            objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th));
        }
        if (c_renamed.m_renamed.m7exceptionOrNullimpl(objM4constructorimpl) != null) {
            objM4constructorimpl = dVar.getClass().getName() + '@' + a_renamed((java.lang.Object) dVar);
        }
        return (java.lang.String) objM4constructorimpl;
    }

    public static final java.lang.String b_renamed(java.lang.Object obj) {
        return obj.getClass().getSimpleName();
    }
}
