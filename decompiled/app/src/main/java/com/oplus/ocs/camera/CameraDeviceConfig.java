package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public final class CameraDeviceConfig {
    private java.lang.Object mSdkCameraDeviceConfig;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface CameraSurfaceType {
        public static final int IMAGE_READER = 3;
        public static final int PREVIEW_FRAME = 6;
        public static final int PREVIEW_IMAGE = 5;
        public static final int RECORDING_SURFACE = 4;
        public static final int SURFACE_TEXTURE = 2;
        public static final int SURFACE_VIEW = 1;
    }

    java.lang.Object getConfig() {
        return this.mSdkCameraDeviceConfig;
    }

    private CameraDeviceConfig(java.lang.Object obj) {
        this.mSdkCameraDeviceConfig = null;
        this.mSdkCameraDeviceConfig = obj;
    }

    public static final class Builder {
        private com.oplus.ocs.camera.CameraDeviceConfigAdapter mBuilderAdapter;

        Builder() {
            this.mBuilderAdapter = null;
            this.mBuilderAdapter = new com.oplus.ocs.camera.CameraDeviceConfigAdapter();
        }

        public com.oplus.ocs.camera.CameraDeviceConfig.Builder setMode(java.lang.String str) {
            this.mBuilderAdapter.setMode(str);
            return this;
        }

        public com.oplus.ocs.camera.CameraDeviceConfig.Builder setPreviewConfig(java.util.List<com.oplus.ocs.camera.CameraDeviceConfig.PreviewConfig> list) {
            this.mBuilderAdapter.setPreviewConfig(list);
            return this;
        }

        public com.oplus.ocs.camera.CameraDeviceConfig.Builder setPictureConfig(java.util.List<com.oplus.ocs.camera.CameraDeviceConfig.PictureConfig> list) {
            this.mBuilderAdapter.setPictureConfig(list);
            return this;
        }

        public com.oplus.ocs.camera.CameraDeviceConfig.Builder setVideoConfig(com.oplus.ocs.camera.CameraDeviceConfig.VideoConfig videoConfig) {
            if (videoConfig != null) {
                this.mBuilderAdapter.setVideoConfig(videoConfig);
            }
            return this;
        }

        public com.oplus.ocs.camera.CameraDeviceConfig.Builder setVideoSize(android.util.Size size) {
            this.mBuilderAdapter.setVideoSize(size);
            return this;
        }

        public <T_renamed> com.oplus.ocs.camera.CameraDeviceConfig.Builder setParameter(com.oplus.ocs.camera.CameraParameter.ConfigureKey<T_renamed> configureKey, T_renamed t_renamed) {
            this.mBuilderAdapter.setParameter(configureKey, t_renamed);
            return this;
        }

        public com.oplus.ocs.camera.CameraDeviceConfig build() {
            return new com.oplus.ocs.camera.CameraDeviceConfig(this.mBuilderAdapter.build());
        }
    }

    public static final class PreviewConfig {
        private java.lang.String mCameraType;
        private int mImageFormat;
        private android.util.Size mPreviewSize;
        private android.view.Surface mPreviewSurface;
        private int mSurfaceType;

        public PreviewConfig(java.lang.String str, android.util.Size size, int i_renamed) {
            this.mCameraType = null;
            this.mPreviewSize = null;
            this.mPreviewSurface = null;
            this.mSurfaceType = 0;
            this.mImageFormat = 0;
            this.mCameraType = str;
            this.mPreviewSize = size;
            this.mSurfaceType = i_renamed;
        }

        public PreviewConfig(java.lang.String str, android.view.Surface surface, android.util.Size size, int i_renamed, int i2) {
            this.mCameraType = null;
            this.mPreviewSize = null;
            this.mPreviewSurface = null;
            this.mSurfaceType = 0;
            this.mImageFormat = 0;
            this.mCameraType = str;
            this.mPreviewSurface = surface;
            this.mPreviewSize = size;
            this.mSurfaceType = i_renamed;
            this.mImageFormat = i2;
        }

        public java.lang.String getCameraType() {
            return this.mCameraType;
        }

        public android.util.Size getPreviewSize() {
            return this.mPreviewSize;
        }

        public android.view.Surface getPreviewSurface() {
            return this.mPreviewSurface;
        }

        public int getFormat() {
            return this.mImageFormat;
        }

        public int getSurfaceType() {
            return this.mSurfaceType;
        }
    }

    public static final class PictureConfig {
        private java.lang.String mCameraType;
        private int mPictureFormat;
        private android.util.Size mPictureSize;

        public PictureConfig(java.lang.String str, android.util.Size size, int i_renamed) {
            this.mCameraType = null;
            this.mPictureSize = null;
            this.mPictureFormat = 0;
            this.mCameraType = str;
            this.mPictureSize = size;
            this.mPictureFormat = i_renamed;
        }

        public java.lang.String getCameraType() {
            return this.mCameraType;
        }

        public android.util.Size getPictureSize() {
            return this.mPictureSize;
        }

        public int getPictureFormat() {
            return this.mPictureFormat;
        }
    }

    public static final class VideoConfig {
        private java.lang.String mCameraType;
        private android.util.Size mVideoSize;
        private android.view.Surface mVideoSurface;

        public VideoConfig(java.lang.String str, android.util.Size size, android.view.Surface surface) {
            this.mCameraType = null;
            this.mVideoSize = null;
            this.mVideoSurface = null;
            this.mCameraType = str;
            this.mVideoSize = size;
            this.mVideoSurface = surface;
        }

        public java.lang.String getCameraType() {
            return this.mCameraType;
        }

        public android.util.Size getVideoSize() {
            return this.mVideoSize;
        }

        public android.view.Surface getVideoSurface() {
            return this.mVideoSurface;
        }
    }
}
