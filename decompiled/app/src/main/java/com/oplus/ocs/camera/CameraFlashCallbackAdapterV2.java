package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
class CameraFlashCallbackAdapterV2 extends com.oplus.ocs.camera.appinterface.CameraFlashCallbackAdapter {
    private com.oplus.ocs.camera.CameraFlashCallback mCameraFlashCallback;

    CameraFlashCallbackAdapterV2(com.oplus.ocs.camera.CameraFlashCallback cameraFlashCallback) {
        this.mCameraFlashCallback = null;
        this.mCameraFlashCallback = cameraFlashCallback;
    }

    public void onFlashModeSupportListChanged(java.util.List<java.lang.String> list) {
        com.oplus.ocs.camera.CameraFlashCallback cameraFlashCallback = this.mCameraFlashCallback;
        if (cameraFlashCallback != null) {
            cameraFlashCallback.onFlashModeSupportListChanged(list);
        }
    }

    public void onFlashModeChanged(java.lang.String str) {
        com.oplus.ocs.camera.CameraFlashCallback cameraFlashCallback = this.mCameraFlashCallback;
        if (cameraFlashCallback != null) {
            cameraFlashCallback.onFlashModeChanged(str);
        }
    }
}
