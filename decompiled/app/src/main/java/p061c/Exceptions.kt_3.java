package p061c;

import java.lang.reflect.InvocationTargetException;
import p061c.p068d.PlatformImplementations.kt;
import p061c.p070f.p072b.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Exceptions.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class Exceptions.kt_3 {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final void m5247a(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.m5305d(th, "$this$addSuppressed");
        Intrinsics.m5305d(th2, "exception");
        if (th != th2) {
            PlatformImplementations.kt.f5042a.m5280a(th, th2);
        }
    }
}
