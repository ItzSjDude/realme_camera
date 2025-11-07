package kotlinx.coroutines.android;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes2.dex */
public final class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.android.b_renamed f7804a;

    public static final android.os.Handler a_renamed(android.os.Looper looper, boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (!z_renamed || android.os.Build.VERSION.SDK_INT < 16) {
            return new android.os.Handler(looper);
        }
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            java.lang.Object objInvoke = android.os.Handler.class.getDeclaredMethod("createAsync", android.os.Looper.class).invoke(null, looper);
            if (objInvoke != null) {
                return (android.os.Handler) objInvoke;
            }
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type android.os.Handler");
        }
        try {
            return (android.os.Handler) android.os.Handler.class.getDeclaredConstructor(android.os.Looper.class, android.os.Handler.Callback.class, java.lang.Boolean.TYPE).newInstance(looper, null, true);
        } catch (java.lang.NoSuchMethodException unused) {
            return new android.os.Handler(looper);
        }
    }

    static {
        java.lang.Object objM4constructorimpl;
        try {
            c_renamed.m_renamed.a_renamed aVar = c_renamed.m_renamed.Companion;
            objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(new kotlinx.coroutines.android.a_renamed(a_renamed(android.os.Looper.getMainLooper(), true), null, 2, null));
        } catch (java.lang.Throwable th) {
            c_renamed.m_renamed.a_renamed aVar2 = c_renamed.m_renamed.Companion;
            objM4constructorimpl = c_renamed.m_renamed.m4constructorimpl(c_renamed.n_renamed.a_renamed(th));
        }
        f7804a = (kotlinx.coroutines.android.b_renamed) (c_renamed.m_renamed.m10isFailureimpl(objM4constructorimpl) ? null : objM4constructorimpl);
    }
}
