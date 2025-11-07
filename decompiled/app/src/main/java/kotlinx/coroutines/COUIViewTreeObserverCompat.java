package kotlinx.coroutines;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* loaded from: classes2.dex */
public final class u_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.List<kotlinx.coroutines.CoroutineExceptionHandler.kt_2> f7905a = c_renamed.j_renamed.c_renamed.b_renamed(c_renamed.j_renamed.c_renamed.a_renamed(java.util.ServiceLoader.load(kotlinx.coroutines.CoroutineExceptionHandler.kt_2.class, kotlinx.coroutines.CoroutineExceptionHandler.kt_2.class.getClassLoader()).iterator()));

    public static final void a_renamed(c_renamed.c_renamed.g_renamed gVar, java.lang.Throwable th) {
        java.util.Iterator<kotlinx.coroutines.CoroutineExceptionHandler.kt_2> it = f7905a.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(gVar, th);
            } catch (java.lang.Throwable th2) {
                java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, kotlinx.coroutines.v_renamed.a_renamed(th, th2));
            }
        }
        java.lang.Thread threadCurrentThread2 = java.lang.Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }
}
