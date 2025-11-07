package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: TexturePreviewFactory.java */
/* loaded from: classes2.dex */
public class z_renamed {
    public static com.oplus.camera.ui.preview.a_renamed.y_renamed a_renamed(android.content.Context context, int i_renamed) {
        if (i_renamed == 1) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OPLUS_SINGLE_PORTRAIT_SUPPORT)) {
                return new com.oplus.camera.ui.preview.a_renamed.r_renamed(context);
            }
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ARCSOFT_SINGLE_BOKEH_SUPPORT)) {
                return new com.oplus.camera.ui.preview.a_renamed.d_renamed(context);
            }
            return new com.oplus.camera.ui.preview.a_renamed.e_renamed(context);
        }
        if (i_renamed == 2) {
            return new com.oplus.camera.ui.preview.a_renamed.l_renamed(context);
        }
        if (i_renamed == 4) {
            return new com.oplus.camera.ui.preview.a_renamed.h_renamed(context);
        }
        if (i_renamed == 8) {
            return new com.oplus.camera.ui.preview.a_renamed.w_renamed(context);
        }
        if (i_renamed == 16) {
            return new com.oplus.camera.ui.preview.a_renamed.c_renamed(context);
        }
        if (i_renamed == 32) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_NEON_SUPPORT) || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_BLUR_V2_SUPPORT)) {
                return new com.oplus.camera.ui.preview.a_renamed.ad_renamed(context);
            }
            return new com.oplus.camera.ui.preview.a_renamed.ac_renamed(context);
        }
        if (i_renamed == 64) {
            return new com.oplus.camera.ui.preview.a_renamed.x_renamed(context);
        }
        if (i_renamed == 128) {
            return new com.oplus.camera.ui.preview.a_renamed.b_renamed.b_renamed(context);
        }
        if (i_renamed == 256) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_RETENTION_V2_SUPPORT)) {
                return new com.oplus.camera.ui.preview.a_renamed.af_renamed(context);
            }
            return new com.oplus.camera.ui.preview.a_renamed.ae_renamed(context);
        }
        if (i_renamed == 512) {
            return new com.oplus.camera.ui.preview.a_renamed.ab_renamed(context);
        }
        if (i_renamed == 1024) {
            return new com.oplus.camera.ui.preview.a_renamed.a_renamed.a_renamed(context);
        }
        if (i_renamed != 2048) {
            return null;
        }
        return new com.oplus.camera.ui.preview.a_renamed.n_renamed(context);
    }
}
