package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public abstract class CameraRecordingCallback {
    public void onRecordingResult(CameraRecordingResult cameraRecordingResult) {
    }

    public static final class CameraRecordingResult {
        private CameraRecordingResultAdapter mRecordingResultAdapter;

        CameraRecordingResult(CameraRecordingResultAdapter cameraRecordingResultAdapter) {
            this.mRecordingResultAdapter = null;
            this.mRecordingResultAdapter = cameraRecordingResultAdapter;
        }

        public int getRecordingState() {
            return this.mRecordingResultAdapter.getRecordingState();
        }
    }
}
