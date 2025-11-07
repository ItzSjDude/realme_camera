package com.oplus.shield.b_renamed;

/* compiled from: CertUtils.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f7630a = "b_renamed";

    public static java.lang.String a_renamed(android.content.Context context, java.lang.String str) {
        return a_renamed(context, "SHA1", str);
    }

    public static java.lang.String b_renamed(android.content.Context context, java.lang.String str) {
        return a_renamed(context, "SHA256", str);
    }

    private static java.lang.String a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) throws android.content.pm.PackageManager.NameNotFoundException {
        if (android.os.Build.VERSION.SDK_INT < 28) {
            android.content.pm.Signature[] signatureArrD = d_renamed(context, str2);
            return (signatureArrD == null || signatureArrD.length <= 0) ? "" : a_renamed(signatureArrD[0].toByteArray(), str);
        }
        android.content.pm.SigningInfo signingInfoC = c_renamed(context, str2);
        if (signingInfoC == null) {
            return "";
        }
        android.content.pm.Signature[] apkContentsSigners = signingInfoC.getApkContentsSigners();
        if (apkContentsSigners.length == 1) {
            return a_renamed(apkContentsSigners[0].toByteArray(), str);
        }
        if (signingInfoC.hasMultipleSigners()) {
            com.oplus.shield.b_renamed.d_renamed.c_renamed("has multiple signers");
            java.lang.String[] strArr = new java.lang.String[apkContentsSigners.length];
            for (int i_renamed = 0; i_renamed < apkContentsSigners.length; i_renamed++) {
                strArr[i_renamed] = a_renamed(apkContentsSigners[i_renamed].toByteArray(), str);
            }
            java.util.Arrays.sort(strArr);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
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
        return a_renamed(apkContentsSigners[0].toByteArray(), str);
    }

    @android.annotation.SuppressLint({"NewApi"})
    private static android.content.pm.SigningInfo c_renamed(android.content.Context context, java.lang.String str) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 134217728);
        } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
            e_renamed.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        return packageInfo.signingInfo;
    }

    private static android.content.pm.Signature[] d_renamed(android.content.Context context, java.lang.String str) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 64);
        } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
            e_renamed.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        return packageInfo.signatures;
    }

    public static byte[] a_renamed(java.lang.String str, java.lang.String str2) {
        return (str + a_renamed(str2)).getBytes(java.nio.charset.StandardCharsets.UTF_8);
    }

    private static java.lang.String a_renamed(byte[] bArr, java.lang.String str) throws java.security.cert.CertificateException {
        java.security.cert.CertificateFactory certificateFactory;
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        java.security.cert.X509Certificate x509Certificate = null;
        try {
            certificateFactory = java.security.cert.CertificateFactory.getInstance("X509");
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            certificateFactory = null;
        }
        if (certificateFactory != null) {
            try {
                x509Certificate = (java.security.cert.X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            return x509Certificate != null ? a_renamed(java.security.MessageDigest.getInstance(str).digest(x509Certificate.getEncoded())) : "";
        } catch (java.security.NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return "";
        } catch (java.security.cert.CertificateEncodingException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static java.lang.String a_renamed(java.lang.String str) {
        return str.contains(":") ? str.replaceAll(":", "") : str;
    }

    private static java.lang.String a_renamed(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (int i_renamed = 0; i_renamed < bArr.length; i_renamed++) {
            java.lang.String hexString = java.lang.Integer.toHexString(bArr[i_renamed]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i_renamed < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }
}
