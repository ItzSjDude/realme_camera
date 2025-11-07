package p061c.p062a;

import java.util.Iterator;

/* compiled from: Iterators.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.w */
/* loaded from: classes.dex */
public abstract class Iterators.kt_2 implements Iterator<Integer> {
    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract int mo5243b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public final Integer next() {
        return Integer.valueOf(mo5243b());
    }
}
