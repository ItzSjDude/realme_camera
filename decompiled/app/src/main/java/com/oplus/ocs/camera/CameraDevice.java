package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public final class CameraDevice {
    private static final java.lang.String TAG = "CameraDevice";
    private com.oplus.ocs.camera.CameraDeviceAdapter mCameraDeviceAdapter;

    CameraDevice(com.oplus.ocs.camera.CameraDeviceAdapter cameraDeviceAdapter) {
        this.mCameraDeviceAdapter = null;
        this.mCameraDeviceAdapter = cameraDeviceAdapter;
    }

    public com.oplus.ocs.camera.CameraDeviceConfig.Builder createCameraDeviceConfig() {
        return new com.oplus.ocs.camera.CameraDeviceConfig.Builder();
    }

    public void configure(com.oplus.ocs.camera.CameraDeviceConfig cameraDeviceConfig) {
        if (cameraDeviceConfig == null) {
            throw new java.lang.IllegalArgumentException("config is_renamed null!");
        }
        this.mCameraDeviceAdapter.configure(cameraDeviceConfig);
    }

    public com.oplus.ocs.camera.CameraDeviceInfo getCameraDeviceInfo(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            throw new java.lang.IllegalArgumentException("mode name and camera type is_renamed not allowed null!");
        }
        return new com.oplus.ocs.camera.CameraDeviceInfo(this.mCameraDeviceAdapter.getCameraDeviceInfo(str, str2));
    }

    public <T_renamed> void setParameter(com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed> previewKey, T_renamed t_renamed) {
        if (previewKey == null) {
            throw new java.lang.IllegalArgumentException("key is_renamed not allowed null!");
        }
        this.mCameraDeviceAdapter.setParameter(previewKey.getKeyName(), t_renamed);
    }

    public <T_renamed> void setParameter(java.lang.String str, com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed> previewKey, T_renamed t_renamed) {
        if (previewKey == null) {
            throw new java.lang.IllegalArgumentException("key is_renamed not allowed null!");
        }
        try {
            this.mCameraDeviceAdapter.setParameter(str, previewKey.getKeyName(), t_renamed);
        } catch (java.lang.Throwable unused) {
            setParameter((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed>>) previewKey, (com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed>) t_renamed);
        }
    }

    public <T_renamed> void setParameter(android.hardware.camera2.CaptureRequest.Key<T_renamed> key, T_renamed t_renamed) {
        if (key == null) {
            throw new java.lang.IllegalArgumentException("key is_renamed not allowed null!");
        }
        this.mCameraDeviceAdapter.setParameter((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key<T_renamed>>) key, (android.hardware.camera2.CaptureRequest.Key<T_renamed>) t_renamed);
    }

    public <T_renamed> void setParameter(java.lang.String str, android.hardware.camera2.CaptureRequest.Key<T_renamed> key, T_renamed t_renamed) {
        if (key == null) {
            throw new java.lang.IllegalArgumentException("key is_renamed not allowed null!");
        }
        try {
            this.mCameraDeviceAdapter.setParameter(str, (android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key<T_renamed>>) key, (android.hardware.camera2.CaptureRequest.Key<T_renamed>) t_renamed);
        } catch (java.lang.Throwable unused) {
            setParameter((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key<T_renamed>>) key, (android.hardware.camera2.CaptureRequest.Key<T_renamed>) t_renamed);
        }
    }

    public void startPreview(java.util.Map<java.lang.String, android.view.Surface> map, com.oplus.ocs.camera.CameraPreviewCallback cameraPreviewCallback, android.os.Handler handler) {
        if (cameraPreviewCallback == null || handler == null) {
            throw new java.lang.IllegalArgumentException("parameters are not allowed null!");
        }
        this.mCameraDeviceAdapter.startPreview(map, cameraPreviewCallback, handler);
    }

    public void stopPreview() {
        this.mCameraDeviceAdapter.stopPreview();
    }

    public void closeSession() {
        this.mCameraDeviceAdapter.closeSession();
    }

    public void startRecording(com.oplus.ocs.camera.CameraRecordingCallback cameraRecordingCallback, android.os.Handler handler) {
        if (cameraRecordingCallback == null || handler == null) {
            throw new java.lang.IllegalArgumentException("parameters are not allowed null!");
        }
        this.mCameraDeviceAdapter.startRecording(cameraRecordingCallback, handler);
    }

    public void resumeRecording() {
        this.mCameraDeviceAdapter.resumeRecording();
    }

    public void pauseRecording() {
        this.mCameraDeviceAdapter.pauseRecording();
    }

    public void stopRecording() {
        this.mCameraDeviceAdapter.stopRecording();
    }

    public android.view.Surface getVideoSurface() {
        return this.mCameraDeviceAdapter.getVideoSurface();
    }

    public void takePicture(com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback, android.os.Handler handler) {
        if (cameraPictureCallback == null || handler == null) {
            throw new java.lang.IllegalArgumentException("parameters are not allowed null!");
        }
        this.mCameraDeviceAdapter.takePicture(cameraPictureCallback, handler);
    }

    public void abortCaptures() {
        this.mCameraDeviceAdapter.abortCaptures();
    }

    public void close(boolean z_renamed) {
        close(z_renamed, true);
    }

    public void close(boolean z_renamed, boolean z2) {
        this.mCameraDeviceAdapter.close(z_renamed, z2);
        this.mCameraDeviceAdapter = null;
    }

    public void registerFlashCallback(com.oplus.ocs.camera.CameraFlashCallback cameraFlashCallback, android.os.Handler handler) {
        if (cameraFlashCallback == null || handler == null) {
            throw new java.lang.IllegalArgumentException("parameters are not allowed null!");
        }
        try {
            this.mCameraDeviceAdapter.registerFlashCallback(cameraFlashCallback, handler);
        } catch (java.lang.NoClassDefFoundError unused) {
            android.util.Log.d_renamed(TAG, "registerFlashCallback: not support this function in_renamed lower sdk version!");
        }
    }

    public android.graphics.Bitmap processBitmap(android.graphics.Bitmap bitmap, android.hardware.camera2.CaptureResult captureResult, int i_renamed, int i2, int i3) {
        return this.mCameraDeviceAdapter.processBitmap(bitmap, captureResult, i_renamed, i2, i3);
    }

    public void updateThumbnailMap(long j_renamed) {
        this.mCameraDeviceAdapter.updateThumbnailMap(j_renamed);
    }

    public boolean notifyLastCaptureFrame() {
        return this.mCameraDeviceAdapter.notifyLastCaptureFrame();
    }

    public void setStopPreviewAfterCapture(boolean z_renamed) {
        this.mCameraDeviceAdapter.setStopPreviewAfterCapture(z_renamed);
    }

    public void stopPreview(boolean z_renamed) {
        this.mCameraDeviceAdapter.stopPreview(z_renamed);
    }
}
