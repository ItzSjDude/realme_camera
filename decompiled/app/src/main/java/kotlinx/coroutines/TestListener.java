package kotlinx.coroutines;

/* compiled from: CompletedExceptionally.kt */
/* loaded from: classes2.dex */
public final class g_renamed extends kotlinx.coroutines.l_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicIntegerFieldUpdater f7856b = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.g_renamed.class, "_resumed");
    private volatile int _resumed;

    public final boolean a_renamed() {
        return f7856b.compareAndSet(this, 0, 1);
    }
}
