package okio;

/* loaded from: classes2.dex */
public final class Buffer implements java.lang.Cloneable, java.nio.channels.ByteChannel, okio.BufferedSink, okio.BufferedSource {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;

    @javax.annotation.Nullable
    okio.Segment head;
    long size;

    @Override // okio.BufferedSink, okio.BufferedSource
    public okio.Buffer buffer() {
        return this;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.Sink
    public void close() {
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer emitCompleteSegments() {
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource
    public okio.Buffer getBuffer() {
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSink
    public java.io.OutputStream outputStream() {
        return new java.io.OutputStream() { // from class: okio.Buffer.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @Override // java.io.OutputStream
            public void write(int i_renamed) {
                okio.Buffer.this.writeByte((int) ((byte) i_renamed));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i_renamed, int i2) {
                okio.Buffer.this.write(bArr, i_renamed, i2);
            }

            public java.lang.String toString() {
                return okio.Buffer.this + ".outputStream()";
            }
        };
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSource
    public void require(long j_renamed) throws java.io.EOFException {
        if (this.size < j_renamed) {
            throw new java.io.EOFException();
        }
    }

    @Override // okio.BufferedSource
    public boolean request(long j_renamed) {
        return this.size >= j_renamed;
    }

    @Override // okio.BufferedSource
    public okio.BufferedSource peek() {
        return okio.Okio.buffer(new okio.PeekSource(this));
    }

    @Override // okio.BufferedSource
    public java.io.InputStream inputStream() {
        return new java.io.InputStream() { // from class: okio.Buffer.2
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (okio.Buffer.this.size > 0) {
                    return okio.Buffer.this.readByte() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i_renamed, int i2) {
                return okio.Buffer.this.read(bArr, i_renamed, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) java.lang.Math.min(okio.Buffer.this.size, 2147483647L);
            }

            public java.lang.String toString() {
                return okio.Buffer.this + ".inputStream()";
            }
        };
    }

    public final okio.Buffer copyTo(java.io.OutputStream outputStream) throws java.io.IOException {
        return copyTo(outputStream, 0L, this.size);
    }

    public final okio.Buffer copyTo(java.io.OutputStream outputStream, long j_renamed, long j2) throws java.io.IOException {
        if (outputStream == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        okio.Util.checkOffsetAndCount(this.size, j_renamed, j2);
        if (j2 == 0) {
            return this;
        }
        okio.Segment segment = this.head;
        while (j_renamed >= segment.limit - segment.pos) {
            j_renamed -= segment.limit - segment.pos;
            segment = segment.next;
        }
        while (j2 > 0) {
            int iMin = (int) java.lang.Math.min(segment.limit - r8, j2);
            outputStream.write(segment.data, (int) (segment.pos + j_renamed), iMin);
            j2 -= iMin;
            segment = segment.next;
            j_renamed = 0;
        }
        return this;
    }

    public final okio.Buffer copyTo(okio.Buffer buffer, long j_renamed, long j2) {
        if (buffer == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        okio.Util.checkOffsetAndCount(this.size, j_renamed, j2);
        if (j2 == 0) {
            return this;
        }
        buffer.size += j2;
        okio.Segment segment = this.head;
        while (j_renamed >= segment.limit - segment.pos) {
            j_renamed -= segment.limit - segment.pos;
            segment = segment.next;
        }
        while (j2 > 0) {
            okio.Segment segmentSharedCopy = segment.sharedCopy();
            segmentSharedCopy.pos = (int) (segmentSharedCopy.pos + j_renamed);
            segmentSharedCopy.limit = java.lang.Math.min(segmentSharedCopy.pos + ((int) j2), segmentSharedCopy.limit);
            okio.Segment segment2 = buffer.head;
            if (segment2 == null) {
                segmentSharedCopy.prev = segmentSharedCopy;
                segmentSharedCopy.next = segmentSharedCopy;
                buffer.head = segmentSharedCopy;
            } else {
                segment2.prev.push(segmentSharedCopy);
            }
            j2 -= segmentSharedCopy.limit - segmentSharedCopy.pos;
            segment = segment.next;
            j_renamed = 0;
        }
        return this;
    }

    public final okio.Buffer writeTo(java.io.OutputStream outputStream) throws java.io.IOException {
        return writeTo(outputStream, this.size);
    }

    public final okio.Buffer writeTo(java.io.OutputStream outputStream, long j_renamed) throws java.io.IOException {
        if (outputStream == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        okio.Util.checkOffsetAndCount(this.size, 0L, j_renamed);
        okio.Segment segment = this.head;
        while (j_renamed > 0) {
            int iMin = (int) java.lang.Math.min(j_renamed, segment.limit - segment.pos);
            outputStream.write(segment.data, segment.pos, iMin);
            segment.pos += iMin;
            long j2 = iMin;
            this.size -= j2;
            j_renamed -= j2;
            if (segment.pos == segment.limit) {
                okio.Segment segmentPop = segment.pop();
                this.head = segmentPop;
                okio.SegmentPool.recycle(segment);
                segment = segmentPop;
            }
        }
        return this;
    }

    public final okio.Buffer readFrom(java.io.InputStream inputStream) throws java.io.IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final okio.Buffer readFrom(java.io.InputStream inputStream, long j_renamed) throws java.io.IOException {
        if (j_renamed < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j_renamed);
        }
        readFrom(inputStream, j_renamed, false);
        return this;
    }

    private void readFrom(java.io.InputStream inputStream, long j_renamed, boolean z_renamed) throws java.io.IOException {
        if (inputStream == null) {
            throw new java.lang.IllegalArgumentException("in_renamed == null");
        }
        while (true) {
            if (j_renamed <= 0 && !z_renamed) {
                return;
            }
            okio.Segment segmentWritableSegment = writableSegment(1);
            int i_renamed = inputStream.read(segmentWritableSegment.data, segmentWritableSegment.limit, (int) java.lang.Math.min(j_renamed, 8192 - segmentWritableSegment.limit));
            if (i_renamed == -1) {
                if (!z_renamed) {
                    throw new java.io.EOFException();
                }
                return;
            } else {
                segmentWritableSegment.limit += i_renamed;
                long j2 = i_renamed;
                this.size += j2;
                j_renamed -= j2;
            }
        }
    }

    public final long completeSegmentByteCount() {
        long j_renamed = this.size;
        if (j_renamed == 0) {
            return 0L;
        }
        okio.Segment segment = this.head.prev;
        return (segment.limit >= 8192 || !segment.owner) ? j_renamed : j_renamed - (segment.limit - segment.pos);
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        if (this.size == 0) {
            throw new java.lang.IllegalStateException("size == 0");
        }
        okio.Segment segment = this.head;
        int i_renamed = segment.pos;
        int i2 = segment.limit;
        int i3 = i_renamed + 1;
        byte b2 = segment.data[i_renamed];
        this.size--;
        if (i3 == i2) {
            this.head = segment.pop();
            okio.SegmentPool.recycle(segment);
        } else {
            segment.pos = i3;
        }
        return b2;
    }

    public final byte getByte(long j_renamed) {
        okio.Util.checkOffsetAndCount(this.size, j_renamed, 1L);
        long j2 = this.size;
        if (j2 - j_renamed > j_renamed) {
            okio.Segment segment = this.head;
            while (true) {
                long j3 = segment.limit - segment.pos;
                if (j_renamed >= j3) {
                    j_renamed -= j3;
                    segment = segment.next;
                } else {
                    return segment.data[segment.pos + ((int) j_renamed)];
                }
            }
        } else {
            long j4 = j_renamed - j2;
            okio.Segment segment2 = this.head;
            do {
                segment2 = segment2.prev;
                j4 += segment2.limit - segment2.pos;
            } while (j4 < 0);
            return segment2.data[segment2.pos + ((int) j4)];
        }
    }

    @Override // okio.BufferedSource
    public short readShort() {
        if (this.size < 2) {
            throw new java.lang.IllegalStateException("size < 2: " + this.size);
        }
        okio.Segment segment = this.head;
        int i_renamed = segment.pos;
        int i2 = segment.limit;
        if (i2 - i_renamed < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = segment.data;
        int i3 = i_renamed + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i_renamed] & 255) << 8) | (bArr[i3] & 255);
        this.size -= 2;
        if (i4 == i2) {
            this.head = segment.pop();
            okio.SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return (short) i5;
    }

    @Override // okio.BufferedSource
    public int readInt() {
        if (this.size < 4) {
            throw new java.lang.IllegalStateException("size < 4: " + this.size);
        }
        okio.Segment segment = this.head;
        int i_renamed = segment.pos;
        int i2 = segment.limit;
        if (i2 - i_renamed < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = segment.data;
        int i3 = i_renamed + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i_renamed] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.size -= 4;
        if (i8 == i2) {
            this.head = segment.pop();
            okio.SegmentPool.recycle(segment);
        } else {
            segment.pos = i8;
        }
        return i9;
    }

    @Override // okio.BufferedSource
    public long readLong() {
        if (this.size < 8) {
            throw new java.lang.IllegalStateException("size < 8: " + this.size);
        }
        okio.Segment segment = this.head;
        int i_renamed = segment.pos;
        int i2 = segment.limit;
        if (i2 - i_renamed < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = segment.data;
        long j_renamed = (bArr[i_renamed] & 255) << 56;
        int i3 = i_renamed + 1 + 1 + 1;
        long j2 = j_renamed | ((bArr[r8] & 255) << 48) | ((bArr[r1] & 255) << 40);
        long j3 = j2 | ((bArr[i3] & 255) << 32) | ((bArr[r1] & 255) << 24);
        long j4 = j3 | ((bArr[r6] & 255) << 16);
        long j5 = j4 | ((bArr[r1] & 255) << 8);
        int i4 = i3 + 1 + 1 + 1 + 1 + 1;
        long j6 = (bArr[r6] & 255) | j5;
        this.size -= 8;
        if (i4 == i2) {
            this.head = segment.pop();
            okio.SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return j6;
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return okio.Util.reverseBytesShort(readShort());
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return okio.Util.reverseBytesInt(readInt());
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return okio.Util.reverseBytesLong(readLong());
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:33:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:34:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:36:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:48:0x00ab A_renamed[EDGE_INSN: B_renamed:48:0x00ab->B_renamed:38:0x00ab BREAK  A_renamed[LOOP:0: B_renamed:5:0x0010->B_renamed:50:?], SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readDecimalLong() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.size
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto Lb6
            r5 = -7
            r7 = 0
            r8 = r5
            r5 = r7
            r6 = r5
        L10:
            okio.Segment r10 = r0.head
            byte[] r11 = r10.data
            int r12 = r10.pos
            int r13 = r10.limit
        L18:
            if (r12 >= r13) goto L97
            r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L69
            r1 = 57
            if (r15 > r1) goto L69
            int r14 = r14 - r15
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L3c
            if (r16 != 0) goto L36
            long r1 = (long) r14
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 >= 0) goto L36
            goto L3c
        L36:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L73
        L3c:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeDecimalLong(r3)
            okio.Buffer r0 = r0.writeByte(r15)
            if (r5 != 0) goto L4e
            r0.readByte()
        L4e:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L69:
            r1 = 45
            if (r15 != r1) goto L78
            if (r7 != 0) goto L78
            r1 = 1
            long r8 = r8 - r1
            r5 = 1
        L73:
            int r12 = r12 + 1
            int r7 = r7 + 1
            goto L18
        L78:
            if (r7 == 0) goto L7c
            r6 = 1
            goto L97
        L7c:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r15)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L97:
            if (r12 != r13) goto La3
            okio.Segment r1 = r10.pop()
            r0.head = r1
            okio.SegmentPool.recycle(r10)
            goto La5
        La3:
            r10.pos = r12
        La5:
            if (r6 != 0) goto Lab
            okio.Segment r1 = r0.head
            if (r1 != 0) goto L10
        Lab:
            long r1 = r0.size
            long r6 = (long) r7
            long r1 = r1 - r6
            r0.size = r1
            if (r5 == 0) goto Lb4
            goto Lb5
        Lb4:
            long r3 = -r3
        Lb5:
            return r3
        Lb6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:44:0x00a5 A_renamed[EDGE_INSN: B_renamed:44:0x00a5->B_renamed:38:0x00a5 BREAK  A_renamed[LOOP:0: B_renamed:5:0x000b->B_renamed:46:?], SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readHexadecimalUnsignedLong() {
        /*
            r14 = this;
            long r0 = r14.size
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lac
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            okio.Segment r6 = r14.head
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L13:
            if (r8 >= r9) goto L91
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L72
            r11 = 70
            if (r10 > r11) goto L72
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L13
        L4a:
            okio.Buffer r14 = new okio.Buffer
            r14.<init>()
            okio.Buffer r14 = r14.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r14 = r14.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r14 = r14.readUtf8()
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            r0.<init>(r14)
            throw r0
        L72:
            if (r1 == 0) goto L76
            r0 = 1
            goto L91
        L76:
            java.lang.NumberFormatException r14 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA_renamed-F_renamed] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = java.lang.Integer.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L91:
            if (r8 != r9) goto L9d
            okio.Segment r7 = r6.pop()
            r14.head = r7
            okio.SegmentPool.recycle(r6)
            goto L9f
        L9d:
            r6.pos = r8
        L9f:
            if (r0 != 0) goto La5
            okio.Segment r6 = r14.head
            if (r6 != 0) goto Lb
        La5:
            long r2 = r14.size
            long r0 = (long) r1
            long r2 = r2 - r0
            r14.size = r2
            return r4
        Lac:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "size == 0"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public okio.ByteString readByteString() {
        return new okio.ByteString(readByteArray());
    }

    @Override // okio.BufferedSource
    public okio.ByteString readByteString(long j_renamed) throws java.io.EOFException {
        return new okio.ByteString(readByteArray(j_renamed));
    }

    @Override // okio.BufferedSource
    public int select(okio.Options options) {
        int iSelectPrefix = selectPrefix(options, false);
        if (iSelectPrefix == -1) {
            return -1;
        }
        try {
            skip(options.byteStrings[iSelectPrefix].size());
            return iSelectPrefix;
        } catch (java.io.EOFException unused) {
            throw new java.lang.AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:27:0x0058, code lost:
    
        if (r19 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:28:0x005a, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:29:0x005b, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    int selectPrefix(okio.Options r18, boolean r19) {
        /*
            r17 = this;
            r0 = r18
            r1 = r17
            okio.Segment r1 = r1.head
            r2 = -2
            if (r1 != 0) goto L13
            if (r19 == 0) goto Lc
            return r2
        Lc:
            okio.ByteString r1 = okio.ByteString.EMPTY
            int r0 = r0.indexOf(r1)
            return r0
        L13:
            byte[] r3 = r1.data
            int r4 = r1.pos
            int r5 = r1.limit
            int[] r0 = r0.trie
            r6 = 0
            r7 = -1
            r8 = r4
            r10 = r5
            r9 = r7
            r4 = r1
            r5 = r3
            r3 = r6
        L23:
            int r11 = r3 + 1
            r3 = r0[r3]
            int r12 = r11 + 1
            r11 = r0[r11]
            if (r11 == r7) goto L2e
            r9 = r11
        L2e:
            if (r4 != 0) goto L31
            goto L58
        L31:
            r11 = 0
            if (r3 >= 0) goto L6d
            int r3 = r3 * (-1)
            int r13 = r12 + r3
        L38:
            int r3 = r8 + 1
            r8 = r5[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r14 = r12 + 1
            r12 = r0[r12]
            if (r8 == r12) goto L45
            return r9
        L45:
            if (r14 != r13) goto L49
            r8 = 1
            goto L4a
        L49:
            r8 = r6
        L4a:
            if (r3 != r10) goto L64
            okio.Segment r3 = r4.next
            int r4 = r3.pos
            byte[] r5 = r3.data
            int r10 = r3.limit
            if (r3 != r1) goto L5f
            if (r8 != 0) goto L5c
        L58:
            if (r19 == 0) goto L5b
            return r2
        L5b:
            return r9
        L5c:
            r3 = r4
            r4 = r11
            goto L64
        L5f:
            r16 = r4
            r4 = r3
            r3 = r16
        L64:
            if (r8 == 0) goto L6a
            r8 = r0[r14]
            r13 = r3
            goto L90
        L6a:
            r8 = r3
            r12 = r14
            goto L38
        L6d:
            int r13 = r8 + 1
            r8 = r5[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r14 = r12 + r3
        L75:
            if (r12 != r14) goto L78
            return r9
        L78:
            r15 = r0[r12]
            if (r8 != r15) goto L96
            int r12 = r12 + r3
            r8 = r0[r12]
            if (r13 != r10) goto L90
            okio.Segment r3 = r4.next
            int r4 = r3.pos
            byte[] r5 = r3.data
            int r10 = r3.limit
            if (r3 != r1) goto L8e
            r13 = r4
            r4 = r11
            goto L90
        L8e:
            r13 = r4
            r4 = r3
        L90:
            if (r8 < 0) goto L93
            return r8
        L93:
            int r3 = -r8
            r8 = r13
            goto L23
        L96:
            int r12 = r12 + 1
            goto L75
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.selectPrefix(okio.Options, boolean):int");
    }

    @Override // okio.BufferedSource
    public void readFully(okio.Buffer buffer, long j_renamed) throws java.io.EOFException {
        long j2 = this.size;
        if (j2 < j_renamed) {
            buffer.write(this, j2);
            throw new java.io.EOFException();
        }
        buffer.write(this, j_renamed);
    }

    @Override // okio.BufferedSource
    public long readAll(okio.Sink sink) throws java.io.IOException {
        long j_renamed = this.size;
        if (j_renamed > 0) {
            sink.write(this, j_renamed);
        }
        return j_renamed;
    }

    @Override // okio.BufferedSource
    public java.lang.String readUtf8() {
        try {
            return readString(this.size, okio.Util.UTF_8);
        } catch (java.io.EOFException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }

    @Override // okio.BufferedSource
    public java.lang.String readUtf8(long j_renamed) throws java.io.EOFException {
        return readString(j_renamed, okio.Util.UTF_8);
    }

    @Override // okio.BufferedSource
    public java.lang.String readString(java.nio.charset.Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (java.io.EOFException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }

    @Override // okio.BufferedSource
    public java.lang.String readString(long j_renamed, java.nio.charset.Charset charset) throws java.io.EOFException {
        okio.Util.checkOffsetAndCount(this.size, 0L, j_renamed);
        if (charset == null) {
            throw new java.lang.IllegalArgumentException("charset == null");
        }
        if (j_renamed > 2147483647L) {
            throw new java.lang.IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j_renamed);
        }
        if (j_renamed == 0) {
            return "";
        }
        okio.Segment segment = this.head;
        if (segment.pos + j_renamed > segment.limit) {
            return new java.lang.String(readByteArray(j_renamed), charset);
        }
        java.lang.String str = new java.lang.String(segment.data, segment.pos, (int) j_renamed, charset);
        segment.pos = (int) (segment.pos + j_renamed);
        this.size -= j_renamed;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            okio.SegmentPool.recycle(segment);
        }
        return str;
    }

    @Override // okio.BufferedSource
    @javax.annotation.Nullable
    public java.lang.String readUtf8Line() throws java.io.EOFException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf == -1) {
            long j_renamed = this.size;
            if (j_renamed != 0) {
                return readUtf8(j_renamed);
            }
            return null;
        }
        return readUtf8Line(jIndexOf);
    }

    @Override // okio.BufferedSource
    public java.lang.String readUtf8LineStrict() throws java.io.EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public java.lang.String readUtf8LineStrict(long j_renamed) throws java.io.EOFException {
        if (j_renamed < 0) {
            throw new java.lang.IllegalArgumentException("limit < 0: " + j_renamed);
        }
        long j2 = j_renamed != Long.MAX_VALUE ? j_renamed + 1 : Long.MAX_VALUE;
        long jIndexOf = indexOf((byte) 10, 0L, j2);
        if (jIndexOf != -1) {
            return readUtf8Line(jIndexOf);
        }
        if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
            return readUtf8Line(j2);
        }
        okio.Buffer buffer = new okio.Buffer();
        copyTo(buffer, 0L, java.lang.Math.min(32L, size()));
        throw new java.io.EOFException("\\n_renamed not found: limit=" + java.lang.Math.min(size(), j_renamed) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    java.lang.String readUtf8Line(long j_renamed) throws java.io.EOFException {
        if (j_renamed > 0) {
            long j2 = j_renamed - 1;
            if (getByte(j2) == 13) {
                java.lang.String utf8 = readUtf8(j2);
                skip(2L);
                return utf8;
            }
        }
        java.lang.String utf82 = readUtf8(j_renamed);
        skip(1L);
        return utf82;
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws java.io.EOFException {
        int i_renamed;
        int i2;
        int i3;
        if (this.size == 0) {
            throw new java.io.EOFException();
        }
        byte b2 = getByte(0L);
        if ((b2 & 128) == 0) {
            i_renamed = b2 & 127;
            i3 = 0;
            i2 = 1;
        } else if ((b2 & 224) == 192) {
            i_renamed = b2 & 31;
            i2 = 2;
            i3 = 128;
        } else if ((b2 & 240) == 224) {
            i_renamed = b2 & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((b2 & 248) != 240) {
                skip(1L);
                return REPLACEMENT_CHARACTER;
            }
            i_renamed = b2 & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j_renamed = i2;
        if (this.size < j_renamed) {
            throw new java.io.EOFException("size < " + i2 + ": " + this.size + " (to read code point prefixed 0x" + java.lang.Integer.toHexString(b2) + ")");
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b3 = getByte(j2);
            if ((b3 & 192) != 128) {
                skip(j2);
                return REPLACEMENT_CHARACTER;
            }
            i_renamed = (i_renamed << 6) | (b3 & 63);
        }
        skip(j_renamed);
        return i_renamed > 1114111 ? REPLACEMENT_CHARACTER : ((i_renamed < 55296 || i_renamed > 57343) && i_renamed >= i3) ? i_renamed : REPLACEMENT_CHARACTER;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (java.io.EOFException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j_renamed) throws java.io.EOFException {
        okio.Util.checkOffsetAndCount(this.size, 0L, j_renamed);
        if (j_renamed > 2147483647L) {
            throw new java.lang.IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j_renamed);
        }
        byte[] bArr = new byte[(int) j_renamed];
        readFully(bArr);
        return bArr;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws java.io.EOFException {
        int i_renamed = 0;
        while (i_renamed < bArr.length) {
            int i2 = read(bArr, i_renamed, bArr.length - i_renamed);
            if (i2 == -1) {
                throw new java.io.EOFException();
            }
            i_renamed += i2;
        }
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i_renamed, int i2) {
        okio.Util.checkOffsetAndCount(bArr.length, i_renamed, i2);
        okio.Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = java.lang.Math.min(i2, segment.limit - segment.pos);
        java.lang.System.arraycopy(segment.data, segment.pos, bArr, i_renamed, iMin);
        segment.pos += iMin;
        this.size -= iMin;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            okio.SegmentPool.recycle(segment);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        okio.Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = java.lang.Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, iMin);
        segment.pos += iMin;
        this.size -= iMin;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            okio.SegmentPool.recycle(segment);
        }
        return iMin;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (java.io.EOFException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }

    @Override // okio.BufferedSource
    public void skip(long j_renamed) throws java.io.EOFException {
        while (j_renamed > 0) {
            if (this.head == null) {
                throw new java.io.EOFException();
            }
            int iMin = (int) java.lang.Math.min(j_renamed, r0.limit - this.head.pos);
            long j2 = iMin;
            this.size -= j2;
            j_renamed -= j2;
            this.head.pos += iMin;
            if (this.head.pos == this.head.limit) {
                okio.Segment segment = this.head;
                this.head = segment.pop();
                okio.SegmentPool.recycle(segment);
            }
        }
    }

    @Override // okio.BufferedSink
    public okio.Buffer write(okio.ByteString byteString) {
        if (byteString == null) {
            throw new java.lang.IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeUtf8(java.lang.String str) {
        return writeUtf8(str, 0, str.length());
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeUtf8(java.lang.String str, int i_renamed, int i2) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("string == null");
        }
        if (i_renamed < 0) {
            throw new java.lang.IllegalArgumentException("beginIndex < 0: " + i_renamed);
        }
        if (i2 < i_renamed) {
            throw new java.lang.IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i_renamed);
        }
        if (i2 > str.length()) {
            throw new java.lang.IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i_renamed < i2) {
            char cCharAt = str.charAt(i_renamed);
            if (cCharAt < 128) {
                okio.Segment segmentWritableSegment = writableSegment(1);
                byte[] bArr = segmentWritableSegment.data;
                int i3 = segmentWritableSegment.limit - i_renamed;
                int iMin = java.lang.Math.min(i2, 8192 - i3);
                int i4 = i_renamed + 1;
                bArr[i_renamed + i3] = (byte) cCharAt;
                while (i4 < iMin) {
                    char cCharAt2 = str.charAt(i4);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i4 + i3] = (byte) cCharAt2;
                    i4++;
                }
                int i5 = (i3 + i4) - segmentWritableSegment.limit;
                segmentWritableSegment.limit += i5;
                this.size += i5;
                i_renamed = i4;
            } else {
                if (cCharAt < 2048) {
                    writeByte((cCharAt >> 6) | 192);
                    writeByte((cCharAt & '?') | 128);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    writeByte((cCharAt >> '\f_renamed') | 224);
                    writeByte(((cCharAt >> 6) & 63) | 128);
                    writeByte((cCharAt & '?') | 128);
                } else {
                    int i6 = i_renamed + 1;
                    char cCharAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        writeByte(63);
                        i_renamed = i6;
                    } else {
                        int i7 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        writeByte((i7 >> 18) | 240);
                        writeByte(((i7 >> 12) & 63) | 128);
                        writeByte(((i7 >> 6) & 63) | 128);
                        writeByte((i7 & 63) | 128);
                        i_renamed += 2;
                    }
                }
                i_renamed++;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeUtf8CodePoint(int i_renamed) {
        if (i_renamed < 128) {
            writeByte(i_renamed);
        } else if (i_renamed < 2048) {
            writeByte((i_renamed >> 6) | 192);
            writeByte((i_renamed & 63) | 128);
        } else if (i_renamed < 65536) {
            if (i_renamed >= 55296 && i_renamed <= 57343) {
                writeByte(63);
            } else {
                writeByte((i_renamed >> 12) | 224);
                writeByte(((i_renamed >> 6) & 63) | 128);
                writeByte((i_renamed & 63) | 128);
            }
        } else if (i_renamed <= 1114111) {
            writeByte((i_renamed >> 18) | 240);
            writeByte(((i_renamed >> 12) & 63) | 128);
            writeByte(((i_renamed >> 6) & 63) | 128);
            writeByte((i_renamed & 63) | 128);
        } else {
            throw new java.lang.IllegalArgumentException("Unexpected code point: " + java.lang.Integer.toHexString(i_renamed));
        }
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeString(java.lang.String str, java.nio.charset.Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeString(java.lang.String str, int i_renamed, int i2, java.nio.charset.Charset charset) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("string == null");
        }
        if (i_renamed < 0) {
            throw new java.lang.IllegalAccessError("beginIndex < 0: " + i_renamed);
        }
        if (i2 < i_renamed) {
            throw new java.lang.IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i_renamed);
        }
        if (i2 <= str.length()) {
            if (charset == null) {
                throw new java.lang.IllegalArgumentException("charset == null");
            }
            if (charset.equals(okio.Util.UTF_8)) {
                return writeUtf8(str, i_renamed, i2);
            }
            byte[] bytes = str.substring(i_renamed, i2).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
        throw new java.lang.IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
    }

    @Override // okio.BufferedSink
    public okio.Buffer write(byte[] bArr) {
        if (bArr == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        return write(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSink
    public okio.Buffer write(byte[] bArr, int i_renamed, int i2) {
        if (bArr == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        long j_renamed = i2;
        okio.Util.checkOffsetAndCount(bArr.length, i_renamed, j_renamed);
        int i3 = i2 + i_renamed;
        while (i_renamed < i3) {
            okio.Segment segmentWritableSegment = writableSegment(1);
            int iMin = java.lang.Math.min(i3 - i_renamed, 8192 - segmentWritableSegment.limit);
            java.lang.System.arraycopy(bArr, i_renamed, segmentWritableSegment.data, segmentWritableSegment.limit, iMin);
            i_renamed += iMin;
            segmentWritableSegment.limit += iMin;
        }
        this.size += j_renamed;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        if (byteBuffer == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i_renamed = iRemaining;
        while (i_renamed > 0) {
            okio.Segment segmentWritableSegment = writableSegment(1);
            int iMin = java.lang.Math.min(i_renamed, 8192 - segmentWritableSegment.limit);
            byteBuffer.get(segmentWritableSegment.data, segmentWritableSegment.limit, iMin);
            i_renamed -= iMin;
            segmentWritableSegment.limit += iMin;
        }
        this.size += iRemaining;
        return iRemaining;
    }

    @Override // okio.BufferedSink
    public long writeAll(okio.Source source) throws java.io.IOException {
        if (source == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        long j_renamed = 0;
        while (true) {
            long j2 = source.read(this, 8192L);
            if (j2 == -1) {
                return j_renamed;
            }
            j_renamed += j2;
        }
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink write(okio.Source source, long j_renamed) throws java.io.IOException {
        while (j_renamed > 0) {
            long j2 = source.read(this, j_renamed);
            if (j2 == -1) {
                throw new java.io.EOFException();
            }
            j_renamed -= j2;
        }
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeByte(int i_renamed) {
        okio.Segment segmentWritableSegment = writableSegment(1);
        byte[] bArr = segmentWritableSegment.data;
        int i2 = segmentWritableSegment.limit;
        segmentWritableSegment.limit = i2 + 1;
        bArr[i2] = (byte) i_renamed;
        this.size++;
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeShort(int i_renamed) {
        okio.Segment segmentWritableSegment = writableSegment(2);
        byte[] bArr = segmentWritableSegment.data;
        int i2 = segmentWritableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i_renamed >>> 8) & 255);
        bArr[i3] = (byte) (i_renamed & 255);
        segmentWritableSegment.limit = i3 + 1;
        this.size += 2;
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeShortLe(int i_renamed) {
        return writeShort((int) okio.Util.reverseBytesShort((short) i_renamed));
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeInt(int i_renamed) {
        okio.Segment segmentWritableSegment = writableSegment(4);
        byte[] bArr = segmentWritableSegment.data;
        int i2 = segmentWritableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i_renamed >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i_renamed >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i_renamed >>> 8) & 255);
        bArr[i5] = (byte) (i_renamed & 255);
        segmentWritableSegment.limit = i5 + 1;
        this.size += 4;
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeIntLe(int i_renamed) {
        return writeInt(okio.Util.reverseBytesInt(i_renamed));
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeLong(long j_renamed) {
        okio.Segment segmentWritableSegment = writableSegment(8);
        byte[] bArr = segmentWritableSegment.data;
        int i_renamed = segmentWritableSegment.limit;
        int i2 = i_renamed + 1;
        bArr[i_renamed] = (byte) ((j_renamed >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j_renamed >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j_renamed >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j_renamed >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j_renamed >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j_renamed >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j_renamed >>> 8) & 255);
        bArr[i8] = (byte) (j_renamed & 255);
        segmentWritableSegment.limit = i8 + 1;
        this.size += 8;
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeLongLe(long j_renamed) {
        return writeLong(okio.Util.reverseBytesLong(j_renamed));
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeDecimalLong(long j_renamed) {
        if (j_renamed == 0) {
            return writeByte(48);
        }
        boolean z_renamed = false;
        int i_renamed = 1;
        if (j_renamed < 0) {
            j_renamed = -j_renamed;
            if (j_renamed < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z_renamed = true;
        }
        if (j_renamed >= 100000000) {
            i_renamed = j_renamed < 1000000000000L ? j_renamed < 10000000000L ? j_renamed < com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND ? 9 : 10 : j_renamed < 100000000000L ? 11 : 12 : j_renamed < 1000000000000000L ? j_renamed < 10000000000000L ? 13 : j_renamed < 100000000000000L ? 14 : 15 : j_renamed < 100000000000000000L ? j_renamed < 10000000000000000L ? 16 : 17 : j_renamed < 1000000000000000000L ? 18 : 19;
        } else if (j_renamed >= 10000) {
            i_renamed = j_renamed < 1000000 ? j_renamed < 100000 ? 5 : 6 : j_renamed < 10000000 ? 7 : 8;
        } else if (j_renamed >= 100) {
            i_renamed = j_renamed < 1000 ? 3 : 4;
        } else if (j_renamed >= 10) {
            i_renamed = 2;
        }
        if (z_renamed) {
            i_renamed++;
        }
        okio.Segment segmentWritableSegment = writableSegment(i_renamed);
        byte[] bArr = segmentWritableSegment.data;
        int i2 = segmentWritableSegment.limit + i_renamed;
        while (j_renamed != 0) {
            i2--;
            bArr[i2] = DIGITS[(int) (j_renamed % 10)];
            j_renamed /= 10;
        }
        if (z_renamed) {
            bArr[i2 - 1] = 45;
        }
        segmentWritableSegment.limit += i_renamed;
        this.size += i_renamed;
        return this;
    }

    @Override // okio.BufferedSink
    public okio.Buffer writeHexadecimalUnsignedLong(long j_renamed) {
        if (j_renamed == 0) {
            return writeByte(48);
        }
        int iNumberOfTrailingZeros = (java.lang.Long.numberOfTrailingZeros(java.lang.Long.highestOneBit(j_renamed)) / 4) + 1;
        okio.Segment segmentWritableSegment = writableSegment(iNumberOfTrailingZeros);
        byte[] bArr = segmentWritableSegment.data;
        int i_renamed = segmentWritableSegment.limit;
        for (int i2 = (segmentWritableSegment.limit + iNumberOfTrailingZeros) - 1; i2 >= i_renamed; i2--) {
            bArr[i2] = DIGITS[(int) (15 & j_renamed)];
            j_renamed >>>= 4;
        }
        segmentWritableSegment.limit += iNumberOfTrailingZeros;
        this.size += iNumberOfTrailingZeros;
        return this;
    }

    okio.Segment writableSegment(int i_renamed) {
        if (i_renamed < 1 || i_renamed > 8192) {
            throw new java.lang.IllegalArgumentException();
        }
        okio.Segment segment = this.head;
        if (segment == null) {
            this.head = okio.SegmentPool.take();
            okio.Segment segment2 = this.head;
            segment2.prev = segment2;
            segment2.next = segment2;
            return segment2;
        }
        okio.Segment segment3 = segment.prev;
        return (segment3.limit + i_renamed > 8192 || !segment3.owner) ? segment3.push(okio.SegmentPool.take()) : segment3;
    }

    @Override // okio.Sink
    public void write(okio.Buffer buffer, long j_renamed) {
        if (buffer == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new java.lang.IllegalArgumentException("source == this");
        }
        okio.Util.checkOffsetAndCount(buffer.size, 0L, j_renamed);
        while (j_renamed > 0) {
            if (j_renamed < buffer.head.limit - buffer.head.pos) {
                okio.Segment segment = this.head;
                okio.Segment segment2 = segment != null ? segment.prev : null;
                if (segment2 != null && segment2.owner) {
                    if ((segment2.limit + j_renamed) - (segment2.shared ? 0 : segment2.pos) <= 8192) {
                        buffer.head.writeTo(segment2, (int) j_renamed);
                        buffer.size -= j_renamed;
                        this.size += j_renamed;
                        return;
                    }
                }
                buffer.head = buffer.head.split((int) j_renamed);
            }
            okio.Segment segment3 = buffer.head;
            long j2 = segment3.limit - segment3.pos;
            buffer.head = segment3.pop();
            okio.Segment segment4 = this.head;
            if (segment4 == null) {
                this.head = segment3;
                okio.Segment segment5 = this.head;
                segment5.prev = segment5;
                segment5.next = segment5;
            } else {
                segment4.prev.push(segment3).compact();
            }
            buffer.size -= j2;
            this.size += j2;
            j_renamed -= j2;
        }
    }

    @Override // okio.Source
    public long read(okio.Buffer buffer, long j_renamed) {
        if (buffer == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        if (j_renamed < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j_renamed);
        }
        long j2 = this.size;
        if (j2 == 0) {
            return -1L;
        }
        if (j_renamed > j2) {
            j_renamed = j2;
        }
        buffer.write(this, j_renamed);
        return j_renamed;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2) {
        return indexOf(b2, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j_renamed) {
        return indexOf(b2, j_renamed, Long.MAX_VALUE);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x0046  */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long indexOf(byte r10, long r11, long r13) {
        /*
            r9 = this;
            r0 = 0
            int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r2 < 0) goto L76
            int r2 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r2 < 0) goto L76
            long r2 = r9.size
            int r4 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r4 <= 0) goto L11
            r13 = r2
        L11:
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            r3 = -1
            if (r2 != 0) goto L18
            return r3
        L18:
            okio.Segment r2 = r9.head
            if (r2 != 0) goto L1d
            return r3
        L1d:
            long r5 = r9.size
            long r7 = r5 - r11
            int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r9 >= 0) goto L33
        L25:
            int r9 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r9 <= 0) goto L42
            okio.Segment r2 = r2.prev
            int r9 = r2.limit
            int r0 = r2.pos
            int r9 = r9 - r0
            long r0 = (long) r9
            long r5 = r5 - r0
            goto L25
        L33:
            r5 = r0
            int r9 = r2.limit
            int r0 = r2.pos
            int r9 = r9 - r0
            long r0 = (long) r9
            long r0 = r0 + r5
            int r9 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r9 >= 0) goto L42
            okio.Segment r2 = r2.next
            goto L33
        L42:
            int r9 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r9 >= 0) goto L75
            byte[] r9 = r2.data
            int r0 = r2.limit
            long r0 = (long) r0
            int r7 = r2.pos
            long r7 = (long) r7
            long r7 = r7 + r13
            long r7 = r7 - r5
            long r0 = java.lang.Math.min(r0, r7)
            int r0 = (int) r0
            int r1 = r2.pos
            long r7 = (long) r1
            long r7 = r7 + r11
            long r7 = r7 - r5
            int r11 = (int) r7
        L5b:
            if (r11 >= r0) goto L6a
            r12 = r9[r11]
            if (r12 != r10) goto L67
            int r9 = r2.pos
            int r11 = r11 - r9
            long r9 = (long) r11
            long r9 = r9 + r5
            return r9
        L67:
            int r11 = r11 + 1
            goto L5b
        L6a:
            int r9 = r2.limit
            int r11 = r2.pos
            int r9 = r9 - r11
            long r11 = (long) r9
            long r11 = r11 + r5
            okio.Segment r2 = r2.next
            r5 = r11
            goto L42
        L75:
            return r3
        L76:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            long r2 = r9.size
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            r0[r1] = r9
            java.lang.Long r9 = java.lang.Long.valueOf(r11)
            r11 = 1
            r0[r11] = r9
            r9 = 2
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r0[r9] = r11
            java.lang.String r9 = "size=%s_renamed fromIndex=%s_renamed toIndex=%s_renamed"
            java.lang.String r9 = java.lang.String.format(r9, r0)
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.indexOf(byte, long, long):long");
    }

    @Override // okio.BufferedSource
    public long indexOf(okio.ByteString byteString) throws java.io.IOException {
        return indexOf(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOf(okio.ByteString byteString, long j_renamed) throws java.io.IOException {
        byte[] bArr;
        okio.Segment segment;
        if (byteString.size() == 0) {
            throw new java.lang.IllegalArgumentException("bytes is_renamed empty");
        }
        long j2 = 0;
        if (j_renamed < 0) {
            throw new java.lang.IllegalArgumentException("fromIndex < 0");
        }
        okio.Segment segment2 = this.head;
        long j3 = -1;
        if (segment2 == null) {
            return -1L;
        }
        long j4 = this.size;
        if (j4 - j_renamed >= j_renamed) {
            while (true) {
                j4 = j2;
                j2 = (segment2.limit - segment2.pos) + j4;
                if (j2 >= j_renamed) {
                    break;
                }
                segment2 = segment2.next;
            }
        } else {
            while (j4 > j_renamed) {
                segment2 = segment2.prev;
                j4 -= segment2.limit - segment2.pos;
            }
        }
        byte b2 = byteString.getByte(0);
        int size = byteString.size();
        long j5 = 1 + (this.size - size);
        long j6 = j_renamed;
        okio.Segment segment3 = segment2;
        long j7 = j4;
        while (j7 < j5) {
            byte[] bArr2 = segment3.data;
            int iMin = (int) java.lang.Math.min(segment3.limit, (segment3.pos + j5) - j7);
            int i_renamed = (int) ((segment3.pos + j6) - j7);
            while (i_renamed < iMin) {
                if (bArr2[i_renamed] == b2) {
                    bArr = bArr2;
                    segment = segment3;
                    if (rangeEquals(segment3, i_renamed + 1, byteString, 1, size)) {
                        return (i_renamed - segment.pos) + j7;
                    }
                } else {
                    bArr = bArr2;
                    segment = segment3;
                }
                i_renamed++;
                segment3 = segment;
                bArr2 = bArr;
            }
            j6 = (r6.limit - r6.pos) + j7;
            segment3 = segment3.next;
            j3 = -1;
            j7 = j6;
        }
        return j3;
    }

    @Override // okio.BufferedSource
    public long indexOfElement(okio.ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(okio.ByteString byteString, long j_renamed) {
        int i_renamed;
        int i2;
        long j2 = 0;
        if (j_renamed < 0) {
            throw new java.lang.IllegalArgumentException("fromIndex < 0");
        }
        okio.Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        long j3 = this.size;
        if (j3 - j_renamed >= j_renamed) {
            while (true) {
                j3 = j2;
                j2 = (segment.limit - segment.pos) + j3;
                if (j2 >= j_renamed) {
                    break;
                }
                segment = segment.next;
            }
        } else {
            while (j3 > j_renamed) {
                segment = segment.prev;
                j3 -= segment.limit - segment.pos;
            }
        }
        if (byteString.size() == 2) {
            byte b2 = byteString.getByte(0);
            byte b3 = byteString.getByte(1);
            while (j3 < this.size) {
                byte[] bArr = segment.data;
                i_renamed = (int) ((segment.pos + j_renamed) - j3);
                int i3 = segment.limit;
                while (i_renamed < i3) {
                    byte b4 = bArr[i_renamed];
                    if (b4 == b2 || b4 == b3) {
                        i2 = segment.pos;
                        return (i_renamed - i2) + j3;
                    }
                    i_renamed++;
                }
                j_renamed = (segment.limit - segment.pos) + j3;
                segment = segment.next;
                j3 = j_renamed;
            }
            return -1L;
        }
        byte[] bArrInternalArray = byteString.internalArray();
        while (j3 < this.size) {
            byte[] bArr2 = segment.data;
            i_renamed = (int) ((segment.pos + j_renamed) - j3);
            int i4 = segment.limit;
            while (i_renamed < i4) {
                byte b5 = bArr2[i_renamed];
                for (byte b6 : bArrInternalArray) {
                    if (b5 == b6) {
                        i2 = segment.pos;
                        return (i_renamed - i2) + j3;
                    }
                }
                i_renamed++;
            }
            j_renamed = (segment.limit - segment.pos) + j3;
            segment = segment.next;
            j3 = j_renamed;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j_renamed, okio.ByteString byteString) {
        return rangeEquals(j_renamed, byteString, 0, byteString.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j_renamed, okio.ByteString byteString, int i_renamed, int i2) {
        if (j_renamed < 0 || i_renamed < 0 || i2 < 0 || this.size - j_renamed < i2 || byteString.size() - i_renamed < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(i3 + j_renamed) != byteString.getByte(i_renamed + i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean rangeEquals(okio.Segment segment, int i_renamed, okio.ByteString byteString, int i2, int i3) {
        int i4 = segment.limit;
        byte[] bArr = segment.data;
        while (i2 < i3) {
            if (i_renamed == i4) {
                okio.Segment segment2 = segment.next;
                byte[] bArr2 = segment2.data;
                i_renamed = segment2.pos;
                segment = segment2;
                i4 = segment2.limit;
                bArr = bArr2;
            }
            if (bArr[i_renamed] != byteString.getByte(i2)) {
                return false;
            }
            i_renamed++;
            i2++;
        }
        return true;
    }

    @Override // okio.Sink
    public okio.Timeout timeout() {
        return okio.Timeout.NONE;
    }

    java.util.List<java.lang.Integer> segmentSizes() {
        if (this.head == null) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(java.lang.Integer.valueOf(this.head.limit - this.head.pos));
        okio.Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment == this.head) {
                return arrayList;
            }
            arrayList.add(java.lang.Integer.valueOf(segment.limit - segment.pos));
        }
    }

    public final okio.ByteString md5() {
        return digest("MD5");
    }

    public final okio.ByteString sha1() {
        return digest("SHA-1");
    }

    public final okio.ByteString sha256() {
        return digest("SHA-256");
    }

    public final okio.ByteString sha512() {
        return digest("SHA-512");
    }

    private okio.ByteString digest(java.lang.String str) throws java.security.NoSuchAlgorithmException {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
            if (this.head != null) {
                messageDigest.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
                okio.Segment segment = this.head;
                while (true) {
                    segment = segment.next;
                    if (segment == this.head) {
                        break;
                    }
                    messageDigest.update(segment.data, segment.pos, segment.limit - segment.pos);
                }
            }
            return okio.ByteString.of_renamed(messageDigest.digest());
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.AssertionError();
        }
    }

    public final okio.ByteString hmacSha1(okio.ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final okio.ByteString hmacSha256(okio.ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final okio.ByteString hmacSha512(okio.ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    private okio.ByteString hmac(java.lang.String str, okio.ByteString byteString) throws java.lang.IllegalStateException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        try {
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance(str);
            mac.init(new javax.crypto.spec.SecretKeySpec(byteString.toByteArray(), str));
            if (this.head != null) {
                mac.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
                okio.Segment segment = this.head;
                while (true) {
                    segment = segment.next;
                    if (segment == this.head) {
                        break;
                    }
                    mac.update(segment.data, segment.pos, segment.limit - segment.pos);
                }
            }
            return okio.ByteString.of_renamed(mac.doFinal());
        } catch (java.security.InvalidKeyException e_renamed) {
            throw new java.lang.IllegalArgumentException(e_renamed);
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.AssertionError();
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof okio.Buffer)) {
            return false;
        }
        okio.Buffer buffer = (okio.Buffer) obj;
        long j_renamed = this.size;
        if (j_renamed != buffer.size) {
            return false;
        }
        long j2 = 0;
        if (j_renamed == 0) {
            return true;
        }
        okio.Segment segment = this.head;
        okio.Segment segment2 = buffer.head;
        int i_renamed = segment.pos;
        int i2 = segment2.pos;
        while (j2 < this.size) {
            long jMin = java.lang.Math.min(segment.limit - i_renamed, segment2.limit - i2);
            int i3 = i2;
            int i4 = i_renamed;
            int i5 = 0;
            while (i5 < jMin) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (segment.data[i4] != segment2.data[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == segment.limit) {
                segment = segment.next;
                i_renamed = segment.pos;
            } else {
                i_renamed = i4;
            }
            if (i3 == segment2.limit) {
                segment2 = segment2.next;
                i2 = segment2.pos;
            } else {
                i2 = i3;
            }
            j2 += jMin;
        }
        return true;
    }

    public int hashCode() {
        okio.Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i_renamed = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i_renamed = (i_renamed * 31) + segment.data[i3];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i_renamed;
    }

    public java.lang.String toString() {
        return snapshot().toString();
    }

    public okio.Buffer clone() {
        okio.Buffer buffer = new okio.Buffer();
        if (this.size == 0) {
            return buffer;
        }
        buffer.head = this.head.sharedCopy();
        okio.Segment segment = buffer.head;
        segment.prev = segment;
        segment.next = segment;
        okio.Segment segment2 = this.head;
        while (true) {
            segment2 = segment2.next;
            if (segment2 != this.head) {
                buffer.head.prev.push(segment2.sharedCopy());
            } else {
                buffer.size = this.size;
                return buffer;
            }
        }
    }

    public final okio.ByteString snapshot() {
        long j_renamed = this.size;
        if (j_renamed > 2147483647L) {
            throw new java.lang.IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
        }
        return snapshot((int) j_renamed);
    }

    public final okio.ByteString snapshot(int i_renamed) {
        if (i_renamed == 0) {
            return okio.ByteString.EMPTY;
        }
        return new okio.SegmentedByteString(this, i_renamed);
    }

    public final okio.Buffer.UnsafeCursor readUnsafe() {
        return readUnsafe(new okio.Buffer.UnsafeCursor());
    }

    public final okio.Buffer.UnsafeCursor readUnsafe(okio.Buffer.UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new java.lang.IllegalStateException("already attached to a_renamed buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    public final okio.Buffer.UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new okio.Buffer.UnsafeCursor());
    }

    public final okio.Buffer.UnsafeCursor readAndWriteUnsafe(okio.Buffer.UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new java.lang.IllegalStateException("already attached to a_renamed buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    public static final class UnsafeCursor implements java.io.Closeable {
        public okio.Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private okio.Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        public final int next() {
            if (this.offset == this.buffer.size) {
                throw new java.lang.IllegalStateException();
            }
            long j_renamed = this.offset;
            return j_renamed == -1 ? seek(0L) : seek(j_renamed + (this.end - this.start));
        }

        public final int seek(long j_renamed) {
            if (j_renamed < -1 || j_renamed > this.buffer.size) {
                throw new java.lang.ArrayIndexOutOfBoundsException(java.lang.String.format("offset=%s_renamed > size=%s_renamed", java.lang.Long.valueOf(j_renamed), java.lang.Long.valueOf(this.buffer.size)));
            }
            if (j_renamed == -1 || j_renamed == this.buffer.size) {
                this.segment = null;
                this.offset = j_renamed;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long j2 = 0;
            long j3 = this.buffer.size;
            okio.Segment segmentPush = this.buffer.head;
            okio.Segment segment = this.buffer.head;
            if (this.segment != null) {
                long j4 = this.offset - (this.start - r6.pos);
                if (j4 > j_renamed) {
                    segment = this.segment;
                    j3 = j4;
                } else {
                    segmentPush = this.segment;
                    j2 = j4;
                }
            }
            if (j3 - j_renamed > j_renamed - j2) {
                while (j_renamed >= (segmentPush.limit - segmentPush.pos) + j2) {
                    j2 += segmentPush.limit - segmentPush.pos;
                    segmentPush = segmentPush.next;
                }
            } else {
                j2 = j3;
                segmentPush = segment;
                while (j2 > j_renamed) {
                    segmentPush = segmentPush.prev;
                    j2 -= segmentPush.limit - segmentPush.pos;
                }
            }
            if (this.readWrite && segmentPush.shared) {
                okio.Segment segmentUnsharedCopy = segmentPush.unsharedCopy();
                if (this.buffer.head == segmentPush) {
                    this.buffer.head = segmentUnsharedCopy;
                }
                segmentPush = segmentPush.push(segmentUnsharedCopy);
                segmentPush.prev.pop();
            }
            this.segment = segmentPush;
            this.offset = j_renamed;
            this.data = segmentPush.data;
            this.start = segmentPush.pos + ((int) (j_renamed - j2));
            this.end = segmentPush.limit;
            return this.end - this.start;
        }

        public final long resizeBuffer(long j_renamed) {
            okio.Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new java.lang.IllegalStateException("not attached to a_renamed buffer");
            }
            if (!this.readWrite) {
                throw new java.lang.IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j2 = buffer.size;
            if (j_renamed <= j2) {
                if (j_renamed < 0) {
                    throw new java.lang.IllegalArgumentException("newSize < 0: " + j_renamed);
                }
                long j3 = j2 - j_renamed;
                while (true) {
                    if (j3 <= 0) {
                        break;
                    }
                    okio.Segment segment = this.buffer.head.prev;
                    long j4 = segment.limit - segment.pos;
                    if (j4 <= j3) {
                        this.buffer.head = segment.pop();
                        okio.SegmentPool.recycle(segment);
                        j3 -= j4;
                    } else {
                        segment.limit = (int) (segment.limit - j3);
                        break;
                    }
                }
                this.segment = null;
                this.offset = j_renamed;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j_renamed > j2) {
                long j5 = j_renamed - j2;
                boolean z_renamed = true;
                while (j5 > 0) {
                    okio.Segment segmentWritableSegment = this.buffer.writableSegment(1);
                    int iMin = (int) java.lang.Math.min(j5, 8192 - segmentWritableSegment.limit);
                    segmentWritableSegment.limit += iMin;
                    j5 -= iMin;
                    if (z_renamed) {
                        this.segment = segmentWritableSegment;
                        this.offset = j2;
                        this.data = segmentWritableSegment.data;
                        this.start = segmentWritableSegment.limit - iMin;
                        this.end = segmentWritableSegment.limit;
                        z_renamed = false;
                    }
                }
            }
            this.buffer.size = j_renamed;
            return j2;
        }

        public final long expandBuffer(int i_renamed) {
            if (i_renamed <= 0) {
                throw new java.lang.IllegalArgumentException("minByteCount <= 0: " + i_renamed);
            }
            if (i_renamed > 8192) {
                throw new java.lang.IllegalArgumentException("minByteCount > Segment.SIZE: " + i_renamed);
            }
            okio.Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new java.lang.IllegalStateException("not attached to a_renamed buffer");
            }
            if (!this.readWrite) {
                throw new java.lang.IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j_renamed = buffer.size;
            okio.Segment segmentWritableSegment = this.buffer.writableSegment(i_renamed);
            int i2 = 8192 - segmentWritableSegment.limit;
            segmentWritableSegment.limit = 8192;
            long j2 = i2;
            this.buffer.size = j_renamed + j2;
            this.segment = segmentWritableSegment;
            this.offset = j_renamed;
            this.data = segmentWritableSegment.data;
            this.start = 8192 - i2;
            this.end = 8192;
            return j2;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new java.lang.IllegalStateException("not attached to a_renamed buffer");
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }
    }
}
