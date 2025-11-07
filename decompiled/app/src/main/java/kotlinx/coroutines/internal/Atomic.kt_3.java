package kotlinx.coroutines.internal;

import kotlinx.coroutines.DebugStrings.kt;

/* compiled from: Atomic.kt */
/* renamed from: kotlinx.coroutines.internal.o */
/* loaded from: classes2.dex */
public abstract class Atomic.kt_3 {
    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract Atomic.kt<?> mo25831b();

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract Object mo25832c(Object obj);

    public String toString() {
        return DebugStrings.kt.m25580b(this) + '@' + DebugStrings.kt.m25579a(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m25886a(Atomic.kt_3 abstractC3937o) {
        Atomic.kt<?> abstractC3925cMo25831b;
        Atomic.kt<?> abstractC3925cMo25831b2 = mo25831b();
        return (abstractC3925cMo25831b2 == null || (abstractC3925cMo25831b = abstractC3937o.mo25831b()) == null || abstractC3925cMo25831b2.m25828a() >= abstractC3925cMo25831b.m25828a()) ? false : true;
    }
}
