package kotlinx.coroutines;

import p061c.Result.kt;
import p061c.Result.kt_4;
import p061c.p064c.Continuation.kt_2;

/* compiled from: DebugStrings.kt */
/* renamed from: kotlinx.coroutines.ad */
/* loaded from: classes2.dex */
public final class DebugStrings.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final String m25579a(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final String m25578a(Continuation.kt_2<?> interfaceC0929d) {
        Object objM26270constructorimpl;
        if (interfaceC0929d instanceof DispatchedContinuation.kt_2) {
            return interfaceC0929d.toString();
        }
        try {
            Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
            objM26270constructorimpl = Result.kt.m26270constructorimpl(interfaceC0929d + '@' + m25579a((Object) interfaceC0929d));
        } catch (Throwable th) {
            Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
            objM26270constructorimpl = Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th));
        }
        if (Result.kt.m26273exceptionOrNullimpl(objM26270constructorimpl) != null) {
            objM26270constructorimpl = interfaceC0929d.getClass().getName() + '@' + m25579a((Object) interfaceC0929d);
        }
        return (String) objM26270constructorimpl;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final String m25580b(Object obj) {
        return obj.getClass().getSimpleName();
    }
}
