package com.heytap.accessory.b_renamed;

/* compiled from: HexUtils.java */
/* loaded from: classes2.dex */
public class e_renamed {
    public static byte[] a_renamed(java.lang.String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        try {
            byte[] bArr = new byte[str.length() / 2];
            for (int i_renamed = 0; i_renamed < bArr.length; i_renamed++) {
                int i2 = i_renamed * 2;
                bArr[i_renamed] = (byte) java.lang.Integer.parseInt(str.substring(i2, i2 + 2), 16);
            }
            return bArr;
        } catch (java.lang.NumberFormatException e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a_renamed(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return a_renamed(bArr, 0, bArr.length);
    }

    public static java.lang.String a_renamed(byte[] bArr, int i_renamed, int i2) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        if (i_renamed + i2 > bArr.length) {
            return "convert byte array, out of_renamed index, offset:" + i_renamed + ", length:" + i2 + ", byteLength:" + bArr.length;
        }
        char[] charArray = "0123456789ABCDEF".toCharArray();
        char[] cArr = new char[i2 * 2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i_renamed + i3] & 255;
            int i5 = i3 * 2;
            cArr[i5] = charArray[i4 >>> 4];
            cArr[i5 + 1] = charArray[i4 & 15];
        }
        return new java.lang.String(cArr);
    }

    public static java.lang.String b_renamed(byte[] bArr) {
        return a_renamed(a_renamed(bArr), 4);
    }

    public static java.lang.String b_renamed(java.lang.String str) {
        return a_renamed(str, 5);
    }

    public static java.lang.String c_renamed(java.lang.String str) {
        return a_renamed(str, 4);
    }

    public static java.lang.String a_renamed(java.lang.String str, int i_renamed) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("***");
        for (int iMin = java.lang.Math.min(str.length(), i_renamed); iMin > 0; iMin--) {
            sb.append(str.charAt(str.length() - iMin));
        }
        return sb.toString();
    }
}
