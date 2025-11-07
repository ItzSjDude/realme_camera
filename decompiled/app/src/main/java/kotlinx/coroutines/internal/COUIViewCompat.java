package kotlinx.coroutines.internal;

/* compiled from: SystemProps.kt */
/* loaded from: classes2.dex */
final /* synthetic */ class t_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int f7887a = java.lang.Runtime.getRuntime().availableProcessors();

    public static final int a_renamed() {
        return f7887a;
    }

    public static final java.lang.String a_renamed(java.lang.String str) {
        try {
            return java.lang.System.getProperty(str);
        } catch (java.lang.SecurityException unused) {
            return null;
        }
    }
}
