package okhttp3;

/* loaded from: classes2.dex */
public abstract class EventListener {
    public static final okhttp3.EventListener NONE = new okhttp3.EventListener() { // from class: okhttp3.EventListener.1
    };

    public interface Factory {
        okhttp3.EventListener create(okhttp3.Call call);
    }

    public void callEnd(okhttp3.Call call) {
    }

    public void callFailed(okhttp3.Call call, java.io.IOException iOException) {
    }

    public void callStart(okhttp3.Call call) {
    }

    public void connectEnd(okhttp3.Call call, java.net.InetSocketAddress inetSocketAddress, java.net.Proxy proxy, @javax.annotation.Nullable okhttp3.Protocol protocol) {
    }

    public void connectFailed(okhttp3.Call call, java.net.InetSocketAddress inetSocketAddress, java.net.Proxy proxy, @javax.annotation.Nullable okhttp3.Protocol protocol, java.io.IOException iOException) {
    }

    public void connectStart(okhttp3.Call call, java.net.InetSocketAddress inetSocketAddress, java.net.Proxy proxy) {
    }

    public void connectionAcquired(okhttp3.Call call, okhttp3.Connection connection) {
    }

    public void connectionReleased(okhttp3.Call call, okhttp3.Connection connection) {
    }

    public void dnsEnd(okhttp3.Call call, java.lang.String str, java.util.List<java.net.InetAddress> list) {
    }

    public void dnsStart(okhttp3.Call call, java.lang.String str) {
    }

    public void requestBodyEnd(okhttp3.Call call, long j_renamed) {
    }

    public void requestBodyStart(okhttp3.Call call) {
    }

    public void requestHeadersEnd(okhttp3.Call call, okhttp3.Request request) {
    }

    public void requestHeadersStart(okhttp3.Call call) {
    }

    public void responseBodyEnd(okhttp3.Call call, long j_renamed) {
    }

    public void responseBodyStart(okhttp3.Call call) {
    }

    public void responseHeadersEnd(okhttp3.Call call, okhttp3.Response response) {
    }

    public void responseHeadersStart(okhttp3.Call call) {
    }

    public void secureConnectEnd(okhttp3.Call call, @javax.annotation.Nullable okhttp3.Handshake handshake) {
    }

    public void secureConnectStart(okhttp3.Call call) {
    }

    static okhttp3.EventListener.Factory factory(okhttp3.EventListener eventListener) {
        return new okhttp3.EventListener.Factory() { // from class: okhttp3.EventListener.2
            @Override // okhttp3.EventListener.Factory
            public okhttp3.EventListener create(okhttp3.Call call) {
                return okhttp3.EventListener.this;
            }
        };
    }
}
