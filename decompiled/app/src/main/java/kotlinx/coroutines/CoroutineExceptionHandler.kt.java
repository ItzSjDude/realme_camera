package kotlinx.coroutines;

import p061c.Exceptions.kt_2;
import p061c.p064c.CoroutineContext.kt_4;

/* compiled from: CoroutineExceptionHandler.kt_2.kt */
/* renamed from: kotlinx.coroutines.v */
/* loaded from: classes2.dex */
public final class CoroutineExceptionHandler.kt_2.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final void m25946a(CoroutineContext.kt_4 interfaceC0932g, Throwable th) {
        try {
            CoroutineExceptionHandler.kt_2 coroutineExceptionHandler = (CoroutineExceptionHandler.kt_2) interfaceC0932g.get(CoroutineExceptionHandler.kt_2.f24546a);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(interfaceC0932g, th);
            } else {
                CoroutineExceptionHandlerImpl.kt.m25944a(interfaceC0932g, th);
            }
        } catch (Throwable th2) {
            CoroutineExceptionHandlerImpl.kt.m25944a(interfaceC0932g, m25945a(th, th2));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Throwable m25945a(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        Exceptions.kt_2.m5247a(runtimeException, th);
        return runtimeException;
    }
}
