package kotlinx.coroutines;

import kotlinx.coroutines.internal.MainDispatchers.kt_3;
import kotlinx.coroutines.p216b.Dispatcher.kt_3;

/* compiled from: Dispatchers.kt */
/* renamed from: kotlinx.coroutines.aj */
/* loaded from: classes2.dex */
public final class Dispatchers.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Dispatchers.kt f24567a = new Dispatchers.kt();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final CoroutineDispatcher.kt f24568b = CoroutineContext.kt_3.m25943a();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final CoroutineDispatcher.kt f24569c = Unconfined.kt_3.f24671b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final CoroutineDispatcher.kt f24570d = Dispatcher.kt_3.f24619b.m25699a();

    private Dispatchers.kt() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final CoroutineDispatcher.kt m25601a() {
        return f24568b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final MainCoroutineDispatcher.kt m25602b() {
        return MainDispatchers.kt_3.f24708a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final CoroutineDispatcher.kt m25603c() {
        return f24570d;
    }
}
