package okhttp3.internal.ws;

/* loaded from: classes2.dex */
public final class RealWebSocket implements okhttp3.WebSocket, okhttp3.internal.ws.WebSocketReader.FrameCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final java.util.List<okhttp3.Protocol> ONLY_HTTP1 = java.util.Collections.singletonList(okhttp3.Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private okhttp3.Call call;
    private java.util.concurrent.ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private java.util.concurrent.ScheduledExecutorService executor;
    private boolean failed;
    private final java.lang.String key;
    final okhttp3.WebSocketListener listener;
    private final okhttp3.Request originalRequest;
    private final long pingIntervalMillis;
    private long queueSize;
    private final java.util.Random random;
    private okhttp3.internal.ws.WebSocketReader reader;
    private java.lang.String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private okhttp3.internal.ws.RealWebSocket.Streams streams;
    private okhttp3.internal.ws.WebSocketWriter writer;
    private final java.lang.Runnable writerRunnable;
    private final java.util.ArrayDeque<okio.ByteString> pongQueue = new java.util.ArrayDeque<>();
    private final java.util.ArrayDeque<java.lang.Object> messageAndCloseQueue = new java.util.ArrayDeque<>();
    private int receivedCloseCode = -1;

    public RealWebSocket(okhttp3.Request request, okhttp3.WebSocketListener webSocketListener, java.util.Random random, long j_renamed) {
        if (!"GET".equals(request.method())) {
            throw new java.lang.IllegalArgumentException("Request must be_renamed GET: " + request.method());
        }
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random;
        this.pingIntervalMillis = j_renamed;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = okio.ByteString.of_renamed(bArr).base64();
        this.writerRunnable = new java.lang.Runnable() { // from class: okhttp3.internal.ws.RealWebSocket.1
            @Override // java.lang.Runnable
            public void run() throws java.io.IOException {
                do {
                    try {
                    } catch (java.io.IOException e_renamed) {
                        okhttp3.internal.ws.RealWebSocket.this.failWebSocket(e_renamed, null);
                        return;
                    }
                } while (okhttp3.internal.ws.RealWebSocket.this.writeOneFrame());
            }
        };
    }

    @Override // okhttp3.WebSocket
    public okhttp3.Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        this.call.cancel();
    }

    public void connect(okhttp3.OkHttpClient okHttpClient) {
        okhttp3.OkHttpClient okHttpClientBuild = okHttpClient.newBuilder().eventListener(okhttp3.EventListener.NONE).protocols(ONLY_HTTP1).build();
        final okhttp3.Request requestBuild = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
        this.call = okhttp3.internal.Internal.instance.newWebSocketCall(okHttpClientBuild, requestBuild);
        this.call.timeout().clearTimeout();
        this.call.enqueue(new okhttp3.Callback() { // from class: okhttp3.internal.ws.RealWebSocket.2
            @Override // okhttp3.Callback
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.io.IOException {
                try {
                    okhttp3.internal.ws.RealWebSocket.this.checkResponse(response);
                    okhttp3.internal.connection.StreamAllocation streamAllocation = okhttp3.internal.Internal.instance.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    okhttp3.internal.ws.RealWebSocket.Streams streamsNewWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        okhttp3.internal.ws.RealWebSocket.this.listener.onOpen(okhttp3.internal.ws.RealWebSocket.this, response);
                        okhttp3.internal.ws.RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + requestBuild.url().redact(), streamsNewWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        okhttp3.internal.ws.RealWebSocket.this.loopReader();
                    } catch (java.lang.Exception e_renamed) {
                        okhttp3.internal.ws.RealWebSocket.this.failWebSocket(e_renamed, null);
                    }
                } catch (java.net.ProtocolException e2) {
                    okhttp3.internal.ws.RealWebSocket.this.failWebSocket(e2, response);
                    okhttp3.internal.Util.closeQuietly(response);
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(okhttp3.Call call, java.io.IOException iOException) throws java.io.IOException {
                okhttp3.internal.ws.RealWebSocket.this.failWebSocket(iOException, null);
            }
        });
    }

    void checkResponse(okhttp3.Response response) throws java.net.ProtocolException {
        if (response.code() != 101) {
            throw new java.net.ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
        }
        java.lang.String strHeader = response.header("Connection");
        if (!"Upgrade".equalsIgnoreCase(strHeader)) {
            throw new java.net.ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strHeader + "'");
        }
        java.lang.String strHeader2 = response.header("Upgrade");
        if (!"websocket".equalsIgnoreCase(strHeader2)) {
            throw new java.net.ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strHeader2 + "'");
        }
        java.lang.String strHeader3 = response.header("Sec-WebSocket-Accept");
        java.lang.String strBase64 = okio.ByteString.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (strBase64.equals(strHeader3)) {
            return;
        }
        throw new java.net.ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strBase64 + "' but was '" + strHeader3 + "'");
    }

    public void initReaderAndWriter(java.lang.String str, okhttp3.internal.ws.RealWebSocket.Streams streams) throws java.io.IOException {
        synchronized (this) {
            this.streams = streams;
            this.writer = new okhttp3.internal.ws.WebSocketWriter(streams.client, streams.sink, this.random);
            this.executor = new java.util.concurrent.ScheduledThreadPoolExecutor(1, okhttp3.internal.Util.threadFactory(str, false));
            if (this.pingIntervalMillis != 0) {
                this.executor.scheduleAtFixedRate(new okhttp3.internal.ws.RealWebSocket.PingRunnable(), this.pingIntervalMillis, this.pingIntervalMillis, java.util.concurrent.TimeUnit.MILLISECONDS);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
        }
        this.reader = new okhttp3.internal.ws.WebSocketReader(streams.client, streams.source, this);
    }

    public void loopReader() throws java.io.IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    boolean processNextFrame() throws java.io.IOException {
        try {
            this.reader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (java.lang.Exception e_renamed) {
            this.failWebSocket(e_renamed, null);
            return false;
        }
    }

    void awaitTermination(int i_renamed, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        this.executor.awaitTermination(i_renamed, timeUnit);
    }

    void tearDown() throws java.lang.InterruptedException {
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.cancelFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.executor.shutdown();
        this.executor.awaitTermination(10L, java.util.concurrent.TimeUnit.SECONDS);
    }

    synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(java.lang.String str) throws java.io.IOException {
        this.listener.onMessage(this, str);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(okio.ByteString byteString) throws java.io.IOException {
        this.listener.onMessage(this, byteString);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(okio.ByteString byteString) {
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(byteString);
            runWriter();
            this.receivedPingCount++;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(okio.ByteString byteString) {
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i_renamed, java.lang.String str) throws java.io.IOException {
        okhttp3.internal.ws.RealWebSocket.Streams streams;
        if (i_renamed == -1) {
            throw new java.lang.IllegalArgumentException();
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                throw new java.lang.IllegalStateException("already closed");
            }
            this.receivedCloseCode = i_renamed;
            this.receivedCloseReason = str;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                streams = this.streams;
                this.streams = null;
                if (this.cancelFuture != null) {
                    this.cancelFuture.cancel(false);
                }
                this.executor.shutdown();
            } else {
                streams = null;
            }
        }
        try {
            this.listener.onClosing(this, i_renamed, str);
            if (streams != null) {
                this.listener.onClosed(this, i_renamed, str);
            }
        } finally {
            okhttp3.internal.Util.closeQuietly(streams);
        }
    }

    @Override // okhttp3.WebSocket
    public boolean send(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("text == null");
        }
        return send(okio.ByteString.encodeUtf8(str), 1);
    }

    @Override // okhttp3.WebSocket
    public boolean send(okio.ByteString byteString) {
        if (byteString == null) {
            throw new java.lang.NullPointerException("bytes == null");
        }
        return send(byteString, 2);
    }

    private synchronized boolean send(okio.ByteString byteString, int i_renamed) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + byteString.size() > 16777216) {
                close(com.heytap.accessory.CommonStatusCodes.AUTHENTICATE_SUCCESS, null);
                return false;
            }
            this.queueSize += byteString.size();
            this.messageAndCloseQueue.add(new okhttp3.internal.ws.RealWebSocket.Message(i_renamed, byteString));
            runWriter();
            return true;
        }
        return false;
    }

    synchronized boolean pong(okio.ByteString byteString) {
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(byteString);
            runWriter();
            return true;
        }
        return false;
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i_renamed, java.lang.String str) {
        return close(i_renamed, str, 60000L);
    }

    synchronized boolean close(int i_renamed, java.lang.String str, long j_renamed) {
        okhttp3.internal.ws.WebSocketProtocol.validateCloseCode(i_renamed);
        okio.ByteString byteStringEncodeUtf8 = null;
        if (str != null) {
            byteStringEncodeUtf8 = okio.ByteString.encodeUtf8(str);
            if (byteStringEncodeUtf8.size() > 123) {
                throw new java.lang.IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.failed && !this.enqueuedClose) {
            this.enqueuedClose = true;
            this.messageAndCloseQueue.add(new okhttp3.internal.ws.RealWebSocket.Close(i_renamed, byteStringEncodeUtf8, j_renamed));
            runWriter();
            return true;
        }
        return false;
    }

    private void runWriter() {
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.writerRunnable);
        }
    }

    boolean writeOneFrame() throws java.io.IOException {
        int i_renamed;
        java.lang.Object objPoll;
        java.lang.String str;
        synchronized (this) {
            if (this.failed) {
                return false;
            }
            okhttp3.internal.ws.WebSocketWriter webSocketWriter = this.writer;
            okio.ByteString byteStringPoll = this.pongQueue.poll();
            okhttp3.internal.ws.RealWebSocket.Streams streams = null;
            if (byteStringPoll == null) {
                objPoll = this.messageAndCloseQueue.poll();
                if (objPoll instanceof okhttp3.internal.ws.RealWebSocket.Close) {
                    i_renamed = this.receivedCloseCode;
                    str = this.receivedCloseReason;
                    if (i_renamed != -1) {
                        okhttp3.internal.ws.RealWebSocket.Streams streams2 = this.streams;
                        this.streams = null;
                        this.executor.shutdown();
                        streams = streams2;
                    } else {
                        this.cancelFuture = this.executor.schedule(new okhttp3.internal.ws.RealWebSocket.CancelRunnable(), ((okhttp3.internal.ws.RealWebSocket.Close) objPoll).cancelAfterCloseMillis, java.util.concurrent.TimeUnit.MILLISECONDS);
                    }
                } else {
                    if (objPoll == null) {
                        return false;
                    }
                    i_renamed = -1;
                    str = null;
                }
            } else {
                i_renamed = -1;
                objPoll = null;
                str = null;
            }
            try {
                if (byteStringPoll != null) {
                    webSocketWriter.writePong(byteStringPoll);
                } else if (objPoll instanceof okhttp3.internal.ws.RealWebSocket.Message) {
                    okio.ByteString byteString = ((okhttp3.internal.ws.RealWebSocket.Message) objPoll).data;
                    okio.BufferedSink bufferedSinkBuffer = okio.Okio.buffer(webSocketWriter.newMessageSink(((okhttp3.internal.ws.RealWebSocket.Message) objPoll).formatOpcode, byteString.size()));
                    bufferedSinkBuffer.write(byteString);
                    bufferedSinkBuffer.close();
                    synchronized (this) {
                        this.queueSize -= byteString.size();
                    }
                } else if (objPoll instanceof okhttp3.internal.ws.RealWebSocket.Close) {
                    okhttp3.internal.ws.RealWebSocket.Close close = (okhttp3.internal.ws.RealWebSocket.Close) objPoll;
                    webSocketWriter.writeClose(close.code, close.reason);
                    if (streams != null) {
                        this.listener.onClosed(this, i_renamed, str);
                    }
                } else {
                    throw new java.lang.AssertionError();
                }
                return true;
            } finally {
                okhttp3.internal.Util.closeQuietly(streams);
            }
        }
    }

    private final class PingRunnable implements java.lang.Runnable {
        PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() throws java.io.IOException {
            okhttp3.internal.ws.RealWebSocket.this.writePingFrame();
        }
    }

    void writePingFrame() throws java.io.IOException {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            okhttp3.internal.ws.WebSocketWriter webSocketWriter = this.writer;
            int i_renamed = this.awaitingPong ? this.sentPingCount : -1;
            this.sentPingCount++;
            this.awaitingPong = true;
            if (i_renamed != -1) {
                failWebSocket(new java.net.SocketTimeoutException("sent ping but didn't_renamed receive pong within " + this.pingIntervalMillis + "ms (after " + (i_renamed - 1) + " successful ping/pongs)"), null);
                return;
            }
            try {
                webSocketWriter.writePing(okio.ByteString.EMPTY);
            } catch (java.io.IOException e_renamed) {
                failWebSocket(e_renamed, null);
            }
        }
    }

    public void failWebSocket(java.lang.Exception exc, @javax.annotation.Nullable okhttp3.Response response) throws java.io.IOException {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            okhttp3.internal.ws.RealWebSocket.Streams streams = this.streams;
            this.streams = null;
            if (this.cancelFuture != null) {
                this.cancelFuture.cancel(false);
            }
            if (this.executor != null) {
                this.executor.shutdown();
            }
            try {
                this.listener.onFailure(this, exc, response);
            } finally {
                okhttp3.internal.Util.closeQuietly(streams);
            }
        }
    }

    static final class Message {
        final okio.ByteString data;
        final int formatOpcode;

        Message(int i_renamed, okio.ByteString byteString) {
            this.formatOpcode = i_renamed;
            this.data = byteString;
        }
    }

    static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final okio.ByteString reason;

        Close(int i_renamed, okio.ByteString byteString, long j_renamed) {
            this.code = i_renamed;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j_renamed;
        }
    }

    public static abstract class Streams implements java.io.Closeable {
        public final boolean client;
        public final okio.BufferedSink sink;
        public final okio.BufferedSource source;

        public Streams(boolean z_renamed, okio.BufferedSource bufferedSource, okio.BufferedSink bufferedSink) {
            this.client = z_renamed;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }
    }

    final class CancelRunnable implements java.lang.Runnable {
        CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            okhttp3.internal.ws.RealWebSocket.this.cancel();
        }
    }
}
