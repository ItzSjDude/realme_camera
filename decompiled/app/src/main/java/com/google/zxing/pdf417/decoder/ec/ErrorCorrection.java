package com.google.zxing.pdf417.decoder.ec_renamed;

/* loaded from: classes.dex */
public final class ErrorCorrection {
    private final com.google.zxing.pdf417.decoder.ec_renamed.ModulusGF field = com.google.zxing.pdf417.decoder.ec_renamed.ModulusGF.PDF417_GF;

    public int decode(int[] iArr, int i_renamed, int[] iArr2) throws com.google.zxing.ChecksumException {
        com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly = new com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly(this.field, iArr);
        int[] iArr3 = new int[i_renamed];
        boolean z_renamed = false;
        for (int i2 = i_renamed; i2 > 0; i2--) {
            int iEvaluateAt = modulusPoly.evaluateAt(this.field.exp(i2));
            iArr3[i_renamed - i2] = iEvaluateAt;
            if (iEvaluateAt != 0) {
                z_renamed = true;
            }
        }
        if (!z_renamed) {
            return 0;
        }
        com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly one = this.field.getOne();
        if (iArr2 != null) {
            com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPolyMultiply = one;
            for (int i3 : iArr2) {
                int iExp = this.field.exp((iArr.length - 1) - i3);
                com.google.zxing.pdf417.decoder.ec_renamed.ModulusGF modulusGF = this.field;
                modulusPolyMultiply = modulusPolyMultiply.multiply(new com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly(modulusGF, new int[]{modulusGF.subtract(0, iExp), 1}));
            }
        }
        com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly[] modulusPolyArrRunEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i_renamed, 1), new com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly(this.field, iArr3), i_renamed);
        com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly2 = modulusPolyArrRunEuclideanAlgorithm[0];
        com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly3 = modulusPolyArrRunEuclideanAlgorithm[1];
        int[] iArrFindErrorLocations = findErrorLocations(modulusPoly2);
        int[] iArrFindErrorMagnitudes = findErrorMagnitudes(modulusPoly3, modulusPoly2, iArrFindErrorLocations);
        for (int i4 = 0; i4 < iArrFindErrorLocations.length; i4++) {
            int length = (iArr.length - 1) - this.field.log(iArrFindErrorLocations[i4]);
            if (length < 0) {
                throw com.google.zxing.ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.field.subtract(iArr[length], iArrFindErrorMagnitudes[i4]);
        }
        return iArrFindErrorLocations.length;
    }

    private com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly[] runEuclideanAlgorithm(com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly, com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly2, int i_renamed) throws com.google.zxing.ChecksumException {
        if (modulusPoly.getDegree() < modulusPoly2.getDegree()) {
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly2;
        }
        com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly zero = this.field.getZero();
        com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly one = this.field.getOne();
        while (true) {
            com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly3 = modulusPoly2;
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly3;
            com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly4 = one;
            com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly5 = zero;
            zero = modulusPoly4;
            if (modulusPoly.getDegree() >= i_renamed / 2) {
                if (modulusPoly.isZero()) {
                    throw com.google.zxing.ChecksumException.getChecksumInstance();
                }
                com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly zero2 = this.field.getZero();
                int iInverse = this.field.inverse(modulusPoly.getCoefficient(modulusPoly.getDegree()));
                while (modulusPoly2.getDegree() >= modulusPoly.getDegree() && !modulusPoly2.isZero()) {
                    int degree = modulusPoly2.getDegree() - modulusPoly.getDegree();
                    int iMultiply = this.field.multiply(modulusPoly2.getCoefficient(modulusPoly2.getDegree()), iInverse);
                    zero2 = zero2.add(this.field.buildMonomial(degree, iMultiply));
                    modulusPoly2 = modulusPoly2.subtract(modulusPoly.multiplyByMonomial(degree, iMultiply));
                }
                one = zero2.multiply(zero).subtract(modulusPoly5).negative();
            } else {
                int coefficient = zero.getCoefficient(0);
                if (coefficient == 0) {
                    throw com.google.zxing.ChecksumException.getChecksumInstance();
                }
                int iInverse2 = this.field.inverse(coefficient);
                return new com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly[]{zero.multiply(iInverse2), modulusPoly.multiply(iInverse2)};
            }
        }
    }

    private int[] findErrorLocations(com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly) throws com.google.zxing.ChecksumException {
        int degree = modulusPoly.getDegree();
        int[] iArr = new int[degree];
        int i_renamed = 0;
        for (int i2 = 1; i2 < this.field.getSize() && i_renamed < degree; i2++) {
            if (modulusPoly.evaluateAt(i2) == 0) {
                iArr[i_renamed] = this.field.inverse(i2);
                i_renamed++;
            }
        }
        if (i_renamed == degree) {
            return iArr;
        }
        throw com.google.zxing.ChecksumException.getChecksumInstance();
    }

    private int[] findErrorMagnitudes(com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly, com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly2, int[] iArr) {
        int degree = modulusPoly2.getDegree();
        int[] iArr2 = new int[degree];
        for (int i_renamed = 1; i_renamed <= degree; i_renamed++) {
            iArr2[degree - i_renamed] = this.field.multiply(i_renamed, modulusPoly2.getCoefficient(i_renamed));
        }
        com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly3 = new com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly(this.field, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iInverse = this.field.inverse(iArr[i2]);
            iArr3[i2] = this.field.multiply(this.field.subtract(0, modulusPoly.evaluateAt(iInverse)), this.field.inverse(modulusPoly3.evaluateAt(iInverse)));
        }
        return iArr3;
    }
}
