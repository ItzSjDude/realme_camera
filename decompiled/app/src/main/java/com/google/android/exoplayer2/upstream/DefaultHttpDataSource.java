package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public class DefaultHttpDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource implements com.google.android.exoplayer2.upstream.HttpDataSource {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    private static final int HTTP_STATUS_PERMANENT_REDIRECT = 308;
    private static final int HTTP_STATUS_TEMPORARY_REDIRECT = 307;
    private static final long MAX_BYTES_TO_DRAIN = 2048;
    private static final int MAX_REDIRECTS = 20;
    private static final java.lang.String TAG = "DefaultHttpDataSource";
    private final boolean allowCrossProtocolRedirects;
    private long bytesRead;
    private long bytesSkipped;
    private long bytesToRead;
    private long bytesToSkip;
    private final int connectTimeoutMillis;
    private java.net.HttpURLConnection connection;
    private final com.google.android.exoplayer2.util.Predicate<java.lang.String> contentTypePredicate;
    private com.google.android.exoplayer2.upstream.DataSpec dataSpec;
    private final com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties defaultRequestProperties;
    private java.io.InputStream inputStream;
    private boolean opened;
    private final int readTimeoutMillis;
    private final com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties;
    private final java.lang.String userAgent;
    private static final java.util.regex.Pattern CONTENT_RANGE_HEADER = java.util.regex.Pattern.compile("^bytes (\\d_renamed+)-(\\d_renamed+)/(\\d_renamed+)$");
    private static final java.util.concurrent.atomic.AtomicReference<byte[]> skipBufferReference = new java.util.concurrent.atomic.AtomicReference<>();

    public DefaultHttpDataSource(java.lang.String str, com.google.android.exoplayer2.util.Predicate<java.lang.String> predicate) {
        this(str, predicate, 8000, 8000);
    }

    public DefaultHttpDataSource(java.lang.String str, com.google.android.exoplayer2.util.Predicate<java.lang.String> predicate, int i_renamed, int i2) {
        this(str, predicate, i_renamed, i2, false, null);
    }

    public DefaultHttpDataSource(java.lang.String str, com.google.android.exoplayer2.util.Predicate<java.lang.String> predicate, int i_renamed, int i2, boolean z_renamed, com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties) {
        super(true);
        this.userAgent = com.google.android.exoplayer2.util.Assertions.checkNotEmpty(str);
        this.contentTypePredicate = predicate;
        this.requestProperties = new com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties();
        this.connectTimeoutMillis = i_renamed;
        this.readTimeoutMillis = i2;
        this.allowCrossProtocolRedirects = z_renamed;
        this.defaultRequestProperties = requestProperties;
    }

    @java.lang.Deprecated
    public DefaultHttpDataSource(java.lang.String str, com.google.android.exoplayer2.util.Predicate<java.lang.String> predicate, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this(str, predicate, transferListener, 8000, 8000);
    }

    @java.lang.Deprecated
    public DefaultHttpDataSource(java.lang.String str, com.google.android.exoplayer2.util.Predicate<java.lang.String> predicate, com.google.android.exoplayer2.upstream.TransferListener transferListener, int i_renamed, int i2) {
        this(str, predicate, transferListener, i_renamed, i2, false, null);
    }

    @java.lang.Deprecated
    public DefaultHttpDataSource(java.lang.String str, com.google.android.exoplayer2.util.Predicate<java.lang.String> predicate, com.google.android.exoplayer2.upstream.TransferListener transferListener, int i_renamed, int i2, boolean z_renamed, com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties) {
        this(str, predicate, i_renamed, i2, z_renamed, requestProperties);
        if (transferListener != null) {
            addTransferListener(transferListener);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public android.net.Uri getUri() {
        java.net.HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return null;
        }
        return android.net.Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        java.net.HttpURLConnection httpURLConnection = this.connection;
        return httpURLConnection == null ? java.util.Collections.emptyMap() : httpURLConnection.getHeaderFields();
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
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException, java.lang.NumberFormatException {
        this.dataSpec = dataSpec;
        long j_renamed = 0;
        this.bytesRead = 0L;
        this.bytesSkipped = 0L;
        transferInitializing(dataSpec);
        try {
            this.connection = makeConnection(dataSpec);
            try {
                int responseCode = this.connection.getResponseCode();
                java.lang.String responseMessage = this.connection.getResponseMessage();
                if (responseCode < 200 || responseCode > 299) {
                    java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = this.connection.getHeaderFields();
                    closeConnectionQuietly();
                    com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException(responseCode, responseMessage, headerFields, dataSpec);
                    if (responseCode == 416) {
                        invalidResponseCodeException.initCause(new com.google.android.exoplayer2.upstream.DataSourceException(0));
                        throw invalidResponseCodeException;
                    }
                    throw invalidResponseCodeException;
                }
                java.lang.String contentType = this.connection.getContentType();
                com.google.android.exoplayer2.util.Predicate<java.lang.String> predicate = this.contentTypePredicate;
                if (predicate != null && !predicate.evaluate(contentType)) {
                    closeConnectionQuietly();
                    throw new com.google.android.exoplayer2.upstream.HttpDataSource.InvalidContentTypeException(contentType, dataSpec);
                }
                if (responseCode == 200 && dataSpec.position != 0) {
                    j_renamed = dataSpec.position;
                }
                this.bytesToSkip = j_renamed;
                if (dataSpec.isFlagSet(1)) {
                    this.bytesToRead = dataSpec.length;
                } else {
                    if (dataSpec.length != -1) {
                        this.bytesToRead = dataSpec.length;
                    } else {
                        long contentLength = getContentLength(this.connection);
                        this.bytesToRead = contentLength != -1 ? contentLength - this.bytesToSkip : -1L;
                    }
                }
                try {
                    this.inputStream = this.connection.getInputStream();
                    this.opened = true;
                    transferStarted(dataSpec);
                    return this.bytesToRead;
                } catch (java.io.IOException e_renamed) {
                    closeConnectionQuietly();
                    throw new com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException(e_renamed, dataSpec, 1);
                }
            } catch (java.io.IOException e2) {
                closeConnectionQuietly();
                throw new com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.uri.toString(), e2, dataSpec, 1);
            }
        } catch (java.io.IOException e3) {
            throw new com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.uri.toString(), e3, dataSpec, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i_renamed, int i2) throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        try {
            skipInternal();
            return readInternal(bArr, i_renamed, i2);
        } catch (java.io.IOException e_renamed) {
            throw new com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException(e_renamed, this.dataSpec, 2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        try {
            if (this.inputStream != null) {
                maybeTerminateInputStream(this.connection, bytesRemaining());
                try {
                    this.inputStream.close();
                } catch (java.io.IOException e_renamed) {
                    throw new com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException(e_renamed, this.dataSpec, 3);
                }
            }
        } finally {
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        }
    }

    protected final java.net.HttpURLConnection getConnection() {
        return this.connection;
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

    private java.net.HttpURLConnection makeConnection(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        java.net.HttpURLConnection httpURLConnectionMakeConnection;
        byte[] bArr;
        java.net.URL url = new java.net.URL(dataSpec.uri.toString());
        int i_renamed = dataSpec.httpMethod;
        byte[] bArr2 = dataSpec.httpBody;
        long j_renamed = dataSpec.position;
        long j2 = dataSpec.length;
        int i2 = 1;
        boolean zIsFlagSet = dataSpec.isFlagSet(1);
        if (!this.allowCrossProtocolRedirects) {
            return makeConnection(url, i_renamed, bArr2, j_renamed, j2, zIsFlagSet, true);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (i3 <= 20) {
                byte[] bArr3 = bArr2;
                byte[] bArr4 = bArr2;
                int i5 = i2;
                long j3 = j2;
                httpURLConnectionMakeConnection = makeConnection(url, i_renamed, bArr3, j_renamed, j2, zIsFlagSet, false);
                int responseCode = httpURLConnectionMakeConnection.getResponseCode();
                java.lang.String headerField = httpURLConnectionMakeConnection.getHeaderField("Location");
                if ((i_renamed == i5 || i_renamed == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                    httpURLConnectionMakeConnection.disconnect();
                    url = handleRedirect(url, headerField);
                    bArr = bArr4;
                } else {
                    if (i_renamed != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                        break;
                    }
                    httpURLConnectionMakeConnection.disconnect();
                    url = handleRedirect(url, headerField);
                    bArr = null;
                    i_renamed = i5;
                }
                i2 = i5;
                bArr2 = bArr;
                j2 = j3;
                i3 = i4;
            } else {
                throw new java.net.NoRouteToHostException("Too many redirects: " + i4);
            }
        }
        return httpURLConnectionMakeConnection;
    }

    private java.net.HttpURLConnection makeConnection(java.net.URL url, int i_renamed, byte[] bArr, long j_renamed, long j2, boolean z_renamed, boolean z2) throws java.io.IOException {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.connectTimeoutMillis);
        httpURLConnection.setReadTimeout(this.readTimeoutMillis);
        com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties = this.defaultRequestProperties;
        if (requestProperties != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : requestProperties.getSnapshot().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : this.requestProperties.getSnapshot().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (j_renamed != 0 || j2 != -1) {
            java.lang.String str = "bytes=" + j_renamed + "-";
            if (j2 != -1) {
                str = str + ((j_renamed + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.userAgent);
        if (!z_renamed) {
            httpURLConnection.setRequestProperty("Accept-Encoding", com.oplus.camera.aps.constant.CameraUnitKeys.KEY_PROCESS_IMAGE_IDENTITY);
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        httpURLConnection.setRequestMethod(com.google.android.exoplayer2.upstream.DataSpec.getStringForHttpMethod(i_renamed));
        if (bArr != null) {
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.connect();
            java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    private static java.net.URL handleRedirect(java.net.URL url, java.lang.String str) throws java.io.IOException {
        if (str == null) {
            throw new java.net.ProtocolException("Null location redirect");
        }
        java.net.URL url2 = new java.net.URL(url, str);
        java.lang.String protocol = url2.getProtocol();
        if ("https".equals(protocol) || "http".equals(protocol)) {
            return url2;
        }
        throw new java.net.ProtocolException("Unsupported protocol redirect: " + protocol);
    }

    private static long getContentLength(java.net.HttpURLConnection httpURLConnection) throws java.lang.NumberFormatException {
        long j_renamed;
        java.lang.String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (android.text.TextUtils.isEmpty(headerField)) {
            j_renamed = -1;
        } else {
            try {
                j_renamed = java.lang.Long.parseLong(headerField);
            } catch (java.lang.NumberFormatException unused) {
                com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Unexpected Content-Length [" + headerField + "]");
            }
        }
        java.lang.String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (android.text.TextUtils.isEmpty(headerField2)) {
            return j_renamed;
        }
        java.util.regex.Matcher matcher = CONTENT_RANGE_HEADER.matcher(headerField2);
        if (!matcher.find()) {
            return j_renamed;
        }
        try {
            long j2 = (java.lang.Long.parseLong(matcher.group(2)) - java.lang.Long.parseLong(matcher.group(1))) + 1;
            if (j_renamed < 0) {
                return j2;
            }
            if (j_renamed == j2) {
                return j_renamed;
            }
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Inconsistent headers [" + headerField + "] [" + headerField2 + "]");
            return java.lang.Math.max(j_renamed, j2);
        } catch (java.lang.NumberFormatException unused2) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Unexpected Content-Range [" + headerField2 + "]");
            return j_renamed;
        }
    }

    private void skipInternal() throws java.io.IOException {
        if (this.bytesSkipped == this.bytesToSkip) {
            return;
        }
        byte[] andSet = skipBufferReference.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j_renamed = this.bytesSkipped;
            long j2 = this.bytesToSkip;
            if (j_renamed != j2) {
                int i_renamed = this.inputStream.read(andSet, 0, (int) java.lang.Math.min(j2 - j_renamed, andSet.length));
                if (java.lang.Thread.currentThread().isInterrupted()) {
                    throw new java.io.InterruptedIOException();
                }
                if (i_renamed == -1) {
                    throw new java.io.EOFException();
                }
                this.bytesSkipped += i_renamed;
                bytesTransferred(i_renamed);
            } else {
                skipBufferReference.set(andSet);
                return;
            }
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
        int i3 = this.inputStream.read(bArr, i_renamed, i2);
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

    private static void maybeTerminateInputStream(java.net.HttpURLConnection httpURLConnection, long j_renamed) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (com.google.android.exoplayer2.util.Util.SDK_INT == 19 || com.google.android.exoplayer2.util.Util.SDK_INT == 20) {
            try {
                java.io.InputStream inputStream = httpURLConnection.getInputStream();
                if (j_renamed == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j_renamed <= 2048) {
                    return;
                }
                java.lang.String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    java.lang.reflect.Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new java.lang.Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new java.lang.Object[0]);
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private void closeConnectionQuietly() {
        java.net.HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (java.lang.Exception e_renamed) {
                com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Unexpected error while disconnecting", e_renamed);
            }
            this.connection = null;
        }
    }
}
