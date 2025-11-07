package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: classes.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    private final float[] tempStartValues = new float[9];
    private final float[] tempEndValues = new float[9];
    private final Matrix tempMatrix = new Matrix();

    @Override // android.animation.TypeEvaluator
    public Matrix evaluate(float COUIBaseListPopupWindow_12, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.tempStartValues);
        matrix2.getValues(this.tempEndValues);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 9; OplusGLSurfaceView_13++) {
            float[] fArr = this.tempEndValues;
            float f2 = fArr[OplusGLSurfaceView_13];
            float[] fArr2 = this.tempStartValues;
            fArr[OplusGLSurfaceView_13] = fArr2[OplusGLSurfaceView_13] + ((f2 - fArr2[OplusGLSurfaceView_13]) * COUIBaseListPopupWindow_12);
        }
        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }
}
