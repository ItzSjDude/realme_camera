package com.google.zxing.common;

/* loaded from: classes.dex */
public final class PerspectiveTransform {
    private final float a11;
    private final float a12;
    private final float a13;
    private final float a21;
    private final float a22;
    private final float a23;
    private final float a31;
    private final float a32;
    private final float a33;

    private PerspectiveTransform(float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.a11 = f_renamed;
        this.a12 = f4;
        this.a13 = f7;
        this.a21 = f2;
        this.a22 = f5;
        this.a23 = f8;
        this.a31 = f3;
        this.a32 = f6;
        this.a33 = f9;
    }

    public static com.google.zxing.common.PerspectiveTransform quadrilateralToQuadrilateral(float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return squareToQuadrilateral(f9, f10, f11, f12, f13, f14, f15, f16).times(quadrilateralToSquare(f_renamed, f2, f3, f4, f5, f6, f7, f8));
    }

    public void transformPoints(float[] fArr) {
        float f_renamed = this.a11;
        float f2 = this.a12;
        float f3 = this.a13;
        float f4 = this.a21;
        float f5 = this.a22;
        float f6 = this.a23;
        float f7 = this.a31;
        float f8 = this.a32;
        float f9 = this.a33;
        int length = fArr.length - 1;
        for (int i_renamed = 0; i_renamed < length; i_renamed += 2) {
            float f10 = fArr[i_renamed];
            int i2 = i_renamed + 1;
            float f11 = fArr[i2];
            float f12 = (f3 * f10) + (f6 * f11) + f9;
            fArr[i_renamed] = (((f_renamed * f10) + (f4 * f11)) + f7) / f12;
            fArr[i2] = (((f10 * f2) + (f11 * f5)) + f8) / f12;
        }
    }

    public void transformPoints(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            float f_renamed = fArr[i_renamed];
            float f2 = fArr2[i_renamed];
            float f3 = (this.a13 * f_renamed) + (this.a23 * f2) + this.a33;
            fArr[i_renamed] = (((this.a11 * f_renamed) + (this.a21 * f2)) + this.a31) / f3;
            fArr2[i_renamed] = (((this.a12 * f_renamed) + (this.a22 * f2)) + this.a32) / f3;
        }
    }

    public static com.google.zxing.common.PerspectiveTransform squareToQuadrilateral(float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f_renamed - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new com.google.zxing.common.PerspectiveTransform(f3 - f_renamed, f5 - f3, f_renamed, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, 1.0f);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        float f17 = ((f11 * f10) - (f9 * f13)) / f15;
        return new com.google.zxing.common.PerspectiveTransform((f16 * f3) + (f3 - f_renamed), (f17 * f7) + (f7 - f_renamed), f_renamed, (f4 - f2) + (f16 * f4), (f8 - f2) + (f17 * f8), f2, f16, f17, 1.0f);
    }

    public static com.google.zxing.common.PerspectiveTransform quadrilateralToSquare(float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return squareToQuadrilateral(f_renamed, f2, f3, f4, f5, f6, f7, f8).buildAdjoint();
    }

    com.google.zxing.common.PerspectiveTransform buildAdjoint() {
        float f_renamed = this.a22;
        float f2 = this.a33;
        float f3 = this.a23;
        float f4 = this.a32;
        float f5 = (f_renamed * f2) - (f3 * f4);
        float f6 = this.a31;
        float f7 = this.a21;
        float f8 = (f3 * f6) - (f7 * f2);
        float f9 = (f7 * f4) - (f_renamed * f6);
        float f10 = this.a13;
        float f11 = this.a12;
        float f12 = this.a11;
        return new com.google.zxing.common.PerspectiveTransform(f5, f8, f9, (f10 * f4) - (f11 * f2), (f2 * f12) - (f10 * f6), (f6 * f11) - (f4 * f12), (f11 * f3) - (f10 * f_renamed), (f10 * f7) - (f3 * f12), (f12 * f_renamed) - (f11 * f7));
    }

    com.google.zxing.common.PerspectiveTransform times(com.google.zxing.common.PerspectiveTransform perspectiveTransform) {
        float f_renamed = this.a11;
        float f2 = perspectiveTransform.a11;
        float f3 = this.a21;
        float f4 = perspectiveTransform.a12;
        float f5 = this.a31;
        float f6 = perspectiveTransform.a13;
        float f7 = (f_renamed * f2) + (f3 * f4) + (f5 * f6);
        float f8 = perspectiveTransform.a21;
        float f9 = perspectiveTransform.a22;
        float f10 = perspectiveTransform.a23;
        float f11 = (f_renamed * f8) + (f3 * f9) + (f5 * f10);
        float f12 = perspectiveTransform.a31;
        float f13 = perspectiveTransform.a32;
        float f14 = perspectiveTransform.a33;
        float f15 = (f_renamed * f12) + (f3 * f13) + (f5 * f14);
        float f16 = this.a12;
        float f17 = this.a22;
        float f18 = this.a32;
        float f19 = (f16 * f2) + (f17 * f4) + (f18 * f6);
        float f20 = (f16 * f8) + (f17 * f9) + (f18 * f10);
        float f21 = (f18 * f14) + (f16 * f12) + (f17 * f13);
        float f22 = this.a13;
        float f23 = this.a23;
        float f24 = this.a33;
        return new com.google.zxing.common.PerspectiveTransform(f7, f11, f15, f19, f20, f21, (f6 * f24) + (f2 * f22) + (f4 * f23), (f8 * f22) + (f9 * f23) + (f10 * f24), (f22 * f12) + (f23 * f13) + (f24 * f14));
    }
}
