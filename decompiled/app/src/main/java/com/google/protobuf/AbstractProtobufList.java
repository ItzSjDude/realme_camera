package com.google.protobuf;

/* loaded from: classes.dex */
abstract class AbstractProtobufList<E_renamed> extends java.util.AbstractList<E_renamed> implements com.google.protobuf.Internal.ProtobufList<E_renamed> {
    protected static final int DEFAULT_CAPACITY = 10;
    private boolean isMutable = true;

    AbstractProtobufList() {
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof java.util.List)) {
            return false;
        }
        if (!(obj instanceof java.util.RandomAccess)) {
            return super.equals(obj);
        }
        java.util.List list = (java.util.List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            if (!get(i_renamed).equals(list.get(i_renamed))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            iHashCode = (iHashCode * 31) + get(i_renamed).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E_renamed e_renamed) {
        ensureIsMutable();
        return super.add(e_renamed);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i_renamed, E_renamed e_renamed) {
        ensureIsMutable();
        super.add(i_renamed, e_renamed);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(java.util.Collection<? extends E_renamed> collection) {
        ensureIsMutable();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i_renamed, java.util.Collection<? extends E_renamed> collection) {
        ensureIsMutable();
        return super.addAll(i_renamed, collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ensureIsMutable();
        super.clear();
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    public boolean isModifiable() {
        return this.isMutable;
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    public final void makeImmutable() {
        this.isMutable = false;
    }

    @Override // java.util.AbstractList, java.util.List
    public E_renamed remove(int i_renamed) {
        ensureIsMutable();
        return (E_renamed) super.remove(i_renamed);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(java.lang.Object obj) {
        ensureIsMutable();
        return super.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(java.util.Collection<?> collection) {
        ensureIsMutable();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(java.util.Collection<?> collection) {
        ensureIsMutable();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public E_renamed set(int i_renamed, E_renamed e_renamed) {
        ensureIsMutable();
        return (E_renamed) super.set(i_renamed, e_renamed);
    }

    protected void ensureIsMutable() {
        if (!this.isMutable) {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}
