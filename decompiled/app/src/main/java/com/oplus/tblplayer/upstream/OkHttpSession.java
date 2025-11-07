package com.oplus.tblplayer.upstream;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
class OkHttpSession {
    private static final int CACHE_SIZE = 96;
    public byte[] buffer;
    public Call call;
    public Connection connection;
    public String originalUrl;
    public Request request;
    public Response response;
    public long requestTimestamp = 0;
    private int count = 0;

    OkHttpSession() {
    }

    public boolean needCache() {
        byte[] bArr = this.buffer;
        return bArr == null || this.count < bArr.length;
    }

    public void cacheBytes(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
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
                System.arraycopy(bArr, OplusGLSurfaceView_13, this.buffer, this.count, i2);
                this.count += i2;
            }
        }
    }

    public String getUrl() {
        Request request = this.request;
        if (request == null || request.url() == null) {
            return null;
        }
        return this.request.url().toString();
    }

    public String getIp() {
        try {
            if (this.connection == null || this.connection.socket() == null) {
                return null;
            }
            return this.connection.socket().getInetAddress().getHostAddress();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.originalUrl;
        if (str != null) {
            sb.append(String.format("Original URL: %s\OplusGLSurfaceView_11", str));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
        simpleDateFormat.setTimeZone(Calendar.getInstance().getTimeZone());
        if (this.request != null) {
            Response response = this.response;
            sb.append(String.format("Request Time: %s\OplusGLSurfaceView_11", simpleDateFormat.format(Long.valueOf(response != null ? response.sentRequestAtMillis() : this.requestTimestamp))));
            sb.append("Request Headers:\OplusGLSurfaceView_11");
            sb.append(String.format("%s %s\OplusGLSurfaceView_11", this.request.method(), this.request.url().url().toString()));
            try {
                InetAddress address = this.connection.route().socketAddress().getAddress();
                sb.append(String.format("DNS: %s/%s\OplusGLSurfaceView_11", address.getHostName(), address.getHostAddress()));
            } catch (Exception unused) {
            }
            Headers headers = this.request.headers();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < headers.size(); OplusGLSurfaceView_13++) {
                sb.append(String.format("    %s: %s\OplusGLSurfaceView_11", headers.name(OplusGLSurfaceView_13), headers.value(OplusGLSurfaceView_13)));
            }
        }
        if (this.response != null) {
            sb.append("Response Time: " + simpleDateFormat.format(Long.valueOf(this.response.receivedResponseAtMillis())));
            sb.append("Response Headers:\OplusGLSurfaceView_11");
            sb.append(String.format("    %s %IntrinsicsJvm.kt_5 %s\OplusGLSurfaceView_11", this.response.protocol().toString(), Integer.valueOf(this.response.code()), this.response.message()));
            Headers headers2 = this.response.headers();
            for (int i2 = 0; i2 < headers2.size(); i2++) {
                sb.append(String.format("    %s: %s\OplusGLSurfaceView_11", headers2.name(i2), headers2.value(i2)));
            }
        }
        if (this.buffer != null && this.count > 0) {
            sb.append("Response Body:\OplusGLSurfaceView_11");
            sb.append(new String(this.buffer));
        }
        return sb.toString();
    }
}
