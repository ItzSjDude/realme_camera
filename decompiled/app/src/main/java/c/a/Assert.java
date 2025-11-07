package c_renamed.a_renamed;

/* compiled from: Collections.kt */
/* loaded from: classes.dex */
final class a_renamed<T_renamed> implements java.util.Collection<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final T_renamed[] f1885a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final boolean f1886b;

    @Override // java.util.Collection
    public boolean add(T_renamed t_renamed) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(java.util.Collection<? extends T_renamed> collection) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean remove(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(java.util.Collection<? extends java.lang.Object> collection) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(java.util.Collection<? extends java.lang.Object> collection) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Collection
    public <T_renamed> T_renamed[] toArray(T_renamed[] tArr) {
        return (T_renamed[]) c_renamed.f_renamed.b_renamed.e_renamed.a_renamed(this, tArr);
    }

    public a_renamed(T_renamed[] tArr, boolean z_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(tArr, "values");
        this.f1885a = tArr;
        this.f1886b = z_renamed;
    }

    @Override // java.util.Collection
    public final int size() {
        return a_renamed();
    }

    public int a_renamed() {
        return this.f1885a.length;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f1885a.length == 0;
    }

    @Override // java.util.Collection
    public boolean contains(java.lang.Object obj) {
        return c_renamed.a_renamed.b_renamed.a_renamed(this.f1885a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(java.util.Collection<? extends java.lang.Object> collection) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(collection, "elements");
        java.util.Collection<? extends java.lang.Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        java.util.Iterator<T_renamed> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<T_renamed> iterator() {
        return c_renamed.f_renamed.b_renamed.b_renamed.a_renamed(this.f1885a);
    }

    @Override // java.util.Collection
    public final java.lang.Object[] toArray() {
        return c_renamed.a_renamed.h_renamed.a_renamed(this.f1885a, this.f1886b);
    }
}
