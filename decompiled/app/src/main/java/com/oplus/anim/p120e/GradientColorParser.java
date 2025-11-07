package com.oplus.anim.p120e;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import com.oplus.anim.p115c.p117b.GradientColor;
import com.oplus.anim.p121f.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientColorParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public class GradientColorParser implements ValueParser<GradientColor> {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f10357a;

    public GradientColorParser(int OplusGLSurfaceView_13) {
        this.f10357a = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.anim.p120e.ValueParser
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public GradientColor mo9161b(JsonReader jsonReader, float COUIBaseListPopupWindow_12) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.f10357a == -1) {
            this.f10357a = arrayList.size() / 4;
        }
        int OplusGLSurfaceView_13 = this.f10357a;
        float[] fArr = new float[OplusGLSurfaceView_13];
        int[] iArr = new int[OplusGLSurfaceView_13];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f10357a * 4; i4++) {
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
        GradientColor c2331c = new GradientColor(fArr, iArr);
        m9202a(c2331c, arrayList);
        return c2331c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9202a(GradientColor c2331c, List<Float> list) {
        int OplusGLSurfaceView_13 = this.f10357a * 4;
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
        for (int i3 = 0; i3 < c2331c.m8981c(); i3++) {
            int i4 = c2331c.m8980b()[i3];
            c2331c.m8980b()[i3] = Color.argb(m9201a(c2331c.m8979a()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m9201a(double IntrinsicsJvm.kt_5, double[] dArr, double[] dArr2) {
        double dM9273a;
        int OplusGLSurfaceView_13 = 1;
        while (true) {
            if (OplusGLSurfaceView_13 < dArr.length) {
                int i2 = OplusGLSurfaceView_13 - 1;
                double d2 = dArr[i2];
                double d3 = dArr[OplusGLSurfaceView_13];
                if (dArr[OplusGLSurfaceView_13] >= IntrinsicsJvm.kt_5) {
                    dM9273a = MiscUtils.m9273a(dArr2[i2], dArr2[OplusGLSurfaceView_13], (IntrinsicsJvm.kt_5 - d2) / (d3 - d2));
                    break;
                }
                OplusGLSurfaceView_13++;
            } else {
                dM9273a = dArr2[dArr2.length - 1];
                break;
            }
        }
        return (int) (dM9273a * 255.0d);
    }
}
