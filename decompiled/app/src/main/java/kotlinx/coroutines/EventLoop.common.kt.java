package kotlinx.coroutines;

import com.sensetime.stmobile.STMobileHumanActionNative;
import kotlinx.coroutines.internal.ArrayQueue.kt;

/* compiled from: EventLoop.common.kt */
/* renamed from: kotlinx.coroutines.am */
/* loaded from: classes2.dex */
public abstract class EventLoop.common.kt extends CoroutineDispatcher.kt {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private long f24572b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f24573d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ArrayQueue.kt<DispatchedTask.kt<?>> f24574e;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final long m25608c(boolean z) {
        if (z) {
            return STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1;
        }
        return 1L;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected void mo25618h() {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public long mo25611b() {
        return !m25615e() ? Long.MAX_VALUE : 0L;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected boolean mo25613c() {
        return m25617g();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected long mo25614d() {
        ArrayQueue.kt<DispatchedTask.kt<?>> c3923a = this.f24574e;
        return (c3923a == null || c3923a.m25825a()) ? Long.MAX_VALUE : 0L;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final boolean m25615e() {
        DispatchedTask.kt<?> abstractC3861ahM25826b;
        ArrayQueue.kt<DispatchedTask.kt<?>> c3923a = this.f24574e;
        if (c3923a == null || (abstractC3861ahM25826b = c3923a.m25826b()) == null) {
            return false;
        }
        abstractC3861ahM25826b.run();
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25609a(DispatchedTask.kt<?> abstractC3861ah) {
        ArrayQueue.kt<DispatchedTask.kt<?>> c3923a = this.f24574e;
        if (c3923a == null) {
            c3923a = new ArrayQueue.kt<>();
            this.f24574e = c3923a;
        }
        c3923a.m25824a(abstractC3861ah);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public final boolean m25616f() {
        return this.f24572b >= m25608c(true);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public final boolean m25617g() {
        ArrayQueue.kt<DispatchedTask.kt<?>> c3923a = this.f24574e;
        if (c3923a != null) {
            return c3923a.m25825a();
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m25607a(EventLoop.common.kt abstractC3866am, boolean z, int OplusGLSurfaceView_13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((OplusGLSurfaceView_13 & 1) != 0) {
            z = false;
        }
        abstractC3866am.m25610a(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25610a(boolean z) {
        this.f24572b += m25608c(z);
        if (z) {
            return;
        }
        this.f24573d = true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m25612b(boolean z) {
        this.f24572b -= m25608c(z);
        if (this.f24572b > 0) {
            return;
        }
        if (Debug.kt.m25574a()) {
            if (!(this.f24572b == 0)) {
                throw new AssertionError();
            }
        }
        if (this.f24573d) {
            mo25618h();
        }
    }
}
