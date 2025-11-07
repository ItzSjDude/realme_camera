package p057b.p059b;

/* compiled from: Assert.java */
@Deprecated
/* renamed from: IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class Assert {
    protected Assert() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m5171a(String str, boolean z) {
        if (z) {
            return;
        }
        m5169a(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m5169a(String str) {
        if (str == null) {
            throw new AssertionFailedError();
        }
        throw new AssertionFailedError(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m5170a(String str, Object obj) {
        m5171a(str, obj != null);
    }
}
