package com.google.zxing.common.reedsolomon;

/* loaded from: classes.dex */
public final class ReedSolomonDecoder {
    private final com.google.zxing.common.reedsolomon.GenericGF field;

    public ReedSolomonDecoder(com.google.zxing.common.reedsolomon.GenericGF genericGF) {
        this.field = genericGF;
    }

    public void decode(int[] iArr, int i_renamed) throws com.google.zxing.common.reedsolomon.ReedSolomonException {
        com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPoly = new com.google.zxing.common.reedsolomon.GenericGFPoly(this.field, iArr);
        int[] iArr2 = new int[i_renamed];
        boolean z_renamed = true;
        for (int i2 = 0; i2 < i_renamed; i2++) {
            com.google.zxing.common.reedsolomon.GenericGF genericGF = this.field;
            int iEvaluateAt = genericGFPoly.evaluateAt(genericGF.exp(genericGF.getGeneratorBase() + i2));
            iArr2[(i_renamed - 1) - i2] = iEvaluateAt;
            if (iEvaluateAt != 0) {
                z_renamed = false;
            }
        }
        if (z_renamed) {
            return;
        }
        com.google.zxing.common.reedsolomon.GenericGFPoly[] genericGFPolyArrRunEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i_renamed, 1), new com.google.zxing.common.reedsolomon.GenericGFPoly(this.field, iArr2), i_renamed);
        com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPoly2 = genericGFPolyArrRunEuclideanAlgorithm[0];
        com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPoly3 = genericGFPolyArrRunEuclideanAlgorithm[1];
        int[] iArrFindErrorLocations = findErrorLocations(genericGFPoly2);
        int[] iArrFindErrorMagnitudes = findErrorMagnitudes(genericGFPoly3, iArrFindErrorLocations);
        for (int i3 = 0; i3 < iArrFindErrorLocations.length; i3++) {
            int length = (iArr.length - 1) - this.field.log(iArrFindErrorLocations[i3]);
            if (length < 0) {
                throw new com.google.zxing.common.reedsolomon.ReedSolomonException("Bad error location");
            }
            iArr[length] = com.google.zxing.common.reedsolomon.GenericGF.addOrSubtract(iArr[length], iArrFindErrorMagnitudes[i3]);
        }
    }

    private com.google.zxing.common.reedsolomon.GenericGFPoly[] runEuclideanAlgorithm(com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPoly, com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPoly2, int i_renamed) throws com.google.zxing.common.reedsolomon.ReedSolomonException {
        if (genericGFPoly.getDegree() < genericGFPoly2.getDegree()) {
            genericGFPoly2 = genericGFPoly;
            genericGFPoly = genericGFPoly2;
        }
        com.google.zxing.common.reedsolomon.GenericGFPoly zero = this.field.getZero();
        com.google.zxing.common.reedsolomon.GenericGFPoly one = this.field.getOne();
        do {
            com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPoly3 = genericGFPoly2;
            genericGFPoly2 = genericGFPoly;
            genericGFPoly = genericGFPoly3;
            com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPoly4 = one;
            com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPoly5 = zero;
            zero = genericGFPoly4;
            if (genericGFPoly.getDegree() >= i_renamed / 2) {
                if (genericGFPoly.isZero()) {
                    throw new com.google.zxing.common.reedsolomon.ReedSolomonException("r_{i_renamed-1} was zero");
                }
                com.google.zxing.common.reedsolomon.GenericGFPoly zero2 = this.field.getZero();
                int iInverse = this.field.inverse(genericGFPoly.getCoefficient(genericGFPoly.getDegree()));
                while (genericGFPoly2.getDegree() >= genericGFPoly.getDegree() && !genericGFPoly2.isZero()) {
                    int degree = genericGFPoly2.getDegree() - genericGFPoly.getDegree();
                    int iMultiply = this.field.multiply(genericGFPoly2.getCoefficient(genericGFPoly2.getDegree()), iInverse);
                    zero2 = zero2.addOrSubtract(this.field.buildMonomial(degree, iMultiply));
                    genericGFPoly2 = genericGFPoly2.addOrSubtract(genericGFPoly.multiplyByMonomial(degree, iMultiply));
                }
                one = zero2.multiply(zero).addOrSubtract(genericGFPoly5);
            } else {
                int coefficient = zero.getCoefficient(0);
                if (coefficient == 0) {
                    throw new com.google.zxing.common.reedsolomon.ReedSolomonException("sigmaTilde(0) was zero");
                }
                int iInverse2 = this.field.inverse(coefficient);
                return new com.google.zxing.common.reedsolomon.GenericGFPoly[]{zero.multiply(iInverse2), genericGFPoly.multiply(iInverse2)};
            }
        } while (genericGFPoly2.getDegree() < genericGFPoly.getDegree());
        throw new java.lang.IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    private int[] findErrorLocations(com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPoly) throws com.google.zxing.common.reedsolomon.ReedSolomonException {
        int degree = genericGFPoly.getDegree();
        int i_renamed = 0;
        if (degree == 1) {
            return new int[]{genericGFPoly.getCoefficient(1)};
        }
        int[] iArr = new int[degree];
        for (int i2 = 1; i2 < this.field.getSize() && i_renamed < degree; i2++) {
            if (genericGFPoly.evaluateAt(i2) == 0) {
                iArr[i_renamed] = this.field.inverse(i2);
                i_renamed++;
            }
        }
        if (i_renamed == degree) {
            return iArr;
        }
        throw new com.google.zxing.common.reedsolomon.ReedSolomonException("Error locator degree does not match number of_renamed roots");
    }

    private int[] findErrorMagnitudes(com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPoly, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            int iInverse = this.field.inverse(iArr[i_renamed]);
            int iMultiply = 1;
            for (int i2 = 0; i2 < length; i2++) {
                if (i_renamed != i2) {
                    int iMultiply2 = this.field.multiply(iArr[i2], iInverse);
                    iMultiply = this.field.multiply(iMultiply, (iMultiply2 & 1) == 0 ? iMultiply2 | 1 : iMultiply2 & (-2));
                }
            }
            iArr2[i_renamed] = this.field.multiply(genericGFPoly.evaluateAt(iInverse), this.field.inverse(iMultiply));
            if (this.field.getGeneratorBase() != 0) {
                iArr2[i_renamed] = this.field.multiply(iArr2[i_renamed], iInverse);
            }
        }
        return iArr2;
    }
}
