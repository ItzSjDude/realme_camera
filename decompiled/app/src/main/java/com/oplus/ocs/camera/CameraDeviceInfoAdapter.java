package com.oplus.ocs.camera;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class CameraDeviceInfoAdapter {
    public <T> T get(CameraCharacteristics.Key<T> key) {
        return null;
    }

    public Object getConfigureParameterRange(String str) {
        return null;
    }

    @Deprecated
    public Map<String, List<String>> getConflictParameter() {
        return null;
    }

    public Map<String, List<String>> getConflictParameter(String str, String str2) {
        return null;
    }

    public List<String> getPhysicalCameraTypeList() {
        return null;
    }

    public Object getPreviewParameterRange(String str) {
        return null;
    }

    public List<Integer> getSupportPictureFormat() {
        return null;
    }

    public List<Integer> getSupportPictureFormat(Map<String, String> map) {
        return null;
    }

    public List<Size> getSupportPictureSize() {
        return null;
    }

    public List<Size> getSupportPictureSize(Map<String, String> map) {
        return null;
    }

    public List<Size> getSupportPreviewSize(int OplusGLSurfaceView_13) {
        return null;
    }

    public List<Size> getSupportPreviewSize(int OplusGLSurfaceView_13, Map<String, String> map) {
        return null;
    }

    public List<Size> getSupportVideoSize() {
        return null;
    }

    public List<Size> getSupportVideoSize(Map<String, String> map) {
        return null;
    }

    public boolean isPreviewAlgoDisable(int OplusGLSurfaceView_13) {
        return false;
    }

    public boolean isSupportConfigureParameter(String str) {
        return false;
    }

    public boolean isSupportPreviewParameter(String str) {
        return false;
    }

    CameraDeviceInfoAdapter() {
    }
}
