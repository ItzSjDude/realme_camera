package androidx.core.h_renamed.b_renamed;

/* compiled from: PathInterpolatorApi14.java */
/* loaded from: classes.dex */
class a_renamed implements android.view.animation.Interpolator {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final float[] f976a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final float[] f977b;

    a_renamed(android.graphics.Path path) {
        android.graphics.PathMeasure pathMeasure = new android.graphics.PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i_renamed = ((int) (length / 0.002f)) + 1;
        this.f976a = new float[i_renamed];
        this.f977b = new float[i_renamed];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i_renamed; i2++) {
            pathMeasure.getPosTan((i2 * length) / (i_renamed - 1), fArr, null);
            this.f976a[i2] = fArr[0];
            this.f977b[i2] = fArr[1];
        }
    }

    a_renamed(float f_renamed, float f2, float f3, float f4) {
        this(a_renamed(f_renamed, f2, f3, f4));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f_renamed) {
        if (f_renamed <= 0.0f) {
            return 0.0f;
        }
        if (f_renamed >= 1.0f) {
            return 1.0f;
        }
        int i_renamed = 0;
        int length = this.f976a.length - 1;
        while (length - i_renamed > 1) {
            int i2 = (i_renamed + length) / 2;
            if (f_renamed < this.f976a[i2]) {
                length = i2;
            } else {
                i_renamed = i2;
            }
        }
        float[] fArr = this.f976a;
        float f2 = fArr[length] - fArr[i_renamed];
        if (f2 == 0.0f) {
            return this.f977b[i_renamed];
        }
        float f3 = (f_renamed - fArr[i_renamed]) / f2;
        float[] fArr2 = this.f977b;
        float f4 = fArr2[i_renamed];
        return f4 + (f3 * (fArr2[length] - f4));
    }

    private static android.graphics.Path a_renamed(float f_renamed, float f2, float f3, float f4) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f_renamed, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }
}
