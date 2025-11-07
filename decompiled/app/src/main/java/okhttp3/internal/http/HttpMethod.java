package okhttp3.internal.http;

/* loaded from: classes2.dex */
public final class HttpMethod {
    public static boolean invalidatesCache(java.lang.String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean requiresRequestBody(java.lang.String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean permitsRequestBody(java.lang.String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static boolean redirectsWithBody(java.lang.String str) {
        return str.equals("PROPFIND");
    }

    public static boolean redirectsToGet(java.lang.String str) {
        return !str.equals("PROPFIND");
    }

    private HttpMethod() {
    }
}
