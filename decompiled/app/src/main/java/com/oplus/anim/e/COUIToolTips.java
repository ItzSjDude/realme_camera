package com.oplus.anim.e_renamed;

/* compiled from: KeyframesParser.java */
/* loaded from: classes2.dex */
class s_renamed {
    static <T_renamed> java.util.List<com.oplus.anim.g_renamed.c_renamed<T_renamed>> a_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar, float f_renamed, com.oplus.anim.e_renamed.aj_renamed<T_renamed> ajVar) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jsonReader.peek() == android.util.JsonToken.STRING) {
            aVar.a_renamed("EffectiveAnimation doesn't_renamed support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            if (strNextName.hashCode() == 107 && strNextName.equals("k_renamed")) {
                c2 = 0;
            }
            if (c2 == 0) {
                if (jsonReader.peek() == android.util.JsonToken.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    if (jsonReader.peek() == android.util.JsonToken.NUMBER) {
                        arrayList.add(com.oplus.anim.e_renamed.r_renamed.a_renamed(jsonReader, aVar, f_renamed, ajVar, false));
                    } else {
                        while (jsonReader.hasNext()) {
                            arrayList.add(com.oplus.anim.e_renamed.r_renamed.a_renamed(jsonReader, aVar, f_renamed, ajVar, true));
                        }
                    }
                    jsonReader.endArray();
                } else {
                    arrayList.add(com.oplus.anim.e_renamed.r_renamed.a_renamed(jsonReader, aVar, f_renamed, ajVar, false));
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        a_renamed(arrayList);
        return arrayList;
    }

    public static <T_renamed> void a_renamed(java.util.List<? extends com.oplus.anim.g_renamed.c_renamed<T_renamed>> list) {
        int i_renamed;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i_renamed = size - 1;
            if (i2 >= i_renamed) {
                break;
            }
            com.oplus.anim.g_renamed.c_renamed<T_renamed> cVar = list.get(i2);
            i2++;
            com.oplus.anim.g_renamed.c_renamed<T_renamed> cVar2 = list.get(i2);
            cVar.e_renamed = java.lang.Float.valueOf(cVar2.f3706c);
            if (cVar.d_renamed == null && cVar2.f3704a != null) {
                cVar.d_renamed = cVar2.f3704a;
                if (cVar instanceof com.oplus.anim.a_renamed.b_renamed.h_renamed) {
                    ((com.oplus.anim.a_renamed.b_renamed.h_renamed) cVar).a_renamed();
                }
            }
        }
        com.oplus.anim.g_renamed.c_renamed<T_renamed> cVar3 = list.get(i_renamed);
        if ((cVar3.f3704a == null || cVar3.d_renamed == null) && list.size() > 1) {
            list.remove(cVar3);
        }
    }
}
