package com.meicam.sdk;

import java.util.List;

/* loaded from: classes2.dex */
public class NvsAssetPackageManager {
    public static final int ASSET_PACKAGE_ASPECT_RATIO_16v9 = 1;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_18v9 = 32;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_1v1 = 2;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_3v4 = 16;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_4v3 = 8;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_9v16 = 4;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_9v18 = 64;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_ALREADY_INSTALLED = 2;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_ASSET_TYPE = 8;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_DECOMPRESSION = 6;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_IMPROPER_STATUS = 5;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_INVALID_PACKAGE = 7;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_IO = 13;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_META_CONTENT = 10;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_NAME = 1;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_NOT_INSTALLED = 4;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_NO_ERROR = 0;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_PERMISSION = 9;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_RESOURCE = 14;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_SDK_VERSION = 11;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_UPGRADE_VERSION = 12;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_WORKING_INPROGRESS = 3;
    public static final int ASSET_PACKAGE_STATUS_INSTALLING = 1;
    public static final int ASSET_PACKAGE_STATUS_NOTINSTALLED = 0;
    public static final int ASSET_PACKAGE_STATUS_READY = 2;
    public static final int ASSET_PACKAGE_STATUS_UPGRADING = 3;
    public static final int ASSET_PACKAGE_TYPE_ANIMATEDSTICKER = 3;
    public static final int ASSET_PACKAGE_TYPE_ARSCENE = 6;
    public static final int ASSET_PACKAGE_TYPE_CAPTIONSTYLE = 2;
    public static final int ASSET_PACKAGE_TYPE_CAPTURESCENE = 5;
    public static final int ASSET_PACKAGE_TYPE_COMPOUND_CAPTION = 7;
    public static final int ASSET_PACKAGE_TYPE_THEME = 4;
    public static final int ASSET_PACKAGE_TYPE_VIDEOFX = 0;
    public static final int ASSET_PACKAGE_TYPE_VIDEOTRANSITION = 1;
    long m_internalObject = 0;
    long m_internalCallbackObject = 0;
    AssetPackageManagerCallback m_callback = null;

    public static class ARSceneBeautyPreset {
        public float amplitude;
        public boolean defaultBeautyEnabled;
        public float defaultBeautyIntensity;
        public boolean enabled;
        public float reddening;
        public boolean sharpenEnabled;
        public float whitening;
    }

    public static class ARSceneShapeBeautificationPreset {
        public float chinWarp;
        public boolean enabled;
        public float eyeCornerStretch;
        public float eyeDistanceWarp;
        public float eyeSizeWarp;
        public float eyebrowWarp;
        public float faceLengthWarp;
        public float faceSizeWarp;
        public float faceWidthWarp;
        public float foreheadWarp;
        public float hairlineWarp;
        public float jawWarp;
        public float malarWarp;
        public float mouthCornerLift;
        public float mouthSizeWarp;
        public float mouthWidthWarp;
        public float noseLengthWarp;
        public float noseWidthWarp;
    }

    public interface AssetPackageManagerCallback {
        void onFinishAssetPackageInstallation(String str, String str2, int OplusGLSurfaceView_13, int i2);

        void onFinishAssetPackageUpgrading(String str, String str2, int OplusGLSurfaceView_13, int i2);
    }

    private native ARSceneBeautyPreset nativeGetARSceneAssetPackageBeautyPreset(long OplusGLSurfaceView_15, String str);

    private native String nativeGetARSceneAssetPackagePrompt(long OplusGLSurfaceView_15, String str);

    /* renamed from: nativeGetARSceneAssetPackageShapeBeautificationPreset */
    private native ARSceneShapeBeautificationPreset m8730x1ea3a36f(long OplusGLSurfaceView_15, String str);

    private native String nativeGetAssetPackageIdFromAssetPackageFilePath(long OplusGLSurfaceView_15, String str);

    private native List<String> nativeGetAssetPackageListOfType(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native int nativeGetAssetPackageStatus(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13);

    private native int nativeGetAssetPackageSupportedAspectRatio(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13);

    private native int nativeGetAssetPackageVersion(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13);

    /* renamed from: nativeGetAssetPackageVersionFromAssetPackageFilePath */
    private native int m8731x27a94584(long OplusGLSurfaceView_15, String str);

    private native String nativeGetVideoFxAssetPackageDescription(long OplusGLSurfaceView_15, String str);

    private native int nativeInstallAssetPackage(long OplusGLSurfaceView_15, String str, String str2, int OplusGLSurfaceView_13, boolean z, StringBuilder sb);

    private native boolean nativeIsCustomAnimatedSticker(long OplusGLSurfaceView_15, String str);

    private native boolean nativeIsParticleFX(long OplusGLSurfaceView_15, String str);

    private native boolean nativeIsThemeContainMusic(long OplusGLSurfaceView_15, String str);

    private native void nativeSetCallbackInterface(AssetPackageManagerCallback assetPackageManagerCallback);

    private native void nativeSetInternalCallbackObject(boolean z);

    private native int nativeUninstallAssetPackage(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13);

    private native int nativeUpgradeAssetPackage(long OplusGLSurfaceView_15, String str, String str2, int OplusGLSurfaceView_13, boolean z, StringBuilder sb);

    public NvsAssetPackageManager(boolean z) {
        nativeSetInternalCallbackObject(z);
    }

    public void setInternalObject(long OplusGLSurfaceView_15) {
        if (this.m_internalObject != 0) {
            setCallbackInterface(null);
        }
        this.m_internalObject = OplusGLSurfaceView_15;
    }

    public void setCallbackInterface(AssetPackageManagerCallback assetPackageManagerCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_callback = assetPackageManagerCallback;
        nativeSetCallbackInterface(this.m_callback);
    }

    public String getAssetPackageIdFromAssetPackageFilePath(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAssetPackageIdFromAssetPackageFilePath(this.m_internalObject, str);
    }

    public int getAssetPackageVersionFromAssetPackageFilePath(String str) {
        NvsUtils.checkFunctionInMainThread();
        return m8731x27a94584(this.m_internalObject, str);
    }

    public int installAssetPackage(String str, String str2, int OplusGLSurfaceView_13, boolean z, StringBuilder sb) {
        NvsUtils.checkFunctionInMainThread();
        return nativeInstallAssetPackage(this.m_internalObject, str, str2, OplusGLSurfaceView_13, z, sb);
    }

    public int upgradeAssetPackage(String str, String str2, int OplusGLSurfaceView_13, boolean z, StringBuilder sb) {
        NvsUtils.checkFunctionInMainThread();
        return nativeUpgradeAssetPackage(this.m_internalObject, str, str2, OplusGLSurfaceView_13, z, sb);
    }

    public int uninstallAssetPackage(String str, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeUninstallAssetPackage(this.m_internalObject, str, OplusGLSurfaceView_13);
    }

    public int getAssetPackageStatus(String str, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAssetPackageStatus(this.m_internalObject, str, OplusGLSurfaceView_13);
    }

    public int getAssetPackageVersion(String str, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAssetPackageVersion(this.m_internalObject, str, OplusGLSurfaceView_13);
    }

    public int getAssetPackageSupportedAspectRatio(String str, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAssetPackageSupportedAspectRatio(this.m_internalObject, str, OplusGLSurfaceView_13);
    }

    public List<String> getAssetPackageListOfType(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAssetPackageListOfType(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public boolean isCustomAnimatedSticker(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsCustomAnimatedSticker(this.m_internalObject, str);
    }

    public boolean isParticleFX(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsParticleFX(this.m_internalObject, str);
    }

    public boolean isThemeContainMusic(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsThemeContainMusic(this.m_internalObject, str);
    }

    public String getVideoFxAssetPackageDescription(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoFxAssetPackageDescription(this.m_internalObject, str);
    }

    public String getARSceneAssetPackagePrompt(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetARSceneAssetPackagePrompt(this.m_internalObject, str);
    }

    public ARSceneBeautyPreset getARSceneAssetPackageBeautyPreset(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetARSceneAssetPackageBeautyPreset(this.m_internalObject, str);
    }

    public ARSceneShapeBeautificationPreset getARSceneAssetPackageShapeBeautificationPreset(String str) {
        NvsUtils.checkFunctionInMainThread();
        return m8730x1ea3a36f(this.m_internalObject, str);
    }
}
