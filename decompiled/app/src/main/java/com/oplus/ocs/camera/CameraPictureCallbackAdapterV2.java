package com.oplus.ocs.camera;

import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPictureCallback;
import com.oplus.ocs.camera.appinterface.CameraPictureCallbackAdapter;
import com.oplus.ocs.camera.common.util.CameraImage;
import java.util.Map;

/* loaded from: classes2.dex */
class CameraPictureCallbackAdapterV2 extends CameraPictureCallbackAdapter {
    private CameraPictureCallback mCameraPictureCallback;

    CameraPictureCallbackAdapterV2(CameraPictureCallback cameraPictureCallback) {
        this.mCameraPictureCallback = null;
        this.mCameraPictureCallback = cameraPictureCallback;
    }

    public void onCaptureStarted(CaptureRequest captureRequest, long OplusGLSurfaceView_15) {
        super.onCaptureStarted(captureRequest, OplusGLSurfaceView_15);
        CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onCaptureShutter(OplusGLSurfaceView_15);
        }
    }

    public void onCapturePrepared() {
        CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onCapturePrepared();
        }
    }

    public void onCaptureFirstFrameArrived(CaptureRequest captureRequest, CameraPictureCallbackAdapter.PictureResult pictureResult) {
        super.onCaptureFirstFrameArrived(captureRequest, pictureResult);
        CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onCaptureFirstFrameArrived(captureRequest, pictureResult != null ? new CameraPictureCallback.CameraPictureResult(new CameraPictureResultV2(pictureResult)) : null);
        }
    }

    public void onPictureCaptureProgressed(CaptureRequest captureRequest, CameraPictureCallbackAdapter.PictureResult pictureResult) {
        super.onPictureCaptureProgressed(captureRequest, pictureResult);
        CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onPictureCaptureProgressed(captureRequest, pictureResult != null ? new CameraPictureCallback.CameraPictureResult(new CameraPictureResultV2(pictureResult)) : null);
        }
    }

    public void onCaptureCompleted(CaptureRequest captureRequest, CameraPictureCallbackAdapter.PictureResult pictureResult) {
        super.onCaptureCompleted(captureRequest, pictureResult);
        CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onCaptureMetaReceived(pictureResult != null ? new CameraPictureCallback.CameraPictureResult(new CameraPictureResultV2(pictureResult)) : null);
        }
    }

    public void onCaptureFailed(CaptureRequest captureRequest, CameraPictureCallbackAdapter.PictureResult pictureResult) {
        super.onCaptureFailed(captureRequest, pictureResult);
        CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onCaptureFailed(pictureResult != null ? new CameraPictureCallback.CameraPictureResult(new CameraPictureResultV2(pictureResult)) : null);
        }
    }

    public void onImageReceived(CameraImage cameraImage) {
        super.onImageReceived(cameraImage);
        CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onImageReceived(cameraImage != null ? new CameraPictureCallback.CameraPictureImage(new CameraPictureImageV2(cameraImage)) : null);
        }
    }

    public void onPictureCaptureSequenceCompleted(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        super.onPictureCaptureSequenceCompleted(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
        CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onPictureCaptureSequenceCompleted(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
        }
    }

    public void onBurstShotStart(long OplusGLSurfaceView_15) {
        super.onBurstShotStart(OplusGLSurfaceView_15);
        CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onBurstShotStart(OplusGLSurfaceView_15);
        }
    }

    public void onBurstShotEnd(CameraPictureCallbackAdapter.PictureResult pictureResult) {
        super.onBurstShotEnd(pictureResult);
        CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.onBurstShotEnd(pictureResult != null ? new CameraPictureCallback.CameraPictureResult(new CameraPictureResultV2(pictureResult)) : null);
        }
    }

    public void afterProcessImage(int OplusGLSurfaceView_13, CameraPictureCallbackAdapter.PictureResult pictureResult) {
        super.afterProcessImage(OplusGLSurfaceView_13, pictureResult);
        CameraPictureCallback cameraPictureCallback = this.mCameraPictureCallback;
        if (cameraPictureCallback != null) {
            cameraPictureCallback.afterProcessImage(OplusGLSurfaceView_13, pictureResult != null ? new CameraPictureCallback.CameraPictureResult(new CameraPictureResultV2(pictureResult)) : null);
        }
    }

    public void fillApsParameters(int OplusGLSurfaceView_13, Map<String, String> map) {
        this.mCameraPictureCallback.fillApsParameters(OplusGLSurfaceView_13, map);
    }

    public void onFinishAddFrame(CameraPictureCallbackAdapter.PictureResult pictureResult) {
        this.mCameraPictureCallback.onFinishAddFrame(pictureResult != null ? new CameraPictureCallback.CameraPictureResult(new CameraPictureResultV2(pictureResult)) : null);
    }

    public void onFirstCaptureFrameAdd() {
        this.mCameraPictureCallback.onFirstCaptureFrameAdd();
    }

    public static final class CameraPictureImageV2 extends CameraImageAdapter {
        private CameraImage mCameraImage;

        CameraPictureImageV2(CameraImage cameraImage) {
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
        public String getCameraType() {
            return this.mCameraImage.getCameraType();
        }

        @Override // com.oplus.ocs.camera.CameraImageAdapter
        public int getSourceType() {
            return this.mCameraImage.getSourceType();
        }
    }

    public static final class CameraPictureResultV2 extends CameraPictureResultAdapter {
        private CameraPictureCallbackAdapter.PictureResult mPictureResult;

        CameraPictureResultV2(CameraPictureCallbackAdapter.PictureResult pictureResult) {
            this.mPictureResult = null;
            this.mPictureResult = pictureResult;
        }

        @Override // com.oplus.ocs.camera.CameraPictureResultAdapter
        public <T> T get(CaptureResult.Key<T> key) {
            return (T) this.mPictureResult.get(key);
        }

        @Override // com.oplus.ocs.camera.CameraPictureResultAdapter
        public <T> T get(CameraParameter.CaptureResultKey<T> captureResultKey) {
            return (T) this.mPictureResult.get(captureResultKey.getKeyName(), captureResultKey.getType(), captureResultKey.getDefault());
        }

        @Override // com.oplus.ocs.camera.CameraPictureResultAdapter
        public CaptureFailure getCaptureFailure() {
            return this.mPictureResult.getCaptureFailure();
        }

        @Override // com.oplus.ocs.camera.CameraPictureResultAdapter
        public CaptureResult getCaptureResult() {
            return this.mPictureResult.getCaptureResult();
        }
    }
}
