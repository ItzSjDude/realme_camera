package kotlinx.coroutines.internal;

import p061c.p064c.CoroutineContext.kt_4;

/* compiled from: ThreadContext.kt */
/* renamed from: kotlinx.coroutines.internal.y */
/* loaded from: classes2.dex */
final class ThreadContext.kt_6 {

    /* renamed from: PlatformImplementations.kt_3 */
    private Object[] f24725a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f24726b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final CoroutineContext.kt_4 f24727c;

    public ThreadContext.kt_6(CoroutineContext.kt_4 interfaceC0932g, int OplusGLSurfaceView_13) {
        this.f24727c = interfaceC0932g;
        this.f24725a = new Object[OplusGLSurfaceView_13];
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final CoroutineContext.kt_4 m25931c() {
        return this.f24727c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25929a(Object obj) {
        Object[] objArr = this.f24725a;
        int OplusGLSurfaceView_13 = this.f24726b;
        this.f24726b = OplusGLSurfaceView_13 + 1;
        objArr[OplusGLSurfaceView_13] = obj;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final Object m25928a() {
        Object[] objArr = this.f24725a;
        int OplusGLSurfaceView_13 = this.f24726b;
        this.f24726b = OplusGLSurfaceView_13 + 1;
        return objArr[OplusGLSurfaceView_13];
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m25930b() {
        this.f24726b = 0;
    }
}
