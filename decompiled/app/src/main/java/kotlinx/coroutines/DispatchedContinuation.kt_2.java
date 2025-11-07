package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.ThreadContext.kt;
import p061c.Unit.kt;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p064c.p066b.p067a.CoroutineStackFrame.kt;

/* compiled from: DispatchedContinuation.kt */
/* renamed from: kotlinx.coroutines.af */
/* loaded from: classes2.dex */
public final class DispatchedContinuation.kt_2<T> extends DispatchedTask.kt<T> implements CoroutineStackFrame.kt, Continuation.kt_2<T> {

    /* renamed from: OplusGLSurfaceView_13 */
    private static final AtomicReferenceFieldUpdater f24558i = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.kt_2.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: PlatformImplementations.kt_3 */
    public Object f24559a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final Object f24560b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final CoroutineDispatcher.kt f24561c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final Continuation.kt_2<T> f24562d;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final CoroutineStackFrame.kt f24563h;

    @Override // p061c.p064c.Continuation.kt_2
    public CoroutineContext.kt_4 getContext() {
        return this.f24562d.getContext();
    }

    @Override // p061c.p064c.p066b.p067a.CoroutineStackFrame.kt
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation.kt_2(CoroutineDispatcher.kt abstractC3958t, Continuation.kt_2<? super T> interfaceC0929d) {
        super(0);
        this.f24561c = abstractC3958t;
        this.f24562d = interfaceC0929d;
        this.f24559a = DispatchedContinuation.kt.f24565b;
        Continuation.kt_2<T> interfaceC0929d2 = this.f24562d;
        this.f24563h = (CoroutineStackFrame.kt) (interfaceC0929d2 instanceof CoroutineStackFrame.kt ? interfaceC0929d2 : null);
        this.f24560b = ThreadContext.kt.m25912a(getContext());
        this._reusableCancellableContinuation = null;
    }

    @Override // p061c.p064c.p066b.p067a.CoroutineStackFrame.kt
    public CoroutineStackFrame.kt getCallerFrame() {
        return this.f24563h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final CancellableContinuationImpl.kt<?> m25586a() {
        Object obj = this._reusableCancellableContinuation;
        if (!(obj instanceof CancellableContinuationImpl.kt)) {
            obj = null;
        }
        return (CancellableContinuationImpl.kt) obj;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m25587a(CancellableContinuationImpl.kt<?> c3919f) {
        Object obj = this._reusableCancellableContinuation;
        if (obj != null) {
            return !(obj instanceof CancellableContinuationImpl.kt) || obj == c3919f;
        }
        return false;
    }

    @Override // kotlinx.coroutines.DispatchedTask.kt
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Object mo25588b() {
        Object obj = this.f24559a;
        if (Debug.kt.m25574a()) {
            if (!(obj != DispatchedContinuation.kt.f24565b)) {
                throw new AssertionError();
            }
        }
        this.f24559a = DispatchedContinuation.kt.f24565b;
        return obj;
    }

    @Override // kotlinx.coroutines.DispatchedTask.kt
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Continuation.kt_2<T> mo25589e() {
        return this;
    }

    @Override // p061c.p064c.Continuation.kt_2
    public void resumeWith(Object obj) {
        CoroutineContext.kt_4 context;
        Object objM25913a;
        CoroutineContext.kt_4 context2 = this.f24562d.getContext();
        Object objM25939a = CompletedExceptionally.kt_3.m25939a(obj);
        if (this.f24561c.mo25640a(context2)) {
            this.f24559a = objM25939a;
            this.f24566e = 0;
            this.f24561c.mo25629a(context2, this);
            return;
        }
        EventLoop.common.kt abstractC3866amM25795a = EventLoop.common.kt_5.f24668a.m25795a();
        if (abstractC3866amM25795a.m25616f()) {
            this.f24559a = objM25939a;
            this.f24566e = 0;
            abstractC3866amM25795a.m25609a((DispatchedTask.kt<?>) this);
            return;
        }
        DispatchedContinuation.kt_2<T> c3859af = this;
        abstractC3866amM25795a.m25610a(true);
        try {
            try {
                context = getContext();
                objM25913a = ThreadContext.kt.m25913a(context, this.f24560b);
            } catch (Throwable th) {
                c3859af.m25594a(th, (Throwable) null);
            }
            try {
                this.f24562d.resumeWith(obj);
                Unit.kt c1025s = Unit.kt.f5071a;
                while (abstractC3866amM25795a.m25615e()) {
                }
            } finally {
                ThreadContext.kt.m25914b(context, objM25913a);
            }
        } finally {
            abstractC3866amM25795a.m25612b(true);
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f24561c + ", " + DebugStrings.kt.m25578a((Continuation.kt_2<?>) this.f24562d) + ']';
    }
}
