package androidx.vectordrawable.a_renamed.a_renamed;

/* compiled from: ArgbEvaluator.java */
/* loaded from: classes.dex */
public class f_renamed implements android.animation.TypeEvaluator {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final androidx.vectordrawable.a_renamed.a_renamed.f_renamed f1776a = new androidx.vectordrawable.a_renamed.a_renamed.f_renamed();

    public static androidx.vectordrawable.a_renamed.a_renamed.f_renamed a_renamed() {
        return f1776a;
    }

    @Override // android.animation.TypeEvaluator
    public java.lang.Object evaluate(float f_renamed, java.lang.Object obj, java.lang.Object obj2) {
        int iIntValue = ((java.lang.Integer) obj).intValue();
        float f2 = ((iIntValue >> 24) & 255) / 255.0f;
        int iIntValue2 = ((java.lang.Integer) obj2).intValue();
        float fPow = (float) java.lang.Math.pow(((iIntValue >> 16) & 255) / 255.0f, 2.2d);
        float fPow2 = (float) java.lang.Math.pow(((iIntValue >> 8) & 255) / 255.0f, 2.2d);
        float fPow3 = (float) java.lang.Math.pow((iIntValue & 255) / 255.0f, 2.2d);
        float fPow4 = (float) java.lang.Math.pow(((iIntValue2 >> 16) & 255) / 255.0f, 2.2d);
        float f3 = f2 + (((((iIntValue2 >> 24) & 255) / 255.0f) - f2) * f_renamed);
        float fPow5 = fPow2 + ((((float) java.lang.Math.pow(((iIntValue2 >> 8) & 255) / 255.0f, 2.2d)) - fPow2) * f_renamed);
        float fPow6 = fPow3 + (f_renamed * (((float) java.lang.Math.pow((iIntValue2 & 255) / 255.0f, 2.2d)) - fPow3));
        float fPow7 = ((float) java.lang.Math.pow(fPow + ((fPow4 - fPow) * f_renamed), 0.45454545454545453d)) * 255.0f;
        float fPow8 = ((float) java.lang.Math.pow(fPow5, 0.45454545454545453d)) * 255.0f;
        return java.lang.Integer.valueOf(java.lang.Math.round(((float) java.lang.Math.pow(fPow6, 0.45454545454545453d)) * 255.0f) | (java.lang.Math.round(fPow7) << 16) | (java.lang.Math.round(f3 * 255.0f) << 24) | (java.lang.Math.round(fPow8) << 8));
    }
}
