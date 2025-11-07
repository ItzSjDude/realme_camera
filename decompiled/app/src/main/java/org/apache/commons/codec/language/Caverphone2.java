package org.apache.commons.codec.language;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.oplus.exif.OplusExifInterface;
import java.util.Locale;

/* loaded from: classes2.dex */
public class Caverphone2 extends AbstractCaverphone {
    private static final String TEN_1 = "1111111111";

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        if (str == null || str.length() == 0) {
            return TEN_1;
        }
        String strReplaceAll = str.toLowerCase(Locale.ENGLISH).replaceAll("[^PlatformImplementations.kt_3-z]", "").replaceAll("COUIBaseListPopupWindow_8$", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^trough", "trou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replaceAll("cq", "2q").replaceAll("ci", "si").replaceAll("ce", "se").replaceAll("cy", "sy").replaceAll("tch", "2ch").replaceAll("IntrinsicsJvm.kt_3", "OplusGLSurfaceView_5").replaceAll("q", "OplusGLSurfaceView_5").replaceAll("x", "OplusGLSurfaceView_5").replaceAll("v", "COUIBaseListPopupWindow_12").replaceAll("dg", "2g").replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll("IntrinsicsJvm.kt_5", "t").replaceAll("ph", "fh").replaceAll("IntrinsicsJvm.kt_4", TtmlNode.TAG_P).replaceAll("sh", "s2").replaceAll("z", "s").replaceAll("^[aeiou]", OplusExifInterface.GpsStatus.IN_PROGRESS).replaceAll("[aeiou]", "3").replaceAll("OplusGLSurfaceView_15", "y").replaceAll("^y3", "Y3").replaceAll("^y", OplusExifInterface.GpsStatus.IN_PROGRESS).replaceAll("y", "3").replaceAll("3gh3", "3kh3").replaceAll("gh", "22").replaceAll("COUIBaseListPopupWindow_11", "OplusGLSurfaceView_5").replaceAll("s+", OplusExifInterface.GpsLatitudeRef.SOUTH).replaceAll("t+", OplusExifInterface.GpsTrackRef.TRUE_DIRECTION).replaceAll("p+", "P").replaceAll("OplusGLSurfaceView_5+", OplusExifInterface.GpsSpeedRef.KILOMETERS).replaceAll("COUIBaseListPopupWindow_12+", "F").replaceAll("OplusGLSurfaceView_6+", "M").replaceAll("OplusGLSurfaceView_11+", "N").replaceAll("w3", "W3").replaceAll("wh3", "Wh3").replaceAll("w$", "3").replaceAll("w", "2").replaceAll("^COUIBaseListPopupWindow_10", OplusExifInterface.GpsStatus.IN_PROGRESS).replaceAll("COUIBaseListPopupWindow_10", "2").replaceAll("r3", "R3").replaceAll("r$", "3").replaceAll("r", "2").replaceAll("l3", "L3").replaceAll("OplusGLSurfaceView_14$", "3").replaceAll("OplusGLSurfaceView_14", "2").replaceAll("2", "").replaceAll("3$", OplusExifInterface.GpsStatus.IN_PROGRESS).replaceAll("3", "");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strReplaceAll);
        stringBuffer.append(TEN_1);
        return stringBuffer.toString().substring(0, 10);
    }
}
