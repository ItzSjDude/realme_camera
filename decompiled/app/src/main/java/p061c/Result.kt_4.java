package p061c;

import p061c.Result.kt;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: Result.kt */
/* renamed from: IntrinsicsJvm.kt_3.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
public final class Result.kt_4 {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final Object m5380a(Throwable th) {
        Intrinsics.m5305d(th, "exception");
        return new Result.kt.IntrinsicsJvm.kt_4(th);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final void m5381a(Object obj) {
        if (obj instanceof Result.kt.IntrinsicsJvm.kt_4) {
            throw ((Result.kt.IntrinsicsJvm.kt_4) obj).exception;
        }
    }
}
