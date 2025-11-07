package com.oplus.anim.e_renamed;

/* compiled from: ShapePathParser.java */
/* loaded from: classes2.dex */
class ag_renamed {
    static com.oplus.anim.c_renamed.b_renamed.o_renamed a_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar) throws java.io.IOException {
        java.lang.String strNextString = null;
        com.oplus.anim.c_renamed.a_renamed.h_renamed hVarE = null;
        int iNextInt = 0;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 3324) {
                if (iHashCode != 3432) {
                    if (iHashCode != 3519) {
                        if (iHashCode == 104415 && strNextName.equals("ind")) {
                            c2 = 1;
                        }
                    } else if (strNextName.equals("nm")) {
                        c2 = 0;
                    }
                } else if (strNextName.equals("ks")) {
                    c2 = 2;
                }
            } else if (strNextName.equals("hd")) {
                c2 = 3;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                iNextInt = jsonReader.nextInt();
            } else if (c2 == 2) {
                hVarE = com.oplus.anim.e_renamed.d_renamed.e_renamed(jsonReader, aVar);
            } else if (c2 == 3) {
                zNextBoolean = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.oplus.anim.c_renamed.b_renamed.o_renamed(strNextString, iNextInt, hVarE, zNextBoolean);
    }
}
