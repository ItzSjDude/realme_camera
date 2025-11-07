package com.heytap.accessory.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.heytap.accessory.Initializer;
import com.heytap.accessory.bean.SdkUnsupportedException;
import com.heytap.accessory.p103a.SdkLog;

/* loaded from: classes2.dex */
public class ManagerConfig {
    public static final String ACCESSORY_FRAMEWORK_PACKAGE = "com.heytap.accessory";
    public static final String INTENT_BASE_FRAMEWORK_SERVICE = "com.heytap.accessory.action.BASE_FRAMEWORK_MANAGER";
    private static final String TAG = "ManagerConfig";
    private static final int VERSION_FAST_PAIR = 20000;
    private static int sFrameworkVersion = 1;

    public ManagerConfig(Context context) throws SdkUnsupportedException, PackageManager.NameNotFoundException {
        if (context == null) {
            throw new IllegalArgumentException("Invalid Context");
        }
        if (!Initializer.useOAFApp()) {
            SdkLog.m8382d(TAG, "is not AppMode,ignore");
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(ACCESSORY_FRAMEWORK_PACKAGE, 0);
            if (packageInfo != null) {
                synchronized (ManagerConfig.class) {
                    sFrameworkVersion = packageInfo.versionCode;
                }
                return;
            }
            throw new SdkUnsupportedException("Accessory Framework Not installed", 2);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new SdkUnsupportedException("Accessory Framework Not installed", 2);
        }
    }

    public static int getFrameworkVersion() {
        return sFrameworkVersion;
    }

    public boolean isSupportFastPair() {
        return sFrameworkVersion >= 20000;
    }
}
