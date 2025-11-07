package kotlinx.coroutines.p215a;

import kotlinx.coroutines.internal.ThreadContext.kt;
import p061c.Result.kt;
import p061c.Result.kt_4;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p064c.p065a.C0914b;
import p061c.p064c.p066b.p067a.DebugProbes.kt_2;
import p061c.p070f.p071a.Functions.kt_3;
import p061c.p070f.p071a.Functions.kt_19;
import p061c.p070f.p072b.TypeIntrinsics;

/* compiled from: Undispatched.kt */
/* renamed from: kotlinx.coroutines.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public final class Undispatched.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> void m25572a(Functions.kt_3<? super Continuation.kt_2<? super T>, ? extends Object> interfaceC0943b, Continuation.kt_2<? super T> interfaceC0929d) {
        Continuation.kt_2 interfaceC0929dM5264a = DebugProbes.kt_2.m5264a(interfaceC0929d);
        try {
            CoroutineContext.kt_4 context = interfaceC0929d.getContext();
            Object objM25913a = ThreadContext.kt.m25913a(context, null);
            try {
                if (interfaceC0943b != null) {
                    Object objInvoke = ((Functions.kt_3) TypeIntrinsics.m5320b(interfaceC0943b, 1)).invoke(interfaceC0929dM5264a);
                    if (objInvoke != C0914b.m5252a()) {
                        Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
                        interfaceC0929dM5264a.resumeWith(Result.kt.m26270constructorimpl(objInvoke));
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            } finally {
                ThreadContext.kt.m25914b(context, objM25913a);
            }
        } catch (Throwable th) {
            Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
            interfaceC0929dM5264a.resumeWith(Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th)));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <R, T> void m25573a(Functions.kt_19<? super R, ? super Continuation.kt_2<? super T>, ? extends Object> interfaceC0954m, R r, Continuation.kt_2<? super T> interfaceC0929d) {
        Continuation.kt_2 interfaceC0929dM5264a = DebugProbes.kt_2.m5264a(interfaceC0929d);
        try {
            CoroutineContext.kt_4 context = interfaceC0929d.getContext();
            Object objM25913a = ThreadContext.kt.m25913a(context, null);
            try {
                if (interfaceC0954m != null) {
                    Object objInvoke = ((Functions.kt_19) TypeIntrinsics.m5320b(interfaceC0954m, 2)).invoke(r, interfaceC0929dM5264a);
                    if (objInvoke != C0914b.m5252a()) {
                        Result.kt.PlatformImplementations.kt_3 aVar = Result.kt.Companion;
                        interfaceC0929dM5264a.resumeWith(Result.kt.m26270constructorimpl(objInvoke));
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            } finally {
                ThreadContext.kt.m25914b(context, objM25913a);
            }
        } catch (Throwable th) {
            Result.kt.PlatformImplementations.kt_3 aVar2 = Result.kt.Companion;
            interfaceC0929dM5264a.resumeWith(Result.kt.m26270constructorimpl(Result.kt_4.m5380a(th)));
        }
    }
}
