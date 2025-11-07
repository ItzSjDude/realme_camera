package com.b_renamed.a_renamed.a_renamed;

/* compiled from: IAnimator.java */
/* loaded from: classes.dex */
public interface j_renamed {
    default float a_renamed(float f_renamed, float f2, float f3) {
        return f_renamed + ((f2 - f_renamed) * f3);
    }

    void a_renamed(float f_renamed);

    void b_renamed();

    void d_renamed();

    default float a_renamed(float[] fArr, float f_renamed) {
        return a_renamed(fArr[0], fArr[1], f_renamed);
    }

    default float a_renamed(float f_renamed, float f2, float f3, float f4) {
        return f_renamed + ((f2 - f_renamed) * ((float) java.lang.Math.pow(f3, f4)));
    }

    default float a_renamed(float[] fArr, float f_renamed, float f2) {
        return a_renamed(fArr[0], fArr[1], f_renamed, f2);
    }
}
