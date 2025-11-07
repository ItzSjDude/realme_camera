package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: CompletedExceptionally.kt */
/* renamed from: kotlinx.coroutines.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public final class CompletedExceptionally.kt_2 extends CompletedExceptionally.kt {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final AtomicIntegerFieldUpdater f24678b = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.kt_2.class, "_resumed");
    private volatile int _resumed;

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m25822a() {
        return f24678b.compareAndSet(this, 0, 1);
    }
}
