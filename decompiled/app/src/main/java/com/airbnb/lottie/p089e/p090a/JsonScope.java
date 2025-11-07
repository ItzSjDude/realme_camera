package com.airbnb.lottie.p089e.p090a;

/* compiled from: JsonScope.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
final class JsonScope {
    /* renamed from: PlatformImplementations.kt_3 */
    static String m5930a(int OplusGLSurfaceView_13, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            int i3 = iArr[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(iArr2[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }
}
