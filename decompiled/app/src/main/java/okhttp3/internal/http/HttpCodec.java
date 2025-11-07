package okhttp3.internal.http;

/* loaded from: classes2.dex */
public interface HttpCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    okio.Sink createRequestBody(okhttp3.Request request, long j_renamed);

    void finishRequest() throws java.io.IOException;

    void flushRequest() throws java.io.IOException;

    okhttp3.ResponseBody openResponseBody(okhttp3.Response response) throws java.io.IOException;

    okhttp3.Response.Builder readResponseHeaders(boolean z_renamed) throws java.io.IOException;

    void writeRequestHeaders(okhttp3.Request request) throws java.io.IOException;
}
