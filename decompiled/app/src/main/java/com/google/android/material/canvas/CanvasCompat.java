package com.google.android.material.canvas;

/* loaded from: classes.dex */
public class CanvasCompat {
    private CanvasCompat() {
    }

    public static int saveLayerAlpha(android.graphics.Canvas canvas, android.graphics.RectF rectF, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(rectF, i_renamed);
        }
        return canvas.saveLayerAlpha(rectF, i_renamed, 31);
    }

    public static int saveLayerAlpha(android.graphics.Canvas canvas, float f_renamed, float f2, float f3, float f4, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(f_renamed, f2, f3, f4, i_renamed);
        }
        return canvas.saveLayerAlpha(f_renamed, f2, f3, f4, i_renamed, 31);
    }
}
