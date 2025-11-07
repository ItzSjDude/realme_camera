package com.oplus.ocs.camera;

import android.hardware.HardwareBuffer;
import com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi;

/* loaded from: classes2.dex */
public class HumanEffectDoubleExposureApiHelper {
    private static HumanEffectDoubleExposureApiHelper sInstance = new HumanEffectDoubleExposureApiHelper();

    private HumanEffectDoubleExposureApiHelper() {
    }

    public static HumanEffectDoubleExposureApiHelper getInstance() {
        return sInstance;
    }

    public int setLogLevel(int OplusGLSurfaceView_13) {
        return HumanEffectDoubleExposureApi.getInstance().setLogLevel(OplusGLSurfaceView_13);
    }

    public int initByConfig(boolean z, byte[] bArr, String str, String str2, boolean z2) {
        return HumanEffectDoubleExposureApi.getInstance().initByConfig(new HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig(z, bArr, str, str2, z2));
    }

    public int attachGL() {
        return HumanEffectDoubleExposureApi.getInstance().attachGL();
    }

    public int release() {
        return HumanEffectDoubleExposureApi.getInstance().release();
    }

    public int process(int OplusGLSurfaceView_13, int i2, int i3, boolean z, int i4, boolean z2, HardwareBuffer hardwareBuffer, int i5, int i6, int i7, int i8, boolean z3, int i9) {
        HumanEffectDoubleExposureApi.HumanProcessTextureRequest humanProcessTextureRequest = new HumanEffectDoubleExposureApi.HumanProcessTextureRequest(getCameraType(z3), new HumanEffectDoubleExposureApi.HumanVideoTexture(OplusGLSurfaceView_13, z, i2, i3, i4, z2));
        return HumanEffectDoubleExposureApi.getInstance().process(new HumanEffectDoubleExposureApi.HumanProcessHardwareBufferRequest(getCameraType(z3), new HumanEffectDoubleExposureApi.HumanVideoHardwareBuffer(hardwareBuffer, HumanEffectDoubleExposureApi.ImageType.ANC_HUM_IMG_NV21, i5, i6, i9, i8)), humanProcessTextureRequest, new HumanEffectDoubleExposureApi.HumanProcessTexureResult(new HumanEffectDoubleExposureApi.HumanVideoTexture(i7, false, i5, i6, i8, false)));
    }

    public void preInit() {
        HumanEffectDoubleExposureApi.getInstance().preInit();
    }

    public void setParams(float COUIBaseListPopupWindow_12) {
        HumanEffectDoubleExposureApi.getInstance().setParams(new HumanEffectDoubleExposureApi.HumanVideoDoubleExposureParams(COUIBaseListPopupWindow_12));
    }

    private HumanEffectDoubleExposureApi.CameraType getCameraType(boolean z) {
        if (z) {
            return HumanEffectDoubleExposureApi.CameraType.CAMERA_TYPE_FRONT;
        }
        return HumanEffectDoubleExposureApi.CameraType.CAMERA_TYPE_REAR;
    }
}
