package kotlinx.coroutines;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes2.dex */
public class f_renamed<T_renamed> extends kotlinx.coroutines.ah_renamed<T_renamed> implements c_renamed.c_renamed.b_renamed.a_renamed.d_renamed, kotlinx.coroutines.e_renamed<T_renamed> {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater f7853b = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.f_renamed.class, "_decision");

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater f7854c = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.f_renamed.class, java.lang.Object.class, "_state");
    private volatile int _decision;
    private volatile java.lang.Object _parentHandle;
    private volatile java.lang.Object _state;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final c_renamed.c_renamed.g_renamed f7855a;
    private final c_renamed.c_renamed.d_renamed<T_renamed> d_renamed;

    protected java.lang.String d_renamed() {
        return "CancellableContinuation";
    }

    @Override // c_renamed.c_renamed.b_renamed.a_renamed.d_renamed
    public java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.ah_renamed
    public final c_renamed.c_renamed.d_renamed<T_renamed> e_renamed() {
        return this.d_renamed;
    }

    @Override // c_renamed.c_renamed.d_renamed
    public c_renamed.c_renamed.g_renamed getContext() {
        return this.f7855a;
    }

    private final kotlinx.coroutines.ak_renamed f_renamed() {
        return (kotlinx.coroutines.ak_renamed) this._parentHandle;
    }

    private final void a_renamed(kotlinx.coroutines.ak_renamed akVar) {
        this._parentHandle = akVar;
    }

    public final java.lang.Object a_renamed() {
        return this._state;
    }

    private final boolean g_renamed() {
        c_renamed.c_renamed.d_renamed<T_renamed> dVar = this.d_renamed;
        return (dVar instanceof kotlinx.coroutines.af_renamed) && ((kotlinx.coroutines.af_renamed) dVar).a_renamed((kotlinx.coroutines.f_renamed<?>) this);
    }

    @Override // c_renamed.c_renamed.b_renamed.a_renamed.d_renamed
    public c_renamed.c_renamed.b_renamed.a_renamed.d_renamed getCallerFrame() {
        c_renamed.c_renamed.d_renamed<T_renamed> dVar = this.d_renamed;
        if (!(dVar instanceof c_renamed.c_renamed.b_renamed.a_renamed.d_renamed)) {
            dVar = null;
        }
        return (c_renamed.c_renamed.b_renamed.a_renamed.d_renamed) dVar;
    }

    @Override // kotlinx.coroutines.ah_renamed
    public java.lang.Object b_renamed() {
        return a_renamed();
    }

    @Override // kotlinx.coroutines.ah_renamed
    public void a_renamed(java.lang.Object obj, java.lang.Throwable th) {
        if (obj instanceof kotlinx.coroutines.o_renamed) {
            try {
                ((kotlinx.coroutines.o_renamed) obj).f7902b.invoke(th);
            } catch (java.lang.Throwable th2) {
                kotlinx.coroutines.v_renamed.a_renamed(getContext(), new kotlinx.coroutines.q_renamed("Exception in_renamed cancellation handler for " + this, th2));
            }
        }
    }

    @Override // c_renamed.c_renamed.d_renamed
    public void resumeWith(java.lang.Object obj) {
        a_renamed(kotlinx.coroutines.m_renamed.a_renamed(obj, this), this.e_renamed);
    }

    private final void a_renamed(int i_renamed) {
        if (h_renamed()) {
            return;
        }
        kotlinx.coroutines.ai_renamed.a_renamed(this, i_renamed);
    }

    private final void c_renamed(java.lang.Object obj) {
        throw new java.lang.IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void i_renamed() {
        if (g_renamed()) {
            return;
        }
        c_renamed();
    }

    public final void c_renamed() {
        kotlinx.coroutines.ak_renamed akVarF = f_renamed();
        if (akVarF != null) {
            akVarF.a_renamed();
        }
        a_renamed((kotlinx.coroutines.ak_renamed) kotlinx.coroutines.bh_renamed.f7846a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.ah_renamed
    public <T_renamed> T_renamed a_renamed(java.lang.Object obj) {
        return obj instanceof kotlinx.coroutines.n_renamed ? (T_renamed) ((kotlinx.coroutines.n_renamed) obj).f7900a : obj instanceof kotlinx.coroutines.o_renamed ? (T_renamed) ((kotlinx.coroutines.o_renamed) obj).f7901a : obj;
    }

    public java.lang.String toString() {
        return d_renamed() + '(' + kotlinx.coroutines.ad_renamed.a_renamed((c_renamed.c_renamed.d_renamed<?>) this.d_renamed) + "){" + a_renamed() + "}@" + kotlinx.coroutines.ad_renamed.a_renamed((java.lang.Object) this);
    }

    private final boolean h_renamed() {
        do {
            int i_renamed = this._decision;
            if (i_renamed != 0) {
                if (i_renamed == 1) {
                    return false;
                }
                throw new java.lang.IllegalStateException("Already resumed".toString());
            }
        } while (!f7853b.compareAndSet(this, 0, 2));
        return true;
    }

    private final kotlinx.coroutines.g_renamed a_renamed(java.lang.Object obj, int i_renamed) {
        while (true) {
            java.lang.Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.bi_renamed) {
                if (f7854c.compareAndSet(this, obj2, obj)) {
                    i_renamed();
                    a_renamed(i_renamed);
                    return null;
                }
            } else {
                if (obj2 instanceof kotlinx.coroutines.g_renamed) {
                    kotlinx.coroutines.g_renamed gVar = (kotlinx.coroutines.g_renamed) obj2;
                    if (gVar.a_renamed()) {
                        return gVar;
                    }
                }
                c_renamed(obj);
            }
        }
    }
}
