package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public class HumanVideoApiHelper {
    private static final java.lang.String TAG = "HumanVideoApiHelper";
    private static com.oplus.ocs.camera.HumanVideoApiHelper mInstance = new com.oplus.ocs.camera.HumanVideoApiHelper();

    public static class HumanFrame {
        public byte[] data;
        public int height;
        public int rotation;
        public com.oplus.ocs.camera.HumanVideoApiHelper.ImageType type;
        public int width;
    }

    public static class HumanTexture {
        public int height;
        public boolean isOES;
        public int rotation;
        public int texID;
        public int width;
    }

    private HumanVideoApiHelper() {
    }

    public static com.oplus.ocs.camera.HumanVideoApiHelper getInstance() {
        return mInstance;
    }

    public int release() {
        return com.anc.humanvideo.HumanVideoApi.getInstance().release();
    }

    public int setLogLevel(int i_renamed) {
        return com.anc.humanvideo.HumanVideoApi.getInstance().setLogLevel(i_renamed);
    }

    public int process(com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessRequest humanProcessRequest, com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessResult humanProcessResult) {
        return com.anc.humanvideo.HumanVideoApi.getInstance().process(humanProcessRequest.mappingSDKObject(), humanProcessResult.mappingSDKObject());
    }

    public int initHandle(com.oplus.ocs.camera.HumanVideoApiHelper.HumanVideoConfig humanVideoConfig) {
        return com.anc.humanvideo.HumanVideoApi.getInstance().initHandle(humanVideoConfig.mappingSDKObject());
    }

    public int enableRuntimeFeature(com.oplus.ocs.camera.HumanVideoApiHelper.FeatureType featureType, boolean z_renamed) {
        return com.anc.humanvideo.HumanVideoApi.getInstance().enableRuntimeFeature(featureType.getSDKFeatureType(), z_renamed);
    }

    public int setParams(com.oplus.ocs.camera.HumanVideoApiHelper.HumanVideoParams humanVideoParams) {
        return com.anc.humanvideo.HumanVideoApi.getInstance().setParams(humanVideoParams.mappingSDK());
    }

    public void preInit() {
        com.anc.humanvideo.HumanVideoApi.getInstance().preInit();
    }

    public static class HumanProcessFrameResult extends com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessResult {
        public com.oplus.ocs.camera.HumanVideoApiHelper.HumanFrame humanFrame = new com.oplus.ocs.camera.HumanVideoApiHelper.HumanFrame();

        @Override // com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessResult
        com.anc.humanvideo.HumanVideoApi.HumanProcessResult mappingSDKObject() {
            com.anc.humanvideo.HumanVideoApi.HumanProcessFrameResult humanProcessFrameResult = new com.anc.humanvideo.HumanVideoApi.HumanProcessFrameResult();
            humanProcessFrameResult.humanFrame.type = this.humanFrame.type.mappingSDKObject();
            humanProcessFrameResult.humanFrame.rotation = this.humanFrame.rotation;
            humanProcessFrameResult.humanFrame.width = this.humanFrame.width;
            humanProcessFrameResult.humanFrame.height = this.humanFrame.height;
            humanProcessFrameResult.humanFrame.data = this.humanFrame.data;
            return humanProcessFrameResult;
        }
    }

    public static class HumanProcessTexureResult extends com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessResult {
        public com.oplus.ocs.camera.HumanVideoApiHelper.HumanTexture humanTexture = new com.oplus.ocs.camera.HumanVideoApiHelper.HumanTexture();

        @Override // com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessResult
        com.anc.humanvideo.HumanVideoApi.HumanProcessResult mappingSDKObject() {
            com.anc.humanvideo.HumanVideoApi.HumanProcessTexureResult humanProcessTexureResult = new com.anc.humanvideo.HumanVideoApi.HumanProcessTexureResult();
            humanProcessTexureResult.humanTexture.rotation = this.humanTexture.rotation;
            humanProcessTexureResult.humanTexture.texID = this.humanTexture.texID;
            humanProcessTexureResult.humanTexture.isOES = this.humanTexture.isOES;
            humanProcessTexureResult.humanTexture.width = this.humanTexture.width;
            humanProcessTexureResult.humanTexture.height = this.humanTexture.height;
            return humanProcessTexureResult;
        }
    }

    public static class HumanProcessResult {
        com.anc.humanvideo.HumanVideoApi.HumanProcessResult mappingSDKObject() {
            return new com.anc.humanvideo.HumanVideoApi.HumanProcessResult();
        }
    }

    public static class HumanVideoRetainParams extends com.oplus.ocs.camera.HumanVideoApiHelper.HumanVideoParams {
        public java.lang.String bgPath;
        public java.lang.String fgPath;

        @Override // com.oplus.ocs.camera.HumanVideoApiHelper.HumanVideoParams
        public com.anc.humanvideo.HumanVideoApi.HumanVideoParams mappingSDK() {
            com.anc.humanvideo.HumanVideoApi.HumanVideoRetainParams humanVideoRetainParams = new com.anc.humanvideo.HumanVideoApi.HumanVideoRetainParams();
            humanVideoRetainParams.fgPath = this.fgPath;
            humanVideoRetainParams.bgPath = this.bgPath;
            return humanVideoRetainParams;
        }
    }

    public static class HumanVideoBokehParams extends com.oplus.ocs.camera.HumanVideoApiHelper.HumanVideoParams {
        public float blurIntensity;

        @Override // com.oplus.ocs.camera.HumanVideoApiHelper.HumanVideoParams
        public com.anc.humanvideo.HumanVideoApi.HumanVideoParams mappingSDK() {
            com.anc.humanvideo.HumanVideoApi.HumanVideoBokehParams humanVideoBokehParams = new com.anc.humanvideo.HumanVideoApi.HumanVideoBokehParams();
            humanVideoBokehParams.blurIntensity = this.blurIntensity;
            return humanVideoBokehParams;
        }
    }

    public static class HumanVideoParams {
        public com.anc.humanvideo.HumanVideoApi.HumanVideoParams mappingSDK() {
            return new com.anc.humanvideo.HumanVideoApi.HumanVideoParams();
        }
    }

    public static class HumanProcessFrameRequest extends com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessRequest {
        public com.oplus.ocs.camera.HumanVideoApiHelper.HumanFrame humanFrame = new com.oplus.ocs.camera.HumanVideoApiHelper.HumanFrame();

        @Override // com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessRequest
        public com.anc.humanvideo.HumanVideoApi.HumanProcessRequest mappingSDKObject() {
            com.anc.humanvideo.HumanVideoApi.HumanProcessFrameRequest humanProcessFrameRequest = new com.anc.humanvideo.HumanVideoApi.HumanProcessFrameRequest();
            if (this.cameraType != null) {
                humanProcessFrameRequest.cameraType = this.cameraType.mappingSDKObject();
            } else {
                android.util.Log.w_renamed(com.oplus.ocs.camera.HumanVideoApiHelper.TAG, "mappingSDKObject, has not set cameraType");
            }
            humanProcessFrameRequest.humanFrame.data = this.humanFrame.data;
            humanProcessFrameRequest.humanFrame.height = this.humanFrame.height;
            humanProcessFrameRequest.humanFrame.width = this.humanFrame.width;
            humanProcessFrameRequest.humanFrame.rotation = this.humanFrame.rotation;
            humanProcessFrameRequest.humanFrame.type = this.humanFrame.type.mappingSDKObject();
            return humanProcessFrameRequest;
        }
    }

    public static class HumanProcessTextureRequest extends com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessRequest {
        public com.oplus.ocs.camera.HumanVideoApiHelper.HumanTexture humanTexture = new com.oplus.ocs.camera.HumanVideoApiHelper.HumanTexture();

        @Override // com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessRequest
        public com.anc.humanvideo.HumanVideoApi.HumanProcessRequest mappingSDKObject() {
            com.anc.humanvideo.HumanVideoApi.HumanProcessTextureRequest humanProcessTextureRequest = new com.anc.humanvideo.HumanVideoApi.HumanProcessTextureRequest();
            if (this.cameraType != null) {
                humanProcessTextureRequest.cameraType = this.cameraType.mappingSDKObject();
            } else {
                android.util.Log.w_renamed(com.oplus.ocs.camera.HumanVideoApiHelper.TAG, "mappingSDKObject, has not set cameraType");
            }
            humanProcessTextureRequest.humanTexture.height = this.humanTexture.height;
            humanProcessTextureRequest.humanTexture.width = this.humanTexture.width;
            humanProcessTextureRequest.humanTexture.isOES = this.humanTexture.isOES;
            humanProcessTextureRequest.humanTexture.texID = this.humanTexture.texID;
            humanProcessTextureRequest.humanTexture.rotation = this.humanTexture.rotation;
            return humanProcessTextureRequest;
        }
    }

    public static class HumanProcessRequest {
        public com.oplus.ocs.camera.HumanVideoApiHelper.CameraType cameraType;

        public com.anc.humanvideo.HumanVideoApi.HumanProcessRequest mappingSDKObject() {
            com.anc.humanvideo.HumanVideoApi.HumanProcessRequest humanProcessRequest = new com.anc.humanvideo.HumanVideoApi.HumanProcessRequest();
            humanProcessRequest.cameraType = this.cameraType.mappingSDKObject();
            return humanProcessRequest;
        }
    }

    public enum CameraType {
        MODE_REAR_CAMERA,
        MODE_FRONT_CAMERA;

        com.anc.humanvideo.HumanVideoApi.CameraType mappingSDKObject() {
            if (equals(MODE_FRONT_CAMERA)) {
                return com.anc.humanvideo.HumanVideoApi.CameraType.MODE_FRONT_CAMERA;
            }
            return com.anc.humanvideo.HumanVideoApi.CameraType.MODE_REAR_CAMERA;
        }
    }

    public static class HumanVideoConfig {
        public java.lang.String cachePath;
        public boolean isRealTime;
        public byte[] modelData;
        public java.lang.String modelPath;
        public java.lang.String nativeLibPath;
        public int sdkCapability;

        @android.annotation.SuppressLint({"DefaultLocale"})
        public java.lang.String toString() {
            java.lang.Object[] objArr = new java.lang.Object[5];
            objArr[0] = java.lang.Integer.valueOf(this.sdkCapability);
            byte[] bArr = this.modelData;
            objArr[1] = java.lang.Integer.valueOf(bArr != null ? bArr.length : 0);
            java.lang.String str = this.cachePath;
            objArr[2] = str != null ? new java.io.File(str).getName() : "null";
            java.lang.String str2 = this.nativeLibPath;
            objArr[3] = str2 != null ? new java.io.File(str2).getName() : "null";
            objArr[4] = java.lang.Boolean.valueOf(this.isRealTime);
            return java.lang.String.format("sdkCapability %d_renamed, model size %d_renamed, cache path %s_renamed, lib path %s_renamed, realtime %b_renamed", objArr);
        }

        com.anc.humanvideo.HumanVideoApi.HumanVideoConfig mappingSDKObject() {
            com.anc.humanvideo.HumanVideoApi.HumanVideoConfig humanVideoConfig = new com.anc.humanvideo.HumanVideoApi.HumanVideoConfig();
            humanVideoConfig.sdkCapability = this.sdkCapability;
            humanVideoConfig.modelData = this.modelData;
            humanVideoConfig.isRealTime = this.isRealTime;
            humanVideoConfig.cachePath = this.cachePath;
            humanVideoConfig.nativeLibPath = this.nativeLibPath;
            humanVideoConfig.modelPath = this.modelPath;
            return humanVideoConfig;
        }
    }

    public enum FeatureType {
        ANCHUM_FEATURE_NONE(0),
        ANCHUM_FEATURE_BOKEH(1),
        ANCHUM_FEATURE_RETAIN(2),
        ANCHUM_FEATURE_SEGMENT(4);

        private final int value;

        FeatureType(int i_renamed) {
            this.value = i_renamed;
        }

        public int getValue() {
            return this.value;
        }

        com.anc.humanvideo.HumanVideoApi.FeatureType getSDKFeatureType() {
            int i_renamed = this.value;
            if (i_renamed == 1) {
                return com.anc.humanvideo.HumanVideoApi.FeatureType.ANCHUM_FEATURE_BOKEH;
            }
            if (i_renamed == 2) {
                return com.anc.humanvideo.HumanVideoApi.FeatureType.ANCHUM_FEATURE_RETAIN;
            }
            if (i_renamed != 3) {
                return com.anc.humanvideo.HumanVideoApi.FeatureType.ANCHUM_FEATURE_NONE;
            }
            return com.anc.humanvideo.HumanVideoApi.FeatureType.ANCHUM_FEATURE_SEGMENT;
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

        com.anc.humanvideo.HumanVideoApi.ImageType mappingSDKObject() {
            switch (this) {
                case ANC_HUM_IMG_BGR:
                    return com.anc.humanvideo.HumanVideoApi.ImageType.ANC_HUM_IMG_BGR;
                case ANC_HUM_IMG_NV21:
                    return com.anc.humanvideo.HumanVideoApi.ImageType.ANC_HUM_IMG_NV21;
                case ANC_HUM_IMG_RGB:
                    return com.anc.humanvideo.HumanVideoApi.ImageType.ANC_HUM_IMG_RGB;
                case ANC_HUM_IMG_RGBA:
                    return com.anc.humanvideo.HumanVideoApi.ImageType.ANC_HUM_IMG_RGBA;
                case ANC_HUM_IMG_DEPTH:
                    return com.anc.humanvideo.HumanVideoApi.ImageType.ANC_HUM_IMG_DEPTH;
                case ANC_HUM_IMG_GREYSCALE:
                    return com.anc.humanvideo.HumanVideoApi.ImageType.ANC_HUM_IMG_GREYSCALE;
                case ANC_HUM_IMG_NV12:
                    return com.anc.humanvideo.HumanVideoApi.ImageType.ANC_HUM_IMG_NV12;
                default:
                    throw new java.lang.RuntimeException(" not match");
            }
        }
    }
}
