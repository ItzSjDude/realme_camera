package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
class CameraPictureCallbackAdapterV2 extends com.oplus.ocs.camera.appinterface.CameraPictureCallbackAdapter {
    private com.oplus.ocs.camera.CameraPictureCallback mCameraPictureCallback;

    CameraPictureCallbackAdapterV2(com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback) {
        this.mCameraPictureCallback = null;
        this.mCameraPictureCallback = cameraPictureCallback;
    }

    public void onCaptureStarted(android.hardware.camera2.CaptureRequest captureRequest, long j_renamed) {
        super.onCaptureStarted(captureRequest, j_renamed);
        com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onCaptureShutter(j_renamed);
        }
    }

    public void onCapturePrepared() {
        com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onCapturePrepared();
        }
    }

    public void onCaptureFirstFrameArrived(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.ocs.camera.appinterface.CameraPictureCallbackAdapter.PictureResult pictureResult) {
        super.onCaptureFirstFrameArrived(captureRequest, pictureResult);
        com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onCaptureFirstFrameArrived(captureRequest, pictureResult != null ? new com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult(new com.oplus.ocs.camera.CameraPictureCallbackAdapterV2.CameraPictureResultV2(pictureResult)) : null);
        }
    }

    public void onPictureCaptureProgressed(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.ocs.camera.appinterface.CameraPictureCallbackAdapter.PictureResult pictureResult) {
        super.onPictureCaptureProgressed(captureRequest, pictureResult);
        com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onPictureCaptureProgressed(captureRequest, pictureResult != null ? new com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult(new com.oplus.ocs.camera.CameraPictureCallbackAdapterV2.CameraPictureResultV2(pictureResult)) : null);
        }
    }

    public void onCaptureCompleted(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.ocs.camera.appinterface.CameraPictureCallbackAdapter.PictureResult pictureResult) {
        super.onCaptureCompleted(captureRequest, pictureResult);
        com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onCaptureMetaReceived(pictureResult != null ? new com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult(new com.oplus.ocs.camera.CameraPictureCallbackAdapterV2.CameraPictureResultV2(pictureResult)) : null);
        }
    }

    public void onCaptureFailed(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.ocs.camera.appinterface.CameraPictureCallbackAdapter.PictureResult pictureResult) {
        super.onCaptureFailed(captureRequest, pictureResult);
        com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onCaptureFailed(pictureResult != null ? new com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult(new com.oplus.ocs.camera.CameraPictureCallbackAdapterV2.CameraPictureResultV2(pictureResult)) : null);
        }
    }

    public void onImageReceived(com.oplus.ocs.camera.common.util.CameraImage cameraImage) {
        super.onImageReceived(cameraImage);
        com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onImageReceived(cameraImage != null ? new com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage(new com.oplus.ocs.camera.CameraPictureCallbackAdapterV2.CameraPictureImageV2(cameraImage)) : null);
        }
    }

    public void onPictureCaptureSequenceCompleted(int i_renamed, long j_renamed) {
        super.onPictureCaptureSequenceCompleted(i_renamed, j_renamed);
        com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onPictureCaptureSequenceCompleted(i_renamed, j_renamed);
        }
    }

    public void onBurstShotStart(long j_renamed) {
        super.onBurstShotStart(j_renamed);
        com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onBurstShotStart(j_renamed);
        }
    }

    public void onBurstShotEnd(com.oplus.ocs.camera.appinterface.CameraPictureCallbackAdapter.PictureResult pictureResult) {
        super.onBurstShotEnd(pictureResult);
        com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onBurstShotEnd(pictureResult != null ? new com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult(new com.oplus.ocs.camera.CameraPictureCallbackAdapterV2.CameraPictureResultV2(pictureResult)) : null);
        }
    }

    public void afterProcessImage(int i_renamed, com.oplus.ocs.camera.appinterface.CameraPictureCallbackAdapter.PictureResult pictureResult) {
        super.afterProcessImage(i_renamed, pictureResult);
        com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.afterProcessImage(i_renamed, pictureResult != null ? new com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult(new com.oplus.ocs.camera.CameraPictureCallbackAdapterV2.CameraPictureResultV2(pictureResult)) : null);
        }
    }

    public void fillApsParameters(int i_renamed, java.util.Map<java.lang.String, java.lang.String> map) {
        this.mCameraPictureCallback.fillApsParameters(i_renamed, map);
    }

    public void onFinishAddFrame(com.oplus.ocs.camera.appinterface.CameraPictureCallbackAdapter.PictureResult pictureResult) {
        this.mCameraPictureCallback.onFinishAddFrame(pictureResult != null ? new com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult(new com.oplus.ocs.camera.CameraPictureCallbackAdapterV2.CameraPictureResultV2(pictureResult)) : null);
    }

    public void onFirstCaptureFrameAdd() {
        this.mCameraPictureCallback.onFirstCaptureFrameAdd();
    }

    public static final class CameraPictureImageV2 extends com.oplus.ocs.camera.CameraImageAdapter {
        private com.oplus.ocs.camera.common.util.CameraImage mCameraImage;

        CameraPictureImageV2(com.oplus.ocs.camera.common.util.CameraImage cameraImage) {
            this.mCameraImage = null;
            this.mCameraImage = cameraImage;
        }

        @Override // com.oplus.ocs.camera.CameraImageAdapter
        public byte[] getImage() {
            return this.mCameraImage.getImage();
        }

        @Override // com.oplus.ocs.camera.CameraImageAdapter
        public int getFormat() {
            return this.mCameraImage.getFormat();
        }

        @Override // com.oplus.ocs.camera.CameraImageAdapter
        public int getWidth() {
            return this.mCameraImage.getWidth();
        }

        @Override // com.oplus.ocs.camera.CameraImageAdapter
        public int getHeight() {
            return this.mCameraImage.getHeight();
        }

        @Override // com.oplus.ocs.camera.CameraImageAdapter
        public int getStride() {
            return this.mCameraImage.getStride();
        }

        @Override // com.oplus.ocs.camera.CameraImageAdapter
        public int getScanline() {
            return this.mCameraImage.getScanline();
        }

        @Override // com.oplus.ocs.camera.CameraImageAdapter
        public int getOrientation() {
            return this.mCameraImage.getOrientation();
        }

        @Override // com.oplus.ocs.camera.CameraImageAdapter
        public long getTimestamp() {
            return this.mCameraImage.getTimestamp();
        }

        @Override // com.oplus.ocs.camera.CameraImageAdapter
        public java.lang.String getCameraType() {
            return this.mCameraImage.getCameraType();
        }

        @Override // com.oplus.ocs.camera.CameraImageAdapter
        public int getSourceType() {
            return this.mCameraImage.getSourceType();
        }
    }

    public static final class CameraPictureResultV2 extends com.oplus.ocs.camera.CameraPictureResultAdapter {
        private com.oplus.ocs.camera.appinterface.CameraPictureCallbackAdapter.PictureResult mPictureResult;

        CameraPictureResultV2(com.oplus.ocs.camera.appinterface.CameraPictureCallbackAdapter.PictureResult pictureResult) {
            this.mPictureResult = null;
            this.mPictureResult = pictureResult;
        }

        @Override // com.oplus.ocs.camera.CameraPictureResultAdapter
        public <T_renamed> T_renamed get(android.hardware.camera2.CaptureResult.Key<T_renamed> key) {
            return (T_renamed) this.mPictureResult.get(key);
        }

        @Override // com.oplus.ocs.camera.CameraPictureResultAdapter
        public <T_renamed> T_renamed get(com.oplus.ocs.camera.CameraParameter.CaptureResultKey<T_renamed> captureResultKey) {
            return (T_renamed) this.mPictureResult.get(captureResultKey.getKeyName(), captureResultKey.getType(), captureResultKey.getDefault());
        }

        @Override // com.oplus.ocs.camera.CameraPictureResultAdapter
        public android.hardware.camera2.CaptureFailure getCaptureFailure() {
            return this.mPictureResult.getCaptureFailure();
        }

        @Override // com.oplus.ocs.camera.CameraPictureResultAdapter
        public android.hardware.camera2.CaptureResult getCaptureResult() {
            return this.mPictureResult.getCaptureResult();
        }
    }
}
