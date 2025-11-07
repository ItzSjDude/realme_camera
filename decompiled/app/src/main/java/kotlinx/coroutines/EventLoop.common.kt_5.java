package kotlinx.coroutines;

/* compiled from: EventLoop.common.kt */
/* renamed from: kotlinx.coroutines.bm */
/* loaded from: classes2.dex */
public final class EventLoop.common.kt_5 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final EventLoop.common.kt_5 f24668a = new EventLoop.common.kt_5();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final ThreadLocal<EventLoop.common.kt> f24669b = new ThreadLocal<>();

    private EventLoop.common.kt_5() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final EventLoop.common.kt m25795a() {
        EventLoop.common.kt abstractC3866am = f24669b.get();
        if (abstractC3866am != null) {
            return abstractC3866am;
        }
        EventLoop.common.kt abstractC3866amM25645a = EventLoop.kt_3.m25645a();
        f24669b.set(abstractC3866amM25645a);
        return abstractC3866amM25645a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m25797b() {
        f24669b.set(null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25796a(EventLoop.common.kt abstractC3866am) {
        f24669b.set(abstractC3866am);
    }
}
