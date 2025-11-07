package com.google.android.exoplayer2.ext.okhttp;

/* loaded from: classes.dex */
public class OkHttpDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource implements com.google.android.exoplayer2.upstream.HttpDataSource {
    private static final byte[] SKIP_BUFFER;
    private long bytesRead;
    private long bytesSkipped;
    private long bytesToRead;
    private long bytesToSkip;
    private final okhttp3.CacheControl cacheControl;
    private final okhttp3.Call.Factory callFactory;
    private final com.google.android.exoplayer2.util.Predicate<java.lang.String> contentTypePredicate;
    private com.google.android.exoplayer2.upstream.DataSpec dataSpec;
    private final com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties defaultRequestProperties;
    private boolean opened;
    private final com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties;
    private okhttp3.Response response;
    private java.io.InputStream responseByteStream;
    private final java.lang.String userAgent;

    static {
        com.google.android.exoplayer2.ExoPlayerLibraryInfo.registerModule("goog.exo.okhttp");
        SKIP_BUFFER = new byte[4096];
    }

    public OkHttpDataSource(okhttp3.Call.Factory factory, java.lang.String str, com.google.android.exoplayer2.util.Predicate<java.lang.String> predicate) {
        this(factory, str, predicate, null, null);
    }

    public OkHttpDataSource(okhttp3.Call.Factory factory, java.lang.String str, com.google.android.exoplayer2.util.Predicate<java.lang.String> predicate, okhttp3.CacheControl cacheControl, com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties) {
        super(true);
        this.callFactory = (okhttp3.Call.Factory) com.google.android.exoplayer2.util.Assertions.checkNotNull(factory);
        this.userAgent = str;
        this.contentTypePredicate = predicate;
        this.cacheControl = cacheControl;
        this.defaultRequestProperties = requestProperties;
        this.requestProperties = new com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public android.net.Uri getUri() {
        okhttp3.Response response = this.response;
        if (response == null) {
            return null;
        }
        return android.net.Uri.parse(response.request().url().toString());
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        okhttp3.Response response = this.response;
        return response == null ? java.util.Collections.emptyMap() : response.headers().toMultimap();
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void setRequestProperty(java.lang.String str, java.lang.String str2) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(str);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(str2);
        this.requestProperties.set(str, str2);
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearRequestProperty(java.lang.String str) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(str);
        this.requestProperties.remove(str);
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearAllRequestProperties() {
        this.requestProperties.clear();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        this.dataSpec = dataSpec;
        long j_renamed = 0;
        this.bytesRead = 0L;
        this.bytesSkipped = 0L;
        transferInitializing(dataSpec);
        try {
            this.response = this.callFactory.newCall(makeRequest(dataSpec)).execute();
            okhttp3.Response response = this.response;
            okhttp3.ResponseBody responseBody = (okhttp3.ResponseBody) com.google.android.exoplayer2.util.Assertions.checkNotNull(response.body());
            this.responseByteStream = responseBody.byteStream();
            int iCode = response.code();
            if (!response.isSuccessful()) {
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> multimap = response.headers().toMultimap();
                closeConnectionQuietly();
                com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException(iCode, response.message(), multimap, dataSpec);
                if (iCode == 416) {
                    invalidResponseCodeException.initCause(new com.google.android.exoplayer2.upstream.DataSourceException(0));
                    throw invalidResponseCodeException;
                }
                throw invalidResponseCodeException;
            }
            okhttp3.MediaType mediaTypeContentType = responseBody.contentType();
            java.lang.String string = mediaTypeContentType != null ? mediaTypeContentType.toString() : "";
            com.google.android.exoplayer2.util.Predicate<java.lang.String> predicate = this.contentTypePredicate;
            if (predicate != null && !predicate.evaluate(string)) {
                closeConnectionQuietly();
                throw new com.google.android.exoplayer2.upstream.HttpDataSource.InvalidContentTypeException(string, dataSpec);
            }
            if (iCode == 200 && dataSpec.position != 0) {
                j_renamed = dataSpec.position;
            }
            this.bytesToSkip = j_renamed;
            if (dataSpec.length != -1) {
                this.bytesToRead = dataSpec.length;
            } else {
                long jContentLength = responseBody.contentLength();
                this.bytesToRead = jContentLength != -1 ? jContentLength - this.bytesToSkip : -1L;
            }
            this.opened = true;
            transferStarted(dataSpec);
            return this.bytesToRead;
        } catch (java.io.IOException e_renamed) {
            throw new com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.uri, e_renamed, dataSpec, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i_renamed, int i2) throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        try {
            skipInternal();
            return readInternal(bArr, i_renamed, i2);
        } catch (java.io.IOException e_renamed) {
            throw new com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException(e_renamed, (com.google.android.exoplayer2.upstream.DataSpec) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.dataSpec), 2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws java.io.IOException {
        if (this.opened) {
            this.opened = false;
            transferEnded();
            closeConnectionQuietly();
        }
    }

    protected final long bytesSkipped() {
        return this.bytesSkipped;
    }

    protected final long bytesRead() {
        return this.bytesRead;
    }

    protected final long bytesRemaining() {
        long j_renamed = this.bytesToRead;
        return j_renamed == -1 ? j_renamed : j_renamed - this.bytesRead;
    }

    private okhttp3.Request makeRequest(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        long j_renamed = dataSpec.position;
        long j2 = dataSpec.length;
        boolean zIsFlagSet = dataSpec.isFlagSet(1);
        okhttp3.HttpUrl httpUrl = okhttp3.HttpUrl.parse(dataSpec.uri.toString());
        if (httpUrl == null) {
            throw new com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException("Malformed URL", dataSpec, 1);
        }
        okhttp3.Request.Builder builderUrl = new okhttp3.Request.Builder().url(httpUrl);
        okhttp3.CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            builderUrl.cacheControl(cacheControl);
        }
        com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties = this.defaultRequestProperties;
        if (requestProperties != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : requestProperties.getSnapshot().entrySet()) {
                builderUrl.header(entry.getKey(), entry.getValue());
            }
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : this.requestProperties.getSnapshot().entrySet()) {
            builderUrl.header(entry2.getKey(), entry2.getValue());
        }
        if (j_renamed != 0 || j2 != -1) {
            java.lang.String str = "bytes=" + j_renamed + "-";
            if (j2 != -1) {
                str = str + ((j_renamed + j2) - 1);
            }
            builderUrl.addHeader("Range", str);
        }
        java.lang.String str2 = this.userAgent;
        if (str2 != null) {
            builderUrl.addHeader("User-Agent", str2);
        }
        if (!zIsFlagSet) {
            builderUrl.addHeader("Accept-Encoding", com.oplus.camera.aps.constant.CameraUnitKeys.KEY_PROCESS_IMAGE_IDENTITY);
        }
        okhttp3.RequestBody requestBodyCreate = null;
        if (dataSpec.httpBody != null) {
            requestBodyCreate = okhttp3.RequestBody.create((okhttp3.MediaType) null, dataSpec.httpBody);
        } else if (dataSpec.httpMethod == 2) {
            requestBodyCreate = okhttp3.RequestBody.create((okhttp3.MediaType) null, com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY);
        }
        builderUrl.method(dataSpec.getHttpMethodString(), requestBodyCreate);
        return builderUrl.build();
    }

    private void skipInternal() throws java.io.IOException {
        if (this.bytesSkipped == this.bytesToSkip) {
            return;
        }
        while (true) {
            long j_renamed = this.bytesSkipped;
            long j2 = this.bytesToSkip;
            if (j_renamed == j2) {
                return;
            }
            int i_renamed = ((java.io.InputStream) com.google.android.exoplayer2.util.Util.castNonNull(this.responseByteStream)).read(SKIP_BUFFER, 0, (int) java.lang.Math.min(j2 - j_renamed, SKIP_BUFFER.length));
            if (java.lang.Thread.currentThread().isInterrupted()) {
                throw new java.io.InterruptedIOException();
            }
            if (i_renamed == -1) {
                throw new java.io.EOFException();
            }
            this.bytesSkipped += i_renamed;
            bytesTransferred(i_renamed);
        }
    }

    private int readInternal(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (i2 == 0) {
            return 0;
        }
        long j_renamed = this.bytesToRead;
        if (j_renamed != -1) {
            long j2 = j_renamed - this.bytesRead;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) java.lang.Math.min(i2, j2);
        }
        int i3 = ((java.io.InputStream) com.google.android.exoplayer2.util.Util.castNonNull(this.responseByteStream)).read(bArr, i_renamed, i2);
        if (i3 == -1) {
            if (this.bytesToRead == -1) {
                return -1;
            }
            throw new java.io.EOFException();
        }
        this.bytesRead += i3;
        bytesTransferred(i3);
        return i3;
    }

    private void closeConnectionQuietly() throws java.io.IOException {
        okhttp3.Response response = this.response;
        if (response != null) {
            ((okhttp3.ResponseBody) com.google.android.exoplayer2.util.Assertions.checkNotNull(response.body())).close();
            this.response = null;
        }
        this.responseByteStream = null;
    }
}
