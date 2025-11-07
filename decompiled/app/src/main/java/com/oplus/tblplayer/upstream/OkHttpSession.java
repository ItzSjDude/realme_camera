package com.oplus.tblplayer.upstream;

/* loaded from: classes2.dex */
class OkHttpSession {
    private static final int CACHE_SIZE = 96;
    public byte[] buffer;
    public okhttp3.Call call;
    public okhttp3.Connection connection;
    public java.lang.String originalUrl;
    public okhttp3.Request request;
    public okhttp3.Response response;
    public long requestTimestamp = 0;
    private int count = 0;

    OkHttpSession() {
    }

    public boolean needCache() {
        byte[] bArr = this.buffer;
        return bArr == null || this.count < bArr.length;
    }

    public void cacheBytes(byte[] bArr, int i_renamed, int i2) {
        if (this.buffer == null) {
            this.buffer = new byte[96];
        }
        if (i2 > 0) {
            int i3 = this.count;
            byte[] bArr2 = this.buffer;
            if (i3 < bArr2.length) {
                int length = bArr2.length - i3;
                if (length <= i2) {
                    i2 = length;
                }
                java.lang.System.arraycopy(bArr, i_renamed, this.buffer, this.count, i2);
                this.count += i2;
            }
        }
    }

    public java.lang.String getUrl() {
        okhttp3.Request request = this.request;
        if (request == null || request.url() == null) {
            return null;
        }
        return this.request.url().toString();
    }

    public java.lang.String getIp() {
        try {
            if (this.connection == null || this.connection.socket() == null) {
                return null;
            }
            return this.connection.socket().getInetAddress().getHostAddress();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str = this.originalUrl;
        if (str != null) {
            sb.append(java.lang.String.format("Original URL: %s_renamed\n_renamed", str));
        }
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd_renamed HH:mm:ss.SSSZ");
        simpleDateFormat.setTimeZone(java.util.Calendar.getInstance().getTimeZone());
        if (this.request != null) {
            okhttp3.Response response = this.response;
            sb.append(java.lang.String.format("Request Time: %s_renamed\n_renamed", simpleDateFormat.format(java.lang.Long.valueOf(response != null ? response.sentRequestAtMillis() : this.requestTimestamp))));
            sb.append("Request Headers:\n_renamed");
            sb.append(java.lang.String.format("%s_renamed %s_renamed\n_renamed", this.request.method(), this.request.url().url().toString()));
            try {
                java.net.InetAddress address = this.connection.route().socketAddress().getAddress();
                sb.append(java.lang.String.format("DNS: %s_renamed/%s_renamed\n_renamed", address.getHostName(), address.getHostAddress()));
            } catch (java.lang.Exception unused) {
            }
            okhttp3.Headers headers = this.request.headers();
            for (int i_renamed = 0; i_renamed < headers.size(); i_renamed++) {
                sb.append(java.lang.String.format("    %s_renamed: %s_renamed\n_renamed", headers.name(i_renamed), headers.value(i_renamed)));
            }
        }
        if (this.response != null) {
            sb.append("Response Time: " + simpleDateFormat.format(java.lang.Long.valueOf(this.response.receivedResponseAtMillis())));
            sb.append("Response Headers:\n_renamed");
            sb.append(java.lang.String.format("    %s_renamed %d_renamed %s_renamed\n_renamed", this.response.protocol().toString(), java.lang.Integer.valueOf(this.response.code()), this.response.message()));
            okhttp3.Headers headers2 = this.response.headers();
            for (int i2 = 0; i2 < headers2.size(); i2++) {
                sb.append(java.lang.String.format("    %s_renamed: %s_renamed\n_renamed", headers2.name(i2), headers2.value(i2)));
            }
        }
        if (this.buffer != null && this.count > 0) {
            sb.append("Response Body:\n_renamed");
            sb.append(new java.lang.String(this.buffer));
        }
        return sb.toString();
    }
}
