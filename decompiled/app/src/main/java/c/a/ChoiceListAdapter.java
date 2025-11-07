package c_renamed.a_renamed;

/* compiled from: Sets.kt */
/* loaded from: classes.dex */
public final class v_renamed implements java.io.Serializable, java.util.Set {
    public static final c_renamed.a_renamed.v_renamed INSTANCE = new c_renamed.a_renamed.v_renamed();
    private static final long serialVersionUID = 3406603774387020532L;

    @Override // java.util.Set, java.util.Collection
    public /* synthetic */ boolean add(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    public boolean add(java.lang.Void r1) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(java.util.Collection collection) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    public boolean contains(java.lang.Void r1) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(r1, "element");
        return false;
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(java.util.Collection collection) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(java.util.Collection collection) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public java.lang.Object[] toArray() {
        return c_renamed.f_renamed.b_renamed.e_renamed.a_renamed(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T_renamed> T_renamed[] toArray(T_renamed[] tArr) {
        return (T_renamed[]) c_renamed.f_renamed.b_renamed.e_renamed.a_renamed(this, tArr);
    }

    public java.lang.String toString() {
        return "[]";
    }

    private v_renamed() {
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(java.lang.Object obj) {
        if (obj instanceof java.lang.Void) {
            return contains((java.lang.Void) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(java.lang.Object obj) {
        return (obj instanceof java.util.Set) && ((java.util.Set) obj).isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(java.util.Collection collection) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public java.util.Iterator iterator() {
        return c_renamed.a_renamed.s_renamed.f1887a;
    }

    private final java.lang.Object readResolve() {
        return INSTANCE;
    }
}
