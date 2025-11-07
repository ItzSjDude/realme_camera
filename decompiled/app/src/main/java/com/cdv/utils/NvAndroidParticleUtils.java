package com.cdv.utils;

/* loaded from: classes.dex */
public class NvAndroidParticleUtils {

    public static class SpriteGenerator {
        private android.graphics.Canvas m_canvas;
        private android.graphics.Paint m_paint;
        private int m_spriteImageSize;

        SpriteGenerator(android.graphics.Bitmap bitmap, int i_renamed) {
            this.m_canvas = new android.graphics.Canvas(bitmap);
            this.m_canvas.drawColor(0, android.graphics.PorterDuff.Mode.SRC);
            this.m_paint = new android.graphics.Paint();
            this.m_paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC));
            this.m_paint.setAntiAlias(false);
            this.m_paint.setFilterBitmap(false);
            this.m_spriteImageSize = i_renamed;
        }

        void drawSpriteImage(int i_renamed, int i2, android.graphics.Bitmap bitmap) {
            if (bitmap == null) {
                return;
            }
            if (bitmap.getWidth() == this.m_spriteImageSize && bitmap.getHeight() == this.m_spriteImageSize) {
                this.m_canvas.drawBitmap(bitmap, i_renamed, i2, this.m_paint);
                return;
            }
            android.graphics.Canvas canvas = this.m_canvas;
            int i3 = this.m_spriteImageSize;
            canvas.drawBitmap(bitmap, (android.graphics.Rect) null, new android.graphics.Rect(i_renamed, i2, i_renamed + i3, i3 + i2), this.m_paint);
        }
    }
}
