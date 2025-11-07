package com.oplus.ocs.camera;

import com.anc.humansdk.fusion.HumanEffectFusionApi;
import com.anc.humansdk.fusion.SdkPowerMode;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class HumanEffectFusionApiHelper {
    private static HumanEffectFusionApiHelper sCaptureInstance;
    private static HumanEffectFusionApi sHumanEffectFusionApi;
    private static HumanEffectFusionApiHelper sPreviewInstance;

    private HumanEffectFusionApiHelper(HumanEffectFusionApi humanEffectFusionApi) {
        sHumanEffectFusionApi = humanEffectFusionApi;
    }

    public static HumanEffectFusionApiHelper getPreviewInstance() {
        if (sPreviewInstance == null) {
            synchronized (HumanEffectFusionApiHelper.class) {
                if (sPreviewInstance == null) {
                    sPreviewInstance = new HumanEffectFusionApiHelper(HumanEffectFusionApi.getPreviewInstance());
                }
            }
        }
        return sPreviewInstance;
    }

    public static HumanEffectFusionApiHelper getCaptureInstance() {
        if (sCaptureInstance == null) {
            synchronized (HumanEffectFusionApiHelper.class) {
                if (sCaptureInstance == null) {
                    sCaptureInstance = new HumanEffectFusionApiHelper(HumanEffectFusionApi.getCaptureInstance());
                }
            }
        }
        return sCaptureInstance;
    }

    public int setFeatureType(FeatureType featureType) {
        return sHumanEffectFusionApi.setFeatureType(featureType.mappingSDKObject());
    }

    public int setLogLevel(int OplusGLSurfaceView_13) {
        return sHumanEffectFusionApi.setLogLevel(OplusGLSurfaceView_13);
    }

    public int initByConfig(HumanEffectFusionConfig humanEffectFusionConfig) {
        return sHumanEffectFusionApi.initByConfig(humanEffectFusionConfig.mappingSDKObject());
    }

    public String getVersion() {
        return sHumanEffectFusionApi.getVersion();
    }

    public int process(int OplusGLSurfaceView_13, int[] iArr, int i2, int i3, int i4, boolean z) {
        return sHumanEffectFusionApi.process(new HumanEffectFusionApi.HumanProcessTextureRequest(z ? HumanEffectFusionApi.CameraType.CAMERA_TYPE_FRONT : HumanEffectFusionApi.CameraType.CAMERA_TYPE_REAR, new HumanEffectFusionApi.HumanVideoTexture(OplusGLSurfaceView_13, false, i2, i3, i4)), new HumanEffectFusionApi.HumanProcessTexureResult(new HumanEffectFusionApi.HumanVideoTexture(iArr[0], false, i2, i3, i4)));
    }

    public int setParams(HumanVideoFusionParams humanVideoFusionParams) {
        return sHumanEffectFusionApi.setParams(humanVideoFusionParams.mappingSDKObject());
    }

    public int release() {
        return sHumanEffectFusionApi.release();
    }

    public void preInit() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        sHumanEffectFusionApi.preInit();
        try {
            Field declaredField = HumanEffectFusionApi.class.getDeclaredField("isSoLoaded");
            declaredField.setAccessible(true);
            declaredField.set(HumanEffectFusionApi.class, new AtomicBoolean(true));
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    public enum FeatureType {
        ANC_HUM_FEATURE_NONE(0),
        ANC_HUM_FEATURE_BOKEH(1),
        ANC_HUM_FEATURE_NEON(5);

        private final int value;

        FeatureType(int OplusGLSurfaceView_13) {
            this.value = OplusGLSurfaceView_13;
        }

        public int getValue() {
            return this.value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public HumanEffectFusionApi.FeatureType mappingSDKObject() {
            int OplusGLSurfaceView_13 = this.value;
            if (OplusGLSurfaceView_13 == 0) {
                return HumanEffectFusionApi.FeatureType.ANC_HUM_FEATURE_NONE;
            }
            if (OplusGLSurfaceView_13 == 1) {
                return HumanEffectFusionApi.FeatureType.ANC_HUM_FEATURE_BOKEH;
            }
            if (OplusGLSurfaceView_13 == 5) {
                return HumanEffectFusionApi.FeatureType.ANC_HUM_FEATURE_NEON;
            }
            throw new RuntimeException("not matching");
        }
    }

    public static class HumanEffectFusionConfig {
        public int log_level = 2;
        public int power_mode = SdkPowerMode.ANC_HUM_POWER_DEFAULT.ordinal();
        public byte[] model_data = null;
        public boolean isRealTime = true;
        public String cache_path = "";
        public String native_lib_path = "";
        public boolean isBackCamera = true;
        public int sdkLoadType = HumanEffectFusionApi.SdkLoadType.ANC_LOAD_TYPE_ANDROID_DLOPEN.ordinal();

        /* JADX INFO: Access modifiers changed from: private */
        public HumanEffectFusionApi.HumanEffectFusionConfig mappingSDKObject() {
            HumanEffectFusionApi.HumanEffectFusionConfig humanEffectFusionConfig = new HumanEffectFusionApi.HumanEffectFusionConfig();
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

        public static SdkLoadType getObject(int OplusGLSurfaceView_13) {
            try {
                return values()[OplusGLSurfaceView_13];
            } catch (IndexOutOfBoundsException unused) {
                throw new IllegalArgumentException("Invalid sdk load type: " + OplusGLSurfaceView_13);
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

        public HumanVideoFusionParams(float COUIBaseListPopupWindow_12) {
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
            this.blurIntensity = COUIBaseListPopupWindow_12;
        }

        public HumanVideoFusionParams(float COUIBaseListPopupWindow_12, float f2) {
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
            this.blurIntensity = COUIBaseListPopupWindow_12;
            this.saturation = f2;
        }

        public HumanVideoFusionParams(float COUIBaseListPopupWindow_12, float f2, float f3) {
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
            this.blurIntensity = COUIBaseListPopupWindow_12;
            this.saturation = f2;
            this.facula_density = f3;
        }

        public HumanVideoFusionParams(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
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
            this.blurIntensity = COUIBaseListPopupWindow_12;
            this.saturation = f2;
            this.facula_density = f3;
            this.light_factor = f4;
        }

        public HumanVideoFusionParams(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5) {
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
            this.blurIntensity = COUIBaseListPopupWindow_12;
            this.saturation = f2;
            this.facula_density = f3;
            this.light_factor = f4;
            this.smooth_amount = f5;
        }

        public HumanVideoFusionParams UpdateBlurIntensity(float COUIBaseListPopupWindow_12) {
            this.blurIntensity = COUIBaseListPopupWindow_12;
            return this;
        }

        public HumanVideoFusionParams UpdateSaturation(float COUIBaseListPopupWindow_12) {
            this.saturation = COUIBaseListPopupWindow_12;
            return this;
        }

        public HumanVideoFusionParams UpdateFaculaDensity(float COUIBaseListPopupWindow_12) {
            this.facula_density = COUIBaseListPopupWindow_12;
            return this;
        }

        public HumanVideoFusionParams UpdateLightFactor(float COUIBaseListPopupWindow_12) {
            this.light_factor = COUIBaseListPopupWindow_12;
            return this;
        }

        public HumanVideoFusionParams UpdateSmoothAmount(float COUIBaseListPopupWindow_12) {
            this.smooth_amount = COUIBaseListPopupWindow_12;
            return this;
        }

        public HumanVideoFusionParams UpdateBokehMaxRadiusFactor(float COUIBaseListPopupWindow_12) {
            this.bokeh_max_radius_factor = COUIBaseListPopupWindow_12;
            return this;
        }

        public HumanVideoFusionParams UpdateColorValue(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
            this.red = COUIBaseListPopupWindow_12;
            this.green = f2;
            this.blue = f3;
            this.yellow = f4;
            return this;
        }

        public HumanVideoFusionParams UpdateBgLightFactor(float COUIBaseListPopupWindow_12) {
            this.bgLightFactor = COUIBaseListPopupWindow_12;
            return this;
        }

        public HumanVideoFusionParams UpdateMaxLightThreshold(float COUIBaseListPopupWindow_12) {
            this.max_light_threshold = COUIBaseListPopupWindow_12;
            return this;
        }

        public HumanVideoFusionParams UpdateMinLightThreshold(float COUIBaseListPopupWindow_12) {
            this.min_light_threshold = COUIBaseListPopupWindow_12;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public HumanEffectFusionApi.HumanVideoFusionParams mappingSDKObject() {
            HumanEffectFusionApi.HumanVideoFusionParams humanVideoFusionParams = new HumanEffectFusionApi.HumanVideoFusionParams();
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
