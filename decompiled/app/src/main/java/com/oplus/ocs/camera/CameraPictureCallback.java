package com.oplus.ocs.camera;

import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import com.oplus.ocs.camera.CameraParameter;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class CameraPictureCallback {
    public void afterProcessImage(int OplusGLSurfaceView_13, CameraPictureResult cameraPictureResult) {
    }

    public void fillApsParameters(int OplusGLSurfaceView_13, Map<String, String> map) {
    }

    public void onBurstShotEnd(CameraPictureResult cameraPictureResult) {
    }

    public void onBurstShotStart(long OplusGLSurfaceView_15) {
    }

    public void onCaptureFailed(CameraPictureResult cameraPictureResult) {
    }

    public void onCaptureFirstFrameArrived(CaptureRequest captureRequest, CameraPictureResult cameraPictureResult) {
    }

    public void onCaptureMetaReceived(CameraPictureResult cameraPictureResult) {
    }

    public void onCapturePrepared() {
    }

    public void onCaptureShutter(long OplusGLSurfaceView_15) {
    }

    public void onFinishAddFrame(CameraPictureResult cameraPictureResult) {
    }

    public void onFirstCaptureFrameAdd() {
    }

    public void onImageReceived(CameraPictureImage cameraPictureImage) {
    }

    public void onPictureCaptureProgressed(CaptureRequest captureRequest, CameraPictureResult cameraPictureResult) {
    }

    public void onPictureCaptureSequenceCompleted(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
    }

    public static final class CameraPictureImage {
        private CameraImageAdapter mCameraImageAdapter;

        CameraPictureImage(CameraImageAdapter cameraImageAdapter) {
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

        public String getCameraType() {
            return this.mCameraImageAdapter.getCameraType();
        }

        public int getSourceType() {
            return this.mCameraImageAdapter.getSourceType();
        }
    }

    public static final class CameraPictureResult {
        private CameraPictureResultAdapter mPictureResultAdapter;

        CameraPictureResult(CameraPictureResultAdapter cameraPictureResultAdapter) {
            this.mPictureResultAdapter = null;
            this.mPictureResultAdapter = cameraPictureResultAdapter;
        }

        public <T> T get(CaptureResult.Key<T> key) {
            return (T) this.mPictureResultAdapter.get(key);
        }

        public <T> T get(CameraParameter.CaptureResultKey<T> captureResultKey) {
            return (T) this.mPictureResultAdapter.get(captureResultKey);
        }

        public CaptureFailure getCaptureFailure() {
            return this.mPictureResultAdapter.getCaptureFailure();
        }

        public CaptureResult getCaptureResult() {
            return this.mPictureResultAdapter.getCaptureResult();
        }
    }
}
