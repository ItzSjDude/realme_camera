package com.google.protobuf;

/* loaded from: classes.dex */
abstract class ExtensionSchema<T_renamed extends com.google.protobuf.FieldSet.FieldDescriptorLite<T_renamed>> {
    abstract int extensionNumber(java.util.Map.Entry<?, ?> entry);

    abstract java.lang.Object findExtensionByNumber(com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, com.google.protobuf.MessageLite messageLite, int i_renamed);

    abstract com.google.protobuf.FieldSet<T_renamed> getExtensions(java.lang.Object obj);

    abstract com.google.protobuf.FieldSet<T_renamed> getMutableExtensions(java.lang.Object obj);

    abstract boolean hasExtensions(com.google.protobuf.MessageLite messageLite);

    abstract void makeImmutable(java.lang.Object obj);

    abstract <UT, UB> UB parseExtension(com.google.protobuf.Reader reader, java.lang.Object obj, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, com.google.protobuf.FieldSet<T_renamed> fieldSet, UB ub, com.google.protobuf.UnknownFieldSchema<UT, UB> unknownFieldSchema) throws java.io.IOException;

    abstract void parseLengthPrefixedMessageSetItem(com.google.protobuf.Reader reader, java.lang.Object obj, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, com.google.protobuf.FieldSet<T_renamed> fieldSet) throws java.io.IOException;

    abstract void parseMessageSetItem(com.google.protobuf.ByteString byteString, java.lang.Object obj, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite, com.google.protobuf.FieldSet<T_renamed> fieldSet) throws java.io.IOException;

    abstract void serializeExtension(com.google.protobuf.Writer writer, java.util.Map.Entry<?, ?> entry) throws java.io.IOException;

    abstract void setExtensions(java.lang.Object obj, com.google.protobuf.FieldSet<T_renamed> fieldSet);

    ExtensionSchema() {
    }
}
