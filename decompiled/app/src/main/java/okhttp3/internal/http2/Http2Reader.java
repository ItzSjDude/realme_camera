package okhttp3.internal.http2;

/* loaded from: classes2.dex */
final class Http2Reader implements java.io.Closeable {
    static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(okhttp3.internal.http2.Http2.class.getName());
    private final boolean client;
    private final okhttp3.internal.http2.Http2Reader.ContinuationSource continuation;
    final okhttp3.internal.http2.Hpack.Reader hpackReader;
    private final okio.BufferedSource source;

    interface Handler {
        void ackSettings();

        void alternateService(int i_renamed, java.lang.String str, okio.ByteString byteString, java.lang.String str2, int i2, long j_renamed);

        void data(boolean z_renamed, int i_renamed, okio.BufferedSource bufferedSource, int i2) throws java.io.IOException;

        void goAway(int i_renamed, okhttp3.internal.http2.ErrorCode errorCode, okio.ByteString byteString);

        void headers(boolean z_renamed, int i_renamed, int i2, java.util.List<okhttp3.internal.http2.Header> list);

        void ping(boolean z_renamed, int i_renamed, int i2);

        void priority(int i_renamed, int i2, int i3, boolean z_renamed);

        void pushPromise(int i_renamed, int i2, java.util.List<okhttp3.internal.http2.Header> list) throws java.io.IOException;

        void rstStream(int i_renamed, okhttp3.internal.http2.ErrorCode errorCode);

        void settings(boolean z_renamed, okhttp3.internal.http2.Settings settings);

        void windowUpdate(int i_renamed, long j_renamed);
    }

    Http2Reader(okio.BufferedSource bufferedSource, boolean z_renamed) {
        this.source = bufferedSource;
        this.client = z_renamed;
        this.continuation = new okhttp3.internal.http2.Http2Reader.ContinuationSource(this.source);
        this.hpackReader = new okhttp3.internal.http2.Hpack.Reader(4096, this.continuation);
    }

    public void readConnectionPreface(okhttp3.internal.http2.Http2Reader.Handler handler) throws java.io.IOException {
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw okhttp3.internal.http2.Http2.ioException("Required SETTINGS preface not received", new java.lang.Object[0]);
            }
            return;
        }
        okio.ByteString byteString = this.source.readByteString(okhttp3.internal.http2.Http2.CONNECTION_PREFACE.size());
        if (logger.isLoggable(java.util.logging.Level.FINE)) {
            logger.fine(okhttp3.internal.Util.format("<< CONNECTION %s_renamed", byteString.hex()));
        }
        if (!okhttp3.internal.http2.Http2.CONNECTION_PREFACE.equals(byteString)) {
            throw okhttp3.internal.http2.Http2.ioException("Expected a_renamed connection header but was %s_renamed", byteString.utf8());
        }
    }

    public boolean nextFrame(boolean z_renamed, okhttp3.internal.http2.Http2Reader.Handler handler) throws java.io.IOException {
        try {
            this.source.require(9L);
            int medium = readMedium(this.source);
            if (medium < 0 || medium > 16384) {
                throw okhttp3.internal.http2.Http2.ioException("FRAME_SIZE_ERROR: %s_renamed", java.lang.Integer.valueOf(medium));
            }
            byte b2 = (byte) (this.source.readByte() & 255);
            if (z_renamed && b2 != 4) {
                throw okhttp3.internal.http2.Http2.ioException("Expected a_renamed SETTINGS frame but was %s_renamed", java.lang.Byte.valueOf(b2));
            }
            byte b3 = (byte) (this.source.readByte() & 255);
            int i_renamed = this.source.readInt() & Integer.MAX_VALUE;
            if (logger.isLoggable(java.util.logging.Level.FINE)) {
                logger.fine(okhttp3.internal.http2.Http2.frameLog(true, i_renamed, medium, b2, b3));
            }
            switch (b2) {
                case 0:
                    readData(handler, medium, b3, i_renamed);
                    return true;
                case 1:
                    readHeaders(handler, medium, b3, i_renamed);
                    return true;
                case 2:
                    readPriority(handler, medium, b3, i_renamed);
                    return true;
                case 3:
                    readRstStream(handler, medium, b3, i_renamed);
                    return true;
                case 4:
                    readSettings(handler, medium, b3, i_renamed);
                    return true;
                case 5:
                    readPushPromise(handler, medium, b3, i_renamed);
                    return true;
                case 6:
                    readPing(handler, medium, b3, i_renamed);
                    return true;
                case 7:
                    readGoAway(handler, medium, b3, i_renamed);
                    return true;
                case 8:
                    readWindowUpdate(handler, medium, b3, i_renamed);
                    return true;
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    private void readHeaders(okhttp3.internal.http2.Http2Reader.Handler handler, int i_renamed, byte b2, int i2) throws java.io.IOException {
        if (i2 == 0) {
            throw okhttp3.internal.http2.Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new java.lang.Object[0]);
        }
        boolean z_renamed = (b2 & 1) != 0;
        short s_renamed = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        if ((b2 & 32) != 0) {
            readPriority(handler, i2);
            i_renamed -= 5;
        }
        handler.headers(z_renamed, i2, -1, readHeaderBlock(lengthWithoutPadding(i_renamed, b2, s_renamed), s_renamed, b2, i2));
    }

    private java.util.List<okhttp3.internal.http2.Header> readHeaderBlock(int i_renamed, short s_renamed, byte b2, int i2) throws java.io.IOException {
        okhttp3.internal.http2.Http2Reader.ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i_renamed;
        continuationSource.length = i_renamed;
        continuationSource.padding = s_renamed;
        continuationSource.flags = b2;
        continuationSource.streamId = i2;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readData(okhttp3.internal.http2.Http2Reader.Handler handler, int i_renamed, byte b2, int i2) throws java.io.IOException {
        if (i2 == 0) {
            throw okhttp3.internal.http2.Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new java.lang.Object[0]);
        }
        boolean z_renamed = (b2 & 1) != 0;
        if ((b2 & 32) != 0) {
            throw okhttp3.internal.http2.Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new java.lang.Object[0]);
        }
        short s_renamed = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        handler.data(z_renamed, i2, this.source, lengthWithoutPadding(i_renamed, b2, s_renamed));
        this.source.skip(s_renamed);
    }

    private void readPriority(okhttp3.internal.http2.Http2Reader.Handler handler, int i_renamed, byte b2, int i2) throws java.io.IOException {
        if (i_renamed != 5) {
            throw okhttp3.internal.http2.Http2.ioException("TYPE_PRIORITY length: %d_renamed != 5", java.lang.Integer.valueOf(i_renamed));
        }
        if (i2 == 0) {
            throw okhttp3.internal.http2.Http2.ioException("TYPE_PRIORITY streamId == 0", new java.lang.Object[0]);
        }
        readPriority(handler, i2);
    }

    private void readPriority(okhttp3.internal.http2.Http2Reader.Handler handler, int i_renamed) throws java.io.IOException {
        int i2 = this.source.readInt();
        handler.priority(i_renamed, i2 & Integer.MAX_VALUE, (this.source.readByte() & 255) + 1, (Integer.MIN_VALUE & i2) != 0);
    }

    private void readRstStream(okhttp3.internal.http2.Http2Reader.Handler handler, int i_renamed, byte b2, int i2) throws java.io.IOException {
        if (i_renamed != 4) {
            throw okhttp3.internal.http2.Http2.ioException("TYPE_RST_STREAM length: %d_renamed != 4", java.lang.Integer.valueOf(i_renamed));
        }
        if (i2 == 0) {
            throw okhttp3.internal.http2.Http2.ioException("TYPE_RST_STREAM streamId == 0", new java.lang.Object[0]);
        }
        int i3 = this.source.readInt();
        okhttp3.internal.http2.ErrorCode errorCodeFromHttp2 = okhttp3.internal.http2.ErrorCode.fromHttp2(i3);
        if (errorCodeFromHttp2 == null) {
            throw okhttp3.internal.http2.Http2.ioException("TYPE_RST_STREAM unexpected error code: %d_renamed", java.lang.Integer.valueOf(i3));
        }
        handler.rstStream(i2, errorCodeFromHttp2);
    }

    private void readSettings(okhttp3.internal.http2.Http2Reader.Handler handler, int i_renamed, byte b2, int i2) throws java.io.IOException {
        if (i2 != 0) {
            throw okhttp3.internal.http2.Http2.ioException("TYPE_SETTINGS streamId != 0", new java.lang.Object[0]);
        }
        if ((b2 & 1) != 0) {
            if (i_renamed != 0) {
                throw okhttp3.internal.http2.Http2.ioException("FRAME_SIZE_ERROR ack frame should be_renamed empty!", new java.lang.Object[0]);
            }
            handler.ackSettings();
            return;
        }
        if (i_renamed % 6 != 0) {
            throw okhttp3.internal.http2.Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s_renamed", java.lang.Integer.valueOf(i_renamed));
        }
        okhttp3.internal.http2.Settings settings = new okhttp3.internal.http2.Settings();
        for (int i3 = 0; i3 < i_renamed; i3 += 6) {
            int i4 = this.source.readShort() & com.oplus.exif.OplusExifInterface.ColorSpace.UNCALIBRATED;
            int i5 = this.source.readInt();
            switch (i4) {
                case 2:
                    if (i5 != 0 && i5 != 1) {
                        throw okhttp3.internal.http2.Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new java.lang.Object[0]);
                    }
                    break;
                case 3:
                    i4 = 4;
                    break;
                case 4:
                    i4 = 7;
                    if (i5 < 0) {
                        throw okhttp3.internal.http2.Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new java.lang.Object[0]);
                    }
                    break;
                case 5:
                    if (i5 < 16384 || i5 > 16777215) {
                        throw okhttp3.internal.http2.Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s_renamed", java.lang.Integer.valueOf(i5));
                    }
                    break;
                    break;
            }
            settings.set(i4, i5);
        }
        handler.settings(false, settings);
    }

    private void readPushPromise(okhttp3.internal.http2.Http2Reader.Handler handler, int i_renamed, byte b2, int i2) throws java.io.IOException {
        if (i2 == 0) {
            throw okhttp3.internal.http2.Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new java.lang.Object[0]);
        }
        short s_renamed = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        handler.pushPromise(i2, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(i_renamed - 4, b2, s_renamed), s_renamed, b2, i2));
    }

    private void readPing(okhttp3.internal.http2.Http2Reader.Handler handler, int i_renamed, byte b2, int i2) throws java.io.IOException {
        if (i_renamed != 8) {
            throw okhttp3.internal.http2.Http2.ioException("TYPE_PING length != 8: %s_renamed", java.lang.Integer.valueOf(i_renamed));
        }
        if (i2 != 0) {
            throw okhttp3.internal.http2.Http2.ioException("TYPE_PING streamId != 0", new java.lang.Object[0]);
        }
        handler.ping((b2 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private void readGoAway(okhttp3.internal.http2.Http2Reader.Handler handler, int i_renamed, byte b2, int i2) throws java.io.IOException {
        if (i_renamed < 8) {
            throw okhttp3.internal.http2.Http2.ioException("TYPE_GOAWAY length < 8: %s_renamed", java.lang.Integer.valueOf(i_renamed));
        }
        if (i2 != 0) {
            throw okhttp3.internal.http2.Http2.ioException("TYPE_GOAWAY streamId != 0", new java.lang.Object[0]);
        }
        int i3 = this.source.readInt();
        int i4 = this.source.readInt();
        int i5 = i_renamed - 8;
        okhttp3.internal.http2.ErrorCode errorCodeFromHttp2 = okhttp3.internal.http2.ErrorCode.fromHttp2(i4);
        if (errorCodeFromHttp2 == null) {
            throw okhttp3.internal.http2.Http2.ioException("TYPE_GOAWAY unexpected error code: %d_renamed", java.lang.Integer.valueOf(i4));
        }
        okio.ByteString byteString = okio.ByteString.EMPTY;
        if (i5 > 0) {
            byteString = this.source.readByteString(i5);
        }
        handler.goAway(i3, errorCodeFromHttp2, byteString);
    }

    private void readWindowUpdate(okhttp3.internal.http2.Http2Reader.Handler handler, int i_renamed, byte b2, int i2) throws java.io.IOException {
        if (i_renamed != 4) {
            throw okhttp3.internal.http2.Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s_renamed", java.lang.Integer.valueOf(i_renamed));
        }
        long j_renamed = this.source.readInt() & 2147483647L;
        if (j_renamed == 0) {
            throw okhttp3.internal.http2.Http2.ioException("windowSizeIncrement was 0", java.lang.Long.valueOf(j_renamed));
        }
        handler.windowUpdate(i2, j_renamed);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.source.close();
    }

    static final class ContinuationSource implements okio.Source {
        byte flags;
        int left;
        int length;
        short padding;
        private final okio.BufferedSource source;
        int streamId;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
        }

        ContinuationSource(okio.BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        @Override // okio.Source
        public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            while (true) {
                int i_renamed = this.left;
                if (i_renamed == 0) {
                    this.source.skip(this.padding);
                    this.padding = (short) 0;
                    if ((this.flags & 4) != 0) {
                        return -1L;
                    }
                    readContinuationHeader();
                } else {
                    long j2 = this.source.read(buffer, java.lang.Math.min(j_renamed, i_renamed));
                    if (j2 == -1) {
                        return -1L;
                    }
                    this.left = (int) (this.left - j2);
                    return j2;
                }
            }
        }

        @Override // okio.Source
        public okio.Timeout timeout() {
            return this.source.timeout();
        }

        private void readContinuationHeader() throws java.io.IOException {
            int i_renamed = this.streamId;
            int medium = okhttp3.internal.http2.Http2Reader.readMedium(this.source);
            this.left = medium;
            this.length = medium;
            byte b2 = (byte) (this.source.readByte() & 255);
            this.flags = (byte) (this.source.readByte() & 255);
            if (okhttp3.internal.http2.Http2Reader.logger.isLoggable(java.util.logging.Level.FINE)) {
                okhttp3.internal.http2.Http2Reader.logger.fine(okhttp3.internal.http2.Http2.frameLog(true, this.streamId, this.length, b2, this.flags));
            }
            this.streamId = this.source.readInt() & Integer.MAX_VALUE;
            if (b2 != 9) {
                throw okhttp3.internal.http2.Http2.ioException("%s_renamed != TYPE_CONTINUATION", java.lang.Byte.valueOf(b2));
            }
            if (this.streamId != i_renamed) {
                throw okhttp3.internal.http2.Http2.ioException("TYPE_CONTINUATION streamId changed", new java.lang.Object[0]);
            }
        }
    }

    static int readMedium(okio.BufferedSource bufferedSource) throws java.io.IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    static int lengthWithoutPadding(int i_renamed, byte b2, short s_renamed) throws java.io.IOException {
        if ((b2 & 8) != 0) {
            i_renamed--;
        }
        if (s_renamed <= i_renamed) {
            return (short) (i_renamed - s_renamed);
        }
        throw okhttp3.internal.http2.Http2.ioException("PROTOCOL_ERROR padding %s_renamed > remaining length %s_renamed", java.lang.Short.valueOf(s_renamed), java.lang.Integer.valueOf(i_renamed));
    }
}
