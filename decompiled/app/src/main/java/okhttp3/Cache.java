package okhttp3;

/* loaded from: classes2.dex */
public final class Cache implements java.io.Closeable, java.io.Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    final okhttp3.internal.cache.DiskLruCache cache;
    private int hitCount;
    final okhttp3.internal.cache.InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    int writeAbortCount;
    int writeSuccessCount;

    public Cache(java.io.File file, long j_renamed) {
        this(file, j_renamed, okhttp3.internal.io.FileSystem.SYSTEM);
    }

    Cache(java.io.File file, long j_renamed, okhttp3.internal.io.FileSystem fileSystem) {
        this.internalCache = new okhttp3.internal.cache.InternalCache() { // from class: okhttp3.Cache.1
            @Override // okhttp3.internal.cache.InternalCache
            public okhttp3.Response get(okhttp3.Request request) throws java.io.IOException {
                return okhttp3.Cache.this.get(request);
            }

            @Override // okhttp3.internal.cache.InternalCache
            public okhttp3.internal.cache.CacheRequest put(okhttp3.Response response) throws java.io.IOException {
                return okhttp3.Cache.this.put(response);
            }

            @Override // okhttp3.internal.cache.InternalCache
            public void remove(okhttp3.Request request) throws java.io.IOException {
                okhttp3.Cache.this.remove(request);
            }

            @Override // okhttp3.internal.cache.InternalCache
            public void update(okhttp3.Response response, okhttp3.Response response2) {
                okhttp3.Cache.this.update(response, response2);
            }

            @Override // okhttp3.internal.cache.InternalCache
            public void trackConditionalCacheHit() {
                okhttp3.Cache.this.trackConditionalCacheHit();
            }

            @Override // okhttp3.internal.cache.InternalCache
            public void trackResponse(okhttp3.internal.cache.CacheStrategy cacheStrategy) {
                okhttp3.Cache.this.trackResponse(cacheStrategy);
            }
        };
        this.cache = okhttp3.internal.cache.DiskLruCache.create(fileSystem, file, VERSION, 2, j_renamed);
    }

    public static java.lang.String key(okhttp3.HttpUrl httpUrl) {
        return okio.ByteString.encodeUtf8(httpUrl.toString()).md5().hex();
    }

    @javax.annotation.Nullable
    okhttp3.Response get(okhttp3.Request request) throws java.io.IOException {
        try {
            okhttp3.internal.cache.DiskLruCache.Snapshot snapshot = this.cache.get(key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                okhttp3.Cache.Entry entry = new okhttp3.Cache.Entry(snapshot.getSource(0));
                okhttp3.Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                okhttp3.internal.Util.closeQuietly(response.body());
                return null;
            } catch (java.io.IOException unused) {
                okhttp3.internal.Util.closeQuietly(snapshot);
                return null;
            }
        } catch (java.io.IOException unused2) {
        }
    }

    @javax.annotation.Nullable
    okhttp3.internal.cache.CacheRequest put(okhttp3.Response response) {
        okhttp3.internal.cache.DiskLruCache.Editor editorEdit;
        java.lang.String strMethod = response.request().method();
        if (okhttp3.internal.http.HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove(response.request());
            } catch (java.io.IOException unused) {
            }
            return null;
        }
        if (!strMethod.equals("GET") || okhttp3.internal.http.HttpHeaders.hasVaryAll(response)) {
            return null;
        }
        okhttp3.Cache.Entry entry = new okhttp3.Cache.Entry(response);
        try {
            editorEdit = this.cache.edit(key(response.request().url()));
            if (editorEdit == null) {
                return null;
            }
            try {
                entry.writeTo(editorEdit);
                return new okhttp3.Cache.CacheRequestImpl(editorEdit);
            } catch (java.io.IOException unused2) {
                abortQuietly(editorEdit);
                return null;
            }
        } catch (java.io.IOException unused3) {
            editorEdit = null;
        }
    }

    void remove(okhttp3.Request request) throws java.io.IOException {
        this.cache.remove(key(request.url()));
    }

    void update(okhttp3.Response response, okhttp3.Response response2) {
        okhttp3.internal.cache.DiskLruCache.Editor editorEdit;
        okhttp3.Cache.Entry entry = new okhttp3.Cache.Entry(response2);
        try {
            editorEdit = ((okhttp3.Cache.CacheResponseBody) response.body()).snapshot.edit();
            if (editorEdit != null) {
                try {
                    entry.writeTo(editorEdit);
                    editorEdit.commit();
                } catch (java.io.IOException unused) {
                    abortQuietly(editorEdit);
                }
            }
        } catch (java.io.IOException unused2) {
            editorEdit = null;
        }
    }

    private void abortQuietly(@javax.annotation.Nullable okhttp3.internal.cache.DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public void initialize() throws java.io.IOException {
        this.cache.initialize();
    }

    public void delete() throws java.io.IOException {
        this.cache.delete();
    }

    public void evictAll() throws java.io.IOException {
        this.cache.evictAll();
    }

    public java.util.Iterator<java.lang.String> urls() throws java.io.IOException {
        return new java.util.Iterator<java.lang.String>() { // from class: okhttp3.Cache.2
            boolean canRemove;
            final java.util.Iterator<okhttp3.internal.cache.DiskLruCache.Snapshot> delegate;

            @javax.annotation.Nullable
            java.lang.String nextUrl;

            {
                this.delegate = okhttp3.Cache.this.cache.snapshots();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.nextUrl != null) {
                    return true;
                }
                this.canRemove = false;
                while (this.delegate.hasNext()) {
                    okhttp3.internal.cache.DiskLruCache.Snapshot next = this.delegate.next();
                    try {
                        this.nextUrl = okio.Okio.buffer(next.getSource(0)).readUtf8LineStrict();
                        return true;
                    } catch (java.io.IOException unused) {
                    } finally {
                        next.close();
                    }
                }
                return false;
            }

            @Override // java.util.Iterator
            public java.lang.String next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                java.lang.String str = this.nextUrl;
                this.nextUrl = null;
                this.canRemove = true;
                return str;
            }

            @Override // java.util.Iterator
            public void remove() {
                if (!this.canRemove) {
                    throw new java.lang.IllegalStateException("remove() before next()");
                }
                this.delegate.remove();
            }
        };
    }

    public synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    public long size() throws java.io.IOException {
        return this.cache.size();
    }

    public long maxSize() {
        return this.cache.getMaxSize();
    }

    @Override // java.io.Flushable
    public void flush() throws java.io.IOException {
        this.cache.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.cache.close();
    }

    public java.io.File directory() {
        return this.cache.getDirectory();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    synchronized void trackResponse(okhttp3.internal.cache.CacheStrategy cacheStrategy) {
        this.requestCount++;
        if (cacheStrategy.networkRequest != null) {
            this.networkCount++;
        } else if (cacheStrategy.cacheResponse != null) {
            this.hitCount++;
        }
    }

    synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    public synchronized int networkCount() {
        return this.networkCount;
    }

    public synchronized int hitCount() {
        return this.hitCount;
    }

    public synchronized int requestCount() {
        return this.requestCount;
    }

    private final class CacheRequestImpl implements okhttp3.internal.cache.CacheRequest {
        private okio.Sink body;
        private okio.Sink cacheOut;
        boolean done;
        private final okhttp3.internal.cache.DiskLruCache.Editor editor;

        CacheRequestImpl(final okhttp3.internal.cache.DiskLruCache.Editor editor) {
            this.editor = editor;
            this.cacheOut = editor.newSink(1);
            this.body = new okio.ForwardingSink(this.cacheOut) { // from class: okhttp3.Cache.CacheRequestImpl.1
                @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws java.io.IOException {
                    synchronized (okhttp3.Cache.this) {
                        if (okhttp3.Cache.CacheRequestImpl.this.done) {
                            return;
                        }
                        okhttp3.Cache.CacheRequestImpl.this.done = true;
                        okhttp3.Cache.this.writeSuccessCount++;
                        super.close();
                        editor.commit();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() throws java.io.IOException {
            synchronized (okhttp3.Cache.this) {
                if (this.done) {
                    return;
                }
                this.done = true;
                okhttp3.Cache.this.writeAbortCount++;
                okhttp3.internal.Util.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (java.io.IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public okio.Sink body() {
            return this.body;
        }
    }

    private static final class Entry {
        private final int code;

        @javax.annotation.Nullable
        private final okhttp3.Handshake handshake;
        private final java.lang.String message;
        private final okhttp3.Protocol protocol;
        private final long receivedResponseMillis;
        private final java.lang.String requestMethod;
        private final okhttp3.Headers responseHeaders;
        private final long sentRequestMillis;
        private final java.lang.String url;
        private final okhttp3.Headers varyHeaders;
        private static final java.lang.String SENT_MILLIS = okhttp3.internal.platform.Platform.get().getPrefix() + "-Sent-Millis";
        private static final java.lang.String RECEIVED_MILLIS = okhttp3.internal.platform.Platform.get().getPrefix() + "-Received-Millis";

        Entry(okio.Source source) throws java.io.IOException {
            okhttp3.TlsVersion tlsVersionForJavaName;
            try {
                okio.BufferedSource bufferedSourceBuffer = okio.Okio.buffer(source);
                this.url = bufferedSourceBuffer.readUtf8LineStrict();
                this.requestMethod = bufferedSourceBuffer.readUtf8LineStrict();
                okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
                int i_renamed = okhttp3.Cache.readInt(bufferedSourceBuffer);
                for (int i2 = 0; i2 < i_renamed; i2++) {
                    builder.addLenient(bufferedSourceBuffer.readUtf8LineStrict());
                }
                this.varyHeaders = builder.build();
                okhttp3.internal.http.StatusLine statusLine = okhttp3.internal.http.StatusLine.parse(bufferedSourceBuffer.readUtf8LineStrict());
                this.protocol = statusLine.protocol;
                this.code = statusLine.code;
                this.message = statusLine.message;
                okhttp3.Headers.Builder builder2 = new okhttp3.Headers.Builder();
                int i3 = okhttp3.Cache.readInt(bufferedSourceBuffer);
                for (int i4 = 0; i4 < i3; i4++) {
                    builder2.addLenient(bufferedSourceBuffer.readUtf8LineStrict());
                }
                java.lang.String str = builder2.get(SENT_MILLIS);
                java.lang.String str2 = builder2.get(RECEIVED_MILLIS);
                builder2.removeAll(SENT_MILLIS);
                builder2.removeAll(RECEIVED_MILLIS);
                this.sentRequestMillis = str != null ? java.lang.Long.parseLong(str) : 0L;
                this.receivedResponseMillis = str2 != null ? java.lang.Long.parseLong(str2) : 0L;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    java.lang.String utf8LineStrict = bufferedSourceBuffer.readUtf8LineStrict();
                    if (utf8LineStrict.length() > 0) {
                        throw new java.io.IOException("expected \"\" but was \"" + utf8LineStrict + "\"");
                    }
                    okhttp3.CipherSuite cipherSuiteForJavaName = okhttp3.CipherSuite.forJavaName(bufferedSourceBuffer.readUtf8LineStrict());
                    java.util.List<java.security.cert.Certificate> certificateList = readCertificateList(bufferedSourceBuffer);
                    java.util.List<java.security.cert.Certificate> certificateList2 = readCertificateList(bufferedSourceBuffer);
                    if (!bufferedSourceBuffer.exhausted()) {
                        tlsVersionForJavaName = okhttp3.TlsVersion.forJavaName(bufferedSourceBuffer.readUtf8LineStrict());
                    } else {
                        tlsVersionForJavaName = okhttp3.TlsVersion.SSL_3_0;
                    }
                    this.handshake = okhttp3.Handshake.get(tlsVersionForJavaName, cipherSuiteForJavaName, certificateList, certificateList2);
                } else {
                    this.handshake = null;
                }
            } finally {
                source.close();
            }
        }

        Entry(okhttp3.Response response) {
            this.url = response.request().url().toString();
            this.varyHeaders = okhttp3.internal.http.HttpHeaders.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }

        public void writeTo(okhttp3.internal.cache.DiskLruCache.Editor editor) throws java.io.IOException {
            okio.BufferedSink bufferedSinkBuffer = okio.Okio.buffer(editor.newSink(0));
            bufferedSinkBuffer.writeUtf8(this.url).writeByte(10);
            bufferedSinkBuffer.writeUtf8(this.requestMethod).writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.varyHeaders.size()).writeByte(10);
            int size = this.varyHeaders.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                bufferedSinkBuffer.writeUtf8(this.varyHeaders.name(i_renamed)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(i_renamed)).writeByte(10);
            }
            bufferedSinkBuffer.writeUtf8(new okhttp3.internal.http.StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);
            int size2 = this.responseHeaders.size();
            for (int i2 = 0; i2 < size2; i2++) {
                bufferedSinkBuffer.writeUtf8(this.responseHeaders.name(i2)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i2)).writeByte(10);
            }
            bufferedSinkBuffer.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
            bufferedSinkBuffer.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
            if (isHttps()) {
                bufferedSinkBuffer.writeByte(10);
                bufferedSinkBuffer.writeUtf8(this.handshake.cipherSuite().javaName()).writeByte(10);
                writeCertList(bufferedSinkBuffer, this.handshake.peerCertificates());
                writeCertList(bufferedSinkBuffer, this.handshake.localCertificates());
                bufferedSinkBuffer.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
            }
            bufferedSinkBuffer.close();
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private java.util.List<java.security.cert.Certificate> readCertificateList(okio.BufferedSource bufferedSource) throws java.io.IOException, java.security.cert.CertificateException {
            int i_renamed = okhttp3.Cache.readInt(bufferedSource);
            if (i_renamed == -1) {
                return java.util.Collections.emptyList();
            }
            try {
                java.security.cert.CertificateFactory certificateFactory = java.security.cert.CertificateFactory.getInstance("X_renamed.509");
                java.util.ArrayList arrayList = new java.util.ArrayList(i_renamed);
                for (int i2 = 0; i2 < i_renamed; i2++) {
                    java.lang.String utf8LineStrict = bufferedSource.readUtf8LineStrict();
                    okio.Buffer buffer = new okio.Buffer();
                    buffer.write(okio.ByteString.decodeBase64(utf8LineStrict));
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (java.security.cert.CertificateException e_renamed) {
                throw new java.io.IOException(e_renamed.getMessage());
            }
        }

        private void writeCertList(okio.BufferedSink bufferedSink, java.util.List<java.security.cert.Certificate> list) throws java.io.IOException {
            try {
                bufferedSink.writeDecimalLong(list.size()).writeByte(10);
                int size = list.size();
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    bufferedSink.writeUtf8(okio.ByteString.of_renamed(list.get(i_renamed).getEncoded()).base64()).writeByte(10);
                }
            } catch (java.security.cert.CertificateEncodingException e_renamed) {
                throw new java.io.IOException(e_renamed.getMessage());
            }
        }

        public boolean matches(okhttp3.Request request, okhttp3.Response response) {
            return this.url.equals(request.url().toString()) && this.requestMethod.equals(request.method()) && okhttp3.internal.http.HttpHeaders.varyMatches(response, this.varyHeaders, request);
        }

        public okhttp3.Response response(okhttp3.internal.cache.DiskLruCache.Snapshot snapshot) {
            java.lang.String str = this.responseHeaders.get("Content-Type");
            java.lang.String str2 = this.responseHeaders.get("Content-Length");
            return new okhttp3.Response.Builder().request(new okhttp3.Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new okhttp3.Cache.CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }
    }

    static int readInt(okio.BufferedSource bufferedSource) throws java.io.IOException {
        try {
            long decimalLong = bufferedSource.readDecimalLong();
            java.lang.String utf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (decimalLong >= 0 && decimalLong <= 2147483647L && utf8LineStrict.isEmpty()) {
                return (int) decimalLong;
            }
            throw new java.io.IOException("expected an_renamed int but was \"" + decimalLong + utf8LineStrict + "\"");
        } catch (java.lang.NumberFormatException e_renamed) {
            throw new java.io.IOException(e_renamed.getMessage());
        }
    }

    private static class CacheResponseBody extends okhttp3.ResponseBody {
        private final okio.BufferedSource bodySource;

        @javax.annotation.Nullable
        private final java.lang.String contentLength;

        @javax.annotation.Nullable
        private final java.lang.String contentType;
        final okhttp3.internal.cache.DiskLruCache.Snapshot snapshot;

        CacheResponseBody(final okhttp3.internal.cache.DiskLruCache.Snapshot snapshot, java.lang.String str, java.lang.String str2) {
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = okio.Okio.buffer(new okio.ForwardingSource(snapshot.getSource(1)) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws java.io.IOException {
                    snapshot.close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public okhttp3.MediaType contentType() {
            java.lang.String str = this.contentType;
            if (str != null) {
                return okhttp3.MediaType.parse(str);
            }
            return null;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            try {
                if (this.contentLength != null) {
                    return java.lang.Long.parseLong(this.contentLength);
                }
                return -1L;
            } catch (java.lang.NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // okhttp3.ResponseBody
        public okio.BufferedSource source() {
            return this.bodySource;
        }
    }
}
