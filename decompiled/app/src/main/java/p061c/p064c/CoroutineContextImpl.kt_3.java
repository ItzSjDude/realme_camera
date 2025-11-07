package p061c.p064c;

import java.io.Serializable;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p071a.Functions.kt_19;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: CoroutineContextImpl.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public final class CoroutineContextImpl.kt_3 implements CoroutineContext.kt_4, Serializable {
    public static final CoroutineContextImpl.kt_3 INSTANCE = new CoroutineContextImpl.kt_3();
    private static final long serialVersionUID = 0;

    @Override // p061c.p064c.CoroutineContext.kt_4
    public <R> R fold(R r, Functions.kt_19<? super R, ? super CoroutineContext.kt_4.IntrinsicsJvm.kt_4, ? extends R> interfaceC0954m) {
        Intrinsics.m5305d(interfaceC0954m, "operation");
        return r;
    }

    @Override // p061c.p064c.CoroutineContext.kt_4
    public <E extends CoroutineContext.kt_4.IntrinsicsJvm.kt_4> E get(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<E> cVar) {
        Intrinsics.m5305d(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // p061c.p064c.CoroutineContext.kt_4
    public CoroutineContext.kt_4 plus(CoroutineContext.kt_4 interfaceC0932g) {
        Intrinsics.m5305d(interfaceC0932g, "context");
        return interfaceC0932g;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }

    private CoroutineContextImpl.kt_3() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // p061c.p064c.CoroutineContext.kt_4
    public CoroutineContext.kt_4 minusKey(CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> cVar) {
        Intrinsics.m5305d(cVar, "key");
        return this;
    }
}
