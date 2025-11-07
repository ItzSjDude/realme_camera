package okio;

/* loaded from: classes2.dex */
final class SegmentedByteString extends okio.ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    SegmentedByteString(okio.Buffer buffer, int i_renamed) {
        super(null);
        okio.Util.checkOffsetAndCount(buffer.size, 0L, i_renamed);
        int i2 = 0;
        okio.Segment segment = buffer.head;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i_renamed) {
            if (segment.limit == segment.pos) {
                throw new java.lang.AssertionError("s_renamed.limit == s_renamed.pos");
            }
            i3 += segment.limit - segment.pos;
            i4++;
            segment = segment.next;
        }
        this.segments = new byte[i4][];
        this.directory = new int[i4 * 2];
        okio.Segment segment2 = buffer.head;
        int i5 = 0;
        while (i2 < i_renamed) {
            this.segments[i5] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            if (i2 > i_renamed) {
                i2 = i_renamed;
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
    public java.lang.String utf8() {
        return toByteString().utf8();
    }

    @Override // okio.ByteString
    public java.lang.String string(java.nio.charset.Charset charset) {
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    public java.lang.String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    public java.lang.String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public okio.ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public okio.ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public okio.ByteString md5() {
        return toByteString().md5();
    }

    @Override // okio.ByteString
    public okio.ByteString sha1() {
        return toByteString().sha1();
    }

    @Override // okio.ByteString
    public okio.ByteString sha256() {
        return toByteString().sha256();
    }

    @Override // okio.ByteString
    public okio.ByteString hmacSha1(okio.ByteString byteString) {
        return toByteString().hmacSha1(byteString);
    }

    @Override // okio.ByteString
    public okio.ByteString hmacSha256(okio.ByteString byteString) {
        return toByteString().hmacSha256(byteString);
    }

    @Override // okio.ByteString
    public java.lang.String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public okio.ByteString substring(int i_renamed) {
        return toByteString().substring(i_renamed);
    }

    @Override // okio.ByteString
    public okio.ByteString substring(int i_renamed, int i2) {
        return toByteString().substring(i_renamed, i2);
    }

    @Override // okio.ByteString
    public byte getByte(int i_renamed) {
        okio.Util.checkOffsetAndCount(this.directory[this.segments.length - 1], i_renamed, 1L);
        int iSegment = segment(i_renamed);
        int i2 = iSegment == 0 ? 0 : this.directory[iSegment - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[iSegment][(i_renamed - i2) + iArr[bArr.length + iSegment]];
    }

    private int segment(int i_renamed) {
        int iBinarySearch = java.util.Arrays.binarySearch(this.directory, 0, this.segments.length, i_renamed + 1);
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
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < length) {
            int[] iArr2 = this.directory;
            int i3 = iArr2[length + i_renamed];
            int i4 = iArr2[i_renamed];
            java.lang.System.arraycopy(this.segments[i_renamed], i3, bArr2, i2, i4 - i2);
            i_renamed++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // okio.ByteString
    public java.nio.ByteBuffer asByteBuffer() {
        return java.nio.ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // okio.ByteString
    public void write(java.io.OutputStream outputStream) throws java.io.IOException {
        if (outputStream == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        int length = this.segments.length;
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i_renamed];
            int i4 = iArr[i_renamed];
            outputStream.write(this.segments[i_renamed], i3, i4 - i2);
            i_renamed++;
            i2 = i4;
        }
    }

    @Override // okio.ByteString
    void write(okio.Buffer buffer) {
        int length = this.segments.length;
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i_renamed];
            int i4 = iArr[i_renamed];
            okio.Segment segment = new okio.Segment(this.segments[i_renamed], i3, (i3 + i4) - i2, true, false);
            if (buffer.head == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                buffer.head.prev.push(segment);
            }
            i_renamed++;
            i2 = i4;
        }
        buffer.size += i2;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i_renamed, okio.ByteString byteString, int i2, int i3) {
        if (i_renamed < 0 || i_renamed > size() - i3) {
            return false;
        }
        int iSegment = segment(i_renamed);
        while (i3 > 0) {
            int i4 = iSegment == 0 ? 0 : this.directory[iSegment - 1];
            int iMin = java.lang.Math.min(i3, ((this.directory[iSegment] - i4) + i4) - i_renamed);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i2, bArr[iSegment], (i_renamed - i4) + iArr[bArr.length + iSegment], iMin)) {
                return false;
            }
            i_renamed += iMin;
            i2 += iMin;
            i3 -= iMin;
            iSegment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i_renamed, byte[] bArr, int i2, int i3) {
        if (i_renamed < 0 || i_renamed > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iSegment = segment(i_renamed);
        while (i3 > 0) {
            int i4 = iSegment == 0 ? 0 : this.directory[iSegment - 1];
            int iMin = java.lang.Math.min(i3, ((this.directory[iSegment] - i4) + i4) - i_renamed);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!okio.Util.arrayRangeEquals(bArr2[iSegment], (i_renamed - i4) + iArr[bArr2.length + iSegment], bArr, i2, iMin)) {
                return false;
            }
            i_renamed += iMin;
            i2 += iMin;
            i3 -= iMin;
            iSegment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public int indexOf(byte[] bArr, int i_renamed) {
        return toByteString().indexOf(bArr, i_renamed);
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] bArr, int i_renamed) {
        return toByteString().lastIndexOf(bArr, i_renamed);
    }

    private okio.ByteString toByteString() {
        return new okio.ByteString(toByteArray());
    }

    @Override // okio.ByteString
    byte[] internalArray() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof okio.ByteString) {
            okio.ByteString byteString = (okio.ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public int hashCode() {
        int i_renamed = this.hashCode;
        if (i_renamed != 0) {
            return i_renamed;
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
    public java.lang.String toString() {
        return toByteString().toString();
    }

    private java.lang.Object writeReplace() {
        return toByteString();
    }
}
