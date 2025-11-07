package com.google.android.material.textfield;

/* loaded from: classes.dex */
class CutoutDrawable extends com.google.android.material.shape.MaterialShapeDrawable {
    private final android.graphics.RectF cutoutBounds;
    private final android.graphics.Paint cutoutPaint;
    private int savedLayer;

    CutoutDrawable() {
        this(null);
    }

    CutoutDrawable(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        super(shapeAppearanceModel == null ? new com.google.android.material.shape.ShapeAppearanceModel() : shapeAppearanceModel);
        this.cutoutPaint = new android.graphics.Paint(1);
        setPaintStyles();
        this.cutoutBounds = new android.graphics.RectF();
    }

    private void setPaintStyles() {
        this.cutoutPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        this.cutoutPaint.setColor(-1);
        this.cutoutPaint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
    }

    boolean hasCutout() {
        return !this.cutoutBounds.isEmpty();
    }

    void setCutout(float f_renamed, float f2, float f3, float f4) {
        if (f_renamed == this.cutoutBounds.left && f2 == this.cutoutBounds.top && f3 == this.cutoutBounds.right && f4 == this.cutoutBounds.bottom) {
            return;
        }
        this.cutoutBounds.set(f_renamed, f2, f3, f4);
        invalidateSelf();
    }

    void setCutout(android.graphics.RectF rectF) {
        setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        preDraw(canvas);
        super.draw(canvas);
        canvas.drawRect(this.cutoutBounds, this.cutoutPaint);
        postDraw(canvas);
    }

    private void preDraw(android.graphics.Canvas canvas) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (useHardwareLayer(callback)) {
            android.view.View view = (android.view.View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
                return;
            }
            return;
        }
        saveCanvasLayer(canvas);
    }

    private void saveCanvasLayer(android.graphics.Canvas canvas) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            this.savedLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.savedLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    private void postDraw(android.graphics.Canvas canvas) {
        if (useHardwareLayer(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.savedLayer);
    }

    private boolean useHardwareLayer(android.graphics.drawable.Drawable.Callback callback) {
        return callback instanceof android.view.View;
    }
}
