package com.google.protobuf;

/* loaded from: classes.dex */
interface Reader {
    public static final int READ_DONE = Integer.MAX_VALUE;
    public static final int TAG_UNKNOWN = 0;

    int getFieldNumber() throws java.io.IOException;

    int getTag();

    boolean readBool() throws java.io.IOException;

    void readBoolList(java.util.List<java.lang.Boolean> list) throws java.io.IOException;

    com.google.protobuf.ByteString readBytes() throws java.io.IOException;

    void readBytesList(java.util.List<com.google.protobuf.ByteString> list) throws java.io.IOException;

    double readDouble() throws java.io.IOException;

    void readDoubleList(java.util.List<java.lang.Double> list) throws java.io.IOException;

    int readEnum() throws java.io.IOException;

    void readEnumList(java.util.List<java.lang.Integer> list) throws java.io.IOException;

    int readFixed32() throws java.io.IOException;

    void readFixed32List(java.util.List<java.lang.Integer> list) throws java.io.IOException;

    long readFixed64() throws java.io.IOException;

    void readFixed64List(java.util.List<java.lang.Long> list) throws java.io.IOException;

    float readFloat() throws java.io.IOException;

    void readFloatList(java.util.List<java.lang.Float> list) throws java.io.IOException;

    @java.lang.Deprecated
    <T_renamed> T_renamed readGroup(java.lang.Class<T_renamed> cls, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

    @java.lang.Deprecated
    <T_renamed> T_renamed readGroupBySchemaWithCheck(com.google.protobuf.Schema<T_renamed> schema, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

    @java.lang.Deprecated
    <T_renamed> void readGroupList(java.util.List<T_renamed> list, com.google.protobuf.Schema<T_renamed> schema, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

    @java.lang.Deprecated
    <T_renamed> void readGroupList(java.util.List<T_renamed> list, java.lang.Class<T_renamed> cls, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

    int readInt32() throws java.io.IOException;

    void readInt32List(java.util.List<java.lang.Integer> list) throws java.io.IOException;

    long readInt64() throws java.io.IOException;

    void readInt64List(java.util.List<java.lang.Long> list) throws java.io.IOException;

    <K_renamed, V_renamed> void readMap(java.util.Map<K_renamed, V_renamed> map, com.google.protobuf.MapEntryLite.Metadata<K_renamed, V_renamed> metadata, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

    <T_renamed> T_renamed readMessage(java.lang.Class<T_renamed> cls, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

    <T_renamed> T_renamed readMessageBySchemaWithCheck(com.google.protobuf.Schema<T_renamed> schema, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

    <T_renamed> void readMessageList(java.util.List<T_renamed> list, com.google.protobuf.Schema<T_renamed> schema, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

    <T_renamed> void readMessageList(java.util.List<T_renamed> list, java.lang.Class<T_renamed> cls, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

    int readSFixed32() throws java.io.IOException;

    void readSFixed32List(java.util.List<java.lang.Integer> list) throws java.io.IOException;

    long readSFixed64() throws java.io.IOException;

    void readSFixed64List(java.util.List<java.lang.Long> list) throws java.io.IOException;

    int readSInt32() throws java.io.IOException;

    void readSInt32List(java.util.List<java.lang.Integer> list) throws java.io.IOException;

    long readSInt64() throws java.io.IOException;

    void readSInt64List(java.util.List<java.lang.Long> list) throws java.io.IOException;

    java.lang.String readString() throws java.io.IOException;

    void readStringList(java.util.List<java.lang.String> list) throws java.io.IOException;

    void readStringListRequireUtf8(java.util.List<java.lang.String> list) throws java.io.IOException;

    java.lang.String readStringRequireUtf8() throws java.io.IOException;

    int readUInt32() throws java.io.IOException;

    void readUInt32List(java.util.List<java.lang.Integer> list) throws java.io.IOException;

    long readUInt64() throws java.io.IOException;

    void readUInt64List(java.util.List<java.lang.Long> list) throws java.io.IOException;

    boolean shouldDiscardUnknownFields();

    boolean skipField() throws java.io.IOException;
}
