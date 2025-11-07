package kotlinx.coroutines.p216b;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.C3941s;
import kotlinx.coroutines.internal.SystemProps.common.kt;
import p061c.p074h.C0987d;

/* compiled from: Tasks.kt */
/* renamed from: kotlinx.coroutines.IntrinsicsJvm.kt_4.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public final class Tasks.kt_4 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final long f24638a = SystemProps.common.kt.m25910a("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, (Object) null);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final int f24639b = SystemProps.common.kt.m25908a("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final int f24640c = SystemProps.common.kt.m25908a("kotlinx.coroutines.scheduler.core.pool.size", C0987d.m5336b(C3941s.m25898a(), 2), 1, 0, 8, (Object) null);

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static final int f24641d = SystemProps.common.kt.m25908a("kotlinx.coroutines.scheduler.max.pool.size", C0987d.m5333a(C3941s.m25898a() * 128, f24640c, 2097150), 0, 2097150, 4, (Object) null);

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static final long f24642e = TimeUnit.SECONDS.toNanos(SystemProps.common.kt.m25910a("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, (Object) null));

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static Tasks.kt_7 f24643f = Tasks.kt.f24632a;
}
