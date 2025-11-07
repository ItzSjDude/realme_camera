package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
class CameraDeviceConfigAdapter {
    private com.oplus.ocs.camera.common.parameter.SdkCameraDeviceConfig.Builder mCameraDeviceConfigBuilder;

    CameraDeviceConfigAdapter() {
        this.mCameraDeviceConfigBuilder = null;
        this.mCameraDeviceConfigBuilder = new com.oplus.ocs.camera.common.parameter.SdkCameraDeviceConfig.Builder();
    }

    public void setMode(java.lang.String str) {
        this.mCameraDeviceConfigBuilder.setModeName(str);
    }

    public void setPreviewConfig(java.util.List<com.oplus.ocs.camera.CameraDeviceConfig.PreviewConfig> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.oplus.ocs.camera.CameraDeviceConfig.PreviewConfig previewConfig : list) {
            arrayList.add(new com.oplus.ocs.camera.common.surface.SurfaceWrapper(previewConfig.getPreviewSurface(), previewConfig.getCameraType(), previewConfig.getPreviewSize(), previewConfig.getFormat(), previewConfig.getSurfaceType()));
        }
        this.mCameraDeviceConfigBuilder.setPreviewSurfaces(arrayList);
    }

    public void setPictureConfig(java.util.List<com.oplus.ocs.camera.CameraDeviceConfig.PictureConfig> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.oplus.ocs.camera.CameraDeviceConfig.PictureConfig pictureConfig : list) {
            arrayList.add(new com.oplus.ocs.camera.common.surface.SurfaceWrapper((android.view.Surface) null, pictureConfig.getCameraType(), pictureConfig.getPictureSize(), pictureConfig.getPictureFormat(), 3));
        }
        this.mCameraDeviceConfigBuilder.setPictureSurfaces(arrayList);
    }

    public void setVideoConfig(com.oplus.ocs.camera.CameraDeviceConfig.VideoConfig videoConfig) {
        if (videoConfig != null) {
            this.mCameraDeviceConfigBuilder.setVideoSurface(new com.oplus.ocs.camera.common.surface.SurfaceWrapper(videoConfig.getVideoSurface(), videoConfig.getCameraType(), videoConfig.getVideoSize(), 0, 4));
        }
    }

    public void setVideoSize(android.util.Size size) {
        this.mCameraDeviceConfigBuilder.setVideoSize(size);
    }

    public <T_renamed> void setParameter(com.oplus.ocs.camera.CameraParameter.ConfigureKey<T_renamed> configureKey, T_renamed t_renamed) {
        this.mCameraDeviceConfigBuilder.setParameter(configureKey.getKeyName(), t_renamed);
    }

    public java.lang.Object build() {
        return this.mCameraDeviceConfigBuilder.build();
    }
}
