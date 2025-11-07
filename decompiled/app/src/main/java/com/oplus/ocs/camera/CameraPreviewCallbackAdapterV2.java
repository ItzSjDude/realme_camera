package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
class CameraPreviewCallbackAdapterV2 extends com.oplus.ocs.camera.appinterface.CameraPreviewCallbackAdapter {
    private com.oplus.ocs.camera.CameraPreviewCallback mCameraPreviewCallback;

    CameraPreviewCallbackAdapterV2(com.oplus.ocs.camera.CameraPreviewCallback cameraPreviewCallback) {
        this.mCameraPreviewCallback = null;
        this.mCameraPreviewCallback = cameraPreviewCallback;
    }

    public void onCaptureCompleted(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.ocs.camera.appinterface.CameraPreviewCallbackAdapter.PreviewResult previewResult) {
        super.onCaptureCompleted(captureRequest, previewResult);
        com.oplus.ocs.camera.CameraPreviewCallback cameraPreviewCallback = this.mCameraPreviewCallback;
        if (cameraPreviewCallback == null || previewResult == null) {
            return;
        }
        cameraPreviewCallback.onPreviewMetaReceived(new com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult(new com.oplus.ocs.camera.CameraPreviewCallbackAdapterV2.CameraPreviewResultV2(previewResult)));
    }

    public void onPreviewReceived(com.oplus.ocs.camera.appinterface.CameraPreviewCallbackAdapter.PreviewResult previewResult) {
        this.mCameraPreviewCallback.onPreviewReceived(new com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult(new com.oplus.ocs.camera.CameraPreviewCallbackAdapterV2.CameraPreviewResultV2(previewResult)));
    }

    public void onVideoReceived(com.oplus.ocs.camera.appinterface.CameraPreviewCallbackAdapter.PreviewResult previewResult) {
        this.mCameraPreviewCallback.onVideoReceived(new com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult(new com.oplus.ocs.camera.CameraPreviewCallbackAdapterV2.CameraPreviewResultV2(previewResult)));
    }

    public void onPreviewFrameReceived(android.media.Image image) {
        this.mCameraPreviewCallback.onPreviewFrameReceived(image);
    }

    public void onPreviewCaptureProgressed(android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CaptureResult captureResult) {
        this.mCameraPreviewCallback.onPreviewCaptureProgressed(captureRequest, captureResult);
    }

    public java.util.Map<java.lang.String, java.lang.Object> generateImageInfo(android.media.Image image) {
        return this.mCameraPreviewCallback.generateImageInfo(image);
    }

    public void onHalPreviewCollected(long j_renamed) {
        this.mCameraPreviewCallback.onHalPreviewCollected(j_renamed);
    }

    public static final class CameraPreviewResultV2 extends com.oplus.ocs.camera.CameraPreviewResultAdapter {
        private com.oplus.ocs.camera.appinterface.CameraPreviewCallbackAdapter.PreviewResult mPreviewResult;

        CameraPreviewResultV2(com.oplus.ocs.camera.appinterface.CameraPreviewCallbackAdapter.PreviewResult previewResult) {
            this.mPreviewResult = null;
            this.mPreviewResult = previewResult;
        }

        @Override // com.oplus.ocs.camera.CameraPreviewResultAdapter
        public android.hardware.camera2.CaptureResult getCaptureResult() {
            com.oplus.ocs.camera.appinterface.CameraPreviewCallbackAdapter.PreviewResult previewResult = this.mPreviewResult;
            if (previewResult != null) {
                return previewResult.getCaptureResult();
            }
            return null;
        }

        @Override // com.oplus.ocs.camera.CameraPreviewResultAdapter
        public <T_renamed> T_renamed get(android.hardware.camera2.CaptureResult.Key<T_renamed> key) {
            com.oplus.ocs.camera.appinterface.CameraPreviewCallbackAdapter.PreviewResult previewResult = this.mPreviewResult;
            if (previewResult != null) {
                return (T_renamed) previewResult.get(key);
            }
            return null;
        }

        @Override // com.oplus.ocs.camera.CameraPreviewResultAdapter
        public <T_renamed> T_renamed get(java.lang.String str, java.lang.Class<T_renamed> cls, T_renamed t_renamed) {
            com.oplus.ocs.camera.appinterface.CameraPreviewCallbackAdapter.PreviewResult previewResult = this.mPreviewResult;
            if (previewResult != null) {
                return (T_renamed) previewResult.get(str, cls, t_renamed);
            }
            return null;
        }

        @Override // com.oplus.ocs.camera.CameraPreviewResultAdapter
        public java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> getApsTotalResult() {
            com.oplus.ocs.camera.appinterface.CameraPreviewCallbackAdapter.PreviewResult previewResult = this.mPreviewResult;
            if (previewResult != null) {
                return previewResult.getApsTotalResult();
            }
            return null;
        }

        @Override // com.oplus.ocs.camera.CameraPreviewResultAdapter
        public void close() {
            com.oplus.ocs.camera.appinterface.CameraPreviewCallbackAdapter.PreviewResult previewResult = this.mPreviewResult;
            if (previewResult != null) {
                previewResult.close();
            }
        }

        @Override // com.oplus.ocs.camera.CameraPreviewResultAdapter
        public void addRef() {
            com.oplus.ocs.camera.appinterface.CameraPreviewCallbackAdapter.PreviewResult previewResult = this.mPreviewResult;
            if (previewResult != null) {
                previewResult.addRef();
            }
        }
    }
}
