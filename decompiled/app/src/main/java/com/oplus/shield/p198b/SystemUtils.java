package com.oplus.shield.p198b;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: SystemUtils.java */
/* renamed from: com.oplus.shield.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class SystemUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    static void m25212a(Object obj, int OplusGLSurfaceView_13, Object obj2, int i2, int i3) {
        System.arraycopy(obj, OplusGLSurfaceView_13, obj2, i2, i3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m25213a(int OplusGLSurfaceView_13) {
        return new byte[]{(byte) (OplusGLSurfaceView_13 & 255), (byte) ((OplusGLSurfaceView_13 >> 8) & 255), (byte) ((OplusGLSurfaceView_13 >> 16) & 255), (byte) ((OplusGLSurfaceView_13 >> 24) & 255)};
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m25210a(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static List<String> m25211a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String[] m25214a() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        boolean z = false;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < stackTrace.length; OplusGLSurfaceView_13++) {
            String className = stackTrace[OplusGLSurfaceView_13].getClassName();
            if (className.startsWith("android")) {
                z = true;
            }
            if (!className.startsWith("android") && z) {
                int i2 = OplusGLSurfaceView_13 - 1;
                return new String[]{stackTrace[i2].getClassName(), stackTrace[i2].getMethodName()};
            }
        }
        return new String[0];
    }
}
