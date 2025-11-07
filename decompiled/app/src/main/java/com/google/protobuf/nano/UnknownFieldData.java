package com.google.protobuf.nano;

/* loaded from: classes.dex */
final class UnknownFieldData {
    final byte[] bytes;
    final int tag;

    UnknownFieldData(int i_renamed, byte[] bArr) {
        this.tag = i_renamed;
        this.bytes = bArr;
    }

    int computeSerializedSize() {
        return com.google.protobuf.nano.CodedOutputByteBufferNano.computeRawVarint32Size(this.tag) + 0 + this.bytes.length;
    }

    void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException {
        codedOutputByteBufferNano.writeRawVarint32(this.tag);
        codedOutputByteBufferNano.writeRawBytes(this.bytes);
    }

    int computeSerializedSizeAsMessageSet() {
        return com.google.protobuf.nano.CodedOutputByteBufferNano.computeRawMessageSetExtensionSize(this.tag, this.bytes);
    }

    void writeAsMessageSetTo(com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException {
        codedOutputByteBufferNano.writeRawMessageSetExtension(this.tag, this.bytes);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.nano.UnknownFieldData)) {
            return false;
        }
        com.google.protobuf.nano.UnknownFieldData unknownFieldData = (com.google.protobuf.nano.UnknownFieldData) obj;
        return this.tag == unknownFieldData.tag && java.util.Arrays.equals(this.bytes, unknownFieldData.bytes);
    }

    public int hashCode() {
        return ((527 + this.tag) * 31) + java.util.Arrays.hashCode(this.bytes);
    }
}
