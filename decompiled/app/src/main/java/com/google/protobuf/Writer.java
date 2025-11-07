package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
interface Writer {

    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    FieldOrder fieldOrder();

    void writeBool(int OplusGLSurfaceView_13, boolean z) throws IOException;

    void writeBoolList(int OplusGLSurfaceView_13, List<Boolean> list, boolean z) throws IOException;

    void writeBytes(int OplusGLSurfaceView_13, ByteString byteString) throws IOException;

    void writeBytesList(int OplusGLSurfaceView_13, List<ByteString> list) throws IOException;

    void writeDouble(int OplusGLSurfaceView_13, double IntrinsicsJvm.kt_5) throws IOException;

    void writeDoubleList(int OplusGLSurfaceView_13, List<Double> list, boolean z) throws IOException;

    @Deprecated
    void writeEndGroup(int OplusGLSurfaceView_13) throws IOException;

    void writeEnum(int OplusGLSurfaceView_13, int i2) throws IOException;

    void writeEnumList(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException;

    void writeFixed32(int OplusGLSurfaceView_13, int i2) throws IOException;

    void writeFixed32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException;

    void writeFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException;

    void writeFixed64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException;

    void writeFloat(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) throws IOException;

    void writeFloatList(int OplusGLSurfaceView_13, List<Float> list, boolean z) throws IOException;

    @Deprecated
    void writeGroup(int OplusGLSurfaceView_13, Object obj) throws IOException;

    @Deprecated
    void writeGroup(int OplusGLSurfaceView_13, Object obj, Schema schema) throws IOException;

    @Deprecated
    void writeGroupList(int OplusGLSurfaceView_13, List<?> list) throws IOException;

    @Deprecated
    void writeGroupList(int OplusGLSurfaceView_13, List<?> list, Schema schema) throws IOException;

    void writeInt32(int OplusGLSurfaceView_13, int i2) throws IOException;

    void writeInt32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException;

    void writeInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException;

    void writeInt64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException;

    <K, V> void writeMap(int OplusGLSurfaceView_13, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException;

    void writeMessage(int OplusGLSurfaceView_13, Object obj) throws IOException;

    void writeMessage(int OplusGLSurfaceView_13, Object obj, Schema schema) throws IOException;

    void writeMessageList(int OplusGLSurfaceView_13, List<?> list) throws IOException;

    void writeMessageList(int OplusGLSurfaceView_13, List<?> list, Schema schema) throws IOException;

    void writeMessageSetItem(int OplusGLSurfaceView_13, Object obj) throws IOException;

    void writeSFixed32(int OplusGLSurfaceView_13, int i2) throws IOException;

    void writeSFixed32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException;

    void writeSFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException;

    void writeSFixed64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException;

    void writeSInt32(int OplusGLSurfaceView_13, int i2) throws IOException;

    void writeSInt32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException;

    void writeSInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException;

    void writeSInt64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException;

    @Deprecated
    void writeStartGroup(int OplusGLSurfaceView_13) throws IOException;

    void writeString(int OplusGLSurfaceView_13, String str) throws IOException;

    void writeStringList(int OplusGLSurfaceView_13, List<String> list) throws IOException;

    void writeUInt32(int OplusGLSurfaceView_13, int i2) throws IOException;

    void writeUInt32List(int OplusGLSurfaceView_13, List<Integer> list, boolean z) throws IOException;

    void writeUInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException;

    void writeUInt64List(int OplusGLSurfaceView_13, List<Long> list, boolean z) throws IOException;
}
