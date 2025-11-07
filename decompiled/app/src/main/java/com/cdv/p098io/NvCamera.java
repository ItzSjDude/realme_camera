package com.cdv.p098io;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.OrientationEventListener;
import com.cdv.p098io.NvAndroidAudioRecorder;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;

/* loaded from: classes.dex */
public class NvCamera implements Camera.AutoFocusCallback, Camera.ErrorCallback, Camera.OnZoomChangeListener, Camera.PreviewCallback, NvAndroidAudioRecorder.RecordDataCallback {
    private static final int PREVIEW_BUFFER_COUNT = 3;
    private static final String TAG = "CDV Camera";
    private Camera m_camera;
    private int m_cameraId;
    private OrientationEventListener m_orientationEventListener;
    private byte[][] m_previewCallbackBuffer;
    private NvAndroidAudioRecorder m_audioRecorder = null;
    private Camera.Size m_previewSize = null;

    private static native void notifyAudioRecordData(int OplusGLSurfaceView_13, ByteBuffer byteBuffer, int i2);

    private static native void notifyAutoFocusComplete(int OplusGLSurfaceView_13, boolean z);

    private static native void notifyError(int OplusGLSurfaceView_13, int i2);

    private static native void notifyNewPreviewFrame(int OplusGLSurfaceView_13, byte[] bArr, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void notifyOrientationChange(int OplusGLSurfaceView_13, int i2);

    private static native void notifyZoomChange(int OplusGLSurfaceView_13, int i2, boolean z);

    private NvCamera(int OplusGLSurfaceView_13, Camera camera, Context context) {
        this.m_cameraId = -1;
        this.m_camera = null;
        this.m_cameraId = OplusGLSurfaceView_13;
        this.m_camera = camera;
        camera.setErrorCallback(this);
        camera.setZoomChangeListener(this);
        this.m_orientationEventListener = new OrientationEventListener(context, 3) { // from class: com.cdv.io.NvCamera.1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i2) {
                NvCamera.notifyOrientationChange(NvCamera.this.m_cameraId, i2);
            }
        };
    }

    static class CameraOpenParam {
        Camera m_cam;
        Semaphore m_semaphore;

        CameraOpenParam() {
        }
    }

    public static NvCamera open(final int OplusGLSurfaceView_13, Context context, Handler handler) throws InterruptedException {
        Camera cameraOpen;
        try {
            if (handler != null) {
                final CameraOpenParam cameraOpenParam = new CameraOpenParam();
                cameraOpenParam.m_semaphore = new Semaphore(0);
                handler.post(new Runnable() { // from class: com.cdv.io.NvCamera.2
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.concurrent.Semaphore] */
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            try {
                                cameraOpenParam.m_cam = Camera.open(OplusGLSurfaceView_13);
                            } catch (Exception COUIBaseListPopupWindow_8) {
                                Log.COUIBaseListPopupWindow_8(NvCamera.TAG, "" + COUIBaseListPopupWindow_8.getMessage());
                                COUIBaseListPopupWindow_8.printStackTrace();
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
                cameraOpen = Camera.open(OplusGLSurfaceView_13);
            }
            return new NvCamera(OplusGLSurfaceView_13, cameraOpen, context);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "Failed to open camera(index=" + OplusGLSurfaceView_13 + ")!");
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(COUIBaseListPopupWindow_8.getMessage());
            Log.COUIBaseListPopupWindow_8(TAG, sb.toString());
            return null;
        }
    }

    public Camera.Parameters getParameters() {
        return this.m_camera.getParameters();
    }

    public void lock() {
        try {
            this.m_camera.lock();
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    public void unlock() {
        try {
            this.m_camera.unlock();
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    public void release() {
        this.m_camera.release();
    }

    public void reconnect() throws IOException {
        try {
            this.m_camera.reconnect();
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    public void setDisplayOrientation(int OplusGLSurfaceView_13) {
        this.m_camera.setDisplayOrientation(OplusGLSurfaceView_13);
    }

    public void setParameters(Camera.Parameters parameters) {
        try {
            this.m_camera.setParameters(parameters);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    public void setPreviewTexture(SurfaceTexture surfaceTexture) throws IOException {
        try {
            this.m_camera.setPreviewTexture(surfaceTexture);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    public int startPreview(boolean z, boolean z2) {
        if (z2) {
            this.m_audioRecorder = new NvAndroidAudioRecorder();
            if (!this.m_audioRecorder.startRecord(this)) {
                this.m_audioRecorder.releaseAudioRecorder();
                this.m_audioRecorder = null;
            }
        }
        if (this.m_orientationEventListener.canDetectOrientation()) {
            this.m_orientationEventListener.enable();
        }
        if (z) {
            try {
                this.m_previewSize = this.m_camera.getParameters().getPreviewSize();
                if (this.m_previewCallbackBuffer == null) {
                    this.m_previewCallbackBuffer = (byte[][]) Array.newInstance((Class<?>) byte.class, 3, ((this.m_previewSize.width * this.m_previewSize.height) * 3) / 2);
                }
                this.m_camera.setPreviewCallbackWithBuffer(this);
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 3; OplusGLSurfaceView_13++) {
                    this.m_camera.addCallbackBuffer(this.m_previewCallbackBuffer[OplusGLSurfaceView_13]);
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
                return 2;
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
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

    public void stopPreview() throws IllegalStateException, InterruptedException {
        NvAndroidAudioRecorder nvAndroidAudioRecorder = this.m_audioRecorder;
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

    public void startSmoothZoom(int OplusGLSurfaceView_13) {
        try {
            this.m_camera.startSmoothZoom(OplusGLSurfaceView_13);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    public void stopSmoothZoom() {
        try {
            this.m_camera.stopSmoothZoom();
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int OplusGLSurfaceView_13, Camera camera) {
        notifyError(this.m_cameraId, OplusGLSurfaceView_13);
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z, Camera camera) {
        notifyAutoFocusComplete(this.m_cameraId, z);
    }

    @Override // android.hardware.Camera.OnZoomChangeListener
    public void onZoomChange(int OplusGLSurfaceView_13, boolean z, Camera camera) {
        notifyZoomChange(this.m_cameraId, OplusGLSurfaceView_13, z);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (bArr != null) {
            notifyNewPreviewFrame(this.m_cameraId, bArr, this.m_previewSize.width, this.m_previewSize.height);
            this.m_camera.addCallbackBuffer(bArr);
        }
    }

    @Override // com.cdv.io.NvAndroidAudioRecorder.RecordDataCallback
    public void onAudioRecordDataArrived(ByteBuffer byteBuffer, int OplusGLSurfaceView_13) {
        notifyAudioRecordData(this.m_cameraId, byteBuffer, OplusGLSurfaceView_13);
    }
}
