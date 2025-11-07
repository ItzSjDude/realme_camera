package com.heytap.accessory.p104b;

import android.text.TextUtils;

/* compiled from: HexUtils.java */
/* renamed from: com.heytap.accessory.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class HexUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m8588a(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        try {
            byte[] bArr = new byte[str.length() / 2];
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bArr.length; OplusGLSurfaceView_13++) {
                int i2 = OplusGLSurfaceView_13 * 2;
                bArr[OplusGLSurfaceView_13] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
            }
            return bArr;
        } catch (NumberFormatException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m8586a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return m8587a(bArr, 0, bArr.length);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m8587a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        if (OplusGLSurfaceView_13 + i2 > bArr.length) {
            return "convert byte array, out of index, offset:" + OplusGLSurfaceView_13 + ", length:" + i2 + ", byteLength:" + bArr.length;
        }
        char[] charArray = "0123456789ABCDEF".toCharArray();
        char[] cArr = new char[i2 * 2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[OplusGLSurfaceView_13 + i3] & 255;
            int i5 = i3 * 2;
            cArr[i5] = charArray[i4 >>> 4];
            cArr[i5 + 1] = charArray[i4 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m8590b(byte[] bArr) {
        return m8585a(m8586a(bArr), 4);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m8589b(String str) {
        return m8585a(str, 5);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static String m8591c(String str) {
        return m8585a(str, 4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m8585a(String str, int OplusGLSurfaceView_13) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder("***");
        for (int iMin = Math.min(str.length(), OplusGLSurfaceView_13); iMin > 0; iMin--) {
            sb.append(str.charAt(str.length() - iMin));
        }
        return sb.toString();
    }
}
