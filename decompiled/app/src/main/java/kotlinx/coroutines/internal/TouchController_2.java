package kotlinx.coroutines.internal;

/* compiled from: MainDispatchers.kt */
/* loaded from: classes2.dex */
public final class m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final boolean f7881a = true;

    public static final kotlinx.coroutines.bf_renamed a_renamed(kotlinx.coroutines.internal.MainDispatcherFactory.kt mainDispatcherFactory, java.util.List<? extends kotlinx.coroutines.internal.MainDispatcherFactory.kt> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (java.lang.Throwable th) {
            return a_renamed(th, mainDispatcherFactory.hintOnError());
        }
    }

    static /* synthetic */ kotlinx.coroutines.internal.n_renamed a_renamed(java.lang.Throwable th, java.lang.String str, int i_renamed, java.lang.Object obj) {
        if ((i_renamed & 1) != 0) {
            th = (java.lang.Throwable) null;
        }
        if ((i_renamed & 2) != 0) {
            str = (java.lang.String) null;
        }
        return a_renamed(th, str);
    }

    private static final kotlinx.coroutines.internal.n_renamed a_renamed(java.lang.Throwable th, java.lang.String str) throws java.lang.Throwable {
        if (f7881a) {
            return new kotlinx.coroutines.internal.n_renamed(th, str);
        }
        if (th != null) {
            throw th;
        }
        a_renamed();
        throw new c_renamed.e_renamed();
    }

    public static final java.lang.Void a_renamed() {
        throw new java.lang.IllegalStateException("Module with the Main dispatcher is_renamed missing. Add dependency providing the Main dispatcher, e_renamed.g_renamed. 'kotlinx-coroutines-android' and ensure it has the same version as_renamed 'kotlinx-coroutines-core'");
    }
}
