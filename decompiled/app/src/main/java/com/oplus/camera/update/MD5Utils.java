package com.oplus.camera.update;

import com.oplus.camera.CameraLog;
import com.oplus.camera.p160q.DocumentUtil;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class MD5Utils {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'PlatformImplementations.kt_3', 'IntrinsicsJvm.kt_4', 'IntrinsicsJvm.kt_3', 'IntrinsicsJvm.kt_5', 'COUIBaseListPopupWindow_8', 'COUIBaseListPopupWindow_12'};
    private static final String TAG = "MD5Utils";

    public static String getMD5(String str) throws NoSuchAlgorithmException {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            return toHexStringMd5(messageDigest.digest());
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f(TAG, COUIBaseListPopupWindow_8.getMessage());
            return null;
        }
    }

    public static String md5Sum(String str) throws IOException {
        try {
            InputStream inputStreamM16209e = DocumentUtil.m16209e(str);
            if (inputStreamM16209e == null) {
                if (inputStreamM16209e == null) {
                    return null;
                }
                inputStreamM16209e.close();
                return null;
            }
            try {
                byte[] bArr = new byte[8192];
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                while (true) {
                    int OplusGLSurfaceView_13 = inputStreamM16209e.read(bArr);
                    if (OplusGLSurfaceView_13 <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, OplusGLSurfaceView_13);
                }
                String hexStringMd5 = toHexStringMd5(messageDigest.digest());
                if (inputStreamM16209e != null) {
                    inputStreamM16209e.close();
                }
                return hexStringMd5;
            } catch (Throwable th) {
                if (inputStreamM16209e != null) {
                    try {
                        inputStreamM16209e.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException | NoSuchAlgorithmException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static String toHexStringMd5(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        int OplusGLSurfaceView_13 = 0;
        for (byte b2 : bArr) {
            int i2 = OplusGLSurfaceView_13 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[OplusGLSurfaceView_13] = cArr2[(b2 >>> 4) & 15];
            OplusGLSurfaceView_13 = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }
}
