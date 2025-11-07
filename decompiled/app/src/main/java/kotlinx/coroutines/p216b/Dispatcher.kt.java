package kotlinx.coroutines.p216b;

import java.util.concurrent.RejectedExecutionException;
import kotlinx.coroutines.Executors.kt;
import kotlinx.coroutines.DefaultExecutor.kt;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p072b.DefaultConstructorMarker;

/* compiled from: Dispatcher.kt */
/* renamed from: kotlinx.coroutines.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class Dispatcher.kt extends Executors.kt {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CoroutineScheduler.kt f24621b;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f24622e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final int f24623f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final long f24624g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final String f24625h;

    public Dispatcher.kt(int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15, String str) {
        this.f24622e = OplusGLSurfaceView_13;
        this.f24623f = i2;
        this.f24624g = OplusGLSurfaceView_15;
        this.f24625h = str;
        this.f24621b = m25700a();
    }

    public /* synthetic */ Dispatcher.kt(int OplusGLSurfaceView_13, int i2, String str, int i3, DefaultConstructorMarker c0970f) {
        this((i3 & 1) != 0 ? Tasks.kt_4.f24640c : OplusGLSurfaceView_13, (i3 & 2) != 0 ? Tasks.kt_4.f24641d : i2, (i3 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    public Dispatcher.kt(int OplusGLSurfaceView_13, int i2, String str) {
        this(OplusGLSurfaceView_13, i2, Tasks.kt_4.f24642e, str);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25629a(CoroutineContext.kt_4 interfaceC0932g, Runnable runnable) {
        try {
            CoroutineScheduler.kt.m25660a(this.f24621b, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.kt.f24556b.mo25629a(interfaceC0932g, runnable);
        }
    }

    public void close() {
        this.f24621b.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    public String toString() {
        return super.toString() + "[scheduler = " + this.f24621b + ']';
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25701a(Runnable runnable, Tasks.kt_6 interfaceC3893j, boolean z) {
        try {
            this.f24621b.m25673a(runnable, interfaceC3893j, z);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.kt.f24556b.m25630a(this.f24621b.m25671a(runnable, interfaceC3893j));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final CoroutineScheduler.kt m25700a() {
        return new CoroutineScheduler.kt(this.f24622e, this.f24623f, this.f24624g, this.f24625h);
    }
}
