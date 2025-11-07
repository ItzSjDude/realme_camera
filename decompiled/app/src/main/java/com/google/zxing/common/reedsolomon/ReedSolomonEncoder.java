package com.google.zxing.common.reedsolomon;

/* loaded from: classes.dex */
public final class ReedSolomonEncoder {
    private final java.util.List<com.google.zxing.common.reedsolomon.GenericGFPoly> cachedGenerators = new java.util.ArrayList();
    private final com.google.zxing.common.reedsolomon.GenericGF field;

    public ReedSolomonEncoder(com.google.zxing.common.reedsolomon.GenericGF genericGF) {
        this.field = genericGF;
        this.cachedGenerators.add(new com.google.zxing.common.reedsolomon.GenericGFPoly(genericGF, new int[]{1}));
    }

    private com.google.zxing.common.reedsolomon.GenericGFPoly buildGenerator(int i_renamed) {
        if (i_renamed >= this.cachedGenerators.size()) {
            java.util.List<com.google.zxing.common.reedsolomon.GenericGFPoly> list = this.cachedGenerators;
            com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPolyMultiply = list.get(list.size() - 1);
            for (int size = this.cachedGenerators.size(); size <= i_renamed; size++) {
                com.google.zxing.common.reedsolomon.GenericGF genericGF = this.field;
                genericGFPolyMultiply = genericGFPolyMultiply.multiply(new com.google.zxing.common.reedsolomon.GenericGFPoly(genericGF, new int[]{1, genericGF.exp((size - 1) + genericGF.getGeneratorBase())}));
                this.cachedGenerators.add(genericGFPolyMultiply);
            }
        }
        return this.cachedGenerators.get(i_renamed);
    }

    public void encode(int[] iArr, int i_renamed) {
        if (i_renamed == 0) {
            throw new java.lang.IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i_renamed;
        if (length <= 0) {
            throw new java.lang.IllegalArgumentException("No data bytes provided");
        }
        com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPolyBuildGenerator = buildGenerator(i_renamed);
        int[] iArr2 = new int[length];
        java.lang.System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] coefficients = new com.google.zxing.common.reedsolomon.GenericGFPoly(this.field, iArr2).multiplyByMonomial(i_renamed, 1).divide(genericGFPolyBuildGenerator)[1].getCoefficients();
        int length2 = i_renamed - coefficients.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        java.lang.System.arraycopy(coefficients, 0, iArr, length + length2, coefficients.length);
    }
}
