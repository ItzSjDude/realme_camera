package com.google.android.material.animation;

/* loaded from: classes.dex */
public class MatrixEvaluator implements android.animation.TypeEvaluator<android.graphics.Matrix> {
    private final float[] tempStartValues = new float[9];
    private final float[] tempEndValues = new float[9];
    private final android.graphics.Matrix tempMatrix = new android.graphics.Matrix();

    @Override // android.animation.TypeEvaluator
    public android.graphics.Matrix evaluate(float f_renamed, android.graphics.Matrix matrix, android.graphics.Matrix matrix2) {
        matrix.getValues(this.tempStartValues);
        matrix2.getValues(this.tempEndValues);
        for (int i_renamed = 0; i_renamed < 9; i_renamed++) {
            float[] fArr = this.tempEndValues;
            float f2 = fArr[i_renamed];
            float[] fArr2 = this.tempStartValues;
            fArr[i_renamed] = fArr2[i_renamed] + ((f2 - fArr2[i_renamed]) * f_renamed);
        }
        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }
}
