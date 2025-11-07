package p061c.p069e;

import java.io.Closeable;
import java.io.IOException;
import p061c.Exceptions.kt_2;

/* compiled from: Closeable.kt */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public final class Closeable.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final void m5285a(Closeable closeable, Throwable th) throws IOException {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            Exceptions.kt_2.m5247a(th, th2);
        }
    }
}
