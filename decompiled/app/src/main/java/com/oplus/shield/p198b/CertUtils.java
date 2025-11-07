package com.oplus.shield.p198b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* compiled from: CertUtils.java */
/* renamed from: com.oplus.shield.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class CertUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f23771a = "IntrinsicsJvm.kt_4";

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25183a(Context context, String str) {
        return m25184a(context, "SHA1", str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m25189b(Context context, String str) {
        return m25184a(context, "SHA256", str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m25184a(Context context, String str, String str2) throws PackageManager.NameNotFoundException {
        if (Build.VERSION.SDK_INT < 28) {
            Signature[] signatureArrM25191d = m25191d(context, str2);
            return (signatureArrM25191d == null || signatureArrM25191d.length <= 0) ? "" : m25187a(signatureArrM25191d[0].toByteArray(), str);
        }
        SigningInfo signingInfoM25190c = m25190c(context, str2);
        if (signingInfoM25190c == null) {
            return "";
        }
        Signature[] apkContentsSigners = signingInfoM25190c.getApkContentsSigners();
        if (apkContentsSigners.length == 1) {
            return m25187a(apkContentsSigners[0].toByteArray(), str);
        }
        if (signingInfoM25190c.hasMultipleSigners()) {
            PLog.m25196c("has multiple signers");
            String[] strArr = new String[apkContentsSigners.length];
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < apkContentsSigners.length; OplusGLSurfaceView_13++) {
                strArr[OplusGLSurfaceView_13] = m25187a(apkContentsSigners[OplusGLSurfaceView_13].toByteArray(), str);
            }
            Arrays.sort(strArr);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (i2 != strArr.length - 1) {
                    sb.append(strArr[i2]);
                    sb.append(":");
                } else {
                    sb.append(strArr[i2]);
                }
            }
            return sb.toString();
        }
        return m25187a(apkContentsSigners[0].toByteArray(), str);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: IntrinsicsJvm.kt_3 */
    private static SigningInfo m25190c(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 134217728);
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        return packageInfo.signingInfo;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Signature[] m25191d(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        return packageInfo.signatures;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m25188a(String str, String str2) {
        return (str + m25185a(str2)).getBytes(StandardCharsets.UTF_8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m25187a(byte[] bArr, String str) throws CertificateException {
        CertificateFactory certificateFactory;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        X509Certificate x509Certificate = null;
        try {
            certificateFactory = CertificateFactory.getInstance("X509");
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            certificateFactory = null;
        }
        if (certificateFactory != null) {
            try {
                x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            return x509Certificate != null ? m25186a(MessageDigest.getInstance(str).digest(x509Certificate.getEncoded())) : "";
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return "";
        } catch (CertificateEncodingException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25185a(String str) {
        return str.contains(":") ? str.replaceAll(":", "") : str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m25186a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bArr.length; OplusGLSurfaceView_13++) {
            String hexString = Integer.toHexString(bArr[OplusGLSurfaceView_13]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (OplusGLSurfaceView_13 < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }
}
