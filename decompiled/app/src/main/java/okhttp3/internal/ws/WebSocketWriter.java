package okhttp3.internal.ws;

/* loaded from: classes2.dex */
final class WebSocketWriter {
    boolean activeWriter;
    final okio.Buffer buffer = new okio.Buffer();
    final okhttp3.internal.ws.WebSocketWriter.FrameSink frameSink = new okhttp3.internal.ws.WebSocketWriter.FrameSink();
    final boolean isClient;
    private final okio.Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    final java.util.Random random;
    final okio.BufferedSink sink;
    final okio.Buffer sinkBuffer;
    boolean writerClosed;

    WebSocketWriter(boolean z_renamed, okio.BufferedSink bufferedSink, java.util.Random random) {
        if (bufferedSink == null) {
            throw new java.lang.NullPointerException("sink == null");
        }
        if (random == null) {
            throw new java.lang.NullPointerException("random == null");
        }
        this.isClient = z_renamed;
        this.sink = bufferedSink;
        this.sinkBuffer = bufferedSink.buffer();
        this.random = random;
        this.maskKey = z_renamed ? new byte[4] : null;
        this.maskCursor = z_renamed ? new okio.Buffer.UnsafeCursor() : null;
    }

    void writePing(okio.ByteString byteString) throws java.io.IOException {
        writeControlFrame(9, byteString);
    }

    void writePong(okio.ByteString byteString) throws java.io.IOException {
        writeControlFrame(10, byteString);
    }

    void writeClose(int i_renamed, okio.ByteString byteString) throws java.io.IOException {
        okio.ByteString byteString2 = okio.ByteString.EMPTY;
        if (i_renamed != 0 || byteString != null) {
            if (i_renamed != 0) {
                okhttp3.internal.ws.WebSocketProtocol.validateCloseCode(i_renamed);
            }
            okio.Buffer buffer = new okio.Buffer();
            buffer.writeShort(i_renamed);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    private void writeControlFrame(int i_renamed, okio.ByteString byteString) throws java.io.IOException {
        if (this.writerClosed) {
            throw new java.io.IOException("closed");
        }
        int size = byteString.size();
        if (size > 125) {
            throw new java.lang.IllegalArgumentException("Payload size must be_renamed less than or equal to 125");
        }
        this.sinkBuffer.writeByte(i_renamed | 128);
        if (this.isClient) {
            this.sinkBuffer.writeByte(size | 128);
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.write(this.maskKey);
            if (size > 0) {
                long size2 = this.sinkBuffer.size();
                this.sinkBuffer.write(byteString);
                this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(size2);
                okhttp3.internal.ws.WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.writeByte(size);
            this.sinkBuffer.write(byteString);
        }
        this.sink.flush();
    }

    okio.Sink newMessageSink(int i_renamed, long j_renamed) {
        if (this.activeWriter) {
            throw new java.lang.IllegalStateException("Another message writer is_renamed active. Did you call close()?");
        }
        this.activeWriter = true;
        okhttp3.internal.ws.WebSocketWriter.FrameSink frameSink = this.frameSink;
        frameSink.formatOpcode = i_renamed;
        frameSink.contentLength = j_renamed;
        frameSink.isFirstFrame = true;
        frameSink.closed = false;
        return frameSink;
    }

    void writeMessageFrame(int i_renamed, long j_renamed, boolean z_renamed, boolean z2) throws java.io.IOException {
        if (this.writerClosed) {
            throw new java.io.IOException("closed");
        }
        if (!z_renamed) {
            i_renamed = 0;
        }
        if (z2) {
            i_renamed |= 128;
        }
        this.sinkBuffer.writeByte(i_renamed);
        int i2 = this.isClient ? 128 : 0;
        if (j_renamed <= 125) {
            this.sinkBuffer.writeByte(((int) j_renamed) | i2);
        } else if (j_renamed <= 65535) {
            this.sinkBuffer.writeByte(i2 | 126);
            this.sinkBuffer.writeShort((int) j_renamed);
        } else {
            this.sinkBuffer.writeByte(i2 | 127);
            this.sinkBuffer.writeLong(j_renamed);
        }
        if (this.isClient) {
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.write(this.maskKey);
            if (j_renamed > 0) {
                long size = this.sinkBuffer.size();
                this.sinkBuffer.write(this.buffer, j_renamed);
                this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(size);
                okhttp3.internal.ws.WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.write(this.buffer, j_renamed);
        }
        this.sink.emit();
    }

    final class FrameSink implements okio.Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        @Override // okio.Sink
        public void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            if (this.closed) {
                throw new java.io.IOException("closed");
            }
            okhttp3.internal.ws.WebSocketWriter.this.buffer.write(buffer, j_renamed);
            boolean z_renamed = this.isFirstFrame && this.contentLength != -1 && okhttp3.internal.ws.WebSocketWriter.this.buffer.size() > this.contentLength - 8192;
            long jCompleteSegmentByteCount = okhttp3.internal.ws.WebSocketWriter.this.buffer.completeSegmentByteCount();
            if (jCompleteSegmentByteCount <= 0 || z_renamed) {
                return;
            }
            okhttp3.internal.ws.WebSocketWriter.this.writeMessageFrame(this.formatOpcode, jCompleteSegmentByteCount, this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
            if (this.closed) {
                throw new java.io.IOException("closed");
            }
            okhttp3.internal.ws.WebSocketWriter webSocketWriter = okhttp3.internal.ws.WebSocketWriter.this;
            webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.size(), this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        @Override // okio.Sink
        public okio.Timeout timeout() {
            return okhttp3.internal.ws.WebSocketWriter.this.sink.timeout();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.closed) {
                throw new java.io.IOException("closed");
            }
            okhttp3.internal.ws.WebSocketWriter webSocketWriter = okhttp3.internal.ws.WebSocketWriter.this;
            webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.size(), this.isFirstFrame, true);
            this.closed = true;
            okhttp3.internal.ws.WebSocketWriter.this.activeWriter = false;
        }
    }
}
