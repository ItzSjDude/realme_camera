package com.oplus.anim.e_renamed;

/* compiled from: GradientColorParser.java */
/* loaded from: classes2.dex */
public class m_renamed implements com.oplus.anim.e_renamed.aj_renamed<com.oplus.anim.c_renamed.b_renamed.c_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f3656a;

    public m_renamed(int i_renamed) {
        this.f3656a = i_renamed;
    }

    @Override // com.oplus.anim.e_renamed.aj_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.anim.c_renamed.b_renamed.c_renamed b_renamed(android.util.JsonReader jsonReader, float f_renamed) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        boolean z_renamed = jsonReader.peek() == android.util.JsonToken.BEGIN_ARRAY;
        if (z_renamed) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(java.lang.Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z_renamed) {
            jsonReader.endArray();
        }
        if (this.f3656a == -1) {
            this.f3656a = arrayList.size() / 4;
        }
        int i_renamed = this.f3656a;
        float[] fArr = new float[i_renamed];
        int[] iArr = new int[i_renamed];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f3656a * 4; i4++) {
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
        com.oplus.anim.c_renamed.b_renamed.c_renamed cVar = new com.oplus.anim.c_renamed.b_renamed.c_renamed(fArr, iArr);
        a_renamed(cVar, arrayList);
        return cVar;
    }

    private void a_renamed(com.oplus.anim.c_renamed.b_renamed.c_renamed cVar, java.util.List<java.lang.Float> list) {
        int i_renamed = this.f3656a * 4;
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
                    dA_renamed = com.oplus.anim.f_renamed.e_renamed.a_renamed(dArr2[i2], dArr2[i_renamed], (d_renamed - d2) / (d3 - d2));
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
