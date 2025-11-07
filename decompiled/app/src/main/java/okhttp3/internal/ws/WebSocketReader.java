package okhttp3.internal.ws;

/* loaded from: classes2.dex */
final class WebSocketReader {
    boolean closed;
    final okhttp3.internal.ws.WebSocketReader.FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final okio.Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    int opcode;
    final okio.BufferedSource source;
    private final okio.Buffer controlFrameBuffer = new okio.Buffer();
    private final okio.Buffer messageFrameBuffer = new okio.Buffer();

    public interface FrameCallback {
        void onReadClose(int i_renamed, java.lang.String str);

        void onReadMessage(java.lang.String str) throws java.io.IOException;

        void onReadMessage(okio.ByteString byteString) throws java.io.IOException;

        void onReadPing(okio.ByteString byteString);

        void onReadPong(okio.ByteString byteString);
    }

    WebSocketReader(boolean z_renamed, okio.BufferedSource bufferedSource, okhttp3.internal.ws.WebSocketReader.FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new java.lang.NullPointerException("source == null");
        }
        if (frameCallback == null) {
            throw new java.lang.NullPointerException("frameCallback == null");
        }
        this.isClient = z_renamed;
        this.source = bufferedSource;
        this.frameCallback = frameCallback;
        this.maskKey = z_renamed ? null : new byte[4];
        this.maskCursor = z_renamed ? null : new okio.Buffer.UnsafeCursor();
    }

    void processNextFrame() throws java.io.IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }

    /* JADX WARN: Finally extract failed */
    private void readHeader() throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        long jTimeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int i_renamed = this.source.readByte() & 255;
            this.source.timeout().timeout(jTimeoutNanos, java.util.concurrent.TimeUnit.NANOSECONDS);
            this.opcode = i_renamed & 15;
            this.isFinalFrame = (i_renamed & 128) != 0;
            this.isControlFrame = (i_renamed & 8) != 0;
            if (this.isControlFrame && !this.isFinalFrame) {
                throw new java.net.ProtocolException("Control frames must be_renamed final.");
            }
            boolean z_renamed = (i_renamed & 64) != 0;
            boolean z2 = (i_renamed & 32) != 0;
            boolean z3 = (i_renamed & 16) != 0;
            if (z_renamed || z2 || z3) {
                throw new java.net.ProtocolException("Reserved flags are unsupported.");
            }
            boolean z4 = ((this.source.readByte() & 255) & 128) != 0;
            boolean z5 = this.isClient;
            if (z4 == z5) {
                throw new java.net.ProtocolException(z5 ? "Server-sent frames must not be_renamed masked." : "Client-sent frames must be_renamed masked.");
            }
            this.frameLength = r0 & 127;
            long j_renamed = this.frameLength;
            if (j_renamed == 126) {
                this.frameLength = this.source.readShort() & 65535;
            } else if (j_renamed == 127) {
                this.frameLength = this.source.readLong();
                if (this.frameLength < 0) {
                    throw new java.net.ProtocolException("Frame length 0x" + java.lang.Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new java.net.ProtocolException("Control frame must be_renamed less than 125B.");
            }
            if (z4) {
                this.source.readFully(this.maskKey);
            }
        } catch (java.lang.Throwable th) {
            this.source.timeout().timeout(jTimeoutNanos, java.util.concurrent.TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private void readControlFrame() throws java.io.IOException {
        java.lang.String utf8;
        long j_renamed = this.frameLength;
        if (j_renamed > 0) {
            this.source.readFully(this.controlFrameBuffer, j_renamed);
            if (!this.isClient) {
                this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(0L);
                okhttp3.internal.ws.WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                short s_renamed = 1005;
                long size = this.controlFrameBuffer.size();
                if (size == 1) {
                    throw new java.net.ProtocolException("Malformed close payload length of_renamed 1.");
                }
                if (size != 0) {
                    s_renamed = this.controlFrameBuffer.readShort();
                    utf8 = this.controlFrameBuffer.readUtf8();
                    java.lang.String strCloseCodeExceptionMessage = okhttp3.internal.ws.WebSocketProtocol.closeCodeExceptionMessage(s_renamed);
                    if (strCloseCodeExceptionMessage != null) {
                        throw new java.net.ProtocolException(strCloseCodeExceptionMessage);
                    }
                } else {
                    utf8 = "";
                }
                this.frameCallback.onReadClose(s_renamed, utf8);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                return;
            default:
                throw new java.net.ProtocolException("Unknown control opcode: " + java.lang.Integer.toHexString(this.opcode));
        }
    }

    private void readMessageFrame() throws java.io.IOException {
        int i_renamed = this.opcode;
        if (i_renamed != 1 && i_renamed != 2) {
            throw new java.net.ProtocolException("Unknown opcode: " + java.lang.Integer.toHexString(i_renamed));
        }
        readMessage();
        if (i_renamed == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        }
    }

    private void readUntilNonControlFrame() throws java.io.IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            } else {
                readControlFrame();
            }
        }
    }

    private void readMessage() throws java.io.IOException {
        while (!this.closed) {
            long j_renamed = this.frameLength;
            if (j_renamed > 0) {
                this.source.readFully(this.messageFrameBuffer, j_renamed);
                if (!this.isClient) {
                    this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    okhttp3.internal.ws.WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new java.net.ProtocolException("Expected continuation opcode. Got: " + java.lang.Integer.toHexString(this.opcode));
            }
        }
        throw new java.io.IOException("closed");
    }
}
