package com.oplus.anim.e_renamed;

/* compiled from: FontParser.java */
/* loaded from: classes2.dex */
class l_renamed {
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    static com.oplus.anim.c_renamed.d_renamed a_renamed(android.util.JsonReader jsonReader) throws java.io.IOException {
        jsonReader.beginObject();
        java.lang.String strNextString = null;
        java.lang.String strNextString2 = null;
        float fNextDouble = 0.0f;
        java.lang.String strNextString3 = null;
        while (jsonReader.hasNext()) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            switch (strNextName.hashCode()) {
                case -1866931350:
                    if (strNextName.equals("fFamily")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1408684838:
                    if (strNextName.equals("ascent")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1294566165:
                    if (strNextName.equals("fStyle")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 96619537:
                    if (strNextName.equals("fName")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                strNextString3 = jsonReader.nextString();
            } else if (c2 == 2) {
                strNextString2 = jsonReader.nextString();
            } else if (c2 == 3) {
                fNextDouble = (float) jsonReader.nextDouble();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new com.oplus.anim.c_renamed.d_renamed(strNextString, strNextString3, strNextString2, fNextDouble);
    }
}
