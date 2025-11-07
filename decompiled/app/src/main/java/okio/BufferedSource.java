package okio;

/* loaded from: classes2.dex */
public interface BufferedSource extends java.nio.channels.ReadableByteChannel, okio.Source {
    @java.lang.Deprecated
    okio.Buffer buffer();

    boolean exhausted() throws java.io.IOException;

    okio.Buffer getBuffer();

    long indexOf(byte b2) throws java.io.IOException;

    long indexOf(byte b2, long j_renamed) throws java.io.IOException;

    long indexOf(byte b2, long j_renamed, long j2) throws java.io.IOException;

    long indexOf(okio.ByteString byteString) throws java.io.IOException;

    long indexOf(okio.ByteString byteString, long j_renamed) throws java.io.IOException;

    long indexOfElement(okio.ByteString byteString) throws java.io.IOException;

    long indexOfElement(okio.ByteString byteString, long j_renamed) throws java.io.IOException;

    java.io.InputStream inputStream();

    okio.BufferedSource peek();

    boolean rangeEquals(long j_renamed, okio.ByteString byteString) throws java.io.IOException;

    boolean rangeEquals(long j_renamed, okio.ByteString byteString, int i_renamed, int i2) throws java.io.IOException;

    int read(byte[] bArr) throws java.io.IOException;

    int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException;

    long readAll(okio.Sink sink) throws java.io.IOException;

    byte readByte() throws java.io.IOException;

    byte[] readByteArray() throws java.io.IOException;

    byte[] readByteArray(long j_renamed) throws java.io.IOException;

    okio.ByteString readByteString() throws java.io.IOException;

    okio.ByteString readByteString(long j_renamed) throws java.io.IOException;

    long readDecimalLong() throws java.io.IOException;

    void readFully(okio.Buffer buffer, long j_renamed) throws java.io.IOException;

    void readFully(byte[] bArr) throws java.io.IOException;

    long readHexadecimalUnsignedLong() throws java.io.IOException;

    int readInt() throws java.io.IOException;

    int readIntLe() throws java.io.IOException;

    long readLong() throws java.io.IOException;

    long readLongLe() throws java.io.IOException;

    short readShort() throws java.io.IOException;

    short readShortLe() throws java.io.IOException;

    java.lang.String readString(long j_renamed, java.nio.charset.Charset charset) throws java.io.IOException;

    java.lang.String readString(java.nio.charset.Charset charset) throws java.io.IOException;

    java.lang.String readUtf8() throws java.io.IOException;

    java.lang.String readUtf8(long j_renamed) throws java.io.IOException;

    int readUtf8CodePoint() throws java.io.IOException;

    @javax.annotation.Nullable
    java.lang.String readUtf8Line() throws java.io.IOException;

    java.lang.String readUtf8LineStrict() throws java.io.IOException;

    java.lang.String readUtf8LineStrict(long j_renamed) throws java.io.IOException;

    boolean request(long j_renamed) throws java.io.IOException;

    void require(long j_renamed) throws java.io.IOException;

    int select(okio.Options options) throws java.io.IOException;

    void skip(long j_renamed) throws java.io.IOException;
}
