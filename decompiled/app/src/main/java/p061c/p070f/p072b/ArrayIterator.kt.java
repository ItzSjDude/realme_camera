package p061c.p070f.p072b;

import java.util.Iterator;

/* compiled from: ArrayIterator.kt */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public final class ArrayIterator.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> Iterator<T> m5288a(T[] tArr) {
        Intrinsics.m5305d(tArr, "array");
        return new ArrayIterator.kt_2(tArr);
    }
}
