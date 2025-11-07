package p061c.p062a;

import java.util.Set;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: Sets.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.ae */
/* loaded from: classes.dex */
class Sets.kt_2 extends SetsJVM.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> Set<T> m5212a() {
        return Sets.kt.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> Set<T> m5213a(Set<? extends T> set) {
        Intrinsics.m5305d(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : C0877ac.m5211a(set.iterator().next());
        }
        return C0877ac.m5212a();
    }
}
