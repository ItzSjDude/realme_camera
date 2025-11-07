package com.coui.appcompat.p099a;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.TextView;

/* compiled from: COUIChangeTextUtil.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class COUIChangeTextUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final float[] f6305a = {0.9f, 1.0f, 1.1f, 1.25f, 1.45f, 1.65f};

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m6388a(float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13) {
        float f3;
        if (OplusGLSurfaceView_13 < 2) {
            return COUIBaseListPopupWindow_12;
        }
        float[] fArr = f6305a;
        if (OplusGLSurfaceView_13 > fArr.length) {
            OplusGLSurfaceView_13 = fArr.length;
        }
        float fRound = Math.round(COUIBaseListPopupWindow_12 / f2);
        if (OplusGLSurfaceView_13 == 2) {
            return f2 < 1.1f ? fRound * 1.0f : fRound * 1.1f;
        }
        if (OplusGLSurfaceView_13 != 3) {
            float[] fArr2 = f6305a;
            int i2 = OplusGLSurfaceView_13 - 1;
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

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6391a(TextView textView, boolean z) {
        if (textView != null) {
            if (COUIVersionUtil.m6500a() < 12) {
                textView.getPaint().setFakeBoldText(z);
            } else {
                textView.setTypeface(z ? Typeface.create("sans-serif-medium", 0) : Typeface.DEFAULT);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6389a(Paint paint, boolean z) {
        if (paint != null) {
            if (COUIVersionUtil.m6500a() < 12) {
                paint.setFakeBoldText(z);
            } else {
                paint.setTypeface(z ? Typeface.create("sans-serif-medium", 0) : Typeface.DEFAULT);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6390a(TextView textView, int OplusGLSurfaceView_13) {
        textView.setTextSize(0, m6388a(textView.getTextSize(), textView.getResources().getConfiguration().fontScale, OplusGLSurfaceView_13));
    }
}
