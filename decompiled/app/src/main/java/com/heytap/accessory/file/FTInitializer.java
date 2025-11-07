package com.heytap.accessory.file;

/* loaded from: classes2.dex */
public class FTInitializer {
    public static final java.lang.String FILE_TRANSFER_SERVICE_INTENT = "com.heytap.accessory.IAfFtManager";
    private static final java.lang.String TAG = "FTInitializer";
    private static boolean sInitialized;

    private FTInitializer() {
    }

    public static void init(android.content.Context context) throws com.heytap.accessory.bean.SdkUnsupportedException {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("Illegal argument input: context");
        }
        if (sInitialized) {
            return;
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        try {
            if (com.heytap.accessory.Initializer.useOAFApp()) {
                if (packageManager.getPackageInfo(com.heytap.accessory.api.ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE, 0) == null) {
                    throw new com.heytap.accessory.bean.SdkUnsupportedException("Device not supported", 1);
                }
            } else {
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "is_renamed not AppMode,ignore");
            }
            java.lang.String fileTransferPackageName = getFileTransferPackageName(context);
            if (fileTransferPackageName == null) {
                throw new com.heytap.accessory.bean.SdkUnsupportedException("Accessory Framework not installed", 2);
            }
            if (packageManager.getPackageInfo(fileTransferPackageName, 0) == null) {
                throw new com.heytap.accessory.bean.SdkUnsupportedException("Accessory Framework not installed", 2);
            }
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Accessory File Transfer SDK version: " + com.heytap.accessory.Config.getSdkVersionName());
            sInitialized = true;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Accessory Framework not installed");
            throw new com.heytap.accessory.bean.SdkUnsupportedException("Accessory Framework not installed", 2);
        }
    }

    public static java.lang.String getFileTransferPackageName(android.content.Context context) {
        return com.heytap.accessory.Initializer.useOAFApp() ? com.heytap.accessory.api.ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE : context.getPackageName();
    }
}
