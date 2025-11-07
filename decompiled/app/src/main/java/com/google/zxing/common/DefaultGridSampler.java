package com.google.zxing.common;

/* loaded from: classes.dex */
public final class DefaultGridSampler extends com.google.zxing.common.GridSampler {
    @Override // com.google.zxing.common.GridSampler
    public com.google.zxing.common.BitMatrix sampleGrid(com.google.zxing.common.BitMatrix bitMatrix, int i_renamed, int i2, float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws com.google.zxing.NotFoundException {
        return sampleGrid(bitMatrix, i_renamed, i2, com.google.zxing.common.PerspectiveTransform.quadrilateralToQuadrilateral(f_renamed, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    @Override // com.google.zxing.common.GridSampler
    public com.google.zxing.common.BitMatrix sampleGrid(com.google.zxing.common.BitMatrix bitMatrix, int i_renamed, int i2, com.google.zxing.common.PerspectiveTransform perspectiveTransform) throws com.google.zxing.NotFoundException {
        if (i_renamed <= 0 || i2 <= 0) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        com.google.zxing.common.BitMatrix bitMatrix2 = new com.google.zxing.common.BitMatrix(i_renamed, i2);
        float[] fArr = new float[i_renamed * 2];
        for (int i3 = 0; i3 < i2; i3++) {
            int length = fArr.length;
            float f_renamed = i3 + 0.5f;
            for (int i4 = 0; i4 < length; i4 += 2) {
                fArr[i4] = (i4 / 2) + 0.5f;
                fArr[i4 + 1] = f_renamed;
            }
            perspectiveTransform.transformPoints(fArr);
            checkAndNudgePoints(bitMatrix, fArr);
            for (int i5 = 0; i5 < length; i5 += 2) {
                try {
                    if (bitMatrix.get((int) fArr[i5], (int) fArr[i5 + 1])) {
                        bitMatrix2.set(i5 / 2, i3);
                    }
                } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                    throw com.google.zxing.NotFoundException.getNotFoundInstance();
                }
            }
        }
        return bitMatrix2;
    }
}
