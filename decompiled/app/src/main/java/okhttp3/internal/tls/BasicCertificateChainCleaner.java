package okhttp3.internal.tls;

/* loaded from: classes2.dex */
public final class BasicCertificateChainCleaner extends okhttp3.internal.tls.CertificateChainCleaner {
    private static final int MAX_SIGNERS = 9;
    private final okhttp3.internal.tls.TrustRootIndex trustRootIndex;

    public BasicCertificateChainCleaner(okhttp3.internal.tls.TrustRootIndex trustRootIndex) {
        this.trustRootIndex = trustRootIndex;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public java.util.List<java.security.cert.Certificate> clean(java.util.List<java.security.cert.Certificate> list, java.lang.String str) throws javax.net.ssl.SSLPeerUnverifiedException {
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque(list);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean z_renamed = false;
        for (int i_renamed = 0; i_renamed < 9; i_renamed++) {
            java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) arrayList.get(arrayList.size() - 1);
            java.security.cert.X509Certificate x509CertificateFindByIssuerAndSignature = this.trustRootIndex.findByIssuerAndSignature(x509Certificate);
            if (x509CertificateFindByIssuerAndSignature != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(x509CertificateFindByIssuerAndSignature)) {
                    arrayList.add(x509CertificateFindByIssuerAndSignature);
                }
                if (verifySignature(x509CertificateFindByIssuerAndSignature, x509CertificateFindByIssuerAndSignature)) {
                    return arrayList;
                }
                z_renamed = true;
            } else {
                java.util.Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    java.security.cert.X509Certificate x509Certificate2 = (java.security.cert.X509Certificate) it.next();
                    if (verifySignature(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z_renamed) {
                    return arrayList;
                }
                throw new javax.net.ssl.SSLPeerUnverifiedException("Failed to find a_renamed trusted cert that signed " + x509Certificate);
            }
        }
        throw new javax.net.ssl.SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    private boolean verifySignature(java.security.cert.X509Certificate x509Certificate, java.security.cert.X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (java.security.GeneralSecurityException unused) {
            return false;
        }
    }

    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof okhttp3.internal.tls.BasicCertificateChainCleaner) && ((okhttp3.internal.tls.BasicCertificateChainCleaner) obj).trustRootIndex.equals(this.trustRootIndex);
    }
}
