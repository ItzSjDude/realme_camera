package com.oplus.ocs.camera;

import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureResult;
import com.oplus.ocs.camera.CameraParameter;

/* loaded from: classes2.dex */
abstract class CameraPictureResultAdapter {
    public <T> T get(CaptureResult.Key<T> key) {
        return null;
    }

    public <T> T get(CameraParameter.CaptureResultKey<T> captureResultKey) {
        return null;
    }

    public CaptureFailure getCaptureFailure() {
        return null;
    }

    public CaptureResult getCaptureResult() {
        return null;
    }

    CameraPictureResultAdapter() {
    }
}
