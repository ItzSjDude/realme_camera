package kotlinx.coroutines;

import p061c.p064c.CoroutineContext.kt_4;

/* compiled from: CoroutineExceptionHandler.kt_2.kt */
/* loaded from: classes2.dex */
public interface CoroutineExceptionHandler.kt_2 extends CoroutineContext.kt_4.IntrinsicsJvm.kt_4 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final CoroutineExceptionHandler.kt_3 f24546a = CoroutineExceptionHandler.kt_3.f24547a;

    void handleException(CoroutineContext.kt_4 interfaceC0932g, Throwable th);

    /* compiled from: CoroutineExceptionHandler.kt_2.kt */
    /* renamed from: kotlinx.coroutines.CoroutineExceptionHandler.kt_2$PlatformImplementations.kt_3 */
    public static final class CoroutineExceptionHandler.kt_3 implements CoroutineContext.kt_4.IntrinsicsJvm.kt_3<CoroutineExceptionHandler.kt_2> {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ CoroutineExceptionHandler.kt_3 f24547a = new CoroutineExceptionHandler.kt_3();

        private CoroutineExceptionHandler.kt_3() {
        }
    }
}
