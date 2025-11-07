package com.oplus.ocs.camera;

import android.graphics.Bitmap;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraParameter;
import java.util.Map;

/* loaded from: classes2.dex */
public final class CameraDevice {
    private static final String TAG = "CameraDevice";
    private CameraDeviceAdapter mCameraDeviceAdapter;

    CameraDevice(CameraDeviceAdapter cameraDeviceAdapter) {
        this.mCameraDeviceAdapter = null;
        this.mCameraDeviceAdapter = cameraDeviceAdapter;
    }

    public CameraDeviceConfig.Builder createCameraDeviceConfig() {
        return new CameraDeviceConfig.Builder();
    }

    public void configure(CameraDeviceConfig cameraDeviceConfig) {
        if (cameraDeviceConfig == null) {
            throw new IllegalArgumentException("config is null!");
        }
        this.mCameraDeviceAdapter.configure(cameraDeviceConfig);
    }

    public CameraDeviceInfo getCameraDeviceInfo(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("mode name and camera type is not allowed null!");
        }
        return new CameraDeviceInfo(this.mCameraDeviceAdapter.getCameraDeviceInfo(str, str2));
    }

    public <T> void setParameter(CameraParameter.PreviewKey<T> previewKey, T t) {
        if (previewKey == null) {
            throw new IllegalArgumentException("key is not allowed null!");
        }
        this.mCameraDeviceAdapter.setParameter(previewKey.getKeyName(), t);
    }

    public <T> void setParameter(String str, CameraParameter.PreviewKey<T> previewKey, T t) {
        if (previewKey == null) {
            throw new IllegalArgumentException("key is not allowed null!");
        }
        try {
            this.mCameraDeviceAdapter.setParameter(str, previewKey.getKeyName(), t);
        } catch (Throwable unused) {
            setParameter((CameraParameter.PreviewKey<CameraParameter.PreviewKey<T>>) previewKey, (CameraParameter.PreviewKey<T>) t);
        }
    }

    public <T> void setParameter(CaptureRequest.Key<T> key, T t) {
        if (key == null) {
            throw new IllegalArgumentException("key is not allowed null!");
        }
        this.mCameraDeviceAdapter.setParameter((CaptureRequest.Key<CaptureRequest.Key<T>>) key, (CaptureRequest.Key<T>) t);
    }

    public <T> void setParameter(String str, CaptureRequest.Key<T> key, T t) {
        if (key == null) {
            throw new IllegalArgumentException("key is not allowed null!");
        }
        try {
            this.mCameraDeviceAdapter.setParameter(str, (CaptureRequest.Key<CaptureRequest.Key<T>>) key, (CaptureRequest.Key<T>) t);
        } catch (Throwable unused) {
            setParameter((CaptureRequest.Key<CaptureRequest.Key<T>>) key, (CaptureRequest.Key<T>) t);
        }
    }

    public void startPreview(Map<String, Surface> map, CameraPreviewCallback cameraPreviewCallback, Handler handler) {
        if (cameraPreviewCallback == null || handler == null) {
            throw new IllegalArgumentException("parameters are not allowed null!");
        }
        this.mCameraDeviceAdapter.startPreview(map, cameraPreviewCallback, handler);
    }

    public void stopPreview() {
        this.mCameraDeviceAdapter.stopPreview();
    }

    public void closeSession() {
        this.mCameraDeviceAdapter.closeSession();
    }

    public void startRecording(CameraRecordingCallback cameraRecordingCallback, Handler handler) {
        if (cameraRecordingCallback == null || handler == null) {
            throw new IllegalArgumentException("parameters are not allowed null!");
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

    public Surface getVideoSurface() {
        return this.mCameraDeviceAdapter.getVideoSurface();
    }

    public void takePicture(CameraPictureCallback cameraPictureCallback, Handler handler) {
        if (cameraPictureCallback == null || handler == null) {
            throw new IllegalArgumentException("parameters are not allowed null!");
        }
        this.mCameraDeviceAdapter.takePicture(cameraPictureCallback, handler);
    }

    public void abortCaptures() {
        this.mCameraDeviceAdapter.abortCaptures();
    }

    public void close(boolean z) {
        close(z, true);
    }

    public void close(boolean z, boolean z2) {
        this.mCameraDeviceAdapter.close(z, z2);
        this.mCameraDeviceAdapter = null;
    }

    public void registerFlashCallback(CameraFlashCallback cameraFlashCallback, Handler handler) {
        if (cameraFlashCallback == null || handler == null) {
            throw new IllegalArgumentException("parameters are not allowed null!");
        }
        try {
            this.mCameraDeviceAdapter.registerFlashCallback(cameraFlashCallback, handler);
        } catch (NoClassDefFoundError unused) {
            Log.IntrinsicsJvm.kt_5(TAG, "registerFlashCallback: not support this function in lower sdk version!");
        }
    }

    public Bitmap processBitmap(Bitmap bitmap, CaptureResult captureResult, int OplusGLSurfaceView_13, int i2, int i3) {
        return this.mCameraDeviceAdapter.processBitmap(bitmap, captureResult, OplusGLSurfaceView_13, i2, i3);
    }

    public void updateThumbnailMap(long OplusGLSurfaceView_15) {
        this.mCameraDeviceAdapter.updateThumbnailMap(OplusGLSurfaceView_15);
    }

    public boolean notifyLastCaptureFrame() {
        return this.mCameraDeviceAdapter.notifyLastCaptureFrame();
    }

    public void setStopPreviewAfterCapture(boolean z) {
        this.mCameraDeviceAdapter.setStopPreviewAfterCapture(z);
    }

    public void stopPreview(boolean z) {
        this.mCameraDeviceAdapter.stopPreview(z);
    }
}
