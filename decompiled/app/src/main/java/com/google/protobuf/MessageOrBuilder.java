package com.google.protobuf;

/* loaded from: classes.dex */
public interface MessageOrBuilder extends com.google.protobuf.MessageLiteOrBuilder {
    java.util.List<java.lang.String> findInitializationErrors();

    java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFields();

    com.google.protobuf.Message getDefaultInstanceForType();

    com.google.protobuf.Descriptors.Descriptor getDescriptorForType();

    java.lang.Object getField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor);

    java.lang.String getInitializationErrorString();

    com.google.protobuf.Descriptors.FieldDescriptor getOneofFieldDescriptor(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor);

    java.lang.Object getRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed);

    int getRepeatedFieldCount(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor);

    com.google.protobuf.UnknownFieldSet getUnknownFields();

    boolean hasField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor);

    boolean hasOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor);
}
