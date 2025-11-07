package com.oplus.camera.sticker.p166b;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: TrustAllCerts.java */
/* renamed from: com.oplus.camera.sticker.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class TrustAllCerts implements X509TrustManager {
    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr == null) {
            throw new IllegalArgumentException("X509Certificate array is null.");
        }
        if (x509CertificateArr.length == 0) {
            throw new IllegalArgumentException("X509Certificate array is empty.");
        }
        for (X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity();
            } catch (Exception unused) {
                throw new CertificateException("X509Certificate has expired, not valid or untrusted.");
            }
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr == null) {
            throw new IllegalArgumentException("X509Certificate array is null.");
        }
        if (x509CertificateArr.length == 0) {
            throw new IllegalArgumentException("X509Certificate array is empty.");
        }
        for (X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity();
            } catch (Exception unused) {
                throw new CertificateException("X509Certificate has expired, not valid or untrusted.");
            }
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static SSLSocketFactory m16796a() throws NoSuchAlgorithmException, KeyManagementException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new TrustAllCerts()}, new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }
}
