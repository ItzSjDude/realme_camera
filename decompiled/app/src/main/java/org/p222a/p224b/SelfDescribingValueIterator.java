package org.p222a.p224b;

import java.util.Iterator;
import org.p222a.SelfDescribing;

/* compiled from: SelfDescribingValueIterator.java */
/* renamed from: org.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class SelfDescribingValueIterator<T> implements Iterator<SelfDescribing> {

    /* renamed from: PlatformImplementations.kt_3 */
    private Iterator<T> f24796a;

    public SelfDescribingValueIterator(Iterator<T> it) {
        this.f24796a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f24796a.hasNext();
    }

    @Override // java.util.Iterator
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public SelfDescribing next() {
        return new SelfDescribingValue(this.f24796a.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f24796a.remove();
    }
}
