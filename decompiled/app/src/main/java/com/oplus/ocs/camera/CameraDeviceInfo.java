package com.oplus.ocs.camera;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import com.oplus.ocs.camera.CameraParameter;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class CameraDeviceInfo {
    private CameraDeviceInfoAdapter mCameraDeviceInfoAdapter;

    CameraDeviceInfo(CameraDeviceInfoAdapter cameraDeviceInfoAdapter) {
        this.mCameraDeviceInfoAdapter = null;
        this.mCameraDeviceInfoAdapter = cameraDeviceInfoAdapter;
    }

    public List<String> getPhysicalCameraTypeList() {
        CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return cameraDeviceInfoAdapter.getPhysicalCameraTypeList();
        }
        return null;
    }

    @Deprecated
    public List<Size> getSupportPreviewSize(int OplusGLSurfaceView_13) {
        CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return cameraDeviceInfoAdapter.getSupportPreviewSize(OplusGLSurfaceView_13);
        }
        return null;
    }

    public List<Size> getSupportPreviewSize(int OplusGLSurfaceView_13, Map<String, String> map) {
        CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter == null) {
            return null;
        }
        try {
            return cameraDeviceInfoAdapter.getSupportPreviewSize(OplusGLSurfaceView_13, map);
        } catch (Throwable unused) {
            return this.mCameraDeviceInfoAdapter.getSupportPreviewSize(OplusGLSurfaceView_13);
        }
    }

    @Deprecated
    public List<Size> getSupportPictureSize() {
        CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return cameraDeviceInfoAdapter.getSupportPictureSize();
        }
        return null;
    }

    public List<Size> getSupportPictureSize(Map<String, String> map) {
        CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter == null) {
            return null;
        }
        try {
            return cameraDeviceInfoAdapter.getSupportPictureSize(map);
        } catch (Throwable unused) {
            return this.mCameraDeviceInfoAdapter.getSupportPictureSize();
        }
    }

    @Deprecated
    public List<Integer> getSupportPictureFormat() {
        CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return cameraDeviceInfoAdapter.getSupportPictureFormat();
        }
        return null;
    }

    public List<Integer> getSupportPictureFormat(Map<String, String> map) {
        CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter == null) {
            return null;
        }
        try {
            return cameraDeviceInfoAdapter.getSupportPictureFormat(map);
        } catch (Throwable unused) {
            return this.getSupportPictureFormat();
        }
    }

    @Deprecated
    public List<Size> getSupportVideoSize() {
        CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return cameraDeviceInfoAdapter.getSupportVideoSize();
        }
        return null;
    }

    public List<Size> getSupportVideoSize(Map<String, String> map) {
        CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter == null) {
            return null;
        }
        try {
            return cameraDeviceInfoAdapter.getSupportVideoSize(map);
        } catch (Throwable unused) {
            return this.mCameraDeviceInfoAdapter.getSupportVideoSize();
        }
    }

    public boolean isSupportConfigureParameter(CameraParameter.ConfigureKey<?> configureKey) {
        CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return cameraDeviceInfoAdapter.isSupportConfigureParameter(configureKey.getKeyName());
        }
        return false;
    }

    public boolean isSupportPreviewParameter(CameraParameter.PreviewKey<?> previewKey) {
        CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return cameraDeviceInfoAdapter.isSupportPreviewParameter(previewKey.getKeyName());
        }
        return false;
    }

    public <T> List<T> getConfigureParameterRange(CameraParameter.ConfigureKey<T> configureKey) {
        Object configureParameterRange;
        CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter == null || (configureParameterRange = cameraDeviceInfoAdapter.getConfigureParameterRange(configureKey.getKeyName())) == null) {
            return null;
        }
        return (List) configureParameterRange;
    }

    public <T> List<T> getPreviewParameterRange(CameraParameter.PreviewKey<T> previewKey) {
        Object previewParameterRange;
        CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter == null || (previewParameterRange = cameraDeviceInfoAdapter.getPreviewParameterRange(previewKey.getKeyName())) == null) {
            return null;
        }
        return (List) previewParameterRange;
    }

    public <T> T get(CameraCharacteristics.Key<T> key) {
        CameraDeviceInfoAdapter cameraDeviceInfoAdapter = this.mCameraDeviceInfoAdapter;
        if (cameraDeviceInfoAdapter != null) {
            return (T) cameraDeviceInfoAdapter.get(key);
        }
        return null;
    }

    @Deprecated
    public Map<String, List<String>> getConflictParameter() {
        try {
            if (this.mCameraDeviceInfoAdapter != null) {
                return this.mCameraDeviceInfoAdapter.getConflictParameter();
            }
        } catch (NoSuchMethodError unused) {
        }
        return null;
    }

    public Map<String, List<String>> getConflictParameter(String str, String str2) {
        try {
            if (this.mCameraDeviceInfoAdapter != null) {
                return this.mCameraDeviceInfoAdapter.getConflictParameter(str, str2);
            }
        } catch (NoSuchMethodError unused) {
        }
        return null;
    }

    public boolean isPreviewAlgoDisable(int OplusGLSurfaceView_13) {
        try {
            if (this.mCameraDeviceInfoAdapter != null) {
                return this.mCameraDeviceInfoAdapter.isPreviewAlgoDisable(OplusGLSurfaceView_13);
            }
            return false;
        } catch (NoSuchMethodError unused) {
            return false;
        }
    }
}
