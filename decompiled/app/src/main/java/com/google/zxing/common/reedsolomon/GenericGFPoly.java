package com.google.zxing.common.reedsolomon;

/* loaded from: classes.dex */
final class GenericGFPoly {
    private final int[] coefficients;
    private final com.google.zxing.common.reedsolomon.GenericGF field;

    GenericGFPoly(com.google.zxing.common.reedsolomon.GenericGF genericGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.field = genericGF;
        int length = iArr.length;
        if (length > 1 && iArr[0] == 0) {
            int i_renamed = 1;
            while (i_renamed < length && iArr[i_renamed] == 0) {
                i_renamed++;
            }
            if (i_renamed == length) {
                this.coefficients = new int[]{0};
                return;
            }
            this.coefficients = new int[length - i_renamed];
            int[] iArr2 = this.coefficients;
            java.lang.System.arraycopy(iArr, i_renamed, iArr2, 0, iArr2.length);
            return;
        }
        this.coefficients = iArr;
    }

    int[] getCoefficients() {
        return this.coefficients;
    }

    int getDegree() {
        return this.coefficients.length - 1;
    }

    boolean isZero() {
        return this.coefficients[0] == 0;
    }

    int getCoefficient(int i_renamed) {
        return this.coefficients[(r1.length - 1) - i_renamed];
    }

    int evaluateAt(int i_renamed) {
        if (i_renamed == 0) {
            return getCoefficient(0);
        }
        if (i_renamed == 1) {
            int iAddOrSubtract = 0;
            for (int i2 : this.coefficients) {
                iAddOrSubtract = com.google.zxing.common.reedsolomon.GenericGF.addOrSubtract(iAddOrSubtract, i2);
            }
            return iAddOrSubtract;
        }
        int[] iArr = this.coefficients;
        int iAddOrSubtract2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            iAddOrSubtract2 = com.google.zxing.common.reedsolomon.GenericGF.addOrSubtract(this.field.multiply(i_renamed, iAddOrSubtract2), this.coefficients[i3]);
        }
        return iAddOrSubtract2;
    }

    com.google.zxing.common.reedsolomon.GenericGFPoly addOrSubtract(com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new java.lang.IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (isZero()) {
            return genericGFPoly;
        }
        if (genericGFPoly.isZero()) {
            return this;
        }
        int[] iArr = this.coefficients;
        int[] iArr2 = genericGFPoly.coefficients;
        if (iArr.length > iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr2.length];
        int length = iArr2.length - iArr.length;
        java.lang.System.arraycopy(iArr2, 0, iArr3, 0, length);
        for (int i_renamed = length; i_renamed < iArr2.length; i_renamed++) {
            iArr3[i_renamed] = com.google.zxing.common.reedsolomon.GenericGF.addOrSubtract(iArr[i_renamed - length], iArr2[i_renamed]);
        }
        return new com.google.zxing.common.reedsolomon.GenericGFPoly(this.field, iArr3);
    }

    com.google.zxing.common.reedsolomon.GenericGFPoly multiply(com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new java.lang.IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (isZero() || genericGFPoly.isZero()) {
            return this.field.getZero();
        }
        int[] iArr = this.coefficients;
        int length = iArr.length;
        int[] iArr2 = genericGFPoly.coefficients;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            int i2 = iArr[i_renamed];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i_renamed + i3;
                iArr3[i4] = com.google.zxing.common.reedsolomon.GenericGF.addOrSubtract(iArr3[i4], this.field.multiply(i2, iArr2[i3]));
            }
        }
        return new com.google.zxing.common.reedsolomon.GenericGFPoly(this.field, iArr3);
    }

    com.google.zxing.common.reedsolomon.GenericGFPoly multiply(int i_renamed) {
        if (i_renamed == 0) {
            return this.field.getZero();
        }
        if (i_renamed == 1) {
            return this;
        }
        int length = this.coefficients.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.field.multiply(this.coefficients[i2], i_renamed);
        }
        return new com.google.zxing.common.reedsolomon.GenericGFPoly(this.field, iArr);
    }

    com.google.zxing.common.reedsolomon.GenericGFPoly multiplyByMonomial(int i_renamed, int i2) {
        if (i_renamed < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.field.getZero();
        }
        int length = this.coefficients.length;
        int[] iArr = new int[i_renamed + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.field.multiply(this.coefficients[i3], i2);
        }
        return new com.google.zxing.common.reedsolomon.GenericGFPoly(this.field, iArr);
    }

    com.google.zxing.common.reedsolomon.GenericGFPoly[] divide(com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new java.lang.IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (genericGFPoly.isZero()) {
            throw new java.lang.IllegalArgumentException("Divide by_renamed 0");
        }
        com.google.zxing.common.reedsolomon.GenericGFPoly zero = this.field.getZero();
        int iInverse = this.field.inverse(genericGFPoly.getCoefficient(genericGFPoly.getDegree()));
        com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPolyAddOrSubtract = zero;
        com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPolyAddOrSubtract2 = this;
        while (genericGFPolyAddOrSubtract2.getDegree() >= genericGFPoly.getDegree() && !genericGFPolyAddOrSubtract2.isZero()) {
            int degree = genericGFPolyAddOrSubtract2.getDegree() - genericGFPoly.getDegree();
            int iMultiply = this.field.multiply(genericGFPolyAddOrSubtract2.getCoefficient(genericGFPolyAddOrSubtract2.getDegree()), iInverse);
            com.google.zxing.common.reedsolomon.GenericGFPoly genericGFPolyMultiplyByMonomial = genericGFPoly.multiplyByMonomial(degree, iMultiply);
            genericGFPolyAddOrSubtract = genericGFPolyAddOrSubtract.addOrSubtract(this.field.buildMonomial(degree, iMultiply));
            genericGFPolyAddOrSubtract2 = genericGFPolyAddOrSubtract2.addOrSubtract(genericGFPolyMultiplyByMonomial);
        }
        return new com.google.zxing.common.reedsolomon.GenericGFPoly[]{genericGFPolyAddOrSubtract, genericGFPolyAddOrSubtract2};
    }

    public java.lang.String toString() {
        if (isZero()) {
            return "0";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(getDegree() * 8);
        for (int degree = getDegree(); degree >= 0; degree--) {
            int coefficient = getCoefficient(degree);
            if (coefficient != 0) {
                if (coefficient < 0) {
                    if (degree == getDegree()) {
                        sb.append("-");
                    } else {
                        sb.append(" - ");
                    }
                    coefficient = -coefficient;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (degree == 0 || coefficient != 1) {
                    int iLog = this.field.log(coefficient);
                    if (iLog == 0) {
                        sb.append('1');
                    } else if (iLog == 1) {
                        sb.append('a_renamed');
                    } else {
                        sb.append("a_renamed^");
                        sb.append(iLog);
                    }
                }
                if (degree != 0) {
                    if (degree == 1) {
                        sb.append('x_renamed');
                    } else {
                        sb.append("x_renamed^");
                        sb.append(degree);
                    }
                }
            }
        }
        return sb.toString();
    }
}
