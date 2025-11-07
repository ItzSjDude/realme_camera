package com.google.protobuf;

/* loaded from: classes.dex */
interface Schema<T_renamed> {
    boolean equals(T_renamed t_renamed, T_renamed t2);

    int getSerializedSize(T_renamed t_renamed);

    int hashCode(T_renamed t_renamed);

    boolean isInitialized(T_renamed t_renamed);

    void makeImmutable(T_renamed t_renamed);

    void mergeFrom(T_renamed t_renamed, com.google.protobuf.Reader reader, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException;

    void mergeFrom(T_renamed t_renamed, T_renamed t2);

    void mergeFrom(T_renamed t_renamed, byte[] bArr, int i_renamed, int i2, com.google.protobuf.ArrayDecoders.Registers registers) throws java.io.IOException;

    T_renamed newInstance();

    void writeTo(T_renamed t_renamed, com.google.protobuf.Writer writer) throws java.io.IOException;
}
