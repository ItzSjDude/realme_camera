package kotlinx.coroutines.internal;

/* compiled from: Atomic.kt */
/* loaded from: classes2.dex */
public abstract class c_renamed<T_renamed> extends kotlinx.coroutines.internal.o_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater f7863a = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.c_renamed.class, java.lang.Object.class, "_consensus");
    private volatile java.lang.Object _consensus = kotlinx.coroutines.internal.b_renamed.f7862b;

    public long a_renamed() {
        return 0L;
    }

    public abstract java.lang.Object a_renamed(T_renamed t_renamed);

    public abstract void a_renamed(T_renamed t_renamed, java.lang.Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.o_renamed
    public kotlinx.coroutines.internal.c_renamed<?> b_renamed() {
        return this;
    }

    public final java.lang.Object b_renamed(java.lang.Object obj) {
        if (kotlinx.coroutines.ac_renamed.a_renamed()) {
            if (!(obj != kotlinx.coroutines.internal.b_renamed.f7862b)) {
                throw new java.lang.AssertionError();
            }
        }
        java.lang.Object obj2 = this._consensus;
        return obj2 != kotlinx.coroutines.internal.b_renamed.f7862b ? obj2 : f7863a.compareAndSet(this, kotlinx.coroutines.internal.b_renamed.f7862b, obj) ? obj : this._consensus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.o_renamed
    public final java.lang.Object c_renamed(java.lang.Object obj) {
        java.lang.Object objB = this._consensus;
        if (objB == kotlinx.coroutines.internal.b_renamed.f7862b) {
            objB = b_renamed(a_renamed((kotlinx.coroutines.internal.c_renamed<T_renamed>) obj));
        }
        a_renamed(obj, objB);
        return objB;
    }
}
