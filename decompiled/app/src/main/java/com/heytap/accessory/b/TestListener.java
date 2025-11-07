package com.heytap.accessory.b_renamed;

/* compiled from: SdkConfig.java */
/* loaded from: classes2.dex */
public final class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static int f3271a = 1;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.String f3272b = "";

    /* renamed from: c_renamed, reason: collision with root package name */
    private static int f3273c = 0;
    private static int d_renamed = 0;
    private static int e_renamed = 0;
    private static int f_renamed = 0;
    private static int g_renamed = 1;

    public static java.lang.String d_renamed() {
        return "UTF-8";
    }

    public static boolean e_renamed() {
        return true;
    }

    public g_renamed(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException, com.heytap.accessory.bean.GeneralException {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("Invalid Context");
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (!com.heytap.accessory.Initializer.useOAFApp()) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed("SdkConfig", "is_renamed not AppMode,ignore");
            return;
        }
        try {
            android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(com.heytap.accessory.api.ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE, 0);
            if (packageInfo == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed("SdkConfig", "Accessory Framework Not installed");
                throw new com.heytap.accessory.bean.GeneralException(2, "Accessory Framework Not installed");
            }
            f3271a = packageInfo.versionCode;
            f3272b = packageInfo.versionName;
            com.heytap.accessory.a_renamed.a_renamed.c_renamed("SdkConfig", "Accessory Framework: " + packageInfo.versionName + " Accessory SDK: " + com.heytap.accessory.Config.getSdkVersionName());
            g_renamed();
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed("SdkConfig", "Accessory Framework Not installed");
            throw new com.heytap.accessory.bean.GeneralException(2, "Accessory Framework Not installed");
        }
    }

    public static boolean a_renamed(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String packageName = context.getPackageName();
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                com.heytap.accessory.a_renamed.a_renamed.d_renamed("SdkConfig", "Package Manager is_renamed null");
                return false;
            }
            android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 4096);
            if (packageInfo == null) {
                com.heytap.accessory.a_renamed.a_renamed.d_renamed("SdkConfig", "PackageInfo is_renamed null");
                return false;
            }
            java.lang.String[] strArr = packageInfo.requestedPermissions;
            if (strArr == null) {
                return false;
            }
            int i_renamed = 0;
            while (true) {
                if (i_renamed >= strArr.length) {
                    i_renamed = -1;
                    break;
                }
                if (com.heytap.accessory.constant.AFConstants.PERMISSION_ACCESSORY_FRAMEWORK.equals(strArr[i_renamed])) {
                    break;
                }
                i_renamed++;
            }
            if (i_renamed == -1) {
                com.heytap.accessory.a_renamed.a_renamed.d_renamed("SdkConfig", "Accessory service permission not granted for Package".concat(java.lang.String.valueOf(packageName)));
                return false;
            }
            com.heytap.accessory.a_renamed.a_renamed.c_renamed("SdkConfig", "Accessory service permission available for Package".concat(java.lang.String.valueOf(packageName)));
            return true;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed("SdkConfig", "Admin Permission check failed for Package".concat(java.lang.String.valueOf(packageName)));
            return false;
        }
    }

    public static void a_renamed(int i_renamed) {
        f3273c = i_renamed;
    }

    public static void b_renamed(int i_renamed) {
        d_renamed = i_renamed;
    }

    public static void c_renamed(int i_renamed) {
        e_renamed = i_renamed;
    }

    public static int a_renamed() {
        return d_renamed;
    }

    public static int b_renamed() {
        return e_renamed;
    }

    public static void d_renamed(int i_renamed) {
        f_renamed = i_renamed;
    }

    public static int c_renamed() {
        return f_renamed;
    }

    public static int f_renamed() {
        return g_renamed;
    }

    public static void e_renamed(int i_renamed) {
        g_renamed = i_renamed;
    }

    public static void g_renamed() {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed("SdkConfig", "sdk version: commit id_renamed is_renamed 3bc035921 time is202111151652");
    }
}
