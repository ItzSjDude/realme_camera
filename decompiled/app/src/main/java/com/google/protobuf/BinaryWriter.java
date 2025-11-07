package com.google.protobuf;

import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.Utf8;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.tblplayer.config.PreCacheConfig;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* loaded from: classes.dex */
abstract class BinaryWriter extends ByteOutput implements Writer {
    public static final int DEFAULT_CHUNK_SIZE = 4096;
    private static final int MAP_KEY_NUMBER = 1;
    private static final int MAP_VALUE_NUMBER = 2;
    private final BufferAllocator alloc;
    final ArrayDeque<AllocatedBuffer> buffers;
    private final int chunkSize;
    int totalDoneBytes;

    /* JADX INFO: Access modifiers changed from: private */
    public static byte computeUInt64SizeNoTag(long OplusGLSurfaceView_15) {
        byte b2;
        if (((-128) & OplusGLSurfaceView_15) == 0) {
            return (byte) 1;
        }
        if (OplusGLSurfaceView_15 < 0) {
            return (byte) 10;
        }
        if (((-34359738368L) & OplusGLSurfaceView_15) != 0) {
            b2 = (byte) 6;
            OplusGLSurfaceView_15 >>>= 28;
        } else {
            b2 = 2;
        }
        if (((-2097152) & OplusGLSurfaceView_15) != 0) {
            b2 = (byte) (b2 + 2);
            OplusGLSurfaceView_15 >>>= 14;
        }
        return (OplusGLSurfaceView_15 & (-16384)) != 0 ? (byte) (b2 + 1) : b2;
    }

    abstract void finishCurrentBuffer();

    public abstract int getTotalBytesWritten();

    abstract void requireSpace(int OplusGLSurfaceView_13);

    abstract void writeBool(boolean z);

    abstract void writeFixed32(int OplusGLSurfaceView_13);

    abstract void writeFixed64(long OplusGLSurfaceView_15);

    abstract void writeInt32(int OplusGLSurfaceView_13);

    abstract void writeSInt32(int OplusGLSurfaceView_13);

    abstract void writeSInt64(long OplusGLSurfaceView_15);

    abstract void writeString(String str);

    abstract void writeTag(int OplusGLSurfaceView_13, int i2);

    abstract void writeVarint32(int OplusGLSurfaceView_13);

    abstract void writeVarint64(long OplusGLSurfaceView_15);

    /* synthetic */ BinaryWriter(BufferAllocator bufferAllocator, int OplusGLSurfaceView_13, C19831 c19831) {
        this(bufferAllocator, OplusGLSurfaceView_13);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator) {
        return newHeapInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator, int OplusGLSurfaceView_13) {
        if (isUnsafeHeapSupported()) {
            return newUnsafeHeapInstance(bufferAllocator, OplusGLSurfaceView_13);
        }
        return newSafeHeapInstance(bufferAllocator, OplusGLSurfaceView_13);
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator) {
        return newDirectInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator, int OplusGLSurfaceView_13) {
        if (isUnsafeDirectSupported()) {
            return newUnsafeDirectInstance(bufferAllocator, OplusGLSurfaceView_13);
        }
        return newSafeDirectInstance(bufferAllocator, OplusGLSurfaceView_13);
    }

    static boolean isUnsafeHeapSupported() {
        return UnsafeHeapWriter.isSupported();
    }

    static boolean isUnsafeDirectSupported() {
        return UnsafeDirectWriter.isSupported();
    }

    static BinaryWriter newSafeHeapInstance(BufferAllocator bufferAllocator, int OplusGLSurfaceView_13) {
        return new SafeHeapWriter(bufferAllocator, OplusGLSurfaceView_13);
    }

    static BinaryWriter newUnsafeHeapInstance(BufferAllocator bufferAllocator, int OplusGLSurfaceView_13) {
        if (!isUnsafeHeapSupported()) {
            throw new UnsupportedOperationException("Unsafe operations not supported");
        }
        return new UnsafeHeapWriter(bufferAllocator, OplusGLSurfaceView_13);
    }

    static BinaryWriter newSafeDirectInstance(BufferAllocator bufferAllocator, int OplusGLSurfaceView_13) {
        return new SafeDirectWriter(bufferAllocator, OplusGLSurfaceView_13);
    }

    static BinaryWriter newUnsafeDirectInstance(BufferAllocator bufferAllocator, int OplusGLSurfaceView_13) {
        if (!isUnsafeDirectSupported()) {
            throw new UnsupportedOperationException("Unsafe operations not supported");
        }
        return new UnsafeDirectWriter(bufferAllocator, OplusGLSurfaceView_13);
    }

    private BinaryWriter(BufferAllocator bufferAllocator, int OplusGLSurfaceView_13) {
        this.buffers = new ArrayDeque<>(4);
        if (OplusGLSurfaceView_13 <= 0) {
            throw new IllegalArgumentException("chunkSize must be > 0");
        }
        this.alloc = (BufferAllocator) Internal.checkNotNull(bufferAllocator, "alloc");
        this.chunkSize = OplusGLSurfaceView_13;
    }

    @Override // com.google.protobuf.Writer
    public final Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.DESCENDING;
    }

    public final Queue<AllocatedBuffer> complete() {
        finishCurrentBuffer();
        return this.buffers;
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed32(int OplusGLSurfaceView_13, int i2) throws IOException {
        writeFixed32(OplusGLSurfaceView_13, i2);
    }

    @Override // com.google.protobuf.Writer
    public final void writeInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        writeUInt64(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        writeFixed64(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    @Override // com.google.protobuf.Writer
    public final void writeFloat(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) throws IOException {
        writeFixed32(OplusGLSurfaceView_13, Float.floatToRawIntBits(COUIBaseListPopupWindow_12));
    }

    @Override // com.google.protobuf.Writer
    public final void writeDouble(int OplusGLSurfaceView_13, double IntrinsicsJvm.kt_5) throws IOException {
        writeFixed64(OplusGLSurfaceView_13, Double.doubleToRawLongBits(IntrinsicsJvm.kt_5));
    }

    @Override // com.google.protobuf.Writer
    public final void writeEnum(int OplusGLSurfaceView_13, int i2) throws IOException {
        writeInt32(OplusGLSurfaceView_13, i2);
    }

    @Override // com.google.protobuf.Writer
    public final void writeInt32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            writeInt32List_Internal(OplusGLSurfaceView_13, (IntArrayList) list, z);
        } else {
            writeInt32List_Internal(OplusGLSurfaceView_13, list, z);
        }
    }

    private final void writeInt32List_Internal(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeInt32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeInt32(OplusGLSurfaceView_13, list.get(size2).intValue());
        }
    }

    private final void writeInt32List_Internal(int OplusGLSurfaceView_13, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((intArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeInt32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeInt32(OplusGLSurfaceView_13, intArrayList.getInt(size2));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeFixed32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            writeFixed32List_Internal(OplusGLSurfaceView_13, (IntArrayList) list, z);
        } else {
            writeFixed32List_Internal(OplusGLSurfaceView_13, list, z);
        }
    }

    private final void writeFixed32List_Internal(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed32(OplusGLSurfaceView_13, list.get(size2).intValue());
        }
    }

    private final void writeFixed32List_Internal(int OplusGLSurfaceView_13, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((intArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed32(OplusGLSurfaceView_13, intArrayList.getInt(size2));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeInt64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException {
        writeUInt64List(OplusGLSurfaceView_13, list, z);
    }

    @Override // com.google.protobuf.Writer
    public final void writeUInt64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException {
        if (list instanceof LongArrayList) {
            writeUInt64List_Internal(OplusGLSurfaceView_13, (LongArrayList) list, z);
        } else {
            writeUInt64List_Internal(OplusGLSurfaceView_13, list, z);
        }
    }

    private final void writeUInt64List_Internal(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeVarint64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt64(OplusGLSurfaceView_13, list.get(size2).longValue());
        }
    }

    private final void writeUInt64List_Internal(int OplusGLSurfaceView_13, LongArrayList longArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeVarint64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt64(OplusGLSurfaceView_13, longArrayList.getLong(size2));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeFixed64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException {
        if (list instanceof LongArrayList) {
            writeFixed64List_Internal(OplusGLSurfaceView_13, (LongArrayList) list, z);
        } else {
            writeFixed64List_Internal(OplusGLSurfaceView_13, list, z);
        }
    }

    private final void writeFixed64List_Internal(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed64(OplusGLSurfaceView_13, list.get(size2).longValue());
        }
    }

    private final void writeFixed64List_Internal(int OplusGLSurfaceView_13, LongArrayList longArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((longArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed64(OplusGLSurfaceView_13, longArrayList.getLong(size2));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeFloatList(int OplusGLSurfaceView_13, List<Float> list, boolean z) throws IOException {
        if (list instanceof FloatArrayList) {
            writeFloatList_Internal(OplusGLSurfaceView_13, (FloatArrayList) list, z);
        } else {
            writeFloatList_Internal(OplusGLSurfaceView_13, list, z);
        }
    }

    private final void writeFloatList_Internal(int OplusGLSurfaceView_13, List<Float> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(Float.floatToRawIntBits(list.get(size).floatValue()));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFloat(OplusGLSurfaceView_13, list.get(size2).floatValue());
        }
    }

    private final void writeFloatList_Internal(int OplusGLSurfaceView_13, FloatArrayList floatArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((floatArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = floatArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(Float.floatToRawIntBits(floatArrayList.getFloat(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = floatArrayList.size() - 1; size2 >= 0; size2--) {
            writeFloat(OplusGLSurfaceView_13, floatArrayList.getFloat(size2));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeDoubleList(int OplusGLSurfaceView_13, List<Double> list, boolean z) throws IOException {
        if (list instanceof DoubleArrayList) {
            writeDoubleList_Internal(OplusGLSurfaceView_13, (DoubleArrayList) list, z);
        } else {
            writeDoubleList_Internal(OplusGLSurfaceView_13, list, z);
        }
    }

    private final void writeDoubleList_Internal(int OplusGLSurfaceView_13, List<Double> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(Double.doubleToRawLongBits(list.get(size).doubleValue()));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeDouble(OplusGLSurfaceView_13, list.get(size2).doubleValue());
        }
    }

    private final void writeDoubleList_Internal(int OplusGLSurfaceView_13, DoubleArrayList doubleArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((doubleArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = doubleArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(Double.doubleToRawLongBits(doubleArrayList.getDouble(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = doubleArrayList.size() - 1; size2 >= 0; size2--) {
            writeDouble(OplusGLSurfaceView_13, doubleArrayList.getDouble(size2));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeEnumList(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        writeInt32List(OplusGLSurfaceView_13, list, z);
    }

    @Override // com.google.protobuf.Writer
    public final void writeBoolList(int OplusGLSurfaceView_13, List<Boolean> list, boolean z) throws IOException {
        if (list instanceof BooleanArrayList) {
            writeBoolList_Internal(OplusGLSurfaceView_13, (BooleanArrayList) list, z);
        } else {
            writeBoolList_Internal(OplusGLSurfaceView_13, list, z);
        }
    }

    private final void writeBoolList_Internal(int OplusGLSurfaceView_13, List<Boolean> list, boolean z) throws IOException {
        if (z) {
            requireSpace(list.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeBool(list.get(size).booleanValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeBool(OplusGLSurfaceView_13, list.get(size2).booleanValue());
        }
    }

    private final void writeBoolList_Internal(int OplusGLSurfaceView_13, BooleanArrayList booleanArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace(booleanArrayList.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = booleanArrayList.size() - 1; size >= 0; size--) {
                writeBool(booleanArrayList.getBoolean(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = booleanArrayList.size() - 1; size2 >= 0; size2--) {
            writeBool(OplusGLSurfaceView_13, booleanArrayList.getBoolean(size2));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeStringList(int OplusGLSurfaceView_13, List<String> list) throws IOException {
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            for (int size = list.size() - 1; size >= 0; size--) {
                writeLazyString(OplusGLSurfaceView_13, lazyStringList.getRaw(size));
            }
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeString(OplusGLSurfaceView_13, list.get(size2));
        }
    }

    private void writeLazyString(int OplusGLSurfaceView_13, Object obj) throws IOException {
        if (obj instanceof String) {
            writeString(OplusGLSurfaceView_13, (String) obj);
        } else {
            writeBytes(OplusGLSurfaceView_13, (ByteString) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeBytesList(int OplusGLSurfaceView_13, List<ByteString> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeBytes(OplusGLSurfaceView_13, list.get(size));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeUInt32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            writeUInt32List_Internal(OplusGLSurfaceView_13, (IntArrayList) list, z);
        } else {
            writeUInt32List_Internal(OplusGLSurfaceView_13, list, z);
        }
    }

    private final void writeUInt32List_Internal(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeVarint32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt32(OplusGLSurfaceView_13, list.get(size2).intValue());
        }
    }

    private final void writeUInt32List_Internal(int OplusGLSurfaceView_13, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeVarint32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt32(OplusGLSurfaceView_13, intArrayList.getInt(size2));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        writeFixed32List(OplusGLSurfaceView_13, list, z);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException {
        writeFixed64List(OplusGLSurfaceView_13, list, z);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSInt32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            writeSInt32List_Internal(OplusGLSurfaceView_13, (IntArrayList) list, z);
        } else {
            writeSInt32List_Internal(OplusGLSurfaceView_13, list, z);
        }
    }

    private final void writeSInt32List_Internal(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt32(OplusGLSurfaceView_13, list.get(size2).intValue());
        }
    }

    private final void writeSInt32List_Internal(int OplusGLSurfaceView_13, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeSInt32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt32(OplusGLSurfaceView_13, intArrayList.getInt(size2));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeSInt64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException {
        if (list instanceof LongArrayList) {
            writeSInt64List_Internal(OplusGLSurfaceView_13, (LongArrayList) list, z);
        } else {
            writeSInt64List_Internal(OplusGLSurfaceView_13, list, z);
        }
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int OplusGLSurfaceView_13, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            int totalBytesWritten = getTotalBytesWritten();
            writeMapEntryField(this, 2, metadata.valueType, entry.getValue());
            writeMapEntryField(this, 1, metadata.keyType, entry.getKey());
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
        }
    }

    /* renamed from: com.google.protobuf.BinaryWriter$1 */
    static /* synthetic */ class C19831 {

        /* renamed from: $SwitchMap$com$google$protobuf$WireFormat$FieldType */
        static final /* synthetic */ int[] f9207xbcb373fd = new int[WireFormat.FieldType.values().length];

        static {
            try {
                f9207xbcb373fd[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.INT32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.INT64.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.SFIXED32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.SINT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.SINT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.FLOAT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.DOUBLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.MESSAGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.BYTES.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f9207xbcb373fd[WireFormat.FieldType.ENUM.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    static final void writeMapEntryField(Writer writer, int OplusGLSurfaceView_13, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (C19831.f9207xbcb373fd[fieldType.ordinal()]) {
            case 1:
                writer.writeBool(OplusGLSurfaceView_13, ((Boolean) obj).booleanValue());
                return;
            case 2:
                writer.writeFixed32(OplusGLSurfaceView_13, ((Integer) obj).intValue());
                return;
            case 3:
                writer.writeFixed64(OplusGLSurfaceView_13, ((Long) obj).longValue());
                return;
            case 4:
                writer.writeInt32(OplusGLSurfaceView_13, ((Integer) obj).intValue());
                return;
            case 5:
                writer.writeInt64(OplusGLSurfaceView_13, ((Long) obj).longValue());
                return;
            case 6:
                writer.writeSFixed32(OplusGLSurfaceView_13, ((Integer) obj).intValue());
                return;
            case 7:
                writer.writeSFixed64(OplusGLSurfaceView_13, ((Long) obj).longValue());
                return;
            case 8:
                writer.writeSInt32(OplusGLSurfaceView_13, ((Integer) obj).intValue());
                return;
            case 9:
                writer.writeSInt64(OplusGLSurfaceView_13, ((Long) obj).longValue());
                return;
            case 10:
                writer.writeString(OplusGLSurfaceView_13, (String) obj);
                return;
            case 11:
                writer.writeUInt32(OplusGLSurfaceView_13, ((Integer) obj).intValue());
                return;
            case 12:
                writer.writeUInt64(OplusGLSurfaceView_13, ((Long) obj).longValue());
                return;
            case 13:
                writer.writeFloat(OplusGLSurfaceView_13, ((Float) obj).floatValue());
                return;
            case 14:
                writer.writeDouble(OplusGLSurfaceView_13, ((Double) obj).doubleValue());
                return;
            case 15:
                writer.writeMessage(OplusGLSurfaceView_13, obj);
                return;
            case 16:
                writer.writeBytes(OplusGLSurfaceView_13, (ByteString) obj);
                return;
            case 17:
                if (obj instanceof Internal.EnumLite) {
                    writer.writeEnum(OplusGLSurfaceView_13, ((Internal.EnumLite) obj).getNumber());
                    return;
                } else {
                    if (obj instanceof Integer) {
                        writer.writeEnum(OplusGLSurfaceView_13, ((Integer) obj).intValue());
                        return;
                    }
                    throw new IllegalArgumentException("Unexpected type for enum in map.");
                }
            default:
                throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
        }
    }

    private final void writeSInt64List_Internal(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt64(OplusGLSurfaceView_13, list.get(size2).longValue());
        }
    }

    private final void writeSInt64List_Internal(int OplusGLSurfaceView_13, LongArrayList longArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeSInt64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(OplusGLSurfaceView_13, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt64(OplusGLSurfaceView_13, longArrayList.getLong(size2));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageList(int OplusGLSurfaceView_13, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(OplusGLSurfaceView_13, list.get(size));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageList(int OplusGLSurfaceView_13, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(OplusGLSurfaceView_13, list.get(size), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeGroupList(int OplusGLSurfaceView_13, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(OplusGLSurfaceView_13, list.get(size));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeGroupList(int OplusGLSurfaceView_13, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(OplusGLSurfaceView_13, list.get(size), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int OplusGLSurfaceView_13, Object obj) throws IOException {
        writeTag(1, 4);
        if (obj instanceof ByteString) {
            writeBytes(3, (ByteString) obj);
        } else {
            writeMessage(3, obj);
        }
        writeUInt32(2, OplusGLSurfaceView_13);
        writeTag(1, 3);
    }

    final AllocatedBuffer newHeapBuffer() {
        return this.alloc.allocateHeapBuffer(this.chunkSize);
    }

    final AllocatedBuffer newHeapBuffer(int OplusGLSurfaceView_13) {
        return this.alloc.allocateHeapBuffer(Math.max(OplusGLSurfaceView_13, this.chunkSize));
    }

    final AllocatedBuffer newDirectBuffer() {
        return this.alloc.allocateDirectBuffer(this.chunkSize);
    }

    final AllocatedBuffer newDirectBuffer(int OplusGLSurfaceView_13) {
        return this.alloc.allocateDirectBuffer(Math.max(OplusGLSurfaceView_13, this.chunkSize));
    }

    private static final class SafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private int limit;
        private int limitMinusOne;
        private int offset;
        private int offsetMinusOne;
        private int pos;

        SafeHeapWriter(BufferAllocator bufferAllocator, int OplusGLSurfaceView_13) {
            super(bufferAllocator, OplusGLSurfaceView_13, null);
            nextBuffer();
        }

        @Override // com.google.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                AllocatedBuffer allocatedBuffer = this.allocatedBuffer;
                allocatedBuffer.position((this.pos - allocatedBuffer.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void nextBuffer(int OplusGLSurfaceView_13) {
            nextBuffer(newHeapBuffer(OplusGLSurfaceView_13));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (!allocatedBuffer.hasArray()) {
                throw new RuntimeException("Allocator returned non-heap buffer");
            }
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.allocatedBuffer = allocatedBuffer;
            this.buffer = allocatedBuffer.array();
            int iArrayOffset = allocatedBuffer.arrayOffset();
            this.limit = allocatedBuffer.limit() + iArrayOffset;
            this.offset = iArrayOffset + allocatedBuffer.position();
            this.offsetMinusOne = this.offset - 1;
            this.limitMinusOne = this.limit - 1;
            this.pos = this.limitMinusOne;
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        int spaceLeft() {
            return this.pos - this.offsetMinusOne;
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
            requireSpace(10);
            writeVarint32(i2);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
            requireSpace(15);
            writeInt32(i2);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
            requireSpace(10);
            writeSInt32(i2);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int OplusGLSurfaceView_13, int i2) throws IOException {
            requireSpace(9);
            writeFixed32(i2);
            writeTag(OplusGLSurfaceView_13, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
            requireSpace(15);
            writeVarint64(OplusGLSurfaceView_15);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
            requireSpace(15);
            writeSInt64(OplusGLSurfaceView_15);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
            requireSpace(13);
            writeFixed64(OplusGLSurfaceView_15);
            writeTag(OplusGLSurfaceView_13, 1);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int OplusGLSurfaceView_13, boolean z) throws IOException {
            requireSpace(6);
            write(z ? (byte) 1 : (byte) 0);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int OplusGLSurfaceView_13, String str) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(OplusGLSurfaceView_13, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int OplusGLSurfaceView_13, ByteString byteString) throws IOException {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(OplusGLSurfaceView_13, 2);
            } catch (IOException COUIBaseListPopupWindow_8) {
                throw new RuntimeException(COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int OplusGLSurfaceView_13, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(OplusGLSurfaceView_13, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int OplusGLSurfaceView_13, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(OplusGLSurfaceView_13, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int OplusGLSurfaceView_13, Object obj) throws IOException {
            writeTag(OplusGLSurfaceView_13, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(OplusGLSurfaceView_13, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int OplusGLSurfaceView_13, Object obj, Schema schema) throws IOException {
            writeTag(OplusGLSurfaceView_13, 4);
            schema.writeTo(obj, this);
            writeTag(OplusGLSurfaceView_13, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeStartGroup(int OplusGLSurfaceView_13) {
            writeTag(OplusGLSurfaceView_13, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeEndGroup(int OplusGLSurfaceView_13) {
            writeTag(OplusGLSurfaceView_13, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeInt32(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0) {
                writeVarint32(OplusGLSurfaceView_13);
            } else {
                writeVarint64(OplusGLSurfaceView_13);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt32(int OplusGLSurfaceView_13) {
            writeVarint32(CodedOutputStream.encodeZigZag32(OplusGLSurfaceView_13));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt64(long OplusGLSurfaceView_15) {
            writeVarint64(CodedOutputStream.encodeZigZag64(OplusGLSurfaceView_15));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeBool(boolean z) {
            write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int OplusGLSurfaceView_13, int i2) {
            writeVarint32(WireFormat.makeTag(OplusGLSurfaceView_13, i2));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint32(int OplusGLSurfaceView_13) {
            if ((OplusGLSurfaceView_13 & (-128)) == 0) {
                writeVarint32OneByte(OplusGLSurfaceView_13);
                return;
            }
            if ((OplusGLSurfaceView_13 & (-16384)) == 0) {
                writeVarint32TwoBytes(OplusGLSurfaceView_13);
                return;
            }
            if (((-2097152) & OplusGLSurfaceView_13) == 0) {
                writeVarint32ThreeBytes(OplusGLSurfaceView_13);
            } else if (((-268435456) & OplusGLSurfaceView_13) == 0) {
                writeVarint32FourBytes(OplusGLSurfaceView_13);
            } else {
                writeVarint32FiveBytes(OplusGLSurfaceView_13);
            }
        }

        private void writeVarint32OneByte(int OplusGLSurfaceView_13) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) OplusGLSurfaceView_13;
        }

        private void writeVarint32TwoBytes(int OplusGLSurfaceView_13) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) (OplusGLSurfaceView_13 >>> 7);
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) ((OplusGLSurfaceView_13 & 127) | 128);
        }

        private void writeVarint32ThreeBytes(int OplusGLSurfaceView_13) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) (OplusGLSurfaceView_13 >>> 14);
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) (((OplusGLSurfaceView_13 >>> 7) & 127) | 128);
            int i4 = this.pos;
            this.pos = i4 - 1;
            bArr[i4] = (byte) ((OplusGLSurfaceView_13 & 127) | 128);
        }

        private void writeVarint32FourBytes(int OplusGLSurfaceView_13) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) (OplusGLSurfaceView_13 >>> 21);
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) (((OplusGLSurfaceView_13 >>> 14) & 127) | 128);
            int i4 = this.pos;
            this.pos = i4 - 1;
            bArr[i4] = (byte) (((OplusGLSurfaceView_13 >>> 7) & 127) | 128);
            int i5 = this.pos;
            this.pos = i5 - 1;
            bArr[i5] = (byte) ((OplusGLSurfaceView_13 & 127) | 128);
        }

        private void writeVarint32FiveBytes(int OplusGLSurfaceView_13) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) (OplusGLSurfaceView_13 >>> 28);
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) (((OplusGLSurfaceView_13 >>> 21) & 127) | 128);
            int i4 = this.pos;
            this.pos = i4 - 1;
            bArr[i4] = (byte) (((OplusGLSurfaceView_13 >>> 14) & 127) | 128);
            int i5 = this.pos;
            this.pos = i5 - 1;
            bArr[i5] = (byte) (((OplusGLSurfaceView_13 >>> 7) & 127) | 128);
            int i6 = this.pos;
            this.pos = i6 - 1;
            bArr[i6] = (byte) ((OplusGLSurfaceView_13 & 127) | 128);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint64(long OplusGLSurfaceView_15) {
            switch (BinaryWriter.computeUInt64SizeNoTag(OplusGLSurfaceView_15)) {
                case 1:
                    writeVarint64OneByte(OplusGLSurfaceView_15);
                    break;
                case 2:
                    writeVarint64TwoBytes(OplusGLSurfaceView_15);
                    break;
                case 3:
                    writeVarint64ThreeBytes(OplusGLSurfaceView_15);
                    break;
                case 4:
                    writeVarint64FourBytes(OplusGLSurfaceView_15);
                    break;
                case 5:
                    writeVarint64FiveBytes(OplusGLSurfaceView_15);
                    break;
                case 6:
                    writeVarint64SixBytes(OplusGLSurfaceView_15);
                    break;
                case 7:
                    writeVarint64SevenBytes(OplusGLSurfaceView_15);
                    break;
                case 8:
                    writeVarint64EightBytes(OplusGLSurfaceView_15);
                    break;
                case 9:
                    writeVarint64NineBytes(OplusGLSurfaceView_15);
                    break;
                case 10:
                    writeVarint64TenBytes(OplusGLSurfaceView_15);
                    break;
            }
        }

        private void writeVarint64OneByte(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            bArr[OplusGLSurfaceView_13] = (byte) OplusGLSurfaceView_15;
        }

        private void writeVarint64TwoBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            bArr[OplusGLSurfaceView_13] = (byte) (OplusGLSurfaceView_15 >>> 7);
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) ((((int) OplusGLSurfaceView_15) & 127) | 128);
        }

        private void writeVarint64ThreeBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            bArr[OplusGLSurfaceView_13] = (byte) (((int) OplusGLSurfaceView_15) >>> 14);
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128);
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) ((OplusGLSurfaceView_15 & 127) | 128);
        }

        private void writeVarint64FourBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            bArr[OplusGLSurfaceView_13] = (byte) (OplusGLSurfaceView_15 >>> 21);
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128);
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128);
            int i4 = this.pos;
            this.pos = i4 - 1;
            bArr[i4] = (byte) ((OplusGLSurfaceView_15 & 127) | 128);
        }

        private void writeVarint64FiveBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            bArr[OplusGLSurfaceView_13] = (byte) (OplusGLSurfaceView_15 >>> 28);
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128);
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128);
            int i4 = this.pos;
            this.pos = i4 - 1;
            bArr[i4] = (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128);
            int i5 = this.pos;
            this.pos = i5 - 1;
            bArr[i5] = (byte) ((OplusGLSurfaceView_15 & 127) | 128);
        }

        private void writeVarint64SixBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            bArr[OplusGLSurfaceView_13] = (byte) (OplusGLSurfaceView_15 >>> 35);
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128);
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128);
            int i4 = this.pos;
            this.pos = i4 - 1;
            bArr[i4] = (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128);
            int i5 = this.pos;
            this.pos = i5 - 1;
            bArr[i5] = (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128);
            int i6 = this.pos;
            this.pos = i6 - 1;
            bArr[i6] = (byte) ((OplusGLSurfaceView_15 & 127) | 128);
        }

        private void writeVarint64SevenBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            bArr[OplusGLSurfaceView_13] = (byte) (OplusGLSurfaceView_15 >>> 42);
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) (((OplusGLSurfaceView_15 >>> 35) & 127) | 128);
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128);
            int i4 = this.pos;
            this.pos = i4 - 1;
            bArr[i4] = (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128);
            int i5 = this.pos;
            this.pos = i5 - 1;
            bArr[i5] = (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128);
            int i6 = this.pos;
            this.pos = i6 - 1;
            bArr[i6] = (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128);
            int i7 = this.pos;
            this.pos = i7 - 1;
            bArr[i7] = (byte) ((OplusGLSurfaceView_15 & 127) | 128);
        }

        private void writeVarint64EightBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            bArr[OplusGLSurfaceView_13] = (byte) (OplusGLSurfaceView_15 >>> 49);
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) (((OplusGLSurfaceView_15 >>> 42) & 127) | 128);
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) (((OplusGLSurfaceView_15 >>> 35) & 127) | 128);
            int i4 = this.pos;
            this.pos = i4 - 1;
            bArr[i4] = (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128);
            int i5 = this.pos;
            this.pos = i5 - 1;
            bArr[i5] = (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128);
            int i6 = this.pos;
            this.pos = i6 - 1;
            bArr[i6] = (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128);
            int i7 = this.pos;
            this.pos = i7 - 1;
            bArr[i7] = (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128);
            int i8 = this.pos;
            this.pos = i8 - 1;
            bArr[i8] = (byte) ((OplusGLSurfaceView_15 & 127) | 128);
        }

        private void writeVarint64NineBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            bArr[OplusGLSurfaceView_13] = (byte) (OplusGLSurfaceView_15 >>> 56);
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) (((OplusGLSurfaceView_15 >>> 49) & 127) | 128);
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) (((OplusGLSurfaceView_15 >>> 42) & 127) | 128);
            int i4 = this.pos;
            this.pos = i4 - 1;
            bArr[i4] = (byte) (((OplusGLSurfaceView_15 >>> 35) & 127) | 128);
            int i5 = this.pos;
            this.pos = i5 - 1;
            bArr[i5] = (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128);
            int i6 = this.pos;
            this.pos = i6 - 1;
            bArr[i6] = (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128);
            int i7 = this.pos;
            this.pos = i7 - 1;
            bArr[i7] = (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128);
            int i8 = this.pos;
            this.pos = i8 - 1;
            bArr[i8] = (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128);
            int i9 = this.pos;
            this.pos = i9 - 1;
            bArr[i9] = (byte) ((OplusGLSurfaceView_15 & 127) | 128);
        }

        private void writeVarint64TenBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            bArr[OplusGLSurfaceView_13] = (byte) (OplusGLSurfaceView_15 >>> 63);
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) (((OplusGLSurfaceView_15 >>> 56) & 127) | 128);
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) (((OplusGLSurfaceView_15 >>> 49) & 127) | 128);
            int i4 = this.pos;
            this.pos = i4 - 1;
            bArr[i4] = (byte) (((OplusGLSurfaceView_15 >>> 42) & 127) | 128);
            int i5 = this.pos;
            this.pos = i5 - 1;
            bArr[i5] = (byte) (((OplusGLSurfaceView_15 >>> 35) & 127) | 128);
            int i6 = this.pos;
            this.pos = i6 - 1;
            bArr[i6] = (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128);
            int i7 = this.pos;
            this.pos = i7 - 1;
            bArr[i7] = (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128);
            int i8 = this.pos;
            this.pos = i8 - 1;
            bArr[i8] = (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128);
            int i9 = this.pos;
            this.pos = i9 - 1;
            bArr[i9] = (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128);
            int i10 = this.pos;
            this.pos = i10 - 1;
            bArr[i10] = (byte) ((OplusGLSurfaceView_15 & 127) | 128);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed32(int OplusGLSurfaceView_13) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) ((OplusGLSurfaceView_13 >> 24) & 255);
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) ((OplusGLSurfaceView_13 >> 16) & 255);
            int i4 = this.pos;
            this.pos = i4 - 1;
            bArr[i4] = (byte) ((OplusGLSurfaceView_13 >> 8) & 255);
            int i5 = this.pos;
            this.pos = i5 - 1;
            bArr[i5] = (byte) (OplusGLSurfaceView_13 & 255);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed64(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            bArr[OplusGLSurfaceView_13] = (byte) (((int) (OplusGLSurfaceView_15 >> 56)) & 255);
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) (((int) (OplusGLSurfaceView_15 >> 48)) & 255);
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) (((int) (OplusGLSurfaceView_15 >> 40)) & 255);
            int i4 = this.pos;
            this.pos = i4 - 1;
            bArr[i4] = (byte) (((int) (OplusGLSurfaceView_15 >> 32)) & 255);
            int i5 = this.pos;
            this.pos = i5 - 1;
            bArr[i5] = (byte) (((int) (OplusGLSurfaceView_15 >> 24)) & 255);
            int i6 = this.pos;
            this.pos = i6 - 1;
            bArr[i6] = (byte) (((int) (OplusGLSurfaceView_15 >> 16)) & 255);
            int i7 = this.pos;
            this.pos = i7 - 1;
            bArr[i7] = (byte) (((int) (OplusGLSurfaceView_15 >> 8)) & 255);
            int i8 = this.pos;
            this.pos = i8 - 1;
            bArr[i8] = (byte) (((int) OplusGLSurfaceView_15) & 255);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeString(String str) {
            int OplusGLSurfaceView_13;
            int i2;
            int i3;
            char cCharAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (cCharAt = str.charAt(length)) < 128) {
                this.buffer[this.pos + length] = (byte) cCharAt;
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char cCharAt2 = str.charAt(length);
                if (cCharAt2 < 128 && (i3 = this.pos) > this.offsetMinusOne) {
                    byte[] bArr = this.buffer;
                    this.pos = i3 - 1;
                    bArr[i3] = (byte) cCharAt2;
                } else if (cCharAt2 < 2048 && (i2 = this.pos) > this.offset) {
                    byte[] bArr2 = this.buffer;
                    this.pos = i2 - 1;
                    bArr2[i2] = (byte) ((cCharAt2 & '?') | 128);
                    int i4 = this.pos;
                    this.pos = i4 - 1;
                    bArr2[i4] = (byte) ((cCharAt2 >>> 6) | CameraParameter.VideoFps.FPS_960);
                } else if ((cCharAt2 < 55296 || 57343 < cCharAt2) && (OplusGLSurfaceView_13 = this.pos) > this.offset + 1) {
                    byte[] bArr3 = this.buffer;
                    this.pos = OplusGLSurfaceView_13 - 1;
                    bArr3[OplusGLSurfaceView_13] = (byte) ((cCharAt2 & '?') | 128);
                    int i5 = this.pos;
                    this.pos = i5 - 1;
                    bArr3[i5] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    int i6 = this.pos;
                    this.pos = i6 - 1;
                    bArr3[i6] = (byte) ((cCharAt2 >>> '\COUIBaseListPopupWindow_12') | CameraParameter.VideoFps.FPS_480);
                } else {
                    if (this.pos > this.offset + 2) {
                        if (length != 0) {
                            char cCharAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt2);
                                byte[] bArr4 = this.buffer;
                                int i7 = this.pos;
                                this.pos = i7 - 1;
                                bArr4[i7] = (byte) ((codePoint & 63) | 128);
                                int i8 = this.pos;
                                this.pos = i8 - 1;
                                bArr4[i8] = (byte) (((codePoint >>> 6) & 63) | 128);
                                int i9 = this.pos;
                                this.pos = i9 - 1;
                                bArr4[i9] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i10 = this.pos;
                                this.pos = i10 - 1;
                                bArr4[i10] = (byte) ((codePoint >>> 18) | 240);
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte b2) {
            byte[] bArr = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            bArr[OplusGLSurfaceView_13] = b2;
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
            this.pos -= i2;
            System.arraycopy(bArr, OplusGLSurfaceView_13, this.buffer, this.pos + 1, i2);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
            if (spaceLeft() < i2) {
                this.totalDoneBytes += i2;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, OplusGLSurfaceView_13, i2));
                nextBuffer();
            } else {
                this.pos -= i2;
                System.arraycopy(bArr, OplusGLSurfaceView_13, this.buffer, this.pos + 1, i2);
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                nextBuffer(iRemaining);
            }
            this.pos -= iRemaining;
            byteBuffer.get(this.buffer, this.pos + 1, iRemaining);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                this.totalDoneBytes += iRemaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            this.pos -= iRemaining;
            byteBuffer.get(this.buffer, this.pos + 1, iRemaining);
        }

        @Override // com.google.protobuf.BinaryWriter
        void requireSpace(int OplusGLSurfaceView_13) {
            if (spaceLeft() < OplusGLSurfaceView_13) {
                nextBuffer(OplusGLSurfaceView_13);
            }
        }
    }

    private static final class UnsafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private long limit;
        private long limitMinusOne;
        private long offset;
        private long offsetMinusOne;
        private long pos;

        UnsafeHeapWriter(BufferAllocator bufferAllocator, int OplusGLSurfaceView_13) {
            super(bufferAllocator, OplusGLSurfaceView_13, null);
            nextBuffer();
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeArrayOperations();
        }

        @Override // com.google.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.allocatedBuffer.position((arrayPos() - this.allocatedBuffer.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0L;
                this.limitMinusOne = 0L;
            }
        }

        private int arrayPos() {
            return (int) this.pos;
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void nextBuffer(int OplusGLSurfaceView_13) {
            nextBuffer(newHeapBuffer(OplusGLSurfaceView_13));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (!allocatedBuffer.hasArray()) {
                throw new RuntimeException("Allocator returned non-heap buffer");
            }
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.allocatedBuffer = allocatedBuffer;
            this.buffer = allocatedBuffer.array();
            int iArrayOffset = allocatedBuffer.arrayOffset();
            this.limit = allocatedBuffer.limit() + iArrayOffset;
            this.offset = iArrayOffset + allocatedBuffer.position();
            this.offsetMinusOne = this.offset - 1;
            this.limitMinusOne = this.limit - 1;
            this.pos = this.limitMinusOne;
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        int spaceLeft() {
            return (int) (this.pos - this.offsetMinusOne);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int OplusGLSurfaceView_13, int i2) {
            requireSpace(10);
            writeVarint32(i2);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int OplusGLSurfaceView_13, int i2) {
            requireSpace(15);
            writeInt32(i2);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int OplusGLSurfaceView_13, int i2) {
            requireSpace(10);
            writeSInt32(i2);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int OplusGLSurfaceView_13, int i2) {
            requireSpace(9);
            writeFixed32(i2);
            writeTag(OplusGLSurfaceView_13, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            requireSpace(15);
            writeVarint64(OplusGLSurfaceView_15);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            requireSpace(15);
            writeSInt64(OplusGLSurfaceView_15);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            requireSpace(13);
            writeFixed64(OplusGLSurfaceView_15);
            writeTag(OplusGLSurfaceView_13, 1);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int OplusGLSurfaceView_13, boolean z) {
            requireSpace(6);
            write(z ? (byte) 1 : (byte) 0);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int OplusGLSurfaceView_13, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(OplusGLSurfaceView_13, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int OplusGLSurfaceView_13, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(OplusGLSurfaceView_13, 2);
            } catch (IOException COUIBaseListPopupWindow_8) {
                throw new RuntimeException(COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int OplusGLSurfaceView_13, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(OplusGLSurfaceView_13, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int OplusGLSurfaceView_13, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(OplusGLSurfaceView_13, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int OplusGLSurfaceView_13, Object obj) throws IOException {
            writeTag(OplusGLSurfaceView_13, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(OplusGLSurfaceView_13, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int OplusGLSurfaceView_13, Object obj, Schema schema) throws IOException {
            writeTag(OplusGLSurfaceView_13, 4);
            schema.writeTo(obj, this);
            writeTag(OplusGLSurfaceView_13, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeStartGroup(int OplusGLSurfaceView_13) {
            writeTag(OplusGLSurfaceView_13, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeEndGroup(int OplusGLSurfaceView_13) {
            writeTag(OplusGLSurfaceView_13, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeInt32(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0) {
                writeVarint32(OplusGLSurfaceView_13);
            } else {
                writeVarint64(OplusGLSurfaceView_13);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt32(int OplusGLSurfaceView_13) {
            writeVarint32(CodedOutputStream.encodeZigZag32(OplusGLSurfaceView_13));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt64(long OplusGLSurfaceView_15) {
            writeVarint64(CodedOutputStream.encodeZigZag64(OplusGLSurfaceView_15));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeBool(boolean z) {
            write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int OplusGLSurfaceView_13, int i2) {
            writeVarint32(WireFormat.makeTag(OplusGLSurfaceView_13, i2));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint32(int OplusGLSurfaceView_13) {
            if ((OplusGLSurfaceView_13 & (-128)) == 0) {
                writeVarint32OneByte(OplusGLSurfaceView_13);
                return;
            }
            if ((OplusGLSurfaceView_13 & (-16384)) == 0) {
                writeVarint32TwoBytes(OplusGLSurfaceView_13);
                return;
            }
            if (((-2097152) & OplusGLSurfaceView_13) == 0) {
                writeVarint32ThreeBytes(OplusGLSurfaceView_13);
            } else if (((-268435456) & OplusGLSurfaceView_13) == 0) {
                writeVarint32FourBytes(OplusGLSurfaceView_13);
            } else {
                writeVarint32FiveBytes(OplusGLSurfaceView_13);
            }
        }

        private void writeVarint32OneByte(int OplusGLSurfaceView_13) {
            byte[] bArr = this.buffer;
            long OplusGLSurfaceView_15 = this.pos;
            this.pos = OplusGLSurfaceView_15 - 1;
            UnsafeUtil.putByte(bArr, OplusGLSurfaceView_15, (byte) OplusGLSurfaceView_13);
        }

        private void writeVarint32TwoBytes(int OplusGLSurfaceView_13) {
            byte[] bArr = this.buffer;
            long OplusGLSurfaceView_15 = this.pos;
            this.pos = OplusGLSurfaceView_15 - 1;
            UnsafeUtil.putByte(bArr, OplusGLSurfaceView_15, (byte) (OplusGLSurfaceView_13 >>> 7));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) ((OplusGLSurfaceView_13 & 127) | 128));
        }

        private void writeVarint32ThreeBytes(int OplusGLSurfaceView_13) {
            byte[] bArr = this.buffer;
            long OplusGLSurfaceView_15 = this.pos;
            this.pos = OplusGLSurfaceView_15 - 1;
            UnsafeUtil.putByte(bArr, OplusGLSurfaceView_15, (byte) (OplusGLSurfaceView_13 >>> 14));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) (((OplusGLSurfaceView_13 >>> 7) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr3, j3, (byte) ((OplusGLSurfaceView_13 & 127) | 128));
        }

        private void writeVarint32FourBytes(int OplusGLSurfaceView_13) {
            byte[] bArr = this.buffer;
            long OplusGLSurfaceView_15 = this.pos;
            this.pos = OplusGLSurfaceView_15 - 1;
            UnsafeUtil.putByte(bArr, OplusGLSurfaceView_15, (byte) (OplusGLSurfaceView_13 >>> 21));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) (((OplusGLSurfaceView_13 >>> 14) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr3, j3, (byte) (((OplusGLSurfaceView_13 >>> 7) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr4, j4, (byte) ((OplusGLSurfaceView_13 & 127) | 128));
        }

        private void writeVarint32FiveBytes(int OplusGLSurfaceView_13) {
            byte[] bArr = this.buffer;
            long OplusGLSurfaceView_15 = this.pos;
            this.pos = OplusGLSurfaceView_15 - 1;
            UnsafeUtil.putByte(bArr, OplusGLSurfaceView_15, (byte) (OplusGLSurfaceView_13 >>> 28));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) (((OplusGLSurfaceView_13 >>> 21) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr3, j3, (byte) (((OplusGLSurfaceView_13 >>> 14) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr4, j4, (byte) (((OplusGLSurfaceView_13 >>> 7) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr5, j5, (byte) ((OplusGLSurfaceView_13 & 127) | 128));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint64(long OplusGLSurfaceView_15) {
            switch (BinaryWriter.computeUInt64SizeNoTag(OplusGLSurfaceView_15)) {
                case 1:
                    writeVarint64OneByte(OplusGLSurfaceView_15);
                    break;
                case 2:
                    writeVarint64TwoBytes(OplusGLSurfaceView_15);
                    break;
                case 3:
                    writeVarint64ThreeBytes(OplusGLSurfaceView_15);
                    break;
                case 4:
                    writeVarint64FourBytes(OplusGLSurfaceView_15);
                    break;
                case 5:
                    writeVarint64FiveBytes(OplusGLSurfaceView_15);
                    break;
                case 6:
                    writeVarint64SixBytes(OplusGLSurfaceView_15);
                    break;
                case 7:
                    writeVarint64SevenBytes(OplusGLSurfaceView_15);
                    break;
                case 8:
                    writeVarint64EightBytes(OplusGLSurfaceView_15);
                    break;
                case 9:
                    writeVarint64NineBytes(OplusGLSurfaceView_15);
                    break;
                case 10:
                    writeVarint64TenBytes(OplusGLSurfaceView_15);
                    break;
            }
        }

        private void writeVarint64OneByte(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) OplusGLSurfaceView_15);
        }

        private void writeVarint64TwoBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) (OplusGLSurfaceView_15 >>> 7));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((((int) OplusGLSurfaceView_15) & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) (((int) OplusGLSurfaceView_15) >>> 14));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        private void writeVarint64FourBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) (OplusGLSurfaceView_15 >>> 21));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        private void writeVarint64FiveBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) (OplusGLSurfaceView_15 >>> 28));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        private void writeVarint64SixBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) (OplusGLSurfaceView_15 >>> 35));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        private void writeVarint64SevenBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) (OplusGLSurfaceView_15 >>> 42));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) (((OplusGLSurfaceView_15 >>> 35) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        private void writeVarint64EightBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) (OplusGLSurfaceView_15 >>> 49));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) (((OplusGLSurfaceView_15 >>> 42) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) (((OplusGLSurfaceView_15 >>> 35) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            byte[] bArr8 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr8, j9, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        private void writeVarint64NineBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) (OplusGLSurfaceView_15 >>> 56));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) (((OplusGLSurfaceView_15 >>> 49) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) (((OplusGLSurfaceView_15 >>> 42) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) (((OplusGLSurfaceView_15 >>> 35) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128));
            byte[] bArr8 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr8, j9, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            byte[] bArr9 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr9, j10, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        private void writeVarint64TenBytes(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) (OplusGLSurfaceView_15 >>> 63));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) (((OplusGLSurfaceView_15 >>> 56) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) (((OplusGLSurfaceView_15 >>> 49) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) (((OplusGLSurfaceView_15 >>> 42) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) (((OplusGLSurfaceView_15 >>> 35) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128));
            byte[] bArr8 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr8, j9, (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128));
            byte[] bArr9 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr9, j10, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            byte[] bArr10 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr10, j11, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed32(int OplusGLSurfaceView_13) {
            byte[] bArr = this.buffer;
            long OplusGLSurfaceView_15 = this.pos;
            this.pos = OplusGLSurfaceView_15 - 1;
            UnsafeUtil.putByte(bArr, OplusGLSurfaceView_15, (byte) ((OplusGLSurfaceView_13 >> 24) & 255));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) ((OplusGLSurfaceView_13 >> 16) & 255));
            byte[] bArr3 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr3, j3, (byte) ((OplusGLSurfaceView_13 >> 8) & 255));
            byte[] bArr4 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr4, j4, (byte) (OplusGLSurfaceView_13 & 255));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed64(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) (((int) (OplusGLSurfaceView_15 >> 56)) & 255));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) (((int) (OplusGLSurfaceView_15 >> 48)) & 255));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) (((int) (OplusGLSurfaceView_15 >> 40)) & 255));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) (((int) (OplusGLSurfaceView_15 >> 32)) & 255));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) (((int) (OplusGLSurfaceView_15 >> 24)) & 255));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) (((int) (OplusGLSurfaceView_15 >> 16)) & 255));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) (((int) (OplusGLSurfaceView_15 >> 8)) & 255));
            byte[] bArr8 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr8, j9, (byte) (((int) OplusGLSurfaceView_15) & 255));
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
        @Override // com.google.protobuf.BinaryWriter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void writeString(java.lang.String r13) {
            /*
                Method dump skipped, instructions count: 295
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.BinaryWriter.UnsafeHeapWriter.writeString(java.lang.String):void");
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte b2) {
            byte[] bArr = this.buffer;
            long OplusGLSurfaceView_15 = this.pos;
            this.pos = OplusGLSurfaceView_15 - 1;
            UnsafeUtil.putByte(bArr, OplusGLSurfaceView_15, b2);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
            if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 + i2 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%IntrinsicsJvm.kt_5, offset=%IntrinsicsJvm.kt_5, length=%IntrinsicsJvm.kt_5", Integer.valueOf(bArr.length), Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2)));
            }
            requireSpace(i2);
            this.pos -= i2;
            System.arraycopy(bArr, OplusGLSurfaceView_13, this.buffer, arrayPos() + 1, i2);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
            if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 + i2 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%IntrinsicsJvm.kt_5, offset=%IntrinsicsJvm.kt_5, length=%IntrinsicsJvm.kt_5", Integer.valueOf(bArr.length), Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2)));
            }
            if (spaceLeft() < i2) {
                this.totalDoneBytes += i2;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, OplusGLSurfaceView_13, i2));
                nextBuffer();
            } else {
                this.pos -= i2;
                System.arraycopy(bArr, OplusGLSurfaceView_13, this.buffer, arrayPos() + 1, i2);
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            requireSpace(iRemaining);
            this.pos -= iRemaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, iRemaining);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                this.totalDoneBytes += iRemaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            this.pos -= iRemaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, iRemaining);
        }

        @Override // com.google.protobuf.BinaryWriter
        void requireSpace(int OplusGLSurfaceView_13) {
            if (spaceLeft() < OplusGLSurfaceView_13) {
                nextBuffer(OplusGLSurfaceView_13);
            }
        }
    }

    private static final class SafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private int limitMinusOne;
        private int pos;

        SafeDirectWriter(BufferAllocator bufferAllocator, int OplusGLSurfaceView_13) {
            super(bufferAllocator, OplusGLSurfaceView_13, null);
            nextBuffer();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private void nextBuffer(int OplusGLSurfaceView_13) {
            nextBuffer(newDirectBuffer(OplusGLSurfaceView_13));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (!allocatedBuffer.hasNioBuffer()) {
                throw new RuntimeException("Allocated buffer does not have NIO buffer");
            }
            ByteBuffer byteBufferNioBuffer = allocatedBuffer.nioBuffer();
            if (!byteBufferNioBuffer.isDirect()) {
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.buffer = byteBufferNioBuffer;
            ByteBuffer byteBuffer = this.buffer;
            byteBuffer.limit(byteBuffer.capacity());
            this.buffer.position(0);
            this.buffer.order(ByteOrder.LITTLE_ENDIAN);
            this.limitMinusOne = this.buffer.limit() - 1;
            this.pos = this.limitMinusOne;
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        private int spaceLeft() {
            return this.pos + 1;
        }

        @Override // com.google.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.buffer.position(this.pos + 1);
                this.buffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int OplusGLSurfaceView_13, int i2) {
            requireSpace(10);
            writeVarint32(i2);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int OplusGLSurfaceView_13, int i2) {
            requireSpace(15);
            writeInt32(i2);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int OplusGLSurfaceView_13, int i2) {
            requireSpace(10);
            writeSInt32(i2);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int OplusGLSurfaceView_13, int i2) {
            requireSpace(9);
            writeFixed32(i2);
            writeTag(OplusGLSurfaceView_13, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            requireSpace(15);
            writeVarint64(OplusGLSurfaceView_15);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            requireSpace(15);
            writeSInt64(OplusGLSurfaceView_15);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            requireSpace(13);
            writeFixed64(OplusGLSurfaceView_15);
            writeTag(OplusGLSurfaceView_13, 1);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int OplusGLSurfaceView_13, boolean z) {
            requireSpace(6);
            write(z ? (byte) 1 : (byte) 0);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int OplusGLSurfaceView_13, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(OplusGLSurfaceView_13, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int OplusGLSurfaceView_13, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(OplusGLSurfaceView_13, 2);
            } catch (IOException COUIBaseListPopupWindow_8) {
                throw new RuntimeException(COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int OplusGLSurfaceView_13, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(OplusGLSurfaceView_13, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int OplusGLSurfaceView_13, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(OplusGLSurfaceView_13, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int OplusGLSurfaceView_13, Object obj) throws IOException {
            writeTag(OplusGLSurfaceView_13, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(OplusGLSurfaceView_13, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int OplusGLSurfaceView_13, Object obj, Schema schema) throws IOException {
            writeTag(OplusGLSurfaceView_13, 4);
            schema.writeTo(obj, this);
            writeTag(OplusGLSurfaceView_13, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeStartGroup(int OplusGLSurfaceView_13) {
            writeTag(OplusGLSurfaceView_13, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeEndGroup(int OplusGLSurfaceView_13) {
            writeTag(OplusGLSurfaceView_13, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeInt32(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0) {
                writeVarint32(OplusGLSurfaceView_13);
            } else {
                writeVarint64(OplusGLSurfaceView_13);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt32(int OplusGLSurfaceView_13) {
            writeVarint32(CodedOutputStream.encodeZigZag32(OplusGLSurfaceView_13));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt64(long OplusGLSurfaceView_15) {
            writeVarint64(CodedOutputStream.encodeZigZag64(OplusGLSurfaceView_15));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeBool(boolean z) {
            write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int OplusGLSurfaceView_13, int i2) {
            writeVarint32(WireFormat.makeTag(OplusGLSurfaceView_13, i2));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint32(int OplusGLSurfaceView_13) {
            if ((OplusGLSurfaceView_13 & (-128)) == 0) {
                writeVarint32OneByte(OplusGLSurfaceView_13);
                return;
            }
            if ((OplusGLSurfaceView_13 & (-16384)) == 0) {
                writeVarint32TwoBytes(OplusGLSurfaceView_13);
                return;
            }
            if (((-2097152) & OplusGLSurfaceView_13) == 0) {
                writeVarint32ThreeBytes(OplusGLSurfaceView_13);
            } else if (((-268435456) & OplusGLSurfaceView_13) == 0) {
                writeVarint32FourBytes(OplusGLSurfaceView_13);
            } else {
                writeVarint32FiveBytes(OplusGLSurfaceView_13);
            }
        }

        private void writeVarint32OneByte(int OplusGLSurfaceView_13) {
            ByteBuffer byteBuffer = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            byteBuffer.put(i2, (byte) OplusGLSurfaceView_13);
        }

        private void writeVarint32TwoBytes(int OplusGLSurfaceView_13) {
            this.pos -= 2;
            this.buffer.putShort(this.pos + 1, (short) ((OplusGLSurfaceView_13 & 127) | 128 | ((OplusGLSurfaceView_13 & 16256) << 1)));
        }

        private void writeVarint32ThreeBytes(int OplusGLSurfaceView_13) {
            this.pos -= 3;
            this.buffer.putInt(this.pos, (((OplusGLSurfaceView_13 & 127) | 128) << 8) | ((2080768 & OplusGLSurfaceView_13) << 10) | (((OplusGLSurfaceView_13 & 16256) | 16384) << 9));
        }

        private void writeVarint32FourBytes(int OplusGLSurfaceView_13) {
            this.pos -= 4;
            this.buffer.putInt(this.pos + 1, (OplusGLSurfaceView_13 & 127) | 128 | ((266338304 & OplusGLSurfaceView_13) << 3) | (((2080768 & OplusGLSurfaceView_13) | PreCacheConfig.DEFAULT_MAX_CACHE_FILE_SIZE) << 2) | (((OplusGLSurfaceView_13 & 16256) | 16384) << 1));
        }

        private void writeVarint32FiveBytes(int OplusGLSurfaceView_13) {
            ByteBuffer byteBuffer = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            byteBuffer.put(i2, (byte) (OplusGLSurfaceView_13 >>> 28));
            this.pos -= 4;
            this.buffer.putInt(this.pos + 1, (OplusGLSurfaceView_13 & 127) | 128 | ((((OplusGLSurfaceView_13 >>> 21) & 127) | 128) << 24) | ((((OplusGLSurfaceView_13 >>> 14) & 127) | 128) << 16) | ((((OplusGLSurfaceView_13 >>> 7) & 127) | 128) << 8));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint64(long OplusGLSurfaceView_15) {
            switch (BinaryWriter.computeUInt64SizeNoTag(OplusGLSurfaceView_15)) {
                case 1:
                    writeVarint64OneByte(OplusGLSurfaceView_15);
                    break;
                case 2:
                    writeVarint64TwoBytes(OplusGLSurfaceView_15);
                    break;
                case 3:
                    writeVarint64ThreeBytes(OplusGLSurfaceView_15);
                    break;
                case 4:
                    writeVarint64FourBytes(OplusGLSurfaceView_15);
                    break;
                case 5:
                    writeVarint64FiveBytes(OplusGLSurfaceView_15);
                    break;
                case 6:
                    writeVarint64SixBytes(OplusGLSurfaceView_15);
                    break;
                case 7:
                    writeVarint64SevenBytes(OplusGLSurfaceView_15);
                    break;
                case 8:
                    writeVarint64EightBytes(OplusGLSurfaceView_15);
                    break;
                case 9:
                    writeVarint64NineBytes(OplusGLSurfaceView_15);
                    break;
                case 10:
                    writeVarint64TenBytes(OplusGLSurfaceView_15);
                    break;
            }
        }

        private void writeVarint64OneByte(long OplusGLSurfaceView_15) {
            writeVarint32OneByte((int) OplusGLSurfaceView_15);
        }

        private void writeVarint64TwoBytes(long OplusGLSurfaceView_15) {
            writeVarint32TwoBytes((int) OplusGLSurfaceView_15);
        }

        private void writeVarint64ThreeBytes(long OplusGLSurfaceView_15) {
            writeVarint32ThreeBytes((int) OplusGLSurfaceView_15);
        }

        private void writeVarint64FourBytes(long OplusGLSurfaceView_15) {
            writeVarint32FourBytes((int) OplusGLSurfaceView_15);
        }

        private void writeVarint64FiveBytes(long OplusGLSurfaceView_15) {
            this.pos -= 5;
            this.buffer.putLong(this.pos - 2, (((OplusGLSurfaceView_15 & 127) | 128) << 24) | ((34091302912L & OplusGLSurfaceView_15) << 28) | (((266338304 & OplusGLSurfaceView_15) | 268435456) << 27) | (((2080768 & OplusGLSurfaceView_15) | 2097152) << 26) | (((16256 & OplusGLSurfaceView_15) | 16384) << 25));
        }

        private void writeVarint64SixBytes(long OplusGLSurfaceView_15) {
            this.pos -= 6;
            this.buffer.putLong(this.pos - 1, (((OplusGLSurfaceView_15 & 127) | 128) << 16) | ((4363686772736L & OplusGLSurfaceView_15) << 21) | (((34091302912L & OplusGLSurfaceView_15) | STMobileHumanActionNative.ST_MOBILE_BODY_ACTION4) << 20) | (((266338304 & OplusGLSurfaceView_15) | 268435456) << 19) | (((2080768 & OplusGLSurfaceView_15) | 2097152) << 18) | (((16256 & OplusGLSurfaceView_15) | 16384) << 17));
        }

        private void writeVarint64SevenBytes(long OplusGLSurfaceView_15) {
            this.pos -= 7;
            this.buffer.putLong(this.pos, (((OplusGLSurfaceView_15 & 127) | 128) << 8) | ((558551906910208L & OplusGLSurfaceView_15) << 14) | (((4363686772736L & OplusGLSurfaceView_15) | 4398046511104L) << 13) | (((34091302912L & OplusGLSurfaceView_15) | STMobileHumanActionNative.ST_MOBILE_BODY_ACTION4) << 12) | (((266338304 & OplusGLSurfaceView_15) | 268435456) << 11) | (((2080768 & OplusGLSurfaceView_15) | 2097152) << 10) | (((16256 & OplusGLSurfaceView_15) | 16384) << 9));
        }

        private void writeVarint64EightBytes(long OplusGLSurfaceView_15) {
            this.pos -= 8;
            this.buffer.putLong(this.pos + 1, (OplusGLSurfaceView_15 & 127) | 128 | ((71494644084506624L & OplusGLSurfaceView_15) << 7) | (((558551906910208L & OplusGLSurfaceView_15) | 562949953421312L) << 6) | (((4363686772736L & OplusGLSurfaceView_15) | 4398046511104L) << 5) | (((34091302912L & OplusGLSurfaceView_15) | STMobileHumanActionNative.ST_MOBILE_BODY_ACTION4) << 4) | (((266338304 & OplusGLSurfaceView_15) | 268435456) << 3) | (((2080768 & OplusGLSurfaceView_15) | 2097152) << 2) | (((16256 & OplusGLSurfaceView_15) | 16384) << 1));
        }

        private void writeVarint64EightBytesWithSign(long OplusGLSurfaceView_15) {
            this.pos -= 8;
            this.buffer.putLong(this.pos + 1, (OplusGLSurfaceView_15 & 127) | 128 | (((71494644084506624L & OplusGLSurfaceView_15) | 72057594037927936L) << 7) | (((558551906910208L & OplusGLSurfaceView_15) | 562949953421312L) << 6) | (((4363686772736L & OplusGLSurfaceView_15) | 4398046511104L) << 5) | (((34091302912L & OplusGLSurfaceView_15) | STMobileHumanActionNative.ST_MOBILE_BODY_ACTION4) << 4) | (((266338304 & OplusGLSurfaceView_15) | 268435456) << 3) | (((2080768 & OplusGLSurfaceView_15) | 2097152) << 2) | (((16256 & OplusGLSurfaceView_15) | 16384) << 1));
        }

        private void writeVarint64NineBytes(long OplusGLSurfaceView_15) {
            ByteBuffer byteBuffer = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            byteBuffer.put(OplusGLSurfaceView_13, (byte) (OplusGLSurfaceView_15 >>> 56));
            writeVarint64EightBytesWithSign(OplusGLSurfaceView_15 & 72057594037927935L);
        }

        private void writeVarint64TenBytes(long OplusGLSurfaceView_15) {
            ByteBuffer byteBuffer = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            byteBuffer.put(OplusGLSurfaceView_13, (byte) (OplusGLSurfaceView_15 >>> 63));
            ByteBuffer byteBuffer2 = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            byteBuffer2.put(i2, (byte) (((OplusGLSurfaceView_15 >>> 56) & 127) | 128));
            writeVarint64EightBytesWithSign(OplusGLSurfaceView_15 & 72057594037927935L);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed32(int OplusGLSurfaceView_13) {
            this.pos -= 4;
            this.buffer.putInt(this.pos + 1, OplusGLSurfaceView_13);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed64(long OplusGLSurfaceView_15) {
            this.pos -= 8;
            this.buffer.putLong(this.pos + 1, OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeString(String str) {
            int OplusGLSurfaceView_13;
            int i2;
            int i3;
            char cCharAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (cCharAt = str.charAt(length)) < 128) {
                this.buffer.put(this.pos + length, (byte) cCharAt);
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char cCharAt2 = str.charAt(length);
                if (cCharAt2 < 128 && (i3 = this.pos) >= 0) {
                    ByteBuffer byteBuffer = this.buffer;
                    this.pos = i3 - 1;
                    byteBuffer.put(i3, (byte) cCharAt2);
                } else if (cCharAt2 < 2048 && (i2 = this.pos) > 0) {
                    ByteBuffer byteBuffer2 = this.buffer;
                    this.pos = i2 - 1;
                    byteBuffer2.put(i2, (byte) ((cCharAt2 & '?') | 128));
                    ByteBuffer byteBuffer3 = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 - 1;
                    byteBuffer3.put(i4, (byte) ((cCharAt2 >>> 6) | CameraParameter.VideoFps.FPS_960));
                } else if ((cCharAt2 < 55296 || 57343 < cCharAt2) && (OplusGLSurfaceView_13 = this.pos) > 1) {
                    ByteBuffer byteBuffer4 = this.buffer;
                    this.pos = OplusGLSurfaceView_13 - 1;
                    byteBuffer4.put(OplusGLSurfaceView_13, (byte) ((cCharAt2 & '?') | 128));
                    ByteBuffer byteBuffer5 = this.buffer;
                    int i5 = this.pos;
                    this.pos = i5 - 1;
                    byteBuffer5.put(i5, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    ByteBuffer byteBuffer6 = this.buffer;
                    int i6 = this.pos;
                    this.pos = i6 - 1;
                    byteBuffer6.put(i6, (byte) ((cCharAt2 >>> '\COUIBaseListPopupWindow_12') | CameraParameter.VideoFps.FPS_480));
                } else {
                    if (this.pos > 2) {
                        if (length != 0) {
                            char cCharAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt2);
                                ByteBuffer byteBuffer7 = this.buffer;
                                int i7 = this.pos;
                                this.pos = i7 - 1;
                                byteBuffer7.put(i7, (byte) ((codePoint & 63) | 128));
                                ByteBuffer byteBuffer8 = this.buffer;
                                int i8 = this.pos;
                                this.pos = i8 - 1;
                                byteBuffer8.put(i8, (byte) (((codePoint >>> 6) & 63) | 128));
                                ByteBuffer byteBuffer9 = this.buffer;
                                int i9 = this.pos;
                                this.pos = i9 - 1;
                                byteBuffer9.put(i9, (byte) (((codePoint >>> 12) & 63) | 128));
                                ByteBuffer byteBuffer10 = this.buffer;
                                int i10 = this.pos;
                                this.pos = i10 - 1;
                                byteBuffer10.put(i10, (byte) ((codePoint >>> 18) | 240));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte b2) {
            ByteBuffer byteBuffer = this.buffer;
            int OplusGLSurfaceView_13 = this.pos;
            this.pos = OplusGLSurfaceView_13 - 1;
            byteBuffer.put(OplusGLSurfaceView_13, b2);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
            this.pos -= i2;
            this.buffer.position(this.pos + 1);
            this.buffer.put(bArr, OplusGLSurfaceView_13, i2);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
            if (spaceLeft() < i2) {
                this.totalDoneBytes += i2;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, OplusGLSurfaceView_13, i2));
                nextBuffer();
            } else {
                this.pos -= i2;
                this.buffer.position(this.pos + 1);
                this.buffer.put(bArr, OplusGLSurfaceView_13, i2);
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                nextBuffer(iRemaining);
            }
            this.pos -= iRemaining;
            this.buffer.position(this.pos + 1);
            this.buffer.put(byteBuffer);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                this.totalDoneBytes += iRemaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            } else {
                this.pos -= iRemaining;
                this.buffer.position(this.pos + 1);
                this.buffer.put(byteBuffer);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        void requireSpace(int OplusGLSurfaceView_13) {
            if (spaceLeft() < OplusGLSurfaceView_13) {
                nextBuffer(OplusGLSurfaceView_13);
            }
        }
    }

    private static final class UnsafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private long bufferOffset;
        private long limitMinusOne;
        private long pos;

        UnsafeDirectWriter(BufferAllocator bufferAllocator, int OplusGLSurfaceView_13) {
            super(bufferAllocator, OplusGLSurfaceView_13, null);
            nextBuffer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private void nextBuffer(int OplusGLSurfaceView_13) {
            nextBuffer(newDirectBuffer(OplusGLSurfaceView_13));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (!allocatedBuffer.hasNioBuffer()) {
                throw new RuntimeException("Allocated buffer does not have NIO buffer");
            }
            ByteBuffer byteBufferNioBuffer = allocatedBuffer.nioBuffer();
            if (!byteBufferNioBuffer.isDirect()) {
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.buffer = byteBufferNioBuffer;
            ByteBuffer byteBuffer = this.buffer;
            byteBuffer.limit(byteBuffer.capacity());
            this.buffer.position(0);
            this.bufferOffset = UnsafeUtil.addressOffset(this.buffer);
            this.limitMinusOne = this.bufferOffset + (this.buffer.limit() - 1);
            this.pos = this.limitMinusOne;
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        private int spaceLeft() {
            return bufferPos() + 1;
        }

        @Override // com.google.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.buffer.position(bufferPos() + 1);
                this.buffer = null;
                this.pos = 0L;
                this.limitMinusOne = 0L;
            }
        }

        private int bufferPos() {
            return (int) (this.pos - this.bufferOffset);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int OplusGLSurfaceView_13, int i2) {
            requireSpace(10);
            writeVarint32(i2);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int OplusGLSurfaceView_13, int i2) {
            requireSpace(15);
            writeInt32(i2);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int OplusGLSurfaceView_13, int i2) {
            requireSpace(10);
            writeSInt32(i2);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int OplusGLSurfaceView_13, int i2) {
            requireSpace(9);
            writeFixed32(i2);
            writeTag(OplusGLSurfaceView_13, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            requireSpace(15);
            writeVarint64(OplusGLSurfaceView_15);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            requireSpace(15);
            writeSInt64(OplusGLSurfaceView_15);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            requireSpace(13);
            writeFixed64(OplusGLSurfaceView_15);
            writeTag(OplusGLSurfaceView_13, 1);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int OplusGLSurfaceView_13, boolean z) {
            requireSpace(6);
            write(z ? (byte) 1 : (byte) 0);
            writeTag(OplusGLSurfaceView_13, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int OplusGLSurfaceView_13, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(OplusGLSurfaceView_13, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int OplusGLSurfaceView_13, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(OplusGLSurfaceView_13, 2);
            } catch (IOException COUIBaseListPopupWindow_8) {
                throw new RuntimeException(COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int OplusGLSurfaceView_13, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(OplusGLSurfaceView_13, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int OplusGLSurfaceView_13, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(OplusGLSurfaceView_13, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int OplusGLSurfaceView_13, Object obj) throws IOException {
            writeTag(OplusGLSurfaceView_13, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(OplusGLSurfaceView_13, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int OplusGLSurfaceView_13, Object obj, Schema schema) throws IOException {
            writeTag(OplusGLSurfaceView_13, 4);
            schema.writeTo(obj, this);
            writeTag(OplusGLSurfaceView_13, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeStartGroup(int OplusGLSurfaceView_13) {
            writeTag(OplusGLSurfaceView_13, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeEndGroup(int OplusGLSurfaceView_13) {
            writeTag(OplusGLSurfaceView_13, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeInt32(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0) {
                writeVarint32(OplusGLSurfaceView_13);
            } else {
                writeVarint64(OplusGLSurfaceView_13);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt32(int OplusGLSurfaceView_13) {
            writeVarint32(CodedOutputStream.encodeZigZag32(OplusGLSurfaceView_13));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt64(long OplusGLSurfaceView_15) {
            writeVarint64(CodedOutputStream.encodeZigZag64(OplusGLSurfaceView_15));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeBool(boolean z) {
            write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int OplusGLSurfaceView_13, int i2) {
            writeVarint32(WireFormat.makeTag(OplusGLSurfaceView_13, i2));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint32(int OplusGLSurfaceView_13) {
            if ((OplusGLSurfaceView_13 & (-128)) == 0) {
                writeVarint32OneByte(OplusGLSurfaceView_13);
                return;
            }
            if ((OplusGLSurfaceView_13 & (-16384)) == 0) {
                writeVarint32TwoBytes(OplusGLSurfaceView_13);
                return;
            }
            if (((-2097152) & OplusGLSurfaceView_13) == 0) {
                writeVarint32ThreeBytes(OplusGLSurfaceView_13);
            } else if (((-268435456) & OplusGLSurfaceView_13) == 0) {
                writeVarint32FourBytes(OplusGLSurfaceView_13);
            } else {
                writeVarint32FiveBytes(OplusGLSurfaceView_13);
            }
        }

        private void writeVarint32OneByte(int OplusGLSurfaceView_13) {
            long OplusGLSurfaceView_15 = this.pos;
            this.pos = OplusGLSurfaceView_15 - 1;
            UnsafeUtil.putByte(OplusGLSurfaceView_15, (byte) OplusGLSurfaceView_13);
        }

        private void writeVarint32TwoBytes(int OplusGLSurfaceView_13) {
            long OplusGLSurfaceView_15 = this.pos;
            this.pos = OplusGLSurfaceView_15 - 1;
            UnsafeUtil.putByte(OplusGLSurfaceView_15, (byte) (OplusGLSurfaceView_13 >>> 7));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((OplusGLSurfaceView_13 & 127) | 128));
        }

        private void writeVarint32ThreeBytes(int OplusGLSurfaceView_13) {
            long OplusGLSurfaceView_15 = this.pos;
            this.pos = OplusGLSurfaceView_15 - 1;
            UnsafeUtil.putByte(OplusGLSurfaceView_15, (byte) (OplusGLSurfaceView_13 >>> 14));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((OplusGLSurfaceView_13 >>> 7) & 127) | 128));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((OplusGLSurfaceView_13 & 127) | 128));
        }

        private void writeVarint32FourBytes(int OplusGLSurfaceView_13) {
            long OplusGLSurfaceView_15 = this.pos;
            this.pos = OplusGLSurfaceView_15 - 1;
            UnsafeUtil.putByte(OplusGLSurfaceView_15, (byte) (OplusGLSurfaceView_13 >>> 21));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((OplusGLSurfaceView_13 >>> 14) & 127) | 128));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((OplusGLSurfaceView_13 >>> 7) & 127) | 128));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((OplusGLSurfaceView_13 & 127) | 128));
        }

        private void writeVarint32FiveBytes(int OplusGLSurfaceView_13) {
            long OplusGLSurfaceView_15 = this.pos;
            this.pos = OplusGLSurfaceView_15 - 1;
            UnsafeUtil.putByte(OplusGLSurfaceView_15, (byte) (OplusGLSurfaceView_13 >>> 28));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((OplusGLSurfaceView_13 >>> 21) & 127) | 128));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((OplusGLSurfaceView_13 >>> 14) & 127) | 128));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((OplusGLSurfaceView_13 >>> 7) & 127) | 128));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((OplusGLSurfaceView_13 & 127) | 128));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint64(long OplusGLSurfaceView_15) {
            switch (BinaryWriter.computeUInt64SizeNoTag(OplusGLSurfaceView_15)) {
                case 1:
                    writeVarint64OneByte(OplusGLSurfaceView_15);
                    break;
                case 2:
                    writeVarint64TwoBytes(OplusGLSurfaceView_15);
                    break;
                case 3:
                    writeVarint64ThreeBytes(OplusGLSurfaceView_15);
                    break;
                case 4:
                    writeVarint64FourBytes(OplusGLSurfaceView_15);
                    break;
                case 5:
                    writeVarint64FiveBytes(OplusGLSurfaceView_15);
                    break;
                case 6:
                    writeVarint64SixBytes(OplusGLSurfaceView_15);
                    break;
                case 7:
                    writeVarint64SevenBytes(OplusGLSurfaceView_15);
                    break;
                case 8:
                    writeVarint64EightBytes(OplusGLSurfaceView_15);
                    break;
                case 9:
                    writeVarint64NineBytes(OplusGLSurfaceView_15);
                    break;
                case 10:
                    writeVarint64TenBytes(OplusGLSurfaceView_15);
                    break;
            }
        }

        private void writeVarint64OneByte(long OplusGLSurfaceView_15) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) OplusGLSurfaceView_15);
        }

        private void writeVarint64TwoBytes(long OplusGLSurfaceView_15) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (OplusGLSurfaceView_15 >>> 7));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((((int) OplusGLSurfaceView_15) & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long OplusGLSurfaceView_15) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((int) OplusGLSurfaceView_15) >>> 14));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        private void writeVarint64FourBytes(long OplusGLSurfaceView_15) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (OplusGLSurfaceView_15 >>> 21));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        private void writeVarint64FiveBytes(long OplusGLSurfaceView_15) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (OplusGLSurfaceView_15 >>> 28));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        private void writeVarint64SixBytes(long OplusGLSurfaceView_15) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (OplusGLSurfaceView_15 >>> 35));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        private void writeVarint64SevenBytes(long OplusGLSurfaceView_15) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (OplusGLSurfaceView_15 >>> 42));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((OplusGLSurfaceView_15 >>> 35) & 127) | 128));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        private void writeVarint64EightBytes(long OplusGLSurfaceView_15) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (OplusGLSurfaceView_15 >>> 49));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((OplusGLSurfaceView_15 >>> 42) & 127) | 128));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((OplusGLSurfaceView_15 >>> 35) & 127) | 128));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        private void writeVarint64NineBytes(long OplusGLSurfaceView_15) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (OplusGLSurfaceView_15 >>> 56));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((OplusGLSurfaceView_15 >>> 49) & 127) | 128));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((OplusGLSurfaceView_15 >>> 42) & 127) | 128));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((OplusGLSurfaceView_15 >>> 35) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        private void writeVarint64TenBytes(long OplusGLSurfaceView_15) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (OplusGLSurfaceView_15 >>> 63));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((OplusGLSurfaceView_15 >>> 56) & 127) | 128));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((OplusGLSurfaceView_15 >>> 49) & 127) | 128));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((OplusGLSurfaceView_15 >>> 42) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((OplusGLSurfaceView_15 >>> 35) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((OplusGLSurfaceView_15 >>> 28) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((OplusGLSurfaceView_15 >>> 21) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((OplusGLSurfaceView_15 >>> 14) & 127) | 128));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (((OplusGLSurfaceView_15 >>> 7) & 127) | 128));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) ((OplusGLSurfaceView_15 & 127) | 128));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed32(int OplusGLSurfaceView_13) {
            long OplusGLSurfaceView_15 = this.pos;
            this.pos = OplusGLSurfaceView_15 - 1;
            UnsafeUtil.putByte(OplusGLSurfaceView_15, (byte) ((OplusGLSurfaceView_13 >> 24) & 255));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((OplusGLSurfaceView_13 >> 16) & 255));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((OplusGLSurfaceView_13 >> 8) & 255));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (OplusGLSurfaceView_13 & 255));
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed64(long OplusGLSurfaceView_15) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((int) (OplusGLSurfaceView_15 >> 56)) & 255));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((int) (OplusGLSurfaceView_15 >> 48)) & 255));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((int) (OplusGLSurfaceView_15 >> 40)) & 255));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((int) (OplusGLSurfaceView_15 >> 32)) & 255));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((int) (OplusGLSurfaceView_15 >> 24)) & 255));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((int) (OplusGLSurfaceView_15 >> 16)) & 255));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((int) (OplusGLSurfaceView_15 >> 8)) & 255));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((int) OplusGLSurfaceView_15) & 255));
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
        @Override // com.google.protobuf.BinaryWriter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void writeString(java.lang.String r13) {
            /*
                Method dump skipped, instructions count: 273
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.BinaryWriter.UnsafeDirectWriter.writeString(java.lang.String):void");
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte b2) {
            long OplusGLSurfaceView_15 = this.pos;
            this.pos = OplusGLSurfaceView_15 - 1;
            UnsafeUtil.putByte(OplusGLSurfaceView_15, b2);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
            this.pos -= i2;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(bArr, OplusGLSurfaceView_13, i2);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
            if (spaceLeft() < i2) {
                this.totalDoneBytes += i2;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, OplusGLSurfaceView_13, i2));
                nextBuffer();
            } else {
                this.pos -= i2;
                this.buffer.position(bufferPos() + 1);
                this.buffer.put(bArr, OplusGLSurfaceView_13, i2);
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                nextBuffer(iRemaining);
            }
            this.pos -= iRemaining;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(byteBuffer);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                this.totalDoneBytes += iRemaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            } else {
                this.pos -= iRemaining;
                this.buffer.position(bufferPos() + 1);
                this.buffer.put(byteBuffer);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        void requireSpace(int OplusGLSurfaceView_13) {
            if (spaceLeft() < OplusGLSurfaceView_13) {
                nextBuffer(OplusGLSurfaceView_13);
            }
        }
    }
}
