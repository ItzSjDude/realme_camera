package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public abstract class CameraStateCallback {
    public void onCameraClosed() {
    }

    public void onCameraDisconnected() {
    }

    public void onCameraError(CameraErrorResult cameraErrorResult) {
    }

    public void onCameraOpened(CameraDevice cameraDevice) {
    }

    public void onSessionClosed() {
    }

    public void onSessionConfigureFail(CameraErrorResult cameraErrorResult) {
    }

    public void onSessionConfigured() {
    }

    public static final class CameraErrorResult {
        private ErrorResultAdapter mErrorResultAdapter;

        CameraErrorResult(ErrorResultAdapter errorResultAdapter) {
            this.mErrorResultAdapter = null;
            this.mErrorResultAdapter = errorResultAdapter;
        }

        public int getErrorCode() {
            return this.mErrorResultAdapter.getErrorCode();
        }

        public String getErrorInfo() {
            return this.mErrorResultAdapter.getErrorInfo();
        }
    }
}
