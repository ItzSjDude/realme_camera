package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public class HumanEffectRetainApiV2Helper {
    private static final com.oplus.ocs.camera.HumanEffectRetainApiV2Helper mInstance = new com.oplus.ocs.camera.HumanEffectRetainApiV2Helper();

    private HumanEffectRetainApiV2Helper() {
    }

    public static com.oplus.ocs.camera.HumanEffectRetainApiV2Helper getInstance() {
        return mInstance;
    }

    public int setLogLevel(int i_renamed) {
        return com.anc.humansdk.retain.HumanEffectRetainApiV2.getInstance().setLogLevel(i_renamed);
    }

    public int setParams(com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanVideoRetainParams humanVideoRetainParams) {
        return com.anc.humansdk.retain.HumanEffectRetainApiV2.getInstance().setParams(humanVideoRetainParams.mappingSDK());
    }

    public void preInit() {
        com.anc.humansdk.retain.HumanEffectRetainApiV2.getInstance().preInit();
    }

    public int initHandle(com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanVideoConfig humanVideoConfig) {
        return com.anc.humansdk.retain.HumanEffectRetainApiV2.getInstance().initHandle(humanVideoConfig.mappingSDK());
    }

    public int release() {
        return com.anc.humansdk.retain.HumanEffectRetainApiV2.getInstance().release();
    }

    public int process(com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTextureRequest humanProcessTextureRequest, com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTexureResult humanProcessTexureResult) {
        return com.anc.humansdk.retain.HumanEffectRetainApiV2.getInstance().process(humanProcessTextureRequest.mappingSDK(), humanProcessTexureResult.mappingSDK());
    }

    public java.lang.String getVersion() {
        return com.anc.humansdk.retain.HumanEffectRetainApiV2.getInstance().getVersion();
    }

    public static class HumanVideoConfig {
        public java.lang.String cachePath;
        public boolean isBackCamera;
        public boolean isRealTime;
        public byte[] modelData;
        public java.lang.String modelPath;
        public java.lang.String nativeLibPath;
        public int powerMode = com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.SdkPowerMode.ANC_HUM_POWER_DEFAULT.ordinal();
        public int sdkLoadType = com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.SdkLoadType.ANC_LOAD_TYPE_VNDKSUPPORT.ordinal();

        @android.annotation.SuppressLint({"DefaultLocale"})
        public java.lang.String toString() {
            java.lang.Object[] objArr = new java.lang.Object[5];
            byte[] bArr = this.modelData;
            objArr[0] = java.lang.Integer.valueOf(bArr != null ? bArr.length : 0);
            java.lang.String str = this.cachePath;
            objArr[1] = str != null ? new java.io.File(str).getName() : "null";
            java.lang.String str2 = this.nativeLibPath;
            objArr[2] = str2 != null ? new java.io.File(str2).getName() : "null";
            objArr[3] = java.lang.Boolean.valueOf(this.isRealTime);
            objArr[4] = java.lang.Integer.valueOf(this.sdkLoadType);
            return java.lang.String.format("model size %d_renamed, cache path %s_renamed, lib path %s_renamed, realtime %b_renamed, sdkLoadType %d_renamed", objArr);
        }

        protected com.anc.humansdk.retain.HumanEffectRetainApiV2.HumanVideoConfig mappingSDK() {
            com.anc.humansdk.retain.HumanEffectRetainApiV2.HumanVideoConfig humanVideoConfig = new com.anc.humansdk.retain.HumanEffectRetainApiV2.HumanVideoConfig();
            humanVideoConfig.isRealTime = this.isRealTime;
            humanVideoConfig.modelData = this.modelData;
            humanVideoConfig.cachePath = this.cachePath;
            humanVideoConfig.nativeLibPath = this.nativeLibPath;
            humanVideoConfig.isBackCamera = this.isBackCamera;
            humanVideoConfig.modelPath = this.modelPath;
            humanVideoConfig.powerMode = this.powerMode;
            humanVideoConfig.sdkLoadType = this.sdkLoadType;
            return humanVideoConfig;
        }
    }

    public static class HumanVideoRetainParams {
        public java.lang.String bgPath;
        public java.lang.String fgPath;

        public HumanVideoRetainParams(java.lang.String str, java.lang.String str2) {
            this.fgPath = str;
            this.bgPath = str2;
        }

        protected com.anc.humansdk.retain.HumanEffectRetainApiV2.HumanVideoRetainParams mappingSDK() {
            return new com.anc.humansdk.retain.HumanEffectRetainApiV2.HumanVideoRetainParams(this.fgPath, this.bgPath);
        }
    }

    public enum SdkLoadType {
        ANC_LOAD_TYPE_DLOEPN,
        ANC_LOAD_TYPE_ANDROID_DLOPEN,
        ANC_LOAD_TYPE_VNDKSUPPORT;

        public static com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.SdkLoadType getObject(int i_renamed) {
            try {
                return values()[i_renamed];
            } catch (java.lang.IndexOutOfBoundsException unused) {
                throw new java.lang.IllegalArgumentException("Invalid sdk load type: " + i_renamed);
            }
        }

        public int getValue() {
            return ordinal();
        }

        protected com.anc.humansdk.retain.HumanEffectRetainApiV2.SdkLoadType mappingSDK() {
            if (equals(ANC_LOAD_TYPE_DLOEPN)) {
                return com.anc.humansdk.retain.HumanEffectRetainApiV2.SdkLoadType.ANC_LOAD_TYPE_DLOEPN;
            }
            if (equals(ANC_LOAD_TYPE_ANDROID_DLOPEN)) {
                return com.anc.humansdk.retain.HumanEffectRetainApiV2.SdkLoadType.ANC_LOAD_TYPE_ANDROID_DLOPEN;
            }
            if (equals(ANC_LOAD_TYPE_VNDKSUPPORT)) {
                return com.anc.humansdk.retain.HumanEffectRetainApiV2.SdkLoadType.ANC_LOAD_TYPE_VNDKSUPPORT;
            }
            return com.anc.humansdk.retain.HumanEffectRetainApiV2.SdkLoadType.ANC_LOAD_TYPE_VNDKSUPPORT;
        }
    }

    public enum SdkPowerMode {
        ANC_HUM_POWER_DEFAULT,
        ANC_HUM_POWER_LOW,
        ANC_HUM_POWER_MEDIUM,
        ANC_HUM_POWER_HIGH;

        public static com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.SdkPowerMode getObject(int i_renamed) {
            try {
                return values()[i_renamed];
            } catch (java.lang.IndexOutOfBoundsException unused) {
                throw new java.lang.IllegalArgumentException("Invalid sdk power state: " + i_renamed);
            }
        }

        public int getValue() {
            return ordinal();
        }
    }

    public enum CameraType {
        CAMERA_TYPE_REAR,
        CAMERA_TYPE_FRONT;

        protected com.anc.humansdk.retain.HumanEffectRetainApiV2.CameraType mappingSDK() {
            if (equals(CAMERA_TYPE_FRONT)) {
                return com.anc.humansdk.retain.HumanEffectRetainApiV2.CameraType.CAMERA_TYPE_FRONT;
            }
            return com.anc.humansdk.retain.HumanEffectRetainApiV2.CameraType.CAMERA_TYPE_REAR;
        }
    }

    public enum ImageType {
        ANC_HUM_IMG_NV21,
        ANC_HUM_IMG_BGR,
        ANC_HUM_IMG_RGB,
        ANC_HUM_IMG_RGBA,
        ANC_HUM_IMG_DEPTH,
        ANC_HUM_IMG_GREYSCALE,
        ANC_HUM_IMG_NV12;

        protected com.anc.humansdk.retain.HumanEffectRetainApiV2.ImageType mappingSDK() {
            if (equals(ANC_HUM_IMG_NV21)) {
                return com.anc.humansdk.retain.HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_NV21;
            }
            if (equals(ANC_HUM_IMG_BGR)) {
                return com.anc.humansdk.retain.HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_BGR;
            }
            if (equals(ANC_HUM_IMG_RGB)) {
                return com.anc.humansdk.retain.HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_RGB;
            }
            if (equals(ANC_HUM_IMG_RGBA)) {
                return com.anc.humansdk.retain.HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_RGBA;
            }
            if (equals(ANC_HUM_IMG_DEPTH)) {
                return com.anc.humansdk.retain.HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_DEPTH;
            }
            if (equals(ANC_HUM_IMG_GREYSCALE)) {
                return com.anc.humansdk.retain.HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_GREYSCALE;
            }
            if (equals(ANC_HUM_IMG_NV12)) {
                return com.anc.humansdk.retain.HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_NV12;
            }
            return com.anc.humansdk.retain.HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_NV21;
        }
    }

    public static class HumanVideoFrame {
        public byte[] data;
        public int height;
        public int rotation;
        public com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.ImageType type;
        public int width;

        public HumanVideoFrame(byte[] bArr, com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.ImageType imageType, int i_renamed, int i2, int i3) {
            this.data = bArr;
            this.type = imageType;
            this.width = i_renamed;
            this.height = i2;
            this.rotation = i3;
        }
    }

    public static class HumanVideoTexture {
        public int height;
        public boolean isOES;
        public int rotation;
        public int texID;
        public int width;

        public HumanVideoTexture(int i_renamed, boolean z_renamed, int i2, int i3, int i4) {
            this.texID = i_renamed;
            this.isOES = z_renamed;
            this.width = i2;
            this.height = i3;
            this.rotation = i4;
        }

        protected com.anc.humansdk.retain.HumanEffectRetainApiV2.HumanVideoTexture mappingSDK() {
            return new com.anc.humansdk.retain.HumanEffectRetainApiV2.HumanVideoTexture(this.texID, this.isOES, this.width, this.height, this.rotation);
        }
    }

    public static class HumanProcessTextureRequest {
        public com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.CameraType cameraType;
        public com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanVideoTexture humanVideoTexture;

        public static com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTextureRequestBuilder Builder() {
            return new com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTextureRequestBuilder();
        }

        public HumanProcessTextureRequest(com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.CameraType cameraType, com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanVideoTexture humanVideoTexture) {
            this.cameraType = cameraType;
            this.humanVideoTexture = humanVideoTexture;
        }

        protected com.anc.humansdk.retain.HumanEffectRetainApiV2.HumanProcessTextureRequest mappingSDK() {
            return new com.anc.humansdk.retain.HumanEffectRetainApiV2.HumanProcessTextureRequest(this.cameraType.mappingSDK(), this.humanVideoTexture.mappingSDK());
        }
    }

    public static class HumanProcessTextureRequestBuilder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.CameraType cameraType;
        public int height;
        public boolean isOES;
        public int rotation;
        public int texID;
        public int width;

        public com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTextureRequestBuilder setCameraType(com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.CameraType cameraType) {
            this.cameraType = cameraType;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTextureRequestBuilder setTexID(int i_renamed) {
            this.texID = i_renamed;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTextureRequestBuilder setOES(boolean z_renamed) {
            this.isOES = z_renamed;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTextureRequestBuilder setWidth(int i_renamed) {
            this.width = i_renamed;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTextureRequestBuilder setHeight(int i_renamed) {
            this.height = i_renamed;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTextureRequestBuilder setRotation(int i_renamed) {
            this.rotation = i_renamed;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTextureRequest build() {
            int i_renamed;
            int i2;
            int i3 = this.texID;
            if (i3 <= 0 || (i_renamed = this.width) <= 0 || (i2 = this.height) <= 0) {
                return null;
            }
            int i4 = this.rotation;
            if (i4 % 90 != 0 || this.cameraType == null) {
                return null;
            }
            return new com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTextureRequest(this.cameraType, new com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanVideoTexture(i3, this.isOES, i_renamed, i2, i4));
        }
    }

    public static class HumanProcessTexureResult {
        public com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanVideoTexture humanVideoTexture;

        public HumanProcessTexureResult(com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanVideoTexture humanVideoTexture) {
            this.humanVideoTexture = humanVideoTexture;
        }

        public HumanProcessTexureResult(int i_renamed, boolean z_renamed, int i2, int i3, int i4) {
            this.humanVideoTexture = new com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanVideoTexture(i_renamed, z_renamed, i2, i3, i4);
        }

        protected com.anc.humansdk.retain.HumanEffectRetainApiV2.HumanProcessTexureResult mappingSDK() {
            return new com.anc.humansdk.retain.HumanEffectRetainApiV2.HumanProcessTexureResult(this.humanVideoTexture.mappingSDK());
        }
    }
}
