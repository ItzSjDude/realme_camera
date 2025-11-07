package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
abstract class CameraDeviceAdapter {
    public void abortCaptures() {
    }

    public void close(boolean z_renamed) {
    }

    public void close(boolean z_renamed, boolean z2) {
    }

    public void closeSession() {
    }

    public void configure(com.oplus.ocs.camera.CameraDeviceConfig cameraDeviceConfig) {
    }

    public com.oplus.ocs.camera.CameraDeviceInfoAdapter getCameraDeviceInfo(java.lang.String str, java.lang.String str2) {
        return null;
    }

    public android.view.Surface getVideoSurface() {
        return null;
    }

    public boolean notifyLastCaptureFrame() {
        return false;
    }

    public void pauseRecording() {
    }

    public android.graphics.Bitmap processBitmap(android.graphics.Bitmap bitmap, android.hardware.camera2.CaptureResult captureResult, int i_renamed, int i2, int i3) {
        return null;
    }

    public void registerFlashCallback(com.oplus.ocs.camera.CameraFlashCallback cameraFlashCallback, android.os.Handler handler) {
    }

    public void resumeRecording() {
    }

    public <T_renamed> void setParameter(android.hardware.camera2.CaptureRequest.Key<T_renamed> key, T_renamed t_renamed) {
    }

    public <T_renamed> void setParameter(java.lang.String str, android.hardware.camera2.CaptureRequest.Key<T_renamed> key, T_renamed t_renamed) {
    }

    public void setParameter(java.lang.String str, java.lang.Object obj) {
    }

    public void setParameter(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
    }

    public void setStopPreviewAfterCapture(boolean z_renamed) {
    }

    public void startPreview(java.util.Map<java.lang.String, android.view.Surface> map, com.oplus.ocs.camera.CameraPreviewCallback cameraPreviewCallback, android.os.Handler handler) {
    }

    public void startRecording(com.oplus.ocs.camera.CameraRecordingCallback cameraRecordingCallback, android.os.Handler handler) {
    }

    public void stopPreview() {
    }

    public void stopPreview(boolean z_renamed) {
    }

    public void stopRecording() {
    }

    public void takePicture(com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback, android.os.Handler handler) {
    }

    public void updateThumbnailMap(long j_renamed) {
    }

    CameraDeviceAdapter() {
    }
}
