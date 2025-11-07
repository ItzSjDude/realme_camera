package com.oplus.ocs.camera;

import android.annotation.SuppressLint;
import android.util.Log;
import com.anc.humanvideo.HumanVideoApi;
import java.io.File;

/* loaded from: classes2.dex */
public class HumanVideoApiHelper {
    private static final String TAG = "HumanVideoApiHelper";
    private static HumanVideoApiHelper mInstance = new HumanVideoApiHelper();

    public static class HumanFrame {
        public byte[] data;
        public int height;
        public int rotation;
        public ImageType type;
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

    public static HumanVideoApiHelper getInstance() {
        return mInstance;
    }

    public int release() {
        return HumanVideoApi.getInstance().release();
    }

    public int setLogLevel(int OplusGLSurfaceView_13) {
        return HumanVideoApi.getInstance().setLogLevel(OplusGLSurfaceView_13);
    }

    public int process(HumanProcessRequest humanProcessRequest, HumanProcessResult humanProcessResult) {
        return HumanVideoApi.getInstance().process(humanProcessRequest.mappingSDKObject(), humanProcessResult.mappingSDKObject());
    }

    public int initHandle(HumanVideoConfig humanVideoConfig) {
        return HumanVideoApi.getInstance().initHandle(humanVideoConfig.mappingSDKObject());
    }

    public int enableRuntimeFeature(FeatureType featureType, boolean z) {
        return HumanVideoApi.getInstance().enableRuntimeFeature(featureType.getSDKFeatureType(), z);
    }

    public int setParams(HumanVideoParams humanVideoParams) {
        return HumanVideoApi.getInstance().setParams(humanVideoParams.mappingSDK());
    }

    public void preInit() {
        HumanVideoApi.getInstance().preInit();
    }

    public static class HumanProcessFrameResult extends HumanProcessResult {
        public HumanFrame humanFrame = new HumanFrame();

        @Override // com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessResult
        HumanVideoApi.HumanProcessResult mappingSDKObject() {
            HumanVideoApi.HumanProcessFrameResult humanProcessFrameResult = new HumanVideoApi.HumanProcessFrameResult();
            humanProcessFrameResult.humanFrame.type = this.humanFrame.type.mappingSDKObject();
            humanProcessFrameResult.humanFrame.rotation = this.humanFrame.rotation;
            humanProcessFrameResult.humanFrame.width = this.humanFrame.width;
            humanProcessFrameResult.humanFrame.height = this.humanFrame.height;
            humanProcessFrameResult.humanFrame.data = this.humanFrame.data;
            return humanProcessFrameResult;
        }
    }

    public static class HumanProcessTexureResult extends HumanProcessResult {
        public HumanTexture humanTexture = new HumanTexture();

        @Override // com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessResult
        HumanVideoApi.HumanProcessResult mappingSDKObject() {
            HumanVideoApi.HumanProcessTexureResult humanProcessTexureResult = new HumanVideoApi.HumanProcessTexureResult();
            humanProcessTexureResult.humanTexture.rotation = this.humanTexture.rotation;
            humanProcessTexureResult.humanTexture.texID = this.humanTexture.texID;
            humanProcessTexureResult.humanTexture.isOES = this.humanTexture.isOES;
            humanProcessTexureResult.humanTexture.width = this.humanTexture.width;
            humanProcessTexureResult.humanTexture.height = this.humanTexture.height;
            return humanProcessTexureResult;
        }
    }

    public static class HumanProcessResult {
        HumanVideoApi.HumanProcessResult mappingSDKObject() {
            return new HumanVideoApi.HumanProcessResult();
        }
    }

    public static class HumanVideoRetainParams extends HumanVideoParams {
        public String bgPath;
        public String fgPath;

        @Override // com.oplus.ocs.camera.HumanVideoApiHelper.HumanVideoParams
        public HumanVideoApi.HumanVideoParams mappingSDK() {
            HumanVideoApi.HumanVideoRetainParams humanVideoRetainParams = new HumanVideoApi.HumanVideoRetainParams();
            humanVideoRetainParams.fgPath = this.fgPath;
            humanVideoRetainParams.bgPath = this.bgPath;
            return humanVideoRetainParams;
        }
    }

    public static class HumanVideoBokehParams extends HumanVideoParams {
        public float blurIntensity;

        @Override // com.oplus.ocs.camera.HumanVideoApiHelper.HumanVideoParams
        public HumanVideoApi.HumanVideoParams mappingSDK() {
            HumanVideoApi.HumanVideoBokehParams humanVideoBokehParams = new HumanVideoApi.HumanVideoBokehParams();
            humanVideoBokehParams.blurIntensity = this.blurIntensity;
            return humanVideoBokehParams;
        }
    }

    public static class HumanVideoParams {
        public HumanVideoApi.HumanVideoParams mappingSDK() {
            return new HumanVideoApi.HumanVideoParams();
        }
    }

    public static class HumanProcessFrameRequest extends HumanProcessRequest {
        public HumanFrame humanFrame = new HumanFrame();

        @Override // com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessRequest
        public HumanVideoApi.HumanProcessRequest mappingSDKObject() {
            HumanVideoApi.HumanProcessFrameRequest humanProcessFrameRequest = new HumanVideoApi.HumanProcessFrameRequest();
            if (this.cameraType != null) {
                humanProcessFrameRequest.cameraType = this.cameraType.mappingSDKObject();
            } else {
                Log.w(HumanVideoApiHelper.TAG, "mappingSDKObject, has not set cameraType");
            }
            humanProcessFrameRequest.humanFrame.data = this.humanFrame.data;
            humanProcessFrameRequest.humanFrame.height = this.humanFrame.height;
            humanProcessFrameRequest.humanFrame.width = this.humanFrame.width;
            humanProcessFrameRequest.humanFrame.rotation = this.humanFrame.rotation;
            humanProcessFrameRequest.humanFrame.type = this.humanFrame.type.mappingSDKObject();
            return humanProcessFrameRequest;
        }
    }

    public static class HumanProcessTextureRequest extends HumanProcessRequest {
        public HumanTexture humanTexture = new HumanTexture();

        @Override // com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessRequest
        public HumanVideoApi.HumanProcessRequest mappingSDKObject() {
            HumanVideoApi.HumanProcessTextureRequest humanProcessTextureRequest = new HumanVideoApi.HumanProcessTextureRequest();
            if (this.cameraType != null) {
                humanProcessTextureRequest.cameraType = this.cameraType.mappingSDKObject();
            } else {
                Log.w(HumanVideoApiHelper.TAG, "mappingSDKObject, has not set cameraType");
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
        public CameraType cameraType;

        public HumanVideoApi.HumanProcessRequest mappingSDKObject() {
            HumanVideoApi.HumanProcessRequest humanProcessRequest = new HumanVideoApi.HumanProcessRequest();
            humanProcessRequest.cameraType = this.cameraType.mappingSDKObject();
            return humanProcessRequest;
        }
    }

    public enum CameraType {
        MODE_REAR_CAMERA,
        MODE_FRONT_CAMERA;

        HumanVideoApi.CameraType mappingSDKObject() {
            if (equals(MODE_FRONT_CAMERA)) {
                return HumanVideoApi.CameraType.MODE_FRONT_CAMERA;
            }
            return HumanVideoApi.CameraType.MODE_REAR_CAMERA;
        }
    }

    public static class HumanVideoConfig {
        public String cachePath;
        public boolean isRealTime;
        public byte[] modelData;
        public String modelPath;
        public String nativeLibPath;
        public int sdkCapability;

        @SuppressLint({"DefaultLocale"})
        public String toString() {
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(this.sdkCapability);
            byte[] bArr = this.modelData;
            objArr[1] = Integer.valueOf(bArr != null ? bArr.length : 0);
            String str = this.cachePath;
            objArr[2] = str != null ? new File(str).getName() : "null";
            String str2 = this.nativeLibPath;
            objArr[3] = str2 != null ? new File(str2).getName() : "null";
            objArr[4] = Boolean.valueOf(this.isRealTime);
            return String.format("sdkCapability %IntrinsicsJvm.kt_5, model size %IntrinsicsJvm.kt_5, cache path %s, lib path %s, realtime %IntrinsicsJvm.kt_4", objArr);
        }

        HumanVideoApi.HumanVideoConfig mappingSDKObject() {
            HumanVideoApi.HumanVideoConfig humanVideoConfig = new HumanVideoApi.HumanVideoConfig();
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

        FeatureType(int OplusGLSurfaceView_13) {
            this.value = OplusGLSurfaceView_13;
        }

        public int getValue() {
            return this.value;
        }

        HumanVideoApi.FeatureType getSDKFeatureType() {
            int OplusGLSurfaceView_13 = this.value;
            if (OplusGLSurfaceView_13 == 1) {
                return HumanVideoApi.FeatureType.ANCHUM_FEATURE_BOKEH;
            }
            if (OplusGLSurfaceView_13 == 2) {
                return HumanVideoApi.FeatureType.ANCHUM_FEATURE_RETAIN;
            }
            if (OplusGLSurfaceView_13 != 3) {
                return HumanVideoApi.FeatureType.ANCHUM_FEATURE_NONE;
            }
            return HumanVideoApi.FeatureType.ANCHUM_FEATURE_SEGMENT;
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

        HumanVideoApi.ImageType mappingSDKObject() {
            switch (this) {
                case ANC_HUM_IMG_BGR:
                    return HumanVideoApi.ImageType.ANC_HUM_IMG_BGR;
                case ANC_HUM_IMG_NV21:
                    return HumanVideoApi.ImageType.ANC_HUM_IMG_NV21;
                case ANC_HUM_IMG_RGB:
                    return HumanVideoApi.ImageType.ANC_HUM_IMG_RGB;
                case ANC_HUM_IMG_RGBA:
                    return HumanVideoApi.ImageType.ANC_HUM_IMG_RGBA;
                case ANC_HUM_IMG_DEPTH:
                    return HumanVideoApi.ImageType.ANC_HUM_IMG_DEPTH;
                case ANC_HUM_IMG_GREYSCALE:
                    return HumanVideoApi.ImageType.ANC_HUM_IMG_GREYSCALE;
                case ANC_HUM_IMG_NV12:
                    return HumanVideoApi.ImageType.ANC_HUM_IMG_NV12;
                default:
                    throw new RuntimeException(" not match");
            }
        }
    }
}
