package com.google.protobuf;

/* loaded from: classes.dex */
public interface ValueOrBuilder extends com.google.protobuf.MessageOrBuilder {
    boolean getBoolValue();

    com.google.protobuf.Value.KindCase getKindCase();

    com.google.protobuf.ListValue getListValue();

    com.google.protobuf.ListValueOrBuilder getListValueOrBuilder();

    com.google.protobuf.NullValue getNullValue();

    int getNullValueValue();

    double getNumberValue();

    java.lang.String getStringValue();

    com.google.protobuf.ByteString getStringValueBytes();

    com.google.protobuf.Struct getStructValue();

    com.google.protobuf.StructOrBuilder getStructValueOrBuilder();

    boolean hasListValue();

    boolean hasStructValue();
}
