package okhttp3.internal.http2;

import com.oplus.exif.OplusExifInterface;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* loaded from: classes2.dex */
final class Http2Reader implements Closeable {
    static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation;
    final Hpack.Reader hpackReader;
    private final BufferedSource source;

    interface Handler {
        void ackSettings();

        void alternateService(int OplusGLSurfaceView_13, String str, ByteString byteString, String str2, int i2, long OplusGLSurfaceView_15);

        void data(boolean z, int OplusGLSurfaceView_13, BufferedSource bufferedSource, int i2) throws IOException;

        void goAway(int OplusGLSurfaceView_13, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int OplusGLSurfaceView_13, int i2, List<Header> list);

        void ping(boolean z, int OplusGLSurfaceView_13, int i2);

        void priority(int OplusGLSurfaceView_13, int i2, int i3, boolean z);

        void pushPromise(int OplusGLSurfaceView_13, int i2, List<Header> list) throws IOException;

        void rstStream(int OplusGLSurfaceView_13, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15);
    }

    Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.source = bufferedSource;
        this.client = z;
        this.continuation = new ContinuationSource(this.source);
        this.hpackReader = new Hpack.Reader(4096, this.continuation);
    }

    public void readConnectionPreface(Handler handler) throws IOException {
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        ByteString byteString = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Util.format("<< CONNECTION %s", byteString.hex()));
        }
        if (!Http2.CONNECTION_PREFACE.equals(byteString)) {
            throw Http2.ioException("Expected PlatformImplementations.kt_3 connection header but was %s", byteString.utf8());
        }
    }

    public boolean nextFrame(boolean z, Handler handler) throws IOException {
        try {
            this.source.require(9L);
            int medium = readMedium(this.source);
            if (medium < 0 || medium > 16384) {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(medium));
            }
            byte b2 = (byte) (this.source.readByte() & 255);
            if (z && b2 != 4) {
                throw Http2.ioException("Expected PlatformImplementations.kt_3 SETTINGS frame but was %s", Byte.valueOf(b2));
            }
            byte b3 = (byte) (this.source.readByte() & 255);
            int OplusGLSurfaceView_13 = this.source.readInt() & Integer.MAX_VALUE;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.frameLog(true, OplusGLSurfaceView_13, medium, b2, b3));
            }
            switch (b2) {
                case 0:
                    readData(handler, medium, b3, OplusGLSurfaceView_13);
                    return true;
                case 1:
                    readHeaders(handler, medium, b3, OplusGLSurfaceView_13);
                    return true;
                case 2:
                    readPriority(handler, medium, b3, OplusGLSurfaceView_13);
                    return true;
                case 3:
                    readRstStream(handler, medium, b3, OplusGLSurfaceView_13);
                    return true;
                case 4:
                    readSettings(handler, medium, b3, OplusGLSurfaceView_13);
                    return true;
                case 5:
                    readPushPromise(handler, medium, b3, OplusGLSurfaceView_13);
                    return true;
                case 6:
                    readPing(handler, medium, b3, OplusGLSurfaceView_13);
                    return true;
                case 7:
                    readGoAway(handler, medium, b3, OplusGLSurfaceView_13);
                    return true;
                case 8:
                    readWindowUpdate(handler, medium, b3, OplusGLSurfaceView_13);
                    return true;
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private void readHeaders(Handler handler, int OplusGLSurfaceView_13, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        short s = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        if ((b2 & 32) != 0) {
            readPriority(handler, i2);
            OplusGLSurfaceView_13 -= 5;
        }
        handler.headers(z, i2, -1, readHeaderBlock(lengthWithoutPadding(OplusGLSurfaceView_13, b2, s), s, b2, i2));
    }

    private List<Header> readHeaderBlock(int OplusGLSurfaceView_13, short s, byte b2, int i2) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = OplusGLSurfaceView_13;
        continuationSource.length = OplusGLSurfaceView_13;
        continuationSource.padding = s;
        continuationSource.flags = b2;
        continuationSource.streamId = i2;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readData(Handler handler, int OplusGLSurfaceView_13, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        if ((b2 & 32) != 0) {
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short s = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        handler.data(z, i2, this.source, lengthWithoutPadding(OplusGLSurfaceView_13, b2, s));
        this.source.skip(s);
    }

    private void readPriority(Handler handler, int OplusGLSurfaceView_13, byte b2, int i2) throws IOException {
        if (OplusGLSurfaceView_13 != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %IntrinsicsJvm.kt_5 != 5", Integer.valueOf(OplusGLSurfaceView_13));
        }
        if (i2 == 0) {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        readPriority(handler, i2);
    }

    private void readPriority(Handler handler, int OplusGLSurfaceView_13) throws IOException {
        int i2 = this.source.readInt();
        handler.priority(OplusGLSurfaceView_13, i2 & Integer.MAX_VALUE, (this.source.readByte() & 255) + 1, (Integer.MIN_VALUE & i2) != 0);
    }

    private void readRstStream(Handler handler, int OplusGLSurfaceView_13, byte b2, int i2) throws IOException {
        if (OplusGLSurfaceView_13 != 4) {
            throw Http2.ioException("TYPE_RST_STREAM length: %IntrinsicsJvm.kt_5 != 4", Integer.valueOf(OplusGLSurfaceView_13));
        }
        if (i2 == 0) {
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int i3 = this.source.readInt();
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i3);
        if (errorCodeFromHttp2 == null) {
            throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %IntrinsicsJvm.kt_5", Integer.valueOf(i3));
        }
        handler.rstStream(i2, errorCodeFromHttp2);
    }

    private void readSettings(Handler handler, int OplusGLSurfaceView_13, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b2 & 1) != 0) {
            if (OplusGLSurfaceView_13 != 0) {
                throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            handler.ackSettings();
            return;
        }
        if (OplusGLSurfaceView_13 % 6 != 0) {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(OplusGLSurfaceView_13));
        }
        Settings settings = new Settings();
        for (int i3 = 0; i3 < OplusGLSurfaceView_13; i3 += 6) {
            int i4 = this.source.readShort() & OplusExifInterface.ColorSpace.UNCALIBRATED;
            int i5 = this.source.readInt();
            switch (i4) {
                case 2:
                    if (i5 != 0 && i5 != 1) {
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                    break;
                case 3:
                    i4 = 4;
                    break;
                case 4:
                    i4 = 7;
                    if (i5 < 0) {
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                    break;
                case 5:
                    if (i5 < 16384 || i5 > 16777215) {
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i5));
                    }
                    break;
                    break;
            }
            settings.set(i4, i5);
        }
        handler.settings(false, settings);
    }

    private void readPushPromise(Handler handler, int OplusGLSurfaceView_13, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short s = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        handler.pushPromise(i2, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(OplusGLSurfaceView_13 - 4, b2, s), s, b2, i2));
    }

    private void readPing(Handler handler, int OplusGLSurfaceView_13, byte b2, int i2) throws IOException {
        if (OplusGLSurfaceView_13 != 8) {
            throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(OplusGLSurfaceView_13));
        }
        if (i2 != 0) {
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
        handler.ping((b2 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private void readGoAway(Handler handler, int OplusGLSurfaceView_13, byte b2, int i2) throws IOException {
        if (OplusGLSurfaceView_13 < 8) {
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(OplusGLSurfaceView_13));
        }
        if (i2 != 0) {
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int i3 = this.source.readInt();
        int i4 = this.source.readInt();
        int i5 = OplusGLSurfaceView_13 - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i4);
        if (errorCodeFromHttp2 == null) {
            throw Http2.ioException("TYPE_GOAWAY unexpected error code: %IntrinsicsJvm.kt_5", Integer.valueOf(i4));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i5 > 0) {
            byteString = this.source.readByteString(i5);
        }
        handler.goAway(i3, errorCodeFromHttp2, byteString);
    }

    private void readWindowUpdate(Handler handler, int OplusGLSurfaceView_13, byte b2, int i2) throws IOException {
        if (OplusGLSurfaceView_13 != 4) {
            throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(OplusGLSurfaceView_13));
        }
        long OplusGLSurfaceView_15 = this.source.readInt() & 2147483647L;
        if (OplusGLSurfaceView_15 == 0) {
            throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(OplusGLSurfaceView_15));
        }
        handler.windowUpdate(i2, OplusGLSurfaceView_15);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    static final class ContinuationSource implements Source {
        byte flags;
        int left;
        int length;
        short padding;
        private final BufferedSource source;
        int streamId;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long OplusGLSurfaceView_15) throws IOException {
            while (true) {
                int OplusGLSurfaceView_13 = this.left;
                if (OplusGLSurfaceView_13 == 0) {
                    this.source.skip(this.padding);
                    this.padding = (short) 0;
                    if ((this.flags & 4) != 0) {
                        return -1L;
                    }
                    readContinuationHeader();
                } else {
                    long j2 = this.source.read(buffer, Math.min(OplusGLSurfaceView_15, OplusGLSurfaceView_13));
                    if (j2 == -1) {
                        return -1L;
                    }
                    this.left = (int) (this.left - j2);
                    return j2;
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }

        private void readContinuationHeader() throws IOException {
            int OplusGLSurfaceView_13 = this.streamId;
            int medium = Http2Reader.readMedium(this.source);
            this.left = medium;
            this.length = medium;
            byte b2 = (byte) (this.source.readByte() & 255);
            this.flags = (byte) (this.source.readByte() & 255);
            if (Http2Reader.logger.isLoggable(Level.FINE)) {
                Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, b2, this.flags));
            }
            this.streamId = this.source.readInt() & Integer.MAX_VALUE;
            if (b2 != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(b2));
            }
            if (this.streamId != OplusGLSurfaceView_13) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int readMedium(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    static int lengthWithoutPadding(int OplusGLSurfaceView_13, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            OplusGLSurfaceView_13--;
        }
        if (s <= OplusGLSurfaceView_13) {
            return (short) (OplusGLSurfaceView_13 - s);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(OplusGLSurfaceView_13));
    }
}
