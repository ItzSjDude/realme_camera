package okhttp3.internal.http2;

/* loaded from: classes2.dex */
public final class Http2Connection implements java.io.Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final java.util.concurrent.ExecutorService listenerExecutor = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), okhttp3.internal.Util.threadFactory("OkHttp Http2Connection", true));
    private boolean awaitingPong;
    long bytesLeftInWriteWindow;
    final boolean client;
    final java.lang.String hostname;
    int lastGoodStreamId;
    final okhttp3.internal.http2.Http2Connection.Listener listener;
    int nextStreamId;
    private final java.util.concurrent.ExecutorService pushExecutor;
    final okhttp3.internal.http2.PushObserver pushObserver;
    final okhttp3.internal.http2.Http2Connection.ReaderRunnable readerRunnable;
    boolean shutdown;
    final java.net.Socket socket;
    final okhttp3.internal.http2.Http2Writer writer;
    private final java.util.concurrent.ScheduledExecutorService writerExecutor;
    final java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> streams = new java.util.LinkedHashMap();
    long unacknowledgedBytesRead = 0;
    okhttp3.internal.http2.Settings okHttpSettings = new okhttp3.internal.http2.Settings();
    final okhttp3.internal.http2.Settings peerSettings = new okhttp3.internal.http2.Settings();
    boolean receivedInitialPeerSettings = false;
    final java.util.Set<java.lang.Integer> currentPushRequests = new java.util.LinkedHashSet();

    public static abstract class Listener {
        public static final okhttp3.internal.http2.Http2Connection.Listener REFUSE_INCOMING_STREAMS = new okhttp3.internal.http2.Http2Connection.Listener() { // from class: okhttp3.internal.http2.Http2Connection.Listener.1
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(okhttp3.internal.http2.Http2Stream http2Stream) throws java.io.IOException {
                http2Stream.close(okhttp3.internal.http2.ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(okhttp3.internal.http2.Http2Connection http2Connection) {
        }

        public abstract void onStream(okhttp3.internal.http2.Http2Stream http2Stream) throws java.io.IOException;
    }

    boolean pushedStream(int i_renamed) {
        return i_renamed != 0 && (i_renamed & 1) == 0;
    }

    Http2Connection(okhttp3.internal.http2.Http2Connection.Builder builder) {
        this.pushObserver = builder.pushObserver;
        this.client = builder.client;
        this.listener = builder.listener;
        this.nextStreamId = builder.client ? 1 : 2;
        if (builder.client) {
            this.nextStreamId += 2;
        }
        if (builder.client) {
            this.okHttpSettings.set(7, OKHTTP_CLIENT_WINDOW_SIZE);
        }
        this.hostname = builder.hostname;
        this.writerExecutor = new java.util.concurrent.ScheduledThreadPoolExecutor(1, okhttp3.internal.Util.threadFactory(okhttp3.internal.Util.format("OkHttp %s_renamed Writer", this.hostname), false));
        if (builder.pingIntervalMillis != 0) {
            this.writerExecutor.scheduleAtFixedRate(new okhttp3.internal.http2.Http2Connection.PingRunnable(false, 0, 0), builder.pingIntervalMillis, builder.pingIntervalMillis, java.util.concurrent.TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), okhttp3.internal.Util.threadFactory(okhttp3.internal.Util.format("OkHttp %s_renamed Push Observer", this.hostname), true));
        this.peerSettings.set(7, com.meicam.sdk.NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN);
        this.peerSettings.set(5, 16384);
        this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize();
        this.socket = builder.socket;
        this.writer = new okhttp3.internal.http2.Http2Writer(builder.sink, this.client);
        this.readerRunnable = new okhttp3.internal.http2.Http2Connection.ReaderRunnable(new okhttp3.internal.http2.Http2Reader(builder.source, this.client));
    }

    public okhttp3.Protocol getProtocol() {
        return okhttp3.Protocol.HTTP_2;
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    synchronized okhttp3.internal.http2.Http2Stream getStream(int i_renamed) {
        return this.streams.get(java.lang.Integer.valueOf(i_renamed));
    }

    synchronized okhttp3.internal.http2.Http2Stream removeStream(int i_renamed) {
        okhttp3.internal.http2.Http2Stream http2StreamRemove;
        http2StreamRemove = this.streams.remove(java.lang.Integer.valueOf(i_renamed));
        notifyAll();
        return http2StreamRemove;
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    synchronized void updateConnectionFlowControl(long j_renamed) {
        this.unacknowledgedBytesRead += j_renamed;
        if (this.unacknowledgedBytesRead >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
            this.unacknowledgedBytesRead = 0L;
        }
    }

    public okhttp3.internal.http2.Http2Stream pushStream(int i_renamed, java.util.List<okhttp3.internal.http2.Header> list, boolean z_renamed) throws java.io.IOException {
        if (this.client) {
            throw new java.lang.IllegalStateException("Client cannot push requests.");
        }
        return newStream(i_renamed, list, z_renamed);
    }

    public okhttp3.internal.http2.Http2Stream newStream(java.util.List<okhttp3.internal.http2.Header> list, boolean z_renamed) throws java.io.IOException {
        return newStream(0, list, z_renamed);
    }

    private okhttp3.internal.http2.Http2Stream newStream(int i_renamed, java.util.List<okhttp3.internal.http2.Header> list, boolean z_renamed) throws java.io.IOException {
        int i2;
        okhttp3.internal.http2.Http2Stream http2Stream;
        boolean z2;
        boolean z3 = !z_renamed;
        synchronized (this.writer) {
            synchronized (this) {
                if (this.nextStreamId > 1073741823) {
                    shutdown(okhttp3.internal.http2.ErrorCode.REFUSED_STREAM);
                }
                if (this.shutdown) {
                    throw new okhttp3.internal.http2.ConnectionShutdownException();
                }
                i2 = this.nextStreamId;
                this.nextStreamId += 2;
                http2Stream = new okhttp3.internal.http2.Http2Stream(i2, this, z3, false, null);
                z2 = !z_renamed || this.bytesLeftInWriteWindow == 0 || http2Stream.bytesLeftInWriteWindow == 0;
                if (http2Stream.isOpen()) {
                    this.streams.put(java.lang.Integer.valueOf(i2), http2Stream);
                }
            }
            if (i_renamed == 0) {
                this.writer.synStream(z3, i2, i_renamed, list);
            } else {
                if (this.client) {
                    throw new java.lang.IllegalArgumentException("client streams shouldn't_renamed have associated stream IDs");
                }
                this.writer.pushPromise(i_renamed, i2, list);
            }
        }
        if (z2) {
            this.writer.flush();
        }
        return http2Stream;
    }

    void writeSynReply(int i_renamed, boolean z_renamed, java.util.List<okhttp3.internal.http2.Header> list) throws java.io.IOException {
        this.writer.synReply(z_renamed, i_renamed, list);
    }

    public void writeData(int i_renamed, boolean z_renamed, okio.Buffer buffer, long j_renamed) throws java.io.IOException {
        int iMin;
        long j2;
        if (j_renamed == 0) {
            this.writer.data(z_renamed, i_renamed, buffer, 0);
            return;
        }
        while (j_renamed > 0) {
            synchronized (this) {
                while (this.bytesLeftInWriteWindow <= 0) {
                    try {
                        if (!this.streams.containsKey(java.lang.Integer.valueOf(i_renamed))) {
                            throw new java.io.IOException("stream closed");
                        }
                        wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                        throw new java.io.InterruptedIOException();
                    }
                }
                iMin = java.lang.Math.min((int) java.lang.Math.min(j_renamed, this.bytesLeftInWriteWindow), this.writer.maxDataLength());
                j2 = iMin;
                this.bytesLeftInWriteWindow -= j2;
            }
            j_renamed -= j2;
            this.writer.data(z_renamed && j_renamed == 0, i_renamed, buffer, iMin);
        }
    }

    void writeSynResetLater(final int i_renamed, final okhttp3.internal.http2.ErrorCode errorCode) {
        try {
            this.writerExecutor.execute(new okhttp3.internal.NamedRunnable("OkHttp %s_renamed stream %d_renamed", new java.lang.Object[]{this.hostname, java.lang.Integer.valueOf(i_renamed)}) { // from class: okhttp3.internal.http2.Http2Connection.1
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        okhttp3.internal.http2.Http2Connection.this.writeSynReset(i_renamed, errorCode);
                    } catch (java.io.IOException unused) {
                        okhttp3.internal.http2.Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (java.util.concurrent.RejectedExecutionException unused) {
        }
    }

    void writeSynReset(int i_renamed, okhttp3.internal.http2.ErrorCode errorCode) throws java.io.IOException {
        this.writer.rstStream(i_renamed, errorCode);
    }

    void writeWindowUpdateLater(final int i_renamed, final long j_renamed) {
        try {
            this.writerExecutor.execute(new okhttp3.internal.NamedRunnable("OkHttp Window Update %s_renamed stream %d_renamed", new java.lang.Object[]{this.hostname, java.lang.Integer.valueOf(i_renamed)}) { // from class: okhttp3.internal.http2.Http2Connection.2
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        okhttp3.internal.http2.Http2Connection.this.writer.windowUpdate(i_renamed, j_renamed);
                    } catch (java.io.IOException unused) {
                        okhttp3.internal.http2.Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (java.util.concurrent.RejectedExecutionException unused) {
        }
    }

    final class PingRunnable extends okhttp3.internal.NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;

        PingRunnable(boolean z_renamed, int i_renamed, int i2) {
            super("OkHttp %s_renamed ping %08x%08x", okhttp3.internal.http2.Http2Connection.this.hostname, java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2));
            this.reply = z_renamed;
            this.payload1 = i_renamed;
            this.payload2 = i2;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            okhttp3.internal.http2.Http2Connection.this.writePing(this.reply, this.payload1, this.payload2);
        }
    }

    void writePing(boolean z_renamed, int i_renamed, int i2) {
        boolean z2;
        if (!z_renamed) {
            synchronized (this) {
                z2 = this.awaitingPong;
                this.awaitingPong = true;
            }
            if (z2) {
                failConnection();
                return;
            }
        }
        try {
            this.writer.ping(z_renamed, i_renamed, i2);
        } catch (java.io.IOException unused) {
            failConnection();
        }
    }

    void writePingAndAwaitPong() throws java.lang.InterruptedException {
        writePing(false, 1330343787, -257978967);
        awaitPong();
    }

    synchronized void awaitPong() throws java.lang.InterruptedException {
        while (this.awaitingPong) {
            wait();
        }
    }

    public void flush() throws java.io.IOException {
        this.writer.flush();
    }

    public void shutdown(okhttp3.internal.http2.ErrorCode errorCode) throws java.io.IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                this.writer.goAway(this.lastGoodStreamId, errorCode, okhttp3.internal.Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        close(okhttp3.internal.http2.ErrorCode.NO_ERROR, okhttp3.internal.http2.ErrorCode.CANCEL);
    }

    void close(okhttp3.internal.http2.ErrorCode errorCode, okhttp3.internal.http2.ErrorCode errorCode2) throws java.io.IOException {
        okhttp3.internal.http2.Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            e_renamed = null;
        } catch (java.io.IOException e_renamed) {
            e_renamed = e_renamed;
        }
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                http2StreamArr = (okhttp3.internal.http2.Http2Stream[]) this.streams.values().toArray(new okhttp3.internal.http2.Http2Stream[this.streams.size()]);
                this.streams.clear();
            }
        }
        if (http2StreamArr != null) {
            for (okhttp3.internal.http2.Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(errorCode2);
                } catch (java.io.IOException e2) {
                    if (e_renamed != null) {
                        e_renamed = e2;
                    }
                }
            }
        }
        try {
            this.writer.close();
        } catch (java.io.IOException e3) {
            if (e_renamed == null) {
                e_renamed = e3;
            }
        }
        try {
            this.socket.close();
        } catch (java.io.IOException e4) {
            e_renamed = e4;
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e_renamed != null) {
            throw e_renamed;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failConnection() {
        try {
            close(okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR, okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR);
        } catch (java.io.IOException unused) {
        }
    }

    public void start() throws java.io.IOException {
        start(true);
    }

    void start(boolean z_renamed) throws java.io.IOException {
        if (z_renamed) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            if (this.okHttpSettings.getInitialWindowSize() != 65535) {
                this.writer.windowUpdate(0, r6 - com.meicam.sdk.NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN);
            }
        }
        new java.lang.Thread(this.readerRunnable).start();
    }

    public void setSettings(okhttp3.internal.http2.Settings settings) throws java.io.IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.shutdown) {
                    throw new okhttp3.internal.http2.ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
            }
            this.writer.settings(settings);
        }
    }

    public synchronized boolean isShutdown() {
        return this.shutdown;
    }

    public static class Builder {
        boolean client;
        java.lang.String hostname;
        int pingIntervalMillis;
        okio.BufferedSink sink;
        java.net.Socket socket;
        okio.BufferedSource source;
        okhttp3.internal.http2.Http2Connection.Listener listener = okhttp3.internal.http2.Http2Connection.Listener.REFUSE_INCOMING_STREAMS;
        okhttp3.internal.http2.PushObserver pushObserver = okhttp3.internal.http2.PushObserver.CANCEL;

        public Builder(boolean z_renamed) {
            this.client = z_renamed;
        }

        public okhttp3.internal.http2.Http2Connection.Builder socket(java.net.Socket socket) throws java.io.IOException {
            return socket(socket, ((java.net.InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), okio.Okio.buffer(okio.Okio.source(socket)), okio.Okio.buffer(okio.Okio.sink(socket)));
        }

        public okhttp3.internal.http2.Http2Connection.Builder socket(java.net.Socket socket, java.lang.String str, okio.BufferedSource bufferedSource, okio.BufferedSink bufferedSink) {
            this.socket = socket;
            this.hostname = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }

        public okhttp3.internal.http2.Http2Connection.Builder listener(okhttp3.internal.http2.Http2Connection.Listener listener) {
            this.listener = listener;
            return this;
        }

        public okhttp3.internal.http2.Http2Connection.Builder pushObserver(okhttp3.internal.http2.PushObserver pushObserver) {
            this.pushObserver = pushObserver;
            return this;
        }

        public okhttp3.internal.http2.Http2Connection.Builder pingIntervalMillis(int i_renamed) {
            this.pingIntervalMillis = i_renamed;
            return this;
        }

        public okhttp3.internal.http2.Http2Connection build() {
            return new okhttp3.internal.http2.Http2Connection(this);
        }
    }

    class ReaderRunnable extends okhttp3.internal.NamedRunnable implements okhttp3.internal.http2.Http2Reader.Handler {
        final okhttp3.internal.http2.Http2Reader reader;

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i_renamed, java.lang.String str, okio.ByteString byteString, java.lang.String str2, int i2, long j_renamed) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i_renamed, int i2, int i3, boolean z_renamed) {
        }

        ReaderRunnable(okhttp3.internal.http2.Http2Reader http2Reader) {
            super("OkHttp %s_renamed", okhttp3.internal.http2.Http2Connection.this.hostname);
            this.reader = http2Reader;
        }

        @Override // okhttp3.internal.NamedRunnable
        protected void execute() throws java.io.IOException {
            okhttp3.internal.http2.Http2Connection http2Connection;
            okhttp3.internal.http2.ErrorCode errorCode = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR;
            okhttp3.internal.http2.ErrorCode errorCode2 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.reader.readConnectionPreface(this);
                        while (this.reader.nextFrame(false, this)) {
                        }
                        errorCode = okhttp3.internal.http2.ErrorCode.NO_ERROR;
                        errorCode2 = okhttp3.internal.http2.ErrorCode.CANCEL;
                        http2Connection = okhttp3.internal.http2.Http2Connection.this;
                    } catch (java.io.IOException unused) {
                    }
                } catch (java.io.IOException unused2) {
                    errorCode = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
                    errorCode2 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
                    http2Connection = okhttp3.internal.http2.Http2Connection.this;
                }
                http2Connection.close(errorCode, errorCode2);
                okhttp3.internal.Util.closeQuietly(this.reader);
            } catch (java.lang.Throwable th) {
                try {
                    okhttp3.internal.http2.Http2Connection.this.close(errorCode, errorCode2);
                } catch (java.io.IOException unused3) {
                }
                okhttp3.internal.Util.closeQuietly(this.reader);
                throw th;
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z_renamed, int i_renamed, okio.BufferedSource bufferedSource, int i2) throws java.io.IOException {
            if (okhttp3.internal.http2.Http2Connection.this.pushedStream(i_renamed)) {
                okhttp3.internal.http2.Http2Connection.this.pushDataLater(i_renamed, bufferedSource, i2, z_renamed);
                return;
            }
            okhttp3.internal.http2.Http2Stream stream = okhttp3.internal.http2.Http2Connection.this.getStream(i_renamed);
            if (stream == null) {
                okhttp3.internal.http2.Http2Connection.this.writeSynResetLater(i_renamed, okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR);
                long j_renamed = i2;
                okhttp3.internal.http2.Http2Connection.this.updateConnectionFlowControl(j_renamed);
                bufferedSource.skip(j_renamed);
                return;
            }
            stream.receiveData(bufferedSource, i2);
            if (z_renamed) {
                stream.receiveFin();
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z_renamed, int i_renamed, int i2, java.util.List<okhttp3.internal.http2.Header> list) {
            if (okhttp3.internal.http2.Http2Connection.this.pushedStream(i_renamed)) {
                okhttp3.internal.http2.Http2Connection.this.pushHeadersLater(i_renamed, list, z_renamed);
                return;
            }
            synchronized (okhttp3.internal.http2.Http2Connection.this) {
                okhttp3.internal.http2.Http2Stream stream = okhttp3.internal.http2.Http2Connection.this.getStream(i_renamed);
                if (stream == null) {
                    if (okhttp3.internal.http2.Http2Connection.this.shutdown) {
                        return;
                    }
                    if (i_renamed <= okhttp3.internal.http2.Http2Connection.this.lastGoodStreamId) {
                        return;
                    }
                    if (i_renamed % 2 == okhttp3.internal.http2.Http2Connection.this.nextStreamId % 2) {
                        return;
                    }
                    final okhttp3.internal.http2.Http2Stream http2Stream = new okhttp3.internal.http2.Http2Stream(i_renamed, okhttp3.internal.http2.Http2Connection.this, false, z_renamed, okhttp3.internal.Util.toHeaders(list));
                    okhttp3.internal.http2.Http2Connection.this.lastGoodStreamId = i_renamed;
                    okhttp3.internal.http2.Http2Connection.this.streams.put(java.lang.Integer.valueOf(i_renamed), http2Stream);
                    okhttp3.internal.http2.Http2Connection.listenerExecutor.execute(new okhttp3.internal.NamedRunnable("OkHttp %s_renamed stream %d_renamed", new java.lang.Object[]{okhttp3.internal.http2.Http2Connection.this.hostname, java.lang.Integer.valueOf(i_renamed)}) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.1
                        @Override // okhttp3.internal.NamedRunnable
                        public void execute() {
                            try {
                                okhttp3.internal.http2.Http2Connection.this.listener.onStream(http2Stream);
                            } catch (java.io.IOException e_renamed) {
                                okhttp3.internal.platform.Platform.get().log(4, "Http2Connection.Listener failure for " + okhttp3.internal.http2.Http2Connection.this.hostname, e_renamed);
                                try {
                                    http2Stream.close(okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR);
                                } catch (java.io.IOException unused) {
                                }
                            }
                        }
                    });
                    return;
                }
                stream.receiveHeaders(list);
                if (z_renamed) {
                    stream.receiveFin();
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i_renamed, okhttp3.internal.http2.ErrorCode errorCode) {
            if (okhttp3.internal.http2.Http2Connection.this.pushedStream(i_renamed)) {
                okhttp3.internal.http2.Http2Connection.this.pushResetLater(i_renamed, errorCode);
                return;
            }
            okhttp3.internal.http2.Http2Stream http2StreamRemoveStream = okhttp3.internal.http2.Http2Connection.this.removeStream(i_renamed);
            if (http2StreamRemoveStream != null) {
                http2StreamRemoveStream.receiveRstStream(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(boolean z_renamed, okhttp3.internal.http2.Settings settings) {
            okhttp3.internal.http2.Http2Stream[] http2StreamArr;
            long j_renamed;
            int i_renamed;
            synchronized (okhttp3.internal.http2.Http2Connection.this) {
                int initialWindowSize = okhttp3.internal.http2.Http2Connection.this.peerSettings.getInitialWindowSize();
                if (z_renamed) {
                    okhttp3.internal.http2.Http2Connection.this.peerSettings.clear();
                }
                okhttp3.internal.http2.Http2Connection.this.peerSettings.merge(settings);
                applyAndAckSettings(settings);
                int initialWindowSize2 = okhttp3.internal.http2.Http2Connection.this.peerSettings.getInitialWindowSize();
                http2StreamArr = null;
                if (initialWindowSize2 == -1 || initialWindowSize2 == initialWindowSize) {
                    j_renamed = 0;
                } else {
                    j_renamed = initialWindowSize2 - initialWindowSize;
                    if (!okhttp3.internal.http2.Http2Connection.this.receivedInitialPeerSettings) {
                        okhttp3.internal.http2.Http2Connection.this.receivedInitialPeerSettings = true;
                    }
                    if (!okhttp3.internal.http2.Http2Connection.this.streams.isEmpty()) {
                        http2StreamArr = (okhttp3.internal.http2.Http2Stream[]) okhttp3.internal.http2.Http2Connection.this.streams.values().toArray(new okhttp3.internal.http2.Http2Stream[okhttp3.internal.http2.Http2Connection.this.streams.size()]);
                    }
                }
                okhttp3.internal.http2.Http2Connection.listenerExecutor.execute(new okhttp3.internal.NamedRunnable("OkHttp %s_renamed settings", okhttp3.internal.http2.Http2Connection.this.hostname) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.2
                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        okhttp3.internal.http2.Http2Connection.this.listener.onSettings(okhttp3.internal.http2.Http2Connection.this);
                    }
                });
            }
            if (http2StreamArr == null || j_renamed == 0) {
                return;
            }
            for (okhttp3.internal.http2.Http2Stream http2Stream : http2StreamArr) {
                synchronized (http2Stream) {
                    http2Stream.addBytesToWriteWindow(j_renamed);
                }
            }
        }

        private void applyAndAckSettings(final okhttp3.internal.http2.Settings settings) {
            try {
                okhttp3.internal.http2.Http2Connection.this.writerExecutor.execute(new okhttp3.internal.NamedRunnable("OkHttp %s_renamed ACK Settings", new java.lang.Object[]{okhttp3.internal.http2.Http2Connection.this.hostname}) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.3
                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        try {
                            okhttp3.internal.http2.Http2Connection.this.writer.applyAndAckSettings(settings);
                        } catch (java.io.IOException unused) {
                            okhttp3.internal.http2.Http2Connection.this.failConnection();
                        }
                    }
                });
            } catch (java.util.concurrent.RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z_renamed, int i_renamed, int i2) {
            if (!z_renamed) {
                try {
                    okhttp3.internal.http2.Http2Connection.this.writerExecutor.execute(okhttp3.internal.http2.Http2Connection.this.new PingRunnable(true, i_renamed, i2));
                } catch (java.util.concurrent.RejectedExecutionException unused) {
                }
            } else {
                synchronized (okhttp3.internal.http2.Http2Connection.this) {
                    okhttp3.internal.http2.Http2Connection.this.awaitingPong = false;
                    okhttp3.internal.http2.Http2Connection.this.notifyAll();
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i_renamed, okhttp3.internal.http2.ErrorCode errorCode, okio.ByteString byteString) {
            okhttp3.internal.http2.Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (okhttp3.internal.http2.Http2Connection.this) {
                http2StreamArr = (okhttp3.internal.http2.Http2Stream[]) okhttp3.internal.http2.Http2Connection.this.streams.values().toArray(new okhttp3.internal.http2.Http2Stream[okhttp3.internal.http2.Http2Connection.this.streams.size()]);
                okhttp3.internal.http2.Http2Connection.this.shutdown = true;
            }
            for (okhttp3.internal.http2.Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i_renamed && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(okhttp3.internal.http2.ErrorCode.REFUSED_STREAM);
                    okhttp3.internal.http2.Http2Connection.this.removeStream(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i_renamed, long j_renamed) {
            if (i_renamed == 0) {
                synchronized (okhttp3.internal.http2.Http2Connection.this) {
                    okhttp3.internal.http2.Http2Connection.this.bytesLeftInWriteWindow += j_renamed;
                    okhttp3.internal.http2.Http2Connection.this.notifyAll();
                }
                return;
            }
            okhttp3.internal.http2.Http2Stream stream = okhttp3.internal.http2.Http2Connection.this.getStream(i_renamed);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j_renamed);
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i_renamed, int i2, java.util.List<okhttp3.internal.http2.Header> list) {
            okhttp3.internal.http2.Http2Connection.this.pushRequestLater(i2, list);
        }
    }

    void pushRequestLater(final int i_renamed, final java.util.List<okhttp3.internal.http2.Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(java.lang.Integer.valueOf(i_renamed))) {
                writeSynResetLater(i_renamed, okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(java.lang.Integer.valueOf(i_renamed));
            try {
                pushExecutorExecute(new okhttp3.internal.NamedRunnable("OkHttp %s_renamed Push Request[%s_renamed]", new java.lang.Object[]{this.hostname, java.lang.Integer.valueOf(i_renamed)}) { // from class: okhttp3.internal.http2.Http2Connection.3
                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        if (okhttp3.internal.http2.Http2Connection.this.pushObserver.onRequest(i_renamed, list)) {
                            try {
                                okhttp3.internal.http2.Http2Connection.this.writer.rstStream(i_renamed, okhttp3.internal.http2.ErrorCode.CANCEL);
                                synchronized (okhttp3.internal.http2.Http2Connection.this) {
                                    okhttp3.internal.http2.Http2Connection.this.currentPushRequests.remove(java.lang.Integer.valueOf(i_renamed));
                                }
                            } catch (java.io.IOException unused) {
                            }
                        }
                    }
                });
            } catch (java.util.concurrent.RejectedExecutionException unused) {
            }
        }
    }

    void pushHeadersLater(final int i_renamed, final java.util.List<okhttp3.internal.http2.Header> list, final boolean z_renamed) {
        try {
            pushExecutorExecute(new okhttp3.internal.NamedRunnable("OkHttp %s_renamed Push Headers[%s_renamed]", new java.lang.Object[]{this.hostname, java.lang.Integer.valueOf(i_renamed)}) { // from class: okhttp3.internal.http2.Http2Connection.4
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    boolean zOnHeaders = okhttp3.internal.http2.Http2Connection.this.pushObserver.onHeaders(i_renamed, list, z_renamed);
                    if (zOnHeaders) {
                        try {
                            okhttp3.internal.http2.Http2Connection.this.writer.rstStream(i_renamed, okhttp3.internal.http2.ErrorCode.CANCEL);
                        } catch (java.io.IOException unused) {
                            return;
                        }
                    }
                    if (zOnHeaders || z_renamed) {
                        synchronized (okhttp3.internal.http2.Http2Connection.this) {
                            okhttp3.internal.http2.Http2Connection.this.currentPushRequests.remove(java.lang.Integer.valueOf(i_renamed));
                        }
                    }
                }
            });
        } catch (java.util.concurrent.RejectedExecutionException unused) {
        }
    }

    void pushDataLater(final int i_renamed, okio.BufferedSource bufferedSource, final int i2, final boolean z_renamed) throws java.io.IOException {
        final okio.Buffer buffer = new okio.Buffer();
        long j_renamed = i2;
        bufferedSource.require(j_renamed);
        bufferedSource.read(buffer, j_renamed);
        if (buffer.size() != j_renamed) {
            throw new java.io.IOException(buffer.size() + " != " + i2);
        }
        pushExecutorExecute(new okhttp3.internal.NamedRunnable("OkHttp %s_renamed Push Data[%s_renamed]", new java.lang.Object[]{this.hostname, java.lang.Integer.valueOf(i_renamed)}) { // from class: okhttp3.internal.http2.Http2Connection.5
            @Override // okhttp3.internal.NamedRunnable
            public void execute() {
                try {
                    boolean zOnData = okhttp3.internal.http2.Http2Connection.this.pushObserver.onData(i_renamed, buffer, i2, z_renamed);
                    if (zOnData) {
                        okhttp3.internal.http2.Http2Connection.this.writer.rstStream(i_renamed, okhttp3.internal.http2.ErrorCode.CANCEL);
                    }
                    if (zOnData || z_renamed) {
                        synchronized (okhttp3.internal.http2.Http2Connection.this) {
                            okhttp3.internal.http2.Http2Connection.this.currentPushRequests.remove(java.lang.Integer.valueOf(i_renamed));
                        }
                    }
                } catch (java.io.IOException unused) {
                }
            }
        });
    }

    void pushResetLater(final int i_renamed, final okhttp3.internal.http2.ErrorCode errorCode) {
        pushExecutorExecute(new okhttp3.internal.NamedRunnable("OkHttp %s_renamed Push Reset[%s_renamed]", new java.lang.Object[]{this.hostname, java.lang.Integer.valueOf(i_renamed)}) { // from class: okhttp3.internal.http2.Http2Connection.6
            @Override // okhttp3.internal.NamedRunnable
            public void execute() {
                okhttp3.internal.http2.Http2Connection.this.pushObserver.onReset(i_renamed, errorCode);
                synchronized (okhttp3.internal.http2.Http2Connection.this) {
                    okhttp3.internal.http2.Http2Connection.this.currentPushRequests.remove(java.lang.Integer.valueOf(i_renamed));
                }
            }
        });
    }

    private synchronized void pushExecutorExecute(okhttp3.internal.NamedRunnable namedRunnable) {
        if (!isShutdown()) {
            this.pushExecutor.execute(namedRunnable);
        }
    }
}
