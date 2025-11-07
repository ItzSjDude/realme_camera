package com.oplus.ocs.camera;

import com.oplus.ocs.camera.appinterface.CameraFlashCallbackAdapter;
import java.util.List;

/* loaded from: classes2.dex */
class CameraFlashCallbackAdapterV2 extends CameraFlashCallbackAdapter {
    private CameraFlashCallback mCameraFlashCallback;

    CameraFlashCallbackAdapterV2(CameraFlashCallback cameraFlashCallback) {
        this.mCameraFlashCallback = null;
        this.mCameraFlashCallback = cameraFlashCallback;
    }

    public void onFlashModeSupportListChanged(List<String> list) {
        CameraFlashCallback cameraFlashCallback = this.mCameraFlashCallback;
        if (cameraFlashCallback != null) {
            cameraFlashCallback.onFlashModeSupportListChanged(list);
        }
    }

    public void onFlashModeChanged(String str) {
        CameraFlashCallback cameraFlashCallback = this.mCameraFlashCallback;
        if (cameraFlashCallback != null) {
            cameraFlashCallback.onFlashModeChanged(str);
        }
    }
}
