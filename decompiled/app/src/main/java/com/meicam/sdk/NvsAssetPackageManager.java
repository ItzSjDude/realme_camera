package com.meicam.sdk;

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
    com.meicam.sdk.NvsAssetPackageManager.AssetPackageManagerCallback m_callback = null;

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
        void onFinishAssetPackageInstallation(java.lang.String str, java.lang.String str2, int i_renamed, int i2);

        void onFinishAssetPackageUpgrading(java.lang.String str, java.lang.String str2, int i_renamed, int i2);
    }

    private native com.meicam.sdk.NvsAssetPackageManager.ARSceneBeautyPreset nativeGetARSceneAssetPackageBeautyPreset(long j_renamed, java.lang.String str);

    private native java.lang.String nativeGetARSceneAssetPackagePrompt(long j_renamed, java.lang.String str);

    private native com.meicam.sdk.NvsAssetPackageManager.ARSceneShapeBeautificationPreset nativeGetARSceneAssetPackageShapeBeautificationPreset(long j_renamed, java.lang.String str);

    private native java.lang.String nativeGetAssetPackageIdFromAssetPackageFilePath(long j_renamed, java.lang.String str);

    private native java.util.List<java.lang.String> nativeGetAssetPackageListOfType(long j_renamed, int i_renamed);

    private native int nativeGetAssetPackageStatus(long j_renamed, java.lang.String str, int i_renamed);

    private native int nativeGetAssetPackageSupportedAspectRatio(long j_renamed, java.lang.String str, int i_renamed);

    private native int nativeGetAssetPackageVersion(long j_renamed, java.lang.String str, int i_renamed);

    private native int nativeGetAssetPackageVersionFromAssetPackageFilePath(long j_renamed, java.lang.String str);

    private native java.lang.String nativeGetVideoFxAssetPackageDescription(long j_renamed, java.lang.String str);

    private native int nativeInstallAssetPackage(long j_renamed, java.lang.String str, java.lang.String str2, int i_renamed, boolean z_renamed, java.lang.StringBuilder sb);

    private native boolean nativeIsCustomAnimatedSticker(long j_renamed, java.lang.String str);

    private native boolean nativeIsParticleFX(long j_renamed, java.lang.String str);

    private native boolean nativeIsThemeContainMusic(long j_renamed, java.lang.String str);

    private native void nativeSetCallbackInterface(com.meicam.sdk.NvsAssetPackageManager.AssetPackageManagerCallback assetPackageManagerCallback);

    private native void nativeSetInternalCallbackObject(boolean z_renamed);

    private native int nativeUninstallAssetPackage(long j_renamed, java.lang.String str, int i_renamed);

    private native int nativeUpgradeAssetPackage(long j_renamed, java.lang.String str, java.lang.String str2, int i_renamed, boolean z_renamed, java.lang.StringBuilder sb);

    public NvsAssetPackageManager(boolean z_renamed) {
        nativeSetInternalCallbackObject(z_renamed);
    }

    public void setInternalObject(long j_renamed) {
        if (this.m_internalObject != 0) {
            setCallbackInterface(null);
        }
        this.m_internalObject = j_renamed;
    }

    public void setCallbackInterface(com.meicam.sdk.NvsAssetPackageManager.AssetPackageManagerCallback assetPackageManagerCallback) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_callback = assetPackageManagerCallback;
        nativeSetCallbackInterface(this.m_callback);
    }

    public java.lang.String getAssetPackageIdFromAssetPackageFilePath(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAssetPackageIdFromAssetPackageFilePath(this.m_internalObject, str);
    }

    public int getAssetPackageVersionFromAssetPackageFilePath(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAssetPackageVersionFromAssetPackageFilePath(this.m_internalObject, str);
    }

    public int installAssetPackage(java.lang.String str, java.lang.String str2, int i_renamed, boolean z_renamed, java.lang.StringBuilder sb) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInstallAssetPackage(this.m_internalObject, str, str2, i_renamed, z_renamed, sb);
    }

    public int upgradeAssetPackage(java.lang.String str, java.lang.String str2, int i_renamed, boolean z_renamed, java.lang.StringBuilder sb) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeUpgradeAssetPackage(this.m_internalObject, str, str2, i_renamed, z_renamed, sb);
    }

    public int uninstallAssetPackage(java.lang.String str, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeUninstallAssetPackage(this.m_internalObject, str, i_renamed);
    }

    public int getAssetPackageStatus(java.lang.String str, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAssetPackageStatus(this.m_internalObject, str, i_renamed);
    }

    public int getAssetPackageVersion(java.lang.String str, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAssetPackageVersion(this.m_internalObject, str, i_renamed);
    }

    public int getAssetPackageSupportedAspectRatio(java.lang.String str, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAssetPackageSupportedAspectRatio(this.m_internalObject, str, i_renamed);
    }

    public java.util.List<java.lang.String> getAssetPackageListOfType(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAssetPackageListOfType(this.m_internalObject, i_renamed);
    }

    public boolean isCustomAnimatedSticker(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsCustomAnimatedSticker(this.m_internalObject, str);
    }

    public boolean isParticleFX(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsParticleFX(this.m_internalObject, str);
    }

    public boolean isThemeContainMusic(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsThemeContainMusic(this.m_internalObject, str);
    }

    public java.lang.String getVideoFxAssetPackageDescription(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoFxAssetPackageDescription(this.m_internalObject, str);
    }

    public java.lang.String getARSceneAssetPackagePrompt(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetARSceneAssetPackagePrompt(this.m_internalObject, str);
    }

    public com.meicam.sdk.NvsAssetPackageManager.ARSceneBeautyPreset getARSceneAssetPackageBeautyPreset(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetARSceneAssetPackageBeautyPreset(this.m_internalObject, str);
    }

    public com.meicam.sdk.NvsAssetPackageManager.ARSceneShapeBeautificationPreset getARSceneAssetPackageShapeBeautificationPreset(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetARSceneAssetPackageShapeBeautificationPreset(this.m_internalObject, str);
    }
}
