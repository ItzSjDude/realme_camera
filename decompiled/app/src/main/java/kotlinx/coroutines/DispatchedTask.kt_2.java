package kotlinx.coroutines;

import kotlinx.coroutines.internal.StackTraceRecovery.kt;
import kotlinx.coroutines.internal.ThreadContext.kt;
import p061c.Result.kt;
import p061c.Result.kt_4;
import p061c.Unit.kt;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p064c.p066b.p067a.CoroutineStackFrame.kt;

/* compiled from: DispatchedTask.kt */
/* renamed from: kotlinx.coroutines.ai */
/* loaded from: classes2.dex */
public final class DispatchedTask.kt_2 {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final boolean m25599a(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final boolean m25600b(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 0 || OplusGLSurfaceView_13 == 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> void m25597a(DispatchedTask.kt<? super T> abstractC3861ah, int OplusGLSurfaceView_13) {
        Continuation.kt_2<? super T> interfaceC0929dMo25589e = abstractC3861ah.mo25589e();
        if (m25600b(OplusGLSurfaceView_13) && (interfaceC0929dMo25589e instanceof DispatchedContinuation.kt_2) && m25599a(OplusGLSurfaceView_13) == m25599a(abstractC3861ah.f24566e)) {
            CoroutineDispatcher.kt abstractC3958t = ((DispatchedContinuation.kt_2) interfaceC0929dMo25589e).f24561c;
            CoroutineContext.kt_4 context = interfaceC0929dMo25589e.getContext();
            if (abstractC3958t.mo25640a(context)) {
                abstractC3958t.mo25629a(context, abstractC3861ah);
                return;
            } else {
                m25596a(abstractC3861ah);
                return;
            }
        }
        m25598a(abstractC3861ah, interfaceC0929dMo25589e, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> void m25598a(DispatchedTask.kt<? super T> abstractC3861ah, Continuation.kt_2<? super T> interfaceC0929d, int OplusGLSurfaceView_13) {
        Object objMo25592a;
        Object objMo25588b = abstractC3861ah.mo25588b();
        Throwable thM25595b = abstractC3861ah.m25595b(objMo25588b);
        if (thM25595b == null) {
            thM25595b = null;
        } else if (Debug.kt.m25576c() && (interfaceC0929d instanceof CoroutineStackFrame.kt)) {
            thM25595b = StackTraceRecovery.kt.m25897b(thM25595b, (CoroutineStackFrame.kt) interfaceC0929d);
        }
        if (thM25595b != null) {
            Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
            objMo25592a = Result.kt_4.m5380a(thM25595b);
        } else {
            Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
            objMo25592a = abstractC3861ah.mo25592a(objMo25588b);
        }
        Object objM26270constructorimpl = Result.kt.m26270constructorimpl(objMo25592a);
        if (OplusGLSurfaceView_13 == 0) {
            interfaceC0929d.resumeWith(objM26270constructorimpl);
            return;
        }
        if (OplusGLSurfaceView_13 == 1) {
            DispatchedContinuation.kt.m25591a(interfaceC0929d, objM26270constructorimpl);
            return;
        }
        if (OplusGLSurfaceView_13 != 2) {
            throw new IllegalStateException(("Invalid mode " + OplusGLSurfaceView_13).toString());
        }
        if (interfaceC0929d != null) {
            DispatchedContinuation.kt_2 c3859af = (DispatchedContinuation.kt_2) interfaceC0929d;
            CoroutineContext.kt_4 context = c3859af.getContext();
            Object objM25913a = ThreadContext.kt.m25913a(context, c3859af.f24560b);
            try {
                c3859af.f24562d.resumeWith(objM26270constructorimpl);
                Unit.kt c1025s = Unit.kt.f5071a;
                return;
            } finally {
                ThreadContext.kt.m25914b(context, objM25913a);
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static final void m25596a(DispatchedTask.kt<?> abstractC3861ah) {
        EventLoop.common.kt abstractC3866amM25795a = EventLoop.common.kt_5.f24668a.m25795a();
        if (abstractC3866amM25795a.m25616f()) {
            abstractC3866amM25795a.m25609a(abstractC3861ah);
            return;
        }
        abstractC3866amM25795a.m25610a(true);
        try {
            try {
                m25598a(abstractC3861ah, abstractC3861ah.mo25589e(), 2);
                do {
                } while (abstractC3866amM25795a.m25615e());
            } catch (Throwable th) {
                abstractC3861ah.m25594a(th, (Throwable) null);
            }
        } finally {
            abstractC3866amM25795a.m25612b(true);
        }
    }
}
