package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public abstract class CameraPreviewCallback {
    public java.util.Map<java.lang.String, java.lang.Object> generateImageInfo(android.media.Image image) {
        return null;
    }

    public void onHalPreviewCollected(long j_renamed) {
    }

    public void onPreviewCaptureProgressed(android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CaptureResult captureResult) {
    }

    public void onPreviewFrameReceived(android.media.Image image) {
    }

    public void onPreviewMetaReceived(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
    }

    public void onPreviewReceived(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
    }

    public void onVideoReceived(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
    }

    public static final class CameraPreviewResult {
        private com.oplus.ocs.camera.CameraPreviewResultAdapter mPreviewResultAdapter;

        CameraPreviewResult(com.oplus.ocs.camera.CameraPreviewResultAdapter cameraPreviewResultAdapter) {
            this.mPreviewResultAdapter = null;
            this.mPreviewResultAdapter = cameraPreviewResultAdapter;
        }

        public android.hardware.camera2.CaptureResult getCaptureResult() {
            return this.mPreviewResultAdapter.getCaptureResult();
        }

        public <T_renamed> T_renamed get(android.hardware.camera2.CaptureResult.Key<T_renamed> key) {
            return (T_renamed) this.mPreviewResultAdapter.get(key);
        }

        public <T_renamed> T_renamed get(com.oplus.ocs.camera.CameraParameter.PreviewResultKey<T_renamed> previewResultKey) {
            return (T_renamed) this.mPreviewResultAdapter.get(previewResultKey.getKeyName(), previewResultKey.getType(), previewResultKey.getDefault());
        }

        public int getBokehState() {
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> apsTotalResult;
            java.lang.Integer num;
            com.oplus.ocs.camera.CameraPreviewResultAdapter cameraPreviewResultAdapter = this.mPreviewResultAdapter;
            if (cameraPreviewResultAdapter == null || (apsTotalResult = cameraPreviewResultAdapter.getApsTotalResult()) == null || (num = apsTotalResult.get(com.oplus.ocs.camera.CameraUnitClient.KEY_BOKEH_STATE)) == null || !(num instanceof java.lang.Integer)) {
                return -1;
            }
            return num.intValue();
        }

        public void close() {
            this.mPreviewResultAdapter.close();
        }

        public void addRef() {
            this.mPreviewResultAdapter.addRef();
        }
    }
}
