package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public class CameraDeviceInfo {
    private com.oplus.ocs.camera.CameraDeviceInfoAdapter mCameraDeviceInfoAdapter;

    CameraDeviceInfo(com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter) {
        this.mCameraDeviceInfoAdapter = null;
        this.mCameraDeviceInfoAdapter = cameraDeviceInfoAdapter;
    }

    public java.util.List<java.lang.String> getPhysicalCameraTypeList() {
        com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return cameraDeviceInfoAdapter.getPhysicalCameraTypeList();
        }
        return null;
    }

    @java.lang.Deprecated
    public java.util.List<android.util.Size> getSupportPreviewSize(int i_renamed) {
        com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return cameraDeviceInfoAdapter.getSupportPreviewSize(i_renamed);
        }
        return null;
    }

    public java.util.List<android.util.Size> getSupportPreviewSize(int i_renamed, java.util.Map<java.lang.String, java.lang.String> map) {
        com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter == null) {
            return null;
        }
        try {
            return cameraDeviceInfoAdapter.getSupportPreviewSize(i_renamed, map);
        } catch (java.lang.Throwable unused) {
            return this.mCameraDeviceInfoAdapter.getSupportPreviewSize(i_renamed);
        }
    }

    @java.lang.Deprecated
    public java.util.List<android.util.Size> getSupportPictureSize() {
        com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return cameraDeviceInfoAdapter.getSupportPictureSize();
        }
        return null;
    }

    public java.util.List<android.util.Size> getSupportPictureSize(java.util.Map<java.lang.String, java.lang.String> map) {
        com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter == null) {
            return null;
        }
        try {
            return cameraDeviceInfoAdapter.getSupportPictureSize(map);
        } catch (java.lang.Throwable unused) {
            return this.mCameraDeviceInfoAdapter.getSupportPictureSize();
        }
    }

    @java.lang.Deprecated
    public java.util.List<java.lang.Integer> getSupportPictureFormat() {
        com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return cameraDeviceInfoAdapter.getSupportPictureFormat();
        }
        return null;
    }

    public java.util.List<java.lang.Integer> getSupportPictureFormat(java.util.Map<java.lang.String, java.lang.String> map) {
        com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter == null) {
            return null;
        }
        try {
            return cameraDeviceInfoAdapter.getSupportPictureFormat(map);
        } catch (java.lang.Throwable unused) {
            return this.getSupportPictureFormat();
        }
    }

    @java.lang.Deprecated
    public java.util.List<android.util.Size> getSupportVideoSize() {
        com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return cameraDeviceInfoAdapter.getSupportVideoSize();
        }
        return null;
    }

    public java.util.List<android.util.Size> getSupportVideoSize(java.util.Map<java.lang.String, java.lang.String> map) {
        com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter == null) {
            return null;
        }
        try {
            return cameraDeviceInfoAdapter.getSupportVideoSize(map);
        } catch (java.lang.Throwable unused) {
            return this.mCameraDeviceInfoAdapter.getSupportVideoSize();
        }
    }

    public boolean isSupportConfigureParameter(com.oplus.ocs.camera.CameraParameter.ConfigureKey<?> configureKey) {
        com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return cameraDeviceInfoAdapter.isSupportConfigureParameter(configureKey.getKeyName());
        }
        return false;
    }

    public boolean isSupportPreviewParameter(com.oplus.ocs.camera.CameraParameter.PreviewKey<?> previewKey) {
        com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return cameraDeviceInfoAdapter.isSupportPreviewParameter(previewKey.getKeyName());
        }
        return false;
    }

    public <T_renamed> java.util.List<T_renamed> getConfigureParameterRange(com.oplus.ocs.camera.CameraParameter.ConfigureKey<T_renamed> configureKey) {
        java.lang.Object configureParameterRange;
        com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter == null || (configureParameterRange = cameraDeviceInfoAdapter.getConfigureParameterRange(configureKey.getKeyName())) == null) {
            return null;
        }
        return (java.util.List) configureParameterRange;
    }

    public <T_renamed> java.util.List<T_renamed> getPreviewParameterRange(com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed> previewKey) {
        java.lang.Object previewParameterRange;
        com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter == null || (previewParameterRange = cameraDeviceInfoAdapter.getPreviewParameterRange(previewKey.getKeyName())) == null) {
            return null;
        }
        return (java.util.List) previewParameterRange;
    }

    public <T_renamed> T_renamed get(android.hardware.camera2.CameraCharacteristics.Key<T_renamed> key) {
        com.oplus.ocs.camera.CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return (T_renamed) cameraDeviceInfoAdapter.get(key);
        }
        return null;
    }

    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getConflictParameter() {
        try {
            if (this.mCameraDeviceInfoAdapter != null) {
                return this.mCameraDeviceInfoAdapter.getConflictParameter();
            }
        } catch (java.lang.NoSuchMethodError unused) {
        }
        return null;
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getConflictParameter(java.lang.String str, java.lang.String str2) {
        try {
            if (this.mCameraDeviceInfoAdapter != null) {
                return this.mCameraDeviceInfoAdapter.getConflictParameter(str, str2);
            }
        } catch (java.lang.NoSuchMethodError unused) {
        }
        return null;
    }

    public boolean isPreviewAlgoDisable(int i_renamed) {
        try {
            if (this.mCameraDeviceInfoAdapter != null) {
                return this.mCameraDeviceInfoAdapter.isPreviewAlgoDisable(i_renamed);
            }
            return false;
        } catch (java.lang.NoSuchMethodError unused) {
            return false;
        }
    }
}
