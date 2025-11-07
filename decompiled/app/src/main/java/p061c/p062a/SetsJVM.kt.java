package p061c.p062a;

import java.util.Collections;
import java.util.Set;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: SetsJVM.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.ad */
/* loaded from: classes.dex */
class SetsJVM.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> Set<T> m5211a(T t) {
        Set<T> setSingleton = Collections.singleton(t);
        Intrinsics.m5301b(setSingleton, "java.util.Collections.singleton(element)");
        return setSingleton;
    }
}
