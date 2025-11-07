package c_renamed.k_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversions.kt */
/* loaded from: classes.dex */
public class l_renamed extends c_renamed.k_renamed.k_renamed {
    public static final java.lang.Integer a_renamed(java.lang.String str) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str, "$this$toIntOrNull");
        return c_renamed.k_renamed.d_renamed.a_renamed(str, 10);
    }

    public static final java.lang.Integer a_renamed(java.lang.String str, int i_renamed) {
        boolean z_renamed;
        int i2;
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str, "$this$toIntOrNull");
        c_renamed.k_renamed.a_renamed.a_renamed(i_renamed);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        int i4 = -2147483647;
        int i5 = 1;
        if (c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(cCharAt, 48) >= 0) {
            z_renamed = false;
            i5 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i4 = Integer.MIN_VALUE;
                z_renamed = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z_renamed = false;
            }
        }
        int i6 = -59652323;
        while (i5 < length) {
            int iA = c_renamed.k_renamed.a_renamed.a_renamed(str.charAt(i5), i_renamed);
            if (iA < 0) {
                return null;
            }
            if ((i3 < i6 && (i6 != -59652323 || i3 < (i6 = i4 / i_renamed))) || (i2 = i3 * i_renamed) < i4 + iA) {
                return null;
            }
            i3 = i2 - iA;
            i5++;
        }
        if (!z_renamed) {
            i3 = -i3;
        }
        return java.lang.Integer.valueOf(i3);
    }

    public static final java.lang.Long b_renamed(java.lang.String str) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str, "$this$toLongOrNull");
        return c_renamed.k_renamed.d_renamed.b_renamed(str, 10);
    }

    public static final java.lang.Long b_renamed(java.lang.String str, int i_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str, "$this$toLongOrNull");
        c_renamed.k_renamed.a_renamed.a_renamed(i_renamed);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        boolean z_renamed = false;
        char cCharAt = str.charAt(0);
        long j_renamed = -9223372036854775807L;
        int i2 = 1;
        if (c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(cCharAt, 48) >= 0) {
            i2 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j_renamed = Long.MIN_VALUE;
                z_renamed = true;
            } else if (cCharAt != '+') {
                return null;
            }
        }
        long j2 = -256204778801521550L;
        long j3 = 0;
        long j4 = -256204778801521550L;
        while (i2 < length) {
            int iA = c_renamed.k_renamed.a_renamed.a_renamed(str.charAt(i2), i_renamed);
            if (iA < 0) {
                return null;
            }
            if (j3 < j4) {
                if (j4 == j2) {
                    j4 = j_renamed / i_renamed;
                    if (j3 < j4) {
                    }
                }
                return null;
            }
            long j5 = j3 * i_renamed;
            long j6 = iA;
            if (j5 < j_renamed + j6) {
                return null;
            }
            j3 = j5 - j6;
            i2++;
            j2 = -256204778801521550L;
        }
        if (!z_renamed) {
            j3 = -j3;
        }
        return java.lang.Long.valueOf(j3);
    }
}
