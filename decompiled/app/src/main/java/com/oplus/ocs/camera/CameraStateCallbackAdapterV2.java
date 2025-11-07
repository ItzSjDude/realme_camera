package com.oplus.ocs.camera;

import com.oplus.ocs.camera.CameraStateCallback;
import com.oplus.ocs.camera.appinterface.CameraDeviceInterface;
import com.oplus.ocs.camera.appinterface.CameraStateCallbackAdapter;
import com.oplus.ocs.camera.common.util.ErrorResult;

/* loaded from: classes2.dex */
class CameraStateCallbackAdapterV2 extends CameraStateCallbackAdapter {
    private CameraStateCallback mCameraStateCallback;

    CameraStateCallbackAdapterV2(CameraStateCallback cameraStateCallback) {
        this.mCameraStateCallback = null;
        this.mCameraStateCallback = cameraStateCallback;
    }

    public void onCameraOpened(CameraDeviceInterface cameraDeviceInterface) {
        super.onCameraOpened(cameraDeviceInterface);
        CameraStateCallback cameraStateCallback = this.mCameraStateCallback;
        if (cameraStateCallback != null) {
            cameraStateCallback.onCameraOpened(new CameraDevice(new CameraDeviceAdapterV2(cameraDeviceInterface)));
        }
    }

    public void onCameraClosed() {
        super.onCameraClosed();
        CameraStateCallback cameraStateCallback = this.mCameraStateCallback;
        if (cameraStateCallback != null) {
            cameraStateCallback.onCameraClosed();
        }
    }

    public void onCameraDisconnected() {
        super.onCameraDisconnected();
        CameraStateCallback cameraStateCallback = this.mCameraStateCallback;
        if (cameraStateCallback != null) {
            cameraStateCallback.onCameraDisconnected();
        }
    }

    public void onCameraError(ErrorResult errorResult) {
        super.onCameraError(errorResult);
        CameraStateCallback cameraStateCallback = this.mCameraStateCallback;
        if (cameraStateCallback != null) {
            cameraStateCallback.onCameraError(errorResult != null ? new CameraStateCallback.CameraErrorResult(new ErrorResultAdapterV2(errorResult)) : null);
        }
    }

    public void onSessionConfigured() {
        super.onSessionConfigured();
        CameraStateCallback cameraStateCallback = this.mCameraStateCallback;
        if (cameraStateCallback != null) {
            cameraStateCallback.onSessionConfigured();
        }
    }

    public void onSessionConfigureFail(ErrorResult errorResult) {
        super.onSessionConfigureFail(errorResult);
        CameraStateCallback cameraStateCallback = this.mCameraStateCallback;
        if (cameraStateCallback != null) {
            cameraStateCallback.onSessionConfigureFail(errorResult != null ? new CameraStateCallback.CameraErrorResult(new ErrorResultAdapterV2(errorResult)) : null);
        }
    }

    public void onSessionClosed() {
        super.onSessionClosed();
        CameraStateCallback cameraStateCallback = this.mCameraStateCallback;
        if (cameraStateCallback != null) {
            cameraStateCallback.onSessionClosed();
        }
    }
}
