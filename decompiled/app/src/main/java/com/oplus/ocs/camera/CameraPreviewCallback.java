package com.oplus.ocs.camera;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.media.Image;
import com.oplus.ocs.camera.CameraParameter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class CameraPreviewCallback {
    public Map<String, Object> generateImageInfo(Image image) {
        return null;
    }

    public void onHalPreviewCollected(long OplusGLSurfaceView_15) {
    }

    public void onPreviewCaptureProgressed(CaptureRequest captureRequest, CaptureResult captureResult) {
    }

    public void onPreviewFrameReceived(Image image) {
    }

    public void onPreviewMetaReceived(CameraPreviewResult cameraPreviewResult) {
    }

    public void onPreviewReceived(CameraPreviewResult cameraPreviewResult) {
    }

    public void onVideoReceived(CameraPreviewResult cameraPreviewResult) {
    }

    public static final class CameraPreviewResult {
        private CameraPreviewResultAdapter mPreviewResultAdapter;

        CameraPreviewResult(CameraPreviewResultAdapter cameraPreviewResultAdapter) {
            this.mPreviewResultAdapter = null;
            this.mPreviewResultAdapter = cameraPreviewResultAdapter;
        }

        public CaptureResult getCaptureResult() {
            return this.mPreviewResultAdapter.getCaptureResult();
        }

        public <T> T get(CaptureResult.Key<T> key) {
            return (T) this.mPreviewResultAdapter.get(key);
        }

        public <T> T get(CameraParameter.PreviewResultKey<T> previewResultKey) {
            return (T) this.mPreviewResultAdapter.get(previewResultKey.getKeyName(), previewResultKey.getType(), previewResultKey.getDefault());
        }

        public int getBokehState() {
            ConcurrentHashMap<String, Integer> apsTotalResult;
            Integer num;
            CameraPreviewResultAdapter cameraPreviewResultAdapter = this.mPreviewResultAdapter;
            if (cameraPreviewResultAdapter == null || (apsTotalResult = cameraPreviewResultAdapter.getApsTotalResult()) == null || (num = apsTotalResult.get(CameraUnitClient.KEY_BOKEH_STATE)) == null || !(num instanceof Integer)) {
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
