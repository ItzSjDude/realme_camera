package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public class HumanEffectFusionApiHelper {
    private static com.oplus.ocs.camera.HumanEffectFusionApiHelper sCaptureInstance;
    private static com.anc.humansdk.fusion.HumanEffectFusionApi sHumanEffectFusionApi;
    private static com.oplus.ocs.camera.HumanEffectFusionApiHelper sPreviewInstance;

    private HumanEffectFusionApiHelper(com.anc.humansdk.fusion.HumanEffectFusionApi humanEffectFusionApi) {
        sHumanEffectFusionApi = humanEffectFusionApi;
    }

    public static com.oplus.ocs.camera.HumanEffectFusionApiHelper getPreviewInstance() {
        if (sPreviewInstance == null) {
            synchronized (com.oplus.ocs.camera.HumanEffectFusionApiHelper.class) {
                if (sPreviewInstance == null) {
                    sPreviewInstance = new com.oplus.ocs.camera.HumanEffectFusionApiHelper(com.anc.humansdk.fusion.HumanEffectFusionApi.getPreviewInstance());
                }
            }
        }
        return sPreviewInstance;
    }

    public static com.oplus.ocs.camera.HumanEffectFusionApiHelper getCaptureInstance() {
        if (sCaptureInstance == null) {
            synchronized (com.oplus.ocs.camera.HumanEffectFusionApiHelper.class) {
                if (sCaptureInstance == null) {
                    sCaptureInstance = new com.oplus.ocs.camera.HumanEffectFusionApiHelper(com.anc.humansdk.fusion.HumanEffectFusionApi.getCaptureInstance());
                }
            }
        }
        return sCaptureInstance;
    }

    public int setFeatureType(com.oplus.ocs.camera.HumanEffectFusionApiHelper.FeatureType featureType) {
        return sHumanEffectFusionApi.setFeatureType(featureType.mappingSDKObject());
    }

    public int setLogLevel(int i_renamed) {
        return sHumanEffectFusionApi.setLogLevel(i_renamed);
    }

    public int initByConfig(com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanEffectFusionConfig humanEffectFusionConfig) {
        return sHumanEffectFusionApi.initByConfig(humanEffectFusionConfig.mappingSDKObject());
    }

    public java.lang.String getVersion() {
        return sHumanEffectFusionApi.getVersion();
    }

    public int process(int i_renamed, int[] iArr, int i2, int i3, int i4, boolean z_renamed) {
        return sHumanEffectFusionApi.process(new com.anc.humansdk.fusion.HumanEffectFusionApi.HumanProcessTextureRequest(z_renamed ? com.anc.humansdk.fusion.HumanEffectFusionApi.CameraType.CAMERA_TYPE_FRONT : com.anc.humansdk.fusion.HumanEffectFusionApi.CameraType.CAMERA_TYPE_REAR, new com.anc.humansdk.fusion.HumanEffectFusionApi.HumanVideoTexture(i_renamed, false, i2, i3, i4)), new com.anc.humansdk.fusion.HumanEffectFusionApi.HumanProcessTexureResult(new com.anc.humansdk.fusion.HumanEffectFusionApi.HumanVideoTexture(iArr[0], false, i2, i3, i4)));
    }

    public int setParams(com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanVideoFusionParams humanVideoFusionParams) {
        return sHumanEffectFusionApi.setParams(humanVideoFusionParams.mappingSDKObject());
    }

    public int release() {
        return sHumanEffectFusionApi.release();
    }

    public void preInit() throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.IllegalArgumentException {
        sHumanEffectFusionApi.preInit();
        try {
            java.lang.reflect.Field declaredField = com.anc.humansdk.fusion.HumanEffectFusionApi.class.getDeclaredField("isSoLoaded");
            declaredField.setAccessible(true);
            declaredField.set(com.anc.humansdk.fusion.HumanEffectFusionApi.class, new java.util.concurrent.atomic.AtomicBoolean(true));
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    public enum FeatureType {
        ANC_HUM_FEATURE_NONE(0),
        ANC_HUM_FEATURE_BOKEH(1),
        ANC_HUM_FEATURE_NEON(5);

        private final int value;

        FeatureType(int i_renamed) {
            this.value = i_renamed;
        }

        public int getValue() {
            return this.value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.anc.humansdk.fusion.HumanEffectFusionApi.FeatureType mappingSDKObject() {
            int i_renamed = this.value;
            if (i_renamed == 0) {
                return com.anc.humansdk.fusion.HumanEffectFusionApi.FeatureType.ANC_HUM_FEATURE_NONE;
            }
            if (i_renamed == 1) {
                return com.anc.humansdk.fusion.HumanEffectFusionApi.FeatureType.ANC_HUM_FEATURE_BOKEH;
            }
            if (i_renamed == 5) {
                return com.anc.humansdk.fusion.HumanEffectFusionApi.FeatureType.ANC_HUM_FEATURE_NEON;
            }
            throw new java.lang.RuntimeException("not matching");
        }
    }

    public static class HumanEffectFusionConfig {
        public int log_level = 2;
        public int power_mode = com.anc.humansdk.fusion.SdkPowerMode.ANC_HUM_POWER_DEFAULT.ordinal();
        public byte[] model_data = null;
        public boolean isRealTime = true;
        public java.lang.String cache_path = "";
        public java.lang.String native_lib_path = "";
        public boolean isBackCamera = true;
        public int sdkLoadType = com.anc.humansdk.fusion.HumanEffectFusionApi.SdkLoadType.ANC_LOAD_TYPE_ANDROID_DLOPEN.ordinal();

        /* JADX INFO: Access modifiers changed from: private */
        public com.anc.humansdk.fusion.HumanEffectFusionApi.HumanEffectFusionConfig mappingSDKObject() {
            com.anc.humansdk.fusion.HumanEffectFusionApi.HumanEffectFusionConfig humanEffectFusionConfig = new com.anc.humansdk.fusion.HumanEffectFusionApi.HumanEffectFusionConfig();
            humanEffectFusionConfig.isRealTime = this.isRealTime;
            humanEffectFusionConfig.model_data = this.model_data;
            humanEffectFusionConfig.cache_path = this.cache_path;
            humanEffectFusionConfig.native_lib_path = this.native_lib_path;
            humanEffectFusionConfig.isBackCamera = this.isBackCamera;
            humanEffectFusionConfig.log_level = this.log_level;
            humanEffectFusionConfig.power_mode = this.power_mode;
            humanEffectFusionConfig.sdkLoadType = this.sdkLoadType;
            return humanEffectFusionConfig;
        }
    }

    public enum SdkLoadType {
        ANC_LOAD_TYPE_DLOEPN,
        ANC_LOAD_TYPE_ANDROID_DLOPEN;

        public static com.oplus.ocs.camera.HumanEffectFusionApiHelper.SdkLoadType getObject(int i_renamed) {
            try {
                return values()[i_renamed];
            } catch (java.lang.IndexOutOfBoundsException unused) {
                throw new java.lang.IllegalArgumentException("Invalid sdk load type: " + i_renamed);
            }
        }

        public int getValue() {
            return ordinal();
        }
    }

    public static class HumanVideoFusionParams {
        public float bgLightFactor;
        public float blue;
        public float blurIntensity;
        public float bokeh_max_radius_factor;
        public float facula_density;
        public float green;
        public float light_factor;
        public float max_light_threshold;
        public float min_light_threshold;
        public float red;
        public float saturation;
        public float smooth_amount;
        public float yellow;

        public HumanVideoFusionParams() {
            this.blurIntensity = -1.0f;
            this.saturation = -1.0f;
            this.facula_density = -1.0f;
            this.light_factor = -1.0f;
            this.smooth_amount = -1.0f;
            this.bokeh_max_radius_factor = -1.0f;
            this.red = -1.0f;
            this.green = -1.0f;
            this.blue = -1.0f;
            this.yellow = -1.0f;
            this.bgLightFactor = -1.0f;
            this.max_light_threshold = -1.0f;
            this.min_light_threshold = -1.0f;
        }

        public HumanVideoFusionParams(float f_renamed) {
            this.blurIntensity = -1.0f;
            this.saturation = -1.0f;
            this.facula_density = -1.0f;
            this.light_factor = -1.0f;
            this.smooth_amount = -1.0f;
            this.bokeh_max_radius_factor = -1.0f;
            this.red = -1.0f;
            this.green = -1.0f;
            this.blue = -1.0f;
            this.yellow = -1.0f;
            this.bgLightFactor = -1.0f;
            this.max_light_threshold = -1.0f;
            this.min_light_threshold = -1.0f;
            this.blurIntensity = f_renamed;
        }

        public HumanVideoFusionParams(float f_renamed, float f2) {
            this.blurIntensity = -1.0f;
            this.saturation = -1.0f;
            this.facula_density = -1.0f;
            this.light_factor = -1.0f;
            this.smooth_amount = -1.0f;
            this.bokeh_max_radius_factor = -1.0f;
            this.red = -1.0f;
            this.green = -1.0f;
            this.blue = -1.0f;
            this.yellow = -1.0f;
            this.bgLightFactor = -1.0f;
            this.max_light_threshold = -1.0f;
            this.min_light_threshold = -1.0f;
            this.blurIntensity = f_renamed;
            this.saturation = f2;
        }

        public HumanVideoFusionParams(float f_renamed, float f2, float f3) {
            this.blurIntensity = -1.0f;
            this.saturation = -1.0f;
            this.facula_density = -1.0f;
            this.light_factor = -1.0f;
            this.smooth_amount = -1.0f;
            this.bokeh_max_radius_factor = -1.0f;
            this.red = -1.0f;
            this.green = -1.0f;
            this.blue = -1.0f;
            this.yellow = -1.0f;
            this.bgLightFactor = -1.0f;
            this.max_light_threshold = -1.0f;
            this.min_light_threshold = -1.0f;
            this.blurIntensity = f_renamed;
            this.saturation = f2;
            this.facula_density = f3;
        }

        public HumanVideoFusionParams(float f_renamed, float f2, float f3, float f4) {
            this.blurIntensity = -1.0f;
            this.saturation = -1.0f;
            this.facula_density = -1.0f;
            this.light_factor = -1.0f;
            this.smooth_amount = -1.0f;
            this.bokeh_max_radius_factor = -1.0f;
            this.red = -1.0f;
            this.green = -1.0f;
            this.blue = -1.0f;
            this.yellow = -1.0f;
            this.bgLightFactor = -1.0f;
            this.max_light_threshold = -1.0f;
            this.min_light_threshold = -1.0f;
            this.blurIntensity = f_renamed;
            this.saturation = f2;
            this.facula_density = f3;
            this.light_factor = f4;
        }

        public HumanVideoFusionParams(float f_renamed, float f2, float f3, float f4, float f5) {
            this.blurIntensity = -1.0f;
            this.saturation = -1.0f;
            this.facula_density = -1.0f;
            this.light_factor = -1.0f;
            this.smooth_amount = -1.0f;
            this.bokeh_max_radius_factor = -1.0f;
            this.red = -1.0f;
            this.green = -1.0f;
            this.blue = -1.0f;
            this.yellow = -1.0f;
            this.bgLightFactor = -1.0f;
            this.max_light_threshold = -1.0f;
            this.min_light_threshold = -1.0f;
            this.blurIntensity = f_renamed;
            this.saturation = f2;
            this.facula_density = f3;
            this.light_factor = f4;
            this.smooth_amount = f5;
        }

        public com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanVideoFusionParams UpdateBlurIntensity(float f_renamed) {
            this.blurIntensity = f_renamed;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanVideoFusionParams UpdateSaturation(float f_renamed) {
            this.saturation = f_renamed;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanVideoFusionParams UpdateFaculaDensity(float f_renamed) {
            this.facula_density = f_renamed;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanVideoFusionParams UpdateLightFactor(float f_renamed) {
            this.light_factor = f_renamed;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanVideoFusionParams UpdateSmoothAmount(float f_renamed) {
            this.smooth_amount = f_renamed;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanVideoFusionParams UpdateBokehMaxRadiusFactor(float f_renamed) {
            this.bokeh_max_radius_factor = f_renamed;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanVideoFusionParams UpdateColorValue(float f_renamed, float f2, float f3, float f4) {
            this.red = f_renamed;
            this.green = f2;
            this.blue = f3;
            this.yellow = f4;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanVideoFusionParams UpdateBgLightFactor(float f_renamed) {
            this.bgLightFactor = f_renamed;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanVideoFusionParams UpdateMaxLightThreshold(float f_renamed) {
            this.max_light_threshold = f_renamed;
            return this;
        }

        public com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanVideoFusionParams UpdateMinLightThreshold(float f_renamed) {
            this.min_light_threshold = f_renamed;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.anc.humansdk.fusion.HumanEffectFusionApi.HumanVideoFusionParams mappingSDKObject() {
            com.anc.humansdk.fusion.HumanEffectFusionApi.HumanVideoFusionParams humanVideoFusionParams = new com.anc.humansdk.fusion.HumanEffectFusionApi.HumanVideoFusionParams();
            humanVideoFusionParams.blurIntensity = this.blurIntensity;
            humanVideoFusionParams.saturation = this.saturation;
            humanVideoFusionParams.facula_density = this.facula_density;
            humanVideoFusionParams.light_factor = this.light_factor;
            humanVideoFusionParams.smooth_amount = this.smooth_amount;
            humanVideoFusionParams.bokeh_max_radius_factor = -1.0f;
            humanVideoFusionParams.red = this.red;
            humanVideoFusionParams.green = this.green;
            humanVideoFusionParams.blue = this.blue;
            humanVideoFusionParams.yellow = this.yellow;
            humanVideoFusionParams.bg_light_factor = this.bgLightFactor;
            return humanVideoFusionParams;
        }
    }
}
