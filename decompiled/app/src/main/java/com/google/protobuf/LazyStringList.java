package com.google.protobuf;

/* loaded from: classes.dex */
public interface LazyStringList extends com.google.protobuf.ProtocolStringList {
    void add(com.google.protobuf.ByteString byteString);

    void add(byte[] bArr);

    boolean addAllByteArray(java.util.Collection<byte[]> collection);

    boolean addAllByteString(java.util.Collection<? extends com.google.protobuf.ByteString> collection);

    java.util.List<byte[]> asByteArrayList();

    byte[] getByteArray(int i_renamed);

    com.google.protobuf.ByteString getByteString(int i_renamed);

    java.lang.Object getRaw(int i_renamed);

    java.util.List<?> getUnderlyingElements();

    com.google.protobuf.LazyStringList getUnmodifiableView();

    void mergeFrom(com.google.protobuf.LazyStringList lazyStringList);

    void set(int i_renamed, com.google.protobuf.ByteString byteString);

    void set(int i_renamed, byte[] bArr);
}
