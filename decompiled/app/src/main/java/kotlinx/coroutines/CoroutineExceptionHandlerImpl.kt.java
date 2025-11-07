package kotlinx.coroutines;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p076j.C0995c;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* renamed from: kotlinx.coroutines.u */
/* loaded from: classes2.dex */
public final class CoroutineExceptionHandlerImpl.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final List<CoroutineExceptionHandler.kt_2> f24740a = C0995c.m5344b(C0995c.m5342a(ServiceLoader.load(CoroutineExceptionHandler.kt_2.class, CoroutineExceptionHandler.kt_2.class.getClassLoader()).iterator()));

    /* renamed from: PlatformImplementations.kt_3 */
    public static final void m25944a(CoroutineContext.kt_4 interfaceC0932g, Throwable th) {
        Iterator<CoroutineExceptionHandler.kt_2> it = f24740a.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(interfaceC0932g, th);
            } catch (Throwable th2) {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, CoroutineExceptionHandler.kt_2.kt.m25945a(th, th2));
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }
}
