package p061c.p062a;

import java.util.Collection;
import p061c.p070f.p072b.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterables.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class Iterables.kt extends Collections.kt_4 {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> int m5232a(Iterable<? extends T> iterable, int OplusGLSurfaceView_13) {
        Intrinsics.m5305d(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : OplusGLSurfaceView_13;
    }
}
