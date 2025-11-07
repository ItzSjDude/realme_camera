package com.oplus.ocs.camera;

import android.graphics.Bitmap;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Handler;
import android.view.Surface;
import com.oplus.ocs.camera.appinterface.CameraDeviceInterface;
import com.oplus.ocs.camera.common.parameter.SdkCameraDeviceConfig;
import java.util.Map;

/* loaded from: classes2.dex */
class CameraDeviceAdapterV2 extends CameraDeviceAdapter {
    private CameraDeviceInterface mCameraDeviceInterface;

    CameraDeviceAdapterV2(CameraDeviceInterface cameraDeviceInterface) {
        this.mCameraDeviceInterface = null;
        this.mCameraDeviceInterface = cameraDeviceInterface;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public CameraDeviceInfoAdapter getCameraDeviceInfo(String str, String str2) {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            return new CameraDeviceInfoAdapterV2(cameraDeviceInterface.getCameraDeviceInfo(str, str2));
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void configure(CameraDeviceConfig cameraDeviceConfig) {
        if (this.mCameraDeviceInterface == null || !(cameraDeviceConfig.getConfig() instanceof SdkCameraDeviceConfig)) {
            return;
        }
        this.mCameraDeviceInterface.configure((SdkCameraDeviceConfig) cameraDeviceConfig.getConfig());
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void setParameter(String str, Object obj) {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.setParameter(str, obj);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void setParameter(String str, String str2, Object obj) {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.setParameter(str, str2, obj);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public <T> void setParameter(CaptureRequest.Key<T> key, T t) {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.setParameter(key, t);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public <T> void setParameter(String str, CaptureRequest.Key<T> key, T t) {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.setParameter(str, key, t);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void startPreview(Map<String, Surface> map, CameraPreviewCallback cameraPreviewCallback, Handler handler) {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.startPreview(map, new CameraPreviewCallbackAdapterV2(cameraPreviewCallback), handler);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void stopPreview() {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.stopPreview();
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void stopPreview(boolean z) {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.stopPreview(z);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void closeSession() {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.closeSession();
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public Surface getVideoSurface() {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            return cameraDeviceInterface.getVideoSurface();
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void startRecording(CameraRecordingCallback cameraRecordingCallback, Handler handler) {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.startRecording(new CameraRecordingCallbackAdapterV2(cameraRecordingCallback), handler);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void resumeRecording() {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.resumeRecording();
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void pauseRecording() {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.pauseRecording();
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void stopRecording() {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.stopRecording();
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void takePicture(CameraPictureCallback cameraPictureCallback, Handler handler) {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.takePicture(new CameraPictureCallbackAdapterV2(cameraPictureCallback), handler);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void abortCaptures() {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.abortCaptures();
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void close(boolean z) {
        close(z, true);
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void close(boolean z, boolean z2) {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.close(z, z2);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void registerFlashCallback(CameraFlashCallback cameraFlashCallback, Handler handler) {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.registerFlashCallback(new CameraFlashCallbackAdapterV2(cameraFlashCallback), handler);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public Bitmap processBitmap(Bitmap bitmap, CaptureResult captureResult, int OplusGLSurfaceView_13, int i2, int i3) {
        return this.mCameraDeviceInterface.processBitmap(bitmap, captureResult, OplusGLSurfaceView_13, i2, i3);
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void updateThumbnailMap(long OplusGLSurfaceView_15) {
        this.mCameraDeviceInterface.updateThumbnailMap(OplusGLSurfaceView_15);
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public boolean notifyLastCaptureFrame() {
        return this.mCameraDeviceInterface.notifyLastCaptureFrame();
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void setStopPreviewAfterCapture(boolean z) {
        CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.setStopPreviewAfterCapture(z);
        }
    }
}
