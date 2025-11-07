package com.oplus.ocs.camera;

import com.oplus.ocs.camera.CameraRecordingCallback;
import com.oplus.ocs.camera.appinterface.CameraRecordingCallbackAdapter;

/* loaded from: classes2.dex */
class CameraRecordingCallbackAdapterV2 extends CameraRecordingCallbackAdapter {
    private CameraRecordingCallback mCameraRecordingCallback;

    CameraRecordingCallbackAdapterV2(CameraRecordingCallback cameraRecordingCallback) {
        this.mCameraRecordingCallback = null;
        this.mCameraRecordingCallback = cameraRecordingCallback;
    }

    public void onRecordingResult(CameraRecordingCallbackAdapter.RecordingResult recordingResult) {
        CameraRecordingCallback cameraRecordingCallback = this.mCameraRecordingCallback;
        if (cameraRecordingCallback != null) {
            cameraRecordingCallback.onRecordingResult(recordingResult != null ? new CameraRecordingCallback.CameraRecordingResult(new CameraRecordingResultV2(recordingResult)) : null);
        }
    }

    public static final class CameraRecordingResultV2 extends CameraRecordingResultAdapter {
        private CameraRecordingCallbackAdapter.RecordingResult mRecordingResult;

        CameraRecordingResultV2(CameraRecordingCallbackAdapter.RecordingResult recordingResult) {
            this.mRecordingResult = null;
            this.mRecordingResult = recordingResult;
        }

        @Override // com.oplus.ocs.camera.CameraRecordingResultAdapter
        public int getRecordingState() {
            return this.mRecordingResult.getRecordingState();
        }
    }
}
