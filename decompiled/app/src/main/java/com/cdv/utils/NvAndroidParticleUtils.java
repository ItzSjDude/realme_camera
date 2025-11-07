package com.cdv.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

/* loaded from: classes.dex */
public class NvAndroidParticleUtils {

    public static class SpriteGenerator {
        private Canvas m_canvas;
        private Paint m_paint;
        private int m_spriteImageSize;

        SpriteGenerator(Bitmap bitmap, int OplusGLSurfaceView_13) {
            this.m_canvas = new Canvas(bitmap);
            this.m_canvas.drawColor(0, PorterDuff.Mode.SRC);
            this.m_paint = new Paint();
            this.m_paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            this.m_paint.setAntiAlias(false);
            this.m_paint.setFilterBitmap(false);
            this.m_spriteImageSize = OplusGLSurfaceView_13;
        }

        void drawSpriteImage(int OplusGLSurfaceView_13, int i2, Bitmap bitmap) {
            if (bitmap == null) {
                return;
            }
            if (bitmap.getWidth() == this.m_spriteImageSize && bitmap.getHeight() == this.m_spriteImageSize) {
                this.m_canvas.drawBitmap(bitmap, OplusGLSurfaceView_13, i2, this.m_paint);
                return;
            }
            Canvas canvas = this.m_canvas;
            int i3 = this.m_spriteImageSize;
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13 + i3, i3 + i2), this.m_paint);
        }
    }
}
