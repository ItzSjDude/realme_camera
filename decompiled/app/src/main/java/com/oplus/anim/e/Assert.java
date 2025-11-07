package com.oplus.anim.e_renamed;

/* compiled from: AnimatablePathValueParser.java */
/* loaded from: classes2.dex */
public class a_renamed {
    public static com.oplus.anim.c_renamed.a_renamed.e_renamed a_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jsonReader.peek() == android.util.JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(com.oplus.anim.e_renamed.w_renamed.a_renamed(jsonReader, aVar));
            }
            jsonReader.endArray();
            com.oplus.anim.e_renamed.s_renamed.a_renamed(arrayList);
        } else {
            arrayList.add(new com.oplus.anim.g_renamed.c_renamed(com.oplus.anim.e_renamed.q_renamed.b_renamed(jsonReader, com.oplus.anim.f_renamed.g_renamed.a_renamed())));
        }
        return new com.oplus.anim.c_renamed.a_renamed.e_renamed(arrayList);
    }

    static com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> b_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar) throws java.io.IOException {
        jsonReader.beginObject();
        com.oplus.anim.c_renamed.a_renamed.e_renamed eVarA = null;
        com.oplus.anim.c_renamed.a_renamed.b_renamed bVarA = null;
        com.oplus.anim.c_renamed.a_renamed.b_renamed bVarA2 = null;
        boolean z_renamed = false;
        while (jsonReader.peek() != android.util.JsonToken.END_OBJECT) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 107) {
                if (iHashCode != 120) {
                    if (iHashCode == 121 && strNextName.equals("y_renamed")) {
                        c2 = 2;
                    }
                } else if (strNextName.equals("x_renamed")) {
                    c2 = 1;
                }
            } else if (strNextName.equals("k_renamed")) {
                c2 = 0;
            }
            if (c2 == 0) {
                eVarA = a_renamed(jsonReader, aVar);
            } else if (c2 != 1) {
                if (c2 == 2) {
                    if (jsonReader.peek() == android.util.JsonToken.STRING) {
                        jsonReader.skipValue();
                        z_renamed = true;
                    } else {
                        bVarA2 = com.oplus.anim.e_renamed.d_renamed.a_renamed(jsonReader, aVar);
                    }
                } else {
                    jsonReader.skipValue();
                }
            } else if (jsonReader.peek() == android.util.JsonToken.STRING) {
                jsonReader.skipValue();
                z_renamed = true;
            } else {
                bVarA = com.oplus.anim.e_renamed.d_renamed.a_renamed(jsonReader, aVar);
            }
        }
        jsonReader.endObject();
        if (z_renamed) {
            aVar.a_renamed("EffectiveAnimation doesn't_renamed support expressions.");
        }
        return eVarA != null ? eVarA : new com.oplus.anim.c_renamed.a_renamed.i_renamed(bVarA, bVarA2);
    }
}
