package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p172ui.preview.p177a.p178a.DoubleExposureTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.p179b.VideoWatermarkTexturePreview;

/* compiled from: TexturePreviewFactory.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.z */
/* loaded from: classes2.dex */
public class TexturePreviewFactory {
    /* renamed from: PlatformImplementations.kt_3 */
    public static TexturePreview m22968a(Context context, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_OPLUS_SINGLE_PORTRAIT_SUPPORT)) {
                return new OplusBlurTexturePreview(context);
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ARCSOFT_SINGLE_BOKEH_SUPPORT)) {
                return new ArcsoftBlurTexturePreview(context);
            }
            return new BlurTexturePreview(context);
        }
        if (OplusGLSurfaceView_13 == 2) {
            return new FilterTexturePreview(context);
        }
        if (OplusGLSurfaceView_13 == 4) {
            return new FaceSlenderTexturePreview(context);
        }
        if (OplusGLSurfaceView_13 == 8) {
            return new StickerTexturePreview(context);
        }
        if (OplusGLSurfaceView_13 == 16) {
            return new AnimojiTexturePreview(context);
        }
        if (OplusGLSurfaceView_13 == 32) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_NEON_SUPPORT) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_BLUR_V2_SUPPORT)) {
                return new VideoFusionTexturePreview(context);
            }
            return new VideoBlurTexturePreview(context);
        }
        if (OplusGLSurfaceView_13 == 64) {
            return new SuperTextTexturePreview(context);
        }
        if (OplusGLSurfaceView_13 == 128) {
            return new VideoWatermarkTexturePreview(context);
        }
        if (OplusGLSurfaceView_13 == 256) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_RETENTION_V2_SUPPORT)) {
                return new VideoRetentionV2TexturePreview(context);
            }
            return new VideoRetentionTexturePreview(context);
        }
        if (OplusGLSurfaceView_13 == 512) {
            return new TiltShiftTexturePreview(context);
        }
        if (OplusGLSurfaceView_13 == 1024) {
            return new DoubleExposureTexturePreview(context);
        }
        if (OplusGLSurfaceView_13 != 2048) {
            return null;
        }
        return new FishEyeTexturePreview(context);
    }
}
