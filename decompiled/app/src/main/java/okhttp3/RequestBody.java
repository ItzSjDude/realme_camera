package okhttp3;

/* loaded from: classes2.dex */
public abstract class RequestBody {
    public long contentLength() throws java.io.IOException {
        return -1L;
    }

    @javax.annotation.Nullable
    public abstract okhttp3.MediaType contentType();

    public abstract void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException;

    public static okhttp3.RequestBody create(@javax.annotation.Nullable okhttp3.MediaType mediaType, java.lang.String str) {
        java.nio.charset.Charset charset = okhttp3.internal.Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = okhttp3.internal.Util.UTF_8;
            mediaType = okhttp3.MediaType.parse(mediaType + "; charset=utf-8");
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static okhttp3.RequestBody create(@javax.annotation.Nullable final okhttp3.MediaType mediaType, final okio.ByteString byteString) {
        return new okhttp3.RequestBody() { // from class: okhttp3.RequestBody.1
            @Override // okhttp3.RequestBody
            @javax.annotation.Nullable
            public okhttp3.MediaType contentType() {
                return mediaType;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() throws java.io.IOException {
                return byteString.size();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
                bufferedSink.write(byteString);
            }
        };
    }

    public static okhttp3.RequestBody create(@javax.annotation.Nullable okhttp3.MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static okhttp3.RequestBody create(@javax.annotation.Nullable final okhttp3.MediaType mediaType, final byte[] bArr, final int i_renamed, final int i2) {
        if (bArr == null) {
            throw new java.lang.NullPointerException("content == null");
        }
        okhttp3.internal.Util.checkOffsetAndCount(bArr.length, i_renamed, i2);
        return new okhttp3.RequestBody() { // from class: okhttp3.RequestBody.2
            @Override // okhttp3.RequestBody
            @javax.annotation.Nullable
            public okhttp3.MediaType contentType() {
                return mediaType;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                return i2;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
                bufferedSink.write(bArr, i_renamed, i2);
            }
        };
    }

    public static okhttp3.RequestBody create(@javax.annotation.Nullable final okhttp3.MediaType mediaType, final java.io.File file) {
        if (file == null) {
            throw new java.lang.NullPointerException("file == null");
        }
        return new okhttp3.RequestBody() { // from class: okhttp3.RequestBody.3
            @Override // okhttp3.RequestBody
            @javax.annotation.Nullable
            public okhttp3.MediaType contentType() {
                return mediaType;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                return file.length();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
                okio.Source source = null;
                try {
                    source = okio.Okio.source(file);
                    bufferedSink.writeAll(source);
                } finally {
                    okhttp3.internal.Util.closeQuietly(source);
                }
            }
        };
    }
}
