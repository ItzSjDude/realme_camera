package p061c.p062a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: CollectionsJVM.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
class CollectionsJVM.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> List<T> m5225a(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        Intrinsics.m5301b(listSingletonList, "java.util.Collections.singletonList(element)");
        return listSingletonList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> Object[] m5226a(T[] tArr, boolean z) {
        Intrinsics.m5305d(tArr, "$this$copyToArrayOfAny");
        if (!z || !Intrinsics.m5299a(tArr.getClass(), Object[].class)) {
            tArr = (T[]) Arrays.copyOf(tArr, tArr.length, Object[].class);
        }
        Intrinsics.m5301b(tArr, "if (isVarargs && this.ja… Array<Any?>::class.java)");
        return tArr;
    }
}
