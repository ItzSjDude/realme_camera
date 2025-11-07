package com.oplus.anim.e_renamed;

/* compiled from: ShapeDataParser.java */
/* loaded from: classes2.dex */
public class ad_renamed implements com.oplus.anim.e_renamed.aj_renamed<com.oplus.anim.c_renamed.b_renamed.l_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.oplus.anim.e_renamed.ad_renamed f3652a = new com.oplus.anim.e_renamed.ad_renamed();

    private ad_renamed() {
    }

    @Override // com.oplus.anim.e_renamed.aj_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.anim.c_renamed.b_renamed.l_renamed b_renamed(android.util.JsonReader jsonReader, float f_renamed) throws java.io.IOException {
        if (jsonReader.peek() == android.util.JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        java.util.List<android.graphics.PointF> listA = null;
        java.util.List<android.graphics.PointF> listA2 = null;
        java.util.List<android.graphics.PointF> listA3 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 99) {
                if (iHashCode != 105) {
                    if (iHashCode != 111) {
                        if (iHashCode == 118 && strNextName.equals("v_renamed")) {
                            c2 = 1;
                        }
                    } else if (strNextName.equals("o_renamed")) {
                        c2 = 3;
                    }
                } else if (strNextName.equals("i_renamed")) {
                    c2 = 2;
                }
            } else if (strNextName.equals("c_renamed")) {
                c2 = 0;
            }
            if (c2 == 0) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (c2 == 1) {
                listA = com.oplus.anim.e_renamed.q_renamed.a_renamed(jsonReader, f_renamed);
            } else if (c2 == 2) {
                listA2 = com.oplus.anim.e_renamed.q_renamed.a_renamed(jsonReader, f_renamed);
            } else if (c2 == 3) {
                listA3 = com.oplus.anim.e_renamed.q_renamed.a_renamed(jsonReader, f_renamed);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == android.util.JsonToken.END_ARRAY) {
            jsonReader.endArray();
        }
        if (listA == null || listA2 == null || listA3 == null) {
            throw new java.lang.IllegalArgumentException("Shape data was missing information.");
        }
        if (listA.isEmpty()) {
            return new com.oplus.anim.c_renamed.b_renamed.l_renamed(new android.graphics.PointF(), false, java.util.Collections.emptyList());
        }
        int size = listA.size();
        android.graphics.PointF pointF = listA.get(0);
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        for (int i_renamed = 1; i_renamed < size; i_renamed++) {
            android.graphics.PointF pointF2 = listA.get(i_renamed);
            int i2 = i_renamed - 1;
            arrayList.add(new com.oplus.anim.c_renamed.a_renamed(com.oplus.anim.f_renamed.e_renamed.a_renamed(listA.get(i2), listA3.get(i2)), com.oplus.anim.f_renamed.e_renamed.a_renamed(pointF2, listA2.get(i_renamed)), pointF2));
        }
        if (zNextBoolean) {
            android.graphics.PointF pointF3 = listA.get(0);
            int i3 = size - 1;
            arrayList.add(new com.oplus.anim.c_renamed.a_renamed(com.oplus.anim.f_renamed.e_renamed.a_renamed(listA.get(i3), listA3.get(i3)), com.oplus.anim.f_renamed.e_renamed.a_renamed(pointF3, listA2.get(0)), pointF3));
        }
        return new com.oplus.anim.c_renamed.b_renamed.l_renamed(pointF, zNextBoolean, arrayList);
    }
}
