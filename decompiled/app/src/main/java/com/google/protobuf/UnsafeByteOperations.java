package com.google.protobuf;

/* loaded from: classes.dex */
public final class UnsafeByteOperations {
    private UnsafeByteOperations() {
    }

    public static com.google.protobuf.ByteString unsafeWrap(byte[] bArr) {
        return com.google.protobuf.ByteString.wrap(bArr);
    }

    public static com.google.protobuf.ByteString unsafeWrap(byte[] bArr, int i_renamed, int i2) {
        return com.google.protobuf.ByteString.wrap(bArr, i_renamed, i2);
    }

    public static com.google.protobuf.ByteString unsafeWrap(java.nio.ByteBuffer byteBuffer) {
        return com.google.protobuf.ByteString.wrap(byteBuffer);
    }

    public static void unsafeWriteTo(com.google.protobuf.ByteString byteString, com.google.protobuf.ByteOutput byteOutput) throws java.io.IOException {
        byteString.writeTo(byteOutput);
    }
}
