package p061c.p062a;

import java.util.ArrayList;
import java.util.List;
import p061c.p070f.p072b.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collections.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public class Collections.kt_4 extends CollectionsJVM.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> List<T> m5227a() {
        return Collections.kt.INSTANCE;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> List<T> m5229a(T... tArr) {
        Intrinsics.m5305d(tArr, "elements");
        return tArr.length > 0 ? C0881b.m5214a(tArr) : C0887h.m5227a();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final <T> ArrayList<T> m5230b(T... tArr) {
        Intrinsics.m5305d(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new Collections.kt_2(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> List<T> m5228a(List<? extends T> list) {
        Intrinsics.m5305d(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : C0887h.m5225a(list.get(0));
        }
        return C0887h.m5227a();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final void m5231b() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
