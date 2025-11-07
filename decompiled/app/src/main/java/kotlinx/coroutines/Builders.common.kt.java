package kotlinx.coroutines;

import p061c.Unit.kt;
import p061c.p064c.CoroutineContextImpl.kt_3;
import p061c.p064c.Continuation.kt_2;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p071a.Functions.kt_19;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.common.kt */
/* renamed from: kotlinx.coroutines.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class Builders.common.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ Job.kt_5 m25810a(CoroutineScope.kt_2 interfaceC3963y, CoroutineContext.kt_4 interfaceC0932g, CoroutineStart.kt enumC3964z, Functions.kt_19 interfaceC0954m, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 1) != 0) {
            interfaceC0932g = CoroutineContextImpl.kt_3.INSTANCE;
        }
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            enumC3964z = CoroutineStart.kt.DEFAULT;
        }
        return C3916c.m25807a(interfaceC3963y, interfaceC0932g, enumC3964z, interfaceC0954m);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Job.kt_5 m25809a(CoroutineScope.kt_2 interfaceC3963y, CoroutineContext.kt_4 interfaceC0932g, CoroutineStart.kt enumC3964z, Functions.kt_19<? super CoroutineScope.kt_2, ? super Continuation.kt_2<? super Unit.kt>, ? extends Object> interfaceC0954m) {
        Builders.common.kt_2 c3908bk;
        CoroutineContext.kt_4 interfaceC0932gM25941a = CoroutineContext.kt_3.m25941a(interfaceC3963y, interfaceC0932g);
        if (enumC3964z.isLazy()) {
            c3908bk = new Builders.common.kt_2(interfaceC0932gM25941a, interfaceC0954m);
        } else {
            c3908bk = new Builders.common.kt_3(interfaceC0932gM25941a, true);
        }
        c3908bk.m25560a(enumC3964z, (CoroutineStart.kt) c3908bk, (Functions.kt_19<? super CoroutineStart.kt, ? super Continuation.kt_2<? super T>, ? extends Object>) interfaceC0954m);
        return c3908bk;
    }
}
