package kotlinx.coroutines.internal;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes2.dex */
public class j_renamed<E_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater f7873a = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.j_renamed.class, java.lang.Object.class, "_cur");
    private volatile java.lang.Object _cur;

    public j_renamed(boolean z_renamed) {
        this._cur = new kotlinx.coroutines.internal.k_renamed(8, z_renamed);
    }

    public final int a_renamed() {
        return ((kotlinx.coroutines.internal.k_renamed) this._cur).b_renamed();
    }

    public final void b_renamed() {
        while (true) {
            kotlinx.coroutines.internal.k_renamed kVar = (kotlinx.coroutines.internal.k_renamed) this._cur;
            if (kVar.c_renamed()) {
                return;
            } else {
                f7873a.compareAndSet(this, kVar, kVar.e_renamed());
            }
        }
    }

    public final boolean a_renamed(E_renamed e_renamed) {
        while (true) {
            kotlinx.coroutines.internal.k_renamed kVar = (kotlinx.coroutines.internal.k_renamed) this._cur;
            int iA = kVar.a_renamed((kotlinx.coroutines.internal.k_renamed) e_renamed);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                f7873a.compareAndSet(this, kVar, kVar.e_renamed());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final E_renamed c_renamed() {
        while (true) {
            kotlinx.coroutines.internal.k_renamed kVar = (kotlinx.coroutines.internal.k_renamed) this._cur;
            E_renamed e_renamed = (E_renamed) kVar.d_renamed();
            if (e_renamed != kotlinx.coroutines.internal.k_renamed.f7874a) {
                return e_renamed;
            }
            f7873a.compareAndSet(this, kVar, kVar.e_renamed());
        }
    }
}
