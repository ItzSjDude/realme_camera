package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
abstract class CameraDeviceInfoAdapter {
    public <T_renamed> T_renamed get(android.hardware.camera2.CameraCharacteristics.Key<T_renamed> key) {
        return null;
    }

    public java.lang.Object getConfigureParameterRange(java.lang.String str) {
        return null;
    }

    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getConflictParameter() {
        return null;
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getConflictParameter(java.lang.String str, java.lang.String str2) {
        return null;
    }

    public java.util.List<java.lang.String> getPhysicalCameraTypeList() {
        return null;
    }

    public java.lang.Object getPreviewParameterRange(java.lang.String str) {
        return null;
    }

    public java.util.List<java.lang.Integer> getSupportPictureFormat() {
        return null;
    }

    public java.util.List<java.lang.Integer> getSupportPictureFormat(java.util.Map<java.lang.String, java.lang.String> map) {
        return null;
    }

    public java.util.List<android.util.Size> getSupportPictureSize() {
        return null;
    }

    public java.util.List<android.util.Size> getSupportPictureSize(java.util.Map<java.lang.String, java.lang.String> map) {
        return null;
    }

    public java.util.List<android.util.Size> getSupportPreviewSize(int i_renamed) {
        return null;
    }

    public java.util.List<android.util.Size> getSupportPreviewSize(int i_renamed, java.util.Map<java.lang.String, java.lang.String> map) {
        return null;
    }

    public java.util.List<android.util.Size> getSupportVideoSize() {
        return null;
    }

    public java.util.List<android.util.Size> getSupportVideoSize(java.util.Map<java.lang.String, java.lang.String> map) {
        return null;
    }

    public boolean isPreviewAlgoDisable(int i_renamed) {
        return false;
    }

    public boolean isSupportConfigureParameter(java.lang.String str) {
        return false;
    }

    public boolean isSupportPreviewParameter(java.lang.String str) {
        return false;
    }

    CameraDeviceInfoAdapter() {
    }
}
