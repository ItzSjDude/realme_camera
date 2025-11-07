package com.oplus.anim.e_renamed;

/* compiled from: RectangleShapeParser.java */
/* loaded from: classes2.dex */
class aa_renamed {
    static com.oplus.anim.c_renamed.b_renamed.j_renamed a_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar) throws java.io.IOException {
        boolean zNextBoolean = false;
        java.lang.String strNextString = null;
        com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVarB = null;
        com.oplus.anim.c_renamed.a_renamed.f_renamed fVarC = null;
        com.oplus.anim.c_renamed.a_renamed.b_renamed bVarA = null;
        while (jsonReader.hasNext()) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 112) {
                if (iHashCode != 3324) {
                    if (iHashCode != 3519) {
                        if (iHashCode != 114) {
                            if (iHashCode == 115 && strNextName.equals("s_renamed")) {
                                c2 = 2;
                            }
                        } else if (strNextName.equals("r_renamed")) {
                            c2 = 3;
                        }
                    } else if (strNextName.equals("nm")) {
                        c2 = 0;
                    }
                } else if (strNextName.equals("hd")) {
                    c2 = 4;
                }
            } else if (strNextName.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_P)) {
                c2 = 1;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                mVarB = com.oplus.anim.e_renamed.a_renamed.b_renamed(jsonReader, aVar);
            } else if (c2 == 2) {
                fVarC = com.oplus.anim.e_renamed.d_renamed.c_renamed(jsonReader, aVar);
            } else if (c2 == 3) {
                bVarA = com.oplus.anim.e_renamed.d_renamed.a_renamed(jsonReader, aVar);
            } else if (c2 == 4) {
                zNextBoolean = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.oplus.anim.c_renamed.b_renamed.j_renamed(strNextString, mVarB, fVarC, bVarA, zNextBoolean);
    }
}
