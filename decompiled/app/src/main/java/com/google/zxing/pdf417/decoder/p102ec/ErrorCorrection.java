package com.google.zxing.pdf417.decoder.p102ec;

import com.google.zxing.ChecksumException;

/* loaded from: classes.dex */
public final class ErrorCorrection {
    private final ModulusGF field = ModulusGF.PDF417_GF;

    public int decode(int[] iArr, int OplusGLSurfaceView_13, int[] iArr2) throws ChecksumException {
        ModulusPoly modulusPoly = new ModulusPoly(this.field, iArr);
        int[] iArr3 = new int[OplusGLSurfaceView_13];
        boolean z = false;
        for (int i2 = OplusGLSurfaceView_13; i2 > 0; i2--) {
            int iEvaluateAt = modulusPoly.evaluateAt(this.field.exp(i2));
            iArr3[OplusGLSurfaceView_13 - i2] = iEvaluateAt;
            if (iEvaluateAt != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        ModulusPoly one = this.field.getOne();
        if (iArr2 != null) {
            ModulusPoly modulusPolyMultiply = one;
            for (int i3 : iArr2) {
                int iExp = this.field.exp((iArr.length - 1) - i3);
                ModulusGF modulusGF = this.field;
                modulusPolyMultiply = modulusPolyMultiply.multiply(new ModulusPoly(modulusGF, new int[]{modulusGF.subtract(0, iExp), 1}));
            }
        }
        ModulusPoly[] modulusPolyArrRunEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(OplusGLSurfaceView_13, 1), new ModulusPoly(this.field, iArr3), OplusGLSurfaceView_13);
        ModulusPoly modulusPoly2 = modulusPolyArrRunEuclideanAlgorithm[0];
        ModulusPoly modulusPoly3 = modulusPolyArrRunEuclideanAlgorithm[1];
        int[] iArrFindErrorLocations = findErrorLocations(modulusPoly2);
        int[] iArrFindErrorMagnitudes = findErrorMagnitudes(modulusPoly3, modulusPoly2, iArrFindErrorLocations);
        for (int i4 = 0; i4 < iArrFindErrorLocations.length; i4++) {
            int length = (iArr.length - 1) - this.field.log(iArrFindErrorLocations[i4]);
            if (length < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.field.subtract(iArr[length], iArrFindErrorMagnitudes[i4]);
        }
        return iArrFindErrorLocations.length;
    }

    private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int OplusGLSurfaceView_13) throws ChecksumException {
        if (modulusPoly.getDegree() < modulusPoly2.getDegree()) {
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly2;
        }
        ModulusPoly zero = this.field.getZero();
        ModulusPoly one = this.field.getOne();
        while (true) {
            ModulusPoly modulusPoly3 = modulusPoly2;
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly3;
            ModulusPoly modulusPoly4 = one;
            ModulusPoly modulusPoly5 = zero;
            zero = modulusPoly4;
            if (modulusPoly.getDegree() >= OplusGLSurfaceView_13 / 2) {
                if (modulusPoly.isZero()) {
                    throw ChecksumException.getChecksumInstance();
                }
                ModulusPoly zero2 = this.field.getZero();
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
                    throw ChecksumException.getChecksumInstance();
                }
                int iInverse2 = this.field.inverse(coefficient);
                return new ModulusPoly[]{zero.multiply(iInverse2), modulusPoly.multiply(iInverse2)};
            }
        }
    }

    private int[] findErrorLocations(ModulusPoly modulusPoly) throws ChecksumException {
        int degree = modulusPoly.getDegree();
        int[] iArr = new int[degree];
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 1; i2 < this.field.getSize() && OplusGLSurfaceView_13 < degree; i2++) {
            if (modulusPoly.evaluateAt(i2) == 0) {
                iArr[OplusGLSurfaceView_13] = this.field.inverse(i2);
                OplusGLSurfaceView_13++;
            }
        }
        if (OplusGLSurfaceView_13 == degree) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] findErrorMagnitudes(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int[] iArr) {
        int degree = modulusPoly2.getDegree();
        int[] iArr2 = new int[degree];
        for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 <= degree; OplusGLSurfaceView_13++) {
            iArr2[degree - OplusGLSurfaceView_13] = this.field.multiply(OplusGLSurfaceView_13, modulusPoly2.getCoefficient(OplusGLSurfaceView_13));
        }
        ModulusPoly modulusPoly3 = new ModulusPoly(this.field, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iInverse = this.field.inverse(iArr[i2]);
            iArr3[i2] = this.field.multiply(this.field.subtract(0, modulusPoly.evaluateAt(iInverse)), this.field.inverse(modulusPoly3.evaluateAt(iInverse)));
        }
        return iArr3;
    }
}
