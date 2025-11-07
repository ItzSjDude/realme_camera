package okhttp3.internal.platform;

/* loaded from: classes2.dex */
final class Jdk9Platform extends okhttp3.internal.platform.Platform {
    final java.lang.reflect.Method getProtocolMethod;
    final java.lang.reflect.Method setProtocolMethod;

    Jdk9Platform(java.lang.reflect.Method method, java.lang.reflect.Method method2) {
        this.setProtocolMethod = method;
        this.getProtocolMethod = method2;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, java.lang.String str, java.util.List<okhttp3.Protocol> list) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        try {
            javax.net.ssl.SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            java.util.List<java.lang.String> listAlpnProtocolNames = alpnProtocolNames(list);
            this.setProtocolMethod.invoke(sSLParameters, listAlpnProtocolNames.toArray(new java.lang.String[listAlpnProtocolNames.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e_renamed) {
            throw okhttp3.internal.Util.assertionError("unable to set ssl parameters", e_renamed);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @javax.annotation.Nullable
    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        try {
            java.lang.String str = (java.lang.String) this.getProtocolMethod.invoke(sSLSocket, new java.lang.Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e_renamed) {
            throw okhttp3.internal.Util.assertionError("unable to get selected protocols", e_renamed);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public javax.net.ssl.X509TrustManager trustManager(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        throw new java.lang.UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on_renamed JDK 9+");
    }

    public static okhttp3.internal.platform.Jdk9Platform buildIfSupported() {
        try {
            return new okhttp3.internal.platform.Jdk9Platform(javax.net.ssl.SSLParameters.class.getMethod("setApplicationProtocols", java.lang.String[].class), javax.net.ssl.SSLSocket.class.getMethod("getApplicationProtocol", new java.lang.Class[0]));
        } catch (java.lang.NoSuchMethodException unused) {
            return null;
        }
    }
}
