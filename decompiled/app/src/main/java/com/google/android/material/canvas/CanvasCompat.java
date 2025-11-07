package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build;

/* loaded from: classes.dex */
public class CanvasCompat {
    private CanvasCompat() {
    }

    public static int saveLayerAlpha(Canvas canvas, RectF rectF, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(rectF, OplusGLSurfaceView_13);
        }
        return canvas.saveLayerAlpha(rectF, OplusGLSurfaceView_13, 31);
    }

    public static int saveLayerAlpha(Canvas canvas, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(COUIBaseListPopupWindow_12, f2, f3, f4, OplusGLSurfaceView_13);
        }
        return canvas.saveLayerAlpha(COUIBaseListPopupWindow_12, f2, f3, f4, OplusGLSurfaceView_13, 31);
    }
}
