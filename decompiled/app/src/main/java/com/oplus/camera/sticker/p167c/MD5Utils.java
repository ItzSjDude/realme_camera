package com.oplus.camera.sticker.p167c;

import android.text.TextUtils;
import com.oplus.camera.CameraLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5Utils.java */
/* renamed from: com.oplus.camera.sticker.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class MD5Utils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final char[] f16225a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m16820a(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (inputStream != null) {
            byte[] bArr = new byte[1024];
            while (true) {
                int OplusGLSurfaceView_13 = inputStream.read(bArr);
                if (OplusGLSurfaceView_13 != -1) {
                    messageDigest.update(bArr, 0, OplusGLSurfaceView_13);
                } else {
                    try {
                        break;
                    } catch (IOException COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                    }
                }
            }
            inputStream.close();
        }
        return m16822a(messageDigest.digest());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m16821a(String str) throws NoSuchAlgorithmException, IOException {
        return m16820a(new FileInputStream(str));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m16823a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            CameraLog.m12966e("MD5Utils", "md5CheckSum, empty value! toBeCheckSum: " + str2);
            return false;
        }
        try {
            return m16821a(str).equalsIgnoreCase(str2);
        } catch (IOException COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("MD5Utils", "md5CheckSum, IOException: " + COUIBaseListPopupWindow_8);
            return false;
        } catch (NoSuchAlgorithmException e2) {
            CameraLog.m12966e("MD5Utils", "md5CheckSum, NoSuchAlgorithmException: " + e2);
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m16822a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bArr.length; OplusGLSurfaceView_13++) {
            sb.append(f16225a[(bArr[OplusGLSurfaceView_13] & 240) >>> 4]);
            sb.append(f16225a[bArr[OplusGLSurfaceView_13] & 15]);
        }
        return sb.toString();
    }
}
