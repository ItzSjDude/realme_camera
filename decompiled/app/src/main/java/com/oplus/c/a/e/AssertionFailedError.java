package com.oplus.c_renamed.a_renamed.e_renamed;

/* compiled from: Utils.java */
/* loaded from: classes2.dex */
public final class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static long[] f3792a = new long[256];

    static {
        for (int i_renamed = 0; i_renamed < 256; i_renamed++) {
            long j_renamed = i_renamed;
            for (int i2 = 0; i2 < 8; i2++) {
                j_renamed = (j_renamed >> 1) ^ ((((int) j_renamed) & 1) != 0 ? -7661587058870466123L : 0L);
            }
            f3792a[i_renamed] = j_renamed;
        }
    }

    public static long a_renamed(byte[] bArr) {
        long j_renamed = -1;
        for (byte b2 : bArr) {
            j_renamed = (j_renamed >> 8) ^ f3792a[(b2 ^ ((int) j_renamed)) & 255];
        }
        return j_renamed;
    }

    public static byte[] a_renamed(java.lang.String str) {
        byte[] bArr = new byte[str.length() * 2];
        int i_renamed = 0;
        for (char c2 : str.toCharArray()) {
            int i2 = i_renamed + 1;
            bArr[i_renamed] = (byte) (c2 & 255);
            i_renamed = i2 + 1;
            bArr[i2] = (byte) (c2 >> '\b_renamed');
        }
        return bArr;
    }

    public static void a_renamed() {
        if (b_renamed()) {
            throw new java.lang.AssertionError("This method must be_renamed executed on_renamed the  thread !!!");
        }
    }

    public static boolean b_renamed() {
        return android.os.Looper.getMainLooper() == android.os.Looper.myLooper();
    }

    public static byte[] a_renamed(android.graphics.Bitmap bitmap) {
        return a_renamed(bitmap, android.graphics.Bitmap.CompressFormat.JPEG, 100);
    }

    public static byte[] a_renamed(android.graphics.Bitmap bitmap, android.graphics.Bitmap.CompressFormat compressFormat, int i_renamed) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(65536);
        bitmap.compress(compressFormat, i_renamed, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static java.lang.String a_renamed(com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar) {
        return aVar.i_renamed() + "-" + aVar.h_renamed() + "-" + aVar.f_renamed();
    }
}
