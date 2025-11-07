package p061c.p062a;

import com.android.providers.downloads.Downloads;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import p061c.p070f.p072b.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _ArraysJvm.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class _ArraysJvm.kt extends Arrays.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> List<T> m5214a(T[] tArr) {
        Intrinsics.m5305d(tArr, "$this$asList");
        List<T> listM5224a = ArraysUtilJVM.m5224a(tArr);
        Intrinsics.m5301b(listM5224a, "ArraysUtilJVM.asList(this)");
        return listM5224a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ Object[] m5217a(Object[] objArr, Object[] objArr2, int OplusGLSurfaceView_13, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            OplusGLSurfaceView_13 = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return C0881b.m5216a(objArr, objArr2, OplusGLSurfaceView_13, i2, i3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> T[] m5216a(T[] tArr, T[] tArr2, int OplusGLSurfaceView_13, int i2, int i3) {
        Intrinsics.m5305d(tArr, "$this$copyInto");
        Intrinsics.m5305d(tArr2, Downloads.Impl.COLUMN_DESTINATION);
        System.arraycopy(tArr, i2, tArr2, OplusGLSurfaceView_13, i3 - i2);
        return tArr2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> void m5215a(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.m5305d(tArr, "$this$sortWith");
        Intrinsics.m5305d(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
