package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        if (codedOutputStream.wrapper != null) {
            return codedOutputStream.wrapper;
        }
        return new CodedOutputStreamWriter(codedOutputStream);
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        this.output = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, "output");
        this.output.wrapper = this;
    }

    @Override // com.google.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32(int OplusGLSurfaceView_13, int i2) throws IOException {
        this.output.writeSFixed32(OplusGLSurfaceView_13, i2);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        this.output.writeInt64(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        this.output.writeSFixed64(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    @Override // com.google.protobuf.Writer
    public void writeFloat(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) throws IOException {
        this.output.writeFloat(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
    }

    @Override // com.google.protobuf.Writer
    public void writeDouble(int OplusGLSurfaceView_13, double IntrinsicsJvm.kt_5) throws IOException {
        this.output.writeDouble(OplusGLSurfaceView_13, IntrinsicsJvm.kt_5);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnum(int OplusGLSurfaceView_13, int i2) throws IOException {
        this.output.writeEnum(OplusGLSurfaceView_13, i2);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        this.output.writeUInt64(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
        this.output.writeInt32(OplusGLSurfaceView_13, i2);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        this.output.writeFixed64(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32(int OplusGLSurfaceView_13, int i2) throws IOException {
        this.output.writeFixed32(OplusGLSurfaceView_13, i2);
    }

    @Override // com.google.protobuf.Writer
    public void writeBool(int OplusGLSurfaceView_13, boolean z) throws IOException {
        this.output.writeBool(OplusGLSurfaceView_13, z);
    }

    @Override // com.google.protobuf.Writer
    public void writeString(int OplusGLSurfaceView_13, String str) throws IOException {
        this.output.writeString(OplusGLSurfaceView_13, str);
    }

    @Override // com.google.protobuf.Writer
    public void writeBytes(int OplusGLSurfaceView_13, ByteString byteString) throws IOException {
        this.output.writeBytes(OplusGLSurfaceView_13, byteString);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
        this.output.writeUInt32(OplusGLSurfaceView_13, i2);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
        this.output.writeSInt32(OplusGLSurfaceView_13, i2);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        this.output.writeSInt64(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int OplusGLSurfaceView_13, Object obj) throws IOException {
        this.output.writeMessage(OplusGLSurfaceView_13, (MessageLite) obj);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int OplusGLSurfaceView_13, Object obj, Schema schema) throws IOException {
        this.output.writeMessage(OplusGLSurfaceView_13, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void writeGroup(int OplusGLSurfaceView_13, Object obj) throws IOException {
        this.output.writeGroup(OplusGLSurfaceView_13, (MessageLite) obj);
    }

    @Override // com.google.protobuf.Writer
    public void writeGroup(int OplusGLSurfaceView_13, Object obj, Schema schema) throws IOException {
        this.output.writeGroup(OplusGLSurfaceView_13, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void writeStartGroup(int OplusGLSurfaceView_13) throws IOException {
        this.output.writeTag(OplusGLSurfaceView_13, 3);
    }

    @Override // com.google.protobuf.Writer
    public void writeEndGroup(int OplusGLSurfaceView_13) throws IOException {
        this.output.writeTag(OplusGLSurfaceView_13, 4);
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int OplusGLSurfaceView_13, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.output.writeRawMessageSetExtension(OplusGLSurfaceView_13, (ByteString) obj);
        } else {
            this.output.writeMessageSetExtension(OplusGLSurfaceView_13, (MessageLite) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            int iComputeInt32SizeNoTag = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(list.get(i3).intValue());
            }
            this.output.writeUInt32NoTag(iComputeInt32SizeNoTag);
            while (i2 < list.size()) {
                this.output.writeInt32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeInt32(OplusGLSurfaceView_13, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            int iComputeFixed32SizeNoTag = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iComputeFixed32SizeNoTag += CodedOutputStream.computeFixed32SizeNoTag(list.get(i3).intValue());
            }
            this.output.writeUInt32NoTag(iComputeFixed32SizeNoTag);
            while (i2 < list.size()) {
                this.output.writeFixed32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeFixed32(OplusGLSurfaceView_13, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            int iComputeInt64SizeNoTag = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(list.get(i3).longValue());
            }
            this.output.writeUInt32NoTag(iComputeInt64SizeNoTag);
            while (i2 < list.size()) {
                this.output.writeInt64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeInt64(OplusGLSurfaceView_13, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            int iComputeUInt64SizeNoTag = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(list.get(i3).longValue());
            }
            this.output.writeUInt32NoTag(iComputeUInt64SizeNoTag);
            while (i2 < list.size()) {
                this.output.writeUInt64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeUInt64(OplusGLSurfaceView_13, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            int iComputeFixed64SizeNoTag = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iComputeFixed64SizeNoTag += CodedOutputStream.computeFixed64SizeNoTag(list.get(i3).longValue());
            }
            this.output.writeUInt32NoTag(iComputeFixed64SizeNoTag);
            while (i2 < list.size()) {
                this.output.writeFixed64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeFixed64(OplusGLSurfaceView_13, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFloatList(int OplusGLSurfaceView_13, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            int iComputeFloatSizeNoTag = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iComputeFloatSizeNoTag += CodedOutputStream.computeFloatSizeNoTag(list.get(i3).floatValue());
            }
            this.output.writeUInt32NoTag(iComputeFloatSizeNoTag);
            while (i2 < list.size()) {
                this.output.writeFloatNoTag(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeFloat(OplusGLSurfaceView_13, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeDoubleList(int OplusGLSurfaceView_13, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            int iComputeDoubleSizeNoTag = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iComputeDoubleSizeNoTag += CodedOutputStream.computeDoubleSizeNoTag(list.get(i3).doubleValue());
            }
            this.output.writeUInt32NoTag(iComputeDoubleSizeNoTag);
            while (i2 < list.size()) {
                this.output.writeDoubleNoTag(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeDouble(OplusGLSurfaceView_13, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeEnumList(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            int iComputeEnumSizeNoTag = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(list.get(i3).intValue());
            }
            this.output.writeUInt32NoTag(iComputeEnumSizeNoTag);
            while (i2 < list.size()) {
                this.output.writeEnumNoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeEnum(OplusGLSurfaceView_13, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeBoolList(int OplusGLSurfaceView_13, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            int iComputeBoolSizeNoTag = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iComputeBoolSizeNoTag += CodedOutputStream.computeBoolSizeNoTag(list.get(i3).booleanValue());
            }
            this.output.writeUInt32NoTag(iComputeBoolSizeNoTag);
            while (i2 < list.size()) {
                this.output.writeBoolNoTag(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeBool(OplusGLSurfaceView_13, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeStringList(int OplusGLSurfaceView_13, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i2 < list.size()) {
                writeLazyString(OplusGLSurfaceView_13, lazyStringList.getRaw(i2));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeString(OplusGLSurfaceView_13, list.get(i2));
            i2++;
        }
    }

    private void writeLazyString(int OplusGLSurfaceView_13, Object obj) throws IOException {
        if (obj instanceof String) {
            this.output.writeString(OplusGLSurfaceView_13, (String) obj);
        } else {
            this.output.writeBytes(OplusGLSurfaceView_13, (ByteString) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeBytesList(int OplusGLSurfaceView_13, List<ByteString> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.output.writeBytes(OplusGLSurfaceView_13, list.get(i2));
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            int iComputeUInt32SizeNoTag = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(list.get(i3).intValue());
            }
            this.output.writeUInt32NoTag(iComputeUInt32SizeNoTag);
            while (i2 < list.size()) {
                this.output.writeUInt32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeUInt32(OplusGLSurfaceView_13, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            int iComputeSFixed32SizeNoTag = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iComputeSFixed32SizeNoTag += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i3).intValue());
            }
            this.output.writeUInt32NoTag(iComputeSFixed32SizeNoTag);
            while (i2 < list.size()) {
                this.output.writeSFixed32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeSFixed32(OplusGLSurfaceView_13, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            int iComputeSFixed64SizeNoTag = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iComputeSFixed64SizeNoTag += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i3).longValue());
            }
            this.output.writeUInt32NoTag(iComputeSFixed64SizeNoTag);
            while (i2 < list.size()) {
                this.output.writeSFixed64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeSFixed64(OplusGLSurfaceView_13, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            int iComputeSInt32SizeNoTag = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(list.get(i3).intValue());
            }
            this.output.writeUInt32NoTag(iComputeSInt32SizeNoTag);
            while (i2 < list.size()) {
                this.output.writeSInt32NoTag(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeSInt32(OplusGLSurfaceView_13, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            int iComputeSInt64SizeNoTag = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(list.get(i3).longValue());
            }
            this.output.writeUInt32NoTag(iComputeSInt64SizeNoTag);
            while (i2 < list.size()) {
                this.output.writeSInt64NoTag(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.output.writeSInt64(OplusGLSurfaceView_13, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int OplusGLSurfaceView_13, List<?> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            writeMessage(OplusGLSurfaceView_13, list.get(i2));
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int OplusGLSurfaceView_13, List<?> list, Schema schema) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            writeMessage(OplusGLSurfaceView_13, list.get(i2), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeGroupList(int OplusGLSurfaceView_13, List<?> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            writeGroup(OplusGLSurfaceView_13, list.get(i2));
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeGroupList(int OplusGLSurfaceView_13, List<?> list, Schema schema) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            writeGroup(OplusGLSurfaceView_13, list.get(i2), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int OplusGLSurfaceView_13, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.output.isSerializationDeterministic()) {
            writeDeterministicMap(OplusGLSurfaceView_13, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.writeTo(this.output, metadata, entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: com.google.protobuf.CodedOutputStreamWriter$1 */
    static /* synthetic */ class C19921 {

        /* renamed from: $SwitchMap$com$google$protobuf$WireFormat$FieldType */
        static final /* synthetic */ int[] f9209xbcb373fd = new int[WireFormat.FieldType.values().length];

        static {
            try {
                f9209xbcb373fd[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9209xbcb373fd[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9209xbcb373fd[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9209xbcb373fd[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9209xbcb373fd[WireFormat.FieldType.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9209xbcb373fd[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9209xbcb373fd[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9209xbcb373fd[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9209xbcb373fd[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9209xbcb373fd[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9209xbcb373fd[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f9209xbcb373fd[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private <K, V> void writeDeterministicMap(int OplusGLSurfaceView_13, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch (C19921.f9209xbcb373fd[metadata.keyType.ordinal()]) {
            case 1:
                V v = map.get(Boolean.FALSE);
                if (v != null) {
                    writeDeterministicBooleanMapEntry(OplusGLSurfaceView_13, false, v, metadata);
                }
                V v2 = map.get(Boolean.TRUE);
                if (v2 != null) {
                    writeDeterministicBooleanMapEntry(OplusGLSurfaceView_13, true, v2, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(OplusGLSurfaceView_13, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(OplusGLSurfaceView_13, metadata, map);
                return;
            case 12:
                writeDeterministicStringMap(OplusGLSurfaceView_13, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.keyType);
        }
    }

    private <V> void writeDeterministicBooleanMapEntry(int OplusGLSurfaceView_13, boolean z, V v, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.output.writeTag(OplusGLSurfaceView_13, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(z), v));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(z), v);
    }

    private <V> void writeDeterministicIntegerMap(int OplusGLSurfaceView_13, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int[] iArr = new int[map.size()];
        Iterator<Integer> it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = it.next().intValue();
            i2++;
        }
        Arrays.sort(iArr);
        for (int i3 : iArr) {
            V v = map.get(Integer.valueOf(i3));
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(i3), v));
            MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(i3), v);
        }
    }

    private <V> void writeDeterministicLongMap(int OplusGLSurfaceView_13, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        long[] jArr = new long[map.size()];
        Iterator<Long> it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            jArr[i2] = it.next().longValue();
            i2++;
        }
        Arrays.sort(jArr);
        for (long OplusGLSurfaceView_15 : jArr) {
            V v = map.get(Long.valueOf(OplusGLSurfaceView_15));
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(OplusGLSurfaceView_15), v));
            MapEntryLite.writeTo(this.output, metadata, Long.valueOf(OplusGLSurfaceView_15), v);
        }
    }

    private <V> void writeDeterministicStringMap(int OplusGLSurfaceView_13, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        String[] strArr = new String[map.size()];
        Iterator<String> it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            strArr[i2] = it.next();
            i2++;
        }
        Arrays.sort(strArr);
        for (String str : strArr) {
            V v = map.get(str);
            this.output.writeTag(OplusGLSurfaceView_13, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, str, v));
            MapEntryLite.writeTo(this.output, metadata, str, v);
        }
    }
}
