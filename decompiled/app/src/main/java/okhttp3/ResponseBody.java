package okhttp3;

/* loaded from: classes2.dex */
public abstract class ResponseBody implements java.io.Closeable {

    @javax.annotation.Nullable
    private java.io.Reader reader;

    public abstract long contentLength();

    @javax.annotation.Nullable
    public abstract okhttp3.MediaType contentType();

    public abstract okio.BufferedSource source();

    public final java.io.InputStream byteStream() {
        return source().inputStream();
    }

    public final byte[] bytes() throws java.io.IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new java.io.IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        okio.BufferedSource bufferedSourceSource = source();
        try {
            byte[] byteArray = bufferedSourceSource.readByteArray();
            okhttp3.internal.Util.closeQuietly(bufferedSourceSource);
            if (jContentLength == -1 || jContentLength == byteArray.length) {
                return byteArray;
            }
            throw new java.io.IOException("Content-Length (" + jContentLength + ") and stream length (" + byteArray.length + ") disagree");
        } catch (java.lang.Throwable th) {
            okhttp3.internal.Util.closeQuietly(bufferedSourceSource);
            throw th;
        }
    }

    public final java.io.Reader charStream() {
        java.io.Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        okhttp3.ResponseBody.BomAwareReader bomAwareReader = new okhttp3.ResponseBody.BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    public final java.lang.String string() throws java.io.IOException {
        okio.BufferedSource bufferedSourceSource = source();
        try {
            return bufferedSourceSource.readString(okhttp3.internal.Util.bomAwareCharset(bufferedSourceSource, charset()));
        } finally {
            okhttp3.internal.Util.closeQuietly(bufferedSourceSource);
        }
    }

    private java.nio.charset.Charset charset() {
        okhttp3.MediaType mediaTypeContentType = contentType();
        return mediaTypeContentType != null ? mediaTypeContentType.charset(okhttp3.internal.Util.UTF_8) : okhttp3.internal.Util.UTF_8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        okhttp3.internal.Util.closeQuietly(source());
    }

    public static okhttp3.ResponseBody create(@javax.annotation.Nullable okhttp3.MediaType mediaType, java.lang.String str) {
        java.nio.charset.Charset charset = okhttp3.internal.Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = okhttp3.internal.Util.UTF_8;
            mediaType = okhttp3.MediaType.parse(mediaType + "; charset=utf-8");
        }
        okio.Buffer bufferWriteString = new okio.Buffer().writeString(str, charset);
        return create(mediaType, bufferWriteString.size(), bufferWriteString);
    }

    public static okhttp3.ResponseBody create(@javax.annotation.Nullable okhttp3.MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr.length, new okio.Buffer().write(bArr));
    }

    public static okhttp3.ResponseBody create(@javax.annotation.Nullable okhttp3.MediaType mediaType, okio.ByteString byteString) {
        return create(mediaType, byteString.size(), new okio.Buffer().write(byteString));
    }

    public static okhttp3.ResponseBody create(@javax.annotation.Nullable final okhttp3.MediaType mediaType, final long j_renamed, final okio.BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new java.lang.NullPointerException("source == null");
        }
        return new okhttp3.ResponseBody() { // from class: okhttp3.ResponseBody.1
            @Override // okhttp3.ResponseBody
            @javax.annotation.Nullable
            public okhttp3.MediaType contentType() {
                return mediaType;
            }

            @Override // okhttp3.ResponseBody
            public long contentLength() {
                return j_renamed;
            }

            @Override // okhttp3.ResponseBody
            public okio.BufferedSource source() {
                return bufferedSource;
            }
        };
    }

    static final class BomAwareReader extends java.io.Reader {
        private final java.nio.charset.Charset charset;
        private boolean closed;

        @javax.annotation.Nullable
        private java.io.Reader delegate;
        private final okio.BufferedSource source;

        BomAwareReader(okio.BufferedSource bufferedSource, java.nio.charset.Charset charset) {
            this.source = bufferedSource;
            this.charset = charset;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i_renamed, int i2) throws java.io.IOException {
            if (this.closed) {
                throw new java.io.IOException("Stream closed");
            }
            java.io.Reader reader = this.delegate;
            if (reader == null) {
                java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(this.source.inputStream(), okhttp3.internal.Util.bomAwareCharset(this.source, this.charset));
                this.delegate = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i_renamed, i2);
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            this.closed = true;
            java.io.Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }
    }
}
