package com.oplus.camera.g_renamed.a_renamed;

/* compiled from: ExifIFH.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public java.nio.ByteOrder f4551a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    public byte[] f4552b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int f4553c = 0;

    public static com.oplus.camera.g_renamed.a_renamed.d_renamed a_renamed(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        com.oplus.camera.g_renamed.a_renamed.d_renamed dVar = new com.oplus.camera.g_renamed.a_renamed.d_renamed();
        dVar.f4552b = new byte[2];
        dVar.f4552b[0] = byteBuffer.get(0);
        dVar.f4552b[1] = byteBuffer.get(1);
        dVar.f4551a = byteBuffer.order();
        dVar.f4553c = byteBuffer.getInt(4);
        return dVar;
    }

    public java.lang.String toString() {
        return "ExifIFH : mOrder[0] : " + com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(java.lang.Byte.valueOf(this.f4552b[0])) + ";\nExifIFH : mOrder[1] : " + com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(java.lang.Byte.valueOf(this.f4552b[1])) + ";\nExifIFH : mByteOrder : " + this.f4551a + ";\nExifIFH : mFirstIFDOffset : " + com.oplus.camera.g_renamed.a_renamed.h_renamed.a_renamed(java.lang.Integer.valueOf(this.f4553c)) + ";\n_renamed";
    }
}
