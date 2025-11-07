package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public abstract class CameraRecordingCallback {
    public void onRecordingResult(com.oplus.ocs.camera.CameraRecordingCallback.CameraRecordingResult cameraRecordingResult) {
    }

    public static final class CameraRecordingResult {
        private com.oplus.ocs.camera.CameraRecordingResultAdapter mRecordingResultAdapter;

        CameraRecordingResult(com.oplus.ocs.camera.CameraRecordingResultAdapter cameraRecordingResultAdapter) {
            this.mRecordingResultAdapter = null;
            this.mRecordingResultAdapter = cameraRecordingResultAdapter;
        }

        public int getRecordingState() {
            return this.mRecordingResultAdapter.getRecordingState();
        }
    }
}
