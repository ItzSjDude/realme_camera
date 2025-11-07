package kotlinx.coroutines.p216b;

import kotlinx.coroutines.p216b.CoroutineScheduler.kt;

/* renamed from: kotlinx.coroutines.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3885b {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final /* synthetic */ int[] f24618a = new int[CoroutineScheduler.kt.IntrinsicsJvm.kt_3.values().length];

    static {
        f24618a[CoroutineScheduler.kt.IntrinsicsJvm.kt_3.PARKING.ordinal()] = 1;
        f24618a[CoroutineScheduler.kt.IntrinsicsJvm.kt_3.BLOCKING.ordinal()] = 2;
        f24618a[CoroutineScheduler.kt.IntrinsicsJvm.kt_3.CPU_ACQUIRED.ordinal()] = 3;
        f24618a[CoroutineScheduler.kt.IntrinsicsJvm.kt_3.DORMANT.ordinal()] = 4;
        f24618a[CoroutineScheduler.kt.IntrinsicsJvm.kt_3.TERMINATED.ordinal()] = 5;
    }
}
