package com.oplus.camera.aps.util;

import android.hardware.HardwareBuffer;
import android.hardware.camera2.CaptureResult;
import android.media.Image;
import com.oplus.camera.CameraLog;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPreviewCallback;

/* loaded from: classes2.dex */
public class CameraApsResult {
    private static final String TAG = "CameraApsResult";
    public int mHeight;
    public long mIdentity;
    public int mIsLastVideoFrame;
    public int mIsMotionDetected;
    public int mIsStartInterpolationFrame;
    private CameraPreviewCallback.CameraPreviewResult mPreviewResult;
    public int mWidth;

    public CameraApsResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        this.mWidth = 0;
        this.mHeight = 0;
        this.mIdentity = 0L;
        this.mIsMotionDetected = 0;
        this.mIsStartInterpolationFrame = 0;
        this.mIsLastVideoFrame = 0;
        this.mPreviewResult = null;
        if (cameraPreviewResult != null) {
            this.mWidth = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_WIDTH)).intValue();
            this.mHeight = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_HEIGHT)).intValue();
            this.mIdentity = ((Long) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_IDENTITY)).longValue();
            this.mIsMotionDetected = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_MOTION_DETECTED)).intValue();
            this.mIsStartInterpolationFrame = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_START_INTERPOLATION_FRAME)).intValue();
            this.mIsLastVideoFrame = ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_LAST_VDIEO_FRAME)).intValue();
            this.mPreviewResult = cameraPreviewResult;
            return;
        }
        CameraLog.m12967f(TAG, "CameraApsResult, result is null!");
    }

    public CameraPreviewCallback.CameraPreviewResult getPreviewResult() {
        return this.mPreviewResult;
    }

    public Image getImage() {
        CameraPreviewCallback.CameraPreviewResult cameraPreviewResult = this.mPreviewResult;
        if (cameraPreviewResult != null) {
            return (Image) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_CAMERA_IMAGE);
        }
        return null;
    }

    public final HardwareBuffer getHardwareBuffer() {
        CameraPreviewCallback.CameraPreviewResult cameraPreviewResult = this.mPreviewResult;
        if (cameraPreviewResult != null) {
            return (HardwareBuffer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_HARDWARE_BUFFER);
        }
        return null;
    }

    public final long getTimestamp() {
        CameraPreviewCallback.CameraPreviewResult cameraPreviewResult = this.mPreviewResult;
        if (cameraPreviewResult != null) {
            return ((Long) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_IMAGE_TIME_STAMP)).longValue();
        }
        return -1L;
    }

    public void closeImageBuffer() {
        CameraPreviewCallback.CameraPreviewResult cameraPreviewResult = this.mPreviewResult;
        if (cameraPreviewResult != null) {
            cameraPreviewResult.close();
        }
    }

    public void addRef() {
        CameraPreviewCallback.CameraPreviewResult cameraPreviewResult = this.mPreviewResult;
        if (cameraPreviewResult != null) {
            cameraPreviewResult.addRef();
        }
    }

    public CaptureResult getCaptureResult() {
        CameraPreviewCallback.CameraPreviewResult cameraPreviewResult = this.mPreviewResult;
        if (cameraPreviewResult != null) {
            return cameraPreviewResult.getCaptureResult();
        }
        return null;
    }

    public boolean isValid() {
        CameraPreviewCallback.CameraPreviewResult cameraPreviewResult = this.mPreviewResult;
        if (cameraPreviewResult != null) {
            return ((Boolean) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_IMAGE_IS_VALID)).booleanValue();
        }
        return false;
    }
}
