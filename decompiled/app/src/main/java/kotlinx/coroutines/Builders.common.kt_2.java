package kotlinx.coroutines;

import kotlinx.coroutines.p215a.Cancellable.kt;
import p061c.Unit.kt;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p064c.p065a.C0914b;
import p061c.p070f.p071a.Functions.kt_19;

/* compiled from: Builders.common.kt */
/* renamed from: kotlinx.coroutines.be */
/* loaded from: classes2.dex */
final class Builders.common.kt_2 extends Builders.common.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Continuation.kt_2<Unit.kt> f24666c;

    public Builders.common.kt_2(CoroutineContext.kt_4 interfaceC0932g, Functions.kt_19<? super CoroutineScope.kt_2, ? super Continuation.kt_2<? super Unit.kt>, ? extends Object> interfaceC0954m) {
        super(interfaceC0932g, false);
        this.f24666c = C0914b.m5251a(interfaceC0954m, this, this);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine.kt
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void mo25565d() {
        Cancellable.kt.m25569a(this.f24666c, this);
    }
}
