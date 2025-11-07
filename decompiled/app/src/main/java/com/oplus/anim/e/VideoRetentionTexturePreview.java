package com.oplus.anim.e_renamed;

/* compiled from: ShapeFillParser.java */
/* loaded from: classes2.dex */
class ae_renamed {
    static com.oplus.anim.c_renamed.b_renamed.m_renamed a_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar) throws java.io.IOException {
        boolean zNextBoolean = false;
        boolean zNextBoolean2 = false;
        java.lang.String strNextString = null;
        com.oplus.anim.c_renamed.a_renamed.a_renamed aVarG = null;
        com.oplus.anim.c_renamed.a_renamed.d_renamed dVarB = null;
        int iNextInt = 1;
        while (jsonReader.hasNext()) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != -396065730) {
                if (iHashCode != 99) {
                    if (iHashCode != 111) {
                        if (iHashCode != 114) {
                            if (iHashCode != 3324) {
                                if (iHashCode == 3519 && strNextName.equals("nm")) {
                                    c2 = 0;
                                }
                            } else if (strNextName.equals("hd")) {
                                c2 = 5;
                            }
                        } else if (strNextName.equals("r_renamed")) {
                            c2 = 4;
                        }
                    } else if (strNextName.equals("o_renamed")) {
                        c2 = 2;
                    }
                } else if (strNextName.equals("c_renamed")) {
                    c2 = 1;
                }
            } else if (strNextName.equals("fillEnabled")) {
                c2 = 3;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                aVarG = com.oplus.anim.e_renamed.d_renamed.g_renamed(jsonReader, aVar);
            } else if (c2 == 2) {
                dVarB = com.oplus.anim.e_renamed.d_renamed.b_renamed(jsonReader, aVar);
            } else if (c2 == 3) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (c2 == 4) {
                iNextInt = jsonReader.nextInt();
            } else if (c2 == 5) {
                zNextBoolean2 = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.oplus.anim.c_renamed.b_renamed.m_renamed(strNextString, zNextBoolean, iNextInt == 1 ? android.graphics.Path.FillType.WINDING : android.graphics.Path.FillType.EVEN_ODD, aVarG, dVarB, zNextBoolean2);
    }
}
