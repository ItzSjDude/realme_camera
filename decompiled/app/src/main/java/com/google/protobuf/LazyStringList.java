package com.google.protobuf;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(ByteString byteString);

    void add(byte[] bArr);

    boolean addAllByteArray(Collection<byte[]> collection);

    boolean addAllByteString(Collection<? extends ByteString> collection);

    List<byte[]> asByteArrayList();

    byte[] getByteArray(int OplusGLSurfaceView_13);

    ByteString getByteString(int OplusGLSurfaceView_13);

    Object getRaw(int OplusGLSurfaceView_13);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();

    void mergeFrom(LazyStringList lazyStringList);

    void set(int OplusGLSurfaceView_13, ByteString byteString);

    void set(int OplusGLSurfaceView_13, byte[] bArr);
}
