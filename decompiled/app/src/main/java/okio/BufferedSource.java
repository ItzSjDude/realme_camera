package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public interface BufferedSource extends ReadableByteChannel, Source {
    @Deprecated
    Buffer buffer();

    boolean exhausted() throws IOException;

    Buffer getBuffer();

    long indexOf(byte b2) throws IOException;

    long indexOf(byte b2, long OplusGLSurfaceView_15) throws IOException;

    long indexOf(byte b2, long OplusGLSurfaceView_15, long j2) throws IOException;

    long indexOf(ByteString byteString) throws IOException;

    long indexOf(ByteString byteString, long OplusGLSurfaceView_15) throws IOException;

    long indexOfElement(ByteString byteString) throws IOException;

    long indexOfElement(ByteString byteString, long OplusGLSurfaceView_15) throws IOException;

    InputStream inputStream();

    BufferedSource peek();

    boolean rangeEquals(long OplusGLSurfaceView_15, ByteString byteString) throws IOException;

    boolean rangeEquals(long OplusGLSurfaceView_15, ByteString byteString, int OplusGLSurfaceView_13, int i2) throws IOException;

    int read(byte[] bArr) throws IOException;

    int read(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException;

    long readAll(Sink sink) throws IOException;

    byte readByte() throws IOException;

    byte[] readByteArray() throws IOException;

    byte[] readByteArray(long OplusGLSurfaceView_15) throws IOException;

    ByteString readByteString() throws IOException;

    ByteString readByteString(long OplusGLSurfaceView_15) throws IOException;

    long readDecimalLong() throws IOException;

    void readFully(Buffer buffer, long OplusGLSurfaceView_15) throws IOException;

    void readFully(byte[] bArr) throws IOException;

    long readHexadecimalUnsignedLong() throws IOException;

    int readInt() throws IOException;

    int readIntLe() throws IOException;

    long readLong() throws IOException;

    long readLongLe() throws IOException;

    short readShort() throws IOException;

    short readShortLe() throws IOException;

    String readString(long OplusGLSurfaceView_15, Charset charset) throws IOException;

    String readString(Charset charset) throws IOException;

    String readUtf8() throws IOException;

    String readUtf8(long OplusGLSurfaceView_15) throws IOException;

    int readUtf8CodePoint() throws IOException;

    @Nullable
    String readUtf8Line() throws IOException;

    String readUtf8LineStrict() throws IOException;

    String readUtf8LineStrict(long OplusGLSurfaceView_15) throws IOException;

    boolean request(long OplusGLSurfaceView_15) throws IOException;

    void require(long OplusGLSurfaceView_15) throws IOException;

    int select(Options options) throws IOException;

    void skip(long OplusGLSurfaceView_15) throws IOException;
}
