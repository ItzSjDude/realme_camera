package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
class CameraDeviceAdapterV2 extends com.oplus.ocs.camera.CameraDeviceAdapter {
    private com.oplus.ocs.camera.appinterface.CameraDeviceInterface mCameraDeviceInterface;

    CameraDeviceAdapterV2(com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface) {
        this.mCameraDeviceInterface = null;
        this.mCameraDeviceInterface = cameraDeviceInterface;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public com.oplus.ocs.camera.CameraDeviceInfoAdapter getCameraDeviceInfo(java.lang.String str, java.lang.String str2) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            return new com.oplus.ocs.camera.CameraDeviceInfoAdapterV2(cameraDeviceInterface.getCameraDeviceInfo(str, str2));
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void configure(com.oplus.ocs.camera.CameraDeviceConfig cameraDeviceConfig) {
        if (this.mCameraDeviceInterface == null || !(cameraDeviceConfig.getConfig() instanceof com.oplus.ocs.camera.common.parameter.SdkCameraDeviceConfig)) {
            return;
        }
        this.mCameraDeviceInterface.configure((com.oplus.ocs.camera.common.parameter.SdkCameraDeviceConfig) cameraDeviceConfig.getConfig());
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void setParameter(java.lang.String str, java.lang.Object obj) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.setParameter(str, obj);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void setParameter(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.setParameter(str, str2, obj);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public <T_renamed> void setParameter(android.hardware.camera2.CaptureRequest.Key<T_renamed> key, T_renamed t_renamed) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.setParameter(key, t_renamed);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public <T_renamed> void setParameter(java.lang.String str, android.hardware.camera2.CaptureRequest.Key<T_renamed> key, T_renamed t_renamed) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.setParameter(str, key, t_renamed);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void startPreview(java.util.Map<java.lang.String, android.view.Surface> map, com.oplus.ocs.camera.CameraPreviewCallback cameraPreviewCallback, android.os.Handler handler) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.startPreview(map, new com.oplus.ocs.camera.CameraPreviewCallbackAdapterV2(cameraPreviewCallback), handler);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void stopPreview() {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.stopPreview();
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void stopPreview(boolean z_renamed) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.stopPreview(z_renamed);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void closeSession() {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.closeSession();
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public android.view.Surface getVideoSurface() {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            return cameraDeviceInterface.getVideoSurface();
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void startRecording(com.oplus.ocs.camera.CameraRecordingCallback cameraRecordingCallback, android.os.Handler handler) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.startRecording(new com.oplus.ocs.camera.CameraRecordingCallbackAdapterV2(cameraRecordingCallback), handler);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void resumeRecording() {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.resumeRecording();
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void pauseRecording() {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.pauseRecording();
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void stopRecording() {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.stopRecording();
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void takePicture(com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback, android.os.Handler handler) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.takePicture(new com.oplus.ocs.camera.CameraPictureCallbackAdapterV2(cameraPictureCallback), handler);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void abortCaptures() {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.abortCaptures();
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void close(boolean z_renamed) {
        close(z_renamed, true);
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void close(boolean z_renamed, boolean z2) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.close(z_renamed, z2);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void registerFlashCallback(com.oplus.ocs.camera.CameraFlashCallback cameraFlashCallback, android.os.Handler handler) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.registerFlashCallback(new com.oplus.ocs.camera.CameraFlashCallbackAdapterV2(cameraFlashCallback), handler);
        }
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public android.graphics.Bitmap processBitmap(android.graphics.Bitmap bitmap, android.hardware.camera2.CaptureResult captureResult, int i_renamed, int i2, int i3) {
        return this.mCameraDeviceInterface.processBitmap(bitmap, captureResult, i_renamed, i2, i3);
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void updateThumbnailMap(long j_renamed) {
        this.mCameraDeviceInterface.updateThumbnailMap(j_renamed);
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public boolean notifyLastCaptureFrame() {
        return this.mCameraDeviceInterface.notifyLastCaptureFrame();
    }

    @Override // com.oplus.ocs.camera.CameraDeviceAdapter
    public void setStopPreviewAfterCapture(boolean z_renamed) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInterface cameraDeviceInterface = this.mCameraDeviceInterface;
        if (cameraDeviceInterface != null) {
            cameraDeviceInterface.setStopPreviewAfterCapture(z_renamed);
        }
    }
}
