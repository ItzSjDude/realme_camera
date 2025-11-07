package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.internal.Symbol.kt;
import kotlinx.coroutines.internal.ThreadContext.kt;
import p061c.Result.kt;
import p061c.Result.kt_4;
import p061c.Unit.kt;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.CoroutineContext.kt_4;

/* compiled from: DispatchedContinuation.kt */
/* renamed from: kotlinx.coroutines.ag */
/* loaded from: classes2.dex */
public final class DispatchedContinuation.kt {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final Symbol.kt f24565b = new Symbol.kt("UNDEFINED");

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Symbol.kt f24564a = new Symbol.kt("REUSABLE_CLAIMED");

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> void m25591a(Continuation.kt_2<? super T> interfaceC0929d, Object obj) {
        boolean z;
        if (!(interfaceC0929d instanceof DispatchedContinuation.kt_2)) {
            interfaceC0929d.resumeWith(obj);
            return;
        }
        DispatchedContinuation.kt_2 c3859af = (DispatchedContinuation.kt_2) interfaceC0929d;
        Object objM25939a = CompletedExceptionally.kt_3.m25939a(obj);
        if (c3859af.f24561c.mo25640a(c3859af.getContext())) {
            c3859af.f24559a = objM25939a;
            c3859af.f24566e = 1;
            c3859af.f24561c.mo25629a(c3859af.getContext(), c3859af);
            return;
        }
        EventLoop.common.kt abstractC3866amM25795a = EventLoop.common.kt_5.f24668a.m25795a();
        if (abstractC3866amM25795a.m25616f()) {
            c3859af.f24559a = objM25939a;
            c3859af.f24566e = 1;
            abstractC3866amM25795a.m25609a((DispatchedTask.kt<?>) c3859af);
            return;
        }
        DispatchedContinuation.kt_2 c3859af2 = c3859af;
        abstractC3866amM25795a.m25610a(true);
        try {
            try {
                Job.kt_5 interfaceC3881ay = (Job.kt_5) c3859af.getContext().get(Job.kt_5.f24595b);
                if (interfaceC3881ay == null || interfaceC3881ay.mo25562b()) {
                    z = false;
                } else {
                    CancellationException cancellationExceptionMo25651h = interfaceC3881ay.mo25651h();
                    Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
                    c3859af.resumeWith(Result.kt.m26270constructorimpl(Result.kt_4.m5380a((Throwable) cancellationExceptionMo25651h)));
                    z = true;
                }
                if (!z) {
                    CoroutineContext.kt_4 context = c3859af.getContext();
                    Object objM25913a = ThreadContext.kt.m25913a(context, c3859af.f24560b);
                    try {
                        c3859af.f24562d.resumeWith(obj);
                        Unit.kt c1025s = Unit.kt.f5071a;
                        ThreadContext.kt.m25914b(context, objM25913a);
                    } catch (Throwable th) {
                        ThreadContext.kt.m25914b(context, objM25913a);
                        throw th;
                    }
                }
                while (abstractC3866amM25795a.m25615e()) {
                }
            } finally {
                abstractC3866amM25795a.m25612b(true);
            }
        } catch (Throwable th2) {
            c3859af2.m25594a(th2, (Throwable) null);
        }
    }
}
