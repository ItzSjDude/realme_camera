package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p061c.p070f.p072b.DefaultConstructorMarker;

/* compiled from: CompletedExceptionally.kt */
/* renamed from: kotlinx.coroutines.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class CompletedExceptionally.kt {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final AtomicIntegerFieldUpdater f24733b = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.kt.class, "_handled");
    private volatile int _handled;

    /* renamed from: PlatformImplementations.kt_3 */
    public final Throwable f24734a;

    public CompletedExceptionally.kt(Throwable th, boolean z) {
        this.f24734a = th;
        this._handled = z ? 1 : 0;
    }

    public /* synthetic */ CompletedExceptionally.kt(Throwable th, boolean z, int OplusGLSurfaceView_13, DefaultConstructorMarker c0970f) {
        this(th, (OplusGLSurfaceView_13 & 2) != 0 ? false : z);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public final boolean m25937b() {
        return this._handled;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final boolean m25938c() {
        return f24733b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return DebugStrings.kt.m25580b(this) + '[' + this.f24734a + ']';
    }
}
