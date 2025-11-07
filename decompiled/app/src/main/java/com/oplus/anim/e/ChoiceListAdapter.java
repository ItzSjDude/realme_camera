package com.oplus.anim.e_renamed;

/* compiled from: MergePathsParser.java */
/* loaded from: classes2.dex */
class v_renamed {
    static com.oplus.anim.c_renamed.b_renamed.h_renamed a_renamed(android.util.JsonReader jsonReader) throws java.io.IOException {
        java.lang.String strNextString = null;
        boolean zNextBoolean = false;
        com.oplus.anim.c_renamed.b_renamed.h_renamed.a_renamed aVarForId = null;
        while (jsonReader.hasNext()) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 3324) {
                if (iHashCode != 3488) {
                    if (iHashCode == 3519 && strNextName.equals("nm")) {
                        c2 = 0;
                    }
                } else if (strNextName.equals("mm")) {
                    c2 = 1;
                }
            } else if (strNextName.equals("hd")) {
                c2 = 2;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                aVarForId = com.oplus.anim.c_renamed.b_renamed.h_renamed.a_renamed.forId(jsonReader.nextInt());
            } else if (c2 == 2) {
                zNextBoolean = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.oplus.anim.c_renamed.b_renamed.h_renamed(strNextString, aVarForId, zNextBoolean);
    }
}
