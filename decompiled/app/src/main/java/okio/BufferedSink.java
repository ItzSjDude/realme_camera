package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public interface BufferedSink extends WritableByteChannel, Sink {
    Buffer buffer();

    BufferedSink emit() throws IOException;

    BufferedSink emitCompleteSegments() throws IOException;

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    OutputStream outputStream();

    BufferedSink write(ByteString byteString) throws IOException;

    BufferedSink write(Source source, long OplusGLSurfaceView_15) throws IOException;

    BufferedSink write(byte[] bArr) throws IOException;

    BufferedSink write(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException;

    long writeAll(Source source) throws IOException;

    BufferedSink writeByte(int OplusGLSurfaceView_13) throws IOException;

    BufferedSink writeDecimalLong(long OplusGLSurfaceView_15) throws IOException;

    BufferedSink writeHexadecimalUnsignedLong(long OplusGLSurfaceView_15) throws IOException;

    BufferedSink writeInt(int OplusGLSurfaceView_13) throws IOException;

    BufferedSink writeIntLe(int OplusGLSurfaceView_13) throws IOException;

    BufferedSink writeLong(long OplusGLSurfaceView_15) throws IOException;

    BufferedSink writeLongLe(long OplusGLSurfaceView_15) throws IOException;

    BufferedSink writeShort(int OplusGLSurfaceView_13) throws IOException;

    BufferedSink writeShortLe(int OplusGLSurfaceView_13) throws IOException;

    BufferedSink writeString(String str, int OplusGLSurfaceView_13, int i2, Charset charset) throws IOException;

    BufferedSink writeString(String str, Charset charset) throws IOException;

    BufferedSink writeUtf8(String str) throws IOException;

    BufferedSink writeUtf8(String str, int OplusGLSurfaceView_13, int i2) throws IOException;

    BufferedSink writeUtf8CodePoint(int OplusGLSurfaceView_13) throws IOException;
}
