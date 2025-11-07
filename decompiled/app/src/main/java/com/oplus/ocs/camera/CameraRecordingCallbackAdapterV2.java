package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
class CameraRecordingCallbackAdapterV2 extends com.oplus.ocs.camera.appinterface.CameraRecordingCallbackAdapter {
    private com.oplus.ocs.camera.CameraRecordingCallback mCameraRecordingCallback;

    CameraRecordingCallbackAdapterV2(com.oplus.ocs.camera.CameraRecordingCallback cameraRecordingCallback) {
        this.mCameraRecordingCallback = null;
        this.mCameraRecordingCallback = cameraRecordingCallback;
    }

    public void onRecordingResult(com.oplus.ocs.camera.appinterface.CameraRecordingCallbackAdapter.RecordingResult recordingResult) {
        com.oplus.ocs.camera.CameraRecordingCallback cameraRecordingCallback = this.mCameraRecordingCallback;
        if (cameraRecordingCallback != null) {
            cameraRecordingCallback.onRecordingResult(recordingResult != null ? new com.oplus.ocs.camera.CameraRecordingCallback.CameraRecordingResult(new com.oplus.ocs.camera.CameraRecordingCallbackAdapterV2.CameraRecordingResultV2(recordingResult)) : null);
        }
    }

    public static final class CameraRecordingResultV2 extends com.oplus.ocs.camera.CameraRecordingResultAdapter {
        private com.oplus.ocs.camera.appinterface.CameraRecordingCallbackAdapter.RecordingResult mRecordingResult;

        CameraRecordingResultV2(com.oplus.ocs.camera.appinterface.CameraRecordingCallbackAdapter.RecordingResult recordingResult) {
            this.mRecordingResult = null;
            this.mRecordingResult = recordingResult;
        }

        @Override // com.oplus.ocs.camera.CameraRecordingResultAdapter
        public int getRecordingState() {
            return this.mRecordingResult.getRecordingState();
        }
    }
}
