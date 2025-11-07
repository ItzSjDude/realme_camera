package okhttp3.internal.connection;

/* loaded from: classes2.dex */
public final class ConnectionSpecSelector {
    private final java.util.List<okhttp3.ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex = 0;

    public ConnectionSpecSelector(java.util.List<okhttp3.ConnectionSpec> list) {
        this.connectionSpecs = list;
    }

    public okhttp3.ConnectionSpec configureSecureSocket(javax.net.ssl.SSLSocket sSLSocket) throws java.io.IOException {
        okhttp3.ConnectionSpec connectionSpec;
        int i_renamed = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i_renamed >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.connectionSpecs.get(i_renamed);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.nextModeIndex = i_renamed + 1;
                break;
            }
            i_renamed++;
        }
        if (connectionSpec == null) {
            throw new java.net.UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.isFallback + ", modes=" + this.connectionSpecs + ", supported protocols=" + java.util.Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.isFallbackPossible = isFallbackPossible(sSLSocket);
        okhttp3.internal.Internal.instance.apply(connectionSpec, sSLSocket, this.isFallback);
        return connectionSpec;
    }

    public boolean connectionFailed(java.io.IOException iOException) {
        this.isFallback = true;
        if (!this.isFallbackPossible || (iOException instanceof java.net.ProtocolException) || (iOException instanceof java.io.InterruptedIOException)) {
            return false;
        }
        boolean z_renamed = iOException instanceof javax.net.ssl.SSLHandshakeException;
        if ((z_renamed && (iOException.getCause() instanceof java.security.cert.CertificateException)) || (iOException instanceof javax.net.ssl.SSLPeerUnverifiedException)) {
            return false;
        }
        return z_renamed || (iOException instanceof javax.net.ssl.SSLProtocolException) || (iOException instanceof javax.net.ssl.SSLException);
    }

    private boolean isFallbackPossible(javax.net.ssl.SSLSocket sSLSocket) {
        for (int i_renamed = this.nextModeIndex; i_renamed < this.connectionSpecs.size(); i_renamed++) {
            if (this.connectionSpecs.get(i_renamed).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
