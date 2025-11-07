package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    SegmentedByteString(Buffer buffer, int OplusGLSurfaceView_13) {
        super(null);
        Util.checkOffsetAndCount(buffer.size, 0L, OplusGLSurfaceView_13);
        int i2 = 0;
        Segment segment = buffer.head;
        int i3 = 0;
        int i4 = 0;
        while (i3 < OplusGLSurfaceView_13) {
            if (segment.limit == segment.pos) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += segment.limit - segment.pos;
            i4++;
            segment = segment.next;
        }
        this.segments = new byte[i4][];
        this.directory = new int[i4 * 2];
        Segment segment2 = buffer.head;
        int i5 = 0;
        while (i2 < OplusGLSurfaceView_13) {
            this.segments[i5] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            if (i2 > OplusGLSurfaceView_13) {
                i2 = OplusGLSurfaceView_13;
            }
            int[] iArr = this.directory;
            iArr[i5] = i2;
            iArr[this.segments.length + i5] = segment2.pos;
            segment2.shared = true;
            i5++;
            segment2 = segment2.next;
        }
    }

    @Override // okio.ByteString
    public String utf8() {
        return toByteString().utf8();
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public ByteString md5() {
        return toByteString().md5();
    }

    @Override // okio.ByteString
    public ByteString sha1() {
        return toByteString().sha1();
    }

    @Override // okio.ByteString
    public ByteString sha256() {
        return toByteString().sha256();
    }

    @Override // okio.ByteString
    public ByteString hmacSha1(ByteString byteString) {
        return toByteString().hmacSha1(byteString);
    }

    @Override // okio.ByteString
    public ByteString hmacSha256(ByteString byteString) {
        return toByteString().hmacSha256(byteString);
    }

    @Override // okio.ByteString
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public ByteString substring(int OplusGLSurfaceView_13) {
        return toByteString().substring(OplusGLSurfaceView_13);
    }

    @Override // okio.ByteString
    public ByteString substring(int OplusGLSurfaceView_13, int i2) {
        return toByteString().substring(OplusGLSurfaceView_13, i2);
    }

    @Override // okio.ByteString
    public byte getByte(int OplusGLSurfaceView_13) {
        Util.checkOffsetAndCount(this.directory[this.segments.length - 1], OplusGLSurfaceView_13, 1L);
        int iSegment = segment(OplusGLSurfaceView_13);
        int i2 = iSegment == 0 ? 0 : this.directory[iSegment - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[iSegment][(OplusGLSurfaceView_13 - i2) + iArr[bArr.length + iSegment]];
    }

    private int segment(int OplusGLSurfaceView_13) {
        int iBinarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, OplusGLSurfaceView_13 + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // okio.ByteString
    public int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        while (OplusGLSurfaceView_13 < length) {
            int[] iArr2 = this.directory;
            int i3 = iArr2[length + OplusGLSurfaceView_13];
            int i4 = iArr2[OplusGLSurfaceView_13];
            System.arraycopy(this.segments[OplusGLSurfaceView_13], i3, bArr2, i2, i4 - i2);
            OplusGLSurfaceView_13++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.segments.length;
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        while (OplusGLSurfaceView_13 < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + OplusGLSurfaceView_13];
            int i4 = iArr[OplusGLSurfaceView_13];
            outputStream.write(this.segments[OplusGLSurfaceView_13], i3, i4 - i2);
            OplusGLSurfaceView_13++;
            i2 = i4;
        }
    }

    @Override // okio.ByteString
    void write(Buffer buffer) {
        int length = this.segments.length;
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        while (OplusGLSurfaceView_13 < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + OplusGLSurfaceView_13];
            int i4 = iArr[OplusGLSurfaceView_13];
            Segment segment = new Segment(this.segments[OplusGLSurfaceView_13], i3, (i3 + i4) - i2, true, false);
            if (buffer.head == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                buffer.head.prev.push(segment);
            }
            OplusGLSurfaceView_13++;
            i2 = i4;
        }
        buffer.size += i2;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int OplusGLSurfaceView_13, ByteString byteString, int i2, int i3) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > size() - i3) {
            return false;
        }
        int iSegment = segment(OplusGLSurfaceView_13);
        while (i3 > 0) {
            int i4 = iSegment == 0 ? 0 : this.directory[iSegment - 1];
            int iMin = Math.min(i3, ((this.directory[iSegment] - i4) + i4) - OplusGLSurfaceView_13);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i2, bArr[iSegment], (OplusGLSurfaceView_13 - i4) + iArr[bArr.length + iSegment], iMin)) {
                return false;
            }
            OplusGLSurfaceView_13 += iMin;
            i2 += iMin;
            i3 -= iMin;
            iSegment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int OplusGLSurfaceView_13, byte[] bArr, int i2, int i3) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iSegment = segment(OplusGLSurfaceView_13);
        while (i3 > 0) {
            int i4 = iSegment == 0 ? 0 : this.directory[iSegment - 1];
            int iMin = Math.min(i3, ((this.directory[iSegment] - i4) + i4) - OplusGLSurfaceView_13);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!Util.arrayRangeEquals(bArr2[iSegment], (OplusGLSurfaceView_13 - i4) + iArr[bArr2.length + iSegment], bArr, i2, iMin)) {
                return false;
            }
            OplusGLSurfaceView_13 += iMin;
            i2 += iMin;
            i3 -= iMin;
            iSegment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public int indexOf(byte[] bArr, int OplusGLSurfaceView_13) {
        return toByteString().indexOf(bArr, OplusGLSurfaceView_13);
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] bArr, int OplusGLSurfaceView_13) {
        return toByteString().lastIndexOf(bArr, OplusGLSurfaceView_13);
    }

    private ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    byte[] internalArray() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public int hashCode() {
        int OplusGLSurfaceView_13 = this.hashCode;
        if (OplusGLSurfaceView_13 != 0) {
            return OplusGLSurfaceView_13;
        }
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.segments[i2];
            int[] iArr = this.directory;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.hashCode = i3;
        return i3;
    }

    @Override // okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    private Object writeReplace() {
        return toByteString();
    }
}
