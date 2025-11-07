package p061c.p062a;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import p061c.p070f.p072b.CollectionToArray.kt;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: Collections.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.t */
/* loaded from: classes.dex */
public final class Collections.kt implements Serializable, List, RandomAccess {
    public static final Collections.kt INSTANCE = new Collections.kt();
    private static final long serialVersionUID = -7390468764508069838L;

    @Override // java.util.List
    public /* synthetic */ void add(int OplusGLSurfaceView_13, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(int OplusGLSurfaceView_13, Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Void r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int OplusGLSurfaceView_13, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Void r1) {
        Intrinsics.m5305d(r1, "element");
        return false;
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return 1;
    }

    public int indexOf(Void r1) {
        Intrinsics.m5305d(r1, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    public int lastIndexOf(Void r1) {
        Intrinsics.m5305d(r1, "element");
        return -1;
    }

    @Override // java.util.List
    public /* synthetic */ Object remove(int OplusGLSurfaceView_13) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Void remove(int OplusGLSurfaceView_13) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* synthetic */ Object set(int OplusGLSurfaceView_13, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void set(int OplusGLSurfaceView_13, Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.kt.m5290a(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.kt.m5291a(this, tArr);
    }

    public String toString() {
        return "[]";
    }

    private Collections.kt() {
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return contains((Void) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Void) {
            return indexOf((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return lastIndexOf((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return getSize();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        Intrinsics.m5305d(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.List
    public Void get(int OplusGLSurfaceView_13) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + OplusGLSurfaceView_13 + '.');
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return Collections.kt_3.f5027a;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return Collections.kt_3.f5027a;
    }

    @Override // java.util.List
    public ListIterator listIterator(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            throw new IndexOutOfBoundsException("Index: " + OplusGLSurfaceView_13);
        }
        return Collections.kt_3.f5027a;
    }

    @Override // java.util.List
    public List subList(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 == 0 && i2 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + OplusGLSurfaceView_13 + ", toIndex: " + i2);
    }

    private final Object readResolve() {
        return INSTANCE;
    }
}
