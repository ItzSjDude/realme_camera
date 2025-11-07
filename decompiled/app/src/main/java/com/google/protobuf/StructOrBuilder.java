package com.google.protobuf;

/* loaded from: classes.dex */
public interface StructOrBuilder extends com.google.protobuf.MessageOrBuilder {
    boolean containsFields(java.lang.String str);

    @java.lang.Deprecated
    java.util.Map<java.lang.String, com.google.protobuf.Value> getFields();

    int getFieldsCount();

    java.util.Map<java.lang.String, com.google.protobuf.Value> getFieldsMap();

    com.google.protobuf.Value getFieldsOrDefault(java.lang.String str, com.google.protobuf.Value value);

    com.google.protobuf.Value getFieldsOrThrow(java.lang.String str);
}
