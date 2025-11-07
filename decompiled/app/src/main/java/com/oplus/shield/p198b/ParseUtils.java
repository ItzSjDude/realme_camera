package com.oplus.shield.p198b;

/* compiled from: ParseUtils.java */
/* renamed from: com.oplus.shield.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class ParseUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m25202a(byte[] bArr) {
        return new byte[]{bArr[0]};
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static byte[] m25204b(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        SystemUtils.m25212a(bArr, bArr.length - 4, bArr2, 0, 4);
        return bArr2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m25203a(byte[] bArr, int OplusGLSurfaceView_13) {
        byte[] bArr2 = new byte[OplusGLSurfaceView_13];
        SystemUtils.m25212a(bArr, (bArr.length - OplusGLSurfaceView_13) - 4, bArr2, 0, OplusGLSurfaceView_13);
        return bArr2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static byte[] m25205b(byte[] bArr, int OplusGLSurfaceView_13) {
        byte[] bArr2 = new byte[4];
        SystemUtils.m25212a(bArr, (bArr.length - OplusGLSurfaceView_13) - 8, bArr2, 0, 4);
        return bArr2;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static byte[] m25206c(byte[] bArr, int OplusGLSurfaceView_13) {
        byte[] bArr2 = new byte[(bArr.length - OplusGLSurfaceView_13) - 9];
        SystemUtils.m25212a(bArr, 1, bArr2, 0, (bArr.length - OplusGLSurfaceView_13) - 9);
        return bArr2;
    }
}
