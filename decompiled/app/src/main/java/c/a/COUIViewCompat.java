package c_renamed.a_renamed;

/* compiled from: Collections.kt */
/* loaded from: classes.dex */
public final class t_renamed implements java.io.Serializable, java.util.List, java.util.RandomAccess {
    public static final c_renamed.a_renamed.t_renamed INSTANCE = new c_renamed.a_renamed.t_renamed();
    private static final long serialVersionUID = -7390468764508069838L;

    @Override // java.util.List
    public /* synthetic */ void add(int i_renamed, java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    public void add(int i_renamed, java.lang.Void r2) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* synthetic */ boolean add(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    public boolean add(java.lang.Void r1) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i_renamed, java.util.Collection collection) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(java.util.Collection collection) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
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

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return 1;
    }

    public int indexOf(java.lang.Void r1) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(r1, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    public int lastIndexOf(java.lang.Void r1) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(r1, "element");
        return -1;
    }

    @Override // java.util.List
    public /* synthetic */ java.lang.Object remove(int i_renamed) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.List
    public java.lang.Void remove(int i_renamed) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(java.util.Collection collection) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(java.util.Collection collection) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.List
    public /* synthetic */ java.lang.Object set(int i_renamed, java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    public java.lang.Void set(int i_renamed, java.lang.Void r2) {
        throw new java.lang.UnsupportedOperationException("Operation is_renamed not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public java.lang.Object[] toArray() {
        return c_renamed.f_renamed.b_renamed.e_renamed.a_renamed(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T_renamed> T_renamed[] toArray(T_renamed[] tArr) {
        return (T_renamed[]) c_renamed.f_renamed.b_renamed.e_renamed.a_renamed(this, tArr);
    }

    public java.lang.String toString() {
        return "[]";
    }

    private t_renamed() {
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(java.lang.Object obj) {
        if (obj instanceof java.lang.Void) {
            return contains((java.lang.Void) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(java.lang.Object obj) {
        if (obj instanceof java.lang.Void) {
            return indexOf((java.lang.Void) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(java.lang.Object obj) {
        if (obj instanceof java.lang.Void) {
            return lastIndexOf((java.lang.Void) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return getSize();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(java.lang.Object obj) {
        return (obj instanceof java.util.List) && ((java.util.List) obj).isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(java.util.Collection collection) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.List
    public java.lang.Void get(int i_renamed) {
        throw new java.lang.IndexOutOfBoundsException("Empty list doesn't_renamed contain element at_renamed index " + i_renamed + '.');
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public java.util.Iterator iterator() {
        return c_renamed.a_renamed.s_renamed.f1887a;
    }

    @Override // java.util.List
    public java.util.ListIterator listIterator() {
        return c_renamed.a_renamed.s_renamed.f1887a;
    }

    @Override // java.util.List
    public java.util.ListIterator listIterator(int i_renamed) {
        if (i_renamed != 0) {
            throw new java.lang.IndexOutOfBoundsException("Index: " + i_renamed);
        }
        return c_renamed.a_renamed.s_renamed.f1887a;
    }

    @Override // java.util.List
    public java.util.List subList(int i_renamed, int i2) {
        if (i_renamed == 0 && i2 == 0) {
            return this;
        }
        throw new java.lang.IndexOutOfBoundsException("fromIndex: " + i_renamed + ", toIndex: " + i2);
    }

    private final java.lang.Object readResolve() {
        return INSTANCE;
    }
}
