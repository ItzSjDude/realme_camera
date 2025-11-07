package p061c.p062a;

import java.util.Collection;
import java.util.Iterator;
import p061c.p070f.p072b.ArrayIterator.kt;
import p061c.p070f.p072b.CollectionToArray.kt;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: Collections.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
final class Collections.kt_2<T> implements Collection<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final T[] f5025a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final boolean f5026b;

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.kt.m5291a(this, tArr);
    }

    public Collections.kt_2(T[] tArr, boolean z) {
        Intrinsics.m5305d(tArr, "values");
        this.f5025a = tArr;
        this.f5026b = z;
    }

    @Override // java.util.Collection
    public final int size() {
        return m5205a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m5205a() {
        return this.f5025a.length;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f5025a.length == 0;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return C0881b.m5219a(this.f5025a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.m5305d(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return ArrayIterator.kt.m5288a(this.f5025a);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return C0887h.m5226a(this.f5025a, this.f5026b);
    }
}
