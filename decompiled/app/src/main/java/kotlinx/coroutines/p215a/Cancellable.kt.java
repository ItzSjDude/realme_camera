package kotlinx.coroutines.p215a;

import kotlinx.coroutines.DispatchedContinuation.kt;
import p061c.Result.kt;
import p061c.Result.kt_4;
import p061c.Unit.kt;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.p065a.C0914b;
import p061c.p070f.p071a.Functions.kt_3;
import p061c.p070f.p071a.Functions.kt_19;

/* compiled from: Cancellable.kt */
/* renamed from: kotlinx.coroutines.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public final class Cancellable.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> void m25570a(Functions.kt_3<? super Continuation.kt_2<? super T>, ? extends Object> interfaceC0943b, Continuation.kt_2<? super T> interfaceC0929d) {
        try {
            Continuation.kt_2 interfaceC0929dA = C0914b.m5249a(C0914b.m5250a(interfaceC0943b, interfaceC0929d));
            Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
            DispatchedContinuation.kt.m25591a(interfaceC0929dA, Result.kt.m26270constructorimpl(Unit.kt.f5071a));
        } catch (Throwable th) {
            Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
            interfaceC0929d.resumeWith(Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th)));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <R, T> void m25571a(Functions.kt_19<? super R, ? super Continuation.kt_2<? super T>, ? extends Object> interfaceC0954m, R r, Continuation.kt_2<? super T> interfaceC0929d) {
        try {
            Continuation.kt_2 interfaceC0929dA = C0914b.m5249a(C0914b.m5251a(interfaceC0954m, r, interfaceC0929d));
            Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
            DispatchedContinuation.kt.m25591a(interfaceC0929dA, Result.kt.m26270constructorimpl(Unit.kt.f5071a));
        } catch (Throwable th) {
            Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
            interfaceC0929d.resumeWith(Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th)));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final void m25569a(Continuation.kt_2<? super Unit.kt> interfaceC0929d, Continuation.kt_2<?> interfaceC0929d2) {
        try {
            Continuation.kt_2 interfaceC0929dA = C0914b.m5249a(interfaceC0929d);
            Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
            DispatchedContinuation.kt.m25591a(interfaceC0929dA, Result.kt.m26270constructorimpl(Unit.kt.f5071a));
        } catch (Throwable th) {
            Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
            interfaceC0929d2.resumeWith(Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th)));
        }
    }
}
