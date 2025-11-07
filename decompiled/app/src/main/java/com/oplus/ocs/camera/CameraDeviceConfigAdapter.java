package com.oplus.ocs.camera;

import android.util.Size;
import android.view.Surface;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.common.parameter.SdkCameraDeviceConfig;
import com.oplus.ocs.camera.common.surface.SurfaceWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
class CameraDeviceConfigAdapter {
    private SdkCameraDeviceConfig.Builder mCameraDeviceConfigBuilder;

    CameraDeviceConfigAdapter() {
        this.mCameraDeviceConfigBuilder = null;
        this.mCameraDeviceConfigBuilder = new SdkCameraDeviceConfig.Builder();
    }

    public void setMode(String str) {
        this.mCameraDeviceConfigBuilder.setModeName(str);
    }

    public void setPreviewConfig(List<CameraDeviceConfig.PreviewConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CameraDeviceConfig.PreviewConfig previewConfig : list) {
            arrayList.add(new SurfaceWrapper(previewConfig.getPreviewSurface(), previewConfig.getCameraType(), previewConfig.getPreviewSize(), previewConfig.getFormat(), previewConfig.getSurfaceType()));
        }
        this.mCameraDeviceConfigBuilder.setPreviewSurfaces(arrayList);
    }

    public void setPictureConfig(List<CameraDeviceConfig.PictureConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CameraDeviceConfig.PictureConfig pictureConfig : list) {
            arrayList.add(new SurfaceWrapper((Surface) null, pictureConfig.getCameraType(), pictureConfig.getPictureSize(), pictureConfig.getPictureFormat(), 3));
        }
        this.mCameraDeviceConfigBuilder.setPictureSurfaces(arrayList);
    }

    public void setVideoConfig(CameraDeviceConfig.VideoConfig videoConfig) {
        if (videoConfig != null) {
            this.mCameraDeviceConfigBuilder.setVideoSurface(new SurfaceWrapper(videoConfig.getVideoSurface(), videoConfig.getCameraType(), videoConfig.getVideoSize(), 0, 4));
        }
    }

    public void setVideoSize(Size size) {
        this.mCameraDeviceConfigBuilder.setVideoSize(size);
    }

    public <T> void setParameter(CameraParameter.ConfigureKey<T> configureKey, T t) {
        this.mCameraDeviceConfigBuilder.setParameter(configureKey.getKeyName(), t);
    }

    public Object build() {
        return this.mCameraDeviceConfigBuilder.build();
    }
}
