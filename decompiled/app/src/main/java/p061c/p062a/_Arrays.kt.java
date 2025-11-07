package p061c.p062a;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import p061c.p070f.p072b.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Arrays.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class _Arrays.kt extends _ArraysJvm.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> boolean m5219a(T[] tArr, T t) {
        Intrinsics.m5305d(tArr, "$this$contains");
        return C0881b.m5220b(tArr, t) >= 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final <T> int m5220b(T[] tArr, T t) {
        Intrinsics.m5305d(tArr, "$this$indexOf");
        int OplusGLSurfaceView_13 = 0;
        if (t == null) {
            int length = tArr.length;
            while (OplusGLSurfaceView_13 < length) {
                if (tArr[OplusGLSurfaceView_13] == null) {
                    return OplusGLSurfaceView_13;
                }
                OplusGLSurfaceView_13++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (OplusGLSurfaceView_13 < length2) {
            if (Intrinsics.m5299a(t, tArr[OplusGLSurfaceView_13])) {
                return OplusGLSurfaceView_13;
            }
            OplusGLSurfaceView_13++;
        }
        return -1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final char m5218a(char[] cArr) {
        Intrinsics.m5305d(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final <T> T m5221b(T[] tArr) {
        Intrinsics.m5305d(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final <T> T[] m5222b(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.m5305d(tArr, "$this$sortedArrayWith");
        Intrinsics.m5305d(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        Intrinsics.m5301b(tArr2, "java.util.Arrays.copyOf(this, size)");
        C0881b.m5215a((Object[]) tArr2, (Comparator) comparator);
        return tArr2;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final <T> List<T> m5223c(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.m5305d(tArr, "$this$sortedWith");
        Intrinsics.m5305d(comparator, "comparator");
        return C0881b.m5214a(C0881b.m5222b((Object[]) tArr, (Comparator) comparator));
    }
}
