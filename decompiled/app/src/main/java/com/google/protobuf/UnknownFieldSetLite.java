package com.google.protobuf;

import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class UnknownFieldSetLite {
    private static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    private static final int MIN_CAPACITY = 8;
    private int count;
    private boolean isMutable;
    private int memoizedSerializedSize;
    private Object[] objects;
    private int[] tags;

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    static UnknownFieldSetLite newInstance() {
        return new UnknownFieldSetLite();
    }

    static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int OplusGLSurfaceView_13 = unknownFieldSetLite.count + unknownFieldSetLite2.count;
        int[] iArrCopyOf = Arrays.copyOf(unknownFieldSetLite.tags, OplusGLSurfaceView_13);
        System.arraycopy(unknownFieldSetLite2.tags, 0, iArrCopyOf, unknownFieldSetLite.count, unknownFieldSetLite2.count);
        Object[] objArrCopyOf = Arrays.copyOf(unknownFieldSetLite.objects, OplusGLSurfaceView_13);
        System.arraycopy(unknownFieldSetLite2.objects, 0, objArrCopyOf, unknownFieldSetLite.count, unknownFieldSetLite2.count);
        return new UnknownFieldSetLite(OplusGLSurfaceView_13, iArrCopyOf, objArrCopyOf, true);
    }

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private UnknownFieldSetLite(int OplusGLSurfaceView_13, int[] iArr, Object[] objArr, boolean z) {
        this.memoizedSerializedSize = -1;
        this.count = OplusGLSurfaceView_13;
        this.tags = iArr;
        this.objects = objArr;
        this.isMutable = z;
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    void checkMutable() {
        if (!this.isMutable) {
            throw new UnsupportedOperationException();
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.count; OplusGLSurfaceView_13++) {
            int i2 = this.tags[OplusGLSurfaceView_13];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i2);
            int tagWireType = WireFormat.getTagWireType(i2);
            if (tagWireType == 0) {
                codedOutputStream.writeUInt64(tagFieldNumber, ((Long) this.objects[OplusGLSurfaceView_13]).longValue());
            } else if (tagWireType == 1) {
                codedOutputStream.writeFixed64(tagFieldNumber, ((Long) this.objects[OplusGLSurfaceView_13]).longValue());
            } else if (tagWireType == 2) {
                codedOutputStream.writeBytes(tagFieldNumber, (ByteString) this.objects[OplusGLSurfaceView_13]);
            } else if (tagWireType == 3) {
                codedOutputStream.writeTag(tagFieldNumber, 3);
                ((UnknownFieldSetLite) this.objects[OplusGLSurfaceView_13]).writeTo(codedOutputStream);
                codedOutputStream.writeTag(tagFieldNumber, 4);
            } else if (tagWireType == 5) {
                codedOutputStream.writeFixed32(tagFieldNumber, ((Integer) this.objects[OplusGLSurfaceView_13]).intValue());
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.count; OplusGLSurfaceView_13++) {
            codedOutputStream.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.tags[OplusGLSurfaceView_13]), (ByteString) this.objects[OplusGLSurfaceView_13]);
        }
    }

    void writeAsMessageSetTo(Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (int OplusGLSurfaceView_13 = this.count - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
                writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[OplusGLSurfaceView_13]), this.objects[OplusGLSurfaceView_13]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[i2]), this.objects[i2]);
        }
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.count == 0) {
            return;
        }
        if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.count; OplusGLSurfaceView_13++) {
                writeField(this.tags[OplusGLSurfaceView_13], this.objects[OplusGLSurfaceView_13], writer);
            }
            return;
        }
        for (int i2 = this.count - 1; i2 >= 0; i2--) {
            writeField(this.tags[i2], this.objects[i2], writer);
        }
    }

    private static void writeField(int OplusGLSurfaceView_13, Object obj, Writer writer) throws IOException {
        int tagFieldNumber = WireFormat.getTagFieldNumber(OplusGLSurfaceView_13);
        int tagWireType = WireFormat.getTagWireType(OplusGLSurfaceView_13);
        if (tagWireType == 0) {
            writer.writeInt64(tagFieldNumber, ((Long) obj).longValue());
            return;
        }
        if (tagWireType == 1) {
            writer.writeFixed64(tagFieldNumber, ((Long) obj).longValue());
            return;
        }
        if (tagWireType == 2) {
            writer.writeBytes(tagFieldNumber, (ByteString) obj);
            return;
        }
        if (tagWireType != 3) {
            if (tagWireType == 5) {
                writer.writeFixed32(tagFieldNumber, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
        }
        if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            writer.writeStartGroup(tagFieldNumber);
            ((UnknownFieldSetLite) obj).writeTo(writer);
            writer.writeEndGroup(tagFieldNumber);
        } else {
            writer.writeEndGroup(tagFieldNumber);
            ((UnknownFieldSetLite) obj).writeTo(writer);
            writer.writeStartGroup(tagFieldNumber);
        }
    }

    public int getSerializedSizeAsMessageSet() {
        int OplusGLSurfaceView_13 = this.memoizedSerializedSize;
        if (OplusGLSurfaceView_13 != -1) {
            return OplusGLSurfaceView_13;
        }
        int iComputeRawMessageSetExtensionSize = 0;
        for (int i2 = 0; i2 < this.count; i2++) {
            iComputeRawMessageSetExtensionSize += CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.tags[i2]), (ByteString) this.objects[i2]);
        }
        this.memoizedSerializedSize = iComputeRawMessageSetExtensionSize;
        return iComputeRawMessageSetExtensionSize;
    }

    public int getSerializedSize() {
        int iComputeUInt64Size;
        int OplusGLSurfaceView_13 = this.memoizedSerializedSize;
        if (OplusGLSurfaceView_13 != -1) {
            return OplusGLSurfaceView_13;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            int i4 = this.tags[i3];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i4);
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                iComputeUInt64Size = CodedOutputStream.computeUInt64Size(tagFieldNumber, ((Long) this.objects[i3]).longValue());
            } else if (tagWireType == 1) {
                iComputeUInt64Size = CodedOutputStream.computeFixed64Size(tagFieldNumber, ((Long) this.objects[i3]).longValue());
            } else if (tagWireType == 2) {
                iComputeUInt64Size = CodedOutputStream.computeBytesSize(tagFieldNumber, (ByteString) this.objects[i3]);
            } else if (tagWireType == 3) {
                iComputeUInt64Size = (CodedOutputStream.computeTagSize(tagFieldNumber) * 2) + ((UnknownFieldSetLite) this.objects[i3]).getSerializedSize();
            } else if (tagWireType == 5) {
                iComputeUInt64Size = CodedOutputStream.computeFixed32Size(tagFieldNumber, ((Integer) this.objects[i3]).intValue());
            } else {
                throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
            }
            i2 += iComputeUInt64Size;
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    private static boolean equals(int[] iArr, int[] iArr2, int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static boolean equals(Object[] objArr, Object[] objArr2, int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            if (!objArr[i2].equals(objArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int OplusGLSurfaceView_13 = this.count;
        return OplusGLSurfaceView_13 == unknownFieldSetLite.count && equals(this.tags, unknownFieldSetLite.tags, OplusGLSurfaceView_13) && equals(this.objects, unknownFieldSetLite.objects, this.count);
    }

    private static int hashCode(int[] iArr, int OplusGLSurfaceView_13) {
        int i2 = 17;
        for (int i3 = 0; i3 < OplusGLSurfaceView_13; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        return i2;
    }

    private static int hashCode(Object[] objArr, int OplusGLSurfaceView_13) {
        int iHashCode = 17;
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            iHashCode = (iHashCode * 31) + objArr[i2].hashCode();
        }
        return iHashCode;
    }

    public int hashCode() {
        int OplusGLSurfaceView_13 = this.count;
        return ((((527 + OplusGLSurfaceView_13) * 31) + hashCode(this.tags, OplusGLSurfaceView_13)) * 31) + hashCode(this.objects, this.count);
    }

    final void printWithIndent(StringBuilder sb, int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < this.count; i2++) {
            MessageLiteToString.printField(sb, OplusGLSurfaceView_13, String.valueOf(WireFormat.getTagFieldNumber(this.tags[i2])), this.objects[i2]);
        }
    }

    void storeField(int OplusGLSurfaceView_13, Object obj) {
        checkMutable();
        ensureCapacity();
        int[] iArr = this.tags;
        int i2 = this.count;
        iArr[i2] = OplusGLSurfaceView_13;
        this.objects[i2] = obj;
        this.count = i2 + 1;
    }

    private void ensureCapacity() {
        int OplusGLSurfaceView_13 = this.count;
        if (OplusGLSurfaceView_13 == this.tags.length) {
            int i2 = this.count + (OplusGLSurfaceView_13 < 4 ? 8 : OplusGLSurfaceView_13 >> 1);
            this.tags = Arrays.copyOf(this.tags, i2);
            this.objects = Arrays.copyOf(this.objects, i2);
        }
    }

    boolean mergeFieldFrom(int OplusGLSurfaceView_13, CodedInputStream codedInputStream) throws IOException {
        checkMutable();
        int tagFieldNumber = WireFormat.getTagFieldNumber(OplusGLSurfaceView_13);
        int tagWireType = WireFormat.getTagWireType(OplusGLSurfaceView_13);
        if (tagWireType == 0) {
            storeField(OplusGLSurfaceView_13, Long.valueOf(codedInputStream.readInt64()));
            return true;
        }
        if (tagWireType == 1) {
            storeField(OplusGLSurfaceView_13, Long.valueOf(codedInputStream.readFixed64()));
            return true;
        }
        if (tagWireType == 2) {
            storeField(OplusGLSurfaceView_13, codedInputStream.readBytes());
            return true;
        }
        if (tagWireType == 3) {
            UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
            unknownFieldSetLite.mergeFrom(codedInputStream);
            codedInputStream.checkLastTagWas(WireFormat.makeTag(tagFieldNumber, 4));
            storeField(OplusGLSurfaceView_13, unknownFieldSetLite);
            return true;
        }
        if (tagWireType == 4) {
            return false;
        }
        if (tagWireType == 5) {
            storeField(OplusGLSurfaceView_13, Integer.valueOf(codedInputStream.readFixed32()));
            return true;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    UnknownFieldSetLite mergeVarintField(int OplusGLSurfaceView_13, int i2) {
        checkMutable();
        if (OplusGLSurfaceView_13 == 0) {
            throw new IllegalArgumentException("Zero is not PlatformImplementations.kt_3 valid field number.");
        }
        storeField(WireFormat.makeTag(OplusGLSurfaceView_13, 0), Long.valueOf(i2));
        return this;
    }

    UnknownFieldSetLite mergeLengthDelimitedField(int OplusGLSurfaceView_13, ByteString byteString) {
        checkMutable();
        if (OplusGLSurfaceView_13 == 0) {
            throw new IllegalArgumentException("Zero is not PlatformImplementations.kt_3 valid field number.");
        }
        storeField(WireFormat.makeTag(OplusGLSurfaceView_13, 2), byteString);
        return this;
    }

    private UnknownFieldSetLite mergeFrom(CodedInputStream codedInputStream) throws IOException {
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
