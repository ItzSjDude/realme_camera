package okhttp3.internal.tls;

/* loaded from: classes2.dex */
public final class BasicTrustRootIndex implements okhttp3.internal.tls.TrustRootIndex {
    private final java.util.Map<javax.security.auth.x500.X500Principal, java.util.Set<java.security.cert.X509Certificate>> subjectToCaCerts = new java.util.LinkedHashMap();

    public BasicTrustRootIndex(java.security.cert.X509Certificate... x509CertificateArr) {
        for (java.security.cert.X509Certificate x509Certificate : x509CertificateArr) {
            javax.security.auth.x500.X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            java.util.Set<java.security.cert.X509Certificate> linkedHashSet = this.subjectToCaCerts.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new java.util.LinkedHashSet<>(1);
                this.subjectToCaCerts.put(subjectX500Principal, linkedHashSet);
            }
            linkedHashSet.add(x509Certificate);
        }
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    public java.security.cert.X509Certificate findByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        java.util.Set<java.security.cert.X509Certificate> set = this.subjectToCaCerts.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (java.security.cert.X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof okhttp3.internal.tls.BasicTrustRootIndex) && ((okhttp3.internal.tls.BasicTrustRootIndex) obj).subjectToCaCerts.equals(this.subjectToCaCerts);
    }

    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
