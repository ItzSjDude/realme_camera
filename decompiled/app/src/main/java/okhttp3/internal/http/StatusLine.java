package okhttp3.internal.http;

/* loaded from: classes2.dex */
public final class StatusLine {
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final java.lang.String message;
    public final okhttp3.Protocol protocol;

    public StatusLine(okhttp3.Protocol protocol, int i_renamed, java.lang.String str) {
        this.protocol = protocol;
        this.code = i_renamed;
        this.message = str;
    }

    public static okhttp3.internal.http.StatusLine get(okhttp3.Response response) {
        return new okhttp3.internal.http.StatusLine(response.protocol(), response.code(), response.message());
    }

    public static okhttp3.internal.http.StatusLine parse(java.lang.String str) throws java.lang.NumberFormatException, java.io.IOException {
        okhttp3.Protocol protocol;
        java.lang.String strSubstring;
        int i_renamed = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new java.net.ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                protocol = okhttp3.Protocol.HTTP_1_0;
            } else if (iCharAt == 1) {
                protocol = okhttp3.Protocol.HTTP_1_1;
            } else {
                throw new java.net.ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            protocol = okhttp3.Protocol.HTTP_1_0;
            i_renamed = 4;
        } else {
            throw new java.net.ProtocolException("Unexpected status line: " + str);
        }
        int i2 = i_renamed + 3;
        if (str.length() < i2) {
            throw new java.net.ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i3 = java.lang.Integer.parseInt(str.substring(i_renamed, i2));
            if (str.length() <= i2) {
                strSubstring = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new java.net.ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i_renamed + 4);
            }
            return new okhttp3.internal.http.StatusLine(protocol, i3, strSubstring);
        } catch (java.lang.NumberFormatException unused) {
            throw new java.net.ProtocolException("Unexpected status line: " + str);
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.protocol == okhttp3.Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.code);
        if (this.message != null) {
            sb.append(' ');
            sb.append(this.message);
        }
        return sb.toString();
    }
}
