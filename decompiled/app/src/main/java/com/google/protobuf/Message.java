package com.google.protobuf;

/* loaded from: classes.dex */
public interface Message extends com.google.protobuf.MessageLite, com.google.protobuf.MessageOrBuilder {

    public interface Builder extends com.google.protobuf.MessageLite.Builder, com.google.protobuf.MessageOrBuilder {
        com.google.protobuf.Message.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj);

        com.google.protobuf.Message build();

        com.google.protobuf.Message buildPartial();

        com.google.protobuf.Message.Builder clear();

        com.google.protobuf.Message.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor);

        com.google.protobuf.Message.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor);

        /* renamed from: clone */
        com.google.protobuf.Message.Builder m25clone();

        @Override // com.google.protobuf.MessageOrBuilder
        com.google.protobuf.Descriptors.Descriptor getDescriptorForType();

        com.google.protobuf.Message.Builder getFieldBuilder(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor);

        com.google.protobuf.Message.Builder getRepeatedFieldBuilder(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed);

        boolean mergeDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException;

        boolean mergeDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

        com.google.protobuf.Message.Builder mergeFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException;

        com.google.protobuf.Message.Builder mergeFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException;

        com.google.protobuf.Message.Builder mergeFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException;

        com.google.protobuf.Message.Builder mergeFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

        com.google.protobuf.Message.Builder mergeFrom(com.google.protobuf.Message message);

        com.google.protobuf.Message.Builder mergeFrom(java.io.InputStream inputStream) throws java.io.IOException;

        com.google.protobuf.Message.Builder mergeFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

        com.google.protobuf.Message.Builder mergeFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException;

        com.google.protobuf.Message.Builder mergeFrom(byte[] bArr, int i_renamed, int i2) throws com.google.protobuf.InvalidProtocolBufferException;

        com.google.protobuf.Message.Builder mergeFrom(byte[] bArr, int i_renamed, int i2, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException;

        com.google.protobuf.Message.Builder mergeFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException;

        com.google.protobuf.Message.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet);

        com.google.protobuf.Message.Builder newBuilderForField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor);

        com.google.protobuf.Message.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj);

        com.google.protobuf.Message.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj);

        com.google.protobuf.Message.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet);
    }

    boolean equals(java.lang.Object obj);

    com.google.protobuf.Parser<? extends com.google.protobuf.Message> getParserForType();

    int hashCode();

    com.google.protobuf.Message.Builder newBuilderForType();

    com.google.protobuf.Message.Builder toBuilder();

    java.lang.String toString();
}
