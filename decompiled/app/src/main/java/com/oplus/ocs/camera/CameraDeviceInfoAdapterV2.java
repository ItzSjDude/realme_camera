package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
class CameraDeviceInfoAdapterV2 extends com.oplus.ocs.camera.CameraDeviceInfoAdapter {
    private com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface mCameraDeviceInfo;

    CameraDeviceInfoAdapterV2(com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface) {
        this.mCameraDeviceInfo = null;
        this.mCameraDeviceInfo = cameraDeviceInfoInterface;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public java.util.List<java.lang.String> getPhysicalCameraTypeList() {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getPhysicalCameraTypeList();
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public java.util.List<android.util.Size> getSupportPreviewSize(int i_renamed) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportPreviewSize(i_renamed);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public java.util.List<android.util.Size> getSupportPictureSize() {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportPictureSize();
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public java.util.List<java.lang.Integer> getSupportPictureFormat() {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportPictureFormat();
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public java.util.List<android.util.Size> getSupportVideoSize() {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportVideoSize();
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public java.util.List<android.util.Size> getSupportPreviewSize(int i_renamed, java.util.Map<java.lang.String, java.lang.String> map) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportPreviewSize(i_renamed, map);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public java.util.List<android.util.Size> getSupportPictureSize(java.util.Map<java.lang.String, java.lang.String> map) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportPictureSize(map);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public java.util.List<java.lang.Integer> getSupportPictureFormat(java.util.Map<java.lang.String, java.lang.String> map) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportPictureFormat(map);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public java.util.List<android.util.Size> getSupportVideoSize(java.util.Map<java.lang.String, java.lang.String> map) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportVideoSize(map);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public boolean isSupportConfigureParameter(java.lang.String str) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.isSupportConfigureParameter(str);
        }
        return false;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public boolean isSupportPreviewParameter(java.lang.String str) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.isSupportPreviewParameter(str);
        }
        return false;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public java.lang.Object getConfigureParameterRange(java.lang.String str) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getConfigureParameterRange(str);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public java.lang.Object getPreviewParameterRange(java.lang.String str) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getPreviewParameterRange(str);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public <T_renamed> T_renamed get(android.hardware.camera2.CameraCharacteristics.Key<T_renamed> key) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return (T_renamed) cameraDeviceInfoInterface.get(key);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getConflictParameter() {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getConflictParameter();
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getConflictParameter(java.lang.String str, java.lang.String str2) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getConflictParameter(str, str2);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public boolean isPreviewAlgoDisable(int i_renamed) {
        com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.isPreviewAlgoDisable(i_renamed);
        }
        return false;
    }
}
