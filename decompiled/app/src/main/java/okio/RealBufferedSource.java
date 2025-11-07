package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
final class RealBufferedSource implements BufferedSource {
    public final Buffer buffer = new Buffer();
    boolean closed;
    public final Source source;

    RealBufferedSource(Source source) {
        if (source == null) {
            throw new NullPointerException("source == null");
        }
        this.source = source;
    }

    @Override // okio.BufferedSource
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // okio.BufferedSource
    public Buffer getBuffer() {
        return this.buffer;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long OplusGLSurfaceView_15) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (OplusGLSurfaceView_15 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + OplusGLSurfaceView_15);
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.buffer.size == 0 && this.source.read(this.buffer, 8192L) == -1) {
            return -1L;
        }
        return this.buffer.read(buffer, Math.min(OplusGLSurfaceView_15, this.buffer.size));
    }

    @Override // okio.BufferedSource
    public boolean exhausted() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        return this.buffer.exhausted() && this.source.read(this.buffer, 8192L) == -1;
    }

    @Override // okio.BufferedSource
    public void require(long OplusGLSurfaceView_15) throws IOException {
        if (!request(OplusGLSurfaceView_15)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public boolean request(long OplusGLSurfaceView_15) throws IOException {
        if (OplusGLSurfaceView_15 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + OplusGLSurfaceView_15);
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (this.buffer.size < OplusGLSurfaceView_15) {
            if (this.source.read(this.buffer, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public byte readByte() throws IOException {
        require(1L);
        return this.buffer.readByte();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long OplusGLSurfaceView_15) throws IOException {
        require(OplusGLSurfaceView_15);
        return this.buffer.readByteString(OplusGLSurfaceView_15);
    }

    @Override // okio.BufferedSource
    public int select(Options options) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            int iSelectPrefix = this.buffer.selectPrefix(options, true);
            if (iSelectPrefix == -1) {
                return -1;
            }
            if (iSelectPrefix != -2) {
                this.buffer.skip(options.byteStrings[iSelectPrefix].size());
                return iSelectPrefix;
            }
        } while (this.source.read(this.buffer, 8192L) != -1);
        return -1;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long OplusGLSurfaceView_15) throws IOException {
        require(OplusGLSurfaceView_15);
        return this.buffer.readByteArray(OplusGLSurfaceView_15);
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws IOException {
        try {
            require(bArr.length);
            this.buffer.readFully(bArr);
        } catch (EOFException COUIBaseListPopupWindow_8) {
            int OplusGLSurfaceView_13 = 0;
            while (this.buffer.size > 0) {
                Buffer buffer = this.buffer;
                int i2 = buffer.read(bArr, OplusGLSurfaceView_13, (int) buffer.size);
                if (i2 == -1) {
                    throw new AssertionError();
                }
                OplusGLSurfaceView_13 += i2;
            }
            throw COUIBaseListPopupWindow_8;
        }
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
        long OplusGLSurfaceView_15 = i2;
        Util.checkOffsetAndCount(bArr.length, OplusGLSurfaceView_13, OplusGLSurfaceView_15);
        if (this.buffer.size == 0 && this.source.read(this.buffer, 8192L) == -1) {
            return -1;
        }
        return this.buffer.read(bArr, OplusGLSurfaceView_13, (int) Math.min(OplusGLSurfaceView_15, this.buffer.size));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.buffer.size == 0 && this.source.read(this.buffer, 8192L) == -1) {
            return -1;
        }
        return this.buffer.read(byteBuffer);
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long OplusGLSurfaceView_15) throws IOException {
        try {
            require(OplusGLSurfaceView_15);
            this.buffer.readFully(buffer, OplusGLSurfaceView_15);
        } catch (EOFException COUIBaseListPopupWindow_8) {
            buffer.writeAll(this.buffer);
            throw COUIBaseListPopupWindow_8;
        }
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long OplusGLSurfaceView_15 = 0;
        while (this.source.read(this.buffer, 8192L) != -1) {
            long jCompleteSegmentByteCount = this.buffer.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                OplusGLSurfaceView_15 += jCompleteSegmentByteCount;
                sink.write(this.buffer, jCompleteSegmentByteCount);
            }
        }
        if (this.buffer.size() <= 0) {
            return OplusGLSurfaceView_15;
        }
        long size = OplusGLSurfaceView_15 + this.buffer.size();
        Buffer buffer = this.buffer;
        sink.write(buffer, buffer.size());
        return size;
    }

    @Override // okio.BufferedSource
    public String readUtf8() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    @Override // okio.BufferedSource
    public String readUtf8(long OplusGLSurfaceView_15) throws IOException {
        require(OplusGLSurfaceView_15);
        return this.buffer.readUtf8(OplusGLSurfaceView_15);
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.buffer.writeAll(this.source);
        return this.buffer.readString(charset);
    }

    @Override // okio.BufferedSource
    public String readString(long OplusGLSurfaceView_15, Charset charset) throws IOException {
        require(OplusGLSurfaceView_15);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        return this.buffer.readString(OplusGLSurfaceView_15, charset);
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws IOException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return this.buffer.readUtf8Line(jIndexOf);
        }
        if (this.buffer.size != 0) {
            return readUtf8(this.buffer.size);
        }
        return null;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws IOException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long OplusGLSurfaceView_15) throws IOException {
        if (OplusGLSurfaceView_15 < 0) {
            throw new IllegalArgumentException("limit < 0: " + OplusGLSurfaceView_15);
        }
        long j2 = OplusGLSurfaceView_15 == Long.MAX_VALUE ? Long.MAX_VALUE : OplusGLSurfaceView_15 + 1;
        long jIndexOf = indexOf((byte) 10, 0L, j2);
        if (jIndexOf != -1) {
            return this.buffer.readUtf8Line(jIndexOf);
        }
        if (j2 < Long.MAX_VALUE && request(j2) && this.buffer.getByte(j2 - 1) == 13 && request(1 + j2) && this.buffer.getByte(j2) == 10) {
            return this.buffer.readUtf8Line(j2);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.buffer;
        buffer2.copyTo(buffer, 0L, Math.min(32L, buffer2.size()));
        throw new EOFException("\\OplusGLSurfaceView_11 not found: limit=" + Math.min(this.buffer.size(), OplusGLSurfaceView_15) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws IOException {
        require(1L);
        byte b2 = this.buffer.getByte(0L);
        if ((b2 & 224) == 192) {
            require(2L);
        } else if ((b2 & 240) == 224) {
            require(3L);
        } else if ((b2 & 248) == 240) {
            require(4L);
        }
        return this.buffer.readUtf8CodePoint();
    }

    @Override // okio.BufferedSource
    public short readShort() throws IOException {
        require(2L);
        return this.buffer.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws IOException {
        require(2L);
        return this.buffer.readShortLe();
    }

    @Override // okio.BufferedSource
    public int readInt() throws IOException {
        require(4L);
        return this.buffer.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws IOException {
        require(4L);
        return this.buffer.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() throws IOException {
        require(8L);
        return this.buffer.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws IOException {
        require(8L);
        return this.buffer.readLongLe();
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() throws IOException {
        byte b2;
        require(1L);
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            int i2 = OplusGLSurfaceView_13 + 1;
            if (!request(i2)) {
                break;
            }
            b2 = this.buffer.getByte(OplusGLSurfaceView_13);
            if ((b2 < 48 || b2 > 57) && !(OplusGLSurfaceView_13 == 0 && b2 == 45)) {
                break;
            }
            OplusGLSurfaceView_13 = i2;
        }
        if (OplusGLSurfaceView_13 == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(b2)));
        }
        return this.buffer.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws IOException {
        byte b2;
        require(1L);
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            int i2 = OplusGLSurfaceView_13 + 1;
            if (!request(i2)) {
                break;
            }
            b2 = this.buffer.getByte(OplusGLSurfaceView_13);
            if ((b2 < 48 || b2 > 57) && ((b2 < 97 || b2 > 102) && (b2 < 65 || b2 > 70))) {
                break;
            }
            OplusGLSurfaceView_13 = i2;
        }
        if (OplusGLSurfaceView_13 == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(b2)));
        }
        return this.buffer.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public void skip(long OplusGLSurfaceView_15) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (OplusGLSurfaceView_15 > 0) {
            if (this.buffer.size == 0 && this.source.read(this.buffer, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(OplusGLSurfaceView_15, this.buffer.size());
            this.buffer.skip(jMin);
            OplusGLSurfaceView_15 -= jMin;
        }
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2) throws IOException {
        return indexOf(b2, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long OplusGLSurfaceView_15) throws IOException {
        return indexOf(b2, OplusGLSurfaceView_15, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long OplusGLSurfaceView_15, long j2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (OplusGLSurfaceView_15 < 0 || j2 < OplusGLSurfaceView_15) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(OplusGLSurfaceView_15), Long.valueOf(j2)));
        }
        while (OplusGLSurfaceView_15 < j2) {
            long jIndexOf = this.buffer.indexOf(b2, OplusGLSurfaceView_15, j2);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long j3 = this.buffer.size;
            if (j3 >= j2 || this.source.read(this.buffer, 8192L) == -1) {
                break;
            }
            OplusGLSurfaceView_15 = Math.max(OplusGLSurfaceView_15, j3);
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long OplusGLSurfaceView_15) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jIndexOf = this.buffer.indexOf(byteString, OplusGLSurfaceView_15);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long j2 = this.buffer.size;
            if (this.source.read(this.buffer, 8192L) == -1) {
                return -1L;
            }
            OplusGLSurfaceView_15 = Math.max(OplusGLSurfaceView_15, (j2 - byteString.size()) + 1);
        }
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) throws IOException {
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long OplusGLSurfaceView_15) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jIndexOfElement = this.buffer.indexOfElement(byteString, OplusGLSurfaceView_15);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long j2 = this.buffer.size;
            if (this.source.read(this.buffer, 8192L) == -1) {
                return -1L;
            }
            OplusGLSurfaceView_15 = Math.max(OplusGLSurfaceView_15, j2);
        }
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long OplusGLSurfaceView_15, ByteString byteString) throws IOException {
        return rangeEquals(OplusGLSurfaceView_15, byteString, 0, byteString.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long OplusGLSurfaceView_15, ByteString byteString, int OplusGLSurfaceView_13, int i2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (OplusGLSurfaceView_15 < 0 || OplusGLSurfaceView_13 < 0 || i2 < 0 || byteString.size() - OplusGLSurfaceView_13 < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + OplusGLSurfaceView_15;
            if (!request(1 + j2) || this.buffer.getByte(j2) != byteString.getByte(OplusGLSurfaceView_13 + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.RealBufferedSource.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                if (RealBufferedSource.this.buffer.size == 0 && RealBufferedSource.this.source.read(RealBufferedSource.this.buffer, 8192L) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.buffer.readByte() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                Util.checkOffsetAndCount(bArr.length, OplusGLSurfaceView_13, i2);
                if (RealBufferedSource.this.buffer.size == 0 && RealBufferedSource.this.source.read(RealBufferedSource.this.buffer, 8192L) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.buffer.read(bArr, OplusGLSurfaceView_13, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                return (int) Math.min(RealBufferedSource.this.buffer.size, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.Source
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.buffer.clear();
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ")";
    }
}
