package com.google.zxing.pdf417.decoder.ec_renamed;

/* loaded from: classes.dex */
final class ModulusPoly {
    private final int[] coefficients;
    private final com.google.zxing.pdf417.decoder.ec_renamed.ModulusGF field;

    ModulusPoly(com.google.zxing.pdf417.decoder.ec_renamed.ModulusGF modulusGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.field = modulusGF;
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
            int iAdd = 0;
            for (int i2 : this.coefficients) {
                iAdd = this.field.add(iAdd, i2);
            }
            return iAdd;
        }
        int[] iArr = this.coefficients;
        int iAdd2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            com.google.zxing.pdf417.decoder.ec_renamed.ModulusGF modulusGF = this.field;
            iAdd2 = modulusGF.add(modulusGF.multiply(i_renamed, iAdd2), this.coefficients[i3]);
        }
        return iAdd2;
    }

    com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly add(com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly) {
        if (!this.field.equals(modulusPoly.field)) {
            throw new java.lang.IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (isZero()) {
            return modulusPoly;
        }
        if (modulusPoly.isZero()) {
            return this;
        }
        int[] iArr = this.coefficients;
        int[] iArr2 = modulusPoly.coefficients;
        if (iArr.length > iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr2.length];
        int length = iArr2.length - iArr.length;
        java.lang.System.arraycopy(iArr2, 0, iArr3, 0, length);
        for (int i_renamed = length; i_renamed < iArr2.length; i_renamed++) {
            iArr3[i_renamed] = this.field.add(iArr[i_renamed - length], iArr2[i_renamed]);
        }
        return new com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly(this.field, iArr3);
    }

    com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly subtract(com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly) {
        if (this.field.equals(modulusPoly.field)) {
            return modulusPoly.isZero() ? this : add(modulusPoly.negative());
        }
        throw new java.lang.IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly multiply(com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly modulusPoly) {
        if (!this.field.equals(modulusPoly.field)) {
            throw new java.lang.IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (isZero() || modulusPoly.isZero()) {
            return this.field.getZero();
        }
        int[] iArr = this.coefficients;
        int length = iArr.length;
        int[] iArr2 = modulusPoly.coefficients;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            int i2 = iArr[i_renamed];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i_renamed + i3;
                com.google.zxing.pdf417.decoder.ec_renamed.ModulusGF modulusGF = this.field;
                iArr3[i4] = modulusGF.add(iArr3[i4], modulusGF.multiply(i2, iArr2[i3]));
            }
        }
        return new com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly(this.field, iArr3);
    }

    com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly negative() {
        int length = this.coefficients.length;
        int[] iArr = new int[length];
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            iArr[i_renamed] = this.field.subtract(0, this.coefficients[i_renamed]);
        }
        return new com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly(this.field, iArr);
    }

    com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly multiply(int i_renamed) {
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
        return new com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly(this.field, iArr);
    }

    com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly multiplyByMonomial(int i_renamed, int i2) {
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
        return new com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly(this.field, iArr);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(getDegree() * 8);
        for (int degree = getDegree(); degree >= 0; degree--) {
            int coefficient = getCoefficient(degree);
            if (coefficient != 0) {
                if (coefficient < 0) {
                    sb.append(" - ");
                    coefficient = -coefficient;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (degree == 0 || coefficient != 1) {
                    sb.append(coefficient);
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
