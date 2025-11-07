package kotlinx.coroutines;

/* compiled from: DispatchedContinuation.kt */
/* loaded from: classes2.dex */
public final class af_renamed<T_renamed> extends kotlinx.coroutines.ah_renamed<T_renamed> implements c_renamed.c_renamed.b_renamed.a_renamed.d_renamed, c_renamed.c_renamed.d_renamed<T_renamed> {
    private static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater i_renamed = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.af_renamed.class, java.lang.Object.class, "_reusableCancellableContinuation");
    private volatile java.lang.Object _reusableCancellableContinuation;

    /* renamed from: a_renamed, reason: collision with root package name */
    public java.lang.Object f7788a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public final java.lang.Object f7789b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public final kotlinx.coroutines.t_renamed f7790c;
    public final c_renamed.c_renamed.d_renamed<T_renamed> d_renamed;
    private final c_renamed.c_renamed.b_renamed.a_renamed.d_renamed h_renamed;

    @Override // c_renamed.c_renamed.d_renamed
    public c_renamed.c_renamed.g_renamed getContext() {
        return this.d_renamed.getContext();
    }

    @Override // c_renamed.c_renamed.b_renamed.a_renamed.d_renamed
    public java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public af_renamed(kotlinx.coroutines.t_renamed tVar, c_renamed.c_renamed.d_renamed<? super T_renamed> dVar) {
        super(0);
        this.f7790c = tVar;
        this.d_renamed = dVar;
        this.f7788a = kotlinx.coroutines.ag_renamed.f7792b;
        c_renamed.c_renamed.d_renamed<T_renamed> dVar2 = this.d_renamed;
        this.h_renamed = (c_renamed.c_renamed.b_renamed.a_renamed.d_renamed) (dVar2 instanceof c_renamed.c_renamed.b_renamed.a_renamed.d_renamed ? dVar2 : null);
        this.f7789b = kotlinx.coroutines.internal.v_renamed.a_renamed(getContext());
        this._reusableCancellableContinuation = null;
    }

    @Override // c_renamed.c_renamed.b_renamed.a_renamed.d_renamed
    public c_renamed.c_renamed.b_renamed.a_renamed.d_renamed getCallerFrame() {
        return this.h_renamed;
    }

    public final kotlinx.coroutines.f_renamed<?> a_renamed() {
        java.lang.Object obj = this._reusableCancellableContinuation;
        if (!(obj instanceof kotlinx.coroutines.f_renamed)) {
            obj = null;
        }
        return (kotlinx.coroutines.f_renamed) obj;
    }

    public final boolean a_renamed(kotlinx.coroutines.f_renamed<?> fVar) {
        java.lang.Object obj = this._reusableCancellableContinuation;
        if (obj != null) {
            return !(obj instanceof kotlinx.coroutines.f_renamed) || obj == fVar;
        }
        return false;
    }

    @Override // kotlinx.coroutines.ah_renamed
    public java.lang.Object b_renamed() {
        java.lang.Object obj = this.f7788a;
        if (kotlinx.coroutines.ac_renamed.a_renamed()) {
            if (!(obj != kotlinx.coroutines.ag_renamed.f7792b)) {
                throw new java.lang.AssertionError();
            }
        }
        this.f7788a = kotlinx.coroutines.ag_renamed.f7792b;
        return obj;
    }

    @Override // kotlinx.coroutines.ah_renamed
    public c_renamed.c_renamed.d_renamed<T_renamed> e_renamed() {
        return this;
    }

    @Override // c_renamed.c_renamed.d_renamed
    public void resumeWith(java.lang.Object obj) {
        c_renamed.c_renamed.g_renamed context;
        java.lang.Object objA;
        c_renamed.c_renamed.g_renamed context2 = this.d_renamed.getContext();
        java.lang.Object objA2 = kotlinx.coroutines.m_renamed.a_renamed(obj);
        if (this.f7790c.a_renamed(context2)) {
            this.f7788a = objA2;
            this.e_renamed = 0;
            this.f7790c.a_renamed(context2, this);
            return;
        }
        kotlinx.coroutines.am_renamed amVarA = kotlinx.coroutines.bm_renamed.f7847a.a_renamed();
        if (amVarA.f_renamed()) {
            this.f7788a = objA2;
            this.e_renamed = 0;
            amVarA.a_renamed((kotlinx.coroutines.ah_renamed<?>) this);
            return;
        }
        kotlinx.coroutines.af_renamed<T_renamed> afVar = this;
        amVarA.a_renamed(true);
        try {
            try {
                context = getContext();
                objA = kotlinx.coroutines.internal.v_renamed.a_renamed(context, this.f7789b);
            } catch (java.lang.Throwable th) {
                afVar.a_renamed(th, (java.lang.Throwable) null);
            }
            try {
                this.d_renamed.resumeWith(obj);
                c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
                while (amVarA.e_renamed()) {
                }
            } finally {
                kotlinx.coroutines.internal.v_renamed.b_renamed(context, objA);
            }
        } finally {
            amVarA.b_renamed(true);
        }
    }

    public java.lang.String toString() {
        return "DispatchedContinuation[" + this.f7790c + ", " + kotlinx.coroutines.ad_renamed.a_renamed((c_renamed.c_renamed.d_renamed<?>) this.d_renamed) + ']';
    }
}
