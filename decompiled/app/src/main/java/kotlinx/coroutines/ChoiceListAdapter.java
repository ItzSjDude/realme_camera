package kotlinx.coroutines;

/* compiled from: CoroutineExceptionHandler.kt_2.kt */
/* loaded from: classes2.dex */
public final class v_renamed {
    public static final void a_renamed(c_renamed.c_renamed.g_renamed gVar, java.lang.Throwable th) {
        try {
            kotlinx.coroutines.CoroutineExceptionHandler.kt_2 coroutineExceptionHandler = (kotlinx.coroutines.CoroutineExceptionHandler.kt_2) gVar.get(kotlinx.coroutines.CoroutineExceptionHandler.kt_2.f7778a);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(gVar, th);
            } else {
                kotlinx.coroutines.u_renamed.a_renamed(gVar, th);
            }
        } catch (java.lang.Throwable th2) {
            kotlinx.coroutines.u_renamed.a_renamed(gVar, a_renamed(th, th2));
        }
    }

    public static final java.lang.Throwable a_renamed(java.lang.Throwable th, java.lang.Throwable th2) {
        if (th == th2) {
            return th;
        }
        java.lang.RuntimeException runtimeException = new java.lang.RuntimeException("Exception while trying to handle coroutine exception", th2);
        c_renamed.a_renamed.a_renamed(runtimeException, th);
        return runtimeException;
    }
}
