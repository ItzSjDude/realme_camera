package com.oplus.camera.g_renamed;

/* compiled from: MP4BoxHeader.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final char[] f4538c = "0123456789ABCDEF".toCharArray();

    /* renamed from: a_renamed, reason: collision with root package name */
    public long f4539a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public java.lang.String f4540b;
    private byte[] d_renamed;
    private boolean e_renamed;

    public a_renamed(byte[] bArr, boolean z_renamed) {
        this.e_renamed = false;
        this.d_renamed = bArr;
        this.e_renamed = z_renamed;
        int length = bArr.length;
        this.f4540b = d_renamed(bArr);
        if (8 == length) {
            this.f4539a = c_renamed(bArr);
            return;
        }
        byte[] bArr2 = new byte[8];
        java.lang.System.arraycopy(bArr, 8, bArr2, 0, 8);
        this.f4539a = b_renamed(bArr2);
    }

    private long b_renamed(byte[] bArr) {
        return java.nio.ByteBuffer.wrap(bArr).getLong();
    }

    private int c_renamed(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
    }

    private java.lang.String d_renamed(byte[] bArr) {
        return new java.lang.String(bArr, 4, 4);
    }

    public static byte[] a_renamed(long j_renamed) {
        return new byte[]{(byte) ((j_renamed >> 24) & 255), (byte) ((j_renamed >> 16) & 255), (byte) ((j_renamed >> 8) & 255), (byte) (j_renamed & 255)};
    }

    public java.lang.String toString() {
        return "MP4BoxHeader{header=" + a_renamed(this.d_renamed) + ", size=" + this.f4539a + ", type='" + this.f4540b + "'}";
    }

    public static java.lang.String a_renamed(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i_renamed = 0; i_renamed < bArr.length; i_renamed++) {
            int i2 = bArr[i_renamed] & 255;
            int i3 = i_renamed * 2;
            char[] cArr2 = f4538c;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i4 = 0; i4 < cArr.length; i4 += 2) {
            sb.append(cArr[i4]);
            sb.append(cArr[i4 + 1]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
