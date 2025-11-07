package com.oplus.ocs.camera;

import android.util.Size;
import android.view.Surface;
import com.oplus.ocs.camera.CameraParameter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes2.dex */
public final class CameraDeviceConfig {
    private Object mSdkCameraDeviceConfig;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CameraSurfaceType {
        public static final int IMAGE_READER = 3;
        public static final int PREVIEW_FRAME = 6;
        public static final int PREVIEW_IMAGE = 5;
        public static final int RECORDING_SURFACE = 4;
        public static final int SURFACE_TEXTURE = 2;
        public static final int SURFACE_VIEW = 1;
    }

    Object getConfig() {
        return this.mSdkCameraDeviceConfig;
    }

    private CameraDeviceConfig(Object obj) {
        this.mSdkCameraDeviceConfig = null;
        this.mSdkCameraDeviceConfig = obj;
    }

    public static final class Builder {
        private CameraDeviceConfigAdapter mBuilderAdapter;

        Builder() {
            this.mBuilderAdapter = null;
            this.mBuilderAdapter = new CameraDeviceConfigAdapter();
        }

        public Builder setMode(String str) {
            this.mBuilderAdapter.setMode(str);
            return this;
        }

        public Builder setPreviewConfig(List<PreviewConfig> list) {
            this.mBuilderAdapter.setPreviewConfig(list);
            return this;
        }

        public Builder setPictureConfig(List<PictureConfig> list) {
            this.mBuilderAdapter.setPictureConfig(list);
            return this;
        }

        public Builder setVideoConfig(VideoConfig videoConfig) {
            if (videoConfig != null) {
                this.mBuilderAdapter.setVideoConfig(videoConfig);
            }
            return this;
        }

        public Builder setVideoSize(Size size) {
            this.mBuilderAdapter.setVideoSize(size);
            return this;
        }

        public <T> Builder setParameter(CameraParameter.ConfigureKey<T> configureKey, T t) {
            this.mBuilderAdapter.setParameter(configureKey, t);
            return this;
        }

        public CameraDeviceConfig build() {
            return new CameraDeviceConfig(this.mBuilderAdapter.build());
        }
    }

    public static final class PreviewConfig {
        private String mCameraType;
        private int mImageFormat;
        private Size mPreviewSize;
        private Surface mPreviewSurface;
        private int mSurfaceType;

        public PreviewConfig(String str, Size size, int OplusGLSurfaceView_13) {
            this.mCameraType = null;
            this.mPreviewSize = null;
            this.mPreviewSurface = null;
            this.mSurfaceType = 0;
            this.mImageFormat = 0;
            this.mCameraType = str;
            this.mPreviewSize = size;
            this.mSurfaceType = OplusGLSurfaceView_13;
        }

        public PreviewConfig(String str, Surface surface, Size size, int OplusGLSurfaceView_13, int i2) {
            this.mCameraType = null;
            this.mPreviewSize = null;
            this.mPreviewSurface = null;
            this.mSurfaceType = 0;
            this.mImageFormat = 0;
            this.mCameraType = str;
            this.mPreviewSurface = surface;
            this.mPreviewSize = size;
            this.mSurfaceType = OplusGLSurfaceView_13;
            this.mImageFormat = i2;
        }

        public String getCameraType() {
            return this.mCameraType;
        }

        public Size getPreviewSize() {
            return this.mPreviewSize;
        }

        public Surface getPreviewSurface() {
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
        private String mCameraType;
        private int mPictureFormat;
        private Size mPictureSize;

        public PictureConfig(String str, Size size, int OplusGLSurfaceView_13) {
            this.mCameraType = null;
            this.mPictureSize = null;
            this.mPictureFormat = 0;
            this.mCameraType = str;
            this.mPictureSize = size;
            this.mPictureFormat = OplusGLSurfaceView_13;
        }

        public String getCameraType() {
            return this.mCameraType;
        }

        public Size getPictureSize() {
            return this.mPictureSize;
        }

        public int getPictureFormat() {
            return this.mPictureFormat;
        }
    }

    public static final class VideoConfig {
        private String mCameraType;
        private Size mVideoSize;
        private Surface mVideoSurface;

        public VideoConfig(String str, Size size, Surface surface) {
            this.mCameraType = null;
            this.mVideoSize = null;
            this.mVideoSurface = null;
            this.mCameraType = str;
            this.mVideoSize = size;
            this.mVideoSurface = surface;
        }

        public String getCameraType() {
            return this.mCameraType;
        }

        public Size getVideoSize() {
            return this.mVideoSize;
        }

        public Surface getVideoSurface() {
            return this.mVideoSurface;
        }
    }
}
