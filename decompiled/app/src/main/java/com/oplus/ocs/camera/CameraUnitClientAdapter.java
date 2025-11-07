package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
class CameraUnitClientAdapter {
    private com.oplus.ocs.camera.appinterface.CameraUnitInterface mCameraUnitInterface;

    CameraUnitClientAdapter() {
        this.mCameraUnitInterface = null;
        this.mCameraUnitInterface = new com.oplus.ocs.camera.CameraUnitImpl();
    }

    public void initialize(android.content.Context context) {
        com.oplus.ocs.camera.appinterface.CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            cameraUnitInterface.initialize(context);
        }
    }

    public boolean isAuthedClient(android.content.Context context) {
        com.oplus.ocs.camera.appinterface.CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            return cameraUnitInterface.isAuthedClient(context);
        }
        return false;
    }

    public void release() {
        com.oplus.ocs.camera.appinterface.CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            cameraUnitInterface.release();
        }
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getAllSupportCameraMode() {
        com.oplus.ocs.camera.appinterface.CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            return cameraUnitInterface.getAllSupportCameraMode();
        }
        return null;
    }

    public java.util.List<java.lang.String> getAllSupportCameraType() {
        com.oplus.ocs.camera.appinterface.CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            return cameraUnitInterface.getAllSupportCameraType();
        }
        return null;
    }

    public void openCamera(java.lang.String str, com.oplus.ocs.camera.CameraStateCallback cameraStateCallback, android.os.Handler handler) {
        com.oplus.ocs.camera.appinterface.CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            cameraUnitInterface.openCamera(str, new com.oplus.ocs.camera.CameraStateCallbackAdapterV2(cameraStateCallback), handler);
        }
    }

    public boolean checkAuthenticationPermission(android.content.Context context, java.lang.String str, int i_renamed) {
        com.oplus.ocs.camera.appinterface.CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            return cameraUnitInterface.checkAuthenticationPermission(context, str, i_renamed);
        }
        return false;
    }

    public com.oplus.ocs.camera.CameraDeviceInfoAdapter getCameraDeviceInfo(java.lang.String str, java.lang.String str2) {
        com.oplus.ocs.camera.appinterface.CameraUnitInterface cameraUnitInterface = this.mCameraUnitInterface;
        if (cameraUnitInterface != null) {
            return new com.oplus.ocs.camera.CameraDeviceInfoAdapterV2(cameraUnitInterface.getCameraDeviceInfo(str, str2));
        }
        return null;
    }
}
