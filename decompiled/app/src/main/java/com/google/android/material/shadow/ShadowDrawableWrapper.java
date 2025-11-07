package com.google.android.material.shadow;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class ShadowDrawableWrapper extends androidx.appcompat.b_renamed.a_renamed.c_renamed {
    static final double COS_45 = java.lang.Math.cos(java.lang.Math.toRadians(45.0d));
    static final float SHADOW_BOTTOM_SCALE = 1.0f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners;
    final android.graphics.RectF contentBounds;
    float cornerRadius;
    final android.graphics.Paint cornerShadowPaint;
    android.graphics.Path cornerShadowPath;
    private boolean dirty;
    final android.graphics.Paint edgeShadowPaint;
    float maxShadowSize;
    private boolean printedShadowClipWarning;
    float rawMaxShadowSize;
    float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    float shadowSize;
    private final int shadowStartColor;

    @Override // androidx.appcompat.b_renamed.a_renamed.c_renamed, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public ShadowDrawableWrapper(android.content.Context context, android.graphics.drawable.Drawable drawable, float f_renamed, float f2, float f3) {
        super(drawable);
        this.dirty = true;
        this.addPaddingForCorners = true;
        this.printedShadowClipWarning = false;
        this.shadowStartColor = androidx.core.a_renamed.a_renamed.c_renamed(context, com.google.android.material.R_renamed.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = androidx.core.a_renamed.a_renamed.c_renamed(context, com.google.android.material.R_renamed.color.design_fab_shadow_mid_color);
        this.shadowEndColor = androidx.core.a_renamed.a_renamed.c_renamed(context, com.google.android.material.R_renamed.color.design_fab_shadow_end_color);
        this.cornerShadowPaint = new android.graphics.Paint(5);
        this.cornerShadowPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.cornerRadius = java.lang.Math.round(f_renamed);
        this.contentBounds = new android.graphics.RectF();
        this.edgeShadowPaint = new android.graphics.Paint(this.cornerShadowPaint);
        this.edgeShadowPaint.setAntiAlias(false);
        setShadowSize(f2, f3);
    }

    private static int toEven(float f_renamed) {
        int iRound = java.lang.Math.round(f_renamed);
        return iRound % 2 == 1 ? iRound - 1 : iRound;
    }

    public void setAddPaddingForCorners(boolean z_renamed) {
        this.addPaddingForCorners = z_renamed;
        invalidateSelf();
    }

    @Override // androidx.appcompat.b_renamed.a_renamed.c_renamed, android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
        super.setAlpha(i_renamed);
        this.cornerShadowPaint.setAlpha(i_renamed);
        this.edgeShadowPaint.setAlpha(i_renamed);
    }

    @Override // androidx.appcompat.b_renamed.a_renamed.c_renamed, android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        this.dirty = true;
    }

    public void setShadowSize(float f_renamed, float f2) {
        if (f_renamed < 0.0f || f2 < 0.0f) {
            throw new java.lang.IllegalArgumentException("invalid shadow size");
        }
        float even = toEven(f_renamed);
        float even2 = toEven(f2);
        if (even > even2) {
            if (!this.printedShadowClipWarning) {
                this.printedShadowClipWarning = true;
            }
            even = even2;
        }
        if (this.rawShadowSize == even && this.rawMaxShadowSize == even2) {
            return;
        }
        this.rawShadowSize = even;
        this.rawMaxShadowSize = even2;
        this.shadowSize = java.lang.Math.round(even * SHADOW_MULTIPLIER);
        this.maxShadowSize = even2;
        this.dirty = true;
        invalidateSelf();
    }

    public void setShadowSize(float f_renamed) {
        setShadowSize(f_renamed, this.rawMaxShadowSize);
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    @Override // androidx.appcompat.b_renamed.a_renamed.c_renamed, android.graphics.drawable.Drawable
    public boolean getPadding(android.graphics.Rect rect) {
        int iCeil = (int) java.lang.Math.ceil(calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int iCeil2 = (int) java.lang.Math.ceil(calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    public static float calculateVerticalPadding(float f_renamed, float f2, boolean z_renamed) {
        return z_renamed ? (float) ((f_renamed * SHADOW_MULTIPLIER) + ((1.0d - COS_45) * f2)) : f_renamed * SHADOW_MULTIPLIER;
    }

    public static float calculateHorizontalPadding(float f_renamed, float f2, boolean z_renamed) {
        return z_renamed ? (float) (f_renamed + ((1.0d - COS_45) * f2)) : f_renamed;
    }

    public void setCornerRadius(float f_renamed) {
        float fRound = java.lang.Math.round(f_renamed);
        if (this.cornerRadius == fRound) {
            return;
        }
        this.cornerRadius = fRound;
        this.dirty = true;
        invalidateSelf();
    }

    @Override // androidx.appcompat.b_renamed.a_renamed.c_renamed, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (this.dirty) {
            buildComponents(getBounds());
            this.dirty = false;
        }
        drawShadow(canvas);
        super.draw(canvas);
    }

    public final void setRotation(float f_renamed) {
        if (this.rotation != f_renamed) {
            this.rotation = f_renamed;
            invalidateSelf();
        }
    }

    private void drawShadow(android.graphics.Canvas canvas) {
        int i_renamed;
        float f_renamed;
        int i2;
        float f2;
        float f3;
        float f4;
        int iSave = canvas.save();
        canvas.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float f5 = this.cornerRadius;
        float f6 = (-f5) - this.shadowSize;
        float f7 = f5 * 2.0f;
        boolean z_renamed = this.contentBounds.width() - f7 > 0.0f;
        boolean z2 = this.contentBounds.height() - f7 > 0.0f;
        float f8 = this.rawShadowSize;
        float f9 = f8 - (SHADOW_TOP_SCALE * f8);
        float f10 = f5 / ((f8 - (SHADOW_HORIZ_SCALE * f8)) + f5);
        float f11 = f5 / (f9 + f5);
        float f12 = f5 / ((f8 - (f8 * 1.0f)) + f5);
        int iSave2 = canvas.save();
        canvas.translate(this.contentBounds.left + f5, this.contentBounds.top + f5);
        canvas.scale(f10, f11);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z_renamed) {
            canvas.scale(1.0f / f10, 1.0f);
            i_renamed = iSave2;
            f_renamed = f12;
            i2 = iSave;
            f2 = f11;
            canvas.drawRect(0.0f, f6, this.contentBounds.width() - f7, -this.cornerRadius, this.edgeShadowPaint);
        } else {
            i_renamed = iSave2;
            f_renamed = f12;
            i2 = iSave;
            f2 = f11;
        }
        canvas.restoreToCount(i_renamed);
        int iSave3 = canvas.save();
        canvas.translate(this.contentBounds.right - f5, this.contentBounds.bottom - f5);
        float f13 = f_renamed;
        canvas.scale(f10, f13);
        canvas.rotate(180.0f);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z_renamed) {
            canvas.scale(1.0f / f10, 1.0f);
            f3 = f2;
            f4 = f13;
            canvas.drawRect(0.0f, f6, this.contentBounds.width() - f7, (-this.cornerRadius) + this.shadowSize, this.edgeShadowPaint);
        } else {
            f3 = f2;
            f4 = f13;
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        canvas.translate(this.contentBounds.left + f5, this.contentBounds.bottom - f5);
        canvas.scale(f10, f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z2) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f6, this.contentBounds.height() - f7, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas.restoreToCount(iSave4);
        int iSave5 = canvas.save();
        canvas.translate(this.contentBounds.right - f5, this.contentBounds.top + f5);
        float f14 = f3;
        canvas.scale(f10, f14);
        canvas.rotate(90.0f);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z2) {
            canvas.scale(1.0f / f14, 1.0f);
            canvas.drawRect(0.0f, f6, this.contentBounds.height() - f7, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas.restoreToCount(iSave5);
        canvas.restoreToCount(i2);
    }

    private void buildShadowCorners() {
        float f_renamed = this.cornerRadius;
        android.graphics.RectF rectF = new android.graphics.RectF(-f_renamed, -f_renamed, f_renamed, f_renamed);
        android.graphics.RectF rectF2 = new android.graphics.RectF(rectF);
        float f2 = this.shadowSize;
        rectF2.inset(-f2, -f2);
        android.graphics.Path path = this.cornerShadowPath;
        if (path == null) {
            this.cornerShadowPath = new android.graphics.Path();
        } else {
            path.reset();
        }
        this.cornerShadowPath.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
        this.cornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.cornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.cornerShadowPath.close();
        float f3 = -rectF2.top;
        if (f3 > 0.0f) {
            float f4 = this.cornerRadius / f3;
            this.cornerShadowPaint.setShader(new android.graphics.RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, f4, ((1.0f - f4) / 2.0f) + f4, 1.0f}, android.graphics.Shader.TileMode.CLAMP));
        }
        this.edgeShadowPaint.setShader(new android.graphics.LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, SHADOW_HORIZ_SCALE, 1.0f}, android.graphics.Shader.TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
    }

    private void buildComponents(android.graphics.Rect rect) {
        float f_renamed = this.rawMaxShadowSize * SHADOW_MULTIPLIER;
        this.contentBounds.set(rect.left + this.rawMaxShadowSize, rect.top + f_renamed, rect.right - this.rawMaxShadowSize, rect.bottom - f_renamed);
        getWrappedDrawable().setBounds((int) this.contentBounds.left, (int) this.contentBounds.top, (int) this.contentBounds.right, (int) this.contentBounds.bottom);
        buildShadowCorners();
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public void setMaxShadowSize(float f_renamed) {
        setShadowSize(this.rawShadowSize, f_renamed);
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinWidth() {
        float f_renamed = this.rawMaxShadowSize;
        return (java.lang.Math.max(f_renamed, this.cornerRadius + (f_renamed / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 2.0f);
    }

    public float getMinHeight() {
        float f_renamed = this.rawMaxShadowSize;
        return (java.lang.Math.max(f_renamed, this.cornerRadius + ((f_renamed * SHADOW_MULTIPLIER) / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * SHADOW_MULTIPLIER * 2.0f);
    }
}
