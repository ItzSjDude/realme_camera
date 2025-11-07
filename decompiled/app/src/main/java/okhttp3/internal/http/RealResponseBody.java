package okhttp3.internal.http;

/* loaded from: classes2.dex */
public final class RealResponseBody extends okhttp3.ResponseBody {
    private final long contentLength;

    @javax.annotation.Nullable
    private final java.lang.String contentTypeString;
    private final okio.BufferedSource source;

    public RealResponseBody(@javax.annotation.Nullable java.lang.String str, long j_renamed, okio.BufferedSource bufferedSource) {
        this.contentTypeString = str;
        this.contentLength = j_renamed;
        this.source = bufferedSource;
    }

    @Override // okhttp3.ResponseBody
    public okhttp3.MediaType contentType() {
        java.lang.String str = this.contentTypeString;
        if (str != null) {
            return okhttp3.MediaType.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    public okio.BufferedSource source() {
        return this.source;
    }
}
