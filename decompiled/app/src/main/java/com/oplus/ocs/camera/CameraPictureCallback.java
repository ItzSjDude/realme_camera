package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public abstract class CameraPictureCallback {
    public void afterProcessImage(int i_renamed, com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
    }

    public void fillApsParameters(int i_renamed, java.util.Map<java.lang.String, java.lang.String> map) {
    }

    public void onBurstShotEnd(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
    }

    public void onBurstShotStart(long j_renamed) {
    }

    public void onCaptureFailed(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
    }

    public void onCaptureFirstFrameArrived(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
    }

    public void onCaptureMetaReceived(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
    }

    public void onCapturePrepared() {
    }

    public void onCaptureShutter(long j_renamed) {
    }

    public void onFinishAddFrame(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
    }

    public void onFirstCaptureFrameAdd() {
    }

    public void onImageReceived(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
    }

    public void onPictureCaptureProgressed(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
    }

    public void onPictureCaptureSequenceCompleted(int i_renamed, long j_renamed) {
    }

    public static final class CameraPictureImage {
        private com.oplus.ocs.camera.CameraImageAdapter mCameraImageAdapter;

        CameraPictureImage(com.oplus.ocs.camera.CameraImageAdapter cameraImageAdapter) {
            this.mCameraImageAdapter = null;
            this.mCameraImageAdapter = cameraImageAdapter;
        }

        public byte[] getImage() {
            return this.mCameraImageAdapter.getImage();
        }

        public int getFormat() {
            return this.mCameraImageAdapter.getFormat();
        }

        public int getWidth() {
            return this.mCameraImageAdapter.getWidth();
        }

        public int getHeight() {
            return this.mCameraImageAdapter.getHeight();
        }

        public int getStride() {
            return this.mCameraImageAdapter.getStride();
        }

        public int getScanline() {
            return this.mCameraImageAdapter.getScanline();
        }

        public int getOrientation() {
            return this.mCameraImageAdapter.getOrientation();
        }

        public long getTimestamp() {
            return this.mCameraImageAdapter.getTimestamp();
        }

        public java.lang.String getCameraType() {
            return this.mCameraImageAdapter.getCameraType();
        }

        public int getSourceType() {
            return this.mCameraImageAdapter.getSourceType();
        }
    }

    public static final class CameraPictureResult {
        private com.oplus.ocs.camera.CameraPictureResultAdapter mPictureResultAdapter;

        CameraPictureResult(com.oplus.ocs.camera.CameraPictureResultAdapter cameraPictureResultAdapter) {
            this.mPictureResultAdapter = null;
            this.mPictureResultAdapter = cameraPictureResultAdapter;
        }

        public <T_renamed> T_renamed get(android.hardware.camera2.CaptureResult.Key<T_renamed> key) {
            return (T_renamed) this.mPictureResultAdapter.get(key);
        }

        public <T_renamed> T_renamed get(com.oplus.ocs.camera.CameraParameter.CaptureResultKey<T_renamed> captureResultKey) {
            return (T_renamed) this.mPictureResultAdapter.get(captureResultKey);
        }

        public android.hardware.camera2.CaptureFailure getCaptureFailure() {
            return this.mPictureResultAdapter.getCaptureFailure();
        }

        public android.hardware.camera2.CaptureResult getCaptureResult() {
            return this.mPictureResultAdapter.getCaptureResult();
        }
    }
}
