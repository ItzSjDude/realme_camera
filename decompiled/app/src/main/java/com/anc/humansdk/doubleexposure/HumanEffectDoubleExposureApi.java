package com.anc.humansdk.doubleexposure;

/* loaded from: classes.dex */
public class HumanEffectDoubleExposureApi {
    static final java.lang.String TAG = "HumanEffectDoubleExposureApi";
    static final boolean DEBUG = android.util.Log.isLoggable(TAG, 3);
    private static com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi sInstance = new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi();
    private static java.util.concurrent.atomic.AtomicBoolean isSoLoaded = new java.util.concurrent.atomic.AtomicBoolean(false);
    private java.util.concurrent.atomic.AtomicInteger mPendingLogLevel = new java.util.concurrent.atomic.AtomicInteger(-1);
    protected java.util.concurrent.atomic.AtomicLong handle = new java.util.concurrent.atomic.AtomicLong(0);

    public enum CameraType {
        CAMERA_TYPE_REAR,
        CAMERA_TYPE_FRONT
    }

    public enum ImageType {
        ANC_HUM_IMG_NV21,
        ANC_HUM_IMG_BGR,
        ANC_HUM_IMG_RGB,
        ANC_HUM_IMG_RGBA,
        ANC_HUM_IMG_DEPTH,
        ANC_HUM_IMG_GREYSCALE,
        ANC_HUM_IMG_NV12
    }

    private native int nativeAttachGl(long j_renamed);

    private native long nativeInitHandle(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig humanEffectDoubleExposureConfig);

    private native int nativeProcessFrame(long j_renamed, byte[] bArr, byte[] bArr2, int i_renamed, int i2, int i3, int i4, int i5, int i6);

    private native int nativeProcessFrameInTextureOut(long j_renamed, byte[] bArr, int i_renamed, int i2, boolean z_renamed, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2, int i9, int i10);

    private native int nativeProcessHardwareBufferInTextureOut(long j_renamed, android.hardware.HardwareBuffer hardwareBuffer, int i_renamed, int i2, boolean z_renamed, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z2);

    private native int nativeProcessTexture(long j_renamed, int i_renamed, int i2, int i3, int i4, int i5, boolean z_renamed);

    private native int nativeProcessTextureAndHardwareBufferInTextureOut(long j_renamed, int i_renamed, boolean z_renamed, android.hardware.HardwareBuffer hardwareBuffer, int i2, int i3, boolean z2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z3);

    private native int nativeProcessTextures(long j_renamed, int i_renamed, boolean z_renamed, int i2, boolean z2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    private native int nativeRelease(long j_renamed);

    private native java.lang.String nativeSdkVersion();

    private native int nativeSetLogLevel(int i_renamed);

    private native int nativeSetParams(long j_renamed, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoDoubleExposureParams humanVideoDoubleExposureParams);

    public static class HumanVideoDoubleExposureParams {
        public float bgAlpha;
        public float bgBrightness;
        public float bgSaturation;
        public float blurIntensity;
        public float blurKernelSize;
        public float groundGlassColor;
        public boolean isAdjustParamsMode = false;
        public float portraitAlpha;
        public float portraitBrightness;
        public float portraitSaturation;

        public HumanVideoDoubleExposureParams(float f_renamed) {
            this.blurIntensity = f_renamed;
        }

        public HumanVideoDoubleExposureParams(float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
            this.blurIntensity = f_renamed;
            this.portraitSaturation = f2;
            this.portraitBrightness = f3;
            this.bgSaturation = f4;
            this.bgBrightness = f5;
            this.bgAlpha = f6;
            this.groundGlassColor = f7;
            this.portraitAlpha = f8;
            this.blurKernelSize = f9;
        }
    }

    public static class HumanVideoTexture {
        public int height;
        public boolean isBgFromAlbum;
        public boolean isOES;
        public int rotation;
        public int texID;
        public int width;

        public HumanVideoTexture(int i_renamed, boolean z_renamed, int i2, int i3, int i4, boolean z2) {
            this.texID = i_renamed;
            this.isOES = z_renamed;
            this.width = i2;
            this.height = i3;
            this.rotation = i4;
            this.isBgFromAlbum = z2;
        }

        public boolean IsValid() {
            return this.texID > 0 && this.width != 0 && this.height != 0 && this.rotation % 90 == 0;
        }
    }

    public static class HumanVideoFrame {
        public byte[] data;
        public int height;
        public int rotation;
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType type;
        public int width;

        public HumanVideoFrame(byte[] bArr, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType imageType, int i_renamed, int i2, int i3) {
            this.data = bArr;
            this.type = imageType;
            this.width = i_renamed;
            this.height = i2;
            this.rotation = i3;
        }

        public boolean IsValid() {
            return this.data != null && this.width > 0 && this.height > 0 && this.rotation % 90 == 0 && this.type != null;
        }
    }

    public static class HumanProcessTextureRequestBuilder {
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType cameraType;
        public int height;
        public boolean isBgFromAlbum;
        public boolean isOES;
        public int rotation;
        public int texID;
        public int width;

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequestBuilder setCameraType(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType cameraType) {
            this.cameraType = cameraType;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequestBuilder setTexID(int i_renamed) {
            this.texID = i_renamed;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequestBuilder setOES(boolean z_renamed) {
            this.isOES = z_renamed;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequestBuilder setWidth(int i_renamed) {
            this.width = i_renamed;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequestBuilder setHeight(int i_renamed) {
            this.height = i_renamed;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequestBuilder setRotation(int i_renamed) {
            this.rotation = i_renamed;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequestBuilder setBgFromAlbum(boolean z_renamed) {
            this.isBgFromAlbum = z_renamed;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequest build() {
            int i_renamed;
            int i2;
            int i3 = this.texID;
            if (i3 > 0 && (i_renamed = this.width) > 0 && (i2 = this.height) > 0) {
                int i4 = this.rotation;
                if (i4 % 90 == 0 && this.cameraType != null) {
                    return new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequest(this.cameraType, new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoTexture(i3, this.isOES, i_renamed, i2, i4, this.isBgFromAlbum));
                }
            }
            android.util.Log.e_renamed(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.TAG, "invalid HumanProcessTextureRequest, texID=" + this.texID + ", width=" + this.width + ",height=" + this.height + ",rotation=" + this.rotation + ", cameraType=" + this.cameraType);
            return null;
        }
    }

    public static class HumanProcessTextureRequest {
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType cameraType;
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoTexture humanVideoTexture;

        public static com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequestBuilder Builder() {
            return new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequestBuilder();
        }

        public HumanProcessTextureRequest(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType cameraType, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoTexture humanVideoTexture) {
            this.cameraType = cameraType;
            this.humanVideoTexture = humanVideoTexture;
        }

        public boolean IsValid() {
            com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoTexture humanVideoTexture = this.humanVideoTexture;
            return humanVideoTexture != null && humanVideoTexture.IsValid();
        }
    }

    public static class HumanProcessFrameRequestBuilder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType cameraType;
        public byte[] data;
        public int height;
        public int rotation;
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType type;
        public int width;

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameRequestBuilder setCameraType(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType cameraType) {
            this.cameraType = cameraType;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameRequestBuilder setData(byte[] bArr) {
            this.data = bArr;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameRequestBuilder setType(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType imageType) {
            this.type = imageType;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameRequestBuilder setWidth(int i_renamed) {
            this.width = i_renamed;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameRequestBuilder setHeight(int i_renamed) {
            this.height = i_renamed;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameRequestBuilder setRotation(int i_renamed) {
            this.rotation = i_renamed;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameRequest build() {
            int i_renamed;
            int i2;
            com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType imageType;
            byte[] bArr = this.data;
            if (bArr == null || (i_renamed = this.width) <= 0 || (i2 = this.height) <= 0 || (imageType = this.type) == null || this.cameraType == null) {
                return null;
            }
            return new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameRequest(this.cameraType, new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoFrame(bArr, imageType, i_renamed, i2, this.rotation));
        }
    }

    public static class HumanProcessFrameRequest {
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType cameraType;
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoFrame humanVideoFrame;

        public static com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameRequestBuilder Builder() {
            return new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameRequestBuilder();
        }

        public HumanProcessFrameRequest(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType cameraType, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoFrame humanVideoFrame) {
            this.cameraType = cameraType;
            this.humanVideoFrame = humanVideoFrame;
        }

        public boolean IsValid() {
            com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoFrame humanVideoFrame = this.humanVideoFrame;
            return humanVideoFrame != null && humanVideoFrame.IsValid();
        }
    }

    public static class HumanProcessHardwareBufferRequestBuilder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType cameraType;
        public android.hardware.HardwareBuffer data;
        public int height;
        public int rotation;
        public int scanline;
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType type;
        public int width;

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessHardwareBufferRequestBuilder setCameraType(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType cameraType) {
            this.cameraType = cameraType;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessHardwareBufferRequestBuilder setData(android.hardware.HardwareBuffer hardwareBuffer) {
            this.data = hardwareBuffer;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessHardwareBufferRequestBuilder setType(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType imageType) {
            this.type = imageType;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessHardwareBufferRequestBuilder setWidth(int i_renamed) {
            this.width = i_renamed;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessHardwareBufferRequestBuilder setHeight(int i_renamed) {
            this.height = i_renamed;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessHardwareBufferRequestBuilder setScanline(int i_renamed) {
            this.scanline = i_renamed;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessHardwareBufferRequestBuilder setRotation(int i_renamed) {
            this.rotation = i_renamed;
            return this;
        }

        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessHardwareBufferRequest build() {
            int i_renamed;
            int i2;
            com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType imageType;
            android.hardware.HardwareBuffer hardwareBuffer = this.data;
            if (hardwareBuffer == null || (i_renamed = this.width) <= 0 || (i2 = this.height) <= 0 || (imageType = this.type) == null || this.cameraType == null) {
                return null;
            }
            return new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessHardwareBufferRequest(this.cameraType, new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoHardwareBuffer(hardwareBuffer, imageType, i_renamed, i2, this.scanline, this.rotation));
        }
    }

    public static class HumanVideoHardwareBuffer {
        public android.hardware.HardwareBuffer data;
        public int height;
        public int rotation;
        public int scanline;
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType type;
        public int width;

        public HumanVideoHardwareBuffer(android.hardware.HardwareBuffer hardwareBuffer, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType imageType, int i_renamed, int i2, int i3, int i4) {
            this.data = hardwareBuffer;
            this.type = imageType;
            this.width = i_renamed;
            this.height = i2;
            this.scanline = i3;
            this.rotation = i4;
        }

        public boolean IsValid() {
            return this.data != null && this.width > 0 && this.height > 0 && this.rotation % 90 == 0 && this.type != null;
        }
    }

    public static class HumanProcessHardwareBufferRequest {
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType cameraType;
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoHardwareBuffer humanVideoFrame;

        public static com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameRequestBuilder Builder() {
            return new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameRequestBuilder();
        }

        public HumanProcessHardwareBufferRequest(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType cameraType, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoHardwareBuffer humanVideoHardwareBuffer) {
            this.cameraType = cameraType;
            this.humanVideoFrame = humanVideoHardwareBuffer;
        }

        public boolean IsValid() {
            com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoHardwareBuffer humanVideoHardwareBuffer = this.humanVideoFrame;
            return humanVideoHardwareBuffer != null && humanVideoHardwareBuffer.IsValid();
        }
    }

    public static class HumanProcessTexureResult {
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoTexture humanVideoTexture;

        public HumanProcessTexureResult(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoTexture humanVideoTexture) {
            this.humanVideoTexture = humanVideoTexture;
        }

        public HumanProcessTexureResult(int i_renamed, boolean z_renamed, int i2, int i3, int i4, boolean z2) {
            this.humanVideoTexture = new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoTexture(i_renamed, z_renamed, i2, i3, i4, z2);
        }

        public boolean IsValid() {
            com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoTexture humanVideoTexture = this.humanVideoTexture;
            return humanVideoTexture != null && humanVideoTexture.IsValid();
        }
    }

    public static class HumanProcessFrameResult {
        public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoFrame humanVideoFrame;

        public HumanProcessFrameResult(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoFrame humanVideoFrame) {
            this.humanVideoFrame = humanVideoFrame;
        }

        public HumanProcessFrameResult(byte[] bArr, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType imageType, int i_renamed, int i2, int i3) {
            this.humanVideoFrame = new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoFrame(bArr, imageType, i_renamed, i2, i3);
        }

        public boolean IsValid() {
            com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoFrame humanVideoFrame = this.humanVideoFrame;
            return humanVideoFrame != null && humanVideoFrame.IsValid();
        }
    }

    public static class HumanEffectDoubleExposureConfig {
        public java.lang.String cache_path;
        public boolean isBackCamera;
        public boolean isRealTime;
        public byte[] model_data;
        public java.lang.String native_lib_path;

        public HumanEffectDoubleExposureConfig(boolean z_renamed, byte[] bArr, java.lang.String str, java.lang.String str2, boolean z2) {
            this.isRealTime = z_renamed;
            this.model_data = bArr;
            this.cache_path = str;
            this.native_lib_path = str2;
            this.isBackCamera = z2;
        }

        public HumanEffectDoubleExposureConfig(byte[] bArr, boolean z_renamed, java.lang.String str, java.lang.String str2) {
            this.model_data = bArr;
            this.isRealTime = z_renamed;
            this.cache_path = str;
            this.native_lib_path = str2;
            this.isBackCamera = true;
        }

        public HumanEffectDoubleExposureConfig() {
            this.model_data = null;
            this.isRealTime = true;
            this.cache_path = "";
            this.native_lib_path = "";
            this.isBackCamera = true;
        }

        public java.lang.String toString() {
            java.lang.Object[] objArr = new java.lang.Object[4];
            byte[] bArr = this.model_data;
            objArr[0] = java.lang.Integer.valueOf(bArr != null ? bArr.length : 0);
            java.lang.String str = this.cache_path;
            objArr[1] = str != null ? new java.io.File(str).getName() : "null";
            java.lang.String str2 = this.native_lib_path;
            objArr[2] = str2 != null ? new java.io.File(str2).getName() : "null";
            objArr[3] = java.lang.Boolean.valueOf(this.isRealTime);
            return java.lang.String.format("sdkCapability %d_renamed, model size %d_renamed, cache path %s_renamed, lib path %s_renamed, realtime %b_renamed", objArr);
        }

        public static class HumanEffectDoubleExposureConfigBuilder {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private java.lang.String cache_path;
            private boolean isBackCamera;
            private boolean isRealTime = true;
            private byte[] model_data;
            private java.lang.String native_lib_path;

            public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig.HumanEffectDoubleExposureConfigBuilder setModel_data(byte[] bArr) {
                this.model_data = bArr;
                return this;
            }

            public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig.HumanEffectDoubleExposureConfigBuilder setCache_path(java.lang.String str) {
                this.cache_path = str;
                return this;
            }

            public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig.HumanEffectDoubleExposureConfigBuilder setNative_lib_path(java.lang.String str) {
                this.native_lib_path = str;
                return this;
            }

            public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig.HumanEffectDoubleExposureConfigBuilder setBackCameraFlag(boolean z_renamed) {
                this.isBackCamera = z_renamed;
                return this;
            }

            public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig.HumanEffectDoubleExposureConfigBuilder setRealTime(boolean z_renamed) {
                this.isRealTime = z_renamed;
                return this;
            }

            public com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig build() {
                if (this.model_data == null) {
                    return null;
                }
                com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig humanEffectDoubleExposureConfig = new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig();
                humanEffectDoubleExposureConfig.isRealTime = this.isRealTime;
                humanEffectDoubleExposureConfig.model_data = this.model_data;
                humanEffectDoubleExposureConfig.cache_path = this.cache_path;
                humanEffectDoubleExposureConfig.native_lib_path = this.native_lib_path;
                humanEffectDoubleExposureConfig.isBackCamera = this.isBackCamera;
                return humanEffectDoubleExposureConfig;
            }
        }

        public static com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig.HumanEffectDoubleExposureConfigBuilder Builder() {
            return new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig.HumanEffectDoubleExposureConfigBuilder();
        }
    }

    public int initByConfig(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig humanEffectDoubleExposureConfig) {
        if (DEBUG) {
            java.lang.String str = TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("init API by_renamed BuildNumber: 350 isRealTime: ");
            sb.append(humanEffectDoubleExposureConfig);
            android.util.Log.i_renamed(str, sb.toString() != null ? humanEffectDoubleExposureConfig.toString() : " null config");
        } else {
            android.util.Log.e_renamed(TAG, "init API by_renamed config BuildNumber: 350");
        }
        if (this.handle.get() != 0) {
            return 3;
        }
        if (humanEffectDoubleExposureConfig == null || humanEffectDoubleExposureConfig.model_data == null) {
            android.util.Log.e_renamed(TAG, "config invalid!");
            return 1;
        }
        if (!isSoLoaded.get()) {
            java.lang.System.loadLibrary("AncHumanDoubleExposure-jni");
            isSoLoaded.set(true);
        }
        if (humanEffectDoubleExposureConfig.cache_path == null) {
            humanEffectDoubleExposureConfig.cache_path = "";
        }
        if (humanEffectDoubleExposureConfig.native_lib_path == null) {
            humanEffectDoubleExposureConfig.native_lib_path = "";
        }
        this.handle.set(nativeInitHandle(humanEffectDoubleExposureConfig));
        int andSet = this.mPendingLogLevel.getAndSet(-1);
        if (andSet >= 0) {
            nativeSetLogLevel(andSet);
        }
        android.util.Log.e_renamed(TAG, "log level " + andSet);
        return this.handle.get() == 0 ? 3 : 0;
    }

    public int setLogLevel(int i_renamed) {
        if (!isSoLoaded.get()) {
            this.mPendingLogLevel.set(i_renamed);
            return -1;
        }
        nativeSetLogLevel(i_renamed);
        return 0;
    }

    public int setParams(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoDoubleExposureParams humanVideoDoubleExposureParams) {
        if (this.handle.get() == 0 || humanVideoDoubleExposureParams == null) {
            android.util.Log.e_renamed(TAG, "setParams: handle is_renamed invalid!");
            return 2;
        }
        return nativeSetParams(this.handle.get(), humanVideoDoubleExposureParams);
    }

    public int process(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequest humanProcessTextureRequest, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTexureResult humanProcessTexureResult) {
        if (this.handle.get() == 0) {
            android.util.Log.e_renamed(TAG, "process: handle is_renamed invalid!");
            return 2;
        }
        if (humanProcessTextureRequest == null || humanProcessTexureResult == null || !humanProcessTextureRequest.IsValid()) {
            return 1;
        }
        return nativeProcessTexture(this.handle.get(), humanProcessTextureRequest.humanVideoTexture.texID, humanProcessTexureResult.humanVideoTexture.texID, humanProcessTextureRequest.humanVideoTexture.width, humanProcessTextureRequest.humanVideoTexture.height, humanProcessTextureRequest.humanVideoTexture.rotation, humanProcessTextureRequest.humanVideoTexture.isOES);
    }

    public int process(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequest humanProcessTextureRequest, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequest humanProcessTextureRequest2, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTexureResult humanProcessTexureResult) {
        if (this.handle.get() == 0) {
            android.util.Log.e_renamed(TAG, "process: handle is_renamed invalid!");
            return 2;
        }
        if (humanProcessTextureRequest == null || humanProcessTexureResult == null || !humanProcessTextureRequest.IsValid()) {
            return 1;
        }
        int i_renamed = humanProcessTextureRequest.humanVideoTexture.width;
        int i2 = humanProcessTextureRequest.humanVideoTexture.height;
        int i3 = humanProcessTextureRequest2.humanVideoTexture.width;
        int i4 = humanProcessTextureRequest2.humanVideoTexture.height;
        android.util.Log.d_renamed(TAG, java.lang.String.format("process fg_renamed %d_renamed, bg_renamed %d_renamed, out %d_renamed", java.lang.Integer.valueOf(humanProcessTextureRequest.humanVideoTexture.texID), java.lang.Integer.valueOf(humanProcessTextureRequest2.humanVideoTexture.texID), java.lang.Integer.valueOf(humanProcessTexureResult.humanVideoTexture.texID)));
        if (humanProcessTexureResult.humanVideoTexture.isOES) {
            android.util.Log.e_renamed(TAG, "please set output 2d texture instead of_renamed oes.");
            return 1;
        }
        return nativeProcessTextures(this.handle.get(), humanProcessTextureRequest.humanVideoTexture.texID, humanProcessTextureRequest.humanVideoTexture.isOES, humanProcessTextureRequest2.humanVideoTexture.texID, humanProcessTextureRequest2.humanVideoTexture.isOES, humanProcessTexureResult.humanVideoTexture.texID, i_renamed, i2, i3, i4, humanProcessTextureRequest2.humanVideoTexture.rotation, humanProcessTextureRequest.humanVideoTexture.rotation);
    }

    public int process(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameRequest humanProcessFrameRequest, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequest humanProcessTextureRequest, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTexureResult humanProcessTexureResult) {
        if (this.handle.get() == 0) {
            android.util.Log.e_renamed(TAG, "process: handle is_renamed invalid!");
            return 2;
        }
        if (humanProcessFrameRequest != null && humanProcessTexureResult != null) {
            if (!((humanProcessTextureRequest == null) | (!humanProcessFrameRequest.IsValid())) && humanProcessTextureRequest.IsValid() && humanProcessTexureResult.IsValid()) {
                android.util.Log.e_renamed(TAG, "fgFrameRequest.cameratype " + humanProcessFrameRequest.cameraType + " bgTextureRequest.cameratype " + humanProcessTextureRequest.cameraType);
                int i_renamed = humanProcessFrameRequest.humanVideoFrame.width;
                int i2 = humanProcessFrameRequest.humanVideoFrame.height;
                if (humanProcessFrameRequest.humanVideoFrame.type != com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType.ANC_HUM_IMG_NV21) {
                    android.util.Log.e_renamed(TAG, "process: argment is_renamed invalid, image type=%d_renamed" + humanProcessFrameRequest.humanVideoFrame.type);
                    return 1;
                }
                if (i_renamed % 64 != 0) {
                    android.util.Log.e_renamed(TAG, "[Warning]process: argment maybe is_renamed invalid, width is_renamed not 64 alignment maybe causes abnormal rendering cases");
                }
                int i3 = humanProcessTextureRequest.humanVideoTexture.width;
                int i4 = humanProcessTextureRequest.humanVideoTexture.height;
                android.util.Log.d_renamed(TAG, java.lang.String.format("process fg_renamed %d_renamed, bg_renamed %d_renamed, out %d_renamed", java.lang.Integer.valueOf(humanProcessFrameRequest.humanVideoFrame.data.length), java.lang.Integer.valueOf(humanProcessTextureRequest.humanVideoTexture.texID), java.lang.Integer.valueOf(humanProcessTexureResult.humanVideoTexture.texID)));
                if (humanProcessTexureResult.humanVideoTexture.isOES) {
                    android.util.Log.e_renamed(TAG, "process: please set output 2d texture instead of_renamed oes.");
                    return 1;
                }
                return nativeProcessFrameInTextureOut(this.handle.get(), humanProcessFrameRequest.humanVideoFrame.data, humanProcessFrameRequest.cameraType == com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType.CAMERA_TYPE_REAR ? 0 : 1, humanProcessTextureRequest.humanVideoTexture.texID, humanProcessTextureRequest.humanVideoTexture.isOES, humanProcessTextureRequest.cameraType == com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType.CAMERA_TYPE_REAR ? 0 : 1, humanProcessTexureResult.humanVideoTexture.texID, i_renamed, i2, i3, i4, humanProcessTextureRequest.humanVideoTexture.isBgFromAlbum, humanProcessTextureRequest.humanVideoTexture.rotation, humanProcessFrameRequest.humanVideoFrame.rotation);
            }
        }
        java.lang.String str = TAG;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("process: argment is_renamed invalid, fgFrameRequest is_renamed ");
        sb.append((humanProcessFrameRequest == null || !humanProcessFrameRequest.IsValid()) ? "invalid" : "valid");
        sb.append(", bgTextureRequest is_renamed ");
        sb.append((humanProcessTextureRequest == null || !humanProcessTextureRequest.IsValid()) ? "invalid" : "valid");
        sb.append(", texureResult is_renamed ");
        sb.append((humanProcessTexureResult == null || !humanProcessTexureResult.IsValid()) ? "invalid" : "valid");
        android.util.Log.e_renamed(str, sb.toString());
        return 1;
    }

    public int process(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessHardwareBufferRequest humanProcessHardwareBufferRequest, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequest humanProcessTextureRequest, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTexureResult humanProcessTexureResult) {
        if (this.handle.get() == 0) {
            android.util.Log.e_renamed(TAG, "process: handle is_renamed invalid!");
            return 2;
        }
        if (humanProcessHardwareBufferRequest != null && humanProcessTexureResult != null) {
            if (!((humanProcessTextureRequest == null) | (!humanProcessHardwareBufferRequest.IsValid())) && humanProcessTextureRequest.IsValid() && humanProcessTexureResult.IsValid()) {
                int i_renamed = humanProcessHardwareBufferRequest.humanVideoFrame.width;
                int i2 = humanProcessHardwareBufferRequest.humanVideoFrame.height;
                if (humanProcessHardwareBufferRequest.humanVideoFrame.type != com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType.ANC_HUM_IMG_NV21) {
                    android.util.Log.e_renamed(TAG, "process: argment is_renamed invalid, image type=%d_renamed" + humanProcessHardwareBufferRequest.humanVideoFrame.type);
                    return 1;
                }
                if (i_renamed % 64 != 0) {
                    android.util.Log.e_renamed(TAG, "[Warning]process: argment maybe is_renamed invalid, width is_renamed not 64 alignment maybe causes abnormal rendering cases");
                }
                int i3 = humanProcessTextureRequest.humanVideoTexture.width;
                int i4 = humanProcessTextureRequest.humanVideoTexture.height;
                if (humanProcessTexureResult.humanVideoTexture.isOES) {
                    android.util.Log.e_renamed(TAG, "process: please set output 2d texture instead of_renamed oes.");
                    return 1;
                }
                return nativeProcessTextureAndHardwareBufferInTextureOut(this.handle.get(), 0, false, humanProcessHardwareBufferRequest.humanVideoFrame.data, humanProcessHardwareBufferRequest.humanVideoFrame.scanline, humanProcessTextureRequest.humanVideoTexture.texID, humanProcessTextureRequest.humanVideoTexture.isOES, humanProcessTexureResult.humanVideoTexture.texID, i_renamed, i2, i3, i4, humanProcessTextureRequest.humanVideoTexture.rotation, humanProcessHardwareBufferRequest.humanVideoFrame.rotation, humanProcessHardwareBufferRequest.cameraType == com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType.CAMERA_TYPE_REAR ? 0 : 1, humanProcessTextureRequest.cameraType == com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType.CAMERA_TYPE_REAR ? 0 : 1, humanProcessTextureRequest.humanVideoTexture.isBgFromAlbum);
            }
        }
        java.lang.String str = TAG;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("process: argment is_renamed invalid, fgFrameRequest is_renamed ");
        sb.append((humanProcessHardwareBufferRequest == null || !humanProcessHardwareBufferRequest.IsValid()) ? "invalid" : "valid");
        sb.append(", bgTextureRequest is_renamed ");
        sb.append((humanProcessTextureRequest == null || !humanProcessTextureRequest.IsValid()) ? "invalid" : "valid");
        sb.append(", texureResult is_renamed ");
        sb.append((humanProcessTexureResult == null || !humanProcessTexureResult.IsValid()) ? "invalid" : "valid");
        android.util.Log.e_renamed(str, sb.toString());
        return 1;
    }

    public int process(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequest humanProcessTextureRequest, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessHardwareBufferRequest humanProcessHardwareBufferRequest, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequest humanProcessTextureRequest2, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTexureResult humanProcessTexureResult) {
        boolean z_renamed;
        if (this.handle.get() == 0) {
            android.util.Log.e_renamed(TAG, "process: handle is_renamed invalid!");
            return 2;
        }
        if (humanProcessTextureRequest == null || !(humanProcessTextureRequest == null || humanProcessHardwareBufferRequest.IsValid())) {
            android.util.Log.w_renamed(TAG, "process: argment fgTextureRequest is_renamed invalid!");
            z_renamed = false;
        } else {
            z_renamed = true;
        }
        if (humanProcessHardwareBufferRequest != null && humanProcessTexureResult != null) {
            if (!((humanProcessTextureRequest2 == null) | (!humanProcessHardwareBufferRequest.IsValid())) && humanProcessTextureRequest2.IsValid() && humanProcessTexureResult.IsValid()) {
                int i_renamed = humanProcessHardwareBufferRequest.humanVideoFrame.width;
                int i2 = humanProcessHardwareBufferRequest.humanVideoFrame.height;
                if (humanProcessHardwareBufferRequest.humanVideoFrame.type != com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType.ANC_HUM_IMG_NV21) {
                    android.util.Log.e_renamed(TAG, "process: argment is_renamed invalid, image type=%d_renamed" + humanProcessHardwareBufferRequest.humanVideoFrame.type);
                    return 1;
                }
                if (i_renamed % 64 != 0) {
                    android.util.Log.e_renamed(TAG, "[Warning]process: argment maybe is_renamed invalid, width is_renamed not 64 alignment maybe causes abnormal rendering cases");
                }
                int i3 = humanProcessTextureRequest2.humanVideoTexture.width;
                int i4 = humanProcessTextureRequest2.humanVideoTexture.height;
                if (humanProcessTexureResult.humanVideoTexture.isOES) {
                    android.util.Log.e_renamed(TAG, "process: please set output 2d texture instead of_renamed oes.");
                    return 1;
                }
                int i5 = humanProcessHardwareBufferRequest.cameraType == com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType.CAMERA_TYPE_REAR ? 0 : 1;
                int i6 = humanProcessTextureRequest2.cameraType == com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType.CAMERA_TYPE_REAR ? 0 : 1;
                return nativeProcessTextureAndHardwareBufferInTextureOut(this.handle.get(), z_renamed ? humanProcessTextureRequest.humanVideoTexture.texID : 0, z_renamed ? humanProcessTextureRequest.humanVideoTexture.isOES : false, humanProcessHardwareBufferRequest.humanVideoFrame.data, humanProcessHardwareBufferRequest.humanVideoFrame.scanline, humanProcessTextureRequest2.humanVideoTexture.texID, humanProcessTextureRequest2.humanVideoTexture.isOES, humanProcessTexureResult.humanVideoTexture.texID, i_renamed, i2, i3, i4, humanProcessTextureRequest2.humanVideoTexture.rotation, humanProcessHardwareBufferRequest.humanVideoFrame.rotation, i5, i6, humanProcessTextureRequest2.humanVideoTexture.isBgFromAlbum);
            }
        }
        java.lang.String str = TAG;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("process: argment is_renamed invalid, fgFrameRequest is_renamed ");
        sb.append((humanProcessHardwareBufferRequest == null || !humanProcessHardwareBufferRequest.IsValid()) ? "invalid" : "valid");
        sb.append(", bgTextureRequest is_renamed ");
        sb.append((humanProcessTextureRequest2 == null || !humanProcessTextureRequest2.IsValid()) ? "invalid" : "valid");
        sb.append(", texureResult is_renamed ");
        sb.append((humanProcessTexureResult == null || !humanProcessTexureResult.IsValid()) ? "invalid" : "valid");
        android.util.Log.e_renamed(str, sb.toString());
        return 1;
    }

    public int process(com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameRequest humanProcessFrameRequest, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessFrameResult humanProcessFrameResult) {
        if (this.handle.get() == 0) {
            android.util.Log.e_renamed(TAG, "process: handle is_renamed invalid!");
            return 2;
        }
        return nativeProcessFrame(this.handle.get(), humanProcessFrameRequest.humanVideoFrame.data, humanProcessFrameResult.humanVideoFrame.data, humanProcessFrameRequest.humanVideoFrame.width, humanProcessFrameRequest.humanVideoFrame.height, (humanProcessFrameResult.humanVideoFrame.width == 0 ? humanProcessFrameRequest.humanVideoFrame : humanProcessFrameResult.humanVideoFrame).width, (humanProcessFrameResult.humanVideoFrame.height == 0 ? humanProcessFrameRequest.humanVideoFrame : humanProcessFrameResult.humanVideoFrame).height, humanProcessFrameRequest.humanVideoFrame.type.ordinal(), humanProcessFrameRequest.humanVideoFrame.rotation);
    }

    public int release() {
        if (this.handle.get() == 0) {
            android.util.Log.e_renamed(TAG, "release: handle is_renamed invalid!");
            return 2;
        }
        int iNativeRelease = nativeRelease(this.handle.get());
        this.handle.set(0L);
        return iNativeRelease;
    }

    public int attachGL() {
        if (this.handle.get() == 0) {
            android.util.Log.e_renamed(TAG, "prepareRun: handle is_renamed invalid!");
            return 2;
        }
        return nativeAttachGl(this.handle.get());
    }

    public static com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi getInstance() {
        return sInstance;
    }

    public java.lang.String getVersion() {
        return !isSoLoaded.get() ? "" : nativeSdkVersion();
    }

    private static byte[] getFileContent(java.lang.String str) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(str);
            while (true) {
                int i_renamed = fileInputStream.read(bArr);
                if (i_renamed != -1) {
                    byteArrayOutputStream.write(bArr, 0, i_renamed);
                } else {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (java.io.IOException unused) {
            return null;
        }
    }
}
