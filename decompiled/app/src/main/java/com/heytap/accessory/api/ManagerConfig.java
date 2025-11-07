package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public class ManagerConfig {
    public static final java.lang.String ACCESSORY_FRAMEWORK_PACKAGE = "com.heytap.accessory";
    public static final java.lang.String INTENT_BASE_FRAMEWORK_SERVICE = "com.heytap.accessory.action.BASE_FRAMEWORK_MANAGER";
    private static final java.lang.String TAG = "ManagerConfig";
    private static final int VERSION_FAST_PAIR = 20000;
    private static int sFrameworkVersion = 1;

    public ManagerConfig(android.content.Context context) throws com.heytap.accessory.bean.SdkUnsupportedException, android.content.pm.PackageManager.NameNotFoundException {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("Invalid Context");
        }
        if (!com.heytap.accessory.Initializer.useOAFApp()) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "is_renamed not AppMode,ignore");
            return;
        }
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(ACCESSORY_FRAMEWORK_PACKAGE, 0);
            if (packageInfo != null) {
                synchronized (com.heytap.accessory.api.ManagerConfig.class) {
                    sFrameworkVersion = packageInfo.versionCode;
                }
                return;
            }
            throw new com.heytap.accessory.bean.SdkUnsupportedException("Accessory Framework Not installed", 2);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            throw new com.heytap.accessory.bean.SdkUnsupportedException("Accessory Framework Not installed", 2);
        }
    }

    public static int getFrameworkVersion() {
        return sFrameworkVersion;
    }

    public boolean isSupportFastPair() {
        return sFrameworkVersion >= 20000;
    }
}
