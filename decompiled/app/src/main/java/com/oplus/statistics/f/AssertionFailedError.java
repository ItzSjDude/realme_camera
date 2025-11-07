package com.oplus.statistics.f_renamed;

/* compiled from: ApkInfoUtil.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.Map<android.app.Application, java.lang.String> f7737a = new java.util.HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String a_renamed() {
        return "AppCode not set. please read the document of_renamed OplusTrack SDK.";
    }

    public static java.lang.String a_renamed(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed("ApkInfoUtil", new com.oplus.statistics.f_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
            return "0";
        }
    }

    public static java.lang.String b_renamed(android.content.Context context) {
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed("ApkInfoUtil", new com.oplus.statistics.f_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
            return "0";
        }
    }

    public static java.lang.String c_renamed(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String str = "0";
        try {
            final android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null || packageInfo.versionName == null) {
                return "0";
            }
            str = packageInfo.versionName;
            com.oplus.statistics.f_renamed.d_renamed.c_renamed("ApkInfoUtil", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.f_renamed.-$$Lambda$b_renamed$YfKuiNFUNYqzGP_3XSVQoxUe-2Q
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.f_renamed.b_renamed.a_renamed(packageInfo);
                }
            });
            return str;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed("ApkInfoUtil", new com.oplus.statistics.f_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String a_renamed(android.content.pm.PackageInfo packageInfo) {
        return "versionName=" + packageInfo.versionName;
    }

    public static java.lang.String d_renamed(android.content.Context context) {
        android.app.Application application = (android.app.Application) context.getApplicationContext();
        java.lang.String str = f7737a.get(application);
        if (!android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.lang.String strValueOf = null;
        try {
            strValueOf = java.lang.String.valueOf(context.getPackageManager().getApplicationInfo(a_renamed(context), 128).metaData.get("AppCode"));
            if (android.text.TextUtils.isEmpty(strValueOf)) {
                com.oplus.statistics.f_renamed.d_renamed.a_renamed("ApkInfoUtil", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.f_renamed.-$$Lambda$b_renamed$6AbyM42-HncKbe3NV8AT4GpQXkY
                    @Override // com.oplus.statistics.f_renamed.e_renamed
                    public final java.lang.Object get() {
                        return com.oplus.statistics.f_renamed.b_renamed.a_renamed();
                    }
                });
            } else {
                f7737a.put(application, strValueOf);
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed("ApkInfoUtil", new com.oplus.statistics.f_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
            e_renamed.printStackTrace();
        }
        return strValueOf;
    }

    public static void a_renamed(android.content.Context context, java.lang.String str) {
        f7737a.put((android.app.Application) context.getApplicationContext(), str);
    }
}
