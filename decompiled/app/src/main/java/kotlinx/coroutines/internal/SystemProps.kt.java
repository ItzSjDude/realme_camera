package kotlinx.coroutines.internal;

/* compiled from: SystemProps.kt */
/* renamed from: kotlinx.coroutines.internal.t */
/* loaded from: classes2.dex */
final /* synthetic */ class SystemProps.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int f24718a = Runtime.getRuntime().availableProcessors();

    /* renamed from: PlatformImplementations.kt_3 */
    public static final int m25905a() {
        return f24718a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final String m25906a(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
