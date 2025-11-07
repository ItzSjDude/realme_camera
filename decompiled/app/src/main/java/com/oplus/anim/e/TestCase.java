package com.oplus.anim.e_renamed;

/* compiled from: CircleShapeParser.java */
/* loaded from: classes2.dex */
class e_renamed {
    static com.oplus.anim.c_renamed.b_renamed.a_renamed a_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar, int i_renamed) throws java.io.IOException {
        boolean z_renamed = i_renamed == 3;
        boolean zNextBoolean = false;
        java.lang.String strNextString = null;
        com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVarB = null;
        com.oplus.anim.c_renamed.a_renamed.f_renamed fVarC = null;
        while (jsonReader.hasNext()) {
            java.lang.String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 100) {
                if (iHashCode != 112) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3324) {
                            if (iHashCode == 3519 && strNextName.equals("nm")) {
                                c2 = 0;
                            }
                        } else if (strNextName.equals("hd")) {
                            c2 = 3;
                        }
                    } else if (strNextName.equals("s_renamed")) {
                        c2 = 2;
                    }
                } else if (strNextName.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_P)) {
                    c2 = 1;
                }
            } else if (strNextName.equals("d_renamed")) {
                c2 = 4;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                mVarB = com.oplus.anim.e_renamed.a_renamed.b_renamed(jsonReader, aVar);
            } else if (c2 == 2) {
                fVarC = com.oplus.anim.e_renamed.d_renamed.c_renamed(jsonReader, aVar);
            } else if (c2 == 3) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (c2 == 4) {
                z_renamed = jsonReader.nextInt() == 3;
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.oplus.anim.c_renamed.b_renamed.a_renamed(strNextString, mVarB, fVarC, z_renamed, zNextBoolean);
    }
}
