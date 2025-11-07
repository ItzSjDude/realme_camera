package com.google.protobuf;

/* loaded from: classes.dex */
public final class UnknownFieldSetLite {
    private static final com.google.protobuf.UnknownFieldSetLite DEFAULT_INSTANCE = new com.google.protobuf.UnknownFieldSetLite(0, new int[0], new java.lang.Object[0], false);
    private static final int MIN_CAPACITY = 8;
    private int count;
    private boolean isMutable;
    private int memoizedSerializedSize;
    private java.lang.Object[] objects;
    private int[] tags;

    public static com.google.protobuf.UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    static com.google.protobuf.UnknownFieldSetLite newInstance() {
        return new com.google.protobuf.UnknownFieldSetLite();
    }

    static com.google.protobuf.UnknownFieldSetLite mutableCopyOf(com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite, com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite2) {
        int i_renamed = unknownFieldSetLite.count + unknownFieldSetLite2.count;
        int[] iArrCopyOf = java.util.Arrays.copyOf(unknownFieldSetLite.tags, i_renamed);
        java.lang.System.arraycopy(unknownFieldSetLite2.tags, 0, iArrCopyOf, unknownFieldSetLite.count, unknownFieldSetLite2.count);
        java.lang.Object[] objArrCopyOf = java.util.Arrays.copyOf(unknownFieldSetLite.objects, i_renamed);
        java.lang.System.arraycopy(unknownFieldSetLite2.objects, 0, objArrCopyOf, unknownFieldSetLite.count, unknownFieldSetLite2.count);
        return new com.google.protobuf.UnknownFieldSetLite(i_renamed, iArrCopyOf, objArrCopyOf, true);
    }

    private UnknownFieldSetLite() {
        this(0, new int[8], new java.lang.Object[8], true);
    }

    private UnknownFieldSetLite(int i_renamed, int[] iArr, java.lang.Object[] objArr, boolean z_renamed) {
        this.memoizedSerializedSize = -1;
        this.count = i_renamed;
        this.tags = iArr;
        this.objects = objArr;
        this.isMutable = z_renamed;
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    void checkMutable() {
        if (!this.isMutable) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
        for (int i_renamed = 0; i_renamed < this.count; i_renamed++) {
            int i2 = this.tags[i_renamed];
            int tagFieldNumber = com.google.protobuf.WireFormat.getTagFieldNumber(i2);
            int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i2);
            if (tagWireType == 0) {
                codedOutputStream.writeUInt64(tagFieldNumber, ((java.lang.Long) this.objects[i_renamed]).longValue());
            } else if (tagWireType == 1) {
                codedOutputStream.writeFixed64(tagFieldNumber, ((java.lang.Long) this.objects[i_renamed]).longValue());
            } else if (tagWireType == 2) {
                codedOutputStream.writeBytes(tagFieldNumber, (com.google.protobuf.ByteString) this.objects[i_renamed]);
            } else if (tagWireType == 3) {
                codedOutputStream.writeTag(tagFieldNumber, 3);
                ((com.google.protobuf.UnknownFieldSetLite) this.objects[i_renamed]).writeTo(codedOutputStream);
                codedOutputStream.writeTag(tagFieldNumber, 4);
            } else if (tagWireType == 5) {
                codedOutputStream.writeFixed32(tagFieldNumber, ((java.lang.Integer) this.objects[i_renamed]).intValue());
            } else {
                throw com.google.protobuf.InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public void writeAsMessageSetTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
        for (int i_renamed = 0; i_renamed < this.count; i_renamed++) {
            codedOutputStream.writeRawMessageSetExtension(com.google.protobuf.WireFormat.getTagFieldNumber(this.tags[i_renamed]), (com.google.protobuf.ByteString) this.objects[i_renamed]);
        }
    }

    void writeAsMessageSetTo(com.google.protobuf.Writer writer) throws java.io.IOException {
        if (writer.fieldOrder() == com.google.protobuf.Writer.FieldOrder.DESCENDING) {
            for (int i_renamed = this.count - 1; i_renamed >= 0; i_renamed--) {
                writer.writeMessageSetItem(com.google.protobuf.WireFormat.getTagFieldNumber(this.tags[i_renamed]), this.objects[i_renamed]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            writer.writeMessageSetItem(com.google.protobuf.WireFormat.getTagFieldNumber(this.tags[i2]), this.objects[i2]);
        }
    }

    public void writeTo(com.google.protobuf.Writer writer) throws java.io.IOException {
        if (this.count == 0) {
            return;
        }
        if (writer.fieldOrder() == com.google.protobuf.Writer.FieldOrder.ASCENDING) {
            for (int i_renamed = 0; i_renamed < this.count; i_renamed++) {
                writeField(this.tags[i_renamed], this.objects[i_renamed], writer);
            }
            return;
        }
        for (int i2 = this.count - 1; i2 >= 0; i2--) {
            writeField(this.tags[i2], this.objects[i2], writer);
        }
    }

    private static void writeField(int i_renamed, java.lang.Object obj, com.google.protobuf.Writer writer) throws java.io.IOException {
        int tagFieldNumber = com.google.protobuf.WireFormat.getTagFieldNumber(i_renamed);
        int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i_renamed);
        if (tagWireType == 0) {
            writer.writeInt64(tagFieldNumber, ((java.lang.Long) obj).longValue());
            return;
        }
        if (tagWireType == 1) {
            writer.writeFixed64(tagFieldNumber, ((java.lang.Long) obj).longValue());
            return;
        }
        if (tagWireType == 2) {
            writer.writeBytes(tagFieldNumber, (com.google.protobuf.ByteString) obj);
            return;
        }
        if (tagWireType != 3) {
            if (tagWireType == 5) {
                writer.writeFixed32(tagFieldNumber, ((java.lang.Integer) obj).intValue());
                return;
            }
            throw new java.lang.RuntimeException(com.google.protobuf.InvalidProtocolBufferException.invalidWireType());
        }
        if (writer.fieldOrder() == com.google.protobuf.Writer.FieldOrder.ASCENDING) {
            writer.writeStartGroup(tagFieldNumber);
            ((com.google.protobuf.UnknownFieldSetLite) obj).writeTo(writer);
            writer.writeEndGroup(tagFieldNumber);
        } else {
            writer.writeEndGroup(tagFieldNumber);
            ((com.google.protobuf.UnknownFieldSetLite) obj).writeTo(writer);
            writer.writeStartGroup(tagFieldNumber);
        }
    }

    public int getSerializedSizeAsMessageSet() {
        int i_renamed = this.memoizedSerializedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int iComputeRawMessageSetExtensionSize = 0;
        for (int i2 = 0; i2 < this.count; i2++) {
            iComputeRawMessageSetExtensionSize += com.google.protobuf.CodedOutputStream.computeRawMessageSetExtensionSize(com.google.protobuf.WireFormat.getTagFieldNumber(this.tags[i2]), (com.google.protobuf.ByteString) this.objects[i2]);
        }
        this.memoizedSerializedSize = iComputeRawMessageSetExtensionSize;
        return iComputeRawMessageSetExtensionSize;
    }

    public int getSerializedSize() {
        int iComputeUInt64Size;
        int i_renamed = this.memoizedSerializedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            int i4 = this.tags[i3];
            int tagFieldNumber = com.google.protobuf.WireFormat.getTagFieldNumber(i4);
            int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                iComputeUInt64Size = com.google.protobuf.CodedOutputStream.computeUInt64Size(tagFieldNumber, ((java.lang.Long) this.objects[i3]).longValue());
            } else if (tagWireType == 1) {
                iComputeUInt64Size = com.google.protobuf.CodedOutputStream.computeFixed64Size(tagFieldNumber, ((java.lang.Long) this.objects[i3]).longValue());
            } else if (tagWireType == 2) {
                iComputeUInt64Size = com.google.protobuf.CodedOutputStream.computeBytesSize(tagFieldNumber, (com.google.protobuf.ByteString) this.objects[i3]);
            } else if (tagWireType == 3) {
                iComputeUInt64Size = (com.google.protobuf.CodedOutputStream.computeTagSize(tagFieldNumber) * 2) + ((com.google.protobuf.UnknownFieldSetLite) this.objects[i3]).getSerializedSize();
            } else if (tagWireType == 5) {
                iComputeUInt64Size = com.google.protobuf.CodedOutputStream.computeFixed32Size(tagFieldNumber, ((java.lang.Integer) this.objects[i3]).intValue());
            } else {
                throw new java.lang.IllegalStateException(com.google.protobuf.InvalidProtocolBufferException.invalidWireType());
            }
            i2 += iComputeUInt64Size;
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    private static boolean equals(int[] iArr, int[] iArr2, int i_renamed) {
        for (int i2 = 0; i2 < i_renamed; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static boolean equals(java.lang.Object[] objArr, java.lang.Object[] objArr2, int i_renamed) {
        for (int i2 = 0; i2 < i_renamed; i2++) {
            if (!objArr[i2].equals(objArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof com.google.protobuf.UnknownFieldSetLite)) {
            return false;
        }
        com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite = (com.google.protobuf.UnknownFieldSetLite) obj;
        int i_renamed = this.count;
        return i_renamed == unknownFieldSetLite.count && equals(this.tags, unknownFieldSetLite.tags, i_renamed) && equals(this.objects, unknownFieldSetLite.objects, this.count);
    }

    private static int hashCode(int[] iArr, int i_renamed) {
        int i2 = 17;
        for (int i3 = 0; i3 < i_renamed; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        return i2;
    }

    private static int hashCode(java.lang.Object[] objArr, int i_renamed) {
        int iHashCode = 17;
        for (int i2 = 0; i2 < i_renamed; i2++) {
            iHashCode = (iHashCode * 31) + objArr[i2].hashCode();
        }
        return iHashCode;
    }

    public int hashCode() {
        int i_renamed = this.count;
        return ((((527 + i_renamed) * 31) + hashCode(this.tags, i_renamed)) * 31) + hashCode(this.objects, this.count);
    }

    final void printWithIndent(java.lang.StringBuilder sb, int i_renamed) {
        for (int i2 = 0; i2 < this.count; i2++) {
            com.google.protobuf.MessageLiteToString.printField(sb, i_renamed, java.lang.String.valueOf(com.google.protobuf.WireFormat.getTagFieldNumber(this.tags[i2])), this.objects[i2]);
        }
    }

    void storeField(int i_renamed, java.lang.Object obj) {
        checkMutable();
        ensureCapacity();
        int[] iArr = this.tags;
        int i2 = this.count;
        iArr[i2] = i_renamed;
        this.objects[i2] = obj;
        this.count = i2 + 1;
    }

    private void ensureCapacity() {
        int i_renamed = this.count;
        if (i_renamed == this.tags.length) {
            int i2 = this.count + (i_renamed < 4 ? 8 : i_renamed >> 1);
            this.tags = java.util.Arrays.copyOf(this.tags, i2);
            this.objects = java.util.Arrays.copyOf(this.objects, i2);
        }
    }

    boolean mergeFieldFrom(int i_renamed, com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        checkMutable();
        int tagFieldNumber = com.google.protobuf.WireFormat.getTagFieldNumber(i_renamed);
        int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i_renamed);
        if (tagWireType == 0) {
            storeField(i_renamed, java.lang.Long.valueOf(codedInputStream.readInt64()));
            return true;
        }
        if (tagWireType == 1) {
            storeField(i_renamed, java.lang.Long.valueOf(codedInputStream.readFixed64()));
            return true;
        }
        if (tagWireType == 2) {
            storeField(i_renamed, codedInputStream.readBytes());
            return true;
        }
        if (tagWireType == 3) {
            com.google.protobuf.UnknownFieldSetLite unknownFieldSetLite = new com.google.protobuf.UnknownFieldSetLite();
            unknownFieldSetLite.mergeFrom(codedInputStream);
            codedInputStream.checkLastTagWas(com.google.protobuf.WireFormat.makeTag(tagFieldNumber, 4));
            storeField(i_renamed, unknownFieldSetLite);
            return true;
        }
        if (tagWireType == 4) {
            return false;
        }
        if (tagWireType == 5) {
            storeField(i_renamed, java.lang.Integer.valueOf(codedInputStream.readFixed32()));
            return true;
        }
        throw com.google.protobuf.InvalidProtocolBufferException.invalidWireType();
    }

    com.google.protobuf.UnknownFieldSetLite mergeVarintField(int i_renamed, int i2) {
        checkMutable();
        if (i_renamed == 0) {
            throw new java.lang.IllegalArgumentException("Zero is_renamed not a_renamed valid field number.");
        }
        storeField(com.google.protobuf.WireFormat.makeTag(i_renamed, 0), java.lang.Long.valueOf(i2));
        return this;
    }

    com.google.protobuf.UnknownFieldSetLite mergeLengthDelimitedField(int i_renamed, com.google.protobuf.ByteString byteString) {
        checkMutable();
        if (i_renamed == 0) {
            throw new java.lang.IllegalArgumentException("Zero is_renamed not a_renamed valid field number.");
        }
        storeField(com.google.protobuf.WireFormat.makeTag(i_renamed, 2), byteString);
        return this;
    }

    private com.google.protobuf.UnknownFieldSetLite mergeFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        int tag;
        do {
            tag = codedInputStream.readTag();
            if (tag == 0) {
                break;
            }
        } while (mergeFieldFrom(tag, codedInputStream));
        return this;
    }
}
