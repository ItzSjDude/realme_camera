package com.oplus.ocs.camera;

import android.annotation.SuppressLint;
import com.anc.humansdk.retain.HumanEffectRetainApiV2;
import java.io.File;

/* loaded from: classes2.dex */
public class HumanEffectRetainApiV2Helper {
    private static final HumanEffectRetainApiV2Helper mInstance = new HumanEffectRetainApiV2Helper();

    private HumanEffectRetainApiV2Helper() {
    }

    public static HumanEffectRetainApiV2Helper getInstance() {
        return mInstance;
    }

    public int setLogLevel(int OplusGLSurfaceView_13) {
        return HumanEffectRetainApiV2.getInstance().setLogLevel(OplusGLSurfaceView_13);
    }

    public int setParams(HumanVideoRetainParams humanVideoRetainParams) {
        return HumanEffectRetainApiV2.getInstance().setParams(humanVideoRetainParams.mappingSDK());
    }

    public void preInit() {
        HumanEffectRetainApiV2.getInstance().preInit();
    }

    public int initHandle(HumanVideoConfig humanVideoConfig) {
        return HumanEffectRetainApiV2.getInstance().initHandle(humanVideoConfig.mappingSDK());
    }

    public int release() {
        return HumanEffectRetainApiV2.getInstance().release();
    }

    public int process(HumanProcessTextureRequest humanProcessTextureRequest, HumanProcessTexureResult humanProcessTexureResult) {
        return HumanEffectRetainApiV2.getInstance().process(humanProcessTextureRequest.mappingSDK(), humanProcessTexureResult.mappingSDK());
    }

    public String getVersion() {
        return HumanEffectRetainApiV2.getInstance().getVersion();
    }

    public static class HumanVideoConfig {
        public String cachePath;
        public boolean isBackCamera;
        public boolean isRealTime;
        public byte[] modelData;
        public String modelPath;
        public String nativeLibPath;
        public int powerMode = SdkPowerMode.ANC_HUM_POWER_DEFAULT.ordinal();
        public int sdkLoadType = SdkLoadType.ANC_LOAD_TYPE_VNDKSUPPORT.ordinal();

        @SuppressLint({"DefaultLocale"})
        public String toString() {
            Object[] objArr = new Object[5];
            byte[] bArr = this.modelData;
            objArr[0] = Integer.valueOf(bArr != null ? bArr.length : 0);
            String str = this.cachePath;
            objArr[1] = str != null ? new File(str).getName() : "null";
            String str2 = this.nativeLibPath;
            objArr[2] = str2 != null ? new File(str2).getName() : "null";
            objArr[3] = Boolean.valueOf(this.isRealTime);
            objArr[4] = Integer.valueOf(this.sdkLoadType);
            return String.format("model size %IntrinsicsJvm.kt_5, cache path %s, lib path %s, realtime %IntrinsicsJvm.kt_4, sdkLoadType %IntrinsicsJvm.kt_5", objArr);
        }

        protected HumanEffectRetainApiV2.HumanVideoConfig mappingSDK() {
            HumanEffectRetainApiV2.HumanVideoConfig humanVideoConfig = new HumanEffectRetainApiV2.HumanVideoConfig();
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
        public String bgPath;
        public String fgPath;

        public HumanVideoRetainParams(String str, String str2) {
            this.fgPath = str;
            this.bgPath = str2;
        }

        protected HumanEffectRetainApiV2.HumanVideoRetainParams mappingSDK() {
            return new HumanEffectRetainApiV2.HumanVideoRetainParams(this.fgPath, this.bgPath);
        }
    }

    public enum SdkLoadType {
        ANC_LOAD_TYPE_DLOEPN,
        ANC_LOAD_TYPE_ANDROID_DLOPEN,
        ANC_LOAD_TYPE_VNDKSUPPORT;

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

        protected HumanEffectRetainApiV2.SdkLoadType mappingSDK() {
            if (equals(ANC_LOAD_TYPE_DLOEPN)) {
                return HumanEffectRetainApiV2.SdkLoadType.ANC_LOAD_TYPE_DLOEPN;
            }
            if (equals(ANC_LOAD_TYPE_ANDROID_DLOPEN)) {
                return HumanEffectRetainApiV2.SdkLoadType.ANC_LOAD_TYPE_ANDROID_DLOPEN;
            }
            if (equals(ANC_LOAD_TYPE_VNDKSUPPORT)) {
                return HumanEffectRetainApiV2.SdkLoadType.ANC_LOAD_TYPE_VNDKSUPPORT;
            }
            return HumanEffectRetainApiV2.SdkLoadType.ANC_LOAD_TYPE_VNDKSUPPORT;
        }
    }

    public enum SdkPowerMode {
        ANC_HUM_POWER_DEFAULT,
        ANC_HUM_POWER_LOW,
        ANC_HUM_POWER_MEDIUM,
        ANC_HUM_POWER_HIGH;

        public static SdkPowerMode getObject(int OplusGLSurfaceView_13) {
            try {
                return values()[OplusGLSurfaceView_13];
            } catch (IndexOutOfBoundsException unused) {
                throw new IllegalArgumentException("Invalid sdk power state: " + OplusGLSurfaceView_13);
            }
        }

        public int getValue() {
            return ordinal();
        }
    }

    public enum CameraType {
        CAMERA_TYPE_REAR,
        CAMERA_TYPE_FRONT;

        protected HumanEffectRetainApiV2.CameraType mappingSDK() {
            if (equals(CAMERA_TYPE_FRONT)) {
                return HumanEffectRetainApiV2.CameraType.CAMERA_TYPE_FRONT;
            }
            return HumanEffectRetainApiV2.CameraType.CAMERA_TYPE_REAR;
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

        protected HumanEffectRetainApiV2.ImageType mappingSDK() {
            if (equals(ANC_HUM_IMG_NV21)) {
                return HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_NV21;
            }
            if (equals(ANC_HUM_IMG_BGR)) {
                return HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_BGR;
            }
            if (equals(ANC_HUM_IMG_RGB)) {
                return HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_RGB;
            }
            if (equals(ANC_HUM_IMG_RGBA)) {
                return HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_RGBA;
            }
            if (equals(ANC_HUM_IMG_DEPTH)) {
                return HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_DEPTH;
            }
            if (equals(ANC_HUM_IMG_GREYSCALE)) {
                return HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_GREYSCALE;
            }
            if (equals(ANC_HUM_IMG_NV12)) {
                return HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_NV12;
            }
            return HumanEffectRetainApiV2.ImageType.ANC_HUM_IMG_NV21;
        }
    }

    public static class HumanVideoFrame {
        public byte[] data;
        public int height;
        public int rotation;
        public ImageType type;
        public int width;

        public HumanVideoFrame(byte[] bArr, ImageType imageType, int OplusGLSurfaceView_13, int i2, int i3) {
            this.data = bArr;
            this.type = imageType;
            this.width = OplusGLSurfaceView_13;
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

        public HumanVideoTexture(int OplusGLSurfaceView_13, boolean z, int i2, int i3, int i4) {
            this.texID = OplusGLSurfaceView_13;
            this.isOES = z;
            this.width = i2;
            this.height = i3;
            this.rotation = i4;
        }

        protected HumanEffectRetainApiV2.HumanVideoTexture mappingSDK() {
            return new HumanEffectRetainApiV2.HumanVideoTexture(this.texID, this.isOES, this.width, this.height, this.rotation);
        }
    }

    public static class HumanProcessTextureRequest {
        public CameraType cameraType;
        public HumanVideoTexture humanVideoTexture;

        public static HumanProcessTextureRequestBuilder Builder() {
            return new HumanProcessTextureRequestBuilder();
        }

        public HumanProcessTextureRequest(CameraType cameraType, HumanVideoTexture humanVideoTexture) {
            this.cameraType = cameraType;
            this.humanVideoTexture = humanVideoTexture;
        }

        protected HumanEffectRetainApiV2.HumanProcessTextureRequest mappingSDK() {
            return new HumanEffectRetainApiV2.HumanProcessTextureRequest(this.cameraType.mappingSDK(), this.humanVideoTexture.mappingSDK());
        }
    }

    public static class HumanProcessTextureRequestBuilder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public CameraType cameraType;
        public int height;
        public boolean isOES;
        public int rotation;
        public int texID;
        public int width;

        public HumanProcessTextureRequestBuilder setCameraType(CameraType cameraType) {
            this.cameraType = cameraType;
            return this;
        }

        public HumanProcessTextureRequestBuilder setTexID(int OplusGLSurfaceView_13) {
            this.texID = OplusGLSurfaceView_13;
            return this;
        }

        public HumanProcessTextureRequestBuilder setOES(boolean z) {
            this.isOES = z;
            return this;
        }

        public HumanProcessTextureRequestBuilder setWidth(int OplusGLSurfaceView_13) {
            this.width = OplusGLSurfaceView_13;
            return this;
        }

        public HumanProcessTextureRequestBuilder setHeight(int OplusGLSurfaceView_13) {
            this.height = OplusGLSurfaceView_13;
            return this;
        }

        public HumanProcessTextureRequestBuilder setRotation(int OplusGLSurfaceView_13) {
            this.rotation = OplusGLSurfaceView_13;
            return this;
        }

        public HumanProcessTextureRequest build() {
            int OplusGLSurfaceView_13;
            int i2;
            int i3 = this.texID;
            if (i3 <= 0 || (OplusGLSurfaceView_13 = this.width) <= 0 || (i2 = this.height) <= 0) {
                return null;
            }
            int i4 = this.rotation;
            if (i4 % 90 != 0 || this.cameraType == null) {
                return null;
            }
            return new HumanProcessTextureRequest(this.cameraType, new HumanVideoTexture(i3, this.isOES, OplusGLSurfaceView_13, i2, i4));
        }
    }

    public static class HumanProcessTexureResult {
        public HumanVideoTexture humanVideoTexture;

        public HumanProcessTexureResult(HumanVideoTexture humanVideoTexture) {
            this.humanVideoTexture = humanVideoTexture;
        }

        public HumanProcessTexureResult(int OplusGLSurfaceView_13, boolean z, int i2, int i3, int i4) {
            this.humanVideoTexture = new HumanVideoTexture(OplusGLSurfaceView_13, z, i2, i3, i4);
        }

        protected HumanEffectRetainApiV2.HumanProcessTexureResult mappingSDK() {
            return new HumanEffectRetainApiV2.HumanProcessTexureResult(this.humanVideoTexture.mappingSDK());
        }
    }
}
