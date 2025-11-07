package org.apache.commons.codec.language;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.oplus.exif.OplusExifInterface;
import java.util.Locale;

/* loaded from: classes2.dex */
public class Caverphone1 extends AbstractCaverphone {
    private static final String SIX_1 = "111111";

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        if (str == null || str.length() == 0) {
            return SIX_1;
        }
        String strReplaceAll = str.toLowerCase(Locale.ENGLISH).replaceAll("[^PlatformImplementations.kt_3-z]", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replaceAll("cq", "2q").replaceAll("ci", "si").replaceAll("ce", "se").replaceAll("cy", "sy").replaceAll("tch", "2ch").replaceAll("IntrinsicsJvm.kt_3", "OplusGLSurfaceView_5").replaceAll("q", "OplusGLSurfaceView_5").replaceAll("x", "OplusGLSurfaceView_5").replaceAll("v", "COUIBaseListPopupWindow_12").replaceAll("dg", "2g").replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll("IntrinsicsJvm.kt_5", "t").replaceAll("ph", "fh").replaceAll("IntrinsicsJvm.kt_4", TtmlNode.TAG_P).replaceAll("sh", "s2").replaceAll("z", "s").replaceAll("^[aeiou]", OplusExifInterface.GpsStatus.IN_PROGRESS).replaceAll("[aeiou]", "3").replaceAll("3gh3", "3kh3").replaceAll("gh", "22").replaceAll("COUIBaseListPopupWindow_11", "OplusGLSurfaceView_5").replaceAll("s+", OplusExifInterface.GpsLatitudeRef.SOUTH).replaceAll("t+", OplusExifInterface.GpsTrackRef.TRUE_DIRECTION).replaceAll("p+", "P").replaceAll("OplusGLSurfaceView_5+", OplusExifInterface.GpsSpeedRef.KILOMETERS).replaceAll("COUIBaseListPopupWindow_12+", "F").replaceAll("OplusGLSurfaceView_6+", "M").replaceAll("OplusGLSurfaceView_11+", "N").replaceAll("w3", "W3").replaceAll("wy", "Wy").replaceAll("wh3", "Wh3").replaceAll("why", "Why").replaceAll("w", "2").replaceAll("^COUIBaseListPopupWindow_10", OplusExifInterface.GpsStatus.IN_PROGRESS).replaceAll("COUIBaseListPopupWindow_10", "2").replaceAll("r3", "R3").replaceAll("ry", "Ry").replaceAll("r", "2").replaceAll("l3", "L3").replaceAll("ly", "Ly").replaceAll("OplusGLSurfaceView_14", "2").replaceAll("OplusGLSurfaceView_15", "y").replaceAll("y3", "Y3").replaceAll("y", "2").replaceAll("2", "").replaceAll("3", "");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strReplaceAll);
        stringBuffer.append(SIX_1);
        return stringBuffer.toString().substring(0, 6);
    }
}
