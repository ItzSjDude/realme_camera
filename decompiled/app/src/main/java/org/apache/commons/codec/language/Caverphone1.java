package org.apache.commons.codec.language;

/* loaded from: classes2.dex */
public class Caverphone1 extends org.apache.commons.codec.language.AbstractCaverphone {
    private static final java.lang.String SIX_1 = "111111";

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return SIX_1;
        }
        java.lang.String strReplaceAll = str.toLowerCase(java.util.Locale.ENGLISH).replaceAll("[^a_renamed-z_renamed]", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^gn_renamed", "2n").replaceAll("mb$", "m2").replaceAll("cq_renamed", "2q").replaceAll("ci_renamed", "si").replaceAll("ce_renamed", "se").replaceAll("cy_renamed", "sy").replaceAll("tch", "2ch").replaceAll("c_renamed", "k_renamed").replaceAll("q_renamed", "k_renamed").replaceAll("x_renamed", "k_renamed").replaceAll("v_renamed", "f_renamed").replaceAll("dg_renamed", "2g").replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll("d_renamed", "t_renamed").replaceAll("ph", "fh_renamed").replaceAll("b_renamed", com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_P).replaceAll("sh", "s2").replaceAll("z_renamed", "s_renamed").replaceAll("^[aeiou]", com.oplus.exif.OplusExifInterface.GpsStatus.IN_PROGRESS).replaceAll("[aeiou]", "3").replaceAll("3gh3", "3kh3").replaceAll("gh_renamed", "22").replaceAll("g_renamed", "k_renamed").replaceAll("s_renamed+", com.oplus.exif.OplusExifInterface.GpsLatitudeRef.SOUTH).replaceAll("t_renamed+", com.oplus.exif.OplusExifInterface.GpsTrackRef.TRUE_DIRECTION).replaceAll("p_renamed+", "P_renamed").replaceAll("k_renamed+", com.oplus.exif.OplusExifInterface.GpsSpeedRef.KILOMETERS).replaceAll("f_renamed+", "F_renamed").replaceAll("m_renamed+", "M_renamed").replaceAll("n_renamed+", "N_renamed").replaceAll("w3", "W3").replaceAll("wy", "Wy").replaceAll("wh3", "Wh3").replaceAll("why", "Why").replaceAll("w_renamed", "2").replaceAll("^h_renamed", com.oplus.exif.OplusExifInterface.GpsStatus.IN_PROGRESS).replaceAll("h_renamed", "2").replaceAll("r3", "R3").replaceAll("ry", "Ry").replaceAll("r_renamed", "2").replaceAll("l3", "L3_renamed").replaceAll("ly", "Ly").replaceAll("l_renamed", "2").replaceAll("j_renamed", "y_renamed").replaceAll("y3", "Y3").replaceAll("y_renamed", "2").replaceAll("2", "").replaceAll("3", "");
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(strReplaceAll);
        stringBuffer.append(SIX_1);
        return stringBuffer.toString().substring(0, 6);
    }
}
