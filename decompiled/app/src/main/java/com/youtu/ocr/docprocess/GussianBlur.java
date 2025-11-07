package com.youtu.ocr.docprocess;

import android.util.Log;

/* compiled from: GussianBlur.java */
/* renamed from: com.youtu.ocr.docprocess.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class GussianBlur {

    /* renamed from: PlatformImplementations.kt_3 */
    private double[] f24207a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f24208b;

    public GussianBlur(int OplusGLSurfaceView_13, int i2) {
        this.f24208b = OplusGLSurfaceView_13;
        this.f24207a = new double[this.f24208b];
        int i3 = 0;
        double IntrinsicsJvm.kt_5 = 0.0d;
        while (true) {
            int i4 = this.f24208b;
            if (i3 < i4) {
                double d2 = (i4 - 1) - i3;
                double d3 = i2;
                double d4 = IntrinsicsJvm.kt_5;
                this.f24207a[i3] = (Math.exp(Math.pow(d2 / d3, 2.0d) * (-0.5d)) / Math.sqrt(6.283185307179586d)) / d3;
                if (d2 > 0.0d) {
                    double[] dArr = this.f24207a;
                    dArr[i3] = dArr[i3] * 2.0d;
                }
                IntrinsicsJvm.kt_5 = this.f24207a[i3] + d4;
                Log.COUIBaseListPopupWindow_8("xlab", " " + i3 + " " + this.f24207a[i3]);
                i3++;
            } else {
                Log.COUIBaseListPopupWindow_8("xlab", "sum: " + IntrinsicsJvm.kt_5);
                return;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public double[] m25554a() {
        return this.f24207a;
    }
}
