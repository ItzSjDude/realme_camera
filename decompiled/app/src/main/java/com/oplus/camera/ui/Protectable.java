package com.oplus.camera.ui;

/* compiled from: CameraUIAttributes.java */
/* loaded from: classes2.dex */
public class c_renamed {
    public static int a_renamed(android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        int color = context.getResources().getColor(com.oplus.camera.R_renamed.color.plugin_background_15_percent_transparency_color);
        if (i_renamed == 0) {
            return context.getResources().getColor(com.oplus.camera.R_renamed.color.plugin_background_15_percent_transparency_color);
        }
        if (i_renamed == 1) {
            return context.getResources().getColor(com.oplus.camera.R_renamed.color.plugin_background_30_percent_transparency_color);
        }
        if (i_renamed != 2) {
            return i_renamed != 3 ? color : context.getResources().getColor(com.oplus.camera.R_renamed.color.plugin_background_color_full);
        }
        return context.getResources().getColor(com.oplus.camera.R_renamed.color.plugin_background_50_percent_transparency_color);
    }
}
