package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public class HumanEffectDoubleExposureApiHelper {
    private static com.oplus.ocs.camera.HumanEffectDoubleExposureApiHelper sInstance = new com.oplus.ocs.camera.HumanEffectDoubleExposureApiHelper();

    private HumanEffectDoubleExposureApiHelper() {
    }

    public static com.oplus.ocs.camera.HumanEffectDoubleExposureApiHelper getInstance() {
        return sInstance;
    }

    public int setLogLevel(int i_renamed) {
        return com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.getInstance().setLogLevel(i_renamed);
    }

    public int initByConfig(boolean z_renamed, byte[] bArr, java.lang.String str, java.lang.String str2, boolean z2) {
        return com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.getInstance().initByConfig(new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig(z_renamed, bArr, str, str2, z2));
    }

    public int attachGL() {
        return com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.getInstance().attachGL();
    }

    public int release() {
        return com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.getInstance().release();
    }

    public int process(int i_renamed, int i2, int i3, boolean z_renamed, int i4, boolean z2, android.hardware.HardwareBuffer hardwareBuffer, int i5, int i6, int i7, int i8, boolean z3, int i9) {
        com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequest humanProcessTextureRequest = new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTextureRequest(getCameraType(z3), new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoTexture(i_renamed, z_renamed, i2, i3, i4, z2));
        return com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.getInstance().process(new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessHardwareBufferRequest(getCameraType(z3), new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoHardwareBuffer(hardwareBuffer, com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.ImageType.ANC_HUM_IMG_NV21, i5, i6, i9, i8)), humanProcessTextureRequest, new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanProcessTexureResult(new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoTexture(i7, false, i5, i6, i8, false)));
    }

    public void preInit() {
        com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.getInstance().preInit();
    }

    public void setParams(float f_renamed) {
        com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.getInstance().setParams(new com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.HumanVideoDoubleExposureParams(f_renamed));
    }

    private com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType getCameraType(boolean z_renamed) {
        if (z_renamed) {
            return com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType.CAMERA_TYPE_FRONT;
        }
        return com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.CameraType.CAMERA_TYPE_REAR;
    }
}
