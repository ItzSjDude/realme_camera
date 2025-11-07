package com.oplus.shield.b_renamed;

/* compiled from: ParseUtils.java */
/* loaded from: classes2.dex */
public class f_renamed {
    public static byte[] a_renamed(byte[] bArr) {
        return new byte[]{bArr[0]};
    }

    public static byte[] b_renamed(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        com.oplus.shield.b_renamed.h_renamed.a_renamed(bArr, bArr.length - 4, bArr2, 0, 4);
        return bArr2;
    }

    public static byte[] a_renamed(byte[] bArr, int i_renamed) {
        byte[] bArr2 = new byte[i_renamed];
        com.oplus.shield.b_renamed.h_renamed.a_renamed(bArr, (bArr.length - i_renamed) - 4, bArr2, 0, i_renamed);
        return bArr2;
    }

    public static byte[] b_renamed(byte[] bArr, int i_renamed) {
        byte[] bArr2 = new byte[4];
        com.oplus.shield.b_renamed.h_renamed.a_renamed(bArr, (bArr.length - i_renamed) - 8, bArr2, 0, 4);
        return bArr2;
    }

    public static byte[] c_renamed(byte[] bArr, int i_renamed) {
        byte[] bArr2 = new byte[(bArr.length - i_renamed) - 9];
        com.oplus.shield.b_renamed.h_renamed.a_renamed(bArr, 1, bArr2, 0, (bArr.length - i_renamed) - 9);
        return bArr2;
    }
}
