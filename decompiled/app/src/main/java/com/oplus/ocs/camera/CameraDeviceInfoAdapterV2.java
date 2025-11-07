package com.oplus.ocs.camera;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import com.oplus.ocs.camera.appinterface.CameraDeviceInfoInterface;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
class CameraDeviceInfoAdapterV2 extends CameraDeviceInfoAdapter {
    private CameraDeviceInfoInterface mCameraDeviceInfo;

    CameraDeviceInfoAdapterV2(CameraDeviceInfoInterface cameraDeviceInfoInterface) {
        this.mCameraDeviceInfo = null;
        this.mCameraDeviceInfo = cameraDeviceInfoInterface;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public List<String> getPhysicalCameraTypeList() {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getPhysicalCameraTypeList();
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public List<Size> getSupportPreviewSize(int OplusGLSurfaceView_13) {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportPreviewSize(OplusGLSurfaceView_13);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public List<Size> getSupportPictureSize() {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportPictureSize();
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public List<Integer> getSupportPictureFormat() {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportPictureFormat();
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public List<Size> getSupportVideoSize() {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportVideoSize();
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public List<Size> getSupportPreviewSize(int OplusGLSurfaceView_13, Map<String, String> map) {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportPreviewSize(OplusGLSurfaceView_13, map);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public List<Size> getSupportPictureSize(Map<String, String> map) {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportPictureSize(map);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public List<Integer> getSupportPictureFormat(Map<String, String> map) {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportPictureFormat(map);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public List<Size> getSupportVideoSize(Map<String, String> map) {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getSupportVideoSize(map);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public boolean isSupportConfigureParameter(String str) {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.isSupportConfigureParameter(str);
        }
        return false;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public boolean isSupportPreviewParameter(String str) {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.isSupportPreviewParameter(str);
        }
        return false;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public Object getConfigureParameterRange(String str) {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getConfigureParameterRange(str);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public Object getPreviewParameterRange(String str) {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getPreviewParameterRange(str);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public <T> T get(CameraCharacteristics.Key<T> key) {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return (T) cameraDeviceInfoInterface.get(key);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public Map<String, List<String>> getConflictParameter() {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getConflictParameter();
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public Map<String, List<String>> getConflictParameter(String str, String str2) {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.getConflictParameter(str, str2);
        }
        return null;
    }

    @Override // com.oplus.ocs.camera.CameraDeviceInfoAdapter
    public boolean isPreviewAlgoDisable(int OplusGLSurfaceView_13) {
        CameraDeviceInfoInterface cameraDeviceInfoInterface = this.mCameraDeviceInfo;
        if (cameraDeviceInfoInterface != null) {
            return cameraDeviceInfoInterface.isPreviewAlgoDisable(OplusGLSurfaceView_13);
        }
        return false;
    }
}
