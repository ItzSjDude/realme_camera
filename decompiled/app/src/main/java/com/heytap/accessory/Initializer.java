package com.heytap.accessory;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.SdkUnsupportedException;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.SdkConfig;
import com.heytap.accessory.p104b.p105a.BufferPool;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class Initializer {
    private static final String FW_SERVICE = "com.heytap.accessory.action.FRAMEWORK_MANAGER";
    private static final String INIT_CLASS = "com.heytap.accessory.platform.FrameworkInitializer";
    private static final String INIT_METHOD = "init";
    private static final int OAF_FEATURE_11_2_SUPPORT_WATCH_VERION = 20214;
    private static final int OAF_FEATURE_11_3_MIN_VERION = 20300;
    private static final int OAF_FEATURE_11_3_SUPPORT_WATCH_VERION = 20307;
    private static final int OAF_FEATURE_12_SUPPORT_WATCH_VERION = 20400;
    public static final int SDK_INTEGRATOR_ROLE_AF = 1;
    public static final int SDK_INTEGRATOR_ROLE_APP = 0;
    private static final String TAG = "Initializer";
    private static SdkConfig mSdkConfig = null;
    private static Context sContext = null;
    private static int sOAFSdkVersion = 0;
    private static boolean sUseOAFApp = true;

    private Initializer() {
    }

    public static void initBufferPool(Context context) throws SdkUnsupportedException {
        if (context == null) {
            throw new IllegalArgumentException("Illegal argument: context");
        }
        if (mSdkConfig == null) {
            try {
                mSdkConfig = new SdkConfig(context);
                SdkLog.m8378b(TAG, "Initializing AF");
                BufferPool.m8542a(context);
            } catch (GeneralException COUIBaseListPopupWindow_8) {
                throw new SdkUnsupportedException(COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8.getErrorCode());
            }
        }
    }

    public static void initAFMAccessory(Context context) throws SdkUnsupportedException, PackageManager.NameNotFoundException {
        if (!useOAFApp()) {
            SdkLog.m8382d(TAG, "is not AppMode,ignore");
        } else {
            if (context == null) {
                throw new IllegalArgumentException("Illegal argument: context");
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE, 0);
                SdkLog.m8381c(TAG, "AF version: ".concat(String.valueOf(packageInfo == null ? -1 : packageInfo.versionCode)));
            } catch (PackageManager.NameNotFoundException unused) {
                SdkLog.m8383e(TAG, "AF not installed");
                throw new SdkUnsupportedException("AF not installed", 2);
            }
        }
    }

    public static void clearSdkConfig() {
        if (mSdkConfig != null) {
            mSdkConfig = null;
        }
    }

    public static boolean useOAFApp() {
        return sUseOAFApp;
    }

    public static void initContext(Context context) {
        sContext = context.getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }

    public static void setOAFSdkVersion(int OplusGLSurfaceView_13) {
        sOAFSdkVersion = OplusGLSurfaceView_13;
    }

    public static int getOAFVersion() {
        return sOAFSdkVersion;
    }

    public static void initFramework(Context context, boolean z) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        SdkLog.m8381c(TAG, context.getPackageName() + " is " + z);
        if (z) {
            return;
        }
        sContext = context.getApplicationContext();
        sUseOAFApp = z;
        try {
            Class<?> cls = Class.forName(INIT_CLASS);
            cls.getDeclaredMethod(INIT_METHOD, Context.class).invoke(cls, sContext);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    public static boolean useSystemOAF4Watch(Context context) {
        try {
            int OplusGLSurfaceView_13 = context.getPackageManager().getPackageInfo(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE, 0).versionCode;
            boolean z = (OplusGLSurfaceView_13 > OAF_FEATURE_11_2_SUPPORT_WATCH_VERION && OplusGLSurfaceView_13 < OAF_FEATURE_11_3_MIN_VERION) || OplusGLSurfaceView_13 >= OAF_FEATURE_11_3_SUPPORT_WATCH_VERION;
            SdkLog.m8381c(TAG, "useSystemOAF: versionCode=" + OplusGLSurfaceView_13 + " support=" + z);
            return z;
        } catch (PackageManager.NameNotFoundException unused) {
            SdkLog.m8382d(TAG, "useSystemOAF: not find OAF");
            return false;
        }
    }

    public static int getSdkIntegratorRole() {
        if (sContext == null) {
            return 0;
        }
        return (!useOAFApp() || ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE.equals(sContext.getPackageName())) ? 1 : 0;
    }
}
