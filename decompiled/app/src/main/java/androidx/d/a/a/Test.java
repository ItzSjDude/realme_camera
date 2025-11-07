package androidx.d_renamed.a_renamed.a_renamed;

/* compiled from: LookupTableInterpolator.java */
/* loaded from: classes.dex */
abstract class d_renamed implements android.view.animation.Interpolator {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final float[] f1047a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final float f1048b;

    protected d_renamed(float[] fArr) {
        this.f1047a = fArr;
        this.f1048b = 1.0f / (this.f1047a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f_renamed) {
        if (f_renamed >= 1.0f) {
            return 1.0f;
        }
        if (f_renamed <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f1047a;
        int iMin = java.lang.Math.min((int) ((fArr.length - 1) * f_renamed), fArr.length - 2);
        float f2 = this.f1048b;
        float f3 = (f_renamed - (iMin * f2)) / f2;
        float[] fArr2 = this.f1047a;
        return fArr2[iMin] + (f3 * (fArr2[iMin + 1] - fArr2[iMin]));
    }
}
