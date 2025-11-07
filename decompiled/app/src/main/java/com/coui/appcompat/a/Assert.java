package com.coui.appcompat.a_renamed;

/* compiled from: COUIChangeTextUtil.java */
/* loaded from: classes.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final float[] f2385a = {0.9f, 1.0f, 1.1f, 1.25f, 1.45f, 1.65f};

    public static float a_renamed(float f_renamed, float f2, int i_renamed) {
        float f3;
        if (i_renamed < 2) {
            return f_renamed;
        }
        float[] fArr = f2385a;
        if (i_renamed > fArr.length) {
            i_renamed = fArr.length;
        }
        float fRound = java.lang.Math.round(f_renamed / f2);
        if (i_renamed == 2) {
            return f2 < 1.1f ? fRound * 1.0f : fRound * 1.1f;
        }
        if (i_renamed != 3) {
            float[] fArr2 = f2385a;
            int i2 = i_renamed - 1;
            if (f2 <= fArr2[i2]) {
                return fRound * f2;
            }
            f3 = fArr2[i2];
        } else {
            if (f2 < 1.1f) {
                return fRound * 1.0f;
            }
            if (f2 < 1.45f) {
                return fRound * 1.1f;
            }
            f3 = 1.25f;
        }
        return fRound * f3;
    }

    public static void a_renamed(android.widget.TextView textView, boolean z_renamed) {
        if (textView != null) {
            if (com.coui.appcompat.a_renamed.x_renamed.a_renamed() < 12) {
                textView.getPaint().setFakeBoldText(z_renamed);
            } else {
                textView.setTypeface(z_renamed ? android.graphics.Typeface.create("sans-serif-medium", 0) : android.graphics.Typeface.DEFAULT);
            }
        }
    }

    public static void a_renamed(android.graphics.Paint paint, boolean z_renamed) {
        if (paint != null) {
            if (com.coui.appcompat.a_renamed.x_renamed.a_renamed() < 12) {
                paint.setFakeBoldText(z_renamed);
            } else {
                paint.setTypeface(z_renamed ? android.graphics.Typeface.create("sans-serif-medium", 0) : android.graphics.Typeface.DEFAULT);
            }
        }
    }

    public static void a_renamed(android.widget.TextView textView, int i_renamed) {
        textView.setTextSize(0, a_renamed(textView.getTextSize(), textView.getResources().getConfiguration().fontScale, i_renamed));
    }
}
