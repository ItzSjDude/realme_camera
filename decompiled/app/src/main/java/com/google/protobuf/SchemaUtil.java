package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
    private static final UnknownFieldSchema<?, ?> PROTO2_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(false);
    private static final UnknownFieldSchema<?, ?> PROTO3_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(true);
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();

    public static boolean shouldUseTableSwitch(int OplusGLSurfaceView_13, int i2, int i3) {
        if (i2 < 40) {
            return true;
        }
        long OplusGLSurfaceView_15 = i3;
        return ((((long) i2) - ((long) OplusGLSurfaceView_13)) + 1) + 9 <= ((2 * OplusGLSurfaceView_15) + 3) + ((OplusGLSurfaceView_15 + 3) * 3);
    }

    private SchemaUtil() {
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = GENERATED_MESSAGE_CLASS) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void writeDouble(int OplusGLSurfaceView_13, double IntrinsicsJvm.kt_5, Writer writer) throws IOException {
        if (Double.compare(IntrinsicsJvm.kt_5, 0.0d) != 0) {
            writer.writeDouble(OplusGLSurfaceView_13, IntrinsicsJvm.kt_5);
        }
    }

    public static void writeFloat(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, Writer writer) throws IOException {
        if (Float.compare(COUIBaseListPopupWindow_12, 0.0f) != 0) {
            writer.writeFloat(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
        }
    }

    public static void writeInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, Writer writer) throws IOException {
        if (OplusGLSurfaceView_15 != 0) {
            writer.writeInt64(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
        }
    }

    public static void writeUInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, Writer writer) throws IOException {
        if (OplusGLSurfaceView_15 != 0) {
            writer.writeUInt64(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
        }
    }

    public static void writeSInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, Writer writer) throws IOException {
        if (OplusGLSurfaceView_15 != 0) {
            writer.writeSInt64(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
        }
    }

    public static void writeFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, Writer writer) throws IOException {
        if (OplusGLSurfaceView_15 != 0) {
            writer.writeFixed64(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
        }
    }

    public static void writeSFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, Writer writer) throws IOException {
        if (OplusGLSurfaceView_15 != 0) {
            writer.writeSFixed64(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
        }
    }

    public static void writeInt32(int OplusGLSurfaceView_13, int i2, Writer writer) throws IOException {
        if (i2 != 0) {
            writer.writeInt32(OplusGLSurfaceView_13, i2);
        }
    }

    public static void writeUInt32(int OplusGLSurfaceView_13, int i2, Writer writer) throws IOException {
        if (i2 != 0) {
            writer.writeUInt32(OplusGLSurfaceView_13, i2);
        }
    }

    public static void writeSInt32(int OplusGLSurfaceView_13, int i2, Writer writer) throws IOException {
        if (i2 != 0) {
            writer.writeSInt32(OplusGLSurfaceView_13, i2);
        }
    }

    public static void writeFixed32(int OplusGLSurfaceView_13, int i2, Writer writer) throws IOException {
        if (i2 != 0) {
            writer.writeFixed32(OplusGLSurfaceView_13, i2);
        }
    }

    public static void writeSFixed32(int OplusGLSurfaceView_13, int i2, Writer writer) throws IOException {
        if (i2 != 0) {
            writer.writeSFixed32(OplusGLSurfaceView_13, i2);
        }
    }

    public static void writeEnum(int OplusGLSurfaceView_13, int i2, Writer writer) throws IOException {
        if (i2 != 0) {
            writer.writeEnum(OplusGLSurfaceView_13, i2);
        }
    }

    public static void writeBool(int OplusGLSurfaceView_13, boolean z, Writer writer) throws IOException {
        if (z) {
            writer.writeBool(OplusGLSurfaceView_13, true);
        }
    }

    public static void writeString(int OplusGLSurfaceView_13, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writeStringInternal(OplusGLSurfaceView_13, (String) obj, writer);
        } else {
            writeBytes(OplusGLSurfaceView_13, (ByteString) obj, writer);
        }
    }

    private static void writeStringInternal(int OplusGLSurfaceView_13, String str, Writer writer) throws IOException {
        if (str == null || str.isEmpty()) {
            return;
        }
        writer.writeString(OplusGLSurfaceView_13, str);
    }

    public static void writeBytes(int OplusGLSurfaceView_13, ByteString byteString, Writer writer) throws IOException {
        if (byteString == null || byteString.isEmpty()) {
            return;
        }
        writer.writeBytes(OplusGLSurfaceView_13, byteString);
    }

    public static void writeMessage(int OplusGLSurfaceView_13, Object obj, Writer writer) throws IOException {
        if (obj != null) {
            writer.writeMessage(OplusGLSurfaceView_13, obj);
        }
    }

    public static void writeDoubleList(int OplusGLSurfaceView_13, List<Double> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeDoubleList(OplusGLSurfaceView_13, list, z);
    }

    public static void writeFloatList(int OplusGLSurfaceView_13, List<Float> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFloatList(OplusGLSurfaceView_13, list, z);
    }

    public static void writeInt64List(int OplusGLSurfaceView_13, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt64List(OplusGLSurfaceView_13, list, z);
    }

    public static void writeUInt64List(int OplusGLSurfaceView_13, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt64List(OplusGLSurfaceView_13, list, z);
    }

    public static void writeSInt64List(int OplusGLSurfaceView_13, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt64List(OplusGLSurfaceView_13, list, z);
    }

    public static void writeFixed64List(int OplusGLSurfaceView_13, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed64List(OplusGLSurfaceView_13, list, z);
    }

    public static void writeSFixed64List(int OplusGLSurfaceView_13, List<Long> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed64List(OplusGLSurfaceView_13, list, z);
    }

    public static void writeInt32List(int OplusGLSurfaceView_13, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt32List(OplusGLSurfaceView_13, list, z);
    }

    public static void writeUInt32List(int OplusGLSurfaceView_13, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt32List(OplusGLSurfaceView_13, list, z);
    }

    public static void writeSInt32List(int OplusGLSurfaceView_13, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt32List(OplusGLSurfaceView_13, list, z);
    }

    public static void writeFixed32List(int OplusGLSurfaceView_13, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed32List(OplusGLSurfaceView_13, list, z);
    }

    public static void writeSFixed32List(int OplusGLSurfaceView_13, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed32List(OplusGLSurfaceView_13, list, z);
    }

    public static void writeEnumList(int OplusGLSurfaceView_13, List<Integer> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeEnumList(OplusGLSurfaceView_13, list, z);
    }

    public static void writeBoolList(int OplusGLSurfaceView_13, List<Boolean> list, Writer writer, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBoolList(OplusGLSurfaceView_13, list, z);
    }

    public static void writeStringList(int OplusGLSurfaceView_13, List<String> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeStringList(OplusGLSurfaceView_13, list);
    }

    public static void writeBytesList(int OplusGLSurfaceView_13, List<ByteString> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBytesList(OplusGLSurfaceView_13, list);
    }

    public static void writeMessageList(int OplusGLSurfaceView_13, List<?> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeMessageList(OplusGLSurfaceView_13, list);
    }

    public static void writeMessageList(int OplusGLSurfaceView_13, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeMessageList(OplusGLSurfaceView_13, list, schema);
    }

    public static void writeLazyFieldList(int OplusGLSurfaceView_13, List<?> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            ((LazyFieldLite) it.next()).writeTo(writer, OplusGLSurfaceView_13);
        }
    }

    public static void writeGroupList(int OplusGLSurfaceView_13, List<?> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeGroupList(OplusGLSurfaceView_13, list);
    }

    public static void writeGroupList(int OplusGLSurfaceView_13, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeGroupList(OplusGLSurfaceView_13, list, schema);
    }

    static int computeSizeInt64ListNoTag(List<Long> list) {
        int iComputeInt64SizeNoTag;
        int size = list.size();
        int OplusGLSurfaceView_13 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            iComputeInt64SizeNoTag = 0;
            while (OplusGLSurfaceView_13 < size) {
                iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(OplusGLSurfaceView_13));
                OplusGLSurfaceView_13++;
            }
        } else {
            iComputeInt64SizeNoTag = 0;
            while (OplusGLSurfaceView_13 < size) {
                iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(list.get(OplusGLSurfaceView_13).longValue());
                OplusGLSurfaceView_13++;
            }
        }
        return iComputeInt64SizeNoTag;
    }

    static int computeSizeInt64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int iComputeSizeInt64ListNoTag = computeSizeInt64ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(OplusGLSurfaceView_13) + CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeInt64ListNoTag);
        }
        return iComputeSizeInt64ListNoTag + (list.size() * CodedOutputStream.computeTagSize(OplusGLSurfaceView_13));
    }

    static int computeSizeUInt64ListNoTag(List<Long> list) {
        int iComputeUInt64SizeNoTag;
        int size = list.size();
        int OplusGLSurfaceView_13 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            iComputeUInt64SizeNoTag = 0;
            while (OplusGLSurfaceView_13 < size) {
                iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(OplusGLSurfaceView_13));
                OplusGLSurfaceView_13++;
            }
        } else {
            iComputeUInt64SizeNoTag = 0;
            while (OplusGLSurfaceView_13 < size) {
                iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(list.get(OplusGLSurfaceView_13).longValue());
                OplusGLSurfaceView_13++;
            }
        }
        return iComputeUInt64SizeNoTag;
    }

    static int computeSizeUInt64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeUInt64ListNoTag = computeSizeUInt64ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(OplusGLSurfaceView_13) + CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeUInt64ListNoTag);
        }
        return iComputeSizeUInt64ListNoTag + (size * CodedOutputStream.computeTagSize(OplusGLSurfaceView_13));
    }

    static int computeSizeSInt64ListNoTag(List<Long> list) {
        int iComputeSInt64SizeNoTag;
        int size = list.size();
        int OplusGLSurfaceView_13 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            iComputeSInt64SizeNoTag = 0;
            while (OplusGLSurfaceView_13 < size) {
                iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(OplusGLSurfaceView_13));
                OplusGLSurfaceView_13++;
            }
        } else {
            iComputeSInt64SizeNoTag = 0;
            while (OplusGLSurfaceView_13 < size) {
                iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(list.get(OplusGLSurfaceView_13).longValue());
                OplusGLSurfaceView_13++;
            }
        }
        return iComputeSInt64SizeNoTag;
    }

    static int computeSizeSInt64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeSInt64ListNoTag = computeSizeSInt64ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(OplusGLSurfaceView_13) + CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeSInt64ListNoTag);
        }
        return iComputeSizeSInt64ListNoTag + (size * CodedOutputStream.computeTagSize(OplusGLSurfaceView_13));
    }

    static int computeSizeEnumListNoTag(List<Integer> list) {
        int iComputeEnumSizeNoTag;
        int size = list.size();
        int OplusGLSurfaceView_13 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            iComputeEnumSizeNoTag = 0;
            while (OplusGLSurfaceView_13 < size) {
                iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(OplusGLSurfaceView_13));
                OplusGLSurfaceView_13++;
            }
        } else {
            iComputeEnumSizeNoTag = 0;
            while (OplusGLSurfaceView_13 < size) {
                iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(list.get(OplusGLSurfaceView_13).intValue());
                OplusGLSurfaceView_13++;
            }
        }
        return iComputeEnumSizeNoTag;
    }

    static int computeSizeEnumList(int OplusGLSurfaceView_13, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeEnumListNoTag = computeSizeEnumListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(OplusGLSurfaceView_13) + CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeEnumListNoTag);
        }
        return iComputeSizeEnumListNoTag + (size * CodedOutputStream.computeTagSize(OplusGLSurfaceView_13));
    }

    static int computeSizeInt32ListNoTag(List<Integer> list) {
        int iComputeInt32SizeNoTag;
        int size = list.size();
        int OplusGLSurfaceView_13 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            iComputeInt32SizeNoTag = 0;
            while (OplusGLSurfaceView_13 < size) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(OplusGLSurfaceView_13));
                OplusGLSurfaceView_13++;
            }
        } else {
            iComputeInt32SizeNoTag = 0;
            while (OplusGLSurfaceView_13 < size) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(list.get(OplusGLSurfaceView_13).intValue());
                OplusGLSurfaceView_13++;
            }
        }
        return iComputeInt32SizeNoTag;
    }

    static int computeSizeInt32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeInt32ListNoTag = computeSizeInt32ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(OplusGLSurfaceView_13) + CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeInt32ListNoTag);
        }
        return iComputeSizeInt32ListNoTag + (size * CodedOutputStream.computeTagSize(OplusGLSurfaceView_13));
    }

    static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int iComputeUInt32SizeNoTag;
        int size = list.size();
        int OplusGLSurfaceView_13 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            iComputeUInt32SizeNoTag = 0;
            while (OplusGLSurfaceView_13 < size) {
                iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(OplusGLSurfaceView_13));
                OplusGLSurfaceView_13++;
            }
        } else {
            iComputeUInt32SizeNoTag = 0;
            while (OplusGLSurfaceView_13 < size) {
                iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(list.get(OplusGLSurfaceView_13).intValue());
                OplusGLSurfaceView_13++;
            }
        }
        return iComputeUInt32SizeNoTag;
    }

    static int computeSizeUInt32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeUInt32ListNoTag = computeSizeUInt32ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(OplusGLSurfaceView_13) + CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeUInt32ListNoTag);
        }
        return iComputeSizeUInt32ListNoTag + (size * CodedOutputStream.computeTagSize(OplusGLSurfaceView_13));
    }

    static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int iComputeSInt32SizeNoTag;
        int size = list.size();
        int OplusGLSurfaceView_13 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            iComputeSInt32SizeNoTag = 0;
            while (OplusGLSurfaceView_13 < size) {
                iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(OplusGLSurfaceView_13));
                OplusGLSurfaceView_13++;
            }
        } else {
            iComputeSInt32SizeNoTag = 0;
            while (OplusGLSurfaceView_13 < size) {
                iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(list.get(OplusGLSurfaceView_13).intValue());
                OplusGLSurfaceView_13++;
            }
        }
        return iComputeSInt32SizeNoTag;
    }

    static int computeSizeSInt32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeSInt32ListNoTag = computeSizeSInt32ListNoTag(list);
        if (z) {
            return CodedOutputStream.computeTagSize(OplusGLSurfaceView_13) + CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeSInt32ListNoTag);
        }
        return iComputeSizeSInt32ListNoTag + (size * CodedOutputStream.computeTagSize(OplusGLSurfaceView_13));
    }

    static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    static int computeSizeFixed32List(int OplusGLSurfaceView_13, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.computeTagSize(OplusGLSurfaceView_13) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 4);
        }
        return size * CodedOutputStream.computeFixed32Size(OplusGLSurfaceView_13, 0);
    }

    static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    static int computeSizeFixed64List(int OplusGLSurfaceView_13, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.computeTagSize(OplusGLSurfaceView_13) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 8);
        }
        return size * CodedOutputStream.computeFixed64Size(OplusGLSurfaceView_13, 0L);
    }

    static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    static int computeSizeBoolList(int OplusGLSurfaceView_13, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.computeTagSize(OplusGLSurfaceView_13) + CodedOutputStream.computeLengthDelimitedFieldSize(size);
        }
        return size * CodedOutputStream.computeBoolSize(OplusGLSurfaceView_13, true);
    }

    static int computeSizeStringList(int OplusGLSurfaceView_13, List<?> list) {
        int iComputeStringSizeNoTag;
        int iComputeStringSizeNoTag2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(OplusGLSurfaceView_13) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i2 < size) {
                Object raw = lazyStringList.getRaw(i2);
                if (raw instanceof ByteString) {
                    iComputeStringSizeNoTag2 = CodedOutputStream.computeBytesSizeNoTag((ByteString) raw);
                } else {
                    iComputeStringSizeNoTag2 = CodedOutputStream.computeStringSizeNoTag((String) raw);
                }
                iComputeTagSize += iComputeStringSizeNoTag2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof ByteString) {
                    iComputeStringSizeNoTag = CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                } else {
                    iComputeStringSizeNoTag = CodedOutputStream.computeStringSizeNoTag((String) obj);
                }
                iComputeTagSize += iComputeStringSizeNoTag;
                i2++;
            }
        }
        return iComputeTagSize;
    }

    static int computeSizeMessage(int OplusGLSurfaceView_13, Object obj, Schema schema) {
        if (obj instanceof LazyFieldLite) {
            return CodedOutputStream.computeLazyFieldSize(OplusGLSurfaceView_13, (LazyFieldLite) obj);
        }
        return CodedOutputStream.computeMessageSize(OplusGLSurfaceView_13, (MessageLite) obj, schema);
    }

    static int computeSizeMessageList(int OplusGLSurfaceView_13, List<?> list) {
        int iComputeMessageSizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(OplusGLSurfaceView_13) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof LazyFieldLite) {
                iComputeMessageSizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                iComputeMessageSizeNoTag = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            }
            iComputeTagSize += iComputeMessageSizeNoTag;
        }
        return iComputeTagSize;
    }

    static int computeSizeMessageList(int OplusGLSurfaceView_13, List<?> list, Schema schema) {
        int iComputeMessageSizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(OplusGLSurfaceView_13) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof LazyFieldLite) {
                iComputeMessageSizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                iComputeMessageSizeNoTag = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj, schema);
            }
            iComputeTagSize += iComputeMessageSizeNoTag;
        }
        return iComputeTagSize;
    }

    static int computeSizeByteStringList(int OplusGLSurfaceView_13, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = size * CodedOutputStream.computeTagSize(OplusGLSurfaceView_13);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iComputeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i2));
        }
        return iComputeTagSize;
    }

    static int computeSizeGroupList(int OplusGLSurfaceView_13, List<MessageLite> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeGroupSize = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iComputeGroupSize += CodedOutputStream.computeGroupSize(OplusGLSurfaceView_13, list.get(i2));
        }
        return iComputeGroupSize;
    }

    static int computeSizeGroupList(int OplusGLSurfaceView_13, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeGroupSize = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iComputeGroupSize += CodedOutputStream.computeGroupSize(OplusGLSurfaceView_13, list.get(i2), schema);
        }
        return iComputeGroupSize;
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fieldInfoArr) {
        if (fieldInfoArr.length == 0) {
            return false;
        }
        return shouldUseTableSwitch(fieldInfoArr[0].getFieldNumber(), fieldInfoArr[fieldInfoArr.length - 1].getFieldNumber(), fieldInfoArr.length);
    }

    public static UnknownFieldSchema<?, ?> proto2UnknownFieldSetSchema() {
        return PROTO2_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> proto3UnknownFieldSetSchema() {
        return PROTO3_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema(boolean z) {
        try {
            Class<?> unknownFieldSetSchemaClass = getUnknownFieldSetSchemaClass();
            if (unknownFieldSetSchemaClass == null) {
                return null;
            }
            return (UnknownFieldSchema) unknownFieldSetSchemaClass.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getGeneratedMessageClass() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static Object getMapDefaultEntry(Class<?> cls, String str) {
        try {
            java.lang.reflect.Field[] declaredFields = Class.forName(cls.getName() + "$" + toCamelCase(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length != 1) {
                throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
            }
            return UnsafeUtil.getStaticObject(declaredFields[0]);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    static String toCamelCase(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        boolean z2 = z;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < str.length(); OplusGLSurfaceView_13++) {
            char cCharAt = str.charAt(OplusGLSurfaceView_13);
            if ('PlatformImplementations.kt_3' > cCharAt || cCharAt > 'z') {
                if ('A' > cCharAt || cCharAt > 'Z') {
                    if ('0' <= cCharAt && cCharAt <= '9') {
                        sb.append(cCharAt);
                    }
                    z2 = true;
                } else if (OplusGLSurfaceView_13 == 0 && !z2) {
                    sb.append((char) (cCharAt + ' '));
                } else {
                    sb.append(cCharAt);
                }
            } else if (z2) {
                sb.append((char) (cCharAt - ' '));
            } else {
                sb.append(cCharAt);
            }
            z2 = false;
        }
        return sb.toString();
    }

    static boolean safeEquals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void mergeMap(MapFieldSchema mapFieldSchema, T t, T t2, long OplusGLSurfaceView_15) {
        UnsafeUtil.putObject(t, OplusGLSurfaceView_15, mapFieldSchema.mergeFrom(UnsafeUtil.getObject(t, OplusGLSurfaceView_15), UnsafeUtil.getObject(t2, OplusGLSurfaceView_15)));
    }

    static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> extensionSchema, T t, T t2) {
        FieldSet<T> extensions = extensionSchema.getExtensions(t2);
        if (extensions.isEmpty()) {
            return;
        }
        extensionSchema.getMutableExtensions(t).mergeFrom(extensions);
    }

    static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, T t2) {
        unknownFieldSchema.setToMessage(t, unknownFieldSchema.merge(unknownFieldSchema.getFromMessage(t), unknownFieldSchema.getFromMessage(t2)));
    }

    static <UT, UB> UB filterUnknownEnumList(int OplusGLSurfaceView_13, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        UB ub2;
        int iIntValue;
        if (enumLiteMap == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue2 = list.get(i3).intValue();
                if (enumLiteMap.findValueByNumber(iIntValue2) != null) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue2));
                    }
                    i2++;
                } else {
                    ub2 = (UB) storeUnknownEnum(OplusGLSurfaceView_13, iIntValue2, ub2, unknownFieldSchema);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            loop1: while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    iIntValue = it.next().intValue();
                    if (enumLiteMap.findValueByNumber(iIntValue) == null) {
                        break;
                    }
                }
                ub = (UB) storeUnknownEnum(OplusGLSurfaceView_13, iIntValue, ub2, unknownFieldSchema);
                it.remove();
            }
        }
        return ub2;
    }

    static <UT, UB> UB filterUnknownEnumList(int OplusGLSurfaceView_13, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        UB ub2;
        int iIntValue;
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue2 = list.get(i3).intValue();
                if (enumVerifier.isInRange(iIntValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue2));
                    }
                    i2++;
                } else {
                    ub2 = (UB) storeUnknownEnum(OplusGLSurfaceView_13, iIntValue2, ub2, unknownFieldSchema);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            loop1: while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    iIntValue = it.next().intValue();
                    if (!enumVerifier.isInRange(iIntValue)) {
                        break;
                    }
                }
                ub = (UB) storeUnknownEnum(OplusGLSurfaceView_13, iIntValue, ub2, unknownFieldSchema);
                it.remove();
            }
        }
        return ub2;
    }

    static <UT, UB> UB storeUnknownEnum(int OplusGLSurfaceView_13, int i2, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.newBuilder();
        }
        unknownFieldSchema.addVarint(ub, OplusGLSurfaceView_13, i2);
        return ub;
    }
}
