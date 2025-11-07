package com.oplus.camera.p144g;

import java.nio.ByteBuffer;

/* compiled from: MP4BoxHeader.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_11.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class MP4BoxHeader {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final char[] f13753c = "0123456789ABCDEF".toCharArray();

    /* renamed from: PlatformImplementations.kt_3 */
    public long f13754a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String f13755b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private byte[] f13756d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f13757e;

    public MP4BoxHeader(byte[] bArr, boolean z) {
        this.f13757e = false;
        this.f13756d = bArr;
        this.f13757e = z;
        int length = bArr.length;
        this.f13755b = m13722d(bArr);
        if (8 == length) {
            this.f13754a = m13721c(bArr);
            return;
        }
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 8, bArr2, 0, 8);
        this.f13754a = m13720b(bArr2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private long m13720b(byte[] bArr) {
        return ByteBuffer.wrap(bArr).getLong();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m13721c(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String m13722d(byte[] bArr) {
        return new String(bArr, 4, 4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m13719a(long OplusGLSurfaceView_15) {
        return new byte[]{(byte) ((OplusGLSurfaceView_15 >> 24) & 255), (byte) ((OplusGLSurfaceView_15 >> 16) & 255), (byte) ((OplusGLSurfaceView_15 >> 8) & 255), (byte) (OplusGLSurfaceView_15 & 255)};
    }

    public String toString() {
        return "MP4BoxHeader{header=" + m13718a(this.f13756d) + ", size=" + this.f13754a + ", type='" + this.f13755b + "'}";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m13718a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bArr.length; OplusGLSurfaceView_13++) {
            int i2 = bArr[OplusGLSurfaceView_13] & 255;
            int i3 = OplusGLSurfaceView_13 * 2;
            char[] cArr2 = f13753c;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < cArr.length; i4 += 2) {
            sb.append(cArr[i4]);
            sb.append(cArr[i4 + 1]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
