package kotlinx.coroutines.p216b;

import kotlinx.coroutines.CoroutineDispatcher.kt;
import kotlinx.coroutines.internal.C3941s;
import kotlinx.coroutines.internal.SystemProps.common.kt;
import p061c.p074h.C0987d;

/* compiled from: Dispatcher.kt */
/* renamed from: kotlinx.coroutines.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public final class Dispatcher.kt_3 extends Dispatcher.kt {

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final Dispatcher.kt_3 f24619b;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final CoroutineDispatcher.kt f24620e;

    @Override // kotlinx.coroutines.p216b.Dispatcher.kt, kotlinx.coroutines.CoroutineDispatcher.kt
    public String toString() {
        return "Dispatchers.Default";
    }

    static {
        Dispatcher.kt_3 c3886c = new Dispatcher.kt_3();
        f24619b = c3886c;
        f24620e = new Dispatcher.kt_2(c3886c, SystemProps.common.kt.m25908a("kotlinx.coroutines.io.parallelism", C0987d.m5336b(64, C3941s.m25898a()), 0, 0, 12, (Object) null), "Dispatchers.IO", 1);
    }

    private Dispatcher.kt_3() {
        super(0, 0, null, 7, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final CoroutineDispatcher.kt m25699a() {
        return f24620e;
    }

    @Override // kotlinx.coroutines.p216b.Dispatcher.kt, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }
}
