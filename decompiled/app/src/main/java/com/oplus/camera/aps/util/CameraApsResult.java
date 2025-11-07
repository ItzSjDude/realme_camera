package com.oplus.camera.aps.util;

/* loaded from: classes2.dex */
public class CameraApsResult {
    private static final java.lang.String TAG = "CameraApsResult";
    public int mHeight;
    public long mIdentity;
    public int mIsLastVideoFrame;
    public int mIsMotionDetected;
    public int mIsStartInterpolationFrame;
    private com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult mPreviewResult;
    public int mWidth;

    public CameraApsResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        this.mWidth = 0;
        this.mHeight = 0;
        this.mIdentity = 0L;
        this.mIsMotionDetected = 0;
        this.mIsStartInterpolationFrame = 0;
        this.mIsLastVideoFrame = 0;
        this.mPreviewResult = null;
        if (cameraPreviewResult != null) {
            this.mWidth = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_WIDTH)).intValue();
            this.mHeight = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_HEIGHT)).intValue();
            this.mIdentity = ((java.lang.Long) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_IDENTITY)).longValue();
            this.mIsMotionDetected = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_MOTION_DETECTED)).intValue();
            this.mIsStartInterpolationFrame = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_START_INTERPOLATION_FRAME)).intValue();
            this.mIsLastVideoFrame = ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_LAST_VDIEO_FRAME)).intValue();
            this.mPreviewResult = cameraPreviewResult;
            return;
        }
        com.oplus.camera.e_renamed.f_renamed(TAG, "CameraApsResult, result is_renamed null!");
    }

    public com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult getPreviewResult() {
        return this.mPreviewResult;
    }

    public android.media.Image getImage() {
        com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult = this.mPreviewResult;
        if (cameraPreviewResult != null) {
            return (android.media.Image) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_CAMERA_IMAGE);
        }
        return null;
    }

    public final android.hardware.HardwareBuffer getHardwareBuffer() {
        com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult = this.mPreviewResult;
        if (cameraPreviewResult != null) {
            return (android.hardware.HardwareBuffer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_HARDWARE_BUFFER);
        }
        return null;
    }

    public final long getTimestamp() {
        com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult = this.mPreviewResult;
        if (cameraPreviewResult != null) {
            return ((java.lang.Long) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_IMAGE_TIME_STAMP)).longValue();
        }
        return -1L;
    }

    public void closeImageBuffer() {
        com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult = this.mPreviewResult;
        if (cameraPreviewResult != null) {
            cameraPreviewResult.close();
        }
    }

    public void addRef() {
        com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult = this.mPreviewResult;
        if (cameraPreviewResult != null) {
            cameraPreviewResult.addRef();
        }
    }

    public android.hardware.camera2.CaptureResult getCaptureResult() {
        com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult = this.mPreviewResult;
        if (cameraPreviewResult != null) {
            return cameraPreviewResult.getCaptureResult();
        }
        return null;
    }

    public boolean isValid() {
        com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult = this.mPreviewResult;
        if (cameraPreviewResult != null) {
            return ((java.lang.Boolean) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_IMAGE_IS_VALID)).booleanValue();
        }
        return false;
    }
}
