package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
abstract class CameraPictureResultAdapter {
    public <T_renamed> T_renamed get(android.hardware.camera2.CaptureResult.Key<T_renamed> key) {
        return null;
    }

    public <T_renamed> T_renamed get(com.oplus.ocs.camera.CameraParameter.CaptureResultKey<T_renamed> captureResultKey) {
        return null;
    }

    public android.hardware.camera2.CaptureFailure getCaptureFailure() {
        return null;
    }

    public android.hardware.camera2.CaptureResult getCaptureResult() {
        return null;
    }

    CameraPictureResultAdapter() {
    }
}
