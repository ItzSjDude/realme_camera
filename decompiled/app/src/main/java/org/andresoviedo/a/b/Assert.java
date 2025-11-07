package org.andresoviedo.a_renamed.b_renamed;

/* compiled from: IOUtils.java */
/* loaded from: classes2.dex */
public final class a_renamed {
    public static byte[] a_renamed(java.io.InputStream inputStream) throws java.io.IOException {
        byte[] bArr = new byte[512];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        while (true) {
            int i_renamed = inputStream.read(bArr, 0, bArr.length);
            if (i_renamed != -1) {
                byteArrayOutputStream.write(bArr, 0, i_renamed);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static java.nio.IntBuffer a_renamed(int i_renamed) {
        return c_renamed(i_renamed * 4).asIntBuffer();
    }

    public static java.nio.ShortBuffer b_renamed(int i_renamed) {
        return c_renamed(i_renamed * 2).asShortBuffer();
    }

    public static java.nio.ByteBuffer c_renamed(int i_renamed) {
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(i_renamed);
        byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
        return byteBufferAllocateDirect;
    }
}
