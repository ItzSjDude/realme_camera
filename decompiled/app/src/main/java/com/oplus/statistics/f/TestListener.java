package com.oplus.statistics.f_renamed;

/* compiled from: VersionUtil.java */
/* loaded from: classes2.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f7739a = new java.lang.String(android.util.Base64.decode("Y29tLm5lYXJtZS5zdGF0aXN0aWNzLnJvbQ==", 0), java.nio.charset.StandardCharsets.UTF_8);

    public static boolean a_renamed(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        long jC = c_renamed(context);
        return jC >= 5118000 || jC == -1;
    }

    public static boolean b_renamed(android.content.Context context) {
        return com.oplus.statistics.c_renamed.b_renamed.a_renamed(context);
    }

    public static long c_renamed(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(f7739a, 1);
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                return packageInfo.getLongVersionCode();
            }
            return packageInfo.versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
            com.oplus.statistics.f_renamed.d_renamed.b_renamed("VersionUtil", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.f_renamed.-$$Lambda$g_renamed$zx7lYbDEEdNxzB04A4FwKYx3MRc
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.f_renamed.g_renamed.a_renamed(e_renamed);
                }
            });
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String a_renamed(android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        return "getDataCollectionAppVersion exception: " + nameNotFoundException.toString();
    }
}
