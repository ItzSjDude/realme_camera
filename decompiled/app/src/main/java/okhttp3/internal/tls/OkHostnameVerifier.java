package okhttp3.internal.tls;

/* loaded from: classes2.dex */
public final class OkHostnameVerifier implements javax.net.ssl.HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final okhttp3.internal.tls.OkHostnameVerifier INSTANCE = new okhttp3.internal.tls.OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
        try {
            return verify(str, (java.security.cert.X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (javax.net.ssl.SSLException unused) {
            return false;
        }
    }

    public boolean verify(java.lang.String str, java.security.cert.X509Certificate x509Certificate) {
        if (okhttp3.internal.Util.verifyAsIpAddress(str)) {
            return verifyIpAddress(str, x509Certificate);
        }
        return verifyHostname(str, x509Certificate);
    }

    private boolean verifyIpAddress(java.lang.String str, java.security.cert.X509Certificate x509Certificate) throws java.security.cert.CertificateParsingException {
        java.util.List<java.lang.String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        int size = subjectAltNames.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            if (str.equalsIgnoreCase(subjectAltNames.get(i_renamed))) {
                return true;
            }
        }
        return false;
    }

    private boolean verifyHostname(java.lang.String str, java.security.cert.X509Certificate x509Certificate) {
        java.lang.String lowerCase = str.toLowerCase(java.util.Locale.US);
        java.util.Iterator<java.lang.String> it = getSubjectAltNames(x509Certificate, 2).iterator();
        while (it.hasNext()) {
            if (verifyHostname(lowerCase, it.next())) {
                return true;
            }
        }
        return false;
    }

    public static java.util.List<java.lang.String> allSubjectAltNames(java.security.cert.X509Certificate x509Certificate) throws java.security.cert.CertificateParsingException {
        java.util.List<java.lang.String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        java.util.List<java.lang.String> subjectAltNames2 = getSubjectAltNames(x509Certificate, 2);
        java.util.ArrayList arrayList = new java.util.ArrayList(subjectAltNames.size() + subjectAltNames2.size());
        arrayList.addAll(subjectAltNames);
        arrayList.addAll(subjectAltNames2);
        return arrayList;
    }

    private static java.util.List<java.lang.String> getSubjectAltNames(java.security.cert.X509Certificate x509Certificate, int i_renamed) throws java.security.cert.CertificateParsingException {
        java.lang.Integer num;
        java.lang.String str;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.util.Collection<java.util.List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return java.util.Collections.emptyList();
            }
            for (java.util.List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (java.lang.Integer) list.get(0)) != null && num.intValue() == i_renamed && (str = (java.lang.String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (java.security.cert.CertificateParsingException unused) {
            return java.util.Collections.emptyList();
        }
    }

    public boolean verifyHostname(java.lang.String str, java.lang.String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            java.lang.String lowerCase = str2.toLowerCase(java.util.Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            java.lang.String strSubstring = lowerCase.substring(1);
            if (!str.endsWith(strSubstring)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}
