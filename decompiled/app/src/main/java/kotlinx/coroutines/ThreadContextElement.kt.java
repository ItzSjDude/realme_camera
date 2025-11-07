package kotlinx.coroutines;

import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p071a.Functions.kt_19;

/* compiled from: ThreadContextElement.kt */
/* renamed from: kotlinx.coroutines.bl */
/* loaded from: classes2.dex */
public interface ThreadContextElement.kt<S> extends CoroutineContext.kt_4.IntrinsicsJvm.kt_4 {

    /* compiled from: ThreadContextElement.kt */
    /* renamed from: kotlinx.coroutines.bl$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        public static <S, E extends CoroutineContext.kt_4.IntrinsicsJvm.kt_4> E m25791a(ThreadContextElement.kt<S> interfaceC3909bl, CoroutineContext.kt_4.IntrinsicsJvm.kt_3<E> cVar) {
            return (E) CoroutineContext.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.m5275a(interfaceC3909bl, cVar);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static <S> CoroutineContext.kt_4 m25792a(ThreadContextElement.kt<S> interfaceC3909bl, CoroutineContext.kt_4 interfaceC0932g) {
            return CoroutineContext.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.m5276a(interfaceC3909bl, interfaceC0932g);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static <S, R> R m25793a(ThreadContextElement.kt<S> interfaceC3909bl, R r, Functions.kt_19<? super R, ? super CoroutineContext.kt_4.IntrinsicsJvm.kt_4, ? extends R> interfaceC0954m) {
            return (R) CoroutineContext.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.m5277a(interfaceC3909bl, r, interfaceC0954m);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static <S> CoroutineContext.kt_4 m25794b(ThreadContextElement.kt<S> interfaceC3909bl, CoroutineContext.kt_4.IntrinsicsJvm.kt_3<?> cVar) {
            return CoroutineContext.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.m5278b(interfaceC3909bl, cVar);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo25789a(CoroutineContext.kt_4 interfaceC0932g, S s);

    /* renamed from: IntrinsicsJvm.kt_4 */
    S mo25790b(CoroutineContext.kt_4 interfaceC0932g);
}
