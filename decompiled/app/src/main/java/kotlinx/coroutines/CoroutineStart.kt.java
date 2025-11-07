package kotlinx.coroutines;

import kotlinx.coroutines.p215a.Cancellable.kt;
import kotlinx.coroutines.p215a.Undispatched.kt;
import p061c.NoWhenBranchMatchedException.kt;
import p061c.p064c.Continuation.kt;
import p061c.p064c.Continuation.kt_2;
import p061c.p070f.p071a.Functions.kt_3;
import p061c.p070f.p071a.Functions.kt_19;

/* compiled from: CoroutineStart.kt */
/* renamed from: kotlinx.coroutines.z */
/* loaded from: classes2.dex */
public enum CoroutineStart.kt {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public static /* synthetic */ void isLazy$annotations() {
    }

    public final <T> void invoke(Functions.kt_3<? super Continuation.kt_2<? super T>, ? extends Object> interfaceC0943b, Continuation.kt_2<? super T> interfaceC0929d) {
        int OplusGLSurfaceView_13 = C3854aa.f24550a[ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            Cancellable.kt.m25570a(interfaceC0943b, interfaceC0929d);
            return;
        }
        if (OplusGLSurfaceView_13 == 2) {
            Continuation.kt.m5272a(interfaceC0943b, interfaceC0929d);
        } else if (OplusGLSurfaceView_13 == 3) {
            Undispatched.kt.m25572a(interfaceC0943b, interfaceC0929d);
        } else if (OplusGLSurfaceView_13 != 4) {
            throw new NoWhenBranchMatchedException.kt();
        }
    }

    public final <R, T> void invoke(Functions.kt_19<? super R, ? super Continuation.kt_2<? super T>, ? extends Object> interfaceC0954m, R r, Continuation.kt_2<? super T> interfaceC0929d) {
        int OplusGLSurfaceView_13 = C3854aa.f24551b[ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            Cancellable.kt.m25571a(interfaceC0954m, r, interfaceC0929d);
            return;
        }
        if (OplusGLSurfaceView_13 == 2) {
            Continuation.kt.m5273a(interfaceC0954m, r, interfaceC0929d);
        } else if (OplusGLSurfaceView_13 == 3) {
            Undispatched.kt.m25573a(interfaceC0954m, r, interfaceC0929d);
        } else if (OplusGLSurfaceView_13 != 4) {
            throw new NoWhenBranchMatchedException.kt();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }
}
