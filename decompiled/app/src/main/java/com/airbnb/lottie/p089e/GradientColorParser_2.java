package com.airbnb.lottie.p089e;

import android.graphics.Color;
import com.airbnb.lottie.p084c.p086b.GradientColor_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.airbnb.lottie.p091f.MiscUtils_2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientColorParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class GradientColorParser_2 implements ValueParser_2<GradientColor_2> {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f5790a;

    public GradientColorParser_2(int OplusGLSurfaceView_13) {
        this.f5790a = OplusGLSurfaceView_13;
    }

    @Override // com.airbnb.lottie.p089e.ValueParser_2
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public GradientColor_2 mo5948b(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = abstractC1149c.mo5920f() == JsonReader.IntrinsicsJvm.kt_4.BEGIN_ARRAY;
        if (z) {
            abstractC1149c.mo5914a();
        }
        while (abstractC1149c.mo5919e()) {
            arrayList.add(Float.valueOf((float) abstractC1149c.mo5925k()));
        }
        if (z) {
            abstractC1149c.mo5916b();
        }
        if (this.f5790a == -1) {
            this.f5790a = arrayList.size() / 4;
        }
        int OplusGLSurfaceView_13 = this.f5790a;
        float[] fArr = new float[OplusGLSurfaceView_13];
        int[] iArr = new int[OplusGLSurfaceView_13];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f5790a * 4; i4++) {
            int i5 = i4 / 4;
            double dFloatValue = arrayList.get(i4).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                fArr[i5] = (float) dFloatValue;
            } else if (i6 == 1) {
                i2 = (int) (dFloatValue * 255.0d);
            } else if (i6 == 2) {
                i3 = (int) (dFloatValue * 255.0d);
            } else if (i6 == 3) {
                iArr[i5] = Color.argb(255, i2, i3, (int) (dFloatValue * 255.0d));
            }
        }
        GradientColor_2 c1106c = new GradientColor_2(fArr, iArr);
        m5983a(c1106c, arrayList);
        return c1106c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5983a(GradientColor_2 c1106c, List<Float> list) {
        int OplusGLSurfaceView_13 = this.f5790a * 4;
        if (list.size() <= OplusGLSurfaceView_13) {
            return;
        }
        int size = (list.size() - OplusGLSurfaceView_13) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i2 = 0;
        while (OplusGLSurfaceView_13 < list.size()) {
            if (OplusGLSurfaceView_13 % 2 == 0) {
                dArr[i2] = list.get(OplusGLSurfaceView_13).floatValue();
            } else {
                dArr2[i2] = list.get(OplusGLSurfaceView_13).floatValue();
                i2++;
            }
            OplusGLSurfaceView_13++;
        }
        for (int i3 = 0; i3 < c1106c.m5670c(); i3++) {
            int i4 = c1106c.m5669b()[i3];
            c1106c.m5669b()[i3] = Color.argb(m5982a(c1106c.m5668a()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m5982a(double IntrinsicsJvm.kt_5, double[] dArr, double[] dArr2) {
        double dM6126a;
        int OplusGLSurfaceView_13 = 1;
        while (true) {
            if (OplusGLSurfaceView_13 < dArr.length) {
                int i2 = OplusGLSurfaceView_13 - 1;
                double d2 = dArr[i2];
                double d3 = dArr[OplusGLSurfaceView_13];
                if (dArr[OplusGLSurfaceView_13] >= IntrinsicsJvm.kt_5) {
                    dM6126a = MiscUtils_2.m6126a(dArr2[i2], dArr2[OplusGLSurfaceView_13], MiscUtils_2.m6135b((IntrinsicsJvm.kt_5 - d2) / (d3 - d2), 0.0d, 1.0d));
                    break;
                }
                OplusGLSurfaceView_13++;
            } else {
                dM6126a = dArr2[dArr2.length - 1];
                break;
            }
        }
        return (int) (dM6126a * 255.0d);
    }
}
