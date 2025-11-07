package com.airbnb.lottie.e_renamed;

/* compiled from: GradientColorParser.java */
/* loaded from: classes.dex */
public class l_renamed implements com.airbnb.lottie.e_renamed.aj_renamed<com.airbnb.lottie.c_renamed.b_renamed.c_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f2196a;

    public l_renamed(int i_renamed) {
        this.f2196a = i_renamed;
    }

    @Override // com.airbnb.lottie.e_renamed.aj_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.c_renamed.b_renamed.c_renamed b_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, float f_renamed) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        boolean z_renamed = cVar.f_renamed() == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BEGIN_ARRAY;
        if (z_renamed) {
            cVar.a_renamed();
        }
        while (cVar.e_renamed()) {
            arrayList.add(java.lang.Float.valueOf((float) cVar.k_renamed()));
        }
        if (z_renamed) {
            cVar.b_renamed();
        }
        if (this.f2196a == -1) {
            this.f2196a = arrayList.size() / 4;
        }
        int i_renamed = this.f2196a;
        float[] fArr = new float[i_renamed];
        int[] iArr = new int[i_renamed];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f2196a * 4; i4++) {
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
                iArr[i5] = android.graphics.Color.argb(255, i2, i3, (int) (dFloatValue * 255.0d));
            }
        }
        com.airbnb.lottie.c_renamed.b_renamed.c_renamed cVar2 = new com.airbnb.lottie.c_renamed.b_renamed.c_renamed(fArr, iArr);
        a_renamed(cVar2, arrayList);
        return cVar2;
    }

    private void a_renamed(com.airbnb.lottie.c_renamed.b_renamed.c_renamed cVar, java.util.List<java.lang.Float> list) {
        int i_renamed = this.f2196a * 4;
        if (list.size() <= i_renamed) {
            return;
        }
        int size = (list.size() - i_renamed) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i2 = 0;
        while (i_renamed < list.size()) {
            if (i_renamed % 2 == 0) {
                dArr[i2] = list.get(i_renamed).floatValue();
            } else {
                dArr2[i2] = list.get(i_renamed).floatValue();
                i2++;
            }
            i_renamed++;
        }
        for (int i3 = 0; i3 < cVar.c_renamed(); i3++) {
            int i4 = cVar.b_renamed()[i3];
            cVar.b_renamed()[i3] = android.graphics.Color.argb(a_renamed(cVar.a_renamed()[i3], dArr, dArr2), android.graphics.Color.red(i4), android.graphics.Color.green(i4), android.graphics.Color.blue(i4));
        }
    }

    private int a_renamed(double d_renamed, double[] dArr, double[] dArr2) {
        double dA_renamed;
        int i_renamed = 1;
        while (true) {
            if (i_renamed < dArr.length) {
                int i2 = i_renamed - 1;
                double d2 = dArr[i2];
                double d3 = dArr[i_renamed];
                if (dArr[i_renamed] >= d_renamed) {
                    dA_renamed = com.airbnb.lottie.f_renamed.g_renamed.a_renamed(dArr2[i2], dArr2[i_renamed], com.airbnb.lottie.f_renamed.g_renamed.b_renamed((d_renamed - d2) / (d3 - d2), 0.0d, 1.0d));
                    break;
                }
                i_renamed++;
            } else {
                dA_renamed = dArr2[dArr2.length - 1];
                break;
            }
        }
        return (int) (dA_renamed * 255.0d);
    }
}
