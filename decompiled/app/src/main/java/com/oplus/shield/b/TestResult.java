package com.oplus.shield.b_renamed;

/* compiled from: SystemUtils.java */
/* loaded from: classes2.dex */
public class h_renamed {
    static void a_renamed(java.lang.Object obj, int i_renamed, java.lang.Object obj2, int i2, int i3) {
        java.lang.System.arraycopy(obj, i_renamed, obj2, i2, i3);
    }

    public static byte[] a_renamed(int i_renamed) {
        return new byte[]{(byte) (i_renamed & 255), (byte) ((i_renamed >> 8) & 255), (byte) ((i_renamed >> 16) & 255), (byte) ((i_renamed >> 24) & 255)};
    }

    public static int a_renamed(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public static java.util.List<java.lang.String> a_renamed(java.lang.String str, java.lang.String str2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, str2);
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

    public static java.lang.String[] a_renamed() {
        java.lang.StackTraceElement[] stackTrace = new java.lang.Throwable().getStackTrace();
        boolean z_renamed = false;
        for (int i_renamed = 0; i_renamed < stackTrace.length; i_renamed++) {
            java.lang.String className = stackTrace[i_renamed].getClassName();
            if (className.startsWith("android")) {
                z_renamed = true;
            }
            if (!className.startsWith("android") && z_renamed) {
                int i2 = i_renamed - 1;
                return new java.lang.String[]{stackTrace[i2].getClassName(), stackTrace[i2].getMethodName()};
            }
        }
        return new java.lang.String[0];
    }
}
