package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.internal.StackTraceRecovery.kt;
import kotlinx.coroutines.internal.ThreadContext.kt;
import kotlinx.coroutines.p216b.Tasks.kt_8;
import kotlinx.coroutines.p216b.Tasks.kt_6;
import p061c.Exceptions.kt_2;
import p061c.Result.kt;
import p061c.Result.kt_4;
import p061c.Unit.kt;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p064c.p066b.p067a.CoroutineStackFrame.kt;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: DispatchedTask.kt */
/* renamed from: kotlinx.coroutines.ah */
/* loaded from: classes2.dex */
public abstract class DispatchedTask.kt<T> extends Tasks.kt_8 {

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int f24566e;

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> T mo25592a(Object obj) {
        return obj;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25593a(Object obj, Throwable th) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract Object mo25588b();

    /* renamed from: COUIBaseListPopupWindow_8 */
    public abstract Continuation.kt_2<T> mo25589e();

    public DispatchedTask.kt(int OplusGLSurfaceView_13) {
        this.f24566e = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final Throwable m25595b(Object obj) {
        if (!(obj instanceof CompletedExceptionally.kt)) {
            obj = null;
        }
        CompletedExceptionally.kt c3950l = (CompletedExceptionally.kt) obj;
        if (c3950l != null) {
            return c3950l.f24734a;
        }
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objM26270constructorimpl;
        Object objM26270constructorimpl2;
        Object objM26270constructorimpl3;
        CancellationException cancellationExceptionM25897b;
        Tasks.kt_6 interfaceC3893j = this.f24636g;
        Throwable th = (Throwable) null;
        try {
            Continuation.kt_2<T> interfaceC0929dMo25589e = mo25589e();
            if (interfaceC0929dMo25589e == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
            }
            DispatchedContinuation.kt_2 c3859af = (DispatchedContinuation.kt_2) interfaceC0929dMo25589e;
            Continuation.kt_2<T> interfaceC0929d = c3859af.f24562d;
            CoroutineContext.kt_4 context = interfaceC0929d.getContext();
            Object objMo25588b = mo25588b();
            Object objM25913a = ThreadContext.kt.m25913a(context, c3859af.f24560b);
            try {
                Throwable thM25595b = m25595b(objMo25588b);
                Job.kt_5 interfaceC3881ay = DispatchedTask.kt_2.m25599a(this.f24566e) ? (Job.kt_5) context.get(Job.kt_5.f24595b) : null;
                if (thM25595b == null && interfaceC3881ay != null && !interfaceC3881ay.mo25562b()) {
                    CancellationException cancellationExceptionMo25651h = interfaceC3881ay.mo25651h();
                    mo25593a(objMo25588b, cancellationExceptionMo25651h);
                    Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
                    if (Debug.kt.m25576c() && (interfaceC0929d instanceof CoroutineStackFrame.kt)) {
                        cancellationExceptionM25897b = StackTraceRecovery.kt.m25897b(cancellationExceptionMo25651h, (CoroutineStackFrame.kt) interfaceC0929d);
                    } else {
                        cancellationExceptionM25897b = cancellationExceptionMo25651h;
                    }
                    interfaceC0929d.resumeWith(Result.kt.m26270constructorimpl(Result.kt_4.m5380a(cancellationExceptionM25897b)));
                } else if (thM25595b != null) {
                    Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
                    interfaceC0929d.resumeWith(Result.kt.m26270constructorimpl(Result.kt_4.m5380a(thM25595b)));
                } else {
                    T tMo25592a = mo25592a(objMo25588b);
                    Result.kt.PlatformImplementations.kt_3 aVar3 = Result.kt.Companion;
                    interfaceC0929d.resumeWith(Result.kt.m26270constructorimpl(tMo25592a));
                }
                Unit.kt c1025s = Unit.kt.f5071a;
                try {
                    Result.kt.PlatformImplementations.kt_3 aVar4 = Result.kt.Companion;
                    DispatchedTask.kt<T> abstractC3861ah = this;
                    interfaceC3893j.mo25703a();
                    objM26270constructorimpl3 = Result.kt.m26270constructorimpl(Unit.kt.f5071a);
                } catch (Throwable th2) {
                    Result.kt.PlatformImplementations.kt_3 aVar5 = Result.kt.Companion;
                    objM26270constructorimpl3 = Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th2));
                }
                m25594a(th, Result.kt.m26273exceptionOrNullimpl(objM26270constructorimpl3));
            } finally {
                ThreadContext.kt.m25914b(context, objM25913a);
            }
        } catch (Throwable th3) {
            try {
                Result.kt.PlatformImplementations.kt_3 aVar6 = Result.kt.Companion;
                DispatchedTask.kt<T> abstractC3861ah2 = this;
                interfaceC3893j.mo25703a();
                objM26270constructorimpl = Result.kt.m26270constructorimpl(Unit.kt.f5071a);
            } catch (Throwable th4) {
                Result.kt.PlatformImplementations.kt_3 aVar7 = Result.kt.Companion;
                objM26270constructorimpl = Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th4));
            }
            m25594a(th, Result.kt.m26273exceptionOrNullimpl(objM26270constructorimpl));
            throw th3;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25594a(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            Exceptions.kt_2.m5247a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        Intrinsics.m5296a((Object) th);
        CoroutineExceptionHandler.kt.m25946a(mo25589e().getContext(), new Exceptions.common.kt("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }
}
