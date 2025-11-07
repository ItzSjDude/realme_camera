package com.google.protobuf;

/* loaded from: classes.dex */
public abstract class ByteOutput {
    public abstract void write(byte b2) throws java.io.IOException;

    public abstract void write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException;

    public abstract void write(byte[] bArr, int i_renamed, int i2) throws java.io.IOException;

    public abstract void writeLazy(java.nio.ByteBuffer byteBuffer) throws java.io.IOException;

    public abstract void writeLazy(byte[] bArr, int i_renamed, int i2) throws java.io.IOException;
}
