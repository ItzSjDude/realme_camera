package com.oplus.camera.p172ui;

import android.content.Context;
import android.content.res.Resources;
import com.oplus.camera.R;

/* compiled from: CameraUIAttributes.java */
/* renamed from: com.oplus.camera.ui.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class CameraUIAttributes {
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m18766a(Context context, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        int color = context.getResources().getColor(R.color.plugin_background_15_percent_transparency_color);
        if (OplusGLSurfaceView_13 == 0) {
            return context.getResources().getColor(R.color.plugin_background_15_percent_transparency_color);
        }
        if (OplusGLSurfaceView_13 == 1) {
            return context.getResources().getColor(R.color.plugin_background_30_percent_transparency_color);
        }
        if (OplusGLSurfaceView_13 != 2) {
            return OplusGLSurfaceView_13 != 3 ? color : context.getResources().getColor(R.color.plugin_background_color_full);
        }
        return context.getResources().getColor(R.color.plugin_background_50_percent_transparency_color);
    }
}
