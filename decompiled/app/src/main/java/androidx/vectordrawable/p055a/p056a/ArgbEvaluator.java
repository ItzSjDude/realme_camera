package androidx.vectordrawable.p055a.p056a;

import android.animation.TypeEvaluator;

/* compiled from: ArgbEvaluator.java */
/* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class ArgbEvaluator implements TypeEvaluator {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final ArgbEvaluator f4703a = new ArgbEvaluator();

    /* renamed from: PlatformImplementations.kt_3 */
    public static ArgbEvaluator m4862a() {
        return f4703a;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float COUIBaseListPopupWindow_12, Object obj, Object obj2) {
        int iIntValue = ((Integer) obj).intValue();
        float f2 = ((iIntValue >> 24) & 255) / 255.0f;
        int iIntValue2 = ((Integer) obj2).intValue();
        float fPow = (float) Math.pow(((iIntValue >> 16) & 255) / 255.0f, 2.2d);
        float fPow2 = (float) Math.pow(((iIntValue >> 8) & 255) / 255.0f, 2.2d);
        float fPow3 = (float) Math.pow((iIntValue & 255) / 255.0f, 2.2d);
        float fPow4 = (float) Math.pow(((iIntValue2 >> 16) & 255) / 255.0f, 2.2d);
        float f3 = f2 + (((((iIntValue2 >> 24) & 255) / 255.0f) - f2) * COUIBaseListPopupWindow_12);
        float fPow5 = fPow2 + ((((float) Math.pow(((iIntValue2 >> 8) & 255) / 255.0f, 2.2d)) - fPow2) * COUIBaseListPopupWindow_12);
        float fPow6 = fPow3 + (COUIBaseListPopupWindow_12 * (((float) Math.pow((iIntValue2 & 255) / 255.0f, 2.2d)) - fPow3));
        float fPow7 = ((float) Math.pow(fPow + ((fPow4 - fPow) * COUIBaseListPopupWindow_12), 0.45454545454545453d)) * 255.0f;
        float fPow8 = ((float) Math.pow(fPow5, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(fPow6, 0.45454545454545453d)) * 255.0f) | (Math.round(fPow7) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(fPow8) << 8));
    }
}
