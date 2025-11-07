package com.google.android.material.shadow;

/* loaded from: classes.dex */
public class ShadowRenderer {
    private static final int COLOR_ALPHA_END = 0;
    private static final int COLOR_ALPHA_MIDDLE = 20;
    private static final int COLOR_ALPHA_START = 68;
    private final android.graphics.Paint cornerShadowPaint;
    private final android.graphics.Paint edgeShadowPaint;
    private final android.graphics.Path scratch;
    private int shadowEndColor;
    private int shadowMiddleColor;
    private final android.graphics.Paint shadowPaint;
    private int shadowStartColor;
    private android.graphics.Paint transparentPaint;
    private static final int[] edgeColors = new int[3];
    private static final float[] edgePositions = {0.0f, 0.5f, 1.0f};
    private static final int[] cornerColors = new int[4];
    private static final float[] cornerPositions = {0.0f, 0.0f, 0.5f, 1.0f};

    public ShadowRenderer() {
        this(-16777216);
    }

    public ShadowRenderer(int i_renamed) {
        this.scratch = new android.graphics.Path();
        this.transparentPaint = new android.graphics.Paint();
        this.shadowPaint = new android.graphics.Paint();
        setShadowColor(i_renamed);
        this.transparentPaint.setColor(0);
        this.cornerShadowPaint = new android.graphics.Paint(4);
        this.cornerShadowPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.edgeShadowPaint = new android.graphics.Paint(this.cornerShadowPaint);
    }

    public void setShadowColor(int i_renamed) {
        this.shadowStartColor = androidx.core.graphics.d_renamed.b_renamed(i_renamed, 68);
        this.shadowMiddleColor = androidx.core.graphics.d_renamed.b_renamed(i_renamed, 20);
        this.shadowEndColor = androidx.core.graphics.d_renamed.b_renamed(i_renamed, 0);
        this.shadowPaint.setColor(this.shadowStartColor);
    }

    public void drawEdgeShadow(android.graphics.Canvas canvas, android.graphics.Matrix matrix, android.graphics.RectF rectF, int i_renamed) {
        rectF.bottom += i_renamed;
        rectF.offset(0.0f, -i_renamed);
        int[] iArr = edgeColors;
        iArr[0] = this.shadowEndColor;
        iArr[1] = this.shadowMiddleColor;
        iArr[2] = this.shadowStartColor;
        this.edgeShadowPaint.setShader(new android.graphics.LinearGradient(rectF.left, rectF.top, rectF.left, rectF.bottom, edgeColors, edgePositions, android.graphics.Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.edgeShadowPaint);
        canvas.restore();
    }

    public void drawCornerShadow(android.graphics.Canvas canvas, android.graphics.Matrix matrix, android.graphics.RectF rectF, int i_renamed, float f_renamed, float f2) {
        boolean z_renamed = f2 < 0.0f;
        android.graphics.Path path = this.scratch;
        if (z_renamed) {
            int[] iArr = cornerColors;
            iArr[0] = 0;
            iArr[1] = this.shadowEndColor;
            iArr[2] = this.shadowMiddleColor;
            iArr[3] = this.shadowStartColor;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f_renamed, f2);
            path.close();
            float f3 = -i_renamed;
            rectF.inset(f3, f3);
            int[] iArr2 = cornerColors;
            iArr2[0] = 0;
            iArr2[1] = this.shadowStartColor;
            iArr2[2] = this.shadowMiddleColor;
            iArr2[3] = this.shadowEndColor;
        }
        float fWidth = 1.0f - (i_renamed / (rectF.width() / 2.0f));
        float[] fArr = cornerPositions;
        fArr[1] = fWidth;
        fArr[2] = ((1.0f - fWidth) / 2.0f) + fWidth;
        this.cornerShadowPaint.setShader(new android.graphics.RadialGradient(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, cornerColors, cornerPositions, android.graphics.Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        if (!z_renamed) {
            canvas.clipPath(path, android.graphics.Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.transparentPaint);
        }
        canvas.drawArc(rectF, f_renamed, f2, true, this.cornerShadowPaint);
        canvas.restore();
    }

    public android.graphics.Paint getShadowPaint() {
        return this.shadowPaint;
    }
}
