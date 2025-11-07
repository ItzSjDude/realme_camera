package kotlinx.coroutines;

/* compiled from: CompletedExceptionally.kt */
/* loaded from: classes2.dex */
public class l_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater f7898b = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.l_renamed.class, "_handled");
    private volatile int _handled;

    /* renamed from: a_renamed, reason: collision with root package name */
    public final java.lang.Throwable f7899a;

    public l_renamed(java.lang.Throwable th, boolean z_renamed) {
        this.f7899a = th;
        this._handled = z_renamed ? 1 : 0;
    }

    public /* synthetic */ l_renamed(java.lang.Throwable th, boolean z_renamed, int i_renamed, c_renamed.f_renamed.b_renamed.f_renamed fVar) {
        this(th, (i_renamed & 2) != 0 ? false : z_renamed);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public final boolean b_renamed() {
        return this._handled;
    }

    public final boolean c_renamed() {
        return f7898b.compareAndSet(this, 0, 1);
    }

    public java.lang.String toString() {
        return kotlinx.coroutines.ad_renamed.b_renamed(this) + '[' + this.f7899a + ']';
    }
}
