package com.oplus.camera.sticker.b_renamed;

/* compiled from: TrustAllCerts.java */
/* loaded from: classes2.dex */
public class c_renamed implements javax.net.ssl.X509TrustManager {
    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        if (x509CertificateArr == null) {
            throw new java.lang.IllegalArgumentException("X509Certificate array is_renamed null.");
        }
        if (x509CertificateArr.length == 0) {
            throw new java.lang.IllegalArgumentException("X509Certificate array is_renamed empty.");
        }
        for (java.security.cert.X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity();
            } catch (java.lang.Exception unused) {
                throw new java.security.cert.CertificateException("X509Certificate has expired, not valid or untrusted.");
            }
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        if (x509CertificateArr == null) {
            throw new java.lang.IllegalArgumentException("X509Certificate array is_renamed null.");
        }
        if (x509CertificateArr.length == 0) {
            throw new java.lang.IllegalArgumentException("X509Certificate array is_renamed empty.");
        }
        for (java.security.cert.X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity();
            } catch (java.lang.Exception unused) {
                throw new java.security.cert.CertificateException("X509Certificate has expired, not valid or untrusted.");
            }
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return new java.security.cert.X509Certificate[0];
    }

    public static javax.net.ssl.SSLSocketFactory a_renamed() throws java.security.NoSuchAlgorithmException, java.security.KeyManagementException {
        try {
            javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
            sSLContext.init(null, new javax.net.ssl.TrustManager[]{new com.oplus.camera.sticker.b_renamed.c_renamed()}, new java.security.SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }
}
