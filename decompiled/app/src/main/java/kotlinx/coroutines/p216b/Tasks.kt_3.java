package kotlinx.coroutines.p216b;

import kotlinx.coroutines.DebugStrings.kt;

/* compiled from: Tasks.kt */
/* renamed from: kotlinx.coroutines.IntrinsicsJvm.kt_4.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public final class Tasks.kt_3 extends Tasks.kt_8 {

    /* renamed from: PlatformImplementations.kt_3 */
    public final Runnable f24637a;

    public Tasks.kt_3(Runnable runnable, long OplusGLSurfaceView_15, Tasks.kt_6 interfaceC3893j) {
        super(OplusGLSurfaceView_15, interfaceC3893j);
        this.f24637a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f24637a.run();
        } finally {
            this.f24636g.mo25703a();
        }
    }

    public String toString() {
        return "Task[" + DebugStrings.kt.m25580b(this.f24637a) + '@' + DebugStrings.kt.m25579a(this.f24637a) + ", " + this.f24635f + ", " + this.f24636g + ']';
    }
}
