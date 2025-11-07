package kotlinx.coroutines;

import p061c.p064c.CoroutineContextImpl.kt_3;
import p061c.p064c.CoroutineContext.kt_4;

/* compiled from: CoroutineScope.kt */
/* renamed from: kotlinx.coroutines.as */
/* loaded from: classes2.dex */
public final class CoroutineScope.kt implements CoroutineScope.kt_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final CoroutineScope.kt f24589a = new CoroutineScope.kt();

    private CoroutineScope.kt() {
    }

    @Override // kotlinx.coroutines.CoroutineScope.kt_2
    /* renamed from: PlatformImplementations.kt_3 */
    public CoroutineContext.kt_4 mo25556a() {
        return CoroutineContextImpl.kt_3.INSTANCE;
    }
}
