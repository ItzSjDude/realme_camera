package com.oplus.anim.e_renamed;

/* compiled from: ShapeGroupParser.java */
/* loaded from: classes2.dex */
class af_renamed {
    static com.oplus.anim.c_renamed.b_renamed.n_renamed a_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String strNextString = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 3324) {
                if (iHashCode != 3371) {
                    if (iHashCode == 3519 && strNextName.equals("nm")) {
                        c2 = 0;
                    }
                } else if (strNextName.equals("it")) {
                    c2 = 2;
                }
            } else if (strNextName.equals("hd")) {
                c2 = 1;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (c2 == 2) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.oplus.anim.c_renamed.b_renamed.b_renamed bVarA = com.oplus.anim.e_renamed.g_renamed.a_renamed(jsonReader, aVar);
                    if (bVarA != null) {
                        arrayList.add(bVarA);
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.oplus.anim.c_renamed.b_renamed.n_renamed(strNextString, arrayList, zNextBoolean);
    }
}
