package com.heytap.accessory.file;

import android.content.Context;
import android.content.pm.PackageManager;
import com.heytap.accessory.Config;
import com.heytap.accessory.Initializer;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.SdkUnsupportedException;
import com.heytap.accessory.p103a.SdkLog;

/* loaded from: classes2.dex */
public class FTInitializer {
    public static final String FILE_TRANSFER_SERVICE_INTENT = "com.heytap.accessory.IAfFtManager";
    private static final String TAG = "FTInitializer";
    private static boolean sInitialized;

    private FTInitializer() {
    }

    public static void init(Context context) throws SdkUnsupportedException {
        if (context == null) {
            throw new IllegalArgumentException("Illegal argument input: context");
        }
        if (sInitialized) {
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            if (Initializer.useOAFApp()) {
                if (packageManager.getPackageInfo(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE, 0) == null) {
                    throw new SdkUnsupportedException("Device not supported", 1);
                }
            } else {
                SdkLog.m8382d(TAG, "is not AppMode,ignore");
            }
            String fileTransferPackageName = getFileTransferPackageName(context);
            if (fileTransferPackageName == null) {
                throw new SdkUnsupportedException("Accessory Framework not installed", 2);
            }
            if (packageManager.getPackageInfo(fileTransferPackageName, 0) == null) {
                throw new SdkUnsupportedException("Accessory Framework not installed", 2);
            }
            SdkLog.m8378b(TAG, "Accessory File Transfer SDK version: " + Config.getSdkVersionName());
            sInitialized = true;
        } catch (PackageManager.NameNotFoundException unused) {
            SdkLog.m8383e(TAG, "Accessory Framework not installed");
            throw new SdkUnsupportedException("Accessory Framework not installed", 2);
        }
    }

    public static String getFileTransferPackageName(Context context) {
        return Initializer.useOAFApp() ? ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE : context.getPackageName();
    }
}
