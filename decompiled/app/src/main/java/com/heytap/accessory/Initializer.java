package com.heytap.accessory;

/* loaded from: classes2.dex */
public class Initializer {
    private static final java.lang.String FW_SERVICE = "com.heytap.accessory.action.FRAMEWORK_MANAGER";
    private static final java.lang.String INIT_CLASS = "com.heytap.accessory.platform.FrameworkInitializer";
    private static final java.lang.String INIT_METHOD = "init";
    private static final int OAF_FEATURE_11_2_SUPPORT_WATCH_VERION = 20214;
    private static final int OAF_FEATURE_11_3_MIN_VERION = 20300;
    private static final int OAF_FEATURE_11_3_SUPPORT_WATCH_VERION = 20307;
    private static final int OAF_FEATURE_12_SUPPORT_WATCH_VERION = 20400;
    public static final int SDK_INTEGRATOR_ROLE_AF = 1;
    public static final int SDK_INTEGRATOR_ROLE_APP = 0;
    private static final java.lang.String TAG = "Initializer";
    private static com.heytap.accessory.b_renamed.g_renamed mSdkConfig = null;
    private static android.content.Context sContext = null;
    private static int sOAFSdkVersion = 0;
    private static boolean sUseOAFApp = true;

    private Initializer() {
    }

    public static void initBufferPool(android.content.Context context) throws com.heytap.accessory.bean.SdkUnsupportedException {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("Illegal argument: context");
        }
        if (mSdkConfig == null) {
            try {
                mSdkConfig = new com.heytap.accessory.b_renamed.g_renamed(context);
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Initializing AF");
                com.heytap.accessory.b_renamed.a_renamed.c_renamed.a_renamed(context);
            } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
                throw new com.heytap.accessory.bean.SdkUnsupportedException(e_renamed.getMessage(), e_renamed.getErrorCode());
            }
        }
    }

    public static void initAFMAccessory(android.content.Context context) throws com.heytap.accessory.bean.SdkUnsupportedException, android.content.pm.PackageManager.NameNotFoundException {
        if (!useOAFApp()) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "is_renamed not AppMode,ignore");
        } else {
            if (context == null) {
                throw new java.lang.IllegalArgumentException("Illegal argument: context");
            }
            try {
                android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(com.heytap.accessory.api.ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE, 0);
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "AF version: ".concat(java.lang.String.valueOf(packageInfo == null ? -1 : packageInfo.versionCode)));
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "AF not installed");
                throw new com.heytap.accessory.bean.SdkUnsupportedException("AF not installed", 2);
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

    public static void initContext(android.content.Context context) {
        sContext = context.getApplicationContext();
    }

    public static android.content.Context getContext() {
        return sContext;
    }

    public static void setOAFSdkVersion(int i_renamed) {
        sOAFSdkVersion = i_renamed;
    }

    public static int getOAFVersion() {
        return sOAFSdkVersion;
    }

    public static void initFramework(android.content.Context context, boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, context.getPackageName() + " is_renamed " + z_renamed);
        if (z_renamed) {
            return;
        }
        sContext = context.getApplicationContext();
        sUseOAFApp = z_renamed;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(INIT_CLASS);
            cls.getDeclaredMethod(INIT_METHOD, android.content.Context.class).invoke(cls, sContext);
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    public static boolean useSystemOAF4Watch(android.content.Context context) {
        try {
            int i_renamed = context.getPackageManager().getPackageInfo(com.heytap.accessory.api.ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE, 0).versionCode;
            boolean z_renamed = (i_renamed > OAF_FEATURE_11_2_SUPPORT_WATCH_VERION && i_renamed < OAF_FEATURE_11_3_MIN_VERION) || i_renamed >= OAF_FEATURE_11_3_SUPPORT_WATCH_VERION;
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "useSystemOAF: versionCode=" + i_renamed + " support=" + z_renamed);
            return z_renamed;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "useSystemOAF: not find OAF");
            return false;
        }
    }

    public static int getSdkIntegratorRole() {
        if (sContext == null) {
            return 0;
        }
        return (!useOAFApp() || com.heytap.accessory.api.ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE.equals(sContext.getPackageName())) ? 1 : 0;
    }
}
