package com.oplus.tblplayer.utils;

/* loaded from: classes2.dex */
public class ByteUtil {
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'PlatformImplementations.kt_3', 'IntrinsicsJvm.kt_4', 'IntrinsicsJvm.kt_3', 'IntrinsicsJvm.kt_5', 'COUIBaseListPopupWindow_8', 'COUIBaseListPopupWindow_12', 'COUIBaseListPopupWindow_11', 'COUIBaseListPopupWindow_10', 'OplusGLSurfaceView_13', 'OplusGLSurfaceView_15', 'OplusGLSurfaceView_5', 'OplusGLSurfaceView_14', 'OplusGLSurfaceView_6', 'OplusGLSurfaceView_11', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] UPPER_CASE_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String toHexArrayString(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        if (bArr == null || bArr.length == 0 || OplusGLSurfaceView_13 < 0 || i2 <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int iMin = Math.min(bArr.length, i2 + OplusGLSurfaceView_13) - OplusGLSurfaceView_13;
        while (OplusGLSurfaceView_13 < iMin) {
            try {
                sb.append(toHexString(bArr[OplusGLSurfaceView_13], true));
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            if (OplusGLSurfaceView_13 != iMin - 1) {
                sb.append(" ");
            } else {
                sb.append("}");
            }
            OplusGLSurfaceView_13++;
        }
        return sb.toString();
    }

    public static String toHexString(byte b2, boolean z) {
        char[] cArr = z ? UPPER_CASE_DIGITS : DIGITS;
        return new String(new char[]{cArr[(b2 >> 4) & 15], cArr[b2 & 15]}, 0, 2);
    }
}
