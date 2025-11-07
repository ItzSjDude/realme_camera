package com.google.protobuf;

/* loaded from: classes.dex */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_RECURSION_LIMIT = 100;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    int recursionDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;
    com.google.protobuf.CodedInputStreamReader wrapper;

    public static int decodeZigZag32(int i_renamed) {
        return (-(i_renamed & 1)) ^ (i_renamed >>> 1);
    }

    public static long decodeZigZag64(long j_renamed) {
        return (-(j_renamed & 1)) ^ (j_renamed >>> 1);
    }

    public abstract void checkLastTagWas(int i_renamed) throws com.google.protobuf.InvalidProtocolBufferException;

    public abstract void enableAliasing(boolean z_renamed);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd() throws java.io.IOException;

    public abstract void popLimit(int i_renamed);

    public abstract int pushLimit(int i_renamed) throws com.google.protobuf.InvalidProtocolBufferException;

    public abstract boolean readBool() throws java.io.IOException;

    public abstract byte[] readByteArray() throws java.io.IOException;

    public abstract java.nio.ByteBuffer readByteBuffer() throws java.io.IOException;

    public abstract com.google.protobuf.ByteString readBytes() throws java.io.IOException;

    public abstract double readDouble() throws java.io.IOException;

    public abstract int readEnum() throws java.io.IOException;

    public abstract int readFixed32() throws java.io.IOException;

    public abstract long readFixed64() throws java.io.IOException;

    public abstract float readFloat() throws java.io.IOException;

    public abstract <T_renamed extends com.google.protobuf.MessageLite> T_renamed readGroup(int i_renamed, com.google.protobuf.Parser<T_renamed> parser, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

    public abstract void readGroup(int i_renamed, com.google.protobuf.MessageLite.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

    public abstract int readInt32() throws java.io.IOException;

    public abstract long readInt64() throws java.io.IOException;

    public abstract <T_renamed extends com.google.protobuf.MessageLite> T_renamed readMessage(com.google.protobuf.Parser<T_renamed> parser, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

    public abstract void readMessage(com.google.protobuf.MessageLite.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

    public abstract byte readRawByte() throws java.io.IOException;

    public abstract byte[] readRawBytes(int i_renamed) throws java.io.IOException;

    public abstract int readRawLittleEndian32() throws java.io.IOException;

    public abstract long readRawLittleEndian64() throws java.io.IOException;

    public abstract int readRawVarint32() throws java.io.IOException;

    public abstract long readRawVarint64() throws java.io.IOException;

    abstract long readRawVarint64SlowPath() throws java.io.IOException;

    public abstract int readSFixed32() throws java.io.IOException;

    public abstract long readSFixed64() throws java.io.IOException;

    public abstract int readSInt32() throws java.io.IOException;

    public abstract long readSInt64() throws java.io.IOException;

    public abstract java.lang.String readString() throws java.io.IOException;

    public abstract java.lang.String readStringRequireUtf8() throws java.io.IOException;

    public abstract int readTag() throws java.io.IOException;

    public abstract int readUInt32() throws java.io.IOException;

    public abstract long readUInt64() throws java.io.IOException;

    @java.lang.Deprecated
    public abstract void readUnknownGroup(int i_renamed, com.google.protobuf.MessageLite.Builder builder) throws java.io.IOException;

    public abstract void resetSizeCounter();

    public abstract boolean skipField(int i_renamed) throws java.io.IOException;

    @java.lang.Deprecated
    public abstract boolean skipField(int i_renamed, com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException;

    public abstract void skipMessage() throws java.io.IOException;

    public abstract void skipMessage(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException;

    public abstract void skipRawBytes(int i_renamed) throws java.io.IOException;

    public static com.google.protobuf.CodedInputStream newInstance(java.io.InputStream inputStream) {
        return newInstance(inputStream, 4096);
    }

    public static com.google.protobuf.CodedInputStream newInstance(java.io.InputStream inputStream, int i_renamed) {
        if (i_renamed <= 0) {
            throw new java.lang.IllegalArgumentException("bufferSize must be_renamed > 0");
        }
        if (inputStream == null) {
            return newInstance(com.google.protobuf.Internal.EMPTY_BYTE_ARRAY);
        }
        return new com.google.protobuf.CodedInputStream.StreamDecoder(inputStream, i_renamed);
    }

    public static com.google.protobuf.CodedInputStream newInstance(java.lang.Iterable<java.nio.ByteBuffer> iterable) {
        if (!com.google.protobuf.CodedInputStream.UnsafeDirectNioDecoder.isSupported()) {
            return newInstance(new com.google.protobuf.IterableByteBufferInputStream(iterable));
        }
        return newInstance(iterable, false);
    }

    static com.google.protobuf.CodedInputStream newInstance(java.lang.Iterable<java.nio.ByteBuffer> iterable, boolean z_renamed) {
        int i_renamed = 0;
        int iRemaining = 0;
        for (java.nio.ByteBuffer byteBuffer : iterable) {
            iRemaining += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                i_renamed |= 1;
            } else {
                i_renamed = byteBuffer.isDirect() ? i_renamed | 2 : i_renamed | 4;
            }
        }
        if (i_renamed == 2) {
            return new com.google.protobuf.CodedInputStream.IterableDirectByteBufferDecoder(iterable, iRemaining, z_renamed);
        }
        return newInstance(new com.google.protobuf.IterableByteBufferInputStream(iterable));
    }

    public static com.google.protobuf.CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static com.google.protobuf.CodedInputStream newInstance(byte[] bArr, int i_renamed, int i2) {
        return newInstance(bArr, i_renamed, i2, false);
    }

    static com.google.protobuf.CodedInputStream newInstance(byte[] bArr, int i_renamed, int i2, boolean z_renamed) {
        com.google.protobuf.CodedInputStream.ArrayDecoder arrayDecoder = new com.google.protobuf.CodedInputStream.ArrayDecoder(bArr, i_renamed, i2, z_renamed);
        try {
            arrayDecoder.pushLimit(i2);
            return arrayDecoder;
        } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
            throw new java.lang.IllegalArgumentException(e_renamed);
        }
    }

    public static com.google.protobuf.CodedInputStream newInstance(java.nio.ByteBuffer byteBuffer) {
        return newInstance(byteBuffer, false);
    }

    static com.google.protobuf.CodedInputStream newInstance(java.nio.ByteBuffer byteBuffer, boolean z_renamed) {
        if (byteBuffer.hasArray()) {
            return newInstance(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z_renamed);
        }
        if (byteBuffer.isDirect() && com.google.protobuf.CodedInputStream.UnsafeDirectNioDecoder.isSupported()) {
            return new com.google.protobuf.CodedInputStream.UnsafeDirectNioDecoder(byteBuffer, z_renamed);
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.duplicate().get(bArr);
        return newInstance(bArr, 0, bArr.length, true);
    }

    private CodedInputStream() {
        this.recursionLimit = 100;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public final int setRecursionLimit(int i_renamed) {
        if (i_renamed < 0) {
            throw new java.lang.IllegalArgumentException("Recursion limit cannot be_renamed negative: " + i_renamed);
        }
        int i2 = this.recursionLimit;
        this.recursionLimit = i_renamed;
        return i2;
    }

    public final int setSizeLimit(int i_renamed) {
        if (i_renamed < 0) {
            throw new java.lang.IllegalArgumentException("Size limit cannot be_renamed negative: " + i_renamed);
        }
        int i2 = this.sizeLimit;
        this.sizeLimit = i_renamed;
        return i2;
    }

    final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }

    final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public static int readRawVarint32(int i_renamed, java.io.InputStream inputStream) throws java.io.IOException {
        if ((i_renamed & 128) == 0) {
            return i_renamed;
        }
        int i2 = i_renamed & 127;
        int i3 = 7;
        while (i3 < 32) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            i2 |= (i4 & 127) << i3;
            if ((i4 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            if ((i5 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
    }

    static int readRawVarint32(java.io.InputStream inputStream) throws java.io.IOException {
        int i_renamed = inputStream.read();
        if (i_renamed == -1) {
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }
        return readRawVarint32(i_renamed, inputStream);
    }

    private static final class ArrayDecoder extends com.google.protobuf.CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private ArrayDecoder(byte[] bArr, int i_renamed, int i2, boolean z_renamed) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = bArr;
            this.limit = i2 + i_renamed;
            this.pos = i_renamed;
            this.startPos = this.pos;
            this.immutable = z_renamed;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws java.io.IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            this.lastTag = readRawVarint32();
            if (com.google.protobuf.WireFormat.getTagFieldNumber(this.lastTag) == 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.invalidTag();
            }
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i_renamed) throws com.google.protobuf.InvalidProtocolBufferException {
            if (this.lastTag != i_renamed) {
                throw com.google.protobuf.InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i_renamed) throws java.io.IOException {
            int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i_renamed);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(com.google.protobuf.WireFormat.makeTag(com.google.protobuf.WireFormat.getTagFieldNumber(i_renamed), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                skipRawBytes(4);
                return true;
            }
            throw com.google.protobuf.InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i_renamed, com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i_renamed);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                com.google.protobuf.ByteString bytes = readBytes();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i_renamed);
                skipMessage(codedOutputStream);
                int iMakeTag = com.google.protobuf.WireFormat.makeTag(com.google.protobuf.WireFormat.getTagFieldNumber(i_renamed), 4);
                checkLastTagWas(iMakeTag);
                codedOutputStream.writeRawVarint32(iMakeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw com.google.protobuf.InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws java.io.IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws java.io.IOException {
            return java.lang.Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws java.io.IOException {
            return java.lang.Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws java.io.IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws java.io.IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws java.io.IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws java.io.IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws java.io.IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws java.io.IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public java.lang.String readString() throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i_renamed = this.limit;
                int i2 = this.pos;
                if (rawVarint32 <= i_renamed - i2) {
                    java.lang.String str = new java.lang.String(this.buffer, i2, rawVarint32, com.google.protobuf.Internal.UTF_8);
                    this.pos += rawVarint32;
                    return str;
                }
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 < 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public java.lang.String readStringRequireUtf8() throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i_renamed = this.limit;
                int i2 = this.pos;
                if (rawVarint32 <= i_renamed - i2) {
                    java.lang.String strDecodeUtf8 = com.google.protobuf.Utf8.decodeUtf8(this.buffer, i2, rawVarint32);
                    this.pos += rawVarint32;
                    return strDecodeUtf8;
                }
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 <= 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i_renamed, com.google.protobuf.MessageLite.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(com.google.protobuf.WireFormat.makeTag(i_renamed, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T_renamed extends com.google.protobuf.MessageLite> T_renamed readGroup(int i_renamed, com.google.protobuf.Parser<T_renamed> parser, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            this.recursionDepth++;
            T_renamed partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(com.google.protobuf.WireFormat.makeTag(i_renamed, 4));
            this.recursionDepth--;
            return partialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        @java.lang.Deprecated
        public void readUnknownGroup(int i_renamed, com.google.protobuf.MessageLite.Builder builder) throws java.io.IOException {
            readGroup(i_renamed, builder, com.google.protobuf.ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(com.google.protobuf.MessageLite.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(iPushLimit);
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T_renamed extends com.google.protobuf.MessageLite> T_renamed readMessage(com.google.protobuf.Parser<T_renamed> parser, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            T_renamed partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(iPushLimit);
            return partialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        public com.google.protobuf.ByteString readBytes() throws java.io.IOException {
            com.google.protobuf.ByteString byteStringCopyFrom;
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i_renamed = this.limit;
                int i2 = this.pos;
                if (rawVarint32 <= i_renamed - i2) {
                    if (this.immutable && this.enableAliasing) {
                        byteStringCopyFrom = com.google.protobuf.ByteString.wrap(this.buffer, i2, rawVarint32);
                    } else {
                        byteStringCopyFrom = com.google.protobuf.ByteString.copyFrom(this.buffer, this.pos, rawVarint32);
                    }
                    this.pos += rawVarint32;
                    return byteStringCopyFrom;
                }
            }
            if (rawVarint32 == 0) {
                return com.google.protobuf.ByteString.EMPTY;
            }
            return com.google.protobuf.ByteString.wrap(readRawBytes(rawVarint32));
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws java.io.IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public java.nio.ByteBuffer readByteBuffer() throws java.io.IOException {
            java.nio.ByteBuffer byteBufferWrap;
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i_renamed = this.limit;
                int i2 = this.pos;
                if (rawVarint32 <= i_renamed - i2) {
                    if (!this.immutable && this.enableAliasing) {
                        byteBufferWrap = java.nio.ByteBuffer.wrap(this.buffer, i2, rawVarint32).slice();
                    } else {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        byteBufferWrap = java.nio.ByteBuffer.wrap(java.util.Arrays.copyOfRange(bArr, i3, i3 + rawVarint32));
                    }
                    this.pos += rawVarint32;
                    return byteBufferWrap;
                }
            }
            if (rawVarint32 == 0) {
                return com.google.protobuf.Internal.EMPTY_BYTE_BUFFER;
            }
            if (rawVarint32 < 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws java.io.IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws java.io.IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws java.io.IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws java.io.IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws java.io.IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws java.io.IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARN: Code restructure failed: missing block: B_renamed:33:0x0068, code lost:
        
            if (r2[r3] < 0) goto L34;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.pos
                int r1 = r5.limit
                if (r1 != r0) goto L7
                goto L6a
            L7:
                byte[] r2 = r5.buffer
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L12
                r5.pos = r3
                return r0
            L12:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L18
                goto L6a
            L18:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L24
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L70
            L24:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L31
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L2f:
                r1 = r3
                goto L70
            L31:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L3f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L70
            L3f:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r2 = r2[r3]
                if (r2 >= 0) goto L70
            L6a:
                long r0 = r5.readRawVarint64SlowPath()
                int r5 = (int) r0
                return r5
            L70:
                r5.pos = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.ArrayDecoder.readRawVarint32():int");
        }

        private void skipRawVarint() throws java.io.IOException {
            if (this.limit - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws java.io.IOException {
            for (int i_renamed = 0; i_renamed < 10; i_renamed++) {
                byte[] bArr = this.buffer;
                int i2 = this.pos;
                this.pos = i2 + 1;
                if (bArr[i2] >= 0) {
                    return;
                }
            }
            throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws java.io.IOException {
            for (int i_renamed = 0; i_renamed < 10; i_renamed++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
        }

        /* JADX WARN: Code restructure failed: missing block: B_renamed:39:0x00b4, code lost:
        
            if (r2[r0] < 0) goto L40;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long readRawVarint64() throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 192
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.ArrayDecoder.readRawVarint64():long");
        }

        @Override // com.google.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws java.io.IOException {
            long j_renamed = 0;
            for (int i_renamed = 0; i_renamed < 64; i_renamed += 7) {
                j_renamed |= (r3 & 127) << i_renamed;
                if ((readRawByte() & 128) == 0) {
                    return j_renamed;
                }
            }
            throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws java.io.IOException {
            int i_renamed = this.pos;
            if (this.limit - i_renamed < 4) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i_renamed + 4;
            return (bArr[i_renamed] & 255) | ((bArr[i_renamed + 1] & 255) << 8) | ((bArr[i_renamed + 2] & 255) << 16) | ((bArr[i_renamed + 3] & 255) << 24);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws java.io.IOException {
            int i_renamed = this.pos;
            if (this.limit - i_renamed < 8) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i_renamed + 8;
            return ((bArr[i_renamed + 7] & 255) << 56) | (bArr[i_renamed] & 255) | ((bArr[i_renamed + 1] & 255) << 8) | ((bArr[i_renamed + 2] & 255) << 16) | ((bArr[i_renamed + 3] & 255) << 24) | ((bArr[i_renamed + 4] & 255) << 32) | ((bArr[i_renamed + 5] & 255) << 40) | ((bArr[i_renamed + 6] & 255) << 48);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z_renamed) {
            this.enableAliasing = z_renamed;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i_renamed) throws com.google.protobuf.InvalidProtocolBufferException {
            if (i_renamed < 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i_renamed + getTotalBytesRead();
            int i2 = this.currentLimit;
            if (totalBytesRead > i2) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i2;
        }

        private void recomputeBufferSizeAfterLimit() {
            this.limit += this.bufferSizeAfterLimit;
            int i_renamed = this.limit;
            int i2 = i_renamed - this.startPos;
            int i3 = this.currentLimit;
            if (i2 > i3) {
                this.bufferSizeAfterLimit = i2 - i3;
                this.limit = i_renamed - this.bufferSizeAfterLimit;
            } else {
                this.bufferSizeAfterLimit = 0;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i_renamed) {
            this.currentLimit = i_renamed;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i_renamed = this.currentLimit;
            if (i_renamed == Integer.MAX_VALUE) {
                return -1;
            }
            return i_renamed - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws java.io.IOException {
            return this.pos == this.limit;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws java.io.IOException {
            int i_renamed = this.pos;
            if (i_renamed == this.limit) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i_renamed + 1;
            return bArr[i_renamed];
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i_renamed) throws java.io.IOException {
            if (i_renamed > 0) {
                int i2 = this.limit;
                int i3 = this.pos;
                if (i_renamed <= i2 - i3) {
                    this.pos = i_renamed + i3;
                    return java.util.Arrays.copyOfRange(this.buffer, i3, this.pos);
                }
            }
            if (i_renamed > 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            if (i_renamed == 0) {
                return com.google.protobuf.Internal.EMPTY_BYTE_ARRAY;
            }
            throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i_renamed) throws java.io.IOException {
            if (i_renamed >= 0) {
                int i2 = this.limit;
                int i3 = this.pos;
                if (i_renamed <= i2 - i3) {
                    this.pos = i3 + i_renamed;
                    return;
                }
            }
            if (i_renamed < 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private static final class UnsafeDirectNioDecoder extends com.google.protobuf.CodedInputStream {
        private final long address;
        private final java.nio.ByteBuffer buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private long limit;
        private long pos;
        private long startPos;

        static boolean isSupported() {
            return com.google.protobuf.UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private UnsafeDirectNioDecoder(java.nio.ByteBuffer byteBuffer, boolean z_renamed) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = byteBuffer;
            this.address = com.google.protobuf.UnsafeUtil.addressOffset(byteBuffer);
            this.limit = this.address + byteBuffer.limit();
            this.pos = this.address + byteBuffer.position();
            this.startPos = this.pos;
            this.immutable = z_renamed;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws java.io.IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            this.lastTag = readRawVarint32();
            if (com.google.protobuf.WireFormat.getTagFieldNumber(this.lastTag) == 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.invalidTag();
            }
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i_renamed) throws com.google.protobuf.InvalidProtocolBufferException {
            if (this.lastTag != i_renamed) {
                throw com.google.protobuf.InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i_renamed) throws java.io.IOException {
            int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i_renamed);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(com.google.protobuf.WireFormat.makeTag(com.google.protobuf.WireFormat.getTagFieldNumber(i_renamed), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                skipRawBytes(4);
                return true;
            }
            throw com.google.protobuf.InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i_renamed, com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i_renamed);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                com.google.protobuf.ByteString bytes = readBytes();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i_renamed);
                skipMessage(codedOutputStream);
                int iMakeTag = com.google.protobuf.WireFormat.makeTag(com.google.protobuf.WireFormat.getTagFieldNumber(i_renamed), 4);
                checkLastTagWas(iMakeTag);
                codedOutputStream.writeRawVarint32(iMakeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw com.google.protobuf.InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws java.io.IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws java.io.IOException {
            return java.lang.Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws java.io.IOException {
            return java.lang.Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws java.io.IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws java.io.IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws java.io.IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws java.io.IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws java.io.IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws java.io.IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public java.lang.String readString() throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 <= 0 || rawVarint32 > remaining()) {
                if (rawVarint32 == 0) {
                    return "";
                }
                if (rawVarint32 < 0) {
                    throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
                }
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = new byte[rawVarint32];
            long j_renamed = rawVarint32;
            com.google.protobuf.UnsafeUtil.copyMemory(this.pos, bArr, 0L, j_renamed);
            java.lang.String str = new java.lang.String(bArr, com.google.protobuf.Internal.UTF_8);
            this.pos += j_renamed;
            return str;
        }

        @Override // com.google.protobuf.CodedInputStream
        public java.lang.String readStringRequireUtf8() throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0 && rawVarint32 <= remaining()) {
                java.lang.String strDecodeUtf8 = com.google.protobuf.Utf8.decodeUtf8(this.buffer, bufferPos(this.pos), rawVarint32);
                this.pos += rawVarint32;
                return strDecodeUtf8;
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 <= 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i_renamed, com.google.protobuf.MessageLite.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(com.google.protobuf.WireFormat.makeTag(i_renamed, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T_renamed extends com.google.protobuf.MessageLite> T_renamed readGroup(int i_renamed, com.google.protobuf.Parser<T_renamed> parser, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            this.recursionDepth++;
            T_renamed partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(com.google.protobuf.WireFormat.makeTag(i_renamed, 4));
            this.recursionDepth--;
            return partialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        @java.lang.Deprecated
        public void readUnknownGroup(int i_renamed, com.google.protobuf.MessageLite.Builder builder) throws java.io.IOException {
            readGroup(i_renamed, builder, com.google.protobuf.ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(com.google.protobuf.MessageLite.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(iPushLimit);
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T_renamed extends com.google.protobuf.MessageLite> T_renamed readMessage(com.google.protobuf.Parser<T_renamed> parser, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            T_renamed partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(iPushLimit);
            return partialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        public com.google.protobuf.ByteString readBytes() throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 <= 0 || rawVarint32 > remaining()) {
                if (rawVarint32 == 0) {
                    return com.google.protobuf.ByteString.EMPTY;
                }
                if (rawVarint32 < 0) {
                    throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
                }
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.immutable && this.enableAliasing) {
                long j_renamed = this.pos;
                long j2 = rawVarint32;
                java.nio.ByteBuffer byteBufferSlice = slice(j_renamed, j_renamed + j2);
                this.pos += j2;
                return com.google.protobuf.ByteString.wrap(byteBufferSlice);
            }
            byte[] bArr = new byte[rawVarint32];
            long j3 = rawVarint32;
            com.google.protobuf.UnsafeUtil.copyMemory(this.pos, bArr, 0L, j3);
            this.pos += j3;
            return com.google.protobuf.ByteString.wrap(bArr);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws java.io.IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public java.nio.ByteBuffer readByteBuffer() throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 <= 0 || rawVarint32 > remaining()) {
                if (rawVarint32 == 0) {
                    return com.google.protobuf.Internal.EMPTY_BYTE_BUFFER;
                }
                if (rawVarint32 < 0) {
                    throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
                }
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            if (!this.immutable && this.enableAliasing) {
                long j_renamed = this.pos;
                long j2 = rawVarint32;
                java.nio.ByteBuffer byteBufferSlice = slice(j_renamed, j_renamed + j2);
                this.pos += j2;
                return byteBufferSlice;
            }
            byte[] bArr = new byte[rawVarint32];
            long j3 = rawVarint32;
            com.google.protobuf.UnsafeUtil.copyMemory(this.pos, bArr, 0L, j3);
            this.pos += j3;
            return java.nio.ByteBuffer.wrap(bArr);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws java.io.IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws java.io.IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws java.io.IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws java.io.IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws java.io.IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws java.io.IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARN: Code restructure failed: missing block: B_renamed:33:0x0083, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r4) < 0) goto L34;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.pos
                long r2 = r10.limit
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto La
                goto L85
            La:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r0)
                if (r0 < 0) goto L17
                r10.pos = r4
                return r0
            L17:
                long r6 = r10.limit
                long r6 = r6 - r4
                r8 = 9
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L21
                goto L85
            L21:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L2f
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L8b
            L2f:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L3e
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L3c:
                r6 = r4
                goto L8b
            L3e:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L4e
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L8b
            L4e:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L8b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L8b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L8b
            L85:
                long r0 = r10.readRawVarint64SlowPath()
                int r10 = (int) r0
                return r10
            L8b:
                r10.pos = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.UnsafeDirectNioDecoder.readRawVarint32():int");
        }

        private void skipRawVarint() throws java.io.IOException {
            if (remaining() >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws java.io.IOException {
            for (int i_renamed = 0; i_renamed < 10; i_renamed++) {
                long j_renamed = this.pos;
                this.pos = 1 + j_renamed;
                if (com.google.protobuf.UnsafeUtil.getByte(j_renamed) >= 0) {
                    return;
                }
            }
            throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws java.io.IOException {
            for (int i_renamed = 0; i_renamed < 10; i_renamed++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() throws java.io.IOException {
            long j_renamed;
            long j2;
            long j3;
            long j4;
            int i_renamed;
            long j5 = this.pos;
            if (this.limit != j5) {
                long j6 = j5 + 1;
                byte b2 = com.google.protobuf.UnsafeUtil.getByte(j5);
                if (b2 >= 0) {
                    this.pos = j6;
                    return b2;
                }
                if (this.limit - j6 >= 9) {
                    long j7 = j6 + 1;
                    int i2 = b2 ^ (com.google.protobuf.UnsafeUtil.getByte(j6) << 7);
                    if (i2 >= 0) {
                        j_renamed = j7 + 1;
                        int i3 = i2 ^ (com.google.protobuf.UnsafeUtil.getByte(j7) << 14);
                        if (i3 >= 0) {
                            j2 = i3 ^ 16256;
                        } else {
                            j7 = j_renamed + 1;
                            int i4 = i3 ^ (com.google.protobuf.UnsafeUtil.getByte(j_renamed) << 21);
                            if (i4 < 0) {
                                i_renamed = i4 ^ (-2080896);
                            } else {
                                j_renamed = j7 + 1;
                                long j8 = i4 ^ (com.google.protobuf.UnsafeUtil.getByte(j7) << 28);
                                if (j8 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    long j9 = j_renamed + 1;
                                    long j10 = j8 ^ (com.google.protobuf.UnsafeUtil.getByte(j_renamed) << 35);
                                    if (j10 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j_renamed = j9 + 1;
                                        j8 = j10 ^ (com.google.protobuf.UnsafeUtil.getByte(j9) << 42);
                                        if (j8 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j9 = j_renamed + 1;
                                            j10 = j8 ^ (com.google.protobuf.UnsafeUtil.getByte(j_renamed) << 49);
                                            if (j10 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                j_renamed = j9 + 1;
                                                j2 = (j10 ^ (com.google.protobuf.UnsafeUtil.getByte(j9) << 56)) ^ 71499008037633920L;
                                                if (j2 < 0) {
                                                    long j11 = 1 + j_renamed;
                                                    if (com.google.protobuf.UnsafeUtil.getByte(j_renamed) >= 0) {
                                                        j_renamed = j11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j2 = j10 ^ j3;
                                    j_renamed = j9;
                                }
                                j2 = j8 ^ j4;
                            }
                        }
                        this.pos = j_renamed;
                        return j2;
                    }
                    i_renamed = i2 ^ (-128);
                    j2 = i_renamed;
                    j_renamed = j7;
                    this.pos = j_renamed;
                    return j2;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws java.io.IOException {
            long j_renamed = 0;
            for (int i_renamed = 0; i_renamed < 64; i_renamed += 7) {
                j_renamed |= (r3 & 127) << i_renamed;
                if ((readRawByte() & 128) == 0) {
                    return j_renamed;
                }
            }
            throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws java.io.IOException {
            long j_renamed = this.pos;
            if (this.limit - j_renamed < 4) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 4 + j_renamed;
            return (com.google.protobuf.UnsafeUtil.getByte(j_renamed) & 255) | ((com.google.protobuf.UnsafeUtil.getByte(1 + j_renamed) & 255) << 8) | ((com.google.protobuf.UnsafeUtil.getByte(2 + j_renamed) & 255) << 16) | ((com.google.protobuf.UnsafeUtil.getByte(j_renamed + 3) & 255) << 24);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws java.io.IOException {
            long j_renamed = this.pos;
            if (this.limit - j_renamed < 8) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 8 + j_renamed;
            return ((com.google.protobuf.UnsafeUtil.getByte(j_renamed + 7) & 255) << 56) | (com.google.protobuf.UnsafeUtil.getByte(j_renamed) & 255) | ((com.google.protobuf.UnsafeUtil.getByte(1 + j_renamed) & 255) << 8) | ((com.google.protobuf.UnsafeUtil.getByte(2 + j_renamed) & 255) << 16) | ((com.google.protobuf.UnsafeUtil.getByte(3 + j_renamed) & 255) << 24) | ((com.google.protobuf.UnsafeUtil.getByte(4 + j_renamed) & 255) << 32) | ((com.google.protobuf.UnsafeUtil.getByte(5 + j_renamed) & 255) << 40) | ((com.google.protobuf.UnsafeUtil.getByte(6 + j_renamed) & 255) << 48);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z_renamed) {
            this.enableAliasing = z_renamed;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i_renamed) throws com.google.protobuf.InvalidProtocolBufferException {
            if (i_renamed < 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i_renamed + getTotalBytesRead();
            int i2 = this.currentLimit;
            if (totalBytesRead > i2) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i2;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i_renamed) {
            this.currentLimit = i_renamed;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i_renamed = this.currentLimit;
            if (i_renamed == Integer.MAX_VALUE) {
                return -1;
            }
            return i_renamed - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws java.io.IOException {
            return this.pos == this.limit;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws java.io.IOException {
            long j_renamed = this.pos;
            if (j_renamed == this.limit) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 1 + j_renamed;
            return com.google.protobuf.UnsafeUtil.getByte(j_renamed);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i_renamed) throws java.io.IOException {
            if (i_renamed < 0 || i_renamed > remaining()) {
                if (i_renamed > 0) {
                    throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
                }
                if (i_renamed == 0) {
                    return com.google.protobuf.Internal.EMPTY_BYTE_ARRAY;
                }
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            byte[] bArr = new byte[i_renamed];
            long j_renamed = this.pos;
            long j2 = i_renamed;
            slice(j_renamed, j_renamed + j2).get(bArr);
            this.pos += j2;
            return bArr;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i_renamed) throws java.io.IOException {
            if (i_renamed >= 0 && i_renamed <= remaining()) {
                this.pos += i_renamed;
            } else {
                if (i_renamed < 0) {
                    throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
                }
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void recomputeBufferSizeAfterLimit() {
            this.limit += this.bufferSizeAfterLimit;
            long j_renamed = this.limit;
            int i_renamed = (int) (j_renamed - this.startPos);
            int i2 = this.currentLimit;
            if (i_renamed > i2) {
                this.bufferSizeAfterLimit = i_renamed - i2;
                this.limit = j_renamed - this.bufferSizeAfterLimit;
            } else {
                this.bufferSizeAfterLimit = 0;
            }
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        private int bufferPos(long j_renamed) {
            return (int) (j_renamed - this.address);
        }

        private java.nio.ByteBuffer slice(long j_renamed, long j2) throws java.io.IOException {
            int iPosition = this.buffer.position();
            int iLimit = this.buffer.limit();
            try {
                try {
                    this.buffer.position(bufferPos(j_renamed));
                    this.buffer.limit(bufferPos(j2));
                    return this.buffer.slice();
                } catch (java.lang.IllegalArgumentException unused) {
                    throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
                }
            } finally {
                this.buffer.position(iPosition);
                this.buffer.limit(iLimit);
            }
        }
    }

    private static final class StreamDecoder extends com.google.protobuf.CodedInputStream {
        private final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final java.io.InputStream input;
        private int lastTag;
        private int pos;
        private com.google.protobuf.CodedInputStream.StreamDecoder.RefillCallback refillCallback;
        private int totalBytesRetired;

        private interface RefillCallback {
            void onRefill();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z_renamed) {
        }

        private StreamDecoder(java.io.InputStream inputStream, int i_renamed) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            com.google.protobuf.Internal.checkNotNull(inputStream, "input");
            this.input = inputStream;
            this.buffer = new byte[i_renamed];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws java.io.IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            this.lastTag = readRawVarint32();
            if (com.google.protobuf.WireFormat.getTagFieldNumber(this.lastTag) == 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.invalidTag();
            }
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i_renamed) throws com.google.protobuf.InvalidProtocolBufferException {
            if (this.lastTag != i_renamed) {
                throw com.google.protobuf.InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i_renamed) throws java.io.IOException {
            int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i_renamed);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(com.google.protobuf.WireFormat.makeTag(com.google.protobuf.WireFormat.getTagFieldNumber(i_renamed), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                skipRawBytes(4);
                return true;
            }
            throw com.google.protobuf.InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i_renamed, com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i_renamed);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                com.google.protobuf.ByteString bytes = readBytes();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i_renamed);
                skipMessage(codedOutputStream);
                int iMakeTag = com.google.protobuf.WireFormat.makeTag(com.google.protobuf.WireFormat.getTagFieldNumber(i_renamed), 4);
                checkLastTagWas(iMakeTag);
                codedOutputStream.writeRawVarint32(iMakeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw com.google.protobuf.InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws java.io.IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, codedOutputStream));
        }

        private class SkippedDataSink implements com.google.protobuf.CodedInputStream.StreamDecoder.RefillCallback {
            private java.io.ByteArrayOutputStream byteArrayStream;
            private int lastPos;

            private SkippedDataSink() {
                this.lastPos = com.google.protobuf.CodedInputStream.StreamDecoder.this.pos;
            }

            @Override // com.google.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void onRefill() {
                if (this.byteArrayStream == null) {
                    this.byteArrayStream = new java.io.ByteArrayOutputStream();
                }
                this.byteArrayStream.write(com.google.protobuf.CodedInputStream.StreamDecoder.this.buffer, this.lastPos, com.google.protobuf.CodedInputStream.StreamDecoder.this.pos - this.lastPos);
                this.lastPos = 0;
            }

            java.nio.ByteBuffer getSkippedData() {
                java.io.ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
                if (byteArrayOutputStream == null) {
                    return java.nio.ByteBuffer.wrap(com.google.protobuf.CodedInputStream.StreamDecoder.this.buffer, this.lastPos, com.google.protobuf.CodedInputStream.StreamDecoder.this.pos - this.lastPos);
                }
                byteArrayOutputStream.write(com.google.protobuf.CodedInputStream.StreamDecoder.this.buffer, this.lastPos, com.google.protobuf.CodedInputStream.StreamDecoder.this.pos);
                return java.nio.ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws java.io.IOException {
            return java.lang.Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws java.io.IOException {
            return java.lang.Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws java.io.IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws java.io.IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws java.io.IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws java.io.IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws java.io.IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws java.io.IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public java.lang.String readString() throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i_renamed = this.bufferSize;
                int i2 = this.pos;
                if (rawVarint32 <= i_renamed - i2) {
                    java.lang.String str = new java.lang.String(this.buffer, i2, rawVarint32, com.google.protobuf.Internal.UTF_8);
                    this.pos += rawVarint32;
                    return str;
                }
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 <= this.bufferSize) {
                refillBuffer(rawVarint32);
                java.lang.String str2 = new java.lang.String(this.buffer, this.pos, rawVarint32, com.google.protobuf.Internal.UTF_8);
                this.pos += rawVarint32;
                return str2;
            }
            return new java.lang.String(readRawBytesSlowPath(rawVarint32, false), com.google.protobuf.Internal.UTF_8);
        }

        @Override // com.google.protobuf.CodedInputStream
        public java.lang.String readStringRequireUtf8() throws java.io.IOException {
            byte[] rawBytesSlowPath;
            int rawVarint32 = readRawVarint32();
            int i_renamed = this.pos;
            int i2 = 0;
            if (rawVarint32 <= this.bufferSize - i_renamed && rawVarint32 > 0) {
                rawBytesSlowPath = this.buffer;
                this.pos = i_renamed + rawVarint32;
                i2 = i_renamed;
            } else {
                if (rawVarint32 == 0) {
                    return "";
                }
                if (rawVarint32 <= this.bufferSize) {
                    refillBuffer(rawVarint32);
                    rawBytesSlowPath = this.buffer;
                    this.pos = rawVarint32 + 0;
                } else {
                    rawBytesSlowPath = readRawBytesSlowPath(rawVarint32, false);
                }
            }
            return com.google.protobuf.Utf8.decodeUtf8(rawBytesSlowPath, i2, rawVarint32);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i_renamed, com.google.protobuf.MessageLite.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(com.google.protobuf.WireFormat.makeTag(i_renamed, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T_renamed extends com.google.protobuf.MessageLite> T_renamed readGroup(int i_renamed, com.google.protobuf.Parser<T_renamed> parser, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            this.recursionDepth++;
            T_renamed partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(com.google.protobuf.WireFormat.makeTag(i_renamed, 4));
            this.recursionDepth--;
            return partialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        @java.lang.Deprecated
        public void readUnknownGroup(int i_renamed, com.google.protobuf.MessageLite.Builder builder) throws java.io.IOException {
            readGroup(i_renamed, builder, com.google.protobuf.ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(com.google.protobuf.MessageLite.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(iPushLimit);
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T_renamed extends com.google.protobuf.MessageLite> T_renamed readMessage(com.google.protobuf.Parser<T_renamed> parser, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            T_renamed partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(iPushLimit);
            return partialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        public com.google.protobuf.ByteString readBytes() throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            int i_renamed = this.bufferSize;
            int i2 = this.pos;
            if (rawVarint32 > i_renamed - i2 || rawVarint32 <= 0) {
                if (rawVarint32 == 0) {
                    return com.google.protobuf.ByteString.EMPTY;
                }
                return readBytesSlowPath(rawVarint32);
            }
            com.google.protobuf.ByteString byteStringCopyFrom = com.google.protobuf.ByteString.copyFrom(this.buffer, i2, rawVarint32);
            this.pos += rawVarint32;
            return byteStringCopyFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            int i_renamed = this.bufferSize;
            int i2 = this.pos;
            if (rawVarint32 <= i_renamed - i2 && rawVarint32 > 0) {
                byte[] bArrCopyOfRange = java.util.Arrays.copyOfRange(this.buffer, i2, i2 + rawVarint32);
                this.pos += rawVarint32;
                return bArrCopyOfRange;
            }
            return readRawBytesSlowPath(rawVarint32, false);
        }

        @Override // com.google.protobuf.CodedInputStream
        public java.nio.ByteBuffer readByteBuffer() throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            int i_renamed = this.bufferSize;
            int i2 = this.pos;
            if (rawVarint32 > i_renamed - i2 || rawVarint32 <= 0) {
                if (rawVarint32 == 0) {
                    return com.google.protobuf.Internal.EMPTY_BYTE_BUFFER;
                }
                return java.nio.ByteBuffer.wrap(readRawBytesSlowPath(rawVarint32, true));
            }
            java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(java.util.Arrays.copyOfRange(this.buffer, i2, i2 + rawVarint32));
            this.pos += rawVarint32;
            return byteBufferWrap;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws java.io.IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws java.io.IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws java.io.IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws java.io.IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws java.io.IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws java.io.IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARN: Code restructure failed: missing block: B_renamed:33:0x0068, code lost:
        
            if (r2[r3] < 0) goto L34;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.pos
                int r1 = r5.bufferSize
                if (r1 != r0) goto L7
                goto L6a
            L7:
                byte[] r2 = r5.buffer
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L12
                r5.pos = r3
                return r0
            L12:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L18
                goto L6a
            L18:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L24
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L70
            L24:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L31
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L2f:
                r1 = r3
                goto L70
            L31:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L3f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L70
            L3f:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r2 = r2[r3]
                if (r2 >= 0) goto L70
            L6a:
                long r0 = r5.readRawVarint64SlowPath()
                int r5 = (int) r0
                return r5
            L70:
                r5.pos = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.StreamDecoder.readRawVarint32():int");
        }

        private void skipRawVarint() throws java.io.IOException {
            if (this.bufferSize - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws java.io.IOException {
            for (int i_renamed = 0; i_renamed < 10; i_renamed++) {
                byte[] bArr = this.buffer;
                int i2 = this.pos;
                this.pos = i2 + 1;
                if (bArr[i2] >= 0) {
                    return;
                }
            }
            throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws java.io.IOException {
            for (int i_renamed = 0; i_renamed < 10; i_renamed++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
        }

        /* JADX WARN: Code restructure failed: missing block: B_renamed:39:0x00b4, code lost:
        
            if (r2[r0] < 0) goto L40;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long readRawVarint64() throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 192
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.StreamDecoder.readRawVarint64():long");
        }

        @Override // com.google.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws java.io.IOException {
            long j_renamed = 0;
            for (int i_renamed = 0; i_renamed < 64; i_renamed += 7) {
                j_renamed |= (r3 & 127) << i_renamed;
                if ((readRawByte() & 128) == 0) {
                    return j_renamed;
                }
            }
            throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws java.io.IOException {
            int i_renamed = this.pos;
            if (this.bufferSize - i_renamed < 4) {
                refillBuffer(4);
                i_renamed = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i_renamed + 4;
            return (bArr[i_renamed] & 255) | ((bArr[i_renamed + 1] & 255) << 8) | ((bArr[i_renamed + 2] & 255) << 16) | ((bArr[i_renamed + 3] & 255) << 24);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws java.io.IOException {
            int i_renamed = this.pos;
            if (this.bufferSize - i_renamed < 8) {
                refillBuffer(8);
                i_renamed = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i_renamed + 8;
            return ((bArr[i_renamed + 7] & 255) << 56) | (bArr[i_renamed] & 255) | ((bArr[i_renamed + 1] & 255) << 8) | ((bArr[i_renamed + 2] & 255) << 16) | ((bArr[i_renamed + 3] & 255) << 24) | ((bArr[i_renamed + 4] & 255) << 32) | ((bArr[i_renamed + 5] & 255) << 40) | ((bArr[i_renamed + 6] & 255) << 48);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i_renamed) throws com.google.protobuf.InvalidProtocolBufferException {
            if (i_renamed < 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            int i2 = i_renamed + this.totalBytesRetired + this.pos;
            int i3 = this.currentLimit;
            if (i2 > i3) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = i2;
            recomputeBufferSizeAfterLimit();
            return i3;
        }

        private void recomputeBufferSizeAfterLimit() {
            this.bufferSize += this.bufferSizeAfterLimit;
            int i_renamed = this.totalBytesRetired;
            int i2 = this.bufferSize;
            int i3 = i_renamed + i2;
            int i4 = this.currentLimit;
            if (i3 > i4) {
                this.bufferSizeAfterLimit = i3 - i4;
                this.bufferSize = i2 - this.bufferSizeAfterLimit;
            } else {
                this.bufferSizeAfterLimit = 0;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i_renamed) {
            this.currentLimit = i_renamed;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i_renamed = this.currentLimit;
            if (i_renamed == Integer.MAX_VALUE) {
                return -1;
            }
            return i_renamed - (this.totalBytesRetired + this.pos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws java.io.IOException {
            return this.pos == this.bufferSize && !tryRefillBuffer(1);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        private void refillBuffer(int i_renamed) throws java.io.IOException {
            if (tryRefillBuffer(i_renamed)) {
                return;
            }
            if (i_renamed > (this.sizeLimit - this.totalBytesRetired) - this.pos) {
                throw com.google.protobuf.InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }

        private boolean tryRefillBuffer(int i_renamed) throws java.io.IOException {
            if (this.pos + i_renamed <= this.bufferSize) {
                throw new java.lang.IllegalStateException("refillBuffer() called when " + i_renamed + " bytes were already available in_renamed buffer");
            }
            int i2 = this.sizeLimit;
            int i3 = this.totalBytesRetired;
            int i4 = this.pos;
            if (i_renamed > (i2 - i3) - i4 || i3 + i4 + i_renamed > this.currentLimit) {
                return false;
            }
            com.google.protobuf.CodedInputStream.StreamDecoder.RefillCallback refillCallback = this.refillCallback;
            if (refillCallback != null) {
                refillCallback.onRefill();
            }
            int i5 = this.pos;
            if (i5 > 0) {
                int i6 = this.bufferSize;
                if (i6 > i5) {
                    byte[] bArr = this.buffer;
                    java.lang.System.arraycopy(bArr, i5, bArr, 0, i6 - i5);
                }
                this.totalBytesRetired += i5;
                this.bufferSize -= i5;
                this.pos = 0;
            }
            java.io.InputStream inputStream = this.input;
            byte[] bArr2 = this.buffer;
            int i7 = this.bufferSize;
            int i8 = inputStream.read(bArr2, i7, java.lang.Math.min(bArr2.length - i7, (this.sizeLimit - this.totalBytesRetired) - this.bufferSize));
            if (i8 == 0 || i8 < -1 || i8 > this.buffer.length) {
                throw new java.lang.IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + i8 + "\nThe InputStream implementation is_renamed buggy.");
            }
            if (i8 <= 0) {
                return false;
            }
            this.bufferSize += i8;
            recomputeBufferSizeAfterLimit();
            if (this.bufferSize >= i_renamed) {
                return true;
            }
            return tryRefillBuffer(i_renamed);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws java.io.IOException {
            if (this.pos == this.bufferSize) {
                refillBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i_renamed = this.pos;
            this.pos = i_renamed + 1;
            return bArr[i_renamed];
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i_renamed) throws java.io.IOException {
            int i2 = this.pos;
            if (i_renamed <= this.bufferSize - i2 && i_renamed > 0) {
                int i3 = i_renamed + i2;
                this.pos = i3;
                return java.util.Arrays.copyOfRange(this.buffer, i2, i3);
            }
            return readRawBytesSlowPath(i_renamed, false);
        }

        private byte[] readRawBytesSlowPath(int i_renamed, boolean z_renamed) throws java.io.IOException {
            byte[] rawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i_renamed);
            if (rawBytesSlowPathOneChunk != null) {
                return z_renamed ? (byte[]) rawBytesSlowPathOneChunk.clone() : rawBytesSlowPathOneChunk;
            }
            int i2 = this.pos;
            int i3 = this.bufferSize;
            int length = i3 - i2;
            this.totalBytesRetired += i3;
            this.pos = 0;
            this.bufferSize = 0;
            java.util.List<byte[]> rawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i_renamed - length);
            byte[] bArr = new byte[i_renamed];
            java.lang.System.arraycopy(this.buffer, i2, bArr, 0, length);
            for (byte[] bArr2 : rawBytesSlowPathRemainingChunks) {
                java.lang.System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        private byte[] readRawBytesSlowPathOneChunk(int i_renamed) throws java.io.IOException {
            if (i_renamed == 0) {
                return com.google.protobuf.Internal.EMPTY_BYTE_ARRAY;
            }
            if (i_renamed < 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            int i2 = this.totalBytesRetired + this.pos + i_renamed;
            if (i2 - this.sizeLimit > 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.sizeLimitExceeded();
            }
            int i3 = this.currentLimit;
            if (i2 > i3) {
                skipRawBytes((i3 - this.totalBytesRetired) - this.pos);
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            int i4 = this.bufferSize - this.pos;
            int i5 = i_renamed - i4;
            if (i5 >= 4096 && i5 > this.input.available()) {
                return null;
            }
            byte[] bArr = new byte[i_renamed];
            java.lang.System.arraycopy(this.buffer, this.pos, bArr, 0, i4);
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
            while (i4 < bArr.length) {
                int i6 = this.input.read(bArr, i4, i_renamed - i4);
                if (i6 == -1) {
                    throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
                }
                this.totalBytesRetired += i6;
                i4 += i6;
            }
            return bArr;
        }

        private java.util.List<byte[]> readRawBytesSlowPathRemainingChunks(int i_renamed) throws java.io.IOException {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            while (i_renamed > 0) {
                byte[] bArr = new byte[java.lang.Math.min(i_renamed, 4096)];
                int i2 = 0;
                while (i2 < bArr.length) {
                    int i3 = this.input.read(bArr, i2, bArr.length - i2);
                    if (i3 == -1) {
                        throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += i3;
                    i2 += i3;
                }
                i_renamed -= bArr.length;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private com.google.protobuf.ByteString readBytesSlowPath(int i_renamed) throws java.io.IOException {
            byte[] rawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i_renamed);
            if (rawBytesSlowPathOneChunk != null) {
                return com.google.protobuf.ByteString.copyFrom(rawBytesSlowPathOneChunk);
            }
            int i2 = this.pos;
            int i3 = this.bufferSize;
            int length = i3 - i2;
            this.totalBytesRetired += i3;
            this.pos = 0;
            this.bufferSize = 0;
            java.util.List<byte[]> rawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i_renamed - length);
            byte[] bArr = new byte[i_renamed];
            java.lang.System.arraycopy(this.buffer, i2, bArr, 0, length);
            for (byte[] bArr2 : rawBytesSlowPathRemainingChunks) {
                java.lang.System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return com.google.protobuf.ByteString.wrap(bArr);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i_renamed) throws java.io.IOException {
            int i2 = this.bufferSize;
            int i3 = this.pos;
            if (i_renamed <= i2 - i3 && i_renamed >= 0) {
                this.pos = i3 + i_renamed;
            } else {
                skipRawBytesSlowPath(i_renamed);
            }
        }

        private void skipRawBytesSlowPath(int i_renamed) throws java.io.IOException {
            if (i_renamed < 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            int i2 = this.totalBytesRetired;
            int i3 = this.pos;
            int i4 = i2 + i3 + i_renamed;
            int i5 = this.currentLimit;
            if (i4 > i5) {
                skipRawBytes((i5 - i2) - i3);
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            int i6 = 0;
            if (this.refillCallback == null) {
                this.totalBytesRetired = i2 + i3;
                int i7 = this.bufferSize - i3;
                this.bufferSize = 0;
                this.pos = 0;
                i6 = i7;
                while (i6 < i_renamed) {
                    try {
                        long j_renamed = i_renamed - i6;
                        long jSkip = this.input.skip(j_renamed);
                        if (jSkip < 0 || jSkip > j_renamed) {
                            throw new java.lang.IllegalStateException(this.input.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is_renamed buggy.");
                        }
                        if (jSkip == 0) {
                            break;
                        } else {
                            i6 += (int) jSkip;
                        }
                    } finally {
                        this.totalBytesRetired += i6;
                        recomputeBufferSizeAfterLimit();
                    }
                }
            }
            if (i6 >= i_renamed) {
                return;
            }
            int i8 = this.bufferSize;
            int i9 = i8 - this.pos;
            this.pos = i8;
            refillBuffer(1);
            while (true) {
                int i10 = i_renamed - i9;
                int i11 = this.bufferSize;
                if (i10 > i11) {
                    i9 += i11;
                    this.pos = i11;
                    refillBuffer(1);
                } else {
                    this.pos = i10;
                    return;
                }
            }
        }
    }

    private static final class IterableDirectByteBufferDecoder extends com.google.protobuf.CodedInputStream {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private java.nio.ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private boolean immutable;
        private java.lang.Iterable<java.nio.ByteBuffer> input;
        private java.util.Iterator<java.nio.ByteBuffer> iterator;
        private int lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        private IterableDirectByteBufferDecoder(java.lang.Iterable<java.nio.ByteBuffer> iterable, int i_renamed, boolean z_renamed) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = i_renamed;
            this.input = iterable;
            this.iterator = this.input.iterator();
            this.immutable = z_renamed;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (i_renamed == 0) {
                this.currentByteBuffer = com.google.protobuf.Internal.EMPTY_BYTE_BUFFER;
                this.currentByteBufferPos = 0L;
                this.currentByteBufferStartPos = 0L;
                this.currentByteBufferLimit = 0L;
                this.currentAddress = 0L;
                return;
            }
            tryGetNextByteBuffer();
        }

        private void getNextByteBuffer() throws com.google.protobuf.InvalidProtocolBufferException {
            if (!this.iterator.hasNext()) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            tryGetNextByteBuffer();
        }

        private void tryGetNextByteBuffer() {
            this.currentByteBuffer = this.iterator.next();
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            this.currentByteBufferPos = this.currentByteBuffer.position();
            this.currentByteBufferStartPos = this.currentByteBufferPos;
            this.currentByteBufferLimit = this.currentByteBuffer.limit();
            this.currentAddress = com.google.protobuf.UnsafeUtil.addressOffset(this.currentByteBuffer);
            long j_renamed = this.currentByteBufferPos;
            long j2 = this.currentAddress;
            this.currentByteBufferPos = j_renamed + j2;
            this.currentByteBufferStartPos += j2;
            this.currentByteBufferLimit += j2;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws java.io.IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            this.lastTag = readRawVarint32();
            if (com.google.protobuf.WireFormat.getTagFieldNumber(this.lastTag) == 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.invalidTag();
            }
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i_renamed) throws com.google.protobuf.InvalidProtocolBufferException {
            if (this.lastTag != i_renamed) {
                throw com.google.protobuf.InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i_renamed) throws java.io.IOException {
            int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i_renamed);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(com.google.protobuf.WireFormat.makeTag(com.google.protobuf.WireFormat.getTagFieldNumber(i_renamed), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                skipRawBytes(4);
                return true;
            }
            throw com.google.protobuf.InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i_renamed, com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i_renamed);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                com.google.protobuf.ByteString bytes = readBytes();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i_renamed);
                skipMessage(codedOutputStream);
                int iMakeTag = com.google.protobuf.WireFormat.makeTag(com.google.protobuf.WireFormat.getTagFieldNumber(i_renamed), 4);
                checkLastTagWas(iMakeTag);
                codedOutputStream.writeRawVarint32(iMakeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(i_renamed);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw com.google.protobuf.InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws java.io.IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws java.io.IOException {
            return java.lang.Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws java.io.IOException {
            return java.lang.Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws java.io.IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws java.io.IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws java.io.IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws java.io.IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws java.io.IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws java.io.IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public java.lang.String readString() throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j_renamed = rawVarint32;
                long j2 = this.currentByteBufferLimit;
                long j3 = this.currentByteBufferPos;
                if (j_renamed <= j2 - j3) {
                    byte[] bArr = new byte[rawVarint32];
                    com.google.protobuf.UnsafeUtil.copyMemory(j3, bArr, 0L, j_renamed);
                    java.lang.String str = new java.lang.String(bArr, com.google.protobuf.Internal.UTF_8);
                    this.currentByteBufferPos += j_renamed;
                    return str;
                }
            }
            if (rawVarint32 > 0 && rawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[rawVarint32];
                readRawBytesTo(bArr2, 0, rawVarint32);
                return new java.lang.String(bArr2, com.google.protobuf.Internal.UTF_8);
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 < 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public java.lang.String readStringRequireUtf8() throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j_renamed = rawVarint32;
                long j2 = this.currentByteBufferLimit;
                long j3 = this.currentByteBufferPos;
                if (j_renamed <= j2 - j3) {
                    java.lang.String strDecodeUtf8 = com.google.protobuf.Utf8.decodeUtf8(this.currentByteBuffer, (int) (j3 - this.currentByteBufferStartPos), rawVarint32);
                    this.currentByteBufferPos += j_renamed;
                    return strDecodeUtf8;
                }
            }
            if (rawVarint32 >= 0 && rawVarint32 <= remaining()) {
                byte[] bArr = new byte[rawVarint32];
                readRawBytesTo(bArr, 0, rawVarint32);
                return com.google.protobuf.Utf8.decodeUtf8(bArr, 0, rawVarint32);
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 <= 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i_renamed, com.google.protobuf.MessageLite.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(com.google.protobuf.WireFormat.makeTag(i_renamed, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T_renamed extends com.google.protobuf.MessageLite> T_renamed readGroup(int i_renamed, com.google.protobuf.Parser<T_renamed> parser, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            this.recursionDepth++;
            T_renamed partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(com.google.protobuf.WireFormat.makeTag(i_renamed, 4));
            this.recursionDepth--;
            return partialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        @java.lang.Deprecated
        public void readUnknownGroup(int i_renamed, com.google.protobuf.MessageLite.Builder builder) throws java.io.IOException {
            readGroup(i_renamed, builder, com.google.protobuf.ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(com.google.protobuf.MessageLite.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(iPushLimit);
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T_renamed extends com.google.protobuf.MessageLite> T_renamed readMessage(com.google.protobuf.Parser<T_renamed> parser, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) {
                throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
            }
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            T_renamed partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(iPushLimit);
            return partialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        public com.google.protobuf.ByteString readBytes() throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j_renamed = rawVarint32;
                long j2 = this.currentByteBufferLimit;
                long j3 = this.currentByteBufferPos;
                if (j_renamed <= j2 - j3) {
                    if (this.immutable && this.enableAliasing) {
                        int i_renamed = (int) (j3 - this.currentAddress);
                        com.google.protobuf.ByteString byteStringWrap = com.google.protobuf.ByteString.wrap(slice(i_renamed, rawVarint32 + i_renamed));
                        this.currentByteBufferPos += j_renamed;
                        return byteStringWrap;
                    }
                    byte[] bArr = new byte[rawVarint32];
                    com.google.protobuf.UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0L, j_renamed);
                    this.currentByteBufferPos += j_renamed;
                    return com.google.protobuf.ByteString.wrap(bArr);
                }
            }
            if (rawVarint32 > 0 && rawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[rawVarint32];
                readRawBytesTo(bArr2, 0, rawVarint32);
                return com.google.protobuf.ByteString.wrap(bArr2);
            }
            if (rawVarint32 == 0) {
                return com.google.protobuf.ByteString.EMPTY;
            }
            if (rawVarint32 < 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws java.io.IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public java.nio.ByteBuffer readByteBuffer() throws java.io.IOException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j_renamed = rawVarint32;
                if (j_renamed <= currentRemaining()) {
                    if (!this.immutable && this.enableAliasing) {
                        this.currentByteBufferPos += j_renamed;
                        long j2 = this.currentByteBufferPos;
                        long j3 = this.currentAddress;
                        return slice((int) ((j2 - j3) - j_renamed), (int) (j2 - j3));
                    }
                    byte[] bArr = new byte[rawVarint32];
                    com.google.protobuf.UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0L, j_renamed);
                    this.currentByteBufferPos += j_renamed;
                    return java.nio.ByteBuffer.wrap(bArr);
                }
            }
            if (rawVarint32 > 0 && rawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[rawVarint32];
                readRawBytesTo(bArr2, 0, rawVarint32);
                return java.nio.ByteBuffer.wrap(bArr2);
            }
            if (rawVarint32 == 0) {
                return com.google.protobuf.Internal.EMPTY_BYTE_BUFFER;
            }
            if (rawVarint32 < 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws java.io.IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws java.io.IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws java.io.IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws java.io.IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws java.io.IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws java.io.IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARN: Code restructure failed: missing block: B_renamed:33:0x0088, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r4) < 0) goto L34;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.currentByteBufferPos
                long r2 = r10.currentByteBufferLimit
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto La
                goto L8a
            La:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r0)
                if (r0 < 0) goto L1a
                long r4 = r10.currentByteBufferPos
                long r4 = r4 + r2
                r10.currentByteBufferPos = r4
                return r0
            L1a:
                long r6 = r10.currentByteBufferLimit
                long r8 = r10.currentByteBufferPos
                long r6 = r6 - r8
                r8 = 10
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L26
                goto L8a
            L26:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L34
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L90
            L34:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L43
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L41:
                r6 = r4
                goto L90
            L43:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L53
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L90
            L53:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L90
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L90
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L90
            L8a:
                long r0 = r10.readRawVarint64SlowPath()
                int r10 = (int) r0
                return r10
            L90:
                r10.currentByteBufferPos = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.readRawVarint32():int");
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() throws java.io.IOException {
            long j_renamed;
            long j2;
            long j3;
            long j4;
            int i_renamed;
            long j5 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j5) {
                long j6 = j5 + 1;
                byte b2 = com.google.protobuf.UnsafeUtil.getByte(j5);
                if (b2 >= 0) {
                    this.currentByteBufferPos++;
                    return b2;
                }
                if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j7 = j6 + 1;
                    int i2 = b2 ^ (com.google.protobuf.UnsafeUtil.getByte(j6) << 7);
                    if (i2 >= 0) {
                        j_renamed = j7 + 1;
                        int i3 = i2 ^ (com.google.protobuf.UnsafeUtil.getByte(j7) << 14);
                        if (i3 >= 0) {
                            j2 = i3 ^ 16256;
                        } else {
                            j7 = j_renamed + 1;
                            int i4 = i3 ^ (com.google.protobuf.UnsafeUtil.getByte(j_renamed) << 21);
                            if (i4 < 0) {
                                i_renamed = i4 ^ (-2080896);
                            } else {
                                j_renamed = j7 + 1;
                                long j8 = i4 ^ (com.google.protobuf.UnsafeUtil.getByte(j7) << 28);
                                if (j8 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    long j9 = j_renamed + 1;
                                    long j10 = j8 ^ (com.google.protobuf.UnsafeUtil.getByte(j_renamed) << 35);
                                    if (j10 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j_renamed = j9 + 1;
                                        j8 = j10 ^ (com.google.protobuf.UnsafeUtil.getByte(j9) << 42);
                                        if (j8 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j9 = j_renamed + 1;
                                            j10 = j8 ^ (com.google.protobuf.UnsafeUtil.getByte(j_renamed) << 49);
                                            if (j10 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                j_renamed = j9 + 1;
                                                j2 = (j10 ^ (com.google.protobuf.UnsafeUtil.getByte(j9) << 56)) ^ 71499008037633920L;
                                                if (j2 < 0) {
                                                    long j11 = 1 + j_renamed;
                                                    if (com.google.protobuf.UnsafeUtil.getByte(j_renamed) >= 0) {
                                                        j_renamed = j11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j2 = j10 ^ j3;
                                    j_renamed = j9;
                                }
                                j2 = j8 ^ j4;
                            }
                        }
                        this.currentByteBufferPos = j_renamed;
                        return j2;
                    }
                    i_renamed = i2 ^ (-128);
                    j2 = i_renamed;
                    j_renamed = j7;
                    this.currentByteBufferPos = j_renamed;
                    return j2;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws java.io.IOException {
            long j_renamed = 0;
            for (int i_renamed = 0; i_renamed < 64; i_renamed += 7) {
                j_renamed |= (r3 & 127) << i_renamed;
                if ((readRawByte() & 128) == 0) {
                    return j_renamed;
                }
            }
            throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws java.io.IOException {
            if (currentRemaining() >= 4) {
                long j_renamed = this.currentByteBufferPos;
                this.currentByteBufferPos = 4 + j_renamed;
                return (com.google.protobuf.UnsafeUtil.getByte(j_renamed) & 255) | ((com.google.protobuf.UnsafeUtil.getByte(1 + j_renamed) & 255) << 8) | ((com.google.protobuf.UnsafeUtil.getByte(2 + j_renamed) & 255) << 16) | ((com.google.protobuf.UnsafeUtil.getByte(j_renamed + 3) & 255) << 24);
            }
            return ((readRawByte() & 255) << 24) | (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws java.io.IOException {
            if (currentRemaining() >= 8) {
                this.currentByteBufferPos = 8 + this.currentByteBufferPos;
                return (com.google.protobuf.UnsafeUtil.getByte(r13) & 255) | ((com.google.protobuf.UnsafeUtil.getByte(1 + r13) & 255) << 8) | ((com.google.protobuf.UnsafeUtil.getByte(2 + r13) & 255) << 16) | ((com.google.protobuf.UnsafeUtil.getByte(3 + r13) & 255) << 24) | ((com.google.protobuf.UnsafeUtil.getByte(4 + r13) & 255) << 32) | ((com.google.protobuf.UnsafeUtil.getByte(5 + r13) & 255) << 40) | ((com.google.protobuf.UnsafeUtil.getByte(6 + r13) & 255) << 48) | ((com.google.protobuf.UnsafeUtil.getByte(r13 + 7) & 255) << 56);
            }
            return ((readRawByte() & 255) << 56) | (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z_renamed) {
            this.enableAliasing = z_renamed;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startOffset = (int) ((this.totalBytesRead + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i_renamed) throws com.google.protobuf.InvalidProtocolBufferException {
            if (i_renamed < 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i_renamed + getTotalBytesRead();
            int i2 = this.currentLimit;
            if (totalBytesRead > i2) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i2;
        }

        private void recomputeBufferSizeAfterLimit() {
            this.totalBufferSize += this.bufferSizeAfterCurrentLimit;
            int i_renamed = this.totalBufferSize;
            int i2 = i_renamed - this.startOffset;
            int i3 = this.currentLimit;
            if (i2 > i3) {
                this.bufferSizeAfterCurrentLimit = i2 - i3;
                this.totalBufferSize = i_renamed - this.bufferSizeAfterCurrentLimit;
            } else {
                this.bufferSizeAfterCurrentLimit = 0;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i_renamed) {
            this.currentLimit = i_renamed;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i_renamed = this.currentLimit;
            if (i_renamed == Integer.MAX_VALUE) {
                return -1;
            }
            return i_renamed - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws java.io.IOException {
            return (((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos == ((long) this.totalBufferSize);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (((this.totalBytesRead - this.startOffset) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws java.io.IOException {
            if (currentRemaining() == 0) {
                getNextByteBuffer();
            }
            long j_renamed = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + j_renamed;
            return com.google.protobuf.UnsafeUtil.getByte(j_renamed);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i_renamed) throws java.io.IOException {
            if (i_renamed >= 0) {
                long j_renamed = i_renamed;
                if (j_renamed <= currentRemaining()) {
                    byte[] bArr = new byte[i_renamed];
                    com.google.protobuf.UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0L, j_renamed);
                    this.currentByteBufferPos += j_renamed;
                    return bArr;
                }
            }
            if (i_renamed >= 0 && i_renamed <= remaining()) {
                byte[] bArr2 = new byte[i_renamed];
                readRawBytesTo(bArr2, 0, i_renamed);
                return bArr2;
            }
            if (i_renamed > 0) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            if (i_renamed == 0) {
                return com.google.protobuf.Internal.EMPTY_BYTE_ARRAY;
            }
            throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
        }

        private void readRawBytesTo(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            if (i2 < 0 || i2 > remaining()) {
                if (i2 > 0) {
                    throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
                }
                if (i2 != 0) {
                    throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
                }
                return;
            }
            int i3 = i2;
            while (i3 > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int iMin = java.lang.Math.min(i3, (int) currentRemaining());
                long j_renamed = iMin;
                com.google.protobuf.UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, (i2 - i3) + i_renamed, j_renamed);
                i3 -= iMin;
                this.currentByteBufferPos += j_renamed;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i_renamed) throws java.io.IOException {
            if (i_renamed < 0 || i_renamed > ((this.totalBufferSize - this.totalBytesRead) - this.currentByteBufferPos) + this.currentByteBufferStartPos) {
                if (i_renamed < 0) {
                    throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
                }
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            while (i_renamed > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int iMin = java.lang.Math.min(i_renamed, (int) currentRemaining());
                i_renamed -= iMin;
                this.currentByteBufferPos += iMin;
            }
        }

        private void skipRawVarint() throws java.io.IOException {
            for (int i_renamed = 0; i_renamed < 10; i_renamed++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
        }

        private int remaining() {
            return (int) (((this.totalBufferSize - this.totalBytesRead) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private java.nio.ByteBuffer slice(int i_renamed, int i2) throws java.io.IOException {
            int iPosition = this.currentByteBuffer.position();
            int iLimit = this.currentByteBuffer.limit();
            try {
                try {
                    this.currentByteBuffer.position(i_renamed);
                    this.currentByteBuffer.limit(i2);
                    return this.currentByteBuffer.slice();
                } catch (java.lang.IllegalArgumentException unused) {
                    throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
                }
            } finally {
                this.currentByteBuffer.position(iPosition);
                this.currentByteBuffer.limit(iLimit);
            }
        }
    }
}
