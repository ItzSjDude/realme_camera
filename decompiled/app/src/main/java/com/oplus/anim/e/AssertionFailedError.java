package com.oplus.anim.e_renamed;

/* compiled from: AnimatableTextPropertiesParser.java */
/* loaded from: classes2.dex */
public class b_renamed {
    public static com.oplus.anim.c_renamed.a_renamed.k_renamed a_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar) throws java.io.IOException {
        jsonReader.beginObject();
        com.oplus.anim.c_renamed.a_renamed.k_renamed kVarB = null;
        while (jsonReader.hasNext()) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            if (strNextName.hashCode() == 97 && strNextName.equals("a_renamed")) {
                c2 = 0;
            }
            if (c2 == 0) {
                kVarB = b_renamed(jsonReader, aVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return kVarB == null ? new com.oplus.anim.c_renamed.a_renamed.k_renamed(null, null, null, null) : kVarB;
    }

    private static com.oplus.anim.c_renamed.a_renamed.k_renamed b_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar) throws java.io.IOException {
        jsonReader.beginObject();
        com.oplus.anim.c_renamed.a_renamed.a_renamed aVarG = null;
        com.oplus.anim.c_renamed.a_renamed.a_renamed aVarG2 = null;
        com.oplus.anim.c_renamed.a_renamed.b_renamed bVarA = null;
        com.oplus.anim.c_renamed.a_renamed.b_renamed bVarA2 = null;
        while (jsonReader.hasNext()) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 116) {
                if (iHashCode != 3261) {
                    if (iHashCode != 3664) {
                        if (iHashCode == 3684 && strNextName.equals("sw")) {
                            c2 = 2;
                        }
                    } else if (strNextName.equals("sc")) {
                        c2 = 1;
                    }
                } else if (strNextName.equals("fc_renamed")) {
                    c2 = 0;
                }
            } else if (strNextName.equals("t_renamed")) {
                c2 = 3;
            }
            if (c2 == 0) {
                aVarG = com.oplus.anim.e_renamed.d_renamed.g_renamed(jsonReader, aVar);
            } else if (c2 == 1) {
                aVarG2 = com.oplus.anim.e_renamed.d_renamed.g_renamed(jsonReader, aVar);
            } else if (c2 == 2) {
                bVarA = com.oplus.anim.e_renamed.d_renamed.a_renamed(jsonReader, aVar);
            } else if (c2 == 3) {
                bVarA2 = com.oplus.anim.e_renamed.d_renamed.a_renamed(jsonReader, aVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new com.oplus.anim.c_renamed.a_renamed.k_renamed(aVarG, aVarG2, bVarA, bVarA2);
    }
}
