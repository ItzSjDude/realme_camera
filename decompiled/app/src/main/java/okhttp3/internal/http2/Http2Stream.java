package okhttp3.internal.http2;

/* loaded from: classes2.dex */
public final class Http2Stream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    final okhttp3.internal.http2.Http2Connection connection;
    private boolean hasResponseHeaders;
    private okhttp3.internal.http2.Header.Listener headersListener;
    final int id_renamed;
    final okhttp3.internal.http2.Http2Stream.FramingSink sink;
    private final okhttp3.internal.http2.Http2Stream.FramingSource source;
    long unacknowledgedBytesRead = 0;
    private final java.util.Deque<okhttp3.Headers> headersQueue = new java.util.ArrayDeque();
    final okhttp3.internal.http2.Http2Stream.StreamTimeout readTimeout = new okhttp3.internal.http2.Http2Stream.StreamTimeout();
    final okhttp3.internal.http2.Http2Stream.StreamTimeout writeTimeout = new okhttp3.internal.http2.Http2Stream.StreamTimeout();
    okhttp3.internal.http2.ErrorCode errorCode = null;

    Http2Stream(int i_renamed, okhttp3.internal.http2.Http2Connection http2Connection, boolean z_renamed, boolean z2, @javax.annotation.Nullable okhttp3.Headers headers) {
        if (http2Connection == null) {
            throw new java.lang.NullPointerException("connection == null");
        }
        this.id_renamed = i_renamed;
        this.connection = http2Connection;
        this.bytesLeftInWriteWindow = http2Connection.peerSettings.getInitialWindowSize();
        this.source = new okhttp3.internal.http2.Http2Stream.FramingSource(http2Connection.okHttpSettings.getInitialWindowSize());
        this.sink = new okhttp3.internal.http2.Http2Stream.FramingSink();
        this.source.finished = z2;
        this.sink.finished = z_renamed;
        if (headers != null) {
            this.headersQueue.add(headers);
        }
        if (isLocallyInitiated() && headers != null) {
            throw new java.lang.IllegalStateException("locally-initiated streams shouldn't_renamed have headers yet");
        }
        if (!isLocallyInitiated() && headers == null) {
            throw new java.lang.IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    public int getId() {
        return this.id_renamed;
    }

    public synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.finished || this.source.closed) && (this.sink.finished || this.sink.closed)) {
            if (this.hasResponseHeaders) {
                return false;
            }
        }
        return true;
    }

    public boolean isLocallyInitiated() {
        return this.connection.client == ((this.id_renamed & 1) == 1);
    }

    public okhttp3.internal.http2.Http2Connection getConnection() {
        return this.connection;
    }

    public synchronized okhttp3.Headers takeHeaders() throws java.io.IOException {
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                waitForIo();
            } catch (java.lang.Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (!this.headersQueue.isEmpty()) {
        } else {
            throw new okhttp3.internal.http2.StreamResetException(this.errorCode);
        }
        return this.headersQueue.removeFirst();
    }

    public synchronized okhttp3.internal.http2.ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public void writeHeaders(java.util.List<okhttp3.internal.http2.Header> list, boolean z_renamed) throws java.io.IOException {
        boolean z2;
        boolean z3;
        if (list == null) {
            throw new java.lang.NullPointerException("headers == null");
        }
        synchronized (this) {
            this.hasResponseHeaders = true;
            if (z_renamed) {
                z2 = false;
            } else {
                this.sink.finished = true;
                z2 = true;
            }
            z3 = z2;
        }
        if (!z2) {
            synchronized (this.connection) {
                z2 = this.connection.bytesLeftInWriteWindow == 0;
            }
        }
        this.connection.writeSynReply(this.id_renamed, z3, list);
        if (z2) {
            this.connection.flush();
        }
    }

    public okio.Timeout readTimeout() {
        return this.readTimeout;
    }

    public okio.Timeout writeTimeout() {
        return this.writeTimeout;
    }

    public okio.Source getSource() {
        return this.source;
    }

    public okio.Sink getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                throw new java.lang.IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    public void close(okhttp3.internal.http2.ErrorCode errorCode) throws java.io.IOException {
        if (closeInternal(errorCode)) {
            this.connection.writeSynReset(this.id_renamed, errorCode);
        }
    }

    public void closeLater(okhttp3.internal.http2.ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.writeSynResetLater(this.id_renamed, errorCode);
        }
    }

    private boolean closeInternal(okhttp3.internal.http2.ErrorCode errorCode) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode;
            notifyAll();
            this.connection.removeStream(this.id_renamed);
            return true;
        }
    }

    void receiveHeaders(java.util.List<okhttp3.internal.http2.Header> list) {
        boolean zIsOpen;
        synchronized (this) {
            this.hasResponseHeaders = true;
            this.headersQueue.add(okhttp3.internal.Util.toHeaders(list));
            zIsOpen = isOpen();
            notifyAll();
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream(this.id_renamed);
    }

    void receiveData(okio.BufferedSource bufferedSource, int i_renamed) throws java.io.IOException {
        this.source.receive(bufferedSource, i_renamed);
    }

    void receiveFin() {
        boolean zIsOpen;
        synchronized (this) {
            this.source.finished = true;
            zIsOpen = isOpen();
            notifyAll();
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream(this.id_renamed);
    }

    synchronized void receiveRstStream(okhttp3.internal.http2.ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public synchronized void setHeadersListener(okhttp3.internal.http2.Header.Listener listener) {
        this.headersListener = listener;
        if (!this.headersQueue.isEmpty() && listener != null) {
            notifyAll();
        }
    }

    private final class FramingSource implements okio.Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean closed;
        boolean finished;
        private final long maxByteCount;
        private final okio.Buffer receiveBuffer = new okio.Buffer();
        private final okio.Buffer readBuffer = new okio.Buffer();

        FramingSource(long j_renamed) {
            this.maxByteCount = j_renamed;
        }

        @Override // okio.Source
        public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            okhttp3.internal.http2.ErrorCode errorCode;
            long j2;
            okhttp3.Headers headers;
            okhttp3.internal.http2.Header.Listener listener;
            if (j_renamed < 0) {
                throw new java.lang.IllegalArgumentException("byteCount < 0: " + j_renamed);
            }
            while (true) {
                synchronized (okhttp3.internal.http2.Http2Stream.this) {
                    okhttp3.internal.http2.Http2Stream.this.readTimeout.enter();
                    try {
                        errorCode = okhttp3.internal.http2.Http2Stream.this.errorCode != null ? okhttp3.internal.http2.Http2Stream.this.errorCode : null;
                        if (!this.closed) {
                            if (okhttp3.internal.http2.Http2Stream.this.headersQueue.isEmpty() || okhttp3.internal.http2.Http2Stream.this.headersListener == null) {
                                if (this.readBuffer.size() > 0) {
                                    j2 = this.readBuffer.read(buffer, java.lang.Math.min(j_renamed, this.readBuffer.size()));
                                    okhttp3.internal.http2.Http2Stream.this.unacknowledgedBytesRead += j2;
                                    if (errorCode == null && okhttp3.internal.http2.Http2Stream.this.unacknowledgedBytesRead >= okhttp3.internal.http2.Http2Stream.this.connection.okHttpSettings.getInitialWindowSize() / 2) {
                                        okhttp3.internal.http2.Http2Stream.this.connection.writeWindowUpdateLater(okhttp3.internal.http2.Http2Stream.this.id_renamed, okhttp3.internal.http2.Http2Stream.this.unacknowledgedBytesRead);
                                        okhttp3.internal.http2.Http2Stream.this.unacknowledgedBytesRead = 0L;
                                    }
                                } else if (this.finished || errorCode != null) {
                                    j2 = -1;
                                } else {
                                    okhttp3.internal.http2.Http2Stream.this.waitForIo();
                                    okhttp3.internal.http2.Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                                }
                                headers = null;
                                listener = null;
                            } else {
                                headers = (okhttp3.Headers) okhttp3.internal.http2.Http2Stream.this.headersQueue.removeFirst();
                                listener = okhttp3.internal.http2.Http2Stream.this.headersListener;
                                j2 = -1;
                            }
                            if (headers == null || listener == null) {
                                break;
                            }
                            listener.onHeaders(headers);
                        } else {
                            throw new java.io.IOException("stream closed");
                        }
                    } finally {
                    }
                }
            }
            if (j2 != -1) {
                updateConnectionFlowControl(j2);
                return j2;
            }
            if (errorCode == null) {
                return -1L;
            }
            throw new okhttp3.internal.http2.StreamResetException(errorCode);
        }

        private void updateConnectionFlowControl(long j_renamed) {
            okhttp3.internal.http2.Http2Stream.this.connection.updateConnectionFlowControl(j_renamed);
        }

        void receive(okio.BufferedSource bufferedSource, long j_renamed) throws java.io.IOException {
            boolean z_renamed;
            boolean z2;
            boolean z3;
            while (j_renamed > 0) {
                synchronized (okhttp3.internal.http2.Http2Stream.this) {
                    z_renamed = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.size() + j_renamed > this.maxByteCount;
                }
                if (z3) {
                    bufferedSource.skip(j_renamed);
                    okhttp3.internal.http2.Http2Stream.this.closeLater(okhttp3.internal.http2.ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z_renamed) {
                    bufferedSource.skip(j_renamed);
                    return;
                }
                long j2 = bufferedSource.read(this.receiveBuffer, j_renamed);
                if (j2 == -1) {
                    throw new java.io.EOFException();
                }
                j_renamed -= j2;
                synchronized (okhttp3.internal.http2.Http2Stream.this) {
                    if (this.readBuffer.size() != 0) {
                        z2 = false;
                    }
                    this.readBuffer.writeAll(this.receiveBuffer);
                    if (z2) {
                        okhttp3.internal.http2.Http2Stream.this.notifyAll();
                    }
                }
            }
        }

        @Override // okio.Source
        public okio.Timeout timeout() {
            return okhttp3.internal.http2.Http2Stream.this.readTimeout;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            long size;
            java.util.ArrayList arrayList;
            okhttp3.internal.http2.Header.Listener listener;
            synchronized (okhttp3.internal.http2.Http2Stream.this) {
                this.closed = true;
                size = this.readBuffer.size();
                this.readBuffer.clear();
                arrayList = null;
                if (okhttp3.internal.http2.Http2Stream.this.headersQueue.isEmpty() || okhttp3.internal.http2.Http2Stream.this.headersListener == null) {
                    listener = null;
                } else {
                    arrayList = new java.util.ArrayList(okhttp3.internal.http2.Http2Stream.this.headersQueue);
                    okhttp3.internal.http2.Http2Stream.this.headersQueue.clear();
                    listener = okhttp3.internal.http2.Http2Stream.this.headersListener;
                }
                okhttp3.internal.http2.Http2Stream.this.notifyAll();
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            okhttp3.internal.http2.Http2Stream.this.cancelStreamIfNecessary();
            if (listener != null) {
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    listener.onHeaders((okhttp3.Headers) it.next());
                }
            }
        }
    }

    void cancelStreamIfNecessary() throws java.io.IOException {
        boolean z_renamed;
        boolean zIsOpen;
        synchronized (this) {
            z_renamed = !this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed);
            zIsOpen = isOpen();
        }
        if (z_renamed) {
            close(okhttp3.internal.http2.ErrorCode.CANCEL);
        } else {
            if (zIsOpen) {
                return;
            }
            this.connection.removeStream(this.id_renamed);
        }
    }

    final class FramingSink implements okio.Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        boolean closed;
        boolean finished;
        private final okio.Buffer sendBuffer = new okio.Buffer();

        FramingSink() {
        }

        @Override // okio.Sink
        public void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            this.sendBuffer.write(buffer, j_renamed);
            while (this.sendBuffer.size() >= 16384) {
                emitFrame(false);
            }
        }

        private void emitFrame(boolean z_renamed) throws java.io.IOException {
            long jMin;
            synchronized (okhttp3.internal.http2.Http2Stream.this) {
                okhttp3.internal.http2.Http2Stream.this.writeTimeout.enter();
                while (okhttp3.internal.http2.Http2Stream.this.bytesLeftInWriteWindow <= 0 && !this.finished && !this.closed && okhttp3.internal.http2.Http2Stream.this.errorCode == null) {
                    try {
                        okhttp3.internal.http2.Http2Stream.this.waitForIo();
                    } finally {
                    }
                }
                okhttp3.internal.http2.Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                okhttp3.internal.http2.Http2Stream.this.checkOutNotClosed();
                jMin = java.lang.Math.min(okhttp3.internal.http2.Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                okhttp3.internal.http2.Http2Stream.this.bytesLeftInWriteWindow -= jMin;
            }
            okhttp3.internal.http2.Http2Stream.this.writeTimeout.enter();
            try {
                okhttp3.internal.http2.Http2Stream.this.connection.writeData(okhttp3.internal.http2.Http2Stream.this.id_renamed, z_renamed && jMin == this.sendBuffer.size(), this.sendBuffer, jMin);
            } finally {
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
            synchronized (okhttp3.internal.http2.Http2Stream.this) {
                okhttp3.internal.http2.Http2Stream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.size() > 0) {
                emitFrame(false);
                okhttp3.internal.http2.Http2Stream.this.connection.flush();
            }
        }

        @Override // okio.Sink
        public okio.Timeout timeout() {
            return okhttp3.internal.http2.Http2Stream.this.writeTimeout;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            synchronized (okhttp3.internal.http2.Http2Stream.this) {
                if (this.closed) {
                    return;
                }
                if (!okhttp3.internal.http2.Http2Stream.this.sink.finished) {
                    if (this.sendBuffer.size() > 0) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(true);
                        }
                    } else {
                        okhttp3.internal.http2.Http2Stream.this.connection.writeData(okhttp3.internal.http2.Http2Stream.this.id_renamed, true, null, 0L);
                    }
                }
                synchronized (okhttp3.internal.http2.Http2Stream.this) {
                    this.closed = true;
                }
                okhttp3.internal.http2.Http2Stream.this.connection.flush();
                okhttp3.internal.http2.Http2Stream.this.cancelStreamIfNecessary();
            }
        }
    }

    void addBytesToWriteWindow(long j_renamed) {
        this.bytesLeftInWriteWindow += j_renamed;
        if (j_renamed > 0) {
            notifyAll();
        }
    }

    void checkOutNotClosed() throws java.io.IOException {
        if (this.sink.closed) {
            throw new java.io.IOException("stream closed");
        }
        if (this.sink.finished) {
            throw new java.io.IOException("stream finished");
        }
        okhttp3.internal.http2.ErrorCode errorCode = this.errorCode;
        if (errorCode != null) {
            throw new okhttp3.internal.http2.StreamResetException(errorCode);
        }
    }

    void waitForIo() throws java.lang.InterruptedException, java.io.InterruptedIOException {
        try {
            wait();
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
            throw new java.io.InterruptedIOException();
        }
    }

    class StreamTimeout extends okio.AsyncTimeout {
        StreamTimeout() {
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            okhttp3.internal.http2.Http2Stream.this.closeLater(okhttp3.internal.http2.ErrorCode.CANCEL);
        }

        @Override // okio.AsyncTimeout
        protected java.io.IOException newTimeoutException(java.io.IOException iOException) {
            java.net.SocketTimeoutException socketTimeoutException = new java.net.SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void exitAndThrowIfTimedOut() throws java.io.IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }
    }
}
