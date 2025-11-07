package p061c.p064c.p066b.p067a;

import java.io.Serializable;
import p061c.Result.kt;
import p061c.Result.kt_4;
import p061c.Unit.kt;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.p065a.C0914b;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: ContinuationImpl.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class AbstractC0918a implements CoroutineStackFrame.kt, Continuation.kt_2<Object>, Serializable {
    private final Continuation.kt_2<Object> completion;

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    public AbstractC0918a(Continuation.kt_2<Object> interfaceC0929d) {
        this.completion = interfaceC0929d;
    }

    public final Continuation.kt_2<Object> getCompletion() {
        return this.completion;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5, IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5<java.lang.Object>, java.lang.Object] */
    @Override // p061c.p064c.Continuation.kt_2
    public final void resumeWith(Object obj) {
        Object objInvokeSuspend;
        while (true) {
            AbstractC0918a abstractC0918a = this;
            DebugProbes.kt_2.m5265b(abstractC0918a);
            ?? r0 = abstractC0918a.completion;
            Intrinsics.m5296a((Object) r0);
            try {
                objInvokeSuspend = abstractC0918a.invokeSuspend(obj);
            } catch (Throwable th) {
                Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
                obj = Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th));
            }
            if (objInvokeSuspend == C0914b.m5252a()) {
                return;
            }
            Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
            obj = Result.kt.m26270constructorimpl(objInvokeSuspend);
            abstractC0918a.releaseIntercepted();
            if (r0 instanceof AbstractC0918a) {
                this = r0;
            } else {
                r0.resumeWith(obj);
                return;
            }
        }
    }

    public Continuation.kt_2<Unit.kt> create(Continuation.kt_2<?> interfaceC0929d) {
        Intrinsics.m5305d(interfaceC0929d, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public Continuation.kt_2<Unit.kt> create(Object obj, Continuation.kt_2<?> interfaceC0929d) {
        Intrinsics.m5305d(interfaceC0929d, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        StackTraceElement stackTraceElement = getStackTraceElement();
        sb.append(stackTraceElement != null ? stackTraceElement : getClass().getName());
        return sb.toString();
    }

    @Override // p061c.p064c.p066b.p067a.CoroutineStackFrame.kt
    public CoroutineStackFrame.kt getCallerFrame() {
        Continuation.kt_2<Object> interfaceC0929d = this.completion;
        if (!(interfaceC0929d instanceof CoroutineStackFrame.kt)) {
            interfaceC0929d = null;
        }
        return (CoroutineStackFrame.kt) interfaceC0929d;
    }

    @Override // p061c.p064c.p066b.p067a.CoroutineStackFrame.kt
    public StackTraceElement getStackTraceElement() {
        return DebugMetadata.kt_3.m5260a(this);
    }
}
