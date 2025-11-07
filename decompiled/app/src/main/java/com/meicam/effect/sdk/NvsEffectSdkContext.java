package com.meicam.effect.sdk;

/* loaded from: classes2.dex */
public class NvsEffectSdkContext {
    public static final int DEBUG_LEVEL_DEBUG = 3;
    public static final int DEBUG_LEVEL_ERROR = 1;
    public static final int DEBUG_LEVEL_NONE = 0;
    public static final int DEBUG_LEVEL_WARNING = 2;
    public static final int HUMAN_DETECTION_DATA_TYPE_FAKE_FACE = 0;
    public static final int HUMAN_DETECTION_FEATURE_FACE_ACTION = 2;
    public static final int HUMAN_DETECTION_FEATURE_FACE_LANDMARK = 1;
    private static final java.lang.String TAG = "Meicam";
    private static android.content.res.AssetManager m_assetManager = null;
    private static java.lang.Thread m_checkExpirationThread = null;
    private static java.lang.ClassLoader m_classLoader = null;
    private static android.content.Context m_context = null;
    private static int m_debugLevel = 3;
    private static boolean m_faceDetectionLibLoaded;
    private static boolean m_initializedOnce;
    private static com.meicam.effect.sdk.NvsEffectSdkContext m_instance;
    private static boolean m_saveDebugMessagesToFile;
    private com.meicam.sdk.NvsAssetPackageManager m_assetPackageManager;

    public static class SdkVersion {
        public int majorVersion;
        public int minorVersion;
        public int revisionNumber;
    }

    public static class VerifyLicenseResult {
        public boolean needCheckExpiration;
        public boolean success;
    }

    private static native void nativeClose();

    private static native void nativeCloseHumanDetection();

    private native com.meicam.effect.sdk.NvsEffectRenderCore nativeCreateEffectRenderCore();

    private native com.meicam.effect.sdk.NvsVideoEffect nativeCreateVideoEffect(java.lang.String str, com.meicam.sdk.NvsRational nvsRational);

    private native void nativeDetectPackageName(android.content.Context context);

    private static native boolean nativeFunctionalityAuthorised(java.lang.String str);

    private native java.util.List<java.lang.String> nativeGetAllBuiltinVideoFxNames();

    private native long nativeGetAssetPackageManager();

    private native com.meicam.effect.sdk.NvsEffectSdkContext.SdkVersion nativeGetSdkVersion();

    private static native int nativeHasARModule();

    private static native boolean nativeInit(java.lang.String str, int i_renamed);

    private static native boolean nativeInitHumanDetection(android.content.Context context, java.lang.String str, java.lang.String str2, int i_renamed);

    private static native boolean nativeInitJNI(android.content.Context context);

    private native boolean nativeIsEffectSdkAuthorised();

    private static native void nativeSetAssetManager(android.content.res.AssetManager assetManager);

    private static native void nativeSetDebugLevel(int i_renamed);

    private static native void nativeSetSaveDebugMessagesToFile(boolean z_renamed);

    private static native boolean nativeSetupHumanDetectionData(int i_renamed, java.lang.String str);

    private static native com.meicam.effect.sdk.NvsEffectSdkContext.VerifyLicenseResult nativeVerifySdkLicenseFile(android.content.Context context, java.lang.String str, boolean z_renamed);

    public static void setDebugLevel(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (i_renamed == m_debugLevel) {
            return;
        }
        m_debugLevel = i_renamed;
        if (m_instance != null) {
            nativeSetDebugLevel(m_debugLevel);
        }
    }

    public static void setSaveDebugMessagesToFile(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (z_renamed == m_saveDebugMessagesToFile) {
            return;
        }
        m_saveDebugMessagesToFile = z_renamed;
        if (m_instance != null) {
            nativeSetSaveDebugMessagesToFile(m_saveDebugMessagesToFile);
        }
    }

    public static android.content.Context getContext() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return m_context;
    }

    public static java.lang.ClassLoader getClassLoader() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return m_classLoader;
    }

    public boolean isSdkAuthorised() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsEffectSdkAuthorised();
    }

    public static com.meicam.effect.sdk.NvsEffectSdkContext init(android.content.Context context, java.lang.String str, int i_renamed) throws java.lang.Exception {
        boolean z_renamed;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        com.meicam.effect.sdk.NvsEffectSdkContext nvsEffectSdkContext = m_instance;
        if (nvsEffectSdkContext != null) {
            return nvsEffectSdkContext;
        }
        java.lang.String str2 = ("HOME=" + context.getFilesDir().getAbsolutePath()) + "\tTMPDIR=" + context.getFilesDir().getAbsolutePath();
        try {
            m_assetManager = context.getAssets();
            m_context = context.getApplicationContext();
            m_classLoader = m_context.getClassLoader();
            if (!m_initializedOnce) {
                tryLoadFaceDetectionLibrary();
                try {
                    java.lang.Class.forName("com.meicam.sdk.NvsStreamingContext");
                    z_renamed = false;
                } catch (java.lang.Exception unused) {
                    z_renamed = true;
                }
                loadNativeLibrary(z_renamed ? "NvEffectSdkCore" : "NvStreamingSdkCore");
            }
            if (!nativeInitJNI(m_context)) {
                throw new java.lang.Exception("nativeInitJNI() failed!");
            }
            nativeSetAssetManager(m_assetManager);
            nativeSetDebugLevel(m_debugLevel);
            nativeSetSaveDebugMessagesToFile(m_saveDebugMessagesToFile);
            boolean z2 = com.meicam.sdk.NvsSystemVariableManager.getSystemVariableInt(context, "isExpired") == 1;
            com.meicam.effect.sdk.NvsEffectSdkContext.VerifyLicenseResult verifyLicenseResult = new com.meicam.effect.sdk.NvsEffectSdkContext.VerifyLicenseResult();
            if (!m_initializedOnce) {
                verifyLicenseResult = nativeVerifySdkLicenseFile(context, str, z2);
            }
            if (verifyLicenseResult.needCheckExpiration) {
                java.lang.String systemVariableString = com.meicam.sdk.NvsSystemVariableManager.getSystemVariableString(context, "lastTime");
                if (android.text.TextUtils.isEmpty(systemVariableString) || com.meicam.sdk.NvsTimeUtil.getHourRange(systemVariableString, com.meicam.sdk.NvsTimeUtil.getCurrentTime()) >= 0) {
                }
            }
            if (!nativeInit(str2, i_renamed)) {
                return null;
            }
            m_instance = new com.meicam.effect.sdk.NvsEffectSdkContext(context);
            m_initializedOnce = true;
            return m_instance;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            m_context = null;
            m_classLoader = null;
            m_assetManager = null;
            return null;
        }
    }

    public static com.meicam.effect.sdk.NvsEffectSdkContext init(android.app.Activity activity, java.lang.String str, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return init((android.content.Context) activity, str, i_renamed);
    }

    public static com.meicam.effect.sdk.NvsEffectSdkContext init(android.app.Activity activity, java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return init(activity, str, 0);
    }

    public static void close() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        com.meicam.effect.sdk.NvsEffectSdkContext nvsEffectSdkContext = m_instance;
        if (nvsEffectSdkContext == null) {
            return;
        }
        com.meicam.sdk.NvsAssetPackageManager assetPackageManager = nvsEffectSdkContext.getAssetPackageManager();
        if (assetPackageManager != null) {
            assetPackageManager.setCallbackInterface(null);
        }
        m_instance = null;
        m_context = null;
        nativeSetAssetManager(null);
        m_assetManager = null;
        m_classLoader = null;
        nativeClose();
    }

    public static com.meicam.effect.sdk.NvsEffectSdkContext getInstance() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return m_instance;
    }

    public static int hasARModule() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeHasARModule();
    }

    public static boolean initHumanDetection(android.content.Context context, java.lang.String str, java.lang.String str2, int i_renamed) throws java.lang.ClassNotFoundException {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        tryLoadFaceDetectionLibrary();
        if (m_faceDetectionLibLoaded) {
            return nativeInitHumanDetection(context, str, str2, i_renamed);
        }
        return false;
    }

    public static void closeHumanDetection() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeCloseHumanDetection();
    }

    public static boolean setupHumanDetectionData(int i_renamed, java.lang.String str) {
        return nativeSetupHumanDetectionData(i_renamed, str);
    }

    private NvsEffectSdkContext(android.content.Context context) {
        this.m_assetPackageManager = null;
        this.m_assetPackageManager = new com.meicam.sdk.NvsAssetPackageManager(true);
        this.m_assetPackageManager.setInternalObject(nativeGetAssetPackageManager());
        nativeDetectPackageName(context);
    }

    public com.meicam.effect.sdk.NvsEffectSdkContext.SdkVersion getSdkVersion() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetSdkVersion();
    }

    public com.meicam.sdk.NvsAssetPackageManager getAssetPackageManager() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_assetPackageManager;
    }

    public java.util.List<java.lang.String> getAllBuiltinVideoFxNames() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAllBuiltinVideoFxNames();
    }

    public com.meicam.effect.sdk.NvsVideoEffect createVideoEffect(java.lang.String str, com.meicam.sdk.NvsRational nvsRational) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeCreateVideoEffect(str, nvsRational);
    }

    public com.meicam.effect.sdk.NvsEffectRenderCore createEffectRenderCore() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeCreateEffectRenderCore();
    }

    private boolean checkCameraPermission() {
        if (android.os.Build.VERSION.SDK_INT < 23) {
        }
        return true;
    }

    private boolean checkInternetPermission() {
        if (android.os.Build.VERSION.SDK_INT < 23 || m_context.checkSelfPermission("android.permission.INTERNET") == 0) {
            return true;
        }
        android.util.Log.e_renamed(TAG, "INTERNET permission has not been granted!");
        return false;
    }

    private static void loadNativeLibrary(java.lang.String str) throws java.lang.SecurityException, java.lang.UnsatisfiedLinkError, java.lang.NullPointerException {
        java.lang.System.loadLibrary(str);
    }

    private static boolean tryLoadNativeLibrary(java.lang.String str) throws java.lang.SecurityException, java.lang.UnsatisfiedLinkError, java.lang.NullPointerException {
        try {
            java.lang.System.loadLibrary(str);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private static void tryLoadFaceDetectionLibrary() throws java.lang.ClassNotFoundException {
        boolean z_renamed;
        boolean z2;
        if (m_faceDetectionLibLoaded) {
            return;
        }
        boolean z3 = false;
        try {
            java.lang.Class.forName("com.meicam.effect.sdk.NvsBEFFaceEffectDetector");
            z_renamed = true;
        } catch (java.lang.Exception unused) {
            z_renamed = false;
        }
        if (!z_renamed || tryLoadNativeLibrary("effect")) {
            try {
                java.lang.Class.forName("com.meicam.effect.sdk.NvsMGFaceEffectDetector");
                z2 = true;
            } catch (java.lang.Exception unused2) {
                z2 = false;
            }
            if (!z2 || (tryLoadNativeLibrary("megface-new") && tryLoadNativeLibrary("MegviiFacepp"))) {
                try {
                    java.lang.Class.forName("com.meicam.effect.sdk.NvsSTFaceEffectDetector");
                    z3 = true;
                } catch (java.lang.Exception unused3) {
                }
                if (!z3 || tryLoadNativeLibrary("st_mobile")) {
                    m_faceDetectionLibLoaded = true;
                }
            }
        }
    }

    public static boolean functionalityAuthorised(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeFunctionalityAuthorised(str);
    }
}
