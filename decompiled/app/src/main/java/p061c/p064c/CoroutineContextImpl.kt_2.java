package p061c.p064c;

import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p071a.Functions.kt_19;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: CoroutineContextImpl.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class CoroutineContextImpl.kt_2 implements CoroutineContext.kt_4.IntrinsicsJvm.kt_4 {
    private final CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> key;

    public CoroutineContextImpl.kt_2(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> cVar) {
        Intrinsics.m5305d(cVar, "key");
        this.key = cVar;
    }

    @Override // p061c.p064c.CoroutineContext.kt_4
    public <R> R fold(R r, Functions.kt_19<? super R, ? super CoroutineContext.kt_4.IntrinsicsJvm.kt_4, ? extends R> interfaceC0954m) {
        Intrinsics.m5305d(interfaceC0954m, "operation");
        return (R) CoroutineContext.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.m5277a(this, r, interfaceC0954m);
    }

    @Override // p061c.p064c.CoroutineContext.kt_4.IntrinsicsJvm.kt_4, p061c.p064c.CoroutineContext.kt_4
    public <E extends CoroutineContext.kt_4.IntrinsicsJvm.kt_4> E get(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<E> cVar) {
        Intrinsics.m5305d(cVar, "key");
        return (E) CoroutineContext.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.m5275a(this, cVar);
    }

    @Override // p061c.p064c.CoroutineContext.kt_4.IntrinsicsJvm.kt_4
    public CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> getKey() {
        return this.key;
    }

    @Override // p061c.p064c.CoroutineContext.kt_4
    public CoroutineContext.kt_4 minusKey(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> cVar) {
        Intrinsics.m5305d(cVar, "key");
        return CoroutineContext.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.m5278b(this, cVar);
    }

    @Override // p061c.p064c.CoroutineContext.kt_4
    public CoroutineContext.kt_4 plus(CoroutineContext.kt_4 interfaceC0932g) {
        Intrinsics.m5305d(interfaceC0932g, "context");
        return CoroutineContext.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.m5276a(this, interfaceC0932g);
    }
}
