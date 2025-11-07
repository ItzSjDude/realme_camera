package kotlinx.coroutines.internal;

import p061c.Result.kt;
import p061c.Result.kt_4;

/* compiled from: FastServiceLoader.kt */
/* renamed from: kotlinx.coroutines.internal.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public final class FastServiceLoader.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final boolean f24690a;

    static {
        Object objM26270constructorimpl;
        try {
            Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
            objM26270constructorimpl = Result.kt.m26270constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
            objM26270constructorimpl = Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th));
        }
        f24690a = Result.kt.m26277isSuccessimpl(objM26270constructorimpl);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final boolean m25844a() {
        return f24690a;
    }
}
