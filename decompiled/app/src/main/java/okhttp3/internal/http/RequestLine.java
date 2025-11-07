package okhttp3.internal.http;

/* loaded from: classes2.dex */
public final class RequestLine {
    private RequestLine() {
    }

    public static java.lang.String get(okhttp3.Request request, java.net.Proxy.Type type) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(request.method());
        sb.append(' ');
        if (includeAuthorityInRequestLine(request, type)) {
            sb.append(request.url());
        } else {
            sb.append(requestPath(request.url()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean includeAuthorityInRequestLine(okhttp3.Request request, java.net.Proxy.Type type) {
        return !request.isHttps() && type == java.net.Proxy.Type.HTTP;
    }

    public static java.lang.String requestPath(okhttp3.HttpUrl httpUrl) {
        java.lang.String strEncodedPath = httpUrl.encodedPath();
        java.lang.String strEncodedQuery = httpUrl.encodedQuery();
        if (strEncodedQuery == null) {
            return strEncodedPath;
        }
        return strEncodedPath + '?' + strEncodedQuery;
    }
}
