package com.airbnb.lottie.e_renamed.a_renamed;

/* compiled from: JsonScope.java */
/* loaded from: classes.dex */
final class d_renamed {
    static java.lang.String a_renamed(int i_renamed, int[] iArr, java.lang.String[] strArr, int[] iArr2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append('$');
        for (int i2 = 0; i2 < i_renamed; i2++) {
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
