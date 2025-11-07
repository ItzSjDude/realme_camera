package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.Debug.kt;

/* compiled from: Atomic.kt */
/* renamed from: kotlinx.coroutines.internal.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public abstract class Atomic.kt<T> extends Atomic.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final AtomicReferenceFieldUpdater f24685a = AtomicReferenceFieldUpdater.newUpdater(Atomic.kt.class, Object.class, "_consensus");
    private volatile Object _consensus = Atomic.kt_2.f24684b;

    /* renamed from: PlatformImplementations.kt_3 */
    public long m25828a() {
        return 0L;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract Object mo25778a(T t);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo25829a(T t, Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.Atomic.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Atomic.kt<?> mo25831b() {
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final Object m25830b(Object obj) {
        if (Debug.kt.m25574a()) {
            if (!(obj != Atomic.kt_2.f24684b)) {
                throw new AssertionError();
            }
        }
        Object obj2 = this._consensus;
        return obj2 != Atomic.kt_2.f24684b ? obj2 : f24685a.compareAndSet(this, Atomic.kt_2.f24684b, obj) ? obj : this._consensus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.Atomic.kt_3
    /* renamed from: IntrinsicsJvm.kt_3 */
    public final Object mo25832c(Object obj) {
        Object objM25830b = this._consensus;
        if (objM25830b == Atomic.kt_2.f24684b) {
            objM25830b = m25830b(mo25778a((Atomic.kt<T>) obj));
        }
        mo25829a(obj, objM25830b);
        return objM25830b;
    }
}
