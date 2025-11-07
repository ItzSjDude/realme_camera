package p061c.p064c;

import p061c.Result.kt;
import p061c.Unit.kt;
import p061c.p064c.p065a.C0914b;
import p061c.p070f.p071a.Functions.kt_3;
import p061c.p070f.p071a.Functions.kt_19;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: Continuation.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public final class Continuation.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> void m5272a(Functions.kt_3<? super Continuation.kt_2<? super T>, ? extends Object> interfaceC0943b, Continuation.kt_2<? super T> interfaceC0929d) {
        Intrinsics.m5305d(interfaceC0943b, "$this$startCoroutine");
        Intrinsics.m5305d(interfaceC0929d, "completion");
        Continuation.kt_2 interfaceC0929dA = C0914b.m5249a(C0914b.m5250a(interfaceC0943b, interfaceC0929d));
        Unit.kt c1025s = Unit.kt.f5071a;
        Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
        interfaceC0929dA.resumeWith(Result.kt.m26270constructorimpl(c1025s));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <R, T> void m5273a(Functions.kt_19<? super R, ? super Continuation.kt_2<? super T>, ? extends Object> interfaceC0954m, R r, Continuation.kt_2<? super T> interfaceC0929d) {
        Intrinsics.m5305d(interfaceC0954m, "$this$startCoroutine");
        Intrinsics.m5305d(interfaceC0929d, "completion");
        Continuation.kt_2 interfaceC0929dA = C0914b.m5249a(C0914b.m5251a(interfaceC0954m, r, interfaceC0929d));
        Unit.kt c1025s = Unit.kt.f5071a;
        Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
        interfaceC0929dA.resumeWith(Result.kt.m26270constructorimpl(c1025s));
    }
}
