package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
class CameraStateCallbackAdapterV2 extends com.oplus.ocs.camera.appinterface.CameraStateCallbackAdapter {
    private com.oplus.ocs.camera.CameraStateCallback mCameraStateCallback;

    CameraStateCallbackAdapterV2(com.oplus.ocs.camera.CameraStateCallback cameraStateCallback) {
        this.mCameraStateCallback = null;
        this.mCameraStateCallback = cameraStateCallback;
    }

    public void onCameraOpened(com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface) {
        super.onCameraOpened(cameraDeviceInterface);
        com.oplus.ocs.camera.CameraStateCallback cameraStateCallback = this.mCameraStateCallback;
        if (cameraStateCallback != null) {
            cameraStateCallback.onCameraOpened(new com.oplus.ocs.camera.CameraDevice(new com.oplus.ocs.camera.CameraDeviceAdapterV2(cameraDeviceInterface)));
        }
    }

    public void onCameraClosed() {
        super.onCameraClosed();
        com.oplus.ocs.camera.CameraStateCallback cameraStateCallback = this.mCameraStateCallback;
        if (cameraStateCallback != null) {
            cameraStateCallback.onCameraClosed();
        }
    }

    public void onCameraDisconnected() {
        super.onCameraDisconnected();
        com.oplus.ocs.camera.CameraStateCallback cameraStateCallback = this.mCameraStateCallback;
        if (cameraStateCallback != null) {
            cameraStateCallback.onCameraDisconnected();
        }
    }

    public void onCameraError(com.oplus.ocs.camera.common.util.ErrorResult errorResult) {
        super.onCameraError(errorResult);
        com.oplus.ocs.camera.CameraStateCallback cameraStateCallback = this.mCameraStateCallback;
        if (cameraStateCallback != null) {
            cameraStateCallback.onCameraError(errorResult != null ? new com.oplus.ocs.camera.CameraStateCallback.CameraErrorResult(new com.oplus.ocs.camera.ErrorResultAdapterV2(errorResult)) : null);
        }
    }

    public void onSessionConfigured() {
        super.onSessionConfigured();
        com.oplus.ocs.camera.CameraStateCallback cameraStateCallback = this.mCameraStateCallback;
        if (cameraStateCallback != null) {
            cameraStateCallback.onSessionConfigured();
        }
    }

    public void onSessionConfigureFail(com.oplus.ocs.camera.common.util.ErrorResult errorResult) {
        super.onSessionConfigureFail(errorResult);
        com.oplus.ocs.camera.CameraStateCallback cameraStateCallback = this.mCameraStateCallback;
        if (cameraStateCallback != null) {
            cameraStateCallback.onSessionConfigureFail(errorResult != null ? new com.oplus.ocs.camera.CameraStateCallback.CameraErrorResult(new com.oplus.ocs.camera.ErrorResultAdapterV2(errorResult)) : null);
        }
    }

    public void onSessionClosed() {
        super.onSessionClosed();
        com.oplus.ocs.camera.CameraStateCallback cameraStateCallback = this.mCameraStateCallback;
        if (cameraStateCallback != null) {
            cameraStateCallback.onSessionClosed();
        }
    }
}
