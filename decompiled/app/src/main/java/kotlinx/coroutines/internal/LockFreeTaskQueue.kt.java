package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LockFreeTaskQueue.kt */
/* renamed from: kotlinx.coroutines.internal.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class LockFreeTaskQueue.kt<E> {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final AtomicReferenceFieldUpdater f24698a = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.kt.class, Object.class, "_cur");
    private volatile Object _cur;

    public LockFreeTaskQueue.kt(boolean z) {
        this._cur = new LockFreeTaskQueue.kt_2(8, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final int m25860a() {
        return ((LockFreeTaskQueue.kt_2) this._cur).m25871b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m25862b() {
        while (true) {
            LockFreeTaskQueue.kt_2 c3933k = (LockFreeTaskQueue.kt_2) this._cur;
            if (c3933k.m25872c()) {
                return;
            } else {
                f24698a.compareAndSet(this, c3933k, c3933k.m25874e());
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m25861a(E COUIBaseListPopupWindow_8) {
        while (true) {
            LockFreeTaskQueue.kt_2 c3933k = (LockFreeTaskQueue.kt_2) this._cur;
            int iM25869a = c3933k.m25869a((LockFreeTaskQueue.kt_2) COUIBaseListPopupWindow_8);
            if (iM25869a == 0) {
                return true;
            }
            if (iM25869a == 1) {
                f24698a.compareAndSet(this, c3933k, c3933k.m25874e());
            } else if (iM25869a == 2) {
                return false;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final E m25863c() {
        while (true) {
            LockFreeTaskQueue.kt_2 c3933k = (LockFreeTaskQueue.kt_2) this._cur;
            E COUIBaseListPopupWindow_8 = (E) c3933k.m25873d();
            if (COUIBaseListPopupWindow_8 != LockFreeTaskQueue.kt_2.f24699a) {
                return COUIBaseListPopupWindow_8;
            }
            f24698a.compareAndSet(this, c3933k, c3933k.m25874e());
        }
    }
}
