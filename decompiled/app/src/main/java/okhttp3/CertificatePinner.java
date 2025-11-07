package okhttp3;

/* loaded from: classes2.dex */
public final class CertificatePinner {
    public static final okhttp3.CertificatePinner DEFAULT = new okhttp3.CertificatePinner.Builder().build();

    @javax.annotation.Nullable
    private final okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner;
    private final java.util.Set<okhttp3.CertificatePinner.Pin> pins;

    CertificatePinner(java.util.Set<okhttp3.CertificatePinner.Pin> set, @javax.annotation.Nullable okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof okhttp3.CertificatePinner) {
            okhttp3.CertificatePinner certificatePinner = (okhttp3.CertificatePinner) obj;
            if (okhttp3.internal.Util.equal(this.certificateChainCleaner, certificatePinner.certificateChainCleaner) && this.pins.equals(certificatePinner.pins)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return ((certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0) * 31) + this.pins.hashCode();
    }

    public void check(java.lang.String str, java.util.List<java.security.cert.Certificate> list) throws javax.net.ssl.SSLPeerUnverifiedException {
        java.util.List<okhttp3.CertificatePinner.Pin> listFindMatchingPins = findMatchingPins(str);
        if (listFindMatchingPins.isEmpty()) {
            return;
        }
        okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        if (certificateChainCleaner != null) {
            list = certificateChainCleaner.clean(list, str);
        }
        int size = list.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) list.get(i_renamed);
            int size2 = listFindMatchingPins.size();
            okio.ByteString byteStringSha256 = null;
            okio.ByteString byteStringSha1 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                okhttp3.CertificatePinner.Pin pin = listFindMatchingPins.get(i2);
                if (pin.hashAlgorithm.equals("sha256/")) {
                    if (byteStringSha256 == null) {
                        byteStringSha256 = sha256(x509Certificate);
                    }
                    if (pin.hash.equals(byteStringSha256)) {
                        return;
                    }
                } else if (pin.hashAlgorithm.equals("sha1/")) {
                    if (byteStringSha1 == null) {
                        byteStringSha1 = sha1(x509Certificate);
                    }
                    if (pin.hash.equals(byteStringSha1)) {
                        return;
                    }
                } else {
                    throw new java.lang.AssertionError("unsupported hashAlgorithm: " + pin.hashAlgorithm);
                }
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n_renamed  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            java.security.cert.X509Certificate x509Certificate2 = (java.security.cert.X509Certificate) list.get(i3);
            sb.append("\n_renamed    ");
            sb.append(pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n_renamed  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = listFindMatchingPins.size();
        for (int i4 = 0; i4 < size4; i4++) {
            okhttp3.CertificatePinner.Pin pin2 = listFindMatchingPins.get(i4);
            sb.append("\n_renamed    ");
            sb.append(pin2);
        }
        throw new javax.net.ssl.SSLPeerUnverifiedException(sb.toString());
    }

    public void check(java.lang.String str, java.security.cert.Certificate... certificateArr) throws javax.net.ssl.SSLPeerUnverifiedException {
        check(str, java.util.Arrays.asList(certificateArr));
    }

    java.util.List<okhttp3.CertificatePinner.Pin> findMatchingPins(java.lang.String str) {
        java.util.List<okhttp3.CertificatePinner.Pin> listEmptyList = java.util.Collections.emptyList();
        for (okhttp3.CertificatePinner.Pin pin : this.pins) {
            if (pin.matches(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new java.util.ArrayList<>();
                }
                listEmptyList.add(pin);
            }
        }
        return listEmptyList;
    }

    okhttp3.CertificatePinner withCertificateChainCleaner(@javax.annotation.Nullable okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner) {
        return okhttp3.internal.Util.equal(this.certificateChainCleaner, certificateChainCleaner) ? this : new okhttp3.CertificatePinner(this.pins, certificateChainCleaner);
    }

    public static java.lang.String pin(java.security.cert.Certificate certificate) {
        if (!(certificate instanceof java.security.cert.X509Certificate)) {
            throw new java.lang.IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + sha256((java.security.cert.X509Certificate) certificate).base64();
    }

    static okio.ByteString sha1(java.security.cert.X509Certificate x509Certificate) {
        return okio.ByteString.of_renamed(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    static okio.ByteString sha256(java.security.cert.X509Certificate x509Certificate) {
        return okio.ByteString.of_renamed(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    static final class Pin {
        private static final java.lang.String WILDCARD = "*.";
        final java.lang.String canonicalHostname;
        final okio.ByteString hash;
        final java.lang.String hashAlgorithm;
        final java.lang.String pattern;

        Pin(java.lang.String str, java.lang.String str2) {
            java.lang.String strHost;
            this.pattern = str;
            if (str.startsWith(WILDCARD)) {
                strHost = okhttp3.HttpUrl.get("http://" + str.substring(2)).host();
            } else {
                strHost = okhttp3.HttpUrl.get("http://" + str).host();
            }
            this.canonicalHostname = strHost;
            if (str2.startsWith("sha1/")) {
                this.hashAlgorithm = "sha1/";
                this.hash = okio.ByteString.decodeBase64(str2.substring(5));
            } else if (str2.startsWith("sha256/")) {
                this.hashAlgorithm = "sha256/";
                this.hash = okio.ByteString.decodeBase64(str2.substring(7));
            } else {
                throw new java.lang.IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
            }
            if (this.hash != null) {
                return;
            }
            throw new java.lang.IllegalArgumentException("pins must be_renamed base64: " + str2);
        }

        boolean matches(java.lang.String str) {
            if (this.pattern.startsWith(WILDCARD)) {
                int iIndexOf = str.indexOf(46);
                if ((str.length() - iIndexOf) - 1 == this.canonicalHostname.length()) {
                    java.lang.String str2 = this.canonicalHostname;
                    if (str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.canonicalHostname);
        }

        public boolean equals(java.lang.Object obj) {
            if (obj instanceof okhttp3.CertificatePinner.Pin) {
                okhttp3.CertificatePinner.Pin pin = (okhttp3.CertificatePinner.Pin) obj;
                if (this.pattern.equals(pin.pattern) && this.hashAlgorithm.equals(pin.hashAlgorithm) && this.hash.equals(pin.hash)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.pattern.hashCode()) * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public java.lang.String toString() {
            return this.hashAlgorithm + this.hash.base64();
        }
    }

    public static final class Builder {
        private final java.util.List<okhttp3.CertificatePinner.Pin> pins = new java.util.ArrayList();

        public okhttp3.CertificatePinner.Builder add(java.lang.String str, java.lang.String... strArr) {
            if (str == null) {
                throw new java.lang.NullPointerException("pattern == null");
            }
            for (java.lang.String str2 : strArr) {
                this.pins.add(new okhttp3.CertificatePinner.Pin(str, str2));
            }
            return this;
        }

        public okhttp3.CertificatePinner build() {
            return new okhttp3.CertificatePinner(new java.util.LinkedHashSet(this.pins), null);
        }
    }
}
