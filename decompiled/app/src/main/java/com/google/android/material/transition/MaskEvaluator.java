package com.google.android.material.transition;

/* loaded from: classes.dex */
class MaskEvaluator {
    private final android.graphics.Path path = new android.graphics.Path();
    private final android.graphics.Path startPath = new android.graphics.Path();
    private final android.graphics.Path endPath = new android.graphics.Path();
    private final com.google.android.material.shape.ShapeAppearancePathProvider pathProvider = new com.google.android.material.shape.ShapeAppearancePathProvider();

    MaskEvaluator() {
    }

    void evaluate(float f_renamed, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel2, android.graphics.RectF rectF, android.graphics.RectF rectF2, android.graphics.RectF rectF3, com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds progressThresholds) {
        com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModelLerp = com.google.android.material.transition.TransitionUtils.lerp(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, ((java.lang.Float) androidx.core.g_renamed.f_renamed.a_renamed(java.lang.Float.valueOf(progressThresholds.start))).floatValue(), ((java.lang.Float) androidx.core.g_renamed.f_renamed.a_renamed(java.lang.Float.valueOf(progressThresholds.end))).floatValue(), f_renamed);
        this.pathProvider.calculatePath(shapeAppearanceModelLerp, 1.0f, rectF2, this.startPath);
        this.pathProvider.calculatePath(shapeAppearanceModelLerp, 1.0f, rectF3, this.endPath);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.path.op(this.startPath, this.endPath, android.graphics.Path.Op.UNION);
        }
    }

    void clip(android.graphics.Canvas canvas) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.path);
        } else {
            canvas.clipPath(this.startPath);
            canvas.clipPath(this.endPath, android.graphics.Region.Op.UNION);
        }
    }
}
