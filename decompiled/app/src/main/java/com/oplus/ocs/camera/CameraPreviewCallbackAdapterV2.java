package com.oplus.ocs.camera;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.media.Image;
import com.oplus.ocs.camera.CameraPreviewCallback;
import com.oplus.ocs.camera.appinterface.CameraPreviewCallbackAdapter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
class CameraPreviewCallbackAdapterV2 extends CameraPreviewCallbackAdapter {
    private CameraPreviewCallback mCameraPreviewCallback;

    CameraPreviewCallbackAdapterV2(CameraPreviewCallback cameraPreviewCallback) {
        this.mCameraPreviewCallback = null;
        this.mCameraPreviewCallback = cameraPreviewCallback;
    }

    public void onCaptureCompleted(CaptureRequest captureRequest, CameraPreviewCallbackAdapter.PreviewResult previewResult) {
        super.onCaptureCompleted(captureRequest, previewResult);
        CameraPreviewCallback cameraPreviewCallback = this.mCameraPreviewCallback;
        if (cameraPreviewCallback == null || previewResult == null) {
            return;
        }
        cameraPreviewCallback.onPreviewMetaReceived(new CameraPreviewCallback.CameraPreviewResult(new CameraPreviewResultV2(previewResult)));
    }

    public void onPreviewReceived(CameraPreviewCallbackAdapter.PreviewResult previewResult) {
        this.mCameraPreviewCallback.onPreviewReceived(new CameraPreviewCallback.CameraPreviewResult(new CameraPreviewResultV2(previewResult)));
    }

    public void onVideoReceived(CameraPreviewCallbackAdapter.PreviewResult previewResult) {
        this.mCameraPreviewCallback.onVideoReceived(new CameraPreviewCallback.CameraPreviewResult(new CameraPreviewResultV2(previewResult)));
    }

    public void onPreviewFrameReceived(Image image) {
        this.mCameraPreviewCallback.onPreviewFrameReceived(image);
    }

    public void onPreviewCaptureProgressed(CaptureRequest captureRequest, CaptureResult captureResult) {
        this.mCameraPreviewCallback.onPreviewCaptureProgressed(captureRequest, captureResult);
    }

    public Map<String, Object> generateImageInfo(Image image) {
        return this.mCameraPreviewCallback.generateImageInfo(image);
    }

    public void onHalPreviewCollected(long OplusGLSurfaceView_15) {
        this.mCameraPreviewCallback.onHalPreviewCollected(OplusGLSurfaceView_15);
    }

    public static final class CameraPreviewResultV2 extends CameraPreviewResultAdapter {
        private CameraPreviewCallbackAdapter.PreviewResult mPreviewResult;

        CameraPreviewResultV2(CameraPreviewCallbackAdapter.PreviewResult previewResult) {
            this.mPreviewResult = null;
            this.mPreviewResult = previewResult;
        }

        @Override // com.oplus.ocs.camera.CameraPreviewResultAdapter
        public CaptureResult getCaptureResult() {
            CameraPreviewCallbackAdapter.PreviewResult previewResult = this.mPreviewResult;
            if (previewResult != null) {
                return previewResult.getCaptureResult();
            }
            return null;
        }

        @Override // com.oplus.ocs.camera.CameraPreviewResultAdapter
        public <T> T get(CaptureResult.Key<T> key) {
            CameraPreviewCallbackAdapter.PreviewResult previewResult = this.mPreviewResult;
            if (previewResult != null) {
                return (T) previewResult.get(key);
            }
            return null;
        }

        @Override // com.oplus.ocs.camera.CameraPreviewResultAdapter
        public <T> T get(String str, Class<T> cls, T t) {
            CameraPreviewCallbackAdapter.PreviewResult previewResult = this.mPreviewResult;
            if (previewResult != null) {
                return (T) previewResult.get(str, cls, t);
            }
            return null;
        }

        @Override // com.oplus.ocs.camera.CameraPreviewResultAdapter
        public ConcurrentHashMap<String, Integer> getApsTotalResult() {
            CameraPreviewCallbackAdapter.PreviewResult previewResult = this.mPreviewResult;
            if (previewResult != null) {
                return previewResult.getApsTotalResult();
            }
            return null;
        }

        @Override // com.oplus.ocs.camera.CameraPreviewResultAdapter
        public void close() {
            CameraPreviewCallbackAdapter.PreviewResult previewResult = this.mPreviewResult;
            if (previewResult != null) {
                previewResult.close();
            }
        }

        @Override // com.oplus.ocs.camera.CameraPreviewResultAdapter
        public void addRef() {
            CameraPreviewCallbackAdapter.PreviewResult previewResult = this.mPreviewResult;
            if (previewResult != null) {
                previewResult.addRef();
            }
        }
    }
}
