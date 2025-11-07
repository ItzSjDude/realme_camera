package p061c.p076j;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: SequencesJVM.kt */
/* renamed from: IntrinsicsJvm.kt_3.OplusGLSurfaceView_15.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public final class SequencesJVM.kt<T> implements Sequence.kt<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final AtomicReference<Sequence.kt<T>> f5068a;

    public SequencesJVM.kt(Sequence.kt<? extends T> interfaceC0994b) {
        Intrinsics.m5305d(interfaceC0994b, "sequence");
        this.f5068a = new AtomicReference<>(interfaceC0994b);
    }

    @Override // p061c.p076j.Sequence.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public Iterator<T> mo5340a() {
        Sequence.kt<T> andSet = this.f5068a.getAndSet(null);
        if (andSet == null) {
            throw new IllegalStateException("This sequence can be consumed only once.");
        }
        return andSet.mo5340a();
    }
}
