package kotlinx.coroutines;

/* compiled from: EventLoop.kt */
/* renamed from: kotlinx.coroutines.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public final class EventLoop.kt extends EventLoop.common.kt_2 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Thread f24597b;

    @Override // kotlinx.coroutines.EventLoop.kt_2
    /* renamed from: PlatformImplementations.kt_3 */
    protected Thread mo25585a() {
        return this.f24597b;
    }

    public EventLoop.kt(Thread thread) {
        this.f24597b = thread;
    }
}
