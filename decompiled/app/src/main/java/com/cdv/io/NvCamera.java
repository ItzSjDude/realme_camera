package com.cdv.io;

/* loaded from: classes.dex */
public class NvCamera implements android.hardware.Camera.AutoFocusCallback, android.hardware.Camera.ErrorCallback, android.hardware.Camera.OnZoomChangeListener, android.hardware.Camera.PreviewCallback, com.cdv.io.NvAndroidAudioRecorder.RecordDataCallback {
    private static final int PREVIEW_BUFFER_COUNT = 3;
    private static final java.lang.String TAG = "CDV Camera";
    private android.hardware.Camera m_camera;
    private int m_cameraId;
    private android.view.OrientationEventListener m_orientationEventListener;
    private byte[][] m_previewCallbackBuffer;
    private com.cdv.io.NvAndroidAudioRecorder m_audioRecorder = null;
    private android.hardware.Camera.Size m_previewSize = null;

    private static native void notifyAudioRecordData(int i_renamed, java.nio.ByteBuffer byteBuffer, int i2);

    private static native void notifyAutoFocusComplete(int i_renamed, boolean z_renamed);

    private static native void notifyError(int i_renamed, int i2);

    private static native void notifyNewPreviewFrame(int i_renamed, byte[] bArr, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void notifyOrientationChange(int i_renamed, int i2);

    private static native void notifyZoomChange(int i_renamed, int i2, boolean z_renamed);

    private NvCamera(int i_renamed, android.hardware.Camera camera, android.content.Context context) {
        this.m_cameraId = -1;
        this.m_camera = null;
        this.m_cameraId = i_renamed;
        this.m_camera = camera;
        camera.setErrorCallback(this);
        camera.setZoomChangeListener(this);
        this.m_orientationEventListener = new android.view.OrientationEventListener(context, 3) { // from class: com.cdv.io.NvCamera.1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i2) {
                com.cdv.io.NvCamera.notifyOrientationChange(com.cdv.io.NvCamera.this.m_cameraId, i2);
            }
        };
    }

    static class CameraOpenParam {
        android.hardware.Camera m_cam;
        java.util.concurrent.Semaphore m_semaphore;

        CameraOpenParam() {
        }
    }

    public static com.cdv.io.NvCamera open(final int i_renamed, android.content.Context context, android.os.Handler handler) throws java.lang.InterruptedException {
        android.hardware.Camera cameraOpen;
        try {
            if (handler != null) {
                final com.cdv.io.NvCamera.CameraOpenParam cameraOpenParam = new com.cdv.io.NvCamera.CameraOpenParam();
                cameraOpenParam.m_semaphore = new java.util.concurrent.Semaphore(0);
                handler.post(new java.lang.Runnable() { // from class: com.cdv.io.NvCamera.2
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.concurrent.Semaphore] */
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            try {
                                cameraOpenParam.m_cam = android.hardware.Camera.open(i_renamed);
                            } catch (java.lang.Exception e_renamed) {
                                android.util.Log.e_renamed(com.cdv.io.NvCamera.TAG, "" + e_renamed.getMessage());
                                e_renamed.printStackTrace();
                            }
                        } finally {
                            cameraOpenParam.m_semaphore.release();
                        }
                    }
                });
                cameraOpenParam.m_semaphore.acquire();
                if (cameraOpenParam.m_cam == null) {
                    return null;
                }
                cameraOpen = cameraOpenParam.m_cam;
            } else {
                cameraOpen = android.hardware.Camera.open(i_renamed);
            }
            return new com.cdv.io.NvCamera(i_renamed, cameraOpen, context);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "Failed to open camera(index=" + i_renamed + ")!");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("");
            sb.append(e_renamed.getMessage());
            android.util.Log.e_renamed(TAG, sb.toString());
            return null;
        }
    }

    public android.hardware.Camera.Parameters getParameters() {
        return this.m_camera.getParameters();
    }

    public void lock() {
        try {
            this.m_camera.lock();
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
        }
    }

    public void unlock() {
        try {
            this.m_camera.unlock();
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
        }
    }

    public void release() {
        this.m_camera.release();
    }

    public void reconnect() throws java.io.IOException {
        try {
            this.m_camera.reconnect();
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
        }
    }

    public void setDisplayOrientation(int i_renamed) {
        this.m_camera.setDisplayOrientation(i_renamed);
    }

    public void setParameters(android.hardware.Camera.Parameters parameters) {
        try {
            this.m_camera.setParameters(parameters);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
        }
    }

    public void setPreviewTexture(android.graphics.SurfaceTexture surfaceTexture) throws java.io.IOException {
        try {
            this.m_camera.setPreviewTexture(surfaceTexture);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
        }
    }

    public int startPreview(boolean z_renamed, boolean z2) {
        if (z2) {
            this.m_audioRecorder = new com.cdv.io.NvAndroidAudioRecorder();
            if (!this.m_audioRecorder.startRecord(this)) {
                this.m_audioRecorder.releaseAudioRecorder();
                this.m_audioRecorder = null;
            }
        }
        if (this.m_orientationEventListener.canDetectOrientation()) {
            this.m_orientationEventListener.enable();
        }
        if (z_renamed) {
            try {
                this.m_previewSize = this.m_camera.getParameters().getPreviewSize();
                if (this.m_previewCallbackBuffer == null) {
                    this.m_previewCallbackBuffer = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) byte.class, 3, ((this.m_previewSize.width * this.m_previewSize.height) * 3) / 2);
                }
                this.m_camera.setPreviewCallbackWithBuffer(this);
                for (int i_renamed = 0; i_renamed < 3; i_renamed++) {
                    this.m_camera.addCallbackBuffer(this.m_previewCallbackBuffer[i_renamed]);
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
                android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
                return 2;
            }
        }
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            this.m_camera.setDisplayOrientation(0);
        }
        this.m_camera.startPreview();
        if (z2) {
            if (this.m_audioRecorder == null) {
                return 1;
            }
        }
        return 0;
    }

    public void stopPreview() throws java.lang.IllegalStateException, java.lang.InterruptedException {
        com.cdv.io.NvAndroidAudioRecorder nvAndroidAudioRecorder = this.m_audioRecorder;
        if (nvAndroidAudioRecorder != null) {
            nvAndroidAudioRecorder.stopRecord();
            this.m_audioRecorder.releaseAudioRecorder();
            this.m_audioRecorder = null;
        }
        if (this.m_orientationEventListener.canDetectOrientation()) {
            this.m_orientationEventListener.disable();
        }
        this.m_camera.stopPreview();
        this.m_camera.setPreviewCallbackWithBuffer(null);
        this.m_previewCallbackBuffer = null;
    }

    public void autoFocus() {
        this.m_camera.autoFocus(this);
    }

    public void cancelAutoFocus() {
        this.m_camera.cancelAutoFocus();
    }

    public void startSmoothZoom(int i_renamed) {
        try {
            this.m_camera.startSmoothZoom(i_renamed);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
        }
    }

    public void stopSmoothZoom() {
        try {
            this.m_camera.stopSmoothZoom();
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
        }
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i_renamed, android.hardware.Camera camera) {
        notifyError(this.m_cameraId, i_renamed);
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z_renamed, android.hardware.Camera camera) {
        notifyAutoFocusComplete(this.m_cameraId, z_renamed);
    }

    @Override // android.hardware.Camera.OnZoomChangeListener
    public void onZoomChange(int i_renamed, boolean z_renamed, android.hardware.Camera camera) {
        notifyZoomChange(this.m_cameraId, i_renamed, z_renamed);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, android.hardware.Camera camera) {
        if (bArr != null) {
            notifyNewPreviewFrame(this.m_cameraId, bArr, this.m_previewSize.width, this.m_previewSize.height);
            this.m_camera.addCallbackBuffer(bArr);
        }
    }

    @Override // com.cdv.io.NvAndroidAudioRecorder.RecordDataCallback
    public void onAudioRecordDataArrived(java.nio.ByteBuffer byteBuffer, int i_renamed) {
        notifyAudioRecordData(this.m_cameraId, byteBuffer, i_renamed);
    }
}
