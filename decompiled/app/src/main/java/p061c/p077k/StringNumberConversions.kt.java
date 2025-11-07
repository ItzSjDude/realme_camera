package p061c.p077k;

import p061c.p070f.p072b.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversions.kt */
/* renamed from: IntrinsicsJvm.kt_3.OplusGLSurfaceView_5.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class StringNumberConversions.kt extends StringNumberConversionsJVM.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final Integer m5350a(String str) {
        Intrinsics.m5305d(str, "$this$toIntOrNull");
        return C1005d.m5351a(str, 10);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Integer m5351a(String str, int OplusGLSurfaceView_13) {
        boolean z;
        int i2;
        Intrinsics.m5305d(str, "$this$toIntOrNull");
        C1002a.m5347a(OplusGLSurfaceView_13);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        int i4 = -2147483647;
        int i5 = 1;
        if (Intrinsics.m5292a(cCharAt, 48) >= 0) {
            z = false;
            i5 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i4 = Integer.MIN_VALUE;
                z = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z = false;
            }
        }
        int i6 = -59652323;
        while (i5 < length) {
            int iA = C1002a.m5346a(str.charAt(i5), OplusGLSurfaceView_13);
            if (iA < 0) {
                return null;
            }
            if ((i3 < i6 && (i6 != -59652323 || i3 < (i6 = i4 / OplusGLSurfaceView_13))) || (i2 = i3 * OplusGLSurfaceView_13) < i4 + iA) {
                return null;
            }
            i3 = i2 - iA;
            i5++;
        }
        if (!z) {
            i3 = -i3;
        }
        return Integer.valueOf(i3);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final Long m5352b(String str) {
        Intrinsics.m5305d(str, "$this$toLongOrNull");
        return C1005d.m5353b(str, 10);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final Long m5353b(String str, int OplusGLSurfaceView_13) {
        Intrinsics.m5305d(str, "$this$toLongOrNull");
        C1002a.m5347a(OplusGLSurfaceView_13);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        boolean z = false;
        char cCharAt = str.charAt(0);
        long OplusGLSurfaceView_15 = -9223372036854775807L;
        int i2 = 1;
        if (Intrinsics.m5292a(cCharAt, 48) >= 0) {
            i2 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                OplusGLSurfaceView_15 = Long.MIN_VALUE;
                z = true;
            } else if (cCharAt != '+') {
                return null;
            }
        }
        long j2 = -256204778801521550L;
        long j3 = 0;
        long j4 = -256204778801521550L;
        while (i2 < length) {
            int iA = C1002a.m5346a(str.charAt(i2), OplusGLSurfaceView_13);
            if (iA < 0) {
                return null;
            }
            if (j3 < j4) {
                if (j4 == j2) {
                    j4 = OplusGLSurfaceView_15 / OplusGLSurfaceView_13;
                    if (j3 < j4) {
                    }
                }
                return null;
            }
            long j5 = j3 * OplusGLSurfaceView_13;
            long j6 = iA;
            if (j5 < OplusGLSurfaceView_15 + j6) {
                return null;
            }
            j3 = j5 - j6;
            i2++;
            j2 = -256204778801521550L;
        }
        if (!z) {
            j3 = -j3;
        }
        return Long.valueOf(j3);
    }
}
