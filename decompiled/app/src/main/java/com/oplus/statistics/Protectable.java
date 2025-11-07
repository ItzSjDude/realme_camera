package com.oplus.statistics;

/* compiled from: OTrackContext.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.util.Map<java.lang.String, com.oplus.statistics.c_renamed> f7672a = new java.util.HashMap();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.String f7673b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.content.Context f7674c;
    private com.oplus.statistics.b_renamed d_renamed;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String b_renamed() {
        return "createDefaultConfig PackageManager.NameNotFoundException.";
    }

    private c_renamed(java.lang.String str, android.content.Context context, com.oplus.statistics.b_renamed bVar) throws android.content.pm.PackageManager.NameNotFoundException {
        com.oplus.statistics.b_renamed bVarA;
        this.f7673b = str;
        this.f7674c = context;
        if (bVar != null) {
            bVarA = a_renamed(this.f7674c, bVar);
        } else {
            bVarA = a_renamed(this.f7674c);
        }
        this.d_renamed = bVarA;
    }

    public static synchronized com.oplus.statistics.c_renamed a_renamed(java.lang.String str) {
        return f7672a.get(str);
    }

    public static synchronized com.oplus.statistics.c_renamed a_renamed(java.lang.String str, android.content.Context context, com.oplus.statistics.b_renamed bVar) {
        com.oplus.statistics.c_renamed cVarA;
        cVarA = a_renamed(str);
        if (cVarA == null) {
            cVarA = new com.oplus.statistics.c_renamed(str, context, bVar);
            f7672a.put(str, cVarA);
        }
        return cVarA;
    }

    private com.oplus.statistics.b_renamed a_renamed(android.content.Context context, com.oplus.statistics.b_renamed bVar) {
        if (android.text.TextUtils.isEmpty(bVar.c_renamed())) {
            bVar.a_renamed(com.oplus.statistics.f_renamed.b_renamed.a_renamed(context));
        }
        if (android.text.TextUtils.isEmpty(bVar.d_renamed())) {
            bVar.b_renamed(com.oplus.statistics.f_renamed.b_renamed.c_renamed(context));
        }
        if (android.text.TextUtils.isEmpty(bVar.e_renamed())) {
            bVar.c_renamed(com.oplus.statistics.f_renamed.b_renamed.b_renamed(context));
        }
        return bVar;
    }

    private com.oplus.statistics.b_renamed a_renamed(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.PackageInfo packageInfo;
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.oplus.statistics.f_renamed.d_renamed.b_renamed("OTrackContext", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$c_renamed$fbHcvn_5_wxf0tRDD0u7-FOxlUw
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.c_renamed.b_renamed();
                }
            });
            packageInfo = null;
        }
        if (packageInfo == null) {
            return com.oplus.statistics.b_renamed.f7641a;
        }
        return new com.oplus.statistics.b_renamed.a_renamed().a_renamed(packageInfo.packageName).b_renamed(packageInfo.versionName).c_renamed(packageInfo.applicationInfo.loadLabel(packageManager).toString()).a_renamed();
    }

    public com.oplus.statistics.b_renamed a_renamed() {
        if (com.oplus.statistics.b_renamed.f7641a.equals(this.d_renamed)) {
            this.d_renamed = a_renamed(this.f7674c);
        }
        return this.d_renamed;
    }
}
