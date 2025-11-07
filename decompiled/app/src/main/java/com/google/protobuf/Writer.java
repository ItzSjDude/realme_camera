package com.google.protobuf;

/* loaded from: classes.dex */
interface Writer {

    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    com.google.protobuf.Writer.FieldOrder fieldOrder();

    void writeBool(int i_renamed, boolean z_renamed) throws java.io.IOException;

    void writeBoolList(int i_renamed, java.util.List<java.lang.Boolean> list, boolean z_renamed) throws java.io.IOException;

    void writeBytes(int i_renamed, com.google.protobuf.ByteString byteString) throws java.io.IOException;

    void writeBytesList(int i_renamed, java.util.List<com.google.protobuf.ByteString> list) throws java.io.IOException;

    void writeDouble(int i_renamed, double d_renamed) throws java.io.IOException;

    void writeDoubleList(int i_renamed, java.util.List<java.lang.Double> list, boolean z_renamed) throws java.io.IOException;

    @java.lang.Deprecated
    void writeEndGroup(int i_renamed) throws java.io.IOException;

    void writeEnum(int i_renamed, int i2) throws java.io.IOException;

    void writeEnumList(int i_renamed, java.util.List<java.lang.Integer> list, boolean z_renamed) throws java.io.IOException;

    void writeFixed32(int i_renamed, int i2) throws java.io.IOException;

    void writeFixed32List(int i_renamed, java.util.List<java.lang.Integer> list, boolean z_renamed) throws java.io.IOException;

    void writeFixed64(int i_renamed, long j_renamed) throws java.io.IOException;

    void writeFixed64List(int i_renamed, java.util.List<java.lang.Long> list, boolean z_renamed) throws java.io.IOException;

    void writeFloat(int i_renamed, float f_renamed) throws java.io.IOException;

    void writeFloatList(int i_renamed, java.util.List<java.lang.Float> list, boolean z_renamed) throws java.io.IOException;

    @java.lang.Deprecated
    void writeGroup(int i_renamed, java.lang.Object obj) throws java.io.IOException;

    @java.lang.Deprecated
    void writeGroup(int i_renamed, java.lang.Object obj, com.google.protobuf.Schema schema) throws java.io.IOException;

    @java.lang.Deprecated
    void writeGroupList(int i_renamed, java.util.List<?> list) throws java.io.IOException;

    @java.lang.Deprecated
    void writeGroupList(int i_renamed, java.util.List<?> list, com.google.protobuf.Schema schema) throws java.io.IOException;

    void writeInt32(int i_renamed, int i2) throws java.io.IOException;

    void writeInt32List(int i_renamed, java.util.List<java.lang.Integer> list, boolean z_renamed) throws java.io.IOException;

    void writeInt64(int i_renamed, long j_renamed) throws java.io.IOException;

    void writeInt64List(int i_renamed, java.util.List<java.lang.Long> list, boolean z_renamed) throws java.io.IOException;

    <K_renamed, V_renamed> void writeMap(int i_renamed, com.google.protobuf.MapEntryLite.Metadata<K_renamed, V_renamed> metadata, java.util.Map<K_renamed, V_renamed> map) throws java.io.IOException;

    void writeMessage(int i_renamed, java.lang.Object obj) throws java.io.IOException;

    void writeMessage(int i_renamed, java.lang.Object obj, com.google.protobuf.Schema schema) throws java.io.IOException;

    void writeMessageList(int i_renamed, java.util.List<?> list) throws java.io.IOException;

    void writeMessageList(int i_renamed, java.util.List<?> list, com.google.protobuf.Schema schema) throws java.io.IOException;

    void writeMessageSetItem(int i_renamed, java.lang.Object obj) throws java.io.IOException;

    void writeSFixed32(int i_renamed, int i2) throws java.io.IOException;

    void writeSFixed32List(int i_renamed, java.util.List<java.lang.Integer> list, boolean z_renamed) throws java.io.IOException;

    void writeSFixed64(int i_renamed, long j_renamed) throws java.io.IOException;

    void writeSFixed64List(int i_renamed, java.util.List<java.lang.Long> list, boolean z_renamed) throws java.io.IOException;

    void writeSInt32(int i_renamed, int i2) throws java.io.IOException;

    void writeSInt32List(int i_renamed, java.util.List<java.lang.Integer> list, boolean z_renamed) throws java.io.IOException;

    void writeSInt64(int i_renamed, long j_renamed) throws java.io.IOException;

    void writeSInt64List(int i_renamed, java.util.List<java.lang.Long> list, boolean z_renamed) throws java.io.IOException;

    @java.lang.Deprecated
    void writeStartGroup(int i_renamed) throws java.io.IOException;

    void writeString(int i_renamed, java.lang.String str) throws java.io.IOException;

    void writeStringList(int i_renamed, java.util.List<java.lang.String> list) throws java.io.IOException;

    void writeUInt32(int i_renamed, int i2) throws java.io.IOException;

    void writeUInt32List(int i_renamed, java.util.List<java.lang.Integer> list, boolean z_renamed) throws java.io.IOException;

    void writeUInt64(int i_renamed, long j_renamed) throws java.io.IOException;

    void writeUInt64List(int i_renamed, java.util.List<java.lang.Long> list, boolean z_renamed) throws java.io.IOException;
}
