package c_renamed;

/* compiled from: Result.kt */
/* loaded from: classes.dex */
public final class n_renamed {
    public static final java.lang.Object a_renamed(java.lang.Throwable th) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(th, "exception");
        return new c_renamed.m_renamed.b_renamed(th);
    }

    public static final void a_renamed(java.lang.Object obj) {
        if (obj instanceof c_renamed.m_renamed.b_renamed) {
            throw ((c_renamed.m_renamed.b_renamed) obj).exception;
        }
    }
}
