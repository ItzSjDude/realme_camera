package com.oplus.camera.sticker.c_renamed;

/* compiled from: MD5Utils.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final char[] f5446a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A_renamed', 'B_renamed', 'C_renamed', 'D_renamed', 'E_renamed', 'F_renamed'};

    public static java.lang.String a_renamed(java.io.InputStream inputStream) throws java.security.NoSuchAlgorithmException, java.io.IOException {
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
        if (inputStream != null) {
            byte[] bArr = new byte[1024];
            while (true) {
                int i_renamed = inputStream.read(bArr);
                if (i_renamed != -1) {
                    messageDigest.update(bArr, 0, i_renamed);
                } else {
                    try {
                        break;
                    } catch (java.io.IOException e_renamed) {
                        e_renamed.printStackTrace();
                    }
                }
            }
            inputStream.close();
        }
        return a_renamed(messageDigest.digest());
    }

    public static java.lang.String a_renamed(java.lang.String str) throws java.security.NoSuchAlgorithmException, java.io.IOException {
        return a_renamed(new java.io.FileInputStream(str));
    }

    public static boolean a_renamed(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.oplus.camera.e_renamed.e_renamed("MD5Utils", "md5CheckSum, empty value! toBeCheckSum: " + str2);
            return false;
        }
        try {
            return a_renamed(str).equalsIgnoreCase(str2);
        } catch (java.io.IOException e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("MD5Utils", "md5CheckSum, IOException: " + e_renamed);
            return false;
        } catch (java.security.NoSuchAlgorithmException e2) {
            com.oplus.camera.e_renamed.e_renamed("MD5Utils", "md5CheckSum, NoSuchAlgorithmException: " + e2);
            return false;
        }
    }

    public static java.lang.String a_renamed(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (int i_renamed = 0; i_renamed < bArr.length; i_renamed++) {
            sb.append(f5446a[(bArr[i_renamed] & 240) >>> 4]);
            sb.append(f5446a[bArr[i_renamed] & 15]);
        }
        return sb.toString();
    }
}
