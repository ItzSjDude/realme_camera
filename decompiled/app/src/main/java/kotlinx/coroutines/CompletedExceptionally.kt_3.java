package kotlinx.coroutines;

import kotlinx.coroutines.internal.StackTraceRecovery.kt;
import p061c.Result.kt;
import p061c.p064c.p066b.p067a.CoroutineStackFrame.kt;

/* compiled from: CompletedExceptionally.kt */
/* renamed from: kotlinx.coroutines.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public final class CompletedExceptionally.kt_3 {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> Object m25939a(Object obj) {
        Throwable thM26273exceptionOrNullimpl = Result.kt.m26273exceptionOrNullimpl(obj);
        return thM26273exceptionOrNullimpl == null ? obj : new CompletedExceptionally.kt(thM26273exceptionOrNullimpl, false, 2, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> Object m25940a(Object obj, CancellableContinuation.kt<?> interfaceC3918e) {
        Throwable thM26273exceptionOrNullimpl = Result.kt.m26273exceptionOrNullimpl(obj);
        if (thM26273exceptionOrNullimpl != null) {
            CancellableContinuation.kt<?> interfaceC3918e2 = interfaceC3918e;
            if (Debug.kt.m25576c() && (interfaceC3918e2 instanceof CoroutineStackFrame.kt)) {
                thM26273exceptionOrNullimpl = StackTraceRecovery.kt.m25897b(thM26273exceptionOrNullimpl, (CoroutineStackFrame.kt) interfaceC3918e2);
            }
            obj = new CompletedExceptionally.kt(thM26273exceptionOrNullimpl, false, 2, null);
        }
        return obj;
    }
}
