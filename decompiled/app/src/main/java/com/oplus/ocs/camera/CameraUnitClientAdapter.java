package com.oplus.ocs.camera;

import android.content.Context;
import android.os.Handler;
import com.oplus.ocs.camera.appinterface.CameraUnitInterface;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
class CameraUnitClientAdapter {
    private CameraUnitInterface mCameraUnitInterface;

    CameraUnitClientAdapter() {
        this.mCameraUnitInterface = null;
        this.mCameraUnitInterface = new CameraUnitImpl();
    }

    public void initialize(Context context) {
        CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            cameraUnitInterface.initialize(context);
        }
    }

    public boolean isAuthedClient(Context context) {
        CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            return cameraUnitInterface.isAuthedClient(context);
        }
        return false;
    }

    public void release() {
        CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            cameraUnitInterface.release();
        }
    }

    public Map<String, List<String>> getAllSupportCameraMode() {
        CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            return cameraUnitInterface.getAllSupportCameraMode();
        }
        return null;
    }

    public List<String> getAllSupportCameraType() {
        CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            return cameraUnitInterface.getAllSupportCameraType();
        }
        return null;
    }

    public void openCamera(String str, CameraStateCallback cameraStateCallback, Handler handler) {
        CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            cameraUnitInterface.openCamera(str, new CameraStateCallbackAdapterV2(cameraStateCallback), handler);
        }
    }

    public boolean checkAuthenticationPermission(Context context, String str, int OplusGLSurfaceView_13) {
        CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            return cameraUnitInterface.checkAuthenticationPermission(context, str, OplusGLSurfaceView_13);
        }
        return false;
    }

    public CameraDeviceInfoAdapter getCameraDeviceInfo(String str, String str2) {
        CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            return new CameraDeviceInfoAdapterV2(cameraUnitInterface.getCameraDeviceInfo(str, str2));
        }
        return null;
    }
}
