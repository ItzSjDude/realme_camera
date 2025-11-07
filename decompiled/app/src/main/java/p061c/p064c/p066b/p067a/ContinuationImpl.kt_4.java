package p061c.p064c.p066b.p067a;

import p061c.p064c.Continuation.kt_2;
import p061c.p064c.CoroutineContext.kt_4;

/* compiled from: ContinuationImpl.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public final class ContinuationImpl.kt_4 implements Continuation.kt_2<Object> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final ContinuationImpl.kt_4 f5030a = new ContinuationImpl.kt_4();

    public String toString() {
        return "This continuation is already complete";
    }

    private ContinuationImpl.kt_4() {
    }

    @Override // p061c.p064c.Continuation.kt_2
    public CoroutineContext.kt_4 getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // p061c.p064c.Continuation.kt_2
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }
}
