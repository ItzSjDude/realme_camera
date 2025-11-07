package com.oplus.camera.update;

/* loaded from: classes2.dex */
public class MD5Utils {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a_renamed', 'b_renamed', 'c_renamed', 'd_renamed', 'e_renamed', 'f_renamed'};
    private static final java.lang.String TAG = "MD5Utils";

    public static java.lang.String getMD5(java.lang.String str) throws java.security.NoSuchAlgorithmException {
        try {
            byte[] bytes = str.getBytes();
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            return toHexStringMd5(messageDigest.digest());
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed(TAG, e_renamed.getMessage());
            return null;
        }
    }

    public static java.lang.String md5Sum(java.lang.String str) throws java.io.IOException {
        try {
            java.io.InputStream inputStreamE = com.oplus.camera.q_renamed.a_renamed.e_renamed(str);
            if (inputStreamE == null) {
                if (inputStreamE == null) {
                    return null;
                }
                inputStreamE.close();
                return null;
            }
            try {
                byte[] bArr = new byte[8192];
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                while (true) {
                    int i_renamed = inputStreamE.read(bArr);
                    if (i_renamed <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i_renamed);
                }
                java.lang.String hexStringMd5 = toHexStringMd5(messageDigest.digest());
                if (inputStreamE != null) {
                    inputStreamE.close();
                }
                return hexStringMd5;
            } catch (java.lang.Throwable th) {
                if (inputStreamE != null) {
                    try {
                        inputStreamE.close();
                    } catch (java.lang.Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (java.io.IOException | java.security.NoSuchAlgorithmException e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static java.lang.String toHexStringMd5(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        int i_renamed = 0;
        for (byte b2 : bArr) {
            int i2 = i_renamed + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i_renamed] = cArr2[(b2 >>> 4) & 15];
            i_renamed = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new java.lang.String(cArr);
    }
}
