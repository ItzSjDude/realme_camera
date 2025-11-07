package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
final class aw_renamed extends kotlinx.coroutines.ba_renamed<kotlinx.coroutines.ay_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater f7810a = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.aw_renamed.class, "_invoked");
    private volatile int _invoked;
    private final c_renamed.f_renamed.a_renamed.b_renamed<java.lang.Throwable, c_renamed.s_renamed> e_renamed;

    @Override // c_renamed.f_renamed.a_renamed.b_renamed
    public /* synthetic */ c_renamed.s_renamed invoke(java.lang.Throwable th) {
        b_renamed(th);
        return c_renamed.s_renamed.f1925a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public aw_renamed(kotlinx.coroutines.ay_renamed ayVar, c_renamed.f_renamed.a_renamed.b_renamed<? super java.lang.Throwable, c_renamed.s_renamed> bVar) {
        super(ayVar);
        this.e_renamed = bVar;
        this._invoked = 0;
    }

    @Override // kotlinx.coroutines.p_renamed
    public void b_renamed(java.lang.Throwable th) {
        if (f7810a.compareAndSet(this, 0, 1)) {
            this.e_renamed.invoke(th);
        }
    }

    @Override // kotlinx.coroutines.internal.i_renamed
    public java.lang.String toString() {
        return "InvokeOnCancelling[" + kotlinx.coroutines.ad_renamed.b_renamed(this) + '@' + kotlinx.coroutines.ad_renamed.a_renamed(this) + ']';
    }
}
