package com.oplus.ocs.camera;

import android.graphics.Bitmap;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Handler;
import android.view.Surface;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class CameraDeviceAdapter {
    public void abortCaptures() {
    }

    public void close(boolean z) {
    }

    public void close(boolean z, boolean z2) {
    }

    public void closeSession() {
    }

    public void configure(CameraDeviceConfig cameraDeviceConfig) {
    }

    public CameraDeviceInfoAdapter getCameraDeviceInfo(String str, String str2) {
        return null;
    }

    public Surface getVideoSurface() {
        return null;
    }

    public boolean notifyLastCaptureFrame() {
        return false;
    }

    public void pauseRecording() {
    }

    public Bitmap processBitmap(Bitmap bitmap, CaptureResult captureResult, int OplusGLSurfaceView_13, int i2, int i3) {
        return null;
    }

    public void registerFlashCallback(CameraFlashCallback cameraFlashCallback, Handler handler) {
    }

    public void resumeRecording() {
    }

    public <T> void setParameter(CaptureRequest.Key<T> key, T t) {
    }

    public <T> void setParameter(String str, CaptureRequest.Key<T> key, T t) {
    }

    public void setParameter(String str, Object obj) {
    }

    public void setParameter(String str, String str2, Object obj) {
    }

    public void setStopPreviewAfterCapture(boolean z) {
    }

    public void startPreview(Map<String, Surface> map, CameraPreviewCallback cameraPreviewCallback, Handler handler) {
    }

    public void startRecording(CameraRecordingCallback cameraRecordingCallback, Handler handler) {
    }

    public void stopPreview() {
    }

    public void stopPreview(boolean z) {
    }

    public void stopRecording() {
    }

    public void takePicture(CameraPictureCallback cameraPictureCallback, Handler handler) {
    }

    public void updateThumbnailMap(long OplusGLSurfaceView_15) {
    }

    CameraDeviceAdapter() {
    }
}
