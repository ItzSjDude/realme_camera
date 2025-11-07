package p061c.p064c;

import p061c.p064c.CoroutineContext.kt_4;
import p061c.p064c.CoroutineContext.kt_4.IntrinsicsJvm.kt_4;
import p061c.p070f.p071a.Functions.kt_3;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: CoroutineContextImpl.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public abstract class CoroutineContextImpl.kt<B extends CoroutineContext.kt_4.IntrinsicsJvm.kt_4, E extends B> implements CoroutineContext.kt_4.IntrinsicsJvm.kt_3<E> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> f5028a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Functions.kt_3<CoroutineContext.kt_4.IntrinsicsJvm.kt_4, E> f5029b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_3<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4<? super IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4, ? extends E extends B>, IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4<IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4, E extends B>, java.lang.Object] */
    public CoroutineContextImpl.kt(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<B> cVar, Functions.kt_3<? super CoroutineContext.kt_4.IntrinsicsJvm.kt_4, ? extends E> interfaceC0943b) {
        Intrinsics.m5305d(cVar, "baseKey");
        Intrinsics.m5305d(interfaceC0943b, "safeCast");
        this.f5029b = interfaceC0943b;
        this.f5028a = cVar instanceof CoroutineContextImpl.kt ? (CoroutineContext.kt_4.IntrinsicsJvm.kt_3<B>) ((CoroutineContextImpl.kt) cVar).f5028a : cVar;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lc/IntrinsicsJvm.kt_3/COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4;)TE; */
    /* renamed from: PlatformImplementations.kt_3 */
    public final CoroutineContext.kt_4.IntrinsicsJvm.kt_4 m5253a(CoroutineContext.kt_4.IntrinsicsJvm.kt_4 bVar) {
        Intrinsics.m5305d(bVar, "element");
        return (CoroutineContext.kt_4.IntrinsicsJvm.kt_4) this.f5029b.invoke(bVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m5254a(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> cVar) {
        Intrinsics.m5305d(cVar, "key");
        return cVar == this || this.f5028a == cVar;
    }
}
