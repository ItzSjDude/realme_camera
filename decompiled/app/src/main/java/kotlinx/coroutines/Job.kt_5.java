package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CoroutineExceptionHandler.kt_2;
import p061c.Unit.kt;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p071a.Functions.kt_3;
import p061c.p070f.p071a.Functions.kt_19;

/* compiled from: Job.kt */
/* renamed from: kotlinx.coroutines.ay */
/* loaded from: classes2.dex */
public interface Job.kt_5 extends CoroutineContext.kt_4.IntrinsicsJvm.kt_4 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final IntrinsicsJvm.kt_4 f24595b = IntrinsicsJvm.kt_4.f24596a;

    /* renamed from: PlatformImplementations.kt_3 */
    Job.kt_4 mo25649a(boolean z, boolean z2, Functions.kt_3<? super Throwable, Unit.kt> interfaceC0943b);

    /* renamed from: PlatformImplementations.kt_3 */
    Job.kt_2 mo25650a(Job.kt interfaceC3948j);

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean mo25562b();

    /* renamed from: COUIBaseListPopupWindow_10 */
    CancellationException mo25651h();

    /* renamed from: OplusGLSurfaceView_13 */
    boolean mo25652i();

    /* compiled from: Job.kt */
    /* renamed from: kotlinx.coroutines.ay$IntrinsicsJvm.kt_4 */
    public static final class IntrinsicsJvm.kt_4 implements CoroutineContext.kt_4.IntrinsicsJvm.kt_3<Job.kt_5> {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ IntrinsicsJvm.kt_4 f24596a = new IntrinsicsJvm.kt_4();

        static {
            CoroutineExceptionHandler.kt_2.CoroutineExceptionHandler.kt_3 c3850a = CoroutineExceptionHandler.kt_2.f24546a;
        }

        private IntrinsicsJvm.kt_4() {
        }
    }

    /* compiled from: Job.kt */
    /* renamed from: kotlinx.coroutines.ay$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        public static <E extends CoroutineContext.kt_4.IntrinsicsJvm.kt_4> E m25653a(Job.kt_5 interfaceC3881ay, CoroutineContext.kt_4.IntrinsicsJvm.kt_3<E> cVar) {
            return (E) CoroutineContext.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.m5275a(interfaceC3881ay, cVar);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static CoroutineContext.kt_4 m25654a(Job.kt_5 interfaceC3881ay, CoroutineContext.kt_4 interfaceC0932g) {
            return CoroutineContext.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.m5276a(interfaceC3881ay, interfaceC0932g);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static <R> R m25655a(Job.kt_5 interfaceC3881ay, R r, Functions.kt_19<? super R, ? super CoroutineContext.kt_4.IntrinsicsJvm.kt_4, ? extends R> interfaceC0954m) {
            return (R) CoroutineContext.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.m5277a(interfaceC3881ay, r, interfaceC0954m);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static CoroutineContext.kt_4 m25657b(Job.kt_5 interfaceC3881ay, CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> cVar) {
            return CoroutineContext.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.m5278b(interfaceC3881ay, cVar);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static /* synthetic */ Job.kt_4 m25656a(Job.kt_5 interfaceC3881ay, boolean z, boolean z2, Functions.kt_3 interfaceC0943b, int OplusGLSurfaceView_13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((OplusGLSurfaceView_13 & 1) != 0) {
                z = false;
            }
            if ((OplusGLSurfaceView_13 & 2) != 0) {
                z2 = true;
            }
            return interfaceC3881ay.mo25649a(z, z2, interfaceC0943b);
        }
    }
}
