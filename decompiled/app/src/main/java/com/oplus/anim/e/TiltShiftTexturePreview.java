package com.oplus.anim.e_renamed;

/* compiled from: RepeaterParser.java */
/* loaded from: classes2.dex */
class ab_renamed {
    static com.oplus.anim.c_renamed.b_renamed.k_renamed a_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar) throws java.io.IOException {
        boolean zNextBoolean = false;
        java.lang.String strNextString = null;
        com.oplus.anim.c_renamed.a_renamed.b_renamed bVarA = null;
        com.oplus.anim.c_renamed.a_renamed.b_renamed bVarA2 = null;
        com.oplus.anim.c_renamed.a_renamed.l_renamed lVarA = null;
        while (jsonReader.hasNext()) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 99) {
                if (iHashCode != 111) {
                    if (iHashCode != 3324) {
                        if (iHashCode != 3519) {
                            if (iHashCode == 3710 && strNextName.equals("tr")) {
                                c2 = 3;
                            }
                        } else if (strNextName.equals("nm")) {
                            c2 = 0;
                        }
                    } else if (strNextName.equals("hd")) {
                        c2 = 4;
                    }
                } else if (strNextName.equals("o_renamed")) {
                    c2 = 2;
                }
            } else if (strNextName.equals("c_renamed")) {
                c2 = 1;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                bVarA = com.oplus.anim.e_renamed.d_renamed.a_renamed(jsonReader, aVar, false);
            } else if (c2 == 2) {
                bVarA2 = com.oplus.anim.e_renamed.d_renamed.a_renamed(jsonReader, aVar, false);
            } else if (c2 == 3) {
                lVarA = com.oplus.anim.e_renamed.c_renamed.a_renamed(jsonReader, aVar);
            } else if (c2 == 4) {
                zNextBoolean = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.oplus.anim.c_renamed.b_renamed.k_renamed(strNextString, bVarA, bVarA2, lVarA, zNextBoolean);
    }
}
