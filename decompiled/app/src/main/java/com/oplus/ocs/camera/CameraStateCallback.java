package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public abstract class CameraStateCallback {
    public void onCameraClosed() {
    }

    public void onCameraDisconnected() {
    }

    public void onCameraError(com.oplus.ocs.camera.CameraStateCallback.CameraErrorResult cameraErrorResult) {
    }

    public void onCameraOpened(com.oplus.ocs.camera.CameraDevice cameraDevice) {
    }

    public void onSessionClosed() {
    }

    public void onSessionConfigureFail(com.oplus.ocs.camera.CameraStateCallback.CameraErrorResult cameraErrorResult) {
    }

    public void onSessionConfigured() {
    }

    public static final class CameraErrorResult {
        private com.oplus.ocs.camera.ErrorResultAdapter mErrorResultAdapter;

        CameraErrorResult(com.oplus.ocs.camera.ErrorResultAdapter errorResultAdapter) {
            this.mErrorResultAdapter = null;
            this.mErrorResultAdapter = errorResultAdapter;
        }

        public int getErrorCode() {
            return this.mErrorResultAdapter.getErrorCode();
        }

        public java.lang.String getErrorInfo() {
            return this.mErrorResultAdapter.getErrorInfo();
        }
    }
}
