package kotlinx.coroutines.internal;

/* compiled from: FastServiceLoader.kt */
/* loaded from: classes2.dex */
public final class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final boolean f7868a;

    static {
        java.lang.Object objM4constructorimpl;
        try {
            c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
            objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(java.lang.Class.forName("android.os.Build"));
        } catch (java.lang.Throwable th) {
            c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
            objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th));
        }
        f7868a = c_renamed.m_renamed.m11isSuccessimpl(objM4constructorimpl);
    }

    public static final boolean a_renamed() {
        return f7868a;
    }
}
