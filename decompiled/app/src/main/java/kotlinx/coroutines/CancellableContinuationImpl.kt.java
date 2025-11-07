package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p064c.p066b.p067a.CoroutineStackFrame.kt;

/* compiled from: CancellableContinuationImpl.kt */
/* renamed from: kotlinx.coroutines.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class CancellableContinuationImpl.kt<T> extends DispatchedTask.kt<T> implements CoroutineStackFrame.kt, CancellableContinuation.kt<T> {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final AtomicIntegerFieldUpdater f24674b = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.kt.class, "_decision");

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final AtomicReferenceFieldUpdater f24675c = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.kt.class, Object.class, "_state");
    private volatile int _decision;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: PlatformImplementations.kt_3 */
    private final CoroutineContext.kt_4 f24676a;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Continuation.kt_2<T> f24677d;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected String m25821d() {
        return "CancellableContinuation";
    }

    @Override // p061c.p064c.p066b.p067a.CoroutineStackFrame.kt
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.DispatchedTask.kt
    /* renamed from: COUIBaseListPopupWindow_8 */
    public final Continuation.kt_2<T> mo25589e() {
        return this.f24677d;
    }

    @Override // p061c.p064c.Continuation.kt_2
    public CoroutineContext.kt_4 getContext() {
        return this.f24676a;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Job.kt_4 m25815f() {
        return (Job.kt_4) this._parentHandle;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final void m25813a(Job.kt_4 interfaceC3864ak) {
        this._parentHandle = interfaceC3864ak;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final Object m25819a() {
        return this._state;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final boolean m25816g() {
        Continuation.kt_2<T> interfaceC0929d = this.f24677d;
        return (interfaceC0929d instanceof DispatchedContinuation.kt_2) && ((DispatchedContinuation.kt_2) interfaceC0929d).m25587a((CancellableContinuationImpl.kt<?>) this);
    }

    @Override // p061c.p064c.p066b.p067a.CoroutineStackFrame.kt
    public CoroutineStackFrame.kt getCallerFrame() {
        Continuation.kt_2<T> interfaceC0929d = this.f24677d;
        if (!(interfaceC0929d instanceof CoroutineStackFrame.kt)) {
            interfaceC0929d = null;
        }
        return (CoroutineStackFrame.kt) interfaceC0929d;
    }

    @Override // kotlinx.coroutines.DispatchedTask.kt
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Object mo25588b() {
        return m25819a();
    }

    @Override // kotlinx.coroutines.DispatchedTask.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25593a(Object obj, Throwable th) {
        if (obj instanceof CancellableContinuationImpl.kt_4) {
            try {
                ((CancellableContinuationImpl.kt_4) obj).f24737b.invoke(th);
            } catch (Throwable th2) {
                CoroutineExceptionHandler.kt.m25946a(getContext(), new Exceptions.common.kt_2("Exception in cancellation handler for " + this, th2));
            }
        }
    }

    @Override // p061c.p064c.Continuation.kt_2
    public void resumeWith(Object obj) {
        m25811a(CompletedExceptionally.kt_3.m25940a(obj, this), this.f24566e);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final void m25812a(int OplusGLSurfaceView_13) {
        if (m25817h()) {
            return;
        }
        DispatchedTask.kt_2.m25597a(this, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final void m25814c(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private final void m25818i() {
        if (m25816g()) {
            return;
        }
        m25820c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final void m25820c() {
        Job.kt_4 interfaceC3864akM25815f = m25815f();
        if (interfaceC3864akM25815f != null) {
            interfaceC3864akM25815f.mo25604a();
        }
        m25813a((Job.kt_4) Job.kt_3.f24667a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> T mo25592a(Object obj) {
        return obj instanceof CancellableContinuationImpl.kt_3 ? (T) ((CancellableContinuationImpl.kt_3) obj).f24735a : obj instanceof CancellableContinuationImpl.kt_4 ? (T) ((CancellableContinuationImpl.kt_4) obj).f24736a : obj;
    }

    public String toString() {
        return m25821d() + '(' + DebugStrings.kt.m25578a((Continuation.kt_2<?>) this.f24677d) + "){" + m25819a() + "}@" + DebugStrings.kt.m25579a((Object) this);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final boolean m25817h() {
        do {
            int OplusGLSurfaceView_13 = this._decision;
            if (OplusGLSurfaceView_13 != 0) {
                if (OplusGLSurfaceView_13 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f24674b.compareAndSet(this, 0, 2));
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final CompletedExceptionally.kt_2 m25811a(Object obj, int OplusGLSurfaceView_13) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof CancellableContinuationImpl.kt_2) {
                if (f24675c.compareAndSet(this, obj2, obj)) {
                    m25818i();
                    m25812a(OplusGLSurfaceView_13);
                    return null;
                }
            } else {
                if (obj2 instanceof CompletedExceptionally.kt_2) {
                    CompletedExceptionally.kt_2 c3920g = (CompletedExceptionally.kt_2) obj2;
                    if (c3920g.m25822a()) {
                        return c3920g;
                    }
                }
                m25814c(obj);
            }
        }
    }
}
